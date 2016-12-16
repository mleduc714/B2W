package testcases;

import com.b2w.test.B2WTestCase;
import tasks.B2WNavigationTasks;
import tasks.scheduler.*;
import tasks.setup.B2WSchedulesTasksTest;
import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;

public class ScheduleAssignmentsTest extends B2WTestCase {

    private final B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    private final B2WSchedulerTasksTest b2wScheduler = new B2WSchedulerTasksTest();
    private final B2WSchedulesTasksTest b2wSchedulesTasks = new B2WSchedulesTasksTest();

    // Property
    // Schedule Views
    B2WScheduleView employeeDefaultScheduleView;
    B2WScheduleView equipmentDefaultScheduleView;
    B2WScheduleView crewsDefaultScheduleView;
    B2WScheduleView locationDefaultScheduleView;

    B2WScheduleView employeeScheduleView;
    B2WScheduleView equipmentScheduleView;
    B2WScheduleView crewsScheduleView;
    B2WScheduleView locationScheduleView;

    // Employee Assignments
    B2WAssignment employeeAssignment;

    // Employee Substitution
    B2WAssignment employeeAssignmentForSubstitution;

    // Employee Need
    B2WAssignment employeeNeed;
    B2WAssignment employeeNeed1;

    // Equipment Assignment
    B2WAssignment equipmentAssignment;

    //Equipment Need
    B2WAssignment equipmentNeed;

    // Crews Assignments
    B2WAssignment crewAssignment;

    // Crews Needs
    B2WAssignment crewNeed;

    // Move Assignment
    B2WAssignment moveAssignment;

    // Move Order
    B2WAssignment moveOrder;

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

/*
        sJobSiteNameUpd = getProperty("sJobSiteNameUpd");
        sRequestedByUpd = getProperty("sRequestedByUpd");
        sEmployeeNameUpd = getProperty("sEmployeeNameUpd");
        sEmployeeNeedNameUpd = getProperty("sEmployeeNeedNameUpd");
        sEquipmentNameUpd = getProperty("sEquipmentNameUpd");
        sEquipmentNeedNameUpd = getProperty("sEquipmentNeedNameUpd");

        sCrewName = getProperty("sCrewName");
        sCrewNameUpd = getProperty("sCrewNameUpd");

        sCrewNeedName = getProperty("sCrewNeedName");
        sCrewNeedNameUpd = getProperty("sCrewNeedNameUpd");

        sPickupJobSiteName = getProperty("sPickupJobSiteName");
        sPickupJobSiteNameUpd = getProperty("sPickupJobSiteNameUpd");

        sDropoffJobSiteName = getProperty("sDropoffJobSiteName");
        sDropoffJobSiteNameUpd = getProperty("sDropoffJobSiteNameUpd");

        sPickupDate = getProperty("sPickupDate");
        sPickupTime = getProperty("sPickupTime");
        sDropoffDate = getProperty("sDropoffDate");
        sDropoffTime = getProperty("sDropoffTime");

        sTransportationCrewName = getProperty("sTransportationCrewName");
        sTransportationCrewNameUpd = getProperty("sTransportationCrewNameUpd");

        sEmployeeEventType = getProperty("sEmployeeEventType");
        sEmployeeEventTypeUpd = getProperty("sEmployeeEventTypeUpd");

        sEquipmentEventType = getProperty("sEquipmentEventType");
        sEquipmentEventTypeUpd = getProperty("sEquipmentEventTypeUpd");

        sLocationEventType = getProperty("sLocationEventType");
        sLocationEventTypeUpd = getProperty("sLocationEventTypeUpd");

        sNotesTextUpd = sNotesText + " UPD";

        sAssignmentDurationUpd = getProperty("sAssignmentDurationUpd");
        sEventDuration = "0 HR";

        sAssignmentStartTimeUpd = getProperty("sAssignmentStartTimeUpd");
        sEventStartTime = "00:00 AM";

        sCalendarDateRange = getProperty("sCalendarDateRange");

        sCalendarStartDate = getProperty("sCalendarStartDate");
        //dCalendarStartDate = StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy");

        sMoveDate = getProperty("sMoveDate");
        dMoveDate = StringUtils.getDateFromStringWithPattern(sMoveDate, "M/d/yyyy");

        sConflictEmployeeName = getProperty("sConflictEmployeeName");
        sConflictEquipmentName = getProperty("sConflictEquipmentName");
        sConflictCrewName = getProperty("sConflictCrewName");
        sConflictJobSite = getProperty("sConflictJobSite");
        sConflictEmployeeEventType = getProperty("sConflictEmployeeEventType");
        sConflictEquipmentEventType = getProperty("sConflictEquipmentEventType");

        // === complete reading properties
        */

