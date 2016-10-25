package tasks.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WAddLaborTypes;
import appobjects.resources.B2WEmployees;
import tasks.WebElementUtils;

public class B2WAddLaborTypeTasks {
	
	public boolean setSearchText(String sText){
		WebElement el = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborTypeSearchText());
		return WebElementUtils.sendKeys(el, sText);
	}

	public boolean clickSearchButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddLaborTypes.getAddLaborGridHeader());
		WebElement search = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborTypeSearchButton());
		if (search != null) {
			bReturn = WebElementUtils.clickElement(search);
			bReturn &= WebElementUtils.waitForElementStale(el, WebElementUtils.SHORT_TIME_OUT);
		}
		return bReturn;
	}

	public boolean clickAddButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborTypeAddButton());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
			WebElementUtils.switchToFrame(B2WEmployees.getEmployeeFirstName(), WebElementUtils.SHORT_TIME_OUT);
		}
		return bReturn;
	}
	
	public boolean clickClearSearchButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborTypeClearSearchButton());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	
	public boolean selectCheckBox(String sText){
		boolean bReturn = false;
		WebElement gridHeader = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborGridHeader());
		List<WebElement> gridText = gridHeader.findElements(B2WAddLaborTypes.getAddLaborNameText());
		for (int i = 0; i < gridText.size()-1; i++){
			if (gridText.get(i).getText().equals(sText)){
				WebElement parentElement = gridText.get(i).findElement(By.xpath("./.."));
				WebElement el = parentElement.findElement(B2WAddLaborTypes.getAddLaborNameCheckBoxFromGridView());
				bReturn = WebElementUtils.clickElement(el);
				break;
			}
		}
		return bReturn;
	}

	

}
