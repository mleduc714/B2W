package tasks.jobs;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import appobjects.resources.KendoUI;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;

public class B2WTMWorkItemTab extends B2WKendoTasks {

	Logger log = Logger.getLogger(B2WTMWorkItemTab.class);
	
	public boolean setTMWorkItemDescription(String sText) {
		return setText(sText,"Description");
	}
	public boolean setTMWorkItemTrackingID(String sText) {
		return setText(sText,"Tracking ID");
	}
	public boolean setTMWorkItemDateAdded(String sText) {
		return setText(sText,"Date Added");
	}
	public boolean setNotes(String sText){
		return setText(sText,"Notes");
	}
	public boolean selectAccountIDFromDD(String sText) {
		boolean bReturn = false;
		WebElement dropdown = findDropDown(true);
		if (WebElementUtils.clickElement(dropdown)) {
			// when we click we need to find the visble list
			List<WebElement> list = WebElementUtils.findElements(KendoUI.getKendoLists());
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()) {
				WebElement els = iter.next();
				String hidden = els.getAttribute("aria-hidden");
				if (hidden != null && hidden.equals("false")) {
					List<WebElement> items = els.findElements(KendoUI.getKendoDropDownItem());
					WebElement item = WebElementUtils.getElementWithMatchingText(items, sText, false);
					if (item != null) {
						bReturn = WebElementUtils.clickElement(item);
					} else {
						log.debug("Item with could not be found matching");
					}
				}
			}
		}

		return bReturn;
	}

	public String selectRandomAccountIDFromDD() {
		String sAccountID = "";
		WebElement dropdown = findDropDown(true);
		if (WebElementUtils.clickElement(dropdown)) {
			// when we click we need to find the visble list
			List<WebElement> list = WebElementUtils.findElements(KendoUI.getKendoLists());
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()) {
				WebElement els = iter.next();
				String hidden = els.getAttribute("aria-hidden");
				if (hidden != null && hidden.equals("false")) {
					List<WebElement> items = els.findElements(KendoUI.getKendoDropDownItem());
					Random rand = new Random();
					WebElement item = items.get(rand.nextInt(items.size()-1));
					if (item != null) {
						if (WebElementUtils.clickElement(item)){
							sAccountID = item.getText();
						}
					}

				}
			}
		}

		return sAccountID;
	}

	
	public boolean selectRequestedByFromDD(String sText) {
		boolean bReturn = false;
		WebElement dropdown = findDropDown(false);
		if (WebElementUtils.clickElement(dropdown)) {
			// when we click we need to find the visble list
			List<WebElement> list = WebElementUtils.findElements(KendoUI.getKendoLists());
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()) {
				WebElement els = iter.next();
				String hidden = els.getAttribute("aria-hidden");
				if (hidden != null && hidden.equals("false")) {
					List<WebElement> items = els.findElements(KendoUI.getKendoDropDownItem());
					WebElement item = WebElementUtils.getElementWithMatchingText(items, sText, false);
					if (item != null) {
						bReturn = WebElementUtils.clickElement(item);
					} else {
						log.debug("Item with could not be found matching");
					}
				}
			}
		}

		return bReturn;
	}

	public String selectRandomRequestedByFromDD() {
		String sName = "";
		WebElement dropdown = findDropDown(false);
		if (WebElementUtils.clickElement(dropdown)) {
			// when we click we need to find the visble list
			List<WebElement> list = WebElementUtils.findElements(KendoUI.getKendoLists());
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()) {
				WebElement els = iter.next();
				String hidden = els.getAttribute("aria-hidden");
				if (hidden != null && hidden.equals("false")) {
					List<WebElement> items = els.findElements(KendoUI.getKendoDropDownItem());
					Random rand = new Random();
					 
					WebElement item = items.get(rand.nextInt(items.size()-1));
					if (item != null) {
						if (WebElementUtils.clickElement(item)){
							sName = item.getText();
						}
					} else {
						log.debug("Item with could not be found matching");
					}
				}
			}
		}

		return sName;
	}
	
	private WebElement findDropDown(boolean bAccountID) {
		WebElement dropdown = null;

		WebElement el = WebElementUtils.findElement(KendoUI.getKendoWorkItemTable());
		if (el != null) {
			List<WebElement> dd = el.findElements(KendoUI.getKendoDropDownForTMTab());
			Iterator<WebElement> iter = dd.iterator();
			while (iter.hasNext()) {
				WebElement temp = iter.next();
				String sDropdown = temp.getAttribute("aria-owns");
				if (sDropdown.equals("AccountsDropDown_listbox") && bAccountID) {
					dropdown = temp;
					break;

				} else if (!bAccountID) {
					dropdown = temp;
					break;
				}

			}
		}
		return dropdown;
	}
	
	private boolean setText(String sText, String sField){
		boolean bReturn = false;

		List<WebElement> els = WebElementUtils.findElements(KendoUI.getKendoDescription());
		WebElement el = WebElementUtils.getElementWithWithMatchingAttribute(els, "name", sField);

		if (el != null && WebElementUtils.waitForElementIsDisplayed(el, WebElementUtils.MEDIUM_TIME_OUT)) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		} else {
			log.debug("Element was not available to send text to");
		}

		return bReturn;
	}
	
	public boolean saveTMWorkItem() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobTMWorkItemSaveButton());
		bReturn = WebElementUtils.clickElement(el);
		bReturn &= waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
		bReturn &= WebElementUtils.waitForElementInvisible(el);
		return bReturn;
	}
	
	public boolean setComplete(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobTMWorkItemCompleteCheckbox());
		WebElementUtils.getAllInfo(el);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
		}
		el = WebElementUtils.findElement(B2WJobs.getB2WJobTMWorkItemCompleteCheckbox());
		return bReturn;
		
	}
	


}
