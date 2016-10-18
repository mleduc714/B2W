package testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.B2WSetupTasks;
import tasks.resources.B2WAccountTasks;
import tasks.resources.B2WAddLaborTypeTasks;
import tasks.resources.B2WAddMaterialsTasks;
import tasks.resources.B2WEmployeeTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.resources.B2WEquipmentTypesTasks;
import tasks.resources.B2WLaborRateClassTasks;
import tasks.resources.B2WMaterialsTasks;
import tasks.resources.B2WNewLaborTypeTasks;
import tasks.resources.B2WOrganizationTasks;
import tasks.resources.B2WPartTasks;
import tasks.resources.B2WPlaceTasks;
import tasks.resources.B2WTMPriceSheetsTasks;
import tasks.setup.B2WCategoriesTasks;
import tasks.setup.B2WUserTasks;

public class TestSetup extends B2WTestCase {



	B2WNavigationTasks b2wNav = new B2WNavigationTasks();


	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");

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
		int  n = getRandomNumber();

	}

	public void testMain() throws Throwable {

		logCompare(true,b2wNav.clickHome(),"Go Home");
		logCompare(true,b2wNav.openJobs(),"Open jobs");
		logCompare(true,b2wNav.clickHome(),"Go Home");
		logCompare(true,b2wNav.openEmployees(),"Open Employees");

	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	
}
