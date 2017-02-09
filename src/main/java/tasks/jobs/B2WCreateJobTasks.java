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
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setJobProjectName(String sProjectName) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobprojectname());
		if (el != null) {
			el.clear();
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
	
	public String selectProjectManagerFromDD() {
		return WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WJobprojectmanagerdd());
	}

	public boolean setJobTitle(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobtitle());
		if (el != null) {
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setJobProjectCustomerFromDD(String sText) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobcustomerdd(), sText);
	}
	public String setJobProjectCustomerFromDD() {
		WebElementUtils.clickElement(B2WJobs.getB2WJobcustomerdd());
		return WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WJobcustomerdd());
	}

	public boolean setJobDefaultLaborRateClassFromDD(String sLaborRate) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultlaborrateclassdd(), sLaborRate);
	}
	
	public String selectJobDefaultLaborRateClassFromDD() {
		WebElementUtils.clickElement(B2WJobs.getB2WJobdefaultlaborrateclassdd());
		return WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultlaborrateclassdd());
	}
	public boolean setJobEquipmentRateClassFromDD(String sEquipmentRate) {
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultequipmentrateclass(),
				sEquipmentRate);
	}
	
	public String setJobEquipmentRateClassFromDD() {
		return WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultequipmentrateclass());
	}

	public boolean selectBusinessUnitFromDD(String sText) {
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WResources.getBusinessUnitDropDown(), sText);
		return sText.equals(WebElementUtils.getSelectedTextFromDropDown(B2WResources.getBusinessUnitDropDown()));
	}
	public boolean clickAddLaborRateButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobaddlaborrateclassesbutton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WLaborrateclassdialogpanel()) != null;
		}
		return bReturn;
	}
	
}
