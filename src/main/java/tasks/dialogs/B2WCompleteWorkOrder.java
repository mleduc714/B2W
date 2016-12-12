package tasks.dialogs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WCompleteWorkOrder extends B2WKendoDialog {

	private String PLANNEDHRS = "plan-hours";
	private String REPORTHRS = "report-hours";

	public boolean setCompleteDate(String sCompleteDate) {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		WebElement page1 = WebElementUtils.getChildElement(window, (By.cssSelector(".page1")));
		WebElement compDate = WebElementUtils.getChildElement(page1, B2WMaintain.getKendoDropDown());
		if (compDate != null) {
			bReturn = WebElementUtils.sendKeys(compDate, sCompleteDate);
		}
		return bReturn;
	}

	public boolean setReadingAtCompletion(String sMeter, String sReading) {
		boolean bReturn = false;
		try {
			WebElement window = getDisplayedWindow();
			WebElement page1 = WebElementUtils.getChildElement(window, (By.cssSelector(".page1")));
			WebElement dialog = WebElementUtils.getChildElement(page1, B2WMaintain.getB2WWorkItemCompleteMeters());
			WebElement rowgroup = WebElementUtils.getChildElement(dialog, By.tagName("tbody"));
			List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
			Iterator<WebElement> iter = rows.iterator();
			while (iter.hasNext()) {
				WebElement row = iter.next();
				List<WebElement> ls = row.findElements(By.tagName("td"));
				if (ls.get(0).getText().startsWith(sMeter)) {
					WebElement dd = WebElementUtils.getChildElement(row, B2WMaintain.getKendoNumericTextBox());
					List<WebElement> inputs = WebElementUtils.getChildElements(dd, B2WMaintain.getKendoDropDown());
					bReturn = WebElementUtils.clickElement(inputs.get(0));
					bReturn &= WebElementUtils.sendKeys(inputs.get(1), sReading);
					rowgroup.click();
				}

			}
		} catch (StaleElementReferenceException e) {
			return setReadingAtCompletion(sMeter, sReading);
		}
		return bReturn;

	}

	public ArrayList<String> getMeters() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement window = getDisplayedWindow();
		WebElement page1 = WebElementUtils.getChildElement(window, (By.cssSelector(".page1")));
		WebElement dialog = WebElementUtils.getChildElement(page1, B2WMaintain.getB2WWorkItemCompleteMeters());
		WebElement rowgroup = WebElementUtils.getChildElement(dialog, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()) {
			WebElement row = iter.next();
			List<WebElement> ls = row.findElements(By.tagName("td"));
			al.add(ls.get(0).getText());
		}
		return al;

	}

	public boolean clickNextPage() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getCompleteNextButton());
		if (el != null) {

			bReturn = WebElementUtils.clickElement(el);
		}

		return bReturn;
	}

	public boolean completeSave() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getCompleteSaveButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

	public boolean selectCompletedWorkItem(String sItem) {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		Pattern pattern = Pattern.compile(sItem);
		WebElement page2 = WebElementUtils.getChildElement(window, (By.cssSelector(".page2")));
		List<WebElement> workItems = WebElementUtils.getChildElements(page2,
				B2WMaintain.getB2WCompleteWorkItemsTitle());
		Iterator<WebElement> iter = workItems.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			String sText = el.getText();
			Matcher test = pattern.matcher(sText);
			if (test.find()) {
				bReturn = WebElementUtils.clickElement(el);
			}
		}

		return bReturn;
	}

	public Hashtable<String, Integer> getMetersAndReading() {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		WebElement window = getDisplayedWindow();
		WebElement page1 = WebElementUtils.getChildElement(window, (By.cssSelector(".page1")));
		WebElement dialog = WebElementUtils.getChildElement(page1, B2WMaintain.getB2WWorkItemCompleteMeters());
		WebElement rowgroup = WebElementUtils.getChildElement(dialog, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()) {
			WebElement row = iter.next();
			List<WebElement> ls = row.findElements(By.tagName("td"));
			String sKey = ls.get(0).getText();
			String sValue = ls.get(3).getText();
			sValue = sValue.replace(",", "");
			Integer reading = new Integer(sValue);
			table.put(sKey, reading);
		}
		return table;

	}

	public boolean setNotesForOrder(String sNotes) {
		return setNotes(sNotes);
	}

	public boolean clickReportHours() {
		return clickButton("Report Hours");
	}

	public boolean clickAddPlannedHours() {
		return clickButton("Add Planned Hours");
	}

	public boolean clickAddParts() {
		return clickButton("Add Parts");
	}

	public boolean setPlannedHoursDescription(String sDesc) {
		boolean bReturn = false;
		WebElement plannedHours = WebElementUtils.findElement(By.className(PLANNEDHRS));
		if (plannedHours != null) {
			WebElement desc = WebElementUtils.getChildElements(plannedHours, By.tagName("input")).get(0);
			bReturn = WebElementUtils.sendKeys(desc, sDesc);
		}
		return bReturn;
	}

	public boolean setPlannedHours(String sHours) {
		boolean bReturn = false;
		WebElement plannedHours = WebElementUtils.findElement(By.className(PLANNEDHRS));
		if (plannedHours != null) {
			bReturn = setNumericField(plannedHours, "Hours", sHours);
		}
		return bReturn;
	}

	public boolean setPlannedHoursLaborType(String lType) {
		boolean bReturn = false;
		WebElement plannedHours = WebElementUtils.findElement(By.className(PLANNEDHRS));
		if (plannedHours != null) {
			WebElement type = WebElementUtils.getChildElement(plannedHours, B2WMaintain.getKendoDropDown());
			if (WebElementUtils.clickElement(type)) {
				TaskUtils.sleep(1000);
				bReturn = selectItemFromDropDown(lType);
			}

		}
		return bReturn;
	}

	public boolean clickAddPlannedHoursAddButton() {

		boolean bReturn = false;
		WebElement plannedHours = WebElementUtils.findElement(By.className(PLANNEDHRS));
		if (plannedHours != null) {
			WebElement add = WebElementUtils.getChildElement(plannedHours, By.cssSelector(".add-planned-hours"));
			bReturn = WebElementUtils.clickElement(add);
		}
		return bReturn;
	}

	
	public boolean setTypeOfReportingHours(String sType) {
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null) {
			WebElement typeHours = WebElementUtils.getChildElement(reportedHours, B2WMaintain.getKendoDropDown());
			if (WebElementUtils.clickElement(typeHours)) {
				TaskUtils.sleep(1000);
				bReturn = selectItemFromDropDown(sType);
			}
		}
		return bReturn;
	}
	
	public boolean setReportHoursDescription(String s){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null) {
			WebElement el = WebElementUtils.getChildElementContainsText(reportedHours, By.tagName("label"), "Description");		
			bReturn = WebElementUtils.sendKeys(WebElementUtils.getChildElement(WebElementUtils.getParentElement(el), By.tagName("input")), s);
			
		}
		return bReturn;
	}
	
	public boolean selectEmployee(String s){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null) {
			WebElement el = WebElementUtils.getChildElementContainsText(reportedHours, By.tagName("label"), "Employee");		
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(WebElementUtils.getParentElement(el), B2WMaintain.getKendoDropDown()));
			bReturn &= selectItemFromDropDown(s);
		}
		return bReturn;
	}
	
	public boolean selectReportedHoursLaborType(String s){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (openDropDownMenu(reportedHours,"Labor Type")){
			bReturn = selectItemFromDropDown(s);
		}
		return bReturn;
	}
	
	public boolean setReportedHoursDate(String s){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null){
			bReturn = setNumericField(reportedHours, "Date", s);
		}
		return bReturn;
	}
	public boolean setReportedRegularHours(String sText){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null){
			bReturn = setNumericField(reportedHours, "Regular", sText);
		}
		return bReturn;
	}
	public boolean setReportedRegularMins(String sText){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		WebElement dd = WebElementUtils.getChildElements(reportedHours, B2WMaintain.getKendoNumericTextBox()).get(1);
		if (dd != null){
			List<WebElement> inputs = WebElementUtils.getChildElements(dd, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}
		return bReturn;
	}
	public boolean setReportedOvertimeHours(String sText){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null){
			bReturn = setNumericField(reportedHours, "Overtime", sText);
		}
		return bReturn;
	}
	public boolean setReportedOvertimeMins(String sText){
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		WebElement dd = WebElementUtils.getChildElements(reportedHours, B2WMaintain.getKendoNumericTextBox()).get(3);
		if (dd != null){
			List<WebElement> inputs = WebElementUtils.getChildElements(dd, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}
		return bReturn;
	}
	
	public boolean clickReportedHoursAdd() {
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null){
			WebElement el = WebElementUtils.getChildElement(reportedHours, By.cssSelector(".add-hours"));
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
	public boolean clickReportedHoursCancel() {
		boolean bReturn = false;
		WebElement reportedHours = WebElementUtils.findElement(By.className(REPORTHRS));
		if (reportedHours != null){
			WebElement el = WebElementUtils.getChildElement(reportedHours, By.cssSelector(".cancel-hours"));
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}
}
