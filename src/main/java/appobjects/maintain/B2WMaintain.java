package appobjects.maintain;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;
import appobjects.resources.KendoUI;

public class B2WMaintain extends KendoUI {

	 public static By getB2WMaintainGrid(){
		    return By.cssSelector(B2WUIMap.b2w_maintain_grid_content);
	 }
	 public static By getB2WMaintainDashboard(){
		  return By.cssSelector(B2WUIMap.b2w_maintaindashboard);
	 }
	 public static By getB2WMaintainRequests(){
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
	 public static By getB2WMaintainAddItemCreateButton() {
		 return By.cssSelector(B2WUIMap.b2w_maintainworkordercreateitembutton);
	 }
	 public static By getB2WMaintainWorkOrderDetailView() {
		 return By.cssSelector(B2WUIMap.b2w_maintainworkorderdetailcontentview);
	 }
	 
}
