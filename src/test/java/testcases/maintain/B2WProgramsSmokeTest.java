package testcases.maintain;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.util.TaskUtils;

public class B2WProgramsSmokeTest extends B2WTestCase {
	

	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
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
		return "author";
	}

	@Override
	public String getTestDescription() {
		// enter the description for the testcase
		return "Testcase description";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/test";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		/*	Create a New Maintenance Program
		•Add Item(s): V
		•Enter Intervals: V
		•Enter Exclusions: V
		•Enter Planned Hours: !
		•Enter Parts to be used with the Maintenance Program: !
		•Save: V

		•Attachments•CRUD: !

		•Copy a Maintenance Program: !
		•Edit a Maintenance Program•Add/Remove Items: !

		•Equipment on a program•Add equipment
		•Search for equipment within entity
		•Generate interval for a piece of equipment
		•Remove equipment from program

		•Attempt to Delete a Maintenance Program that has been associated with a piece of Equipment (You should not be able to delete)
		•Explore Search and Business Unit Filter
		•Explore sorting of Program List
		•Security Permissions
		•Navigation options to Programs page
	*/
		
		B2WNavigationTasks navigation = new B2WNavigationTasks();
		
		B2WMaintainTasks b2wMain = new B2WMaintainTasks();
		
		B2WMaintainProgramsTasks b2wMainPrograms = new B2WMaintainProgramsTasks();
		
		B2WAddItemMaintenanceProgram b2wAddItem = new B2WAddItemMaintenanceProgram();
		
		B2WAddInterval addInterval = new B2WAddInterval();	

		
		logCompare(true, navigation.openMaintain(), "Open Equipment Page");
		
		b2wMain.openPrograms();
		
		b2wMainPrograms.createNewMaintenanceProgram();
		b2wMainPrograms.setMaintenanceProgramDescription("This is a newly created program");
		b2wMainPrograms.selectBusinessUnit("Hauling");
		b2wMainPrograms.selectLaborRateClass("New Hampshire Rates");
		
		b2wMainPrograms.clickAddItem();
		b2wAddItem.setAddItemDescription("This is a new item");
		b2wAddItem.selectAddItemPriority("High");
		b2wAddItem.selectAddItemTypeFromDD("Inspection");
		b2wAddItem.setAddItemLevel("55");
		b2wAddItem.saveItem();
		
		b2wMainPrograms.expandIntervals();
		b2wMainPrograms.clickAddInterval();
		addInterval.setIntervalDescription("This is a new interval");
		addInterval.selectCalendarBasedInterval();
		addInterval.selectMeterTypeFromDD("Odometer");
		addInterval.selectDailyBasedInterval();
		addInterval.setIntervalOccursEvery("1");
		addInterval.saveInterval();
		b2wMainPrograms.collapseIntervals();
		
		b2wMainPrograms.clickAddItem();
		b2wAddItem.setAddItemDescription("This is another item");
		b2wAddItem.selectAddItemTypeFromDD("Winter");
		b2wAddItem.selectAddItemPriority("Low");
		b2wAddItem.setAddItemLevel("33");
		b2wAddItem.saveItem();
		
		b2wMainPrograms.expandIntervals();
		b2wMainPrograms.clickAddInterval();
		addInterval.setIntervalDescription("This is another interval");
		addInterval.selectMeterTypeFromDD("Odometer");
		addInterval.selectMeterTypeFromDD("Hour Interval");
		addInterval.selectMeterEvery("100");
		addInterval.setGenerateRepairRequestsForThisItem("10");
		addInterval.saveInterval();
		
		b2wMainPrograms.expandExclusions();
		b2wMainPrograms.excludeAugust();
		b2wMainPrograms.excludeJanuary();
		b2wMainPrograms.excludeDecemeber();
		b2wMainPrograms.excludeMarch();
		
		
		
		//b2wMainPrograms.expandHours();
		//b2wMainPrograms.clickAddHours();
		
		//MISSING:
		//
		//•Add Hours Description
		//•Hours Labor Type
		//•Enter Planned Hours
		//•Save Hours
		
		
		
		//b2wMainPrograms.expandParts();
		//b2wMainPrograms.clickAddParts();
		
		//MISSING:
		//
		//•Select Parts by ID
		//•Search for Parts
		//•Set Estimated Quantity
		//•Save Parts
		
		b2wMainPrograms.saveMaintenanceProgram();
		
		TaskUtils.sleep(5000);
		
		b2wMainPrograms.expandAttachments();
		b2wMainPrograms.collapseAttachments();
		
		//MISSING:
		//
		//•Add Attachments button
		//•Set Attachment Description
		//•Save Attachment
		//•Edit Attachment
		//•Delete Attachment
		
		
		//MISSING:
		//	
		//•Copy Program
		
		
		//MISSING:
		//	
		//•Edit Program
		
		
		
		
	}

}