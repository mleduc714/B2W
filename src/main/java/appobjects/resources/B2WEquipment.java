package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WEquipment {

	public static By getEquipmentDescription() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentdescription);
	}
	public static By getNewEquipmentButton() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentbutton);
	}
	public static By getNewEquipmentRequiredForms() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentformrequired);
	}
	public static By getNewEquipmentDropDownItem() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentselectfromdropdown);
	}
	public static By getNewEquipmentNameValuePair() {
		return By.cssSelector(B2WUIMap.b2w_newequiopmentnamevaluepair);
	}
	public static By getNewEquipmentDropDown(){
		return By.cssSelector(B2WUIMap.b2w_newequipmentdropdown);
	}
	public static By getNewEquipmentLists() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentlistofitemsfromdd);
	}
	public static By getNewEquipmentFooter() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentformfooter);
	}
	public static By getNewEquipmentSaveButton() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentsavebutton);
	}
	
}
