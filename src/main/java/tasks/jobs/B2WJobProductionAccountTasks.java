package tasks.jobs;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;

public class B2WJobProductionAccountTasks extends B2WJobsTasks {
	
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
	
	public String getTrackingID() {
		return getJobProductionAccountView(0);
	}
	public String getSupervisorProjectedUnitCost() {
		return getJobProductionAccountView(1);
	}
	public String getAccountID() {
		return getJobProductionAccountView(2);
	}
	public String getManagerProjectedUnitCost () {
		return getJobProductionAccountView(3);
	}
	public String getDescription() {
		return getJobProductionAccountView(4);
	}
	public String getEstimatedQuantity () {
		return getJobProductionAccountView(5);
	}
	public String getUnitOfMeasure() {
		return getJobProductionAccountView(6);
	}
	public String getChangeOrderQuantity(){
		return getJobProductionAccountView(7);
	}
	public String getEstimatedProductionRate(){
		return getJobProductionAccountView(8);
	}
	public String getTotalEstimatedQuantity(){
		return getJobProductionAccountView(9);
	}
	public String getComplete(){
		return getJobProductionAccountView(10);
	}
	public String getTotalReportedQuantity(){
		return getJobProductionAccountView(11);
	}
	
	
	public String getJobProductionAccountView(int i){
		String s = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateTrackingAccountsVerification());
		if (el != null){
				List<WebElement> trs = WebElementUtils.getChildElements(el, By.cssSelector("td.contentCell"));
				if (i < trs.size()){
					s = trs.get(i).getText();
				}
		}
		
		return s;
	}
	
	public String getEstimatedUnitCost() {
		return getEstimatedSummary(0);
	}
	public String getChangeOrderUnitCost() {
		return getEstimatedSummary(1);
	}
	public String getTotalEstimatedUnitCost() {
		return getEstimatedSummary(2);
	}
	public String getEstimatedTotalCost() {
		return getEstimatedSummary(3);
	}
	public String getChangeOrderTotalCost() {
		return getEstimatedSummary(4);
	}
	public String getTotalEstimatedTotalCost() {
		return getEstimatedSummary(5);
	}
	

	public String getEstimatedSummary(int i){
		String s = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemView());
		if (el != null){
			WebElement box = WebElementUtils.getChildElements(el, By.cssSelector("div.box")).get(1);
			if (box != null){
				List<WebElement> trs = WebElementUtils.getChildElements(box, By.cssSelector("td.contentCell"));
//				for (int z = 0; z < trs.size(); z++){
//					System.out.println(z + " "+trs.get(z).getText());
//				}
				
				if (i < trs.size()){
					s = trs.get(i).getText();
				}
			}
		}
		
		return s;
	}

	public String getReportedSummary(int i){
		String s = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemView());
		if (el != null){
			WebElement box = WebElementUtils.getChildElements(el, By.cssSelector("div.box")).get(2);
			if (box != null){
				List<WebElement> trs = WebElementUtils.getChildElements(box, By.cssSelector("td.contentCell"));
				for (int z = 0; z < trs.size(); z++){
					System.out.println(z + " "+trs.get(z).getText());
				}
				
				if (i < trs.size()){
					s = trs.get(i).getText();
				}
			}
		}
		
		return s;
	}
}
