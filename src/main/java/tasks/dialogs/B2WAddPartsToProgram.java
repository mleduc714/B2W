package tasks.dialogs;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddPartsToProgram extends B2WKendoDialog {
	
	
	public boolean selectPartToAddToProgramByDescription(String sPart){
		return selectFromDialog(sPart, 1);
		
	}
	
	public boolean selectPartToAddToWorkItemByID(String sPart){
		return selectFromDialog(sPart, 0);
	}
	
	public boolean clickAddProgramNextButton(){
		boolean bReturn = false;
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
	
	public boolean enterEstimatedQuanityForPart(String sPart, String sEstQty){
		boolean bReturn = false;
		WebElement tbody = WebElementUtils.findElement(By.tagName("tbody"));
		List<WebElement> list = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			String sText  = WebElementUtils.getChildElements(el, By.tagName("td")).get(0).getText();
			if (sText.contains(sPart)){
				WebElement textbox = WebElementUtils.getChildElement(el, B2WMaintain.getKendoNumericTextBox());
				List<WebElement> dd = WebElementUtils.getChildElements(textbox, B2WMaintain.getKendoDropDown());
				WebElementUtils.clickElement(dd.get(0));
				bReturn = WebElementUtils.sendKeys(dd.get(1), sEstQty);
				break;
			}
		}
		
		
		return bReturn;
	}

}
