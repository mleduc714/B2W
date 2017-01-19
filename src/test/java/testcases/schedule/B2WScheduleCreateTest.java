package testcases.schedule;

import java.util.ArrayList;
import com.b2w.test.B2WTestCase;
import tasks.scheduler.B2WScheduleView;
import tasks.scheduler.B2WSchedulerTasks;
import tasks.setup.B2WSchedulesTasks;
import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;

public class B2WScheduleCreateTest extends B2WTestCase{

	private final B2WSchedulerTasks b2wScheduler = new B2WSchedulerTasks();
	private final B2WSchedulesTasks b2wSchedulesTasks = new B2WSchedulesTasks();

	// Property
	// Schedule Views
	B2WScheduleView employeeScheduleView;
	B2WScheduleView equipmentScheduleView;
	B2WScheduleView crewsScheduleView;
	B2WScheduleView locationScheduleView;

	B2WScheduleView copyEmployeeScheduleView;
	B2WScheduleView copyEquipmentScheduleView;
	B2WScheduleView copyCrewsScheduleView;
	B2WScheduleView copyLocationScheduleView;

	B2WScheduleView updateEmployeeScheduleView;
	B2WScheduleView updateEquipmentScheduleView;
	B2WScheduleView updateCrewsScheduleView;
	B2WScheduleView updateLocationScheduleView;

	@Override
	public String getAuthor() {
		return "atrostyanko";
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
		super.testSetUp();
		int  n = getRandomNumber();

		// === Setup Schedules View
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

	public void testMain() throws Throwable {
		// Schedule Tests
		createScheduleViews();
		copyScheduleViews();
		updateScheduleView();

		// Delete Schedule Views
		deleteScheduleViews();
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
	private B2WScheduleView setupUpdateEmployeeScheduleView(B2WScheduleView scheduleView) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sEmployeeScheduleView_BU_UPD");
		String sSchedulesNotes = getProperty("sEmployeeScheduleView_Notes_UPD");
		String sGroupingLevel1 = getProperty("sEmployeeScheduleView_GroupingLevel1_UPD");
		String sGroupingLevel2 = getProperty("sEmployeeScheduleView_GroupingLevel2_UPD");
		String sFilterType = getProperty("sEmployeeScheduleView_FilterType_UPD");
		String sFilterValue = getProperty("sEmployeeScheduleView_FilterValue_UPD");
		String sSecurityRole = getProperty("sEmployeeScheduleView_SecurityRole_UPD");
		String sUser = getProperty("sEmployeeScheduleView_User_UPD");
		// === Complete reading properties

		// === Prepare Schedule Items based on Schedule Format
		ArrayList<B2WScheduleItem> itemList = new ArrayList<>();
		B2WScheduleItem item = new B2WScheduleItem();
		item.setScheduleFormat("Resource Listing");
		item.setResourceName("Employees");
		item.setEvents(false);
		item.setNeeds(false);
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

		oReturn = new B2WScheduleView(scheduleView.getName() + "_UPD", sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);

		oReturn.setStartDate(scheduleView.getStartDate());
		oReturn.setDuration(scheduleView.getDuration());

		return oReturn;
	}
	private B2WScheduleView setupUpdateEquipmentScheduleView(B2WScheduleView scheduleView) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sEquipmentScheduleView_BU_UPD");
		String sSchedulesNotes = getProperty("sEquipmentScheduleView_Notes_UPD");
		String sGroupingLevel1 = getProperty("sEquipmentScheduleView_GroupingLevel1_UPD");
		String sGroupingLevel2 = getProperty("sEquipmentScheduleView_GroupingLevel2_UPD");
		String sFilterType = getProperty("sEquipmentScheduleView_FilterType_UPD");
		String sFilterValue = getProperty("sEquipmentScheduleView_FilterValue_UPD");
		String sSecurityRole = getProperty("sEquipmentScheduleView_SecurityRole_UPD");
		String sUser = getProperty("sEquipmentScheduleView_User_UPD");
		// === Complete reading properties

		// Prepare Schedule Items based on Schedule Format
		ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
		B2WScheduleItem item = new B2WScheduleItem();
		item.setScheduleFormat("Resource Listing");
		item.setResourceName("Equipment");
		item.setNeeds(false);
		item.setEvents(false);
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

		oReturn = new B2WScheduleView(scheduleView.getName() + "_UPD", sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);
		oReturn.setStartDate(scheduleView.getStartDate());
		oReturn.setDuration(scheduleView.getDuration());

		return oReturn;
	}
	private B2WScheduleView setupUpdateCrewsScheduleView(B2WScheduleView scheduleView) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sCrewsScheduleView_BU_UPD");
		String sSchedulesNotes = getProperty("sCrewsScheduleView_Notes_UPD");
		String sGroupingLevel1 = getProperty("sCrewsScheduleView_GroupingLevel1_UPD");
		String sGroupingLevel2 = getProperty("sCrewsScheduleView_GroupingLevel2_UPD");
		String sFilterType = getProperty("sCrewsScheduleView_FilterType_UPD");
		String sFilterValue = getProperty("sCrewsScheduleView_FilterValue_UPD");
		String sSecurityRole = getProperty("sCrewsScheduleView_SecurityRole_UPD");
		String sUser = getProperty("sCrewsScheduleView_User_UPD");
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

