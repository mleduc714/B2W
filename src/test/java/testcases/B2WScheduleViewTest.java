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
		
		timer.start();
		b2wNav.openSchedule();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Open Schedule", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrews();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByAssignmentLocation();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Assignment Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByWorkSubtype();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Work Subtype", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByWorkType();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Work Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByWorkTypeAndWorkSubtype();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
        linkTable.put("Crews by Work Type & Work Subtype", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeeSchedule();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employee Schedule", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeesByAssignmentLocation();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employees by Assignment Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeesByBusinessUnit();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employees by Business Unit", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeesByLaborType();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Employees by Labor Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByCategory();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Category", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByCategoryAndLocation();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Category & Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByCategoryAndType();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Category & Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByLocation();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByLocationAndCategory();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Location & Category", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByLocationAndType();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Location & Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByType();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Type", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByTypeAndCategory();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Type & Category", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByTypeAndLocation();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Grouped by Type & Location", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule1();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 1", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule2();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 2", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule3();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 3", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule4();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 4", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule5();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 5", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule6();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 6", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule7();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 7", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule8();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 8", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule9();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Equipment Schedule 9", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentAtRt93Exit18();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment At RT93 Exit 18 ", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentDownForMaintenance();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment Down for Maintenance", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentScheduledForMaintenance();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment Scheduled for Maintenance", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentThatMovesOtherEquipment();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered By Equipment That Moves other Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentThatRequiresMoves();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment That Requires Moves", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentWithGPS();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment With GPS", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentWithMemoEvents();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Equipment With Memo Events", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByOwnedEquipmentAtEqYardOrHQ();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Owned Equipment at Eq. Yard or HQ", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByRentedAndSubcontractedEquipment();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Rented & Subcontracted Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByRentedCranes();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Rented Cranes", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredBySelfMobileEquipment();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Self Mobile Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredBySitework();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered by Sitework", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredBySubcontractedTriAxles();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Filtered By Subcontracted Tri-Axles", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnJobSites();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Job Sites", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnJobSitesPlaces();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Job Sites - Places", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnMortsInactiveEquipment();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Mort's <Inactive> Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnMortsActiveEquipment();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Mort's Active Equipment", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnNortheastDivisionAndPaversAndGraders();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Northeast Division & Pavers & 'Graders'", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnNorthwestDivisionPaversGraders();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Northwest Division Pavers-Graders", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnPlaces();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Places", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnSouthernDivisionSiteworkSpecial();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Southern Division Sitework \"Special\"", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnSouthwestDivisionPaversGraders();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Southwest Division Pavers--Graders", timer.getTotalTime());
		
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnRandomCharacters();
		schedulerTasks.waitForSchedulePageNoBusy();
		timer.end();
		linkTable.put("Z!\"#$%&'()*+-./:;<=>?@[\\]^_`{|}~“”‘’!\"#$%&'()*+-./:;<=>?@[\\]^_`{|}~“”‘’", timer.getTotalTime());
		
		
        Set<String> keys = linkTable.keySet();
        for (String key: keys){
               System.out.println(key + " " + linkTable.get(key));
        }
		
		

	}
}
