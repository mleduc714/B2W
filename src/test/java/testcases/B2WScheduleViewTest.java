package testcases;

import java.util.LinkedHashMap;
import java.util.Set;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.scheduler.B2WScheduleViewTasks;
import tasks.scheduler.B2WSchedulerTasks;
import tasks.util.Timer;

public class B2WScheduleViewTest extends B2WTestCase{
	

	private static LinkedHashMap<String,Long> linkTable = new LinkedHashMap<String,Long>();
	
	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
	}

	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		super.testMain();
		scheduleViewTest();
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

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

	public static void scheduleViewTest() throws Exception{
		B2WScheduleViewTasks scheduleView = new B2WScheduleViewTasks();
		
		B2WNavigationTasks b2wNav = new B2WNavigationTasks();
		Timer timer = new Timer();
		B2WSchedulerTasks schedulerTasks = new B2WSchedulerTasks();
		
		b2wNav.openSchedule();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Open Schedule", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrews();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByAssignmentLocation();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Assignment Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByWorkSubtype();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Work Subtype", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByWorkType();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Work Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByWorkTypeAndWorkSubtype();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Work Type & Work Subtype", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEmployeeSchedule();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employee Schedule", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEmployeesByAssignmentLocation();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employees by Assignment Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEmployeesByBusinessUnit();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employees by Business Unit", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEmployeesByLaborType();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employees by Labor Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByCategory();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Category", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByCategoryAndLocation();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Category & Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByCategoryAndType();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Category & Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByLocation();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByLocationAndCategory();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Location & Category", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByLocationAndType();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Location & Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByType();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByTypeAndCategory();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Type & Category", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByTypeAndLocation();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Type & Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule1();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 1", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule2();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 2", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule3();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 3", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule4();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 4", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule5();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 5", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule6();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 6", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule7();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 7", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule8();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 8", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule9();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 9", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentAtRt93Exit18();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment At RT93 Exit 18 ", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentDownForMaintenance();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment Down for Maintenance", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentScheduledForMaintenance();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment Scheduled for Maintenance", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentThatMovesOtherEquipment();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered By Equipment That Moves other Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentThatRequiresMoves();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment That Requires Moves", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentWithGPS();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment With GPS", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentWithMemoEvents();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment With Memo Events", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByOwnedEquipmentAtEqYardOrHQ();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Owned Equipment at Eq. Yard or HQ", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByRentedAndSubcontractedEquipment();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Rented & Subcontracted Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByRentedCranes();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Rented Cranes", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredBySelfMobileEquipment();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Self Mobile Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredBySitework();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Sitework", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredBySubcontractedTriAxles();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered By Subcontracted Tri-Axles", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnJobSites();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Job Sites", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnJobSitesPlaces();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Job Sites - Places", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnMortsInactiveEquipment();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Mort's <Inactive> Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnMortsActiveEquipment();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Mort's Active Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnNortheastDivisionAndPaversAndGraders();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Northeast Division & Pavers & 'Graders'", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnNorthwestDivisionPaversGraders();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Northwest Division Pavers-Graders", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnPlaces();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Places", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnSouthernDivisionSiteworkSpecial();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Southern Division Sitework \"Special\"", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnSouthwestDivisionPaversGraders();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Southwest Division Pavers--Graders", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		scheduleView.clickOnRandomCharacters();
		timer.start();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Z!\"#$%&'()*+-./:;<=>?@[\\]^_`{|}~����!\"#$%&'()*+-./:;<=>?@[\\]^_`{|}~����", timer.getTotalTime());
		
		
        Set<String> keys = linkTable.keySet();
        for (String key: keys){
               System.out.println(key + " " + linkTable.get(key));
        }
		
	}
}
