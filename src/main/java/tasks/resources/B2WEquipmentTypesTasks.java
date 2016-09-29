package tasks.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WEquipmentType;
import tasks.WebElementUtils;

public class B2WEquipmentTypesTasks extends B2WResourceTasks {

	public boolean createNewEquipmentTypeButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WEquipmentType.getNewEquipmentTypeButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WEquipmentType.getNewEquipmentTypeName()) != null;
		}
		return bReturn;
	}
	
	public boolean selectEquipmentCategory(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WEquipmentType.getNewEquipmentCategoryDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}
	
	public boolean setEquipmentType(String sText){
		WebElement el = WebElementUtils.findElement(B2WEquipmentType.getNewEquipmentTypeName());
		return WebElementUtils.sendKeys(el, sText);
	}
	
	public boolean setEquipmentTypeID(String sText){
		WebElement el = WebElementUtils.findElement(B2WEquipmentType.getNewEquipmentTypeID());
		return WebElementUtils.sendKeys(el, sText);
	}
	
	public boolean setEquipmentTypeTransportsMaterials(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WEquipmentType.getNewEquipmentTransportsMaterialsCheckBox());
		return checkBox(el, bCheck);
	}
	
}
