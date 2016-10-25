package tasks.resources;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import tasks.WebElementUtils;

public class B2WEquipmentTasks extends B2WKendoTasks {
	
	
	public String EQUIPMENTSPECS = "Equipment Specs";
	public String COMPSPECS = "Component Specs";
	public String FILEATTACH = "File Attachments";
	public String FINANCIALS = "Financials";
	public String METERS = "Meters";
	public String PARTS = "Parts";
	public String WARRANTIES = "Warranties";
	public String PROGRAMS = "Programs";
	public String TAGS = "Tags";
	public String CREWS = "Crews";
	public String EVENTS = "Events";
	public String HISTORY = "History";
	public String LOCATION = "Location";
	
	
	Logger log = Logger.getLogger(B2WEquipmentTasks.class);

	public boolean createNewEquipment() {
		boolean bReturn = false;
		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getKendoButton());
		if (els.size() > 0) {
			WebElement el = WebElementUtils.getElementWithMatchingText(els, "New Equipment", true);
			if (el != null) {
				bReturn = WebElementUtils.clickElement(el);
				bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getKendoFooter(), WebElementUtils.MEDIUM_TIME_OUT) != null;
			}
		}
		return bReturn;
	}

	public boolean setEquipmentDescription(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
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

		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithWithMatchingAttribute(els, "name", "EquipmentID");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to set text to");
		}

		return bReturn;
	}
	
	public boolean selectNewEquipmentBusinessUnitFromDropDown(String sText){
		String sBusinessUnit = "Business Unit";
		return selectNewEquipmentDropDownItem(sBusinessUnit,sText);
	}
	
	public boolean selectNewEquipmentTypeFromDropDown(String sText) {
		String sEquipmentType = "Equipment Type";
		return selectNewEquipmentDropDownItem(sEquipmentType, sText);
	}
	
	public boolean selectMobilityTypeSelfMobileFromDropDown(){
		String sMobilityType = "Mobility Type";
		return selectNewEquipmentDropDownItem(sMobilityType,"Self Mobile");
	}
	
	public boolean selectMobilityTypeMovesOtherEquipmentFromDropDown(){
		String sMobilityType = "Mobility Type";
		return selectNewEquipmentDropDownItem(sMobilityType,"Moves Other Equipment");
	}
	
	public boolean selectMobilityTypeRequiresMoveFromDropDown() {
		String sMobilityType = "Mobility Type";
		return selectNewEquipmentDropDownItem(sMobilityType,"Requires Move");
	}
	
	private boolean selectNewEquipmentDropDownItem(String sText, String sItem) {
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getKendoNameValuePair());
		WebElement el = WebElementUtils.getElementWithMatchingStartsWithText(ls, sText);
		WebElement dd = WebElementUtils.getChildElement(el, B2WEquipment.getKendoDropDown());
		if (WebElementUtils.clickElement(dd)) {
			// when we click we need to find the visble list
			List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()) {
				WebElement els = iter.next();
				String hidden = els.getAttribute("aria-hidden");
				if (hidden != null && hidden.equals("false")) {
					List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
					WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
					if (item != null) {
						bReturn = WebElementUtils.clickElement(item);
					}else{
						log.debug("Item with could not be found matching "+sItem);
					}
				}
			}
		}
		return bReturn;
	}
	
	public boolean selectOwnershipTypeSubcontractedFromDropDown() {
		String sOwnershipTypeString = "Ownership Type";
		return selectNewEquipmentDropDownItem(sOwnershipTypeString,"Subcontracted");
	}
	public boolean selectOwnershipTypeOwnedFromDropDown() {
		String sOwnershipTypeString = "Ownership Type";
		return selectNewEquipmentDropDownItem(sOwnershipTypeString,"Owned");
	}
	public boolean selectOwnershipTypeRentedFromDropDown() {
		String sOwnershipTypeString = "Ownership Type";
		return selectNewEquipmentDropDownItem(sOwnershipTypeString,"Rented");
	}

	public boolean saveNewEquipment() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WEquipment.getKendoFooter());
		if (el != null) {
			WebElement button = WebElementUtils.getChildElement(el, B2WEquipment.getNewEquipmentSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getEquipmentItemAction()) != null;
			bReturn &= waitForEquipmentPageNoBusy();
			
		}
		return bReturn;
	}
	
	public boolean selectAllEquipmentByTypeView() {
		boolean bReturn = false;
		String sItem = "All Equipment By Type";
		if (WebElementUtils.clickElement(B2WEquipment.getKendoDropDownItem())) {
			// when we click we need to find the visble list
			bReturn = findAndSelectItemFromDD(sItem);
		}
		return bReturn;
				
	}
	
	public boolean selectFilterByBusinessUnit(String sUnit){
		boolean bReturn = false;
		List<WebElement> dd = WebElementUtils.findElements(B2WEquipment.getKendoFilterByDD());
		if (WebElementUtils.clickElement(dd.get(0))){
			bReturn =findAndSelectItemFromDD(sUnit);
		}
		return bReturn;
		
	}
	
	private boolean findAndSelectItemFromDD(String sText){
		boolean bReturn = false;
		
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sText, false);
				if (item != null) {
					bReturn = WebElementUtils.clickElement(item);
				}else{
					log.debug("Item with could not be found matching "+sText);
				}
			}
		}
		return bReturn;
	
	}
	
	public boolean selectEquipmentFromViewByDescription(String sDesc){
		boolean bReturn = false;
		
		WebElement grid = WebElementUtils.findElement(B2WEquipment.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()){
			WebElement item = iter.next();
			List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
			String sText = gridcontent.get(1).getText();
			// when it's a empty string we need to get into view
			if (sText.equals("")){
				Coordinates coordinate = ((Locatable)item).getCoordinates(); 
				coordinate.onPage(); 
				coordinate.inViewPort();
			}
			sText = gridcontent.get(1).getText();
			if (sText.startsWith(sDesc)){
				item.click();
				break;
			}
		}
		return bReturn;
	}
	
	public String getEquipmentHeadline() {
		return WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getEquipmentHeadline()).getText();
	}
	
	public String getSerialNumberOfItem() {
		return getTextOfItemFromOverview("Serial Number");
	}
	public String getLicencePlateOfItem() {
		return getTextOfItemFromOverview("License Plate");
	}
	public String getBusinessUnitOfItem() {
		return getTextOfItemFromOverview("Business Unit");
	}
	public String getEquipmentTypeOfItem() {
		return getTextOfItemFromOverview("Equipment Type");
	}
	public String getMobilityTypeOfItem() {
		return getTextOfItemFromOverview("Mobility Type");
	}
	public String getOwnershipTypeOfItem() {
		return getTextOfItemFromOverview("Ownership Type");
	}
	public String getLocationOfItem() {
		return getTextOfItemFromOverview("Location");
	}
	public String getOrganizationOfItem() {
		return getTextOfItemFromOverview("Organization");
	}
	public String getOperatorOfItem() {
		return getTextOfItemFromOverview("Operator");
	}
	public String getExcludeFromFieldLogsOfItem() {
		return getTextOfItemFromOverview("Exclude from Field Logs");
	}
	public String getNotesOfItem() {
		return getTextOfItemFromOverview("Notes");
	}
	
	private String getTextOfItemFromOverview(String sItem){
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getEquipmentBoxContent());
		List<WebElement> nvps = WebElementUtils.getChildElements(el, B2WEquipment.getKendoNameValuePair());
		Iterator<WebElement> iter = nvps.iterator();
		while (iter.hasNext()){
			WebElement nvp = iter.next();
			WebElement label = nvp.findElement(By.cssSelector(".label"));
			if (label.getText().equals(sItem)){
				sItem = nvp.findElement(By.cssSelector(".data")).getText();
			}
		}
		return sItem;
		
	}
	
	public boolean expandEquipmentSpecs() {
		return getHeaderandExpandOrCollapse(EQUIPMENTSPECS, true);
	}
	public boolean collapseEquipmentSpecs(){
		return getHeaderandExpandOrCollapse(EQUIPMENTSPECS, false);
	}
	public boolean expandComponentSpecs() {
		return getHeaderandExpandOrCollapse(COMPSPECS, true);
	}
	public boolean collapseComponentSpecs(){
		return getHeaderandExpandOrCollapse(COMPSPECS, false);
	}
	public boolean expandFileAttachments() {
		return getHeaderandExpandOrCollapse(FILEATTACH, true);
	}
	public boolean collapseFileAttachments(){
		return getHeaderandExpandOrCollapse(FILEATTACH, false);
	}
	public boolean expandMeters() {
		return getHeaderandExpandOrCollapse(METERS, true);
	}
	public boolean collapseMeters(){
		return getHeaderandExpandOrCollapse(METERS, false);
	}
	public boolean expandParts() {
		return getHeaderandExpandOrCollapse(PARTS, true);
	}
	public boolean collapseParts(){
		return getHeaderandExpandOrCollapse(PARTS, false);
	}
	public boolean expandWarrenties() {
		return getHeaderandExpandOrCollapse(WARRANTIES, true);
	}
	public boolean collapseWarrenties(){
		return getHeaderandExpandOrCollapse(WARRANTIES, false);
	}
	public boolean expandPrograms() {
		return getHeaderandExpandOrCollapse(PROGRAMS, true);
	}
	public boolean collapsePrograms(){
		return getHeaderandExpandOrCollapse(PROGRAMS, false);
	}
	public boolean expandTags() {
		return getHeaderandExpandOrCollapse(TAGS, true);
	}
	public boolean collapseTags(){
		return getHeaderandExpandOrCollapse(TAGS, false);
	}
	public boolean expandCrews() {
		return getHeaderandExpandOrCollapse(CREWS, true);
	}
	public boolean collapseCrews(){
		return getHeaderandExpandOrCollapse(CREWS, false);
	}
	public boolean expandEvents() {
		return getHeaderandExpandOrCollapse(EVENTS, true);
	}
	public boolean collapseEvents(){
		return getHeaderandExpandOrCollapse(EVENTS, false);
	}
	public boolean expandHistory() {
		return getHeaderandExpandOrCollapse(HISTORY, true);
	}
	public boolean collapseHistory(){
		return getHeaderandExpandOrCollapse(HISTORY, false);
	}
	public boolean expandLocation() {
		return getHeaderandExpandOrCollapse(LOCATION, true);
	}
	public boolean collapseLocation(){
		return getHeaderandExpandOrCollapse(LOCATION, false);
	}
	
	public boolean waitForEquipmentPageNoBusy() {
		return waitForPageNotBusy();
	}
	
}