        // === Setup Schedules View
        String sScheduleName = getProperty("sGeneralScheduleName");
        String sEmployeeScheduleViewName = sScheduleName + " - Employees - " + n;
        String sEquipmentScheduleViewName = sScheduleName + " - Equipment - " + n;
        String sCrewScheduleViewName = sScheduleName + " - Crews - " + n;
        String sLocationScheduleViewName = sScheduleName + " - Location - " + n;

        String sDefaultEmployeeView = getProperty("sDefaultEmployeeView");
        String sDefaultEquipmentView = getProperty("sDefaultEquipmentView");
        String sDefaultCrewView = getProperty("sDefaultCrewView");
        String sDefaultLocationView = getProperty("sDefaultLocationView");

        employeeScheduleView = setupEmployeeScheduleView(sEmployeeScheduleViewName);
        employeeDefaultScheduleView = employeeScheduleView.clone();
        employeeDefaultScheduleView.setName(sDefaultEmployeeView);

        equipmentScheduleView = setupEquipmentScheduleView(sEquipmentScheduleViewName);
        equipmentDefaultScheduleView = equipmentScheduleView.clone();
        equipmentDefaultScheduleView.setName(sDefaultEquipmentView);

        crewsScheduleView = setupCrewsScheduleView(sCrewScheduleViewName);
        crewsDefaultScheduleView = crewsScheduleView.clone();
        crewsDefaultScheduleView.setName(sDefaultCrewView);

        locationScheduleView = setupLocationScheduleView(sLocationScheduleViewName);
        locationDefaultScheduleView = locationScheduleView.clone();
        locationDefaultScheduleView.setName(sDefaultLocationView);

        // ==== Setup Employee Assignments =============================================================================
        // === Reading Properties
        String sEmployeeName = getProperty("sEmployeeName");

        String sEmployeeJobSiteName = getProperty("sEmployeeJobSiteName");
        String sEmployeeRequestedBy = getProperty("sEmployeeRequestedBy");
        String sEmployeeNotesText = getProperty("sEmployeeNotesText");
        String sEmployeeAssignmentStartTime = getProperty("sEmployeeAssignmentStartTime");
        String sEmployeeAssignmentDuration = getProperty("sEmployeeAssignmentDuration");
        // === Complete reading properties

        ArrayList<Date> dateList = new ArrayList<Date>();
        dateList.add(employeeScheduleView.getStartDate()); //Start Date
        dateList.add(employeeScheduleView.getStartDate()); //End Date

        employeeAssignment = new B2WAssignment(B2WAssignmentType.EMPLOYEE_TYPE, sEmployeeName, sEmployeeJobSiteName,
                sEmployeeRequestedBy, sEmployeeNotesText, dateList, sEmployeeAssignmentStartTime, sEmployeeAssignmentDuration);

        // ==== Setup Employee Assignments Substitution ================================================================
        // === Reading Properties
        String sEmployeeNameForSubstitution = getProperty("sEmployeeNameForSubstitution");

        String sSubstitutionJobSiteName = getProperty("sSubstitutionJobSiteName");
        String sSubstitutionRequestedBy = getProperty("sSubstitutionRequestedBy");
        String sSubstitutionNotesText = getProperty("sSubstitutionNotesText");
        String sSubstitutionAssignmentStartTime = getProperty("sSubstitutionAssignmentStartTime");
        String sSubstitutionAssignmentDuration = getProperty("sSubstitutionAssignmentDuration");
        // === Complete reading properties

        employeeAssignmentForSubstitution = new B2WAssignment(B2WAssignmentType.EMPLOYEE_TYPE, sEmployeeNameForSubstitution,
                sSubstitutionJobSiteName, sSubstitutionRequestedBy, sSubstitutionNotesText, dateList, sSubstitutionAssignmentStartTime, sSubstitutionAssignmentDuration);

        // ==== Setup Employee Need ====================================================================================
        // === Reading Properties
        String sEmployeeNeedName = getProperty("sEmployeeNeedName");

