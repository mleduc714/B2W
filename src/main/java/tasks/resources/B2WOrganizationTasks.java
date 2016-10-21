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
		return checkBox(B2WOrganization.getB2WOrganizationcustomerchkbox(), bCheck);
	}
	public boolean setOrganizationTypeSubContractor(boolean bCheck){
		return checkBox(B2WOrganization.getB2WOrganizationsubcntrchkbox(), bCheck);
	}	
	public boolean setOrganizationTypeTruckingSubcontractor(boolean bCheck){
		return checkBox(B2WOrganization.getB2WOrganizationtrucksubchkbox(), bCheck);
	}
	public boolean setOrganizationTypeVendor(boolean bCheck){
		return checkBox(B2WOrganization.getB2WOrganizationvendorchkbox(), bCheck);
	}
	public boolean setOrganizationTypePartsVendor(boolean bCheck){
		return checkBox(B2WOrganization.getB2WOrganizationpartvendorchkbox(), bCheck);
	}
	public boolean setOrganizationTypeExternalShop(boolean bCheck){
		return checkBox(B2WOrganization.getB2WOrganizationexternalshopchkbox(), bCheck);
	}
	public boolean setOrganizationTypeOwned(boolean bCheck){
		return checkBox(B2WOrganization.getB2WOrganizationownedchkbox(), bCheck);
	}
	public boolean setOrganizationProvidesEquipment(boolean bCheck){
		return checkBox(B2WOrganization.getB2WOrganizationprovidesequipchkbox(), bCheck);
	}
	public String getCompanyName() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationcompanynametext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getCompanyID() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationorganizationidtext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getCompanyAltID() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationaltidtext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getCompanyAddress() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationaddress1text());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	
	public String getCompanyCity() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationcitytext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getCompanyZip() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationzipcodetext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getCompanyPhone() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationphonetext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getCompanyState() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationstatetext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getCompanyCountry() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationcountrytext());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getOrganizationPaymentTerms() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrganizationpaymenttermsText());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getOrganizationType() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WOrganization.getB2WOrgainzationTypeText());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
}
