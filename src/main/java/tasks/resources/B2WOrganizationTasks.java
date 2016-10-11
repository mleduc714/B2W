package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.resources.B2WOrganization;
import tasks.WebElementUtils;

public class B2WOrganizationTasks extends B2WResourceTasks {


	public boolean createNewOrganization() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WOrganization.getB2WCreateNewOrganizationButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WOrganization.getB2WOrganizationzipcode()) != null;
		}
		return bReturn;
	}
	
	public boolean setCompanyName(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationcompanyname());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyID(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationorganizationid());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyAltID(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationaltid());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyAddress1(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationaddress1());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyAddress2(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationaddress2());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyCity(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationcity());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyZip(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationzipcode());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyPhone(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationphone());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyState(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationstate());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setCompanyCountry(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationcountry());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setOrganizationPaymentTerms(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationpaymentterms());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setOrganizationTypeCustomer(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationcustomerchkbox());
		return checkBox(el, bCheck);
	}
	public boolean setOrganizationTypeSubContractor(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationsubcntrchkbox());
		return checkBox(el, bCheck);
	}	
	public boolean setOrganizationTypeTruckingSubcontractor(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationtrucksubchkbox());
		return checkBox(el, bCheck);
	}
	public boolean setOrganizationTypeVendor(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationvendorchkbox());
		return checkBox(el, bCheck);
	}
	public boolean setOrganizationTypePartsVendor(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationpartvendorchkbox());
		return checkBox(el, bCheck);
	}
	public boolean setOrganizationTypeExternalShop(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationexternalshopchkbox());
		return checkBox(el, bCheck);
	}
	public boolean setOrganizationTypeOwned(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationownedchkbox());
		return checkBox(el, bCheck);
	}
	public boolean setOrganizationProvidesEquipment(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationprovidesequipchkbox());
		return checkBox(el, bCheck);
	}
}
