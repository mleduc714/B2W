package tasks.resources;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WAccounts;
import tasks.B2WSetupTasks;
import tasks.BrowserUtils;
import tasks.WebElementUtils;

public class B2WAccountTasks extends B2WSetupTasks {

	Logger log = Logger.getLogger(B2WAccountTasks.class);

	public boolean expandProductionAccounts() {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getProductionAccountsHeader());
		if (isSectionCollapsed(el)) {
			clickOnTwistie(el);
		}
		return !isSectionCollapsed(el);
	}

	public boolean collapseProductionAccounts() {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getProductionAccountsHeader());
		if (!isSectionCollapsed(el)) {
			clickOnTwistie(el);
		}
		return isSectionCollapsed(el);

	}

	public boolean expandOverheadAccounts() {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getOverheadAccountsHeader());
		if (isSectionCollapsed(el)) {
			clickOnTwistie(el);
		}
		return !isSectionCollapsed(el);
	}

	public boolean collapseOverheadAccounts() {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getOverheadAccountsHeader());
		if (isSectionCollapsed(el)) {
			clickOnTwistie(el);
		}
		return !isSectionCollapsed(el);

	}

	public boolean clickCreateNewProductionAccountButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WAccounts.getNewProductionAccountButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getAccountDescription()) != null;
		}
		return bReturn;
	}

	public boolean clickCreateNewOverheadAccountButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WAccounts.getNewOverheadAccountButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getAccountDescription()) != null;
		}
		return bReturn;
	}
	
	public boolean clickCreateNewMaterialsButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WAccounts.getCreateNewMaterialsButton())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getAccountDescription()) != null;
			}
			return bReturn;
	}

	public boolean setDescription(String sDescription) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAccountDescription());
		return WebElementUtils.sendKeys(el, sDescription);
	}

	public boolean setAccountID(String sText) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAccountID());
		return WebElementUtils.sendKeys(el, sText);
	}

	public boolean checkTimeAndMaterials() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getTimeMaterialsCheckBox());
		if (!WebElementUtils.isCheckboxChecked(el)) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean selectBusinessUnit(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;

	}

	public boolean selectBusinessUnit(int iSelect) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, iSelect);
		return bReturn;
	}

	public boolean selectUnitOfMeasure(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}

	public boolean selectUnitOfMeasure(int iSelect) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, iSelect);
		return bReturn;
	}

	public String getSelectedBusinessUnit() {
		String sSelection = null;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		sSelection = WebElementUtils.getSelectedTextFromDropDown(els);
		return sSelection;
	}

	public String getSelectedUnitOfMeasure() {
		String sSelection = null;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		sSelection = WebElementUtils.getSelectedTextFromDropDown(els);
		return sSelection;
	}

	public boolean selectInactiveCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getInactiveCheckBox());
		return checkBox(el, bCheck);

	}

	public boolean checkAppliesToEmployees(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAppliesToEmployeesCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean checkAppliesToEquipment(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAppliesToEmployeesCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean checkAppliesToMaterial(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAppliesToEmployeesCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean checkAppliesToMiscesllaneous(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAppliesToEmployeesCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean checkAppliesToTrucking(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAppliesToEmployeesCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean checkAppliesToSubcontractors(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAppliesToEmployeesCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean openProductionAccountByDescription(String sDescription) {
		boolean bReturn = false;
		enterInfoAndSearchForAccount(sDescription);
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WAccounts.getProductionAccountDescription());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sDescription, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getPageTitleHeader());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}

	private boolean enterInfoAndSearchForAccount(String sText) {
		boolean bReturn = false;
		if (enterSearchText(sText)) {
			clickSearchButton();
			bReturn = waitForProcessingDialogToClear();
		}
		return bReturn;

	}

	public boolean openProductionAccountByAccountID(String sID) {
		boolean bReturn = false;
		enterInfoAndSearchForAccount(sID);
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WAccounts.getProductionAccountID());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sID, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getPageTitleHeader());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}

	public boolean openOverheadAccountByDescription(String sDescription) {
		boolean bReturn = false;
		enterInfoAndSearchForAccount(sDescription);
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WAccounts.getOverheadAccountDescription());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sDescription, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getPageTitleHeader());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}

	public boolean openOverheadAccountByAccountID(String sID) {
		boolean bReturn = false;
		enterInfoAndSearchForAccount(sID);
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WAccounts.getOverheadAccountID());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sID, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getPageTitleHeader());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}

	public boolean deleteProductionAccountByDescription(String sText) {
		boolean bReturn = false;
		if (openProductionAccountByDescription(sText)) {
			clickTopDeleteButton();
			Alert alert = WebElementUtils.waitForAndGetAlertDialog(WebElementUtils.MEDIUM_TIME_OUT);
			if (alert != null) {
				log.debug("Deleting Production Account " + sText);
				alert.accept();
				bReturn = waitForProcessingDialogToClear();
			}

		}
		return bReturn;
	}

	public boolean clickSearchButton() {
		return WebElementUtils.clickElement(B2WAccounts.getAccountSearchButton());
	}

	public boolean setNotes(String sText) {
		return WebElementUtils.sendKeys(B2WAccounts.getGeneralInformationNotes(), sText);
	}

	public boolean setAlternateID(String sText) {
		return WebElementUtils.sendKeys(B2WAccounts.getAccountAlterID(), sText);
	}

	public boolean setCategory(int iSelect) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, iSelect);
		return bReturn;
	}

	public boolean setCategory(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}
	
	public boolean checkTemporaryMaterial(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WAccounts.getTempMaterialCheckBox());
		return checkBox(el, bCheck);
	}
	
	public boolean checkTrackableMaterial(boolean bCheck){
		WebElement el = WebElementUtils.waitAndFindElement(B2WAccounts.getTrackableMaterialCheckBox());
		return checkBox(el, bCheck);
	}
	
	public boolean setTotalCount(String iCount){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindElement(B2WAccounts.getTotalCount());
		bReturn = WebElementUtils.sendKeys(el, iCount);
		return bReturn;
	}

}
