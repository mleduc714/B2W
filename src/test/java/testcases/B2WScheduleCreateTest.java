package testcases;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.scheduler.B2WScheduleView;
import tasks.setup.B2WSchedulesTasks;
import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;

public class B2WScheduleCreateTest extends B2WTestCase{
	
	private static LinkedHashMap<String,Long> linkTable = new LinkedHashMap<String,Long>();
	private final B2WSchedulesTasks b2wSchedulesTasks = new B2WSchedulesTasks();
	private final B2WNavigationTasks b2wNav = new B2WNavigationTasks();

	B2WScheduleView employeeScheduleView;
	B2WScheduleView equipmentScheduleView;
	B2WScheduleView crewsScheduleView;
	B2WScheduleView locationScheduleView;

	@Override
	public void testSetUp() throws Throwable {
		super.testSetUp();

		// === Setup Schedules View
		int  n = getRandomNumber();
		String sScheduleName = getProperty("sGeneralScheduleName");
		String sEmployeeScheduleViewName = sScheduleName + " - Employees - " + n;
		String sEquipmentScheduleViewName = sScheduleName + " - Equipment - " + n;
		String sCrewScheduleViewName = sScheduleName + " - Crews - " + n;
		String sLocationScheduleViewName = sScheduleName + " - Location - " + n;

		employeeScheduleView = setupEmployeeScheduleView(sEmployeeScheduleViewName);
		equipmentScheduleView = setupEquipmentScheduleView(sEquipmentScheduleViewName);
		crewsScheduleView = setupCrewsScheduleView(sCrewScheduleViewName);
		locationScheduleView = setupLocationScheduleView(sLocationScheduleViewName);
	}

	@Override
	public void testMain() throws Throwable {
		super.testMain();
		//createScheduleOld();
		createScheduleNew();
	}

	@Override
	public void testTearDown() throws Throwable {
		super.testTearDown();
	}

