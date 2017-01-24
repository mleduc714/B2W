package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddToInventory extends B2WKendoDialog {
	

	
	public boolean selectPart(String sPart){
		boolean bReturn = false;
		WebElement part = getFormElement("Part", B2WMaintain.getKendoDropDown());
		if (part != null){
			WebElementUtils.sendKeys(part, sPart);
			bReturn = selectItemFromDropDown(0);
		}
		return bReturn;
		
	}
	public boolean selectLocation(String sLocation){

		boolean bReturn = false;
		WebElement part = getFormElement("Location", B2WMaintain.getKendoDropDown());
		if (part != null){
			bReturn = WebElementUtils.clickElement(part);
			
			bReturn &= selectItemFromDropDown(sLocation);
		}
		return bReturn;
		
	}
	
	public boolean selectTypeOfUpdateAdjustInventory() {

		boolean bReturn = false;
		WebElement part = getFormElement("Type of Update", B2WMaintain.getKendoDropDown());
		if (part != null){
			bReturn = WebElementUtils.clickElement(part);
			
			bReturn &= selectItemFromDropDown("Adjust Inventory");
		}
		return bReturn;
		
	}
	
	public boolean setNewQuantity(String s){
		return setNumericField("New Quantity", s);
	}
	public boolean setQuantityToMove(String s){
		return setNumericField("Quantity To Move", s);
	}
	public boolean selectNewLocation(String s){

		boolean bReturn = false;
		WebElement part = getFormElement("New Location", B2WMaintain.getKendoDropDown());
		if (part != null){
			bReturn = WebElementUtils.clickElement(part);
			
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
		
	}
	
	public String selectNewBin(){

		String sRandomItem = "";
		WebElement part = getFormElement("Bin", B2WMaintain.getKendoDropDown());
		if (part != null){
			WebElementUtils.clickElement(part);
			sRandomItem = selectRandomItemFromDropDown();
			log.debug("Item Selected is "+sRandomItem);
		}
		return sRandomItem;
	}
	
	public boolean selectTypeOfUpdateLocation() {

		boolean bReturn = false;
		WebElement part = getFormElement("Type of Update", B2WMaintain.getKendoDropDown());
		if (part != null){
			bReturn = WebElementUtils.clickElement(part);
			
			bReturn &= selectItemFromDropDown("Update Location");
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
	
	public String selectAnyBin() {

		String sRandomItem = "";
		WebElement part = getFormElement("Bin", B2WMaintain.getKendoDropDown());
		if (part != null){
			WebElementUtils.clickElement(part);
			sRandomItem = selectRandomItemFromDropDown();
			log.debug("Item Selected is "+sRandomItem);
		}
		return sRandomItem;
	}
	public boolean setQuantity(String sQuantity){
		return setNumericField("Quantity", sQuantity);
	
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
