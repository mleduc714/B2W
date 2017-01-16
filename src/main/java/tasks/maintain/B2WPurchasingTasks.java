package tasks.maintain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;

public class B2WPurchasingTasks extends B2WKendoTasks {
	
	public ArrayList<String> getParts(){
		
		ArrayList<String> al = new ArrayList<String>();
		WebElement details = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		WebElement purchase = WebElementUtils.getChildElement(details, B2WMaintain.getMaintainPurchaseItemsContainer());
		List<WebElement> rows = WebElementUtils.getChildElements(WebElementUtils.getChildElement(purchase, By.tagName("tbody")),By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			al.add(WebElementUtils.getChildElements(el, By.tagName("td")).get(0).getText());
		}
		return al;
	}
	public String getPartVendor(String sPart){
		return getText(sPart,1);
	}
	public String getPartCategory(String sPart){
		return getText(sPart,2);
	}
	public String getPartOrderQty(String sPart){
		return getText(sPart,3);
	}
	public String getPartRecdQty(String sPart){
		return getText(sPart,4);
	}
	public String getPartRemainingQty(String sPart){
		return getText(sPart,5);
	}
	public String getPartItemStatus(String sPart){
		return getText(sPart,6);
	}
	public String getPartTaxable(String sPart){
		return getText(sPart,7);
	}
	public String getPartPrice(String sPart){
		return getText(sPart,8);
	}
	public String getPartExtendedPrice(String sPart){
		return getText(sPart,9);
	}
	public void deletePart(String sPart){
		
	}

