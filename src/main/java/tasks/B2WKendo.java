package tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import tasks.util.TaskUtils;

public abstract class B2WKendo {
	
	Logger log = Logger.getLogger(B2WKendo.class);
	
	protected boolean selectItemFromDropDown(int i){
		boolean bReturn = false;
		// when we click we need to find the visible list
		List<WebElement> items = new ArrayList<WebElement>();
		int iTimeout = 0;
		while (items.size() == 0 && iTimeout < 50){
			items = getKendoDropDownItems();
			iTimeout++;
			TaskUtils.sleep(100);
		}
		if (items.size() != 0) {
			WebElement item = items.get(i);
			WebElementUtils.waitForElementIsDisplayed(item, WebElementUtils.SHORT_TIME_OUT);
			if (item != null) {
				bReturn = WebElementUtils.clickElement(item);
				WebElementUtils.waitForElementInvisible(item);
			} else {
				log.debug("Could not select item #" + i);
			}
		}else{
			log.debug("Could not find a visible drop down menu");
		}
		return bReturn;
	}
	protected boolean selectItemFromDropDown(String sItem){
		boolean bReturn = false;
		try {
			List<WebElement> items = getKendoDropDownItems();
			WebElement item = WebElementUtils.getElementWithMatchingStartsWithText(items, sItem);
			if (item != null) {
				bReturn = WebElementUtils.clickElement(item);
				bReturn &= WebElementUtils.waitForElementInvisible(item);
			}else{
				log.debug("Item with could not be found matching "+sItem);
			}
		
		}catch (StaleElementReferenceException e){
			return selectItemFromDropDown(sItem);
		}
		return bReturn;
	}

	protected Iterator<WebElement> getChildElementsFromGrid(WebElement grid){
		Iterator<WebElement> itr = null;
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		if (items.size()> 0){
			itr = items.iterator();
		}
		return itr;
	}
	
	protected List<WebElement> getRowsFromGrid(WebElement grid){
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		return items;
	}
	
