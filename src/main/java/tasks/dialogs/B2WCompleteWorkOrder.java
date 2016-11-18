package tasks.dialogs;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
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
				WebElement dd = WebElementUtils.getChildElement(row,B2WMaintain.getKendoNumericTextBox());
				List<WebElement> inputs = WebElementUtils.getChildElements(dd,B2WMaintain.getKendoDropDown());
				bReturn = WebElementUtils.clickElement(inputs.get(0));
				bReturn &= WebElementUtils.sendKeys(inputs.get(1), sReading);
			}
			
		}
		return bReturn;
		
	}
	public boolean clickNextPage() {
		// this is temp solution. 
		WebElement el = WebElementUtils.findElement(By.xpath("//a[@data-bind='visible: workOrderCompletionViewModel.isNextVisible,dataEnabled: workOrderCompletionViewModel.isNextEnabled']"));
		return WebElementUtils.clickElement(el);
	
	}

	public boolean completeSave() {
		//temp
		WebElement el = WebElementUtils.findElement(By.xpath("//a[@data-bind='visible: workOrderCompletionViewModel.isSaveVisible']"));
		return WebElementUtils.clickElement(el);
	}
	
	public boolean selectCompletedWorkItem(String sItem){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		Pattern pattern = Pattern.compile(sItem);
		WebElement page2 = WebElementUtils.getChildElement(window,(By.cssSelector(".page2")));
		List<WebElement> workItems = WebElementUtils.getChildElements(page2, B2WMaintain.getB2WCompleteWorkItemsTitle());
		Iterator<WebElement> iter = workItems.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			String sText = el.getText();
			Matcher test = pattern.matcher(sText);
			if (test.find()){
				bReturn = WebElementUtils.clickElement(el);
			}
			}
		
		return bReturn;
	}

}
