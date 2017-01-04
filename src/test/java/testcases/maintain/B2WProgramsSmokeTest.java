package testcases.maintain;

import com.b2w.test.B2WTestCase;

public class B2WProgramsSmokeTest extends B2WTestCase {
	

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
		/*	Create a New Maintenance Program
		•Add Item(s)
		•Enter Intervals
		•Enter Exclusions
		•Enter Planned Hours
		•Enter Parts to be used with the Maintenance Program
		•Save

		•Attachments•CRUD

		•Copy a Maintenance Program
		•Edit a Maintenance Program•Add/Remove Items

		•Equipment on a program•Add equipment
		•Search for equipment within entity
		•Generate interval for a piece of equipment
		•Remove equipment from program

		•Attempt to Delete a Maintenance Program that has been associated with a piece of Equipment (You should not be able to delete)
		•Explore Search and Business Unit Filter
		•Explore sorting of Program List
		•Security Permissions
		•Navigation options to Programs page
	*/
		
	}

}
