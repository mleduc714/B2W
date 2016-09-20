package testcases.b2w;

import com.b2w.test.B2WTestCase;

public class OperationsSmokeB extends B2WTestCase {
	
	
	
/*	
 * Create new entities of the following types, through the Resources area
 * 
 *  a.Production Account
	b.Overhead Account
	c.Material
	
	
 * */



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
		//check do I need to remove access
		//removeAllAccess();
	}

}
