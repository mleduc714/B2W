package tasks.scheduler;



import com.b2w.test.B2WTestCase;

import appobjects.scheduler.B2WScheduleView;
import tasks.B2WNavigationTasks;
import tasks.util.Timer;

public class B2WScheduleViewTest extends B2WTestCase{
	
	
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
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrews();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByAssignmentLocation();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByWorkSubtype();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByWorkType();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnCrewsByWorkTypeAndWorkSubtype();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeeSchedule();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeesByAssignmentLocation();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeesByBusinessUnit();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEmployeesByLaborType();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByCategory();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByCategoryAndLocation();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByCategoryAndType();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByLocation();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByLocationAndCategory();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByLocationAndType();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByType();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByTypeAndCategory();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentGroupedByTypeAndLocation();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule1();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule2();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule3();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule4();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule5();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule6();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule7();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule8();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnEquipmentSchedule9();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentAtRt93Exit18();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentDownForMaintenance();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentScheduledForMaintenance();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentThatMovesOtherEquipment();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentThatRequiresMoves();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentWithGPS();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByEquipmentWithMemoEvents();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByOwnedEquipmentAtEqYardOrHQ();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByRentedAndSubcontractedEquipment();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredByRentedCranes();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredBySelfMobileEquipment();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredBySitework();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnFilteredBySubcontractedTriAxles();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnJobSites();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnJobSitesPlaces();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnMortsInactiveEquipment();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnMortsActiveEquipment();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnNortheastDivisionAndPaversAndGraders();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnNorthwestDivisionPaversGraders();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnPlaces();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnSouthernDivisionSiteworkSpecial();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnSouthwestDivisionPaversGraders();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
		scheduleView.openScheduleViewList();
		timer.start();
		scheduleView.clickOnRandomCharacters();
		timer.end();
		schedulerTasks.waitForSchedulePageNoBusy();
	}
}
