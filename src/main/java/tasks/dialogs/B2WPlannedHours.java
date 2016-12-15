package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WPlannedHours extends B2WKendoDialog{
	
	
	public boolean setDescription(String sText){
		boolean bReturn = false;
		WebElement el =  this.getFormElement("Description", B2WMaintain.getKendoDescription());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean selectLaborType(String sText){
		boolean bReturn = false;
		WebElement el =  this.getFormElement("Labor Type", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setPlannedHours(String sText){

		boolean bReturn = false;
		WebElement el =  this.getFormElement("Planned Hours", B2WMaintain.getKendoNumericTextBox());
		if (el != null){
			List<WebElement> inputs = WebElementUtils.getChildElements(el,B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		
		}
		return bReturn;
	}
	
	public boolean savePlannedHours() {
		return clickSave();
	}
}
