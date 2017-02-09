package testcases.jobs;

import java.util.ArrayList;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WEstimateItemBreakDownTasks;
import tasks.jobs.B2WEstimateItemTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.util.TaskUtils;

public class B2WEstimateItemsTest extends B2WTestCase {
	
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WCommonJobsMethods b2wCommon = new B2WCommonJobsMethods();
	B2WEstimateItemTasks b2wEst = new B2WEstimateItemTasks();
	B2WJobsTasks b2wJob = new B2WJobsTasks();
	B2WEstimateItemBreakDownTasks b2wEstItem = new B2WEstimateItemBreakDownTasks();
	
	
	String sJobA, sJobB, sJobC, sJobD, sJobE, sJobF, sJobG, sJobH, sJobI;
	String sEstimateQTY;
	String sItemIDA,sEstimateQTYA, sEstimatedUnitCostA, sEstimatedCurrentUnitCostA,sEstimatedTotalCostA,sCurrentTotalCostA;
	String sItemIDB,sEstimatedCostBreakdownIDB, sUnitCostLaborB,sUnitCostEquipmentOwnedB,sUnitCostEquipmentRentedB,sUnitCostSubcontractedB,
	sExpectedUnitCostB,sUnitCostTruckingB,sUnitCostMiscB,sExpectedTotalCostB, sItemIDC,
	sItemCostBreakdownIDC,sItemCostIDC,sTrackingAccountC,sEstimateItemDescC,sEstimateItemQTYC, sUnitOfMeasureC,
	sUnitCostLaborC,sUnitCostEquipmentOwnedC,sUnitCostEquipmentRentedC,sUnitCostSubcontractedC,
	sUnitCostTruckingC,sUnitCostMiscC, sExpectedUnitCostC,sExpectedTotalCostC,
			sEstimatedUnitCostC, sEstimatedTotalCostC, sEstimatedUnitCurrentCostC, sEstimatedTotalCurrentCostC;
	String[] sJobs;
	ArrayList<String> estimateItemIDs = new ArrayList<String>();
	int iRandom;
	
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		iRandom = getRandomNumber();
		sJobA= getProperty("sJobA");
		sJobB= getProperty("sJobB");
		sJobC= getProperty("sJobC");
		sJobD= getProperty("sJobD");
		sJobE= getProperty("sJobE");
		sJobF= getProperty("sJobF");
		sJobG= getProperty("sJobG");
		sJobH= getProperty("sJobH");
		sJobI= getProperty("sJobI");
		sEstimateQTYA = getProperty("sEstimateQTYA");
		sItemIDA = getProperty("sItemIDA");
		sEstimatedUnitCostA = getProperty("sEstimatedUnitCostA");
		sEstimatedCurrentUnitCostA = getProperty("sEstimatedCurrentUnitCostA");
		sEstimatedTotalCostA = getProperty("sEstimatedTotalCostA");
		sCurrentTotalCostA = getProperty("sCurrentTotalCostA");
		sItemIDB = getProperty("sItemIDB");
		sEstimatedCostBreakdownIDB = getProperty("sEstimatedCostBreakdownIDB");
		sUnitCostLaborB = getProperty("sUnitCostLaborB");
		sUnitCostEquipmentOwnedB = getProperty("sUnitCostEquipmentOwnedB");
		sUnitCostEquipmentRentedB = getProperty("sUnitCostEquipmentRentedB");
		sUnitCostSubcontractedB = getProperty("sUnitCostSubcontractedB");
		sExpectedUnitCostB = getProperty("sExpectedUnitCostB");
		sUnitCostTruckingB = getProperty("sUnitCostTruckingB");
		sUnitCostMiscB = getProperty("sUnitCostMiscB");
		sExpectedTotalCostB = getProperty("sExpectedTotalCostB");
		sItemIDC = getProperty("sItemDC");
		sItemCostBreakdownIDC=getProperty("sItemCostBreakdownIDC")+iRandom;
		sItemCostIDC=getProperty("sItemCostIDC");
		sTrackingAccountC=getProperty("sTrackingAccountC");
		sEstimateItemDescC=getProperty("sEstimateItemDescC");
		sUnitOfMeasureC=getProperty("sUnitOfMeasureC");
		sEstimateItemQTYC = getProperty("sEstimateItemQTYC");
		
