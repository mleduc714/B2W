package testcases.maintain;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.dialogs.B2WAddItemWorkOrder;
import tasks.dialogs.B2WAddMaintenanceReqToWorkOrder;
import tasks.dialogs.B2WAddPartsToWorkItem;
import tasks.dialogs.B2WAddToInventory;
import tasks.dialogs.B2WApprovePurchaseOrder;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WEditScheduleMaintenance;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.jobs.B2WJobsTasks;
import tasks.maintain.B2WInventoryTasks;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainPartsTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WPurchasingTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.resources.B2WEmployeeTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.util.TaskUtils;

public class B2WRequestSmokeTest extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WJobsTasks b2wJob = new B2WJobsTasks();
	B2WMaintainDashboardTasks b2wDash = new B2WMaintainDashboardTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WMaintainTasks b2wMaintain = new B2WMaintainTasks();
	B2WWorkOrdersTasks b2wWork = new B2WWorkOrdersTasks();
	B2WAddMaintenanceReqToWorkOrder addToWO = new B2WAddMaintenanceReqToWorkOrder();
	B2WMaintainProgramsTasks b2wMainPrograms = new B2WMaintainProgramsTasks();
	B2WAddInterval addInterval = new B2WAddInterval();
	B2WAddItemMaintenanceProgram b2wAddItem = new B2WAddItemMaintenanceProgram();
	B2WMaintainScheduleTasks b2wSchd = new B2WMaintainScheduleTasks();
	B2WScheduleMaintenance b2wSchMain = new B2WScheduleMaintenance();
	B2WCompleteWorkOrder b2wComplete = new B2WCompleteWorkOrder();
	B2WEditScheduleMaintenance b2wEditSch = new B2WEditScheduleMaintenance();
	B2WReportHours b2wReport = new B2WReportHours();
	B2WTimeCardTasks b2wtimecards = new B2WTimeCardTasks();
	B2WAddEquipmentToMainProgram b2wEquipmentProgram = new B2WAddEquipmentToMainProgram();
	B2WAddItemWorkOrder b2wAddItemWO = new B2WAddItemWorkOrder();
	B2WInventoryTasks inventory = new B2WInventoryTasks();
	B2WAddToInventory addInventory = new B2WAddToInventory();
	B2WMaintainPartsTasks parts = new B2WMaintainPartsTasks();
	B2WEquipmentTasks b2wE = new B2WEquipmentTasks();
	B2WAddItemWorkOrder b2wAddToWorkOrder = new B2WAddItemWorkOrder();
	B2WAddPartsToWorkItem addParts = new B2WAddPartsToWorkItem();
	B2WEmployeeTasks b2wEmp = new B2WEmployeeTasks();
	B2WApprovePurchaseOrder approve = new B2WApprovePurchaseOrder();	
	B2WPurchasingTasks purch = new B2WPurchasingTasks();
	B2WEquipmentTasks b2wEquip = new B2WEquipmentTasks();
	String sEquipment,sID,sBusinessUnit, sRequestDescription, sAltID, sRequestNotes, sRequestComment, sRequestType,
	sProblemCode, sRequestedBy, sRequestNumber, sEditRequestNumber, sEditRequestType, sEditNotes, sEditDesc;
	
	int iRandom;

	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		iRandom = getRandomNumber();
		
		sEquipment = getProperty("sEquipment")+iRandom;
		sID = getProperty("sID")+iRandom;
		sBusinessUnit = getProperty("sBusinessUnit");
		sRequestDescription=getProperty("sRequestDescription");
		sAltID=getProperty("sAltID")+iRandom;
		sRequestNotes=getProperty("sRequestNotes");
		sRequestComment=getProperty("sRequestComment");
		sRequestNumber=getProperty("sRequestNumber");
		sEditRequestNumber=getProperty("sEditRequestNumber");
		sEditRequestType=getProperty("sEditRequestType");
		sEditNotes=getProperty("sEditNotes");
		sEditDesc=getProperty("sEditDesc");
		super.testSetUp();
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
		return "Request Smoke Test";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/request";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		//Create New Requests
		createRequest();
		editRequest();
		//•Edit existing Requests (should only be able to edit requests with a status of Requested)
		
		
//		•Delete a Request (based on status and users security role permissions)
//		•Add/Edit/Delete Comments on a Request
//		•Add/Edit/Delete Attachments on a Request
//		•Adding a Request to a Work Order
//		•Links to Equipment
//		•Search for information on Requests including Expanded Search
//		•Explore Advanced Search & Filters
//		•Navigation options to Requests
		

	}
	
	public void createRequest() {
		b2wNav.openMaintain();
		b2wMaintain.openEquipment();
		b2wEquip.createNewEquipment();
		assertTrue("Create Equipment", b2wEquip.createEquipment(sEquipment, sID, sBusinessUnit));
		logCompare(true,b2wMaintain.openRequests(),"Open Requests");
		logCompare(true,b2wRequests.clickCreateNewRequestButton(), "Click Create New Request");
		logCompare(true,b2wRequests.selectEquipment(sEquipment),"Equipment");
		logCompare(true,b2wRequests.setRequestDescription(sRequestDescription),"Request Desc");
		logCompare(true,b2wRequests.setAlternativeID(sAltID),"Alt ID");
		sRequestType = b2wRequests.selectAnyTypeFromDD();
		sProblemCode = b2wRequests.selectAnyProblemCodeFromDD();
		sRequestedBy = b2wRequests.selectRequestedByFromDD();
		logCompare(true,b2wRequests.setRequestNotes(sRequestNotes), "Request Notes");
		logCompare(true,b2wRequests.clickNewCommentButton(), "Click New Comment");
		logCompare(true,b2wRequests.setNewCommentAndSave(sRequestComment), "Set New Comment");
		logCompare(true,b2wRequests.clickSaveButton(), "Click Save Button");
	}

	public void editRequest() {
		b2wNav.openMaintain();
		b2wMaintain.openRequests();
		b2wRequests.selectWorkOrderRequestByID(sRequestNumber);
		logCompare(false,b2wRequests.clickEditRequest(),"Cannot edit request");
		TaskUtils.sleep(500);
		logCompare(true,b2wRequests.selectWorkOrderRequestByID(sEditRequestNumber), "Select Request that can be edited");
		logCompare(true,b2wRequests.clickEditRequest(),"Edit Request");
		logCompare(true,b2wRequests.setRequestDescription(sEditDesc), "Edit Desc");
		logCompare(true,b2wRequests.selectTypeFromDD(sEditRequestType), "Edit Type");
		logCompare(true,b2wRequests.setRequestNotes(sEditNotes),"Changed Notes");
		logCompare(true,b2wRequests.clickSaveButton(),"Save");
		logCompare(true,b2wRequests.selectWorkOrderRequestByDescription(sEditDesc),"Edit description");
		TaskUtils.sleep(500);
		logCompare(true,b2wRequests.deleteRequest(), "Delete this Request");
		TaskUtils.sleep(1000);
	}
	
}
