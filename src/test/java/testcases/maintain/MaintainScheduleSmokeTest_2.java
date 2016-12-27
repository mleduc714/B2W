package testcases.maintain;

import java.util.ArrayList;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.dialogs.B2WAddItemWorkOrder;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WEditScheduleMaintenance;
import tasks.dialogs.B2WMaintainSchedulePopupToolTip;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.util.TaskUtils;

public class MaintainScheduleSmokeTest_2 extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainDashboardTasks b2wDash = new B2WMaintainDashboardTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WMaintainTasks b2wMaintain = new B2WMaintainTasks();
	B2WWorkOrdersTasks b2wOrder = new B2WWorkOrdersTasks();
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
	B2WMaintainSchedulePopupToolTip tooltip = new B2WMaintainSchedulePopupToolTip();
	B2WEquipmentTasks b2wEquip = new B2WEquipmentTasks();
	B2WCompleteWorkOrder b2wComp = new B2WCompleteWorkOrder();
	
	String sWorkDescription, sUpdatedWorkDescription, sUpdatedWorkDescriptionA, sUpdatedWorkDescriptionB;
	
	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		int r = getRandomNumber();
		sWorkDescription = "Automation"+r;
		sUpdatedWorkDescription = "AutoUpdate"+r;
		sUpdatedWorkDescriptionA = "AutoEditWO"+r;
		sUpdatedWorkDescriptionB = "PastDueEdit"+r;
		super.testSetUp();
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return super.getCategory();
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return super.getAuthor();
	}

	@Override
	public String getTestDescription() {
		// TODO Auto-generated method stub
		return super.getTestDescription();
	}

	@Override
	public String getDataPath() {
		// TODO Auto-generated method stub
		return super.getDataPath();
	}

	@Override
	public boolean isSupported() {
		// TODO Auto-generated method stub
		return super.isSupported();
	}
	
	@Override
	public void testMain() throws Throwable {

		quickSchedule();
		wrenchOptionsScheduled();
		wrenchOptionsUnscheduled();
		wrenchOptionsPastDue();
	}
	
	public void quickSchedule() {

/*		Quick Schedule – New Work Order•Confirm Work Order & Work Order Items are created
		•Confirm that the Work Order is automatically approved
		•Confirm that you are brought back to Schedule Page & new Work Order is displayed

		•Tool Tip Information and Links within Tool Tip - click on a scheduled Work Order and unscheduled Work Order to confirm tool tip information and links

*/
		assertTrue("Open Maintain", b2wNav.openMaintain());
		assertTrue("Open Schedule", b2wMaintain.openRequests());
		ArrayList<String> equipment = new B2WMaintainRequestTasks().getEquipmentFromRequestsView();
		logCompare(true,b2wMaintain.openSchedule(),"Open Schedule");
		logCompare(true,b2wSchd.quickSchedule(), "Quick Schedule");
		String sEquipment = getRandomStringFromArrayList(equipment);
		logCompare(true,b2wOrder.selectEquipment(sEquipment), "Select Equipment");
		logCompare(true,b2wOrder.setWorkOrderDescription(sWorkDescription), "Set Description");
		b2wOrder.selectAnyPlannedWorkLocation();
		b2wOrder.selectPriorityFromDD("Medium");
		TaskUtils.sleep(1000);
		b2wOrder.clickNewItemButton();
		if (b2wAddItemWO.selectItemsToWorkOrderExists()) {
			if (b2wAddItemWO.addAllRequests()) {

				logCompare(true,b2wAddItemWO.clickFinishButton(),"Click Finish");
			} else {
				b2wAddItemWO.clickCreateAddItemButton();
				b2wAddItemWO.setAddItemDescription("AutoItem");
				b2wAddItemWO.setAddItemTypeFromDD("Repair");
				logCompare(true,b2wAddItemWO.clickCreateAddItemButton(), "Add Item");
			}
			
		}else{
			b2wAddItemWO.setAddItemDescription("AutoItem");
			b2wAddItemWO.setAddItemTypeFromDD("Repair");
			logCompare(true,b2wAddItemWO.clickCreateAddItemButton(), "Add Item");
		}
		logCompare(true,b2wOrder.clickSaveButton(),"Click Save");
		
		TaskUtils.sleep(1000);
		logCompare(true,b2wSchd.clickWorkOrderFromWorkOrderTabByDescription(sWorkDescription), "Click On Work Order to see if available");
		logCompare("Medium",tooltip.getPriority(), "Priority Match");
		logCompare(sEquipment, tooltip.getEquipment(), "Equipment Match");
		logCompare(true,tooltip.clickEquipmentLink(), "Click Equipment Link");
		logCompare(sEquipment, b2wEquip.getEquipmentHeadline(), "Equipment Opened");
		logCompare(true, b2wMaintain.openSchedule(), "Go back to schedule");
		logCompare(true,b2wSchd.clickWorkOrderFromWorkOrderTabByDescription(sWorkDescription), "Click On Work Order to see if available");
		logCompare("Medium",tooltip.getPriority(), "Priority Match");
		logCompare(sEquipment, tooltip.getEquipment(), "Equipment Match");
		String sWorkOrderTitle = tooltip.getWorkOrderTitle();
		logCompare(true,tooltip.clickWorkItemLink(), "Click Work Item Link");
		logCompare(sWorkOrderTitle, b2wOrder.getWorkOrderHeadline(), "work order headline");
	
	}
	
	public void wrenchOptionsScheduled() {
		/*Wrench Options - Scheduled Work Order•Edit Schedule
		•Un-schedule a scheduled Work Order
		•Find Nearby Maintenance - Map launches showing nearby Maintenance (confirm can Return to Schedule)
		•Edit Work Order - make an edit, save (confirm brought back to Schedule page)
		•Complete the Work Order - confirm removed from Schedule*/
		logCompare(true,b2wMaintain.openSchedule(),"Open Schedule");
		ArrayList<String> al = b2wSchd.getAllScheduledWorkOrders();
		String sWorkItem = al.get(0);
		//String sWorkItemID = sWorkItem.substring(sWorkItem.indexOf("["), sWorkItem.length());
		logCompare(true,b2wSchd.unscheduleWorkOrderByDescriptionWithWrench(sWorkItem), "Unschedule Work Order");
		logCompare(true,b2wSchd.clickConfirmYes(), "Confirm Yes");
		logCompare(false,b2wSchd.openWorkOrderByDescription(sWorkItem), "Work Item is not on schedule");
		logCompare(true, b2wSchd.openWorkOrderFromWorkOrderTabByDescription(sWorkItem), "Open Work Item");
		b2wSchMain.selectAnyMechanic();
		b2wSchMain.selectAnyWorkLocation();
		logCompare(true,b2wSchMain.saveScheduledMaintenance(), "Save Scheduled Maintenance");
		TaskUtils.sleep(2000);
		logCompare(true,b2wSchd.editWorkOrderByDescriptionWithWrench(sWorkItem), "Edit Work Order");
		logCompare(true,b2wOrder.setWorkOrderDescription(sUpdatedWorkDescription), "Update Desc");
		TaskUtils.sleep(1000);
		logCompare(true,b2wOrder.saveEditWorkOrder(), "Save Edit Work Order");
		TaskUtils.sleep(2000);
		logCompare(true,b2wSchd.completeWorkOrderByDescriptionWithWrench(sUpdatedWorkDescription), "Complete Work Order");
		logCompare(true,b2wComp.clickNextPage(), "click next page");
		logCompare(true,b2wComp.completeSave(), "Complete Save");
		logCompare(false,b2wSchd.openWorkOrderByDescription(sUpdatedWorkDescription), "Work Item is not on schedule");
	}

	public void wrenchOptionsUnscheduled() {
		logCompare(true,b2wMaintain.openSchedule(),"Open Schedule");
		ArrayList<String> al = b2wSchd.getWorkOrdersFromTab();
//		Schedule a Work Order
		logCompare(true,b2wSchd.scheduleWorkOrderFromWorkOrderTabByDescriptionWithWrench(al.get(0)), "Schedule Work Order");
		b2wSchMain.selectAnyMechanic();
		b2wSchMain.selectAnyWorkLocation();
		logCompare(true,b2wSchMain.saveScheduledMaintenance(), "Save Maintenance");
		TaskUtils.sleep(1000);
		logCompare(true,b2wSchd.clickWorkOrderByDescription(al.get(0)), "click work order");
		logCompare(true,tooltip.closeToolTip(), "Close tool tip");
		TaskUtils.sleep(5000);
//		•Un-approve an unscheduled Work Order
		logCompare(true,b2wSchd.unapproveWorkOrderFromWorkOrderTabByDescriptionWithWrench(al.get(1)), "Unapprove");
		logCompare(true,b2wSchd.clickConfirmYes(), "Confirm Yes");
		logCompare(false,b2wSchd.openWorkOrderFromWorkOrderTabByDescription(al.get(1)), "Open Work Order");
//		•Find Nearby Maintenance - Map launches showing nearby Maintenance (confirm can Return to Schedule)
//		•Edit Work Order - make an edit, save (confirm brought back to Schedule page)
		logCompare(true,b2wSchd.editWorkOrderFromWorkOrderTabByDescriptionWithWrench(al.get(2)), "Edit");
		logCompare(true,b2wOrder.setWorkOrderDescription(sUpdatedWorkDescriptionA), "Update Desc");
		TaskUtils.sleep(1000);
		logCompare(true,b2wOrder.saveEditWorkOrder(), "Save Edit Work Order");
		TaskUtils.sleep(2000);
		
//		•Complete a Work Order
		logCompare(true,b2wSchd.completeWorkOrderFromWorkOrderTabByDescriptionWithWrench(sUpdatedWorkDescriptionA), "Complete Work Order");
		logCompare(true,b2wComp.clickNextPage(), "click next page");
		logCompare(true,b2wComp.completeSave(), "Complete Save");
		logCompare(false,b2wSchd.openWorkOrderFromWorkOrderTabByDescription(sUpdatedWorkDescriptionA), "Work Item is not on schedule");

	}
	
	public void wrenchOptionsPastDue() {
/*		Edit Schedule - edit Start and End Date to current Date in order to schedule Work Order (verify Past Due WO after Date Edit change was added to schedule)
		•Unschedule Work Order
		•Find Nearby Maintenance - Map launches showing nearby Maintenance (confirm can Return to Schedule)
		•Edit Work Order - make an edit, save (confirm brought back to Schedule page)
		•Complete a Work Order
		
*/
		
		logCompare(true,b2wMaintain.openSchedule(),"Open Schedule");
		b2wSchd.clickPastDueWorkOrdersTab();
		TaskUtils.sleep(1000);
		ArrayList<String> al = b2wSchd.getPastDueWorkOrdersFromTab();
		if (al.size() > 2) {
			logCompare(true, b2wSchd.unscheduleWorkOrderFromPastDueTabByDescriptionWithWrench(al.get(0)),
					"Un Schedule Work Order");
			logCompare(true, b2wSchd.clickConfirmYes(), "Confirm Yes");
			logCompare(false, b2wSchd.openWorkOrderFromPastDueTabByDescription(al.get(0)),
					"Past Due Item has been removed");
			TaskUtils.sleep(1000);
			logCompare(true, b2wSchd.editscheduleWorkOrderFromPastDueTabByDescriptionWithWrench(al.get(1)), "Edit WO");
			b2wEditSch.selectAnyMechanic();
			logCompare(true, b2wEditSch.saveScheduleMaintenance(), "Save Maintenance");
			TaskUtils.sleep(1000);
			logCompare(true, b2wSchd.editWorkOrderFromPastDueTabByDescriptionWithWrench(al.get(1)), "Edit Work ");

			logCompare(true, b2wOrder.setWorkOrderDescription(sUpdatedWorkDescriptionB), "Update Desc");
			TaskUtils.sleep(1000);
			logCompare(true, b2wOrder.saveEditWorkOrder(), "Save Edit Work Order");
			TaskUtils.sleep(2000);

			logCompare(true, b2wSchd.completeWorkOrderFromPastDueTabByDescriptionWithWrench(sUpdatedWorkDescriptionB),
					"Complete Work Order");
			logCompare(true, b2wComp.clickNextPage(), "click next page");
			logCompare(true, b2wComp.completeSave(), "Complete Save");
			logCompare(false, b2wSchd.openWorkOrderFromPastDueTabByDescription(sUpdatedWorkDescriptionB),
					"Work Item is not on schedule");
		}
		
		

	
		
	}
	
}
