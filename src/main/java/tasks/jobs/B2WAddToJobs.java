package tasks.jobs;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobsDialogs;
import tasks.WebElementUtils;
import tasks.jobs.B2WJobsTasks.JOBSDIALOG;

public class B2WAddToJobs {
	
	public JOBSDIALOG dialog;
	private String searchID;
	private String selectID;
	private By search = null;
	private By select = null;
	private By searchbutton = null;
	private By selectbutton = null;
	private By addbutton = null;
	private By cancelbutton = null;
	private By gridview = null;
	private By gridcheckbox = null;
	
	Logger log = Logger.getLogger(B2WAddToJobs.class);
	
	public B2WAddToJobs(JOBSDIALOG dialog) {
		
		switch (dialog){
		case ADDMATERIALS:
			gridview = B2WJobsDialogs.getB2WJobsaddmaterialsgridview();
			gridcheckbox = B2WJobsDialogs.getB2WJobsaddmaterialsgridviewchkbox();
			break;
		case ADDSUBCONTRACTORS:
			gridview = B2WJobsDialogs.getB2WJobsaddsubcontractorsgridview();
			gridcheckbox =  B2WJobsDialogs.getB2WJobsaddsubcontractorsgridviewchkbox();
			break;
		case ADDTRUCKINGSUBCONTRACTORS:
			gridview = B2WJobsDialogs.getB2WJobsaddtrucksubcontractorsgridview();
			gridcheckbox =  B2WJobsDialogs.getB2WJobsaddtrucksubcontractorsgridviewchkbox();
			break;
		case ADDVENDORS:
			gridview = B2WJobsDialogs.getB2WJobsaddvendorsgridview();
			gridcheckbox =  B2WJobsDialogs.getB2WJobsaddvendorsgridviewchkbox();
			break;
		}
		
		search = B2WJobsDialogs.getB2WJobsaddSearchText();
		select = B2WJobsDialogs.getB2WJobsaddSelectText();
		searchbutton = B2WJobsDialogs.getB2WJobsaddsearchbutton();
		selectbutton = B2WJobsDialogs.getB2WJobsaddselectbutton();
		addbutton = B2WJobsDialogs.getB2WJobsaddbutton();
		cancelbutton = B2WJobsDialogs.getB2WJobscancelbutton();

	}
	
	public boolean waitForDialogToAppear() {
		return WebElementUtils.waitAndFindDisplayedElement(gridview) != null;
	}
	
	public boolean setSearchText(String sText){
		boolean bReturn = false;
		WebElement el = findTheDisplayedElement(WebElementUtils.findElements(search));
		if (el != null) {
			searchID = el.getAttribute("id");
			bReturn = WebElementUtils.setAttributeWithJS(searchID, "value", sText);
		}
		return bReturn;
	}
	public boolean setIDText(String sText){
		boolean bReturn = false;
		WebElement el = findTheDisplayedElement(WebElementUtils.findElements(select));
		if (el != null) {
			selectID = el.getAttribute("id");
			bReturn = WebElementUtils.setAttributeWithJS(selectID, "value", sText);
		}
		return bReturn;
	}
	public boolean clickSearchButton() {
		boolean bReturn = false;
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(gridview);
		WebElement el = findTheDisplayedElement(WebElementUtils.findElements(searchbutton));
		if (WebElementUtils.clickElement(el)){
			bReturn = WebElementUtils.waitForElementStale(grid, WebElementUtils.SHORT_TIME_OUT);
		}
		return bReturn;
	}

	public boolean clickSelectButton() {
		boolean bReturn = false;
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(gridview);
		WebElement checkbox = WebElementUtils.findElement(gridcheckbox);
		if (checkbox == null) {
			log.debug("Did not find any items in the search");

		} else {
			WebElement el = findTheDisplayedElement(WebElementUtils.findElements(selectbutton));
			if (WebElementUtils.clickElement(el)) {
				bReturn = WebElementUtils.waitForElementStale(grid, WebElementUtils.SHORT_TIME_OUT);
			}
		}
		return bReturn;
	}

	public void clickAddButton() {
		WebElement grid = WebElementUtils.findElement(By.className("grid"));
		WebElement el = findTheDisplayedElement(WebElementUtils.findElements(addbutton));
		if (WebElementUtils.clickElement(el)){
			// when this is stale it means that grid has been updated
			WebElementUtils.waitForElementStale(grid, WebElementUtils.LONG_TIME_OUT);
			
		}

	}
	
	public void clickCancelButton() {
		WebElement el = findTheDisplayedElement(WebElementUtils.findElements(cancelbutton));
		WebElementUtils.clickElement(el);
	}
	
	private WebElement findTheDisplayedElement(List<WebElement> list) {
		WebElement el = null;
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			el = iter.next();
			if (el.isDisplayed()) {
				break;
			}
		}
		return el;
	}
	
	
	
	
		
//	public boolean isAnItemChecked() {
//	
//		boolean bReturn = false;
//		try {
//		List<WebElement> ls = WebElementUtils.waitAndFindDisplayedElements(gridcheckbox);
//		Iterator<WebElement> iter = ls.iterator();
//		while (iter.hasNext()){
//			
//			WebElement el = iter.next();
//			WebElementUtils.getAllInfo(el);
//			String sChecked = el.getAttribute("checked");
//			if (sChecked!=null){
//				bReturn = true;
//				break;
//			}
//		}
//		} catch(StaleElementReferenceException e){
//			log.warn("Caught a stale element exception");
//			return isAnItemChecked();
//		}
//		return bReturn;
//	}

	
}