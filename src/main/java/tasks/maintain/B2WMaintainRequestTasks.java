package tasks.maintain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;



public class B2WMaintainRequestTasks extends B2WKendoTasks {
	
	public int iEquipment = 0;
	public int iRequestDesc = 1;
	public int iAltID = 2;
	public int iType = 3;
	public int iProblemCode = 4;
	public int iRequestedBy = 5;
	public int iPriority = 6;
	
	private static List<WebElement> pageElement = new ArrayList<WebElement>();

	public boolean clickCreateNewRequestButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainItemActions());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoButtonAdd());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainRequestCreateView()) != null;
			if (bReturn){
				getFormElements(B2WMaintain.getB2WMaintainRequestCreateView());
			}
		}
		
		return bReturn;
	}
	
	

	public boolean selectEquipment(String sText) {
		boolean bReturn = false;
		TaskUtils.sleep(1000);
		WebElement equipment = pageElement.get(iEquipment);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment, B2WMaintain.getKendoDropDown());
			bReturn = sendTextAndSelectValueFromKendoFDD(el, sText);
		}
		
		return bReturn;
		
	}
	
	public boolean setRequestDescription(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iRequestDesc);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDescription());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setAlternativeID(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iAltID);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDescription());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean selectTypeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iType);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
		
	}
	
	public boolean selectProblemCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iProblemCode);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectRequestedByFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iRequestedBy);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectPriorityFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iPriority);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
//	public boolean setNotes(String sText){
//		WebElementUtils.switchToFrame(By.cssSelector("iframe.k-content"), 1);
//		WebElement el = WebElementUtils.findElement(By.cssSelector("html body br.k-br"));
//		el.click();
//		return false;
//	}
	
	public boolean clickNewCommentButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.findElement(B2WMaintain.getB2WMaintainRequestCreateView());
		WebElement comment = WebElementUtils.getChildElement(parent, B2WMaintain.getB2WNewMaintanceRequestNewCommentButton());
		if (comment != null){
			Coordinates coordinate = ((Locatable)comment).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			WebElementUtils.clickElement(comment);
			//WebElementUtils.waitAndFindDisplayedElement(By.cssSelector("textarea.comments")) != null;
		}
		return bReturn;
	}
	
	public boolean setNewCommentAndSave(String sText){
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(By.cssSelector("textarea.comments"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			if (el.isDisplayed()){
				bReturn = WebElementUtils.sendKeys(el, sText);
				WebElement parent = WebElementUtils.getParentElement(el);
				WebElement save = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoLargeSaveButton());
				bReturn = WebElementUtils.clickElement(save);
				bReturn &= WebElementUtils.waitForElementInvisible(save);
			}
		}
		return bReturn;
	}
	
	public boolean clickSaveButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getKendoLargeSaveButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForPageNotBusy();
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainItemActions()) != null;
		}
		return bReturn;
	}
	
	public boolean selectRequestByDescription(String sDesc){
		return selectItemFromView(sDesc, 1);
	}
	
	
}