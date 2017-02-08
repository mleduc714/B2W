package tasks.jobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;
import tasks.resources.B2WResourceTasks;
import tasks.util.StringUtils;
import tasks.util.TaskUtils;

public class B2WJobOverheadAccountTasks extends B2WResourceTasks {	
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
	}
	
	public String getOverheadAccountInfo(int i){
		String s = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemView());
		if (el != null){
			WebElement box = WebElementUtils.getChildElements(el, By.cssSelector("div.box")).get(0);
			if (box != null){
				List<WebElement> trs = WebElementUtils.getChildElements(box, By.cssSelector("td.contentCell"));
				
				if (i < trs.size()){
					s = trs.get(i).getText();
				}
			}
		}
		
		return s;
	}
	public String getTrackingID() {
		return getOverheadAccountInfo(0);
	}
	public String getAccountID() {
		return getOverheadAccountInfo(2);
	}
	public String getDescription() {
		return getOverheadAccountInfo(4);
	}
	public String getTotalEstimatedHours() {
		return getOverheadAccountInfo(5);
	}
	public String getValueType() {
		return getOverheadAccountInfo(6);
	}
	public String getTotalReportedHours() {
		return getOverheadAccountInfo(7);
	}
	public String getCostCalcType() {
		return getOverheadAccountInfo(8);
	}
	public String getUnitCost() {
		return getOverheadAccountInfo(9);
	}
	public String getDefaultValue() {
		return getOverheadAccountInfo(10);
	}
	public String getComplete() {
		return getOverheadAccountInfo(12);
	}
	public String getChangeOrderHours() {
		return getOverheadAccountInfo(3);
	}
	public String getEstimatedHours() {
		return getOverheadAccountInfo(1);
	}
	public String getEstimatedSummaryInfo(int i){
		String s = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemView());
		if (el != null){
			WebElement box = WebElementUtils.getChildElements(el, By.cssSelector("div.box")).get(1);
			if (box != null){
				List<WebElement> trs = WebElementUtils.getChildElements(box, By.tagName("td"));
				if (i < trs.size()){
					s = trs.get(i).getText();
				}
			}
		}
		
		return s;
	}
	
	
	public String getUnitCostEstimated() {
		return getEstimatedSummaryInfo(1);
	}
	public String getUnitCostChangeOrder() {
		return getEstimatedSummaryInfo(2);
	}
	public String getUnitCostTotalEstimated() {
		return getEstimatedSummaryInfo(3);
	}
	public String getTotalCostEstimated() {
		return getEstimatedSummaryInfo(6);
	}
	public String getTotalCostChangeOrder() {
		return getEstimatedSummaryInfo(7);
	}
	public String getTotalCostTotalEstimated() {
		return getEstimatedSummaryInfo(8);
	}
	public boolean editJobOverheadAccountByTrackingID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobOverheadAccountTrackingID(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobOverheadAccountEdit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobProductionAccountTrackingID());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	public boolean deleteJobOverheadAccountByTrackingID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobOverheadAccountTrackingID(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobOverheadAccountDelete());
			WebElementUtils.clickElement(edits.get(iNumber));
			Alert alert = TaskUtils.getAlertDialog();
			if (alert != null){
				alert.accept();
				bReturn &= true;
			}
			
		}
		return bReturn;
	}
	public boolean openJobOverheadAccountByTrackingID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobOverheadAccountTrackingID(), s);
		if (el != null){
			
			bReturn = WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getJobOverheadAccountDetails());
			bReturn = waitForThis != null;
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
	
	public boolean openEstimateItemCostBreakdownByID(String sID){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateItemCostBreakdownID(), sID);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
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
	
	public ArrayList<String> getJobOverheadAccountTrackingIDs() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> ids = WebElementUtils.findElements(B2WJobs.getB2WJobOverheadAccountTrackingID());
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			al.add(sText);
		}
		return al;
	}
	public String getEstimated(String sItemID){
		String s = "";
		int iIndex = getJobOverheadAccountTrackingIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2wJoboverheadaccountgridviewoverheadestimated()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getReported(String sItemID){
		String s = "";
		int iIndex = getJobOverheadAccountTrackingIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2wJoboverheadaccountgridviewoverheadreported()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getPercentOfEstimate(String sItemID){
		String s = "";
		int iIndex = getJobOverheadAccountTrackingIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2wJoboverheadaccountgridviewoverheadpercentcomplete()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getComplete(String sItemID){
		String s = "";
		int iIndex = getJobOverheadAccountTrackingIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2wJoboverheadaccountgridviewoverheadcomplete()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
}
