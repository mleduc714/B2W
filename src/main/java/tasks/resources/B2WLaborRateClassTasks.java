package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.setup.B2WLaborRateClasses;
import tasks.WebElementUtils;

public class B2WLaborRateClassTasks extends B2WResourceTasks {

	public boolean setLaborRateName(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WLaborRateClasses.getLaborRateName());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setLaborRateID(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WLaborRateClasses.getLaborRateID());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setLaborRateBusinessUnit(String sText){
		return selectBusinessUnit(sText);
	}
	
}
