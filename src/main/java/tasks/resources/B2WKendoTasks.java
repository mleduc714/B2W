package tasks.resources;

import java.util.Iterator;
import java.util.List;

import appobjects.resources.KendoUI;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WEquipment;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public abstract class B2WKendoTasks {

	Logger log = Logger.getLogger(B2WKendoTasks.class);
	
	public boolean selectItemFromDropDown(String sItem){
		boolean bReturn = false;
		// when we click we need to find the visble list
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
				if (item != null) {
					bReturn = WebElementUtils.clickElement(item);
				}else{
					log.debug("Item with could not be found matching "+sItem);
				}
			}
		}
		return bReturn;
	
	}
	public boolean waitForPageNotBusy() {
		boolean bReturn = false;
		int iTrys = 0;
		while (!bReturn && iTrys < 100) {
			try {
				BrowserUtils.getDriver().findElement(B2WEquipment.getKendoPageLoading());
				TaskUtils.sleep(100);
				iTrys++;

			} catch (NoSuchElementException e) {
				
				bReturn = true;
			}
		}
		double iSec = (iTrys * 100);
		double iSeconds = iSec / 1000;
		if (!bReturn){
			log.info("Page waited as long as: "+iSeconds + " Seconds");
		}else{
			log.info("Page is done loading. waited: "+iSeconds + " Seconds");
		}
		return bReturn;
	}
	public boolean clickAndSelectValueFromKendoFDD(WebElement dropDownElement, String sItem) {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(dropDownElement)) {
			TaskUtils.sleep(100);
			bReturn = selectItemFromFDD(sItem);
		}
		return bReturn;
	}
	public boolean sendTextAndSelectValueFromKendoFDD(WebElement dropDownElement, String sItem) {
		boolean bReturn = false;
		if (WebElementUtils.sendKeys(dropDownElement, sItem)) {
			TaskUtils.sleep(100);
			bReturn = selectItemFromFDD(sItem);
		}
		return bReturn;
	}
	public boolean selectItemFromFDD(String sItem) {
		boolean bReturn = false;
		// when we click we need to find the visible list
		List<WebElement> list = WebElementUtils.findElements(KendoUI.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext() && !bReturn) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(KendoUI.getKendoDropDownItem());
				//WebElement item = WebElementUtils.getElementWithMatchingStartsWithText(items, sItem);
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
				if (item != null) {
					//bReturn = WebElementUtils.waitForElementHasAttributeWithValue(els, "aria-hidden", "false", true, WebElementUtils.MEDIUM_TIME_OUT);
					//bReturn &= WebElementUtils.waitForElementClickable(item);
					bReturn = WebElementUtils.clickElement(item);
				}else{
					log.debug("Item with could not be found matching " + sItem);
				}
			}
		}
		if (!bReturn) log.debug("Element with value" + sItem + " could not be found.");
		return bReturn;
	}
	/*
	public boolean selectItemFromFDD(String sItem) {
		boolean bReturn = false;
		// when we click we need to find the visible list
		List<WebElement> list = WebElementUtils.findElements(KendoUI.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext() && !bReturn) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null) {
				List<WebElement> items = els.findElements(KendoUI.getKendoDropDownItem());
				//WebElement item = WebElementUtils.getElementWithMatchingStartsWithText(items, sItem);
				WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
				if (item != null) {
					bReturn = WebElementUtils.waitForElementHasAttributeWithValue(els, "aria-hidden", "false", true, WebElementUtils.MEDIUM_TIME_OUT);
					//bReturn &= WebElementUtils.waitForElementClickable(item);
					bReturn &= WebElementUtils.clickElement(item);
				}else{
					log.debug("Item with could not be found matching " + sItem);
				}
			}
		}
		if (!bReturn) log.debug("Element with value" + sItem + " could not be found.");
		return bReturn;
	}
	*/
}
