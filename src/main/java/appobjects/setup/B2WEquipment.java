package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WEquipment {

	public static By getEquipmentDescription() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentdescription);
	}
	
	public static By getNewEquipmentButton() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentbutton);
	}
	
	public static By getNewEquipmentTypeButton() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentbusinessunit);
	}
	
	public static By getNewEquipmentRequiredForms() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentformrequired);
	}
	
	public static By getNewEquipmentDropDownItem() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentselectfromdropdown);
	}
}
