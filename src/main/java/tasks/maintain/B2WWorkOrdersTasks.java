package tasks.maintain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
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
	
	public boolean editWorkOrder() {
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
		if (equipment != null){
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
	
	public boolean selectLaborRateClassFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Labor Rate Class",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectPlannedLocationDD(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Planned Work Location",B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
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
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions(), WebElementUtils.MEDIUM_TIME_OUT) != null;
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
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions(), WebElementUtils.MEDIUM_TIME_OUT) != null;
		}
		return bReturn;
	}

	
	public boolean clickCreateAddItemButton() {
		boolean bReturn = false;
		WebElement button = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddItemCreateButton());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitForElementInvisible(button);
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

	public boolean collapseDetails() {
		return getHeaderandExpandOrCollapse("Details", false);
	}
	public boolean expandParts() {
		return getHeaderandExpandOrCollapse("Parts", true);
	}
	public boolean collapseParts() {
		return getHeaderandExpandOrCollapse("Parts", false);
	}
	public boolean expandHours() {
		return getHeaderandExpandOrCollapse("Hours", true);
	}
	public boolean clickAddPlannedHours() {
		boolean bReturn = false;
		WebElement el = getButton(6);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WPlannedHours()) != null;
		}
		return bReturn;
		
	}
	public boolean clickAddReportedHours() {
		WebElement el = getButton(7);
		return WebElementUtils.clickElement(el);
	
	}
	public boolean clickAddParts() {
		boolean bReturn = false;
		WebElement el = getButton(8);
		bReturn = WebElementUtils.clickElement(el);
		bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
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
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WWorkOrderItems());
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
	
	public boolean selectItemOnWorkOrder(String s) {
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
	
}
