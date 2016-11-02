package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public abstract class B2WResources {


	public static By getAccountDescription() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_account_description);
	}
	public static By getAccountDescriptionLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_account_descriptionlabel);
	}
	public static By getAccountID() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_account_ID);
	}
	public static By getAccountIDLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_account_IDLabel);
	}
	public static By getTimeMaterialsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_timematerialsonly);
	}
	public static By getInactiveCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_inactive);
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
	public static By getBusinessUnitHyperLink() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfo_businessunitlink);
	}
	public static By getPageTitleHeader() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfopagetitlepanel);
	}
	public static By getAccountAlterID(){
		return By.cssSelector(B2WUIMap.b2w_accountgeninfoalternateid);
	}
	public static By getCategoryDropDown() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfocategorydropdown);
	}
	public static By getSubCategoryDropDown() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfosubcategorydropdown);
	}
	public static By getIntegrationKeyText() {
		return By.cssSelector(B2WUIMap.b2w_accountintegrationkeylabel);
	}
	public static By getInactiveTestLabel() {
		return By.cssSelector(B2WUIMap. b2w_accountinactivelabel);
	}
	public static By getUnitOfMeasureLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountunitofmeasurelabel);
	}
	public static By getTotalCost() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfototalcost);
	}
	public static By getResourcesSearchText() {
		return By.cssSelector(B2WUIMap.b2w_resourcesearchtext);
	}
	public static By getResourcesClearSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_employeeclearsearchbutton);
	}
	public static By getDescriptionList() {
		return By.cssSelector(B2WUIMap.b2w_materialsdescriptiongrid);
	}
	public static By getUnitCostLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountunitcostlabel);
	}
	public static By getNameTextLabel() {
		return By.cssSelector(B2WUIMap.b2w_resourcesnamelabel);
	}
	public static By getCategoryTextLabel() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfocategorylabel);
	}
	public static By getB2WSearchText() {
		return By.cssSelector(B2WUIMap.b2w_setup_searchtextbox);
	}
	
}
