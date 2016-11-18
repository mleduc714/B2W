package tasks.resources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
		// when we click we need to find the visible list
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		log.debug("Looking for item "+sItem);
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

	public boolean selectItemFromDropDown(int i){
		boolean bReturn = false;
		// when we click we need to find the visble list
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		log.debug("There are "+list.size() + " to find the correct drop down");
		while (iter.hasNext()) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
				WebElement item = items.get(i);
				if (item != null) {
					bReturn = WebElementUtils.clickElement(item);
				}else{
					log.debug("Could not select item #"+i);
				}
			}
		}
		return bReturn;
	}
	
	
	public boolean waitForPageNotBusy(int iSecs) {
		boolean bReturn = false;
		// seconds need to muliply
		iSecs = iSecs * 20;
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
		dropDownElement.clear();
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
			// temp fix to sleep 1/2 sec 
			TaskUtils.sleep(500);
		}
		if (!isExpanded & bExpand){
			log.debug(sText + " is collapsed, clicking expanded");
			WebElementUtils.clickElement(el);
			// temp fix to sleep 1/2 sec 
			TaskUtils.sleep(500);
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
	
	protected boolean selectItemFromView(String sItem, int iColumn) {
		boolean bReturn = false;

		WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		Iterator<WebElement> iter = items.iterator();
		log.debug("Looking for item "+sItem);
		while (iter.hasNext()) {
			WebElement item = iter.next();
			List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
			String sText = gridcontent.get(iColumn).getText();
			// when it's a empty string we need to get into view
			if (sText.equals("")) {
				Coordinates coordinate = ((Locatable) item).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
			}
			sText = gridcontent.get(iColumn).getText();
			if (sText.startsWith(sItem)) {
				bReturn = WebElementUtils.clickElement(item);
				bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
				break;
			}
		}
		return bReturn;
	}
	
	protected boolean selectItemFromView(int i){
		boolean bReturn = false;

		WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		if (i < items.size()){
			WebElement item = items.get(i);
			Coordinates coordinate = ((Locatable) item).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	
		
	}
	
	public boolean clickConfirmYes() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoConfirmYesButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	
	public boolean clickFinish() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoLargeFinishButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	public boolean clickConfirmNo() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoConfirmNoButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	
	protected WebElement getButton(int iButton) {
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getKendoButtonAdd());
		WebElement button = list.get(iButton);
		if (button != null && button.isDisplayed()){
			return button;
		}else{
			return null;
		}
	}
	
	protected String getValueOfItem(String sItem, By by) {

		WebElement el = WebElementUtils.waitAndFindDisplayedElement(by);
		List<WebElement> nvps = WebElementUtils.getChildElements(el, B2WEquipment.getKendoNameValuePair());
		Iterator<WebElement> iter = nvps.iterator();
		while (iter.hasNext()) {
			WebElement nvp = iter.next();
			WebElement label = nvp.findElement(By.cssSelector(".label"));
			if (label.getText().equals(sItem)) {
				sItem = nvp.findElement(By.cssSelector(".data")).getText();
			}
		}
		return sItem;

	}
	
	public String getSelectedItemFromView(int iColumn) {
		String sText = "";
		WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
		WebElement selected = WebElementUtils.getChildElement(grid, B2WMaintain.getKendoSelected());
		List<WebElement> gridcontent = WebElementUtils.getChildElements(selected, By.tagName("td"));
		sText = gridcontent.get(iColumn).getText();
		return sText;
	}
	
}
