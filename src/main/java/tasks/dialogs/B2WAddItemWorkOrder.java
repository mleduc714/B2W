package tasks.dialogs;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddItemWorkOrder extends B2WKendoDialog {


	public String data_bind_requestlist = "invisible: createViewModel.addWorkOrderItem.requestList.isListEmpty";
	private static Hashtable<String,WebElement> table = new Hashtable<String,WebElement>();
	//private static List<WebElement> additemsElements = new ArrayList<WebElement>();

	public boolean addItem(String sText){
		boolean bReturn = false;
		addItemsToOrder();
		WebElement el = table.get(sText);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean generateItem(String sText){
		boolean bReturn = false;
		addItemsToOrder();
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
	
	public void addRequestsToWorkOrder(){
		
		WebElement parent = WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		List<WebElement> divs = WebElementUtils.getChildElements(parent, By.tagName("div"));
		WebElement requests = WebElementUtils.getElementWithMatchingAttribute(divs, "data-bind",data_bind_requestlist);
		List<WebElement> items = WebElementUtils.getChildElements(requests, By.tagName("input"));
		for (WebElement i: items){
			System.out.println(i.getText());
			i.click();
		}
		
	}

	
	
	public boolean clickAddNewItemFromWorkOrder() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		WebElement button = WebElementUtils.getChildElement(parent,B2WMaintain.getKendoButtonNew());
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
		}
		return bReturn;
	}
	
	
	public boolean setAddItemDescription(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Description", B2WMaintain.getKendoInputTextBox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemAlternativeID(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Alternate ID", B2WMaintain.getKendoInputTextBox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		
		return bReturn;
		
	}
	
	public boolean setAddItemTypeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Type", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemPriorityFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Priority", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemProblemCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Problem Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemCompCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Component Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemSubCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Subcomponent Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemFailureCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Failure Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemActionCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Action Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean setAddItemRequestedByFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Requested By", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
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
