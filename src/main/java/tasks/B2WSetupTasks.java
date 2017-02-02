package tasks;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.b2w.test.BaseAssert;

import appobjects.B2WCommonObjects;
import appobjects.setup.B2WSetup;
import tasks.util.TaskUtils;

public class B2WSetupTasks {
	
	Logger log = Logger.getLogger(B2WSetupTasks.class);

	public boolean openB2WOPSetup() {
		boolean bReturn = false;

		return bReturn;
	}
	
	public boolean clickSortByAll() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListAll());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterA() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListA());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterB() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListB());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterC() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListC());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterD() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListD());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterE() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListE());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterF() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListF());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterG() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListG());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			TaskUtils.sleep(500);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterH() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListH());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterI() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListI());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterJ() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListJ());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterK() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListK());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterL() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListL());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterM() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListM());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			TaskUtils.sleep(1000);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterN() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListN());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterO() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListO());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterP() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListP());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterQ() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListQ());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterR() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListR());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterS() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListS());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterT() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListT());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterU() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListU());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterV() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListV());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterW() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListW());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterX() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListX());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterY() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListY());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}

	public boolean clickSortByLetterZ() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WPageListZ());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForProcessingDialogToClear();
		}
		return bReturn;
	}
	
	public boolean enterSearchText(String sText) {
		String searchID = WebElementUtils.getElementValueByAttribute(B2WSetup.getB2WSearchText(),"id");
		return WebElementUtils.setAttributeWithJS(searchID, "value", sText);
	}
	
	public String getSearchText() {
		return WebElementUtils.getElementValueByAttribute(B2WSetup.getB2WSearchText(),"value");
	}
	
	public boolean clickSearchClear() {
		return WebElementUtils.clickElement(B2WSetup.getB2WClearSearchButton());
	}
	
	public boolean clickCancelButton(){
		return WebElementUtils.clickElement(B2WSetup.getB2WCancelButton());
	}
	public boolean waitForProcessingDialogToClear() {
		boolean bReturn = false;
		bReturn = WebElementUtils.waitForElementHasAttributeWithValue(B2WSetup.getProcessingPanel(), "class", "hidden", true, WebElementUtils.LONG_TIME_OUT);
		waitForAjax();
		return bReturn;
	}
	private void waitForAjax() {
		int iTimeout = 0;
		boolean ajaxIsComplete = false;
		while (!ajaxIsComplete && iTimeout < 100) {
			ajaxIsComplete = (Boolean) ((JavascriptExecutor) BrowserUtils.getDriver()).executeScript("return jQuery.active == 0");
			log.debug("**Waiting for ajax to complete**");
			iTimeout++;
			TaskUtils.sleep(100);
		}
		log.debug("Waited "+ iTimeout +" trys for ajax to complete");
		
	}
	
	protected boolean checkBox(By by, boolean bCheck){
		
		boolean isChecked = WebElementUtils.isCheckboxChecked(by);
		// if item is checked and need to uncheck
		if (isChecked && !bCheck){
			log.debug("Uncheck the checkbox");
			WebElementUtils.clickElement(by);
		}
		// if item is unchecked and need to check
		if (!isChecked && bCheck){
			log.debug("Check the checkbox");
			WebElementUtils.clickElement(by);
		}
		return bCheck == WebElementUtils.isCheckboxChecked(by);
	}

	protected void clickOnTwistie(WebElement el) {
		el.findElement(By.tagName("span")).click();

	}
	
	protected boolean isSectionCollapsed(WebElement el) {
		boolean bReturn = false;
		String sStatus = el.findElement(By.tagName("h2")).getAttribute("class");
		if (sStatus.equals("closed")) {
			log.debug("The section is colapsed");
			bReturn = true;
		} else {
			log.debug("The section is expanded");
		}
		return bReturn;
	}
	
	public boolean clickTopCancelButton() {
		return WebElementUtils.clickElement(B2WSetup.getTopCancelButton());
	}
	public boolean clickBottomCancelButton() {
		return WebElementUtils.clickElement(B2WSetup.getBottomCancelButton());
	}
	public boolean clickTopSaveButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetup.getTopSaveButton())) {
			TaskUtils.sleep(500);
			bReturn = waitForProcessingDialogToClear();
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WSetup.getTopEditButton()) != null;
			if (!bReturn) {
				log.warn("******Error saving item********");
				BaseAssert.logScreenCapture();
				if (WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPagePanelError(), 1) != null) {
					log.warn("***Error displayed in panel***");
					clickTopCancelButton();
					Alert alert = WebElementUtils.waitForAndGetAlertDialog(WebElementUtils.MEDIUM_TIME_OUT);
					if (alert != null) {
						alert.accept();
						waitForProcessingDialogToClear();
					}
				}

			}
		}
		return bReturn;
	}

	public boolean clickBottomSaveButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetup.getBottomSaveButton())) {
			bReturn = waitForProcessingDialogToClear();
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WSetup.getTopEditButton()) != null;
			if (!bReturn) {
				if (WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPagePanelError(), 1) != null) {
					log.debug("***Error saving item***");
					BaseAssert.logScreenCapture();
					clickTopCancelButton();
					Alert alert = WebElementUtils.waitForAndGetAlertDialog(WebElementUtils.MEDIUM_TIME_OUT);
					if (alert != null) {
						alert.accept();
						waitForProcessingDialogToClear();
					}
				}

			}
		}
		return bReturn;
	}
	
	public boolean clickTopDeleteButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetup.getTopDeleteButton())){
			bReturn = true;
		}
		return bReturn;
	}
	public boolean clickBottomDeleteButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetup.getBottomDeleteButton())){
			bReturn = true;
		}
		return bReturn;
	}
	public boolean clickTopEditButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetup.getTopEditButton())){
			bReturn = true;
		}
		return bReturn;
	}
	public boolean clickBottomEditButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetup.getTopEditButton())){
			bReturn = true;
		}
		return bReturn;
	}
	public boolean enterTextAndClickSearch(String sText) {
		boolean bReturn = false;
		if (enterSearchText(sText)){
			this.clickSearchButton();
			TaskUtils.sleep(500);
			bReturn = waitForProcessingDialogToClear();
		}
		return bReturn;
	}
	public boolean clickSearchButton(){
		return WebElementUtils.clickElement(B2WSetup.getB2WSearchButton());
	}
	public String getGenInfoNameValueLabel() {
		String sText = "";
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WSetup.getGenInfoNameValueLabel());
		if (el!=null){
			sText = el.getText();
		}
		return sText;
	}

	public int getTotalPages() {
		int iPages = 1;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WGridPager());
		if (el != null) {
			WebElement last = WebElementUtils.getChildElement(el, By.className("last"));
			List<WebElement> pages = WebElementUtils.getChildElements(last, By.tagName("a"));
			iPages += pages.size();
		}
		return iPages;
	}

	public boolean clickPage(int iPage) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getB2WGridPager());
		if (el != null) {
			WebElement last = WebElementUtils.getChildElement(el, By.className("last"));
			WebElement page = WebElementUtils.getChildElementContainsText(last, By.tagName("a"),
					Integer.toString(iPage));
			if (page != null) {
				bReturn = WebElementUtils.clickElement(page);
				WebElementUtils.waitForElementStale(page, WebElementUtils.SHORT_TIME_OUT);
			}
		}
		return bReturn;
	}
	
	public WebElement getColumnHeader(String sHeader){
		WebElement el = null;
		WebElement listinggrid = WebElementUtils.findElement(B2WCommonObjects.getB2WPageContentGrid());
		if (listinggrid != null){
			el = WebElementUtils.getChildElementContainsText(listinggrid, By.tagName("a"), sHeader);
		}
		return el;
		
	}
	
	public ArrayList<String> getColumnText(int iCol) {
		ArrayList<String> al = new ArrayList<String>();
		WebElement listinggrid = WebElementUtils.findElement(B2WCommonObjects.getB2WPageContentGrid());
		if (listinggrid != null){
			WebElement tbody = WebElementUtils.getChildElement(listinggrid, By.tagName("tbody"));
			List<WebElement> list = WebElementUtils.getChildElements(tbody, By.tagName("tr"));
			for (WebElement e: list){
				List<WebElement> td = WebElementUtils.getChildElements(e, By.tagName("td"));
				al.add(td.get(iCol).getText());
				if (e.getAttribute("class").equals("last")){
					break;
				}
			}
		}
		return al;
	}
	
}
