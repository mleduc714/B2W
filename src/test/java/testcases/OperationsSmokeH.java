package testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddPartsToWorkItem;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WPlannedHours;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeH extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainTasks b2wMain = new B2WMaintainTasks();
	B2WMaintainScheduleTasks b2wSchd = new B2WMaintainScheduleTasks();
	B2WTimeCardTasks b2wtimecards = new B2WTimeCardTasks();
	B2WWorkOrdersTasks b2wOrder = new B2WWorkOrdersTasks();
	B2WReportHours b2wReport = new B2WReportHours();
	B2WAddPartsToWorkItem b2wAddParts = new B2WAddPartsToWorkItem();
	B2WPlannedHours b2wPlan = new B2WPlannedHours();
	B2WCompleteWorkOrder b2wComplete = new B2WCompleteWorkOrder();
	B2WScheduleMaintenance b2wSchMain = new B2WScheduleMaintenance();
	String sMaintenanceWorkOrderDescription;
	String sMaintenanceWorkOrderItemDescriptionA;
	String sMaintenanceWorkOrderItemDescriptionB;
	String sEmployeeFirstNameD, sEmployeeLastNameD, sEmployeeIDD, sEmployeeFullNameID;
	String sPlaceDescription, sPlaceID;
	String sMaintenanceTimeCardWorkDesc, sEquipmentDescD, sEquipmentIDD, sEquipmentID_Desc, sLaborRate;
	String sEndDate;
	String sPartA, sPartIDA, sPartB, sPartIDB, sPartC, sPartIDC;

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
		int n = 8093;
		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 3);
		
		sEndDate = format.format(cal.getTime());
		
		sLaborRate = getProperty("laborrateclass") + n;

		sEquipmentDescD = getProperty("equipmentD");
		sEquipmentIDD = getProperty("equipmentidD")+ n;
		sEquipmentID_Desc = sEquipmentIDD +" [" +sEquipmentDescD + "]";
		//sEquipmentDescD="Bobcat S175";
		//sEquipmentIDD="BCAT01";
		
		

		sMaintenanceWorkOrderDescription = getProperty("sMaintenanceWorkOrderDescription") + n;
		sMaintenanceWorkOrderItemDescriptionA=getProperty("sMaintenanceWorkOrderItemDescriptionA");
		sMaintenanceWorkOrderItemDescriptionB=getProperty("sMaintenanceWorkOrderItemDescriptionB");
		sEmployeeFirstNameD = getProperty("employeenameFirstD");
		sEmployeeLastNameD = getProperty("employeenameLastD");
		sEmployeeIDD = getProperty("employeenameDID") +n;
		sEmployeeFullNameID = sEmployeeFirstNameD + " "+sEmployeeLastNameD + " ["+sEmployeeIDD+"]";
		sPlaceDescription = getProperty("placeD") + n;
		sPlaceID = getProperty("placeIDD") + n;
		sMaintenanceTimeCardWorkDesc = getProperty("sMaintenanceTimeCardWorkDesc");
		sPartA = getProperty("partA");
		sPartIDA = getProperty("partIDA") + n;
		sPartB = getProperty("partB");
		sPartIDB = getProperty("partIDB") + n;
		sPartC = getProperty("partC");
		sPartIDC = getProperty("partIDC") + n;
		
		sMaintenanceWorkOrderDescription = "PREP AND PAINT [1009]";
		sEmployeeFullNameID = "Victoria McGrath [13062]";
		sPlaceDescription = "Calefs Corner4442";
		sEquipmentID_Desc = "1016 [ROLLER, VIB CLIP ON]";
		
	}
	public void testMain() throws Throwable {

		scheduleToWorkOrder();
		//createTimeCard();
		//addHoursToWorkOrder();
		//submitTimeCardCompleteWorkItem();
	}
	
	public void scheduleToWorkOrder(){
		//sMaintenanceWorkOrderDescription
		//sPlaceDescription
		//sEmployeeFullNameID
		//*[@id="work_order_edit_view"]/div[3]/div[1]
		assertTrue("open Maintain", b2wNav.openMaintain());
		logCompare(true, b2wMain.openSchedule(), "Open Schedule");
		logCompare(true, b2wSchd.clickWorkOrdersTab(), "Click Work Orders");
		assertTrue("Open Work Order",b2wSchd.openWorkOrderFromWorkOrderTabByDescription(sMaintenanceWorkOrderDescription));
		logCompare(true, b2wSchMain.scheduleMaintainancePopupSelectMechanic(sEmployeeFullNameID), "Select Mechanic "+sEmployeeFullNameID);
		TaskUtils.sleep(500);
		logCompare(true, b2wSchMain.scheduleMaintainancePopupSelectEvent("Down for Maintenance"), "Down for maintenance");
		logCompare(true, b2wSchMain.scheduleMaintainancePopupSelectEndDate(sEndDate), "Set End Date");
		logCompare(true, b2wSchMain.scheduleMaintainancePopupSelectWorkLocation(sPlaceDescription), "Work Location "+sPlaceDescription);
		logCompare(false,true, "TEST IMAGE");
		//logCompare(true, b2wSchMain.saveScheduleMaintenance(), "Save Schedule Maintenance");
	}
	
	public void createTimeCard() {

		assertTrue("open Maintain", b2wNav.openMaintain());

		logCompare(true, b2wMain.openTimeCards(), "Open Time Cards");
		logCompare(true, b2wtimecards.clickCreateNewTimeCard(), "Create new Time Card");
		logCompare(true, b2wReport.selectEmployee(sEmployeeFullNameID), "Select Employee");
		TaskUtils.sleep(1000);
		logCompare(true, b2wtimecards.clickAddTimeButton(), "Click Add Time Button");
		TaskUtils.sleep(1000);
		logCompare(true, b2wReport.selectTypeofHoursEquipment(), "Select Type of Hours Equipment");
		TaskUtils.sleep(1000);
		//logCompare(true, b2wtimecards.selectChargeToEquipment(), "Select Charge Equipment");
		logCompare(true, b2wReport.setEquipmentHoursDescription(sMaintenanceTimeCardWorkDesc), "Set Description ");
		logCompare(true, b2wReport.setEquipmentUsed(sEquipmentID_Desc), "Set Equipment Used");
		logCompare(true, b2wReport.selectWorkOrder(sMaintenanceWorkOrderDescription), "Select Work Order");
		logCompare(true, b2wReport.selectWorkOrderItem(sMaintenanceWorkOrderItemDescriptionA), "Select Work Order Item");
	
		logCompare(true, b2wReport.setRegularMins("30"), "Change Oil");
		logCompare(true, b2wReport.selectEquipmentRateClass("Standard"), "Select Labor Rate");
		b2wtimecards.saveReportHours();
		TaskUtils.sleep(500);
		b2wtimecards.selectTimeCardByEmployeeName(sEmployeeFullNameID);
		b2wtimecards.clickReportEquipmentHoursButton();
		TaskUtils.sleep(1000);
		logCompare(true, b2wReport.selectTypeofHoursEquipment(), "Select Type of Hours Equipment");
		TaskUtils.sleep(1000);
		//logCompare(true, b2wtimecards.selectChargeToEquipment(), "Select Charge Equipment");
		logCompare(true, b2wReport.setEquipmentHoursDescription(sMaintenanceTimeCardWorkDesc), "Set Description ");
		logCompare(true, b2wReport.setEquipmentUsed(sEquipmentID_Desc), "Set Equipment Used");
		logCompare(true, b2wReport.selectWorkOrder(sMaintenanceWorkOrderDescription), "Select Work Order");
		logCompare(true, b2wReport.selectWorkOrderItem(sMaintenanceWorkOrderItemDescriptionB), "Select Work Order Item");
		logCompare(true, b2wReport.setRegularHours("1"), "Broken Track 1 hr");
		logCompare(true, b2wReport.setRegularMins("30"), "Broken Track");
		logCompare(true, b2wReport.selectEquipmentRateClass("Standard"), "Select Labor Rate");
		logCompare(true, b2wtimecards.saveReportHours(), "Save Report Hours");

	}
	
	public void addHoursToWorkOrder() {
		assertTrue("open Maintain", b2wNav.openMaintain());
		assertTrue("Open Work Orders", b2wMain.openWorkOrders());
		TaskUtils.sleep(1000);
		logCompare(true,b2wOrder.selectWorkOrderByDescription("REPAIR VIBRATOR"), "Select Work Order");
		logCompare(true,b2wOrder.editWorkOrder(), "Edit Work Order");
		TaskUtils.sleep(1000);
		logCompare(true,b2wOrder.collapseDetails(), "Collapse Details");
		logCompare(true,b2wOrder.expandParts(), "Expand Parts");
		logCompare(true,b2wOrder.clickAddParts(), "Add Parts");
		logCompare(true,b2wAddParts.selectPartToAddToWorkItemByID(sPartIDA), "Select Part");
		logCompare(true,b2wAddParts.selectPartToAddToWorkItemByID(sPartIDB), "Select Part");
		logCompare(true,b2wAddParts.selectPartToAddToWorkItemByID(sPartIDC), "Select Part");
		logCompare(true,b2wAddParts.partsNext(), "Next Page");
		logCompare(true,b2wAddParts.setEstimatedQty(sPartA, "5"), "QTY Est A");
		logCompare(true,b2wAddParts.setReportedQty(sPartA,"7"), "QTY Rpt A");
		logCompare(true,b2wAddParts.setEstimatedQty(sPartB, "5"), "QTY Est B");
		logCompare(true,b2wAddParts.setReportedQty(sPartB,"5"), "QTY Rpt B");
		logCompare(true,b2wAddParts.setEstimatedQty(sPartC, "4"), "QTY Est C");
		logCompare(true,b2wAddParts.setReportedQty(sPartC,"3"), "QTY Est C");
		logCompare(true,b2wAddParts.saveParts(), "Save Parts");
		logCompare(true,b2wOrder.collapseParts(), "Collapse Parts");
		logCompare(true,b2wOrder.expandHours(), "Expand Hours");
		logCompare(true,b2wOrder.clickAddPlannedHours(), "Add Planned Hours");
		logCompare(true,b2wPlan.setDescription("Planned Hours"), "Set Desc");
		logCompare(true,b2wPlan.setLaborType("Laborer"), "Set Labor Type");
		logCompare(true,b2wPlan.setPlannedHours("1"), "Set Planned Hours");
		logCompare(true,b2wPlan.savePlannedHours(), "Saved Planned Hours");
		logCompare(true,b2wOrder.saveEditWorkOrder(), "Save ");
		
	}
	
	
	public void submitTimeCardCompleteWorkItem() {
		logCompare(true, b2wtimecards.selectEmployee(sEmployeeFullNameID), "Select Employee");
		logCompare(true, b2wtimecards.submitTimeCard(),"Submit Time Card");
		logCompare(true, b2wtimecards.clickConfirmYes(), "Confirm Yes");
		logCompare(true, b2wtimecards.submitApproved(), "Approve");
		logCompare(true, b2wtimecards.clickConfirmYes(), "Confirm");
		assertTrue("Open Work Orders", b2wMain.openWorkOrders());
		TaskUtils.sleep(1000);
		logCompare(true, b2wOrder.selectWorkOrderByDescription(sMaintenanceWorkOrderDescription), "Select Work Order");
		logCompare(true, b2wOrder.clickComplete(), "Complete");
		//b2wComplete.setReadingAtCompletion("Hours Meter", "120");
		logCompare(true, b2wComplete.clickNextPage(), "next page");
		logCompare(true, b2wComplete.completeSave(),"Complete Save");
		//b2wtimecards.
	}

}
