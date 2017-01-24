package tasks.maintain;

import java.util.ArrayList;
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
	
	public boolean rejectTimeCard() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getMaintainTimeCardReject());
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
	
	public String getEmployeeRegularHoursByRow(int iRow){
		String s = "";
		ArrayList<String> al = getEmployeeHours();
		if (al.size()>iRow){
			String hrs = al.get(iRow);
			s = hrs.substring(0, hrs.indexOf("\n"));
		}
		return s;
	}
	
	public String getEmployeeOvertimeHoursByRow(int iRow){
		String s = "";
		ArrayList<String> al = getEmployeeHours();
		if (al.size()>iRow){
			String hrs = al.get(iRow);
			s = hrs.substring(hrs.indexOf("\n")+1, hrs.length());
		}
		return s;
	}
	
	
	public ArrayList<String> getEmployeeTimeCardInfo(int iColumn) {
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainEmployeeHoursGrid());
		WebElement tbody = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendotbodyTag());
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, B2WMaintain.getB2WKendotrTag());
		for (WebElement tr: rows){
			al.add(WebElementUtils.getChildElements(tr, B2WMaintain.getB2WKendotdTag()).get(iColumn).getText());
		}
		return al;
	}
	
	public ArrayList<String> getEquipmentUsedHours(int iColumn){
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainEquipmentHoursGrid());
		WebElement tbody = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendotbodyTag());
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, B2WMaintain.getB2WKendotrTag());
		for (WebElement tr: rows){
			al.add(WebElementUtils.getChildElements(tr, B2WMaintain.getB2WKendotdTag()).get(iColumn).getText());
		}
		return al;
	}
	
	public boolean clickEmployeeIconByRow(int iRow) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainEmployeeHoursGrid());
		if (el != null) {
			WebElement tbody = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendotbodyTag());
			if (tbody != null) {
				List<WebElement> rows = WebElementUtils.getChildElements(tbody, B2WMaintain.getB2WKendotrTag());
				if (rows.size() > iRow) {
					bReturn = WebElementUtils.clickElement(
							WebElementUtils.getChildElement(rows.get(iRow), B2WMaintain.getB2WKendoIcon()));
				}
			}
		}
		return bReturn;
	}

	public boolean clickEquipmentIconByRow(int iRow) {

		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainEquipmentHoursGrid());
		if (el != null) {
			WebElement tbody = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendotbodyTag());
			if (tbody != null) {
				List<WebElement> rows = WebElementUtils.getChildElements(tbody, B2WMaintain.getB2WKendotrTag());
				if (rows.size() > iRow) {
					bReturn = WebElementUtils.clickElement(
							WebElementUtils.getChildElement(rows.get(iRow), B2WMaintain.getB2WKendoIcon()));
				}
			}
		}
		return bReturn;
	}
	
	public String getEmployeeTotalHours() {
		String s = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainEmployeeHoursGrid());
		if (el != null){
			WebElement footer = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendoFooterTemplate());
			s = WebElementUtils.getChildElements(footer, B2WMaintain.getB2WKendotdTag()).get(3).getText();
		}
		return s;
	}
	public String getEquipmentTotalHours() {
		String s = "";
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainEquipmentHoursGrid());
		if (el != null){
			WebElement footer = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendoFooterTemplate());
			s = WebElementUtils.getChildElements(footer, B2WMaintain.getB2WKendotdTag()).get(3).getText();
		}
		return s;
	}
	public ArrayList<String> getEquipmentUsed() {
		return getEquipmentUsedHours(0);
	}
	
	public ArrayList<String> getEquipmentRateClass() {
		return getEquipmentUsedHours(1);
	}
	public ArrayList<String> getEquipmentChargeTo() {
		return getEquipmentUsedHours(2);
	}
	public ArrayList<String> getEquipmentHours() {
		return getEquipmentUsedHours(3);
	}
	
	public String getEquipmentRegularHoursByRow(int iRow){
		String s = "";
		ArrayList<String> al = getEquipmentHours();
		if (al.size()>iRow){
			s = al.get(iRow);
		}
		return s;
	}
	
	public boolean setComments(String sText){
		return super.setComments(sText, false);
	}
	
	public ArrayList<String> getTimeCardHistoryStatus() {
		return getTimeCardHistory(0);
	}
	public ArrayList<String> getTimeCardUpdatedBy() {
		return getTimeCardHistory(1);
	}
	public ArrayList<String> getTimeCardUpdatedOn() {
		return getTimeCardHistory(2);
	}
	public ArrayList<String> getTimeCardNotes() {
		return getTimeCardHistory(3);
	}
	
	private ArrayList<String> getTimeCardHistory(int iCol) {
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainTimeCardHistory());
		if (el != null){
			WebElement tbody = WebElementUtils.getChildElement(el, B2WMaintain.getB2WKendotbodyTag());
			List<WebElement> list = WebElementUtils.getChildElements(tbody, B2WMaintain.getB2WKendotrTag());
			for (WebElement e: list){
				al.add(WebElementUtils.getChildElements(e, B2WMaintain.getB2WKendotdTag()).get(iCol).getText());
			}
		}
		return al;
	}
	
}
