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

	public boolean scheduleMaintainancePopupSelectMechanic(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(0);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);

			if (WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "true", true,
					WebElementUtils.SHORT_TIME_OUT)) {
				bReturn = selectItemFromDropDown(sText);
			}
		}
		return bReturn;
	}

	public boolean scheduleMaintainancePopupSelectStartDate(String startDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(1);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, startDate);
		}
		return bReturn;
	}

	public boolean scheduleMaintainancePopupSelectStartTime(String startTime) {
		boolean bReturn = false;
		
		WebElement el = getWebElementFromScheduleMaintenanceDialog(2);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(startTime);
		}
		return bReturn;
	}
	public boolean scheduleMaintainancePopupSelectEndDate(String endDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(3);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, endDate);
		}
		return bReturn;
	}

	public boolean scheduleMaintainancePopupSelectEndTime(String endTime) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(4);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(endTime);
		}
		return bReturn;

	}

	public boolean scheduleMaintainancePopupSelectWorkLocation(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean scheduleMaintainancePopupSelectEvent(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean saveScheduleMaintenance() {
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		if (el != null){
			WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
		}
		return bReturn;
	}
	private WebElement getWebElementFromScheduleMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);

	}

	public boolean editMaintainancePopupSelectMechanic(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditMaintenanceDialog(0);
		el.click();
		if (WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "true", true,
				WebElementUtils.SHORT_TIME_OUT)) {
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;

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
	
	public boolean saveEditMaintenance() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
		if (button != null) {
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}

	private WebElement getWebElementFromEditMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	public boolean clickWorkOrdersTab() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerWorkOrdersTab());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public boolean clickPastDueWorkOrdersTab() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerPastDueWorkOrdersTab());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

}