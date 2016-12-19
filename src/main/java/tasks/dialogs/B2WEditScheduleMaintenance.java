package tasks.dialogs;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import appobjects.maintain.B2WMaintain;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.maintain.B2WMaintainScheduleTasks;
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
	
	public String selectAnyMechanic() {
		String sText = "";
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(0);
		if (el != null) {
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}

	public boolean selectStartDate(String startDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(1);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, startDate);
		}
		return bReturn;
	}

	public boolean selectStartTime(String startTime) {
		boolean bReturn = false;
		
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(2);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(startTime);
		}
		return bReturn;
	}
	public boolean selectEndDate(String endDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(3);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, endDate);
		}
		return bReturn;
	}

	public boolean selectEndTime(String endTime) {
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(4);
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(endTime);
		}
		return bReturn;

	}

	public boolean selectWorkLocation(String sText){
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
	public String selectAnyWorkLocation(){
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
	
	
	public boolean selectEvent(String sText){
		boolean bReturn = false;
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(6);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public String selectAnyEvent(){
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
		
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		if (el != null){
			WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitForElementInvisible(button);
		}
		return bReturn;
	}
	
	public boolean cancelScheduledMaintenance() {
		clickCancel();
		return new B2WMaintainScheduleTasks().clickConfirmYes();
	}
	
	private WebElement getWebElementFromEditScheduleMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		return list.get(i);
	}
	
	public String getWorkOrder() {
		String sWorkOrder = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerEditSchedulePopupWindow());
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
	
	public ArrayList<String> getMechanicsScheduled() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement form = WebElementUtils.getParentElement(getParentOfLabel("Mechanic"));
		WebElementUtils.getAllInfo(form);
		List<WebElement> list = WebElementUtils.getChildElements(form, By.cssSelector("li.k-button"));
		for (WebElement button: list){
			al.add(WebElementUtils.getChildElement(button, By.tagName("span")).getText());
			
		}
		return al;
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
	public String getStartDate() {
		String startDate = "";
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(1);
		WebElementUtils.clickElement(el);
		Actions a = new Actions(BrowserUtils.getDriver());
		a.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		a.perform();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		try {
			startDate = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {

		} catch (IOException e) {

		}
		return startDate;
	}

	public String getEndDate() {
		String enddate = "";
		WebElement el = getWebElementFromEditScheduleMaintenanceDialog(3);
		WebElementUtils.clickElement(el);
		Actions a = new Actions(BrowserUtils.getDriver());
		a.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		a.perform();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		try {
			enddate = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {

		} catch (IOException e) {

		}
		return enddate;
	}
}
