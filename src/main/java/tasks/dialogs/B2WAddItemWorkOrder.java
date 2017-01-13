package tasks.dialogs;

import java.util.ArrayList;
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
	public ArrayList<String> getRequestIDs() {

		ArrayList<String> al = new ArrayList<String>();
		Iterator<WebElement> iterRequests = getRequestWorkOrderElements();
		while (iterRequests.hasNext()) {
			List<WebElement> td = iterRequests.next().findElements(By.tagName("td"));
			String sText = td.get(0).getText().trim();
			al.add(sText);
		}
		return al;
	}
	public boolean addAllRequests(){
		boolean bReturn = false;
		ArrayList<String> al = getRequestIDs();
		Iterator<String> iter = al.iterator();
		while (iter.hasNext()){
			String sItem= iter.next();
			Iterator<WebElement> elements = getRequestWorkOrderElements();
			while (elements.hasNext()){
				List<WebElement> td  = elements.next().findElements(By.tagName("td"));
				String sText = td.get(0).getText().trim();
				if (sItem.equals(sText)){
					bReturn = true;
					WebElement checkbox = WebElementUtils.getChildElement(td.get(0), By.tagName("input"));
					if (!checkbox.isSelected()){
						bReturn &= WebElementUtils.clickElement(checkbox);
					}
					break;
				}
			}
		}
		return bReturn;
	}
	public Iterator<WebElement> getRequestWorkOrderElements () {
		//String sText = ".add-request-items"
		//WebElement parent = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		WebElement parent = getDisplayedWindow();
		List<WebElement> elements = parent.findElements(By.tagName("tbody"));
		// first body is checkbox to include
		WebElement workorderselections = elements.get(0);
		// number of tr's will tell us how many rows
		List<WebElement> requests = workorderselections.findElements(By.tagName("tr"));
		Iterator<WebElement> iterRequests = requests.iterator();
		return iterRequests;
	}
	
	public boolean selectItemsToWorkOrderExists(){
		return WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder()) != null;
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
	
	public String setAnyAddItemTypeFromDD(){
		String sText = "";
		WebElement el = getFormElement("Type", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = this.selectRandomItemFromDropDown();
		}
		
		return sText;
		
	}
	public boolean selectAddItemPriorityFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Priority", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	public boolean selectAddItemProblemCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Problem Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	
	public String selectAnyAddItemProblemCodeFromDD(){
		String sText = "";
		WebElement el = getFormElement("Problem Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		
		return sText;
		
	}
	
	public boolean selectAddItemCompCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Component Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	
	public String selectAnyAddItemCompCodeFromDD(){
		String sText = "";
		WebElement el = getFormElement("Component Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		
		return sText;
		
	}
	
	public boolean selectAddItemSubCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Subcomponent Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	
	public String selectAnyAddItemSubCodeFromDD(){
		String sText = "";
		WebElement el = getFormElement("Subcomponent Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	
	public boolean selectAddItemFailureCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Failure Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	
	public String selectAnyAddItemFailureCodeFromDD(){
		String sText = "";
		WebElement el = getFormElement("Failure Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		
		return sText;
		
	}
	public boolean selectAddItemActionCodeFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Action Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
	}
	
	public String selectAnyAddItemActionCodeFromDD() {
		String sText = "";
		WebElement el = getFormElement("Action Code", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		
		return sText;
	}
	
	public boolean selectAddItemRequestedByFromDD(String sText){
		boolean bReturn = false;
		WebElement el = getFormElement("Requested By", B2WMaintain.getKendoDropDown());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		
		return bReturn;
		
	}
	
	public String selectAnyAddItemRequestedByFromDD(){
		String sText = "";
		WebElement el = getFormElement("Requested By", B2WMaintain.getKendoDropDown());
		if (el != null){
			WebElementUtils.clickElement(el);
			sText = selectRandomItemFromDropDown();
		}
		return sText;
	}
	
	public boolean clickCreateAddItemButton() {
		boolean bReturn = false;
		WebElement parent = getDisplayedWindow();
		if (parent != null) {
			WebElement button = WebElementUtils.getChildElement(parent,
					B2WMaintain.getB2WMaintainAddItemCreateButton());
			if (button != null) {
				bReturn = WebElementUtils.clickElement(button);
				bReturn &= WebElementUtils.waitForElementInvisible(button);
			}
		}
		return bReturn;
	}
	
	public boolean clickFinishButton() {
		WebElement parent = getDisplayedWindow();
		WebElement finish = WebElementUtils.getChildElement(parent, B2WMaintain.getKendoLargeFinishButton());
		boolean bReturn = false;
		if (finish != null){
			bReturn = WebElementUtils.clickElement(finish);
			bReturn &= WebElementUtils.waitForElementInvisible(finish);
		}
		return bReturn;
	}
	
	public boolean clickGenerateItem() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		List<WebElement> elements = parent.findElements(By.tagName("tbody"));
		WebElement workorderselections = elements.get(1);
		List<WebElement> maintenancePrograms = workorderselections.findElements(By.tagName("tr"));
		Iterator<WebElement> iterGenerateRequests = maintenancePrograms.iterator();
		while (iterGenerateRequests.hasNext()){
			List<WebElement> td = iterGenerateRequests.next().findElements(By.tagName("td"));
			WebElement generateItem = td.get(3).findElement(By.cssSelector("*"));
			if (generateItem != null){
				bReturn = WebElementUtils.clickElement(generateItem);
				bReturn &= clickConfirmYes();
			}
		}
		return bReturn;
	}
	public boolean setNotes(String sText){
		return super.setNotes(sText);
	}
}
