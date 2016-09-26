package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WAddMaterials {
	public static By getMaterialsDialog() {
		return By.cssSelector(B2WUIMap.b2w_addmaterialsdialog);
	}
	public static By getAddMaterialsSearchText() {
		return By.cssSelector(B2WUIMap.b2w_addmaterialssearchtext);
	}
	public static By getAddMaterialsIDToSelect() {
		return By.cssSelector(B2WUIMap.b2w_addmaterialsidtoselect);
	}
	public static By getSelectButton() {
		return By.cssSelector(B2WUIMap.b2w_addmaterialsselectbutton);
	}
	public static By getAddButton() {
		return By.cssSelector(B2WUIMap.b2w_addmaterialsaddbutton);
	}
}