	@Override
	public String getAuthor() {
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

	public static void createScheduleOld() throws Exception {
		/*
		Timer timer = new Timer();
		
		B2WSchedulesTasks schedulesTasks = new B2WSchedulesTasks();
		
		B2WNavigationTasks navigationTasks = new B2WNavigationTasks();
		
		navigationTasks.openSchedules();
		
		schedulesTasks.clickCreateScheduleViewDialog();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Create Schedule", timer.getTotalTime());
		
		schedulesTasks.setName("New Schedule Task");
		
		schedulesTasks.setBU("Organization");
		
		schedulesTasks.setNotes("This is a new test Schedule View.");
		
		schedulesTasks.setScheduleFormat("Resource Listing");
		
		B2WScheduleItem schedItem = new B2WScheduleItem();
		 
		schedulesTasks.setGrouping("group items by", "Job");
		
		schedulesTasks.setGrouping("secondary grouping", "Location");
		
		schedulesTasks.setSecurityRole("Foreman");
		
		schedulesTasks.setFilter("Business Unit", "Northern Division");
		
		schedulesTasks.setUser("Deborah Dean");
		schedulesTasks.setUser("Darrin Bailey");
		schedulesTasks.setUser("Jody Thornton");
		schedulesTasks.setUser("Build Service");
		
		schedulesTasks.saveSchedule();
		
		schedulesTasks.clickUpdateScheduleViewDialog();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Open Schedule to Edit", timer.getTotalTime());
		
		schedulesTasks.setFilter("Place Category", "Office");
		
		schedulesTasks.setNotes("These are new, edited notes. 12345678910");
		
		schedulesTasks.setBU("Northern Division\\Paving");
		
		schedulesTasks.saveSchedule();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Save Schedule", timer.getTotalTime());
        
		schedulesTasks.deleteSchedule();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Delete Schedule", timer.getTotalTime());
        
        Set<String> keys = linkTable.keySet();
        for (String key: keys){
               System.out.println(key + " " + linkTable.get(key));
        }
        */
	}

	public void createScheduleNew() throws Exception {
		linkTable.put("Create Schedule", b2wSchedulesTasks.createScheduleView_Performance(employeeScheduleView));
		linkTable.put("Create Schedule", b2wSchedulesTasks.createScheduleView_Performance(equipmentScheduleView));
		linkTable.put("Create Schedule", b2wSchedulesTasks.createScheduleView_Performance(crewsScheduleView));
		linkTable.put("Create Schedule", b2wSchedulesTasks.createScheduleView_Performance(locationScheduleView));
		Set<String> keys = linkTable.keySet();
		for (String key: keys){
			System.out.println(key + " " + linkTable.get(key));
		}
	}

	private B2WScheduleView setupEmployeeScheduleView(String sScheduleName) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sEmployeeScheduleView_BU");
		String sSchedulesNotes = getProperty("sEmployeeScheduleView_Notes");
		String sGroupingLevel1 = getProperty("sEmployeeScheduleView_GroupingLevel1");
		String sGroupingLevel2 = getProperty("sEmployeeScheduleView_GroupingLevel2");
		String sFilterType = getProperty("sEmployeeScheduleView_FilterType");
		String sFilterValue = getProperty("sEmployeeScheduleView_FilterValue");
		String sSecurityRole = getProperty("sEmployeeScheduleView_SecurityRole");
		String sUser = getProperty("sEmployeeScheduleView_User");
		String sCalendarStartDate = getProperty("sEmployeeScheduleView_CalendarStartDate");
		String sCalendarDateRange = getProperty("sEmployeeScheduleView_CalendarDateRange");
		// === Complete reading properties

		// === Prepare Schedule Items based on Schedule Format
		ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
		B2WScheduleItem item = new B2WScheduleItem();
		item.setScheduleFormat("Resource Listing");
		item.setResourceName("Employees");
		itemList.add(item);

		// === Prepare Filters List
		ArrayList<String[]> filters = new ArrayList<String[]>();
		String[] filterItem = new String[2];
		if (!sFilterType.equals("")) {
			filterItem[0] = sFilterType;
			filterItem[1] = sFilterValue;
			filters.add(filterItem);
		}

		// === Prepare Roles list
		ArrayList<String> roles = new ArrayList<String>();
		if (!sSecurityRole.equals("")){
			roles.add(sSecurityRole);
		}

		// === Prepare Users list
		ArrayList<String> users = new ArrayList<String>();
		if (!sUser.equals("")) {
			users.add(sUser);
		}

		oReturn = new B2WScheduleView(sScheduleName, sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);

		oReturn.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
		oReturn.setDuration(sCalendarDateRange);

		return oReturn;
	}
	private B2WScheduleView setupEquipmentScheduleView(String sScheduleName) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sEquipmentScheduleView_BU");
		String sSchedulesNotes = getProperty("sEquipmentScheduleView_Notes");
		String sGroupingLevel1 = getProperty("sEquipmentScheduleView_GroupingLevel1");
		String sGroupingLevel2 = getProperty("sEquipmentScheduleView_GroupingLevel2");
		String sFilterType = getProperty("sEquipmentScheduleView_FilterType");
		String sFilterValue = getProperty("sEquipmentScheduleView_FilterValue");
		String sSecurityRole = getProperty("sEquipmentScheduleView_SecurityRole");
		String sUser = getProperty("sEquipmentScheduleView_User");
		String sCalendarStartDate = getProperty("sEquipmentScheduleView_CalendarStartDate");
		String sCalendarDateRange = getProperty("sEquipmentScheduleView_CalendarDateRange");
		// === Complete reading properties

		// Prepare Schedule Items based on Schedule Format
		ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
		B2WScheduleItem item = new B2WScheduleItem();
		item.setScheduleFormat("Resource Listing");
		item.setResourceName("Equipment");
		itemList.add(item);

		// Prepare Filters List
		ArrayList<String[]> filters = new ArrayList<String[]>();
		String[] filterItem = new String[2];
		if (!sFilterType.equals("")) {
			filterItem[0] = sFilterType;
			filterItem[1] = sFilterValue;
			filters.add(filterItem);
		}

		// === Prepare Roles list
		ArrayList<String> roles = new ArrayList<String>();
		if (!sSecurityRole.equals("")){
			roles.add(sSecurityRole);
		}

		// === Prepare Users list
		ArrayList<String> users = new ArrayList<String>();
		if (!sUser.equals("")) {
			users.add(sUser);
		}

		oReturn = new B2WScheduleView(sScheduleName, sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);
		oReturn.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
		oReturn.setDuration(sCalendarDateRange);

