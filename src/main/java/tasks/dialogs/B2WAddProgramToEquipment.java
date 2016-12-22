package tasks.dialogs;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddProgramToEquipment extends B2WKendoDialog {

	public boolean setAddProgramText(String sText) {
		boolean bReturn = false;
		WebElement el = getDisplayedWindow();
		if (el != null){
			WebElement program = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDropDown());
			if (program != null){
				WebElementUtils.clickElement(program);
				bReturn = WebElementUtils.sendKeys(program, sText);
			}
		}
		return bReturn;
	}
	
	public boolean clickAddProgramNextButton(){
		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement el = getDisplayedWindow();
		if (el != null){
			WebElement program = WebElementUtils.getChildElement(el, B2WMaintain.getKendoButtonNext());
			bReturn = WebElementUtils.clickElement(program);
		}
		return bReturn;
	}
	
	public boolean clickSaveProgramButton() {
		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement el = getDisplayedWindow();
		if (el != null){
			WebElement program = WebElementUtils.getChildElement(el, B2WMaintain.getKendoAddSaveButton());
			bReturn = WebElementUtils.clickElement(program);
			bReturn &= WebElementUtils.waitForElementInvisible(program);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		TaskUtils.sleep(1000);
		return bReturn;
	}

	
}
