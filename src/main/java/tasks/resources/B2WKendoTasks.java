package tasks.resources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
				if (item != null) {
					WebElementUtils.waitForElementIsDisplayed(item, WebElementUtils.SHORT_TIME_OUT);
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
				WebElementUtils.waitForElementIsDisplayed(item, WebElementUtils.SHORT_TIME_OUT);
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
				log.debug("Caught a stale element exception");
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
		waitForAjax();
		return bReturn;
		
	}
	public boolean clickAndSelectValueFromKendoFDD(WebElement dropDownElement, String sItem) {
		boolean bReturn = false;
		WebElementUtils.moveVirtualMouseOverElement(dropDownElement);
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
	

	public WebElement getFormElement(String sLabel, By by){
		WebElement child = null;
		WebElement content = WebElementUtils.getVisibleElementFromListofElements(WebElementUtils.findElements(B2WMaintain.getB2WMaintainBoxContent()));
		if (content != null){
			WebElement label = WebElementUtils.getChildElementContainsText(content, By.tagName("label"), sLabel);
			if (label != null){
				child = WebElementUtils.getChildElement(WebElementUtils.getParentElement(label), by);
			}
		}
		return child;
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
			sText = sText.trim();
			if (sText.equals(sItem)) {
				bReturn = WebElementUtils.clickElement(item);
				bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
				break;
			}
		}
		return bReturn;
	}
	
	protected int getNumberOfItemsFromView(){
		int iItems = 0;
		WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		if (items.size() > 0){
			iItems = items.size();
		}
		return iItems;
	}
	
	protected boolean selectItemFromView(int i){
		boolean bReturn = false;

		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		if (i < items.size()){
			WebElement item = items.get(i);
			Coordinates coordinate = ((Locatable) item).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();
			bReturn = WebElementUtils.clickElement(item);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	
		
	}
	
	public boolean clickConfirmYes() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoConfirmYesButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
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
			try {
				WebElement nvp = iter.next();
				WebElement label = nvp.findElement(By.cssSelector(".label"));
				if (label.getText().equals(sItem)) {
					sItem = nvp.findElement(By.cssSelector(".data")).getText();
					break;
				}
			} catch (NoSuchElementException e) {
			}
		}
		return sItem;

	}
	

	protected String getPriorityOfItem(By by) {
		String sText = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(by);
		WebElement dataPriority = WebElementUtils.getChildElement(el, B2WMaintain.getB2WPriorityofItem());
		if (dataPriority != null){
			sText = WebElementUtils.getChildElements(dataPriority, By.tagName("span")).get(1).getText();
		}
		return sText;
	}
	
	protected String getSelectedItemFromView(int iColumn) {
		String sText = "";
		WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
		WebElement selected = WebElementUtils.getChildElement(grid, B2WMaintain.getKendoSelected());
		List<WebElement> gridcontent = WebElementUtils.getChildElements(selected, By.tagName("td"));
		sText = gridcontent.get(iColumn).getText();
		return sText;
	}
	
	private void waitForAjax() {
		while (true) {
			Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) BrowserUtils.getDriver()).executeScript("return jQuery.active == 0");
			if (ajaxIsComplete) {
				break;
			}
			TaskUtils.sleep(500);
		}
	}
	protected String getDueDate(){
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainWorkOrderShortDate());
		if (el != null){
			sText = el.getText();
		}
		return sText;
		
	}
	protected String getStatus(){
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainWorkOrderStatus());
		if (el != null){
			sText = el.getText();
		}
		return sText;
		
	}
	
	protected boolean setNotes(String sText){
		boolean bReturn = false;
		List<WebElement> iframes = BrowserUtils.getDriver().findElements(By.tagName("iframe"));
		for (WebElement iframe : iframes) {
			if (iframe.isDisplayed()==true){
				// we want this one.
				WebDriver driver = BrowserUtils.getDriver().switchTo().frame(iframe);
				WebElement body = driver.findElement(By.tagName("body"));
				WebElementUtils.clickElement(body);
				bReturn = WebElementUtils.sendKeys(body, sText);
				BrowserUtils.getDriver().switchTo().defaultContent();
				break;
			}
		}
		return bReturn;
	}
	

	public String selectRandomItemFromDropDown() {
		String sText = "";
		// when we click we need to find the visible list
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		log.debug("There are " + list.size() + " to find the correct drop down");
		while (iter.hasNext()) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
				log.debug("There are "+items.size() + " items in the drop down");
				Random rand = new Random();
				int randnumber = rand.nextInt(items.size() - 1);
				WebElement item = items.get(randnumber);
				sText = item.getText();
				WebElementUtils.waitForElementIsDisplayed(item, WebElementUtils.SHORT_TIME_OUT);
				if (item != null) {
					if (WebElementUtils.clickElement(item)) {
						WebElementUtils.waitForElementHasAttributeWithValue(els, "aria-hidden", "true", true,
								WebElementUtils.MEDIUM_TIME_OUT);
						waitForPageNotBusy(WebElementUtils.SHORT_TIME_OUT);
						
						log.debug("Selected an item");
						break;
					}else{
						log.debug("The item was not clickable in dropdown");
					}
				} 
			}
		}
		return sText;
	}
	protected boolean setNumericField(WebElement el, String sLabel, String sText){
		boolean bReturn = false;
		WebElement dd = WebElementUtils.getChildElement(el, B2WMaintain.getKendoNumericTextBox());
		if (dd != null){
			List<WebElement> inputs = WebElementUtils.getChildElements(dd, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}
		return bReturn;

	}

	public ArrayList<String> getText(WebElement parent, int iRow, int iColumn) {
		ArrayList<String> al = new ArrayList<String>();
		WebElement rowgroup = WebElementUtils.getChildElement(parent, By.tagName("tbody"));
		if (rowgroup != null) {
			try {
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				List<WebElement> ls = rows.get(iRow).findElements(By.tagName("td"));
				al.add(ls.get(iColumn).getText());
			} catch (Exception e) {
				log.debug("Caught an exception attempt to get text with row/column");
			}
		}
		return al;
	}

}
