package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WMaterials extends B2WResources {
	
	public static By getTempMaterialCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfotempmaterialcheckbox);
	}
	public static By getTrackableMaterialCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfotrackablematerialcheckbox);
	}
	public static By getCreateNewMaterialsButton() {
		return By.cssSelector(B2WUIMap.b2w_setup_createnewmaterial);
	}
	public static By getTotalCount() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfototalcount);
	}
	public static By getTotalCost() {
		return By.cssSelector(B2WUIMap.b2w_accountgeninfototalcost);
	}
	public static By getMaterialsID() {
		return By.cssSelector(B2WUIMap.b2w_accountmaterialsid);
	}
	public static By getMaterialsAltID() {
		return By.cssSelector(B2WUIMap.b2w_accountmaterialaltid);
	}
}
