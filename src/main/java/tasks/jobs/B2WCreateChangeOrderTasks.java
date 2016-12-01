package tasks.jobs;

import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;

public class B2WCreateChangeOrderTasks {

	public boolean setChangeOrdersID(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChangeOrdersID());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setChangeOrdersAlternateID(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChaneOrdersAlternateID());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setChangeOrdersDescription(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChangeOrdersDescription());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setChangeOrdersEstimatedQuantity(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChangeOrderEstimatedQuantity());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	
	

	
	
	
	public boolean setChangeOrdersType(String sText){
		WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WChangeOrdersType());
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WChangeOrdersType()).equals(sText);
	}
	
	public boolean setChangeOrdersStatus(String sText){
		WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WChangeOrdersStatus());
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WChangeOrdersStatus()).equals(sText);
	}
	
	public boolean setChangeOrdersUnitOfMeasure(String sText){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WChangeOrderUnitOfMeasure(), sText);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WChangeOrderUnitOfMeasure()).equals(sText);
	}
	



}
