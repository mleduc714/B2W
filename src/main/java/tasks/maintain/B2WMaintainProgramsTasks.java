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
	//private final String GENREPAIRS = "Generate repair";
	//private final String WEEKSON = "Week(s) on";
	private final String MONTHLYVALUE = "dayOfWeek";
	private final String MONTHLYNAME = "monthlyType";
	private final String PLANNEDCALDATE = "Planned Calendar Date";
	private final String PLANNEDCOMPREADING = "Planned Completion Reading";
	private final String ACTUALCALDATE = "Actual Calendar Date";
	private final String ACTUALCOMPREADING = "Actual Completion Reading";
	
	//private final String databindCalendarDaily = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarDaily";
	//private final String databindCalendarWeekly = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarWeekly";
	private final String databindCalendarMonthly = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarMonthly";
	private final String databindCalendarYearly = "visible: programIntervalEditableViewModel.isIntervalTypeCalendarYearly";
	private final String databindTypeMeterBasedinvisible = "invisible: programIntervalEditableViewModel.isIntervalTypeMeterBased";
	private final String databindTypeMeterBasedvisible = "visible: programIntervalEditableViewModel.isIntervalTypeMeterBased";
	private final String GENERALREPAIRREQUESTS = "Generate repair requests for this item";
	//private final String SCHEDULEOCCURANCES = "Schedule the subsequent occurrences";
	
	public boolean createNewMaintenanceProgram() {
		boolean bReturn = false;
		List<WebElement> els = WebElementUtils.findElements(B2WEquipment.getKendoButton());
		if (els.size() > 0) {
			WebElement el = WebElementUtils.getElementWithMatchingText(els, "New Maintenance Program", true);
			if (el != null) {
				bReturn = WebElementUtils.clickElement(el);
				bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoFooter(),
						WebElementUtils.MEDIUM_TIME_OUT) != null;
			}
		}
		return bReturn;
	}

	public boolean setMaintenanceProgramDescription(String sText) {
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithWithMatchingAttribute(els, "name", "Description");

		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		} else {
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}

	public boolean setBusinessUnit(String sText) {
		boolean bReturn = false;

		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainBoxContent());
		List<WebElement> items = el.findElements(By.tagName("p"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.getText().startsWith(BUSINESSUNIT)) {
				item.click();
				bReturn = selectItemFromDropDown(sText);
				break;
			}
		}
		return bReturn;
	}

	public boolean selectLaborRateClass(String sText) {
		boolean bReturn = false;

		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainBoxContent());
		List<WebElement> items = el.findElements(By.tagName("p"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.getText().startsWith(LABORRATES)) {
				WebElementUtils.clickElement(WebElementUtils.getChildElement(item,B2WMaintain.getKendoDropDownForTMTab()));
				bReturn = selectItemFromDropDown(sText);
				break;
			}
		}
		return bReturn;
	}

	public boolean clickAddItem() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainButtonsContainer());
		List<WebElement> items = el.findElements(By.tagName("a"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement button = iter.next();
			if (button.getText().startsWith(ADDITEM)) {
				bReturn = WebElementUtils.clickElement(button);
				WebElementUtils.switchToFrame(B2WMaintain.getB2WMaintainAddItemDialog(),
						WebElementUtils.SHORT_TIME_OUT);

			}
		}
		return bReturn;
	}

	public boolean setAddItemDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(ITEMDESC);
		if (el != null) {
			WebElement textbox = el.findElement(B2WMaintain.getKendoInputTextBox());
			bReturn = WebElementUtils.clickElement(textbox);
			bReturn &= WebElementUtils.sendKeys(textbox, sText);
		}
		return bReturn;
	}

	public boolean selectAddItemTypeFromDD(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(TYPE);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	

	public boolean selectAddItemPriority(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(PRIORITY);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean setAddItemLevel(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(LEVEL);
		if (el != null) {
			List<WebElement> els = WebElementUtils.getChildElements(el, B2WMaintain.getB2WMaintainAddItemLevel());
			WebElementUtils.clickElement(els.get(0));
			bReturn = WebElementUtils.sendKeys(els.get(1), sText);

		}
		return bReturn;
	}

	private WebElement getItemFromAddItemDialog(String sText) {
		WebElement item = null;
		WebElement dialog = getVisibleDialog();
		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName("p"));
		Iterator<WebElement> iterB = items.iterator();
		while (iterB.hasNext()) {
			WebElement temp = iterB.next();
			if (temp.getText().startsWith(sText)) {
				item = temp;
			}
		}
		return item;
	}

	public boolean saveItem() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddItemDialog());
		WebElement save = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainAddItemSaveButton());
		if (save != null) {
			bReturn = WebElementUtils.clickElement(save);
			bReturn &= WebElementUtils.waitForElementInvisible(save);
		}
		return bReturn;
	}

	public boolean clickAddInterval() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddIntervalButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(B2WMaintain.getB2WMaintainAddIntervalButton());
			WebElementUtils.switchToFrame(B2WMaintain.getKendoWindow(), WebElementUtils.SHORT_TIME_OUT);
		}

		return bReturn;
	}

	public boolean setIntervalDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(INTERVALDESC);
		if (el != null) {
			WebElement textbox = el.findElement(B2WMaintain.getKendoInputTextBox());
			bReturn = WebElementUtils.clickElement(textbox);
			bReturn &= WebElementUtils.sendKeys(textbox, sText);
		}
		return bReturn;
	}

	public boolean selectCalendarBasedInterval() {
		return selectIntervalRadioButton(CALENDARBASED, INTERVALTYPE);
	}

	public boolean selectMeterBasedInterval() {
		return selectIntervalRadioButton(METERBASED, INTERVALTYPE);
	}

	public boolean selectDailyBasedInterval() {
		return selectIntervalRadioButton("0", INTERVALCAL);
	}

	public boolean selectWeeklyBasedInterval() {
		return selectIntervalRadioButton("1", INTERVALCAL);
	}

	public boolean selectMonthlyBasedInterval() {
		return selectIntervalRadioButton("2", INTERVALCAL);
	}

	public boolean selectYearlyBasedInterval() {
		return selectIntervalRadioButton("3", INTERVALCAL);
	}

	private boolean selectIntervalRadioButton(String sRadioButton, String sName) {
		boolean bReturn = false;
		WebElement dialog = getVisibleDialog();
		List<WebElement> inputs = WebElementUtils.getChildElements(dialog, By.tagName("input"));
		Iterator<WebElement> iterB = inputs.iterator();
		while (iterB.hasNext()) {
			WebElement temp = iterB.next();
			String sType = temp.getAttribute("type");
			String sValue = temp.getAttribute("value");
			String sIntervalType = temp.getAttribute("name");
			if (sType.equals("radio") && sValue.equals(sRadioButton) && sIntervalType.equals(sName)) {
				bReturn = WebElementUtils.clickElement(temp);
			}
		}
		return bReturn;
	}
	
	public boolean setIntervalOccursEvery(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(OCCUREVERY);
		if (el != null) {
			List<WebElement> els = WebElementUtils.getChildElements(el, B2WMaintain.getB2WMaintainAddItemLevel());
			WebElementUtils.clickElement(els.get(0));
			bReturn = WebElementUtils.sendKeys(els.get(1), sText);

		}
		return bReturn;
	}
	
	public boolean setMonthlyIntervalOccursEveryMonthOnDay(String sEvery, String sDay) {

		boolean bReturn = true;
		WebElement el = getMonthlyDataElement();
		List<WebElement> wes = el.findElements(B2WMaintain.getKendoNumericTextBox());
		List<WebElement> every = wes.get(0).findElements(B2WMaintain.getB2WMaintainAddItemLevel());
		bReturn = WebElementUtils.clickElement(every.get(0));
		bReturn &= WebElementUtils.sendKeys(every.get(1), sEvery);
		List<WebElement> days = wes.get(1).findElements(B2WMaintain.getB2WMaintainAddItemLevel());
		bReturn &= WebElementUtils.clickElement(days.get(0));
		bReturn &= WebElementUtils.sendKeys(days.get(1), sEvery);
		return bReturn;

	}
	
	public boolean setMonthlyIntervalOccurEveryMonthOnThe(String sEvery, String sNumber, String sDay){
		
		boolean bReturn = true;
		selectIntervalRadioButton(MONTHLYVALUE,MONTHLYNAME);
		WebElement el = getMonthlyDataElement();
		List<WebElement> wes = el.findElements(B2WMaintain.getKendoNumericTextBox());
		List<WebElement> every = wes.get(2).findElements(B2WMaintain.getB2WMaintainAddItemLevel());
		bReturn = WebElementUtils.clickElement(every.get(0));
		bReturn &= WebElementUtils.sendKeys(every.get(1), sEvery);
		List<WebElement> dropdowns = el.findElements(B2WMaintain.getKendoDropDownForTMTab());
		dropdowns.get(0).click();
		selectItemFromDropDown(sNumber);
		dropdowns.get(1).click();
		bReturn = selectItemFromDropDown(sDay);
		
		return bReturn;
	
		
	}
	
	public boolean setYearlyIntervalOccursEveryonTheOf(String sYear, String sOn, String sDay, String sMonth){
		
		boolean bReturn = true;
		selectYearlyBasedInterval();
		WebElement el = getYearlyDataElement();
		WebElement textbox = WebElementUtils.getChildElement(el, B2WMaintain.getKendoNumericTextBox());
		List<WebElement> every = textbox.findElements(B2WMaintain.getB2WMaintainAddItemLevel());
		bReturn = WebElementUtils.clickElement(every.get(0));
		bReturn &= WebElementUtils.sendKeys(every.get(1), sYear);
		List<WebElement> dropdowns = el.findElements(B2WMaintain.getKendoDropDownForTMTab());
		dropdowns.get(0).click();
		selectItemFromDropDown(sOn);
		dropdowns.get(1).click();
		selectItemFromDropDown(sDay);
		dropdowns.get(2).click();
		selectItemFromDropDown(sMonth);
		return bReturn;
			
	}
	
	
	public boolean selectOccursEveryWeekOnFromDD(String sText) {
		boolean bReturn = false;
		WebElement top = getItemFromAddItemDialog(OCCUREVERY);
		WebElement el = WebElementUtils.getChildElement(top, By.cssSelector("span.k-input"));
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	

	private WebElement getMonthlyDataElement() {
		return getProgramIntervalType(databindCalendarMonthly);
	}
	
	private WebElement getYearlyDataElement() {
		return getProgramIntervalType(databindCalendarYearly);
		
	}
	
	private WebElement getIntervalTypeMeterBasedInvisible() {
		return getProgramIntervalType(databindTypeMeterBasedinvisible);
	}

	private WebElement getIntervalTypeMeterBasedvisible() {

		return getProgramIntervalType(databindTypeMeterBasedvisible);

	}
	
	private WebElement getProgramIntervalType(String sDataInterval) {

		WebElement item = null;
		WebElement dialog = getVisibleDialog();
		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName("div"));
		Iterator<WebElement> iterB = items.iterator();
		while (iterB.hasNext()){
			WebElement el = iterB.next();
			String sData = el.getAttribute("data-bind");
			if (sData == null){
				continue;
			}else if (sData.equals(sDataInterval)){
				item = el;
				break;
			}
		}
		return item;
	}
	
	private WebElement getVisibleDialog() {

		WebElement dialog = null;
		List<WebElement> dialogs = WebElementUtils.findElements(B2WMaintain.getB2WMaintainAddItemDialogContent());
		Iterator<WebElement> iterA = dialogs.iterator();
		while (iterA.hasNext()) {
			WebElement temp = iterA.next();
			if (temp.isDisplayed()) {
				dialog = temp;
				break;
			}
		}
		return dialog;
	}
	
	public boolean setGenerateRepairRequestsForThisItem(String sDays){
		boolean bReturn = false;
		Iterator<WebElement> iter = getElementsByTag("p");
		while (iter.hasNext()){
			WebElement el = iter.next();
			if (el.getText().startsWith(GENERALREPAIRREQUESTS)){
				List<WebElement> inputs = el.findElements(B2WMaintain.getB2WMaintainAddItemLevel());
				WebElementUtils.clickElement(inputs.get(0));
				bReturn = WebElementUtils.sendKeys(inputs.get(1), sDays);
			}
		}
		return bReturn;
	}
	
	public boolean selectScheduleSubsquentOrdersByActualDate(){
		return selectScheduleSubsequentByDate(ACTUALCALDATE);
	}
	public boolean selectScheduleSubsquentOrdersByPlannedDate(){
		return selectScheduleSubsequentByDate(PLANNEDCALDATE);
	}
	public boolean selectScheduleSubsquentOrdersByActualCompReading(){
		return selectScheduleSubsequentByReading(ACTUALCOMPREADING);
	}
	public boolean selectScheduleSubsquentOrdersByPlannedReading(){
		return selectScheduleSubsequentByReading(PLANNEDCOMPREADING);
	}
	
	
	private boolean selectScheduleSubsequentByDate(String sType) {
		boolean bReturn = false;
		WebElement el = getIntervalTypeMeterBasedInvisible();
		List<WebElement> items = el.findElements(B2WMaintain.getKendoDropDown());
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()){
			WebElement inputs = iter.next();
			if (inputs.getText().startsWith(PLANNEDCALDATE) || inputs.getText().startsWith(ACTUALCALDATE)){
				bReturn = WebElementUtils.clickElement(inputs);
				bReturn &= selectItemFromDropDown(sType);
			}
		}
		return bReturn;
	}
	private boolean selectScheduleSubsequentByReading(String sType) {
		boolean bReturn = false;
		WebElement el = getIntervalTypeMeterBasedvisible();
		List<WebElement> items = el.findElements(B2WMaintain.getKendoDropDown());
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()){
			WebElement inputs = iter.next();
			if (inputs.getText().startsWith(PLANNEDCOMPREADING) || inputs.getText().startsWith(ACTUALCOMPREADING)){
				bReturn = WebElementUtils.clickElement(inputs);
				bReturn &= selectItemFromDropDown(sType);
			}
		}
		return bReturn;
	}
	
	public Iterator<WebElement> getElementsByTag(String sTag){
		WebElement dialog = getVisibleDialog();
		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName(sTag));
		Iterator<WebElement> iter = items.iterator();
		return iter;
	}
	
	public boolean saveInterval(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainAddIntervalDialog());
		WebElement save = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainAddItemSaveButton());
		bReturn = WebElementUtils.clickElement(save);
		bReturn &= WebElementUtils.waitForElementInvisible(save);
		return bReturn;
	}
	
	public boolean selectMeterTypeFromDD(String sItem) {
		boolean bReturn = false;
		WebElement el = getIntervalTypeMeterBasedvisible();
		WebElement dd = WebElementUtils.getChildElement(el,B2WMaintain.getKendoDropDownForTMTab());
		WebElement input = WebElementUtils.getChildElement(dd, B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(input);
		bReturn &= selectItemFromDropDown(sItem);
		return bReturn;
		
	}
	
	public boolean selectMeterEvery(String sDay){
		boolean bReturn = false;
		WebElement el = getIntervalTypeMeterBasedvisible();
		WebElement dd = WebElementUtils.getChildElement(el,B2WMaintain.getKendoNumericTextBox());
		List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
		bReturn = WebElementUtils.clickElement(inputs.get(0));
		bReturn &= WebElementUtils.sendKeys(inputs.get(1), sDay);
		return bReturn;
	}
	
	public boolean saveMaintenanceProgram() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WEquipment.getKendoFooter());
		if (el != null) {
			WebElement button = WebElementUtils.getChildElement(el, B2WEquipment.getKendoLargeSaveButton());
			bReturn = WebElementUtils.clickElement(button);
			bReturn = WebElementUtils.waitForElementInvisible(WebElementUtils.findElement(B2WMaintain.getKendoFakeSaveButton()));
			WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoButton());
			bReturn &= waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			
		}
		return bReturn;
	}
}
