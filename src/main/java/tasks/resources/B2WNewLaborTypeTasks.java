package tasks.resources;

import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.resources.B2WLaborType;
import appobjects.resources.B2WResources;
import appobjects.setup.B2WSetup;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

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
	public boolean searchAndOpenLaborTypeByName(String sLaborTypeID) {
		boolean bReturn = false;
		WebElement searchText = WebElementUtils.waitAndFindDisplayedElement(B2WLaborType.getResourcesSearchText());

		if (searchText != null){
			WebElementUtils.sendKeys(searchText, sLaborTypeID);
			WebElementUtils.clickElement(B2WSetup.getB2WSearchButton());
			TaskUtils.sleep(1000);
			List<WebElement> list = WebElementUtils.findElements(B2WLaborType.getLaborTypeViewGridID());
			if (!list.isEmpty()){
				WebElement el = WebElementUtils.getElementWithMatchingText(list, sLaborTypeID, false);
				if (el!=null){
					if (WebElementUtils.clickElement(el)){
						bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WResources.getNameTextLabel()) != null;
					}
				}
			}
	
		}
		return bReturn;
	}
	
	
}
