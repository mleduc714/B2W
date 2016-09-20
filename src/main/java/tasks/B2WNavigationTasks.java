package tasks;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.B2WHomePage;
import appobjects.B2WNavigationPanel;
import appobjects.maintain.B2WMaintain;
import appobjects.setup.B2WAccounts;
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
					bReturn = el.isDisplayed();
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
	
	public boolean openSetup() {
		boolean bReturn = false;
		WebElement el = null;
		if (WebElementUtils.clickElement(B2WNavigationPanel.getB2WSetupLink())){
			el = WebElementUtils.waitAndFindDisplayedElement(B2WNavigationPanel.getB2WSetupPanel());
			if (el!=null){
				bReturn = el.isDisplayed();		
				}
		}
		return bReturn;
	}
	
	public boolean openResources() {
		boolean bReturn = false;
		WebElement el = null;
		if (WebElementUtils.clickElement(B2WNavigationPanel.getB2WResourcesLink())){
			el = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getProductionAccountsHeader());
			if (el!=null){
				bReturn = el.isDisplayed();
			}
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
	
	public String getUserName() {
		String sUserName = "";
		WebElement el = WebElementUtils.findElement(B2WNavigationPanel.getB2WUserName());
		if (el != null){
			sUserName = el.getText();
		}
		return sUserName;
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
	public boolean openSecurityRoles() {
		return openSetup("Security Roles","Hierarchical Security Roles");
	}
	

}
