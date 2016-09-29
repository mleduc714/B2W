package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WEquipmentType {
	
	public static By getNewEquipmentTypeButton() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentypebutton);
	}
	
	public static By getNewEquipmentTypeName() {
		return By.cssSelector(B2WUIMap.b2w_generalinfoname);
	}
	
	public static By getNewEquipmentTypeID() {
		return By.cssSelector(B2WUIMap.b2w_newequipmenttypeid);
	}
	public static By getNewEquipmentTransportsMaterialsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_newequipmenttypetransportscb);
	}
	public static By getNewEquipmentCategoryDropDown() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentcategory);
	}
	
}
