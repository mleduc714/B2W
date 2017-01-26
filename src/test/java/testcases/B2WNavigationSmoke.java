package testcases;

import java.util.ArrayList;

import com.b2w.test.B2WTestCase;

import tasks.B2WHomeTasks;
import tasks.B2WNavigationTasks;
import tasks.B2WSetupTasks;
import tasks.util.TaskUtils;

public class B2WNavigationSmoke extends B2WTestCase {

	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WHomeTasks b2wHome = new B2WHomeTasks();
	B2WSetupTasks b2wSetup = new B2WSetupTasks();
	
	
	ArrayList<String> expected = new ArrayList<String>();
	ArrayList<String> resource = new ArrayList<String>();
	ArrayList<String> setup = new ArrayList<String>();
	
	String sHome,sJobs,sSchedule,sTrack,sMaintain,sResources,sSetup,sReports,sHelp;
	String 	sResourceA,sResourceB,sResourceC,sResourceD,sResourceE,sResourceF,sResourceG,sResourceH,
	sResourceI,sResourceJ,sResourceK, sResourceL,sResourceM,sResourceN, sResourceO,sResourceP;
	String 	sSetupA,sSetupB,sSetupC,sSetupD,sSetupE,sSetupF,sSetupG,sSetupH,
	sSetupI,sSetupJ;
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		sHome = getProperty("sHome");
		sJobs = getProperty("sJobs");
		sSchedule = getProperty("sSchedule");
		sTrack = getProperty("sTrack");
		sMaintain = getProperty("sMaintain");
		sResources = getProperty("sResources");
		sSetup = getProperty("sSetup");
		sReports = getProperty("sReports");
		sHelp = getProperty("sHelp");
		sResourceA = getProperty("sResourceA");
		sResourceB = getProperty("sResourceB");
		sResourceC = getProperty("sResourceC");
		sResourceD = getProperty("sResourceD");
		sResourceE = getProperty("sResourceE");
		sResourceF = getProperty("sResourceF");
		sResourceG = getProperty("sResourceG");
		sResourceH = getProperty("sResourceH");
		sResourceI = getProperty("sResourceI");
		sResourceJ = getProperty("sResourceJ");
		sResourceK = getProperty("sResourceK");
		sResourceL = getProperty("sResourceL");
		sResourceM = getProperty("sResourceM");
		sResourceN = getProperty("sResourceN");
		sResourceO = getProperty("sResourceO");
		sResourceP = getProperty("sResourceP");
		
		sSetupA = getProperty("sSetupA");
		sSetupB = getProperty("sSetupB");
		sSetupC = getProperty("sSetupC");
		sSetupD = getProperty("sSetupD");
		sSetupE = getProperty("sSetupE");
		sSetupF = getProperty("sSetupF");
		sSetupG = getProperty("sSetupG");
		sSetupH = getProperty("sSetupH");
		sSetupI = getProperty("sSetupI");
		sSetupJ = getProperty("sSetupJ");

		expected.add(sHome);
		expected.add(sJobs);
		expected.add(sSchedule);
		expected.add(sTrack);
		expected.add(sMaintain);
		resource.add(sResourceA);
		resource.add(sResourceB);
		resource.add(sResourceC);
		resource.add(sResourceD);
		resource.add(sResourceE);
		resource.add(sResourceF);
		resource.add(sResourceG);
		resource.add(sResourceH);
		resource.add(sResourceI);
		resource.add(sResourceJ);
		resource.add(sResourceK);
		resource.add(sResourceL);
		resource.add(sResourceM);
		resource.add(sResourceN);
		resource.add(sResourceO);
		resource.add(sResourceP);
		
		setup.add(sSetupA);
		setup.add(sSetupB);
		setup.add(sSetupC);
		setup.add(sSetupD);
		setup.add(sSetupE);
		setup.add(sSetupF);
		setup.add(sSetupG);
		setup.add(sSetupH);
		setup.add(sSetupI);
		setup.add(sSetupJ);
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
		return "data/navigation";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		for (int i = 0; i < expected.size(); i++){
			logCompare(b2wNav.getNavigatonPanelItems().get(i),expected.get(i), "Items Match");
		}
		logCompare(true,b2wNav.clickHome(),"Go Home");
		if (!b2wNav.isMarketingAreaOpen()){
			b2wNav.clickChevron();
		}
		logCompare(true,b2wNav.openJobs(), "Open Jobs");
		logCompare(true,b2wNav.openSchedule(), "Open Schedule");
		logCompare(true,b2wNav.openTrack(), "Open Track");
		logCompare(true,b2wNav.openMaintain(), "Open Maintain");
		
