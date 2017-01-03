package testcases;

import com.b2w.test.B2WTestCase;

public class B2WTestCaseTemplate extends B2WTestCase {

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
		// testcase
		// enter steps of the test
		// 1
		// 2
		// 3
		// 4
		// 5
		
	}

}
