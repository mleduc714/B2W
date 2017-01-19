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

public class B2WTimeCardSmokeTest extends B2WTestCase {
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
	
	String sEmployeeFirstName,sEmployeeLastName,sEmployeeID,sEmployeeLaborType,sEmployeeLaborTypeClass,sEmployeeChargeTo,
	sEmployeeEquipment, sEmployeeWorkOrder, sEmployeeWorkItem,sEmployeeEquipmentLaborType,
	sEmployeeHourDescriptionA, sEmployeeHourDescriptionB, sEmployeeHourDescriptionC,
	sEmployeeRegularHoursA,sEmployeeRegularMinsA,sEmployeeOvertimeHoursA,sEmployeeOvertimeMinsA,
	sEmployeeRegularHoursB,sEmployeeRegularMinsB,sEmployeeOvertimeHoursB,sEmployeeOvertimeMinsB,
	sEmployeeRegularHoursC,sEmployeeRegularMinsC,sEmployeeOvertimeHoursC,sEmployeeOvertimeMinsC,
	sEmployeeChargeToJob,sEmployeeChargeToLaborRateClass,sEmployeeChargeToLaborType,
	sEmployeeOverheadAccount,sEmployeeOverheadLaborRateClass,sEmployeeOverheadLaborType;
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		
		sEmployeeID = getProperty("sEmployeeID");
		sEmployeeFirstName = getProperty("sEmployeeFirstName");
		sEmployeeLastName = getProperty("sEmployeeLastName");
		sEmployeeHourDescriptionA = getProperty("sEmployeeHourDescriptionA");
		sEmployeeHourDescriptionB = getProperty("sEmployeeHourDescriptionB");
		sEmployeeHourDescriptionC = getProperty("sEmployeeHourDescriptionC");
		sEmployeeRegularHoursA = getProperty("sEmployeeRegularHoursA");
		sEmployeeRegularMinsA = getProperty("sEmployeeRegularMinsA");
		sEmployeeOvertimeHoursA = getProperty("sEmployeeOvertimeHoursA");
		sEmployeeOvertimeMinsA = getProperty("sEmployeeOvertimeMinsA");
		sEmployeeRegularHoursB = getProperty("sEmployeeRegularHoursB");
		sEmployeeRegularMinsB = getProperty("sEmployeeRegularMinsB");
		sEmployeeOvertimeHoursB = getProperty("sEmployeeOvertimeHoursB");
		sEmployeeOvertimeMinsB = getProperty("sEmployeeOvertimeMinsB");
		sEmployeeRegularHoursC = getProperty("sEmployeeRegularHoursC");
		sEmployeeRegularMinsC = getProperty("sEmployeeRegularMinsC");
		sEmployeeOvertimeHoursC = getProperty("sEmployeeOvertimeHoursC");
		sEmployeeOvertimeMinsC = getProperty("sEmployeeOvertimeMinsC");
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
		return "mleduc";
	}

	@Override
	public String getTestDescription() {
		// enter the description for the testcase
		return "Testcase description";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/timecards";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		
/*		Create a New Time Card - For all options listed below
		•Type of Hours - Employee Hours
		•Type of Hours - Equipment Hours
		•Charge to Equipment
		•Charge to Job/Tracking Account
		•Charge to Overhead Account

		•Verify tool tip information and links for Charge To items•Edit Equipment, Employee or Job Hours - validated tool tip is updated with correct reported hours
		•Link out to Work Order and validated reported hours are updated on WO

		•Submit Time Card - Verify Time Card History
		•Approve Time Card - Verify Time Card History
		•Reject Time Card - Verify Time Card History
		•Attempt to Submit a New Time Card with 0 hrs - 'Cannot Submit.  You cannot submit a time card that has no hours reported on it.'
		•Export Time Card (using Standard Mechanic export)
		•Explore Filtering by Business Unit, Employee and Status and Start and End Date
		•Explore Sorting list
		•Security Permissions
		•Navigation options to Time Cards page*/
		
		logCompare(true,b2wNav.openMaintain(),"Open Maintain");
		logCompare(true,b2wMaintain.openTimeCards(),"Open Time Cards");
		//System.out.println(b2wtimecards.getTotalHours());
		employeeHoursChargeToEquipment();
		//employeeHoursChargeToOverheadAccount();
	}

	
	public void createEmployee() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstName), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastName), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeID), "Set Employee ID");
		logCompare(true, b2wEmp.setDriverCheckBox(true), "Set Driver Checkbox");
		logCompare(true, b2wEmp.setPurchaseOrderApproverCheckBox(true), "Approver");
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");

	}
	
	public void employeeHoursChargeToJob() {

		logCompare(true,b2wtimecards.clickReportEmployeeHoursButton(), "Employee Hours");
		b2wReport.selectTypeofHoursEmployee();
		logCompare(true,b2wReport.selectChargeToJob(),"Change Account");
		sEmployeeChargeToJob = b2wReport.selectAnyJob();
		//b2wReport.selectEmployeeHoursAnyJobTrackingAccount();
		b2wReport.setEmployeeWorkHoursDescription(sEmployeeHourDescriptionA);
		sEmployeeChargeToLaborRateClass = b2wReport.selectEmployeeAnyLaborRateClass();
		sEmployeeChargeToLaborType = b2wReport.selectEmployeeAnyLaborType();
		b2wReport.setEmployeeRegularHours(sEmployeeRegularHoursA);
		b2wReport.setEmployeeRegularMins(sEmployeeRegularMinsA);
		b2wReport.setEmployeeOvertimeHours(sEmployeeOvertimeHoursA);
		b2wReport.setEmployeeOvertimeMins(sEmployeeOvertimeMinsA);
		//b2wReport.saveReportedHours();
		TaskUtils.sleep(5000);
	}
	
	public void employeeHoursChargeToOverheadAccount() {
		logCompare(true,b2wtimecards.clickReportEmployeeHoursButton(), "Employee Hours");
		b2wReport.selectTypeofHoursEmployee();
		logCompare(true,b2wReport.selectChargeToOverheadAccount(),"Change Account");
		sEmployeeOverheadAccount = b2wReport.selectAnyOverheadAccount();
		b2wReport.setEmployeeWorkHoursDescription(sEmployeeHourDescriptionB);
		sEmployeeOverheadLaborRateClass = b2wReport.selectEmployeeAnyLaborRateClass();
		sEmployeeOverheadLaborType = b2wReport.selectEmployeeAnyLaborType();
		b2wReport.setEmployeeRegularHours(sEmployeeRegularHoursB);
		b2wReport.setEmployeeRegularMins(sEmployeeRegularMinsB);
		b2wReport.setEmployeeOvertimeHours(sEmployeeOvertimeHoursB);
		b2wReport.setEmployeeOvertimeMins(sEmployeeOvertimeMinsB);
		b2wReport.saveReportedHours();
		TaskUtils.sleep(5000);
	}
	
	public void employeeHoursChargeToEquipment() {
		
		logCompare(true,b2wtimecards.clickReportEmployeeHoursButton(), "Employee Hours");
		b2wReport.selectTypeofHoursEmployee();
		logCompare(true,b2wReport.selectChargeToEquipment(),"Change Equipment");
		//b2wReport.selectEmployeeHoursAnyJobTrackingAccount();
		sEmployeeEquipment = b2wReport.selectEmployeeAnyEquipment();
		sEmployeeWorkOrder = b2wReport.selectEmployeeAnyWorkOrder();
		sEmployeeWorkItem = b2wReport.selectEmployeeAnyWorkOrderItem();
		b2wReport.setEmployeeWorkHoursDescription(sEmployeeHourDescriptionC);
		sEmployeeEquipmentLaborType = b2wReport.selectEmployeeAnyLaborType();
		b2wReport.setEmployeeRegularHours(sEmployeeRegularHoursC);
		b2wReport.setEmployeeRegularMins(sEmployeeRegularMinsC);
		b2wReport.setEmployeeOvertimeHours(sEmployeeOvertimeHoursC);
		b2wReport.setEmployeeOvertimeMins(sEmployeeOvertimeMinsC);
		//b2wReport.saveReportedHours();
		TaskUtils.sleep(5000);
	
		
	}
	
	public void equipmentHours() {
		
		//b2wReport.setEquipmentHoursDescription(sText)
	
	}
	
	
}
