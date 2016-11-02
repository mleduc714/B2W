package testcases.jobs;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WAddToJobs;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WJobsTasks.JOBSDIALOG;
import tasks.resources.B2WAddMaterialsTasks;
import testcases.OperationsSmokeF;

public class B2WJobTestCase extends B2WTestCase {
	
	private B2WJobsTasks b2wJobs = new B2WJobsTasks();
	private B2WNavigationTasks b2wNav = new B2WNavigationTasks();

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
	}

	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		b2wNav.clickHome();
		
		B2WJobsTasks jobsTasks = new B2WJobsTasks();
		B2WAddMaterialsTasks addMaterialsTasks = new B2WAddMaterialsTasks();
		B2WAddToJobs addToJobs = new B2WAddToJobs(JOBSDIALOG.ADDMATERIALS);
		OperationsSmokeF opsF = new OperationsSmokeF();
		
		//Navigate to the Jobs area and create a new Job
		jobsTasks.jobsPageOpen();
		jobsTasks.clickCreateNewJob();
				//a.Populate the General Information
		jobsTasks.setJobNumber(jobsTasks.randomNumberGenerator());
		String jobTitle = "This is a new Job Title #" + jobsTasks.randomNumberGenerator();
		jobsTasks.setJobTitle(jobTitle);
		jobsTasks.setProjectManagerFromDD("Abigail Mitchell");
		jobsTasks.setProjectName("This is a New Job Project");
		jobsTasks.setProjectStatusFromDD("Complete");
		jobsTasks.setProjectCustomerFromDD("Agnerson Construction");
		jobsTasks.setDefaultLaborRateClassFromDD("New Hampshire Rates");
		jobsTasks.setEquipmentRateClassFromDD("Do Not Use Active Rates");
		
		//Create a Job Site
		jobsTasks.clickAddJobSiteButton();
		String jobDescription = "This is a new Job Site #" + jobsTasks.randomNumberGenerator();
		jobsTasks.setJobSiteDescription(jobDescription);
		jobsTasks.setJobSiteStartDate("10/28/2017");
		jobsTasks.setJobSiteDurationType("No End Date");
		jobsTasks.setJobSiteNonWorkingDayMonday(true);
		jobsTasks.setJobSiteNonWorkingDayTuesday(true);
		jobsTasks.setJobSiteNonWorkingDayWednesday(true);
		jobsTasks.setJobSiteNonWorkingDayThursday(true);
		jobsTasks.setJobSiteNonWorkingDayFriday(false);
		jobsTasks.setJobSiteNonWorkingDaySaturday(false);
		jobsTasks.setJobSiteNonWorkingDaySunday(false);
		jobsTasks.setShowOnJobBoard(true);
		jobsTasks.setJobSiteAddress("99 Bow Street");
		jobsTasks.setJobSiteCity("Portsmouth");
		jobsTasks.setJobSiteState("New Hampshire");
		jobsTasks.setJobSiteZip("03801");
		jobsTasks.setJobCountry("USA");
		
		//##### Needs to be a 'press Save button' method #####
		
		// add materials
		jobsTasks.clickMaterialsTab();
		jobsTasks.clickAddMaterialsButton();
		       // add Crushed Gravel CRGRVL02
		addMaterialsTasks.setIDToSelect("CRGRVL02");
		addMaterialsTasks.clickSelectButton();
		addMaterialsTasks.clickAddButton();
		
		//add a vendor
		jobsTasks.clickSubsVendorsTab();
		jobsTasks.clickAddVendors();
		addToJobs.setIDText("NOR98");
		addToJobs.clickSelectButton();
		addMaterialsTasks.clickAddButton();
		
		// add job production account
		jobsTasks.clickTrackingAccountsTab();
		jobsTasks.clickAddNewJobProductionAccount();
		jobsTasks.selectJobProductionAccountID();
		jobsTasks.setJobProductionAccountTrackingIDText("0123456");
		jobsTasks.setJobProductionAccountDescriptionText("This is a new job production account.");
		jobsTasks.selectJobProductionAccountIDFromDD("23423423");
		jobsTasks.setJobProductionAccountComplete(true);
		
		     // enter info
		
		// create new t&m work item
		jobsTasks.clickTMWorkTab();
		jobsTasks.clickCreateNewTMWorkItemButton();
		
		// open the job
		// delete the job
				
		super.testMain();
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getDataPath() {
		// TODO Auto-generated method stub
		return "data/jobs";
	}

	@Override
	public boolean isSupported() {
		// TODO Auto-generated method stub
		return true;
	}

}
