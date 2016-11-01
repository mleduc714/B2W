package tasks;

import java.util.List;

import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.B2WHomePage;
import appobjects.B2WNavigationPanel;
import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.B2WTMPriceSheets;
import tasks.resources.B2WEquipmentTasks;
import tasks.resources.B2WKendoTasks;
import tasks.scheduler.B2WSchedulerTasks;
import tasks.setup.B2WSchedulesTasks;
import tasks.util.TaskUtils;

public class B2WNavigationTasks implements Navigation {

	WebDriver driver;
	private static Logger log = Logger.getLogger(B2WNavigationTasks.class);
	
	
	public B2WNavigationTasks() {
		//driver = BrowserUtils.getDriver();
	}
	
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
				WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainGrid());
				if (grid != null) {
					bReturn = grid.isDisplayed();
				}
			}
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
					new B2WSchedulerTasks().waitForSchedulePageNoBusy();
					bReturn = grid.isDisplayed();
				}
			}
		}
		return bReturn;
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
	
	public boolean openReports() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WNavigationPanel.getB2WReportsLink())){
			bReturn = true;
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
		if (openSetup()){
			WebElementUtils.switchToFrame(B2WNavigationPanel.getB2WSetupNavigationPanel(), 1);
			List<WebElement> items = BrowserUtils.getDriver().findElements(B2WNavigationPanel.getB2WSetupPopupItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(items, "Schedules", true);
			if (item != null){
				item.click();
				bReturn = new B2WSchedulesTasks().waitForSchedulesPageNoBusy();
				bReturn &= new TaskUtils().waitForProductPanel("Schedules");
			}
		}
		return bReturn;
	}
	public boolean openSecurityRoles() {
		return openSetup("Security Roles","Hierarchical Security Roles");
	}
	public boolean openAccounts() {
		return openResources("Accounts","Production Accounts");
	}
	public boolean openEmployees() {
		return openResources("Employees","Employees");
	}
	public boolean openMaterials() {
		return openResources("Materials","Materials");
	}
	public boolean openPlaces() {
		return openResources("Places","Places");
	}
	public boolean openOrganizations() {
		return openResources("Organizations","Organizations");
	}
	public boolean openParts() {
		return openResources("Parts","Parts");
	}
	public boolean openEquipmentTypes() {
		return openResources("Equipment Types", "Equipment Types");
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
	public boolean openLaborTypes() {
		return openResources("Labor Types", "Labor Types");
	}
	public boolean openEquipmentRateClasses() {
		return openResources("Equipment Rate Classes","Equipment Rate Classes");
	}
	public boolean openLaborRateClasses() {
		return openResources("Labor Rate Classes", "Labor Rate Classes");
	}
	
}
