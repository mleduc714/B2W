package testcases.jobs;

import java.util.ArrayList;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddLaborRateClass;
import tasks.jobs.B2WAddToJobs;
import tasks.jobs.B2WEstimateItemTasks;
import tasks.jobs.B2WCreateJobProductionAccountTasks;
import tasks.jobs.B2WCreateJobSiteTasks;
import tasks.jobs.B2WCreateJobTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WJobsTasks.JOBSDIALOG;
import tasks.resources.B2WMaterialsTasks;
import tasks.resources.B2WOrganizationTasks;
import tasks.util.TaskUtils;

public class B2WJobsTestPart2 extends B2WTestCase {
	

	
	private B2WNavigationTasks b2wNav = new B2WNavigationTasks();

	B2WJobsTasks jobsTasks = new B2WJobsTasks();
	B2WCreateJobTasks b2wCreate = new B2WCreateJobTasks();
	B2WCreateJobSiteTasks b2wJobSite = new B2WCreateJobSiteTasks();
	B2WAddToJobs addToJobs = new B2WAddToJobs(JOBSDIALOG.ADDMATERIALS);
	B2WAddToJobs addToVendors = new B2WAddToJobs(JOBSDIALOG.ADDVENDORS);
	B2WCreateJobProductionAccountTasks jobProd = new B2WCreateJobProductionAccountTasks();
	B2WEstimateItemTasks estimate = new B2WEstimateItemTasks();
	B2WOrganizationTasks b2wOrg = new B2WOrganizationTasks();
	B2WMaterialsTasks b2wMaterial = new B2WMaterialsTasks();
	B2WAddLaborRateClass laborRate = new B2WAddLaborRateClass();
	Calendar cal = Calendar.getInstance();
	
	String sJobNumberA, sJobTitleA, sJobBusinssUnitA, sJobStatusA, sJobNumberB, sJobTitleB, sJobBusinssUnitB,
	sJobStatusB, sJobNumberC, sJobTitleC, sJobBusinssUnitC, sJobStatusC, sJobNumberD, sJobTitleD,
	sJobBusinssUnitD, sJobStatusD, sJobNumberE, sJobTitleE, sJobBusinssUnitE, sJobStatusE, sJobProjectNameA,
	sJobToExploreID, sJobToExploreSite, sJobSiteA, sJobSiteB, sJobSiteC, sJobSiteASupervisor,
	sJobToExploreIDA, sJobToExploreSiteA, sJobEstimateItemA, sJobEstimateItemB,
	sJobEstimateItemNumber,sJobEstimateQuantity,sJobEstimateItemID,sJobEstimateChangeOrderQuantity,sJobEstimateDescription,
	sJobEstimateUniOfM,sJobEstimateUnitBidPrice, sAutomationRates,sJobSiteEditA,
			sJobA, sJobB, sJobC, sJobD, sJobE, sJobF, sJobG, sJobH, sJobI;
	String[] sJobs;
	int iRandom;
	
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		super.testSetUp();
		iRandom = getRandomNumber();
		cal.add(Calendar.DAY_OF_YEAR, 120);
		sJobNumberA = getProperty("sJobNumberA")+iRandom;
		sJobTitleA = getProperty("sJobTitleA")+iRandom;
		sJobBusinssUnitA = getProperty("sJobBusinssUnitA");
		sJobStatusA = getProperty("sJobStatusA");
		sJobProjectNameA = getProperty("sJobProjectNameA");
		sJobNumberB = getProperty("sJobNumberB");
		sJobTitleB = getProperty("sJobTitleB");
		sJobBusinssUnitB = getProperty("sJobBusinssUnitB");
		sJobStatusB = getProperty("sJobStatusB");
		sJobNumberC = getProperty("sJobNumberC");
		sJobTitleC = getProperty("sJobTitleC");
		sJobBusinssUnitC = getProperty("sJobBusinssUnitC");
		sJobStatusC = getProperty("sJobStatusC");
		sJobNumberD = getProperty("sJobNumberD");
		sJobTitleD = getProperty("sJobTitleD");
		sJobBusinssUnitD = getProperty("sJobBusinssUnitD");
		sJobStatusD = getProperty("sJobStatusD");
		sJobNumberE = getProperty("sJobNumberE");
		sJobTitleE = getProperty("sJobTitleE");
		sJobBusinssUnitE = getProperty("sJobBusinssUnitE");
		sJobStatusE = getProperty("sJobStatusE");
		sJobToExploreID = getProperty("sJobToExploreID");
		sJobToExploreSite = getProperty("sJobToExploreSite");
		sJobSiteA = getProperty("sJobSiteA");
		sJobSiteB = getProperty("sJobSiteB");
		sJobSiteC = getProperty("sJobSiteC");
		sJobSiteASupervisor = getProperty("sJobSiteASupervisor");
		sJobToExploreIDA = getProperty("sJobToExploreIDA");
		sJobToExploreSiteA = getProperty("sJobToExploreSiteA");
		sJobEstimateItemA = getProperty("sJobEstimateItemA");
		sJobEstimateItemB = getProperty("sJobEstimateItemB");
		sJobSiteEditA = getProperty("sJobSiteEditA")+iRandom;
		