        String sEmployeeNeedJobSiteName = getProperty("sEmployeeNeedJobSiteName");
        String sEmployeeNeedRequestedBy = getProperty("sEmployeeNeedRequestedBy");
        String sEmployeeNeedNotesText = getProperty("sEmployeeNeedNotesText");
        String sEmployeeNeedAssignmentStartTime = getProperty("sEmployeeNeedAssignmentStartTime");
        String sEmployeeNeedAssignmentDuration = getProperty("sEmployeeNeedAssignmentDuration");
        // === Complete reading properties
        employeeNeed = new B2WAssignment(B2WAssignmentType.EMPLOYEE_NEED_TYPE, sEmployeeNeedName, sEmployeeNeedJobSiteName,
                sEmployeeNeedRequestedBy, sEmployeeNeedNotesText, dateList, sEmployeeNeedAssignmentStartTime, sEmployeeNeedAssignmentDuration);

        // === Reading Properties
        String sEmployeeNeedName1 = getProperty("sEmployeeNeedName1");

        String sEmployeeNeedJobSiteName1 = getProperty("sEmployeeNeedJobSiteName1");
        String sEmployeeNeedRequestedBy1 = getProperty("sEmployeeNeedRequestedBy1");
        String sEmployeeNeedNotesText1 = getProperty("sEmployeeNeedNotesText1");
        String sEmployeeNeedAssignmentStartTime1 = getProperty("sEmployeeNeedAssignmentStartTime1");
        String sEmployeeNeedAssignmentDuration1 = getProperty("sEmployeeNeedAssignmentDuration1");
        // === Complete reading properties
        employeeNeed1 = new B2WAssignment(B2WAssignmentType.EMPLOYEE_NEED_TYPE, sEmployeeNeedName1, sEmployeeNeedJobSiteName1,
                sEmployeeNeedRequestedBy1, sEmployeeNeedNotesText1, dateList, sEmployeeNeedAssignmentStartTime1, sEmployeeNeedAssignmentDuration1);
        // ==== Complete Employees =====================================================================================

        // ==== Setup Equipment Assignments ============================================================================
        // === Reading Properties
        String sEquipmentName = getProperty("sEquipmentName");

        String sEquipmentJobSiteName = getProperty("sEquipmentJobSiteName");
        String sEquipmentRequestedBy = getProperty("sEquipmentRequestedBy");
        String sEquipmentNotesText = getProperty("sEquipmentNotesText");
        String sEquipmentAssignmentStartTime = getProperty("sEquipmentAssignmentStartTime");
        String sEquipmentAssignmentDuration = getProperty("sEquipmentAssignmentDuration");
        // === Complete reading properties

        dateList = new ArrayList<Date>();
        dateList.add(equipmentScheduleView.getStartDate()); //Start Date
        dateList.add(equipmentScheduleView.getStartDate()); //End Date

        equipmentAssignment = new B2WAssignment(B2WAssignmentType.EQUIPMENT_TYPE, sEquipmentName, sEquipmentJobSiteName, sEquipmentRequestedBy, sEquipmentNotesText,
                dateList, sEquipmentAssignmentStartTime, sEquipmentAssignmentDuration);

        // ==== Setup Equipment Need ===================================================================================
        // === Reading Properties
        String sEquipmentNeedName = getProperty("sEquipmentNeedName");

        String sEquipmentNeedJobSiteName = getProperty("sEquipmentNeedJobSiteName");
        String sEquipmentNeedRequestedBy = getProperty("sEquipmentNeedRequestedBy");
        String sEquipmentNeedNotesText = getProperty("sEquipmentNeedNotesText");
        String sEquipmentNeedAssignmentStartTime = getProperty("sEquipmentNeedAssignmentStartTime");
        String sEquipmentNeedAssignmentDuration = getProperty("sEquipmentNeedAssignmentDuration");
        // === Complete reading properties

        equipmentNeed = new B2WAssignment(B2WAssignmentType.EQUIPMENT_NEED_TYPE, sEquipmentNeedName, sEquipmentNeedJobSiteName, sEquipmentNeedRequestedBy, sEquipmentNeedNotesText,
                dateList, sEquipmentNeedAssignmentStartTime, sEquipmentNeedAssignmentDuration);
        // ==== Complete Equipment =====================================================================================

