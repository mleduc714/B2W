package tasks.jobs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.jobs.B2WJobs;
import appobjects.resources.B2WPlaces;
import appobjects.setup.B2WSetupUsers;
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
	
	public String randomNumberGenerator() {
		Random rn = new Random();
		int randomNum = rn.nextInt(999999) + 1;
		String randNumString = String.valueOf(randomNum);
		return randNumString;
	}
	
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
	
	
	public String getJobProjectManagerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJopprojectmanagertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}

	public boolean setJobProjectName(String sProjectName){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobprojectname());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sProjectName);
		}
		return bReturn;
	}
	
	public String getJobProjectNameText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobprojectnametext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public boolean setJobProjectStatusFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobstatusdd(), sText);
	}
	public String getJobProjectStatusText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobstatustext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}

	public boolean setJobProjectCustomerFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobcustomerdd(), sText);
	}
	public String getJobCustomerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobcustomertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}

	public boolean setJobDefaultLaborRateClassFromDD(String sLaborRate){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultlaborrateclassdd(), sLaborRate);
	}
	public String getJobDefaultLaborRateClassText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobdefaultlaborrateclasstext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}

	public boolean setJobEquipmentRateClassFromDD(String sEquipmentRate){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobdefaultequipmentrateclass(), sEquipmentRate);
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
	public boolean openJobByJobTitle(String sTitle){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WListViewJobTitle(), sTitle);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobnumbertext());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}

	public boolean openEstimateItemByItemID(String b2w_jobsestimateitemid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateItemIDs(), b2w_jobsestimateitemid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTableVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openEstimateItemByDescription(String b2w_jobsestimatedescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateItemDescription(), b2w_jobsestimatedescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTableVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openTrackingAccountByTrackingID(String b2w_jobstrackingaccountid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateTrackingAccountsVerification(), b2w_jobstrackingaccountid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTrackingAccountsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openTrackingAccountByDescription(String b2w_jobstrackingaccountdescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateTrackingAccountsVerification(), b2w_jobstrackingaccountdescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTrackingAccountsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openMaterialByDescription(String b2w_jobsmaterialsdescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateMaterialsVerification(), b2w_jobsmaterialsdescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateMaterialsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openMaterialByMaterialID(String b2w_jobsmaterialsmaterialid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateMaterialsVerification(), b2w_jobsmaterialsmaterialid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateMaterialsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobSubcontractorsByCompanyName(String b2w_jobsubcontractorscompanyname) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateJobSubcontractorsVerification(), b2w_jobsubcontractorscompanyname);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobSubcontractorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobSubcontractorsByCompanyID(String b2w_jobsubcontractorscompanyid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateJobSubcontractorsVerification(), b2w_jobsubcontractorscompanyid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobSubcontractorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobTruckingSubcontractorsByCompanyName(String b2w_jobtruckingsubcontractorscompanyname) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateJobTruckingSubcontractorVerification(), b2w_jobtruckingsubcontractorscompanyname);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobTruckingSubcontractorVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobVendorsByCompanyName(String b2w_jobvendorscompanyname) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateJobVendorsVerification(), b2w_jobvendorscompanyname);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobVendorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobVendorsByCompanyID(String b2w_jobvendorscompanyid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateJobVendorsVerification(), b2w_jobvendorscompanyid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobVendorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobTruckingSubcontractorsByCompanyID(String b2w_jobtruckingsubcontractorscompanyid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateJobTruckingSubcontractorVerification(), b2w_jobtruckingsubcontractorscompanyid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobTruckingSubcontractorVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openChangeOrderByID(String b2w_changeorderid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateChangeOrdersIDVerification(), b2w_changeorderid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateChangeOrdersIDVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openChangeOrderByDescription(String b2w_changeorderdescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateChangeOrdersDescriptionVerification(), b2w_changeorderdescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateChangeOrdersDescriptionVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openTimeAndMaterialRatesByRateType(String b2w_timeandmaterialratesratetype) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateTimeAndMaterialRatesVerification(), b2w_timeandmaterialratesratetype);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTimeAndMaterialRatesVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openTimeAndMaterialWorkItemsByID(String b2w_timeandmaterialworkitemsid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateTimeAndMaterialWorkItemsVerification(), b2w_timeandmaterialworkitemsid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTimeAndMaterialWorkItemsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openTimeAndMaterialWorkItemsByDescription(String b2w_timeandmaterialworkitemsdescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WEstimateTimeAndMaterialWorkItemsVerification(), b2w_timeandmaterialworkitemsdescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTimeAndMaterialWorkItemsVerification());
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
	public boolean setJobProductionSupervisorProjectedUnitCost(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionsupervisorprojectedunitcost());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionManagerProjectedUnitCost (String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionmanagerprojectedunitcost());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionEstimatedQuantity(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobproductionmanagerestimatedquanity());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setJobProductionChangeOrderQuantity (String sText){
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
			bReturn = new B2WTMWorkItemTab().waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	
	public boolean clickCreateNewEstimateButton() {
		
		boolean bReturn = false;
		
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobCReateNewEstimateButton())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateItemNumber()) != null;
		}
		return bReturn;
	}
	
	public boolean clickCreateNewChangeOrderButton() {
		
		boolean bReturn = false;
		
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobsCreateNewChangeOrderButton())){
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WChangeOrdersID()) != null;
		}
		return bReturn;
	}
	
	public boolean setEstimateItemNumber(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemNumber());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateEstimatedQuantity(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateEstimatedQuantity());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateItemID(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateItemID());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateChangeOrderQuantity(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateChangeOrderQuantity());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateDescription(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateDescription());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateUnitBidPriceEstimated(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateUnitBidPriceEstimated());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateUnitBidPriceChangeOrder(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateUnitBidPriceChangeOrder());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateTotalBidPriceEstimated(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateTotalBidPriceEstimated());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setEstimateTotalBidPriceChangeOrder(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WEstimateTotalBidPriceChangeOrder());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	
	
	public boolean setChangeOrdersID(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChangeOrdersID());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setChangeOrdersAlternateID(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChaneOrdersAlternateID());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setChangeOrdersDescription(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChangeOrdersDescription());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setChangeOrdersEstimatedQuantity(String sText){
		boolean bReturn = false;
		
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WChangeOrderEstimatedQuantity());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	
	
	public boolean setEstimateUnitOfMeasure(String sText){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WEstimateUnitOfMeasure(), sText);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WEstimateUnitOfMeasure()).equals(sText);
	}
	
	
	
	public boolean setChangeOrdersType(String sText){
		WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WChangeOrdersType());
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WChangeOrdersType()).equals(sText);
	}
	
	public boolean setChangeOrdersStatus(String sText){
		WebElementUtils.selectAnyItemFromOpsDropDownMenu(B2WJobs.getB2WChangeOrdersStatus());
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WChangeOrdersStatus()).equals(sText);
	}
	
	public boolean setChangeOrdersUnitOfMeasure(String sText){
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WChangeOrderUnitOfMeasure(), sText);
		
		return WebElementUtils.getSelectedTextFromDropDown(B2WJobs.getB2WChangeOrderUnitOfMeasure()).equals(sText);
	}
	
	
	public boolean setJobTitle(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobtitle());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	public boolean setProjectManagerFromDD(String sText){
		return WebElementUtils.selectItemFromOpsDropDownMenu(B2WJobs.getB2WJobprojectmanagerdd(), sText);
	}
	
	public String getJobNumberText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobnumbertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	
	public String getJobTitleText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobtitletext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	
	public String getProjectManagerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJopprojectmanagertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public String getProjectStatusText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobstatustext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public String getCustomerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobcustomertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	public String getEquipmentRateClassText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobdefaultequipmentrateclasstext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
	
	public ArrayList<String> getJobSiteDescriptions() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getB2WJobssitedesc());
		if (list.size() > 0){
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				al.add(iter.next().getText());
			}
		}
		return al;
	}
	public ArrayList<String> getJobSupervisors() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getB2wJobssitesitesupervisor());
		if (list.size() > 0){
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				al.add(iter.next().getText());
			}
		}
		return al;
	}

	public ArrayList<String> getJobSiteAddresses() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getB2wJobssiteaddress());
		if (list.size() > 0){
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				al.add(iter.next().getText());
			}
		}
		return al;
	}
	public ArrayList<String> getJobSiteCities() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getB2wJobssitecity());
		if (list.size() > 0){
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				al.add(iter.next().getText());
			}
		}
		return al;
	}
	public ArrayList<String> getJobSiteStates() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getB2wJobssitestate());
		if (list.size() > 0){
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				al.add(iter.next().getText());
			}
		}
		return al;
	}
	public ArrayList<String> getEstimateItemsIDs() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getB2WEstimateItemIDs());
		if (list.size() > 0){
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				al.add(iter.next().getText());
			}
		}
		return al;
	}
	public ArrayList<String> getJobProductionAccountsTrackingIDs() {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getJobProductionAccountID());
		if (list.size() > 0){
			Iterator<WebElement> iter = list.iterator();
			while (iter.hasNext()){
				al.add(iter.next().getText());
			}
		}
		return al;
	}
	
	public boolean openJobProjectManager() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJopprojectmanagertext());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			new TaskUtils().waitForProductPanel("Employees");
		}
		return bReturn;
	}
	public boolean openJobSite(String sDescription){
		boolean bReturn = false;
		List<WebElement> jobsites = WebElementUtils.findElements(B2WJobs.getB2WJobssitedesc());
		Iterator<WebElement> iter = jobsites.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			if (el.getText().equals(sDescription)){
				bReturn = WebElementUtils.clickElement(el);
				bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WSetupUsers.getUserInformationHeader()) != null;
			}
		}
		return bReturn;
	}
	
}
