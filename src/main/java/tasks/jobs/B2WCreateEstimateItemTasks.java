package tasks.jobs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import appobjects.setup.B2WSetup;
import appobjects.setup.B2WSetupUsers;
import tasks.WebElementUtils;
import tasks.resources.B2WResourceTasks;
import tasks.util.TaskUtils;

public class B2WCreateEstimateItemTasks extends B2WResourceTasks {
	
	public boolean setEstimateItemNumber(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemNumber());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateEstimatedQuantity(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateEstimatedQuantity());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateItemID(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemID());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateChangeOrderQuantity(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateChangeOrderQuantity());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateDescription(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateDescription());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateUnitBidPriceEstimated(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateUnitBidPriceEstimated());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText+Keys.TAB);
		}
		return bReturn;
	}
	
	public boolean setEstimateUnitBidPriceChangeOrder(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateUnitBidPriceChangeOrder());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateTotalBidPriceEstimated(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateTotalBidPriceEstimated());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateTotalBidPriceChangeOrder(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateTotalBidPriceChangeOrder());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean clickAddChangeOrderCostBreakdownButton() {
		return WebElementUtils.clickElement(B2WJobs.getB2WAddChangeOrderCostBreakdown());
	}
	
	public boolean setEstimateUnitOfMeasure(String sText){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WEstimateUnitOfMeasure(), sText);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WEstimateUnitOfMeasure()).equals(sText);
	}
	
	public boolean clickEditButton(){
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetupUsers.getB2WUserEditButton())){
			bReturn = waitForProcessingDialogToClear();
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateItemNumber())!=null;
		}
		return bReturn;
	}
	public boolean clickBottomSaveButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetup.getBottomSaveButton())) {
			TaskUtils.sleep(500);
			bReturn = waitForProcessingDialogToClear();
			
		}
		return bReturn;
	}
	
}
