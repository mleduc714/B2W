package tasks.maintain;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.scheduler.B2WScheduleAssignments;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;

public class B2WMaintainScheduleTasks extends B2WKendoTasks {

	public enum CLICK {
		DOUBLE, SINGLE, CONTEXT
	};

	public enum BY {
		EQUIPMENT, DESCRIPTION
	};

	public enum WHERE {
		SCHEDULE, WORKTAB, PASTTAB
	}

	public boolean clickDayView() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleDayView());
	}

	public boolean clickThreeDayView() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleThreeDaysView());
	}

	public boolean clickWeekView() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleWeekView());
	}

	public boolean clickTwoWeekView() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleTwoWeekView());
	}

	public boolean clickMechanicsView() {
		boolean bReturn = false;
		bReturn = WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleMechanicsView());
		return bReturn;
	}

	public boolean clickToday() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleTodayButton());
	}

	public boolean clickBackwardArrow() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainSchedulerArrowWest());
	}

	public boolean clickForwardArrow() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainSchedulerArrowEast());
	}

	public String getCurrentScheduleView() {
		String sView = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainScheduleCurrentView());
		sView = el.getAttribute("data-name");
		return sView;
	}

	public boolean clickEquipmentView() {
		boolean bReturn = false;
		bReturn = WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleEquipmentView());
		return bReturn;
	}

	public boolean clickWorkOrderByDescription(String s) {
		return workOrder(s,CLICK.SINGLE,BY.DESCRIPTION,WHERE.SCHEDULE,null);
	}
	public boolean clickWorkOrderByEquipment(String s) {
		return workOrder(s,CLICK.SINGLE,BY.EQUIPMENT,WHERE.SCHEDULE,null);
	}
	public boolean openWorkOrderByDescription(String s) {
		return workOrder(s,CLICK.DOUBLE,BY.DESCRIPTION,WHERE.SCHEDULE,null);
	}
	public boolean openWorkOrderByEquipment(String s) {
		return workOrder(s,CLICK.DOUBLE,BY.EQUIPMENT,WHERE.SCHEDULE,null);
	}
	public boolean editScheduleWorkOrderByDescription(String s){
		return workOrder(s,CLICK.CONTEXT,BY.EQUIPMENT,WHERE.SCHEDULE,"Edit Schedule");
	}
	public boolean unscheduleWorkOrderByDescription(String s){
		return workOrder(s,CLICK.CONTEXT,BY.EQUIPMENT,WHERE.SCHEDULE,"Unschedule");
	}
	public boolean editWorkOrderByDescription(String s){
		return workOrder(s,CLICK.CONTEXT,BY.EQUIPMENT,WHERE.SCHEDULE,"Edit Work Order");
	}
	public boolean completeWorkOrderByDescription(String s){
		return workOrder(s,CLICK.CONTEXT,BY.EQUIPMENT,WHERE.SCHEDULE,"Complete");
	}
	
	public boolean openWorkOrderFromWorkOrderTabByDescription(String s) {	
		return workOrder(s,CLICK.DOUBLE,BY.DESCRIPTION,WHERE.WORKTAB,null);
	}

	public boolean openWorkOrderFromPastDueTabByDescription(String s) {
		return workOrder(s,CLICK.DOUBLE,BY.DESCRIPTION,WHERE.PASTTAB,null);
	}

	public boolean scheduleWorkOrderFromWorkOrderTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.WORKTAB, "Schedule");
	}
	public boolean unapproveWorkOrderFromWorkOrderTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.WORKTAB, "Unapprove");
	}
	public boolean editWorkOrderFromWorkOrderTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.WORKTAB, "Edit Work Order");
	}

	public boolean completeWorkOrderFromWorkOrderTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.WORKTAB,  "Complete");
	}
	public boolean editscheduleWorkOrderFromPastDueTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.PASTTAB, "Edit Schedule");
	}
	public boolean unscheduleWorkOrderFromPastDueTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.PASTTAB, "Unschedule");
	}
	public boolean editWorkOrderFromPastDueTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.PASTTAB, "Edit Work Order");
	}
	public boolean completeWorkOrderFromPastDueTabByDescription(String s) {
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.PASTTAB,  "Complete");
	}
	public boolean clickWorkOrderFromWorkOrderTabByDescription(String s) {
		return workOrder(s,CLICK.SINGLE,BY.DESCRIPTION,WHERE.WORKTAB,null);
	}
	public boolean clickWorkOrderFromPastDueTabByDescription(String s) {
		return workOrder(s,CLICK.SINGLE,BY.DESCRIPTION,WHERE.PASTTAB,null);
	}

	private boolean workOrder(String sText, CLICK click, BY desc, WHERE where, String sMenu) {
		boolean bReturn = false;
		WebElement workorderlist = null;
		List<WebElement> events = null;
		String sDescAndWorkNumber = null;
		WebElement contextMenu = null;

		switch (where) {

		case SCHEDULE:
			workorderlist = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerContent());
			events = WebElementUtils.getChildElements(workorderlist, B2WMaintain.getB2WMaintainSchedulerEvents());
			break;
		case WORKTAB:
			workorderlist = WebElementUtils.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
			events = WebElementUtils.getChildElements(workorderlist,
					B2WMaintain.getB2WMaintainschedulerworkorderunscheduled());
			break;
		case PASTTAB:
			workorderlist = WebElementUtils.findElement(B2WMaintain.getB2WMaintainschedulerpastdueworkorderlist());
			events = WebElementUtils.getChildElements(workorderlist,
					B2WMaintain.getB2WMaintainschedulerpastdueworkorder());
			break;
		}

		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			switch (desc) {
			case DESCRIPTION:
				sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
				break;
			case EQUIPMENT:
				int iStart = summary.getText().indexOf("\n");
				int iEnd = summary.getText().indexOf(("\n"), iStart + 1);
				sDescAndWorkNumber = summary.getText().substring(++iStart, iEnd);
			}
			if (sDescAndWorkNumber.contains(sText)) {
				Coordinates coordinate = ((Locatable) el).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
				Actions actions = new Actions(BrowserUtils.getDriver());
				switch (click) {
				case SINGLE:
					actions.click(el);
					break;
				case DOUBLE:
					actions.doubleClick(el);
					break;
				case CONTEXT:
					actions.contextClick(el);
					break;
				}
				actions.perform();
				switch (click) {
				case SINGLE:
					bReturn = WebElementUtils
							.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerToolTip()) != null;
					break;
				case DOUBLE:
					switch (where) {
					case PASTTAB:
					case SCHEDULE:
						bReturn = WebElementUtils.waitAndFindDisplayedElement(
								B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow()) != null;
						break;
					case WORKTAB:

						bReturn = WebElementUtils.waitAndFindDisplayedElement(
								B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow()) != null;
						break;
					}
					break;
				case CONTEXT:
					switch (where) {
					case PASTTAB:
					case SCHEDULE:

						contextMenu = WebElementUtils
								.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduledContextMenu());

						break;
					case WORKTAB:

						contextMenu = WebElementUtils.waitAndFindDisplayedElement(
								B2WMaintain.getB2WMaintainSchedulerUnscheduledContextMenu());
						break;
					}
					List<WebElement> items = contextMenu.findElements(B2WScheduleAssignments.getLinks());
					WebElement item = WebElementUtils.getElementWithMatchingText(items, sMenu, false);

					bReturn = WebElementUtils.clickElement(item);
					break;
				}
				break;
			}
			
		}

		return bReturn;
	}


	public boolean clickWorkOrdersTab() {
		boolean bReturn = false;
		waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerWorkOrdersTab());
		WebElement child = WebElementUtils.getChildElement(el, By.cssSelector("span.k-link"));
		if (el != null) {
			bReturn = WebElementUtils.clickElement(child);
		}
		return bReturn;
	}

	public boolean clickPastDueWorkOrdersTab() {
		boolean bReturn = false;
		waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerPastDueWorkOrdersTab());
		WebElement child = WebElementUtils.getChildElement(el, By.cssSelector("span.k-link"));
		if (el != null) {
			bReturn = WebElementUtils.clickElement(child);
		}
		return bReturn;
	}
	public boolean openWorkOrderFromWorkOrderTabByNumber(int i) {
		boolean bReturn = false;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerworkorderunscheduled());
		if (i < events.size()) {
			WebElement item = events.get(i);
			Coordinates coordinate = ((Locatable) item).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();
			Actions actions = new Actions(BrowserUtils.getDriver());
			actions.doubleClick(item);
			actions.perform();
			bReturn = WebElementUtils.waitAndFindDisplayedElement(
					B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow()) != null;

		}

		return bReturn;
	}

	public boolean openWorkOrderFromPastDueTabByNumber(int i) {
		boolean bReturn = false;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerpastdueworkorderlist());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerpastdueworkorder());
		if (i < events.size()) {
			if (WebElementUtils.clickElement(events.get(i))) {
				WebElement item = events.get(i);
				Coordinates coordinate = ((Locatable) item).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
				Actions actions = new Actions(BrowserUtils.getDriver());
				actions.doubleClick(item);
				actions.perform();
				bReturn = WebElementUtils.waitAndFindDisplayedElement(
						B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow()) != null;

			}
		}
		return bReturn;
	}

}
