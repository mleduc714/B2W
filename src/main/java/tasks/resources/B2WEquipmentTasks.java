package tasks.resources;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

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
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Description");
		
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
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "EquipmentID");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to set text to");
		}

		return bReturn;
	}
	
	//***********************THIS IS A TEST************************************
	
	//EQUIPMENT SPECS
	public boolean setEquipmentSpecsManufacturer(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Manufacturer");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	public boolean setEquipmentSpecsModel(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Model");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	//Year does not Work for some reason
	public boolean setEquipmentSpecsYear(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Year");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	
	public boolean setEquipmentSpecsColor(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Color");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	
	public boolean setEquipmentSpecsLojack(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Lojack");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	
	public boolean setEquipmentSpecsHutStickerNumber(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "HutStickerNumber");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	
	public boolean setEquipmentSpecsEZPassNumber(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "EZPassNumber");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	
	
	//COMPONENT SPECS
	public boolean setComponentSpecsEngine(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "Engine");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
		public boolean setComponentSpecsEngineArrangement(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "EngineArrangement");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		public boolean setComponentSpecsEngineSerialNumber(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "EngineSerialNumber");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		public boolean setComponentSpecsHorsePower(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "HorsePower");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		public boolean setComponentSpecsTransmissionModel(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "TransmissionModel");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		public boolean setComponentSpecsTransmissionSerialNumber(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "TransmissionSerialNumber");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		public boolean setComponentSpecsTireSize(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "TireSize");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		public boolean setComponentSpecsGET(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "GET");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		public boolean setComponentSpecsHydraulicFlowRate(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "HydraulicFlowRate");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
		
		
		//FINANCIALS
		
		public boolean setFinancialsPurchasedFrom(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "PurchasedFrom");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		public boolean setFinancialsPurchasePrice(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "PurchasePrice");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		public boolean setFinancialsInsuranceValue(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "InsuranceValue");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		public boolean setFinancialsTitleHolder(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "TitleHolder");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		public boolean setFinancialsSoldTo(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "SoldTo");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		public boolean setFinancialsSalesPrice(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithMatchingAttribute(els, "name", "SalesPrice");
		
		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}else{
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
		
	//***********************THIS IS A TEST************************************
	

	
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
			// when we click we need to find the visible list
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
			WebElement button = WebElementUtils.getChildElement(el, B2WEquipment.getKendoLargeSaveButton());
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
	public boolean selectEquipmentFromViewByID(String sID){
		return selectItemFromView(sID,0);
	}
	
	public boolean selectEquipmentFromViewByDescription(String sDesc) {
		return selectItemFromView(sDesc,1);
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
	public boolean expandFinancials() {
		return getHeaderandExpandOrCollapse(FINANCIALS, true);
	}
	
	public boolean collapseFinancials(){
		return getHeaderandExpandOrCollapse(FINANCIALS, false);
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
		return waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
	}
	
	public boolean clickAddPartsButton() {
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getKendoHeadersFromView());
		WebElement el = WebElementUtils.getElementWithMatchingText(ls, PARTS, false);
		if (el != null) {
			List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindowTitle());
			WebElement button = getButton(2);
			Coordinates coordinate = ((Locatable) button).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();
			TaskUtils.sleep(5000);
			if (WebElementUtils.clickElement(button)) {
				bReturn = WebElementUtils.waitForElementIsDisplayed(windows.get(1), WebElementUtils.SHORT_TIME_OUT);
				bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			}
		}
		return bReturn;
	}
	

	public WebElement getDisplayedWindow() {
		WebElement window = null;
		List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindow());
		Iterator<WebElement> iter = windows.iterator();
		while (iter.hasNext()){
			WebElement temp = iter.next();
			if (temp.isDisplayed()){
				window = temp;
			}
		}
		return window;
	}
	
	public boolean clickAddMeterButton() {
		boolean bReturn = false;

		WebElement button = getButton(1);
		Coordinates coordinate = ((Locatable) button).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		TaskUtils.sleep(5000);
		if (WebElementUtils.clickElement(button)) {
			List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindowTitle());
			bReturn = WebElementUtils.waitForElementIsDisplayed(windows.get(windows.size() - 1),
					WebElementUtils.SHORT_TIME_OUT);
		}

		return bReturn;
	}
	
	public boolean clickAddProgramButton() {
		boolean bReturn = false;
		WebElement button = getButton(4);
		Coordinates coordinate = ((Locatable) button).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		TaskUtils.sleep(5000);
		if (WebElementUtils.clickElement(button)) {
			bReturn = WebElementUtils.waitAndFindDisplayedEletment(B2WMaintain.getB2WAddProgramDialog()) != null;
		}

		return bReturn;
	}
	
	//Allows to populate fields and dropdowns
	public boolean setTextEquipmentSpecs(String sField, String sText){
		return setTextByField(EQUIPMENTSPECS, sField, sText);
	}
	
	public boolean setFieldAndItemFromDropDownEquipmentSpecs(String sField, String sValue, String sItem){
		return selectItemValueFromDropDown(EQUIPMENTSPECS, sField, sValue, sItem);
	}
	
	public boolean setTextComponentSpecs(String sField, String sText){
		return setTextByField(COMPSPECS, sField, sText);
	}
	
	public boolean setFieldAndItemFromDropDownComponentSpecs(String sField, String sValue, String sItem){
		return selectItemValueFromDropDown(COMPSPECS, sField, sValue, sItem);
	}
	
	public boolean setTextFinancials(String sField, String sText){
		return setTextByField(FINANCIALS, sField, sText);
	}
	
	public boolean setFieldAndItemFromDropDownFinancials(String sField, String sValue, String sItem){
		return selectItemValueFromDropDown(FINANCIALS, sField, sValue, sItem);
	}
	
	
	
	private boolean setTextByField(String sHeader, String sField, String sText){
		boolean bReturn = false;
		// get the header
		WebElement parent = getHeader(sHeader);
		// find all the name value pairs
		List<WebElement> items = WebElementUtils.getChildElements(parent, B2WMaintain.getKendoNameValuePair());
		// find the label of the element we wish to set text for
		WebElement specs = WebElementUtils.getElementWithMatchingChildElementText(items, By.tagName("label"), sField);
		if (specs != null){
		// get the parent of the label
			// find the input
			WebElement input = WebElementUtils.getChildElement(specs, By.tagName("input"));
			bReturn = WebElementUtils.sendKeys(input, sText);
		}
		return bReturn;
	}
	
	private boolean selectItemValueFromDropDown(String sHeader, String sField, String sValue, String sItem){
		boolean bReturn = false;
		// get the header
		WebElement parent = getHeader(sHeader);
		// find all the name value pairs
		List<WebElement> items = WebElementUtils.getChildElements(parent, B2WMaintain.getKendoNameValuePair());
		// find the label of the element we wish to set text for
		WebElement specs = WebElementUtils.getElementWithMatchingChildElementText(items, By.tagName("label"), sField);
		if (specs != null){
		// get the parent of the label
		// find the input
			List<WebElement> input = WebElementUtils.getChildElements(specs, B2WMaintain.getKendoDropDown());
			Coordinates coordinate = ((Locatable) input.get(0)).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();
			if (sValue != null){
				WebElementUtils.clickElement(input.get(0));
				bReturn = WebElementUtils.sendKeys(input.get(1), sValue);
			}
			if (sItem != null){
				WebElementUtils.clickElement(input.get(input.size()-1));
				bReturn &= selectItemFromDropDown(sItem);
			}
		}
		return bReturn;
	}
}