        // ==== Setup Crews Assignments ================================================================================
        // === Reading Properties
        String sCrewName = getProperty("sCrewName");

        String sCrewJobSiteName = getProperty("sCrewJobSiteName");
        String sCrewRequestedBy = getProperty("sCrewRequestedBy");
        String sCrewNotesText = getProperty("sCrewNotesText");
        String sCrewAssignmentDuration = getProperty("sCrewAssignmentDuration");
        String sCrewAssignmentStartTime = getProperty("sCrewAssignmentStartTime");
        // === Complete reading properties

        dateList = new ArrayList<Date>();
        dateList.add(crewsScheduleView.getStartDate()); //Start Date
        dateList.add(crewsScheduleView.getStartDate()); //End Date

        crewAssignment = new B2WAssignment(B2WAssignmentType.CREW_TYPE, sCrewName, sCrewJobSiteName, sCrewRequestedBy, sCrewNotesText,
                dateList, sCrewAssignmentStartTime, sCrewAssignmentDuration);

        // ==== Setup Crews Needs ======================================================================================
        // === Reading Properties
        String sCrewNeedName = getProperty("sCrewNeedName");

        String sCrewNeedJobSiteName = getProperty("sCrewNeedJobSiteName");
        String sCrewNeedRequestedBy = getProperty("sCrewNeedRequestedBy");
        String sCrewNeedNotesText = getProperty("sCrewNeedNotesText");
        String sCrewNeedAssignmentDuration = getProperty("sCrewNeedAssignmentDuration");
        String sCrewNeedAssignmentStartTime = getProperty("sCrewNeedAssignmentStartTime");
        // === Complete reading properties

        crewNeed = new B2WAssignment(B2WAssignmentType.CREW_NEED_TYPE, sCrewNeedName, sCrewNeedJobSiteName, sCrewNeedRequestedBy, sCrewNeedNotesText,
                dateList, sCrewNeedAssignmentStartTime, sCrewNeedAssignmentDuration);
        // ==== Complete Crews =========================================================================================

        // ==== Setup Move Assignment ==================================================================================
        // === Reading Properties
        String sMoveAssignmentEquipmentName = getProperty("sMoveAssignmentEquipmentName");
        String sMoveAssignmentPickupLocationType = getProperty("sMoveAssignmentPickupLocationType");
        String sMoveAssignmentPickupLocationName = getProperty("sMoveAssignmentPickupLocationName");
        String sMoveAssignmentDropoffLocationType = getProperty("sMoveAssignmentDropoffLocationType");
        String sMoveAssignmentDropoffLocationName = getProperty("sMoveAssignmentDropoffLocationName");
        String sMoveAssignmentPickupDate = getProperty("sMoveAssignmentPickupDate");
        Date dMoveAssignmentPickupDate = StringUtils.getDateFromStringWithPattern(sMoveAssignmentPickupDate, "M/d/yyyy");
        String sMoveAssignmentPickupTime = getProperty("sMoveAssignmentPickupTime");
        String sMoveAssignmentDropoffDate = getProperty("sMoveAssignmentDropoffDate");
        Date dMoveAssignmentDropoffDate = StringUtils.getDateFromStringWithPattern(sMoveAssignmentDropoffDate, "M/d/yyyy");
        String sMoveAssignmentDropoffTime = getProperty("sMoveAssignmentDropoffTime");
        String sMoveAssignmentRequestedBy = getProperty("sMoveAssignmentRequestedBy");
        String sMoveAssignmentNotesText = getProperty("sMoveAssignmentNotesText");
        String sMoveAssignmentTransportationCrewName = getProperty("sMoveAssignmentTransportationCrewName");
        // === Complete reading properties

