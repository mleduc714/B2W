package tasks.resources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public abstract class B2WKendoTasks {

	Logger log = Logger.getLogger(B2WKendoTasks.class);
	
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
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
				if (item != null) {
					bReturn = WebElementUtils.clickElement(item);
				}else{
					log.debug("Item with could not be found matching "+sItem);
				}
			}
		}
		return bReturn;
	
	}
	public boolean waitForPageNotBusy() {
		boolean bReturn = false;
		int iTrys = 0;
		while (!bReturn && iTrys < 100) {
			try {
				BrowserUtils.getDriver().findElement(B2WEquipment.getKendoPageLoading());
				TaskUtils.sleep(100);
				iTrys++;

			} catch (NoSuchElementException e) {
				
				bReturn = true;
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
	public boolean clickAndSelectValueFromKendoFDD(WebElement dropDownElement, String sItem) {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(dropDownElement)) {
			TaskUtils.sleep(100);
			bReturn = selectItemFromFDD(sItem);
		}
		return bReturn;
	}
	public boolean sendTextAndSelectValueFromKendoFDD(WebElement dropDownElement, String sItem) {
		boolean bReturn = false;
		if (WebElementUtils.sendKeys(dropDownElement, sItem)) {
			TaskUtils.sleep(100);
			bReturn = selectItemFromFDD(sItem);
		}
		return bReturn;
	}
	public boolean selectItemFromFDD(String sItem) {
		boolean bReturn = false;
		// when we click we need to find the visible list
		List<WebElement> list = WebElementUtils.findElements(KendoUI.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext() && !bReturn) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(KendoUI.getKendoDropDownItem());
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
				if (item != null) {
					bReturn = WebElementUtils.clickElement(item);
				}else{
					log.debug("Item with could not be found matching " + sItem);
				}
			}
		}
		if (!bReturn) log.debug("Element with value" + sItem + " could not be found.");
		return bReturn;
	}

	// Test methods
	public List<WebElement> getListSelectedItemsFromAllFDD() {
		//ToDo Remove it if could not fix it
		return WebElementUtils.findElements(B2WScheduleAssignments.getAllSelectedItemsFromAllFDD());
	}
	public List<WebElement> getDifferenceBetweenLists(List<WebElement> lOriginal, List<WebElement> lNew) {
		//ToDo Remove it if could not fix it
		for (Object o : lOriginal) {
			if (lNew.contains(o)) {
				lNew.remove(o);
			}
		}
		return lNew;
	}

	public boolean getHeaderandExpandOrCollapse(String sText, boolean bExpand){
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getKendoHeadersFromView());
		WebElement el = WebElementUtils.getElementWithMatchingText(ls, sText, false);
		// get parent and is it expanded or collapsed
		WebElement parent = getHeader(sText);
		boolean isExpanded =  new Boolean(parent.getAttribute("aria-expanded")).booleanValue();
		if (isExpanded & !bExpand){
			log.debug(sText + " is expanded, click to collapse");
			WebElementUtils.clickElement(el);
		}
		if (!isExpanded & bExpand){
			log.debug(sText + " is collapsed, clicking expanded");
			WebElementUtils.clickElement(el);
		}
		parent = WebElementUtils.getParentElement(el);
		isExpanded =  new Boolean(parent.getAttribute("aria-expanded")).booleanValue();
		return isExpanded == bExpand;
	}
	
	public void findItem(WebElement grid, int i) {
		WebElement item = null;
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()){
			item = iter.next();
			List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
			String sText = gridcontent.get(i).getText();
			// when it's a empty string we need to get into view
			if (sText.equals("")){
				Coordinates coordinate = ((Locatable)item).getCoordinates(); 
				coordinate.onPage(); 
				coordinate.inViewPort();
			}
		}
	}
	
	public WebElement getHeader(String sText){
		WebElement header = null;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getKendoHeadersFromView());
		WebElement el = WebElementUtils.getElementWithMatchingText(ls, sText, false);
		if (el != null){
			header = WebElementUtils.getParentElement(el);
		}
		return header;
		
	}

	public Iterator<WebElement> getChildElementsFromGrid(WebElement grid){
		Iterator<WebElement> itr = null;
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		if (items.size()> 0){
			itr = items.iterator();
		}
		return itr;
	}
	public ArrayList<String> getItemsByColumnFromGrid(String sHeader, int iColumn) {
		ArrayList<String> itemstext = new ArrayList<String>();
		WebElement header = getHeader(sHeader);
		WebElement grid = WebElementUtils.getChildElement(header, B2WMaintain.getKendoGridContent());
		Iterator<WebElement> itr = getChildElementsFromGrid(grid);
		if (itr!=null){
			while (itr.hasNext()){
				WebElement item = itr.next();
				List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
				String sText = gridcontent.get(iColumn).getText();
				if (sText.equals("")){
					Coordinates coordinate = ((Locatable)item).getCoordinates(); 
					coordinate.onPage(); 
					coordinate.inViewPort();
				}
				sText = gridcontent.get(iColumn).getText();
				itemstext.add(sText);
			}
		}
		return itemstext;
	}
}
