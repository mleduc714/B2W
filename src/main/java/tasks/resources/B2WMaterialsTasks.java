package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.setup.B2WMaterials;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

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

	public boolean setTotalCost(String sCost) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getTotalCost());
		bReturn = WebElementUtils.sendKeys(el, sCost);
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
	
	public boolean createNewMaterial() {
		clickCreateNewMaterialsButton();
		boolean bReturn = false;
		setDescription("TEST");
		this.setMaterialID("ID");
		this.setAlternateID("ALTID");
		this.selectBusinessUnit("Northern Division\\Paving");
		this.selectCategory("Asphalt");
		TaskUtils.sleep(1000);
		this.selectUnitOfMeasure("EACH");
		this.checkTemporaryMaterial(true);
		this.checkTrackableMaterial(true);
		this.setTotalCount("5");
		TaskUtils.sleep(5000);
		return false;
	}

}
