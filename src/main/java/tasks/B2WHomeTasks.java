package tasks;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.B2WHomePage;
import appobjects.reports.B2WReports;
import tasks.util.TaskUtils;

public class B2WHomeTasks {

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
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeDispatchViewJobBoard());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Job Board");
			}
		}

		return bReturn;
	}

	public boolean openDispatchEquipmentMoves() {

		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeDispatchEquipmentMoves());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Moves");
			}
		}

		return bReturn;

	}

	public boolean openDispatchTruckingOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeDispatchTruckingOrders());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Trucking");
			}
		}

		return bReturn;
	}

	public boolean openDispatchDeliveryOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeDispatchDeliveryOrders());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Deliveries");
			}
		}

		return bReturn;
	}

	public boolean openDispatchMapOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WHomePage.getB2WHomeDispatchViewMapOrders());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Map");
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
}
