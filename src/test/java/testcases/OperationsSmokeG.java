package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainTasks;

public class OperationsSmokeG extends B2WTestCase {

	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainTasks b2wMain = new B2WMaintainTasks();
	B2WMaintainProgramsTasks b2wMainPrograms = new B2WMaintainProgramsTasks();
	String sMaintenanceProgramDesc;
	String sMaintenanceProgramItemADesc;
	String sMaintenanceProgramItemAType;
	String sMaintenanceProgramItemAPriority;
	String sMaintenanceProgramItemALevel;
	String sMaintenanceProgramItemAIntervalDesc;
	String sMaintenanceProgramItemBDesc;
	String sMaintenanceProgramItemBType;
	String sMaintenanceProgramItemBPriority;
	String sMaintenanceProgramItemBLevel;
	String sMaintenanceProgramItemBIntervalDesc;
	String sLaborRate, sLaborRateID, sCategoryB, sCategoryC;


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
		sMaintenanceProgramDesc = getProperty("sMaintenanceProgramDesc") + n;
		sMaintenanceProgramItemADesc = getProperty("sMaintenanceProgramItemADesc");
		sMaintenanceProgramItemAType = getProperty("sMaintenanceProgramItemAType");
		sMaintenanceProgramItemAPriority = getProperty("sMaintenanceProgramItemAPriority");
		sMaintenanceProgramItemALevel = getProperty("sMaintenanceProgramItemALevel");
		sMaintenanceProgramItemAIntervalDesc = getProperty("sMaintenanceProgramItemAIntervalDesc");
		sMaintenanceProgramItemBDesc = getProperty("sMaintenanceProgramItemBDesc");
		sMaintenanceProgramItemBType = getProperty("sMaintenanceProgramItemBType");
		sMaintenanceProgramItemBPriority = getProperty("sMaintenanceProgramItemBPriority");
		sMaintenanceProgramItemBLevel = getProperty("sMaintenanceProgramItemBLevel");
		sMaintenanceProgramItemBIntervalDesc = getProperty("sMaintenanceProgramItemBIntervalDesc");
		sLaborRate = getProperty("laborrateclass") + n;
		sLaborRateID = getProperty("laborrateclassid") + n;
		sCategoryB = getProperty("categoryNameB") + n;
		sCategoryC = getProperty("categoryNameC");
	}

	public void testMain() throws Throwable {

		createMaintenanceProgram();

	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}
	
	public void createMaintenanceProgram() {
		// associate test user with current user
		// addEmployeeToUser();
		logCompare(true,b2wNav.openMaintain(),"Open Maintain");
		logCompare(true,b2wMain.openPrograms(),"Open Programs");
		logCompare(true,b2wMainPrograms.createNewMaintenanceProgram(),"Create Maintenance Program");
		logCompare(true,b2wMainPrograms.setMaintenanceProgramDescription(sMaintenanceProgramDesc), "Set Maintenance Program Desc");
		logCompare(true,b2wMainPrograms.setBusinessUnit("Hauling"),"Select Business Unit");
		logCompare(true,b2wMainPrograms.selectLaborRateClass(sLaborRate), "Select Labor Rate Class");
		logCompare(true,b2wMainPrograms.clickAddItem(),"Click Add Item");
		logCompare(true,b2wMainPrograms.setAddItemDescription(sMaintenanceProgramItemADesc),"Set Maintenance item description");
		logCompare(true,b2wMainPrograms.selectAddItemTypeFromDD("Repair"), "Select Add Item Type");
		logCompare(true,b2wMainPrograms.selectAddItemPriority(sMaintenanceProgramItemAPriority),"Select Item priority");
		logCompare(true,b2wMainPrograms.setAddItemLevel(sMaintenanceProgramItemALevel),"Select Maintenance Program Level");
		logCompare(true,b2wMainPrograms.saveItem(),"Save Item");
		logCompare(true,b2wMainPrograms.getHeaderandExpandOrCollapse("Intervals", true)," Expand Interval");
		logCompare(true,b2wMainPrograms.clickAddInterval(),"Click Add Interval");
		logCompare(true,b2wMainPrograms.setIntervalDescription(sMaintenanceProgramItemAIntervalDesc),"Set Interval Description");
		logCompare(true,b2wMainPrograms.selectCalendarBasedInterval(),"Select Calendar based Interval");
		logCompare(true,b2wMainPrograms.selectDailyBasedInterval(),"Select Daily based Interval");
		logCompare(true,b2wMainPrograms.setIntervalOccursEvery("1"), "Ocucrs Every day");
		logCompare(true,b2wMainPrograms.saveInterval(), "Save Interval");
		logCompare(true,b2wMainPrograms.clickAddItem(), "Add Item");
		logCompare(true,b2wMainPrograms.setAddItemDescription(sMaintenanceProgramItemBDesc),"Set Maintenance item description");
		logCompare(true,b2wMainPrograms.selectAddItemTypeFromDD("Repair"), "Select Add Item Type");
		logCompare(true,b2wMainPrograms.selectAddItemPriority(sMaintenanceProgramItemBPriority),"Select Item priority");
		logCompare(true,b2wMainPrograms.setAddItemLevel(sMaintenanceProgramItemBLevel),"Select Maintenance Program Level");
		logCompare(true,b2wMainPrograms.saveItem(),"Save Item");
		logCompare(true,b2wMainPrograms.getHeaderandExpandOrCollapse("Intervals", true)," Expand Interval");
		logCompare(true,b2wMainPrograms.clickAddInterval(),"Click Add Interval");
		logCompare(true,b2wMainPrograms.setIntervalDescription(sMaintenanceProgramItemAIntervalDesc),"Set Interval Description");
		logCompare(true,b2wMainPrograms.selectMeterBasedInterval(),"Select Calendar based Interval");
		logCompare(true,b2wMainPrograms.selectMeterTypeFromDD(sCategoryB),"Select Daily based Interval");
		logCompare(true,b2wMainPrograms.selectMeterEvery("100"), "Occurs Every day");
		logCompare(true,b2wMainPrograms.saveInterval(), "Save interval");
		
		logCompare(true,b2wMainPrograms.saveMaintenanceProgram(), "Save Maintenance Program");
		
		

	}

}
