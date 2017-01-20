package tasks.maintain;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
		return selectItemFromView(sName, COLUMN.ID);
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
		return selectItemFromView(sItem, COLUMN.EMPLOYEE);
	}
	
	public ArrayList<String> getEmployeeLaborTypes() {
		return getEmployeeTimeCardInfo(0);
	}
	
	public ArrayList<String> getEmployeeLaborRateClass() {
		return getEmployeeTimeCardInfo(1);
	}
	public ArrayList<String> getEmployeeChargeTo() {
		return getEmployeeTimeCardInfo(2);
	}
	public ArrayList<String> getEmployeeHours() {
		return getEmployeeTimeCardInfo(3);
	}
	public ArrayList<String> getEmployeeTimeCardInfo(int iColumn) {
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(By.cssSelector("div#employeeHoursGrid"));
		WebElement tbody = WebElementUtils.getChildElement(el, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		for (WebElement tr: rows){
			al.add(WebElementUtils.getChildElements(tr, By.tagName("td")).get(iColumn).getText());
		}
		return al;
	}
	
	public void clickIconByRow(int iRow) {
		WebElement el = WebElementUtils.findElement(By.cssSelector("div#employeeHoursGrid"));
		WebElement tbody = WebElementUtils.getChildElement(el, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		WebElementUtils.getChildElement(rows.get(iRow), By.cssSelector("a.btn-icon")).click();
	}
	
	public String getTotalHours() {
		String s = "";
		WebElement el = WebElementUtils.findElement(By.cssSelector("div#employeeHoursGrid"));
		if (el != null){
			WebElement footer = WebElementUtils.getChildElement(el, By.className("k-footer-template"));
			s = WebElementUtils.getChildElements(footer, By.tagName("td")).get(3).getText();
		}
		return s;
		
		
	}
}
