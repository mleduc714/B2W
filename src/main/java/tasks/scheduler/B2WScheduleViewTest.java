package tasks.scheduler;

import java.util.Timer;

import com.b2w.test.B2WTestCase;

import appobjects.scheduler.B2WScheduleView;
import tasks.B2WNavigationTasks;

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

	public static void scheduleViewTest(){
		B2WScheduleViewTasks scheduleView = new B2WScheduleViewTasks();
		
		B2WNavigationTasks b2wNav = new B2WNavigationTasks();
		Timer timer = new Timer();
		
		b2wNav.openSchedule();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrews();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByAssignmentLocation();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByAssignmentLocation();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByWorkSubtype();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByWorkType();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnCrewsByWorkTypeAndWorkSubtype();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEmployeeSchedule();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEmployeesByAssignmentLocation();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEmployeesByLaborType();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByCategory();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByCategoryAndLocation();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByCategoryAndType();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByLocation();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByLocationAndCategory();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByLocationAndType();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByType();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByTypeAndCategory();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentGroupedByTypeAndLocation();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule1();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule2();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule3();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule4();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule5();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule6();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule7();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule8();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnEquipmentSchedule9();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentAtRt93Exit18();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentDownForMaintenance();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentScheduledForMaintenance();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentThatMovesOtherEquipment();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentThatRequiresMoves();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentWithGPS();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByEquipmentWithMemoEvents();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByOwnedEquipmentAtEqYardOrHQ();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByRentedAndSubcontractedEquipment();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredByRentedCranes();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredBySelfMobileEquipment();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredBySitework();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnFilteredBySubcontractedTriAxles();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnJobSites();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnJobSitesPlaces();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnMortsInactiveEquipment();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnMortsActiveEquipment();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnNortheastDivisionAndPaversAndGraders();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnNorthwestDivisionPaversGraders();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnPlaces();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnSouthernDivisionSiteworkSpecial();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnNortheastDivisionAndPaversAndGraders();
		scheduleView.openScheduleViewList();
		scheduleView.clickOnRandomCharacters();
		scheduleView.openScheduleViewList();
	}
}
