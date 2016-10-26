package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeG extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainTasks b2wMain = new B2WMaintainTasks();
	B2WMaintainProgramsTasks b2wMainPrograms = new B2WMaintainProgramsTasks();
	String sMaintenanceProgramDesc;
	String sMaintenanceProgramLaborRateClass;
	String sMaintenanceProgramItem1Desc;
	String sMaintenanceProgramItem1Type;
	String sMaintenanceProgramItem1Priority;
	String sMaintenanceProgramItem1Level;
	
	
	
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

	}

	public void testMain() throws Throwable {
		// associate test user with current user
		//addEmployeeToUser();
		b2wNav.openMaintain();
		b2wMain.openPrograms();
		b2wMainPrograms.createNewMaintenanceProgram();
		b2wMainPrograms.setMaintenanceProgramDescription("TESTING");
		b2wMainPrograms.setBusinessUnit("Hauling");
		b2wMainPrograms.clickAddItem();
		b2wMainPrograms.setAddItemDescription("Testing");
		b2wMainPrograms.selectAddItemTypeFromDD("Inspection");
		b2wMainPrograms.selectAddItemPriority("High");
		b2wMainPrograms.setAddItemLevel("1");
		b2wMainPrograms.saveItem();
		b2wMainPrograms.getHeaderandExpandOrCollapse("Intervals", true);
		b2wMainPrograms.clickAddInterval();
		b2wMainPrograms.setIntervalDescription("New interval");
		b2wMainPrograms.selectCalendarBasedInterval();
		b2wMainPrograms.selectMonthlyBasedInterval();
		b2wMainPrograms.setMonthlyIntervalOccurEveryMonthOnThe("2","2","2");
		//b2wMainPrograms.selectOccursEveryWeekOnFromDD("Sunday");

		TaskUtils.sleep(4000);

	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

}
