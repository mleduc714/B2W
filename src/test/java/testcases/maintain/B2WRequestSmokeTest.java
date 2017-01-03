package testcases.maintain;

import com.b2w.test.B2WTestCase;

public class B2WRequestSmokeTest extends B2WTestCase {
	


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
		return "author";
	}

	@Override
	public String getTestDescription() {
		// enter the description for the testcase
		return "Testcase description";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/test";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		/*	Go to start of metadata 
		Repair Requests
		•Create New Requests
		•Edit existing Requests (should only be able to edit requests with a status of Requested)
		•Delete a Request (based on status and users security role permissions)
		•Add/Edit/Delete Comments on a Request
		•Add/Edit/Delete Attachments on a Request
		•Adding a Request to a Work Order
		•Links to Equipment
		•Search for information on Requests including Expanded Search
		•Explore Advanced Search & Filters
		•Navigation options to Requests*/
		

	}

}
