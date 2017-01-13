package tasks.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WAddPartsToWorkItem extends B2WKendoDialog {
	
	int iCurrentRows = 0;

	public boolean selectPartToAddToWorkItemByDescription(String sPart){
		return selectFromDialog(sPart, 1);
		
	}
	
	public boolean selectPartToAddToWorkItemByID(String sPart){
		return selectFromDialog(sPart, 0);
	}
	
	public String selectRandomPartToAdd() {
		return selectAnyItemFromDialog();
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
	
	
	public boolean setCustomDescription(String sText){
		boolean bReturn = false;
		WebElement window = getRowsOfParts().get(iCurrentRows-1);
		WebElement textBox = WebElementUtils.getChildElement(window, B2WMaintain.getKendoInputTextBox());
		if (textBox != null){
			bReturn = WebElementUtils.sendKeys(textBox, sText);
		}
		return bReturn;
	}
	public boolean setCustomUnitCost(String sText){
		boolean bReturn = false;
		WebElement window = getRowsOfParts().get(iCurrentRows-1);
		List<WebElement> numbers = WebElementUtils.getChildElements(window, B2WMaintain.getKendoNumericTextBox());
		if (numbers.size()>0){
			List<WebElement> inputs = WebElementUtils.getChildElements(numbers.get(0),B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
			
		}
		return bReturn;
	}
	public boolean setCustomEstQty(String sText){
		boolean bReturn = false;
		WebElement window = getRowsOfParts().get(iCurrentRows-1);
		List<WebElement> numbers = WebElementUtils.getChildElements(window, B2WMaintain.getKendoNumericTextBox());
		if (numbers.size()>0){
			List<WebElement> inputs = WebElementUtils.getChildElements(numbers.get(1),B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
			
		}
		return bReturn;
	}
	public boolean setCustomRptQty(String sText){
		boolean bReturn = false;
		WebElement window = getRowsOfParts().get(iCurrentRows-1);
		List<WebElement> numbers = WebElementUtils.getChildElements(window, B2WMaintain.getKendoNumericTextBox());
		if (numbers.size()>0){
			List<WebElement> inputs = WebElementUtils.getChildElements(numbers.get(2),B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
			
		}
		return bReturn;
	}
	
	public boolean selectUnitOfMeasure(String sText){
		boolean bReturn = false;
		WebElement window = getRowsOfParts().get(iCurrentRows-1);
		List<WebElement> numbers = WebElementUtils.getChildElements(window, B2WMaintain.getKendoDropDownForTMTab());
		if (numbers.size()>0){
			List<WebElement> inputs = WebElementUtils.getChildElements(numbers.get(0),B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= selectItemFromDropDown("ID");
			
		}
		return bReturn;
	}
	public boolean setUnitCost(String sItem, String sCost){
		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		List<WebElement> textBoxs = WebElementUtils.getChildElements(window, B2WMaintain.getKendoInputTextBox());
		WebElement textBox = WebElementUtils.getVisibleElementFromListofElements(textBoxs);
		System.out.println(textBox.getText());
		System.out.println(textBoxs.size());
		return bReturn;
	}
	public List<WebElement> getRowsOfParts() {
		WebElement window = getDisplayedWindow();
		List<WebElement> rows = new ArrayList<WebElement>();
		List<WebElement> animal = WebElementUtils.getChildElements(window,By.tagName("tr"));
		for (WebElement el: animal){
			if (el.getAttribute("data-uid") != null){
				rows.add(el);
			}
		}
		return rows;
	}
	public boolean clickAddCustomPart() {
		boolean bReturn = false;
		iCurrentRows = getRowsOfParts().size();
		bReturn = clickButton("Add Custom Part");
		TaskUtils.sleep(500);
		iCurrentRows = getRowsOfParts().size();
		return bReturn;
	}
}
