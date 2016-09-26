package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.setup.B2WAddMaterials;
import tasks.WebElementUtils;

public class B2WAddMaterialsTasks {
	
	public boolean setSearchMaterialsText(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getAddMaterialsSearchText());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(B2WAddMaterials.getAddMaterialsSearchText(), sText);
		}
		return bReturn;
	}
	
	public boolean setIDToSelect(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getAddMaterialsIDToSelect());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(B2WAddMaterials.getAddMaterialsIDToSelect(), sText);
		}
		return bReturn;
	}
	
	public boolean clickSelectButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSelectButton());
		el.click();
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickAddButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getAddButton());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
		}else{
			System.out.println("Element is null");
		}
		return bReturn;
	}
	
}
