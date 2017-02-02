package testcases.maintain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.dialogs.B2WAddMaintenanceReqToWorkOrder;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WEditScheduleMaintenance;
import tasks.dialogs.B2WMaintainSchedulePopupToolTip;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.dialogs.B2WSchedulePopupFilter;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.maintain.B2WWorkOrdersTasks.PRIORITY;
import tasks.util.TaskUtils;

public class MaintainDashboardSmokeTest_2 extends B2WTestCase {
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
	B2WMaintainSchedulePopupToolTip b2wSchedPopup = new B2WMaintainSchedulePopupToolTip();
	B2WSchedulePopupFilter b2wSchedPopupFilter = new B2WSchedulePopupFilter();
	B2WReportHours b2wReportedHrs = new B2WReportHours();
	

	int iUnassignedRepairRequests, iNumberOfRequest, iUnscheduledPM, iUnscheduledWorkOrders, iPastDueWorkOrders, iPendingTimeCards;
	String dashboardDDRequests = "Unassigned Requests";
	String sMaintenanceRequestDescription, sCategoryD, sMaintenanceRequestComments, sMaintenanceRequestNotes,
			sMaintenanceWorkOrderDescription, sToday;
	int iRandomNumber;
	
	PRIORITY priority = null;
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
		sToday = sd.format(cal.getTime());

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
		b2wNav.openMaintain();
		b2wMaintain.openDashboard();
		String sUser = b2wNav.getUserName() + "!";
		//String sUpdatedText = b2wDash.getDashboardUpdatedText();
		logCompare(sUser, b2wDash.getUserWelcome(), "User Name");
		logCompare(sd.format(Calendar.getInstance().getTime()), b2wDash.getDateFromDashboard(), "Compare Dates");

		logCompare(true,b2wMaintain.openDashboard(),"Open Dashboard");
		//verifyFilters();
		verifyScheduledWorkOrders();
		verifyWorkOrdersPriorityChart();
		verifyWorkOrderItemHours();

	}
	
	
	public void verifyFilters() {
		ArrayList<String> al = b2wDash.getAllWorkOrderLocations();

		Random rand = new Random();
		int randnumber = rand.nextInt(al.size());
		String sFilterLocation = al.get(randnumber);
		logCompare(true,b2wDash.clickScheduleWorkOrderFiltersButton(), "Click Work Order Filter Button");
		logCompare(true,b2wSchedPopupFilter.selectItemFromSchedulerFilter("Work Location", sFilterLocation), "Filter by location");
		logCompare(Collections.frequency(al, sFilterLocation), b2wDash.getNumberOfScheduledWorkOrders(), "Numbers Match After Filter");
		logCompare(true,b2wDash.clickScheduleWorkOrderFiltersButton(), "Filter");
		logCompare(true,b2wSchedPopupFilter.removeFilter(),"Remove Filter");
		logCompare(al.size(),b2wDash.getNumberOfScheduledWorkOrders(), "Scheduled orders back without filters");
		
		al = b2wDash.getAllWorkOrderEquipment();
		randnumber = rand.nextInt(al.size());
		sFilterLocation = al.get(randnumber);
		logCompare(true,b2wDash.clickScheduleWorkOrderFiltersButton(), "Click Work Order Filter Button");
		logCompare(true,b2wSchedPopupFilter.selectItemFromSchedulerFilter("Equipment", sFilterLocation), "Filter by Equipment");
		logCompare(Collections.frequency(al, sFilterLocation), b2wDash.getNumberOfScheduledWorkOrders(), "Numbers Match After Filter");
		TaskUtils.sleep(1000);
		logCompare(true,b2wDash.clickScheduleWorkOrderFiltersButton(), "Filter");
		logCompare(true,b2wSchedPopupFilter.removeFilter(),"Remove Filter");

		
	}
	
	public void verifyScheduledWorkOrders() {
		int iScheduledWorkOrders = b2wDash.getNumberOfScheduledWorkOrders();
		for (int i = 0; i < iScheduledWorkOrders; i++){
			logCompare(true,b2wDash.selectWorkOrderByNumber(i),"Select Work Order By Number");
			TaskUtils.sleep(1000);
			logCompare(true,b2wSchedPopup.clickWorkItemLink(),"Click Work Item");
			logCompare("Scheduled",b2wOrder.getSelectedWorkOrderStatus(), "Work status is scheduled");
			logCompare(true,b2wMaintain.openDashboard(),"Open Dashboard");
		}
	}
	
	public void verifyWorkOrdersPriorityChart() {
		
		int h = b2wDash.getHighPriorityPercentage();
		int l = b2wDash.getLowPriorityPercentage();
		int m = b2wDash.getMediumPriorityPercentage();
		b2wDash.selectWorkOrderByNumber(0);
		logCompare(true,b2wSchedPopup.clickWorkItemLink(),"Click Work Item");
		priority = b2wOrder.getPriorityOfItemEnum();
		b2wOrder.clickEditWorkOrder();
		
		switch (priority){
		case MEDIUM:
			b2wOrder.selectPriorityFromDD("High");
			break;
		case HIGH:
			b2wOrder.selectPriorityFromDD("Low");
			break;
		case LOW:
			b2wOrder.selectPriorityFromDD("Medium");
			break;
		default:
		}
		b2wOrder.saveEditWorkOrder();
		switch (priority){
		case MEDIUM:
			logCompare(true,h != b2wDash.getHighPriorityPercentage(), "The old high percentage was "+h + " the new one is "+b2wDash.getHighPriorityPercentage());
			break;
		case HIGH:
			logCompare(true,l != b2wDash.getLowPriorityPercentage(), "The old low percentage was "+l + " the new one is "+b2wDash.getLowPriorityPercentage());
			break;
		case LOW:
			logCompare(true,m != b2wDash.getMediumPriorityPercentage(), "The old medium percentage was "+m + " the new one is "+b2wDash.getMediumPriorityPercentage());
			break;
		default:
		}
		b2wMaintain.openDashboard();

	}
	
	public void verifyWorkOrderItemHours() {
		// verify that not work order items to display, then we can test it
		if (!b2wDash.isCompleteWorkOrderItemHourChartDisplayed()){
			
			b2wDash.selectWorkOrderByNumber(0);
			logCompare(true,b2wSchedPopup.clickWorkItemLink(),"Click Work Item");
			b2wOrder.clickEditWorkOrder();
			b2wOrder.expandHours();
			b2wOrder.clickAddReportedHours();
			TaskUtils.sleep(1000);
			b2wReportedHrs.setEmployeeWorkHoursDescription("Strange Brew");
			String sEmployee = b2wReportedHrs.selectRandomEmployee();
			TaskUtils.sleep(500);
			b2wReportedHrs.selectRandomEmployeeLaborType();
			TaskUtils.sleep(500);
			b2wReportedHrs.setDate(sToday);
			b2wReportedHrs.setEmployeeRegularHours("8");
			b2wReportedHrs.setEmployeeRegularMins("15");
			b2wReportedHrs.saveReportedHours();
			b2wOrder.saveEditWorkOrder();
			
			b2wOrder.clickComplete();
			b2wComplete.clickNextPage();
			b2wComplete.completeSave();
			b2wMaintain.openDashboard();
			logCompare(true, b2wDash.isCompleteWorkOrderItemHourChartDisplayed(), "Chart is displayed");
			logCompare(true, b2wDash.getMechanicsFromChart().contains(sEmployee), "Employee "+sEmployee+" is in the chart");
			
		}
		
	
		
	}
}