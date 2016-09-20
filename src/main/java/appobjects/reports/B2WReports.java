package appobjects.reports;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WReports {
	
	public static By getReportsPage() {
		return By.cssSelector(B2WUIMap.b2w_reportspage);
	}
	public static By getBusinessUnitsPage() {
		return By.cssSelector(B2WUIMap.b2w_pagecontentlistinggridview);
	}
	

}
