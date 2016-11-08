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
			// get parent and is it expanded or collapsed
			WebElement parent = WebElementUtils.getParentElement(el);
			WebElement button = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoButtonAdd());
			Coordinates coordinate = ((Locatable)button).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			if (WebElementUtils.clickElement(button)){
				bReturn = WebElementUtils.waitForElementIsDisplayed(windows.get(1), WebElementUtils.SHORT_TIME_OUT);
				bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			}
		}
		return bReturn;
	}
	
	public boolean clickSaveAddPart() {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement buttoncontainer = WebElementUtils.getChildElement(window, B2WEquipment.getKendoButtonContainer());
			WebElement savebutton = buttoncontainer.findElement(B2WEquipment.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(savebutton);
			bReturn &= WebElementUtils.waitForElementInvisible(window);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean selectPartToAddToEquipmentByDescription(String sPart){
		
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			if (WebElementUtils.waitForElementStale(grid, 1)){
				grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			}
			Iterator<WebElement> itr = getChildElementsFromGrid(grid);
			//List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
			//Iterator<WebElement> itr = items.iterator();
			while (itr.hasNext()){
				WebElement item = itr.next();
				List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
				String sText = gridcontent.get(1).getText();
				// when it's a empty string we need to get into view
				if (sText.equals("")){
					Coordinates coordinate = ((Locatable)item).getCoordinates(); 
					coordinate.onPage(); 
					coordinate.inViewPort();
				}
				sText = gridcontent.get(1).getText();
				if (sText.startsWith(sPart)){
					bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(gridcontent.get(0),By.tagName("input")));
					break;
				}
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
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getKendoHeadersFromView());
		WebElement el = WebElementUtils.getElementWithMatchingText(ls, METERS, false);
		if (el != null) {
			// get parent and is it expanded or collapsed
			WebElement parent = WebElementUtils.getParentElement(el);
			WebElement button = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoButtonAdd());
			WebElementUtils.clickElement(button);
			List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindowTitle());
			bReturn = WebElementUtils.waitForElementIsDisplayed(windows.get(windows.size()-1), WebElementUtils.SHORT_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean clickAddProgramButton() {
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WEquipment.getKendoHeadersFromView());
		WebElement el = WebElementUtils.getElementWithMatchingText(ls, PROGRAMS, false);
		if (el != null) {
			// get parent and is it expanded or collapsed
			WebElement parent = WebElementUtils.getParentElement(el);
			WebElement button = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoButtonAdd());
			WebElementUtils.clickElement(button);
			//List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindowTitle());
			//WebElementUtils.getAllInfo(windows.get(0));
			bReturn = WebElementUtils.waitAndFindDisplayedEletment(B2WMaintain.getB2WAddProgramDialog()) != null;
		}
		return bReturn;
	}
	
	public boolean setAddProgramText(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WAddProgramDialog());
		if (el != null){
			WebElement program = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(program);
			bReturn = WebElementUtils.sendKeys(program, sText);
			el.click();
		}
		return bReturn;
	}
	
	public boolean clickAddProgramNextButton(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WAddProgramDialog());
		if (el != null){
			WebElement program = WebElementUtils.getChildElement(el, B2WMaintain.getKendoButtonNext());
			bReturn = WebElementUtils.clickElement(program);
		}
		return bReturn;
	}
	
	public boolean clickSaveProgramButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WAddProgramDialog());
		if (el != null){
			WebElement program = WebElementUtils.getChildElement(el, B2WMaintain.getKendoAddSaveButton());
			bReturn = WebElementUtils.clickElement(program);
			bReturn &= WebElementUtils.waitForElementInvisible(program);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	public boolean selectAddMeterTypeFromDD(String sText) {
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 0);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean setAddMeterTypeDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getDisplayedWindow();
		WebElement desc = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDescription());
		if (desc != null){
			bReturn = WebElementUtils.sendKeys(desc, sText);
		}
		return bReturn;
	}

	public boolean clickSaveAddMeter() {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement buttoncontainer = WebElementUtils.getChildElement(window, B2WEquipment.getKendoButtonContainer());
			WebElement savebutton = buttoncontainer.findElement(B2WEquipment.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(savebutton);
			bReturn &= WebElementUtils.waitForElementInvisible(window);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean selectAddMeterExcludeFromWorkOrdersUseGlobalSetting(){
		String sText = "Use global Setting";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 1);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterExcludeFromWorkOrdersAlways(){
		String sText = "Yes, always";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 1);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterExcludeFromWorkOrdersNever(){
		String sText = "No, never";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 1);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterRequiredOnWorkOrderCompletionUseGlobalSetting(){
		String sText = "Use global Setting";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 2);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterRequiredOnWorkOrderCompletionRequired(){
		String sText = "Required";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 2);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean selectAddMeterRequiredOnWorkOrderCompletionNotRequired(){
		String sText = "Not required";
		boolean bReturn = false;
		WebElement dd = getDropDownsFromWindow(getDisplayedWindow(), 2);
		if (WebElementUtils.clickElement(WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown()))){
			bReturn = selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	public boolean setAddMeterIntialReading(String sReading){
		boolean bReturn = false;
		WebElement el = getNumericTextBoxesFromWindow(getDisplayedWindow(), 0);
		List<WebElement> inputs = WebElementUtils.getChildElements(el,B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sReading);

		return bReturn;
	}
	public boolean setAddMeterEnterNewReadingCheckBox(){
		boolean bReturn = false;
		bReturn = WebElementUtils.clickElement(getCheckboxsFromWindow(getDisplayedWindow(), 2));
		return bReturn;
	}
	public boolean setAddMeterEnterNewReading(String sReading){
		boolean bReturn = false;
		WebElement el = getNumericTextBoxesFromWindow(getDisplayedWindow(), 1);
		List<WebElement> inputs = WebElementUtils.getChildElements(el,B2WMaintain.getKendoDropDown());
		Coordinates coordinate = ((Locatable)inputs.get(0)).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sReading);

		return bReturn;
	}
	public boolean setAddMeterEnterNewReadingDate(String sDate){
		boolean bReturn = false;
		WebElement el = getDisplayedWindow();
		WebElement date = WebElementUtils.getChildElement(el,B2WEquipment.getKendoDateText());
		if (date != null){
			Coordinates coordinate = ((Locatable)date).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			WebElement input = date.findElement(B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(input);
			bReturn = WebElementUtils.sendKeys(input,sDate);
		}
		return bReturn;
	}
	
	public WebElement getDropDownsFromWindow(WebElement window, int iNum) {
		List<WebElement> dds = window.findElements(KendoUI.getKendoDropDownForTMTab());
		return dds.get(iNum);
	}
	
	public WebElement getCheckboxsFromWindow(WebElement window, int iNum){
		List<WebElement> checkboxes = new ArrayList<WebElement>();
		List<WebElement> inputs = window.findElements(By.tagName("input"));
		Iterator<WebElement> iter = inputs.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			if (el.getAttribute("type").equals("checkbox")){
				checkboxes.add(el);
			}
		}
		return checkboxes.get(iNum);
	}
	
	public WebElement getNumericTextBoxesFromWindow(WebElement window, int iNum){
		List<WebElement> numerictextboxes = window.findElements(B2WEquipment.getKendoNumericTextBox());
		return numerictextboxes.get(iNum);
	}
	
	
}
