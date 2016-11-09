package testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.resources.B2WEquipmentTasks;

public class OperationsSmokeG extends B2WTestCase {

	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainTasks b2wMain = new B2WMaintainTasks();
	B2WMaintainProgramsTasks b2wMainPrograms = new B2WMaintainProgramsTasks();
	B2WEquipmentTasks b2wEquip = new B2WEquipmentTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WWorkOrdersTasks b2wOrder = new B2WWorkOrdersTasks();
	B2WMaintainScheduleTasks b2wSchd = new B2WMaintainScheduleTasks();
	B2WTimeCardTasks b2wtimecards = new B2WTimeCardTasks();
	String sMaintenanceProgramDesc;
	String sMaintenanceProgramItemADesc;
	String sMaintenanceProgramItemAType;
	String sMaintenanceProgramItemAPriority;
	String sMaintenanceProgramItemALevel;
	String sMaintenanceProgramItemAIntervalDesc;
	String sMaintenanceProgramItemBDesc;
	String sMaintenanceProgramItemBType;
	String sMaintenanceProgramItemBPriority;
	String sMaintenanceProgramItemBLevel;
	String sMaintenanceProgramItemBIntervalDesc;
	String sLaborRate, sLaborRateID, sCategoryB,sCategoryC,sCategoryA, sCategoryD;
	String sPartA, sPartIDA, sPartB, sPartIDB, sPartC, sPartIDC, sEquipmentDescD, sEquipmentIDD, sDateTwoDaysAgo, sDateTwoWeeksFromNow, sEquipmentID_Desc;
	String sMaintenanceRequestDescription;
	String sMaintenanceRequestPriority;
	String sMaintenanceRequestComments; 
	String sMaintenanceWorkOrderDescription;
	String sMaintenanceWorkOrderItemDescriptionA;
	String sMaintenanceWorkOrderItemDescriptionB;
	String sEmployeeFirstNameD, sEmployeeLastNameD, sEmployeeIDD, sEmployeeFullNameID;
	String sPlaceDescription, sPlaceID;
	String sMaintenanceTimeCardWorkDesc;
	
	




	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "mleduc";
	}

	@Override
	public String getDataPath() {
		// for properties files of test data
		return "data/test";
	}

	@Override
	public boolean isSupported() {
		// for specific browser
		return true;
	}

	@Override
	public String getCategory() {
		// Category of the within ops
		return null;
	}

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
		int n = getRandomNumber();
		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -2);
		sDateTwoDaysAgo = format.format(cal.getTime());
		cal.add(Calendar.DAY_OF_YEAR, 16);
		sDateTwoWeeksFromNow = format.format(cal.getTime());
		
		
		sMaintenanceProgramDesc = getProperty("sMaintenanceProgramDesc") + n;
		sMaintenanceProgramItemADesc = getProperty("sMaintenanceProgramItemADesc");
		sMaintenanceProgramItemAType = getProperty("sMaintenanceProgramItemAType");
		sMaintenanceProgramItemAPriority = getProperty("sMaintenanceProgramItemAPriority");
		sMaintenanceProgramItemALevel = getProperty("sMaintenanceProgramItemALevel");
		sMaintenanceProgramItemAIntervalDesc = getProperty("sMaintenanceProgramItemAIntervalDesc");
		sMaintenanceProgramItemBDesc = getProperty("sMaintenanceProgramItemBDesc");
		sMaintenanceProgramItemBType = getProperty("sMaintenanceProgramItemBType");
		sMaintenanceProgramItemBPriority = getProperty("sMaintenanceProgramItemBPriority");
		sMaintenanceProgramItemBLevel = getProperty("sMaintenanceProgramItemBLevel");
		sMaintenanceProgramItemBIntervalDesc = getProperty("sMaintenanceProgramItemBIntervalDesc");
		
		
		sLaborRate = getProperty("laborrateclass") + n;
		sLaborRateID = getProperty("laborrateclassid") + n;
		sCategoryA = getProperty("categoryNameA") + n;
		sCategoryB = getProperty("categoryNameB") + n;
		sCategoryC = getProperty("categoryNameC");
		sCategoryD = getProperty("categoryNameD");
		sPartA = getProperty("partA");
		sPartIDA = getProperty("partIDA") + n;
		sPartB = getProperty("partB");
		sPartIDB = getProperty("partIDB") + n;
		sPartC = getProperty("partC");
		sPartIDC = getProperty("partIDC") + n;
		sEquipmentDescD = getProperty("equipmentD");
		sEquipmentIDD = getProperty("equipmentidD")+ n;
		sEquipmentID_Desc = sEquipmentIDD +" [" +sEquipmentDescD + "]";
		//sEquipmentDescD="Bobcat S175";
		//sEquipmentIDD="BCAT01";
		
		
		sMaintenanceRequestDescription = getProperty("sMaintenanceRequestDescription") + n;
		sMaintenanceRequestPriority = getProperty("sMaintenanceRequestPriority");
		sMaintenanceRequestComments = getProperty("sMaintenanceRequestComments");
		sMaintenanceWorkOrderItemDescriptionA = getProperty("sMaintenanceWorkOrderItemDescriptionA");
		sMaintenanceWorkOrderItemDescriptionB = getProperty("sMaintenanceWorkOrderItemDescriptionB");
		sMaintenanceWorkOrderDescription = getProperty("sMaintenanceWorkOrderDescription") + n;
		sEmployeeFirstNameD = getProperty("employeenameFirstD");
		sEmployeeLastNameD = getProperty("employeenameLastD");
		sEmployeeIDD = getProperty("employeenameDID") +n;
		sEmployeeFullNameID = sEmployeeFirstNameD + " "+sEmployeeLastNameD + " ["+sEmployeeIDD+"]";
		sPlaceDescription = getProperty("placeD") + n;
		sPlaceID = getProperty("placeIDD") + n;
		sMaintenanceTimeCardWorkDesc = getProperty("sMaintenanceTimeCardWorkDesc");
		//test data
