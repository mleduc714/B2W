package testcases.jobs;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WJobProductionAccountTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WJobOverheadAccountTasks;
import tasks.util.TaskUtils;

public class B2WTrackingAccounts extends B2WTestCase {
	
	String sJobCProductionAccountA, sJobCOverheadAccountA, sJobCOverheadAccountB, sJobCOverheadAccountC, sJobC;
	String sJobCProductionAccountAEstimatedTotalCost,sJobCProductionAccountAEstimatedUnitCost,sJobCProductionAccountATotalEstimatedUnitCost;
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WJobsTasks b2wJob = new B2WJobsTasks();
	B2WJobOverheadAccountTasks jobOverhead = new B2WJobOverheadAccountTasks();
	B2WJobProductionAccountTasks prodAccount = new B2WJobProductionAccountTasks();
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		sJobCProductionAccountA = getProperty("sJobCProductionAccountA");
		sJobCOverheadAccountA = getProperty("sJobCOverheadAccountA");
		sJobCOverheadAccountB = getProperty("sJobCOverheadAccountB");
		sJobCOverheadAccountC = getProperty("sJobCOverheadAccountC");
		sJobCProductionAccountAEstimatedTotalCost = getProperty("sJobCProductionAccountAEstimatedTotalCost");
		sJobCProductionAccountAEstimatedUnitCost = getProperty("sJobCProductionAccountAEstimatedUnitCost");
		sJobCProductionAccountATotalEstimatedUnitCost = getProperty("sJobCProductionAccountATotalEstimatedUnitCost");
		sJobC = getProperty("sJobC");
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
		return "Tracking Accounts";
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

		b2wNav.openJobs();
		b2wJob.openJobByJobNumber(sJobC);
		b2wJob.clickTrackingAccountsTab();
		new TaskUtils().getAllIDS();
/*		prodAccount.openJobProductionAccountByTrackingID(sJobCProductionAccountA);
		prodAccount.clickTopEditButton();
		prodAccount.setJobProductionEstimatedQuantity("5");
		prodAccount.setJobProductionChangeOrderQuantity("1");
		prodAccount.saveJobProductionAccount();
		logCompare(this.sJobCProductionAccountAEstimatedTotalCost, prodAccount.getEstimatedTotalCost(), "Verify changes to cost");
		logCompare(this.sJobCProductionAccountAEstimatedUnitCost, prodAccount.getEstimatedUnitCost(), "Verify Unit cost changed");
		logCompare(sJobCProductionAccountATotalEstimatedUnitCost, prodAccount.getTotalEstimatedUnitCost(), "Verify Unit cost Changed");
		logCompare(this.sJobCProductionAccountAEstimatedTotalCost, prodAccount.getTotalEstimatedTotalCost(), "Verify Total cost changed");

		
		prodAccount.clickPathLink();
		b2wJob.clickTrackingAccountsTab();
		logCompare("5.00",prodAccount.getEstimatedQuantity(sJobCProductionAccountA), "Verify Quantity");
		logCompare("1.00",prodAccount.getChangeOrderQuantity(sJobCProductionAccountA), "Verify Change Order");
		logCompare(this.sJobCProductionAccountATotalEstimatedUnitCost, prodAccount.getEstimatedUnitCost(sJobCProductionAccountA), "Verify Unit cost changed");
*/		
		TaskUtils.sleep(5000);
		
	}
	
	


}
