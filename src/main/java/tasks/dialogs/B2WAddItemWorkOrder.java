package tasks.dialogs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddItemWorkOrder extends B2WKendoDialog {
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
	
	
	private static Hashtable<String,WebElement> table = new Hashtable<String,WebElement>();
	//private static List<WebElement> additemsElements = new ArrayList<WebElement>();
	private static List<WebElement> additemsElements = new ArrayList<WebElement>();
	
	public boolean clickNewItemButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.findElement(B2WMaintain.getB2WMaintainNewWorkOrderView());
		WebElement itembutton = WebElementUtils.getChildElement(parent, B2WMaintain.getB2WMaintainNewWorkItemAddItemButton());
		if (itembutton != null){
			Coordinates coordinate = ((Locatable)itembutton).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			WebElementUtils.clickElement(itembutton);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			if (WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder()) != null){
				addItemsToOrder();
				bReturn = true;
			}else{
				additemsElements = getFormElements(B2WMaintain.getB2WMaintainAddItemToWorkOrder());
				bReturn = true;
			}
		}
		return bReturn;
	}

	public boolean addItem(String sText){
		boolean bReturn = false;
		WebElement el = table.get(sText);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean generateItem(String sText){
		boolean bReturn = false;
		WebElement el = table.get(sText);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
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
	private void addItemsToOrder() {
		
		WebElement parent = WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		List<WebElement> elements = parent.findElements(By.tagName("tbody"));
		// first body is checkbox to include
		WebElement workorderselections = elements.get(0);
		// number of tr's will tell us how many rows
		List<WebElement> requests = workorderselections.findElements(By.tagName("tr"));
		Iterator<WebElement> iterRequests = requests.iterator();
		while (iterRequests.hasNext()){
			// check checkbox webelement
			List<WebElement> td = iterRequests.next().findElements(By.tagName("td"));
			WebElement checkbox = td.get(0).findElement(By.tagName("input"));
			String sText = td.get(1).getText();
			table.put(sText, checkbox);
			// get the description text
		}
		workorderselections = elements.get(1);
		List<WebElement> maintenancePrograms = workorderselections.findElements(By.tagName("tr"));
		Iterator<WebElement> iterGenerateRequests = maintenancePrograms.iterator();
		while (iterGenerateRequests.hasNext()){
			List<WebElement> td = iterGenerateRequests.next().findElements(By.tagName("td"));
			String sText = td.get(0).getText();
			WebElement generateItem = td.get(3).findElement(By.cssSelector("*"));
			table.put(sText, generateItem);
		}
	}
	
	public boolean clickAddNewItemFromWorkOrder() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		WebElement button = WebElementUtils.getChildElement(parent,B2WMaintain.getKendoButtonNew());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
			if (bReturn){
				additemsElements  = getFormElements(B2WMaintain.getB2WMaintainAddItemToWorkOrder());
			}else{
				log.warn("Clicking on New Item button retured false");
			}
		}else{
			log.warn("Button to add new item returned null");
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
	
}
