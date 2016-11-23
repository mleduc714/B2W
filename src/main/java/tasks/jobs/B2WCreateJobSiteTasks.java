package tasks.jobs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;
import tasks.resources.B2WPlaceTasks;

public class B2WCreateJobSiteTasks extends B2WJobsTasks{

	Logger log = Logger.getLogger(B2WCreateJobSiteTasks.class);
	B2WPlaceTasks b2wPlace = new B2WPlaceTasks();

	public boolean setJobSiteAddress(String sText) {
		return b2wPlace.setLocationAddress1(sText);
	}

	public boolean setJobSiteCity(String sText) {
		return b2wPlace.setLocationCity(sText);
	}

	public boolean setJobSiteState(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobsSiteState());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setJobSiteZip(String sText) {
		return b2wPlace.setLocationPostalCode(sText);
	}

	public boolean setJobCountry(String sText) {
		return b2wPlace.setLocationCountry(sText);
	}

	public boolean setJobSiteDescription(String sDesc) {
		return b2wPlace.setDescription(sDesc);
	}

	public boolean setJobSiteSupervisor(String sText) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobSiteSupervisorDD(), sText);
	}

	public boolean setJobSiteStartDate(String sText) {
		return b2wPlace.setStartDate(sText);
	}

	public boolean setJobSiteDurationType(String sText) {
		return b2wPlace.setDurationType(sText);
	}

	public boolean setJobSiteNonWorkingDayMonday(boolean bCheck) {
		return b2wPlace.setNonWorkingDayMonday(bCheck);
	}

	public boolean setJobSiteNonWorkingDayTuesday(boolean bCheck) {
		return b2wPlace.setNonWorkingDayTuesday(bCheck);
	}

	public boolean setJobSiteNonWorkingDayWednesday(boolean bCheck) {
		return b2wPlace.setNonWorkingDayWednesday(bCheck);
	}

	public boolean setJobSiteNonWorkingDayThursday(boolean bCheck) {
		return b2wPlace.setNonWorkingDayThursday(bCheck);
	}

	public boolean setJobSiteNonWorkingDayFriday(boolean bCheck) {
		return b2wPlace.setNonWorkingDayFriday(bCheck);
	}

	public boolean setJobSiteNonWorkingDaySaturday(boolean bCheck) {
		return b2wPlace.setNonWorkingDaySaturday(bCheck);
	}

	public boolean setJobSiteNonWorkingDaySunday(boolean bCheck) {
		return b2wPlace.setNonWorkingDaySunday(bCheck);
	}

	public boolean setShowOnJobBoard(boolean bCheck) {
		return checkBox(B2WJobs.getB2WJobSiteShowOnJobBoard(), bCheck);
	}
	public boolean saveJobSite() {
		return b2wPlace.clickSaveBin();
	}

}
