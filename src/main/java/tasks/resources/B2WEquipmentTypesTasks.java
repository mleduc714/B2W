package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.resources.B2WEquipmentType;
import tasks.WebElementUtils;

public class B2WEquipmentTypesTasks extends B2WResourceTasks {

	public boolean createNewEquipmentTypeButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WEquipmentType.getNewEquipmentTypeButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WEquipmentType.getNewEquipmentTypeName()) != null;
		}
		return bReturn;
	}
	
	public boolean selectEquipmentTypeCategory(String sText) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WEquipmentType.getNewEquipmentTypeCategoryDropDown(), sText);
	}
	
	public boolean setEquipmentTypeName(String sText){
		WebElement el = WebElementUtils.findElement(B2WEquipmentType.getNewEquipmentTypeName());
		return WebElementUtils.sendKeys(el, sText);
	}
	
	public boolean setEquipmentTypeID(String sText){
		WebElement el = WebElementUtils.findElement(B2WEquipmentType.getNewEquipmentTypeID());
		return WebElementUtils.sendKeys(el, sText);
	}
	
	public boolean setEquipmentTypeTransportsMaterials(boolean bCheck){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WEquipmentType.getNewEquipmentTypeTransportsMaterialsCheckBox());
		checkBox(el, bCheck);
		if (bCheck){
			WebElement list = WebElementUtils.waitAndFindDisplayedElement(B2WEquipmentType.getNewEquipmentCapacityList());
			if (list != null){
				bReturn = true;
			}
		}else{
			bReturn = true;
		}
		return bReturn;
	}
	
	public boolean setEquipmentTypeBusinessUnit(String sCategory) {
		return selectBusinessUnit(sCategory);
	}
	
}
