package tasks.maintain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WMaintainDashboardTasks extends B2WMaintainTasks {

	public String getUserWelcome() {
		String sUser = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainDashboardUserInfo());
		sUser = WebElementUtils.getChildElement(el, By.tagName("strong")).getText();
		return sUser;
	}

	public String getDateFromDashboard() {
		String sDate = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainDashboardUserInfo());
		List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("strong"));
		List<WebElement> list1 = WebElementUtils.getChildElements(el, By.tagName("span"));
		WebElement day = WebElementUtils.getElementWithMatchingAttribute(list1, "data-bind", "text:getDay");
		WebElement date = WebElementUtils.getElementWithMatchingAttribute(list, "data-bind", "text:getDate");
		if (date != null && day != null) {
			sDate = day.getText() + "," + " " + date.getText();
		}
		return sDate;
	}

	public int getUnassignedRepairRequests() {

		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardNewRequests());
		if (el != null) {
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}

	public boolean openUnassignedRepairRequests() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardNewRequests());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
				bReturn &= new TaskUtils().waitForProductPanel("Requests");
				bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoGridContent()) != null;

			}
		}
		return bReturn;
	}

	public int getUnscheduledPM() {
		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRequestsAndAssigned());
		if (el != null) {
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}

	public boolean openUnscheduledPM() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRequestsAndAssigned());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForProductPanel("Requests");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public int getUnscheduledWorkOrders() {

		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUnscheduleWorkOrders());
		if (el != null) {
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;

	}

	public boolean openUnscheduledWorkOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUnscheduleWorkOrders());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForProductPanel("Work Order Schedule by Mechanic");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);

		}
		return bReturn;
	}

	public int getPastDueWorkOrders() {
		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPastDue());
		if (el != null) {
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}

	public boolean openPastDueWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPastDue());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public int getPendingTimeCards() {
		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPendingCards());
		if (el != null) {
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}

	public boolean openPendingTimeCards() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPendingCards());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForProductPanel("Time Cards");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public boolean selectWorkOrderByLocation(String s) {
		return selectWorkOrder(s, 0);
	}

	public boolean selectWorkOrderByAssigned(String s) {
		return selectWorkOrder(s, 1);
	}

	public boolean selectWorkOrderByEquipment(String s) {
		return selectWorkOrder(s, 2);
	}

	public boolean selectWorkOrderByNumber(int i) {

		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardWorkOrderList());
		List<WebElement> containers = WebElementUtils.getChildElements(el,
				B2WMaintain.getB2WMaintainDashboardWorkOrderContainer());
		WebElement workorder = containers.get(i);

		Coordinates coordinate = ((Locatable) workorder).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		bReturn = WebElementUtils.clickElement(workorder);

		return bReturn;

	}

	public int getNumberOfScheduledWorkOrders() {
		int iWorkOrders = 0;

		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardWorkOrderList());
		if (el != null) {
			List<WebElement> containers = WebElementUtils.getChildElements(el,
					B2WMaintain.getB2WMaintainDashboardWorkOrderContainer());
			iWorkOrders = containers.size();
		}
		return iWorkOrders;
	}

	private boolean selectWorkOrder(String s, int i) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardWorkOrderList());
		List<WebElement> containers = WebElementUtils.getChildElements(el,
				B2WMaintain.getB2WMaintainDashboardWorkOrderContainer());
		Iterator<WebElement> iter = containers.iterator();
		while (iter.hasNext()) {
			WebElement workorder = iter.next();
			List<WebElement> list = WebElementUtils.getChildElements(workorder,
					B2WMaintain.getB2WMaintainDashboardWorkOrderData());
			WebElement location = list.get(i);
			String sLocation = location.getAttribute("title");
			if (sLocation.contains(s)) {
				Coordinates coordinate = ((Locatable) workorder).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
				bReturn = WebElementUtils.clickElement(workorder);
				break;
			}
		}
		return bReturn;
	}
	
	public ArrayList<String> getAllWorkOrderLocations(){
		return getWorkOrders(0);
	}
	public ArrayList<String> getAllWorkOrderAssignedTo(){
		return getWorkOrders(1);
	}
	public ArrayList<String> getAllWorkOrderEquipment(){
		return getWorkOrders(2);
	}
	
	
	public ArrayList<String> getWorkOrders(int i){

		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardWorkOrderList());
		List<WebElement> containers = WebElementUtils.getChildElements(el,
				B2WMaintain.getB2WMaintainDashboardWorkOrderContainer());
		Iterator<WebElement> iter = containers.iterator();
		while (iter.hasNext()) {
			WebElement workorder = iter.next();
			List<WebElement> list = WebElementUtils.getChildElements(workorder,
					B2WMaintain.getB2WMaintainDashboardWorkOrderData());
			WebElement location = list.get(i);
			String sLocation = location.getAttribute("title");
			al.add(sLocation);
		}
		return al;
	
	}

	public boolean clickScheduleWorkOrderFiltersButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardWorkOrdersFilter());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainDashboardFiltersDialog()) != null;
		}
		return bReturn;
	}

	public boolean clickRefresh() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRefresh());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public String getDashboardUpdatedText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUserInfo());
		List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("span"));
		WebElement day = WebElementUtils.getElementWithMatchingAttribute(list, "data-bind", "text:getDateAndTime");
		if (day != null) {
			sText = day.getText();
		}
		return sText;
	}

	public boolean clickYearToDate() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardYearToDateLink());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickMonthToDate() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardMonthToDateLink());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickViewTimeCards() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardTimeCardsLink());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickViewWorkOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardViewWorksLink());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public int getLowPriorityPercentage() {
		int iPercentage = 0;
		WebElement dashboard = WebElementUtils.findElement(B2WMaintain.getB2WDashboardWorkOrderChart());
		if (dashboard != null){
			String sText = WebElementUtils.getChildElements(dashboard, By.tagName("text")).get(1).getText();
			sText.substring(0,sText.indexOf("%"));
			iPercentage = new Integer(sText.substring(0,sText.indexOf("%")).trim()).intValue();
		}
		return iPercentage;
	}

	public int getMediumPriorityPercentage() {
		int iPercentage = 0;
		WebElement dashboard = WebElementUtils.findElement(B2WMaintain.getB2WDashboardWorkOrderChart());
		if (dashboard != null){
			String sText = WebElementUtils.getChildElements(dashboard, By.tagName("text")).get(2).getText();
			iPercentage = new Integer(sText.substring(0,sText.indexOf("%")).trim()).intValue();
		}
		return iPercentage;
	}

	public int getHighPriorityPercentage() {
		int iPercentage = 0;
		WebElement dashboard = WebElementUtils.findElement(B2WMaintain.getB2WDashboardWorkOrderChart());
		if (dashboard != null){
			String sText = WebElementUtils.getChildElements(dashboard, By.tagName("text")).get(3).getText();
			iPercentage = new Integer(sText.substring(0,sText.indexOf("%")).trim()).intValue();
		}
		return iPercentage;
	}
	
	public ArrayList<String> getMechanicsFromChart() {
		ArrayList<String> sText = new ArrayList<String>();
		WebElement dashboard = WebElementUtils.findElement(B2WMaintain.getB2WDashboardWorkOrderManHoursByMechanic());
		if (dashboard != null){
			List<WebElement> list = WebElementUtils.getChildElements(dashboard, By.tagName("text"));
			List<WebElement> mechanics = WebElementUtils.getElementsWithMatchingAttribute(list, "fill", "#4c5356");
			for (WebElement e: mechanics){
				String sMechanic = e.getText();
				log.debug(sMechanic);
				sText.add(sMechanic);
			}
		}
		return sText;
	}

	
	public boolean isCompleteWorkOrderItemHourChartDisplayed(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WDashboardWorkOrderRightChart());
		if (el != null){
			WebElement data = WebElementUtils.getChildElement(el, B2WMaintain.getB2WDashboardNoData());
			bReturn = !data.isDisplayed();
		}
		return bReturn;
	}
}
