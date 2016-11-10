package tasks.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddMeterToEquipment extends B2WKendoDialog {
	
	public WebElement getDropDownsFromWindow(WebElement window, int iNum) {
		List<WebElement> dds = window.findElements(KendoUI.getKendoDropDownForTMTab());
		return dds.get(iNum);
	}
	
	public WebElement getCheckboxsFromWindow(WebElement window, int iNum){
		List<WebElement> checkboxes = new ArrayList<WebElement>();
		List<WebElement> inputs = window.findElements(By.tagName("input"));
		Iterator<WebElement> iter = inputs.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			if (el.getAttribute("type").equals("checkbox")){
				checkboxes.add(el);
			}
		}
		return checkboxes.get(iNum);
	}
	
	public WebElement getNumericTextBoxesFromWindow(WebElement window, int iNum){
		List<WebElement> numerictextboxes = window.findElements(B2WEquipment.getKendoNumericTextBox());
		return numerictextboxes.get(iNum);
	}
	public boolean selectAddMeterTypeFromDD(String sText) {
		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 0);
		WebElement child = WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown());
		if (WebElementUtils.clickElement(child)){
			TaskUtils.sleep(500);
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean setAddMeterTypeDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getDisplayedWindow();
		WebElement desc = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDescription());
		if (desc != null){
			bReturn = WebElementUtils.sendKeys(desc, sText);
		}
		return bReturn;
	}

	public boolean clickSaveAddMeter() {
		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement buttoncontainer = WebElementUtils.getChildElement(window, B2WEquipment.getKendoButtonContainer());
			WebElement savebutton = buttoncontainer.findElement(B2WEquipment.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(savebutton);
			bReturn &= WebElementUtils.waitForElementInvisible(window);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean clickCancelAddMeter() {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement buttoncontainer = WebElementUtils.getChildElement(window, B2WEquipment.getKendoButtonContainer());
			WebElement savebutton = buttoncontainer.findElement(B2WEquipment.getKendoCancelButton());
			bReturn = WebElementUtils.clickElement(savebutton);
			bReturn &= WebElementUtils.waitForElementInvisible(window);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	
	public boolean selectAddMeterExcludeFromWorkOrdersUseGlobalSetting(){
		String sText = "Use global Setting";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 1);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterExcludeFromWorkOrdersAlways(){
		String sText = "Yes, always";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 1);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterExcludeFromWorkOrdersNever(){
		String sText = "No, never";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 1);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterRequiredOnWorkOrderCompletionUseGlobalSetting(){
		String sText = "Use global Setting";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 2);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterRequiredOnWorkOrderCompletionRequired(){
		String sText = "Required";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 2);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterRequiredOnWorkOrderCompletionNotRequired(){
		String sText = "Not required";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 2);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean setAddMeterIntialReading(String sReading){
		boolean bReturn = false;
		WebElement el = getNumericTextBoxesFromWindow(getDisplayedWindow(), 0);
		List<WebElement> inputs = WebElementUtils.getChildElements(el,B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sReading);

		return bReturn;
	}
	public boolean setAddMeterEnterNewReadingCheckBox(){
		boolean bReturn = false;
		bReturn = WebElementUtils.clickElement(getCheckboxsFromWindow(getDisplayedWindow(), 2));
		return bReturn;
	}
	public boolean setAddMeterEnterNewReading(String sReading){
		boolean bReturn = false;
		WebElement el = getNumericTextBoxesFromWindow(getDisplayedWindow(), 1);
		List<WebElement> inputs = WebElementUtils.getChildElements(el,B2WMaintain.getKendoDropDown());
		Coordinates coordinate = ((Locatable)inputs.get(0)).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		TaskUtils.sleep(500);
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sReading);

		return bReturn;
	}
	public boolean setAddMeterEnterNewReadingDate(String sDate){
		boolean bReturn = false;
		WebElement el = getDisplayedWindow();
		WebElement date = WebElementUtils.getChildElement(el,B2WEquipment.getKendoDateText());
		if (date != null){
			Coordinates coordinate = ((Locatable)date).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			TaskUtils.sleep(500);
			WebElement input = date.findElement(B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(input);
			bReturn = WebElementUtils.sendKeys(input,sDate);
		}
		return bReturn;
	}

}
