package tasks.jobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
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
	public boolean openEstimatedByCostBreakdownID(String sID) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemCostBreakdownGridView());
		List<WebElement> ids = WebElementUtils.getChildElements(el, By.tagName("a"));
		for (int i = 0; i < ids.size(); i++){
			String sText = ids.get(i).getText();
			if (sText.equals(sID)){
				WebElementUtils.clickElement(ids.get(i));
				break;
			}
		}
		return bReturn;
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
	
	public boolean setLaborUnitCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostlaborunitcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setLaborTotalCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostlabortotalcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setRegularHours(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostregularhourstextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setOvertimeHours(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostovertimehourstextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setDoubleTimeHours(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostdoubletimehourstextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setEquipmentOwnedHours(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostequipmentownedhourstextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	
	public boolean setEquipmentRentedHours(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostequipmentrentedhourstextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setEquipmentOwnedUnitCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostequipmentownedunitcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	public boolean setEquipmentOwnedTotalCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostequipmentownedtotalcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setEquipmentRentedUnitCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostequipmentrentedunitcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	public boolean setEquipmentRentedTotalCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostequipmentrentedtotalcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	
	public boolean setSubcontractedUnitCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostsubcontractedunitcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	public boolean setSubcontractedTotalCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostsubcontractedtotalcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public boolean setMiscUnitCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostmiscellaneousunitcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	public boolean setMiscTotalCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcostmiscellaneoustotalcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	public boolean setTruckingUnitCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcosttruckingunitcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	public boolean setTruckingTotalCost(String s) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstcosttruckingtotalcosttextbox());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
			
		return bReturn;
	}
	
	public String getMaterialsOwnedUnitCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2wEstcostmaterialsownedunitcost());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	public String getMaterialsOwnedTotalCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2wEstcostmaterialsownedtotalcost());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	public String getMaterialsPurchasedUnitCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2wEstcostmaterialspurchasedunitcost());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	public String getMaterialsPurchasedTotalCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2wEstcostmaterialspurchasedtotalcost());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	public String getEstimatedUnitCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2WEstimateUnitCost());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	public String getEstimatedTotalCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2WEstimateTotalCost());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	
	
}
