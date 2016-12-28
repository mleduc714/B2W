package tasks.maintain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.scheduler.B2WScheduleAssignments;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;

public class B2WMaintainScheduleTasks extends B2WKendoTasks {
	
	Logger log = Logger.getLogger(B2WMaintainScheduleTasks.class);
	SimpleDateFormat sd = new SimpleDateFormat("EEE, M/d");
	SimpleDateFormat md = new SimpleDateFormat("M/d");
	public enum CLICK {
		DOUBLE, SINGLE, CONTEXT, WRENCH
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
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WMaintain.getB2WMaintainScheduleTodayButton())){
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public boolean clickBackwardArrow() {
		return WebElementUtils.clickElement(B2WMaintain.getB2WMaintainSchedulerArrowWest());
	}

	public boolean clickForwardArrow() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WMaintain.getB2WMaintainSchedulerArrowEast())){
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public String getCurrentScheduleView() {
		String sView = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainScheduleCurrentView());
		if (el != null){
			sView = el.getAttribute("data-name");
		}
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
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.SCHEDULE,"Edit Schedule");
	}
	public boolean unscheduleWorkOrderByDescription(String s){
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.SCHEDULE,"Unschedule");
	}
	public boolean editWorkOrderByDescription(String s){
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.SCHEDULE,"Edit Work Order");
	}
	public boolean completeWorkOrderByDescription(String s){
		return workOrder(s,CLICK.CONTEXT,BY.DESCRIPTION,WHERE.SCHEDULE,"Complete");
	}
	
	
	public boolean editScheduleWorkOrderByDescriptionWithWrench(String s){
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.SCHEDULE,"Edit Schedule");
	}
	public boolean unscheduleWorkOrderByDescriptionWithWrench(String s){
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.SCHEDULE,"Unschedule");
	}
	public boolean editWorkOrderByDescriptionWithWrench(String s){
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.SCHEDULE,"Edit Work Order");
	}
	public boolean completeWorkOrderByDescriptionWithWrench(String s){
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.SCHEDULE,"Complete");
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
	public boolean scheduleWorkOrderFromWorkOrderTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.WORKTAB, "Schedule");
	}
	public boolean unapproveWorkOrderFromWorkOrderTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.WORKTAB, "Unapprove");
	}
	public boolean editWorkOrderFromWorkOrderTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.WORKTAB, "Edit Work Order");
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
	
	public boolean completeWorkOrderFromWorkOrderTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.WORKTAB,  "Complete");
	}
	public boolean editscheduleWorkOrderFromPastDueTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.PASTTAB, "Edit Schedule");
	}
	public boolean unscheduleWorkOrderFromPastDueTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.PASTTAB, "Unschedule");
	}
	public boolean editWorkOrderFromPastDueTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.PASTTAB, "Edit Work Order");
	}
	public boolean completeWorkOrderFromPastDueTabByDescriptionWithWrench(String s) {
		return workOrder(s,CLICK.WRENCH,BY.DESCRIPTION,WHERE.PASTTAB,  "Complete");
	}
	
	public boolean clickWorkOrderFromWorkOrderTabByDescription(String s) {
		return workOrder(s,CLICK.SINGLE,BY.DESCRIPTION,WHERE.WORKTAB,null);
	}
	public boolean clickWorkOrderFromPastDueTabByDescription(String s) {
		return workOrder(s,CLICK.SINGLE,BY.DESCRIPTION,WHERE.PASTTAB,null);
	}

	private WebElement getWorkOrder(String sText, BY desc, WHERE where){
		WebElement el = null;
		WebElement workorderlist = null;
		List<WebElement> events = null;
		String sDescAndWorkNumber = null;
		try {
			switch (where) {

			case SCHEDULE:
				workorderlist = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerContent());
				events = WebElementUtils.getChildElements(workorderlist, B2WMaintain.getB2WMaintainSchedulerEvents());
				break;
			case WORKTAB:
				workorderlist = WebElementUtils
						.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
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
				el = iter.next();
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
					break;
				}
			  el = null;	
			}
		}catch (StaleElementReferenceException e){
			return getWorkOrder(sText, desc, where);
		}
			return el;
	}
	
	private boolean workOrder(String sText, CLICK click, BY desc, WHERE where, String sMenu) {
		boolean bReturn = false;
		WebElement contextMenu = null;
		try {
			WebElement el = getWorkOrder(sText, desc, where);
			if (el != null) {
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
				case WRENCH:
					WebElement parent = WebElementUtils.getParentElement(el);
					WebElementUtils.clickElement(WebElementUtils.getChildElement(parent, B2WMaintain.getMaintainScheduleWrench()));
					
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
						bReturn &= WebElementUtils
								.waitAndFindDisplayedElement(B2WMaintain.getKendoCancelButton()) != null;
						break;
					case WORKTAB:

						bReturn = WebElementUtils.waitAndFindDisplayedElement(
								B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow()) != null;
						break;
					}
					break;
				case CONTEXT:
				case WRENCH:
					switch (where) {
					case PASTTAB:
					case SCHEDULE:
						switch (click) {
						case CONTEXT:
							contextMenu = WebElementUtils.waitAndFindDisplayedElement(
									B2WMaintain.getB2WMaintainSchedulerScheduledContextMenu());
							break;
						case WRENCH:
							contextMenu = WebElementUtils.waitAndFindDisplayedElement(
									B2WMaintain.getB2WMaintainSchedulerScheduledWrenchMenu());

							break;
						case SINGLE:
							break;
						case DOUBLE:
							break;
						}
						break;
					case WORKTAB:
						switch (click) {
						case CONTEXT:
							contextMenu = WebElementUtils.waitAndFindDisplayedElement(
									B2WMaintain.getB2WMaintainSchedulerUnscheduledContextMenu());
							break;
						case WRENCH:
							contextMenu = WebElementUtils.waitAndFindDisplayedElement(
									B2WMaintain.getB2WMaintainSchedulerUnscheduledWrenchMenu());

							break;
						case SINGLE:
							break;
						case DOUBLE:
							break;
						}
						break;
					}
					List<WebElement> items = contextMenu.findElements(B2WScheduleAssignments.getLinks());
					WebElement item = WebElementUtils.getElementWithMatchingText(items, sMenu, false);

					bReturn = WebElementUtils.clickElement(item);
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			log.debug("Caught stale element exception in open " + sText);
			workOrder(sText, click, desc, where, sMenu);
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

	public ArrayList<String> getWorkOrdersFromTab() {
		
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = null;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerworkorderunscheduled());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			String sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
			al.add(sDescAndWorkNumber);
		}
		return al;
		
	}
	public ArrayList<String> getPastDueWorkOrdersFromTab() {
		
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = null;
		WebElement workorderlist = WebElementUtils.findElement(B2WMaintain.getB2WMaintainschedulerpastdueworkorderlist());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerpastdueworkorder());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			String sDescAndWorkNumber = summary.getText().substring(0, summary.getText().indexOf("\n"));
			al.add(sDescAndWorkNumber);
		}
		return al;
		
	}
	
	public ArrayList<String> getAllScheduledWorkOrders() {	
		
		ArrayList<String> al = new ArrayList<String>();
		WebElement workorderlist = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulerContent());
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist, B2WMaintain.getB2WMaintainSchedulerEvents());
		Iterator<WebElement> iter = events.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			WebElement summary = WebElementUtils.getChildElement(el,
					B2WMaintain.getB2WMaintainschedulerworkordersummary());
			 al.add(summary.getText().substring(0, summary.getText().indexOf("\n")));
		}
		return al;
	
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
				waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
				bReturn = WebElementUtils.waitAndFindDisplayedElement(
						B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow()) != null;

			}
		}
		return bReturn;
	}
	
	public int getPastDueWorkOrders() {
		int iNumber = 0;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerpastdueworkorderlist());
		if (workorderlist != null){
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerpastdueworkorder());
			iNumber = events.size();
		}
		return iNumber;
	}

	public int getWorkOrders() {
		int iNumber = 0;
		WebElement workorderlist = WebElementUtils
				.findElement(B2WMaintain.getB2WMaintainschedulerunscheduledworkorderslist());
		if (workorderlist != null){
		List<WebElement> events = WebElementUtils.getChildElements(workorderlist,
				B2WMaintain.getB2WMaintainschedulerworkorderunscheduled());
			iNumber = events.size();
		}
		return iNumber;
		
	}
	
	public ArrayList<Date> getDates() {
		
		ArrayList<Date> al = new ArrayList<Date>();
		try {
		WebElement header = WebElementUtils.findElement(B2WMaintain.getB2WMaintainScheduleHeader());
		List<WebElement> strongs = WebElementUtils.getChildElements(header, By.tagName("strong"));
		for (WebElement el: strongs){
			String sDate = el.getText();
			SimpleDateFormat sd = new SimpleDateFormat("EEE, M/d");
			Date date = parseDate(sDate, sd);
			al.add(date);
		}
		}catch (StaleElementReferenceException e){
			return getDates();
		}
		return al;
	}
	
	
	
	public boolean goToDate(String sDate) {
		
		log.debug("Going to Date: "+sDate);
		boolean bReturn = false;
		Calendar cal = Calendar.getInstance();
		if (getCurrentDate() != null){
			cal.setTime(getCurrentDate());
		}else{
			log.warn("Get Current Date returned null");
		}
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
		Date goToDate = null;
		// Calendar month = Calendar.getInstance();
		// Calendar day = Calendar.getInstance();
		try {
			goToDate = format.parse(sDate);

			Calendar cGoToDate = Calendar.getInstance();
			cGoToDate.setTime(goToDate);

			if (cGoToDate.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR)) {

				WebElementUtils.clickElement(B2WMaintain.getB2WScheduleDatePickerButton());
				WebElement dp = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WScheduleDatePicker());
				bReturn = goToDate(sDate, dp);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return bReturn;

	}

	
	public ArrayList<String> getMechanicsFromSchedule() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> mechanics = WebElementUtils.findElements(By.cssSelector("span.caption"));
		for (WebElement el: mechanics){
			al.add(WebElementUtils.getParentElement(el).getAttribute("title"));
		}
		return al;
	}
	
	
	public void goToMechanicInView(String s) {
		List<WebElement> mechanics = WebElementUtils.findElements(By.cssSelector("span.caption"));
		ArrayList<String> al = getMechanicsFromSchedule();
		int i = al.indexOf(s);
		if (i + 1 != al.size()){
			i++;
		}
		Coordinates coordinate = ((Locatable) mechanics.get(i)).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		
	}
	
	private WebElement getMechanicDay(String sMechanic, Date date) {
		List<WebElement> list = WebElementUtils.findElements(B2WMaintain.getB2WMaintainSchedulerContent());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(list, "data-role", "droptargetarea");
		List<WebElement> rows = WebElementUtils.getChildElements(el, By.tagName("tr"));
		int iMechanicNumber = getMechanicsFromSchedule().indexOf(sMechanic);
		WebElement mechanicRow = rows.get(iMechanicNumber);
		List<WebElement> datecolumns = WebElementUtils.getChildElements(mechanicRow, By.tagName("td"));
		ArrayList<Date> dates = getDates();
		int iRow = dates.indexOf(date);
		return datecolumns.get(iRow);
	}
	
	private Date parseDate(String s, SimpleDateFormat sd){
		Date date = null;
		try {
			date = sd.parse(s);
		} catch (ParseException e) {
			log.warn("Issue parsing the date "+s);
		}
		return date;
	}
	
	public boolean dragDropWorkOrderToMechanic(String sMechanic, String sDate, String sWorkOrder) {
		boolean bReturn = false;
		// go to the date in schedule view
		goToDate(sDate);
		// scroll down to get the mechanic in the view
		goToMechanicInView(sMechanic);
		Date date = parseDate(sDate, md);
		// this will get the target to drag to
		WebElement column = getMechanicDay(sMechanic, date);
		if (column != null) {
			clickWorkOrdersTab();
			// grab the work order
			WebElement workorder = getWorkOrder(sWorkOrder, BY.DESCRIPTION, WHERE.WORKTAB);
			if (workorder != null) {
				Actions action = new Actions(BrowserUtils.getDriver());
				action.dragAndDrop(workorder, column);
	
				bReturn = WebElementUtils.waitAndFindDisplayedElement(
						B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow()) != null;
			}

		}

		return bReturn;
	}
	
	public boolean dragDropWorkOrderToAnotherMechanic(String sDate, String sToDate, String sWorkOrder,
			String sMechanic) {
		boolean bReturn = false;
		// go to the date in schedule view
		goToDate(sDate);
		TaskUtils.sleep(1000);
		// scroll down to get the mechanic in the view
		goToMechanicInView(sMechanic);
		Date date = parseDate(sToDate, md);
		// this will get the target to drag to
		// WebElement columnA = getMechanicDay(sMechanicA, date);

		WebElement column = getMechanicDay(sMechanic, date);
		if (column != null) {
			// grab the work order
			WebElement workorder = getWorkOrder(sWorkOrder, BY.DESCRIPTION, WHERE.SCHEDULE);
			if (workorder != null) {
				Actions action = new Actions(BrowserUtils.getDriver());
				action.dragAndDrop(workorder, column);
				action.perform();
			}
		}
		return bReturn;
	}
	
	public boolean dragDropWorkOrderToDate(String sMechanic, String sWorkOrder, String sStartDate, String sDate) {
		boolean bReturn = false;
		goToDate(sStartDate);
		TaskUtils.sleep(1000);
		// go to the date in schedule view
		// scroll down to get the mechanic in the view
		Date date = parseDate(sDate, md);
		// this will get the target to drag to
		WebElement column = getMechanicDay(sMechanic, date);
		if (column != null) {
			// grab the work order
			WebElement workorder = getWorkOrder(sWorkOrder, BY.DESCRIPTION, WHERE.SCHEDULE);
			if (workorder != null) {
				Actions action = new Actions(BrowserUtils.getDriver());
				action.dragAndDrop(workorder, column);
				action.perform();
			}
		}
		return bReturn;

	}
	
	public LinkedList<String> getAllMechanicsWithoutScheduledWorkItems() {
		LinkedList<String> al = new LinkedList<String>();
		try {

			List<WebElement> mechanics = WebElementUtils.findElements(By.cssSelector("span.caption"));
			for (WebElement el : mechanics) {
				String sMechanic = WebElementUtils.getParentElement(el).getAttribute("title");
				String sHeight = WebElementUtils
						.getParentElement(WebElementUtils.getParentElement(WebElementUtils.getParentElement(el)))
						.getAttribute("style");
				if (sHeight.contains("40px")) {
					al.add(sMechanic);
				}
			}
		} catch (StaleElementReferenceException e) {
			return getAllMechanicsWithoutScheduledWorkItems();
		}
		return al;
	}
	
	public Date getCurrentDate() {
		Date date = null;
		String sDate = null;
		try {
			SimpleDateFormat calendardate = new SimpleDateFormat("EEE MM/dd/yyyy");
			WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WScheduleSmallFormatDate());
			if (el != null) {
				sDate = el.getText();
				if (sDate.length() > 0) {
					int iIndex = sDate.indexOf("-");
					if (iIndex != -1) {
						sDate = sDate.substring(0, iIndex).trim();
					}
					date = calendardate.parse(sDate);
				} else {
					el = WebElementUtils.findElement(B2WMaintain.getB2WScheduleSmallFormatDate());
					sDate = el.getText();
					date = calendardate.parse(sDate);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;

	}
	
	public boolean quickSchedule() {
		boolean bReturn = false;
		List<WebElement> tables = WebElementUtils.findElements(B2WMaintain.getB2WMaintainScheduleTable());
		if (tables.size() > 3) {
			List<WebElement> rows = WebElementUtils.getChildElements(tables.get(3), By.tagName("tr"));
			if (rows.size() > 0) {
				List<WebElement> unscheduledRows = WebElementUtils.getElementsWithMatchingAttribute(rows, "style",
						"height: 40px;");
				if (unscheduledRows.size() > 1) {

					WebElement child = WebElementUtils.getChildElement(unscheduledRows.get(1),
							B2WMaintain.getB2WMaintainScheduleNonWorkHour());
					if (child != null) {
						Actions actions = new Actions(BrowserUtils.getDriver());
						actions.contextClick(child);
						actions.perform();
						WebElement contextMenu = WebElementUtils
								.waitAndFindDisplayedElement(By.xpath("//span[contains(.,'New Work Order')]"));

						bReturn = WebElementUtils.clickElement(contextMenu);
						bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainNewWorkOrderView()) != null;

					}
				}
			}
		}

		return bReturn;
	}

}