		sUnitCostLaborC = getProperty("sUnitCostLaborC");
		sUnitCostEquipmentOwnedC = getProperty("sUnitCostEquipmentOwnedC");
		sUnitCostEquipmentRentedC = getProperty("sUnitCostEquipmentRentedC");
		sUnitCostSubcontractedC = getProperty("sUnitCostSubcontractedC");
		sUnitCostTruckingC = getProperty("sUnitCostTruckingC");
		sUnitCostMiscC = getProperty("sUnitCostMiscC");
		sExpectedUnitCostC = getProperty("sExpectedUnitCostC");
		sExpectedTotalCostC = getProperty("sExpectedTotalCostC");

		sEstimatedUnitCostC = getProperty("sEstimatedUnitCostC");
		sEstimatedTotalCostC = getProperty("sEstimatedTotalCostC");
		sEstimatedUnitCurrentCostC = getProperty("sEstimatedUnitCurrentCostC");
		sEstimatedTotalCurrentCostC = getProperty("sEstimatedTotalCurrentCostC");
		
		sJobs = new String[]{sJobA, sJobB, sJobC, sJobD, sJobE, sJobF, sJobG, sJobH, sJobI};
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
		return "Create,Edit,Delete, Verify Estimate Items";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/estimate";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		// navigate to jobs
		//logCompare(true,b2wEstItem.selectTrackingAccount(sTrackingAccountC), "Select Tracking");

		b2wNav.openJobs();
		b2wCommon.openJob(sJobs);
		b2wJob.clickEstimatesItemsTab();
		b2wEst.editEstimateItemByItemID(sItemIDA);
		b2wEst.setEstimateEstimatedQuantity(sEstimateQTYA);
		b2wEst.saveEstimateItem();
		logCompare(this.sEstimatedUnitCostA,b2wEst.getEstimatedUnitCostEstimated(), "Verify Change in Estimated Unit Cost");
		logCompare(this.sEstimatedCurrentUnitCostA,b2wEst.getEstimatedUnitCostCurrent(), "Verify Change in Estimated Current Unit Cost");
		logCompare(this.sEstimatedTotalCostA,b2wEst.getEstimatedTotalCostEstimated(), "Verify Change in Estimated Total Cost");
		logCompare(this.sCurrentTotalCostA,b2wEst.getEstimatedTotalCostCurrent(), "Verify Change in Estimated Current Total Cost");
		b2wEst.clickPathLink();
	
