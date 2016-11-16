package tasks.dialogs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddMaintenanceReqToWorkOrder extends B2WKendoDialog {

	private static Hashtable<String, WebElement> table = new Hashtable<String, WebElement>();
	// private static List<WebElement> additemsElements = new
	// ArrayList<WebElement>();
	private static List<WebElement> additemsElements = new ArrayList<WebElement>();

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

	private void addItemsToOrder() {

		WebElement parent = WebElementUtils.waitAndFindElement(B2WMaintain.getB2WMaintainSelectItemsToWorkOrder());
		List<WebElement> elements = parent.findElements(By.tagName("tbody"));
		// first body is checkbox to include
		WebElement workorderselections = elements.get(0);
		// number of tr's will tell us how many rows
		List<WebElement> requests = workorderselections.findElements(By.tagName("tr"));
		Iterator<WebElement> iterRequests = requests.iterator();
		while (iterRequests.hasNext()) {
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
		while (iterGenerateRequests.hasNext()) {
			List<WebElement> td = iterGenerateRequests.next().findElements(By.tagName("td"));
			String sText = td.get(0).getText();
			WebElement generateItem = td.get(3).findElement(By.cssSelector("*"));
			table.put(sText, generateItem);
		}
	}

}
