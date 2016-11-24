package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WEditScheduleMaintenance extends B2WKendoDialog {
	public boolean editScheduleMaintainancePopupSelectMechanic(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(0);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);

			if (WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "true", true,
					WebElementUtils.SHORT_TIME_OUT)) {
				bReturn = selectItemFromDropDown(sText);
			}
		}
		return bReturn;
	}
	
	public String editScheduleMaintainancePopupSelectAnyMechanic() {
		String sText = "";
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(0);
		if (el != null) {
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}

	public boolean editScheduleMaintainancePopupSelectStartDate(String startDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(1);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, startDate);
		}
		return bReturn;
	}

	public boolean editScheduleMaintainancePopupSelectStartTime(String startTime) {
		boolean bReturn = false;
		
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(2);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(startTime);
		}
		return bReturn;
	}
	public boolean editScheduleMaintainancePopupSelectEndDate(String endDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(3);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, endDate);
		}
		return bReturn;
	}

	public boolean editScheduleMaintainancePopupSelectEndTime(String endTime) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(4);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(endTime);
		}
		return bReturn;

	}

	public boolean editScheduleMaintainancePopupSelectWorkLocation(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(5);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
			TaskUtils.sleep(500);
			selectItemFromDropDown(0);
		}
		return bReturn;
	}
	public String editScheduleMaintainancePopupSelectAnyWorkLocation(){
		String sText = "";
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(5);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElementUtils.sendKeys(el,"a");
			TaskUtils.sleep(500);
			sText = selectRandomItemFromDropDown();
			
		}
		return sText;
	}
	
	
	public boolean editScheduleMaintainancePopupSelectEvent(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(6);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public String editScheduleMaintainancePopupSelectAnyEvent(){
		String sText = "";
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(6);
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public boolean saveScheduleMaintenance() {
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		if (el != null){
			WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitForElementInvisible(button);
		}
		return bReturn;
	}
	private WebElement getWebElementFromEditScheduleMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	public String getWorkOrder() {
		String sWorkOrder = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindowWorkOrder());
		if (el != null){
			sWorkOrder = el.getText();
		}
		return sWorkOrder;
		
	}
	
	public String getWorkOrderDescription() {
		String sText = getWorkOrder();
		return sText.substring(0, sText.indexOf("[")).trim();
	}
	
	public String getWorkOrderID() {
		String sText = getWorkOrder();
		return sText.substring(sText.indexOf("[")+1, sText.indexOf("]"));
	}
	
	
	public String getEquipment() {
		String sEquipment = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		if (el != null){
			sEquipment = el.getText();
		}
		return sEquipment;
	}
	
	public String getEquipmentID(){
		String sText = getEquipment();
		return sText.substring(0, sText.indexOf("[")).trim();
	}
	public String getEquipmentDescription() {
		String sText = getEquipment();
		return sText.substring(sText.indexOf("[")+1, sText.indexOf("]"));
	}
}
