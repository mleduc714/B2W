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

	public static By getMaterialsID() {
		return By.cssSelector(B2WUIMap.b2w_accountmaterialsid);
	}
	public static By getMaterialsAltID() {
		return By.cssSelector(B2WUIMap.b2w_accountmaterialaltid);
	}
	
	public static By getMaterialsDescriptionLabel() {
		return By.cssSelector(B2WUIMap.b2w_materialsdesclabel);
	}
	public static By getMaterialsIDLabel() {
		return By.cssSelector(B2WUIMap.b2w_materialidlabel);
	}
	public static By getMaterialUnitOfMeasureLabel() {
		return By.cssSelector(B2WUIMap.b2w_materialunitofmeasurelabel);
	}
	public static By getMaterialTempMaterialText() {
		return By.cssSelector(B2WUIMap.b2w_materialtempmaterialtext);
	}
	public static By getMaterialTrackableText() {
		return By.cssSelector(B2WUIMap.b2w_materialtrackabletext);
	}
	public static By getMaterialNumberOfText() {
		return By.cssSelector(B2WUIMap.b2w_materialnumberoflabel);
	}
	public static By getUnitOfMeasureLabel() {
		return By.cssSelector(B2WUIMap.b2w_materialsunitofmeasurelabel);
	}

}