	public boolean clickAddPart() {
		boolean bReturn = false;
		WebElement el = getButton("Add Part");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean clickAddCustomPart() {
		boolean bReturn = false;
		WebElement el = getButton("Add Custom Part");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public String getSubtotal() {
		return getTotals(0);

	}
	
	public String getFreight() {
		return getTotals(1);
		
	}
	public String getTax() {
		return getTotals(3);
	}
	public String getTotal() {
		return getTotals(4);
	}
	public String  getPODueDate() {
		WebElement el = getFormElementByLabelClass("PO Due Date", By.className("data"));
		if (el != null){
			return el.getText();
		}else{
			return "";
		}
	}
	public String getTaxRate(){

		WebElement el = getFormElementByLabelClass("Tax %", By.className("data"));
		if (el != null){
			return el.getText();
		}else{
			return "";
		}
	
	}
	public void savePart() {
		
	}
	public void cancelSave() {
		
	}

	public boolean selectChooseVendorfromDD(String sText){
		boolean bReturn = false;
		WebElement vendor = getFormElementByLabelClass("Choose Vendor", B2WMaintain.getKendoDropDown());
		if (vendor != null){
			bReturn = WebElementUtils.clickElement(vendor);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAltID(String sText){
		boolean bReturn = false;
		WebElement vendor = getFormElementByLabelClass("Alternate ID", B2WMaintain.getKendoDropDown());
		if (vendor != null){
			bReturn = WebElementUtils.clickElement(vendor);
			bReturn &= WebElementUtils.sendKeys(vendor, sText);
		}
		return bReturn;
	}
	public boolean setPODueDate(String sText){
		boolean bReturn = false;
		WebElement vendor = getFormElementByLabelClass("PO Due Date", B2WMaintain.getKendoDropDown());
		if (vendor != null){
			bReturn = WebElementUtils.clickElement(vendor);
			bReturn &= WebElementUtils.sendKeys(vendor, sText);
		}
		return bReturn;
	}
	public boolean setCompanyName(String sText){
		boolean bReturn = false;
		WebElement el = getField("CompanyName");
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setStreetAddress(String sText){
		boolean bReturn = false;
		WebElement el = getField("Address1");
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setStreetAddress2(String sText){
		boolean bReturn = false;
		WebElement el = getField("Address2");
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setCity(String sText){
		boolean bReturn = false;
		WebElement el = getField("City");
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setState(String sText){
		boolean bReturn = false;
		WebElement el = getField("StateProvince");
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setPostalCode(String sText){
		boolean bReturn = false;
		WebElement el = getField("PostalCode");
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setCountry(String sText){
		boolean bReturn = false;
		WebElement el = getField("Country");
		if (el != null){
			WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setFreight(String sText){
		boolean bReturn = false;
		WebElement child = null;
		WebElement details = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		if (details != null){
			WebElement label = WebElementUtils.getChildElementContainsText(details, By.className("label"), "Freight");
			if (label != null){
				child = WebElementUtils.getChildElement(WebElementUtils.getParentElement(WebElementUtils.getParentElement(label)), B2WMaintain.getKendoNumericTextBox());
				List<WebElement> inputs = WebElementUtils.getChildElements(child, B2WMaintain.getKendoDropDown());
				bReturn = WebElementUtils.clickElement(inputs.get(0));
				bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
			}
		}
		return bReturn;
	}
	public boolean setTaxRate(String sText){
		boolean bReturn = false;
		WebElement el = getFormElementByLabelClass("Tax %",B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		return bReturn;
	}
	
	public WebElement getField(String sField){
		WebElement el = null;
		WebElement details = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		if (details != null){
			List<WebElement> data = WebElementUtils.getChildElements(details, By.tagName("input"));
			WebElement input = WebElementUtils.getElementWithMatchingAttribute(data, "name", sField);
			el = input;
		}
		return el;
	
	}
	public boolean createBlankPurchaseOrder(){
		boolean bReturn = false;
		WebElement el = getButton("Order Parts");
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			TaskUtils.sleep(500);
			bReturn = WebElementUtils.clickElement(By.cssSelector("li#blankPOLink"));
		}
		return bReturn;
	}
	
	public WebElement getFormElementByLabelClass(String sLabel, By by){
		WebElement child = null;
		WebElement details = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		if (details != null){
			WebElement label = WebElementUtils.getChildElementContainsText(details, By.className("label"), sLabel);
			if (label != null){
				child = WebElementUtils.getChildElement(WebElementUtils.getParentElement(label), by);
			}
		}
		return child;
	}
	
	public boolean savePurchaseOrder() {
		boolean bReturn = false;
		WebElement details = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		WebElement save = WebElementUtils.getChildElement(details, B2WMaintain.getKendoLargeSaveButton());
		if (save != null){
			bReturn = WebElementUtils.clickElement(save);
		}
		return bReturn;
		
	}
	public boolean selectPurchaseOrderByVendor(String sItem) {
		return selectItemFromView(sItem, 2);
	}
	public boolean selectPurchaseOrderByID(String sItem) {
		return selectItemFromView(sItem, 1);
	}
	private WebElement getPurchasingElement(String sContainer){
		WebElement vendor = null;
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
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
	
	public boolean setPart(String sText){
		boolean bReturn = false;
		WebElement el = getPurchasingElement("FormattedDescription()");
		if (el != null){
		
			WebElement part = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(part);
			WebElementUtils.sendKeys(part, sText);
			TaskUtils.sleep(1000);
			bReturn = selectItemFromDropDown(0);
		}
		
		
		return bReturn;
	}
	
	public boolean setVendorPart(String sText){
		boolean bReturn = false;
		WebElement el = getPurchasingElement("VendorPartNumber");
		if (el != null){
			WebElement vPart = WebElementUtils.getChildElement(el, B2WMaintain.getKendoInputTextBox());
			if (vPart != null){
				WebElementUtils.clickElement(vPart);
				bReturn = WebElementUtils.sendKeys(vPart, sText);
			}
		}
		return bReturn;
	}
	
	public boolean setOrderQty(String sText){
		boolean bReturn = false;
		WebElement el = getPurchasingElement("OrderQty");
		if (el != null){
			WebElement vPart = WebElementUtils.getChildElement(el, B2WMaintain.getKendoNumericTextBox());
			if (vPart != null){
				List<WebElement> dd = WebElementUtils.getChildElements(vPart, B2WMaintain.getKendoDropDown());
				WebElementUtils.clickElement(dd.get(0));
				bReturn = WebElementUtils.sendKeys(dd.get(1), sText);
			}
		}
		return bReturn;
	}
	
	public boolean savePartOrder(){
		boolean bReturn = false;
		WebElement listView = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		if (listView != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(listView, By.cssSelector(".k-grid-update")));
		}
		return bReturn;
	}
	
	public boolean clickApproveButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		if (el != null){
			WebElement approve = WebElementUtils.getChildElement(el, B2WMaintain.getKendoApproveButton());
			bReturn = WebElementUtils.clickElement(approve);
		}
		return bReturn;
	}

	public String getText(String sPart, int iColumn){
		String sText = "";
		WebElement details = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		WebElement purchase = WebElementUtils.getChildElement(details, B2WMaintain.getMaintainPurchaseItemsContainer());
		List<WebElement> rows = WebElementUtils.getChildElements(WebElementUtils.getChildElement(purchase, By.tagName("tbody")),By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("td"));
			String s = list.get(0).getText();
			if (s.contains(sPart)){
				sText = list.get(iColumn).getText();
				break;
			}
		}
		return sText;
	}
	
	public boolean editPart(String sPart){
		boolean bReturn = false;
		WebElement details = WebElementUtils.findElement(B2WMaintain.getMaintainPurchaseOrderDetails());
		WebElement purchase = WebElementUtils.getChildElement(details, B2WMaintain.getMaintainPurchaseItemsContainer());
		List<WebElement> rows = WebElementUtils.getChildElements(WebElementUtils.getChildElement(purchase, By.tagName("tbody")),By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			List<WebElement> list = WebElementUtils.getChildElements(el, By.tagName("td"));
			String s = list.get(0).getText();
			if (s.contains(sPart)){
				WebElement button = WebElementUtils.getChildElement(el, By.cssSelector(".k-edit"));
				bReturn = WebElementUtils.clickElement(button);
				break;
			}
		}
		return bReturn;
	}
	public String getTotals(int iColumn){
		String sText = "";
		WebElement purchase = WebElementUtils.findElement(By.cssSelector("div.purchase-order-details-totals"));
		if (purchase != null){
			List<WebElement> data = WebElementUtils.getChildElements(purchase, By.className("data"));
			sText = data.get(iColumn).getText();
		}
		return sText;
	}
	
}
