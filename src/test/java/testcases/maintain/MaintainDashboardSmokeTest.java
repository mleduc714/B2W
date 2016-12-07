package testcases.maintain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.BrowserUtils;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.dialogs.B2WAddMaintenanceReqToWorkOrder;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WEditScheduleMaintenance;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.util.TaskUtils;

public class MaintainDashboardSmokeTest extends B2WTestCase {

	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainDashboardTasks b2wDash = new B2WMaintainDashboardTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WMaintainTasks b2wMaintain = new B2WMaintainTasks();
	B2WWorkOrdersTasks b2wOrder = new B2WWorkOrdersTasks();
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


	int iUnassignedRepairRequests, iNumberOfRequest, iUnscheduledPM, iUnscheduledWorkOrders, iPastDueWorkOrders, iPendingTimeCards;
	String dashboardDDRequests = "Unassigned Requests";
	String sMaintenanceRequestDescription, sCategoryD, sMaintenanceRequestComments, sMaintenanceRequestNotes,
			sMaintenanceWorkOrderDescription, sDateTwoWeeksFromNow;
	int iRandomNumber;
	SimpleDateFormat sd = new SimpleDateFormat("M/d/yyyy");
	ArrayList<String> requestIDs = new ArrayList<String>();

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub

		super.testSetUp();
		iRandomNumber = getRandomNumber();
		sMaintenanceRequestDescription = "AutomationTest" + iRandomNumber;
		sMaintenanceWorkOrderDescription = "AutomationTestWO" + iRandomNumber;
		sMaintenanceRequestComments = "Comments not required";
		sMaintenanceRequestNotes = "The Notes for this is Woo related";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 14);
		sDateTwoWeeksFromNow = sd.format(cal.getTime());

	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return super.getCategory();
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return super.getAuthor();
	}

	@Override
	public String getTestDescription() {
		// TODO Auto-generated method stub
		return super.getTestDescription();
	}

	@Override
	public String getDataPath() {
		// TODO Auto-generated method stub
		return "data/dashboard";
		
	}

	@Override
	public boolean isSupported() {
		// TODO Auto-generated method stub
		return super.isSupported();
	}

	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		SimpleDateFormat sd = new SimpleDateFormat("EEEEE, MMMMM d, yyy");
		BrowserUtils.getDriver().navigate().to(getEnvProperty("deploy") + "Maintenance/Dashboard.aspx");
		String sUser = b2wNav.getUserName() + "!";
		//String sUpdatedText = b2wDash.getDashboardUpdatedText();
		logCompare(sUser, b2wDash.getUserWelcome(), "User Name");
		logCompare(sd.format(Calendar.getInstance().getTime()), b2wDash.getDateFromDashboard(), "Compare Dates");
		verifyUnassignedRequests();
		verifyUnassignedPM();
		verifyUnscheduledWorkOrders();
		verifyPendingTimeCards();
		verifyPastDueWorkOrders();

		
	}
	

	public void verifyUnassignedRequests() {
		iUnassignedRepairRequests = b2wDash.getUnassignedRepairRequests();
		logCompare(true, b2wDash.openUnassignedRepairRequests(), "Open Unassigned Repair Requests");
		TaskUtils.sleep(1000);
		logCompare(dashboardDDRequests, b2wRequests.getSelectedItemFromDropDown(), "Verify View is correct");
		logCompare(iUnassignedRepairRequests, b2wRequests.getTheNumberOfRequestsInView(), "Do the Numbers Match");
		b2wRequests.clickCreateNewRequestButton();
		b2wRequests.selectAnyPieceOfEquipment();
		logCompare(true, b2wRequests.setRequestDescription(sMaintenanceRequestDescription), "Set Description");
		logCompare(true, b2wRequests.clickNewCommentButton(), "Create a comments");
		logCompare(true, b2wRequests.setNewCommentAndSave(sMaintenanceRequestComments), "Comments");
		logCompare(true, b2wRequests.setRequestNotes(sMaintenanceRequestNotes), "Set Notes");
		b2wRequests.selectAnyTypeFromDD();
		assertTrue("Save request", b2wRequests.clickSaveButton());
		b2wMaintain.openDashboard();
		logCompare(iUnassignedRepairRequests + 1, b2wDash.getUnassignedRepairRequests(), "Unassigned Repair Requests");
		iUnassignedRepairRequests = b2wDash.getUnassignedRepairRequests();
		logCompare(true, b2wDash.openUnassignedRepairRequests(), "Open Unassigned Requests");
		TaskUtils.sleep(1000);
		
		if (b2wRequests.selectRequestByDescription(sMaintenanceRequestDescription)) {
			b2wRequests.clickAddToWorkOrderButton();
			if (addToWO.doesDialogExist()) {
				logCompare(true, addToWO.selectCreateNewWorkOrderRadioButton(), "Create new Work Order");
				logCompare(true, addToWO.clickNextButton(), "Click Next");
				iUnscheduledPM = addToWO.getNumberOfRequestsToAddToWorkOrder();
				requestIDs = addToWO.getRequestIDs();
				logCompare(true, addToWO.addAllRequests(), "Add All Requests");
				logCompare(true, addToWO.clickFinishButton(), "Click Finish");
			}
			logCompare(true, b2wOrder.setWorkOrderDescription(sMaintenanceWorkOrderDescription), "Set Work");
			logCompare(true, b2wOrder.setDueDate(sDateTwoWeeksFromNow), "Due Date");
			logCompare(true, b2wOrder.selectPlannedLocationDD("Field"), "Planned in the Field");
			logCompare(true, b2wOrder.selectPriorityFromDD("Medium"), "Medium Priority");
			logCompare(true, b2wOrder.setWorkOrderNotes("Automation Created this work order"), "Set Notes");
			b2wOrder.clickSaveButton();

		}
		b2wMaintain.openDashboard();
		logCompare(iUnassignedRepairRequests - 1, b2wDash.getUnassignedRepairRequests(), "Unassigned Repair Requests");
		
	}
	
	public void verifyUnassignedPM() {
		//Unscheduled PM
		//Quantity is valid - when click on 'Unscheduled PM' launches to Maintain > Request which will be filtered for 'Program Requests'
		iUnscheduledPM = b2wDash.getUnscheduledPM();
		iUnassignedRepairRequests = b2wDash.getUnassignedRepairRequests();
		logCompare(true, b2wDash.openUnscheduledPM(), "Open Scheduled PM");
		TaskUtils.sleep(1000);
		logCompare(true,b2wMaintain.openPrograms(), "Open Programs");
		logCompare(true,b2wMainPrograms.selectMaintenanceProgram(0), "Select First Maintenance Program");
		logCompare(true,b2wMainPrograms.clickAddEquipment(), "Click Add Equipment");
		String sEquipment = b2wEquipmentProgram.selectAnyEquipment();
		
		logCompare(true,b2wEquipmentProgram.clickFinishAddEquipment(), "Click Finish Button");
		logCompare(true,b2wMainPrograms.expandEquipmentByID(sEquipment), "Expand Equipment");
		logCompare(true,b2wMainPrograms.generateItems(), "Generate Items");
		logCompare(true,b2wMaintain.openDashboard(), "Open The Dashboard");
		logCompare(iUnscheduledPM + 1,b2wDash.getUnscheduledPM(), "The number increased by 1");
		logCompare(iUnassignedRepairRequests + 1,b2wDash.getUnassignedRepairRequests(), "Unassigned Repair Requests increased by 1" );
	}
	
	
	public void verifyUnscheduledWorkOrders() {

		b2wMaintain.openDashboard();
		
		iUnscheduledWorkOrders = b2wDash.getUnscheduledWorkOrders();
		logCompare(true, b2wDash.openUnscheduledWorkOrders(), "Open Unscheduled Workers");
		logCompare(true, b2wSchd.openWorkOrderFromWorkOrderTabByNumber(0), "Open the first work order from tab");
		TaskUtils.sleep(500);
		String sWorkLocation = b2wSchMain.scheduleMaintainancePopupSelectAnyWorkLocation();
		String sMechanic = b2wSchMain.scheduleMaintainancePopupSelectAnyMechanic();
		String sWorkOrderID = b2wSchMain.getWorkOrderID();
		logCompare(true, b2wSchMain.saveScheduleMaintenance(), "Save Scheduled Maintenance");
		if (logCompare(true, b2wMaintain.openWorkOrders(), "Open Work Orders")) {
			TaskUtils.sleep(500);
			logCompare(true, b2wOrder.selectWorkOrderByID(sWorkOrderID), "Select Work Order");
			logCompare(sMechanic, b2wOrder.getValueOfItem("Mechanic"), "Mechanic");
			logCompare(sWorkLocation, b2wOrder.getValueOfItem("Work Location"), "Work Location");
			logCompare("Scheduled", b2wOrder.getSelectedWorkOrderStatus(), "Status");
			logCompare(true, b2wOrder.clickComplete(), "Complete");
			logCompare(true, b2wComplete.clickNextPage(), "next page");
			logCompare(true, b2wComplete.completeSave(), "Complete Save");
			logCompare(true, b2wMaintain.openDashboard(), "Open the Dashboard");
			logCompare(iUnscheduledWorkOrders - 1, b2wDash.getUnscheduledWorkOrders(), "Unscheduled Work Orders");
		}


	}
	
	public void verifyPastDueWorkOrders() {
		b2wMaintain.openDashboard();
		iPastDueWorkOrders = b2wDash.getPastDueWorkOrders();
		logCompare(true,b2wDash.openPastDueWorkOrder(), "Open Past Due Work Orders");
		logCompare(iPastDueWorkOrders, b2wSchd.getPastDueWorkOrders(), "Number of Past Due Work Orders");
		if (iPastDueWorkOrders > 0) {
			SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, 7);
			logCompare(true,b2wDash.openPastDueWorkOrder(), "Open Past Due Work Order");
			logCompare(true,b2wSchd.openWorkOrderFromPastDueTabByNumber(0), "Open Work Order from Past Due");
			String sWorkOrder = b2wEditSch.getWorkOrder();
			logCompare(true, b2wEditSch.editScheduleMaintainancePopupSelectStartDate(format.format(cal.getTime())),
					"Set Start Date to 7 days to "+sWorkOrder);
			cal.add(Calendar.DAY_OF_YEAR, 14);
			logCompare(true, b2wEditSch.editScheduleMaintainancePopupSelectEndDate(format.format(cal.getTime())),
					"Add 7 to start date to "+sWorkOrder);
			logCompare(true, b2wEditSch.saveScheduleMaintenance(), "Save scheduled maintenance");
			BrowserUtils.getDriver().navigate().to(getEnvProperty("deploy") + "Maintenance/Dashboard.aspx");
			logCompare(iPastDueWorkOrders - 1, b2wDash.getPastDueWorkOrders(), "Past Due Number Decreases");
		}

		
		
	}
	
	public void verifyPendingTimeCards() {
		b2wMaintain.openDashboard();
		iPendingTimeCards = b2wDash.getPendingTimeCards();
		logCompare(true, b2wDash.openPendingTimeCards(), "Open Pending Time Cards");
		logCompare(true, b2wtimecards.clickCreateNewTimeCard(), "Create new Time Card");
		String sEmployee = b2wReport.selectRandomEmployee();
		b2wtimecards.clickAddTimeButton();
		TaskUtils.sleep(1000);
		b2wReport.selectChargeToJob();
		b2wReport.selectAnyJob();
		b2wReport.setEmployeeWorkHoursDescription("This time card is a load of laughs");
		b2wReport.selectEmployeeLaborType("Foreman");
		b2wReport.setEmployeeRegularHours("10");
		b2wtimecards.saveReportHours();
		b2wMaintain.openDashboard();
		logCompare(iPendingTimeCards, b2wDash.getPendingTimeCards(), "Get Pending Time Cards");
		logCompare(true, b2wDash.openPendingTimeCards(), "Open Pending Time Cards");
		BrowserUtils.getDriver().navigate().to(getEnvProperty("deploy") + "Maintenance/TimeCards.aspx");
		TaskUtils.sleep(2500);
		b2wtimecards.selectEmployee(sEmployee);
		logCompare(true, b2wtimecards.submitTimeCard(),"Submit Time Card");
		logCompare(true, b2wtimecards.clickConfirmYes(), "Confirm Yes");
		TaskUtils.sleep(2400);
		b2wMaintain.openDashboard();
		logCompare(iPendingTimeCards + 1, b2wDash.getPendingTimeCards(), "Get Pending Time Cards");
		logCompare(true, b2wDash.openPendingTimeCards(), "Open Pending Time Cards");
		b2wtimecards.selectEmployee(sEmployee);
		logCompare(true, b2wtimecards.submitApproved(), "Approve");
		logCompare(true, b2wtimecards.clickConfirmYes(), "Confirm");
		TaskUtils.sleep(1000);
		b2wMaintain.openDashboard();
		logCompare(iPendingTimeCards, b2wDash.getPendingTimeCards(), "Get Pending Time Cards");
		
		
	}
	
	
}
