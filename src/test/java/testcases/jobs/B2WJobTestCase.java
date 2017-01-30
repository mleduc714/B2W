package testcases.jobs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.jobs.B2WAddToJobs;
import tasks.jobs.B2WCreateJobProductionAccountTasks;
import tasks.jobs.B2WCreateJobSiteTasks;
import tasks.jobs.B2WCreateJobTasks;
import tasks.jobs.B2WJobsTasks;
import tasks.jobs.B2WJobsTasks.JOBSDIALOG;
import tasks.resources.B2WMaterialsTasks;
import tasks.resources.B2WOrganizationTasks;
import tasks.util.TaskUtils;

public class B2WJobTestCase extends B2WTestCase {

	private B2WNavigationTasks b2wNav = new B2WNavigationTasks();

	B2WJobsTasks jobsTasks = new B2WJobsTasks();
	B2WCreateJobTasks b2wCreate = new B2WCreateJobTasks();
	B2WCreateJobSiteTasks b2wJobSite = new B2WCreateJobSiteTasks();
	B2WAddToJobs addToJobs = new B2WAddToJobs(JOBSDIALOG.ADDMATERIALS);
	B2WAddToJobs addToVendors = new B2WAddToJobs(JOBSDIALOG.ADDVENDORS);
	B2WCreateJobProductionAccountTasks jobProd = new B2WCreateJobProductionAccountTasks();
	B2WOrganizationTasks b2wOrg = new B2WOrganizationTasks();
	B2WMaterialsTasks b2wMaterial = new B2WMaterialsTasks();
	LinkedList<String> jobNumber = new LinkedList<String>();
	LinkedList<String> materialID = new LinkedList<String>();
	LinkedList<String> vendorID = new LinkedList<String>();
	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
	Calendar cal = Calendar.getInstance();

	String sJobNumberA, sJobTitleA, sJobBusinssUnitA, sJobStatusA, sJobNumberB, sJobTitleB, sJobBusinssUnitB,
			sJobStatusB, sJobNumberC, sJobTitleC, sJobBusinssUnitC, sJobStatusC, sJobNumberD, sJobTitleD,
			sJobBusinssUnitD, sJobStatusD, sJobNumberE, sJobTitleE, sJobBusinssUnitE, sJobStatusE, sJobProjectNameA,
			sJobToExploreID, sJobToExploreSite;

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();

