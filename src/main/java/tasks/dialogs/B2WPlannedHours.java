package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WPlannedHours extends B2WKendoDialog{
	
	
	public boolean setDescription(String sText){
		boolean bReturn = false;
		WebElement el = getFormElements(B2WMaintain.getB2WPlannedHours()).get(0);
		if (el != null){
			WebElement text = WebElementUtils.getChildElement(el,B2WMaintain.getKendoDescription());
			text.click();
			bReturn = WebElementUtils.sendKeys(text, sText);
		}
		return bReturn;
	}
	public boolean setLaborType(String sText){
		boolean bReturn = false;
		WebElement el = getFormElements(B2WMaintain.getB2WPlannedHours()).get(1);
		if (el != null){
			WebElement text = WebElementUtils.getChildElement(el,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(text);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setPlannedHours(String sText){

		boolean bReturn = false;
		WebElement el = getFormElements(B2WMaintain.getB2WPlannedHours()).get(2);
		WebElement dd = WebElementUtils.getChildElement(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	
	}
	
	public boolean savePlannedHours() {
		return clickSave();
	}
}
