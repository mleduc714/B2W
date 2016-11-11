package tasks.maintain;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;

public class B2WWorkOrdersTasks extends B2WKendoTasks {
	
	public int iEquipment = 0;
	public int iRequestDesc = 1;
	public int iAltID = 2;
	public int iDueDate = 3;
	public int iPriority = 4;
	public int iPlannedWorkLocation= 5;
	public int iLaborRateClass = 6;
	

	Logger log = Logger.getLogger(B2WWorkOrdersTasks.class);
	
	
	private static List<WebElement> pageElement = new ArrayList<WebElement>();


	public boolean clickCreateNewWorkOrderButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoButtonAdd());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainNewWorkOrderView()) != null;
			if (bReturn){
				pageElement = getFormElements(B2WMaintain.getB2WMaintainNewWorkOrderView());
			}
		}
		return bReturn;
	}
	


	public boolean selectEquipment(String sText) {
		boolean bReturn = false;
		TaskUtils.sleep(1000);
		WebElement equipment = pageElement.get(iEquipment);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment, B2WMaintain.getKendoDropDown());
			if (el != null){
				sendTextAndSelectValueFromKendoFDD(el, sText);
				bReturn = true;
			}
		}
		
		return bReturn;
		
	}
	
	public boolean editWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoEditButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean clickComplete() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoCompleteButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean completeWorkOrder() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoEditButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean setWorkOrderDescription(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iRequestDesc);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDescription());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setAlternativeID(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iAltID);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDescription());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	
	public boolean setDueDate(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iDueDate);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	
	public boolean selectLaborRateClassFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iLaborRateClass);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectPlannedLocationDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iPlannedWorkLocation);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectPriorityFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iPriority);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	
	public boolean clickSaveButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoLargeSaveButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(WebElementUtils.findElement(B2WMaintain.getKendoFakeSaveButton()));
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions(), WebElementUtils.MEDIUM_TIME_OUT) != null;
		}
		return bReturn;
	}
	


	
	public boolean clickCreateAddItemButton() {
		boolean bReturn = false;
		WebElement button = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddItemCreateButton());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitForElementInvisible(button);
		}
		return bReturn;
	}
	
	public boolean clickApproveButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainWorkOrderDetailView());
		if (el != null){
			WebElement approve = WebElementUtils.getChildElement(el, B2WMaintain.getKendoApproveButton());
			bReturn = WebElementUtils.clickElement(approve);
		}
		return bReturn;
	}
	
	public boolean selectWorkOrderByID(String sText){
		return selectItemFromView(sText, 0);
	}

	public boolean selectWorkOrderByDescription(String sText) {
		return selectItemFromView(sText, 1);
	}

	public void getItems() {
	
		
	}
	public boolean collapseDetails() {
		return getHeaderandExpandOrCollapse("Details", false);
	}
	public boolean expandParts() {
		return getHeaderandExpandOrCollapse("Details", true);
	}
	public boolean collapseParts() {
		return getHeaderandExpandOrCollapse("Details", false);
	}
	public boolean expandHours() {
		return getHeaderandExpandOrCollapse("Hours", true);
	}
	public boolean clickAddPlannedHours() {
		WebElement el = getButton(6);
		return WebElementUtils.clickElement(el);
	
	}
	public boolean clickAddReportedHours() {
		WebElement el = getButton(7);
		return WebElementUtils.clickElement(el);
	
	}
	public boolean clickAddParts() {
		boolean bReturn = false;
		WebElement el = getButton(8);
		bReturn = WebElementUtils.clickElement(el);
		bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		return bReturn;
	}
	
}
