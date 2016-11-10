package tasks.dialogs;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WReportHours extends B2WKendoDialog {
	
	private final String sEquipmentHoursBind = "visible: isEquipmentHoursTypeSelected";
	private final String sReportHours = "visible: isNewHours";
	
	private WebElement getWebElementFromTimeCardsDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainTimeCardDialog());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);

	}

	private WebElement getWebElementFromReportHoursDialog(int i) {
		WebElement el = getReportEquipmentHoursDialog(sReportHours);
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	private WebElement getWebElementFromReportHoursByEquipment(int i){
		WebElement el = getReportEquipmentHoursDialog(sEquipmentHoursBind);
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
		WebElement el = getWebElementFromTimeCardsDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
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
		WebElement el = getWebElementFromReportHoursDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Employee Hours");
		}
		return bReturn;
	}
	
	public boolean selectTypeofHoursEquipment() {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursDialog(0);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Equipment Hours");
		}
		return bReturn;
	}
	
	public boolean selectChargeToOverheadAccount(){
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursDialog(1);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Overhead Account");
		}
		return bReturn;
	}
	
	public boolean selectChargeToJob() {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursDialog(1);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown("Job");
		}
		return bReturn;
	}
	public boolean selectChargeToEquipment() {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursDialog(1);
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

	public boolean selectWorkOrder(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromReportHoursByEquipment(1);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean selectWorkOrderItem(String sText) {
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
	public boolean setRegularHours(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sEquipmentHoursBind);

		WebElement dd = WebElementUtils.getChildElement(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	public boolean setRegularMins(String sText){
		boolean bReturn = false;
		WebElement el = getReportEquipmentHoursDialog(sEquipmentHoursBind);

		List<WebElement> dd = WebElementUtils.getChildElements(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(1),B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	
	public boolean saveReportedHours() {
		return clickSave();
	}

	
	
}
