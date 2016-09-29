package tasks.resources;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WAddMaterials;
import appobjects.setup.B2WMaterials;
import tasks.WebElementUtils;

public class B2WAddMaterialsTasks {
	
	Logger log = Logger.getLogger(B2WAddMaterialsTasks.class);
	
	public boolean setSearchMaterialsText(String sText){
		boolean bReturn = false;
		WebElement bar = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSearchButtonBar());
		WebElement el = WebElementUtils.getChildElement(bar, B2WAddMaterials.getAddMaterialsSearchText());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(el, sText);
			String sValue = el.getAttribute("value");
			log.debug("The Value in Search Box is: "+sValue);
			bReturn &= sValue.equals(sText);
		}
		return bReturn;
	}
	
	public boolean setIDToSelect(String sText){
		boolean bReturn = false;
		WebElement bar = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSearchIDBar());
		WebElement el = WebElementUtils.getChildElement(bar, B2WAddMaterials.getAddMaterialsIDToSelect());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(el, sText);
			String sValue = el.getAttribute("value");
			log.debug("The Value to ID is: "+sValue);
			bReturn &= sValue.equals(sText);
			WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
			if (grid == null){
				bReturn = false;
				log.debug("The search did not return any results");
			}
		}
		
		return bReturn;
	}
	
	public boolean clickSelectButton() {
		
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSelectButton());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
			
		}
		return bReturn;
	}

	public boolean clickAddButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getAddButton());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
		}else{
			log.debug("Add Button is null");
		}
		
		return bReturn;
	}
	
	public boolean clickCancelButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCancelButton());
		if (el!=null){
			el.click();
		}else{
			log.debug("Cancel Button is null");
		}
		
		return bReturn;
	}
	
	public boolean isChecked() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
		if (el != null){
			WebElement checkbox = WebElementUtils.getChildElement(el, B2WAddMaterials.getAddMaterialsCheckBox());
			bReturn = checkbox.isDisplayed();
			
		}
		return bReturn;
		
	}
	
	public boolean test() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSearchButtonBar());
		WebElementUtils.sendKeys(el, "WOOODDS");
		return false;
		
	}
	
}
