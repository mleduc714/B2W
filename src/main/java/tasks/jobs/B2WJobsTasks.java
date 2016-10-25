package tasks.jobs;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.jobs.B2WJobs;
import appobjects.resources.B2WPlaces;
import tasks.WebElementUtils;
import tasks.resources.B2WPlaceTasks;
import tasks.resources.B2WResourceTasks;
import tasks.util.TaskUtils;

public class B2WJobsTasks extends B2WResourceTasks {

	
	B2WPlaceTasks b2wPlace = new B2WPlaceTasks();
	TaskUtils tsk = new TaskUtils();
	
	/**
	 * Wait for jobs page be visible
	 * checks for the grid displayed
	 * @return
	 */
	

	public static enum JOBSDIALOG {ADDSUBCONTRACTORS, ADDTRUCKINGSUBCONTRACTORS, ADDMATERIALS, ADDVENDORS};
	
	
	public boolean jobsPageOpen() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPageContentGrid(), 30);
		if (el!=null) {
			bReturn = el.isDisplayed();
		}
		return bReturn;
		
	}
	
	public boolean clickCreateNewJob() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobsCreateNewJobButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobnumber()) != null;
		}
		return bReturn;
	}
	
	public boolean setJobNumber(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobnumber());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public String getJobNumberText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobnumbertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	
	public boolean setJobTitle(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobtitle());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public String getJobTitleText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobtitletext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	
	public boolean setProjectManagerFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobprojectmanagerdd(), sText);
	}
	
	public String getProjectManagerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJopprojectmanagertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}

	public boolean setProjectName(String sProjectName){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobprojectname());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sProjectName);
		}
		return bReturn;
	}
	
	public String getProjectNameText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobprojectnametext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public boolean setProjectStatusFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobstatusdd(), sText);
	}
	public String getProjectStatusText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobstatustext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public boolean setProjectCustomerFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobcustomerdd(), sText);
	}
	public String getCustomerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobcustomertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public boolean setDefaultLaborRateClassFromDD(String sLaborRate){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultlaborrateclassdd(), sLaborRate);
	}
	public String getDefaultLaborRateClassText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobdefaultlaborrateclasstext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public boolean setEquipmentRateClassFromDD(String sEquipmentRate){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultequipmentrateclass(), sEquipmentRate);
	}
	public String getEquipmentRateClassText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobdefaultequipmentrateclasstext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	
	public boolean setJobSiteDescription(String sDesc) {
		return b2wPlace.setDescription(sDesc);
	}
	public boolean setJobSiteSupervisor(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobSiteSupervisorDD(), sText);
	}
	public boolean setJobSiteStartDate(String sText){
		return b2wPlace.setStartDate(sText);
	}
	public boolean setJobSiteDurationType(String sText) {
		return b2wPlace.setDurationType(sText);
	}
	public boolean setJobSiteNonWorkingDayMonday(boolean bCheck){
		return b2wPlace.setNonWorkingDayMonday(bCheck);
	}
	public boolean setJobSiteNonWorkingDayTuesday(boolean bCheck){
		return b2wPlace.setNonWorkingDayTuesday(bCheck);
	}
	public boolean setJobSiteNonWorkingDayWednesday(boolean bCheck){
		return b2wPlace.setNonWorkingDayWednesday(bCheck);
	}
	public boolean setJobSiteNonWorkingDayThursday(boolean bCheck){
		return b2wPlace.setNonWorkingDayThursday(bCheck);
	}
	public boolean setJobSiteNonWorkingDayFriday(boolean bCheck){
		return b2wPlace.setNonWorkingDayFriday(bCheck);
	}
	public boolean setJobSiteNonWorkingDaySaturday(boolean bCheck){
		return b2wPlace.setNonWorkingDaySaturday(bCheck);
	}
	public boolean setJobSiteNonWorkingDaySunday(boolean bCheck){
		return b2wPlace.setNonWorkingDaySunday(bCheck);
	}
	public boolean setShowOnJobBoard(boolean bCheck){
		return checkBox(B2WJobs.getB2WJobSiteShowOnJobBoard(),bCheck);
	}
	public boolean setJobSiteAddress(String sText){
		return b2wPlace.setLocationAddress1(sText);
	}
	public boolean setJobSiteCity(String sText){
		return b2wPlace.setLocationCity(sText);
	}
	public boolean setJobSiteState(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobsSiteState());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobSiteZip(String sText){
		return b2wPlace.setLocationPostalCode(sText);
	}
	public boolean setJobCountry(String sText){
		return b2wPlace.setLocationCountry(sText); 
	}
	public boolean clickAddJobSiteButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WAddJobSiteButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getPlaceDescription()) != null;
		}
		return bReturn;
	}

	public boolean clickAddNewJobProductionAccount() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WCreateNewJobProdAccount())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobProductionAccountDescription()) != null;
		}
		return bReturn;
	}
	public boolean clickAddNewOverheadAccount() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WCreateNewJobOverheadAccount())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJoboverheaddescriptiontextbox()) != null;
		}
		return bReturn;
	}
	public boolean openJobByJobNumber(String sJobNumber) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WListViewJobNunber(), sJobNumber);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobnumbertext());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean setJobProductionAccountTrackingIDText(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobProductionAccountTrackingID());
		if (el != null){
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
	public boolean setProductionSupervisorProjectedUnitCost(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionsupervisorprojectedunitcost());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setProductionManagerProjectedUnitCost (String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionmanagerprojectedunitcost());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setProductionEstimatedQuantity(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionmanagerestimatedquanity());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setProductionChangeOrderQuantity (String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionchangeorderquanitytextbox());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionAccountDescriptionText(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobProductionAccountDescription());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setJobProductionAccountComplete(boolean bCheck){
		return checkBox(B2WJobs.getB2WJobProductionCompleteCheckBox(), bCheck);
	}
	
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
	public boolean clickAddEstimateItemCostBreakdown(){
		return WebElementUtils.clickElement(B2WJobs.getB2WAddEstimateItemCostBreakdownButton());
	}
	public boolean clickAddChangeOrderCostBreakdownButton() {
		return WebElementUtils.clickElement(B2WJobs.getB2WAddChangeOrderCostBreakdown());
	}
	
	public boolean clickEstimatesItemsTab() {
		return WebElementUtils.clickElement(B2WJobs.getB2WJobstabestimateitems());
	}
	public boolean clickTrackingAccountsTab() {
		return WebElementUtils.clickElement(B2WJobs.getB2WJobstabtrackingaccounts());
	}
	public boolean clickMaterialsTab() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobstabmaterials())){
			bReturn = tsk.waitForPageHeader("Job Materials");
		}
		return bReturn;
	}
	public boolean clickSubsVendorsTab() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobstabsubvendors())){
			bReturn = tsk.waitForPageHeader("Job Subcontractors");
		}
		return bReturn;
	}
	public boolean clickActivityTab() {
		return WebElementUtils.clickElement(B2WJobs.getB2WJobstabsactivity());
	}
	public boolean clickChangeOrderTab() {
		return WebElementUtils.clickElement(B2WJobs.getB2WJobstabchangeorders());
	}
	public boolean clickTMWorkTab() {
		return WebElementUtils.clickElement(B2WJobs.getB2WJobstmwork());
	}
	public boolean clickGeneralInfoTab() {
		return WebElementUtils.clickElement(B2WJobs.getB2WJobsGeneralInfoTab());
	}
	public boolean clickAddMaterialsButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobsAddMaterialsButton())){
			B2WAddToJobs b2wAdd = new B2WAddToJobs(JOBSDIALOG.ADDMATERIALS);
			bReturn = b2wAdd.waitForDialogToAppear();
		}
		return bReturn;
	}
	public boolean clickAddSubcontractorsButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobsAddSubContractorButton())){
			B2WAddToJobs b2wAdd = new B2WAddToJobs(JOBSDIALOG.ADDSUBCONTRACTORS);
			bReturn = b2wAdd.waitForDialogToAppear();
		}
		return bReturn;
	}
	public boolean clickAddTruckingSubcontractorsButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobsAddTruckingSubcontractorButton())){
			B2WAddToJobs b2wAdd = new B2WAddToJobs(JOBSDIALOG.ADDTRUCKINGSUBCONTRACTORS);
			bReturn = b2wAdd.waitForDialogToAppear();
		}
		return bReturn;
	}
	public boolean clickAddVendors() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobsAddVendorButton())){
			B2WAddToJobs b2wAdd = new B2WAddToJobs(JOBSDIALOG.ADDVENDORS);
			bReturn = b2wAdd.waitForDialogToAppear();
		}
		return bReturn;
	}
	public boolean saveJobSite() {
		return b2wPlace.clickSaveBin();
	}
	public boolean clickCreateNewTMWorkItemButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobAddNewTMWorkItemButton())){
			bReturn = new B2WTMWorkItemTab().waitForPageNotBusy();
		}
		return bReturn;
	}
	public ArrayList<String> getJobSiteDescriptionFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssitedesc());
	}
	public ArrayList<String> getJobSiteSupervisorFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssitesitesupervisor());
	}
	public ArrayList<String> getJobSiteAddressFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssiteaddress());
	}
	public ArrayList<String> getJobSiteCityFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssitecity());
	}
	public ArrayList<String> getJobSiteStateFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssitestate());
	}
	public ArrayList<String> getJobMaterialsDescriptionFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobsmaterialsdescFromGrid());
	}
	public ArrayList<String> getJobMaterialsIDFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobsmaterialsmaterialidFromGrid());
	}
	public ArrayList<String> getJobMaterialsUnitCostFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobsmaterialsunitcostFromGrid());
	}
	public ArrayList<String> getJobMaterialsUnitMeasureFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobsmaterialsunitmeasureFromGrid());
	}
	public ArrayList<String> getJobSubcontractorCompanyNameFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssubsvendorscompnameFromGrid());
	}
	public ArrayList<String> getJobSubcontractorCompanyIDFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssubsvendorscompidFromGrid());
	}
	public ArrayList<String> getJobSubcontractorCompanyTypeFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobssubsvendorscomptypeFromGrid());
	}
	public ArrayList<String> getJobTruckingSubcontractorCompanyNameFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobstruckingsubscompanynameFromGrid());
	}
	public ArrayList<String> getJobTruckingSubcontractorCompanyIDFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobstruckingsubscompanyidFromGrid());
	}
	public ArrayList<String> getJobTruckingSubcontractorCompanyTypeFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobstruckingsubscompanytypeFromGrid());
	}
	public ArrayList<String> getJobVendorCompanyNameFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobsvendorscompnameFromGrid());
	}
	public ArrayList<String> getJobVendorCompanyIDFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobsvendorscompidFromGrid());
	}
	public ArrayList<String> getJobVendorCompanyTypeFromGrid() {
		return TaskUtils.getTextFromElements(B2WJobs.getB2WJobsvendorscomptypeFromGrid());
	}
	
	
	public boolean clickCreateNewEstimateButton() {
		
		boolean bReturn = false;
		
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobCReateNewEstimateButton())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateItemNumber()) != null;
		}
		return bReturn;
	}
}
