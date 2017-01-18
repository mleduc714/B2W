package testcases.maintain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddItemWorkOrder;
import tasks.dialogs.B2WAddPartsToWorkItem;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WPlannedHours;
import tasks.dialogs.B2WReportHours;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.util.TaskUtils;

public class B2WWorkOrderSmokeTest extends B2WTestCase {

	B2WMaintainTasks b2wmain = new B2WMaintainTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainRequestTasks b2wRequest = new B2WMaintainRequestTasks();
	B2WEquipmentTasks b2wEquip = new B2WEquipmentTasks();
	B2WWorkOrdersTasks b2wWork = new B2WWorkOrdersTasks();
	B2WAddItemWorkOrder b2wAddToWorkOrder = new B2WAddItemWorkOrder();
	B2WMaintainProgramsTasks program = new B2WMaintainProgramsTasks();
	B2WAddEquipmentToMainProgram addEquipmentToProgram = new B2WAddEquipmentToMainProgram();
	B2WPlannedHours b2wPlannedHours = new B2WPlannedHours();
	B2WReportHours b2wReportHours = new B2WReportHours();
	B2WAddPartsToWorkItem addParts = new B2WAddPartsToWorkItem();
	B2WCompleteWorkOrder b2wCmp = new B2WCompleteWorkOrder();
	
