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
	public static By getB2WHomeViewSchedules() {
		return By.cssSelector(B2WUIMap.b2w_home_view_schedules);
	}
	public static By getB2WHomeSetupSchedules() {
		return By.cssSelector(B2WUIMap.b2w_home_setup_schedules);
	}
	public static By getB2WHomeSetupCrewTemplates() {
		return By.cssSelector(B2WUIMap.b2w_home_setup_crew_templates);
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
	public static By getB2WFrame() {
		return By.cssSelector(B2WUIMap.b2w_frame);
	}
	public static By getAddDashboardButton() {
		return By.cssSelector(B2WUIMap.b2w_changedashboardbutton);
	}
	public static By getUserSettingsBodyPanel() {
		return By.cssSelector(B2WUIMap.b2w_usersettingbodypanel);
	}
	public static By getAddDashboardOKButton() {
		return By.cssSelector(B2WUIMap.b2w_adddashboardokbutton);
	}
	public static By getManagerHomePageCostDashboard() {
		return By.cssSelector(B2WUIMap.b2w_dashboardmanagerhomepagecost);
	}
	public static By getManagerHomePageProductionDashboard() {
		return By.cssSelector(B2WUIMap.b2w_dashboardmanagerhomepageproduction);
	}
	public static By getForemanHomePageProductionDashboard() {
		return By.cssSelector(B2WUIMap.b2w_dashboardforemanhomepagecost);
	}
}
