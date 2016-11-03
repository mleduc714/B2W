package testcases.jobs;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WAddToJobs;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WJobsTasks.JOBSDIALOG;
import tasks.resources.B2WAddMaterialsTasks;
import tasks.util.TaskUtils;
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
		B2WAddToJobs addToVendors = new B2WAddToJobs(JOBSDIALOG.ADDVENDORS);
		
		//Navigate to the Jobs area and create a new Job
		b2wNav.openJobs();
		jobsTasks.clickCreateNewJob();
				//a.Populate the General Information
		jobsTasks.setJobNumber(jobsTasks.randomNumberGenerator());
		logCompare(true, jobsTasks.setJobNumber(jobsTasks.randomNumberGenerator()), "Add Job Number");
		String jobTitle = "This is a new Job Title #" + jobsTasks.randomNumberGenerator();
		logCompare(true, jobsTasks.setJobTitle(jobTitle), "Set Job Title");
		logCompare(true, jobsTasks.setProjectManagerFromDD("Abigail Mitchell"), "Set Project Manager from Dropdown");
		logCompare(true, jobsTasks.setProjectName("This is a New Job Project"), "Set Project Name");
		logCompare(true, jobsTasks.setProjectStatusFromDD("Complete"), "Set Project Status from Dropdowm");
		logCompare(true, jobsTasks.setProjectCustomerFromDD("Agnerson Construction"), "Set Project Customer from Dropdown");
		logCompare(true, jobsTasks.setDefaultLaborRateClassFromDD("New Hampshire Rates"), "Set Default Labor Rate Class from Dropdown");
		logCompare(true, jobsTasks.setEquipmentRateClassFromDD("Do Not Use Active Rates"), "Set Equipment Rate Class from Dropdown");
		jobsTasks.clickBottomSaveButton();
		
		//Create a Job Site
		jobsTasks.clickAddJobSiteButton();
		String jobDescription = "This is a new Job Site #" + jobsTasks.randomNumberGenerator();
		logCompare(true, jobsTasks.setJobSiteDescription(jobDescription), "Set Job Site Description");
		logCompare(true, jobsTasks.setJobSiteStartDate("10/28/2017"), "Set Job Site Start Date");
		logCompare(true, jobsTasks.setJobSiteDurationType("No End Date"), "Set Job Site Duration Type");
		logCompare(true, jobsTasks.setJobSiteNonWorkingDayMonday(true), "Set Job Site Non Working Day Monday");
		logCompare(true, jobsTasks.setJobSiteNonWorkingDayTuesday(true), "Set Job Site Non Working Day Tuesday");
		logCompare(true, jobsTasks.setJobSiteNonWorkingDayWednesday(true), "Set Job Site Non Working Day Wednesday");
		logCompare(true, jobsTasks.setJobSiteNonWorkingDayThursday(true), "Set Job Site Non Working Day Thursday");
		logCompare(true, jobsTasks.setJobSiteNonWorkingDayFriday(true), "Set Job Site Non Working Day Friday");
		logCompare(true, jobsTasks.setJobSiteNonWorkingDaySaturday(true), "Set Job Site Non Working Day Saturday");
		logCompare(true, jobsTasks.setJobSiteNonWorkingDaySunday(true), "Set Job Site Non Working Day Sunday");
		logCompare(true, jobsTasks.setShowOnJobBoard(true), "Set Show on Board");
		logCompare(true, jobsTasks.setJobSiteAddress("99 Bow Street"), "Set Job Site Address");
		logCompare(true, jobsTasks.setJobSiteCity("Portsmouth"), "Set Job Site City");
		logCompare(true, jobsTasks.setJobSiteState("New Hampshire"), "Set Job Site State");
		logCompare(true, jobsTasks.setJobSiteZip("03801"), "Set Job Site Zip");
		logCompare(true, jobsTasks.setJobCountry("USA"), "Set Job Country");
		jobsTasks.clickBottomSaveButton();
		
		// add materials
		jobsTasks.clickMaterialsTab();
		jobsTasks.clickAddMaterialsButton();
		logCompare(true, addToJobs.setSearchText("CRGRVL02"), "Set Search Text");
		addToJobs.clickSearchButton();
		addToJobs.setIDText("CRGRVL02");
		addToJobs.clickSelectButton();
		addToJobs.clickAddButton();
		
		//add a vendor
		jobsTasks.clickSubsVendorsTab();
		jobsTasks.clickAddVendors();
		logCompare(true, addToJobs.setSearchText("NOR98"), "Set Search Text");
		addToVendors.clickSearchButton();
		addToVendors.setIDText("NOR98");
		addToVendors.clickSelectButton();
		addToVendors.clickAddButton();
		
		// add job production account
		jobsTasks.clickTrackingAccountsTab();
		jobsTasks.clickAddNewJobProductionAccount();
		logCompare(true, jobsTasks.setJobProductionAccountTrackingIDText(jobsTasks.randomNumberGenerator()), "Set Job Production Account Tracking ID Text");
		logCompare(true, jobsTasks.setJobProductionAccountDescriptionText("This is a new job production account. " + jobsTasks.randomNumberGenerator()), "Set Job Production Account Description Text");
		logCompare(true, jobsTasks.selectJobProductionAccountIDFromDD("1000 - Asphalt"), "Select Job Production Account ID from Dropdown");
		jobsTasks.setJobProductionAccountComplete(true);
		jobsTasks.clickBottomSaveButton();
		
		jobsTasks.clickGeneralInfoTab();
		jobsTasks.clickBottomDeleteButton();
		TaskUtils.dismissAlert();
		
		     // enter info
		
		// create new t&m work item
		
		//jobsTasks.clickTMWorkTab();
		//jobsTasks.clickCreateNewTMWorkItemButton();
		
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
