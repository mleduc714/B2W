package testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WReportHours;
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
	
	String sMaintenanceWorkOrderDescription;
	String sMaintenanceWorkOrderItemDescriptionA;
	String sMaintenanceWorkOrderItemDescriptionB;
	String sEmployeeFirstNameD, sEmployeeLastNameD, sEmployeeIDD, sEmployeeFullNameID;
	String sPlaceDescription, sPlaceID;
	String sMaintenanceTimeCardWorkDesc, sEquipmentDescD, sEquipmentIDD, sEquipmentID_Desc, sLaborRate;
	String sEndDate;

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
		int n = 3426;
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
		
/*		
		sMaintenanceWorkOrderDescription = "Engine Service3426 [1037]";
		sEmployeeFullNameID = "Benson Sherwood [ID703710]";
		sPlaceDescription = "Asphalt Plant6226";
		sEquipmentID_Desc = "1016 [ROLLER, VIB CLIP ON]";*/
		
	}
	public void testMain() throws Throwable {

		//scheduleToWorkOrder();
		//createTimeCard();
		addHoursToWorkOrder();
	}
	
	public void scheduleToWorkOrder(){
		//sMaintenanceWorkOrderDescription
		//sPlaceDescription
		//sEmployeeFullNameID
		
		assertTrue("open Maintain", b2wNav.openMaintain());
		logCompare(true, b2wMain.openSchedule(), "Open Schedule");
		logCompare(true, b2wSchd.clickWorkOrdersTab(), "Click Work Orders");
		assertTrue("Open Work Order",b2wSchd.openWorkOrderFromWorkOrderTabByDescription(sMaintenanceWorkOrderDescription));
		logCompare(true, b2wSchd.scheduleMaintainancePopupSelectWorkLocation(sPlaceDescription), "Work Location "+sPlaceDescription);
		logCompare(true, b2wSchd.scheduleMaintainancePopupSelectMechanic(sEmployeeFullNameID), "Select Mechanic "+sEmployeeFullNameID);
		logCompare(true, b2wSchd.scheduleMaintainancePopupSelectEvent("Down for Maintenance"), "Down for maintenance");
		logCompare(true, b2wSchd.scheduleMaintainancePopupSelectEndDate(sEndDate), "Set End Date");
		logCompare(true, b2wSchd.saveScheduleMaintenance(), "Save Schedule Maintenance");
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
		logCompare(true, b2wtimecards.clickAddTimeButton(), "Click Add Time Button");
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
		b2wtimecards.saveReportHours();

	}
	
	public void addHoursToWorkOrder() {
		assertTrue("open Maintain", b2wNav.openMaintain());
		assertTrue("Open Work Orders", b2wMain.openWorkOrders());
		TaskUtils.sleep(1000);
		b2wOrder.selectWorkOrderByDescription("Engine Service3829");
		TaskUtils.sleep(5000);
		b2wOrder.editWorkOrder();
		TaskUtils.sleep(2000);
		b2wOrder.getHeaderandExpandOrCollapse("Details", false);
		b2wOrder.getHeaderandExpandOrCollapse("Parts", true);
		//b2wOrder.clickAdd
		//TaskUtils.sleep(2000);
		//5 add item
		//6 add planned hours
		//7 report hours
		//8 parts
		
	}

}