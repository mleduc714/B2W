package testcases.maintain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.dialogs.B2WAddItemWorkOrder;
import tasks.dialogs.B2WAddMaintenanceReqToWorkOrder;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WEditScheduleMaintenance;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.util.TaskUtils;

public class MaintainScheduleSmokeTest extends B2WTestCase {

	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
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

	static SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
	static SimpleDateFormat dialogDate = new SimpleDateFormat("M/d/yyyy");
	Calendar calA = Calendar.getInstance();
	Calendar calB = Calendar.getInstance();
	Calendar calC = Calendar.getInstance();
	Calendar wOrder = Calendar.getInstance();

	String sMechanicA, sMechanicB, sMechanicC, sMechanicD, sMechanicE, sMechanicF, sLocation, sEvent, sWorkOrder;
	
	String sEquipment;
	String WODesc = "", sDueDate;
	String sItemDescA, sItemTypeA, sItemPriorityA;
	String sItemDescB, sItemTypeB, sItemPriorityB;
	String sWorkOrderId;

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		int r = getRandomNumber();
		sEquipment = "1007 [Yamaha Golf Cart]";
		WODesc = "AutoTest"+r;
		sItemDescA = "ItemNumber1"+r;
		sItemTypeA = "Inspection";
		sItemPriorityA = "Medium";
		sItemDescB = "ItemNumber2"+r;
		sItemTypeB = "Repair";
		sItemPriorityB = "Low";
		wOrder.add(Calendar.DAY_OF_YEAR, 10);
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

		assertTrue("Open Maintain", b2wNav.openMaintain()); 
		
		
		assertTrue("Open Schedule", b2wMaintain.openSchedule());
		// scheduleApprovedWorkOrder();

		calA.add(Calendar.DAY_OF_YEAR, 21);
		calB.add(Calendar.DAY_OF_YEAR, 22);