		return oReturn;
	}
	private B2WScheduleView setupCrewsScheduleView(String sScheduleName) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sCrewsScheduleView_BU");
		String sSchedulesNotes = getProperty("sCrewsScheduleView_Notes");
		String sGroupingLevel1 = getProperty("sCrewsScheduleView_GroupingLevel1");
		String sGroupingLevel2 = getProperty("sCrewsScheduleView_GroupingLevel2");
		String sFilterType = getProperty("sCrewsScheduleView_FilterType");
		String sFilterValue = getProperty("sCrewsScheduleView_FilterValue");
		String sSecurityRole = getProperty("sCrewsScheduleView_SecurityRole");
		String sUser = getProperty("sCrewsScheduleView_User");
		String sCalendarStartDate = getProperty("sCrewsScheduleView_CalendarStartDate");
		String sCalendarDateRange = getProperty("sCrewsScheduleView_CalendarDateRange");
		// === Complete reading properties

		// Prepare Schedule Items based on Schedule Format
		ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
		B2WScheduleItem item = new B2WScheduleItem();
		item.setScheduleFormat("Crew View");
		item.setResourceName("Production Crews");
		itemList.add(item);
		B2WScheduleItem item1 = new B2WScheduleItem();
		item1.setScheduleFormat("Crew View");
		item1.setResourceName("Transport Crews");
		itemList.add(item1);

		// Prepare Filters List
		ArrayList<String[]> filters = new ArrayList<String[]>();
		String[] filterItem = new String[2];
		if (!sFilterType.equals("")) {
			filterItem[0] = sFilterType;
			filterItem[1] = sFilterValue;
			filters.add(filterItem);
		}

		// === Prepare Roles list
		ArrayList<String> roles = new ArrayList<String>();
		if (!sSecurityRole.equals("")){
			roles.add(sSecurityRole);
		}

		// === Prepare Users list
		ArrayList<String> users = new ArrayList<String>();
		if (!sUser.equals("")) {
			users.add(sUser);
		}

		oReturn = new B2WScheduleView(sScheduleName, sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);
		oReturn.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
		oReturn.setDuration(sCalendarDateRange);

		return oReturn;
	}
	private B2WScheduleView setupLocationScheduleView(String sScheduleName) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sLocationScheduleView_BU");
		String sSchedulesNotes = getProperty("sLocationScheduleView_Notes");
		String sGroupingLevel1 = getProperty("sLocationScheduleView_GroupingLevel1");
		String sGroupingLevel2 = getProperty("sLocationScheduleView_GroupingLevel2");
		String sFilterType = getProperty("sLocationScheduleView_FilterType");
		String sFilterValue = getProperty("sLocationScheduleView_FilterValue");
		String sSecurityRole = getProperty("sLocationScheduleView_SecurityRole");
		String sUser = getProperty("sLocationScheduleView_User");
		String sCalendarStartDate = getProperty("sLocationScheduleView_CalendarStartDate");
		String sCalendarDateRange = getProperty("sLocationScheduleView_CalendarDateRange");
		// === Complete reading properties

		// Prepare Schedule Items based on Schedule Format
		ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
		B2WScheduleItem item = new B2WScheduleItem();
		item.setScheduleFormat("Location View");
		item.setResourceName("Job Sites");
		itemList.add(item);

		B2WScheduleItem item1 = new B2WScheduleItem();
		item1.setScheduleFormat("Location View");
		item1.setResourceName("Places");
		itemList.add(item1);

		// Prepare Filters List
		ArrayList<String[]> filters = new ArrayList<String[]>();
		String[] filterItem = new String[2];
		if (!sFilterType.equals("")) {
			filterItem[0] = sFilterType;
			filterItem[1] = sFilterValue;
			filters.add(filterItem);
		}

		// === Prepare Roles list
		ArrayList<String> roles = new ArrayList<String>();
		if (!sSecurityRole.equals("")){
			roles.add(sSecurityRole);
		}

		// === Prepare Users list
		ArrayList<String> users = new ArrayList<String>();
		if (!sUser.equals("")) {
			users.add(sUser);
		}

		oReturn = new B2WScheduleView(sScheduleName, sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);
		oReturn.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
		oReturn.setDuration(sCalendarDateRange);

		return oReturn;
	}
}