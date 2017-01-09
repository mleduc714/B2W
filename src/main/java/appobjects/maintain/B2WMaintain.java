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

	public static By getB2WMaintainWorkOrderEditView() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderseditview);
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

	public static By getB2WMaintainScheduleLinkViews() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleviewlinks);
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
		return By.cssSelector(B2WUIMap.b2w_maintainschedulerunscheduledpastduelist);
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
		return By.cssSelector(B2WUIMap.unscheduledworkorderscontextmenu);
	}

	public static By getB2WMaintainSchedulerEmptySlotContextMenu() {
		return By.cssSelector(B2WUIMap.scheduleremptyslotcontextmenu);
	}

	public static By getB2WMaintainSchedulerScheduledContextMenu() {
		return By.cssSelector(B2WUIMap.scheduleworkorderscontentmenu);
	}

	public static By getB2WMaintainSchedulerScheduledWrenchMenu() {
		return By.cssSelector(B2WUIMap.scheduleworkorderscontentmenuwrench);
	}

	public static By getB2WMaintainSchedulerUnscheduledWrenchMenu() {
		return By.cssSelector(B2WUIMap.unscheduledworkorderscontentmenuwrench);
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

	public static By getB2WPlannedHours() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderplannedhours);
	}

	public static By getB2WAddPartsDialogQuanities() {
		return By.cssSelector(B2WUIMap.b2w_addpartstoworkorderquanitiesgrid);
	}

	public static By getB2WCompleteWorkItemsTitle() {
		return By.cssSelector(B2WUIMap.b2w_kendoworkorderitemstitle);
	}

	public static By getB2WWorkItemCompleteMeters() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkordercomplete);
	}

	public static By getB2WorkItemCompleteDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkordercompletedialog);
	}

	public static By getB2WMaintainScheduleCurrentView() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulecurrentview);
	}

	public static By getB2WMaintainDashboardUserInfo() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboarduserinfo);
	}

	public static By getB2WMaintainDashboardDate() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboarddate);
	}

	public static By getB2WMaintainDashboardUpdated() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardupdated);
	}

	public static By getB2WMaintainDashboardRefresh() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardrefresh);
	}

	public static By getB2WMaintainDashboardNewRequests() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardnewrequests);
	}

	public static By getB2WMaintainDashboardRequestsAndAssigned() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardrequestedandassigned);
	}

	public static By getB2WMaintainDashboardUnscheduleWorkOrders() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardunscheduledworkorders);
	}

	public static By getB2WMaintainDashboardPastDue() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardpastdue);
	}

	public static By getB2WMaintainDashboardPendingCards() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardpendingtimecards);
	}

	public static By getB2WMaintainDashboardWorkOrderList() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkorderlist);
	}

	public static By getB2WMaintainDashboardWorkOrders() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkorders);
	}

	public static By getB2WMaintainDashboardTimeCards() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardtimecards);
	}

	public static By getB2WMaintainDashboardWorkOrdersContent() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkorderscontent);
	}

	public static By getB2WMaintainDashboardWorkOrderContainer() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkordercontainer);
	}

	public static By getB2WMaintainDashboardYearToDateLink() {
		return By.linkText(B2WUIMap.b2w_maintaindashboardyeartodatelink);
	}

	public static By getB2WMaintainDashboardMonthToDateLink() {
		return By.linkText(B2WUIMap.b2w_maintaindashboardmonthtodatelink);
	}

	public static By getB2WMaintainDashboardTimeCardsLink() {
		return By.linkText(B2WUIMap.b2w_maintaindashboardtimecardslink);
	}

	public static By getB2WMaintainDashboardViewWorksLink() {
		return By.linkText(B2WUIMap.b2w_maintaindashboardviewworkorderslink);
	}

	public static By getB2WMaintainDashboardWorkOrderTitle() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkordertitle);
	}

	public static By getB2WMaintainDashboardNumber() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardnumber);
	}

	public static By getB2WMaintainDashboardWorkOrderData() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkorderdata);
	}

	public static By getB2WMaintainSchedulePopup() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardscheduletooltip);
	}

	public static By getB2WMaintainSchedulePopupContent() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardscheduletooltip);
	}

	public static By getB2WMaintainSchedulePopupWorkOrderTitle() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulepopupworkordertitle);
	}

	public static By getB2WMaintainSchedulePopupWorkOrderTime() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulepopupworkourdertime);
	}

	public static By getB2WMaintainSchedulePopupWarning() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulepopupwarning);
	}

	public static By getB2WMaintainSchedulePopupSectionTitle() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulepopupsectiontitle);
	}

	public static By getB2WMaintainSchedulePopupClose() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulepopupclose);
	}

	public static By getB2WMaintainDashboardWorkOrdersFilter() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardscheduledworkOrdersfilterbutton);
	}

	public static By getB2WMaintainDashboardFiltersDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleworkorderfilters);
	}

	public static By getB2WMaintainDashboardFiltersApply() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleworkorderfilterapply);
	}

	public static By getB2WMaintainDashboardFiltersCancel() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleworkorderfiltercancel);
	}

	public static By getB2WMaintainRequestsAddToWorkOrder() {
		return By.cssSelector(B2WUIMap.b2w_maintainrequestsaddtoworkorder);
	}

	public static By getB2WMaintainRequestAddToWorkOrderDialog() {
		return By.cssSelector(B2WUIMap.b2w_maintainrequestsaddtoworkorderdialog);
	}

	public static By getB2WMaintainWorkOrderListView() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderslistview);
	}

	public static By getB2WMaintainRequestListView() {
		return By.cssSelector(B2WUIMap.b2w_maintainrequestlistview);
	}

	public static By getB2WMaintainWorkOrderShortDate() {
		return By.xpath(B2WUIMap.b2w_maintainworkordersduedate);
	}

	public static By getB2WMaintainWorkOrderStatus() {
		return By.xpath(B2WUIMap.b2w_maintainworkorderstatus);
	}

	public static By getB2WMaintainRequestOrderStatus() {
		return By.xpath(B2WUIMap.b2w_maintainrequestsstatus);
	}

	public static By getB2WMaintainSchedulerScheduleMaintenancePopupWindowWorkOrder() {
		return By.xpath(B2WUIMap.b2w_schedulemaintenancedialogworkorder);
	}

	public static By getB2WMaintainSchedulerScheduleMaintenancePopupWindowEquipment() {
		return By.xpath(B2WUIMap.b2w_schedulemaintenancedialogequipment);
	}

	public static By getB2WMaintainDashboardWorkOrdersChartsLeft() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderscharts);
	}

	public static By getB2WMaintainScheduleTable() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduletable);
	}

	public static By getB2WMaintainScheduleNonWorkHour() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulenonworkhour);
	}

	public static By getB2WMaintainScheduleTimes() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduletimes);
	}

	public static By getB2WMaintainScheduleHeader() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleheader);
	}

	public static By getB2WWorkOrderScheduler() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleworkorder);
	}

	public static By getB2WProgramGenerateItem() {
		return By.cssSelector(B2WUIMap.b2w_maintainprogramgeneraterequestlink);
	}

	public static By getB2WWorkOrderStatus() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderdisplaystatus);
	}

	public static By getB2WWorkItemTable() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkordertable);
	}

	public static By getB2WDashboardWorkOrderChart() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkordercharts);
	}

	public static By getB2WDashboardWorkOrderChartPopUp() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkorderpopupchart);
	}

	public static By getB2WDashboardWorkOrderManHoursByMechanic() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkordermanorderchart);
	}

	public static By getB2WDashboardWorkOrderManHoursChart() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardmanhrscharts);
	}

	public static By getB2WPriorityofItem() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardpriority);
	}

	public static By getB2WWorkOrderItems() {
		return By.cssSelector(B2WUIMap.b2w_maintainworkorderitemslist);
	}

	public static By getB2WDashboardWorkOrderRightChart() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardworkorderchartright);
	}

	public static By getB2WDashboardNoData() {
		return By.cssSelector(B2WUIMap.b2w_maintaindashboardnodata);
	}

	public static By getB2WScheduleDatePickerButton() {
		return By.cssSelector(B2WUIMap.b2w_scheduledatepicker);
	}

	public static By getB2WScheduleDatePicker() {
		return By.cssSelector(B2WUIMap.b2w_scheduledatecalendar);
	}

	public static By getB2WScheduleDatePickerMonthDate() {
		return By.cssSelector(B2WUIMap.b2w_scheduledatemonth);
	}

	public static By getB2WScheduleFormatDate() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleformatteddate);
	}

	public static By getB2WScheduleSmallFormatDate() {
		return By.cssSelector(B2WUIMap.b2w_maintainscheduleformatsmalldate);
	}

	public static By getMaintainEquipmentDetailView() {
		return By.cssSelector(B2WUIMap.b2w_maintainequipmentdetailview);
	}
	public static By getMaintainPartDetailView() {
		return By.cssSelector(B2WUIMap.b2w_maintainpartdetailview);
	}
	public static By getMaintainProgramDetailView() {
		return By.cssSelector(B2WUIMap.b2w_maintainprogramdetailview);
	}
	public static By getMaintainEquipmentHistoryView() {
		return By.cssSelector(B2WUIMap.b2w_equipmenthistorylistview);
	}

	public static By getMaintainEquipmentPartsView() {
		return By.cssSelector(B2WUIMap.b2w_equipmentpartslistview);
	}

	public static By getMaintainEquipmentMetersView() {
		return By.cssSelector(B2WUIMap.b2w_equipmentmeterlistview);
	}

	public static By getMaintainEquipmentWarrantiesView() {
		return By.cssSelector(B2WUIMap.b2w_equipmentwarratieslistview);
	}

	public static By getMaintainScheduleWrench() {
		return By.cssSelector(B2WUIMap.b2w_maintainschedulewrenchicon);
	}

	public static By getMaintainEquipmentLogDatePicker() {
		return By.cssSelector(B2WUIMap.b2w_equipmentlogdatepicker);
	}

	public static By getMaintainEquipmentLogCancelIcon() {
		return By.cssSelector(B2WUIMap.b2w_equipmentlogcancelicon);
	}

	public static By getMaintainEquipmentLogDeleteIcon() {
		return By.cssSelector(B2WUIMap.b2w_equipmentlogdeleteicon);
	}

	public static By getMaintainEquipmenttagslistview() {
		return By.cssSelector(B2WUIMap.b2w_equipmenttagslistview);
	}

	public static By getMaintainEquipmentcrewslistview() {
		return By.cssSelector(B2WUIMap.b2w_equipmentcrewslistview);
	}

	public static By getMaintainEquipmenteventslistivew() {
		return By.cssSelector(B2WUIMap.b2w_equipmenteventslistivew);
	}

	public static By getMaintainEquipmentLogSaveIcon() {
		return By.cssSelector(B2WUIMap.b2w_equipmentlogsaveicon);
	}
	public static By getMaintainInventoryDetails() {
		return By.cssSelector(B2WUIMap.b2w_inventorycollapsedetail);
	}
	public static By getMaintainInventoryAlocatedInventory() {
		return By.cssSelector(B2WUIMap.b2w_inventoryallocatedtooltip);
	}
	public static By getMaintainPartsListView() {
		return By.cssSelector(B2WUIMap.b2w_maintainpartslistview);
	}
	public static By getMaintainPartsAddWarranty() {
		return By.cssSelector(B2WUIMap.b2w_maintainpartaddwarranty);
	}
	public static By getMaintainPartWarrantyList() {
		return By.cssSelector(B2WUIMap.b2w_maintainpartwarrantydurationlist);
	}
	public static By getMaintainRequestDetailView() {
		return By.cssSelector(B2WUIMap.b2w_requestdetailview);
	}
	public static By getMaintainSearchFilterList(){
		return By.cssSelector(B2WUIMap.b2w_searchfilterlist);
	}

}