	protected boolean goToDate(String sDate, WebElement dp) {
		boolean bReturn = false;
		SimpleDateFormat sd = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat month = new SimpleDateFormat("MMM");
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat title = new SimpleDateFormat("EEEEE, MMMMM dd, yyyy");
		Date goToDate = null;

		try {
			goToDate = format.parse(sDate);
			Calendar cal = Calendar.getInstance();
			Calendar cGoToDate = Calendar.getInstance();
			cGoToDate.setTime(goToDate);

			if (dp != null) {
				WebElement selected = WebElementUtils.getChildElement(dp, By.cssSelector(".k-state-focused"));
				if (selected == null){
					selected = WebElementUtils.getChildElement(dp, By.cssSelector(".k-state-selected"));
				}
				String sCurrentDate = WebElementUtils.getChildElement(selected, By.tagName("a")).getAttribute("title");
				cal.setTime(title.parse(sCurrentDate));

				WebElement dateYear = WebElementUtils
						.waitAndFindDisplayedElement(B2WMaintain.getB2WScheduleDatePickerMonthDate());
				// if months and year don't match we have to click month/year at
				// least
				// once

				WebElementUtils.clickElement(dateYear);

				// if the year doesn't match we click again to get years
				if (cGoToDate.get(Calendar.YEAR) != cal.get(Calendar.YEAR)) {

					WebElementUtils.clickElement(dateYear);
					TaskUtils.sleep(1000);
					// go to the year

					//// a[@data-value='2016/0/1']
					// a[@data-value='2017/0/1']
					WebElement cYear = WebElementUtils
							.findElement(By.xpath("//a[@data-value='" + year.format(cGoToDate.getTime()) + "/0/1']"));
					if (cYear != null) {
						WebElementUtils.clickElement(cYear);
					} else {
						log.debug("The Year has returned null");
					}

				}
				TaskUtils.sleep(1000);
				// go to the month we want
				WebElement cMonth = WebElementUtils.waitAndFindDisplayedElement(
						By.xpath("//a[contains(.,'" + month.format(cGoToDate.getTime()) + "')]"));
				WebElementUtils.clickElement(cMonth);

			}
			TaskUtils.sleep(2000);
			// go to the date we want
			WebElement day = WebElementUtils
					.waitAndFindDisplayedElement(By.xpath("//a[@title='" + sd.format(cGoToDate.getTime()) + "']"));
			bReturn = WebElementUtils.clickElement(day);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return bReturn;

	}
	public boolean waitForPageNotBusy(int iSecs) {
		boolean bReturn = false;
		// seconds need to muliply
		iSecs = iSecs * 20;
		int iTrys = 0;
		while (!bReturn && iTrys < iSecs) {
			try {
				WebElement el = BrowserUtils.getDriver().findElement(B2WEquipment.getKendoPageLoading());
				TaskUtils.sleep(100);
				if (!el.isDisplayed()){
					bReturn = true;
					log.debug("Element is not displayed");
					break;
				}
				iTrys++;

			} catch (NoSuchElementException e) {
				log.warn("Page not Busy no such element exception");
				bReturn = true;
			}catch (StaleElementReferenceException e){
				log.debug("Caught a stale element exception");
				TaskUtils.sleep(250);
				bReturn =true;
			}
		}
		double iSec = (iTrys * 100);
		double iSeconds = iSec / 1000;
		if (!bReturn){
			TaskUtils.logScreenCapture();
			log.info("Page waited as long as: "+iSeconds + " Seconds");
		}else{
			log.info("Page is done loading. waited: "+iSeconds + " Seconds");
		}
		waitForAjax();
		return bReturn;
		
	}
	private void waitForAjax() {
		int iTimeout = 0;
		while (true) {
			Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) BrowserUtils.getDriver()).executeScript("return jQuery.active == 0");
			if (ajaxIsComplete && iTimeout < 20) {
				log.debug("Wait for Ajax done");
				break;
			}
			log.debug("Wait for Ajax "+iTimeout);
			iTimeout++;
			TaskUtils.sleep(500);
		}
	}
	
	protected boolean setTextArea(WebElement el, String sLabel, String sText){
		boolean bReturn = false;
		WebElement label = WebElementUtils.getChildElementContainsText(el, By.tagName("label"), sLabel);
		WebElement dd = WebElementUtils.getChildElement(WebElementUtils.getParentElement(label), By.tagName("textarea"));
		if (dd != null){
			bReturn = WebElementUtils.sendKeys(dd, sText);
		}
		return bReturn;

	}
	
	protected boolean setText(WebElement el, String sLabel, String sText){
		boolean bReturn = false;
		WebElement label = WebElementUtils.getChildElementContainsText(el, By.tagName("label"), sLabel);
		if (label != null) {
			WebElement dd = WebElementUtils.getChildElement(WebElementUtils.getParentElement(label), B2WMaintain.getKendoInputTextBox());
			WebElementUtils.clickElement(dd);
			bReturn = WebElementUtils.sendKeys(dd, sText);
		}
		return bReturn;
	}
	public boolean clickConfirmYes() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoConfirmYesButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	protected boolean clickFinish() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoLargeFinishButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	
	public boolean clickDone() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoLargeDoneButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	public boolean clickConfirmNo() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoConfirmNoButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	
	
	protected boolean setNotes(String sText){
		boolean bReturn = false;
		List<WebElement> iframes = BrowserUtils.getDriver().findElements(By.tagName("iframe"));
		for (WebElement iframe : iframes) {
			if (iframe.isDisplayed()==true){
				// we want this one.
				WebDriver driver = BrowserUtils.getDriver().switchTo().frame(iframe);
				WebElement body = driver.findElement(By.tagName("body"));
				WebElementUtils.clickElement(body);
				body.clear();
				bReturn = WebElementUtils.sendKeys(body, sText);
				BrowserUtils.getDriver().switchTo().defaultContent();
				break;
			}
		}
		return bReturn;
	}
	
	protected boolean setNotesForItem(String sText) {
		boolean bReturn = false;
		List<WebElement> displayedFrames = new ArrayList<WebElement>();
		List<WebElement> iframes = BrowserUtils.getDriver().findElements(By.tagName("iframe"));
		for (WebElement iframe : iframes) {
			if (iframe.isDisplayed() == true) {
				// we want this one.
				displayedFrames.add(iframe);
			}
		}
		WebDriver driver = BrowserUtils.getDriver().switchTo().frame(displayedFrames.get(displayedFrames.size() - 1));
		WebElement body = driver.findElement(By.tagName("body"));
		WebElementUtils.clickElement(body);
		body.clear();
		bReturn = WebElementUtils.sendKeys(body, sText);
		BrowserUtils.getDriver().switchTo().defaultContent();

		return bReturn;
	}

	public ArrayList<String> getItemsFromDropDown() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> items = getKendoDropDownItems();
		Iterator<WebElement> iterElements = items.iterator();
		while (iterElements.hasNext()) {
			WebElement ddItem = iterElements.next();
			al.add(ddItem.getText());
		}
		return al;
	}
	
	public List<WebElement> getKendoDropDownItems() {
		List<WebElement> dropdown = new ArrayList<WebElement>();
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		log.debug("There are "+list.size() + " to find the correct drop down");
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement e = iter.next();
			String hidden = e.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				dropdown = e.findElements(B2WEquipment.getKendoDropDownItem());
				break;
			}
			
		}
		return dropdown;
		
	}
	public WebElement getDisplayedWindow() {
		WebElement window = null;
		List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindow());
		Iterator<WebElement> iter = windows.iterator();
		while (iter.hasNext()){
			WebElement temp = iter.next();
			if (temp.isDisplayed()){
				WebElement el = WebElementUtils.getChildElement(temp, B2WMaintain.getKendoWindowTitle());
				log.debug("Displayed window -> "+el.getText());
				window = temp;
				break;
			}
		}
		return window;
	}

}