	String sEquipment, sRequestEquipmentDesc, sRequestType, sProblemCode, sRequestBy, sRequestNotes, sRequestComments, sRequestID;
	String sEquipmentName, sEquipmentID_Name, sWorkOrderDescription, sWorkOrderItemDescription;
	String sAddItemCompCode, sAddItemSubCode, sAddItemProblemCode, sAddItemFailCode, sAddItemActionCode, sAddItemRequestBy, sAddItemType;
	String sProgramItem;
	String sWorkOrderPlannedHoursDesc,sWorkOrderPlannedHours,sWorkOrderPlannedLaborType,sWorkOrderReportHoursDesc,
		    sWorkOrderReportLaborType,sWorkOrderReportRegularHours;
	String sCustomPart,sCustomPartCost, sCustomEstQty,sCustomRptQty,sCustomRptUnitOfMeasure;
	String sPart1,sPart2;
	int iRandom;
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		iRandom = getRandomNumber();
		sRequestEquipmentDesc = getProperty("sRequestEquipmentDesc")+iRandom;
		sRequestNotes = getProperty("sRequestNotes")+timestamp.getTime();
		sRequestComments = getProperty("sRequestComments")+timestamp.getTime();
		sEquipment = getProperty("sEquipmentName");
		sEquipmentName = getProperty("sEquipmentName")+iRandom;
		sEquipmentID_Name = iRandom + " ["+sEquipmentName+"]";
		sWorkOrderDescription = getProperty("sWorkOrderDescription")+iRandom;
		sWorkOrderItemDescription = getProperty("sWorkOrderItemDescription")+iRandom;
		sWorkOrderPlannedHoursDesc = getProperty("sWorkOrderPlannedHoursDesc");
		sWorkOrderPlannedHours = getProperty("sWorkOrderPlannedHours");
		sWorkOrderPlannedLaborType = getProperty("sWorkOrderPlannedLaborType");
		sWorkOrderReportHoursDesc = getProperty("sWorkOrderReportHoursDesc");
		sWorkOrderReportLaborType = getProperty("sWorkOrderReportLaborType");
		sWorkOrderReportRegularHours = getProperty("sWorkOrderReportRegularHours");
		sCustomPart = getProperty("sCustomPart");
		sCustomPartCost = getProperty("sCustomPartCost");
		sCustomEstQty = getProperty("sCustomPartCost");
		sCustomRptQty = getProperty("sCustomRptQty");
		sCustomRptUnitOfMeasure = getProperty("sCustomRptUnitOfMeasure");


	}

	@Override
	public void testTearDown() throws Throwable {
		// code here for code after the test complete. 
		// cleanup
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() {
		return "mleduc";
	}

	@Override
	public String getTestDescription() {
		// enter the description for the testcase
		return "Work Order Smoke Test";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/maintain";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {

/*		https://bid2win.atlassian.net/wiki/display/RP/Work+Order+Smoke+Test
*/		
		createEquipment();
		createRequest();
		createWorkOrder();
		editWorkOrder();
		addProgramToWorkOrder();
		editItemsOnWorkOrder();
		verifyWorkOrder();

		
		
	}

	public void createEquipment() {
		logCompare(true,b2wNav.openMaintain(),"Open Maintain");
		logCompare(true,b2wmain.openEquipment(),"Open Equipment");
		logCompare(true,b2wEquip.createNewEquipment(), "Create New Equipment");
		logCompare(true,b2wEquip.setEquipmentDescription(sEquipmentName), "Set Equipment");
		logCompare(true,b2wEquip.setEquipmentID(Integer.toString(iRandom)),"Set Equipment ID");
		logCompare(true,b2wEquip.selectNewEquipmentBusinessUnitFromDropDown("Hauling"),"Hauling");
		logCompare(true,b2wEquip.saveNewEquipment(), "New Equipment");
		TaskUtils.sleep(1000);
		logCompare(true,b2wEquip.selectEquipmentFromViewByDescription(sEquipmentName),"Select Equipment");
		
	}
	
	public void createRequest() {
		logCompare(true,b2wmain.openRequests(),"Open Requests");
		logCompare(true,b2wRequest.clickCreateNewRequestButton(), "Create New Request");
		logCompare(true,b2wRequest.selectEquipment(sEquipmentID_Name), "Select Equipment");
		logCompare(true,b2wRequest.setRequestDescription(sRequestEquipmentDesc), "Set Request Desc");
		sRequestType = b2wRequest.selectAnyTypeFromDD();
		sProblemCode = b2wRequest.selectAnyProblemCodeFromDD();
		sRequestBy = b2wRequest.selectRequestedByFromDD();
		logCompare(true, b2wRequest.selectPriorityFromDD("High"), "Select Priority");
		logCompare(true,b2wRequest.setRequestNotes(sRequestNotes), "Set Request Notes");
		logCompare(true,b2wRequest.clickNewCommentButton(), "click new comment");
		logCompare(true,b2wRequest.setNewCommentAndSave(sRequestComments), "Save comments");
		logCompare(true,b2wRequest.clickSaveButton(), "Save Request");
		logCompare(true,b2wRequest.selectWorkOrderRequestByDescription(sRequestEquipmentDesc), "Select Request");
		sRequestID = b2wRequest.getSelectedItemID();
		logCompare(sRequestNotes,b2wRequest.getNotes(),"Notes Match");
		//b2wRequest.expandComments();
		logCompare(sRequestComments,b2wRequest.getComment(), "Compare");
	}
	
	public void createWorkOrder() {
		logCompare(true,b2wmain.openWorkOrders(),"Open Work Orders");
		logCompare(true,b2wWork.clickCreateNewWorkOrderButton(),"Create New Work Order");
		logCompare(true,b2wWork.selectEquipment(sEquipmentID_Name), "Select Equipment");
		logCompare(true,b2wWork.selectPriorityFromDD("Medium"), "Select Medium");
		logCompare(true,b2wWork.setWorkOrderDescription(sWorkOrderDescription),"Work Order Desc");
		b2wWork.selectAnyPlannedWorkLocation();
		logCompare(true,b2wWork.clickAddItemButton(), "New Item");
		TaskUtils.sleep(1000);
		logCompare(true,b2wAddToWorkOrder.addItem(sRequestEquipmentDesc), "Desc");
		logCompare(true,b2wAddToWorkOrder.clickFinishButton(),"Click Finish");
		logCompare(true,b2wWork.clickSaveButton(), "Save Work");
		TaskUtils.sleep(1000);
	}
	
	public void editWorkOrder() {
		logCompare(true,b2wmain.openWorkOrders(),"Open Work Orders");
		TaskUtils.sleep(1000);
		b2wWork.selectWorkOrderByDescription(sWorkOrderDescription);
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.clickEditWorkOrder(),"Edit Work Order");
		logCompare(true,b2wWork.clickAddItemButton(),"Add Item");
		b2wAddToWorkOrder.setAddItemDescription(sWorkOrderItemDescription);
		sAddItemType = b2wAddToWorkOrder.setAnyAddItemTypeFromDD();
		b2wAddToWorkOrder.selectAddItemPriorityFromDD("Medium");
		sAddItemProblemCode = b2wAddToWorkOrder.selectAnyAddItemProblemCodeFromDD();
		sAddItemCompCode = b2wAddToWorkOrder.selectAnyAddItemCompCodeFromDD();
		sAddItemSubCode = b2wAddToWorkOrder.selectAnyAddItemSubCodeFromDD();
		sAddItemFailCode = b2wAddToWorkOrder.selectAnyAddItemFailureCodeFromDD();
		sAddItemActionCode = b2wAddToWorkOrder.selectAnyAddItemActionCodeFromDD();
		TaskUtils.sleep(1000);
		sAddItemRequestBy = b2wAddToWorkOrder.selectAnyAddItemRequestedByFromDD();
		TaskUtils.sleep(1000);
		logCompare(true,b2wAddToWorkOrder.clickCreateAddItemButton(),"Add Item");
		logCompare(true,b2wWork.saveEditWorkOrder(), "Save Edit Work");
		TaskUtils.sleep(1000);
	}
	
	public void addProgramToWorkOrder() {
		logCompare(true,b2wmain.openPrograms(),"Open Programs");
		logCompare(true,program.selectMaintenanceProgram(1),"Select first program");
		ArrayList<String> progItems = program.getItemsFromProgram();
		sProgramItem = progItems.get(progItems.size()-1);
		
		program.clickAddEquipment();
		logCompare(true,addEquipmentToProgram.selectEquipmentByDescription(sEquipmentName),"Select Equipment");
		logCompare(true,addEquipmentToProgram.clickFinishAddEquipment(), "Finish");
		TaskUtils.sleep(1000);
		logCompare(true,program.expandEquipmentByID(Integer.toString(iRandom)), "Expand");
		logCompare(true,program.generateItems(), "Generate Items");
	}
	
	public void editItemsOnWorkOrder() {
		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -2);
		logCompare(true,b2wmain.openWorkOrders(),"Open Work Orders");
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Description for "+sWorkOrderDescription);
		logCompare(true,b2wWork.clickEditWorkOrder(), "");

		logCompare(true,b2wWork.expandHours(), "Expanded Hours");
		logCompare(true,b2wWork.clickAddPlannedHours(), "Add Planned Hours");
		logCompare(true,b2wPlannedHours.setDescription(this.sWorkOrderPlannedHoursDesc), "");
		logCompare(true,b2wPlannedHours.setPlannedHours(this.sWorkOrderPlannedHours), "");
		logCompare(true,b2wPlannedHours.selectLaborType(this.sWorkOrderPlannedLaborType), "");
		logCompare(true,b2wPlannedHours.savePlannedHours(), "Save Planned Hours");
		logCompare(true,b2wWork.clickAddReportedHours(), "Add Reported Hours");
		logCompare(true,b2wReportHours.setEmployeeWorkHoursDescription(this.sWorkOrderReportHoursDesc), "");
		logCompare(true,b2wReportHours.selectEmployeeLaborType(this.sWorkOrderReportLaborType), "Select Labor Type");
		logCompare(true,b2wReportHours.setDate(format.format(cal.getTime())), "Set the Date");
		b2wReportHours.selectRandomEmployee();
		logCompare(true,b2wReportHours.setEmployeeRegularHours(this.sWorkOrderReportRegularHours), "");
		logCompare(true,b2wReportHours.saveReportedHours(), "Save Reported Hours");
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.clickAddItemButton(), "Click Add Item");
		TaskUtils.sleep(1000);
		logCompare(true,b2wAddToWorkOrder.addAllRequests(), "add requests");
		logCompare(true,b2wAddToWorkOrder.clickFinishButton(),"Click Finish");
		logCompare(true,b2wWork.collapseHours(), "Collapse Hours");
		logCompare(true,b2wWork.selectItemOnEditWorkOrder(sWorkOrderItemDescription), "Select Work Item");
		logCompare(true,b2wWork.expandParts(), "Expand Parts");
		logCompare(true,b2wWork.clickAddParts(), "Add Parts");
		sPart1 = addParts.selectRandomPartToAdd();
		sPart2 = addParts.selectRandomPartToAdd();
		logCompare(true,addParts.partsNext(), "");
		logCompare(true,addParts.clickAddCustomPart(), "Add Custom Part");
		logCompare(true,addParts.setCustomDescription(sCustomPart), "Desc");
		logCompare(true,addParts.setCustomUnitCost(sCustomPartCost), "Unit cost");
		logCompare(true,addParts.setCustomEstQty(this.sCustomEstQty), "Est Qty");
		logCompare(true,addParts.setCustomRptQty(this.sCustomRptQty), "Custom QTY");
		logCompare(true,addParts.selectUnitOfMeasure(this.sCustomRptUnitOfMeasure), "Unit of measure");
		logCompare(true,addParts.saveParts(), "Save");
		
		logCompare(true,b2wWork.saveEditWorkOrder(), "Save work order with adjustments");
		TaskUtils.sleep(5000);
	}
	
	public void verifyWorkOrder() {
		
		String sNewComment = "Edited:"+ timestamp.getTime();
		logCompare(true, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");

		logCompare(true, b2wWork.selectItemOnWorkOrder(sWorkOrderItemDescription),"Work Order Item");
		logCompare(true,b2wWork.expandParts(),"Expand Parts");
		logCompare(true,b2wWork.getParts().contains(sPart1), "Contains part "+sPart1);
		logCompare(true,b2wWork.getParts().contains(sPart2), "Contains part "+sPart2);
		logCompare(true,b2wWork.getParts().contains(sCustomPart), "Contains part "+sCustomPart);
		logCompare(true, b2wWork.selectItemOnWorkOrder(sRequestEquipmentDesc),"Select Request");
		logCompare(true,b2wWork.expandComments(), "Expand Comments");
		logCompare(sRequestComments,b2wWork.getComment(), "Verify Comments");
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.editComment(sRequestComments),"Edit Comment");
		logCompare(true,b2wWork.setCommentAndSave(sNewComment),"Save New Comment");
		logCompare(sNewComment,b2wWork.getComment(), "Verify New Comments");
		logCompare(true,b2wWork.selectWorkOrdersContainingProgramItems(),"Work Order Containing Program items");
		TaskUtils.sleep(1000);
		logCompare(true, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");
		logCompare(true,b2wWork.selectOpenWorkOrders(),"Select Open Work Orders");
		TaskUtils.sleep(1000);
		logCompare(true, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");
		logCompare(true,b2wWork.selectCompletedWorkOrders(),"Completed Work Order Items");
		TaskUtils.sleep(1000);
		logCompare(false, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");
		logCompare(true,b2wWork.selectOpenWorkOrders(),"Select Open Work Orders");
		TaskUtils.sleep(1000);
		logCompare(true, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");
		logCompare(true, b2wWork.clickApproveButton(), "Approve Work Order");
		b2wWork.clickConfirmYes();
		logCompare(false, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");
		logCompare(true,b2wWork.selectAllWorkOrders(), "Select All Work Orders");
		TaskUtils.sleep(1000);
		logCompare(true, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");
		logCompare(true, b2wWork.clickComplete(), "Complete Work Order");
		logCompare(true, b2wCmp.clickNextPage(),"Click Next Page");
		logCompare(true,b2wCmp.selectCompletedWorkItem(sWorkOrderItemDescription), "Select Work Item");
		logCompare(true,b2wCmp.selectCompletedWorkItem(sRequestEquipmentDesc), "Select Work Item");
		logCompare(true,b2wCmp.completeSave(), "Complete Save");
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.selectCompletedWorkOrders(),"Completed Work Order Items");
		TaskUtils.sleep(1000);
		logCompare(true, b2wWork.selectWorkOrderByDescription(sWorkOrderDescription), "Select Work Order");
		
		
	}
}
