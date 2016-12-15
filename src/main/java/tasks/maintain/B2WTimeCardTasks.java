package tasks.maintain;

import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import appobjects.setup.B2WSchedules;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;

public class B2WTimeCardTasks extends B2WKendoTasks {

	
	public boolean clickCreateNewTimeCard() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainNewTimeCardButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainTimeCardDialog()) != null;
		}
		return bReturn;
	}
	

	
	public boolean clickAddTimeButton(){
		boolean bReturn = false;
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainTimeCardDialog());
		if (el != null){
			WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainTimeCardAddTimeButton());
			if (button != null){
				bReturn = WebElementUtils.clickElement(button);
				bReturn &= WebElementUtils.waitForElementInvisible(button);
			}
		
		}
		return bReturn;
		
	}
	
	public boolean clickSaveTimeCard() {
		boolean bReturn = false;
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainTimeCardDialog());
		if (el != null){
			WebElement button = WebElementUtils.getChildElement(el, B2WSchedules.saveBtn());
			if (button != null){
				bReturn = WebElementUtils.clickElement(button);
				bReturn &= WebElementUtils.waitForElementInvisible(button);
			}
		
		}
		return bReturn;
		
	}
	

	public boolean saveReportHours() {
		boolean bReturn = false;
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainReportHoursDialog());
		if (el != null){
			WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
			bReturn &= WebElementUtils.waitForElementInvisible(button);
		
		}
		return bReturn;
		
	}
	

	
	public boolean selectTimeCardByEmployeeName(String sName){
		return selectItemFromView(sName, 0);
	}

	public boolean clickReportEquipmentHoursButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainTimeCardDetailContent());
		if (el != null){
			List<WebElement> buttons = WebElementUtils.getChildElements(el, B2WMaintain.getKendoButtonAdd());
			bReturn = WebElementUtils.clickElement(buttons.get(1));
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainReportHoursDialog()) != null;
		}
		return bReturn;
		
	}
	
	public boolean clickReportEmployeeHoursButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainTimeCardDetailContent());
		if (el != null){
			List<WebElement> buttons = WebElementUtils.getChildElements(el, B2WMaintain.getKendoButtonAdd());
			bReturn = WebElementUtils.clickElement(buttons.get(0));
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainReportHoursDialog()) != null;
		}
		return bReturn;
		
	}
	
	public boolean submitTimeCard() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoSubmitButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			
		}
		return bReturn;
	}
	
	public boolean submitApproved() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoApproveButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public boolean selectEmployee(String sItem) {
		return selectItemFromView(sItem, 0);
	}
	
}
