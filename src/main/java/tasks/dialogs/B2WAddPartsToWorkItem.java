package tasks.dialogs;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddPartsToWorkItem extends B2WKendoDialog {

	public boolean selectPartToAddToWorkItemByDescription(String sPart){
		
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			if (WebElementUtils.waitForElementStale(grid, 1)){
				grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			}
			Iterator<WebElement> itr = getChildElementsFromGrid(grid);
			while (itr.hasNext()){
				WebElement item = itr.next();
				List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
				String sText = gridcontent.get(1).getText();
				if (sText.equals("")){
					Coordinates coordinate = ((Locatable)item).getCoordinates(); 
					coordinate.onPage(); 
					coordinate.inViewPort();
				}
				sText = gridcontent.get(1).getText();
				if (sText.startsWith(sPart)){
					bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(gridcontent.get(0),By.tagName("input")));
					break;
				}
			}
		}
		return bReturn;
	}
	
	public boolean clickSaveAddPart() {
		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement buttoncontainer = WebElementUtils.getChildElement(window, B2WEquipment.getKendoButtonContainer());
			WebElement savebutton = buttoncontainer.findElement(B2WEquipment.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(savebutton);
			bReturn &= WebElementUtils.waitForElementInvisible(window);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	

	
}
