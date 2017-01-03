package testcases;

import com.b2w.test.B2WTestCase;
import org.apache.commons.lang3.time.DateUtils;
import tasks.B2WNavigationTasks;
import tasks.scheduler.*;
import tasks.setup.B2WSchedulesTasks;
import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;

public class ScheduleAssignments extends B2WTestCase {

    private final B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    private final B2WSchedulerTasks b2wScheduler = new B2WSchedulerTasks();
    private final B2WSchedulesTasks b2wSchedulesTasks = new B2WSchedulesTasks();

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
    B2WAssignment copyEmployeeAssignment;
    B2WAssignment employeeAssignmentForSubstitution;

    // Employee Substitution
    B2WAssignment employeeSubstitution;

    // Employee Need
    B2WAssignment employeeNeed;
    B2WAssignment copyEmployeeNeed;
    B2WAssignment employeeNeed1;

    // Employee Event
    B2WAssignment employeeEvent;
    B2WAssignment copyEmployeeEvent;

    // Equipment Assignment
    B2WAssignment equipmentAssignment;
    B2WAssignment copyEquipmentAssignment;

    // Equipment Need
    B2WAssignment equipmentNeed;
    B2WAssignment copyEquipmentNeed;
    B2WAssignment equipmentNeed1;

    // Equipment Event
    B2WAssignment equipmentEvent;
    B2WAssignment copyEquipmentEvent;

    // Crews Assignments
    B2WAssignment crewAssignment;
    B2WAssignment copyCrewAssignment;

    // Crews Needs
    B2WAssignment crewNeed;
    B2WAssignment copyCrewNeed;
    B2WAssignment crewNeed1;

    // Move Assignment
    B2WAssignment moveAssignment;
    B2WAssignment copyMoveAssignment;

    // Move Order
    B2WAssignment moveOrder;
    B2WAssignment copyMoveOrder;
    B2WAssignment copyMoveOrder1;

    // Location Event
    B2WAssignment locationEvent;
    B2WAssignment copyLocationEvent;

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
        createScheduleViews();

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
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

        // Resize Assignments
        resizeEmployeeAssignment();
        resizeEmployeeNeed();
        resizeEquipmentAssignment();
        resizeEquipmentNeed();
        resizeCrewAssignment();
        resizeCrewNeed();
        resizeMoveAssignment();
        resizeMoveOrder();
        resizeEmployeeEvent();
        resizeEquipmentEvent();
        resizeLocationEvent();

        // Copy Assignments
        copyEmployeeAssignment();
        copyEmployeeNeed();
        copyEquipmentAssignment();
        copyEquipmentNeed();
        copyCrewAssignment();
        copyCrewNeed();
        copyMoveAssignment();
        copyMoveOrder();
        copyEmployeeEvent();
        copyEquipmentEvent();
        copyLocationEvent();

        // Conflict Panel
        resolveEmployeeConflict();
        resolveEquipmentConflict();
        resolveCrewConflict();
        resolveMoveAssignmentsConflict();
        resolveEmployeeEventConflict();
        resolveEquipmentEventConflict();

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

        // Update Assignments
        updateEmployeeAssignment();
        updateSubstitution();
        updateEmployeeNeed();
        updateEquipmentAssignment();
        updateEquipmentNeed();
        updateCrewAssignment();
        updateCrewNeed();
        updateMoveAssignment();
        updateMoveOrder();
        updateEmployeeEvent();
        updateEquipmentEvent();
        updateLocationEvent();

        // Order Panel
        verifyEmployeeNeedOrder();
        verifyEquipmentNeedOrder();
        verifyCrewNeedOrder();
        verifyMoveOrderOrder();

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
        logCompare(true, b2wScheduler.navigateTo(scheduleView), "Open '" + scheduleView.getName() + "' Schedule View");
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

