package testcases.jobs;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WCreateJobTasks;
import tasks.jobs.B2WJobsTasks;

public class B2WJobsSmokeTest extends B2WTestCase {
	
	B2WJobsTasks b2wJobs = new B2WJobsTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WCreateJobTasks b2wCreate = new B2WCreateJobTasks();
	
	String sJobNumberA, sJobTitleA, sJobBusinssUnitA, sJobStatusA, sJobNumberB, sJobTitleB, sJobBusinssUnitB,
			sJobStatusB, sJobNumberC, sJobTitleC, sJobBusinssUnitC, sJobStatusC, sJobNumberD, sJobTitleD,
			sJobBusinssUnitD, sJobStatusD, sJobNumberE, sJobTitleE, sJobBusinssUnitE, sJobStatusE;
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		sJobNumberA= getProperty("sJobNumberA");
		sJobTitleA= getProperty("sJobTitleA");
		sJobBusinssUnitA= getProperty("sJobBusinssUnitA");
		sJobStatusA= getProperty("sJobStatusA");
		sJobNumberB= getProperty("sJobNumberB");
		sJobTitleB= getProperty("sJobTitleB");
		sJobBusinssUnitB= getProperty("sJobBusinssUnitB");
		sJobStatusB= getProperty("sJobStatusB");
		sJobNumberC= getProperty("sJobNumberC");
		sJobTitleC= getProperty("sJobTitleC");
		sJobBusinssUnitC= getProperty("sJobBusinssUnitC");
		sJobStatusC= getProperty("sJobStatusC");
		sJobNumberD= getProperty("sJobNumberD");
		sJobTitleD= getProperty("sJobTitleD");
		sJobBusinssUnitD= getProperty("sJobBusinssUnitD");
		sJobStatusD= getProperty("sJobStatusD");
		sJobNumberE= getProperty("sJobNumberE");
		sJobTitleE= getProperty("sJobTitleE");
		sJobBusinssUnitE= getProperty("sJobBusinssUnitE");
		sJobStatusE = getProperty("sJobStatusE");
	}

	@Override
	public void testTearDown() throws Throwable {
		// code here for code after the test complete. 
		// cleanup
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() {
		return "mleduc";
	}

	@Override
	public String getTestDescription() {
		// enter the description for the testcase
		return "Testcase description";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/jobs";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {

//		Jobs Exploratory Testing Guide
//		Job Listing Page
		logCompare(true,b2wNav.openJobs(),"Open Jobs");
		logCompare(true,b2wJobs.clickCreateNewJob(), "Create new job");
		logCompare(true, b2wCreate.setJobTitle(sJobNumberA), "Set Job Title");
		logCompare(true, b2wCreate.setProjectManagerFromDD("Abigail Mitchell"), "Set Project Manager from Dropdown");
		logCompare(true, b2wCreate.setJobProjectName("This is a New Job Project"), "Set Project Name");
		logCompare(true, b2wCreate.setJobProjectStatusFromDD("Complete"), "Set Project Status from Dropdowm");
		logCompare(true, b2wCreate.setJobProjectCustomerFromDD("Agnerson Construction"), "Set Project Customer from Dropdown");
		logCompare(true, b2wCreate.setJobDefaultLaborRateClassFromDD("New Hampshire Rates"), "Set Default Labor Rate Class from Dropdown");
		logCompare(true, b2wCreate.setJobEquipmentRateClassFromDD("Do Not Use Active Rates"), "Set Equipment Rate Class from Dropdown");
//		Search
		
//		Column Sort
//		Copy button
//		Character Filtering
//		Import
//		‘Show Inactive Jobs’ checkbox
//		Create job
//		Add general info and save
//		Edit/Save general information
//		Add/Edit/Delete Attachments
//		Delete a Job
//		Create a new job then delete
//		Attempt to delete a job that contains a job site in use (job site has assignments)
//		Working with an existing job
//		General Information tab
//		Add/Edit/Delete Job Sites
//		Add/Edit/Delete Attachments
//		Edit General Information Tab
//		Change data under the General Information heading
//		Add/Edit/Delete Labor Rate Classes
//		Estimate Items tab
//		Sort/edit/delete Estimate Items
//		Create new Job Estimate Item
//		Create new cost breakdown elements (at least one with Materials)
//		Sorting of cost breakdown elements list view
//		Sorting of estimate items list view
//		Tracking Accounts tab
//		Create New Job Production Account
//		Add/remove cost breakdown elements
//		Create New Job Overhead Account
//		Add/remove cost breakdown elements
//		Edit/delete/sort Job Production Account
//		Edit/delete/sort Job Overhead Account
//		Materials tab
//		Add/delete materials
//		Sort
//		Navigate to Material Information page by clicking Description and Material ID 
//		Subs & Vendors tab
//		Add/Delete
//		Job Subcontractors
//		Job Trucking Subcontractors
//		Job Vendors
//		Activity tab
//		Note: Select a job that has activity data. Some jobs in the Testing database do not have activity data.
//		Sorting
//		Show Information for Account Type
//		Check various Activity ID links to existing field logs
//		Create a new field log
//		Right-click and create in a new tab; exercise just enough to assure that you are creating a Field Log in the Jobs area.
//		Change Orders tab
//		Create new change order
//		Add cost breakdown
//		Associate with existing Estimate Item
//		Set change order quantity & change order unit bid price on associated Estimate Item
//		T&M Work tab
//		Time & Material Rates
//		Check links to rate sheets
//		Copy T&M Rates from a Job
//		Other Markups
//		Edit markups
//		Time & Material Work Items
//		Create new T&M Work Item
//		Edit/delete a T&M work item
//		Test links in Tracking ID and Description columns
//		

		
	}

}
