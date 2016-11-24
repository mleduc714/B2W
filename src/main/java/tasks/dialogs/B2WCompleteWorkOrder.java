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

public class B2WCompleteWorkOrder extends B2WKendoDialog {
	
	
	public boolean setCompleteDate(String sCompleteDate) {
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		WebElement page1 = WebElementUtils.getChildElement(window,(By.cssSelector(".page1")));
		WebElement compDate = WebElementUtils.getChildElement(page1, B2WMaintain.getKendoDropDown());
		if (compDate != null){
			bReturn = WebElementUtils.sendKeys(compDate,sCompleteDate);
		}
		return bReturn;
	}
	
	public boolean setReadingAtCompletion (String sMeter, String sReading){
		boolean bReturn = false;
		try{
		WebElement window = getDisplayedWindow();
		WebElement page1 = WebElementUtils.getChildElement(window,(By.cssSelector(".page1")));
		WebElement dialog = WebElementUtils.getChildElement(page1, B2WMaintain.getB2WWorkItemCompleteMeters());
		WebElement rowgroup = WebElementUtils.getChildElement(dialog, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement row = iter.next();
			List<WebElement> ls = row.findElements(By.tagName("td"));
			if (ls.get(0).getText().startsWith(sMeter)){
				System.out.println(ls.get(0).getText());
				WebElement dd = WebElementUtils.getChildElement(row,B2WMaintain.getKendoNumericTextBox());
				List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
				bReturn = WebElementUtils.clickElement(inputs.get(0));
				bReturn &= WebElementUtils.sendKeys(inputs.get(1), sReading);
				rowgroup.click();
			}
			
		}
		}catch (StaleElementReferenceException e){
			return setReadingAtCompletion(sMeter, sReading);
		}
		return bReturn;
		
	}
	
	public ArrayList<String> getMeters() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement window = getDisplayedWindow();
		WebElement page1 = WebElementUtils.getChildElement(window,(By.cssSelector(".page1")));
		WebElement dialog = WebElementUtils.getChildElement(page1, B2WMaintain.getB2WWorkItemCompleteMeters());
		WebElement rowgroup = WebElementUtils.getChildElement(dialog, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement row = iter.next();
			List<WebElement> ls = row.findElements(By.tagName("td"));
			al.add(ls.get(0).getText());
		}
		return al;
		
	}
	

	
	public boolean clickNextPage() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getCompleteNextButton());
		if (el != null){
		
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
	
	public Hashtable<String,Integer> getMetersAndReading(){
		Hashtable<String,Integer> table = new Hashtable<String,Integer>();
		WebElement window = getDisplayedWindow();
		WebElement page1 = WebElementUtils.getChildElement(window,(By.cssSelector(".page1")));
		WebElement dialog = WebElementUtils.getChildElement(page1, B2WMaintain.getB2WWorkItemCompleteMeters());
		WebElement rowgroup = WebElementUtils.getChildElement(dialog, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement row = iter.next();
			List<WebElement> ls = row.findElements(By.tagName("td"));
			String sKey = ls.get(0).getText();
			String sValue = ls.get(3).getText();
			sValue = sValue.replace(",","");
			Integer reading = new Integer(sValue);
			table.put(sKey, reading);
		}
		return table;
		
	}

}
