package tasks;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.B2WHomePage;
import appobjects.B2WNavigationPanel;
import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.B2WTMPriceSheets;
import appobjects.scheduler.B2WScheduleAssignments;
import tasks.maintain.B2WMaintainTasks;
import tasks.resources.B2WCrewTemplateTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.scheduler.B2WSchedulerTasks;
import tasks.util.TaskUtils;

public class B2WNavigationTasks implements Navigation {

	WebDriver driver;
	private static Logger log = Logger.getLogger(B2WNavigationTasks.class);
	
	
	public B2WNavigationTasks() {
		
	}

	//======
	public boolean clickHome() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WNavigationPanel.getB2WHome())){
			log.debug("Clicked the Home Button. Waiting for Page to appear");
			WebElement el =  WebElementUtils.waitAndFindDisplayedElement(B2WHomePage.getB2WHomeMarketingPage(), WebElementUtils.MEDIUM_TIME_OUT);
			if (el!=null){
				bReturn = true;
			}
		}
		return bReturn;
	}
	public boolean openJobs() {
		boolean bReturn = false;
		WebElement el = null;
		el = WebElementUtils.findElement(B2WNavigationPanel.getB2WJobs());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				WebElement jobsGrid = WebElementUtils
						.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPageContentGrid());
				if (jobsGrid != null) {
					bReturn = true;
				}
			}
		}
		return bReturn;
	}
	public boolean openTrack() {
		boolean bReturn = false;
		WebElement el = null;
		el = WebElementUtils.findElement(B2WNavigationPanel.getB2WTrack());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Field Logs");
			}
		}
		return bReturn;
	}
	public boolean openDispatch() {
		boolean bReturn = false;
		WebElement el = null;
		el = WebElementUtils.findElement(B2WNavigationPanel.getB2WDispatch());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Job Board");
			}
		}
		return bReturn;
	}

	public boolean openMaintain() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2WMaintain());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				WebElement menu = WebElementUtils.waitAndFindDisplayedElement(By.cssSelector("div.SubNavMenu"));
				if (menu.getAttribute("class").endsWith("closed")){
					WebElement button = WebElementUtils.findElement(B2WMaintain.getB2WMaintainExpandButton());
					bReturn = WebElementUtils.clickElement(button);
				}else{
					bReturn = true;
				}
				
			}
			new B2WMaintainTasks().waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public boolean openSchedule() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2WSchedule());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleCenterPanel());
				if (grid != null) {
					new B2WSchedulerTasks().waitForSchedulesPageNoBusy();
					bReturn = grid.isDisplayed();
				}
			}
		}
		return bReturn;
	}
	public boolean isScheduleIsOpened() {
		WebElement grid = WebElementUtils.findElement(B2WScheduleAssignments.getScheduleCenterPanel());
		if (grid != null) { return true; }
		else { return false; }
	}

	public boolean openSetup() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WNavigationPanel.getB2WSetupLink())) {
			WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WNavigationPanel.getB2WSetupNavigationPanel(),
					WebElementUtils.SHORT_TIME_OUT);
			if (el != null) {
				bReturn = true;
			} else {
				log.debug("Open Resources is returning a null on Navigation Panel");
			}

		}
		return bReturn;
	}
	
	public boolean openResources() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WNavigationPanel.getB2WResourcesLink())){
			WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WNavigationPanel.getB2WSetupNavigationPanel(), WebElementUtils.SHORT_TIME_OUT);
			if (el != null){
				bReturn = true;
			}else{
				log.debug("Open Resources is returning a null on Navigation Panel");
			}
		}
		return bReturn;
	}
	
	public String getResourceTitle() {
		return WebElementUtils.findElement(B2WNavigationPanel.getB2WResourcesLink()).findElement(By.tagName("img")).getAttribute("title");
	}
	public String getReportsTitle() {
		return WebElementUtils.findElement(B2WNavigationPanel.getB2WReportsLink()).findElement(By.tagName("img")).getAttribute("title");
	}
	public String getSetupTitle() {
		return WebElementUtils.findElement(B2WNavigationPanel.getB2WSetupLink()).findElement(By.tagName("img")).getAttribute("title");
	}
	public String getHelpTitle() {
		return WebElementUtils.findElement(B2WNavigationPanel.getB2WNavigationHelp()).findElement(By.tagName("img")).getAttribute("title");
	}
	public boolean openReports() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WNavigationPanel.getB2WReportsLink())){
			bReturn = new TaskUtils().waitForProductPanel("Reports and Dashboards");
		}
		return bReturn;
	}

	private boolean openSetup(String sMenuItem, String sPanel) {
		boolean bReturn = false;
		if (openSetup()){
			WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
			List<WebElement> items = BrowserUtils.getDriver().findElements(B2WNavigationPanel.getB2WSetupPopupItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(items, sMenuItem, true);
			if (item != null){
				item.click();
				bReturn = new TaskUtils().waitForPageHeader(sPanel);
			}
			
		}
		return bReturn;
	}
	
	private boolean openResources(String sMenuItem, String sPanel) {
		boolean bReturn = false;
		if (!sPanel.equals(new TaskUtils().getPageHeader())) {
			if (openResources()) {
				WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
				List<WebElement> items = BrowserUtils.getDriver()
						.findElements(B2WNavigationPanel.getB2WSetupPopupItem());
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sMenuItem, true);
				if (item != null) {
					item.click();
					bReturn = new TaskUtils().waitForPageHeader(sPanel);
				}

			}

		} else {
			log.debug("The " + sMenuItem + " is Opened");
			bReturn = true;
		}

		return bReturn;
	}

	public String getUserName() {
		String sUserName = "";
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2WUserName());
		if (el != null){
			sUserName = el.getText();
		}
		return sUserName;
	}
	
	public String getLastNameOfUser() {
		String sLastName = "";
		String userName = getUserName();
		for (int i = 0; i < userName.length(); i++) {
			if (Character.isWhitespace(userName.charAt(i))) {
				sLastName = userName.substring(++i, userName.length());
				break;
			}
		}
		return sLastName;
	}

	// ====== Setup =======
	public boolean openSetupUsers() {
		return openSetup("Users","User Listing");
	}
	public boolean openAddIns(){
		return openSetup("Add-ins","Add-ins");
	}
	public boolean openBusinessUnits() {
		return openSetup("Business Units","Business Units");
	}
	public boolean openCategories() {
		return openSetup("Categories","Categories");
	}
	public boolean openCustomProperties() {
		return openSetup("Custom Properties","Custom Properties");
	}
	public boolean openDepartmentMappings() {
		return openSetup("Department Mappings","Departments");
	}
	public boolean openLicenseInformation() {
		return openSetup("License Information","Modules Licensed");
	}
	public boolean openMobileDevices() {
		return openSetup("Mobile Devices","Mobile Devices");
	}
	public boolean openMobileWorkstations(){
		return openSetup("Mobile Workstations","Mobile Workstations");
	}
	public boolean openSchedules() {
		boolean bReturn = false;
		if (!new TaskUtils().waitForProductPanel("Schedules")) {
			if (openSetup()) {
				WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
				List<WebElement> items = BrowserUtils.getDriver().findElements(B2WNavigationPanel.getB2WSetupPopupItem());
				WebElement item = WebElementUtils.getElementWithMatchingText(items, "Schedules", true);
				if (item != null) {
					item.click();
					bReturn = new B2WSchedulerTasks().waitForSchedulesPageNoBusy();
					bReturn &= new TaskUtils().waitForProductPanel("Schedules");
				}
			}
		} else bReturn = true;
		return bReturn;
	}
	public boolean openSecurityRoles() {
		return openSetup("Security Roles","Hierarchical Security Roles");
	}

	// ====== Resources =======
	public boolean openAccounts() {
		return openResources("Accounts","Production Accounts");
	}
	public boolean openCrewTemplates() {
		boolean bReturn = false;
		if (openResources()) {
			WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
			List<WebElement> items = BrowserUtils.getDriver()
					.findElements(B2WNavigationPanel.getB2WSetupPopupItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(items, "Crew Templates", true);
			if (item != null) {
				item.click();
				WebElement panel = WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPageProductPanel());
				String sText = panel.findElement(By.tagName("h1")).getText();
				bReturn = sText.equals("Crew Templates");
				new B2WCrewTemplateTasks().waitForSchedulesPageNoBusy();
			}
		} else {
			log.debug("Resource menu could not be opened.");
		}
		return bReturn;
	}
	public boolean openEmployees() {
		return openResources("Employees","Employees");
	}
	public boolean openEquipment() {
		boolean bReturn = false;
		if (openResources()) {
			WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
			List<WebElement> items = BrowserUtils.getDriver().findElements(B2WNavigationPanel.getB2WSetupPopupItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(items, "Equipment", true);
			if (item != null) {
				item.click();
				WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getKendoButton());
				if (el != null) {
					bReturn = true;
					bReturn &= new B2WEquipmentTasks().waitForEquipmentPageNoBusy();
				}
			}
		}
		return bReturn;
	}
	
	//THIS MIGHT NOT WORK
	public boolean openPrograms() {
		boolean bReturn = false;
		if (openResources()) {
			WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
			List<WebElement> items = BrowserUtils.getDriver().findElements(B2WNavigationPanel.getB2WSetupPopupItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(items, "Programs", true);
			if (item != null) {
				item.click();
				WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getKendoButton());
				if (el != null) {
					bReturn = true;
					bReturn &= new B2WEquipmentTasks().waitForEquipmentPageNoBusy();
				}
			}
		}
		return bReturn;
	}
	//THIS MIGHT NOT WORK
	
	public boolean openEquipmentRateClasses() {
		return openResources("Equipment Rate Classes","Equipment Rate Classes");
	}
	public boolean openEquipmentTypes() {
		return openResources("Equipment Types", "Equipment Types");
	}
	public boolean openLaborRateClasses() {
		return openResources("Labor Rate Classes", "Labor Rate Classes");
	}
	public boolean openLaborTypes() {
		return openResources("Labor Types", "Labor Types");
	}
	public boolean openMaterials() {
		return openResources("Materials","Materials");
	}
	public boolean openOrganizations() {
		return openResources("Organizations","Organizations");
	}
	public boolean openParts() {
		return openResources("Parts","Parts");
	}
	public boolean openPlaces() {
		return openResources("Places","Places");
	}
	public boolean openTimeSheets() {
		boolean bReturn = false;
		if (openResources()) {
			WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
			List<WebElement> items = BrowserUtils.getDriver().findElements(B2WNavigationPanel.getB2WSetupPopupItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(items, "T&M Price Sheets", true);
			if (item != null) {
				item.click();
				WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WTMPriceSheets.getNewPriceSheetButton());
				if (el != null) {
					bReturn = true;
					bReturn &= new B2WEquipmentTasks().waitForEquipmentPageNoBusy();
				}
			}
		}
		return bReturn;
	}

	public ArrayList<String> getNavigatonPanelItems() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2WNavigationMenu());
		List<WebElement> items = WebElementUtils.getChildElements(el, By.tagName("a"));
		for (WebElement e: items){
			al.add(e.getText());
		}
		return al;
		
	}
	
	public ArrayList<String> getResourceItems() {
		ArrayList<String> al = new ArrayList<String>();
		if (openResources()) {

			List<WebElement> list = WebElementUtils.getChildElements(
					WebElementUtils.findElement(B2WNavigationPanel.getB2WSetupNavigationPanel()),
					By.className("nav-popup-item"));
			for (WebElement e : list) {
				al.add(WebElementUtils.getChildElement(e, By.tagName("a")).getText());
			}

		}
		return al;
	}
	public ArrayList<String> getSetupItems() {
		ArrayList<String> al = new ArrayList<String>();
		if (openSetup()) {

			List<WebElement> list = WebElementUtils.getChildElements(
					WebElementUtils.findElement(B2WNavigationPanel.getB2WSetupNavigationPanel()),
					By.className("nav-popup-item"));
			for (WebElement e : list) {
				al.add(WebElementUtils.getChildElement(e, By.tagName("a")).getText());
			}

		}
		return al;
	}
	
	public boolean clickChevron() {
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2WNavigationChevron());
		WebElement button = WebElementUtils.getChildElement(el, B2WNavigationPanel.getB2WNavigationMarketing());
		return WebElementUtils.clickElement(button);
	}
	
	public boolean isMarketingAreaOpen() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2WNavigationChevron());
		if (el.getAttribute("class").equals("open")){
			bReturn = true;
		}
		return bReturn;
	}
	
	public boolean isBadgeEstimateVisible() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2wBadgeEstimate());
		if (el != null){
		 bReturn = el.isDisplayed();
		}
		return bReturn;
		
	}
	public boolean isBadgeScheduleVisible() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2wBadgeSchedule());
		if (el != null){
		 bReturn = el.isDisplayed();
		}
		return bReturn;
		
	}
	public boolean isBadgeTrackVisible() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2wBadgeTrack());
		if (el != null){
		 bReturn = el.isDisplayed();
		}
		return bReturn;
		
	}
	public boolean isBadgeMaintainVisible() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2wBadgeMaintain());
		if (el != null){
		 bReturn = el.isDisplayed();
		}
		return bReturn;
		
	}
	public boolean isBadgeInformVisible() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2wBadgeInform());
		if (el != null){
		 bReturn = el.isDisplayed();
		}
		return bReturn;
		
	}
	
}
