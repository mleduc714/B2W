package tasks.jobs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.jobs.B2WJobs;
import appobjects.resources.B2WPlaces;
import appobjects.setup.B2WSetup;
import appobjects.setup.B2WSetupUsers;
import tasks.WebElementUtils;
import tasks.resources.B2WResourceTasks;
import tasks.util.StringUtils;
import tasks.util.TaskUtils;

public class B2WEstimateItemTasks extends B2WResourceTasks {
	
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
	public boolean clickAddCostBreakdownElement() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WCreatenewcostbreakdownelement())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WCreatenewcostbreaddownid()) != null;
		}
		return bReturn;
	}
	public boolean openEstimateItemByItemID(String b2w_jobsestimateitemid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateItemIDs(), b2w_jobsestimateitemid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateItemView());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openEstimateItemByDescription(String b2w_jobsestimatedescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateItemDescription(), b2w_jobsestimatedescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateItemView());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean editEstimateItemByDescription(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateItemDescription(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WSetupUsers.getB2WUserListingEdit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateDescription());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	public boolean editEstimateItemByItemID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateItemIDs(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WSetupUsers.getB2WUserListingEdit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateDescription());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
/*	0 ItemNumber
	1 Estimated QTY
	2 ItemID
	3 Change Order QTY
	4 Desc
	5 Current QTY
	6 Unit of Measure
	7 Reported QTY
	8 Revenue to Date*/
	
	public String getEstimateItemNumber(){
		return getEstimateItemViewTop(0);
	}
	public String getEstimatedQTY(){
		return getEstimateItemViewTop(1);
	}
	public String getEstimateItemID(){
		return getEstimateItemViewTop(2);
	}
	public String getEstimateChangeOrderQTY(){
		return getEstimateItemViewTop(3);
	}
	public String getEstimateDescription(){
		return getEstimateItemViewTop(4);
	}
	public String getEstimateCurrentQTY(){
		return getEstimateItemViewTop(5);
	}
	public String getEstimateUnitOfMeasure(){
		return getEstimateItemViewTop(6);
	}
	public String getEstimateReportedQTY(){
		return getEstimateItemViewTop(7);
	}
	public String getEstimateRevenueToDate(){
		return getEstimateItemViewTop(8);
	}

	public String getUnitBidPriceEstimated() {
		return getEstimateItemViewBottom(1);
	}
	public String getUnitBidPriceChangeOrder() {
		return getEstimateItemViewBottom(2);
	}
	public String getUnitBidPriceCurrent() {
		return getEstimateItemViewBottom(3);
	}
	public String getTotalBidPriceEstimated() {
		return getEstimateItemViewBottom(6);
	}
	public String getTotalBidPriceChangeOrder() {
		return getEstimateItemViewBottom(7);
	}
	public String getTotalBidPriceCurrent() {
		return getEstimateItemViewBottom(8);
	}
	public String getEstimatedUnitCostEstimated() {
		return getEstimateItemViewBottom(11);
	}
	public String getEstimatedUnitCostChangeOrder() {
		return getEstimateItemViewBottom(12);
	}
	public String getEstimatedUnitCostCurrent() {
		return getEstimateItemViewBottom(13);
	}
	public String getEstimatedTotalCostEstimated() {
		return getEstimateItemViewBottom(16);
	}
	public String getEstimatedTotalCostChangeOrder() {
		return getEstimateItemViewBottom(17);
	}
	public String getEstimatedTotalCostCurrent() {
		return getEstimateItemViewBottom(18);
	}
	
	
	
	private String getEstimateItemViewTop(int i){
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
	private String getEstimateItemViewBottom(int i){
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
	
	public ArrayList<String> getEstimatedByCostBreakdownIDs() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WCommonObjects.getB2WPageContentGrid());
		List<WebElement> ids = WebElementUtils.getChildElements(el, B2WJobs.getB2WEstimateItemIDs());
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			al.add(sText);
		}
		return al;
	}

	public ArrayList<String> getEstimatedByDescription() {
		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WCommonObjects.getB2WPageContentGrid());
		List<WebElement> ids = WebElementUtils.getChildElements(el, B2WJobs.getB2WEstimateItemDescription());
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			al.add(sText);
		}
		return al;
	}
	
	public String getEstimatedQuantity(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobsestimateoriginalquantity()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedChangeOrderQuantity(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobestimatechangeorderquanity()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedCurrentQuantity(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobsestimatequantity()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedUnitOfMeasure(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobsestimateunitofmeasure()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedReportedQuantity(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobestimatereportquanity()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedRemainingQuantity(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobsestimateremainingquanity()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedUnitPrice(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobsestimateunitprice()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedTotalPrice(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobsestimatetotalprice()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public String getEstimatedRevenueToDate(String sItemID) {
		String s = "";
		int iIndex = getEstimatedByCostBreakdownIDs().indexOf(sItemID);
		if (iIndex != -1) {
			WebElement el = WebElementUtils.findElements(B2WJobs.getB2WJobsestimatebillrevenue()).get(iIndex);
			if (el != null) {
				s = el.getText();
			}
		}
		return s;
	}
	public boolean editEstimatedByCostBreakdownID(String sID){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemCostBreakdownGridView());
		List<WebElement> ids = WebElementUtils.getChildElements(el, By.tagName("a"));
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			if (sText.equals(sID)){
				WebElement parent = WebElementUtils.getParentElement(WebElementUtils.getParentElement(ids.get(i)));
				WebElement edit = WebElementUtils.getChildElement(parent, By.className("edit"));
				bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(edit, By.tagName("a")));
				break;
			}
		}
		return bReturn;
	}
	
	public boolean deleteEstimatedByCostBreakdownID(String sID){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemCostBreakdownGridView());
		List<WebElement> ids = WebElementUtils.getChildElements(el, By.tagName("a"));
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			if (sText.equals(sID)){
				WebElement parent = WebElementUtils.getParentElement(WebElementUtils.getParentElement(ids.get(i)));
				WebElement edit = WebElementUtils.getChildElement(parent, By.className("delete"));
				bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(edit, By.tagName("a")));
				Alert alert = TaskUtils.getAlertDialog();
				if (alert != null){
					alert.accept();
					bReturn &= true;
				}
				break;
			}
		}
		return bReturn;
	}
	
	public boolean saveEstimateItem() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WPlaces.getTopSavePanel());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			TaskUtils.sleep(500);
			bReturn &= waitForProcessingDialogToClear();
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateItemView()) != null;
		}
		return bReturn;
	}
	
	
}
