package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WHomeTasks;
import tasks.B2WNavigationTasks;
import tasks.B2WSetupTasks;
import tasks.setup.B2WUserTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeA extends B2WTestCase {
	
	B2WUserTasks userTasks = new B2WUserTasks();
	B2WSetupTasks b2wSetup = new B2WSetupTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	String sLastName;
	
	B2WHomeTasks b2wHome = new B2WHomeTasks();

	
	
	@Override
	public void testTearDown() throws Throwable {
		
		
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
	
	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		sLastName = "LeDuc";
		super.testSetUp();
		//check do I need to remove access
		//removeAllAccess();
	}

	@Override
	public void testMain() throws Throwable {
/*		Navigate to Setup area and configure current user with full Track accesss
 		"JOBS", "TRACK", "RESOURCES", and "REPORTS" areas become availablei."Field Logs"  area becomes available under "TRACK"
		ii."Repair Requests" area becomes available under "TRACK"


		3.Add full Dispatch access to current usera."DISPATCH" area becomes available

		4.Add full Maintain Manager access to current usera."MAINTAIN" area becomes available*/


		removeAllAccess();
		assertFalse("Not open create field log", b2wHome.openTrackCreateFieldLog());
		assertFalse("Should not have access to Create Field Logs", b2wHome.openTrackViewFieldLogs());
		assertFalse("Should not have access to View Jobs link", b2wHome.openTrackViewJobs());

		//dispatch
		assertFalse("Should not see dispatch link to job board", b2wHome.openDispatchJobBoard());
		assertFalse("Should not see dispatch link to Delivery Orders",b2wHome.openDispatchDeliveryOrders());
		assertFalse("Should not see dispatch link to Equipment Moves",b2wHome.openDispatchEquipmentMoves());
		assertFalse("Should not see dispatch link to Trucking Orders",b2wHome.openDispatchTruckingOrders());
		assertFalse("Should not see dispatch link to Map Orders",b2wHome.openDispatchMapOrders());
		//maintain
		assertFalse("Should not see link to maintenance requests",b2wHome.openMaintainMaintenanceRequests());
		assertFalse("Should not see link to view work orders",b2wHome.openMaintainViewWorkOrders());
		assertFalse("Should not see link to schedule work orders",b2wHome.openMaintainViewScheduleWorkOrders());
		assertFalse("Should not see link to view equipment",b2wHome.openMaintainViewEquipment());

		//navigation
		assertFalse("MainTain link from Navigation panel should not be available", b2wNav.openMaintain());
		assertFalse("Dispatch link from Navigation panel should not be available", b2wNav.openDispatch());
		assertFalse("Jobs Link from Navigation panel should not be available", b2wNav.openJobs());
		assertFalse("Track Link from Navigation panel should not be available", b2wNav.openTrack());

		assertFalse("Open Reports from panel should not be available", b2wHome.openAdminReports());
		assertTrue("Open Manage Business Units", b2wHome.openAdminManageBusinessUnits());
		assertTrue("Click on home screen", b2wNav.clickHome());
		assertTrue("Open the link to add a user", b2wHome.openAdminAddAUser());
		assertTrue("Click on the home screen", b2wNav.clickHome());
		assertFalse("Unable to see the link to View Employees", b2wHome.openAdminViewEmployees());
		assertFalse("Unable to see the link to Manage Equipment", b2wHome.openAdminManageEquipment());

		// enable track
		assertTrue("Open Setup Users", b2wNav.openSetupUsers());
		assertTrue("Open the user",userTasks.openUserByLastName(sLastName));
		assertTrue("Edit the User",userTasks.clickEditButton());
		assertTrue("Add Full Track Access", userTasks.changeTrackAccessToFullAccess());
		assertTrue("Save the user", userTasks.clickTopSaveButton());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Track Link", b2wNav.openTrack());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open create field log", b2wHome.openTrackCreateFieldLog());
		assertTrue("Click Cancel to get out", b2wSetup.clickCancelButton());
		assertTrue("Dismiss Alert", TaskUtils.dismissAlert());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Track View Field Log",b2wHome.openTrackViewFieldLogs());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Track View Jobs", b2wHome.openTrackViewJobs());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Reports Link", b2wHome.openAdminReports());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Manage Business Units", b2wHome.openAdminManageBusinessUnits());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open link to add a user", b2wHome.openAdminAddAUser());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open View Employees", b2wHome.openAdminViewEmployees());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Manage Equipment", b2wHome.openAdminManageEquipment());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		// enable Dispatch
		assertTrue("Open Setup Users", b2wNav.openSetupUsers());
		assertTrue("Open the user",userTasks.openUserByLastName(sLastName));
		assertTrue("Edit the User",userTasks.clickEditButton());
		assertTrue("Add Full Track Access", userTasks.changeDispatchAccessToFullAccess());
		assertTrue("Save the user", userTasks.clickTopSaveButton());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
