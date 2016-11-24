package tasks.jobs;

import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import appobjects.resources.B2WResources;
import tasks.WebElementUtils;

public class B2WCreateJobTasks {

	public boolean setJobNumber(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobnumber());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setJobProjectName(String sProjectName) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobprojectname());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sProjectName);
		}
		return bReturn;
	}

	public boolean setJobProjectStatusFromDD(String sText) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobstatusdd(), sText);
	}

	public boolean setProjectManagerFromDD(String sText) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobprojectmanagerdd(), sText);
	}

	public boolean setJobTitle(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobtitle());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setJobProjectCustomerFromDD(String sText) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobcustomerdd(), sText);
	}

	public boolean setJobDefaultLaborRateClassFromDD(String sLaborRate) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultlaborrateclassdd(), sLaborRate);
	}

	public boolean setJobEquipmentRateClassFromDD(String sEquipmentRate) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultequipmentrateclass(),
				sEquipmentRate);
	}

	public boolean selectBusinessUnitFromDD(String sText) {
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WResources.getBusinessUnitDropDown(), sText);
		return sText.equals(WebElementUtils.getSelectedTextFromDropDown(B2WResources.getBusinessUnitDropDown()));
	}
	
}
