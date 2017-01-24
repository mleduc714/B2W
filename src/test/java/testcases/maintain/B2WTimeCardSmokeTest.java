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
import tasks.dialogs.B2WReportedHoursToolTip;
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
	B2WReportedHoursToolTip hoursToolTip = new B2WReportedHoursToolTip();
	
	String sEmployeeFirstName,sEmployeeLastName,sEmployeeID,sEmployeeLaborType,sEmployeeLaborTypeClass,sEmployeeChargeTo,
	sEmployeeEquipment, sEmployeeWorkOrder, sEmployeeWorkItem,sEmployeeEquipmentLaborType,
	sEmployeeHourDescriptionA, sEmployeeHourDescriptionB, sEmployeeHourDescriptionC,
	sEmployeeRegularHoursA,sEmployeeRegularMinsA,sEmployeeOvertimeHoursA,sEmployeeOvertimeMinsA,
	sEmployeeRegularHoursB,sEmployeeRegularMinsB,sEmployeeOvertimeHoursB,sEmployeeOvertimeMinsB,
	sEmployeeRegularHoursC,sEmployeeRegularMinsC,sEmployeeOvertimeHoursC,sEmployeeOvertimeMinsC,
	sEmployeeChargeToJob,sEmployeeChargeToLaborRateClass,sEmployeeChargeToLaborType,
	sEmployeeOverheadAccount,sEmployeeOverheadLaborRateClass,sEmployeeOverheadLaborType,sEmployee, sEquipment, sEquipmentID, sEquipmentBU,
	sEmployeeHourDescriptionD, sEquipmentWorkOrder, sEquipmentWorkItem, sEquipmentWorkLaborClass, sEquipmentRegularHoursC,sEquipmentRegularMinsC,
	sEquipmentNameID, sEquipmentNameID2,sEmployeeLaborTypeA, sEmployeeLaborTypeB, sEmployeeLaborTypeC;
	int iRandom = 0;
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		iRandom = getRandomNumber();
		sEmployeeID = Integer.toString(iRandom);
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
		sEmployeeHourDescriptionD = getProperty("sEmployeeHourDescriptionD");
		sEquipmentRegularHoursC = getProperty("sEquipmentRegularHoursC");
		sEquipmentRegularMinsC = getProperty("sEquipmentRegularMinsC");
		sEmployeeLaborTypeA = getProperty("sEmployeeLaborTypeA");
		sEmployeeLaborTypeB = getProperty("sEmployeeLaborTypeB");
		sEmployeeLaborTypeC = getProperty("sEmployeeLaborTypeC");
		
		
		sEquipment = getProperty("sEquipment");
		sEquipmentID = getProperty("sEquipmentID")+iRandom;
		sEquipmentBU = getProperty("sEquipmentBU");
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
		return "Timecard smoke test";
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
	
		div.b2w-icon2.i130-jobs
		div.b2w-icon2.i123-equipment
		div.b2w-icon2.i137-overhead-accts
		div.b2w-icon2.i123-equipment
		
	
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
		sEmployee = this.sEmployeeFirstName+ " "+this.sEmployeeLastName + " ["+ this.sEmployeeID+ "]";
		sEquipmentNameID = this.sEquipmentID+ " " + "[" + this.sEquipment + "]";
		sEquipmentNameID2 = this.sEquipment+ " " + "[" + this.sEquipmentID + "]";

		createEmployee();
		createEquipment();
		createTimeCard();
		employeeHoursChargeToJob();
		employeeHoursChargeToEquipment();
		employeeHoursChargeToOverheadAccount();
		equipmentHours();
		submittimecards();
	}
	
	public void createEquipment() {
		b2wNav.openMaintain();
		assertTrue("Open Equipment",b2wMaintain.openEquipment());
		
		assertTrue("Create New Equipment",b2wE.createNewEquipment());
		assertTrue("Create Equipment ",b2wE.createEquipment(sEquipment, sEquipmentID, sEquipmentBU));
		
	}
	
	public void createEmployee() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstName), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastName), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeID), "Set Employee ID");
		logCompare(true, b2wEmp.setDriverCheckBox(true), "Set Driver Checkbox");
		logCompare(true, b2wEmp.setPurchaseOrderApproverCheckBox(true), "Approver");
		logCompare(true, b2wEmp.setMechanicCheckBox(true), "Mechanic");
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");

	}
	
	public void createTimeCard() {
		logCompare(true,b2wNav.openMaintain(),"Open Maintain");
		logCompare(true,b2wMaintain.openTimeCards(),"Open Time Cards");
		logCompare(true,b2wtimecards.clickCreateNewTimeCard(), "Create New Card");
		logCompare(true,b2wReport.selectEmployee(sEmployee), "Select "+sEmployee);
		logCompare(true,b2wReport.saveReportedHours(), "Save Reported Hours");
	}
	
	public void employeeHoursChargeToJob() {
		

		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		logCompare(true,b2wtimecards.clickReportEmployeeHoursButton(), "Employee Hours");
		logCompare(true,b2wReport.selectTypeofHoursEmployee(), "Select Type Hours");
		logCompare(true,b2wReport.selectChargeToJob(),"Change Account");
		sEmployeeChargeToJob = b2wReport.selectAnyJob();
		logCompare(true,b2wReport.setEmployeeWorkHoursDescription(sEmployeeHourDescriptionA),"Employee Desc");
		sEmployeeChargeToLaborRateClass = b2wReport.selectEmployeeAnyLaborRateClass();
		logCompare(true,b2wReport.selectEmployeeLaborType(sEmployeeLaborTypeA), "Labor Type A");
		b2wReport.setEmployeeRegularHours(sEmployeeRegularHoursA);
		b2wReport.setEmployeeRegularMins(sEmployeeRegularMinsA);
		b2wReport.setEmployeeOvertimeHours(sEmployeeOvertimeHoursA);
		b2wReport.setEmployeeOvertimeMins(sEmployeeOvertimeMinsA);
		b2wReport.saveReportedHours();
		String sHours = "Charge\n"+sEmployeeRegularHoursA+":"+sEmployeeRegularMinsA + " RT, "+this.sEmployeeOvertimeHoursA+":"+this.sEmployeeOvertimeMinsA+ " OT\n"+
		"on job "+sEmployeeChargeToJob;
		sEmployeeChargeToLaborRateClass = sEmployeeChargeToLaborRateClass.substring(0, sEmployeeChargeToLaborRateClass.indexOf("[")).trim();
		logCompare(true,b2wtimecards.getEmployeeLaborTypes().contains(sEmployeeLaborTypeA),"Verify Employee Labor Type "+sEmployeeLaborTypeA);
		logCompare(true,b2wtimecards.getEmployeeLaborRateClass().contains(sEmployeeChargeToLaborRateClass), "Employee Labor Rate Class "+sEmployeeChargeToLaborRateClass);
		logCompare(true,b2wtimecards.getEmployeeChargeTo().contains(sEmployeeChargeToJob), "Employee Charge to Job "+sEmployeeChargeToJob);
		logCompare(sEmployeeRegularHoursA+":"+sEmployeeRegularMinsA + " RT", b2wtimecards.getEmployeeRegularHoursByRow(0), "Verify Regular Hours");
		logCompare(this.sEmployeeOvertimeHoursA+":"+this.sEmployeeOvertimeMinsA+ " OT",b2wtimecards.getEmployeeOvertimeHoursByRow(0), "Verify Overtime Hours");
		b2wtimecards.clickEmployeeIconByRow(0);
		logCompare(sEmployeeHourDescriptionA,hoursToolTip.getTitle(), "Title of Tool Tip");
		logCompare(sEmployeeLaborTypeA + " with labor rate class of "+sEmployeeChargeToLaborRateClass, hoursToolTip.getLaborTypeAndLaborRateClassText(), "Labor Rate and Type");
		logCompare(sHours, hoursToolTip.getChargeToText(), "Verify Charge To text");
	}
	
	public void employeeHoursChargeToOverheadAccount() {
		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		logCompare(true,b2wtimecards.clickReportEmployeeHoursButton(), "Employee Hours");
		b2wReport.selectTypeofHoursEmployee();
		logCompare(true,b2wReport.selectChargeToOverheadAccount(),"Change Account");
		sEmployeeOverheadAccount = b2wReport.selectAnyOverheadAccount();
		b2wReport.setEmployeeWorkHoursDescription(sEmployeeHourDescriptionB);
		sEmployeeOverheadLaborRateClass = b2wReport.selectEmployeeAnyLaborRateClass();
		logCompare(true,b2wReport.selectEmployeeLaborType(sEmployeeLaborTypeB), "Labor Type B");
		b2wReport.setEmployeeRegularHours(sEmployeeRegularHoursB);
		b2wReport.setEmployeeRegularMins(sEmployeeRegularMinsB);
		b2wReport.setEmployeeOvertimeHours(sEmployeeOvertimeHoursB);
		b2wReport.setEmployeeOvertimeMins(sEmployeeOvertimeMinsB);
		b2wReport.saveReportedHours();
		sEmployeeOverheadLaborRateClass = sEmployeeOverheadLaborRateClass.substring(0, sEmployeeOverheadLaborRateClass.indexOf("[")).trim();
		String sHours = "Charge\n"+sEmployeeRegularHoursB+":"+sEmployeeRegularMinsB + " RT, "+this.sEmployeeOvertimeHoursB+":"+this.sEmployeeOvertimeMinsB+ " OT\n"+
				"to "+sEmployeeOverheadAccount + " overhead account";
		logCompare(true,b2wtimecards.getEmployeeLaborTypes().contains(sEmployeeLaborTypeB),"Verify Employee Labor Type "+sEmployeeLaborTypeB);
		logCompare(true,b2wtimecards.getEmployeeLaborRateClass().contains(sEmployeeOverheadLaborRateClass), "Employee Labor Rate Class "+sEmployeeOverheadLaborRateClass);
		logCompare(true,b2wtimecards.getEmployeeChargeTo().contains(sEmployeeOverheadAccount), "Employee Charge to Job "+sEmployeeOverheadAccount);
		logCompare(sEmployeeRegularHoursB+":"+sEmployeeRegularMinsB + " RT", b2wtimecards.getEmployeeRegularHoursByRow(2), "Verify Regular Hours");
		logCompare(this.sEmployeeOvertimeHoursB+":"+this.sEmployeeOvertimeMinsB+ " OT",b2wtimecards.getEmployeeOvertimeHoursByRow(2), "Verify Overtime Hours");
		b2wtimecards.clickEmployeeIconByRow(2);
		logCompare(sEmployeeHourDescriptionB,hoursToolTip.getTitle(), "Title of Tool Tip");
		logCompare(sEmployeeLaborTypeB + " with labor rate class of "+sEmployeeOverheadLaborRateClass, hoursToolTip.getLaborTypeAndLaborRateClassText(), "Labor Rate and Type");
		logCompare(sHours, hoursToolTip.getChargeToText(), "Verify Charge To text");

	}
	
	public void employeeHoursChargeToEquipment() {
		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		logCompare(true,b2wtimecards.clickReportEmployeeHoursButton(), "Employee Hours");
		b2wReport.selectTypeofHoursEmployee();
		logCompare(true,b2wReport.selectChargeToEquipment(),"Change Equipment");
		//b2wReport.selectEmployeeHoursAnyJobTrackingAccount();
		sEmployeeEquipment = b2wReport.selectEmployeeAnyEquipment();
		sEmployeeWorkOrder = b2wReport.selectEmployeeAnyWorkOrder();
		sEmployeeWorkItem = b2wReport.selectEmployeeAnyWorkOrderItem();
		logCompare(true,b2wReport.setEmployeeWorkHoursDescription(sEmployeeHourDescriptionC), "Employee Work Hours Description");
		logCompare(true,b2wReport.selectEmployeeLaborType(sEmployeeLaborTypeC), "Labor Type C");
		b2wReport.setEmployeeRegularHours(sEmployeeRegularHoursC);
		b2wReport.setEmployeeRegularMins(sEmployeeRegularMinsC);
		b2wReport.setEmployeeOvertimeHours(sEmployeeOvertimeHoursC);
		b2wReport.setEmployeeOvertimeMins(sEmployeeOvertimeMinsC);
		b2wReport.saveReportedHours();
		
		logCompare(true,b2wtimecards.getEmployeeLaborTypes().contains(sEmployeeLaborTypeC),"Verify Employee Labor Type "+sEmployeeLaborTypeC);
		//logCompare(true,b2wtimecards.getEmployeeChargeTo().contains(sEmployeeWorkOrder), "Employee Charge to Work Order "+sEmployeeWorkOrder);
		logCompare(sEmployeeRegularHoursC+":"+sEmployeeRegularMinsC + " RT", b2wtimecards.getEmployeeRegularHoursByRow(1), "Verify Regular Hours");
		logCompare(this.sEmployeeOvertimeHoursC+":"+this.sEmployeeOvertimeMinsC+ " OT",b2wtimecards.getEmployeeOvertimeHoursByRow(1), "Verify Overtime Hours");
		b2wtimecards.clickEmployeeIconByRow(1);
		logCompare(sEmployeeHourDescriptionC,hoursToolTip.getTitle(), "Title of Tool Tip");
		logCompare(true,this.hoursToolTip.clickOnEquipment(), "Open Equipment");
		logCompare(sEmployeeEquipment,b2wE.getEquipmentHeadline(), "Equipment Match");
		logCompare(true,b2wMaintain.openTimeCards(), "Go Back to TimeCards");
		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		b2wtimecards.clickEmployeeIconByRow(1);
		logCompare(true,this.hoursToolTip.clickOnWorkOrder(), "Open Work Order");
		logCompare(sEmployeeWorkOrder,b2wWork.getWorkOrderHeadline(), "Work Order Match");
		logCompare(true,b2wMaintain.openTimeCards(), "Go Back to TimeCards");
		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		
	}
	
	public void equipmentHours() {
		
		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		b2wtimecards.clickReportEquipmentHoursButton();
		logCompare(true,b2wReport.setEquipmentHoursDescription(this.sEmployeeHourDescriptionD), "Employee Desc");
		logCompare(true,b2wReport.setEquipmentUsed(sEquipmentNameID), "Set Auto Equipment");
		sEquipmentWorkOrder = b2wReport.selectEquipmentAnyWorkOrder();
		sEquipmentWorkItem = b2wReport.selectEquipmentAnyWorkOrderItem();
		sEquipmentWorkLaborClass = b2wReport.selectEquipmentAnyRateClass();
		logCompare(true,b2wReport.setEquipmentRegularHours(sEquipmentRegularHoursC), "Equipment Hours");
		logCompare(true,b2wReport.setEquipmentRegularMins(sEquipmentRegularMinsC), "Equipment Mins");
		logCompare(true,b2wReport.saveReportedHours(), "Reported Hours");
		logCompare(true,b2wtimecards.getEquipmentUsed().contains(sEquipmentNameID2), "Verify "+sEquipment);
		logCompare(true,b2wtimecards.getEquipmentRateClass().contains(sEquipmentWorkLaborClass), "Verify "+sEquipmentWorkLaborClass);
		logCompare(sEquipmentRegularHoursC+":"+sEquipmentRegularMinsC + " RT", b2wtimecards.getEquipmentRegularHoursByRow(0), "Verify Equipment Hours");
		b2wtimecards.clickEquipmentIconByRow(0);
		TaskUtils.sleep(1000);
		logCompare(sEmployeeHourDescriptionD,hoursToolTip.getTitle(), "Title of Tool Tip");
		String sEquipmentLinkText = hoursToolTip.getEquipmentLinkText();
		logCompare(true,this.hoursToolTip.clickOnEquipment(), "Open Equipment");
		logCompare(sEquipmentLinkText,b2wE.getEquipmentHeadline(), "Equipment Match");
		logCompare(true,b2wMaintain.openTimeCards(), "Go Back to TimeCards");
		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		b2wtimecards.clickEquipmentIconByRow(0);
		logCompare(true, this.hoursToolTip.clickOnWorkOrder(), "Open Work Order");
		logCompare(sEquipmentWorkOrder,b2wWork.getWorkOrderHeadline(), "Work Order Match");
		logCompare(true,b2wMaintain.openTimeCards(), "Go Back to TimeCards");
		logCompare(true,b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		
	}
	
	public void submittimecards() {
		
		assertTrue("open Maintain", b2wNav.openMaintain());
		logCompare(true, b2wMaintain.openTimeCards(), "Open Time Cards");
		logCompare(true, b2wtimecards.selectEmployee(sEmployee), "Select Employee");
		logCompare(true, b2wtimecards.submitTimeCard(),"Submit Time Card");
		logCompare(true, b2wtimecards.setComments("Submitted Time Card"), "Time Cards");
		logCompare(true, b2wtimecards.clickConfirmYes(), "Confirm Yes");
		logCompare("Submitted Time Card",b2wtimecards.getTimeCardNotes().get(0), "Status");
		logCompare("Submitted",b2wtimecards.getTimeCardHistoryStatus().get(0), "Status");
		logCompare(true, b2wtimecards.submitApproved(), "Approve");
		logCompare(true, b2wtimecards.setComments("Approved Time Card"), "Time Cards");
		logCompare(true, b2wtimecards.clickConfirmYes(), "Confirm Yes");
		logCompare("Approved Time Card",b2wtimecards.getTimeCardNotes().get(1), "Status");
		logCompare("Approved",b2wtimecards.getTimeCardHistoryStatus().get(1), "Status");
		logCompare(true, b2wtimecards.rejectTimeCard(), "Rejected");
		logCompare(true, b2wtimecards.setComments("Rejected Time Card"), "Time Cards");
		logCompare(true, b2wtimecards.clickConfirmYes(), "Confirm Yes");
		logCompare("Rejected Time Card",b2wtimecards.getTimeCardNotes().get(2), "Status");
		logCompare("Rejected",b2wtimecards.getTimeCardHistoryStatus().get(2), "Status");

	}
	
	
}
