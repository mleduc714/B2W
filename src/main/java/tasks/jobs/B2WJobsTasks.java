package tasks.jobs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import appobjects.jobs.B2WJobs;
import appobjects.resources.B2WPlaces;
import appobjects.setup.B2WSetupUsers;
import tasks.WebElementUtils;
import tasks.resources.B2WPlaceTasks;
import tasks.resources.B2WResourceTasks;
import tasks.util.StringUtils;
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
	

	
	
	public String getJobProjectManagerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJopprojectmanagertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
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
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobProductionListAccountTrackingID(), b2w_jobstrackingaccountid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTrackingAccountsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openTrackingAccountByDescription(String b2w_jobstrackingaccountdescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobProductionListAccountDescription(), b2w_jobstrackingaccountdescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateTrackingAccountsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openMaterialByDescription(String b2w_jobsmaterialsdescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobMaterialListDesc(), b2w_jobsmaterialsdescription);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateMaterialsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openMaterialByMaterialID(String b2w_jobsmaterialsmaterialid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobMaterialListID(), b2w_jobsmaterialsmaterialid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateMaterialsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobSubcontractorsByCompanyName(String b2w_jobsubcontractorscompanyname) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobssubsvendorsListcompname(), b2w_jobsubcontractorscompanyname);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobSubcontractorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobSubcontractorsByCompanyID(String b2w_jobsubcontractorscompanyid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobstruckingsubsListcompanyid(), b2w_jobsubcontractorscompanyid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobSubcontractorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobTruckingSubcontractorsByCompanyName(String b2w_jobtruckingsubcontractorscompanyname) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobstruckingsubsListcompanyname(), b2w_jobtruckingsubcontractorscompanyname);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobTruckingSubcontractorVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobVendorsByCompanyName(String b2w_jobvendorscompanyname) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobssubsvendorsListcompname(), b2w_jobvendorscompanyname);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobVendorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobVendorsByCompanyID(String b2w_jobvendorscompanyid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobssubsvendorsListcompid(), b2w_jobvendorscompanyid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobVendorsVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openJobTruckingSubcontractorsByCompanyID(String b2w_jobtruckingsubcontractorscompanyid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobstruckingsubsListcompanyid(), b2w_jobtruckingsubcontractorscompanyid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateJobTruckingSubcontractorVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openChangeOrderByID(String b2w_changeorderid) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobschangeorderchangeorderid(), b2w_changeorderid);
		if (el != null){
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WEstimateChangeOrdersIDVerification());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean openChangeOrderByDescription(String b2w_changeorderdescription) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobschangeorderdesc(), b2w_changeorderdescription);
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


	public boolean clickAddEstimateItemCostBreakdown(){
		return WebElementUtils.clickElement(B2WJobs.getB2WAddEstimateItemCostBreakdownButton());
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
	
	public boolean clickCreateNewTMWorkItemButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WJobs.getB2WJobAddNewTMWorkItemButton())){
			bReturn = new B2WTMWorkItemTasks().waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
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
		List<WebElement> list = WebElementUtils.findElements(B2WJobs.getB2WJobProductionListAccountTrackingID());
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
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobssitedesc(),sDescription);
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WSetupUsers.getUserInformationHeader()) != null;
		}
		return bReturn;
	}
	
	public boolean editJobSite(String sDescription){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobssitedesc(),sDescription);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WSetupUsers.getB2WUserListingEdit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobssitedesc());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean editJobByNumber(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WListViewJobNunber(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WSetupUsers.getB2WUserListingEdit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobnumber());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean editJobByTitle(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WListViewJobTitle(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WSetupUsers.getB2WUserListingEdit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobnumber());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	
	public boolean editEstimateItemByID(String s){
		boolean bReturn = false;
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
	public boolean editJobProductionAccountByTrackingID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobProductionListAccountTrackingID(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobProductionAccountEdit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WJobProductionAccountTrackingID());
			bReturn = waitForThis != null;
		}
		return bReturn;
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
	public boolean deleteJobMaterialByDescription(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobMaterialListDesc(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobMaterialListDelete());
			WebElementUtils.clickElement(edits.get(iNumber));
			Alert alert = TaskUtils.getAlertDialog();
			if (alert != null){
				alert.accept();
				bReturn = true;
			}
			
		}
		return bReturn;
	}
	
	public boolean deleteChangeOrderByDescription(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobschangeorderdesc(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobschangeorderdelete());
			WebElementUtils.clickElement(edits.get(iNumber));
			Alert alert = TaskUtils.getAlertDialog();
			if (alert != null){
				alert.accept();
				bReturn = true;
			}
			
		}
		return bReturn;
	}
	public boolean editChangeOrderByDescription(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobschangeorderdesc(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobschangeorderedit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WChangeOrdersID());
			bReturn = waitForThis != null;
		}
		return bReturn;
	}
	public boolean deleteChangeOrderByID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobschangeorderchangeorderid(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobschangeorderdelete());
			WebElementUtils.clickElement(edits.get(iNumber));
			Alert alert = TaskUtils.getAlertDialog();
			if (alert != null){
				alert.accept();
				bReturn = true;
			}
			
		}
		return bReturn;
	}
	public boolean editChangeOrderByID(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.getElementWithMatchingText(B2WJobs.getB2WJobschangeorderchangeorderid(), s);
		if (el != null){
			int iNumber = StringUtils.getNumberFromID(el.getAttribute("id"));
			List<WebElement> edits = WebElementUtils.findElements(B2WJobs.getB2WJobschangeorderedit());
			WebElementUtils.clickElement(edits.get(iNumber));
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WJobs.getB2WChangeOrdersID());
			bReturn = waitForThis != null;
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

	public String getJobProjectStatusText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobstatustext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}


	public String getJobCustomerText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobcustomertext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}


	public String getJobDefaultLaborRateClassText() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WJobdefaultlaborrateclasstext());
			if (el != null){
				sText = el.getText();
			}
		return sText;
	}
}
