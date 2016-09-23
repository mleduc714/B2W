package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WAccounts {

	public static By getProductionAccountsHeader() {
		return By.cssSelector(B2WUIMap.b2w_setup_productionaccounts);
	}
	public static By getOverheadAccountsHeader() {
		return By.cssSelector(B2WUIMap.b2w_setup_overheadaccounts);
	}
	public static By getNewProductionAccountButton() {
		return By.cssSelector(B2WUIMap.b2w_setup_createproductionaccount);
	}
	public static By getNewOverheadAccountButton() {
		return By.cssSelector(B2WUIMap.b2w_setup_createoverheadaccount);
	}
	public static By getAccountDescription() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_account_description);
	}
	public static By getAccountID() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_account_ID);
	}
	public static By getTimeMaterialsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_timematerialsonly);
	}
	public static By getInactiveCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_inactive);
	}
	public static By getAppliesToEmployeesCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_applies_to_employees);
	}
	public static By getAppliesToEquipmentCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_applies_to_equipment);
	}
	public static By getAppliesToMaterialCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_applies_to_material);
	}
	public static By getAppliesToMisc() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_applies_to_misc);
	}
	public static By getAppliesToTruckingCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_applies_to_trucking);
	}
	public static By getAppliesToSubContractorsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_applies_to_subcontractors);
	}
	public static By getUnitOfMeasureDropDown() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_unit_of_measure);
	}
	public static By getGeneralInformationNotes() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_notes);
	}
	public static By getBusinessUnitDropDown() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_businessunit);
	}	
	public static By getProductionAccountDescription() {
		return By.cssSelector(B2WUIMap.b2w_setup_productionaccountdescription);
	}
	public static By getProductionAccountID() {
		return By.cssSelector(B2WUIMap.b2w_setup_productionaccountid);
	}	
	public static By getOverheadAccountDescription() {
		return By.cssSelector(B2WUIMap.b2w_setup_overheadaccountdescription);
	}
	public static By getOverheadAccountID() {
		return By.cssSelector(B2WUIMap.b2w_setup_overheadaccountid);
	}
	public static By getPageTitleHeader() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfopagetitlepanel);
	}
	public static By getAccountSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_setup_accountsearchbutton);
	}	
	public static By getAccountValueType() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfovaluetype);
	}
	public static By getAccountCostCalType() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfocostcalctype);
	}
	public static By getAccountPerUnitPercent() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfoperunitpercent);
	}
	public static By getAccountDefaultValue() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfodefaultvalue);
	}
	public static By getAccountAlterID(){
		return By.cssSelector(B2WUIMap.b2w_accountgeninfoalternateid);
	}
	public static By getTempMaterialCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfotempmaterialcheckbox);
	}
	public static By getTrackableMaterialCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfotrackablematerialcheckbox);
	}
	public static By getCreateNewMaterialsButton() {
		return By.cssSelector(B2WUIMap.b2w_setup_createnewmaterial);
	}
	public static By getTotalCount() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfototalcount);
	}
}