		cal.add(Calendar.DAY_OF_YEAR, 120);
		sJobNumberA = getProperty("sJobNumberA");
		sJobTitleA = getProperty("sJobTitleA");
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
	}

	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		super.testMain();
		//getAllJobsByNumber();
		b2wNav.openJobs();
		jobsTasks.enterTextAndClickSearch(sJobToExploreID);
		jobsTasks.getJobsByJobNumber();
		jobsTasks.clickClearSearchButton();
		jobsTasks.clickSortByLetterM();
		getAllJobsByNumber();

	}

	public void createJob() {
		jobsTasks.clickCreateNewJob();
		// a.Populate the General Information
		logCompare(true, b2wCreate.setJobNumber(sJobNumberA), "Add Job Number");
		logCompare(true, b2wCreate.setJobTitle(sJobTitleA), "Set Job Title");
		b2wCreate.selectProjectManagerFromDD();
		logCompare(true, b2wCreate.setJobProjectName(sJobProjectNameA), "Set Project Name");
		logCompare(true, b2wCreate.setJobProjectStatusFromDD(sJobStatusA), "Set Project Status from Dropdowm");
		b2wCreate.setJobProjectCustomerFromDD();
		b2wCreate.selectJobDefaultLaborRateClassFromDD();
		b2wCreate.setJobEquipmentRateClassFromDD();
		jobsTasks.clickBottomSaveButton();
	}

	public void createJobSite() {
		jobsTasks.clickAddJobSiteButton();
		String jobDescription = "This is a new Job Site #" + jobsTasks.randomNumberGenerator();
		logCompare(true, b2wJobSite.setJobSiteDescription(jobDescription), "Set Job Site Description");
		logCompare(true, b2wJobSite.setJobSiteStartDate(format.format(cal.getTime())), "Set Job Site Start Date");
		logCompare(true, b2wJobSite.setJobSiteDurationType("No End Date"), "Set Job Site Duration Type");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayMonday(true), "Set Job Site Non Working Day Monday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayTuesday(true), "Set Job Site Non Working Day Tuesday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayWednesday(true), "Set Job Site Non Working Day Wednesday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayThursday(true), "Set Job Site Non Working Day Thursday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDayFriday(true), "Set Job Site Non Working Day Friday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDaySaturday(true), "Set Job Site Non Working Day Saturday");
		logCompare(true, b2wJobSite.setJobSiteNonWorkingDaySunday(false), "Set Job Site Non Working Day Sunday");
		logCompare(true, b2wJobSite.setShowOnJobBoard(true), "Set Show on Board");
		logCompare(true, b2wJobSite.setJobSiteAddress("99 Bow Street"), "Set Job Site Address");
		logCompare(true, b2wJobSite.setJobSiteCity("Portsmouth"), "Set Job Site City");
		logCompare(true, b2wJobSite.setJobSiteState("New Hampshire"), "Set Job Site State");
		logCompare(true, b2wJobSite.setJobSiteZip("03801"), "Set Job Site Zip");
		logCompare(true, b2wJobSite.setJobCountry("USA"), "Set Job Country");
		jobsTasks.clickBottomSaveButton();
	}

	public void addMaterials() {
		String s = this.getRandomItem(materialID);
		jobsTasks.clickMaterialsTab();
		jobsTasks.clickAddMaterialsButton();
		logCompare(true, addToJobs.setSearchText(s), "Set Search Text");
		addToJobs.clickSearchButton();
		addToJobs.setIDText(s);
		addToJobs.clickSelectButton();
		addToJobs.clickAddButton();
	}

	public void addVendor() {
		String s = this.getRandomItem(vendorID);
		jobsTasks.clickSubsVendorsTab();
		jobsTasks.clickAddVendors();
		logCompare(true, addToJobs.setSearchText(s), "Set Search Text");
		addToVendors.clickSearchButton();
		addToVendors.setIDText(s);
		addToVendors.clickSelectButton();
		addToVendors.clickAddButton();

	}

	public void addJobProductionAccount() {
		jobsTasks.clickTrackingAccountsTab();
		jobsTasks.clickAddNewJobProductionAccount();
		logCompare(true, jobProd.setJobProductionAccountTrackingIDText(jobsTasks.randomNumberGenerator()),
				"Set Job Production Account Tracking ID Text");
		logCompare(true,
				jobProd.setJobProductionAccountDescriptionText(
						"This is a new job production account. " + jobsTasks.randomNumberGenerator()),
				"Set Job Production Account Description Text");
		logCompare(true, jobProd.selectJobProductionAccountIDFromDD("1000 - Asphalt"),
				"Select Job Production Account ID from Dropdown");
		jobProd.setJobProductionAccountComplete(true);
		jobsTasks.clickBottomSaveButton();
	}

	public ArrayList<String> getAllJobsByTitle() {
		ArrayList<String> al = new ArrayList<String>();
		int iPages = jobsTasks.getTotalPages();
		for (int i = 1; iPages >= i; i++) {
			jobsTasks.clickPage(i);
			TaskUtils.sleep(1000);
			al.addAll(jobsTasks.getJobsByJobTitle());
		}
		Collections.sort(al);
		return al;
	}

	public void getAllJobsByNumber() {
		b2wNav.openJobs();
		int iPages = jobsTasks.getTotalPages();
		for (int i = 1; iPages >= i; i++) {
			jobsTasks.clickPage(i);
			TaskUtils.sleep(1000);
			jobNumber.addAll(jobsTasks.getJobsByJobNumber());
		}
	}

	public void getAllVendors() {
		b2wNav.openOrganizations();
		int iPages = jobsTasks.getTotalPages();
		for (int i = 1; iPages >= i; i++) {
			jobsTasks.clickPage(i);
			TaskUtils.sleep(1000);
			vendorID.addAll(b2wOrg.getAllVendorsByID());
		}

	}

	public void getAllMaterialsByID() {
		assertTrue("Open Materials", b2wNav.openMaterials());
		int iPages = jobsTasks.getTotalPages();
		for (int i = 1; iPages >= i; i++) {
			jobsTasks.clickPage(i);
			TaskUtils.sleep(1000);
			materialID.addAll(b2wMaterial.getMaterialsByID());
		}

	}

	public String getRandomItem(LinkedList<String> ll) {
		int iRandom = getRandomNumber(ll.size() - 1);
		String s = ll.get(iRandom);
		ll.remove(iRandom);
		return s;
	}

	public static int getRandomNumber(int iRange) {

		Random rand = new Random();

		int randnumber = rand.nextInt(iRange);

		return randnumber;
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "mleduc";
	}

	@Override
	public String getDataPath() {
		// TODO Auto-generated method stub
		return "data/jobs";
	}

	@Override
	public boolean isSupported() {
		// TODO Auto-generated method stub
		return true;
	}

}
