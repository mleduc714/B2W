package testcases;

import java.text.SimpleDateFormat;

import com.b2w.test.B2WTestCase;

import appobjects.jobs.B2WJobs;
import tasks.B2WNavigationTasks;
import tasks.jobs.B2WJobsTasks;

public class TestSetup extends B2WTestCase {



	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WJobsTasks b2wJob = new B2WJobsTasks();


	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");

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
		int  n = getRandomNumber();

	}

	public void testMain() throws Throwable {

		logCompare(true,b2wNav.openJobs(),"Go Home");
		logCompare(true,b2wJob.enterInfoAndSearchForResource("2007-0006"), "Navigate to Job");
		logCompare(true,b2wJob.openJobByJobNumber("2007-0006"),"Open Job");
		logCompare(true,b2wJob.clickEstimatesItemsTab(), "Click on Estimate Tab");
		logCompare(true,b2wJob.clickCreateNewEstimateButton(),"Create Estimate Item");
		logCompare(true,b2wJob.setEstimateItemNumber("123450"), "Fill Item Number");
		logCompare(true,b2wJob.setEstimateEstimatedQuantity("5.55"),"Fill Estimated Quantity");
		logCompare(true,b2wJob.setEstimateItemID("098673"),"Fill Item ID");
		logCompare(true,b2wJob.setEstimateChangeOrderQuantity("55"),"Fill Change Order Quantity");
		logCompare(true,b2wJob.setEstimateDescription("This is a Job Estimate Item."),"Fill Description");
		logCompare(true,b2wJob.setEstimateUnitOfMeasure("ACRE"), "Fill Unit of Measure");
		logCompare(true,b2wJob.setEstimateUnitBidPriceEstimated("4"), "Fill Unit Bid Price Estimated");
		logCompare(true,b2wJob.setEstimateUnitBidPriceChangeOrder("4"), "Fill Unit Bid Proce Change Order");
		logCompare(true,b2wJob.setEstimateTotalBidPriceEstimated("6"), "Fill Total Bid Price Estimated");
		logCompare(true,b2wJob.setEstimateTotalBidPriceChangeOrder("7"),"Fill Total Bid Price Change Order");
		logCompare(true,b2wJob.clickBottomSaveButton(),"Save Button Clicked");
		logCompare(true,b2wJob.clickChangeOrderTab(),"Click on Change Orders Tab");
		logCompare(true,b2wJob.clickCreateNewChangeOrderButton(),"Create Change Order");
		logCompare(true,b2wJob.setChangeOrdersID("1234567892"),"Fill Change Order ID");
		logCompare(true,b2wJob.setChangeOrdersAlternateID("654321"),"Fill Alternate ID");
		logCompare(true,b2wJob.setChangeOrdersDescription("This is a new Change Order"),"Fill Description");
		logCompare(true,b2wJob.setChangeOrdersType("External"),"Fill Change Order Type");
		logCompare(true,b2wJob.setChangeOrdersStatus("Approved"),"Fill Status");
		logCompare(true,b2wJob.setChangeOrdersEstimatedQuantity("8"),"Fill Estimated Quantity");
		logCompare(true,b2wJob.setChangeOrdersUnitOfMeasure("LITER"),"Fill Unit of Measure");
		logCompare(true,b2wJob.clickBottomSaveButton(),"Save Button Clicked");
		

	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	
}
