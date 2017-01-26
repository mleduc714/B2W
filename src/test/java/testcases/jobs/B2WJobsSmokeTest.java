package testcases.jobs;

import java.util.ArrayList;
import java.util.Collections;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.util.TaskUtils;

public class B2WJobsSmokeTest extends B2WTestCase {
	
	B2WJobsTasks b2wJobs = new B2WJobsTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
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
		b2wNav.openJobs();
		b2wJobs.clickJobNumberHeader();
		b2wJobs.clickJobTitleHeader();
		getAllJobsByTitle();
		TaskUtils.sleep(3000);
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
		
	public ArrayList<String> getAllJobsByTitle() {
		ArrayList<String> al = new ArrayList<String>();
		int iPages = b2wJobs.getTotalPages();
		for (int i = 1; i < iPages; i++){
			b2wJobs.clickPage(i);
			TaskUtils.sleep(1000);
			al.addAll(b2wJobs.getJobsByJobTitle());
		}
		Collections.sort(al);
		return al;
	}

	public ArrayList<String> getAllJobsByNumber() {
		ArrayList<String> al = new ArrayList<String>();
		int iPages = b2wJobs.getTotalPages();
		for (int i = 1; i < iPages; i++){
			b2wJobs.clickPage(i);
			TaskUtils.sleep(1000);
			al.addAll(b2wJobs.getJobsByJobNumber());
		}
		Collections.sort(al);
		return al;
	}
}
