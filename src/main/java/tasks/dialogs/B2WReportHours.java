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
		WebElement window = getDisplayedWindow();
		if (window != null){
			openDropDownMenu(window, "Employee");
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public String selectRandomEmployee(){
		String sText = "";
		WebElement window = getDisplayedWindow();
		if (window != null){
			openDropDownMenu(window, "Employee");
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public String selectRandomEmployeeLaborType() {
		String sText = "";
		WebElement window = getDisplayedWindow();
		if (window != null){
			openDropDownMenu(window, "Labor Type");
			TaskUtils.sleep(500);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public String getEmployeeLaborType() {
		String sText = "";
		WebElement el = getFormElement("Labor Type", B2WMaintain.getKendoDropDown());
		if (el != null){
			sText = el.getText();
		}
		return sText;

	}
	
	public boolean setDate(String sText){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement parent = WebElementUtils.getParentElement(WebElementUtils.getChildElementContainsText(window, By.tagName("label"), "Date"));
			WebElement input = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(input);
			bReturn = WebElementUtils.sendKeys(input, sText);
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
		WebElement window = getDisplayedWindow();
		if (window != null){
			openDropDownMenu(window, "Equipment Rate Class");
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectEquipmentUsed(String sText){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			enterDropDownMenu(window, "Equipment Used", sText);
			selectItemFromDropDown(0);
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
			TaskUtils.sleep(500);
			selectRandomItemFromDropDown();
			bReturn &= waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
			TaskUtils.sleep(500);
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
		WebElement window = getDisplayedWindow();
		if (window != null){
			bReturn = setText(window, "Description", sText);
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
		WebElement window = getDisplayedWindow();
		if (window != null){
			openDropDownMenu(window, "Labor Type");
			TaskUtils.sleep(500);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setEmployeeRegularHours(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);
		if (el == null){
			el = getDisplayedWindow();
		}
		WebElement dd = WebElementUtils.getChildElement(el,B2WMaintain.getKendoNumericTextBox());
		if (dd != null){
			List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}
		return bReturn;
	}
	public boolean setEmployeeRegularMins(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);
		if (el == null){
			el = getDisplayedWindow();
		}
		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(1),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	public boolean setEmployeeOvertimeHours(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);
		if (el == null){
			el = getDisplayedWindow();
		}
		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(2),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	public boolean setEmployeeOvertimeMins(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sChargeTypeSelected);
		if (el == null){
			el = getDisplayedWindow();
		}
		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(3),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
}
