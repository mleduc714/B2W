package testcases.jobs;

import com.b2w.test.B2WTestCase;

import tasks.jobs.B2WJobsTasks;

public class B2WJobTestCase extends B2WTestCase {
	
	private B2WJobsTasks b2wJobs = new B2WJobsTasks();

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
	}

	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		
		//Navigate to the Jobs area and create a new Job
				//a.Populate the General Information 
		//Create a Job Site
		        // populate all info
		// add materials
		       // add Crushed Gravel CRGRVL02
		//add a vendor
		      // add northern steel
		// add job production account
		     // enter info
		// create new t&m work item
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
		return super.getCategory();
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return super.getAuthor();
	}

	@Override
	public String getDataPath() {
		// TODO Auto-generated method stub
		return super.getDataPath();
	}

	@Override
	public boolean isSupported() {
		// TODO Auto-generated method stub
		return super.isSupported();
	}

}
