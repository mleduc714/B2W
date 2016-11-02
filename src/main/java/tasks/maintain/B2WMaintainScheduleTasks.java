package tasks.maintain;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;

public class B2WMaintainScheduleTasks extends B2WKendoTasks {

	public boolean clickMechanics() {
		boolean bReturn = false;
		bReturn = WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleMechanicsView());
		return bReturn;
	}

	public boolean openWorkOrderToolTipByMechanicByDescription(String s) {
		boolean bReturn = false;
		WebElement scheduler = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerContent());
		List<WebElement> events = WebElementUtils.getChildElements(scheduler,
				B2WMaintain.getB2WMaintainSchedulerEvents());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			String sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
			if (sDescAndWorkNumber.startsWith(s)) {
				Coordinates coordinate = ((Locatable) el).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();

				WebElementUtils.clickElement(el);
			}
		}

		return bReturn;
	}

	public boolean openWorkOrderByMechanicByDescription(String s) {
		boolean bReturn = false;
		WebElement scheduler = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerContent());
		List<WebElement> events = WebElementUtils.getChildElements(scheduler,
				B2WMaintain.getB2WMaintainSchedulerEvents());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			String sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
			if (sDescAndWorkNumber.startsWith(s)) {
				Coordinates coordinate = ((Locatable) el).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
				Actions actions = new Actions(BrowserUtils.getDriver());
				actions.doubleClick(el);
				actions.perform();
				bReturn = WebElementUtils.waitAndFindDisplayedElement(
						B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow()) != null;

			}
		}

		return bReturn;
	}

	public boolean openWorkOrderFromWorkOrderTabByDescription(String s) {
		boolean bReturn = false;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerworkorderunscheduled());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			String sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
			if (sDescAndWorkNumber.startsWith(s)) {
				Coordinates coordinate = ((Locatable) el).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
				Actions actions = new Actions(BrowserUtils.getDriver());
				actions.doubleClick(el);
				actions.perform();
				bReturn = WebElementUtils.waitAndFindDisplayedElement(
						B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow()) != null;
			}
		}

		return bReturn;
	}
	

	public boolean scheduleWorkOrderFromWorkOrderTabByDescriptionFromContextMenu(String s) {
		boolean bReturn = false;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerworkorderunscheduled());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			String sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
			if (sDescAndWorkNumber.startsWith(s)) {
				Coordinates coordinate = ((Locatable) el).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
				Actions actions = new Actions(BrowserUtils.getDriver());
				actions.contextClick(el);
				actions.perform();
				WebElement contextMenu = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerUnscheduledContextMenu());
				WebElementUtils.getChildElement(contextMenu, By.linkText("Schedule")).click();
				bReturn = WebElementUtils.waitAndFindDisplayedElement(
						B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow()) != null;
			}
		}

		return bReturn;
	}

	public boolean openToolTipWorkOrderFromWorkOrderTabByDescription(String s) {
		boolean bReturn = false;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerworkorderunscheduled());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			String sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
			if (sDescAndWorkNumber.startsWith(s)) {
				Coordinates coordinate = ((Locatable) el).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
				WebElementUtils.clickElement(el);
				bReturn = WebElementUtils
						.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerToolTip()) != null;
			}
		}

		return bReturn;
	}

	public void scheduleMaintainancePopupSelectMechanic(String sText) {
		WebElement el = getWebElementFromScheduleMaintenanceDialog(0);
		el.click();
		if (WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "true", true,
				WebElementUtils.SHORT_TIME_OUT)) {
			selectItemFromDropDown(sText);
		}

	}

	public void scheduleMaintainancePopupSelectStartDate(String startDate) {
		WebElement el = getWebElementFromScheduleMaintenanceDialog(1);
		el.click();
		WebElementUtils.sendKeys(el, startDate);
	}

	public void scheduleMaintainancePopupSelectStartTime(String startTime) {
		WebElement el = getWebElementFromScheduleMaintenanceDialog(2);
		el.click();
		selectItemFromDropDown(startTime);
	}
	public void scheduleMaintainancePopupSelectEndDate(String startDate) {
		WebElement el = getWebElementFromScheduleMaintenanceDialog(3);
		el.click();
		WebElementUtils.sendKeys(el, startDate);
	}

	public void scheduleMaintainancePopupSelectEndTime(String endTime) {
		WebElement el = getWebElementFromScheduleMaintenanceDialog(4);
		el.click();
		selectItemFromDropDown(endTime);
	}

	public void scheduleMaintainancePopupSelectWorkLocation(String sText){
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		el.click();
		WebElementUtils.sendKeys(el, sText);
	}
	
	public void scheduleMaintainancePopupSelectEvent(String sText){
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		el.click();
		selectItemFromDropDown(sText);
	}
	
	public void saveScheduleMaintenance() {
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
		WebElementUtils.clickElement(button);
		
	}
	private WebElement getWebElementFromScheduleMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);

	}

	public void editMaintainancePopupSelectMechanic(String sText) {
		WebElement el = getWebElementFromEditMaintenanceDialog(0);
		el.click();
		if (WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "true", true,
				WebElementUtils.SHORT_TIME_OUT)) {
			selectItemFromDropDown(sText);
		}

	}

	public void editMaintainancePopupSelectStartDate(String startDate) {
		WebElement el = getWebElementFromEditMaintenanceDialog(1);
		el.click();
		WebElementUtils.sendKeys(el, startDate);
	}

	public void editMaintainancePopupSelectStartTime(String startTime) {
		WebElement el = getWebElementFromEditMaintenanceDialog(2);
		el.click();
		selectItemFromDropDown(startTime);
	}
	public void editMaintainancePopupSelectEndDate(String startDate) {
		WebElement el = getWebElementFromEditMaintenanceDialog(3);
		el.click();
		WebElementUtils.sendKeys(el, startDate);
	}

	public void editMaintainancePopupSelectEndTime(String endTime) {
		WebElement el = getWebElementFromEditMaintenanceDialog(4);
		el.click();
		selectItemFromDropDown(endTime);
	}

	public void editMaintainancePopupSelectWorkLocation(String sText){
		WebElement el = getWebElementFromEditMaintenanceDialog(5);
		el.click();
		WebElementUtils.sendKeys(el, sText);
	}
	
	public void editMaintainancePopupSelectEvent(String sText){
		WebElement el = getWebElementFromEditMaintenanceDialog(5);
		el.click();
		selectItemFromDropDown(sText);
	}
	
	public void saveEditMaintenance() {
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
		WebElementUtils.clickElement(button);
	}
	private WebElement getWebElementFromEditMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}


}
