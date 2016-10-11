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
	public static By getEquipmentListView() {
		return By.cssSelector(B2WUIMap.b2w_equipmentlistview);
	}
	public static By getEquipmentFilterByDD() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentfilterbydd);
	}
	public static By getEquipmentGridContent() {
		return By.cssSelector(B2WUIMap.b2w_equipmentgridcontent);
	}
	public static By getEquipmentItems() {
		return By.cssSelector(B2WUIMap.b2w_equipmentitems);
	}
	public static By getEquipmentBoxContent() {
		return By.cssSelector(B2WUIMap.b2w_equipmentcontent);
	}
	public static By getEquipmentHeadersFromView() {
		return By.cssSelector(B2WUIMap.b2w_equipmentheaders);
	}
	public static By getEquipmentHeadline() {
		return By.cssSelector(B2WUIMap.b2w_equipmentheadline);
	}
	public static By getEquipmentItemAction() {
		return By.cssSelector(B2WUIMap.b2w_equipmentactionbuttons);
	}
	public static By getEquipmentPageLoading() {
		return By.cssSelector(B2WUIMap.b2w_equipmentloadpage);
	}
}
