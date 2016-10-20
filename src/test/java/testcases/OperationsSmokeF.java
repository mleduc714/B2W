package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WAddToJobs;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WTMWorkItemTab;
import tasks.setup.B2WUserTasks;

public class OperationsSmokeF extends B2WTestCase {

	B2WNavigationTasks b2wNT = new B2WNavigationTasks();
	B2WUserTasks userTasks = new B2WUserTasks();
	B2WJobsTasks b2wJobs = new B2WJobsTasks();
	
	
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
	
	}

	public void testMain() throws Throwable {
		// associate test user with current user
		createJob();
		addJobSite();
		createNewJobProductionAccount();
		createNewJobOverheadAccount();
		addMaterials();
		addSubsAndVendors();
		//addCreateNewTMWorkItem();
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}
	
	public void createJob() {
		
		logCompare(true,b2wNT.openJobs(),"Open Jobs");
		logCompare(true,b2wJobs.clickCreateNewJob(), "Create New Job");
		logCompare(true, b2wJobs.setJobNumber(sJobNumberID), "Set Job Number ID");
		logCompare(true, b2wJobs.setJobTitle(sJobTitle), "Set Job Title");
		logCompare(true, b2wJobs.setProjectManagerFromDD(sProjectManager), "Set Project Manager");
		logCompare(true, b2wJobs.setProjectName(sProjectName), "Set Project Name");
		logCompare(true, b2wJobs.setProjectStatusFromDD(sJobStatus), "Set Job Status");
		logCompare(true, b2wJobs.setProjectCustomerFromDD(sJobCustomer), "Set Job Customer");
		logCompare(true, b2wJobs.setDefaultLaborRateClassFromDD(sLaborRateClass), "Labor Rate Class");
		logCompare(true, b2wJobs.setEquipmentRateClassFromDD(sEquipRateClass), "Equipment Rate Class");
		logCompare(true, b2wJobs.clickBottomSaveButton(), "Save Button");
		
		logCompare(sJobNumberID, b2wJobs.getJobNumberText(), "Verify job Number");
		logCompare(sJobTitle, b2wJobs.getJobTitleText(), "Verify Job Title");
		logCompare(sProjectManager, b2wJobs.getProjectManagerText(), "Verify Project Manager");
		logCompare(sJobStatus, b2wJobs.getProjectStatusText(), "Verify Project Status");
		logCompare(sJobCustomer, b2wJobs.getCustomerText(), "Verify Customer");
		logCompare(sLaborRateClass, b2wJobs.getDefaultLaborRateClassText(), "Labor Rate Class");
		logCompare(sEquipRateClass, b2wJobs.getEquipmentRateClassText(), "Equip Rate Class");
		
	}
	
	public void addJobSite(){
		logCompare(true, b2wJobs.clickAddJobSiteButton(), "Create new Job site");
		logCompare(true, b2wJobs.setJobSiteDescription(sJobSiteDesc), "Job Desc");
		logCompare(true, b2wJobs.setJobSiteAddress(sJobSiteAddress), "Job Site Address");
		logCompare(true, b2wJobs.setJobSiteCity(sJobSiteCity), "Job Site City");
		logCompare(true, b2wJobs.setJobSiteState(sJobSiteState), "Job State");
		logCompare(true, b2wJobs.setJobSiteZip(sJobSiteZipCode), "Zip Code");
		logCompare(true, b2wJobs.saveJobSite(), "Save Site");
		
	}
	
	
	public void createNewJobProductionAccount() {

		logCompare(true,b2wJobs.clickTrackingAccountsTab(), "Click Tracking Accounts tab");
		logCompare(true,b2wJobs.clickAddNewJobProductionAccount(), "Click Add New Job Production Account");
		logCompare(true,b2wJobs.setJobProductionAccountTrackingIDText(sNewJobProductionAccountTrackID), "Set Account tracking ID");
		logCompare(true,b2wJobs.setJobProductionAccountDescriptionText(sNewJobProductionAccountDescription), "Job Production Desc");
		b2wJobs.selectJobProductionAccountID();
		logCompare(true, b2wJobs.clickTopSaveButton(), "save account");
		
	}
	
	public void createNewJobOverheadAccount() {
		logCompare(true,b2wJobs.clickAddNewOverheadAccount(), "Create New Overhead Account");
		logCompare(true,b2wJobs.setJobOverheadDescription(sNewJobOverheadAccountDescription), "Overhead acocunt description");
		logCompare(true,b2wJobs.setJobOverheadTrackingID(sNewJobOverheadAccountTrackID), "Overhead account tracking id");
		b2wJobs.selectJobOverheadAccountID();
		logCompare(true,b2wJobs.clickTopSaveButton(), "Save Overhead account");
		
	}
	
	
	public void addMaterials() {

		logCompare(true,b2wJobs.clickMaterialsTab(), "Click Materials Tab");
		logCompare(true,b2wJobs.clickAddMaterialsButton(),"Click add materials button");
		B2WAddToJobs b2wJobsAdd = new B2WAddToJobs(B2WJobsTasks.JOBSDIALOG.ADDMATERIALS);
		logCompare(true,b2wJobsAdd.setSearchText(sMaterialsDescriptionD), "Search for Material");
		logCompare(true,b2wJobsAdd.clickSearchButton(),"Click Search");
		logCompare(true,b2wJobsAdd.setIDText(sMaterialsIDD),"Set ID");
		if (logCompare(true,b2wJobsAdd.clickSelectButton(), "Select button")){
			b2wJobsAdd.clickAddButton();
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
			b2wJobsAdd.clickAddButton();
		}else{
			b2wJobsAdd.clickCancelButton();
		}
		logCompare(true,b2wJobs.clickAddTruckingSubcontractorsButton(), "Click Truck Subs");
		b2wJobsAdd = new B2WAddToJobs(B2WJobsTasks.JOBSDIALOG.ADDTRUCKINGSUBCONTRACTORS);
		logCompare(true,b2wJobsAdd.setSearchText(sOrganizationCompanyNameB), "Select Organization");
		logCompare(true,b2wJobsAdd.clickSearchButton(), "Click Search Button");
		logCompare(true,b2wJobsAdd.setIDText(sOrganizationCompanyIDB), "Set ID");

		if (logCompare(true,b2wJobsAdd.clickSelectButton(), "Select button")){
			b2wJobsAdd.clickAddButton();
		}else{
			b2wJobsAdd.clickCancelButton();
		}

	}
	
	public void addEmployeeToUser() {
		assertTrue("Open Setup Users", b2wNT.openSetupUsers());
		String sLastName = b2wNT.getLastNameOfUser();
		//logCompare("Michael LeDuc",b2wNav.getUserName(), "User Names");
		//TaskUtils.logScreenCapture();
		assertTrue("Search for Last Name",userTasks.enterTextAndClickSearch(b2wNT.getUserName()));
		assertTrue("Open the user",userTasks.openUserByLastName(sLastName));
		assertTrue("Edit the User",userTasks.clickEditButton());
		userTasks.selectEmployeeFromDD("Test User");
		userTasks.clickTopSaveButton();
		logCompare("Test User", userTasks.getEmployeeText(), "Employee Name");
		
	}
	
	public void addCreateNewTMWorkItem() {
		B2WTMWorkItemTab b2wTM = new B2WTMWorkItemTab();
		b2wJobs.clickTMWorkTab();
		b2wJobs.clickCreateNewTMWorkItemButton();
		b2wTM.setTMWorkItemDescription("Silver Gold");
		b2wTM.selectRequestedByFromDD("Ted Arnold");
		b2wTM.saveTMWorkItem();
		
	}

}