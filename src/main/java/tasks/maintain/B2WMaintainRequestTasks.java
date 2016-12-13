package tasks.maintain;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;



public class B2WMaintainRequestTasks extends B2WKendoTasks {
	
	public int iEquipment = 0;
	public int iRequestDesc = 1;
	public int iAltID = 2;
	public int iType = 3;
	public int iProblemCode = 4;
	public int iRequestedBy = 5;
	public int iPriority = 6;
	
	Logger log = Logger.getLogger(B2WMaintainRequestTasks.class);

	public boolean clickCreateNewRequestButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoButtonAdd());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainRequestCreateView()) != null;
		
		}
		
		return bReturn;
	}
	
	public boolean selectEquipment(String sText) {
		boolean bReturn = false;
		WebElement equipment =getFormElement("Equipment", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			bReturn = sendTextAndSelectValueFromKendoFDD(equipment, sText);
		}
		return bReturn;
		
	}
	
	public String selectAnyPieceOfEquipment() {
		String sText = "";
		WebElement equipment = getFormElement("Equipment", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			WebElementUtils.sendKeys(equipment, "a");
			TaskUtils.sleep(500);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public boolean setRequestDescription(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Request Description", B2WMaintain.getKendoInputTextBox());
		if (equipment != null){
			bReturn = WebElementUtils.sendKeys(equipment, sText);
		}
		return bReturn;
		
	}
	public boolean setAlternativeID(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Alternate ID", B2WMaintain.getKendoInputTextBox());
		if (equipment != null){
			bReturn = WebElementUtils.sendKeys(equipment, sText);
		}
		return bReturn;
		
	}
	public boolean selectTypeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Type", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
		
	}
	
	public String selectAnyTypeFromDD() {
		String sText = "";
		WebElement equipment = getFormElement("Type", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			TaskUtils.sleep(500);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
		
	}
	
	public boolean selectProblemCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Problem Code", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectRequestedByFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Requested By", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectPriorityFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Priority", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	
	public boolean clickNewCommentButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.findElement(B2WMaintain.getB2WMaintainRequestCreateView());
		WebElement comment = WebElementUtils.getChildElement(parent, B2WMaintain.getB2WNewMaintanceRequestNewCommentButton());
		if (comment != null){
			Coordinates coordinate = ((Locatable)comment).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			bReturn = WebElementUtils.clickElement(comment);
			//WebElementUtils.waitAndFindDisplayedElement(By.cssSelector("textarea.comments")) != null;
		}
		return bReturn;
	}
	
	public boolean setNewCommentAndSave(String sText){
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(By.cssSelector("textarea.comments"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			if (el.isDisplayed()){
				bReturn = WebElementUtils.sendKeys(el, sText);
				WebElement parent = WebElementUtils.getParentElement(el);
				WebElement save = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoLargeSaveButton());
				bReturn = WebElementUtils.clickElement(save);
				bReturn &= WebElementUtils.waitForElementInvisible(el);
				break;
			}
		}
		return bReturn;
	}
	
	public boolean clickSaveButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.findElement(B2WMaintain.getB2WMaintainRequestCreateView());
		WebElement el = WebElementUtils.waitForChildElement(parent, B2WMaintain.getKendoLargeSaveButton(),1);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions()) != null;
		}
		return bReturn;
	}
	
	public boolean selectRequestByDescription(String sDesc){
		return selectItemFromView(sDesc, 1);
	}
	public boolean selectRequest(int i){
		return selectItemFromView(i);
	}
	public boolean clickAddToWorkOrderButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainRequestsAddToWorkOrder());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public String getSelectedItemDescription() {
		return getSelectedItemFromView(1);
	}
	public String getSelectedItemID() {
		return getSelectedItemFromView(0);
	}

	public boolean selectOpenRequests() {
		return selectViewFromDropDown("Open Requests");
	}
	public boolean selectCompletedRequests(){
		return selectViewFromDropDown("Completed Requests");
	}
	public boolean selectUnassignedRequests(){
		return selectViewFromDropDown("Unassigned Requests");
	}
	public boolean selectWarrantyRequests(){
		return selectViewFromDropDown("Warranty Requests");
	}
	public boolean selectProgramRequests(){
		return selectViewFromDropDown("Program Requests");
	}
	public boolean selectAllRequestsGroupedByEquipment(){
		return selectViewFromDropDown("All Requests Grouped By Equipment");
	}
	public boolean selectOpenRequestsGroupedByEquipment(){
		return selectViewFromDropDown("Open Requests Grouped By Equipment");
	}
	public boolean selectCompletedRequestsGroupedByEquipment(){
		return selectViewFromDropDown("Completed Requests Grouped By Equipment");
	}
	public boolean selectUnassignedRequestsGroupedByEquipment(){
		return selectViewFromDropDown("Unassigned Requests Grouped By Equipment");
	}
	public boolean selectWarrantyRequestsGroupedByEquipment(){
		return selectViewFromDropDown("Warranty Requests Grouped By Equipment");
	}
	

	private boolean selectViewFromDropDown(String sText){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainRequestListView());
		WebElement dd = WebElementUtils.getChildElement(listView, B2WMaintain.getKendoDropDown());
		if (dd != null){
			WebElementUtils.clickElement(dd);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public String getSelectedItemFromDropDown() {
		String sText = "";
		WebElement listView = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainRequestListView());
		List<WebElement> inputs = WebElementUtils.getChildElements(listView, B2WMaintain.getKendoDropDown());
		WebElement dd = WebElementUtils.getElementWithMatchingAttribute(inputs, "unselectable", "on");
		if (dd != null){
			sText = dd.getText();
		}
		return sText;
	}
	
	public int getTheNumberOfRequestsInView() {
		return getNumberOfItemsFromView();
	}
	
	public String getSelectedRequestDueDate() {
		return getDueDate();
	}
	public String getSelectedRequestStatus() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainRequestOrderStatus());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public boolean setRequestNotes(String sText){
		return setNotes(sText);
	}
}
