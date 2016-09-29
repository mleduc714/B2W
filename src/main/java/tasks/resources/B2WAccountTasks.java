package tasks.resources;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WAccounts;
import tasks.BrowserUtils;
import tasks.WebElementUtils;

public class B2WAccountTasks extends B2WResourceTasks {

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
		if (WebElementUtils.clickElement(B2WAccounts.getNewProductionAccountButton())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getAccountDescription()) != null;
		}
		return bReturn;
	}

	public boolean clickCreateNewOverheadAccountButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WAccounts.getNewOverheadAccountButton())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getAccountDescription()) != null;
		}
		return bReturn;
	}
	

	public boolean openProductionAccountByDescription(String sDescription) {
		boolean bReturn = false;
		enterInfoAndSearchForAccount(sDescription);
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WAccounts.getProductionAccountDescription());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sDescription, false);
			if (el != null) {
				WebElementUtils.clickElement(el);
				WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WAccounts.getPageTitleHeader());
				bReturn = waitForThis != null;
			}
		}
		return bReturn;
	}
	
	@Override
	public boolean clickSearchButton() {
		return WebElementUtils.clickElement(B2WAccounts.getAccountSearchButton());
	}
	
	@Override
	public boolean clickSearchClear() {
		return WebElementUtils.clickElement(B2WAccounts.getClearSearchButton());
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
	
	public boolean deleteOverheadAccountByDescription(String sText){
		boolean bReturn = false;
		if (openOverheadAccountByDescription(sText)) {
			clickTopDeleteButton();
			Alert alert = WebElementUtils.waitForAndGetAlertDialog(WebElementUtils.MEDIUM_TIME_OUT);
			if (alert != null) {
				log.debug("Deleting Overhead Account " + sText);
				alert.accept();
				bReturn = waitForProcessingDialogToClear();
			}

		}
		return bReturn;
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
	
	public String getAppliesToTextLabel() {
		return WebElementUtils.findElement(B2WAccounts.getAppliesToTextLabel()).getText();
	}
	
	public boolean selectValueTypeFromDropDown(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAccountValueType());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}
	
	public boolean selectCostCalcTypePercentage(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAccountCostCalType());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, 1);
		return bReturn;
	}
	
	public boolean selectCostCalcTypeUnitCost() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAccounts.getAccountCostCalType());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, 0);
		return bReturn;
	}
	public String getAccountValueTypeText() {
		return WebElementUtils.findElement(B2WAccounts.getAccountValueTypeLable()).getText();
	}
	public String getAccountInfoCostCalTypeLabel() {
		return WebElementUtils.findElement(B2WAccounts.getAcccountInfoCostCalTypeLabel()).getText();
	}
	public String getAccountUnitCostLabel() {
		return WebElementUtils.findElement(B2WAccounts.getUnitCostLabel()).getText();
	}
	public String getAccountDefaultValueLabel() {
		return WebElementUtils.findElement(B2WAccounts.getAccountDefaultValueLabel()).getText();
	}
	public String getAccountNotesText() {
		return WebElementUtils.findElement(B2WAccounts.getAccountNotesText()).getText();
	}
	
	public boolean createProductionAcccount(String sDesc, String accountID, String sBusinessUnit, String sUnitOfMeasure, String sNotes) {
		clickCreateNewProductionAccountButton();
		setDescription(sDesc);
		setAccountID(accountID);
		selectBusinessUnit(sBusinessUnit);
		selectUnitOfMeasure(sUnitOfMeasure);
		setNotes(sNotes);
		return clickTopSaveButton();
		
	}
	
	public boolean createOverheadAcccount(String sDesc, String accountID, String sBusinessUnit, String sNotes) {
		clickCreateNewOverheadAccountButton();
		setDescription(sDesc);
		setAccountID(accountID);
		selectBusinessUnit(sBusinessUnit);
		setNotes(sNotes);
		return clickTopSaveButton();
	}

}
