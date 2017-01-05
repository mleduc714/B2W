package testcases.maintain;

import java.util.ArrayList;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddItemWorkOrder;
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
	
	String sEquipment, sRequestEquipmentDesc, sRequestType, sProblemCode, sRequestBy, sRequestNotes, sRequestComments, sRequestID;
	String sEquipmentName, sEquipmentID_Name, sWorkOrderDescription, sWorkOrderItemDescription;
	String sAddItemCompCode, sAddItemSubCode, sAddItemProblemCode, sAddItemFailCode, sAddItemActionCode, sAddItemRequestBy, sAddItemType;
	String sProgramItem;
	int iRandom;
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		iRandom = getRandomNumber();
		sRequestEquipmentDesc = getProperty("sRequestEquipmentDesc")+iRandom;
		sRequestNotes = getProperty("sRequestNotes");
		sRequestComments = getProperty("sRequestComments");
		sEquipment = getProperty("sEquipmentName");
		sEquipmentName = getProperty("sEquipmentName")+iRandom;
		sEquipmentID_Name = iRandom + " ["+sEquipmentName+"]";
		sWorkOrderDescription = getProperty("sWorkOrderDescription")+iRandom;
		sWorkOrderItemDescription = getProperty("sWorkOrderItemDescription")+iRandom;
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
		return "author";
	}

	@Override
	public String getTestDescription() {
		// enter the description for the testcase
		return "Testcase description";
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

//      Add Requests to a Work Order
//		�Create a New Work Order
//		�Add a New Item to a Work Order
//		�Generate/Add an active maintenance program service to a Work Order//
		createEquipment();
		createRequest();
		createWorkOrder();
		editWorkOrder();
//		addProgramToWorkOrder();
//		editItemsOnWorkOrder();

//		�Edit Work Order�Details
//		�Hours (Planned/Reported)
//		�Parts (Database & Custom Part)
//		�Add/Edit/Delete Comments on a Request
//		�Add/Edit/Delete Attachments on a Request
//		�Search for information on Requests including Expanded Search
//		�Explore Advanced Search & Filters
//		�Sorting of Work Order List
//		�View Report on a Work Order
//		�Approve a Work Order
//		�Complete a Work Order
//		�Unapprove a Work Order
//		�Links on the Work Order �'Nearby Maintenance Around this Equipment' launches to Map
//		�Equipment Link
//		�Request Link
//		�Active Warranty Link
//
//		�Security Settings for Work Order*/
		
		
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
		logCompare(true,program.selectMaintenanceProgram(0),"Select first program");
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
		b2wNav.openMaintain();
		logCompare(true,b2wmain.openWorkOrders(),"Open Work Orders");
		logCompare(true,b2wWork.selectWorkOrderByDescription(sWorkOrderItemDescription), "Set Description");
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.clickEditWorkOrder(),"Edit Work Order");
		TaskUtils.sleep(1000);
		//b2wWork.chargeToJob(true);
		logCompare(true,	b2wWork.clickAddItemButton(), "Click Add Item");
		TaskUtils.sleep(1000);
		logCompare(true,b2wAddToWorkOrder.addAllRequests(), "add requests");
		logCompare(true,b2wAddToWorkOrder.clickFinishButton(),"Click Finish");
		
	}
}