/*		sLaborRate = "Automation Rates";
		sCategoryC = "Repair";
		sCategoryB = "Hour Meter";
		sCategoryD = "Inspection";
		sEquipmentIDD = "CATVRLR_02";
		sEquipmentID_Desc = "CATVRLR_02 [CAT Vibratory Roller]";
		sPartA = "Grease";
		sPartB = "Hose";
		sPartC = "Oil hose";
		sEmployeeFullNameID = "Ryder Martin [13194]";*/
		
	}

	public void testMain() throws Throwable {

		createMaintenanceProgram();
		addParts();
		createRequest();
		createWorkOrders();

	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}
	
	public void createMaintenanceProgram() {
		assertTrue("open Maintain", b2wNav.openMaintain());
		assertTrue("open Programs", b2wMain.openPrograms());
		logCompare(true,b2wMainPrograms.createNewMaintenanceProgram(),"Create Maintenance Program");
		logCompare(true,b2wMainPrograms.setMaintenanceProgramDescription(sMaintenanceProgramDesc), "Set Maintenance Program Desc");
		logCompare(true,b2wMainPrograms.setBusinessUnit("Hauling"),"Select Business Unit");
		logCompare(true,b2wMainPrograms.selectLaborRateClass(sLaborRate), "Select Labor Rate Class");
		logCompare(true,b2wMainPrograms.clickAddItem(),"Click Add Item");
		logCompare(true,b2wMainPrograms.setAddItemDescription(sMaintenanceProgramItemADesc),"Set Maintenance item description");
		logCompare(true,b2wMainPrograms.selectAddItemPriority(sMaintenanceProgramItemAPriority),"Select Item priority");
		logCompare(true,b2wMainPrograms.selectAddItemTypeFromDD(sCategoryC), "Select Add Item Type");
		logCompare(true,b2wMainPrograms.setAddItemLevel(sMaintenanceProgramItemALevel),"Select Maintenance Program Level");
		logCompare(true,b2wMainPrograms.saveItem(),"Save Item");
		logCompare(true,b2wMainPrograms.getHeaderandExpandOrCollapse("Intervals", true)," Expand Interval");
		logCompare(true,b2wMainPrograms.clickAddInterval(),"Click Add Interval");
		logCompare(true,b2wMainPrograms.setIntervalDescription(sMaintenanceProgramItemAIntervalDesc),"Set Interval Description");
		logCompare(true,b2wMainPrograms.selectCalendarBasedInterval(),"Select Calendar based Interval");
		logCompare(true,b2wMainPrograms.selectDailyBasedInterval(),"Select Daily based Interval");
		logCompare(true,b2wMainPrograms.setIntervalOccursEvery("1"), "Ocucrs Every day");
		logCompare(true,b2wMainPrograms.saveInterval(), "Save Interval");
		logCompare(true,b2wMainPrograms.clickAddItem(), "Add Item");
		logCompare(true,b2wMainPrograms.setAddItemDescription(sMaintenanceProgramItemBDesc),"Set Maintenance item description");
		logCompare(true,b2wMainPrograms.selectAddItemTypeFromDD(sCategoryC), "Select Add Item Type");
		logCompare(true,b2wMainPrograms.selectAddItemPriority(sMaintenanceProgramItemBPriority),"Select Item priority");
		logCompare(true,b2wMainPrograms.setAddItemLevel(sMaintenanceProgramItemBLevel),"Select Maintenance Program Level");
		logCompare(true,b2wMainPrograms.saveItem(),"Save Item");
		logCompare(true,b2wMainPrograms.getHeaderandExpandOrCollapse("Intervals", true)," Expand Interval");
		logCompare(true,b2wMainPrograms.clickAddInterval(),"Click Add Interval");
		logCompare(true,b2wMainPrograms.setIntervalDescription(sMaintenanceProgramItemAIntervalDesc),"Set Interval Description");
		logCompare(true,b2wMainPrograms.selectMeterBasedInterval(),"Select Meter based Interval");
		logCompare(true,b2wMainPrograms.selectMeterTypeFromDD(sCategoryB),"Select Meter type");
		logCompare(true,b2wMainPrograms.selectMeterEvery("100"), "Occurs Every 100 hours");
		logCompare(true,b2wMainPrograms.setGenerateRepairRequestsForThisItem("10"), "Generate Requests for this item");
		logCompare(true,b2wMainPrograms.saveInterval(), "Save interval");
		logCompare(true,b2wMainPrograms.saveMaintenanceProgram(), "Save Maintenance Program");
		
		

	}
	public void addParts() {
		assertTrue("Open Equipment",b2wMain.openEquipment());
		logCompare(true, b2wEquip.selectEquipmentFromViewByID(sEquipmentIDD),"Select: "+sEquipmentIDD+" Equipment");
		logCompare(true, b2wEquip.expandParts(),"Expand Parts");
		logCompare(true, b2wEquip.clickAddPartsButton(),"Add Parts");
		logCompare(true, b2wEquip.selectPartToAddToEquipmentByDescription(sPartA), "Add "+sPartA+ " Part");
		logCompare(true, b2wEquip.selectPartToAddToEquipmentByDescription(sPartB), "Add "+sPartB+ " Part");
		logCompare(true, b2wEquip.selectPartToAddToEquipmentByDescription(sPartC), "Add "+sPartC+ " Part");
		logCompare(true, b2wEquip.clickSaveAddPart(), "Save Part");
		b2wEquip.collapseParts();
		logCompare(true, b2wEquip.expandMeters(), "Expand Meters");
		logCompare(true, b2wEquip.clickAddMeterButton(), "Click Add Meter");
		logCompare(true, b2wEquip.selectAddMeterTypeFromDD(sCategoryB), "Select Add "+sCategoryB+" Meter");
		logCompare(true, b2wEquip.selectAddMeterRequiredOnWorkOrderCompletionNotRequired(), "Add Meter not required");
		logCompare(true, b2wEquip.selectAddMeterExcludeFromWorkOrdersNever(), "Exclude never");
		logCompare(true, b2wEquip.setAddMeterTypeDescription("Hours Meter"), "Meter Description");
		logCompare(true, b2wEquip.setAddMeterIntialReading("20"),"Intial Reading");
		logCompare(true, b2wEquip.setAddMeterEnterNewReadingCheckBox(), "Enter new reading checkbox");
		logCompare(true, b2wEquip.setAddMeterEnterNewReading("120"),"Enter new reading");
		logCompare(true, b2wEquip.setAddMeterEnterNewReadingDate(sDateTwoDaysAgo), "Set two days ago");
		if (!logCompare(true, b2wEquip.clickSaveAddMeter(), "Add the Meter")){
			b2wEquip.clickCancelAddMeter();
		}
		logCompare(true, b2wEquip.collapseMeters(), "Collapse Meters");
		logCompare(true, b2wEquip.expandPrograms(), "Expand Programs");
		logCompare(true, b2wEquip.clickAddProgramButton(), "Add Programs");
		logCompare(true, b2wEquip.setAddProgramText(sMaintenanceProgramDesc), "Select Maintainence Program");
		logCompare(true, b2wEquip.clickAddProgramNextButton(), "Click Next");
		logCompare(true, b2wEquip.clickSaveProgramButton(), "Save Program");
		
		
	}
	
	public void createRequest() {
		assertTrue("Open Requests",b2wMain.openRequests());
		assertTrue("Create Requests", b2wRequests.clickCreateNewRequestButton());
		logCompare(true, b2wRequests.selectEquipment(sEquipmentID_Desc), "Select "+sEquipmentIDD+" Equipment");
		logCompare(true, b2wRequests.setRequestDescription(sMaintenanceRequestDescription), "Set Description");
		logCompare(true, b2wRequests.selectTypeFromDD(sCategoryD), "Select Auto corrective");
		logCompare(true, b2wRequests.clickNewCommentButton(), "Create a comments");
		logCompare(true, b2wRequests.setNewCommentAndSave(sMaintenanceRequestComments), "Comments");
		logCompare(true, b2wRequests.clickSaveButton(), "Save request");
		
	}
	
	public void createWorkOrders(){
		assertTrue("Open Work Orders",b2wMain.openWorkOrders());
		logCompare(true, b2wOrder.clickCreateNewWorkOrderButton(), "Create New Work Order");
		logCompare(true, b2wOrder.selectEquipment(sEquipmentID_Desc), "Select "+sEquipmentIDD+" Equipment");
		logCompare(true, b2wOrder.setWorkOrderDescription(sMaintenanceWorkOrderDescription), "Set Work");
		logCompare(true, b2wOrder.setDueDate(sDateTwoWeeksFromNow), "Due Date");
		logCompare(true, b2wOrder.selectPlannedLocationDD("Field"), "Planned in the Field");
		logCompare(true, b2wOrder.selectPriorityFromDD("Medium"), "Medium Priority");
		logCompare(true, b2wOrder.clickNewItemButton(), "Create New Item");
		logCompare(true, b2wOrder.addItem(sMaintenanceRequestDescription), "Add Item");
		logCompare(true, b2wOrder.generateItem(sMaintenanceProgramItemBDesc), "Generate Item");
		logCompare(true, b2wOrder.clickConfirmYes(), "Click Yes");
		logCompare(true, b2wOrder.clickAddNewItemFromWorkOrder(), "Add new item for work order");
		logCompare(true, b2wOrder.setAddItemDescription(sMaintenanceWorkOrderItemDescriptionA), "Add Item Description");
		logCompare(true, b2wOrder.setAddItemTypeFromDD(sCategoryC), "Type");
		logCompare(true, b2wOrder.setAddItemPriorityFromDD("Medium"), "Medium Priority");
		logCompare(true, b2wOrder.clickCreateAddItemButton(),"Create add Item");
		logCompare(true, b2wOrder.clickFinish(),"Click Finish");
		logCompare(true, b2wOrder.clickSaveButton(), "Click Save Button");
		logCompare(true, b2wOrder.selectWorkOrderByDescription(sMaintenanceWorkOrderDescription), "Select Work Order");
		logCompare(true, b2wOrder.clickApproveButton(), "Approve the Work Order");
		logCompare(true, b2wOrder.clickConfirmYes(), "Confirm Approve");
	}

	
}
