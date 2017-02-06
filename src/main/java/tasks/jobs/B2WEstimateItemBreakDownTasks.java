package tasks.jobs;

import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;
import tasks.resources.B2WResourceTasks;

public class B2WEstimateItemBreakDownTasks extends B2WResourceTasks{
	
	public boolean setCostBreakDownID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreaddownid());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	public boolean setCostID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreakdowncostid());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	
	public boolean selectTrackingAccount(String s){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WCreatenewcostbreakdowntrackaccountdd(), s);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WCreatenewcostbreakdowntrackaccountdd()).equals(s);
	}
	
	public boolean selectEstimateItem(String s){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WCreatenewcostbreakdownestimateitemdropdown(), s);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WCreatenewcostbreakdownestimateitemdropdown()).equals(s);
	}
	public boolean setDescription(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreakdowndescription());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	public boolean setEstimatedQuantity(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreakdownestquantity());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
}
