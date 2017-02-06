package smoketest;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.BrowserUtils;
import tasks.jobs.B2WAddToJobs;
import tasks.jobs.B2WCreateChangeOrderTasks;
import tasks.jobs.B2WEstimateItemTasks;
import tasks.jobs.B2WCreateJobOverheadAccountTasks;
import tasks.jobs.B2WCreateJobProductionAccountTasks;
import tasks.jobs.B2WCreateJobSiteTasks;
import tasks.jobs.B2WCreateJobTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WTMWorkItemTasks;
import tasks.setup.B2WUserTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeF extends B2WTestCase {

	B2WNavigationTasks b2wNT = new B2WNavigationTasks();
	B2WUserTasks userTasks = new B2WUserTasks();
	B2WJobsTasks b2wJobs = new B2WJobsTasks();
	B2WCreateJobTasks b2wCreate = new B2WCreateJobTasks();
	B2WCreateJobSiteTasks b2wJobSite = new B2WCreateJobSiteTasks();
	B2WCreateJobProductionAccountTasks jobProd = new B2WCreateJobProductionAccountTasks();
	B2WCreateJobOverheadAccountTasks jobOver = new B2WCreateJobOverheadAccountTasks();
	B2WEstimateItemTasks b2wEstimate = new B2WEstimateItemTasks();
	B2WCreateChangeOrderTasks b2wChangeOrder = new B2WCreateChangeOrderTasks();
	
	String sJobNumberID, sJobTitle, sProjectManager, sProjectName, sJobStatus, sJobCustomer, sBusinessUnit, sLaborRateClass, sEquipRateClass, sNotes;
	
	String sProductionAccountDesc;
	String sProductionAccountID;
	String sOverheadAccountDesc;
	String sOverheadAccountID;
	
	String sJobSiteDesc;
	String sJobSiteAddress;
	String sJobSiteCity;
	String sJobSiteState;
	String sJobSiteZipCode;
	
	String sMaterialsDescriptionC;
	String sMaterialsIDC;

	String sMaterialsDescriptionD;
	String sMaterialsIDD;
	
	String sOrganizationCompanyNameA;
	String sOrganizationCompanyIDA;
	
	String sOrganizationCompanyNameB;
	String sOrganizationCompanyIDB;
	
	String sNewJobProductionAccountTrackID, 
			sNewJobProductionAccountDescription,
			sNewJobOverheadAccountTrackID,
			sNewJobOverheadAccountDescription;
	
	String sTMWorkItemDescription, sTMWorkItemDateAdded, sTMWorkItemTrackingID, sTMWorkItemAccountID, sTMWorkItemRequestedBy;
	

	String sEstimateItemNumber;
	String sEstimateEstimatedQuantity;
	String sEstimateItemID;
	String sEstimateChangeOrderQuantity;
	String sEstimateDescription;
	String sEstimateUnitOfMeasure;
	String sEstimateUnitBidPriceEstimated;
	String sEstimateUnitBidPriceChangeOrder;
	String sEstimateTotalBidPriceEstimated;
	String sEstimateTotalBidPriceChangeOrder;
	
	String sChangeOrdersID;
	String sChangeOrdersAlternateID;
	String sChangeOrdersDescription;
	String sChangeOrdersType;
	String sChangeOrdersStatus;
	String sChangeOrdersEstimatedQuantity;
	String sChangeOrdersUnitOfMeasure;
	
	public B2WAddToJobs b2wJobsAdd = new B2WAddToJobs(B2WJobsTasks.JOBSDIALOG.ADDSUBCONTRACTORS);
	
	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "mleduc";
	}

	@Override
	public String getDataPath() {
		// for properties files of test data
		return "data/test";
	}

	@Override
	public boolean isSupported() {
		// for specific browser
		return true;
	}

	@Override
	public String getCategory() {
		// Category of the within ops
		return null;
	}

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
		int n = getRandomNumber();
		
		sJobNumberID = getProperty("sJobNumberID") + n;
		sJobTitle= getProperty("sJobTitle");
		sProjectManager= getProperty("sProjectManager");
		sProjectName= getProperty("sProjectName");
		sJobStatus = getProperty("sJobStatus");
		sJobCustomer = getProperty("sJobCustomer");
		sBusinessUnit = getProperty("sBusinessUnit");
		sLaborRateClass = getProperty("laborrateclass") + n;
		sEquipRateClass = getProperty("sEquipRateClass");
		sNotes = getProperty("sNotes");
		
		sJobSiteDesc = getProperty("sJobSiteDesc") + n;
		sJobSiteAddress = getProperty("sJobSiteAddress");
		sJobSiteCity = getProperty("sJobSiteCity");
		sJobSiteState = getProperty("sJobSiteState");
		sJobSiteZipCode = getProperty("sJobSiteZipCode");
	
		sProductionAccountDesc = getProperty("productionaccountdescription");
		sProductionAccountID = getProperty("productionaccountaccountid") + n;
		
		sOverheadAccountDesc = getProperty("overheadaccountdescription");
		sOverheadAccountID = getProperty("overheadaccountaccountid") + n;
		
		sMaterialsDescriptionC = getProperty("materialdescriptionC");
		sMaterialsIDC = getProperty("materialIDC") + n;

		sMaterialsDescriptionD = getProperty("materialdescriptionD");
		sMaterialsIDD = getProperty("materialIDD") + n;
		
		sOrganizationCompanyNameA = getProperty("sOrganizationCompanyNameA");
		sOrganizationCompanyIDA = getProperty("sOrganizationCompanyIDA") + n;
		
		sOrganizationCompanyNameB = getProperty("sOrganizationCompanyNameB");
		sOrganizationCompanyIDB = getProperty("sOrganizationCompanyIDB") + n;
		
		sNewJobProductionAccountTrackID = getProperty("sNewJobProductionAccountTrackID") + n;
		sNewJobProductionAccountDescription  = getProperty("sNewJobProductionAccountDescription");
		sNewJobOverheadAccountTrackID = getProperty("sNewJobOverheadAccountTrackID") + n;
		sNewJobOverheadAccountDescription = getProperty("sNewJobOverheadAccountDescription");
		sTMWorkItemDescription = getProperty("sTMWorkItemDescription");
		sTMWorkItemDateAdded = getProperty("sTMWorkItemDateAdded");
		sTMWorkItemTrackingID = getProperty("sTMWorkItemTrackingID");
		sTMWorkItemAccountID = getProperty("sTMWorkItemAccountID");
		sTMWorkItemRequestedBy = getProperty("sTMWorkItemRequestedBy");
		

		sEstimateItemNumber = getProperty("sEstimateItemNumber");
		sEstimateEstimatedQuantity = getProperty("sEstimateQuantity");
		sEstimateItemID = getProperty("sEstimateItemID");
		sEstimateChangeOrderQuantity = getProperty("sEstimateChangeOrderQuantity");
		sEstimateDescription = getProperty("sEstimateDescription");
		sEstimateUnitOfMeasure = getProperty("sEstimateUnitOfMeasure");
		sEstimateUnitBidPriceEstimated = getProperty("sEstimateUnitBidPriceEstimated");
		sEstimateUnitBidPriceChangeOrder = getProperty("sEstimateUnitBidPriceChangeOrder");
		sEstimateTotalBidPriceEstimated = getProperty("sEstimateTotalBidPriceEstimated");
		sEstimateTotalBidPriceChangeOrder = getProperty("sEstimateTotalBidPriceChangeOrder");
		
		sChangeOrdersID = getProperty("sChangeOrdersID");
		sChangeOrdersAlternateID = getProperty("sChangeOrdersAlternateID");
		sChangeOrdersDescription = getProperty("sChangeOrdersDescription");
		sChangeOrdersType = getProperty("sChangeOrdersType");
		sChangeOrdersStatus = getProperty("sChangeOrdersStatus");
		sChangeOrdersEstimatedQuantity = getProperty("sChangeOrdersEstimatedQuantity");
		sChangeOrdersUnitOfMeasure = getProperty("sChangeOrdersUnitOfMeasure");
	
	}

	public void testMain() throws Throwable {
		// associate test user with current user
		//addEmployeeToUser();
		createJob();
		addJobSite();
		createNewJobProductionAccount();
		createNewJobOverheadAccount();
		createEstimateItem();
		createChangeOrder();
		addSubsAndVendors();
		addMaterials();

		addCreateNewTMWorkItem();
	}

	public String getTestDescription() {
		// TODO Auto-generated method stub
		return "Job, site, estimate, change order, add materials, subcontractors";
	}
	
	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}
	
	public void createJob() {
		
		logCompare(true,b2wNT.openJobs(),"Open Jobs");
		logCompare(true,b2wJobs.clickCreateNewJob(), "Create New Job");
		logCompare(true, b2wCreate.setJobNumber(sJobNumberID), "Set Job Number ID");
		logCompare(true, b2wCreate.setJobTitle(sJobTitle), "Set Job Title");
		logCompare(true, b2wCreate.setProjectManagerFromDD(sProjectManager), "Set Project Manager");
		logCompare(true, b2wCreate.setJobProjectName(sProjectName), "Set Project Name");
		logCompare(true, b2wCreate.setJobProjectStatusFromDD(sJobStatus), "Set Job Status");
		logCompare(true, b2wCreate.setJobProjectCustomerFromDD(sJobCustomer), "Set Job Customer");
		logCompare(true, b2wCreate.setJobDefaultLaborRateClassFromDD(sLaborRateClass), "Labor Rate Class");
		logCompare(true, b2wCreate.setJobEquipmentRateClassFromDD(sEquipRateClass), "Equipment Rate Class");
		assertTrue("Save Job", b2wJobs.clickBottomSaveButton());
		
		logCompare(sJobNumberID, b2wJobs.getJobNumberText(), "Verify job Number");
		logCompare(sJobTitle, b2wJobs.getJobTitleText(), "Verify Job Title");
		logCompare(sProjectManager, b2wJobs.getJobProjectManagerText(), "Verify Project Manager");
		logCompare(sJobStatus, b2wJobs.getJobProjectStatusText(), "Verify Project Status");
		logCompare(sJobCustomer, b2wJobs.getJobCustomerText(), "Verify Customer");
		logCompare(sEquipRateClass, b2wJobs.getEquipmentRateClassText(), "Equip Rate Class");
		
	}
	
	public void addJobSite(){
		logCompare(true, b2wJobs.clickAddJobSiteButton(), "Create new Job site");
		logCompare(true, b2wJobSite.setJobSiteDescription(sJobSiteDesc), "Job Desc");
		logCompare(true, b2wJobSite.setJobSiteAddress(sJobSiteAddress), "Job Site Address");
		logCompare(true, b2wJobSite.setJobSiteCity(sJobSiteCity), "Job Site City");
		logCompare(true, b2wJobSite.setJobSiteState(sJobSiteState), "Job State");
		logCompare(true, b2wJobSite.setJobSiteZip(sJobSiteZipCode), "Zip Code");
		assertTrue("Save Job Site",b2wJobSite.saveJobSite());
		
	}
	
	
	public void createNewJobProductionAccount() {

		logCompare(true,b2wJobs.clickTrackingAccountsTab(), "Click Tracking Accounts tab");
		logCompare(true,b2wJobs.clickAddNewJobProductionAccount(), "Click Add New Job Production Account");
		logCompare(true,jobProd.setJobProductionAccountTrackingIDText(sNewJobProductionAccountTrackID), "Set Account tracking ID");
		logCompare(true,jobProd.setJobProductionAccountDescriptionText(sNewJobProductionAccountDescription), "Job Production Desc");
		logCompare(true,jobProd.selectJobProductionAccountIDFromDD(sProductionAccountID + " - "+ sProductionAccountDesc), "Select Production Account ID");
		assertTrue("Save Account",b2wJobs.clickTopSaveButton());
		
	}
	
	public void createNewJobOverheadAccount() {
		logCompare(true,b2wJobs.clickTrackingAccountsTab(), "Click Tracking Accounts tab");
		logCompare(true,b2wJobs.clickAddNewOverheadAccount(), "Create New Overhead Account");
		logCompare(true,jobOver.setJobOverheadDescription(sNewJobOverheadAccountDescription), "Overhead acocunt description");
		logCompare(true,jobOver.setJobOverheadTrackingID(sNewJobOverheadAccountTrackID), "Overhead account tracking id");
		logCompare(true,jobOver.selectJobOverheadAccountIDFromDD(sOverheadAccountID + " - "+ sOverheadAccountDesc), "Select Account ID");
		assertTrue("Create New Job Overhead", b2wJobs.clickTopSaveButton());
		
	}
	
	
	public void addMaterials() {

		logCompare(true,b2wJobs.clickMaterialsTab(), "Click Materials Tab");
		logCompare(true,b2wJobs.clickAddMaterialsButton(),"Click add materials button");
		B2WAddToJobs b2wJobsAdd = new B2WAddToJobs(B2WJobsTasks.JOBSDIALOG.ADDMATERIALS);
		logCompare(true,b2wJobsAdd.setSearchText(sMaterialsDescriptionD), "Search for Material");
		logCompare(true,b2wJobsAdd.clickSearchButton(),"Click Search");
		logCompare(true,b2wJobsAdd.setIDText(sMaterialsIDD),"Set ID");
		if (logCompare(true,b2wJobsAdd.clickSelectButton(), "Select button")){
			TaskUtils.sleep(500);
			logCompare(true,b2wJobsAdd.clickAddButton(), "Click Add Button");
		}else{
			b2wJobsAdd.clickCancelButton();
		}
		
		
	}
	
	public void addSubsAndVendors() {
		
		logCompare(true,b2wJobs.clickSubsVendorsTab(),"Click Subs Vendor Tab");
		logCompare(true,b2wJobs.clickAddSubcontractorsButton(), "Add Subcontractors button");
		B2WAddToJobs b2wJobsAdd = new B2WAddToJobs(B2WJobsTasks.JOBSDIALOG.ADDSUBCONTRACTORS);
		logCompare(true,b2wJobsAdd.setSearchText(sOrganizationCompanyNameA), "Select Organization");
		logCompare(true,b2wJobsAdd.clickSearchButton(), "Click Search Button");
		logCompare(true,b2wJobsAdd.setIDText(sOrganizationCompanyIDA), "Set ID");
		if (logCompare(true,b2wJobsAdd.clickSelectButton(), "Select button")){
			logCompare(true,b2wJobsAdd.clickAddButton(), "Click Add Button");
		}else{
			b2wJobsAdd.clickCancelButton();
		}

		logCompare(true,b2wJobs.clickAddTruckingSubcontractorsButton(), "Click Truck Subs");
		b2wJobsAdd = new B2WAddToJobs(B2WJobsTasks.JOBSDIALOG.ADDTRUCKINGSUBCONTRACTORS);
		logCompare(true,b2wJobsAdd.setSearchText(sOrganizationCompanyNameB), "Select Organization");
		logCompare(true,b2wJobsAdd.clickSearchButton(), "Click Search Button");
		logCompare(true,b2wJobsAdd.setIDText(sOrganizationCompanyIDB), "Set ID");
		if (logCompare(true,b2wJobsAdd.clickSelectButton(), "Select button")){
			logCompare(true,b2wJobsAdd.clickAddButton(), "Click Add Button");
		}else{
			b2wJobsAdd.clickCancelButton();
		}


	}
	
	public void addEmployeeToUser() {
		assertTrue("Open Setup Users", b2wNT.openSetupUsers());
		String sLastName = b2wNT.getLastNameOfUser();
		assertTrue("Search for Last Name",userTasks.enterTextAndClickSearch(b2wNT.getUserName()));
		assertTrue("Open the user",userTasks.openUserByLastName(sLastName));
		assertTrue("Edit the User",userTasks.clickEditButton());
		userTasks.selectEmployeeFromDD("Test User");
		userTasks.clickTopSaveButton();
		logCompare("Test User", userTasks.getEmployeeText(), "Employee Name");
		
	}
	
	public void addCreateNewTMWorkItem() {
		B2WTMWorkItemTasks b2wTM = new B2WTMWorkItemTasks();
		logCompare(true,b2wJobs.clickTMWorkTab(), "Click TM Work Item Tab");
		logCompare(true,b2wJobs.clickCreateNewTMWorkItemButton(),"Click create new TM Work Item button");
		logCompare(true,b2wTM.setTMWorkItemDescription(sTMWorkItemDescription), "Set TM Work Item Desc");
		logCompare(true,b2wTM.setTMWorkItemTrackingID(sTMWorkItemTrackingID), "Set Tracking ID");
		b2wTM.selectRandomRequestedByFromDD();
		b2wTM.selectRandomAccountIDFromDD();
		assertTrue("Save TM Work Item",b2wTM.saveTMWorkItem());
		BrowserUtils.getDriver().navigate().to(getEnvProperty("deploy") + "Maintenance/Dashboard.aspx");
	}
	
	public void createEstimateItem(){
		logCompare(true,b2wJobs.clickEstimatesItemsTab(), "Click on Estimate Tab");
		logCompare(true,b2wJobs.clickCreateNewEstimateButton(),"Create Estimate Item");
		logCompare(true,b2wEstimate.setEstimateItemNumber(sEstimateItemNumber), "Fill Item Number");
		logCompare(true,b2wEstimate.setEstimateEstimatedQuantity(sEstimateEstimatedQuantity),"Fill Estimated Quantity");
		logCompare(true,b2wEstimate.setEstimateItemID(sEstimateItemID),"Fill Item ID");
		logCompare(true,b2wEstimate.setEstimateChangeOrderQuantity(sEstimateChangeOrderQuantity),"Fill Change Order Quantity");
		logCompare(true,b2wEstimate.setEstimateDescription(sEstimateDescription),"Fill Description");
		logCompare(true,b2wEstimate.setEstimateUnitOfMeasure(sEstimateUnitOfMeasure), "Fill Unit of Measure");
		logCompare(true,b2wEstimate.setEstimateUnitBidPriceEstimated(sEstimateUnitBidPriceEstimated), "Fill Unit Bid Price Estimated");
		logCompare(true,b2wEstimate.setEstimateUnitBidPriceChangeOrder(sEstimateUnitBidPriceChangeOrder), "Fill Unit Bid Proce Change Order");
		logCompare(true,b2wEstimate.setEstimateTotalBidPriceEstimated(sEstimateTotalBidPriceEstimated), "Fill Total Bid Price Estimated");
		logCompare(true,b2wEstimate.setEstimateTotalBidPriceChangeOrder(sEstimateTotalBidPriceChangeOrder),"Fill Total Bid Price Change Order");
		logCompare(true,b2wJobs.clickBottomSaveButton(),"Save Button Clicked");
	}
	
	public void createChangeOrder(){
		logCompare(true,b2wJobs.clickChangeOrderTab(),"Click on Change Orders Tab");
		logCompare(true,b2wJobs.clickCreateNewChangeOrderButton(),"Create Change Order");
		logCompare(true,b2wChangeOrder.setChangeOrdersID(sChangeOrdersID),"Fill Change Order ID");
		logCompare(true,b2wChangeOrder.setChangeOrdersAlternateID(sChangeOrdersAlternateID),"Fill Alternate ID");
		logCompare(true,b2wChangeOrder.setChangeOrdersDescription(sChangeOrdersDescription),"Fill Description");
		logCompare(true,b2wChangeOrder.setChangeOrdersEstimatedQuantity(sChangeOrdersEstimatedQuantity),"Fill Estimated Quantity");
		logCompare(true,b2wChangeOrder.setChangeOrdersUnitOfMeasure(sChangeOrdersUnitOfMeasure),"Fill Unit of Measure");
		logCompare(true,b2wJobs.clickBottomSaveButton(),"Save Button Clicked");
	}

}
