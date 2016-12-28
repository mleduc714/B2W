package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WNewEquipmentLog extends B2WKendoDialog {
	
	
	private static String datacontainer = "data-container-for";
	private static String equipment = "equipment";
	private static String meter = "meter";
	private static String newreading = "newReading";
	private static String newreadingdate = "newReadingDate";
	
	
	private WebElement getParentFromEquipmentLog(String container) {
		WebElement window = getDisplayedWindow();
		List<WebElement> tds = window.findElements(By.tagName("td"));
		WebElement parent = WebElementUtils.getElementWithMatchingAttribute(tds, datacontainer, container);
		return parent;
	}
	
	public boolean selectEquipment(String s) {
		boolean bReturn = false;
		WebElement parent = getParentFromEquipmentLog(equipment);
		if (parent != null) {
			WebElement el = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			WebElementUtils.sendKeys(el, s);
			bReturn = selectItemFromDropDown(0);
		}
		return bReturn;

	}
	
	public boolean clickSaveNewMeterReading(){
		boolean bReturn = false;
		WebElement save = WebElementUtils.findElement(B2WMaintain.getMaintainEquipmentLogSaveIcon());
		if (save != null){
			bReturn = WebElementUtils.clickElement(save);
		}
		return bReturn;
		
	}
	
	public boolean setNewReading(String s){
		boolean bReturn = false;
		WebElement parent = getParentFromEquipmentLog(newreading);
		WebElement el = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoNumericTextBox());
	
		if (el != null){
			List<WebElement> inputs = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), s);
		}
		return bReturn;
	}
	
	public boolean setDate(String s) {
		boolean bReturn = false;

		WebElement parent = getParentFromEquipmentLog(newreadingdate);
		if (parent != null) {
			WebElement el = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			WebElement dp = WebElementUtils
					.waitAndFindDisplayedElement(B2WMaintain.getMaintainEquipmentLogDatePicker());
			bReturn = goToDate(s, dp);
		}
		return bReturn;
	}
	
	public boolean selectMeter(String sItem) {
		boolean bReturn = false;
		WebElement parent = getParentFromEquipmentLog(meter);
		WebElement el = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sItem);
		}
		return bReturn;
	}

	public boolean clickNewEquipmentLog() {
		return clickButton("New Equipment Log");
	}
	public boolean clickNewMeterReading() {
		return clickButton("New Meter Reading");
	}
	
	public boolean saveLog() {
		boolean bReturn = false;
		WebElement el = getDisplayedWindow();
		if (el != null){
			WebElement Save = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSAVEButton());
			bReturn = WebElementUtils.clickElement(Save);
		}
		return bReturn;
	}
	public boolean clickDone(){
		return super.clickDone();
	}
	
}
