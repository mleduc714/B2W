package tasks.resources;

import java.util.ArrayList;
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
import appobjects.setup.B2WSchedules;
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
		WebElement el = getFormElement("Purchased From", B2WMaintain.getKendoDescription());
		if (el != null) {
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setFinancialsPurchasePrice(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Purchased Price", B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);

		return bReturn;
	}

	public boolean setFinancialsInsuranceValue(String sText) {

		boolean bReturn = false;
		WebElement el = getFormElement("Insurance Value", B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);

		return bReturn;

	}

	public boolean setFinancialsTitleHolder(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Title Holder", B2WMaintain.getKendoDescription());
		if (el != null) {
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setFinancialsSoldTo(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Sold To", B2WMaintain.getKendoDescription());
		if (el != null) {
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setFinancialsSalesPrice(String sText) {

		boolean bReturn = false;
		WebElement el = getFormElement("Sale Price", B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);

		return bReturn;

	}
	
	public boolean setFinancialsPurchaseDate(String sText) {

		boolean bReturn = false;
		WebElement el = getFormElement("Purchased Date", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
			
		}
		return bReturn;

	}
	
	public boolean setFinancialsDispositionDate(String sText) {

		boolean bReturn = false;
		WebElement el = getFormElement("Disposition Date", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
			
		}
		return bReturn;

	}
	
	public boolean selectFinancialsCCAClass(String sText) {

		boolean bReturn = false;
		WebElement el = getFormElement("CCA Class", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
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
			WebElement button = getButton("Add Parts");
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

		WebElement button = getButton("New Meter");
		Coordinates coordinate = ((Locatable) button).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		if (WebElementUtils.clickElement(button)) {
			List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindowTitle());
			bReturn = WebElementUtils.waitForElementIsDisplayed(windows.get(windows.size() - 1),
					WebElementUtils.SHORT_TIME_OUT);
		}

		return bReturn;
	}
	
	public boolean clickAddProgramButton() {
		boolean bReturn = false;
		WebElement button = getButton("Add Program");
		Coordinates coordinate = ((Locatable) button).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		if (WebElementUtils.clickElement(button)) {
			bReturn = true;
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WAddProgramDialog()) != null;
		}
		return bReturn;
	}
	
	
	
	public boolean clickAddEventButton(){
		boolean bReturn = false;
		WebElement button = getButton("Add Event");
		Coordinates coordinate = ((Locatable) button).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		if (WebElementUtils.clickElement(button)) {
			bReturn = true;
		}

		return bReturn;
	}
	public boolean clickAddWarrantyButton(){
		boolean bReturn = false;
		WebElement button = getButton("Add Warranty");
		Coordinates coordinate = ((Locatable) button).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		if (WebElementUtils.clickElement(button)) {
			bReturn = true;
		}

		return bReturn;
	}
	
	public boolean clickAddEquipmentTag(){
		boolean bReturn = false;
		WebElement button = getButton("Add Equipment Tags");
		Coordinates coordinate = ((Locatable) button).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		if (WebElementUtils.clickElement(button)) {
			bReturn = true;
		}

		return bReturn;
	}
	
	public boolean clickEquipmentLogs() {
		return clickKendoButton("Equipment Logs");
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
	
	public String getValueOfItem(String sItem){
		return getValueOfItem(sItem, B2WMaintain.getMaintainEquipmentDetailView());
	}
	public boolean clickEdit() {
        boolean bReturn = false;
		WebElement eEdit = WebElementUtils.findElement(B2WSchedules.editScheduleViewBtn());
        if (eEdit != null){
        	bReturn = WebElementUtils.clickElement(eEdit);
        }
        return bReturn;
	}
	
	public ArrayList<String> getEquipmentHistoryWorkOrders() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getHistoryRows().iterator();
		while (iter.hasNext()){
			List<WebElement> tds = WebElementUtils.getChildElements(iter.next(), By.tagName("td"));
			String sWorkOrder = WebElementUtils.getChildElement(tds.get(0), By.tagName("a")).getText();
			al.add(sWorkOrder);
		}
		return al;
	}
	
	
	
	public ArrayList<String> getEquipmentHistoryRequests() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getHistoryRows().iterator();
		while (iter.hasNext()){
			List<WebElement> tds = WebElementUtils.getChildElements(iter.next(), By.tagName("td"));
			String sWorkOrder = WebElementUtils.getChildElement(tds.get(1), By.tagName("a")).getText();
			al.add(sWorkOrder);
		}
		return al;
	}
	
	public boolean clickOnWorkOrderFromHistory(String sWorkOrder){
		boolean bReturn = false;
		Iterator<WebElement> iter = getHistoryRows().iterator();
		while (iter.hasNext()){
			List<WebElement> tds = WebElementUtils.getChildElements(iter.next(), By.tagName("td"));
			WebElement wo = WebElementUtils.getChildElement(tds.get(0), By.tagName("a"));
			if (wo.getText().equals(sWorkOrder)){
				bReturn = WebElementUtils.clickElement(wo);
			}
		}
		return bReturn;
	}
	
	public boolean clickOnCrew(String sCrew){
		boolean bReturn = false;
		Iterator<WebElement> iter = getEquipmentCrewsRows().iterator();
		while (iter.hasNext()){
			List<WebElement> tds = WebElementUtils.getChildElements(iter.next(), By.tagName("td"));
			WebElement wo = WebElementUtils.getChildElement(tds.get(0), By.tagName("a"));
			if (wo.getText().equals(sCrew)){
				bReturn = WebElementUtils.clickElement(wo);
			}
		}
		return bReturn;
	}
	
	public boolean clickOnRequestFromHistory(String sRequest){
		boolean bReturn = false;
		Iterator<WebElement> iter = getHistoryRows().iterator();
		while (iter.hasNext()){
			List<WebElement> tds = WebElementUtils.getChildElements(iter.next(), By.tagName("td"));
			WebElement wo = WebElementUtils.getChildElement(tds.get(1), By.tagName("a"));
			if (wo.getText().equals(sRequest)){
				bReturn = WebElementUtils.clickElement(wo);
			}
		}
		return bReturn;
	}
	public String getRequestTypeByWorkOrderFromHistory(String sWorkOrder) {
		String sText = "";
		int iRow = getEquipmentHistoryWorkOrders().indexOf(sWorkOrder);
		if (iRow != -1){
			sText = getHistory(iRow,2);
		}
		return sText;
	}
	public String getDescriptionByWorkOrderFromHistory(String sWorkOrder) {
		String sText = "";
		int iRow = getEquipmentHistoryWorkOrders().indexOf(sWorkOrder);
		if (iRow != -1){
			sText = getHistory(iRow,3);
		}
		return sText;
	}
	public String getCompCodeByWorkOrderFromHistory(String sWorkOrder) {
		String sText = "";
		int iRow = getEquipmentHistoryWorkOrders().indexOf(sWorkOrder);
		if (iRow != -1){
			sText = getHistory(iRow,4);
		}
		return sText;
	}
	public String getStatusByWorkOrderFromHistory(String sWorkOrder) {
		String sText = "";
		int iRow = getEquipmentHistoryWorkOrders().indexOf(sWorkOrder);
		if (iRow != -1){
			sText = getHistory(iRow,5);
		}
		return sText;
	}
	private String getHistory(int iRow, int iColumn){
		String sText = "";
		List<WebElement> rows = getHistoryRows();
		if (rows.size()>0){
			sText = WebElementUtils.getChildElements(rows.get(iRow),By.tagName("td")).get(iColumn).getText();
			
		}
		return sText;
	}
	
	private String getMeters(int iRow, int iColumn){
		String sText = "";
		List<WebElement> rows = getMeterRows();
		if (rows.size()>0){
			sText = WebElementUtils.getChildElements(rows.get(iRow),By.tagName("td")).get(iColumn).getText();
			
		}
		return sText;
	}
	
	public ArrayList<String> getMeters() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getMeterRows().iterator();
		while (iter.hasNext()){
			al.add(WebElementUtils.getChildElements(iter.next(),By.tagName("td")).get(0).getText());
		}
		return al;
	}
	public ArrayList<String> getParts() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getPartsRows().iterator();
		while (iter.hasNext()){
			al.add(WebElementUtils.getChildElements(iter.next(),By.tagName("td")).get(0).getText());
		}
		return al;
	}
	
	public ArrayList<String> getWarranties() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getWarrantyRows().iterator();
		while (iter.hasNext()){
			al.add(WebElementUtils.getChildElements(iter.next(),By.tagName("td")).get(0).getText());
		}
		return al;
	}
	
	public ArrayList<String> getEvents() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getEquipmentEventsRows().iterator();
		while (iter.hasNext()){
			al.add(WebElementUtils.getChildElements(iter.next(),By.tagName("td")).get(0).getText());
		}
		return al;
	}
	public ArrayList<String> getCrews() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getEquipmentCrewsRows().iterator();
		while (iter.hasNext()){
			List<WebElement> tds = WebElementUtils.getChildElements(iter.next(), By.tagName("td"));
			String sWorkOrder = WebElementUtils.getChildElement(tds.get(0), By.tagName("a")).getText();
			al.add(sWorkOrder);
		}
		return al;
	}
	public ArrayList<String> getTags() {
		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iter = getEquipmentTagRows().iterator();
		while (iter.hasNext()){
			al.add(WebElementUtils.getChildElements(iter.next(),By.tagName("td")).get(0).getText());
		}
		return al;
	}
	public String getMeterTypeByMeter(String sMeter){
		String sText = "";
		int iRow = getMeters().indexOf(sMeter);
		if (iRow != -1){
			sText = getMeters(iRow,1);
		}
		return sText;
	}
	public String getMeterReadingDateByMeter(String sMeter){
		String sText = "";
		int iRow = getMeters().indexOf(sMeter);
		if (iRow != -1){
			sText = getMeters(iRow,2);
		}
		return sText;
	}
	public String getMeterCurrentReadingDateByMeter(String sMeter){
		String sText = "";
		int iRow = getMeters().indexOf(sMeter);
		if (iRow != -1){
			sText = getMeters(iRow,3);
		}
		return sText;
	}
	public String getMeterPreviousReadingDateByMeter(String sMeter){
		String sText = "";
		int iRow = getMeters().indexOf(sMeter);
		if (iRow != -1){
			sText = getMeters(iRow,4);
		}
		return sText;
	}
	
	
	public String getPartDescriptionByPartID(String sPart){
		String sText = "";
		int iRow = getParts().indexOf(sPart);
		if (iRow != -1){
			sText = getParts(iRow,1);
		}
		return sText;
	}
	public String getPartUnitOfMeasureByPartID(String sPart){
		String sText = "";
		int iRow = getParts().indexOf(sPart);
		if (iRow != -1){
			sText = getParts(iRow,2);
		}
		return sText;
	}
	public String getPartManufacturerByPartID(String sPart){
		String sText = "";
		int iRow = getParts().indexOf(sPart);
		if (iRow != -1){
			sText = getParts(iRow,3);
		}
		return sText;
	}
	
	public String getWarrantyTypeByDescription(String sWarranty){
		String sText = "";
		int iRow = getWarranties().indexOf(sWarranty);
		if (iRow != -1){
			sText = getWarranty(iRow, 1);
		}
		return sText;
	}
	
	public String getWarrantyDurationByDescription(String sWarranty){
		String sText = "";
		int iRow = getWarranties().indexOf(sWarranty);
		if (iRow != -1){
			sText = getWarranty(iRow, 2);
		}
		return sText;
	}
	
	public String getWarrantyStatusByDescription(String sWarranty){
		String sText = "";
		int iRow = getWarranties().indexOf(sWarranty);
		if (iRow != -1){
			sText = getWarranty(iRow, 3);
		}
		return sText;
	}
	
	public boolean deletePart(String sPart){
		boolean bReturn = false;
		int iRow = getParts().indexOf(sPart);
		List<WebElement> rows = getPartsRows();
		if (rows.size()>0){
			WebElement delete = WebElementUtils.getChildElement(rows.get(iRow), B2WMaintain.getKendoDeleteButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}
	public boolean deleteWarranty(String sWarranty){
		boolean bReturn = false;
		int iRow = getWarranties().indexOf(sWarranty);
		List<WebElement> rows = getWarrantyRows();
		if (rows.size()>0){
			WebElement delete = WebElementUtils.getChildElement(rows.get(iRow), B2WMaintain.getKendoDeleteButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}
	public boolean editWarranty(String sWarranty){
		boolean bReturn = false;
		int iRow = getWarranties().indexOf(sWarranty);
		List<WebElement> rows = getWarrantyRows();
		if (rows.size()>0){
			WebElement delete = WebElementUtils.getChildElement(rows.get(iRow), B2WMaintain.getKendoEditButton());
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
	}
	
	public boolean editMeter(String sMeter){
		boolean bReturn = false;
		int iRow = getMeters().indexOf(sMeter);
		List<WebElement> rows = getMeterRows();
		if (rows.size()>0){
			WebElement edit = WebElementUtils.getChildElement(rows.get(iRow), B2WMaintain.getKendoEditButton());
			bReturn = WebElementUtils.clickElement(edit);
		}
		return bReturn;
	}
	
	private String getParts(int iRow, int iColumn){
		String sText = "";
		List<WebElement> rows = getPartsRows();
		if (rows.size()>0){
			sText = WebElementUtils.getChildElements(rows.get(iRow),By.tagName("td")).get(iColumn).getText();
		}
		return sText;
	}
	private String getWarranty(int iRow, int iColumn){
		String sText = "";
		List<WebElement> rows = getWarrantyRows();
		if (rows.size()>0){
			sText = WebElementUtils.getChildElements(rows.get(iRow),By.tagName("td")).get(iColumn).getText();
		}
		return sText;
	}
	
	
	private List<WebElement> getHistoryRows() {
		WebElement header = getHeader(HISTORY);
		WebElement historyView = WebElementUtils.getChildElement(header, B2WMaintain.getMaintainEquipmentHistoryView());
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	
	private List<WebElement> getPartsRows() {
		WebElement header = getHeader(PARTS);
		WebElement historyView = WebElementUtils.getChildElement(header, B2WMaintain.getMaintainEquipmentPartsView());
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	private List<WebElement> getMeterRows() {
		WebElement header = getHeader(METERS);
		WebElement historyView = WebElementUtils.getChildElement(header, B2WMaintain.getMaintainEquipmentMetersView());
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	
	private List<WebElement> getWarrantyRows() {
		WebElement header = getHeader(WARRANTIES);
		WebElement historyView = WebElementUtils.getChildElement(header, B2WMaintain.getMaintainEquipmentWarrantiesView());
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	private List<WebElement> getEquipmentTagRows() {
		WebElement header = getHeader(TAGS);
		WebElement historyView = WebElementUtils.getChildElement(header, B2WMaintain.getMaintainEquipmenttagslistview());
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	private List<WebElement> getEquipmentEventsRows() {
		WebElement header = getHeader(EVENTS);
		WebElement historyView = WebElementUtils.getChildElement(header, B2WMaintain.getMaintainEquipmenteventslistivew());
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	private List<WebElement> getEquipmentCrewsRows() {
		WebElement header = getHeader(CREWS);
		WebElement historyView = WebElementUtils.getChildElement(header, B2WMaintain.getMaintainEquipmentcrewslistview());
		WebElement tbody = WebElementUtils.getChildElement(historyView, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
		return rows;
	}
	
	
}
