package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WEquipment extends KendoUI {


	public static By getNewEquipmentRequiredForms() {
		return By.cssSelector(B2WUIMap.b2w_newequipmentformrequired);
	}
	public static By getEquipmentListView() {
		return By.cssSelector(B2WUIMap.b2w_equipmentlistview);
	}
	public static By getEquipmentBoxContent() {
		return By.cssSelector(B2WUIMap.b2w_equipmentcontent);
	}
	public static By getEquipmentHeadline() {
		return By.cssSelector(B2WUIMap.b2w_equipmentheadline);
	}
	public static By getEquipmentItemAction() {
		return By.cssSelector(B2WUIMap.b2w_equipmentactionbuttons);
	}

}
