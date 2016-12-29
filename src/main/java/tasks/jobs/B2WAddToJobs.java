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
		List<WebElement> checkbox = WebElementUtils.findElements(gridcheckbox);

		if (checkbox == null) {
			log.debug("Did not find any items in the search");

		} else {

			WebElement el = WebElementUtils.getChildElement(parent, selectbutton);
			if (WebElementUtils.clickElement(el)) {
				bReturn = WebElementUtils.waitForElementStale(grid, WebElementUtils.SHORT_TIME_OUT);
			}

			checkbox = WebElementUtils.findElements(gridcheckbox);
			Iterator<WebElement> iter = checkbox.iterator();
			while (iter.hasNext()){
				while (iter.hasNext()){
					WebElement chkbox = iter.next();
					if (chkbox.isSelected()){
						log.debug("checkbox is selected");
						break;
					}
				}
			}
		}
		return bReturn;
	}

	public boolean clickAddButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement el = WebElementUtils.getChildElement(parent, addbutton);
		//WebElement el = WebElementUtils.findElement(By.xpath("//a[contains(@id,'AddButton')]"));
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
			if (!bReturn){
				log.warn("Clicking the cancel button. Workaround");
				bReturn = clickCancelButton();
			}
		}
		return bReturn;
	}
	
	public boolean clickCancelButton() {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(bydialog);
		WebElement el = WebElementUtils.getChildElement(parent, cancelbutton);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	

}
