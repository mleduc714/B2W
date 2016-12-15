package tasks.dialogs;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import appobjects.maintain.B2WMaintain;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WScheduleMaintenance extends B2WKendoDialog {
	public boolean selectMechanic(String sText) {
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

	public String selectAnyMechanic() {
		String sText = "";
		WebElement el = getWebElementFromScheduleMaintenanceDialog(0);
		if (el != null) {
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}

	public boolean selectStartDate(String startDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(1);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, startDate);
		}
		return bReturn;
	}

	public boolean selectStartTime(String startTime) {
		boolean bReturn = false;

		WebElement el = getWebElementFromScheduleMaintenanceDialog(2);
		if (el != null) {
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(startTime);
		}
		return bReturn;
	}

	public boolean selectEndDate(String endDate) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(3);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.sendKeys(el, endDate);
		}
		return bReturn;
	}

	public boolean selectEndTime(String endTime) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(4);
		if (el != null) {
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(endTime);
		}
		return bReturn;

	}

	public boolean selectWorkLocation(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		if (el != null) {
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
			TaskUtils.sleep(500);
			selectItemFromDropDown(0);
		}
		return bReturn;
	}

	public String selectAnyWorkLocation() {
		String sText = "";
		WebElement el = getWebElementFromScheduleMaintenanceDialog(5);
		if (el != null) {
			WebElementUtils.clickElement(el);
			WebElementUtils.sendKeys(el, "a");
			TaskUtils.sleep(500);
			sText = selectRandomItemFromDropDown();

		}
		return sText;
	}

	public boolean selectEvent(String sText) {
		boolean bReturn = false;
		WebElement el = getWebElementFromScheduleMaintenanceDialog(6);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public String selectAnyEvent() {
		String sText = "";
		WebElement el = getWebElementFromScheduleMaintenanceDialog(6);
		if (el != null) {
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}

	public boolean saveScheduledMaintenance() {
		boolean bReturn = false;

		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		if (el != null) {
			WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitForElementInvisible(button);
		}
		return bReturn;
	}

	private WebElement getWebElementFromScheduleMaintenanceDialog(int i) {
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		if (el != null) {
			List<WebElement> list = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
			return list.get(i);
		} else {
			return null;
		}
	}

	public String getWorkOrder() {
		String sWorkOrder = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(
				B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindowWorkOrder());
		if (el != null) {
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
		return sText.substring(sText.indexOf("[") + 1, sText.indexOf("]"));
	}

	public String getEquipment() {
		String sEquipment = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(
				B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindowEquipment());
		if (el != null) {
			sEquipment = el.getText();
		}
		return sEquipment;
	}

	public String getEquipmentID() {
		String sText = getEquipment();
		return sText.substring(0, sText.indexOf("[")).trim();
	}

	public String getEquipmentDescription() {
		String sText = getEquipment();
		return sText.substring(sText.indexOf("[") + 1, sText.indexOf("]"));
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

	public String getStartDate() {
		String startDate = "";
		WebElement el = getWebElementFromScheduleMaintenanceDialog(1);
		el.click();
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
		WebElement el = getWebElementFromScheduleMaintenanceDialog(3);
		el.click();
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

	public Hashtable<String,String> getWorkOrderItems() {
		Hashtable<String,String> al = new Hashtable<String,String>();
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("input"));
		List<WebElement> checkboxes = WebElementUtils.getElementsWithMatchingAttribute(list, "type", "checkbox");
		for (WebElement items : checkboxes) {
			String label = WebElementUtils.getParentElement(items).getText();
			int iNextLine = label.indexOf("\n");
			String sWorkItem = label.substring(0, iNextLine);
			String sHours = label.substring(++iNextLine, label.length());
			System.out.println(sHours);
			al.put(sWorkItem, sHours);
		}

		return al;
	}
	
	public boolean uncheckWorkItem(String sWorkItem){
		boolean bReturn = false;
		WebElement el = WebElementUtils
				.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSchedulerScheduleMaintenancePopupWindow());
		List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("input"));
		List<WebElement> checkboxes = WebElementUtils.getElementsWithMatchingAttribute(list, "type", "checkbox");
		for (WebElement items : checkboxes) {
			String label = WebElementUtils.getParentElement(items).getText();
			if (label.contains(sWorkItem)){
				if (items.isSelected()){
					items.click();
					bReturn = true;
					break;
				}
			}
		}
		return bReturn;
	}
}
