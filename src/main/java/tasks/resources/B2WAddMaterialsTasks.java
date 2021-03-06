package tasks.resources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WAddMaterials;
import tasks.WebElementUtils;

public class B2WAddMaterialsTasks {
	
	Logger log = Logger.getLogger(B2WAddMaterialsTasks.class);
	
	public boolean setSearchMaterialsText(String sText){
		
		boolean bReturn = false;
		WebElement grid = WebElementUtils.findElement(B2WAddMaterials.getCheckboxGrid());
		WebElement bar = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSearchButtonBar());
		WebElement el = WebElementUtils.getChildElement(bar, B2WAddMaterials.getAddMaterialsSearchText());
		if (el!=null){
			
			bReturn = WebElementUtils.sendKeys(el, sText);
			WebElementUtils.waitForElementStale(grid,2);
			String sValue = el.getAttribute("value");
			log.debug("The Value in Search Box is: "+sValue);
			bReturn &= sValue.equals(sText);
			
		}
		return bReturn;
	}
	
	public boolean setIDToSelect(String sText) {
		boolean bReturn = false;
		WebElement bar = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSearchIDBar());
		WebElement el = WebElementUtils.getChildElement(bar, B2WAddMaterials.getAddMaterialsIDToSelect());
		if (el != null) {
			// if the id is in the dialog, enter in the id in the field and then
			// select
			log.debug("Does MaterialsID exist in the grid: " + getMaterialIDTextFromGrid().contains(sText));
			bReturn = WebElementUtils.sendKeys(el, sText);
			String sValue = el.getAttribute("value");
			log.debug("The Value to ID is: " + sValue);
			bReturn &= sValue.equals(sText);

		} else {
			log.debug("The Materials To To Select TextBox is returning as null");
		}

		return bReturn;
	}
	
	public boolean clickSelectButton() {

		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSelectButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);

		}
		return bReturn;
	}

	public boolean clickAddButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getAddButton());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
		}else{
			log.debug("Add Button is null");
		}
		return bReturn;
	}
	
	public boolean clickCancelButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCancelButton());
		if (el!=null){
			el.click();
		}else{
			log.debug("Cancel Button is null");
		}
		
		return bReturn;
	}
	
//	public boolean isChecked() {
//	
//		boolean bReturn = false;
//		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
//		if (el != null){
//			WebElement checkbox = WebElementUtils.getChildElement(el, B2WAddMaterials.getAddMaterialsCheckBox());
//		}
//		return bReturn;
//		
//	}
	
//	public void getAllInfoFromGrid() {
//		WebElement el = BrowserUtils.getDriver().findElement(By.className("search-textbox"));
//		JavascriptExecutor executor = (JavascriptExecutor) BrowserUtils.getDriver();
//		Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", el);
//		System.out.println(aa.toString());
//	}
	
	
	public List<WebElement> getRowsFromDialog() {
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
		return grid.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}
	

	
	public ArrayList<String> getMaterialIDTextFromGrid() {
		ArrayList<String> sMaterialIDs = new ArrayList<String>();
		try {
			List<WebElement> rows = getRowsFromDialog();
			if (rows.size() > 0) {
				Iterator<WebElement> iter = rows.iterator();
				while (iter.hasNext()) {
					WebElement row = iter.next();

					String sMaterialsID = row.findElements(By.tagName("td")).get(2).getText();
					log.debug("Found Material ID "+sMaterialsID);
					sMaterialIDs.add(sMaterialsID);
				}
			}
		} catch (StaleElementReferenceException e) {
			getMaterialIDTextFromGrid();
		}
		return sMaterialIDs;
	}
	
	
}
