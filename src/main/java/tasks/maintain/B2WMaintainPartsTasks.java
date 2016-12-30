package tasks.maintain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;

public class B2WMaintainPartsTasks extends B2WKendoTasks {

	public boolean clickAddPart() {
		boolean bReturn = false;
		WebElement el = getButton("Add Part");
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickEditPart() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoEditButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public boolean clickDeletePart() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoDeleteButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean setPartID(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("ID", B2WMaintain.getKendoInputTextBox());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setPartDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Description", B2WMaintain.getKendoInputTextBox());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setPartAltID(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Alternate ID", B2WMaintain.getKendoInputTextBox());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;

	}

	public boolean selectUnitOfMeasure(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Unit of Measure", B2WMaintain.getKendoDropDown());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean selectCategory(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Category", B2WMaintain.getKendoDropDown());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean selectSubCategory(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Subcategory", B2WMaintain.getKendoDropDown());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean setStandardUnitCost(String sText) {
		return setNumericField("Standard Unit Cost", sText);
	}

	public boolean setMinimumInventory(String sText) {
		return setNumericField("Minimum Inventory", sText);
	}

	public boolean setReorderQuantity(String sText) {
		return setNumericField("Reorder Quantity", sText);
	}

	public boolean selectBusinessUnit(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Business Unit", B2WMaintain.getKendoDropDown());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean setManufacturer(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Manufacturer", B2WMaintain.getKendoInputTextBox());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;

	}

	public boolean selectBuyer(String sText) {
		boolean bReturn = false;
		WebElement el = getFormElement("Buyer", B2WMaintain.getKendoDropDown());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean setNotes(String sText) {
		return super.setNotes(sText);

	}
	
	public boolean clickSavePart() {
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
	
	public boolean selectPartByID(String sID){
		return selectItemFromView(sID, 0);
	}
	public boolean selectPartByDescription(String sText){
		return selectItemFromView(sText, 1);
	}
	public boolean expandAttachments() {
		return getHeaderandExpandOrCollapse("Attachments", true);
	}
	public boolean expandVendors() {
		return getHeaderandExpandOrCollapse("Vendors", true);
	}
	public boolean expandInventoryHistory() {
		return getHeaderandExpandOrCollapse("Inventory History", true);
	}
	public boolean expandPurchaseOrderHistory() {
		return getHeaderandExpandOrCollapse("Purchase Order History", true);
	}
	public boolean expandWarranty() {
		return getHeaderandExpandOrCollapse("Warranty", true);
	}
	public boolean collapseAttachments() {
		return getHeaderandExpandOrCollapse("Attachments", false);
	}
	public boolean collapseVendors() {
		return getHeaderandExpandOrCollapse("Vendors", false);
	}
	public boolean collapseInventoryHistory() {
		return getHeaderandExpandOrCollapse("Inventory History", false);
	}
	public boolean collapsePurchaseOrderHistory() {
		return getHeaderandExpandOrCollapse("Purchase Order History", false);
	}
	public boolean collapseWarranty() {
		return getHeaderandExpandOrCollapse("Warranty", false);
	}
	private boolean selectViewFromDropDown(String sText){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getMaintainPartsListView());
		WebElement dd = WebElementUtils.getChildElement(listView, B2WMaintain.getKendoDropDown());
		if (dd != null){
			WebElementUtils.clickElement(dd);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectAllPartsView() {
		return selectViewFromDropDown("All Parts");
	}
	public boolean selectAllPartsByCategoryView() {
		return selectViewFromDropDown("All Parts by Category");
	}
	public boolean selectOnlyPartsWithWarrantyView() {
		return selectViewFromDropDown("Only Parts with a Warranty");
	}
	public boolean selectOnlyPartsWithWarrantyByCategoryView() {
		return selectViewFromDropDown("Only Parts with a Warranty by Category");
	}
	public String getValueOfPartItem(String sItem){
		return getValueOfItem(sItem, B2WMaintain.getMaintainPartDetailView());
	}
	public boolean clickAddWarranty(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainPartsAddWarranty());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getMaintainPartWarrantyList());
		}
		return bReturn;
	}
	public boolean setWarrantyDescription(String s){
		boolean bReturn = false;
		WebElement el = getFormElement("Warranty Description", B2WMaintain.getKendoInputTextBox());
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
		
	}
	
	public boolean selectTypeOfDurationCalendar() {
		boolean bReturn = false;
		WebElement duration = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		if (duration != null) {
			List<WebElement> tds = WebElementUtils.getChildElements(duration, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(tds, "data-container-for",
					"durationTypeList");
			WebElementUtils.clickElement(WebElementUtils.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown("Calendar Based");
		}

		return bReturn;
	}
	public boolean selectTypeOfDurationMeter() {
		boolean bReturn = false;
		WebElement window = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "durationTypeList");
			Coordinates coordinate = ((Locatable)input).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			WebElementUtils.clickElement(WebElementUtils
					.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown("Meter Based");
		}
		return bReturn;
	}
	
	public boolean setSpan(String sText) {
		boolean bReturn = false;
		WebElement window = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "spanValue");
			List<WebElement> inputs = WebElementUtils.getChildElements(input, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}
		return bReturn;
	}
	
	private boolean setSpanType(String sText) {
		boolean bReturn = false;
		WebElement window = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "unitOfMeasureList");
			WebElementUtils.clickElement(WebElementUtils
					.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectRelatedMeter(String sText){
		boolean bReturn = false;
		WebElement window = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		if (window != null){
			List<WebElement> list = WebElementUtils.getChildElements(window, By.tagName("td"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(list, "data-container-for", "meterTypeList");
			WebElementUtils.clickElement(WebElementUtils
					.getChildElement(input, B2WMaintain.getKendoDropDown()));
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean clickCompleteButton() {
		boolean bReturn = false;
		WebElement window = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		if (window != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(window, B2WMaintain.getKendoCompleteButton()));
		}
		return bReturn;
	}
	public boolean clickDeleteButton() {
		boolean bReturn = false;
		WebElement window = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		if (window != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(window, B2WMaintain.getKendoDeleteButton()));
		}
		return bReturn;
	}
	
	public boolean setSpanWeeks() {
		return setSpanType("Weeks");
	}
	public boolean setSpanDays() {
		return setSpanType("Days");
	}
	public boolean setSpanMonths() {
		return setSpanType("Months");
	}
	public boolean setSpanYears() {
		return setSpanType("Years");
	}
	
	public boolean setWarrantyNotes(String sText){
		WebElement window = WebElementUtils.findElement(B2WMaintain.getMaintainPartWarrantyList());
		return setTextArea(window, "Notes", sText);
	}
	public boolean clickAddDuration(){
		boolean bReturn = false;
		WebElement window = WebElementUtils.findElement(By.cssSelector("div.box-content.form"));
		WebElement el = WebElementUtils.getChildElementContainsText(window, B2WMaintain.getKendoButton(), "Add duration");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
}
