package testcases.maintain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.BrowserUtils;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.util.TaskUtils;

public class DashboardSmokeTest extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainDashboardTasks b2wDash = new B2WMaintainDashboardTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WMaintainTasks b2wMaintain = new B2WMaintainTasks();
	B2WWorkOrdersTasks b2wOrder = new B2WWorkOrdersTasks();
	
	int iUnassignedRepairRequests;
	String dashboardDDRequests = "Unassigned Requests";
	String sMaintenanceRequestDescription, sCategoryD, sMaintenanceRequestComments,sMaintenanceRequestNotes, sMaintenanceWorkOrderDescription, sDateTwoWeeksFromNow;
	int iRandomNumber;
	SimpleDateFormat sd = new SimpleDateFormat("m/d/yyyy");

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		
		super.testSetUp();
		iRandomNumber = getRandomNumber();
		sMaintenanceRequestDescription = "AutomationTest"+iRandomNumber;
		sMaintenanceWorkOrderDescription = "AutomationTestWO"+iRandomNumber;
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
		return super.getDataPath();
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
		String sUser = b2wNav.getUserName()+"!";
		String sUpdatedText = b2wDash.getDashboardUpdatedText();
		logCompare(sUser,b2wDash.getUserWelcome(),"User Name");
		logCompare(sd.format(Calendar.getInstance().getTime()),b2wDash.getDateFromDashboard(), "Compare Dates");
		//Unassigned Repair Request
		iUnassignedRepairRequests = b2wDash.getUnassignedRepairRequests();
		logCompare(true, b2wDash.openUnassignedRepairRequests(), "Open Unassigned Repair Requests");
		TaskUtils.sleep(1000);
		logCompare(dashboardDDRequests, b2wRequests.getSelectedItemFromDropDown(), "Verify View is correct");
		logCompare(iUnassignedRepairRequests, b2wRequests.getTheNumberOfRequestsInView(), "Do the Numbers Match");
		b2wRequests.clickCreateNewRequestButton();
		b2wRequests.selectAnyPieceOfEquipment();
		logCompare(true, b2wRequests.setRequestDescription(sMaintenanceRequestDescription), "Set Description");
		b2wRequests.selectAnyTypeFromDD();
		logCompare(true, b2wRequests.setRequestNotes("This Request was generated with selenium automation"), "Set Notes");
		logCompare(true, b2wRequests.clickNewCommentButton(), "Create a comments");
		logCompare(true, b2wRequests.setNewCommentAndSave(sMaintenanceRequestComments), "Comments");
		logCompare(true, b2wRequests.setRequestNotes(sMaintenanceRequestNotes), "Set Notes");
		assertTrue("Save request", b2wRequests.clickSaveButton());
		b2wMaintain.openDashboard();
		logCompare(iUnassignedRepairRequests + 1, b2wDash.getUnassignedRepairRequests(), "Unassigned Repair Requests");
		iUnassignedRepairRequests = b2wDash.getUnassignedRepairRequests();
		logCompare(true, b2wDash.openUnassignedRepairRequests(), "Open Unassigned Requests");
		TaskUtils.sleep(1000);
		if (b2wRequests.selectRequestByDescription(sMaintenanceRequestDescription)){
			b2wRequests.clickAddToWorkOrderButton();
			logCompare(true, b2wOrder.clickCreateNewWorkOrderButton(), "Create New Work Order");
			logCompare(true, b2wOrder.setWorkOrderDescription(sMaintenanceWorkOrderDescription), "Set Work");
			logCompare(true, b2wOrder.setDueDate(sDateTwoWeeksFromNow), "Due Date");
			logCompare(true, b2wOrder.selectPlannedLocationDD("Field"), "Planned in the Field");
			logCompare(true, b2wOrder.selectPriorityFromDD("Medium"), "Medium Priority");
			logCompare(true, b2wOrder.setWorkOrderNotes("Automation Created this work order"), "Set Notes");
			b2wOrder.clickSaveButton();
		}
		TaskUtils.sleep(5600);
		
		
	}
}
