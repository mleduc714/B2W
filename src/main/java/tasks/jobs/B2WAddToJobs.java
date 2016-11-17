package tasks.jobs;

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
	private By bydialog = null;
	
	Logger log = Logger.getLogger(B2WAddToJobs.class);
	
	public B2WAddToJobs(JOBSDIALOG dialog) {
		
		switch (dialog){
		case ADDMATERIALS:
			gridview = B2WJobsDialogs.getB2WJobsaddmaterialsgridview();
			gridcheckbox = B2WJobsDialogs.getB2WJobsaddmaterialsgridviewchkbox();
			bydialog = B2WJobsDialogs.getB2WJobsAddMaterialsDialog();
			break;
		case ADDSUBCONTRACTORS:
			gridview = B2WJobsDialogs.getB2WJobsaddsubcontractorsgridview();
			gridcheckbox =  B2WJobsDialogs.getB2WJobsaddsubcontractorsgridviewchkbox();
			bydialog = B2WJobsDialogs.getB2WJobsAddSubcontractorDialog();
			break;
		case ADDTRUCKINGSUBCONTRACTORS:
			gridview = B2WJobsDialogs.getB2WJobsaddtrucksubcontractorsgridview();
			gridcheckbox =  B2WJobsDialogs.getB2WJobsaddtrucksubcontractorsgridviewchkbox();
			bydialog = B2WJobsDialogs.getB2WJobsAddTruckingSubcontractorDialog();
			break;
		case ADDVENDORS:
			gridview = B2WJobsDialogs.getB2WJobsaddvendorsgridview();
			gridcheckbox =  B2WJobsDialogs.getB2WJobsaddvendorsgridviewchkbox();
			bydialog = B2WJobsDialogs.getB2WJobsAddVendorDialog();
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
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement el =  WebElementUtils.getChildElement(parent, search);
		if (el != null) {
			searchID = el.getAttribute("id");
			bReturn = WebElementUtils.setAttributeWithJS(searchID, "value", sText);
		}
		return bReturn;
	}
	public boolean setIDText(String sText){
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement el =  WebElementUtils.getChildElement(parent, select);
		if (el != null) {
			selectID = el.getAttribute("id");
			bReturn = WebElementUtils.setAttributeWithJS(selectID, "value", sText);
		}
		return bReturn;
	}
	public boolean clickSearchButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(gridview);
		WebElement el = WebElementUtils.getChildElement(parent, searchbutton);
		if (WebElementUtils.clickElement(el)){
			bReturn = WebElementUtils.waitForElementStale(grid, WebElementUtils.SHORT_TIME_OUT);
		}
		return bReturn;
	}

	public boolean clickSelectButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(gridview);
		WebElement checkbox = WebElementUtils.findElement(gridcheckbox);
		if (checkbox == null) {
			log.debug("Did not find any items in the search");

		} else {
			WebElement el = WebElementUtils.getChildElement(parent, selectbutton);
			if (WebElementUtils.clickElement(el)) {
				bReturn = WebElementUtils.waitForElementStale(grid, WebElementUtils.SHORT_TIME_OUT);
			}
		}
		return bReturn;
	}

	public boolean clickAddButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement el = WebElementUtils.getChildElement(parent, addbutton);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	
	public void clickCancelButton() {
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement el = WebElementUtils.getChildElement(parent, cancelbutton);
		WebElementUtils.clickElement(el);
	}
	
//	private WebElement findTheDisplayedElement(List<WebElement> list) {
//		WebElement el = null;
//		Iterator<WebElement> iter = list.iterator();
//		while (iter.hasNext()) {
//			el = iter.next();
//			if (el.isEnabled()) {
//				break;
//			}
//		}
//		return el;
//	}
	
	
	
	
		
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
