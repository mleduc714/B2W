package tasks.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddEquipmentToMainProgram extends B2WKendoDialog {

	public boolean selectEquipmentByDescription(String sDescription){
		return selectFromDialog(sDescription, 2);
	}
	public boolean selectEquipmentByID(String sID){
		return selectFromDialog(sID, 1);
	}
	public String selectAnyEquipment(){
		return selectAnyItemFromDialog();
	}
	
	public boolean clickFinishAddEquipment() {


		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement window = getDisplayedWindow();
		if (window != null){
		
			WebElement finishbutton = WebElementUtils.findElement(By.id("FinishButton"));
			bReturn = WebElementUtils.clickElement(finishbutton);
			WebElementUtils.waitForElementInvisible(finishbutton);
		}
		return bReturn;
	
	}
}