    private void resizeEmployeeAssignment() {
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Quick Filter to " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.resizeAssignment(employeeAssignment, "Right", employeeDefaultScheduleView.getEndDate()),
                "Resize Employee Assignment (" +  employeeAssignment.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeAssignment, "Left", employeeDefaultScheduleView.getEndDate()),
                "Resize Employee Assignment (" +  employeeAssignment.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeAssignment, "Left", employeeDefaultScheduleView.getStartDate()),
                "Resize Employee Assignment (" +  employeeAssignment.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeAssignment, "Right", employeeDefaultScheduleView.getStartDate()),
                "Resize Employee Assignment (" +  employeeAssignment.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getStartDate());
    }
    private void resizeEmployeeNeed() {
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Quick Filter to " + employeeNeed.getResourceName());
        logCompare(true, b2wScheduler.resizeAssignment(employeeNeed, "Right", employeeDefaultScheduleView.getEndDate()),
                "Resize Employee Need (" +  employeeNeed.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeNeed, "Left", employeeDefaultScheduleView.getEndDate()),
                "Resize Employee Need (" +  employeeNeed.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeNeed, "Left", employeeDefaultScheduleView.getStartDate()),
                "Resize Employee Need (" +  employeeNeed.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeNeed, "Right", employeeDefaultScheduleView.getStartDate()),
                "Resize Employee Need (" +  employeeNeed.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getStartDate());
    }
    private void resizeEquipmentAssignment() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Quick Filter to " + equipmentAssignment.getResourceName());
        /*
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Right", equipmentScheduleView.getEndDate()),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Left", equipmentScheduleView.getEndDate()),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Left", equipmentScheduleView.getStartDate()),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Right", equipmentScheduleView.getStartDate()),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getStartDate());
        */
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Right", DateUtils.addDays(equipmentAssignment.getEndDateAsDate(), 1)),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentAssignment.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Left", DateUtils.addDays(equipmentAssignment.getStartDateAsDate(), 1)),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Left", DateUtils.addDays(equipmentAssignment.getStartDateAsDate(), -1)),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentAssignment, "Right", DateUtils.addDays(equipmentAssignment.getEndDateAsDate(), -1)),
                "Resize Equipment Assignment (" +  equipmentAssignment.getResourceName() + ") to Date: " + equipmentAssignment.getEndDate());
    }
    private void resizeEquipmentNeed() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Quick Filter to " + equipmentNeed.getResourceName());
        /*
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Right", equipmentScheduleView.getEndDate()),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Left", equipmentScheduleView.getEndDate()),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Left", equipmentScheduleView.getStartDate()),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Right", equipmentScheduleView.getStartDate()),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentScheduleView.getStartDate());
        */
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Right", DateUtils.addDays(equipmentNeed.getEndDateAsDate(), 1)),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentNeed.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Left", DateUtils.addDays(equipmentNeed.getStartDateAsDate(), 1)),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentNeed.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Left", DateUtils.addDays(equipmentNeed.getStartDateAsDate(), -1)),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentNeed.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(equipmentNeed, "Right", DateUtils.addDays(equipmentNeed.getEndDateAsDate(), -1)),
                "Resize Equipment Need (" +  equipmentNeed.getResourceName() + ") to Date: " + equipmentNeed.getEndDate());
    }
    private void resizeCrewAssignment() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Quick Filter to " + crewAssignment.getResourceName());
        /*
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Right", crewsScheduleView.getEndDate()),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewsScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Left", crewsScheduleView.getEndDate()),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewsScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Left", crewsScheduleView.getStartDate()),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewsScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Right", crewsScheduleView.getStartDate()),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewsScheduleView.getStartDate());
        */
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Right", DateUtils.addDays(crewAssignment.getEndDateAsDate(), 1)),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewAssignment.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Left", DateUtils.addDays(crewAssignment.getStartDateAsDate(), 1)),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Left", DateUtils.addDays(crewAssignment.getStartDateAsDate(), -1)),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewAssignment, "Right", DateUtils.addDays(crewAssignment.getEndDateAsDate(), -1)),
                "Resize Crew Assignment (" +  crewAssignment.getResourceName() + ") to Date: " + crewAssignment.getEndDate());
    }
    private void resizeCrewNeed() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Quick Filter to " + crewNeed.getResourceName());
        /*
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Right", crewsScheduleView.getEndDate()),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewsScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Left", crewsScheduleView.getEndDate()),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewsScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Left", crewsScheduleView.getStartDate()),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewsScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Right", crewsScheduleView.getStartDate()),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewsScheduleView.getStartDate());
        */
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Right", DateUtils.addDays(crewNeed.getEndDateAsDate(), 1)),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewNeed.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Left", DateUtils.addDays(crewNeed.getStartDateAsDate(), 1)),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewNeed.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Left", DateUtils.addDays(crewNeed.getStartDateAsDate(), -1)),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewNeed.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(crewNeed, "Right", DateUtils.addDays(crewNeed.getEndDateAsDate(), -1)),
                "Resize Crew Need (" +  crewNeed.getResourceName() + ") to Date: " + crewNeed.getEndDate());
    }
    private void resizeMoveAssignment() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Quick Filter to " + moveAssignment.getResourceName());
        /*
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", equipmentScheduleView.getEndDate()),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", equipmentScheduleView.getEndDate()),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", equipmentScheduleView.getStartDate()),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", equipmentScheduleView.getStartDate()),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentScheduleView.getStartDate());
        */
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", DateUtils.addDays(moveAssignment.getEndDateAsDate(), 1)),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", DateUtils.addDays(moveAssignment.getStartDateAsDate(), 1)),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", DateUtils.addDays(moveAssignment.getStartDateAsDate(), -1)),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", DateUtils.addDays(moveAssignment.getEndDateAsDate(), -1)),
                "Resize Move Assignment (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getEndDate());
    }
    private void resizeMoveOrder() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveOrder.getResourceName()), "Set Quick Filter to " + moveOrder.getResourceName());
        logCompare(true, b2wScheduler.resizeAssignment(moveOrder, "Right", DateUtils.addDays(moveOrder.getEndDateAsDate(), 1)),
                "Resize Move Order (" +  moveOrder.getResourceName() + ") to Date: " + moveOrder.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveOrder, "Left", DateUtils.addDays(moveOrder.getStartDateAsDate(), 1)),
                "Resize Move Order (" +  moveOrder.getResourceName() + ") to Date: " + moveOrder.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveOrder, "Left", DateUtils.addDays(moveOrder.getStartDateAsDate(), -1)),
                "Resize Move Order (" +  moveOrder.getResourceName() + ") to Date: " + moveOrder.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveOrder, "Right", DateUtils.addDays(moveOrder.getEndDateAsDate(), -1)),
                "Resize Move Order (" +  moveOrder.getResourceName() + ") to Date: " + moveOrder.getEndDate());
    }
    private void resizeEmployeeEvent() {
        selectView(employeeDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeEvent.getResourceName()), "Set Quick Filter to " + employeeEvent.getResourceName());
        logCompare(true, b2wScheduler.resizeAssignment(employeeEvent, "Right", employeeDefaultScheduleView.getEndDate()),
                "Resize Employee Event (" +  employeeEvent.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeEvent, "Left", employeeDefaultScheduleView.getEndDate()),
                "Resize Employee Event (" +  employeeEvent.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeEvent, "Left", employeeDefaultScheduleView.getStartDate()),
                "Resize Employee Event (" +  employeeEvent.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(employeeEvent, "Right", employeeDefaultScheduleView.getStartDate()),
                "Resize Employee Event (" +  employeeEvent.getResourceName() + ") to Date: " + employeeDefaultScheduleView.getStartDate());
    }
    private void resizeEquipmentEvent() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Quick Filter to " + moveAssignment.getResourceName());
        /*
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", equipmentDefaultScheduleView.getEndDate()),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", equipmentDefaultScheduleView.getEndDate()),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentDefaultScheduleView.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", equipmentDefaultScheduleView.getStartDate()),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentDefaultScheduleView.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", equipmentDefaultScheduleView.getStartDate()),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + equipmentDefaultScheduleView.getStartDate());
        */
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", DateUtils.addDays(moveAssignment.getEndDateAsDate(), 1)),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", DateUtils.addDays(moveAssignment.getStartDateAsDate(), 1)),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Left", DateUtils.addDays(moveAssignment.getStartDateAsDate(), -1)),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(moveAssignment, "Right", DateUtils.addDays(moveAssignment.getEndDateAsDate(), -1)),
                "Resize Equipment Event (" +  moveAssignment.getResourceName() + ") to Date: " + moveAssignment.getEndDate());
    }
    private void resizeLocationEvent() {
        selectView(locationDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(locationEvent.getResourceName()), "Set Quick Filter to " + locationEvent.getResourceName());
        logCompare(true, b2wScheduler.resizeAssignment(locationEvent, "Right", DateUtils.addDays(locationEvent.getEndDateAsDate(), 1)),
                "Resize Location Event (" +  locationEvent.getResourceName() + ") to Date: " + locationEvent.getEndDate());
        logCompare(true, b2wScheduler.resizeAssignment(locationEvent, "Left", DateUtils.addDays(locationEvent.getStartDateAsDate(), 1)),
                "Resize Location Event (" +  locationEvent.getResourceName() + ") to Date: " + locationEvent.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(locationEvent, "Left", DateUtils.addDays(locationEvent.getStartDateAsDate(), -1)),
                "Resize Location Event (" +  locationEvent.getResourceName() + ") to Date: " + locationEvent.getStartDate());
        logCompare(true, b2wScheduler.resizeAssignment(locationEvent, "Right", DateUtils.addDays(locationEvent.getEndDateAsDate(), -1)),
                "Resize Location Event (" +  locationEvent.getResourceName() + ") to Date: " + locationEvent.getEndDate());
    }

    private void moveEmployeeAssignment() {
        selectView(employeeDefaultScheduleView);

        String backupEmployee = employeeAssignment.getResourceName();
        String sNewEmployee = getProperty("sEmployeeNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Quick Filter to " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(employeeAssignment, DateUtils.addDays(employeeAssignment.getStartDateAsDate(), 2)), "Move Employee Assignment for: "
                + employeeAssignment.getResourceName() + " to Date: " + DateUtils.addDays(employeeAssignment.getStartDateAsDate(), 2));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeAssignment, sNewEmployee, employeeAssignment.getEndDateAsDate(), true), "Move Employee Assignment for: "
                + employeeAssignment.getResourceName() + " to Date: " + employeeAssignment.getEndDateAsDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeAssignment, backupEmployee, DateUtils.addDays(employeeAssignment.getStartDateAsDate(), -1), true), "Move Employee Assignment for: "
                + employeeAssignment.getResourceName() + " to Date: " + DateUtils.addDays(employeeAssignment.getStartDateAsDate(), -1));
    }
    private void moveSubstitution() {
        selectView(employeeDefaultScheduleView);

        String sNewEmployee = getProperty("sEmployeeNameUpd");

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        if (employeeSubstitution != null) {
            String backupEmployeeName = employeeSubstitution.getResourceName();
            logCompare(true, b2wScheduler.moveAssignmentToResource(employeeSubstitution, sNewEmployee), "Move Employee Assignment for: "
                    + employeeSubstitution.getResourceName() + " to Date: " + employeeSubstitution.getDateList().get(0));
            logCompare(true, b2wScheduler.moveAssignmentToResource(employeeSubstitution, backupEmployeeName), "Move Employee Assignment for: "
                    + employeeSubstitution.getResourceName() + " to Date: " + employeeSubstitution.getDateList().get(0));
        } else {
            logCompare(true, false, "Employee Substitution was not created.");
        }
    }
    private void moveEmployeeNeed() {
        selectView(employeeDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Quick Filter to " + employeeNeed.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(employeeNeed, DateUtils.addDays(employeeNeed.getStartDateAsDate(), 1)), "Move Employee Need for: "
                + employeeNeed.getResourceName() + " to Date: " + DateUtils.addDays(employeeNeed.getStartDateAsDate(), 1));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeNeed1, employeeNeed.getResourceName(), employeeNeed1.getStartDateAsDate(), true), "Move Employee Assignment for: "
                + employeeNeed.getResourceName() + " to Date: " + employeeNeed1.getStartDateAsDate());

    }
    private void moveEquipmentAssignment() {
        selectView(equipmentDefaultScheduleView);

        String sNewEquipmentName = getProperty("sEquipmentNameUpd");
        String backupEmployee = equipmentAssignment.getResourceName();

        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Quick Filter to " + equipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(equipmentAssignment, DateUtils.addDays(equipmentAssignment.getStartDateAsDate(), 2)), "Move Equipment Assignment for: "
                + equipmentAssignment.getResourceName() + " to Date: " + DateUtils.addDays(equipmentAssignment.getStartDateAsDate(), 2));
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentAssignment, sNewEquipmentName, equipmentAssignment.getStartDateAsDate(), true), "Move Equipment Assignment for: "
                + equipmentAssignment.getResourceName() + " to Date: " + equipmentAssignment.getStartDateAsDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentAssignment, backupEmployee, DateUtils.addDays(equipmentAssignment.getStartDateAsDate(), -1), true), "Move Equipment Assignment for: "
                + equipmentAssignment.getResourceName() + " to Date: " + DateUtils.addDays(equipmentAssignment.getStartDateAsDate(), -1));
    }
    private void moveEquipmentNeed() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Quick Filter to " + equipmentNeed.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(equipmentNeed, DateUtils.addDays(equipmentNeed.getStartDateAsDate(), 1)), "Move Equipment Need for: "
                + equipmentNeed.getResourceName() + " to Date: " + DateUtils.addDays(equipmentNeed.getStartDateAsDate(), 1));
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentNeed1, equipmentNeed.getResourceName(), equipmentNeed1.getStartDateAsDate(), true), "Move Equipment Need for: "
                + equipmentNeed1.getResourceName() + " to Date: " + equipmentNeed1.getStartDateAsDate());
    }
    private void moveCrewAssignment() {
        selectView(crewsDefaultScheduleView);

        String sCrewNameUpd = getProperty("sCrewNameUpd");
        String backupCrewName = crewAssignment.getResourceName();

        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Quick Filter to " + crewAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(crewAssignment, DateUtils.addDays(crewAssignment.getStartDateAsDate(), 2)), "Move Crew Assignment for: "
                + crewAssignment.getResourceName() + " to Date: " + DateUtils.addDays(crewAssignment.getStartDateAsDate(), 2));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(crewAssignment, sCrewNameUpd, crewAssignment.getStartDateAsDate(), true), "Move Crew Assignment for: "
                + crewAssignment.getResourceName() + " to Date: " + crewAssignment.getStartDateAsDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(crewAssignment, backupCrewName, DateUtils.addDays(crewAssignment.getStartDateAsDate(), -1), true), "Move Crew Assignment for: "
                + crewAssignment.getResourceName() + " to Date: " + DateUtils.addDays(crewAssignment.getStartDateAsDate(), -1));
    }
    private void moveCrewNeed() {
        selectView(crewsDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Quick Filter to " + crewNeed.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(crewNeed, DateUtils.addDays(crewNeed.getStartDateAsDate(), 1)), "Move Crew Need for: "
                + crewNeed.getResourceName() + " to Date: " + DateUtils.addDays(crewNeed.getStartDateAsDate(), 1));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(crewNeed1, crewNeed.getResourceName(), crewNeed1.getStartDateAsDate(), true), "Move Crew Need for: "
                + crewNeed1.getResourceName() + " to Date: " + crewNeed1.getStartDateAsDate());
    }
    private void moveMoveAssignment() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Quick Filter to " + moveAssignment.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(moveAssignment, DateUtils.addDays(moveAssignment.getStartDateAsDate(), 2)), "Move Move Assignment for: "
                + moveAssignment.getResourceName() + " to Date: " + DateUtils.addDays(moveAssignment.getStartDateAsDate(), 2));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Quick Filter");
        logCompare(true, b2wScheduler.moveAssignmentToDate(moveAssignment, DateUtils.addDays(moveAssignment.getStartDateAsDate(), -1)), "Move Move Assignment for: "
                + moveAssignment.getResourceName() + " to Date: " + DateUtils.addDays(moveAssignment.getStartDateAsDate(), -1));
    }
    private void moveMoveOrder() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveOrder.getResourceName()), "Set Quick Filter to " + moveOrder.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(moveOrder, DateUtils.addDays(moveOrder.getStartDateAsDate(), 2)), "Move Move Order for: "
                + moveOrder.getResourceName() + " to Date: " + DateUtils.addDays(moveOrder.getStartDateAsDate(), 2));

        logCompare(true, b2wScheduler.moveAssignmentToDate(moveOrder, DateUtils.addDays(moveOrder.getStartDateAsDate(), -1)), "Move Move Order for: "
                + moveOrder.getResourceName() + " to Date: " + DateUtils.addDays(moveOrder.getStartDateAsDate(), -1));
    }
    private void moveEmployeeEvent() {
        selectView(employeeDefaultScheduleView);

        String backupEmployee = employeeEvent.getResourceName();
        String sNewEmployee = getProperty("sEmployeeNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(employeeEvent.getResourceName()), "Set Quick Filter to " + employeeEvent.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(employeeEvent, DateUtils.addDays(employeeEvent.getStartDateAsDate(), 2)), "Move Employee Event for: "
                + employeeEvent.getResourceName() + " to Date: " + DateUtils.addDays(employeeEvent.getStartDateAsDate(), 2));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeEvent, sNewEmployee, employeeEvent.getStartDateAsDate(), true), "Move Employee Event for: "
                + employeeEvent.getResourceName() + " to Date: " + employeeEvent.getStartDateAsDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(employeeEvent, backupEmployee, DateUtils.addDays(employeeEvent.getStartDateAsDate(), -1), true), "Move Employee Event for: "
                + employeeEvent.getResourceName() + " to Date: " + DateUtils.addDays(employeeEvent.getStartDateAsDate(), -1));
    }
    private void moveEquipmentEvent() {
        selectView(equipmentDefaultScheduleView);

        String backupResourceName = equipmentEvent.getResourceName();
        String sEquipmentNameUpd = getProperty("sEquipmentNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(equipmentEvent.getResourceName()), "Set Quick Filter to " + equipmentEvent.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(equipmentEvent, DateUtils.addDays(equipmentEvent.getStartDateAsDate(), 2)), "Move Equipment Event for: "
                + equipmentEvent.getResourceName() + " to Date: " + DateUtils.addDays(equipmentEvent.getStartDateAsDate(), 2));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentEvent, sEquipmentNameUpd, equipmentEvent.getStartDateAsDate(), true), "Move Equipment Event for: "
                + equipmentEvent.getResourceName() + " to Date: " + equipmentEvent.getStartDateAsDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(equipmentEvent, backupResourceName, DateUtils.addDays(equipmentEvent.getStartDateAsDate(), -1), true), "Move Equipment Event for: "
                + equipmentEvent.getResourceName() + " to Date: " + DateUtils.addDays(equipmentEvent.getStartDateAsDate(), -1));
    }
    private void moveLocationEvent() {
        selectView(locationDefaultScheduleView);

        String backupResourceName = locationEvent.getResourceName();
        String sLocationEventNameUpd = getProperty("sLocationEventNameUpd");

        logCompare(true, b2wScheduler.setSearchValue(locationEvent.getResourceName()), "Set Quick Filter to " + locationEvent.getResourceName());
        logCompare(true, b2wScheduler.moveAssignmentToDate(locationEvent, DateUtils.addDays(locationEvent.getStartDateAsDate(), 2)), "Move Location Event for: "
                + locationEvent.getResourceName() + " to Date: " + DateUtils.addDays(locationEvent.getStartDateAsDate(), 2));

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear Search box");
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(locationEvent, sLocationEventNameUpd, locationEvent.getStartDateAsDate(), true), "Move Location Event for: "
                + locationEvent.getResourceName() + " to Date: " + locationEvent.getStartDateAsDate());
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(locationEvent, backupResourceName, DateUtils.addDays(locationEvent.getStartDateAsDate(), -1), true), "Move Location Event for: "
                + locationEvent.getResourceName() + " to Date: " + DateUtils.addDays(locationEvent.getStartDateAsDate(), -1));
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
        selectView(employeeScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = employeeSubstitution.clone();

        String sEmployeeSubstitutionUpd = getProperty("sEmployeeSubstitutionUpd");
        updatedAssignment.setResourceName(sEmployeeSubstitutionUpd);

        logCompare(true, b2wScheduler.setSearchValue(employeeSubstitution.getResourceName()), "Set Quick Filter to " + employeeSubstitution.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(employeeSubstitution, updatedAssignment), "Update Employee Substitution from: "
                + employeeSubstitution.getResourceName() + " to : " + updatedAssignment.getResourceName());
        employeeSubstitution = updatedAssignment;
    }
    private void updateEmployeeNeed() {
        selectView(employeeScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = employeeNeed.clone();

        String sEmployeeNeedNameUpd = getProperty("sEmployeeNeedNameUpd");
        String sEmployeeNeedJobSiteNameUpd = getProperty("sEmployeeNeedJobSiteNameUpd");
        String sEmployeeNeedRequestedByUpd = getProperty("sEmployeeNeedRequestedByUpd");
        String sEmployeeNeedNotesTextUpd = getProperty("sEmployeeNeedNotesTextUpd");
        String sEmployeeNeedAssignmentDurationUpd = getProperty("sEmployeeNeedAssignmentDurationUpd");
        String sEmployeeNeedAssignmentStartTimeUpd = getProperty("sEmployeeNeedAssignmentStartTimeUpd");

        updatedAssignment.setResourceName(sEmployeeNeedNameUpd);
        updatedAssignment.setLocationName(sEmployeeNeedJobSiteNameUpd);
        updatedAssignment.setRequestedBy(sEmployeeNeedRequestedByUpd);
        updatedAssignment.setNotes(sEmployeeNeedNotesTextUpd);
        updatedAssignment.setDuration(sEmployeeNeedAssignmentDurationUpd);
        updatedAssignment.setStartTime(sEmployeeNeedAssignmentStartTimeUpd);


        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Quick Filter to " + employeeNeed.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(employeeNeed, updatedAssignment), "Update Employee Need from: "
                + employeeNeed.getResourceName() + " to : " + updatedAssignment.getResourceName());
        employeeNeed = updatedAssignment;
    }
    private void updateEquipmentAssignment() {
        selectView(equipmentScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = equipmentAssignment.clone();

        String sEquipmentNameUpd = getProperty("sEquipmentNameUpd");
        String sEquipmentJobSiteNameUpd = getProperty("sEquipmentJobSiteNameUpd");
        String sEquipmentRequestedByUpd = getProperty("sEquipmentRequestedByUpd");
        String sEquipmentNotesTextUpd = getProperty("sEquipmentNotesTextUpd");
        String sEquipmentAssignmentDurationUpd = getProperty("sEquipmentAssignmentDurationUpd");
        String sEquipmentAssignmentStartTimeUpd = getProperty("sEquipmentAssignmentStartTimeUpd");

        updatedAssignment.setResourceName(sEquipmentNameUpd);
        updatedAssignment.setLocationName(sEquipmentJobSiteNameUpd);
        updatedAssignment.setRequestedBy(sEquipmentRequestedByUpd);
        updatedAssignment.setNotes(sEquipmentNotesTextUpd);
        updatedAssignment.setDuration(sEquipmentAssignmentDurationUpd);
        updatedAssignment.setStartTime(sEquipmentAssignmentStartTimeUpd);


        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Quick Filter to " + equipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(equipmentAssignment, updatedAssignment), "Update Equipment Assignment from: "
                + equipmentAssignment.getResourceName() + " to : " + updatedAssignment.getResourceName());
        equipmentAssignment = updatedAssignment;
    }
    private void updateEquipmentNeed() {
        selectView(equipmentScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = equipmentNeed.clone();

        String sEquipmentNeedNameUpd = getProperty("sEquipmentNeedNameUpd");
        String sEquipmentNeedJobSiteNameUpd = getProperty("sEquipmentNeedJobSiteNameUpd");
        String sEquipmentNeedRequestedByUpd = getProperty("sEquipmentNeedRequestedByUpd");
        String sEquipmentNeedNotesTextUpd = getProperty("sEquipmentNeedNotesTextUpd");
        String sEquipmentNeedAssignmentDurationUpd = getProperty("sEquipmentNeedAssignmentDurationUpd");
        String sEquipmentNeedAssignmentStartTimeUpd = getProperty("sEquipmentNeedAssignmentStartTimeUpd");

        updatedAssignment.setResourceName(sEquipmentNeedNameUpd);
        updatedAssignment.setLocationName(sEquipmentNeedJobSiteNameUpd);
        updatedAssignment.setRequestedBy(sEquipmentNeedRequestedByUpd);
        updatedAssignment.setNotes(sEquipmentNeedNotesTextUpd);
        updatedAssignment.setDuration(sEquipmentNeedAssignmentDurationUpd);
        updatedAssignment.setStartTime(sEquipmentNeedAssignmentStartTimeUpd);

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Quick Filter to " + equipmentNeed.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(equipmentNeed, updatedAssignment), "Update Equipment Need from: "
                + equipmentNeed.getResourceName() + " to : " + updatedAssignment.getResourceName());
        equipmentNeed = updatedAssignment;
    }
    private void updateCrewAssignment() {
        selectView(crewsScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = crewAssignment.clone();

        String sCrewNameUpd = getProperty("sCrewNameUpd");
        String sCrewJobSiteNameUpd = getProperty("sCrewJobSiteNameUpd");
        String sCrewRequestedByUpd = getProperty("sCrewRequestedByUpd");
        String sCrewNotesTextUpd = getProperty("sCrewNotesTextUpd");
        String sCrewAssignmentDurationUpd = getProperty("sCrewAssignmentDurationUpd");
        String sCrewAssignmentStartTimeUpd = getProperty("sCrewAssignmentStartTimeUpd");

        updatedAssignment.setResourceName(sCrewNameUpd);
        updatedAssignment.setLocationName(sCrewJobSiteNameUpd);
        updatedAssignment.setRequestedBy(sCrewRequestedByUpd);
        updatedAssignment.setNotes(sCrewNotesTextUpd);
        updatedAssignment.setDuration(sCrewAssignmentDurationUpd);
        updatedAssignment.setStartTime(sCrewAssignmentStartTimeUpd);

        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Quick Filter to " + crewAssignment.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(crewAssignment, updatedAssignment), "Update Crew Assignment from: "
                + crewAssignment.getResourceName() + " to : " + updatedAssignment.getResourceName());
        crewAssignment = updatedAssignment;
    }
    private void updateCrewNeed() {
        selectView(crewsScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = crewNeed.clone();

        String sCrewNeedNameUpd = getProperty("sCrewNeedNameUpd");
        String sCrewNeedJobSiteNameUpd = getProperty("sCrewNeedJobSiteNameUpd");
        String sCrewNeedRequestedByUpd = getProperty("sCrewNeedRequestedByUpd");
        String sCrewNeedNotesTextUpd = getProperty("sCrewNeedNotesTextUpd");
        String sCrewNeedAssignmentDurationUpd = getProperty("sCrewNeedAssignmentDurationUpd");
        String sCrewNeedAssignmentStartTimeUpd = getProperty("sCrewNeedAssignmentStartTimeUpd");

        updatedAssignment.setResourceName(sCrewNeedNameUpd);
        updatedAssignment.setLocationName(sCrewNeedJobSiteNameUpd);
        updatedAssignment.setRequestedBy(sCrewNeedRequestedByUpd);
        updatedAssignment.setNotes(sCrewNeedNotesTextUpd);
        updatedAssignment.setDuration(sCrewNeedAssignmentDurationUpd);
        updatedAssignment.setStartTime(sCrewNeedAssignmentStartTimeUpd);

        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Quick Filter to " + crewNeed.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(crewNeed, updatedAssignment), "Update Crew Need from: "
                + crewNeed.getResourceName() + " to : " + updatedAssignment.getResourceName());
        crewNeed = updatedAssignment;
    }
    private void updateMoveAssignment() {
        selectView(equipmentScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = moveAssignment.clone();

        String sMoveAssignmentEquipmentNameUpd = getProperty("sMoveAssignmentEquipmentNameUpd");

        String sMoveAssignmentPickupLocationTypeUpd = getProperty("sMoveAssignmentPickupLocationTypeUpd");
        String sMoveAssignmentPickupLocationNameUpd = getProperty("sMoveAssignmentPickupLocationNameUpd");
        String sMoveAssignmentPickupDateUpd = getProperty("sMoveAssignmentPickupDateUpd");
        String sMoveAssignmentPickupTimeUpd = getProperty("sMoveAssignmentPickupTimeUpd");

        String sMoveAssignmentDropoffLocationTypeUpd = getProperty("sMoveAssignmentDropoffLocationTypeUpd");
        String sMoveAssignmentDropoffLocationNameUpd = getProperty("sMoveAssignmentDropoffLocationNameUpd");
        String sMoveAssignmentDropoffDateUpd = getProperty("sMoveAssignmentDropoffDateUpd");
        String sMoveAssignmentDropoffTimeUpd = getProperty("sMoveAssignmentDropoffTimeUpd");

        String sMoveAssignmentRequestedByUpd = getProperty("sMoveAssignmentRequestedByUpd");
        String sMoveAssignmentNotesTextUpd = getProperty("sMoveAssignmentNotesTextUpd");
        String sMoveAssignmentTransportationCrewNameUpd = getProperty("sMoveAssignmentTransportationCrewNameUpd");

        updatedAssignment.setResourceName(sMoveAssignmentEquipmentNameUpd);

        updatedAssignment.setPickupLocationType(sMoveAssignmentPickupLocationTypeUpd);
        updatedAssignment.setPickupLocation(sMoveAssignmentPickupLocationNameUpd);
        updatedAssignment.setPickupDate(StringUtils.getDateFromStringWithPattern(sMoveAssignmentPickupDateUpd, "M/d/yyyy"));
        updatedAssignment.setPickupTime(sMoveAssignmentPickupTimeUpd);

        updatedAssignment.setDropoffLocationType(sMoveAssignmentDropoffLocationTypeUpd);
        updatedAssignment.setDropoffLocation(sMoveAssignmentDropoffLocationNameUpd);
        updatedAssignment.setDropoffDate(StringUtils.getDateFromStringWithPattern(sMoveAssignmentDropoffDateUpd, "M/d/yyyy"));
        updatedAssignment.setDropoffTime(sMoveAssignmentDropoffTimeUpd);

        updatedAssignment.setRequestedBy(sMoveAssignmentRequestedByUpd);
        updatedAssignment.setNotes(sMoveAssignmentNotesTextUpd);

        updatedAssignment.setTransportationCrew(sMoveAssignmentTransportationCrewNameUpd);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Quick Filter to " + moveAssignment.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(moveAssignment, updatedAssignment), "Update Move Assignment from: "
                + moveAssignment.getResourceName() + " to : " + updatedAssignment.getResourceName());
        moveAssignment = updatedAssignment;
    }
    private void updateMoveOrder() {
        selectView(equipmentScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = moveOrder.clone();

        String sMoveOrderPickupLocationTypeUpd = getProperty("sMoveOrderPickupLocationTypeUpd");
        String sMoveOrderPickupLocationNameUpd = getProperty("sMoveOrderPickupLocationNameUpd");
        String sMoveOrderPickupDateUpd = getProperty("sMoveOrderPickupDateUpd");
        String sMoveOrderPickupTimeUpd = getProperty("sMoveOrderPickupTimeUpd");

        String sMoveOrderDropoffLocationTypeUpd = getProperty("sMoveOrderDropoffLocationTypeUpd");
        String sMoveOrderDropoffLocationNameUpd = getProperty("sMoveOrderDropoffLocationNameUpd");
        String sMoveOrderDropoffDateUpd = getProperty("sMoveOrderDropoffDateUpd");
        String sMoveOrderDropoffTimeUpd = getProperty("sMoveOrderDropoffTimeUpd");

        String sMoveOrderRequestedByUpd = getProperty("sMoveOrderRequestedByUpd");
        String sMoveOrderNotesTextUpd = getProperty("sMoveOrderNotesTextUpd");

        updatedAssignment.setPickupLocationType(sMoveOrderPickupLocationTypeUpd);
        updatedAssignment.setPickupLocation(sMoveOrderPickupLocationNameUpd);
        updatedAssignment.setPickupDate(StringUtils.getDateFromStringWithPattern(sMoveOrderPickupDateUpd, "M/d/yyyy"));
        updatedAssignment.setPickupTime(sMoveOrderPickupTimeUpd);

        updatedAssignment.setDropoffLocationType(sMoveOrderDropoffLocationTypeUpd);
        updatedAssignment.setDropoffLocation(sMoveOrderDropoffLocationNameUpd);
        updatedAssignment.setDropoffDate(StringUtils.getDateFromStringWithPattern(sMoveOrderDropoffDateUpd, "M/d/yyyy"));
        updatedAssignment.setDropoffTime(sMoveOrderDropoffTimeUpd);

        updatedAssignment.setRequestedBy(sMoveOrderRequestedByUpd);
        updatedAssignment.setNotes(sMoveOrderNotesTextUpd);

        logCompare(true, b2wScheduler.setSearchValue(moveOrder.getResourceName()), "Set Quick Filter to " + moveOrder.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(moveOrder, updatedAssignment), "Update Move Order from: "
                + moveOrder.getResourceName() + " to : " + updatedAssignment.getResourceName());
        moveOrder = updatedAssignment;
    }
    private void updateEmployeeEvent() {
        selectView(employeeDefaultScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = employeeEvent.clone();

        String sEmployeeEventNameUpd = getProperty("sEmployeeEventNameUpd");
        String sEmployeeEventTypeUpd = getProperty("sEmployeeEventTypeUpd");
        String sEmployeeEventNotesTextUpd = getProperty("sEmployeeEventNotesTextUpd");
        updatedAssignment.setResourceName(sEmployeeEventNameUpd);
        updatedAssignment.setLocationName(sEmployeeEventTypeUpd);
        updatedAssignment.setNotes(sEmployeeEventNotesTextUpd);

        logCompare(true, b2wScheduler.setSearchValue(employeeEvent.getResourceName()), "Set Quick Filter to " + employeeEvent.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(employeeEvent, updatedAssignment), "Update Employee Event from: "
                + employeeEvent.getResourceName() + " to : " + updatedAssignment.getResourceName());
        employeeEvent = updatedAssignment;
    }
    private void updateEquipmentEvent() {
        selectView(equipmentDefaultScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = equipmentEvent.clone();

        String sEquipmentEventNameUpd = getProperty("sEquipmentEventNameUpd");
        String sEquipmentEventTypeUpd = getProperty("sEquipmentEventTypeUpd");
        String sEquipmentEventNotesTextUpd = getProperty("sEquipmentEventNotesTextUpd");
        updatedAssignment.setResourceName(sEquipmentEventNameUpd);
        updatedAssignment.setLocationName(sEquipmentEventTypeUpd);
        updatedAssignment.setNotes(sEquipmentEventNotesTextUpd);

        logCompare(true, b2wScheduler.setSearchValue(equipmentEvent.getResourceName()), "Set Quick Filter to " + equipmentEvent.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(equipmentEvent, updatedAssignment), "Update Equipment Event from: "
                + equipmentEvent.getResourceName() + " to : " + updatedAssignment.getResourceName());
        equipmentEvent = updatedAssignment;
    }
    private void updateLocationEvent() {
        selectView(locationDefaultScheduleView);

        B2WAssignment updatedAssignment;
        updatedAssignment = locationEvent.clone();

        String sLocationEventNameUpd = getProperty("sLocationEventNameUpd");
        String sLocationEventTypeUpd = getProperty("sLocationEventTypeUpd");
        String sLocationEventNotesTextUpd = getProperty("sLocationEventNotesTextUpd");
        updatedAssignment.setResourceName(sLocationEventNameUpd);
        updatedAssignment.setLocationName(sLocationEventTypeUpd);
        updatedAssignment.setNotes(sLocationEventNotesTextUpd);

        logCompare(true, b2wScheduler.setSearchValue(locationEvent.getResourceName()), "Set Quick Filter to " + locationEvent.getResourceName());
        logCompare(true, b2wScheduler.updateAssignment(locationEvent, updatedAssignment), "Update Location Event from: "
                + locationEvent.getResourceName() + " to : " + updatedAssignment.getResourceName());
        locationEvent = updatedAssignment;
    }

    private void copyEmployeeAssignment() {
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Quick Filter to " + employeeAssignment.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(employeeAssignment), "Copy Employee Assignment : " + employeeAssignment.getResourceName())) {
            copyEmployeeAssignment = employeeAssignment.clone();
        }
    }
    private void copyEmployeeNeed() {
        selectView(employeeScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Quick Filter to " + employeeNeed.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(employeeNeed), "Copy Employee Need : " + employeeNeed.getResourceName())) {
            copyEmployeeNeed = employeeNeed.clone();
        }
    }
    private void copyEquipmentAssignment() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Quick Filter to " + equipmentAssignment.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(equipmentAssignment), "Copy Equipment Assignment : " + equipmentAssignment.getResourceName())) {
            copyEquipmentAssignment = equipmentAssignment.clone();
        }
    }
    private void copyEquipmentNeed() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Quick Filter to " + equipmentNeed.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(equipmentNeed), "Copy Equipment Need : " + equipmentNeed.getResourceName())) {
            copyEquipmentNeed = equipmentNeed.clone();
        }
    }
    private void copyCrewAssignment() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewAssignment.getResourceName()), "Set Quick Filter to " + crewAssignment.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(crewAssignment), "Copy Crew Assignment : " + crewAssignment.getResourceName())) {
            copyCrewAssignment = crewAssignment.clone();
        }
    }
    private void copyCrewNeed() {
        selectView(crewsScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(crewNeed.getResourceName()), "Set Quick Filter to " + crewNeed.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(crewNeed), "Copy Equipment Need : " + crewNeed.getResourceName())) {
            copyCrewNeed = crewNeed.clone();
        }
    }
    private void copyMoveAssignment() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveAssignment.getResourceName()), "Set Quick Filter to " + moveAssignment.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(moveAssignment), "Copy Move Assignment : " + moveAssignment.getResourceName())) {
            copyMoveAssignment = moveAssignment.clone();
        }
    }
    private void copyMoveOrder() {
        selectView(equipmentScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(moveOrder.getResourceName()), "Set Quick Filter to " + moveOrder.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(moveOrder), "Copy Move Order : " + moveOrder.getResourceName())) {
            copyMoveOrder = moveOrder.clone();
        }
        if (logCompare(true, b2wScheduler.copyAssignment(moveOrder), "Copy Move Order : " + moveOrder.getResourceName())) {
            copyMoveOrder1 = moveOrder.clone();
        }
    }
    private void copyEmployeeEvent() {
        selectView(employeeDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(employeeEvent.getResourceName()), "Set Quick Filter to " + employeeEvent.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(employeeEvent), "Copy Employee Event : " + employeeEvent.getResourceName())) {
            copyEmployeeEvent = employeeEvent.clone();
        }
    }
    private void copyEquipmentEvent() {
        selectView(equipmentDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(equipmentEvent.getResourceName()), "Set Quick Filter to " + equipmentEvent.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(equipmentEvent), "Copy Equipment Event : " + equipmentEvent.getResourceName())) {
            copyEquipmentEvent = equipmentEvent.clone();
        }
    }
    private void copyLocationEvent() {
        selectView(locationDefaultScheduleView);

        logCompare(true, b2wScheduler.setSearchValue(locationEvent.getResourceName()), "Set Quick Filter to " + locationEvent.getResourceName());
        if (logCompare(true, b2wScheduler.copyAssignment(locationEvent), "Copy Location Event : " + locationEvent.getResourceName())) {
            copyLocationEvent = locationEvent.clone();
        }
    }

    private void resolveEmployeeConflict() {
        selectView(employeeScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        logCompare(true, b2wScheduler.setSearchValue(copyEmployeeAssignment.getResourceName()), "Set Quick Filter to " + copyEmployeeAssignment.getResourceName());
        logCompare(true, true, "====== Start resolving Employee Conflicts for " + copyEmployeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.conflictIconIsDisplayed(copyEmployeeAssignment), "Check that Conflict Icon is displayed.");
        logCompare(true, b2wScheduler.openConflictPanel(), "Open conflict panel.");
        logCompare(true, b2wScheduler.resolveConflict(copyEmployeeAssignment), "Resolve conflict.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete resolving Employee Conflicts for " + copyEmployeeAssignment.getResourceName());
    }
    private void resolveEquipmentConflict() {
        selectView(equipmentScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        logCompare(true, b2wScheduler.setSearchValue(copyEquipmentAssignment.getResourceName()), "Set Quick Filter to " + copyEquipmentAssignment.getResourceName());
        logCompare(true, true, "====== Start resolving Equipment Conflicts for " + copyEquipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.conflictIconIsDisplayed(copyEquipmentAssignment), "Check that Conflict Icon is displayed.");
        logCompare(true, b2wScheduler.openConflictPanel(), "Open conflict panel.");
        logCompare(true, b2wScheduler.resolveConflict(copyEquipmentAssignment), "Resolve Equipment conflicts.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete resolving Equipment Conflicts for " + copyEquipmentAssignment.getResourceName());
    }
    private void resolveCrewConflict() {
        selectView(crewsScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        logCompare(true, b2wScheduler.setSearchValue(copyCrewAssignment.getResourceName()), "Set Quick Filter to " + copyCrewAssignment.getResourceName());
        logCompare(true, true, "====== Start resolving Crew Conflicts for " + copyCrewAssignment.getResourceName());
        logCompare(true, b2wScheduler.conflictIconIsDisplayed(copyCrewAssignment), "Check that Conflict Icon is displayed.");
        logCompare(true, b2wScheduler.openConflictPanel(), "Open conflict panel.");
        logCompare(true, b2wScheduler.resolveConflict(copyCrewAssignment), "Open conflict panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete resolving Crew Conflicts for " + copyCrewAssignment.getResourceName());
    }
    private void resolveMoveAssignmentsConflict() {
        selectView(equipmentScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        logCompare(true, b2wScheduler.setSearchValue(copyMoveAssignment.getResourceName()), "Set Quick Filter to " + copyMoveAssignment.getResourceName());
        logCompare(true, true, "====== Start resolving Move Assignment Conflicts for " + copyMoveAssignment.getResourceName());
        logCompare(true, b2wScheduler.conflictIconIsDisplayed(copyMoveAssignment), "Check that Conflict Icon is displayed.");
        logCompare(true, b2wScheduler.openConflictPanel(), "Open conflict panel.");
        logCompare(true, b2wScheduler.resolveConflict(copyMoveAssignment), "Open conflict panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete resolving Move Assignment Conflicts for " + copyMoveAssignment.getResourceName());
    }
    private void resolveEmployeeEventConflict() {
        selectView(employeeDefaultScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        logCompare(true, b2wScheduler.setSearchValue(copyEmployeeEvent.getResourceName()), "Set Quick Filter to " + copyEmployeeEvent.getResourceName());
        logCompare(true, true, "====== Start resolving Employee Event Conflicts for " + copyEmployeeEvent.getResourceName());
        logCompare(true, b2wScheduler.conflictIconIsDisplayed(copyEmployeeEvent), "Check that Conflict Icon is displayed.");
        logCompare(true, b2wScheduler.openConflictPanel(), "Open conflict panel.");
        logCompare(true, b2wScheduler.resolveConflict(copyEmployeeEvent), "Open conflict panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete resolving Employee Event Conflicts for " + copyEmployeeEvent.getResourceName());
    }
    private void resolveEquipmentEventConflict() {
        selectView(equipmentDefaultScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        logCompare(true, b2wScheduler.setSearchValue(copyEquipmentEvent.getResourceName()), "Set Quick Filter to " + copyEquipmentEvent.getResourceName());
        logCompare(true, true, "====== Start resolving Equipment Event Conflicts for " + copyEquipmentEvent.getResourceName());
        logCompare(true, b2wScheduler.conflictIconIsDisplayed(copyEquipmentEvent), "Check that Conflict Icon is displayed.");
        logCompare(true, b2wScheduler.openConflictPanel(), "Open conflict panel.");
        logCompare(true, b2wScheduler.resolveConflict(copyEquipmentEvent), "Open conflict panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete resolving Equipment Event Conflicts for " + copyEquipmentEvent.getResourceName());
    }

    //=== Order Panel
    private void verifyEmployeeNeedOrder() {
        selectView(employeeDefaultScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        String sEmployeeFillNeedName = getProperty("sEmployeeFillNeedName");
        String sEmployeeDragNeedName = getProperty("sEmployeeDragNeedName");

        //logCompare(true, b2wScheduler.setSearchValue(copyEmployeeNeed.getResourceName()), "Set Quick Filter to " + copyEmployeeNeed.getResourceName());
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search box.");
        logCompare(true, true, "====== Start fill Employee Need " + copyEmployeeNeed.getResourceName() + " from Order Panel");
        logCompare(true, b2wScheduler.warningIconIsDisplayed(copyEmployeeNeed.getResourceName()), "Verify that Warning Icon is displayed for Resource.");
        logCompare(true, b2wScheduler.openOrderPanel(), "Open Order panel.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyEmployeeNeed.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDelete(copyEmployeeNeed), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(employeeNeed.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByFill(employeeNeed, sEmployeeFillNeedName), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(employeeNeed1.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDrag(employeeNeed1, sEmployeeDragNeedName), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.isOrderPanelEmpty(), "Check that there are no more orders in the panel.");
        logCompare(false, b2wScheduler.warningIconIsDisplayed(copyEmployeeNeed.getResourceName()), "Verify that Warning Icon is not displayed for Resource.");
        logCompare(true, b2wScheduler.closeConflictPanel(), "Close the Order Panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete fill Employee Need for " + copyEmployeeNeed.getResourceName());
    }
    private void verifyEquipmentNeedOrder() {
        selectView(equipmentDefaultScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        String sEquipmentFillNeedName = getProperty("sEquipmentFillNeedName");
        String sEquipmentDragNeedName = getProperty("sEquipmentDragNeedName");

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search box.");
        logCompare(true, true, "====== Start fill Equipment Need " + copyEquipmentNeed.getResourceName() + " from Order Panel");
        logCompare(true, b2wScheduler.warningIconIsDisplayed(copyEquipmentNeed.getResourceName()), "Verify that Warning Icon is displayed for Resource.");
        logCompare(true, b2wScheduler.openOrderPanel(), "Open Order panel.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyEquipmentNeed.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDelete(copyEquipmentNeed), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(equipmentNeed1.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByFill(equipmentNeed1, sEquipmentFillNeedName), "Resolve Need on Order Panel by deletion.");
        String tmpResourceName = equipmentNeed.getResourceName();
        logCompare(true, b2wScheduler.setOrdersFilter(tmpResourceName), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDrag(equipmentNeed, sEquipmentDragNeedName), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyEquipmentNeed.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.isOrderPanelEmpty(), "Check that there are no more orders in the panel.");
        logCompare(true, b2wScheduler.setOrdersFilter(tmpResourceName), "Set Filter on the Order panel.");
        //ToDo: Investigate Why 3 Orders are displayed in the Panel.
        //logCompare(true, b2wScheduler.isOrderPanelEmpty(), "Check that there are no more orders in the panel.");
        logCompare(false, b2wScheduler.warningIconIsDisplayed(copyEquipmentNeed.getResourceName()), "Verify that Warning Icon is not displayed for Resource.");
        logCompare(true, b2wScheduler.closeConflictPanel(), "Close the Order Panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete fill Equipment Need for " + copyEquipmentNeed.getResourceName());
    }
    private void verifyCrewNeedOrder() {
        selectView(crewsDefaultScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        String sCrewFillNeedName = getProperty("sCrewFillNeedName");
        String sCrewDragNeedName = getProperty("sCrewDragNeedName");

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search box.");
        logCompare(true, true, "====== Start fill Crew Need " + copyCrewNeed.getResourceName() + " from Order Panel");
        logCompare(true, b2wScheduler.warningIconIsDisplayed(copyCrewNeed.getResourceName()), "Verify that Warning Icon is displayed for Resource.");
        logCompare(true, b2wScheduler.openOrderPanel(), "Open Order panel.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyCrewNeed.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDelete(copyCrewNeed), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(crewNeed1.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByFill(crewNeed1, sCrewFillNeedName), "Resolve Need on Order Panel by deletion.");
        String tmpResourceName = crewNeed.getResourceName();
        logCompare(true, b2wScheduler.setOrdersFilter(tmpResourceName), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDrag(crewNeed, sCrewDragNeedName), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyCrewNeed.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.isOrderPanelEmpty(), "Check that there are no more orders in the panel.");
        logCompare(true, b2wScheduler.setOrdersFilter(tmpResourceName), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.isOrderPanelEmpty(), "Check that there are no more orders in the panel.");
        logCompare(false, b2wScheduler.warningIconIsDisplayed(copyCrewNeed.getResourceName()), "Verify that Warning Icon is not displayed for Resource.");
        logCompare(true, b2wScheduler.closeConflictPanel(), "Close the Order Panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete fill Crew Need for " + copyCrewNeed.getResourceName());
    }
    private void verifyMoveOrderOrder() {
        selectView(equipmentDefaultScheduleView);
        logCompare(true, b2wScheduler.collapseCalendarPanel(), "Collapse Calendar Panel.");

        String sMoveOrderFillNeedName = getProperty("sMoveOrderFillNeedName");
        String sMoveOrderNeedName = getProperty("sMoveOrderNeedName");

        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search box.");
        logCompare(true, true, "====== Start fill Move Order Need " + copyMoveOrder.getResourceName() + " from Order Panel");
        logCompare(true, b2wScheduler.openOrderPanel(), "Open Order panel.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyMoveOrder.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDelete(copyMoveOrder), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyMoveOrder1.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByFill(copyMoveOrder1, sMoveOrderFillNeedName), "Resolve Need on Order Panel by deletion.");
        String tmpResourceName = moveOrder.getResourceName();
        logCompare(true, b2wScheduler.setOrdersFilter(tmpResourceName), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.resolveOrderByDrag(moveOrder, sMoveOrderNeedName), "Resolve Need on Order Panel by deletion.");
        logCompare(true, b2wScheduler.setOrdersFilter(copyMoveOrder.getResourceName()), "Set Filter on the Order panel.");
        logCompare(true, b2wScheduler.isOrderPanelEmpty(), "Check that there are no more orders in the panel.");
        logCompare(true, b2wScheduler.closeConflictPanel(), "Close the Order Panel.");
        logCompare(true, b2wScheduler.expandCalendarPanel(), "Expand Calendar Panel.");
        logCompare(true, true, "====== Complete fill Move Order Need for " + copyMoveOrder.getResourceName());
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
        logCompare(true, b2wScheduler.setSearchValue(copyMoveOrder1.getResourceName()), "Set Filter by " + moveOrder.getResourceName());
        logCompare(true, b2wScheduler.deleteAssignment(copyMoveOrder1), "Delete Move Order for: " + moveOrder.getResourceName());
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