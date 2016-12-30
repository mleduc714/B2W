package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddToInventory extends B2WKendoDialog {
	

	
	public boolean enterPart(String sPart){
		boolean bReturn = false;
		WebElement part = getFormElement("Part", B2WMaintain.getKendoDropDown());
		if (part != null){
			WebElementUtils.sendKeys(part, sPart);
			TaskUtils.sleep(1000);
			bReturn = selectItemFromDropDown(0);
		}
		return bReturn;
		
	}
	public boolean selectLocation(String sLocation){

		boolean bReturn = false;
		WebElement part = getFormElement("Location", B2WMaintain.getKendoDropDown());
		if (part != null){
			bReturn = WebElementUtils.clickElement(part);
			selectItemFromDropDown(sLocation);
			bReturn = selectItemFromDropDown(sLocation);
		}
		return bReturn;
		
	
		
		
	}
	public boolean selectBin(String sBin){

		boolean bReturn = false;
		WebElement part = getFormElement("Bin", B2WMaintain.getKendoDropDown());
		if (part != null){
			bReturn = WebElementUtils.clickElement(part);
			selectItemFromDropDown(sBin);
			bReturn = selectItemFromDropDown(sBin);
		}
		return bReturn;
	}
	
	public boolean selectAnyBin() {

		boolean bReturn = false;
		WebElement part = getFormElement("Bin", B2WMaintain.getKendoDropDown());
		if (part != null){
			bReturn = WebElementUtils.clickElement(part);
			String sRandomItem = selectRandomItemFromDropDown();
			log.debug("Item Selected is "+sRandomItem);
		}
		return bReturn;
	}
	public boolean setQuantity(String sQuantity){
		return setNumericField(getDisplayedWindow(), "Quantity", sQuantity);
	
	}
	
	public boolean checkAddToInventory() {
		boolean bReturn = false;
		WebElement el = getDisplayedWindow();
		List<WebElement> inputs = WebElementUtils.getChildElements(el, By.tagName("input"));
		WebElement checkbox = WebElementUtils.getElementWithMatchingAttribute(inputs, "type", "checkbox");
		if (checkbox != null){
			bReturn = WebElementUtils.clickElement(checkbox);
		}
		return bReturn;
	}
	
	public boolean saveAddToInventory() {
		return clickSave();
	}
	public boolean cancelAddToInventory() {
		return clickCancel();
	}
	
}
