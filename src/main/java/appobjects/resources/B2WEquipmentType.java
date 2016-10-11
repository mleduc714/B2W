package appobjects.resources;

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
	public static By getNewEquipmentTypeTransportsMaterialsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_newequipmenttypetransportscb);
	}
	public static By getNewEquipmentTypeCategoryDropDown() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentcategory);
	}
	public static By getNewEquipmentCapacityList(){
		return By.cssSelector(B2WUIMap.b2w_newequipmentcapacitygrid);
	}
	public static By getNewEquipmentTypeTransportsMaterialsText() {
		return By.cssSelector(B2WUIMap.b2w_newequipmenttypetransportmaterialtext);
	}
	
}
