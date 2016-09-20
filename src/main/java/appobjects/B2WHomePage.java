package appobjects;

import org.openqa.selenium.By;

public class B2WHomePage {
	
	public static By getB2WHomeAdminReports() {
		return By.cssSelector(B2WUIMap.b2w_home_admin_reports);
	}
	public static By getB2WHomeAdminManageUnits() {
		return By.cssSelector(B2WUIMap.b2w_home_admin_managebusinessunits);
	}
	public static By getB2WHomeAdminAddUser() {
		return By.cssSelector(B2WUIMap.b2w_home_admin_adduser);
	}
	public static By getB2WHomeAdminViewEmployees() {
		return By.cssSelector(B2WUIMap.b2w_home_admin_viewemployees);
	}
	public static By getB2WHomeAdminManageEquipment() {
		return By.cssSelector(B2WUIMap.b2w_home_admin_manageequipment);
	}
	public static By getB2WHomeTrackCreateFieldLogs() {
		return By.cssSelector(B2WUIMap.b2w_home_track_createfieldLogs);
	}
	public static By getB2WHomeTrackViewFieldLogs() {
		return By.cssSelector(B2WUIMap.b2w_home_track_viewfieldlogs);
	}
	public static By getB2WHomeTrackViewJobs() {
		return By.cssSelector(B2WUIMap.b2w_home_track_viewjobs);
	}
	public static By getB2WHomeDispatchViewJobBoard() {
		return By.cssSelector(B2WUIMap.b2w_home_dispatch_viewjobboard);
	}
	public static By getB2WHomeDispatchEquipmentMoves() {
		return By.cssSelector(B2WUIMap.b2w_home_dispatch_equipmentmoves);
	}
	public static By getB2WHomeDispatchTruckingOrders() {
		return By.cssSelector(B2WUIMap.b2w_home_dispatch_truckingorders);
	}
	public static By getB2WHomeDispatchDeliveryOrders() {
		return By.cssSelector(B2WUIMap.b2w_home_dispatch_deliveryorders);
	}
	public static By getB2WHomeDispatchViewMapOrders() {
		return By.cssSelector(B2WUIMap.b2w_home_dispatch_viewmap);
	}
	public static By getB2WHomeMaintainViewMaintenanceRequests() {
		return By.cssSelector(B2WUIMap.b2w_home_maintain_viewmaintainrequests);
	}
	public static By getB2WHomeMaintainViewWorkOrders() {
		return By.cssSelector(B2WUIMap.b2w_home_maintain_viewworkorders);
	}
	public static By getB2WHomeMaintainScheduleWorkOrders() {
		return By.cssSelector(B2WUIMap.b2w_home_maintain_scheduleworkorders);
	}
	public static By getB2WHomeMaintainViewEquipment() {
		return By.cssSelector(B2WUIMap.b2w_home_maintain_viewequipment);
	}
	public static By getB2WHomeMarketingPage() {
		return By.cssSelector(B2WUIMap.b2w_home_marketing);
	}
}
