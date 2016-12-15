package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddWarranty extends B2WKendoDialog {
	
	public boolean setWarrantyDescription(String s){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			bReturn = setText(window, "Description", s);
		}
		return bReturn;
	}
	
	public boolean selectWarrantyType(String sType){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			openDropDownMenu(window, "Warranty Type");
			bReturn = selectItemFromDropDown(sType);
		}
		return bReturn;
	}
	
	public boolean selectComponentCode(String sCode){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			openDropDownMenu(window, "Component Code");
			bReturn = selectItemFromDropDown(sCode);
		}
		return bReturn;
	}
	
	public boolean selectTypeOfDurationCalendar() {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "durationTypeList");
			WebElementUtils.clickElement(WebElementUtils
					.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown("Calendar Based");
		}
		return bReturn;
	}
	public boolean selectTypeOfDurationMeter() {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "durationTypeList");
			WebElementUtils.clickElement(WebElementUtils
					.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown("Meter Based");
		}
		return bReturn;
	}
	
	public boolean setSpan(String sText) {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "spanValue");
			List<WebElement> inputs = WebElementUtils.getChildElements(input, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}
		return bReturn;
	}
	
	private boolean setSpanType(String sText) {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "unitOfMeasureList");
			WebElementUtils.clickElement(WebElementUtils
					.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean setStarting(String sText){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "startValue");
			WebElement calinput = WebElementUtils.getChildElement(input, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(calinput);
			bReturn &= WebElementUtils.sendKeys(calinput, sText);
		}
		return bReturn;
	}
	
	public boolean setRelatedMeter(String sText){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "meterTypeList");
			WebElementUtils.clickElement(WebElementUtils
					.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean clickCompleteButton() {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(window, B2WMaintain.getKendoCompleteButton()));
		}
		return bReturn;
	}
	
	public boolean setSpanWeeks() {
		return setSpanType("Weeks");
	}
	public boolean setSpanDays() {
		return setSpanType("Days");
	}
	public boolean setSpanMonths() {
		return setSpanType("Months");
	}
	public boolean setSpanYears() {
		return setSpanType("Years");
	}
	
	public boolean setWarrantyNotes(String sText){
		WebElement window = getDisplayedWindow();
		return setTextArea(window, "Notes", sText);
	}
	public boolean clickAddDuration(){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		WebElement el = WebElementUtils.getChildElementContainsText(window, B2WMaintain.getKendoButton(), "Add duration");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public boolean clickSaveWarranty() {
		return clickSave();
	}
}
