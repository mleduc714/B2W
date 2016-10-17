package testcases;

import org.apache.log4j.Logger;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.resources.B2WAccountTasks;
import tasks.resources.B2WAddLaborTypeTasks;
import tasks.resources.B2WAddMaterialsTasks;
import tasks.resources.B2WEmployeeTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.resources.B2WEquipmentTypesTasks;
import tasks.resources.B2WPlaceTasks;
import tasks.setup.B2WUserTasks;

public class TestSetup extends B2WTestCase {

B2WNavigationTasks b2wNav = new B2WNavigationTasks();
B2WUserTasks userTasks = new B2WUserTasks();
B2WAccountTasks b2wAct = new B2WAccountTasks();
B2WEquipmentTasks b2wEquip = new B2WEquipmentTasks();
B2WEquipmentTypesTasks b2wEquipType = new B2WEquipmentTypesTasks();
B2WPlaceTasks b2wPlaces = new B2WPlaceTasks();
B2WAddMaterialsTasks b2wAdd = new B2WAddMaterialsTasks();
B2WEmployeeTasks b2wEmp = new B2WEmployeeTasks();
B2WAddLaborTypeTasks b2wLabor = new B2WAddLaborTypeTasks();
Logger log = Logger.getLogger(TestScript.class);

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
	b2wNav.openJobs();
	b2wNav.clickHome();
	b2wNav.openMaintain();
	b2wNav.clickHome();
	b2wNav.openTrack();
	b2wNav.clickHome();

	
	
}




@Override
public void testTearDown() throws Throwable {
	// TODO Auto-generated method stub
	super.testTearDown();
	
}


}
