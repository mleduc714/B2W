package appobjects.maintain;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;
import appobjects.resources.KendoUI;

public class B2WMaintain extends KendoUI {

	public static By getB2WMaintainGrid() {
		return By.cssSelector(B2WUIMap.b2w_maintain_grid_content);
	}

	public static By getB2WMaintainDashboard() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboard);
	}

	public static By getB2WMaintainRequests() {
		return By.cssSelector(B2WUIMap.b2w_maintainrequests);
	}

	public static By getB2WMaintainWorkOrders() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorders);
	}

	public static By getB2WMaintainSchedule() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedule);
	}

	public static By getB2WMaintainTimeCards() {
		return By.cssSelector(B2WUIMap.b2w_maintaintimecards);
	}

	public static By getB2WMaintainPrograms() {
		return By.cssSelector(B2WUIMap.b2w_maintainprograms);
	}

	public static By getB2WMaintainEquipment() {
		return By.cssSelector(B2WUIMap.b2w_maintainequipment);
	}

	public static By getB2WMaintainParts() {
		return By.cssSelector(B2WUIMap.b2w_maintainparts);
	}

	public static By getB2WMaintainInventory() {
		return By.cssSelector(B2WUIMap.b2w_maintaininventory);
	}

	public static By getB2WMaintainPurchasing() {
		return By.cssSelector(B2WUIMap.b2w_maintainpurchasing);
	}

	public static By getB2WMaintainPageMenu() {
		return By.cssSelector(B2WUIMap.b2w_maintainpagemenu);
	}

	public static By getB2WDashboardWorkOrderHeader() {
		return By.cssSelector("span.category_headers");
	}

	public static By getB2WMaintainBoxContent() {
		return By.cssSelector(B2WUIMap.b2w_maintainkendocontentform);
	}

	public static By getB2WMaintainButtonsContainer() {
		return By.cssSelector(B2WUIMap.b2w_maintainkendoitemsbuttoncontainer);
	}

	public static By getB2WMaintainAddItemDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainadditemsdialog);
	}

	public static By getB2WMaintainAddItemDialogContent() {
		return By.cssSelector(B2WUIMap.b2w_maintainkendodialogcontentform);
	}

	public static By getB2WMaintainAddItemSaveButton() {
		return By.cssSelector(B2WUIMap.b2w_maintainadditemsavebutton);
	}

	public static By getB2WMaintainAddItemLevel() {
		return By.cssSelector(B2WUIMap.b2w_kendoinputkinput);
	}

	public static By getB2WMaintainAddIntervalButton() {
		return By.cssSelector(B2WUIMap.b2w_maintainaddintervalbutton);
	}

	public static By getB2WMaintainAddIntervalDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainintervaldialog);
	}

	public static By getB2WMaintainRequestCreateView() {
		return By.cssSelector(B2WUIMap.b2w_maintainrequestcreateview);
	}

	public static By getB2WMaintainItemActions() {
		return By.cssSelector(B2WUIMap.b2w_maintainitemactions);
	}

	public static By getB2WMaintainEditFormContent() {
		return By.cssSelector(B2WUIMap.b2w_maintainrequesteditformcontent);
	}

	public static By getB2WNewMaintanceRequestNewCommentButton() {
		return By.cssSelector(B2WUIMap.b2w_maintainrequestedcommentbutton);
	}

	public static By getB2WMaintainNewWorkOrderView() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkordersview);
	}

	public static By getB2WMaintainNewWorkItemAddItemButton() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderadditembutton);
	}

	public static By getB2WMaintainAddItemToWorkOrder() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderadditemview);
	}
	public static By getB2WMaintainSelectItemsToWorkOrder() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderselectitemsview);
	}

	public static By getB2WMaintainAddItemCreateButton() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkordercreateitembutton);
	}

	public static By getB2WMaintainWorkOrderDetailView() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderdetailcontentview);
	}

	public static By getB2WMaintainScheduleMechanicsView() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulemechanics);
	}

	public static By getB2WMaintainScheduleEquipmentView() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleequipment);
	}

	public static By getB2WMaintainSchedulerToolbar() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulertoolbar);
	}

	public static By getB2WMaintainSchedulerArrowWest() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerclickwest);
	}

	public static By getB2WMaintainSchedulerArrowEast() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerclickeast);
	}

	public static By getB2WMaintainScheduleTodayButton() {
		return By.linkText(B2WUIMap.b2w_maintainscheduletodaylink);
	}

	public static By getB2WMaintainScheduleDayView() {
		return By.linkText(B2WUIMap.b2w_maintainscheduledaylink);
	}

	public static By getB2WMaintainScheduleThreeDaysView() {
		return By.linkText(B2WUIMap.b2w_maintainscheduleThreeDayslink);
	}

	public static By getB2WMaintainScheduleWeekView() {
		return By.linkText(B2WUIMap.b2w_maintainscheduleweeklink);
	}

	public static By getB2WMaintainScheduleTwoWeekView() {
		return By.linkText(B2WUIMap.b2w_maintainscheduletwoweekslink);
	}

	public static By getB2WMaintainschedulernewworkorderbutton() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulernewworkorderbutton);
	}

	public static By getB2WMaintainschedulerfilterbutton() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerfilterbutton);
	}
	public static By getB2WMaintainschedulertabone() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulertabone);
	}
	public static By getB2WMaintainschedulertabtwo() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulertabtwo);
	}
	public static By getB2WMaintainschedulerworkorderunscheduled() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerworkorderunscheduled);
	}
	public static By getB2WMaintainschedulerworkordersummary() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerworkordersummary);
	}
	public static By getB2WMaintainschedulerunscheduledworkorderslist() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerunscheduledworkorderslist);
	}
	public static By getB2WMaintainschedulerpastdueworkorderlist() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerpastdueworkorderlist);
	}
	public static By getB2WMaintainschedulerpastdueworkorder() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerpastdueworkorder);
	}
	public static By getB2WMaintainSchedulerContent() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulercontent);
	}
	public static By getB2WMaintainSchedulerEvents() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerevents);
	}
	public static By getB2WMaintainWorkOrdersList() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerworkorderslist);
	}
	public static By getB2WMaintainSchedulerToolTip() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulertooltip);
	}
	public static By getB2WMaintainSchedulerEditSchedulePopupWindow() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulereditschedule);
	}
	public static By getB2WMaintainSchedulerScheduleMaintenancePopupWindow() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerschedulemaintenance);
	}
	public static By getB2WMaintainSchedulerUnscheduledContextMenu() {
		return By.cssSelector(B2WUIMap.unscheduledWorkOrdersContextMenu);
	}
	public static By getB2WMaintainSchedulerWorkOrdersTab() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulertabone);
	}
	public static By getB2WMaintainSchedulerPastDueWorkOrdersTab() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulertabtwo);
	}
	public static By getB2WMaintainTimeCardDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainnewtimecardpopup);
	}
	public static By getB2WMaintainTimeCardAddTimeButton() {
		return By.cssSelector(B2WUIMap.b2w_maintainnewtimecardaddtimebutton);
	}
	public static By getB2WMaintainReportHoursDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainreporthoursdialog);
	}
	public static By getB2WMaintainNewTimeCardButton() {
		return By.cssSelector(B2WUIMap.b2w_schedules_createscheduleviewbtn);
	}
	public static By getB2WMaintainTimeCardDetailContent() {
		return By.cssSelector(B2WUIMap.b2w_maintaintimecarddetailcontentview);
	}
	public static By getB2WMaintainExpandButton() {
		return By.cssSelector(B2WUIMap.b2w_maintainexpandbutton);
	}
	public static By getB2WMaintainSubNavMenu() {
		return By.cssSelector(B2WUIMap.b2w_maintainsubnavmenu);
	}
	public static By getB2WMaintainCollapseButton() {
		return By.cssSelector(B2WUIMap.b2w_maintaincollapsebutton);
	}
	public static By getB2WAddProgramDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainequipmentaddprogram);
	}
	public static By getB2WAddPartsToWorkOrder() {
		return By.cssSelector(B2WUIMap.b2w_maintainequipmentaddprogram);
	}
	
	
	
}
