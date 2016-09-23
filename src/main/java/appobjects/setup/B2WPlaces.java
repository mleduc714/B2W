package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WPlaces extends B2WResources {
	 
	public static By getAddMaterialsButton() {
		return By.cssSelector(B2WUIMap.b2w_newplace_addmaterialsbutton);
	}
	public static By getProducesMaterialsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_canproducematerials);
	}

	
}
