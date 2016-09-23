package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WAccounts extends B2WResources {
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
	public static By getAccountSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_setup_accountsearchbutton);
	}
	public static By getClearSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_setup_accountclearsearchbutton);
	}
	public static By getAppliesToTextLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountappliestolabel);
	}
	public static By getAccountValueTypeLable() {
		return By.cssSelector(B2WUIMap.b2w_accountinfovaluetypelabel);
	}
	public static By getAcccountInfoCostCalTypeLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountinfocostcaltypelabel);
	}
	public static By getAccountUnitCostLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountunitcostlabel);
	}
	public static By getAccountDefaultValueLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountinfodefaultvalue);
	}
	
}
