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
    B2WAssignment employeeAssignmentForSubstitution;

    // Employee Substitution
    B2WAssignment employeeSubstitution;

    // Employee Need
    B2WAssignment employeeNeed;
    B2WAssignment employeeNeed1;

    // Employee Event
    B2WAssignment employeeEvent;

    // Equipment Assignment
    B2WAssignment equipmentAssignment;

    // Equipment Need
    B2WAssignment equipmentNeed;
    B2WAssignment equipmentNeed1;

    // Equipment Event
    B2WAssignment equipmentEvent;

    // Crews Assignments
    B2WAssignment crewAssignment;

    // Crews Needs
    B2WAssignment crewNeed;
    B2WAssignment crewNeed1;

    // Move Assignment
    B2WAssignment moveAssignment;

    // Move Order
    B2WAssignment moveOrder;

    // Location Event
    B2WAssignment locationEvent;

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

        // === Reading Properties
        String sEquipmentNeedName1 = getProperty("sEquipmentNeedName1");
        String sEquipmentNeedJobSiteName1 = getProperty("sEquipmentNeedJobSiteName1");
        String sEquipmentNeedRequestedBy1 = getProperty("sEquipmentNeedRequestedBy1");
        String sEquipmentNeedNotesText1 = getProperty("sEquipmentNeedNotesText1");
        String sEquipmentNeedAssignmentStartTime1 = getProperty("sEquipmentNeedAssignmentStartTime1");
        String sEquipmentNeedAssignmentDuration1 = getProperty("sEquipmentNeedAssignmentDuration1");
        // === Complete reading properties

        equipmentNeed1 = new B2WAssignment(B2WAssignmentType.EQUIPMENT_NEED_TYPE, sEquipmentNeedName1, sEquipmentNeedJobSiteName1, sEquipmentNeedRequestedBy1, sEquipmentNeedNotesText1,
                dateList, sEquipmentNeedAssignmentStartTime1, sEquipmentNeedAssignmentDuration1);

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

        // === Reading Properties
        String sCrewNeedName1 = getProperty("sCrewNeedName1");
        String sCrewNeedJobSiteName1 = getProperty("sCrewNeedJobSiteName1");
        String sCrewNeedRequestedBy1 = getProperty("sCrewNeedRequestedBy1");
        String sCrewNeedNotesText1 = getProperty("sCrewNeedNotesText1");
        String sCrewNeedAssignmentDuration1 = getProperty("sCrewNeedAssignmentDuration1");
        String sCrewNeedAssignmentStartTime1 = getProperty("sCrewNeedAssignmentStartTime1");
        // === Complete reading properties

        crewNeed1 = new B2WAssignment(B2WAssignmentType.CREW_NEED_TYPE, sCrewNeedName1, sCrewNeedJobSiteName1, sCrewNeedRequestedBy1, sCrewNeedNotesText1,
                dateList, sCrewNeedAssignmentStartTime1, sCrewNeedAssignmentDuration1);

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

        dateList = new ArrayList<Date>();
        dateList.add(equipmentScheduleView.getStartDate()); //Start Date
        dateList.add(equipmentScheduleView.getStartDate()); //End Date
        // === Complete reading properties

        moveAssignment = new B2WAssignment(B2WAssignmentType.MOVE_ASSIGNMENT_TYPE, sMoveAssignmentEquipmentName,
                sMoveAssignmentPickupLocationType, sMoveAssignmentPickupLocationName, dMoveAssignmentPickupDate, sMoveAssignmentPickupTime,
                sMoveAssignmentDropoffLocationType, sMoveAssignmentDropoffLocationName, dMoveAssignmentDropoffDate, sMoveAssignmentDropoffTime,
                sMoveAssignmentRequestedBy, sMoveAssignmentNotesText, sMoveAssignmentTransportationCrewName);
        // ==== Complete Move Assignments ==============================================================================

        // ==== Setup Move Order =======================================================================================
        // === Reading Properties
        String sMoveOrderEquipmentName = getProperty("sMoveOrderEquipmentName");
        String sMoveOrderPickupLocationType = getProperty("sMoveOrderPickupLocationType");
        String sMoveOrderPickupLocationName = getProperty("sMoveOrderPickupLocationName");
        String sMoveOrderPickupDate = getProperty("sMoveOrderPickupDate");
        Date dMoveOrderPickupDate = StringUtils.getDateFromStringWithPattern(sMoveOrderPickupDate, "M/d/yyyy");
        String sMoveOrderPickupTime = getProperty("sMoveOrderPickupTime");
        String sMoveOrderDropoffLocationType = getProperty("sMoveOrderDropoffLocationType");
        String sMoveOrderDropoffLocationName = getProperty("sMoveOrderDropoffLocationName");
        String sMoveOrderDropoffDate = getProperty("sMoveOrderDropoffDate");
        Date dMoveOrderDropoffDate = StringUtils.getDateFromStringWithPattern(sMoveOrderDropoffDate, "M/d/yyyy");
        String sMoveOrderDropoffTime = getProperty("sMoveOrderDropoffTime");
        String sMoveOrderRequestedBy = getProperty("sMoveOrderRequestedBy");
        String sMoveOrderNotesText = getProperty("sMoveOrderNotesText");
        String sMoveOrderTransportationCrewName = "";
        // === Complete reading properties

        moveOrder = new B2WAssignment(B2WAssignmentType.MOVE_ORDER_TYPE, sMoveOrderEquipmentName,
                sMoveOrderPickupLocationType, sMoveOrderPickupLocationName, dMoveOrderPickupDate, sMoveOrderPickupTime,
                sMoveOrderDropoffLocationType, sMoveOrderDropoffLocationName, dMoveOrderDropoffDate, sMoveOrderDropoffTime,
                sMoveOrderRequestedBy, sMoveOrderNotesText, sMoveOrderTransportationCrewName);
        // ==== Complete Move Order ====================================================================================

        // ==== Setup Employee Event ===================================================================================
        // === Reading Properties
        String sEmployeeEventName = getProperty("sEmployeeEventName");
        String sEmployeeEventType = getProperty("sEmployeeEventType");
        String sEmployeeEventNotesText = getProperty("sEmployeeEventNotesText");
        // === Complete reading properties

        dateList = new ArrayList<Date>();
        dateList.add(employeeDefaultScheduleView.getStartDate()); //Start Date
        dateList.add(employeeDefaultScheduleView.getStartDate()); //End Date

        employeeEvent = new B2WAssignment(B2WAssignmentType.EMPLOYEE_EVENT_TYPE, sEmployeeEventName,
                sEmployeeEventType, sEmployeeEventNotesText, dateList);
        // ==== Complete Employee Event ================================================================================

        // ==== Setup Equipment Event ==================================================================================
        // === Reading Properties
        String sEquipmentEventName = getProperty("sEquipmentEventName");
        String sEquipmentEventType = getProperty("sEquipmentEventType");
        String sEquipmentEventNotesText = getProperty("sEquipmentEventNotesText");
        // === Complete reading properties

        dateList = new ArrayList<Date>();
        dateList.add(equipmentDefaultScheduleView.getStartDate()); //Start Date
        dateList.add(equipmentDefaultScheduleView.getStartDate()); //End Date

        equipmentEvent = new B2WAssignment(B2WAssignmentType.EQUIPMENT_EVENT_TYPE, sEquipmentEventName,
                sEquipmentEventType, sEquipmentEventNotesText, dateList);
        // ==== Complete Equipment Event ===============================================================================

        // ==== Setup Location Event ==================================================================================
        // === Reading Properties
        String sLocationEventName = getProperty("sLocationEventName");
        String sLocationEventType = getProperty("sLocationEventType");
        String sLocationEventNotesText = getProperty("sLocationEventNotesText");
        // === Complete reading properties

        dateList = new ArrayList<Date>();
        dateList.add(locationDefaultScheduleView.getStartDate()); //Start Date
        dateList.add(locationDefaultScheduleView.getStartDate()); //End Date

        locationEvent = new B2WAssignment(B2WAssignmentType.LOCATION_EVENT_TYPE, sLocationEventName,
                sLocationEventType, sLocationEventNotesText, dateList);
        // ==== Complete Location Event ===============================================================================
    }

    public void testMain() throws Throwable {
        //createScheduleViews();

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        /*
        // Create All Types of Assignments
        createEmployeeAssignments();
        createEmployeeSubstitution();
        createEmployeeNeeds();
        createEquipmentAssignments();
        createEquipmentNeeds();
        createCrewsAssignments();
        createCrewsNeeds();
        createMoveAssignment();
        createMoveOrder();
        createEmployeeEvent();
        createEquipmentEvent();
        createLocationEvent();

        // Move Assignments
        moveEmployeeAssignment();
        moveSubstitution();
        moveEmployeeNeed();
        moveEquipmentAssignment();
        moveEquipmentNeed();
        moveCrewAssignment();
        moveCrewNeed();
        moveMoveAssignment();
        moveMoveOrder();
        moveEmployeeEvent();
        moveEquipmentEvent();
        moveLocationEvent();
        */
        // Update Assignments
        /*
        updateEmployeeAssignment();
        */
        createEmployeeSubstitution();
        moveSubstitution();
        updateSubstitution();
        /*
        // Delete Assignments
        deleteEmployeeAssignmentSubstitution();
        deleteEmployeeAssignments();
        deleteEmployeeNeeds();
        deleteEquipmentAssignments();
        deleteEquipmentsNeeds();
        deleteCrewAssignments();
        deleteCrewNeeds();
        deleteMoveAssignments();
        deleteMoveOrders();
        deleteEmployeeEvents();
        deleteEquipmentEvents();
        deleteLocationEvents();

        // Delete Schedule Views
        deleteScheduleViews();
        */
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
        b2wSchedulesTasks.createScheduleView(crewsScheduleView);
        b2wSchedulesTasks.createScheduleView(locationScheduleView);
    }
    private void deleteScheduleViews() {
        b2wSchedulesTasks.deleteScheduleView(employeeScheduleView);
        b2wSchedulesTasks.deleteScheduleView(equipmentScheduleView);
        b2wSchedulesTasks.deleteScheduleView(crewsScheduleView);
        b2wSchedulesTasks.deleteScheduleView(locationScheduleView);
    }
    private void selectView(B2WScheduleView scheduleView) {
        logCompare(true, b2wScheduler.navigateTo(scheduleView), "Open " + scheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(scheduleView), "Set " + scheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(scheduleView), "Set Start Date to " + scheduleView.getStartDate());
    }

    private void createEmployeeAssignments() {
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Filter by " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeAssignment(employeeAssignment), "Create Assignment for: " + employeeAssignment.getResourceName());
    }
    private void createEmployeeSubstitution() {
        selectView(employeeDefaultScheduleView);

        String sEmployeeSubstitution = getProperty("sEmployeeSubstitution");

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignmentForSubstitution.getResourceName()), "Set Filter by " + employeeAssignmentForSubstitution.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeAssignment(employeeAssignmentForSubstitution), "Create Assignment for: " + employeeAssignmentForSubstitution.getResourceName());

        logCompare(true, b2wScheduler.createEmployeeSubstitution(employeeAssignmentForSubstitution, sEmployeeSubstitution), "Create Assignment for: " + employeeAssignmentForSubstitution.getResourceName());
        employeeSubstitution = employeeAssignmentForSubstitution.getSubstitution();
    }
    private void createEmployeeNeeds() {
        selectView(employeeScheduleView);

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
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Filter by " + equipmentNeed.getResourceName());
        logCompare(true, b2wScheduler.createEquipmentNeed(equipmentNeed), "Create Assignment for: " + equipmentNeed.getResourceName());

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed1.getResourceName()), "Set Filter by " + equipmentNeed1.getResourceName());
        logCompare(true, b2wScheduler.createEquipmentNeed(equipmentNeed1), "Create Assignment for: " + equipmentNeed1.getResourceName());
    }
    private void createCrewsAssignments() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Filter by " + crewAssignment.getResourceName());
        logCompare(true, b2wScheduler.createCrewAssignment(crewAssignment), "Create Assignment for: " + crewAssignment.getResourceName());
    }
    private void createCrewsNeeds() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Filter by " + crewNeed.getResourceName());
        logCompare(true, b2wScheduler.createCrewNeed(crewNeed), "Create Need for: " + crewNeed.getResourceName());

        logCompare(true, b2wScheduler.setSearchValue(crewNeed1.getResourceName()), "Set Filter by " + crewNeed1.getResourceName());
        logCompare(true, b2wScheduler.createCrewNeed(crewNeed1), "Create Need for: " + crewNeed1.getResourceName());
    }
    private void createMoveAssignment() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Filter by " + moveAssignment.getResourceName());
        logCompare(true, b2wScheduler.createMoveAssignment(moveAssignment), "Create Move Assignment for: " + moveAssignment.getResourceName());
    }
    private void createMoveOrder() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveOrder.getResourceName()), "Set Filter by " + moveOrder.getResourceName());
        logCompare(true, b2wScheduler.createMoveOrder(moveOrder), "Create Move Assignment for: " + moveOrder.getResourceName());

    }
    private void createEmployeeEvent() {
        selectView(employeeDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeEvent.getResourceName()), "Set Filter by " + employeeEvent.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeEvent(employeeEvent), "Create Employee Event for: " + employeeEvent.getResourceName());
    }
    private void createEquipmentEvent() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentEvent.getResourceName()), "Set Filter by " + equipmentEvent.getResourceName());
        logCompare(true, b2wScheduler.createEquipmentEvent(equipmentEvent), "Create Equipment Event for: " + equipmentEvent.getResourceName());
    }
    private void createLocationEvent() {
        selectView(locationDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(locationEvent.getResourceName()), "Set Filter by " + locationEvent.getResourceName());
        logCompare(true, b2wScheduler.createLocationEvent(locationEvent), "Create Location Event for: " + locationEvent.getResourceName());
    }

    private void moveEmployeeAssignment() {
        selectView(employeeDefaultScheduleView);

        String backupEmployee = employeeAssignment.getResourceName();
        String sNewEmployee = getProperty("sEmployeeNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Quick Filter to " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(employeeAssignment, employeeDefaultScheduleView.getEndDate()), "Move Employee Assignment for: "
                + employeeAssignment.getResourceName() + " to Date: " + employeeDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeAssignment, sNewEmployee, employeeDefaultScheduleView.getEndDate()), "Move Employee Assignment for: "
                + employeeAssignment.getResourceName() + " to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeAssignment, backupEmployee, employeeDefaultScheduleView.getStartDate()), "Move Employee Assignment for: "
                + employeeAssignment.getResourceName() + " to Date: " + employeeDefaultScheduleView.getStartDate());
    }
    private void moveSubstitution() {
        selectView(employeeDefaultScheduleView);

        String sNewEmployee = getProperty("sEmployeeNameUpd");
        String backupEmployeeName = employeeSubstitution.getResourceName();

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResource(employeeSubstitution, sNewEmployee), "Move Employee Assignment for: "
                + employeeSubstitution.getResourceName() + " to Date: " + employeeSubstitution.getDateList().get(0));
        logCompare(true, b2wScheduler.moveAssignmentToResource(employeeSubstitution, backupEmployeeName), "Move Employee Assignment for: "
                + employeeSubstitution.getResourceName() + " to Date: " + employeeSubstitution.getDateList().get(0));

        /*
        String backupEmployeeName = employeeAssignmentForSubstitution.getSubstitution().getResourceName();

        logCompare(true, b2wScheduler.moveAssignmentToResource(employeeAssignmentForSubstitution.getSubstitution(), sNewEmployee), "Move Employee Assignment for: "
                + employeeAssignmentForSubstitution.getSubstitution().getResourceName() + " to Date: " + employeeAssignmentForSubstitution.getSubstitution().getDateList().get(0));
        logCompare(true, b2wScheduler.moveAssignmentToResource(employeeAssignmentForSubstitution.getSubstitution(), backupEmployeeName), "Move Employee Assignment for: "
                + employeeAssignmentForSubstitution.getSubstitution().getResourceName() + " to Date: " + employeeAssignmentForSubstitution.getSubstitution().getDateList().get(0));
        */
    }
    private void moveEmployeeNeed() {
        selectView(employeeDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Quick Filter to " + employeeNeed.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(employeeNeed, employeeDefaultScheduleView.getEndDate()), "Move Employee Need for: "
                + employeeNeed.getResourceName() + " to Date: " + employeeDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeNeed1, employeeNeed.getResourceName(), employeeDefaultScheduleView.getStartDate()), "Move Employee Assignment for: "
                + employeeNeed.getResourceName() + " to Date: " + employeeDefaultScheduleView.getStartDate());

    }
    private void moveEquipmentAssignment() {
        selectView(equipmentDefaultScheduleView);

        String sNewEquipmentName = getProperty("sEquipmentNameUpd");
        String backupEmployee = equipmentAssignment.getResourceName();

        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Quick Filter to " + equipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(equipmentAssignment, equipmentDefaultScheduleView.getEndDate()), "Move Equipment Assignment for: "
                + equipmentAssignment.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentAssignment, sNewEquipmentName, equipmentDefaultScheduleView.getEndDate()), "Move Equipment Assignment for: "
                + equipmentAssignment.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentAssignment, backupEmployee, equipmentDefaultScheduleView.getStartDate()), "Move Equipment Assignment for: "
                + equipmentAssignment.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getStartDate());
    }
    private void moveEquipmentNeed() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Quick Filter to " + equipmentNeed.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(equipmentNeed, equipmentDefaultScheduleView.getEndDate()), "Move Equipment Need for: "
                + equipmentNeed.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentNeed1, equipmentNeed.getResourceName(), equipmentDefaultScheduleView.getStartDate()), "Move Equipment Need for: "
                + equipmentNeed1.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getStartDate());
    }
    private void moveCrewAssignment() {
        selectView(crewsDefaultScheduleView);

        String sCrewNameUpd = getProperty("sCrewNameUpd");
        String backupCrewName = crewAssignment.getResourceName();

        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Quick Filter to " + crewAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(crewAssignment, crewsDefaultScheduleView.getEndDate()), "Move Crew Assignment for: "
                + crewAssignment.getResourceName() + " to Date: " + crewsDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(crewAssignment, sCrewNameUpd, crewsDefaultScheduleView.getEndDate()), "Move Crew Assignment for: "
                + crewAssignment.getResourceName() + " to Date: " + crewsDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(crewAssignment, backupCrewName, crewsDefaultScheduleView.getStartDate()), "Move Crew Assignment for: "
                + crewAssignment.getResourceName() + " to Date: " + crewsDefaultScheduleView.getStartDate());
    }
    private void moveCrewNeed() {
        selectView(crewsDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Quick Filter to " + crewNeed.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(crewNeed, crewsDefaultScheduleView.getEndDate()), "Move Crew Need for: "
                + crewNeed.getResourceName() + " to Date: " + crewsDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(crewNeed1, crewNeed.getResourceName(), crewsDefaultScheduleView.getStartDate()), "Move Crew Need for: "
                + crewNeed1.getResourceName() + " to Date: " + crewsDefaultScheduleView.getStartDate());
    }
    private void moveMoveAssignment() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Quick Filter to " + moveAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(moveAssignment, equipmentDefaultScheduleView.getEndDate()), "Move Move Assignment for: "
                + moveAssignment.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToDate(moveAssignment, equipmentDefaultScheduleView.getStartDate()), "Move Move Assignment for: "
                + moveAssignment.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getStartDate());
    }
    private void moveMoveOrder() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveOrder.getResourceName()), "Set Quick Filter to " + moveOrder.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(moveOrder, equipmentDefaultScheduleView.getEndDate()), "Move Move Order for: "
                + moveOrder.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToDate(moveOrder, equipmentDefaultScheduleView.getStartDate()), "Move Move Order for: "
                + moveOrder.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getStartDate());
    }
    private void moveEmployeeEvent() {
        selectView(employeeDefaultScheduleView);

        String backupEmployee = employeeEvent.getResourceName();
        String sNewEmployee = getProperty("sEmployeeNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(employeeEvent.getResourceName()), "Set Quick Filter to " + employeeEvent.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(employeeEvent, employeeDefaultScheduleView.getEndDate()), "Move Employee Event for: "
                + employeeEvent.getResourceName() + " to Date: " + employeeDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeEvent, sNewEmployee, employeeDefaultScheduleView.getEndDate()), "Move Employee Event for: "
                + employeeEvent.getResourceName() + " to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeEvent, backupEmployee, employeeDefaultScheduleView.getStartDate()), "Move Employee Event for: "
                + employeeEvent.getResourceName() + " to Date: " + employeeDefaultScheduleView.getStartDate());
    }
    private void moveEquipmentEvent() {
        selectView(equipmentDefaultScheduleView);

        String backupResourceName = equipmentEvent.getResourceName();
        String sEquipmentNameUpd = getProperty("sEquipmentNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(equipmentEvent.getResourceName()), "Set Quick Filter to " + equipmentEvent.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(equipmentEvent, equipmentDefaultScheduleView.getEndDate()), "Move Equipment Event for: "
                + equipmentEvent.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentEvent, sEquipmentNameUpd, equipmentDefaultScheduleView.getEndDate()), "Move Equipment Event for: "
                + equipmentEvent.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentEvent, backupResourceName, equipmentDefaultScheduleView.getStartDate()), "Move Equipment Event for: "
                + equipmentEvent.getResourceName() + " to Date: " + equipmentDefaultScheduleView.getStartDate());
    }
    private void moveLocationEvent() {
        selectView(locationDefaultScheduleView);

        String backupResourceName = locationEvent.getResourceName();
        String sLocationEventNameUpd = getProperty("sLocationEventNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(locationEvent.getResourceName()), "Set Quick Filter to " + locationEvent.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(locationEvent, locationDefaultScheduleView.getEndDate()), "Move Location Event for: "
                + locationEvent.getResourceName() + " to Date: " + locationDefaultScheduleView.getEndDate());

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(locationEvent, sLocationEventNameUpd, locationDefaultScheduleView.getEndDate()), "Move Location Event for: "
                + locationEvent.getResourceName() + " to Date: " + locationDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(locationEvent, backupResourceName, locationDefaultScheduleView.getStartDate()), "Move Location Event for: "
                + locationEvent.getResourceName() + " to Date: " + locationDefaultScheduleView.getStartDate());
    }

    private void updateEmployeeAssignment() {
        selectView(employeeScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = employeeAssignment.clone();

        String sEmployeeNameUpd = getProperty("sEmployeeNameUpd");
        String sEmployeeJobSiteNameUpd = getProperty("sEmployeeJobSiteNameUpd");
        String sEmployeeRequestedByUpd = getProperty("sEmployeeRequestedByUpd");
        String sEmployeeAssignmentDurationUpd = getProperty("sEmployeeAssignmentDurationUpd");
        String sEmployeeAssignmentStartTimeUpd = getProperty("sEmployeeAssignmentStartTimeUpd");
        String sEmployeeAssignmentNotesUpd = getProperty("sEmployeeAssignmentNotesUpd");
        updatedAssignment.setResourceName(sEmployeeNameUpd);
        updatedAssignment.setLocationName(sEmployeeJobSiteNameUpd);
        updatedAssignment.setRequestedBy(sEmployeeRequestedByUpd);
        updatedAssignment.setDuration(sEmployeeAssignmentDurationUpd);
        updatedAssignment.setStartTime(sEmployeeAssignmentStartTimeUpd);
        updatedAssignment.setNotes(sEmployeeAssignmentNotesUpd);

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Quick Filter to " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(employeeAssignment, updatedAssignment), "Update Employee Assignment from: "
                + employeeAssignment.getResourceName() + " to : " + updatedAssignment.getResourceName());
        employeeAssignment = updatedAssignment;
    }
    private void updateSubstitution() {
        employeeScheduleView.setName("AUT Schedule - Employees - 6755");
        //===============
        selectView(employeeScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = employeeSubstitution.clone();

        String sEmployeeSubstitutionUpd = getProperty("sEmployeeSubstitutionUpd");
        updatedAssignment.setResourceName(sEmployeeSubstitutionUpd);

        logCompare(true, b2wScheduler.setSearchValue(employeeSubstitution.getResourceName()), "Set Quick Filter to " + employeeSubstitution.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(employeeSubstitution, updatedAssignment), "Update Employee Assignment from: "
                + employeeSubstitution.getResourceName() + " to : " + updatedAssignment.getResourceName());
        employeeSubstitution = updatedAssignment;
    }

    private void deleteEmployeeAssignmentSubstitution(){
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeSubstitution.getResourceName()), "Set Filter by " + employeeSubstitution.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(employeeSubstitution), "Delete Assignment for: " + employeeSubstitution.getResourceName());
        employeeAssignmentForSubstitution.removeSubstitution();
        employeeSubstitution = null;
    }
    private void deleteEmployeeAssignments(){
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Filter by " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(employeeAssignment), "Delete Assignment for: " + employeeAssignment.getResourceName());
        employeeAssignment = null;

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignmentForSubstitution.getResourceName()), "Set Filter by " + employeeAssignmentForSubstitution.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(employeeAssignmentForSubstitution), "Delete Assignment for: " + employeeAssignmentForSubstitution.getResourceName());
        employeeAssignmentForSubstitution = null;
    }
    private void deleteEmployeeNeeds(){
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Filter by " + employeeNeed.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(employeeNeed), "Delete Need for: " + employeeNeed.getResourceName());
        employeeNeed = null;

        logCompare(true, b2wScheduler.setSearchValue(employeeNeed1.getResourceName()), "Set Filter by " + employeeNeed1.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(employeeNeed1), "Delete Need for: " + employeeNeed1.getResourceName());
        employeeNeed1 = null;
    }
    private void deleteEquipmentAssignments() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Filter by " + equipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(equipmentAssignment), "Delete Equipment Assignment for: " + equipmentAssignment.getResourceName());
        equipmentAssignment = null;
    }
    private void deleteEquipmentsNeeds() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Filter by " + equipmentNeed.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(equipmentNeed), "Delete Equipment Need for: " + equipmentNeed.getResourceName());
        equipmentNeed = null;

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed1.getResourceName()), "Set Filter by " + equipmentNeed1.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(equipmentNeed1), "Delete Equipment Need for: " + equipmentNeed1.getResourceName());
        equipmentNeed1 = null;
    }
    private void deleteCrewAssignments() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Filter by " + crewAssignment.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(crewAssignment), "Delete Crew Assignment for: " + crewAssignment.getResourceName());
        crewAssignment = null;
    }
    private void deleteCrewNeeds() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Filter by " + crewNeed.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(crewNeed), "Delete Crew Need for: " + crewNeed.getResourceName());
        crewNeed = null;

        logCompare(true, b2wScheduler.setSearchValue(crewNeed1.getResourceName()), "Set Filter by " + crewNeed1.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(crewNeed1), "Delete Crew Need for: " + crewNeed1.getResourceName());
        crewNeed1 = null;
    }
    private void deleteMoveAssignments() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Filter by " + moveAssignment.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(moveAssignment), "Delete Move Assignment for: " + moveAssignment.getResourceName());
        moveAssignment = null;
    }
    private void deleteMoveOrders() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveOrder.getResourceName()), "Set Filter by " + moveOrder.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(moveOrder), "Delete Move Order for: " + moveOrder.getResourceName());
        moveOrder = null;
    }
    private void deleteEmployeeEvents() {
        selectView(employeeDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeEvent.getResourceName()), "Set Filter by " + employeeEvent.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(employeeEvent), "Delete Employee Event for: " + employeeEvent.getResourceName());
        employeeEvent = null;
    }
    private void deleteEquipmentEvents() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentEvent.getResourceName()), "Set Filter by " + equipmentEvent.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(equipmentEvent), "Delete Equipment Event for: " + equipmentEvent.getResourceName());
        equipmentEvent = null;
    }
    private void deleteLocationEvents() {
        selectView(locationDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(locationEvent.getResourceName()), "Set Filter by " + locationEvent.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(locationEvent), "Delete Location Event for: " + locationEvent.getResourceName());
        locationEvent = null;
    }
}