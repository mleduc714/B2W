package tasks.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.maintain.B2WMaintainTasks;

public class B2WMaintainSchedulePopupToolTip {
	
	String ITEMS = "Items";
	String ASSIGNEDTO = "Assigned to";
	String LOCATION = "Location";
	String PRIORITY = "Priority";
	String NOTES = "Notes";
	
	
	private WebElement getSchedulePopup() {
		WebElement schedule = null;
		List<WebElement> list = WebElementUtils.findElements(By.className("schedule-tooltip"));
		for (WebElement el: list){
			if (el.isDisplayed()){
				if (!el.getAttribute("class").contains("priority-indicator")){
					schedule = el;
					break;
				}
			}
		}
		return schedule;
			
	}
	
	public String getWorkOrderTitle(){
		String sText = "";
		WebElement el = WebElementUtils.getChildElement(getSchedulePopup(), B2WMaintain.getB2WMaintainSchedulePopupWorkOrderTitle());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getEquipment(){
		String sText = "";
		List<WebElement> el = WebElementUtils.getChildElements(getSchedulePopup(), By.tagName("span"));
		if (el != null){
			
			sText = el.get(1).getText();
			sText = sText.substring(0, sText.indexOf("]")+1);
		}
		return sText;
	}
	public String getTimeSpan() {
		String sText = "";
		WebElement el = WebElementUtils.getChildElement(getSchedulePopup(), B2WMaintain.getB2WMaintainSchedulePopupWorkOrderTime());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getTimeWarning() {
		String sText = "";
		WebElement el = WebElementUtils.getChildElement(getSchedulePopup(), B2WMaintain.getB2WMaintainSchedulePopupWarning());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public ArrayList<String> getItems() {
		 ArrayList<String> al = new ArrayList<String>();
		 WebElement el = getSectionTitle(ITEMS);
		 List<WebElement> items = WebElementUtils.getChildElements(el, By.tagName("li"));	
		 Iterator<WebElement> iter = items.iterator();
		 while (iter.hasNext()){
			 al.add(iter.next().getText());
		 }
		return al;
	}
	public String getAssignedTo() {
		WebElement el = getSectionTitle(ASSIGNEDTO);
		return getTextFromSection(el);
	}
	public String getLocation() {

		WebElement el = getSectionTitle(LOCATION);
		return getTextFromSection(el);
	
	}
	public String getPriority(){

		WebElement el = getSectionTitle(PRIORITY);
		return getTextFromSection(el);
	
	}

	public String getNotes() {
		WebElement el = getSectionTitle(NOTES);
		return getTextFromSection(el);

	}
	public boolean clickEquipmentLink(){

		boolean bReturn = false;
		List<WebElement> el = WebElementUtils.getChildElements(getSchedulePopup(), By.tagName("a"));
		if (el.size() > 0){
			BrowserUtils.getDriver().navigate().to(el.get(0).getAttribute("href"));
			bReturn = true;
		}
		return bReturn;
	}
	public boolean clickWorkItemLink(){

		boolean bReturn = false;
		WebElement e = getSchedulePopup();
		List<WebElement> el = WebElementUtils.getChildElements(e, By.tagName("a"));
		if (el.size() > 1){
			BrowserUtils.getDriver().navigate().to(el.get(1).getAttribute("href"));
			bReturn = new B2WMaintainTasks().waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	public boolean closeToolTip() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainSchedulePopupClose());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public WebElement getSectionTitle(String sTitle){
		WebElement item = null;
		List<WebElement> el = WebElementUtils.getChildElements(getSchedulePopup(), B2WMaintain.getB2WMaintainSchedulePopupSectionTitle());
		if (el.size() > 0){
		
			item = WebElementUtils.getElementWithMatchingText(el, sTitle, false);
		}
		return item;
	}
	
	private String getTextFromSection(WebElement el) {
		String sText = "";
		WebElement parent = WebElementUtils.getParentElement(el);
		List<WebElement> list = WebElementUtils.getChildElements(parent, By.tagName("span"));
		if (el != null) {
			sText = list.get(1).getText();
		}
		return sText;
	}
	
	

}
