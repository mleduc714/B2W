package tasks.jobs;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;

public class B2WCreateJobProductionAccountTasks extends B2WJobsTasks {
	
	public boolean setJobProductionAccountTrackingIDText(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobProductionAccountTrackingID());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean selectJobProductionAccountIDFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobProductionAccountIDDD(), sText);
	}
	public String selectJobProductionAccountID() {
		return WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WJobProductionAccountIDDD());
	}
	public boolean selectJobProductionUnitOfMeasureFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobProductionUnitOfMeasureDD(), sText);
	}
	public boolean selectJobProductionRateUnitOfMeasureFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobProductionRateUnitOfMeasure(), sText);
	}
	public boolean selectJobProductionEstimatedProductionRateFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobProductionEstimatedProductionRate(), sText);
	}
	public boolean setJobProductionSupervisorProjectedUnitCost(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionsupervisorprojectedunitcost());
		el.clear();
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionManagerProjectedUnitCost (String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionmanagerprojectedunitcost());
		el.clear();
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionEstimatedQuantity(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionmanagerestimatedquanity());
		el.clear();
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionChangeOrderQuantity (String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionchangeorderquanitytextbox());
		el.clear();
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionAccountDescriptionText(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobProductionAccountDescription());
		el.clear();
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setJobProductionAccountComplete(boolean bCheck){
		return checkBox(B2WJobs.getB2WJobProductionCompleteCheckBox(), bCheck);
	}
	
	public boolean editJobProductionAccount() {
		boolean bReturn = false;
		if (clickTopEditButton()){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobProductionAccountTrackingID()) != null;
		}
		return bReturn;
	}
	
	public boolean deleteEstimateItemCostBreakdownByID(String sID){
		boolean bReturn = false;
		int iNumber = -1;
		List<WebElement> ids = WebElementUtils.findElements(B2WJobs.getB2WEstimateItemCostBreakdownID());
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			if (sText.equals(sID)){
				iNumber = i;
				break;
			}
		}
		if (iNumber != -1){
			bReturn = WebElementUtils.clickElement(WebElementUtils.findElements(B2WJobs.getB2WEstimateItemCostItemDelete()).get(iNumber));
			Alert alert = WebElementUtils.waitForAndGetAlertDialog(WebElementUtils.MEDIUM_TIME_OUT);
			if (alert != null) {
				alert.accept();
				bReturn &= true;
				waitForProcessingDialogToClear();
			}

		}
		return bReturn;
	}
	
	public boolean deleteEstimateItemCostBreakdownByDescription(String sDesc){
		boolean bReturn = false;
		int iNumber = -1;
		List<WebElement> ids = WebElementUtils.findElements(B2WJobs.getB2WEstimateItemCostItemDescription());
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			if (sText.equals(sDesc)){
				iNumber = i;
				break;
			}
		}
		if (iNumber != -1){
			bReturn = WebElementUtils.clickElement(WebElementUtils.findElements(B2WJobs.getB2WEstimateItemCostItemDelete()).get(iNumber));
			Alert alert = WebElementUtils.waitForAndGetAlertDialog(WebElementUtils.MEDIUM_TIME_OUT);
			if (alert != null) {
				alert.accept();
				bReturn &= true;
				waitForProcessingDialogToClear();
			}

		}
		return bReturn;
	}

}
