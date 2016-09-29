package tasks.resources;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WAccounts;
import appobjects.setup.B2WAddLaborTypes;
import appobjects.setup.B2WEmployees;
import tasks.BrowserUtils;
import tasks.WebElementUtils;

public class B2WEmployeeTasks extends B2WResourceTasks {
	
	Logger log = Logger.getLogger(B2WEmployeeTasks.class);

	public boolean createNewEmployeeButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WEmployees.getCreateNewEmployeeButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WEmployees.getEmployeeFirstName()) != null;
		}
		return bReturn;
	}

	public boolean setEmployeeFirstName(String sFirstName) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeFirstName());
		return WebElementUtils.sendKeys(el, sFirstName);
	}

	public boolean setEmployeeMiddleName(String sMiddleName) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeMiddleName());
		return WebElementUtils.sendKeys(el, sMiddleName);
	}

	public boolean setEmployeeLastName(String sLastName) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeLastName());
		return WebElementUtils.sendKeys(el, sLastName);
	}

	public boolean setEmployeeID(String sID) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeID());
		return WebElementUtils.sendKeys(el, sID);
	}

	public boolean setEmployeeBusinessUnit(String sText) {
		return new B2WAccountTasks().selectBusinessUnit(sText);
	}

	public boolean setFieldLogReviewerCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getFieldLogReviewer());
		return checkBox(el, bCheck);
	}

	public boolean setEmployeeTitle(String sTitle) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeTitle());
		return WebElementUtils.sendKeys(el, sTitle);
	}

	public boolean setEmployeeNickName(String sNickName) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeNickName());
		return WebElementUtils.sendKeys(el, sNickName);
	}

	public boolean setEmployeeCellPhone(String sCellPhone) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeCellPhone());
		return WebElementUtils.sendKeys(el, sCellPhone);
	}

	public boolean setEmployeeHomePhone(String sHomePhone) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeHomePhone());
		return WebElementUtils.sendKeys(el, sHomePhone);
	}

	public boolean setEmployeeWorkPhone(String sWorkPhone) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeHomePhone());
		return WebElementUtils.sendKeys(el, sWorkPhone);
	}

	public boolean setEmployeeEmail(String sEmail) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeEmail());
		return WebElementUtils.sendKeys(el, sEmail);
	}

	public boolean setFieldEmployeeCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getFieldEmployeeCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setDriverCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getDriverCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setTruckDriverCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getTruckDriverCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setForemanCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getForemanCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setSupervisorCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getSupervisorheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setProjectManagerCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getProjectManagerCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setMechanicCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getMechanicCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setBuyerCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getBuyerCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setPurchaseOrderApproverCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WEmployees.getPurchaseOrderApproverCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean openAddLaborTypeDialog() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WEmployees.getAddLaborTypeButton());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				bReturn = WebElementUtils.switchToFrame(B2WAddLaborTypes.getAddLaborTypesDialog(),
						WebElementUtils.SHORT_TIME_OUT);

			}
		}
		return bReturn;
	}

	public boolean addCertificationsButton() {
		return false;
	}
	
	public boolean openByLastName(String sLastName){
		boolean bReturn = false;
		enterTextandSearchForEmployee(sLastName);
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WEmployees.getEmployeeLastName());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sLastName, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getPageTitleHeader());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean enterTextandSearchForEmployee(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WEmployees.getEmployeeSearchText());
		if (el!=null){
			bReturn =WebElementUtils.sendKeys(el, sText);
			bReturn &= WebElementUtils.clickElement(B2WEmployees.getEmployeeSearchButton());
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}
	
	public boolean openEmployeeByLastName(String sText){
		boolean bReturn = false;
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WEmployees.getEmployeeByLastNameGrid());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sText, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WEmployees.getEmployeeLastNameText());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
}
