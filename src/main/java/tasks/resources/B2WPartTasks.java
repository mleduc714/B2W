package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.resources.B2WParts;
import tasks.WebElementUtils;

public class B2WPartTasks extends B2WResourceTasks {

	public boolean setPartID(String sPartID) {
		boolean bReturn = false;

		WebElement el = WebElementUtils.findElement(B2WParts.getPartID());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sPartID);
		}
		return bReturn;

	}

	public boolean setAltPartID(String sPartID) {
		boolean bReturn = false;

		WebElement el = WebElementUtils.findElement(B2WParts.getPartAltID());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sPartID);
		}
		return bReturn;
	}

	public boolean setPartDescription(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WParts.getPartDescription());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setPartManufacter(String sManufacturer) {
		boolean bReturn = false;

		WebElement el = WebElementUtils.findElement(B2WParts.getPartManufacturer());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sManufacturer);
		}
		return bReturn;

	}

	public boolean setPartUnitCost(String sText) {
		return setTotalCost(sText);
	}

	public boolean setPartUnitMeasure(String sText) {
		return selectUnitOfMeasure(sText);
	}

	public boolean setPartCategory(String sText) {
		return setCategory(sText);
	}
	
	public boolean createNewPart() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WParts.getCreateNewPartButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WParts.getPartDescription()) != null;
		}
		return bReturn;
	}

}
