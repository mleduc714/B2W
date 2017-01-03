package testcases.maintain;

import com.b2w.test.B2WTestCase;

public class B2WPartsSmokeTest extends B2WTestCase {

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
		/*	
		 Add a New Part
		•Provide values to Required Fields
		•Enter in a Standard Unit Cost, Minimum Inventory, Reorder Quantity
		•Add a warranty
		•Add an Attachment

		•Add a Primary Vendor
		•Explore Inventory History and Purchase Order History 
		•Add the new part to Inventory, Create Request, Work Order,and Purchase Order to create Part history for these entities

		•Explore Links within the Entities - Work Order, PO#, Attachments, Vendor
		•Explore Inactive and Active Parts
		•Edit a Part
		•Delete a Part (Including confirming message when deleting a Part in use)
		•Explore Filters & Search & Sorting - Part List and Filtering/Sorting within the Entities
		•Explore having enough Vendors, Inventory History, PO History to increment the items per page and navigating to next page and back
		•Security Permissions
		•Navigation options to Parts Page
		*/
		
		
		
	}


}
