package tasks.maintain;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import tasks.WebElementUtils;

public class B2WMaintainProgramsTasks extends B2WMaintainTasks {

	private final String BUSINESSUNIT = "Business Unit";
	private final String LABORRATES = "Labor Rate Class";
	private final String ADDITEM = "Add Item";

	//private final String SCHEDULEOCCURANCES = "Schedule the subsequent occurrences";
	
	public boolean createNewMaintenanceProgram() {
		boolean bReturn = false;
		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getKendoButton());
		if (els.size() > 0) {
			WebElement el = WebElementUtils.getElementWithMatchingText(els, "New Maintenance Program", true);
			if (el != null) {
				bReturn = WebElementUtils.clickElement(el);
				bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoFooter(),
						WebElementUtils.MEDIUM_TIME_OUT) != null;
			}
		}
		return bReturn;
	}

	public boolean setMaintenanceProgramDescription(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Description");

		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		} else {
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}

	public boolean setBusinessUnit(String sText) {
		boolean bReturn = false;

		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainBoxContent());
		List<WebElement> items = el.findElements(By.tagName("p"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.getText().startsWith(BUSINESSUNIT)) {
				item.click();
				bReturn = selectItemFromDropDown(sText);
				break;
			}
		}
		return bReturn;
	}

	public boolean selectLaborRateClass(String sText) {
		boolean bReturn = false;

		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainBoxContent());
		List<WebElement> items = el.findElements(By.tagName("p"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.getText().startsWith(LABORRATES)) {
				WebElementUtils.clickElement(WebElementUtils.getChildElement(item,B2WMaintain.getKendoDropDownForTMTab()));
				bReturn = selectItemFromDropDown(sText);
				break;
			}
		}
		return bReturn;
	}

	public boolean clickAddItem() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainButtonsContainer());
		List<WebElement> items = el.findElements(By.tagName("a"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement button = iter.next();
			if (button.getText().startsWith(ADDITEM)) {
				bReturn = WebElementUtils.clickElement(button);
				WebElementUtils.switchToFrame(B2WMaintain.getB2WMaintainAddItemDialog(),
						WebElementUtils.SHORT_TIME_OUT);

			}
		}
		return bReturn;
	}


	
	public boolean clickAddInterval() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddIntervalButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(B2WMaintain.getB2WMaintainAddIntervalButton());
			WebElementUtils.switchToFrame(B2WMaintain.getKendoWindow(), WebElementUtils.SHORT_TIME_OUT);
		}

		return bReturn;
	}

	public boolean saveMaintenanceProgram() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WEquipment.getKendoFooter());
		if (el != null) {
			WebElement button = WebElementUtils.getChildElement(el, B2WEquipment.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			bReturn = WebElementUtils.waitForElementInvisible(WebElementUtils.findElement(B2WMaintain.getKendoFakeSaveButton()));
			WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoButton());
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			
		}
		return bReturn;
	}
	
	public boolean selectMaintenanceProgram(String sItem) {
		return selectItemFromView(sItem, 1);
	}
	public boolean selectMaintenanceProgram(int i) {
		return selectItemFromView(i);
	}
	
	public boolean clickAddEquipment() {
		boolean bReturn = false;
		List<WebElement> el = WebElementUtils.findElements(B2WMaintain.getKendoButtonAdd());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el.get(1));
		}
		return bReturn;
	}
	
	public boolean expandEquipmentByID(String sID) {
		boolean bReturn = false;
		List<WebElement> masterRows = WebElementUtils.findElements(B2WMaintain.getKendoMasterRow());
		for (WebElement el: masterRows){
			String sText = WebElementUtils.getChildElements(el, By.tagName("td")).get(1).getText();
			if (sText.equals(sID)){
				WebElement icon = WebElementUtils.findElement(B2WMaintain.getKendoIconPlus());
				if (icon != null){
					bReturn = WebElementUtils.clickElement(icon);
				}
			}
		}
		return bReturn;
		
	}
	
	
	public boolean generateItems() {
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.waitAndFindDisplayedElements(By.linkText("Generate Item"));
		for (WebElement el: list){
			if (el.isDisplayed()){
				WebElementUtils.clickElement(el);
				bReturn = clickConfirmYes();
				break;
			}
		}
		return bReturn;
	}
	
	
}
