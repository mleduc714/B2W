package tasks.maintain;

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
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUserInfo());
		sUser = WebElementUtils.getChildElement(el, By.tagName("strong")).getText();
		return sUser;
	}
	public int getUnassignedRepairRequests(){
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardNewRequests());
		String number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
		return new Integer(number).intValue();
	}
	public boolean openUnassignedRepairRequests() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardNewRequests());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForPageHeader("Requests");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	public int getUnscheduledPM(){
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRequestsAndAssigned());
		String number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
		return new Integer(number).intValue();
	}
	
	public boolean openUnscheduledPM() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRequestsAndAssigned());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForPageHeader("Requests");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	
	
	public int getUnscheduledWorkOrders(){

		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUnscheduleWorkOrders());
		String number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
		return new Integer(number).intValue();
	}
	public boolean opeUnscheduledWorkOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUnscheduleWorkOrders());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForPageHeader("Work Order Schedule by Mechanic");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);

		}
		return bReturn;
	}
	
	public int getPastDueWorkOrders() {

		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPastDue());
		String number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
		return new Integer(number).intValue();
	}
	
	public boolean openPastDueWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPastDue());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForPageHeader("Work Order Schedule by Mechanic");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public int getPendingTimeCards(){
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPendingCards());
		String number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
		return new Integer(number).intValue();
	}
	public boolean openPendingTimeCards() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPendingCards());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForPageHeader("Time Cards");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	
	public boolean selectWorkOrderByLocation(String s){
		return selectWorkOrder(s,0);
	}
	public boolean selectWorkOrderByAssigned(String s){
		return selectWorkOrder(s,1);
	}
	public boolean selectWorkOrderByEquipment(String s){
		return selectWorkOrder(s,2);
	}
	
	private boolean selectWorkOrder(String s, int i) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardWorkOrderList());
		List<WebElement> containers = WebElementUtils.getChildElements(el, B2WMaintain.getB2WMaintainDashboardWorkOrderContainer());
		Iterator<WebElement> iter = containers.iterator();
		while (iter.hasNext()){
			WebElement workorder = iter.next();
			List<WebElement> list = WebElementUtils.getChildElements(workorder, B2WMaintain.getB2WMaintainDashboardWorkOrderData());
			System.out.println(list.size());
			WebElement location = list.get(0);
			String sLocation = location.getAttribute("title");
			System.out.println(sLocation);
			if (sLocation.startsWith(s)){
				Coordinates coordinate = ((Locatable)workorder).getCoordinates(); 
				coordinate.onPage(); 
				coordinate.inViewPort();
				bReturn = WebElementUtils.clickElement(workorder);
				break;
			}
		}
		return bReturn;
	}
	
	public boolean clickScheduleWorkOrderFiltersButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardWorkOrdersFilter());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public boolean clickRefresh() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRefresh());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public boolean clickYearToDate() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardYearToDateLink());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean clickMonthToDate() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardMonthToDateLink());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean clickViewTimeCards() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardTimeCardsLink());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean clickViewWorkOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardViewWorksLink());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
}
