package tasks.maintain;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;

public class B2WWorkOrdersTasks extends B2WKendoTasks {
	
	public int iEquipment = 0;
	public int iRequestDesc = 1;
	public int iAltID = 2;
	public int iDueDate = 3;
	public int iPriority = 4;
	public int iPlannedWorkLocation= 5;
	public int iLaborRateClass = 6;
	
	public int iAddItemDescription = 0;
	public int iAddItemAltID = 1;
	public int iAddItemType = 2;
	public int iAddItemPriority = 3;
	public int iAddItemProblemCode = 4;
	public int iAddItemCompCode = 5;
	public int iAddItemSubCode = 6;
	public int iAddItemFailureCode = 7;
	public int iAddItemActionCode = 8;
	public int iAddItemRequestedBy = 9;
	
	
	private static List<WebElement> pageElement = new ArrayList<WebElement>();
	private static List<WebElement> additemsElements = new ArrayList<WebElement>();

	public boolean clickCreateNewWorkOrderButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainItemActions());
		WebElement button = WebElementUtils.getChildElement(el, B2WMaintain.getKendoButtonAdd());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainNewWorkOrderView()) != null;
			if (bReturn){
				pageElement = getFormElements(B2WMaintain.getB2WMaintainNewWorkOrderView());
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
	
	public boolean setWorkOrderDescription(String sText){
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
	
	public boolean setDueDate(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iDueDate);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	
	public boolean selectLaborRateClassFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iLaborRateClass);
		if (equipment != null){
			//WebElement desc = WebElementUtils.findElement(By.cssSelector("#request_create_view > div.edit-form-content > div.box-content.form > p.form-required > input[name='RequestDescription']"));
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean selectPlannedLocationDD(String sText){
		boolean bReturn = false;
		WebElement equipment = pageElement.get(iPlannedWorkLocation);
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
	
	public boolean clickNewItemButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.findElement(B2WMaintain.getB2WMaintainNewWorkOrderView());
		WebElement itembutton = WebElementUtils.getChildElement(parent, B2WMaintain.getB2WMaintainNewWorkItemAddItemButton());
		if (itembutton != null){
			Coordinates coordinate = ((Locatable)itembutton).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			WebElementUtils.clickElement(itembutton);
			if (WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddItemToWorkOrder()) != null){
				additemsElements = getFormElements(B2WMaintain.getB2WMaintainAddItemToWorkOrder());
				bReturn = true;
			}
			
		}
		return bReturn;
	}
	
	public boolean setAddItemDescription(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemDescription);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDescription());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	public boolean setAddItemAlternativeID(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemAltID);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDescription());
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
		
	}
	
	public boolean setAddItemTypeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemType);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAddItemPriorityFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemPriority);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAddItemProblemCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemProblemCode);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAddItemCompCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemCompCode);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAddItemSubCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemSubCode);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAddItemFailureCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemFailureCode);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAddItemActionCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemActionCode);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	public boolean setAddItemRequestedByFromDD(String sText){
		boolean bReturn = false;
		WebElement equipment = additemsElements.get(iAddItemRequestedBy);
		if (equipment != null){
			WebElement el = WebElementUtils.getChildElement(equipment,B2WMaintain.getKendoDropDown());
			WebElementUtils.clickElement(el);
			bReturn = selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	public boolean clickCreateAddItemButton() {
		boolean bReturn = false;
		WebElement button = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddItemCreateButton());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			bReturn &= WebElementUtils.waitForElementInvisible(button);
		}
		return bReturn;
	}
	
	public boolean selectWorkOrderByID(String sText){
		return selectItemFromView(sText, 0);
	}

	public boolean selectWorkOrderByDescription(String sText) {
		return selectItemFromView(sText, 1);
	}
	
	public boolean clickApproveButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainWorkOrderDetailView());
		if (el != null){
			WebElement approve = WebElementUtils.getChildElement(el, B2WMaintain.getKendoApproveButton());
			bReturn = WebElementUtils.clickElement(approve);
		}
		return bReturn;
	}
	
	public boolean clickCompleteButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainWorkOrderDetailView());
		if (el != null){
			WebElement approve = WebElementUtils.getChildElement(el, B2WMaintain.getKendoCompleteButton());
			bReturn = WebElementUtils.clickElement(approve);
		}
		return bReturn;
	}
	


}