package tasks.dialogs;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddEvent extends B2WKendoDialog {
	
	public boolean selectEventType(String sText){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		TaskUtils.sleep(1000);
		if (openDropDownMenu(window,"Event Type")){
			TaskUtils.sleep(500);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean setEventStartDate(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Start Date", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, s);
			
		}
		return bReturn;
	}
	public boolean setEventEndDate(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("End Date", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, s);
			
		}
		return bReturn;
	}
	
	public boolean setEventDescription(String s){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			bReturn = setTextArea(window, "Description", s);
		}
		return bReturn;
	}
	public boolean clickSaveEvent() {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement button = WebElementUtils.getChildElement(window, B2WMaintain.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			WebElementUtils.waitForElementInvisible(button);
		}
		return bReturn;
	}
	
}
