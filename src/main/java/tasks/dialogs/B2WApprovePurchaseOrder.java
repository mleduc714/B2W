package tasks.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WApprovePurchaseOrder extends B2WKendoDialog {
	
	public boolean selectApprover(String sText){
		boolean bReturn = false;
		WebElement parent = getDisplayedWindow();
		if (parent != null){
			WebElement el = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoDropDown());
			WebElementUtils.sendKeys(el, sText);
			TaskUtils.sleep(1000);
			bReturn = selectItemFromDropDown(0);
		}
		return bReturn;
	}
	
	public boolean setNotes(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Notes", By.cssSelector("textarea.notes-edit"));
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	
	public boolean clickApproveButton() {
		return clickSave();
	}

}
