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
	
	public static By getNewProductionAccount() {
		return By.cssSelector(B2WUIMap.b2w_setup_createproductionaccount);
	}
	
	public static By getNewOverheadAccount() {
		return By.cssSelector(B2WUIMap.b2w_setup_createoverheadaccount);
	}
	
}
