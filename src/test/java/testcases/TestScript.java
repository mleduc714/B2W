package testcases;


import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.resources.B2WAccountTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.setup.B2WUserTasks;


public class TestScript extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WUserTasks userTasks = new B2WUserTasks();
	B2WAccountTasks b2wAct = new B2WAccountTasks();
	B2WEquipmentTasks b2wEquip = new B2WEquipmentTasks();


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
		//String sLastName = getProperty("mleduc_test1");
		test1();
		//System.out.println(b2wNav.getUserName());
		//logCompare(true, b2wNav.openSetupUsers(),"Open");
		//0ogCompare(true, userTasks.enterTextAndClickSearch("WOOO"),"Enter Text");
		
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
		b2wNav.openEquipment();
//		b2wEquip.createNewEquipment();
//		b2wEquip.setEquipmentDescription("TEST");
//		b2wEquip.setEquipmentID("Equipment ID");
//		b2wEquip.setEquipmentBusinessUnit("Hauling");
//		b2wEquip.setMobilityTypeRequiresMove();
//		b2wEquip.selectOwnershipTypeRented();
//		TaskUtils.sleep(1000);
		
		
	}

}