        //createMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupJobSiteName, sTransportationCrewName, sPickupDate, sPickupTime, sDropoffDate, sDropoffTime);
        moveAssignment = new B2WAssignment(B2WAssignmentType.MOVE_ASSIGNMENT_TYPE, sMoveAssignmentEquipmentName,
                sMoveAssignmentPickupLocationType, sMoveAssignmentPickupLocationName, dMoveAssignmentPickupDate, sMoveAssignmentPickupTime,
                sMoveAssignmentDropoffLocationType, sMoveAssignmentDropoffLocationName, dMoveAssignmentDropoffDate, sMoveAssignmentDropoffTime,
                sMoveAssignmentRequestedBy, sMoveAssignmentNotesText, sMoveAssignmentTransportationCrewName);
        // ==== Complete Move Assignments ==============================================================================
    }

    public void testMain() throws Throwable {
        createScheduleViews();
        /*
        createEmployeeAssignments();
        createEmployeeNeeds();
        createEquipmentAssignments();
        createEquipmentNeeds();
        createCrewsAssignments();
        createCrewsNeeds();
        */
        createEmployeeAssignments();
        createMoveAssignment();
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

    // Tests
    private void createScheduleViews() {
        b2wSchedulesTasks.createScheduleView(employeeScheduleView);
        b2wSchedulesTasks.createScheduleView(equipmentScheduleView);
        /*
        b2wSchedulesTasks.createScheduleView(crewsScheduleView);
        b2wSchedulesTasks.createScheduleView(locationScheduleView);
        */
    }
    private void createEmployeeAssignments() {
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateTo(employeeScheduleView), "Open " + employeeScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(employeeScheduleView), "Set " + employeeScheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(employeeScheduleView), "Set Start Date to " + employeeScheduleView.getStartDate());
        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Filter by " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeAssignment(employeeAssignment), "Create Assignment for: " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.setSearchValue(employeeAssignmentForSubstitution.getResourceName()), "Set Filter by " + employeeAssignmentForSubstitution.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeAssignment(employeeAssignmentForSubstitution), "Create Assignment for: " + employeeAssignmentForSubstitution.getResourceName());
        logCompare(true, b2wScheduler.navigateTo(employeeDefaultScheduleView), "Open " + employeeDefaultScheduleView.getName() + " Schedule View");
        String sEmployeeSubstitution = getProperty("sEmployeeSubstitution");
        logCompare(true, b2wScheduler.createEmployeeSubstitution(employeeAssignmentForSubstitution, sEmployeeSubstitution), "Create Assignment for: " + employeeAssignmentForSubstitution.getResourceName());
    }
    private void createEmployeeNeeds() {
        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Filter by " + employeeNeed.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeNeed(employeeNeed), "Create Assignment for: " + employeeNeed.getResourceName());
        logCompare(true, b2wScheduler.setSearchValue(employeeNeed1.getResourceName()), "Set Filter by " + employeeNeed1.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeNeed(employeeNeed1), "Create Assignment for: " + employeeNeed1.getResourceName());
    }
    private void createEquipmentAssignments() {
        logCompare(true, b2wScheduler.navigateTo(equipmentScheduleView), "Open " + equipmentScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(equipmentScheduleView), "Set " + equipmentScheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(equipmentScheduleView), "Set Start Date to " + equipmentScheduleView.getStartDate());
        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Filter by " + equipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.createEquipmentAssignment(equipmentAssignment), "Create Assignment for: " + equipmentAssignment.getResourceName());
    }
    private void createEquipmentNeeds() {
        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Filter by " + equipmentNeed.getResourceName());
        logCompare(true, b2wScheduler.createEquipmentNeed(equipmentNeed), "Create Assignment for: " + equipmentNeed.getResourceName());
    }
    private void createCrewsAssignments() {
        logCompare(true, b2wScheduler.navigateTo(crewsScheduleView), "Open " + crewsScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(crewsScheduleView), "Set " + crewsScheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(crewsScheduleView), "Set Start Date to " + crewsScheduleView.getStartDate());
        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Filter by " + crewAssignment.getResourceName());
        logCompare(true, b2wScheduler.createCrewAssignment(crewAssignment), "Create Assignment for: " + crewAssignment.getResourceName());

    }
    private void createCrewsNeeds() {
        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Filter by " + crewNeed.getResourceName());
        logCompare(true, b2wScheduler.createCrewNeed(crewNeed), "Create Need for: " + crewNeed.getResourceName());
    }
    private void createMoveAssignment() {
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateTo(equipmentScheduleView), "Open " + equipmentScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(equipmentScheduleView), "Set " + equipmentScheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(equipmentScheduleView), "Set Start Date to " + equipmentScheduleView.getStartDate());
        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Filter by " + moveAssignment.getResourceName());
        logCompare(true, b2wScheduler.createMoveAssignment(moveAssignment), "Create Move Assignment for: " + moveAssignment.getResourceName());
    }
}