		item1 = new B2WScheduleItem();
		item1.setScheduleFormat("Crew View");
		item1.setResourceName("Production Crews");
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

		oReturn = new B2WScheduleView(scheduleView.getName() + "_UPD", sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);
		oReturn.setStartDate(scheduleView.getStartDate());
		oReturn.setDuration(scheduleView.getDuration());

		return oReturn;
	}
	private B2WScheduleView setupUpdateLocationScheduleView(B2WScheduleView scheduleView) {
		B2WScheduleView oReturn;

		// === Read Properties
		String sBU = getProperty("sLocationScheduleView_BU_UPD");
		String sSchedulesNotes = getProperty("sLocationScheduleView_Notes_UPD");
		String sGroupingLevel1 = getProperty("sLocationScheduleView_GroupingLevel1_UPD");
		String sGroupingLevel2 = getProperty("sLocationScheduleView_GroupingLevel2_UPD");
		String sFilterType = getProperty("sLocationScheduleView_FilterType_UPD");
		String sFilterValue = getProperty("sLocationScheduleView_FilterValue_UPD");
		String sSecurityRole = getProperty("sLocationScheduleView_SecurityRole_UPD");
		String sUser = getProperty("sLocationScheduleView_User_UPD");
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

		item1 = new B2WScheduleItem();
		item1.setScheduleFormat("Location View");
		item1.setResourceName("Production Crews");
		itemList.add(item1);

		item1 = new B2WScheduleItem();
		item1.setScheduleFormat("Location View");
		item1.setResourceName("Equipment");
		itemList.add(item1);

		item1 = new B2WScheduleItem();
		item1.setScheduleFormat("Location View");
		item1.setResourceName("Employees");
		itemList.add(item1);

		// Prepare Filters List
		ArrayList<String[]> filters = new ArrayList<>();
		String[] filterItem = new String[2];
		if (!sFilterType.equals("")) {
			filterItem[0] = sFilterType;
			filterItem[1] = sFilterValue;
			filters.add(filterItem);
		}

		// === Prepare Roles list
		ArrayList<String> roles = new ArrayList<>();
		if (!sSecurityRole.equals("")){
			roles.add(sSecurityRole);
		}

		// === Prepare Users list
		ArrayList<String> users = new ArrayList<>();
		if (!sUser.equals("")) {
			users.add(sUser);
		}

		oReturn = new B2WScheduleView(scheduleView.getName() + "_UPD", sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
				filters, roles, users);

		oReturn.setStartDate(scheduleView.getStartDate());
		oReturn.setDuration(scheduleView.getDuration());

		return oReturn;
	}

	// Tests
	private void createScheduleViews() {
		b2wSchedulesTasks.createScheduleView(employeeScheduleView);
		b2wSchedulesTasks.createScheduleView(equipmentScheduleView);
		b2wSchedulesTasks.createScheduleView(crewsScheduleView);
		b2wSchedulesTasks.createScheduleView(locationScheduleView);
	}
	private void copyScheduleViews() {
		copyEmployeeScheduleView = b2wSchedulesTasks.copyScheduleView(employeeScheduleView);
		copyEquipmentScheduleView = b2wSchedulesTasks.copyScheduleView(equipmentScheduleView);
		copyCrewsScheduleView = b2wSchedulesTasks.copyScheduleView(crewsScheduleView);
		copyLocationScheduleView = b2wSchedulesTasks.copyScheduleView(locationScheduleView);
	}
	private void updateScheduleView() {
		updateEmployeeScheduleView = setupUpdateEmployeeScheduleView(copyEmployeeScheduleView);
		b2wSchedulesTasks.updateScheduleView(copyEmployeeScheduleView, updateEmployeeScheduleView);
		copyEmployeeScheduleView = updateEmployeeScheduleView;

		updateEquipmentScheduleView = setupUpdateEquipmentScheduleView(copyEquipmentScheduleView);
		b2wSchedulesTasks.updateScheduleView(copyEquipmentScheduleView, updateEquipmentScheduleView);
		copyEquipmentScheduleView = updateEquipmentScheduleView;

		updateCrewsScheduleView = setupUpdateCrewsScheduleView(copyCrewsScheduleView);
		b2wSchedulesTasks.updateScheduleView(copyCrewsScheduleView, updateCrewsScheduleView);
		copyCrewsScheduleView = updateCrewsScheduleView;

		updateLocationScheduleView = setupUpdateLocationScheduleView(copyLocationScheduleView);
		b2wSchedulesTasks.updateScheduleView(copyLocationScheduleView, updateLocationScheduleView);
		copyLocationScheduleView = updateLocationScheduleView;
	}
	private void deleteScheduleViews() {
		b2wSchedulesTasks.deleteScheduleView(employeeScheduleView);
		b2wSchedulesTasks.deleteScheduleView(copyEmployeeScheduleView);
		b2wSchedulesTasks.deleteScheduleView(equipmentScheduleView);
		b2wSchedulesTasks.deleteScheduleView(copyEquipmentScheduleView);
		b2wSchedulesTasks.deleteScheduleView(crewsScheduleView);
		b2wSchedulesTasks.deleteScheduleView(copyCrewsScheduleView);
		b2wSchedulesTasks.deleteScheduleView(locationScheduleView);
		b2wSchedulesTasks.deleteScheduleView(copyLocationScheduleView);
	}
}