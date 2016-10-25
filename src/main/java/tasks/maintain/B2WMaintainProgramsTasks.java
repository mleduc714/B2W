package tasks.maintain;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import tasks.WebElementUtils;

public class B2WMaintainProgramsTasks extends B2WMaintainTasks {

	private final String BUSINESSUNIT = "Business Unit";
	private final String LABORRATES = "Labor Rate Class";
	private final String ADDITEM = "Add Item";
	private final String ITEMDESC = "Item Description";
	private final String INTERVALDESC = "Description";
	private final String TYPE = "Type";
	private final String PRIORITY = "Priority";
	private final String LEVEL = "Level";
	private final String METERBASED = "meter";
	private final String CALENDARBASED = "calendar";
	private final String INTERVALCAL = "intervalCalendarType";
	private final String INTERVALTYPE = "intervalType";
	private final String OCCUREVERY = "Occur every";
	private final String GENREPAIRS = "Generate repair";
	private final String WEEKSON = "Week(s) on";
	private final String databindCalendarDaily = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarDaily";
	private final String databindCalendarWeekly = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarWeekly";
	private final String databindCalendarMonthly = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarMonthly";
	private final String databindCalendarYearly = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarYearly";
	
//	public boolean createNewMaintenanceProgram() {
//		boolean bReturn = false;
//		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getKendoButton());
//		if (els.size() > 0) {
//			WebElement el = WebElementUtils.getElementWithMatchingText(els, "New Maintenance Program", true);
//			if (el != null) {
//				bReturn = WebElementUtils.clickElement(el);
//				bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoFooter(),
//						WebElementUtils.MEDIUM_TIME_OUT) != null;
//			}
//		}
//		return bReturn;
//	}
//
//	public boolean setMaintenanceProgramDescription(String sText) {
//		boolean bReturn = false;
//
//		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
//		WebElement el = WebElementUtils.getElementWithWithMatchingAttribute(els, "name", "Description");
//
//		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
//			bReturn = WebElementUtils.sendKeys(el, sText);
//		} else {
//			log.debug("Element was not available to send text to");
//		}
//
//		return bReturn;
//	}
//
//	public boolean setBusinessUnit(String sText) {
//		boolean bReturn = false;
//
//		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainBoxContent());
//		List<WebElement> items = el.findElements(By.tagName("p"));
//		Iterator<WebElement> iter = items.iterator();
//		while (iter.hasNext()) {
//			WebElement item = iter.next();
//			if (item.getText().startsWith(BUSINESSUNIT)) {
//				item.click();
//				bReturn = selectItemFromDropDown(sText);
//			}
//		}
//		return bReturn;
//	}
//
//	public boolean setLaborRateClass(String sText) {
//		boolean bReturn = false;
//
//		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainBoxContent());
//		List<WebElement> items = el.findElements(By.tagName("p"));
//		Iterator<WebElement> iter = items.iterator();
//		while (iter.hasNext()) {
//			WebElement item = iter.next();
//			if (item.getText().startsWith(LABORRATES)) {
//				item.click();
//				bReturn = selectItemFromDropDown(sText);
//			}
//		}
//		return bReturn;
//	}
//
//	public boolean clickAddItem() {
//		boolean bReturn = false;
//		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainButtonsContainer());
//		List<WebElement> items = el.findElements(By.tagName("a"));
//		Iterator<WebElement> iter = items.iterator();
//		while (iter.hasNext()) {
//			WebElement button = iter.next();
//			if (button.getText().startsWith(ADDITEM)) {
//				bReturn = WebElementUtils.clickElement(button);
//				bReturn = WebElementUtils.switchToFrame(B2WMaintain.getB2WMaintainAddItemDialog(),
//						WebElementUtils.SHORT_TIME_OUT);
//
//			}
//		}
//		return bReturn;
//	}
//
//	public boolean setAddItemDescription(String sText) {
//		boolean bReturn = false;
//		WebElement el = getItemFromAddItemDialog(ITEMDESC);
//		if (el != null) {
//			WebElement textbox = el.findElement(B2WMaintain.getKendoInputTextBox());
//			bReturn = WebElementUtils.clickElement(textbox);
//			bReturn &= WebElementUtils.sendKeys(textbox, sText);
//		}
//		return bReturn;
//	}
//
//	public boolean selectAddItemTypeFromDD(String sText) {
//		boolean bReturn = false;
//		WebElement el = getItemFromAddItemDialog(TYPE);
//		if (el != null) {
//			bReturn = WebElementUtils.clickElement(el);
//			bReturn &= selectItemFromDropDown(sText);
//		}
//		return bReturn;
//	}
//	
//	
//
//	public boolean selectAddItemPriority(String sText) {
//		boolean bReturn = false;
//		WebElement el = getItemFromAddItemDialog(PRIORITY);
//		if (el != null) {
//			bReturn = WebElementUtils.clickElement(el);
//			bReturn &= selectItemFromDropDown(sText);
//		}
//		return bReturn;
//	}
//
//	public boolean setAddItemLevel(String sText) {
//		boolean bReturn = false;
//		WebElement el = getItemFromAddItemDialog(LEVEL);
//		if (el != null) {
//			List<WebElement> els = WebElementUtils.getChildElements(el, B2WMaintain.getB2WMaintainAddItemLevel());
//			WebElementUtils.clickElement(els.get(0));
//			bReturn = WebElementUtils.sendKeys(els.get(1), sText);
//
//		}
//		return bReturn;
//	}
//
//	private WebElement getItemFromAddItemDialog(String sText) {
//		WebElement item = null;
//		WebElement dialog = getVisibleDialog();
//		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName("p"));
//		Iterator<WebElement> iterB = items.iterator();
//		while (iterB.hasNext()) {
//			WebElement temp = iterB.next();
//			if (temp.getText().startsWith(sText)) {
//				item = temp;
//			}
//		}
//		return item;
//	}
//
//	public boolean saveItem() {
//		boolean bReturn = false;
//		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddItemDialog());
//		WebElement save = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainAddItemSaveButton());
//		if (save != null) {
//			bReturn = WebElementUtils.clickElement(save);
//			bReturn &= WebElementUtils.waitForElementInvisible(el);
//		}
//		return bReturn;
//	}
//
//	public boolean clickAddInterval() {
//		boolean bReturn = false;
//		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddIntervalButton());
//		if (el != null) {
//			WebElementUtils.clickElement(B2WMaintain.getB2WMaintainAddIntervalButton());
//			bReturn = WebElementUtils.switchToFrame(B2WMaintain.getKendoWindow(), WebElementUtils.SHORT_TIME_OUT);
//		}
//
//		return bReturn;
//	}
//
//	public boolean setIntervalDescription(String sText) {
//		boolean bReturn = false;
//		WebElement el = getItemFromAddItemDialog(INTERVALDESC);
//		if (el != null) {
//			WebElement textbox = el.findElement(B2WMaintain.getKendoInputTextBox());
//			bReturn = WebElementUtils.clickElement(textbox);
//			bReturn &= WebElementUtils.sendKeys(textbox, sText);
//		}
//		return bReturn;
//	}
//
//	public boolean selectCalendarBasedInterval() {
//		return selectIntervalRadioButton(CALENDARBASED, INTERVALTYPE);
//	}
//
//	public boolean selectMeterBasedInterval() {
//		return selectIntervalRadioButton(METERBASED, INTERVALTYPE);
//	}
//
//	public boolean selectDailyBasedInterval() {
//		return selectIntervalRadioButton("0", INTERVALCAL);
//	}
//
//	public boolean selectWeeklyBasedInterval() {
//		return selectIntervalRadioButton("1", INTERVALCAL);
//	}
//
//	public boolean selectMonthlyBasedInterval() {
//		return selectIntervalRadioButton("2", INTERVALCAL);
//	}
//
//	public boolean selectYearlyBasedInterval() {
//		return selectIntervalRadioButton("3", INTERVALCAL);
//	}
//
//	private boolean selectIntervalRadioButton(String sRadioButton, String sName) {
//		boolean bReturn = false;
//		WebElement dialog = getVisibleDialog();
//		List<WebElement> inputs = WebElementUtils.getChildElements(dialog, By.tagName("input"));
//		Iterator<WebElement> iterB = inputs.iterator();
//		while (iterB.hasNext()) {
//			WebElement temp = iterB.next();
//			String sType = temp.getAttribute("type");
//			String sValue = temp.getAttribute("value");
//			String sIntervalType = temp.getAttribute("name");
//			if (sType.equals("radio") && sValue.equals(sRadioButton) && sIntervalType.equals(sName)) {
//				bReturn = WebElementUtils.clickElement(temp);
//			}
//		}
//		return bReturn;
//	}
//	
//	public boolean setIntervalOccursEvery(String sText) {
//		boolean bReturn = false;
//		WebElement el = getItemFromAddItemDialog(OCCUREVERY);
//		if (el != null) {
//			List<WebElement> els = WebElementUtils.getChildElements(el, B2WMaintain.getB2WMaintainAddItemLevel());
//			WebElementUtils.clickElement(els.get(0));
//			bReturn = WebElementUtils.sendKeys(els.get(1), sText);
//
//		}
//		return bReturn;
//	}
//	
//	public boolean setMonthlyIntervalOccursEvery(String sText){
//		boolean bReturn = true;
//		WebElement el = getMonthlyDataElement();
//		List<WebElement> wes = el.findElements(By.cssSelector("span.k-widget.k-numerictextbox"));
//		System.out.println(wes.size());
//		return bReturn;
//		
//		
//	}
//	
//	public boolean selectOccursEveryWeekOnFromDD(String sText) {
//		boolean bReturn = false;
//		WebElement top = getItemFromAddItemDialog(OCCUREVERY);
//		WebElement el = WebElementUtils.getChildElement(top, By.cssSelector("span.k-input"));
//		if (el != null) {
//			bReturn = WebElementUtils.clickElement(el);
//			bReturn &= selectItemFromDropDown(sText);
//		}
//		return bReturn;
//	}
//	
//
//	private WebElement getMonthlyDataElement() {
//		return getProgramIntervalType(databindCalendarMonthly);
//	}
//	
//	private WebElement getYearlyDataElement() {
//		return getProgramIntervalType(databindCalendarYearly);
//		
//	}
//	
//	private WebElement getProgramIntervalType(String sDataInterval) {
//
//		WebElement item = null;
//		WebElement dialog = getVisibleDialog();
//		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName("div"));
//		Iterator<WebElement> iterB = items.iterator();
//		while (iterB.hasNext()){
//			WebElement el = iterB.next();
//			String sData = el.getAttribute("data");
//			System.out.println(sData);
//		}
//		return item;
//	
//	
//		
//	}
//	
//	
//	private WebElement getVisibleDialog() {
//
//		WebElement dialog = null;
//		List<WebElement> dialogs = WebElementUtils.findElements(B2WMaintain.getB2WMaintainAddItemDialogContent());
//		Iterator<WebElement> iterA = dialogs.iterator();
//		while (iterA.hasNext()) {
//			WebElement temp = iterA.next();
//			System.out.println(temp.isDisplayed());
//			if (temp.isDisplayed()) {
//				dialog = temp;
//				break;
//			}
//		}
//		return dialog;
//	}
	
}
