package testcases;


import com.b2w.test.B2WTestCase;

import tasks.B2WHomeTasks;
import tasks.B2WNavigationTasks;
import tasks.setup.B2WUserTasks;


public class TestScript extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WUserTasks userTasks = new B2WUserTasks();


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
	public void testMain() throws Throwable {
		// code of the testcase
		// Steps would be open jobs, click on sort, etc
		
		//String sLastName = getEnvProperty("lastname");
		String sLastName = getProperty("mleduc_test1");
		test1();
		//System.out.println(b2wNav.getUserName());
		logCompare(true, b2wNav.openSetupUsers(),"Open");
		logCompare(true, userTasks.enterTextAndClickSearch("WOOO"),"Enter Text");
		
//		logCompare(true, userTasks.enterTextAndClickSearch(sLastName)," Search for: "+sLastName);
//		logCompare(true, userTasks.isLastNameInSearch(sLastName), "Found: "+sLastName);
//		logCompare(true, userTasks.openUserByLastName(sLastName), "Open the user by last name: "+sLastName);
//		logCompare(true, userTasks.clickEditButton(), "Edit User");
//		logCompare(true, userTasks.changeDispatchAccessToFullAccess(), "Change access on dispatch");
//		logCompare(true, userTasks.changeMaintainManagerAccessToFullAccess(), "Change maintain manager access to full");
//		logCompare(true, userTasks.changeMaintainMechanicAccessToFullAccess(), "Change maintain mechanic access to full");
//		logCompare(true, userTasks.changeTrackAccessToReadOnly(), "Change Track Access to Read Only");
//		logCompare(true, userTasks.clickBottomSaveButton(), "Save updated user");
	}
	
	public void test1() {
		B2WHomeTasks b2wHome = new B2WHomeTasks();
	}

}