		logCompare(sResources,b2wNav.getResourceTitle(), "Resources");
		logCompare(sReports,b2wNav.getReportsTitle(), "Reports");
		logCompare(sSetup,b2wNav.getSetupTitle(), "Setup");
		logCompare(sHelp,b2wNav.getHelpTitle(), "Help");
		ArrayList<String> actualResources = b2wNav.getResourceItems();
		for (int i = 0; i < resource.size(); i++){
			logCompare(resource.get(i),actualResources.get(i),  "Resource Items Match");
		}
		ArrayList<String> actualSetup = b2wNav.getSetupItems();
		for (int i = 0; i < setup.size(); i++){
			logCompare(setup.get(i),actualSetup.get(i),  "Setup Items Match");
		}
		
		logCompare(true,b2wNav.openReports(), "Open Reports");
		
		logCompare(true,b2wNav.clickHome(), "Go Home");
		logCompare(true,b2wNav.isBadgeEstimateVisible(), "Estimate Visible");
		logCompare(true,b2wNav.isBadgeScheduleVisible(), "Schedule Visible");
		logCompare(true,b2wNav.isBadgeTrackVisible(), "Track Visible");
		logCompare(true,b2wNav.isBadgeMaintainVisible(), "Maintain Visible");
		logCompare(true,b2wNav.isBadgeInformVisible(), "Inform Visible");
		logCompare(true,b2wNav.clickChevron(), "click chevron");
		logCompare(false,b2wNav.isBadgeEstimateVisible(), "Estimate Visible");
		logCompare(false,b2wNav.isBadgeScheduleVisible(), "Schedule Visible");
		logCompare(false,b2wNav.isBadgeTrackVisible(), "Track Visible");
		logCompare(false,b2wNav.isBadgeMaintainVisible(), "Maintain Visible");
		logCompare(false,b2wNav.isBadgeInformVisible(), "Inform Visible");
		logCompare(true,b2wNav.clickChevron(), "click chevron");

		assertTrue("Open Track Link", b2wNav.openTrack());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open create field log", b2wHome.openTrackCreateFieldLog());
		assertTrue("Click Cancel to get out", b2wSetup.clickCancelButton());
		assertTrue("Dismiss Alert", TaskUtils.dismissAlert());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Track View Field Log",b2wHome.openTrackViewFieldLogs());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Track View Jobs", b2wHome.openTrackViewJobs());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Reports Link", b2wHome.openAdminReports());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Manage Business Units", b2wHome.openAdminManageBusinessUnits());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open link to add a user", b2wHome.openAdminAddAUser());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open View Employees", b2wHome.openAdminViewEmployees());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Manage Equipment", b2wHome.openAdminManageEquipment());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Schedule from Navigation", b2wNav.openSchedule());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Schedule Crews", b2wHome.openSetupCrewTemplates());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Schedule Setup", b2wHome.openSetupSchedules());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Schedule View", b2wHome.openViewSchedules());
		assertTrue("Go back to home screen", b2wNav.clickHome());
		assertTrue("Open Maintenance requests",b2wHome.openMaintainMaintenanceRequests());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open Maintain work orders",b2wHome.openMaintainViewWorkOrders());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open maintain view schedule work orders",b2wHome.openMaintainViewScheduleWorkOrders());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open Maintain View Equipment",b2wHome.openMaintainViewEquipment());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		assertTrue("Open MainTain From Navigation", b2wNav.openMaintain());
		assertTrue("Go back to home screen", b2wNav.clickHome());	
		logCompare(true,b2wHome.addDashboardManagerHomePageCost(), "Manager Home Page Cost");
		logCompare(true,b2wHome.addDashboardManagerHomePageProduction(), "Manager Production");
		logCompare(true,b2wHome.removeDashboard(), "Remove Dashboard");
		
	}
}
