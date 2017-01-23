package tasks.maintain;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import tasks.WebElementUtils;

public class B2WMaintainProgramsTasks extends B2WMaintainTasks {

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
		WebElement el = getFormElement("Description", B2WMaintain.getKendoInputTextBox());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean selectBusinessUnit(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Business Unit", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean selectLaborRateClass(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Labor Rate Class", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean clickAddItem() {
		boolean bReturn = false;
		WebElement el = getButton("Add Item");
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;}


	
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
		return selectItemFromView(sItem, COLUMN.DESCRIPTION);
	}
	public boolean selectMaintenanceProgram(int i) {
		return selectItemFromView(i);
	}
	
	public boolean clickAddEquipment() {
		boolean bReturn = false;
		List<WebElement> el = WebElementUtils.findElements(B2WMaintain.getKendoButtonAdd());
		if (el.size() > 1 ){
			bReturn = WebElementUtils.clickElement(el.get(1));
			
		}
		return bReturn;
	}
	
	public boolean expandEquipmentByID(String sID) {
		boolean bReturn = false;
		List<WebElement> masterRows = WebElementUtils.findElements(B2WMaintain.getKendoMasterRow());
		int i = 0;
		for (WebElement el: masterRows){
			
			String sText = WebElementUtils.getChildElements(el, By.tagName("td")).get(1).getText();
			if (sText.equals(sID)){
				List<WebElement> icon = WebElementUtils.findElements(B2WMaintain.getKendoIconPlus());
				if (icon != null){
					bReturn = WebElementUtils.clickElement(icon.get(i));
					waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
				}
			
			}
			i++;
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
	
	public boolean clickAddParts() {
		boolean bReturn = false;
		WebElement el = getButton("Add Parts");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean clickAddHours() {
		boolean bReturn = false;
		WebElement el = getButton("Add Hours");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean excludeJanuary() {
		return excludeMonth("January");
		
	}
	public boolean excludeFebruary() {
		return excludeMonth("February");
		
	}
	public boolean excludeMarch() {
		return excludeMonth("March");
		
	}
	public boolean excludeApril() {
		return excludeMonth("April");
		
	}
	public boolean excludeMay() {
		return excludeMonth("May");
		
	}
	public boolean excludeJune() {
		return excludeMonth("June");
		
	}
	public boolean excludeJuly() {
		return excludeMonth("July");
		
	}
	public boolean excludeAugust() {
		return excludeMonth("August");
		
	}
	public boolean excludeSeptember() {
		return excludeMonth("September");
		
	}
	public boolean excludeOctober() {
		return excludeMonth("October");
		
	}
	public boolean excludeNovemeber() {
		return excludeMonth("November");
		
	}
	public boolean excludeDecemeber() {
		return excludeMonth("December");
		
	}
	private boolean excludeMonth(String sMonth){
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(By.tagName("input"));
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(list, "name", sMonth);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= el.isSelected();
		}
		return bReturn;
		
	}
	
	public ArrayList<String> getItemsFromProgram() {
		return getItems();
	}
	
	public boolean setMaintainanceProgramNotes(String sText) {
		return super.setNotes(sText);
	}
	
	public boolean selectItemOnMaintenanceProgram(String s) {
		return selectItem(s);
	}
	
	public String getValueOfItem(String sItem) {
		return getValueOfItem(sItem, B2WMaintain.getMaintainProgramDetailView());
	}
	public String getProgramHeadline() {
		return WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getEquipmentHeadline()).getText();
	}
	
}