		logCompare(sEstimateQTYA+".00",b2wEst.getEstimatedQuantity(sItemIDA), "Verify Quantity");
		logCompare(sEstimateQTYA+".00",b2wEst.getEstimatedCurrentQuantity(sItemIDA), "Verify Current Quantity");
		logCompare(sEstimateQTYA+".00",b2wEst.getEstimatedRemainingQuantity(sItemIDA), "Verify Current Quantity");
		logCompare(true,b2wEst.openEstimateItemByItemID(sItemIDB),"Open Estimate Item");
		logCompare(true,b2wEst.editEstimatedByCostBreakdownID(sEstimatedCostBreakdownIDB),"Open Estimate Item");
		logCompare(true,b2wEstItem.setLaborUnitCost(this.sUnitCostLaborB),"Set Labor Unit");
		logCompare(true,b2wEstItem.setEquipmentOwnedUnitCost(this.sUnitCostEquipmentOwnedB),"Equipment Owned");
		logCompare(true,b2wEstItem.setEquipmentRentedUnitCost(this.sUnitCostEquipmentRentedB),"Set Equipment Rent Unit");
		logCompare(true,b2wEstItem.setSubcontractedUnitCost(this.sUnitCostSubcontractedB),"Set Subcontracted Unit");
		logCompare(true,b2wEstItem.setTruckingUnitCost(this.sUnitCostTruckingB),"Set Trucking Unit Cost");
		logCompare(true,b2wEstItem.setMiscUnitCost(this.sUnitCostMiscB),"Set Misc Unit Item");
		logCompare(true,b2wEstItem.saveEstimateItemCostBreakdown(),"Save Estimate Item Breakdown");
		logCompare(sExpectedUnitCostB, b2wEstItem.getEstimatedItemUnitCostBreakdownUnitCost(), "Verify Estimate Unit Cost after updates");
		logCompare(sExpectedTotalCostB, b2wEstItem.getEstimatedItemTotalCostBreakdownUnitCost(), "Verify Total Cost");
		b2wEstItem.clickPathLink();
		b2wJob.clickEstimatesItemsTab();
		logCompare(true,b2wEst.openEstimateItemByItemID(sItemIDB),"Open Estimate Item");
		logCompare(sExpectedUnitCostB, b2wEst.getEstimatedUnitCostEstimated(), "Unit Cost Estimated");
		logCompare(sExpectedTotalCostB, b2wEst.getEstimatedTotalCostEstimated(), "Verify Total Cost");
		logCompare(sExpectedUnitCostB, b2wEst.getEstimatedUnitCostCurrent(), "Unit Cost Current");
		logCompare(sExpectedTotalCostB, b2wEst.getEstimatedTotalCostCurrent(), "Verify Current Cost");
		b2wEstItem.clickPathLink();
		b2wJob.clickEstimatesItemsTab();
		assertTrue("Open Estimate Item",b2wEst.openEstimateItemByItemID(sItemIDC));
		logCompare(true,b2wEst.clickAddCostBreakdownElement(), "Click Cost Breakdown");
		logCompare(true,b2wEstItem.setCostBreakDownID(sItemCostBreakdownIDC), "Set Cost Breakdown ID");
		logCompare(true,b2wEstItem.setCostID(sItemCostIDC), "Set Cost ID");
		logCompare(true,b2wEstItem.setDescription(sEstimateItemDescC), "Set Desc");
		logCompare(true,b2wEstItem.setEstimatedQuantity(sEstimateItemQTYC), "Set Est QTY");
		logCompare(true,b2wEstItem.setEstimateUnitOfMeasure(sUnitOfMeasureC), "Set UM");
		logCompare(true,b2wEstItem.setLaborUnitCost(this.sUnitCostLaborC),"Set Labor Unit");
		logCompare(true,b2wEstItem.setEquipmentOwnedUnitCost(this.sUnitCostEquipmentOwnedC),"Equipment Owned");
		logCompare(true,b2wEstItem.setEquipmentRentedUnitCost(this.sUnitCostEquipmentRentedC),"Set Equipment Rent Unit");
		logCompare(true,b2wEstItem.setSubcontractedUnitCost(this.sUnitCostSubcontractedC),"Set Subcontracted Unit");
		logCompare(true,b2wEstItem.setTruckingUnitCost(this.sUnitCostTruckingC),"Set Trucking Unit Cost");
		logCompare(true,b2wEstItem.setMiscUnitCost(this.sUnitCostMiscC),"Set Misc Unit Item");
		logCompare(true, b2wEstItem.saveEstimateItemCostBreakdown(), "save item");
		logCompare(sExpectedUnitCostC, b2wEstItem.getEstimatedItemUnitCostBreakdownUnitCost(), "Verify Estimate Unit Cost after updates");
		logCompare(sExpectedTotalCostC, b2wEstItem.getEstimatedItemTotalCostBreakdownUnitCost(), "Verify Total Cost");
		b2wEstItem.clickPathLink();
		b2wJob.clickEstimatesItemsTab();
		assertTrue("Open Estimate Item",b2wEst.openEstimateItemByItemID(sItemIDC));
		logCompare(sEstimatedUnitCostC, b2wEst.getEstimatedUnitCostEstimated(), "Unit Cost Estimated");
		logCompare(sEstimatedTotalCostC, b2wEst.getEstimatedTotalCostEstimated(), "Verify Total Cost");
		logCompare(sEstimatedUnitCurrentCostC, b2wEst.getEstimatedUnitCostCurrent(), "Unit Cost Current");
		logCompare(sEstimatedTotalCurrentCostC, b2wEst.getEstimatedTotalCostCurrent(), "Verify Current Cost");
		b2wNav.openJobs();
		b2wCommon.openJob(sJobs);
		b2wJob.clickEstimatesItemsTab();
		logCompare(true,b2wEst.openEstimateItemByItemID(sItemIDC),"Open Estimate Item");
		logCompare(true,b2wEst.deleteEstimatedByCostBreakdownID(sItemCostBreakdownIDC), "Delete Item Cost Breakdown");
		TaskUtils.sleep(1000);
		logCompare(false,b2wEst.editEstimatedByCostBreakdownID(sItemCostBreakdownIDC), "Should be Deleted");
		// open a job
		// 
		
	}

}
