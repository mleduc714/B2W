package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WScheduleMaintenance extends B2WKendoDialog {
	public boolean scheduleMaintainancePopupSelectMechanic(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(0);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);

			if (WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "true", true,
					WebElementUtils.SHORT_TIME_OUT)) {
				bReturn = selectItemFromDropDown(sText);
			}
		}
		return bReturn;
	}
	
	public String scheduleMaintainancePopupSelectAnyMechanic() {
		String sText = "";
		WebElement el = getWebElementFromScheduleMaintenanceDialog(0);
		if (el != null) {
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}

	public boolean scheduleMaintainancePopupSelectStartDate(String startDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(1);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, startDate);
		}
		return bReturn;
	}

	public boolean scheduleMaintainancePopupSelectStartTime(String startTime) {
		boolean bReturn = false;
		
		WebElement el = getWebElementFromScheduleMaintenanceDialog(2);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(startTime);
		}
		return bReturn;
	}
	public boolean scheduleMaintainancePopupSelectEndDate(String endDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(3);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, endDate);
		}
		return bReturn;
	}

	public boolean scheduleMaintainancePopupSelectEndTime(String endTime) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(4);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(endTime);
		}
		return bReturn;

	}

	public boolean scheduleMaintainancePopupSelectWorkLocation(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
			TaskUtils.sleep(500);
			selectItemFromDropDown(0);
		}
		return bReturn;
	}
	public String scheduleMaintainancePopupSelectAnyWorkLocation(){
		String sText = "";
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElementUtils.sendKeys(el,"a");
			TaskUtils.sleep(500);
			sText = selectRandomItemFromDropDown();
			
		}
		return sText;
	}
	
	
	public boolean scheduleMaintainancePopupSelectEvent(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(6);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public String scheduleMaintainancePopupSelectAnyEvent(){
		String sText = "";
		WebElement el = getWebElementFromScheduleMaintenanceDialog(6);
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
	private WebElement getWebElementFromScheduleMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
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
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindowEquipment());
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
