package tasks.maintain;

import java.util.ArrayList;
import java.util.Iterator;
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

	int sourcecolumn = 0;
	int datecolumn = 1;
	int location = 2;
	int bin = 3;
	int inventorychange = 4;
	int ponumber = 5;
	
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
		boolean bReturn = false;
		WebElement el = getFormElement("Notes", By.cssSelector("textarea.notes-edit"));
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
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
	
	public boolean clickAddVendor() {
		boolean bReturn = false;
		WebElement el = getButton("Add Vendor");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			
		}
		return bReturn;
	}
	public boolean selectVendorName(String sText) {
		boolean bReturn = false;
		WebElement vendor = getVendorElement("Organization");
		if (vendor != null) {
			WebElementUtils.getChildElement(vendor, B2WMaintain.getKendoDropDown()).click();
			bReturn = selectItemFromDropDown(sText);
		}

		return bReturn;
	}
	
	public String selectAnyVendor() {
		String sText = "";
		WebElement vendor = getVendorElement("Organization");
		if (vendor != null) {
			WebElementUtils.getChildElement(vendor, B2WMaintain.getKendoDropDown()).click();
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public boolean selectPrimarySecondary(String sText) {
		boolean bReturn = false;
		WebElement vendor = getVendorElement("VendorType");
		if (vendor != null) {
			WebElementUtils.getChildElement(vendor, B2WMaintain.getKendoDropDown()).click();
			bReturn = selectItemFromDropDown(sText);
		}

		return bReturn;

	}
	
	public boolean setVendorPartNumber(String sText){
		boolean bReturn = false;
		WebElement vendor = getVendorElement("VendorPartNumber");
		if (vendor != null) {
			WebElement text = WebElementUtils.getChildElement(vendor, By.cssSelector("input.k-input.k-textbox"));
			WebElementUtils.clickElement(text);
			bReturn = WebElementUtils.sendKeys(text, sText);
		}

		return bReturn;

	}
	
	public boolean setPartLeadTime(String sText){
		boolean bReturn = false;
		WebElement vendor = getVendorElement("PartLeadTimeSpan");
		if (vendor != null) {
			WebElement textbox = WebElementUtils.getChildElement(vendor, B2WMaintain.getKendoNumericTextBox());
			List<WebElement> dd = WebElementUtils.getChildElements(textbox, B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(dd.get(0));
			bReturn = WebElementUtils.sendKeys(dd.get(1),sText);
		}

		return bReturn;

	}
	
	public boolean saveVendor(){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPartsVendorsList());
		if (listView != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(listView, By.cssSelector(".k-grid-update")));
		}
		return bReturn;
	}
	
	public boolean deleteVendor(){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPartsVendorsList());
		if (listView != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(listView, By.cssSelector(".k-grid-delete")));
		}
		return bReturn;
	}
	
	private WebElement getVendorElement(String sContainer){
		WebElement vendor = null;
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPartsVendorsList());
		if (listView != null){
			WebElement elementRow = WebElementUtils.getChildElement(listView, B2WMaintain.getMaintainEditRow());
			List<WebElement> gridcells = WebElementUtils.getChildElements(elementRow, By.tagName("td"));
			WebElement el = WebElementUtils.getElementWithMatchingAttribute(gridcells, "data-container-for", sContainer);
			if (el != null){
				vendor = el;
			}
		}
		return vendor;
	}
	
	public ArrayList<String> getInventorySource() {
		
		return getInventoryByColumn(0);
	}
	public ArrayList<String> getInventoryDate() {
		
		return getInventoryByColumn(1);
	}
	public ArrayList<String> getInventoryLocations() {
		
		return getInventoryByColumn(2);
	}
	public ArrayList<String> getInventoryBins() {
		
		return getInventoryByColumn(3);
	}
	public ArrayList<String> getInventoryChange() {
		
		return getInventoryByColumn(4);
	}
	public ArrayList<String> getInventoryPO() {
		
		return getInventoryByColumn(5);
		
	}
	private ArrayList<String> getInventoryByColumn(int iColumn){
		ArrayList<String> al = new ArrayList<String>();
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPartsInventoryHistoryListView());
		if (listView != null){
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(WebElementUtils.getChildElements(listView, By.tagName("tbody")),"role","rowgroup");
			if (rowgroup != null){
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				Iterator<WebElement> iter = rows.iterator();
				while (iter.hasNext()) {
					WebElement row = iter.next();
					List<WebElement> ls = row.findElements(By.tagName("td"));
					al.add(ls.get(iColumn).getText());
				}
			}
		
		}
		return al;
	}
	
	public String getInventoryText(int iRow, int iColumn) {
		String al = "";
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPartsInventoryHistoryListView());
		if (listView != null) {
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(
					WebElementUtils.getChildElements(listView, By.tagName("tbody")), "role", "rowgroup");
			if (rowgroup != null) {
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				if (rows.size()>=iRow){
					List<WebElement> columns =  rows.get(iRow).findElements(By.tagName("td"));
					if (columns.size()>=iColumn){
						al = columns.get(iColumn).getText();
					}
				}

			}

		}
		return al;
	}
	
	public int getInventoryHistoryRows() {
		int i = 0;
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPartsInventoryHistoryListView());
		if (listView != null) {
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(
					WebElementUtils.getChildElements(listView, By.tagName("tbody")), "role", "rowgroup");
			if (rowgroup != null) {
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				i = rows.size();

			}

		}
		return i;
	}
	
	public int getPurchaseOrderHistoryRows() {
		int i = 0;
		WebElement listView = WebElementUtils.findElement(By.id("PurchaseOrderGrid"));
		if (listView != null) {
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(
					WebElementUtils.getChildElements(listView, By.tagName("tbody")), "role", "rowgroup");
			if (rowgroup != null) {
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				i = rows.size();

			}

		}
		return i;
	}

	public ArrayList<String> getPurchaseOrderDate() {
		
		return getPurchaseOrderByColumn(0);
	}
	public ArrayList<String> getPurchaseOrderNumber() {
		
		return getPurchaseOrderByColumn(1);
	}
	public ArrayList<String> getPurchaseOrderVendor() {
		
		return getPurchaseOrderByColumn(2);
	}
	public ArrayList<String> getPurchaseOrderBuyer() {
		
		return getPurchaseOrderByColumn(3);
		
	}
	private ArrayList<String> getPurchaseOrderByColumn(int iColumn){
		ArrayList<String> al = new ArrayList<String>();
		WebElement listView = WebElementUtils.findElement(By.id("PurchaseOrderGrid"));
		if (listView != null){
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(WebElementUtils.getChildElements(listView, By.tagName("tbody")),"role","rowgroup");
			if (rowgroup != null){
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				Iterator<WebElement> iter = rows.iterator();
				while (iter.hasNext()) {
					WebElement row = iter.next();
					List<WebElement> ls = row.findElements(By.tagName("td"));
					al.add(ls.get(iColumn).getText());
				}
			}
		
		}
		return al;
	}
	
	public String getPurchaseOrderText(int iRow, int iColumn) {
		String al = "";
		WebElement listView = WebElementUtils.findElement(By.id("PurchaseOrderGrid"));
		if (listView != null) {
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(
					WebElementUtils.getChildElements(listView, By.tagName("tbody")), "role", "rowgroup");
			if (rowgroup != null) {
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				al = rows.get(iRow).findElements(By.tagName("td")).get(iColumn).getText();

			}

		}
		return al;
	}
	public boolean clickOnLink(int iRow){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPartsInventoryHistoryListView());
		if (listView != null){
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(WebElementUtils.getChildElements(listView, By.tagName("tbody")),"role","rowgroup");
			if (rowgroup != null){
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				if (rows.size() > iRow){
					WebElement row = rows.get(iRow);
					WebElement column = row.findElements(By.tagName("td")).get(0);
					bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(column, By.tagName("a")));
				}
			}
		}
		return bReturn;
	}
	public boolean clickOnPONumberLink(int iRow){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.findElement(By.id("PurchaseOrderGrid"));
		if (listView != null){
			WebElement rowgroup = WebElementUtils.getElementWithMatchingAttribute(WebElementUtils.getChildElements(listView, By.tagName("tbody")),"role","rowgroup");
			if (rowgroup != null){
				List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
				if (rows.size() > iRow){
					WebElement row = rows.get(iRow);
					WebElement column = row.findElements(By.tagName("td")).get(0);
					bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(column, By.tagName("a")));
				}
			}
		}
		return bReturn;
	}
}
