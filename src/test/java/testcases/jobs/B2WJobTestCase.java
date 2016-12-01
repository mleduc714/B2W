package testcases.jobs;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WAddToJobs;
import tasks.jobs.B2WCreateJobProductionAccountTasks;
import tasks.jobs.B2WCreateJobSiteTasks;
import tasks.jobs.B2WCreateJobTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WJobsTasks.JOBSDIALOG;
import tasks.util.TaskUtils;

public class B2WJobTestCase extends B2WTestCase {
	
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
		B2WCreateJobTasks b2wCreate = new B2WCreateJobTasks();
		B2WCreateJobSiteTasks b2wJobSite = new B2WCreateJobSiteTasks();
		B2WAddToJobs addToJobs = new B2WAddToJobs(JOBSDIALOG.ADDMATERIALS);
		B2WAddToJobs addToVendors = new B2WAddToJobs(JOBSDIALOG.ADDVENDORS);
		B2WCreateJobProductionAccountTasks jobProd = new B2WCreateJobProductionAccountTasks();
		
		//Navigate to the Jobs area and create a new Job
		b2wNav.openJobs();
		jobsTasks.clickCreateNewJob();
				//a.Populate the General Information
		logCompare(true, b2wCreate.setJobNumber(jobsTasks.randomNumberGenerator()), "Add Job Number");
		String jobTitle = "This is a new Job Title #" + jobsTasks.randomNumberGenerator();
		logCompare(true, b2wCreate.setJobTitle(jobTitle), "Set Job Title");
		logCompare(true, b2wCreate.setProjectManagerFromDD("Abigail Mitchell"), "Set Project Manager from Dropdown");
		logCompare(true, b2wCreate.setJobProjectName("This is a New Job Project"), "Set Project Name");
		logCompare(true, b2wCreate.setJobProjectStatusFromDD("Complete"), "Set Project Status from Dropdowm");
		logCompare(true, b2wCreate.setJobProjectCustomerFromDD("Agnerson Construction"), "Set Project Customer from Dropdown");
		logCompare(true, b2wCreate.setJobDefaultLaborRateClassFromDD("New Hampshire Rates"), "Set Default Labor Rate Class from Dropdown");
		logCompare(true, b2wCreate.setJobEquipmentRateClassFromDD("Do Not Use Active Rates"), "Set Equipment Rate Class from Dropdown");
		jobsTasks.clickBottomSaveButton();
		
		//Create a Job Site
		jobsTasks.clickAddJobSiteButton();
		String jobDescription = "This is a new Job Site #" + jobsTasks.randomNumberGenerator();
		logCompare(true, b2wJobSite.setJobSiteDescription(jobDescription), "Set Job Site Description");
		logCompare(true, b2wJobSite.setJobSiteStartDate("10/28/2017"), "Set Job Site Start Date");
		logCompare(true, b2wJobSite.setJobSiteDurationType("No End Date"), "Set Job Site Duration Type");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayMonday(true), "Set Job Site Non Working Day Monday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayTuesday(true), "Set Job Site Non Working Day Tuesday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayWednesday(true), "Set Job Site Non Working Day Wednesday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayThursday(true), "Set Job Site Non Working Day Thursday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayFriday(true), "Set Job Site Non Working Day Friday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDaySaturday(true), "Set Job Site Non Working Day Saturday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDaySunday(true), "Set Job Site Non Working Day Sunday");
		logCompare(true, b2wJobSite.setShowOnJobBoard(true), "Set Show on Board");
		logCompare(true, b2wJobSite.setJobSiteAddress("99 Bow Street"), "Set Job Site Address");
		logCompare(true, b2wJobSite.setJobSiteCity("Portsmouth"), "Set Job Site City");
		logCompare(true, b2wJobSite.setJobSiteState("New Hampshire"), "Set Job Site State");
		logCompare(true, b2wJobSite.setJobSiteZip("03801"), "Set Job Site Zip");
		logCompare(true, b2wJobSite.setJobCountry("USA"), "Set Job Country");
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
		logCompare(true, jobProd.setJobProductionAccountTrackingIDText(jobsTasks.randomNumberGenerator()), "Set Job Production Account Tracking ID Text");
		logCompare(true, jobProd.setJobProductionAccountDescriptionText("This is a new job production account. " + jobsTasks.randomNumberGenerator()), "Set Job Production Account Description Text");
		logCompare(true, jobProd.selectJobProductionAccountIDFromDD("1000 - Asphalt"), "Select Job Production Account ID from Dropdown");
		jobProd.setJobProductionAccountComplete(true);
		jobsTasks.clickBottomSaveButton();
		
		jobsTasks.clickGeneralInfoTab();
		logCompare(true,jobsTasks.clickBottomDeleteButton(),"Click Delete");
		logCompare(true,TaskUtils.dismissAlert(),"Dismiss Alert");
		
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
