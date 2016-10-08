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
import tasks.util.TaskUtils;

public class B2WAddMaterialsTasks {
	
	private static int COUNTOFMATERIALS = 10;
	Logger log = Logger.getLogger(B2WAddMaterialsTasks.class);
	
	public boolean setSearchMaterialsText(String sText){
		
		boolean bReturn = false;
		WebElement bar = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSearchButtonBar());
		WebElement el = WebElementUtils.getChildElement(bar, B2WAddMaterials.getAddMaterialsSearchText());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(el, sText);
			String sValue = el.getAttribute("value");
			log.debug("The Value in Search Box is: "+sValue);
			bReturn &= sValue.equals(sText);
			bReturn &= waitForNumberOfItemsInDialogToChange();
		}
		return bReturn;
	}
	
	public boolean setIDToSelect(String sText){
		boolean bReturn = false;
		WebElement bar = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getSearchIDBar());
		WebElement el = WebElementUtils.getChildElement(bar, B2WAddMaterials.getAddMaterialsIDToSelect());
		if (el!=null){
			if (getMaterialIDTextFromGrid().contains(sText)){
				bReturn = WebElementUtils.sendKeys(el, sText);
				String sValue = el.getAttribute("value");
				log.debug("The Value to ID is: "+sValue);
				bReturn &= sValue.equals(sText);
			}else{
				log.debug("Did not find the "+sText+ " in the material id list");
			}
		}else{
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
	
	public boolean isChecked() {
	
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
		if (el != null){
			WebElement checkbox = WebElementUtils.getChildElement(el, B2WAddMaterials.getAddMaterialsCheckBox());
			System.out.println("Selected"+checkbox.isSelected());
			
		}
		return bReturn;
		
	}
	
//	public void getAllInfoFromGrid() {
//		WebElement el = BrowserUtils.getDriver().findElement(By.className("search-textbox"));
//		JavascriptExecutor executor = (JavascriptExecutor) BrowserUtils.getDriver();
//		Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", el);
//		System.out.println(aa.toString());
//	}
	
	private int getNumberOfMaterialsinAddMaterialsDialog() {
		int i = 0;
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
		if (grid != null) {
			i = getRowsFromDialog().size();
			log.info("Number of materials in the dialog is: "+i);
		}
		return i;
	}
	
	public List<WebElement> getRowsFromDialog() {
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
		return grid.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}
	
	private boolean waitForNumberOfItemsInDialogToChange() {
		boolean bReturn = false;
		int iWait = 0;
		int iItems = getNumberOfMaterialsinAddMaterialsDialog();
		while ((COUNTOFMATERIALS == iItems) && (iWait < 20)){
			TaskUtils.sleep(100);
			iItems = getNumberOfMaterialsinAddMaterialsDialog();
			iWait++;
		}
		if (iWait < 20){
			bReturn = true;
		}
		COUNTOFMATERIALS = iItems;
		return bReturn;
		
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
		
	
	

	
	public static void setCountOfMaterialsinDialog() {
		COUNTOFMATERIALS = new B2WAddMaterialsTasks().getNumberOfMaterialsinAddMaterialsDialog();
	}
	
	
}
