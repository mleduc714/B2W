package tasks.maintain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;

public class B2WWorkOrdersTasks extends B2WKendoTasks {
	
	public int iEquipment = 0;
	public int iRequestDesc = 1;
	public int iAltID = 2;
	public int iDueDate = 3;
	public int iPriority = 4;
	public int iPlannedWorkLocation= 5;
	public int iLaborRateClass = 6;
	
	public enum PRIORITY {
		LOW,MEDIUM,HIGH
	};
	

	Logger log = Logger.getLogger(B2WWorkOrdersTasks.class);


	public boolean clickCreateNewWorkOrderButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoButtonAdd());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainNewWorkOrderView()) != null;
		}
		return bReturn;
	}
	


	public boolean selectEquipment(String sText) {
		boolean bReturn = false;
		TaskUtils.sleep(1000);
		WebElement equipment = getFormElement("Equipment", B2WMaintain.getKendoDropDown());
		if (equipment != null) {
			sendTextAndSelectValueFromKendoFDD(equipment, sText);
			bReturn = true;
		}
		return bReturn;

	}
	
	public String selectAnyEquipment() {
		String sText = "";
		WebElement equipment = getFormElement("Equipment", B2WMaintain.getKendoDropDown());
		if (equipment != null) {
			sText = sendTextAndSelectAnyValueFromKendoFDD(equipment);
		}
		return sText;

	}
	
	public boolean clickEditWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoEditButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean clickComplete() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoCompleteButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean completeWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoEditButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean setWorkOrderDescription(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Description",B2WMaintain.getKendoDescription());
		if (equipment != null) {

			equipment.clear();

			bReturn = WebElementUtils.sendKeys(equipment, sText);
		}
		return bReturn;
		
	}
	public boolean setAlternativeID(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Alternate ID",B2WMaintain.getKendoDescription());
		if (equipment != null){
			bReturn = WebElementUtils.sendKeys(equipment, sText);
		}
		return bReturn;
		
	}
	
	public boolean setDueDate(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Due Date",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			equipment.click();
			bReturn = WebElementUtils.sendKeys(equipment, sText);
		}
		return bReturn;
		
	}
	
	public boolean selectLaborRateClass(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Labor Rate Class",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public String selectAnyLaborRateClass() {
		String sText = "";
		WebElement equipment = getFormElement("Labor Rate Class",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public boolean selectPlannedWorkedLocation(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Planned Work Location",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public String selectAnyPlannedWorkLocation(){
		String sItem = "";
		WebElement equipment = getFormElement("Planned Work Location",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			if (WebElementUtils.clickElement(equipment)){
				sItem = selectRandomItemFromDropDown();
			}
		}
		return sItem;
	}
	
	public boolean selectPriorityFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Priority",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	
	public boolean clickSaveButton() {
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoLargeSaveButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(WebElementUtils.findElement(B2WMaintain.getKendoFakeSaveButton()), WebElementUtils.LONG_TIME_OUT, true);
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			//bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions(), WebElementUtils.MEDIUM_TIME_OUT) != null;
		}
		return bReturn;
	}
	
	public boolean saveEditWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(By.xpath("//*[@id='work_order_edit_view']/div[3]/div[1]"));
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(WebElementUtils.findElement(B2WMaintain.getKendoFakeSaveButton()));
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			//bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions(), WebElementUtils.MEDIUM_TIME_OUT) != null;
		}
		return bReturn;
	}

	
	public boolean clickApproveButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainWorkOrderDetailView());
		if (el != null){
			WebElement approve = WebElementUtils.getChildElement(el, B2WMaintain.getKendoApproveButton());
			bReturn = WebElementUtils.clickElement(approve);
		}
		return bReturn;
	}
	
	public boolean selectWorkOrderByID(String sText){
		return selectItemFromView(sText, 0);
	}

	public boolean selectWorkOrderByDescription(String sText) {
		return selectItemFromView(sText, 1);
	}
	
	public boolean selectWorkOrderByPriority(String sText){
		return selectItemFromView(sText, 2);
	}
	
	public String getSelectWorkOrderID() {
		return getSelectedItemFromView(0);
	}

	public boolean clickAddPlannedHours() {
		boolean bReturn = false;
		WebElement el = getButton("Add Planned Hours");
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean clickAddReportedHours() {
		boolean bReturn = false;
		WebElement el = getButton("Report Hours");
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickAddParts() {
		boolean bReturn = false;
		WebElement el = getButton("Add Parts");
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean selectAllWorkOrders() {
		return selectViewFromDropDown("All Work Orders");
	}
	public boolean selectOpenWorkOrders() {
		return selectViewFromDropDown("Open Work Orders");
	}
	public boolean selectCompletedWorkOrders(){
		return selectViewFromDropDown("Completed Work Orders");
	}
	public boolean selectWorkOrdersContainingProgramItems(){
		return selectViewFromDropDown("Work Orders Containing Program Items");
	}
	public boolean selectWarrantyWorkOrders(){
		return selectViewFromDropDown("Warranty Work Orders");
	}
	public boolean selectAllWorkOrdersGroupedByEquipment(){
		return selectViewFromDropDown("All Work Orders Grouped By Equipment");
	}
	public boolean selectOpenWorkOrdersGroupedByEquipment(){
		return selectViewFromDropDown("Open Work Orders Grouped By Equipment");
	}
	public boolean selectCompletedWorkOrdersGroupedByEquipment(){
		return selectViewFromDropDown("Completed Work Orders Grouped By Equipment");
	}
	public boolean selectWarrantyWorkOrdersGroupedByEquipment(){
		return selectViewFromDropDown("Warranty Work Orders Grouped By Equipment");
	}

	private boolean selectViewFromDropDown(String sText){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainWorkOrderListView());
		WebElement dd = WebElementUtils.getChildElement(listView, B2WMaintain.getKendoDropDown());
		if (dd != null){
			WebElementUtils.clickElement(dd);
			TaskUtils.sleep(500);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public String getSelectedWorkOrderDueDate() {
		return getDueDate();
	}
	public String getSelectedWorkOrderStatus() {
		String sStatus = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WWorkItemTable());
		if (el != null){
			WebElement item = WebElementUtils.getChildElement(el, B2WMaintain.getB2WWorkOrderStatus());
			sStatus = item.getText();
		}
		return sStatus;
	}
	public String getValueOfItem(String sItem){
		return getValueOfItem(sItem, B2WMaintain.getB2WMaintainWorkOrderDetailView());
	}
	public String getPriorityOfItem(){
		return getPriorityOfItem(B2WMaintain.getB2WMaintainWorkOrderDetailView());
	}
	public PRIORITY getPriorityOfItemEnum() {
		PRIORITY priority = null;
		String sPriority = getPriorityOfItem(B2WMaintain.getB2WMaintainWorkOrderDetailView());
		if (sPriority.equals("Low")){
			priority = PRIORITY.LOW;
		}
		if (sPriority.equals("Medium")){
			priority = PRIORITY.MEDIUM;
		}
		if (sPriority.equals("High")){
			priority = PRIORITY.HIGH;
		}
		return priority;
	}
	
	public boolean setWorkOrderNotes(String sText){
		return setNotes(sText);
	}

	public ArrayList<String> getItemsOnWorkOrder() {
		
		return getItems();
	}
	
	public ArrayList<String> getItemsOnEditWorkOrder() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> grids = WebElementUtils.findElements(By.cssSelector("div.grid.k-grid.k-widget"));
		WebElement el  = WebElementUtils.getElementWithMatchingAttribute(grids, "data-bind", "source: editViewModel.workOrderItems.listDataSource");
		Coordinates coordinate = ((Locatable)el).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		if (el != null){
			List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("td"));
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				WebElement e = iter.next();
				String sText = e.getText();
				al.add(sText);
			}
		}
		return al;
	}
	
	public boolean selectItemOnEditWorkOrder(String s) {
		boolean bReturn = false;
		List<WebElement> grids = WebElementUtils.findElements(By.cssSelector("div.grid.k-grid.k-widget"));
		WebElement el  = WebElementUtils.getElementWithMatchingAttribute(grids, "data-bind", "source: editViewModel.workOrderItems.listDataSource");
		Coordinates coordinate = ((Locatable)el).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		if (el != null){
			List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("td"));
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				WebElement e = iter.next();
				String sText = e.getText();
				if (sText.contains(s)){
					bReturn = WebElementUtils.clickElement(e);
					break;
				}
			}
		}
		return bReturn;
		
	}
	
	public boolean selectItemOnWorkOrder(String s) {
		return selectItem(s);
	}
	
	protected boolean clickOnRequestLink(){
		WebElement el = getHeader("Details");
		boolean bReturn = false;
		if (el != null){
			WebElement link = WebElementUtils.getChildElements(el, By.tagName("a")).get(2);
			bReturn = WebElementUtils.clickElement(link);
		}
		return bReturn;
	}
	
	public boolean deleteWorkOrder(){
		boolean bReturn = false;
		WebElement delete = WebElementUtils.findElement(B2WMaintain.getKendoDeleteButton());
		if (delete != null){
			bReturn = WebElementUtils.clickElement(delete);
			bReturn &= clickConfirmYes();
		}
		return bReturn;
	}
	public boolean clickAddItemButton() {
		boolean bReturn = false;
		WebElement el = getButton("Add Item");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public String getWorkOrderHeadline() {
		return WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getEquipmentHeadline()).getText();
	}
	
	public boolean clickFinish() {
		return super.clickFinish();
	}
	
	public boolean editItemDescription(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Item Description", B2WMaintain.getKendoInputTextBox());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			el.clear();
			bReturn &= WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	public String getOriginatingRequestID(){
		String sText = "";
		List<WebElement> grids = WebElementUtils.findElements(By.className("data"));
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(grids, "data-bind", "text: editViewModel.workOrderItems.selectedItem.maintenanceRequestID");
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	
	public boolean editItemNumber(String s) {
		boolean bReturn = false;
		WebElement el = getFormElement("Item Number", B2WMaintain.getKendoInputTextBox());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			el.clear();
			bReturn &= WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	
	public boolean editProblemCode(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Problem Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	
	public boolean editType(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Type", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	public boolean editCompCode(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Component Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	public boolean editSubcomponentCode(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Subcomponent Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	public boolean editFailureCode(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Failure Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	public boolean editActionCode(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Action Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	public boolean editWarranty(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Warranty", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	public boolean chargeToJob(boolean check){

		List<WebElement> el = WebElementUtils.getElementsWithMatchingAttribute(WebElementUtils.findElements(By.tagName("input")), "name","ChargeToJob");
		WebElement box = WebElementUtils.getVisibleElementFromListofElements(el);
		
		
		Coordinates coordinate = ((Locatable)box).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		
		return checkBox(box, check);
	}
	public boolean editAltID(String sID){
		boolean bReturn = false;
		WebElement el = getFormElement("Alternate ID", B2WMaintain.getKendoInputTextBox());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			el.clear();
			bReturn &= WebElementUtils.sendKeys(el, sID);
		}
		return bReturn;
	}
	public boolean editNotesForItem(String sText){
		return setNotesForItem(sText);
	}
	
	private List<WebElement> getPartsRows() {
		WebElement header = getHeader("Parts");
		WebElement tbody = WebElementUtils.getChildElement(header, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	
	private List<WebElement> getPlannedHourRows() {
		List<WebElement> rows = null;
		List<WebElement> hourslist = WebElementUtils.findElements(By.className("hours-list"));
		for (WebElement el : hourslist) {
			if (el.getAttribute("id").equals("hours_list_view")) {
				if (el.isDisplayed()) {
					WebElement tbody = WebElementUtils.getChildElement(el, By.tagName("tbody"));
					rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
					break;
				}
			}
		}
		return rows;
	}
	private List<WebElement> getEditPlannedHourRows() {
		List<WebElement> rows = null;
		List<WebElement> hourslist = WebElementUtils.findElements(By.className("hours-list"));
		for (WebElement el : hourslist) {
			if (el.getAttribute("id").equals("hours_edit")) {
				if (el.isDisplayed()) {
					WebElement tbody = WebElementUtils.getChildElement(el, By.tagName("tbody"));
					rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
					break;
				}
			}
		}
		return rows;
	}

	private List<WebElement> getReportedHourRows() {
		List<WebElement> rows = null;
		List<WebElement> hourslist = WebElementUtils.findElements(By.className("hours-list"));
		for (WebElement el : hourslist) {
			if (el.getAttribute("id").equals("reported_list_view")) {
				if (el.isDisplayed()) {
					WebElement tbody = WebElementUtils.getChildElement(el, By.tagName("tbody"));
					rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
					break;
				}
			}
		}
		return rows;
	}
	
	private List<WebElement> getEditReportedHourRows() {
		List<WebElement> rows = null;
		List<WebElement> hourslist = WebElementUtils.findElements(By.className("reported-list"));
		for (WebElement el : hourslist) {
			if (el.getAttribute("id").equals("reported_hours_edit")) {
				if (el.isDisplayed()) {
					WebElement tbody = WebElementUtils.getChildElement(el, By.tagName("tbody"));
					rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
					break;
				}
			}
		}
		return rows;
	}
	
	
	public ArrayList<String> getPlannedHoursFromView() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> HourRows = getPlannedHourRows();
		if (HourRows != null) {
			Iterator<WebElement> iter = HourRows.iterator();
			while (iter.hasNext()) {
				al.add(WebElementUtils.getChildElements(iter.next(), By.tagName("td")).get(0).getText());
			}
		}
		return al;
	}
	public ArrayList<String> getPlannedHoursFromEditView() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> HourRows = getEditPlannedHourRows();
		if (HourRows != null) {
			Iterator<WebElement> iter = HourRows.iterator();
			while (iter.hasNext()) {
				al.add(WebElementUtils.getChildElements(iter.next(), By.tagName("td")).get(0).getText());
			}
		}
		return al;
	}
	public ArrayList<String> getReportedHoursFromView() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> HourRows = getReportedHourRows();
		if (HourRows != null) {
			Iterator<WebElement> iter = HourRows.iterator();
			while (iter.hasNext()) {
				al.add(WebElementUtils.getChildElements(iter.next(), By.tagName("td")).get(0).getText());
			}
		}
		return al;
	}
	
	public ArrayList<String> getReportedHoursFromEditView() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> HourRows = getEditReportedHourRows();
		if (HourRows != null) {
			Iterator<WebElement> iter = HourRows.iterator();
			while (iter.hasNext()) {
				al.add(WebElementUtils.getChildElements(iter.next(), By.tagName("td")).get(0).getText());
			}
		}
		return al;
	}
	
	
	public ArrayList<String> getParts() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getPartsRows().iterator();
		while (iter.hasNext()){
			String sText = WebElementUtils.getChildElements(iter.next(),By.tagName("td")).get(0).getText();
			sText = sText.substring(0, sText.indexOf("["));
			al.add(sText.trim());
		}
		return al;
	}
	public boolean deletePart(String sPart){
		boolean bReturn = false;
		int iRow = getParts().indexOf(sPart);
		List<WebElement> rows = getPartsRows();
		if (rows.size()>0){
			WebElement delete = WebElementUtils.getChildElement(rows.get(iRow), B2WMaintain.getKendoDeleteButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}
	public boolean clickAddPartsToItem() {
		return WebElementUtils.clickElement(getButton("Add Parts"));
	}
	public boolean clickEditQuantities() {
		return WebElementUtils.clickElement(getEditButton("Edit Quantities"));
	}
	public boolean setCommentAndSave(String sText){
		return super.setNewCommentAndSave(sText);
	}
	public String getComment() {
		return getComments(0,0);
	}
	public boolean deleteComment(String sComment){
		boolean bReturn = false;
		WebElement el = getRowByCommentDescription(sComment);
		if (el != null){
			WebElement delete = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDeleteButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}
	
	public boolean editComment(String sComment){
		boolean bReturn = false;
		WebElement el = getRowByCommentDescription(sComment);
		if (el != null){
			WebElement delete = WebElementUtils.getChildElement(el, B2WMaintain.getKendoEditButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}


}
