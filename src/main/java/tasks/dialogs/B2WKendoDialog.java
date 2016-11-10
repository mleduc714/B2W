package tasks.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public abstract class B2WKendoDialog {
	
	Logger log = Logger.getLogger(B2WKendoDialog.class);
	
	public boolean selectItemFromDropDown(String sItem){
		boolean bReturn = false;
		// when we click we need to find the visble list
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
				WebElement item = WebElementUtils.getElementWithMatchingStartsWithText(items, sItem);
				if (item != null) {
					bReturn = WebElementUtils.clickElement(item);
					bReturn &= WebElementUtils.waitForElementInvisible(item);
				}else{
					log.debug("Item with could not be found matching "+sItem);
				}
			}
		}
		return bReturn;
	}
	public WebElement getDisplayedWindow() {
		WebElement window = null;
		List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindow());
		Iterator<WebElement> iter = windows.iterator();
		while (iter.hasNext()){
			WebElement temp = iter.next();
			if (temp.isDisplayed()){
				window = temp;
			}
		}
		return window;
	}
	

	public Iterator<WebElement> getChildElementsFromGrid(WebElement grid){
		Iterator<WebElement> itr = null;
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		if (items.size()> 0){
			itr = items.iterator();
		}
		return itr;
	}
	public boolean waitForPageNotBusy(int iSecs) {
		boolean bReturn = false;
		int iTrys = 0;
		while (!bReturn && iTrys < iSecs) {
			try {
				WebElement el = BrowserUtils.getDriver().findElement(B2WEquipment.getKendoPageLoading());
				TaskUtils.sleep(100);
				if (!el.isDisplayed()){
					bReturn = true;
					log.debug("Element is not displayed");
					break;
				}
				iTrys++;

			} catch (NoSuchElementException e) {
				log.warn("Page not Busy no such element exception");
				bReturn = true;
			}catch (StaleElementReferenceException e){
				log.warn("Caught a stale element exception");
				TaskUtils.sleep(250);
				bReturn =true;
			}
		}
		double iSec = (iTrys * 100);
		double iSeconds = iSec / 1000;
		if (!bReturn){
			log.info("Page waited as long as: "+iSeconds + " Seconds");
		}else{
			log.info("Page is done loading. waited: "+iSeconds + " Seconds");
		}
		return bReturn;
		
	}
	public WebElement getItemFromAddItemDialog(String sText) {
		WebElement item = null;
		WebElement dialog = getVisibleDialog();
		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName("p"));
		Iterator<WebElement> iterB = items.iterator();
		while (iterB.hasNext()) {
			WebElement temp = iterB.next();
			if (temp.getText().startsWith(sText)) {
				item = temp;
			}
		}
		return item;
	}
	
	public WebElement getVisibleDialog() {

		WebElement dialog = null;
		List<WebElement> dialogs = WebElementUtils.findElements(B2WMaintain.getB2WMaintainAddItemDialogContent());
		Iterator<WebElement> iterA = dialogs.iterator();
		while (iterA.hasNext()) {
			WebElement temp = iterA.next();
			if (temp.isDisplayed()) {
				dialog = temp;
				break;
			}
		}
		return dialog;
	}
	
	public List<WebElement> getFormElements(By by) {
		List<WebElement> elements = new ArrayList<WebElement>();
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(by);
		List<WebElement> list = WebElementUtils.getChildElements(parent, By.tagName("p"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			String sClass = el.getAttribute("class");
			if (sClass.startsWith("form")) {
				elements.add(el);
			}
		}

		return elements;
	}
}