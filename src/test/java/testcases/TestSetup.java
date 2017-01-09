package testcases;

import java.text.SimpleDateFormat;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.dialogs.B2WAddItemWorkOrder;
import tasks.dialogs.B2WAddMaintenanceReqToWorkOrder;
import tasks.dialogs.B2WAddToInventory;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WEditScheduleMaintenance;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.jobs.B2WJobsTasks;
import tasks.maintain.B2WInventoryTasks;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainPartsTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.util.TaskUtils;


public class TestSetup extends B2WTestCase {



	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WJobsTasks b2wJob = new B2WJobsTasks();
	B2WMaintainDashboardTasks b2wDash = new B2WMaintainDashboardTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WMaintainTasks b2wMaintain = new B2WMaintainTasks();
	B2WWorkOrdersTasks b2wOrder = new B2WWorkOrdersTasks();
	B2WAddMaintenanceReqToWorkOrder addToWO = new B2WAddMaintenanceReqToWorkOrder();
	B2WMaintainProgramsTasks b2wMainPrograms = new B2WMaintainProgramsTasks();
	B2WAddInterval addInterval = new B2WAddInterval();
	B2WAddItemMaintenanceProgram b2wAddItem = new B2WAddItemMaintenanceProgram();
	B2WMaintainScheduleTasks b2wSchd = new B2WMaintainScheduleTasks();
	B2WScheduleMaintenance b2wSchMain = new B2WScheduleMaintenance();
	B2WCompleteWorkOrder b2wComplete = new B2WCompleteWorkOrder();
	B2WEditScheduleMaintenance b2wEditSch = new B2WEditScheduleMaintenance();
	B2WReportHours b2wReport = new B2WReportHours();
	B2WTimeCardTasks b2wtimecards = new B2WTimeCardTasks();
	B2WAddEquipmentToMainProgram b2wEquipmentProgram = new B2WAddEquipmentToMainProgram();
	B2WAddItemWorkOrder b2wAddItemWO = new B2WAddItemWorkOrder();
	B2WInventoryTasks inventory = new B2WInventoryTasks();
	B2WAddToInventory addInventory = new B2WAddToInventory();
	B2WMaintainPartsTasks parts = new B2WMaintainPartsTasks();
	B2WEquipmentTasks b2wE = new B2WEquipmentTasks();


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
		//int  n = getRandomNumber();

	}

	public void testMain() throws Throwable {

		assertTrue("open Maintain", b2wNav.openMaintain());
		b2wMaintain.openEquipment();
		b2wE.createNewEquipment();
		b2wE.expandComponentSpecs();
		b2wE.setComponentSpecsProductionDate("10/11/2016");
		TaskUtils.sleep(5000);
		
//		b2wMaintain.openPrograms();
//		b2wMainPrograms.selectItemOnMaintenanceProgram("Excavator 500 Hour Service");
//		System.out.println(b2wMainPrograms.getValueOfItem("Description"));
//		b2wMainPrograms.createNewMaintenanceProgram();
//		b2wMainPrograms.clickAddItem();
//		b2wAddItem.setAddItemDescription("TESTING");
//		b2wAddItem.selectAddItemPriority("High");
//		b2wAddItem.selectAddItemTypeFromDD("Repair");
//		b2wAddItem.setAddItemLevel("2");
//		b2wAddItem.saveItem();
//		
//		b2wMainPrograms.expandExclusions();
//		System.out.println(b2wMainPrograms.excludeJanuary());
		
/*		b2wMainPrograms.expandParts();
		b2wMainPrograms.clickAddParts();
		new B2WAddPartsToWorkItem().selectPartToAddToWorkItemByDescription("Seat belt");
		new B2WAddPartsToWorkItem().partsNext();
		new B2WAddPartsToWorkItem().setEstimatedQty("Seat belt", "10");
		new B2WAddPartsToWorkItem().saveParts();
		TaskUtils.sleep(5000);*/
		TaskUtils.sleep(5000);
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	
}
