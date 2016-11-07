package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeH extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainTasks b2wMain = new B2WMaintainTasks();
	B2WMaintainScheduleTasks b2wSchd = new B2WMaintainScheduleTasks();
	B2WTimeCardTasks b2wtimecards = new B2WTimeCardTasks();
	
	String sMaintenanceWorkOrderDescription;
	String sEmployeeFirstNameD, sEmployeeLastNameD, sEmployeeIDD, sEmployeeFullNameID;
	String sPlaceDescription, sPlaceID;
	String sMaintenanceTimeCardWorkDesc, sEquipmentDescD, sEquipmentIDD, sEquipmentID_Desc, sLaborRate;

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
		
		
		sLaborRate = getProperty("laborrateclass") + n;

		sEquipmentDescD = getProperty("equipmentD");
		sEquipmentIDD = getProperty("equipmentidD")+ n;
		sEquipmentID_Desc = sEquipmentIDD +" [" +sEquipmentDescD + "]";
		//sEquipmentDescD="Bobcat S175";
		//sEquipmentIDD="BCAT01";
		
		

		sMaintenanceWorkOrderDescription = getProperty("sMaintenanceWorkOrderDescription") + n;
		sEmployeeFirstNameD = getProperty("employeenameFirstD");
		sEmployeeLastNameD = getProperty("employeenameLastD");
		sEmployeeIDD = getProperty("employeenameDID") +n;
		sEmployeeFullNameID = sEmployeeFirstNameD + " "+sEmployeeLastNameD + " ["+sEmployeeIDD+"]";
		sPlaceDescription = getProperty("placeD") + n;
		sPlaceID = getProperty("placeIDD") + n;
		sMaintenanceTimeCardWorkDesc = getProperty("sMaintenanceTimeCardWorkDesc");
	}
	public void testMain() throws Throwable {

		scheduleToWorkOrder();
		createTimeCard();
	}
	
	public void scheduleToWorkOrder(){
		assertTrue("open Maintain", b2wNav.openMaintain());
		logCompare(true, b2wMain.openSchedule(), "Open Schedule");
		logCompare(true, b2wSchd.clickWorkOrdersTab(), "Click Work Orders");
		logCompare(true, b2wSchd.openWorkOrderFromWorkOrderTabByDescription(sMaintenanceWorkOrderDescription), "Open Work Order Tab by Desc");
		logCompare(true, b2wSchd.scheduleMaintainancePopupSelectWorkLocation(sPlaceDescription), "Work Location "+sPlaceDescription);
		logCompare(true, b2wSchd.scheduleMaintainancePopupSelectMechanic(sEmployeeFullNameID), "Select Mechanic "+sEmployeeFullNameID);
		logCompare(true, b2wSchd.scheduleMaintainancePopupSelectEvent("Down for Maintenance"), "Down for maintenance");
		logCompare(true, b2wSchd.saveScheduleMaintenance(), "Save Schedule Maintenance");
	}
	
	public void createTimeCard() {
		logCompare(true, b2wNav.openMaintain(), "Open Maintain");
		logCompare(true, b2wMain.openTimeCards(), "Open Time Cards");
		logCompare(true,b2wtimecards.clickCreateNewTimeCard(), "Create new Time Card");
		logCompare(true, b2wtimecards.selectEmployee(sEmployeeFullNameID), "Select Employee");
		TaskUtils.sleep(1000);
		b2wtimecards.clickAddTimeButton();
		TaskUtils.sleep(1000);
		b2wtimecards.selectTypeofHoursEquipment();
		b2wtimecards.selectChargeToEquipment();
		b2wtimecards.setEquipmentHoursDescription(sMaintenanceTimeCardWorkDesc);
		b2wtimecards.setEquipmentUsed(sEquipmentID_Desc);
		b2wtimecards.selectWorkOrder(sMaintenanceWorkOrderDescription);
		b2wtimecards.selectWorkOrderItem(0);
		b2wtimecards.selectEquipmentRateClass(sLaborRate);
		b2wtimecards.setRegularMins("5");
		b2wtimecards.saveReportHours();
		b2wtimecards.selectTimeCardByEmployeeName(sEmployeeFullNameID);
		b2wtimecards.clickReportEquipmentHoursButton();
		
	}

}
