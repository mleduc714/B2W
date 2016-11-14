package tasks.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddPartsToWorkItem extends B2WKendoDialog {

	public boolean selectPartToAddToWorkItemByDescription(String sPart){
		return selectPart(sPart, 1);
		
	}
	
	public boolean selectPartToAddToWorkItemByID(String sPart){
		return selectPart(sPart, 0);
	}
	
	public boolean partsNext() {
		return clickNext();
	}
	public boolean saveParts() {
		return clickSave();
	}
	
	public boolean setEstimatedQty(String sItem, String sEstimate){
		return setQty(sItem, sEstimate, 0);
		
		}
	
	private boolean setQty(String sItem, String sQty, int item){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		WebElement dialog = WebElementUtils.getChildElement(window,B2WMaintain.getB2WAddPartsDialogQuanities());
		WebElement rowgroup = WebElementUtils.getChildElement(dialog, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement row = iter.next();
			List<WebElement> ls = row.findElements(By.tagName("td"));
			if (ls.get(0).getText().startsWith(sItem)){
				List<WebElement> dd = WebElementUtils.getChildElements(row,B2WMaintain.getKendoNumericTextBox());
				List<WebElement> inputs = WebElementUtils.getChildElements(dd.get(item),B2WMaintain.getKendoDropDown());
				bReturn = WebElementUtils.clickElement(inputs.get(0));
				bReturn &= WebElementUtils.sendKeys(inputs.get(1), sQty);
			}
			
		}
		return bReturn;

	
		
	}
	
	public boolean setReportedQty(String sItem, String sReported){
		return setQty(sItem, sReported, 1);
		
	}

	public ArrayList<String> getPartsDescriptions() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement window = getDisplayedWindow();
		WebElement rowgroup = WebElementUtils.getChildElement(window, By.tagName("tbody"));
		List<WebElement> rows = WebElementUtils.getChildElements(rowgroup, By.tagName("tr"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement row = iter.next();
			List<WebElement> ls = row.findElements(By.tagName("td"));
			al.add(ls.get(0).getText());
			
		}
		return al;
		
	}
	
}
