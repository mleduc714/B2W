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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import tasks.B2WKendo;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public abstract class B2WKendoTasks extends B2WKendo {
	
	public String EQUIPMENTSPECS = "Equipment Specs";
	public String COMPSPECS = "Component Specs";
	public String FILEATTACH = "File Attachments";
	public String FINANCIALS = "Financials";
	public String METERS = "Meters";
	public String PARTS = "Parts";
	public String WARRANTIES = "Warranties";
	public String PROGRAMS = "Programs";
	public String TAGS = "Tags";
	public String CREWS = "Crews";
	public String EVENTS = "Events";
	public String HISTORY = "History";
	public String LOCATION = "Location";
	public String ATTACHMENTS = "Attachments";
	public String WARRANTY = "Warranty";
	public String VENDORS = "Vendors";
	public String INVENTORYHISTORY = "Inventory History";
	public String PURCHASEORDERHISTORY = "Purchase Order History";
	public String HOURS = "Hours";
	public String EXCLUSIONS = "Exclusions";
	public String DETAILS = "Details";
	public String INTERVALS = "Intervals";
	public String COMMENTS = "Comments";
	
	public enum COLUMN {
		ID, DESCRIPTION, PRIORITY, EQUIPMENT, VENDOR, CREATED, EMPLOYEE, DATE, STATUS
	};
	
	Logger log = Logger.getLogger(B2WKendoTasks.class);
	private int getRandomNumber(int iSize) {
		Random rand = new Random();
		int randnumber = rand.nextInt(iSize);
		return randnumber;
	}

	protected boolean clickKendoButton(String sButton){
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getKendoButton());
		for (WebElement el: list){
			if (el.getText().equals(sButton)){
				bReturn = WebElementUtils.clickElement(el);
			}
		}
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
			if (!selectItemFromFDD(sItem)) {
				TaskUtils.sleep(500);
				bReturn = selectItemFromFDD(sItem);
			} else {
				bReturn = true;
			}
		}
		return bReturn;
	}
	
	public String sendTextAndSelectAnyValueFromKendoFDD(WebElement dropDownElement){
		String sRandom = "";
		dropDownElement.clear();
		WebElementUtils.clickElement(dropDownElement);
		if (WebElementUtils.sendKeys(dropDownElement, "a")) {
			sRandom =  selectRandomItemFromDropDown();
		}
		return sRandom;
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
		if (!bReturn) log.debug("Element with value '" + sItem + "' could not be found.");
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

	private boolean getHeaderandExpandOrCollapse(String sText, boolean bExpand){
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
	
	protected boolean selectItemFromView(String sItem, COLUMN col) {
		boolean bReturn = false;
		int iColumn = 0;
		try {
			iColumn = getColumn(col);
			WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
			List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
			Iterator<WebElement> iter = items.iterator();
			log.debug("Looking for item " + sItem);
			while (iter.hasNext()) {
				WebElement item = iter.next();
				List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
				if (iColumn < gridcontent.size()) {
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
			}
		} catch (StaleElementReferenceException e) {
			return selectItemFromView(sItem, col);
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
	

	protected WebElement getButton(int iButton) {
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getKendoButtonAdd());
		WebElement button = list.get(iButton);
		if (button != null && button.isDisplayed()){
			return button;
		}else{
			return null;
		}
	}
	
	protected WebElement getButton(String sDesc){
		WebElement el = null;
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getKendoButtonAdd());
		for (WebElement e: list){
			String sButtonName = WebElementUtils.getParentElement(e).getText();
			if (sButtonName.contains(sDesc)){
				log.debug("Found Button: "+sDesc);
				el = e;
				break;
			}
		}
		return el;
		
	}
	
	protected WebElement getEditButton(String sDesc){
		WebElement el = null;
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getKendoEditButton());
		for (WebElement e: list){
			String sButtonName = WebElementUtils.getParentElement(e).getText();
			if (sButtonName.contains(sDesc)){
				el = e;
				break;
			}
		}
		return el;
		
	}
	
	protected String getValueOfItem(String sItem, By by) {
		
		String sValueOfItem = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(by);
		List<WebElement> nvps = WebElementUtils.getChildElements(el, B2WEquipment.getKendoNameValuePair());
		Iterator<WebElement> iter = nvps.iterator();
		while (iter.hasNext()) {
			try {
				WebElement nvp = iter.next();
				WebElement label = nvp.findElement(By.cssSelector(".label"));
				if (label.getText().equals(sItem)) {
					// getting notes is going to be different
					sValueOfItem = nvp.findElement(By.cssSelector(".data")).getText();
					break;
				}
			
			} catch (NoSuchElementException e) {
			}
		}
		return sValueOfItem;

	}
	
	protected String getNotes(By by) {
		
		String sValueOfItem = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(by);
		List<WebElement> nvps = WebElementUtils.getChildElements(el, B2WEquipment.getKendoNameValuePair());
		Iterator<WebElement> iter = nvps.iterator();
		while (iter.hasNext()) {
			try {
				WebElement nvp = iter.next();
				WebElement label = nvp.findElement(By.cssSelector(".label"));
				if (label.getText().equals("Notes")) {
					// getting notes is going to be different
					sValueOfItem = nvp.findElement(By.cssSelector(".data-notes")).getText();
				}
			
			} catch (NoSuchElementException e) {
			}
		}
		return sValueOfItem;

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
	
	protected ArrayList<String> getItemsFromView(int iColumn) {
		ArrayList<String> al = new ArrayList<String>();
		WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid,  By.tagName("tr"));

		for (WebElement el: items){
			
			List<WebElement> columns = WebElementUtils.getChildElements(el, By.tagName("td"));
			if (columns.get(iColumn).getText().equals("")){
				((JavascriptExecutor) BrowserUtils.getDriver()).executeScript(
		                "arguments[0].scrollIntoView();", el);
			}
				al.add(columns.get(iColumn).getText());
			}
		

		return al;
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
	
	public String selectRandomItemFromDropDown() {
		WebElement item = null;
		String sText = "";
		List<WebElement> items = new ArrayList<WebElement>();
		int iTimeOut = 0;
		while (items.size() == 0 && iTimeOut < 50) {
			items = getKendoDropDownItems();
			iTimeOut++;
			TaskUtils.sleep(100);
		}
		log.debug("There are " + items.size() + " items in the drop down");
		if (items.size() > 0) {
			while (sText.length() < 1) {
				item = items.get(getRandomNumber(items.size()));
				sText = item.getText();
			}
			if (item != null) {
				if (WebElementUtils.clickElement(item)) {
					WebElementUtils.waitForElementInvisible(item);
					waitForPageNotBusy(WebElementUtils.SHORT_TIME_OUT);
					log.debug("Selected an item");
				} else {
					log.debug("The item was not clickable in dropdown");
				}
			}
		}
		return sText;
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
	
	public boolean setNumericField(String sLabel, String sText) {

		boolean bReturn = false;
		WebElement el = getFormElement(sLabel, B2WMaintain.getKendoNumericTextBox());
		if (el != null) {
			List<WebElement> inputs = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			inputs.get(1).clear();
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}

		return bReturn;
	}
	protected boolean selectItem(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WWorkOrderItems());
		if (el != null){
			List<WebElement> list = WebElementUtils.getElementsWithMatchingAttribute(WebElementUtils.getChildElements(el, By.tagName("td")), "role", "gridcell");
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				WebElement e = iter.next();
				String sText = e.getText();
				if (sText.contains(s)){
					bReturn = WebElementUtils.clickElement(e);
				}
			}
		}
		return bReturn;
	}
	
	protected ArrayList<String> getItems() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WWorkOrderItems());
		Coordinates coordinate = ((Locatable)el).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		if (el != null){
			List<WebElement> list = WebElementUtils.getElementsWithMatchingAttribute(WebElementUtils.getChildElements(el, By.tagName("td")), "role", "gridcell");
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				WebElement e = iter.next();
				String sText = e.getText();
				al.add(sText);
			}
		}
		return al;
	}
	
	protected boolean checkBox(WebElement el, boolean bCheck){
		
		boolean isChecked = el.isSelected();
		// if item is checked and need to uncheck
		if (isChecked && !bCheck){
			log.debug("Uncheck the checkbox");
			WebElementUtils.clickElement(el);
		}
		// if item is unchecked and need to check
		if (!isChecked && bCheck){
			log.debug("Check the checkbox");
			WebElementUtils.clickElement(el);
		}
		return bCheck == el.isSelected();
	}
	protected boolean setNewCommentAndSave(String sText){
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(By.cssSelector("textarea.comments"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			if (el.isDisplayed()){
				el.clear();
				bReturn = WebElementUtils.sendKeys(el, sText);
				WebElement parent = WebElementUtils.getParentElement(el);
				TaskUtils.sleep(1000);
				WebElement save = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoLargeSaveButton());
				bReturn = WebElementUtils.clickElement(save);
				bReturn &= WebElementUtils.waitForElementInvisible(el);
				break;
			}
		}
		return bReturn;
	}
	protected List<WebElement> getCommentsRows() {
		WebElement historyView = WebElementUtils.findElement(By.cssSelector(".comments-view"));
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	protected String getComments(int iRow, int iColumn){
		String sText = "";
		List<WebElement> rows = getCommentsRows();
		if (rows.size()>0){
			sText = WebElementUtils.getChildElements(rows.get(iRow),By.tagName("td")).get(iColumn).getText();
		}
		return sText;
	}
	
	protected WebElement getRowByCommentDescription(String sDesc){
		WebElement row = null;
		List<WebElement> rows = getCommentsRows();
		if (rows.size()>0){
			for (WebElement el: rows){
				String sText = WebElementUtils.getChildElements(el,By.tagName("td")).get(0).getText();
				if (sText.equals(sDesc)){
					row = el;
				}
			}
			
		}
		return row;
	}
	
	public boolean expandEquipmentSpecs() {
		return getHeaderandExpandOrCollapse(EQUIPMENTSPECS, true);
	}
	public boolean collapseEquipmentSpecs(){
		return getHeaderandExpandOrCollapse(EQUIPMENTSPECS, false);
	}
	public boolean expandComponentSpecs() {
		return getHeaderandExpandOrCollapse(COMPSPECS, true);
	}
	public boolean collapseComponentSpecs(){
		return getHeaderandExpandOrCollapse(COMPSPECS, false);
	}
	public boolean expandFileAttachments() {
		return getHeaderandExpandOrCollapse(FILEATTACH, true);
	}
	public boolean collapseFileAttachments(){
		return getHeaderandExpandOrCollapse(FILEATTACH, false);
	}
	public boolean expandFinancials() {
		return getHeaderandExpandOrCollapse(FINANCIALS, true);
	}
	
	public boolean collapseFinancials(){
		return getHeaderandExpandOrCollapse(FINANCIALS, false);
	}
	
	public boolean expandMeters() {
		return getHeaderandExpandOrCollapse(METERS, true);
	}
	public boolean collapseMeters(){
		return getHeaderandExpandOrCollapse(METERS, false);
	}
	public boolean expandParts() {
		return getHeaderandExpandOrCollapse(PARTS, true);
	}
	public boolean collapseParts(){
		return getHeaderandExpandOrCollapse(PARTS, false);
	}
	public boolean expandWarrenties() {
		return getHeaderandExpandOrCollapse(WARRANTIES, true);
	}
	public boolean collapseWarrenties(){
		return getHeaderandExpandOrCollapse(WARRANTIES, false);
	}
	public boolean expandPrograms() {
		return getHeaderandExpandOrCollapse(PROGRAMS, true);
	}
	public boolean collapsePrograms(){
		return getHeaderandExpandOrCollapse(PROGRAMS, false);
	}
	public boolean expandTags() {
		return getHeaderandExpandOrCollapse(TAGS, true);
	}
	public boolean collapseTags(){
		return getHeaderandExpandOrCollapse(TAGS, false);
	}
	public boolean expandCrews() {
		return getHeaderandExpandOrCollapse(CREWS, true);
	}
	public boolean collapseCrews(){
		return getHeaderandExpandOrCollapse(CREWS, false);
	}
	public boolean expandEvents() {
		return getHeaderandExpandOrCollapse(EVENTS, true);
	}
	public boolean collapseEvents(){
		return getHeaderandExpandOrCollapse(EVENTS, false);
	}
	public boolean expandHistory() {
		return getHeaderandExpandOrCollapse(HISTORY, true);
	}
	public boolean collapseHistory(){
		return getHeaderandExpandOrCollapse(HISTORY, false);
	}
	public boolean expandLocation() {
		return getHeaderandExpandOrCollapse(LOCATION, true);
	}
	public boolean collapseLocation(){
		return getHeaderandExpandOrCollapse(LOCATION, false);
	}
	public boolean expandAttachments() {
		return getHeaderandExpandOrCollapse(ATTACHMENTS, true);
	}
	public boolean collapseAttachments() {
		return getHeaderandExpandOrCollapse(ATTACHMENTS, false);
	}
	public boolean expandVendors() {
		return getHeaderandExpandOrCollapse(VENDORS, true);
	}
	public boolean expandInventoryHistory() {
		return getHeaderandExpandOrCollapse(INVENTORYHISTORY, true);
	}
	public boolean expandPurchaseOrderHistory() {
		return getHeaderandExpandOrCollapse(PURCHASEORDERHISTORY, true);
	}
	public boolean expandWarranty() {
		return getHeaderandExpandOrCollapse(WARRANTY, true);
	}
	public boolean collapseVendors() {
		return getHeaderandExpandOrCollapse(VENDORS, false);
	}
	public boolean collapseInventoryHistory() {
		return getHeaderandExpandOrCollapse(INVENTORYHISTORY, false);
	}
	public boolean collapsePurchaseOrderHistory() {
		return getHeaderandExpandOrCollapse(PURCHASEORDERHISTORY, false);
	}
	public boolean collapseWarranty() {
		return getHeaderandExpandOrCollapse(WARRANTY, false);
	}
	public boolean expandHours() {
		return getHeaderandExpandOrCollapse(HOURS, true);
	}
	public boolean collapseHours() {
		return getHeaderandExpandOrCollapse(HOURS, false);
	}
	public boolean expandExclusions(){
		return getHeaderandExpandOrCollapse(EXCLUSIONS, true);
	}
	public boolean collapseExclusions(){
		return getHeaderandExpandOrCollapse(EXCLUSIONS, false);
	}
	public boolean collapseDetails() {
		return getHeaderandExpandOrCollapse(DETAILS, false);
	}
	public boolean expandDetails() {
		return getHeaderandExpandOrCollapse(DETAILS, true);
	}
	public boolean expandIntervals() {
		return getHeaderandExpandOrCollapse(INTERVALS, true);
	}
	public boolean collapseIntervals() {
		return getHeaderandExpandOrCollapse(INTERVALS, false);
	}
	public boolean expandComments() {
		return getHeaderandExpandOrCollapse(COMMENTS, true);
	}
	public boolean collapseComments() {
		return getHeaderandExpandOrCollapse(COMMENTS, false);
	}
	public boolean clickNewCommentButton() {
		boolean bReturn = false;
		List<WebElement> comments = WebElementUtils.findElements(B2WMaintain.getB2WNewMaintanceRequestNewCommentButton());
		if (comments.size()>0){
			WebElement comment = WebElementUtils.getVisibleElementFromListofElements(comments);
			if (comment != null){
				bReturn = WebElementUtils.clickElement(comment);
			}
		}
		return bReturn;
	}
	
	public boolean searchText(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainSearchFilterList());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean clickBusinessRuleError() {
		boolean bReturn = false;
		String sErrorMessage = "Business Rule Error";
		WebElement el = getDisplayedWindow();
		if (el != null) {
			WebElement dialog = WebElementUtils
					.getVisibleElementFromListofElements(WebElementUtils.findElements(By.className("k-window-title")));
			if (dialog != null) {
				if (dialog.getText().equals(sErrorMessage)) {
					bReturn = true;
					clickConfirmYes();
				}
			}
		}
		return bReturn;
	}

	protected String getSelectedStatus() {
		String sStatus = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WWorkItemTable());
		if (el != null){
			WebElement item = WebElementUtils.getChildElement(el, B2WMaintain.getB2WWorkOrderStatus());
			sStatus = item.getText();
		}
		return sStatus;
	}
	protected boolean editComment(String sComment){
		boolean bReturn = false;
		WebElement el = getRowByCommentDescription(sComment);
		if (el != null){
			WebElement delete = WebElementUtils.getChildElement(el, B2WMaintain.getKendoEditButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}
	protected boolean deleteComment(String sComment){
		boolean bReturn = false;
		WebElement el = getRowByCommentDescription(sComment);
		if (el != null){
			WebElement delete = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDeleteButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}
	
	protected boolean closeFilter(String sFilter){
		boolean bReturn = false;
		
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getB2WKendoKButton());
		for (WebElement el: list){
			if (el.getText().contains(sFilter)){
				WebElement close = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendoRemoveItemBtn());
				bReturn = WebElementUtils.clickElement(close);
			}
		}
		
		return bReturn;
	}

	public int getColumn(COLUMN col){
		int iCol = 0;
		WebElement header = WebElementUtils.findElement(B2WMaintain.getKendoGridHeader());
		List<WebElement> columns = WebElementUtils.getChildElements(header, By.tagName("th"));
		String s = "";
		switch (col){
		case ID:
			s = "ID";
			break;
		case DESCRIPTION:
			s = "Description";
			break;
		case PRIORITY:
			s ="Priority";
			break;
		case EQUIPMENT:
			s = "Equipment";
			break;
		case EMPLOYEE:
			s = "Employee";
			break;
		case DATE:
			s = "Date";
			break;
		case STATUS:
			s = "STATUS";
			break;
		case VENDOR:
			s = "Vendor";
			break;
		case CREATED:
			s = "Created";
			break;
		}
		
		for (WebElement el: columns){
			String sHeader = el.getAttribute("data-title");
			if (sHeader != null && sHeader.equals(s)){
				
				break;
			}
			iCol++;
		}
		return iCol;	
	}
}
