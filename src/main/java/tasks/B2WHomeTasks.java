package tasks;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.B2WHomePage;
import appobjects.reports.B2WReports;
import tasks.util.TaskUtils;

public class B2WHomeTasks {

	String sDashboardA = "Foreman Home Page Production Dashboard";
	String sDashboardB = "Manager Home Page Cost Dashboard";
	String sDashboardC = "Manager Home Page Production Dashboard";
	Logger log = Logger.getLogger(B2WHomeTasks.class);

	public boolean openAdminReports() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeAdminReports());
		if (el != null) {
			WebElementUtils.clickElement(el);
			WebElement reports = WebElementUtils.waitAndFindElement(B2WReports.getReportsPage());
			if (reports != null) {
				bReturn = true;
			}

		} else {
			log.info("Administration of Reports Link is not available");
		}
		return bReturn;
	}

	public boolean openAdminManageBusinessUnits() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeAdminManageUnits());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForPageHeader("Business Units");
			}

		}
		return bReturn;
	}

	public boolean openAdminAddAUser() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeAdminAddUser());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForPageHeader("User Listing");
			}

		}
		return bReturn;
	}

	public boolean openAdminViewEmployees() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeAdminViewEmployees());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForPageHeader("Employees");
			}

		}
		return bReturn;
	}

	public boolean openAdminManageEquipment() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeAdminManageEquipment());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment");
			}
		}
		return bReturn;
	}

	public boolean openTrackCreateFieldLog() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeTrackCreateFieldLogs());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Field Logs");
			}

		}
		return bReturn;
	}

	public boolean openTrackViewFieldLogs() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeTrackViewFieldLogs());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				
				bReturn = new TaskUtils().waitForProductPanel("Field Logs");
			}
		}
		return bReturn;
	}

	public boolean openTrackViewJobs() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeTrackViewJobs());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				WebElement jobs = WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPageContentGrid());
				bReturn = jobs.isDisplayed();
			}
		}

		return bReturn;
	}

	public boolean openDispatchJobBoard() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeViewSchedules());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Job Board");
			}
		}

		return bReturn;
	}

	public boolean openDispatchEquipmentMoves() {

		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeSetupSchedules());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Moves");
			}
		}

		return bReturn;

	}

	public boolean openDispatchTruckingOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeSetupCrewTemplates());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Trucking");
			}
		}

		return bReturn;
	}

	public boolean openSetupCrewTemplates() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeSetupCrewTemplates());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Crew Templates");
			}
		}

		return bReturn;
	}

	public boolean openViewSchedules() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeViewSchedules());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("All Employees");
			}
		}

		return bReturn;
	}

	public boolean openSetupSchedules() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeSetupSchedules());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Schedules");
			}
		}

		return bReturn;
	}
	public boolean openMaintainViewWorkOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeMaintainViewWorkOrders());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Work Orders");
			}
		}

		return bReturn;
	}
	public boolean openMaintainMaintenanceRequests() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeMaintainViewMaintenanceRequests());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Requests");
			}
		}

		return bReturn;
	}
	public boolean openMaintainViewScheduleWorkOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeMaintainScheduleWorkOrders());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Work Order Schedule by Mechanic");
			}
		}

		return bReturn;
	}
	
	public boolean openMaintainViewEquipment() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeMaintainViewEquipment());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment");
			}
		}

		return bReturn;
	}
	public boolean addDashboardManagerHomePageCost() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getAddDashboardButton());
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getUserSettingsBodyPanel());
			bReturn = WebElementUtils.selectItemFromOpsDropDownMenu(B2WHomePage.getUserSettingsBodyPanel(), sDashboardB);
			bReturn &= WebElementUtils.clickElement(WebElementUtils.findElement(B2WHomePage.getAddDashboardOKButton()));
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getManagerHomePageCostDashboard(), WebElementUtils.LONG_TIME_OUT) != null;
		}
		return bReturn;
	}
	public boolean addDashboardManagerHomePageProduction() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getAddDashboardButton());
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getUserSettingsBodyPanel());
			bReturn = WebElementUtils.selectItemFromOpsDropDownMenu(B2WHomePage.getUserSettingsBodyPanel(), sDashboardC);
			bReturn &= WebElementUtils.clickElement(WebElementUtils.findElement(B2WHomePage.getAddDashboardOKButton()));
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getManagerHomePageProductionDashboard(), WebElementUtils.LONG_TIME_OUT) != null;
		}
		return bReturn;
	}
	public boolean addDashboardForemanHomePageProduction() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getAddDashboardButton());
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getUserSettingsBodyPanel());
			bReturn = WebElementUtils.selectItemFromOpsDropDownMenu(B2WHomePage.getUserSettingsBodyPanel(), sDashboardA);
			bReturn &= WebElementUtils.clickElement(WebElementUtils.findElement(B2WHomePage.getAddDashboardOKButton()));
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getForemanHomePageProductionDashboard(), WebElementUtils.LONG_TIME_OUT) != null;
		}
		return bReturn;
	}
	public boolean removeDashboard() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getAddDashboardButton());
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getUserSettingsBodyPanel());
			WebElementUtils.selectItemFromOpsDropDownMenuByNumber(B2WHomePage.getUserSettingsBodyPanel(),0);
			bReturn = WebElementUtils.clickElement(WebElementUtils.findElement(B2WHomePage.getAddDashboardOKButton()));
		}
		return bReturn;
	}
}
