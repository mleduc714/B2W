package tasks.maintain;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;

public class B2WMaintainTasks extends B2WKendoTasks {
	
	
	public enum MENUITEM {DASHBOARD, REQUESTS, WORKORDERS, SCHEDULE, TIMECARDS, PROGRAMS, EQUIPMENT, PARTS, INVENTORY, PURCHASING};
	
	private final String DASHBOARD = "Dashboard";
	private final String REQUESTS = "Requests";
	private final String WORKORDERS = "Work Orders";
	private final String SCHEDULE = "Schedule";
	private final String TIMECARDS = "Time Cards";
	private final String PROGRAMS = "Programs";
	private final String EQUIPMENT = "Equipment";
	private final String PARTS = "Parts";
	private final String INVENTORY = "Inventory";
	private final String PURCHASING = "Purchasing";
	
	
	Logger log = Logger.getLogger(B2WMaintainTasks.class);
	
	public String getSelectedMenuItem() {
		String sMenu = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainPageMenu());
		if (el != null){
			List<WebElement> menuItems = WebElementUtils.getChildElements(el, By.tagName("li"));
			Iterator<WebElement> iter = menuItems.iterator();
			while (iter.hasNext()){
				WebElement item = iter.next();
				String isSelected =  item.getAttribute("class");
				if (isSelected.equals("selected")){
					WebElement name = item.findElement(By.cssSelector("div.tabcontent"));
					sMenu = name.getText();
					log.debug("Selected Menu item is "+sMenu);
				}
			}
		}
		
		return sMenu;
	}
	
	public boolean openDashboard(){
		return openMenuItem(MENUITEM.DASHBOARD);
	}
	public boolean openRequests(){
		return openMenuItem(MENUITEM.REQUESTS);
	}
	public boolean openWorkOrders(){
		return openMenuItem(MENUITEM.WORKORDERS);
	}
	public boolean openSchedule(){
		return openMenuItem(MENUITEM.SCHEDULE);
	}
	public boolean openTimeCards(){
		return openMenuItem(MENUITEM.TIMECARDS);
	}
	public boolean openPrograms(){
		return openMenuItem(MENUITEM.PROGRAMS);
	}
	public boolean openEquipment(){
		return openMenuItem(MENUITEM.EQUIPMENT);
	}
	public boolean openParts(){
		return openMenuItem(MENUITEM.PARTS);
	}
	public boolean openInventory(){
		return openMenuItem(MENUITEM.INVENTORY);
	}
	public boolean openPurchasing(){
		return openMenuItem(MENUITEM.PURCHASING);
	}
	
	public boolean openMenuItem(MENUITEM menu) {
		boolean bReturn = false;
		String sMenuItem = "";
		By by = null;
		
		switch (menu){
		case DASHBOARD:
			sMenuItem = DASHBOARD;
			by = B2WMaintain.getB2WMaintainDashboard();
			break;
		case EQUIPMENT:
			sMenuItem = EQUIPMENT;
			by = B2WMaintain.getB2WMaintainEquipment();
			break;
		case INVENTORY:
			sMenuItem = INVENTORY;
			by = B2WMaintain.getB2WMaintainInventory();
			break;
		case PARTS:
			sMenuItem = PARTS;
			by = B2WMaintain.getB2WMaintainParts();
			break;
		case PROGRAMS:
			sMenuItem = PROGRAMS;
			by = B2WMaintain.getB2WMaintainPrograms();
			break;
		case PURCHASING:
			sMenuItem = PURCHASING;
			by = B2WMaintain.getB2WMaintainPurchasing();
			break;
		case REQUESTS:
			sMenuItem = REQUESTS;
			by = B2WMaintain.getB2WMaintainRequests();
			break;
		case SCHEDULE:
			sMenuItem = SCHEDULE;
			by = B2WMaintain.getB2WMaintainSchedule();
			break;
		case TIMECARDS:
			sMenuItem = TIMECARDS;
			by = B2WMaintain.getB2WMaintainTimeCards();
			break;
		case WORKORDERS:
			sMenuItem = WORKORDERS;
			by = B2WMaintain.getB2WMaintainWorkOrders();
			break;
		}
		if (getSelectedMenuItem().startsWith(sMenuItem)) {
			bReturn = true;
			log.debug(DASHBOARD + " is already selected");
		} else {

			WebElement item = WebElementUtils.waitAndFindDisplayedElement(by);
			if (item != null) {
				WebElementUtils.clickElement(item);
				bReturn = waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
				bReturn &= getSelectedMenuItem().equals(sMenuItem);
			}
		}

		return bReturn;
	}
	
	
}
