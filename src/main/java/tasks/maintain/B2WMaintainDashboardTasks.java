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
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainDashboardUserInfo());
		sUser = WebElementUtils.getChildElement(el, By.tagName("strong")).getText();
		return sUser;
	}
	
	public String getDateFromDashboard() {
		String sDate = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainDashboardUserInfo());
		List<WebElement> list = WebElementUtils.getChildElements(el,By.tagName("strong"));
		List<WebElement> list1 = WebElementUtils.getChildElements(el, By.tagName("span"));
		WebElement day =  WebElementUtils.getElementWithMatchingAttribute(list1, "data-bind", "text:getDay");
		WebElement date = WebElementUtils.getElementWithMatchingAttribute(list, "data-bind", "text:getDate");
		if (date != null && day != null){
			sDate = day.getText()+ "," + " "+date.getText();
		}
		return sDate;
	}
	
	public int getUnassignedRepairRequests(){

		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardNewRequests());
		if ( el != null){
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}
	public boolean openUnassignedRepairRequests() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardNewRequests());
		if (el != null){
			if (WebElementUtils.clickElement(el)){
				bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
				bReturn &= new TaskUtils().waitForProductPanel("Requests");
				bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoGridContent()) != null;
				
			}
		}
		return bReturn;
	}
	public int getUnscheduledPM(){
		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRequestsAndAssigned());
		if ( el != null){
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}
	
	public boolean openUnscheduledPM() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardRequestsAndAssigned());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForProductPanel("Requests");
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	
	
	public int getUnscheduledWorkOrders(){
		

		String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUnscheduleWorkOrders());
		if ( el != null){
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	
	}
	public boolean openUnscheduledWorkOrders() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUnscheduleWorkOrders());
		if (el != null){
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
		if ( el != null){
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}
	
	public boolean openPastDueWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPastDue());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public int getPendingTimeCards(){
	String number = "";
		int iNumber = 0;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPendingCards());
		if ( el != null){
			number = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainDashboardNumber()).getText();
			iNumber = new Integer(number).intValue();
		}
		return iNumber;
	}
	public boolean openPendingTimeCards() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardPendingCards());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= new TaskUtils().waitForProductPanel("Time Cards");
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
			WebElement location = list.get(0);
			String sLocation = location.getAttribute("title");
			if (sLocation.contains(s)){
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
	
	public String getDashboardUpdatedText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardUserInfo());
		List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("span"));
		WebElement day =  WebElementUtils.getElementWithMatchingAttribute(list, "data-bind", "text:getDateAndTime");
		if (day != null){
			sText = day.getText();
		}
		return sText;
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
