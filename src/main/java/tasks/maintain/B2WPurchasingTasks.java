package tasks.maintain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;

public class B2WPurchasingTasks extends B2WKendoTasks {
	
	public void getParts(){
		
	}
	public void getPartVendor(String sPart){
		
	}
	public void getPartCategory(String sPart){
		
	}
	public void getPartOrderQty(String sPart){
		
	}
	public void getPartRecdQty(String sPart){
		
	}
	public void getPartRemainingQty(String sPart){
		
	}
	public void getPartItemStatus(String sPart){
		
	}
	public void getPartTaxable(String sPart){
		
	}
	public void getPartPrice(String sPart){
		
	}
	public void getPartExtendedPrice(String sPart){
		
	}
	public void deletePart(String sPart){
		
	}
	public void editPart(String sPart){
		
	}
	
	public boolean clickAddPart() {
		boolean bReturn = false;
		WebElement el = getButton("Add Part");
		if (el != null){
			WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public void clickAddCustomPart() {
		
	}
	
	public void getSubtotal(){
		
	}
	
	public void getFreight() {
		
	}
	public void getTax() {
		
	}
	public void getTotal() {
		
	}
	public void getPODueDate() {
		
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

}
