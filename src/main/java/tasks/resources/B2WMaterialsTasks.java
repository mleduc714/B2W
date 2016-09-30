package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.resources.B2WMaterials;
import tasks.WebElementUtils;

public class B2WMaterialsTasks extends B2WResourceTasks {

	public boolean clickCreateNewMaterialsButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WMaterials.getCreateNewMaterialsButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getAccountDescription()) != null;
		}
		return bReturn;
	}

	public boolean checkTemporaryMaterial(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WMaterials.getTempMaterialCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean checkTrackableMaterial(boolean bCheck) {
		WebElement el = WebElementUtils.waitAndFindElement(B2WMaterials.getTrackableMaterialCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setTotalCount(String iCount) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindElement(B2WMaterials.getTotalCount());
		bReturn = WebElementUtils.sendKeys(el, iCount);
		return bReturn;
	}


	
	public boolean setMaterialID(String sID){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialsID());
		bReturn = WebElementUtils.sendKeys(el, sID);
		return bReturn;
	}
	
	public boolean setMaterialAltID(String sID){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialsAltID());
		bReturn = WebElementUtils.sendKeys(el, sID);
		return bReturn;
	}

	
	public String getMaterialDescriptionText() {
		String sText = "";
		WebElement el =  WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialsDescriptionLabel());
		if (el!=null){
			sText = el.getText();
		}
		return sText;
	}
	
	public String getMaterialIDText() {
		String sText = "";
		WebElement el =  WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialsIDLabel());
		if (el!=null){
			sText = el.getText();
		}
		return sText;
	}
	
	public String getMaterialUnitOfMeasureText() {
		String sText = "";
		sText = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialUnitOfMeasureLabel()).getText();
		return sText;
	}
	
	public String getMaterialTempMaterialText() {
		String sText = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialTempMaterialText());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getMaterialUnitCost() {
		String sText = "";
		sText = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getUnitCostLabel()).getText();
		return sText;
	}

	public String getMaterialTrackableText() {
		String sText = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialTrackableText());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	
	public String getMaterialTotalCountText() {
		String sText = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getMaterialNumberOfText());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	
	public String getAccountUnitofMeasureText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WMaterials.getUnitOfMeasureLabel());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	
	
	
	//public boolean createNewMaterial() {
//		clickCreateNewMaterialsButton();
//		boolean bReturn = false;
//		setDescription("TEST");
//		this.setMaterialID("ID");
//		this.setAlternateID("ALTID");
//		this.selectBusinessUnit("Northern Division\\Paving");
//		this.selectCategory("Asphalt");
//		TaskUtils.sleep(1000);
//		this.selectUnitOfMeasure("EACH");
//		this.checkTemporaryMaterial(true);
//		this.checkTrackableMaterial(true);
//		this.setTotalCount("5");
//		TaskUtils.sleep(5000);
//		return false;
	

}
