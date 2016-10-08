package tasks.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WAddLaborTypes;
import appobjects.resources.B2WEmployees;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddLaborTypeTasks {
	
	public boolean setSearchText(String sText){
		WebElement el = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborTypeSearchText());
		return WebElementUtils.sendKeys(el, sText);
	}

	public boolean clickSearchButton() {
		int iCurrentCount = getNumberOfLaborTypesInView();
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborTypeSearchButton());

		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForTheNumberOfItemsInDialogToChange(iCurrentCount);
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
	
	public int getNumberOfLaborTypesInView() {
		int iCount = 0;
		WebElement el = WebElementUtils.findElement(B2WAddLaborTypes.getAddLaborGridHeader());
		iCount = el.findElements(B2WAddLaborTypes.getAddLaborNameCheckBox()).size();
		return iCount;
	}

	private boolean waitForTheNumberOfItemsInDialogToChange(int iCurrentCount) {
		boolean bReturn = false;
		int iWait = 0;
		int iItems = getNumberOfLaborTypesInView();
		while ((iCurrentCount == iItems) && (iWait < 20)){
			TaskUtils.sleep(100);
			iItems = getNumberOfLaborTypesInView();
			iWait++;
		}
		if (iWait < 20){
			bReturn = true;
		}
		iCurrentCount = iItems;
		return bReturn;
	}

}
