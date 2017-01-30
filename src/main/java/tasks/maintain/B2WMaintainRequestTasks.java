package tasks.maintain;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

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
			WebElementUtils.clickElement(equipment);
			bReturn = WebElementUtils.sendKeys(equipment, sText);
			selectItemFromDropDown(0);
		}
		return bReturn;
	}
	
	public String selectAnyPieceOfEquipment() {
		String sText = "";
		WebElement equipment = getFormElement("Equipment", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.sendKeys(equipment, "a");
			TaskUtils.sleep(500);
			selectRandomItemFromDropDown();
			sText = equipment.getText();
			log.debug("The Piece of Equipment Selected is: "+sText);
		}
		return sText;
	}
	
	public boolean setRequestDescription(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Request Description", B2WMaintain.getKendoInputTextBox());
		if (equipment != null){
			equipment.clear();
			bReturn = WebElementUtils.sendKeys(equipment, sText);
		}
		return bReturn;
		
	}
	public boolean setAlternativeID(String sText){
		boolean bReturn = false;
		WebElement equipment = getFormElement("Alternate ID", B2WMaintain.getKendoInputTextBox());
		if (equipment != null){
			equipment.clear();
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
			selectRandomItemFromDropDown();
			sText = equipment.getText();
			log.debug("The Type selected from DD is "+sText);
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
	
	public String selectAnyProblemCodeFromDD() {
		String s = "";
		WebElement equipment = getFormElement("Problem Code", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElementUtils.clickElement(equipment);
			s = selectRandomItemFromDropDown();
		}
		return s;
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
	
	public String selectRequestedByFromDD() {
		String s = "";
		WebElement equipment = getFormElement("Requested By", B2WMaintain.getKendoDropDown());
		if (equipment != null){
			WebElementUtils.clickElement(equipment);
			s = selectRandomItemFromDropDown();
		}
		return s;
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
	
	public boolean setComments(String sText){
		
		return super.setComments(sText, true);
	}
	
	public boolean clickSaveButton() {
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getKendoLargeSaveButton());
		WebElement el = WebElementUtils.getVisibleElementFromListofElements(list);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions()) != null;
		}
		return bReturn;
	}
	
	public boolean selectWorkOrderRequestByDescription(String sDesc){
		return selectItemFromView(sDesc, COLUMN.DESCRIPTION);
	}
	public boolean selectWorkOrderRequestByID(String sID){
		return selectItemFromView(sID, COLUMN.ID);
	}
	public boolean selectRequest(int i){
		return selectItemFromView(i);
	}
	public boolean clickAddToWorkOrderButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainRequestsAddToWorkOrder());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainNewWorkOrderView());
		}
		return bReturn;
	}
	
	public boolean clickEditRequest() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoEditButton());
		if (el != null){
			try {
				el.click();
				bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainEditFormContent()) != null;
				bReturn &= true;
			}catch (WebDriverException e){
				log.debug("Edit is not available");
			}
		}
		return bReturn;
	}
	
	public String getSelectedItemDescription() {
		return getSelectedItemFromView(1);
	}
	public String getSelectedItemID() {
		return getSelectedItemFromView(0);
	}

	public boolean selectAllRequests() {
		return selectViewFromDropDown(0);
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
	private boolean selectViewFromDropDown(int i){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainRequestListView());
		WebElement dd = WebElementUtils.getChildElement(listView, B2WMaintain.getKendoDropDown());
		if (dd != null){
			WebElementUtils.clickElement(dd);
			bReturn = selectItemFromDropDown(i);
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
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainRequestOrderStatus());
		if (el != null){
			sText = el.getText().trim();
		}
		return sText;
	}
	
	public boolean clickOnLinkInStatus() {
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getB2WWorkOrderStatus());
		if (list.size()>0){
			WebElement el = WebElementUtils.getVisibleElementFromListofElements(list);
			WebElement link = WebElementUtils.getChildElement(el, By.tagName("a"));
			bReturn = WebElementUtils.clickElement(link);
		}
		return bReturn;
	}
	public boolean setRequestNotes(String sText){
		return setNotes(sText);
	}

	public boolean deleteRequest() {
		boolean bReturn = false;
		try {
			WebElement delete = WebElementUtils.findElement(B2WMaintain.getKendoDeleteButton());
			if (delete != null) {
				delete.click();
				bReturn = clickConfirmYes();
			}
		} catch (WebDriverException e) {
			log.debug("Delete not available");
		}
		return bReturn;
	}
	public ArrayList<String> getEquipmentFromRequestsView(){
		return getItemsFromView(3);
	}
	public String getValueOfItem(String sItem){
		return getValueOfItem(sItem, B2WMaintain.getMaintainRequestDetailView());
	}
	public String getNotes() {
		return getNotes(B2WMaintain.getMaintainRequestDetailView());
	}

	public String getComment() {
		return getComments(0,0);
	}

	public boolean editComment(String s){
		return super.editComment(s);
	}
	public boolean deleteComment(String sComment){
		return super.deleteComment(sComment);
	}
	public boolean clickOnEquipmentLink() {
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getMaintainSubhead());
		if (list.size()>1){
			WebElement link = WebElementUtils.getChildElement(list.get(1), By.tagName("a"));
			bReturn = WebElementUtils.clickElement(link);
			WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getMaintainEquipmentDetailView());
		}
		return bReturn;
	}
}