		sJobEstimateItemNumber = getProperty("sJobEstimateItemNumber")+iRandom;
		sJobEstimateQuantity = getProperty("sJobEstimateQuantity");
		sJobEstimateItemID = getProperty("sJobEstimateItemID")+iRandom;
		sJobEstimateChangeOrderQuantity = getProperty("sJobEstimateChangeOrderQuantity");
		sJobEstimateDescription = getProperty("sJobEstimateDescription")+iRandom;
		sJobEstimateUniOfM = getProperty("sJobEstimateUniOfM");
		sJobEstimateUnitBidPrice = getProperty("sJobEstimateUnitBidPrice");
		sAutomationRates = "Automation Rates";
		sJobA= getProperty("sJobA");
		sJobB= getProperty("sJobB");
		sJobC= getProperty("sJobC");
		sJobD= getProperty("sJobD");
		sJobE= getProperty("sJobE");
		sJobF= getProperty("sJobF");
		sJobG= getProperty("sJobG");
		sJobH= getProperty("sJobH");
		sJobI= getProperty("sJobI");
		
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
		return "Testcase description";
	}

	@Override
	public String getDataPath() {
		// TODO Auto-generated method stub
		return "data/jobs";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		
		B2WJobsTCS.getIDs("2007-0001");
		
		//editJobWithProductionAccounts();
		//logCompare(true,openJob(),"Open A existing Job");
		//this.createEstimate();
		
	}
	public boolean openJobWithProductionAccounts() {
		
		assertTrue("Open Jobs",b2wNav.openJobs());
		boolean bReturn = false;
		for (int i = 0; i < sJobs.length; i++){
			if (jobsTasks.openJobByJobNumber(sJobs[i])){
				jobsTasks.clickTrackingAccountsTab();
				if (jobsTasks.getJobProductionAccountsTrackingIDs().size() != 0){
					bReturn = true;
				}else{
					b2wNav.openJobs();
				}
			}
			if (bReturn){
				break;
			}
		}
		return bReturn;
	}
	
	
	public boolean openJob() {
		
		assertTrue("Open Jobs",b2wNav.openJobs());
		boolean bReturn = false;
		for (int i = 0; i < sJobs.length; i++){
			bReturn = jobsTasks.openJobByJobNumber(sJobs[i]);
			if (bReturn){
				break;
			}
		}
		return bReturn;
	}
	
	public void editJob() {
		
		ArrayList<String> al = jobsTasks.getJobSiteDescriptions();
		if (al.size() != 0){
			logCompare(true,jobsTasks.editJobSite(al.get(0)), "Edit Job Site");
			logCompare(true,b2wJobSite.setJobSiteSupervisor(sJobSiteASupervisor),"Change Job Supervisor");
			logCompare(true,b2wJobSite.saveJobSite(),"Save Job Site");
			logCompare(true,b2wJobSite.clickLinkToJob(), "Go Back To Job");
			logCompare(sJobSiteASupervisor, b2wJobSite.getJobSiteSupervisor(sJobSiteA), "Supervisor has changed");
			logCompare(true,jobsTasks.clickTopEditButton(), "Click Top Edit Button");
			TaskUtils.sleep(1000);
			this.b2wCreate.clickAddLaborRateButton();
			laborRate.selectItem(0);
			TaskUtils.sleep(1000);
			laborRate.clickAdd();
			TaskUtils.sleep(1000);
			jobsTasks.clickBottomSaveButton();
		}
	}
	
	public void createEstimate() {
		
		logCompare(true,jobsTasks.clickEstimatesItemsTab(), "Click Estimates Items Tab");
		ArrayList<String> al = jobsTasks.getEstimateDescriptions();
		logCompare(true,estimate.openEstimateItemByDescription(al.get(0)), "Open Estimate Item");
		logCompare(true,estimate.clickEditButton(),"Click Edit Button");
		logCompare(true,estimate.setEstimateEstimatedQuantity("5"), "Estimated Quantity");
		logCompare(true,estimate.clickBottomSaveButton(), "Save Button");
		logCompare(true,jobsTasks.clickPathLink(), "Click Link");
		logCompare(true,jobsTasks.clickCreateNewEstimateButton(),"Create new Estimate");
		logCompare(true,estimate.setEstimateItemNumber(sJobEstimateItemNumber),"Create new Estimate");
		logCompare(true,estimate.setEstimateItemID(sJobEstimateItemID),"Create new Estimate");
		logCompare(true,estimate.setEstimateEstimatedQuantity(sJobEstimateQuantity),"Create new Estimate");
		logCompare(true,estimate.setEstimateDescription(sJobEstimateDescription),"Create new Estimate");
		logCompare(true,estimate.setEstimateUnitOfMeasure(sJobEstimateUniOfM),"Create new Estimate");
		logCompare(true,estimate.setEstimateUnitBidPriceEstimated(sJobEstimateUnitBidPrice),"Create new Estimate");
		TaskUtils.sleep(1000);
		jobsTasks.clickBottomSaveButton();
		TaskUtils.sleep(1000);
		logCompare(true,jobsTasks.clickPathLink(), "Click Link");
		logCompare(true,estimate.editEstimateItemByDescription(sJobEstimateDescription), "Edit Estimate");
		this.sJobEstimateDescription = "aaChanged"+iRandom; 
		logCompare(true,estimate.setEstimateDescription(sJobEstimateDescription), "Set New Desc "+sJobEstimateDescription);
		jobsTasks.clickBottomSaveButton();
		logCompare(true,jobsTasks.clickPathLink(), "Click Link");
		logCompare(true,jobsTasks.deleteEstimateItemByDescription(sJobEstimateDescription), "Delete Estimate Item");
		TaskUtils.sleep(1000);
		logCompare(false,estimate.editEstimateItemByDescription(sJobEstimateDescription), "Edit Estimate");
		
	}

	public void jobListingPage() {
		
		assertTrue("Open Jobs",b2wNav.openJobs());
		logCompare(true,jobsTasks.enterTextAndClickSearch(sJobToExploreIDA), "Enter Text And Search");
		logCompare(sJobToExploreIDA,jobsTasks.getJobsByJobNumber().get(0), "Get Jobs");
		logCompare(true,jobsTasks.clickClearSearchButton(), "Clear Search Button");
		TaskUtils.sleep(1000);
		logCompare(true,jobsTasks.clickJobTitleHeader(), "Sort by Job Title");
		TaskUtils.sleep(1000);
		logCompare(true,jobsTasks.clickSortByLetterG(),"Click Sort By Letter G");
		if (logCompare(true, jobsTasks.getJobsByJobTitle().size() != 0, "Make sure we have some listings")){
			logCompare(this.sJobToExploreSite, jobsTasks.getJobsByJobTitle().get(0), "Job Title");
		}
		logCompare(true,jobsTasks.clickSortByAll(),"Sort By All");
		
	}
	
	public void editJobSite() {
		
		assertTrue("Open Jobs",b2wNav.openJobs());
		openJob();
		logCompare(true, jobsTasks.getJobSiteDescriptions().size() != 0, "Job Site");
		logCompare(true,jobsTasks.editJobSite(jobsTasks.getJobSiteDescriptions().get(0)), "Job Site");
		logCompare(true,b2wJobSite.setJobSiteDescription(sJobSiteEditA), "Set Job Site Desc");
		logCompare(true,b2wJobSite.saveJobSite(), "Save Job Site");
		logCompare(true,jobsTasks.clickPathLink(), "Click Path Link");
		logCompare(sJobSiteEditA, b2wJobSite.getJobSiteDescriptions().get(0), "Verify Changed");
		logCompare(true,jobsTasks.openJobSite(sJobSiteEditA), "Open Site");
		logCompare(sJobSiteEditA,b2wJobSite.getDescriptionText(), "Verify Description");
		logCompare(true,jobsTasks.clickPathLink(), "Click Path Link");
		
	}
	
	
	public void editJobWithProductionAccounts() {
		openJobWithProductionAccounts();
		
		
	}
}
