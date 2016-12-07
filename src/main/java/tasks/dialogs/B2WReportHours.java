package tasks.dialogs;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WReportHours extends B2WKendoDialog {
	
	private final String sEquipmentHoursBind = "visible: isEquipmentHoursTypeSelected";
	private final String sEmployeeHoursBind = "visible: isEmployeeHoursTypeSelected";
	private final String sReportHours = "visible: isNewHours";
	private final String sChargeTypeJob = "visible: isChargeTypeJob";
	private final String sChargeTypeAccount = "visible: isChargeTypeAccount";
	private final String sChargeTypeEquipment = "visible: isChargeTypeEquipment";
	private final String sChargeTypeSelected = "visible: isChargeTypeSelected";

	
	private WebElement getWebElementFromTimeCardsDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainTimeCardDialog());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);

	}

	private WebElement getWebElementFromReportHoursEquipmentDialog(int i) {
		WebElement el = getReportEquipmentHoursDialog(sReportHours);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	private WebElement getWebElementFromReportHoursEmployeeDialog(int i) {
		WebElement el = getReportEquipmentHoursDialog(sEmployeeHoursBind);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	private WebElement getWebElementFromJobChargedDialog(int i){
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeJob);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	private WebElement getWebElementFromEquipmentChargedDialog(int i){
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeEquipment);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	private WebElement getWebElementFromReportHoursByEquipment(int i){
		WebElement el = getReportEquipmentHoursDialog(sEquipmentHoursBind);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	private WebElement getWebElementFromIsChargedTypeSelected(int i){
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	private WebElement getWebElementFromisChargeTypeAccount(int i){	
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeAccount);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	private WebElement getWebElementTextFieldFromIsChargedTypeSelected(int i){
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDescription());
		return list.get(i);
	}
	
	public WebElement getReportEquipmentHoursDialog(String sBind) {


		WebElement item = null;
		WebElement dialog = WebElementUtils.findElement(B2WMaintain.getB2WMaintainReportHoursDialog());
		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName("div"));
		Iterator<WebElement> iterB = items.iterator();
		while (iterB.hasNext()){
			WebElement el = iterB.next();
			String sData = el.getAttribute("data-bind");
			if (sData == null){
				continue;
			}else if (sData.equals(sBind)){
				item = el;
				break;
			}
		}
		return item;
	
	}
	
	
	public boolean selectEmployee(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromTimeCardsDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	
	public String selectRandomEmployee(){
		String sText = "";
		WebElement el = getWebElementFromTimeCardsDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public boolean setDate(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromTimeCardsDialog(1);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	
	}
	
	public boolean selectTypeofHoursEmployee(){
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursEquipmentDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Employee Hours");
		}
		return bReturn;
	}
	
	public boolean selectTypeofHoursEquipment() {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursEquipmentDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Equipment Hours");
		}
		return bReturn;
	}
	
	public boolean selectChargeToOverheadAccount(){
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursEmployeeDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Overhead Account");
		}
		return bReturn;
	}
	
	public boolean selectChargeToJob() {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursEmployeeDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Job");
		}
		return bReturn;
	}
	public boolean selectChargeToEquipment() {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursEmployeeDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Equipment");
		}
		return bReturn;
	}
	
	public boolean setEquipmentHoursDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sEquipmentHoursBind);
		if (el != null){
			WebElement description = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDescription());
			bReturn = WebElementUtils.sendKeys(description, sText);
		}
		return bReturn;
	}
	
	public boolean setEquipmentUsed(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursByEquipment(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean selectEquipmentWorkOrder(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursByEquipment(1);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean selectEquipmentWorkOrderItem(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursByEquipment(2);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean selectEquipmentRateClass(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursByEquipment(3);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setEquipmentRegularHours(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sEquipmentHoursBind);

		WebElement dd = WebElementUtils.getChildElement(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	public boolean setEquipmentRegularMins(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sEquipmentHoursBind);

		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(1),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	
	public boolean setJob(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromJobChargedDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
			TaskUtils.sleep(1000);
			selectItemFromDropDown(0);
		}
		return bReturn;
	}
	
	public boolean selectAnyJob(){
		boolean bReturn = false;
		WebElement el = getWebElementFromJobChargedDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, "a");
			TaskUtils.sleep(1000);
			selectRandomItemFromDropDown();
			waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
			bReturn = true;
		}
		return bReturn;
	}
	
	public boolean setEmployeeEquipment(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromEquipmentChargedDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
			TaskUtils.sleep(1000);
			selectItemFromDropDown(0);
		}
		return bReturn;
	}
	public boolean selectEmployeeWorkOrder(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromEquipmentChargedDialog(1);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean selectEmployeeWorkOrderItem(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromEquipmentChargedDialog(2);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectOverheadAccount(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromisChargeTypeAccount(0);
		if (el != null){
			WebElementUtils.clickElement(el);

			selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean saveReportedHours() {
		return clickSave();
	}
	
	public boolean selectEmployeeHoursJobTrackingAccount(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromJobChargedDialog(1);
		if (el != null){
			WebElementUtils.clickElement(el);
			selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean setEmployeeWorkHoursDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementTextFieldFromIsChargedTypeSelected(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean selectEmployeeLaborRateClass(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromIsChargedTypeSelected(6);
		if (el != null){
			WebElementUtils.clickElement(el);
			selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean selectEmployeeLaborType(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromIsChargedTypeSelected(7);
		if (el != null){
			WebElementUtils.clickElement(el);
			selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setEmployeeRegularHours(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);

		WebElement dd = WebElementUtils.getChildElement(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	public boolean setEmployeeRegularMins(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);

		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(1),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	public boolean setEmployeeOvertimeHours(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);

		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(2),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	public boolean setEmployeeOvertimeMins(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);

		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(3),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
}