		// b2wSchd.getCurrentDate();
		scheduleApprovedWorkOrder();
		dragDropTest();
		verifyViews();
		verifyEquipmentView();
		createWorkOrders();
		deleteRequests();
	}

	public void setMechanics() {

		LinkedList<String> ll = b2wSchd.getAllMechanicsWithoutScheduledWorkItems();
		sMechanicA = ll.get(1);
		sMechanicB = ll.get(5);
		sMechanicC = ll.get(7);
		sMechanicD = ll.get(10);
		sMechanicE = ll.get(11);
		sMechanicF = ll.get(12);
	}

	public void scheduleApprovedWorkOrder() {

		assertTrue("Open Schedule", b2wMaintain.openSchedule());
		logCompare(true, b2wSchd.clickWorkOrdersTab(), "Click Work Orders Tab");
		if (b2wSchd.getWorkOrders() > 0) {
			b2wSchd.goToDate(sd.format(calA.getTime()));
			setMechanics();
			logCompare(true, b2wSchd.openWorkOrderFromWorkOrderTabByNumber(0), "Open Work Order");
			b2wSchMain.selectStartDate(sd.format(calA.getTime()));
			b2wSchMain.selectEndDate(sd.format(calA.getTime()));
			logCompare(true, b2wSchMain.selectMechanic(sMechanicA), "Select Mechanic");
			logCompare(true, b2wSchMain.selectMechanic(sMechanicB), "Select Mechanic");
			// logCompare(true, b2wSchMain.selectMechanic(sMechanicC), "Select
			// Mechanic");
			sLocation = b2wSchMain.selectAnyWorkLocation();
			sEvent = b2wSchMain.selectAnyEvent();
			sWorkOrder = b2wSchMain.getWorkOrderDescription();
			logCompare(true, b2wSchMain.saveScheduledMaintenance(), "Save Scheduled Maintenance");
			// verify scheduled
			logCompare(true, !b2wSchd.getAllMechanicsWithoutScheduledWorkItems().contains(sMechanicA),
					sMechanicA + " has been scheduled");
			logCompare(true, !b2wSchd.getAllMechanicsWithoutScheduledWorkItems().contains(sMechanicB),
					sMechanicB + " has been scheduled");
			logCompare(true, b2wSchd.getAllMechanicsWithoutScheduledWorkItems().contains(sMechanicC),
					sMechanicC + " has not been scheduled");

		}

	}

	public void dragDropTest() {

		b2wSchd.dragDropWorkOrderToAnotherMechanic(sd.format(calA.getTime()), sd.format(calA.getTime()), sWorkOrder,
				sMechanicC);
		TaskUtils.sleep(1000);
		logCompare(true, b2wSchd.getAllMechanicsWithoutScheduledWorkItems().contains(sMechanicA),
				sMechanicA + " has been de-scheduled");
		logCompare(true, !b2wSchd.getAllMechanicsWithoutScheduledWorkItems().contains(sMechanicB),
				sMechanicB + " has been scheduled");
		logCompare(true, !b2wSchd.getAllMechanicsWithoutScheduledWorkItems().contains(sMechanicC),
				sMechanicC + " has been scheduled");
		// logCompare(true,
		// !b2wSchd.getAllMechanicsWithoutScheduledWorkItems().contains(sMechanicD),
		// sMechanicD + " has been scheduled");
		logCompare(true, b2wSchd.openWorkOrderByDescription(sWorkOrder), "Open Work Order");
		logCompare(true, b2wEditSch.getMechanicsScheduled().contains(sMechanicB), sMechanicB + " has been scheduled");
		logCompare(true, b2wEditSch.getMechanicsScheduled().contains(sMechanicC), sMechanicC + " has been scheduled");
		logCompare(false, b2wEditSch.getMechanicsScheduled().contains(sMechanicA),
				sMechanicA + " has not been scheduled");
		b2wEditSch.cancelScheduledMaintenance();
		b2wSchd.dragDropWorkOrderToDate(sMechanicB, sWorkOrder, sd.format(calA.getTime()), sd.format(calB.getTime()));
		logCompare(true, b2wSchd.openWorkOrderByDescription(sWorkOrder), "Open rescheduled work order");
		logCompare(dialogDate.format(calB.getTime()), b2wEditSch.getStartDate(), "Compare Dates");
		b2wEditSch.cancelScheduledMaintenance();

	}

	public void verifyViews() {
		
		b2wSchd.clickDayView();
		b2wSchd.goToDate(sd.format(calB.getTime()));
		logCompare(true, b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		calB.add(Calendar.DAY_OF_YEAR, 2);
		b2wEditSch.selectStartDate(dialogDate.format(calB.getTime()));
		logCompare(true, b2wEditSch.saveScheduleMaintenance(), "Save adding 3 dates");
		TaskUtils.sleep(2000);
		logCompare(false,b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		TaskUtils.sleep(2000);
		logCompare(true,b2wSchd.clickThreeDayView(), "Open Three Day View");
		TaskUtils.sleep(4000);
		logCompare(true,b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		calB.add(Calendar.DAY_OF_YEAR, 4);
		b2wEditSch.selectStartDate(dialogDate.format(calB.getTime()));
		logCompare(true, b2wEditSch.saveScheduleMaintenance(), "Save adding 4 dates");
		TaskUtils.sleep(2000);
		logCompare(false,b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		TaskUtils.sleep(2000);
		logCompare(true,b2wSchd.clickWeekView(), "Open Week View");
		TaskUtils.sleep(4000);
		logCompare(true,b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		calB.add(Calendar.DAY_OF_YEAR, 4);
		b2wEditSch.selectStartDate(dialogDate.format(calB.getTime()));
		logCompare(true, b2wEditSch.saveScheduleMaintenance(), "Save adding 4 dates");
		TaskUtils.sleep(2000);
		logCompare(false,b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		TaskUtils.sleep(2000);
		logCompare(true,b2wSchd.clickTwoWeekView(), "Two Week View");
		TaskUtils.sleep(4000);
		logCompare(true,b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		logCompare(true,b2wEditSch.cancelScheduledMaintenance(), "Cancel Maintenance");
		
	}

	public void verifyEquipmentView() {
		TaskUtils.sleep(2000);
		b2wSchd.clickEquipmentView();
		TaskUtils.sleep(4000);
		logCompare(true,b2wSchd.openWorkOrderByDescription(sWorkOrder), "open work order");
		logCompare(true,b2wEditSch.cancelScheduledMaintenance(), "Cancel Maintenance");
		
	}
	
	public void createWorkOrders(){
		

	
		assertTrue("Open Work Orders",b2wMaintain.openWorkOrders());
		logCompare(true, b2wOrder.clickCreateNewWorkOrderButton(), "Create New Work Order");
		logCompare(true, b2wOrder.selectEquipment(sEquipment), "Select "+sEquipment+" Equipment");
		logCompare(true, b2wOrder.setWorkOrderDescription(WODesc), "Set Work");
		//logCompare(true, b2wOrder.setDueDate(sDueDate), "Due Date");
		logCompare(true, b2wOrder.selectPlannedWorkedLocation("Field"), "Planned in the Field");
		logCompare(true, b2wOrder.selectPriorityFromDD("Medium"), "Medium Priority");
		logCompare(true, b2wOrder.setWorkOrderNotes("Automation Created this work order"), "Set Notes");
		logCompare(true, b2wAddItemWO.clickNewItemButton(), "Add new item for work order");
		logCompare(true, b2wAddItemWO.setAddItemDescription(sItemDescA), "Add Item Description");
		logCompare(true, b2wAddItemWO.setAddItemTypeFromDD(sItemTypeA), "Type");
		logCompare(true, b2wAddItemWO.setAddItemPriorityFromDD(sItemPriorityA), "Medium Priority");
		logCompare(true, b2wAddItemWO.clickCreateAddItemButton(),"Create add Item");
		logCompare(true, b2wAddItemWO.clickNewItemButton(), "Add new item for work order");
		logCompare(true, b2wAddItemWO.setAddItemDescription(sItemDescB), "Add Item Description");
		logCompare(true, b2wAddItemWO.setAddItemTypeFromDD(sItemTypeB), "Type");
		logCompare(true, b2wAddItemWO.setAddItemPriorityFromDD(sItemPriorityB), "Medium Priority");
		logCompare(true, b2wAddItemWO.clickCreateAddItemButton(),"Create add Item");
		logCompare(true, b2wOrder.clickSaveButton(), "Click Save Button");
		logCompare(true, b2wOrder.selectWorkOrderByDescription(WODesc), "Select Work Order");
		sWorkOrderId = b2wOrder.getSelectWorkOrderID();
		logCompare(true, b2wOrder.clickApproveButton(), "Approve the Work Order");
		logCompare(true, b2wOrder.clickConfirmYes(), "Confirm Approve");
		assertTrue("Open Schedule",b2wMaintain.openSchedule());
		setMechanics();
		b2wSchd.openWorkOrderFromWorkOrderTabByDescription(sEquipment + " ["+sWorkOrderId+"]");
		TaskUtils.sleep(1000);
		logCompare(true, b2wSchMain.uncheckWorkItem(sItemDescA), "Uncheck Item");
		logCompare(true, b2wSchMain.selectMechanic(sMechanicE), "Select E");
		b2wSchMain.selectAnyWorkLocation();
		b2wSchMain.selectAnyEvent();
		logCompare(true, b2wSchMain.saveScheduledMaintenance(), "Save Scheduled Maintenance");
		TaskUtils.sleep(1000);
		b2wSchd.openWorkOrderFromWorkOrderTabByDescription(sEquipment + " ["+sWorkOrderId+"]");
		//logCompare(true, b2wSchMain.uncheckWorkItem(sItemDescA), "Uncheck Item");
		logCompare(true, b2wSchMain.selectMechanic(sMechanicF), "Select E");
		b2wSchMain.selectAnyWorkLocation();
		b2wSchMain.selectAnyEvent();
		b2wSchMain.selectStartDate(dialogDate.format(wOrder.getTime()));
		logCompare(true, b2wSchMain.saveScheduledMaintenance(), "Save Scheduled Maintenance");
		TaskUtils.sleep(5000);
		
		

	}
	
	public void deleteRequests() {
		
		
		logCompare(true,b2wMaintain.openSchedule(),"Open Schedule");
		logCompare(true,b2wSchd.unscheduleWorkOrderByDescription(WODesc), "Unschedule Work ORder");
		logCompare(true,b2wSchd.clickConfirmYes(), "Confirm");
		logCompare(true,b2wSchd.goToDate(sd.format(wOrder.getTime())), "Go to date");
		logCompare(true,b2wSchd.unscheduleWorkOrderByDescription(WODesc), "Unschedule Work ORder");
		logCompare(true,b2wSchd.clickConfirmYes(), "Confirm");
		
		logCompare(true,b2wSchd.unapproveWorkOrderFromWorkOrderTabByDescription(WODesc), "Unapprove WO");
		logCompare(true,b2wSchd.clickConfirmYes(), "Confirm");
		b2wMaintain.openWorkOrders();
		logCompare(true,b2wOrder.selectWorkOrderByDescription(WODesc),"Select Work Order");
		logCompare(true,b2wOrder.deleteWorkOrder(), "Delete WO");
		b2wMaintain.openRequests();
		logCompare(true,b2wRequests.selectRequestByDescription(sItemDescA), "Select Request");
		logCompare(true,b2wRequests.deleteRequest(),"Delete Request");
		logCompare(true,b2wRequests.selectRequestByDescription(sItemDescB),"Select Request");
		logCompare(true,b2wRequests.deleteRequest(), "Delete Request");
	}
	
}