//		assertTrue("Open Dispatch from Navigation", b2wNav.openDispatch());
//		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open dispatch link to job board", b2wHome.openDispatchJobBoard());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open dispatch link to Delivery Orders",b2wHome.openDispatchDeliveryOrders());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open dispatch link to Equipment Moves",b2wHome.openDispatchEquipmentMoves());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open dispatch link to Trucking Orders",b2wHome.openDispatchTruckingOrders());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open dispatch link to Map Orders",b2wHome.openDispatchMapOrders());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		// enable 
		assertTrue("Open Setup Users", b2wNav.openSetupUsers());
		assertTrue("Open the user",userTasks.openUserByLastName(sLastName));
		assertTrue("Edit the User",userTasks.clickEditButton());
		assertTrue("Add Full Track Access", userTasks.changeMaintainManagerAccessToFullAccess());
		assertTrue("Add Full Track Access", userTasks.changeMaintainMechanicAccessToFullAccess());
		assertTrue("Save the user", userTasks.clickTopSaveButton());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		
		assertTrue("Open Maintenance requests",b2wHome.openMaintainMaintenanceRequests());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open Maintain work orders",b2wHome.openMaintainViewWorkOrders());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open maintain view schedule work orders",b2wHome.openMaintainViewScheduleWorkOrders());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open Maintain View Equipment",b2wHome.openMaintainViewEquipment());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open MainTain From Navigation", b2wNav.openMaintain());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
	}
	
	public void removeAllAccess() {
		assertTrue("Open Setup Users", b2wNav.openSetupUsers());
		logCompare("Michael LeDuc",b2wNav.getUserName(), "User Names");
		TaskUtils.logScreenCapture();
		assertTrue("Search for Last Name",userTasks.enterTextAndClickSearch(sLastName));
		assertTrue("Open the user",userTasks.openUserByLastName(sLastName));
		assertTrue("Edit the User",userTasks.clickEditButton());
	
		
		logCompare(true,userTasks.changeDispatchAccessToNone(),"Remove Dispatch");		
		logCompare(true,userTasks.changeMaintainManagerAccessToNone(),"Remove Maintain Manager Access");
		logCompare(true,userTasks.changeMaintainMechanicAccessToNone(),"Remove Maintain Mechanic Access");
		logCompare(true,userTasks.changeTrackAccessToNone(), "Remove Track Access");
		logCompare(true,userTasks.clickTopSaveButton(), "Save the user");
		assertTrue("Go Home",b2wNav.clickHome());

	}
	
	public void addAllAccess() {
		b2wNav.openSetupUsers();
		userTasks.openUserByLastName(sLastName);
		userTasks.clickEditButton();
		userTasks.changeDispatchAccessToFullAccess();
		userTasks.changeTrackAccessToFullAccess();
		userTasks.changeMaintainManagerAccessToFullAccess();
		userTasks.changeMaintainMechanicAccessToFullAccess();
		userTasks.clickTopSaveButton();
		b2wNav.clickHome();
	}
	
	


}
