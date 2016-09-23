package tasks.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WResources;
import tasks.B2WSetupTasks;
import tasks.WebElementUtils;

public abstract class B2WResourceTasks extends B2WSetupTasks {

	public boolean setDescription(String sDescription) {
		WebElement el = WebElementUtils.findElement(B2WResources.getAccountDescription());
		return WebElementUtils.sendKeys(el, sDescription);
	}
	
	public String getDescriptionText(){
		return WebElementUtils.findElement(B2WResources.getAccountDescriptionLabel()).getText();
	}
	
	public boolean setAccountID(String sText) {
		WebElement el = WebElementUtils.findElement(B2WResources.getAccountID());
		return WebElementUtils.sendKeys(el, sText);
	}
	
	public String getAccountIDText() {
		return WebElementUtils.findElement(B2WResources.getAccountIDLabel()).getText();
	}
	
	public boolean selectBusinessUnit(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;

	}

	public boolean selectBusinessUnit(int iSelect) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, iSelect);
		return bReturn;
	}
	
	public boolean selectCategory(int iSelect){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getCategoryDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, iSelect);
		return bReturn;
	}
	public boolean selectCategory(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getCategoryDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}
	public boolean selectUnitOfMeasure(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WResources.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}

	public boolean selectUnitOfMeasure(int iSelect) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, iSelect);
		return bReturn;
	}
	
	public String getSelectedBusinessUnit() {
		String sSelection = null;
		WebElement el = WebElementUtils.findElement(B2WResources.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		sSelection = WebElementUtils.getSelectedTextFromDropDown(els);
		return sSelection;
	}

	public String getSelectedUnitOfMeasure() {
		String sSelection = null;
		WebElement el = WebElementUtils.findElement(B2WResources.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		sSelection = WebElementUtils.getSelectedTextFromDropDown(els);
		return sSelection;
	}
	
	public String getAccountUnitofMeasureText() {
		return WebElementUtils.findElement(B2WResources.getUnitOfMeasureLabel()).getText();
	}
	
	public String getAccountBusinessUnitLink() {
		return WebElementUtils.findElement(B2WResources.getBusinessUnitHyperLink()).getText();
	}

	public boolean selectInactiveCheckBox(boolean bCheck) {
		WebElement el = WebElementUtils.findElement(B2WResources.getInactiveCheckBox());
		return checkBox(el, bCheck);
	}

	public boolean setNotes(String sText) {
		return WebElementUtils.sendKeys(B2WResources.getGeneralInformationNotes(), sText);
	}

	public boolean setCategory(int iSelect) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getUnitOfMeasureDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElementUtils.selectElementFromDropDownList(els, iSelect);
		return bReturn;
	}

	public boolean setCategory(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getBusinessUnitDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}

	public boolean setAlternateID(String sText) {
		return WebElementUtils.sendKeys(B2WResources.getAccountAlterID(), sText);
	}
	
	public boolean checkTimeAndMaterials() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WResources.getTimeMaterialsCheckBox());
		if (!WebElementUtils.isCheckboxChecked(el)) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}


}
