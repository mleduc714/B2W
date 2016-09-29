package tasks.resources;

import org.openqa.selenium.WebElement;

import appobjects.setup.B2WLaborType;
import tasks.WebElementUtils;

public class B2WNewLaborTypeTasks extends B2WResourceTasks {
	
	public boolean createNewLaborType() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WLaborType.getCreateLabelTypeButton())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WLaborType.getLaborName()) != null;
		}
		return bReturn;
	}

	public boolean setLaborType(String sLaborName) {
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WLaborType.getLaborName());
		return WebElementUtils.sendKeys(el, sLaborName);
	}
	
	public boolean setLaborID(String sLaborID){
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WLaborType.getLaborID());
		return WebElementUtils.sendKeys(el, sLaborID);
	}
	
	
}
