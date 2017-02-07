package testcases.jobs;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WEstimateItemTasks;
import tasks.jobs.B2WJobProductionAccountTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.util.TaskUtils;

public class B2WCommonJobsMethods {

	static B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	static B2WJobsTasks b2wJobs = new B2WJobsTasks();
	static B2WJobProductionAccountTasks b2wCreateJobProd = new B2WJobProductionAccountTasks();
	static B2WEstimateItemTasks estimate = new B2WEstimateItemTasks();
	
	B2WJobsTasks jobsTasks = new B2WJobsTasks();

	public static void test1(String sNumber) {

		b2wNav.openJobs();
		b2wJobs.openJobByJobNumber(sNumber);
		b2wJobs.clickTrackingAccountsTab();
		b2wJobs.openTrackingAccountByTrackingID("1100");
		b2wCreateJobProd.getReportedSummary(0);
//		b2wCreateJobProd.editJobProductionAccount();
//		b2wCreateJobProd.setJobProductionSupervisorProjectedUnitCost("100");
//		b2wCreateJobProd.setJobProductionManagerProjectedUnitCost("200");
//		TaskUtils.sleep(5000);
	
	}
	
	public static void getIDs(String sNumber) {
		b2wNav.openJobs();
		b2wJobs.openJobByJobNumber(sNumber);
		b2wJobs.clickEstimatesItemsTab();
		estimate.openEstimateItemByItemID("1200");
		estimate.editEstimatedByCostBreakdownID("1200-1100.a");
		TaskUtils.sleep(1000);
		
	}
	
	public boolean openJob(String[] sJobs) {
		
		b2wNav.openJobs();
		boolean bReturn = false;
		for (int i = 0; i < sJobs.length; i++){
			bReturn = jobsTasks.openJobByJobNumber(sJobs[i]);
			if (bReturn){
				break;
			}
		}
		return bReturn;
	}
	
}

