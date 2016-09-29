package tasks.resources;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WMaterials;
import appobjects.setup.B2WResources;
import tasks.B2WSetupTasks;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public abstract class B2WResourceTasks extends B2WSetupTasks {
	
	Logger log = Logger.getLogger(B2WResourceTasks.class);

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
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WResources.getUnitOfMeasureLabel());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	
	public String getAccountBusinessUnitLink() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WResources.getBusinessUnitHyperLink());
		if (el != null){
			sText = el.getText();
		}
		return sText;
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
	public boolean setTotalCost(String sCost) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getTotalCost());
		el.clear();
		bReturn = WebElementUtils.sendKeys(el, sCost);
		return bReturn;

	}
	public boolean enterInfoAndSearchForAccount(String sText) {
		boolean bReturn = false;
		if (enterSearchText(sText)) {
			clickSearchButton();
			bReturn = waitForProcessingDialogToClear();
		}
		return bReturn;

	}
	public boolean clickSearchButton(){
		boolean bReturn = false;
		bReturn = WebElementUtils.clickElement(WebElementUtils.findElement(B2WMaterials.getResourcesSearchButton()));
		return bReturn;
	}
	
	public boolean clickClearSearchButton() {
		boolean bReturn = false;
		bReturn = WebElementUtils.clickElement(WebElementUtils.findElement(B2WMaterials.getResourcesClearSearchButton()));
		return bReturn;
	}
	
	
	public boolean enterSearchForResourceText(String sText){
		boolean bReturn = false;
		String value = "";
		
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getResourcesSearchText());
		if (el != null) {
			value = el.getAttribute("value");
			log.debug("The Value currently is " + value);
			log.debug("The length of value is " +value.length());
			if (value.length() > 0) {
				log.debug("The Search needs to be cleared");
				clickClearSearchButton();
				// need to retrieve webelement again
				TaskUtils.sleep(1000);
				el = WebElementUtils.waitAndFindDisplayedElement(B2WMaterials.getResourcesSearchText());
				log.debug("After the searched has been cleared" +el.getAttribute("value"));
						
			

			}
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		
		return bReturn;
	}
	
	public boolean searchOpenResourceByDescription(String sDescription){

		boolean bReturn = false;
		enterInfoAndSearchForResource(sDescription);
		TaskUtils.sleep(1000);
		List<WebElement> list = WebElementUtils.findElements(B2WResources.getDescriptionList());
		if (!list.isEmpty()) {
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sDescription, false);
			if (el!=null){
				WebElementUtils.clickElement(el);
				WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WResources.getAccountDescriptionLabel());
				bReturn = waitForThis != null;
			}
		}
		return bReturn;
	
	}
	
	private boolean enterInfoAndSearchForResource(String sDescription) {
		boolean bReturn = false;
		if (enterSearchForResourceText(sDescription)){
			bReturn = clickSearchButton();
		}
		return bReturn;
	}

	public boolean deleteResource() {
		boolean bReturn = false;
		clickTopDeleteButton();
		Alert alert = WebElementUtils.waitForAndGetAlertDialog(WebElementUtils.MEDIUM_TIME_OUT);
		if (alert != null) {
			alert.accept();
			bReturn = waitForProcessingDialogToClear();
		}
		return bReturn;
	}

}
