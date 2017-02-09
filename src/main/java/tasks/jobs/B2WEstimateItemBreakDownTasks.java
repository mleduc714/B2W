package tasks.jobs;

import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import appobjects.setup.B2WSetup;
import tasks.WebElementUtils;
import tasks.resources.B2WResourceTasks;
import tasks.util.TaskUtils;

public class B2WEstimateItemBreakDownTasks extends B2WResourceTasks{
	
	public boolean setCostBreakDownID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreaddownid());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	public boolean setCostID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreakdowncostid());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	
	public boolean selectTrackingAccount(String s){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WCreatenewcostbreakdowntrackaccountdd(), s);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WCreatenewcostbreakdowntrackaccountdd()).equals(s);
	}
	
	public boolean selectEstimateItem(String s){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WCreatenewcostbreakdownestimateitemdropdown(), s);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WCreatenewcostbreakdownestimateitemdropdown()).equals(s);
	}
	public boolean setDescription(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreakdowndescription());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
		}
		return bReturn;
	}
	public boolean setEstimatedQuantity(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WCreatenewcostbreakdownestquantity());
		if (el != null){
			el.clear();
			bReturn = WebElementUtils.sendKeys(el, s);
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
	
	public String getEstimatedItemUnitCostBreakdownUnitCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2wEstimatedunitcostbreakdown());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	
	public String getEstimatedItemTotalCostBreakdownUnitCost() {
		String s = "";
		WebElement e = WebElementUtils.findElement(B2WJobs.getB2wEstimatedtotalcostbreakdown());
		if (e != null){
			s = e.getText();
		}
		return s;
	}
	public boolean saveEstimateItemCostBreakdown() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WSetup.getTopSaveButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			TaskUtils.sleep(500);
			bReturn &= waitForProcessingDialogToClear();
			bReturn &= WebElementUtils.waitAndFindDisplayedElements(B2WJobs.getB2WEstcostlaborunitcosttextbox()) != null;
		}
		return bReturn;
	}
	public boolean setEstimateUnitOfMeasure(String sText){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WEstimateUnitOfMeasure(), sText);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WEstimateUnitOfMeasure()).equals(sText);
	}
}
