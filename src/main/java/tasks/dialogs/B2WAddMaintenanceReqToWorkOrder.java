package tasks.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddMaintenanceReqToWorkOrder extends B2WKendoDialog {

	//private static Hashtable<String, WebElement> table = new Hashtable<String, WebElement>();
	// private static List<WebElement> additemsElements = new
	// ArrayList<WebElement>();

	public boolean selectCreateNewWorkOrderRadioButton() {
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.getChildElements(getDialog(), By.tagName("input"));
		List<WebElement> radiobuttons = WebElementUtils.getElementsWithWithMatchingAttribute(list, "type", "radio");
		bReturn = WebElementUtils.clickElement(radiobuttons.get(0));
		return bReturn;

	}

	public boolean selectAddToExistingWorkOrderRadioButton() {
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.getChildElements(getDialog(), By.tagName("input"));
		List<WebElement> radiobuttons = WebElementUtils.getElementsWithWithMatchingAttribute(list, "type", "radio");
		bReturn = WebElementUtils.clickElement(radiobuttons.get(1));
		return bReturn;

	}

	private WebElement getDialog() {
		return WebElementUtils.findElement(B2WMaintain.getB2WMaintainRequestAddToWorkOrderDialog());
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
	
	public int getNumberOfRequestsToAddToWorkOrder() {
		return getRequestIDs().size();
	}
	

	public boolean clickNextButton() {
		boolean bReturn = false;
		if (clickNext()){
			
			bReturn = true;
		}
		return bReturn;
	}
	
	public boolean clickFinishButton() {
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());

		boolean bReturn = false;
		if (clickFinish()){
			bReturn = WebElementUtils.waitForElementInvisible(parent);
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			bReturn &= WebElementUtils.waitAndFindDisplayedElements(B2WMaintain.getB2WMaintainBoxContent()) != null;
		}
		return bReturn;
	}
	
	public Iterator<WebElement> getRequestWorkOrderElements () {
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		List<WebElement> elements = parent.findElements(By.tagName("tbody"));
		// first body is checkbox to include
		WebElement workorderselections = elements.get(0);
		// number of tr's will tell us how many rows
		List<WebElement> requests = workorderselections.findElements(By.tagName("tr"));
		Iterator<WebElement> iterRequests = requests.iterator();
		return iterRequests;
	}
	

}
