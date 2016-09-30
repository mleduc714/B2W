package tasks.resources;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WEquipment;
import tasks.WebElementUtils;

public class B2WEquipmentTasks extends B2WResourceTasks {
	
	Logger log = Logger.getLogger(B2WEquipment.class);

	public boolean createNewEquipment() {
		boolean bReturn = false;
		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getNewEquipmentButton());
		if (els.size() > 0) {
			WebElement el = WebElementUtils.getElementWithMatchingText(els, "New Equipment", true);
			if (el != null) {
				bReturn = WebElementUtils.clickElement(el);

			}
		}
		return bReturn;
	}

	public boolean setEquipmentDescription(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getEquipmentDescription());
		WebElement el = WebElementUtils.getElementWithWithMatchingAttribute(els, "name", "Description");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	public boolean setEquipmentID(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getEquipmentDescription());
		WebElement el = WebElementUtils.getElementWithWithMatchingAttribute(els, "name", "EquipmentID");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to set text to");
		}

		return bReturn;
	}
	
	public boolean setEquipmentBusinessUnit(String sText){
		String sBusinessUnit = "Business Unit";
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getNewEquipmentRequiredForms());
		WebElement dd = WebElementUtils.getElementWithMatchingStartsWithText(ls, sBusinessUnit);
		if (dd != null) {
			WebElementUtils.clickElement(dd);
			List<WebElement> el = WebElementUtils.findElements(B2WEquipment.getNewEquipmentDropDownItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(el, sText, false);
			if (item != null) {
				bReturn = WebElementUtils.clickElement(item);
			}
		}else{
			log.debug("Business Unit was not found in Equipment");
		}
		return bReturn;
	}
	
	public boolean setMobiltyTypeSelfMobile(){
		String sMobilityType = "Mobility Type";
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getNewEquipmentRequiredForms());
		WebElement dd = WebElementUtils.getElementWithMatchingStartsWithText(ls, sMobilityType);
		if (dd != null) {
			bReturn = getNewEquipmentDropDownItem(dd, "Self Mobile");
		}else{
			log.debug("Business Unit was not found in Equipment");
		}
		return bReturn;
	}
	
	public boolean setMobilityTypeMovesOtherEquipment(){
		String sMobilityType = "Mobility Type";
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getNewEquipmentRequiredForms());
		WebElement dd = WebElementUtils.getElementWithMatchingStartsWithText(ls, sMobilityType);
		if (dd != null) {
			bReturn = getNewEquipmentDropDownItem(dd, "Moves Other Equipment");
		}else{
			log.debug("Mobility Type was not found in Equipment");
		}
		return bReturn;
	}
	
	public boolean setMobilityTypeRequiresMove() {
		String sMobilityType = "Mobility Type";
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getNewEquipmentRequiredForms());
		WebElement dd = WebElementUtils.getElementWithMatchingStartsWithText(ls, sMobilityType);
		if (dd != null) {
			bReturn = getNewEquipmentDropDownItem(dd, "Requires Move");
		}else{
			log.debug("Mobility Type was not found in Equipment");
		}
		return bReturn;
	}
	
	private boolean getNewEquipmentDropDownItem(WebElement el, String sText){
		boolean bReturn = false;
		if (el != null) {
			WebElementUtils.clickElement(el);
			List<WebElement> dd = WebElementUtils.findElements(B2WEquipment.getNewEquipmentDropDownItem());
			WebElement item = WebElementUtils.getElementWithMatchingText(dd, sText, false);
			if (item != null) {
				bReturn = WebElementUtils.clickElement(item);
			}
		}else{
			log.debug("Element is null");
		}
		return bReturn;
	}
	
	public boolean selectOwnershipTypeSubcontracted() {
		String sOwnershipTypeString = "Ownership Type";
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getNewEquipmentRequiredForms());
		WebElement dd = WebElementUtils.getElementWithMatchingStartsWithText(ls, sOwnershipTypeString);
		if (dd != null) {
			bReturn = getNewEquipmentDropDownItem(dd, "Subcontracted");
		}else{
			log.debug("Ownership Type not found");
		}
		return bReturn;
	}
	public boolean selectOwnershipTypeOwned() {
		String sOwnershipTypeString = "Ownership Type";
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getNewEquipmentRequiredForms());
		WebElement dd = WebElementUtils.getElementWithMatchingStartsWithText(ls, sOwnershipTypeString);
		if (dd != null) {
			bReturn = getNewEquipmentDropDownItem(dd, "Owned");
		}else{
			log.debug("Ownership Type not found");
		}
		return bReturn;
	}
	public boolean selectOwnershipTypeRented() {
		String sOwnershipTypeString = "Ownership Type";
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getNewEquipmentRequiredForms());
		WebElement dd = WebElementUtils.getElementWithMatchingStartsWithText(ls, sOwnershipTypeString);
		if (dd != null) {
			bReturn = getNewEquipmentDropDownItem(dd, "Rented");
		}else{
			log.debug("Ownership Type not found");
		}
		return bReturn;
	}


}
