package tasks.dialogs;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
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
				bReturn = selectItemFromDropDown(0);
				TaskUtils.sleep(500);
				TaskUtils.logScreenCapture();
			}
		}
		return bReturn;
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
	
	public boolean scheduleMaintainancePopupSelectEvent(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(6);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
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
	public boolean selectItemFromDropDown(int i){
		boolean bReturn = false;
		// when we click we need to find the visible list
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		log.debug("There are "+list.size() + " to find the correct drop down");
		while (iter.hasNext()) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
				WebElement item = items.get(i);
				if (item != null) {
					bReturn = WebElementUtils.clickElement(item);
				}else{
					log.debug("Could not select item #"+i);
				}
			}
		}
		return bReturn;
	}

}
