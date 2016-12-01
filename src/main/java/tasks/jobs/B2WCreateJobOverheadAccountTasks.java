package tasks.jobs;

import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;

public class B2WCreateJobOverheadAccountTasks extends B2WJobsTasks {	
	public boolean setJobOverheadTrackingID(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJoboverheadtrackingidtextbox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean selectJobOverheadAccountIDFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJoboverheadaccountiddropdown(), sText);
	}
	
	public String selectJobOverheadAccountID() {
		return WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WJoboverheadaccountiddropdown());
	}

	public boolean setJobOverheadDescription(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJoboverheaddescriptiontextbox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean selectJobOverheadAccountValueTypeFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJoboverheadvaluetypedropdown(), sText);
	}
	
	public boolean selectJobOverheadAccountCostCalcDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJoboverheadtotalcostcalcdd(), sText);
	}
	public boolean setJobOverheadDefaultValue(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJoboverheadtotalcostcalcdd());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobOverheadEstimatedHours(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJoboverheadestimatedunittextbox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobOverheadChangeOrderHours(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJoboverheadchangeorderunittextbox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobOverheadPerUnitPercentage(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJoboverheadperunitpercentagetextbox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobOverheadAccountComplete(boolean bCheck){
		return checkBox(B2WJobs.getB2WJobOverheadCompleteCheckBox(), bCheck);
	}}
