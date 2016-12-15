package testcases;

import com.b2w.test.B2WTestCase;
import tasks.B2WNavigationTasks;
import tasks.scheduler.*;
import tasks.setup.B2WSchedulesTasksTest;
import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleAssignmentsTest extends B2WTestCase {

    private final B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    private final B2WSchedulerTasksTest b2wScheduler = new B2WSchedulerTasksTest();
    private final B2WSchedulesTasksTest b2wSchedulesTasks = new B2WSchedulesTasksTest();

    // Property
    // Schedule Setup
    private String sScheduleName;
    private String sBU;
    private String sSchedulesNotes;
    private String sScheduleFormatResourceListing;
    private String sScheduleFormatLocationView;
    private String sScheduleFormatCrewView;
    private String sGroupingLevel1;
    private String sGroupingLevel2;
    private String sSecurityRole;
    private String sFilterType;
    private String sFilterValue;

    // Schedule View
    B2WScheduleView employeeDefaultScheduleView;
    B2WScheduleView equipmentDefaultScheduleView;
    B2WScheduleView crewsDefaultScheduleView;
    B2WScheduleView locationDefaultScheduleView;

    B2WScheduleView employeeScheduleView;
    B2WScheduleView equipmentScheduleView;
    B2WScheduleView crewsScheduleView;
    B2WScheduleView locationScheduleView;

    private String sEmployeeScheduleViewName;
    private String sEquipmentScheduleViewName;
    private String sCrewScheduleViewName;
    private String sLocationScheduleViewName;
    private String sCalendarDateRange;
    private String sCalendarStartDate;
    //private Date dCalendarStartDate;
    private String sDefaultEmployeeView;
    private String sDefaultEquipmentView;
    private String sDefaultCrewView;
    private String sDefaultLocationView;

    // Assignment - General Values
    private String sJobSiteName;
    private String sJobSiteNameUpd;
    private String sRequestedBy;
    private String sRequestedByUpd;
    private String sNotesText;
    private String sNotesTextUpd;
    private String sAssignmentDuration;
    private String sAssignmentDurationUpd;
    private String sEventDuration;
    private String sAssignmentStartTime;
    private String sEventStartTime;
    private String sAssignmentStartTimeUpd;
    private String sMoveDate;
    private Date dMoveDate;

    // Employee
    private String sEmployeeName;
    private String sEmployeeNameForSubstitution;
    private String sEmployeeSubstitution;
    private String sEmployeeNameUpd;
    private String sEmployeeNeedName;
    private String sEmployeeNeedName1;
    private String sEmployeeNeedNameUpd;

    // Equipment
    private String sEquipmentName;
    private String sEquipmentNameUpd;
    private String sEquipmentNeedName;
    private String sEquipmentNeedNameUpd;

    // Crew
    private String sCrewName;
    private String sCrewNameUpd;
    private String sCrewNeedName;
    private String sCrewNeedNameUpd;

    // Move
    private String sPickupJobSiteName;
    private String sPickupJobSiteNameUpd;
    private String sDropoffJobSiteName;
    private String sDropoffJobSiteNameUpd;
    private String sTransportationCrewName;
    private String sTransportationCrewNameUpd;
    private String sPickupDate;
    private String sPickupTime;
    private String sDropoffDate;
    private String sDropoffTime;

    // Event
    private String sEmployeeEventType;
    private String sEmployeeEventTypeUpd;
    private String sEquipmentEventType;
    private String sEquipmentEventTypeUpd;
    private String sLocationEventType;
    private String sLocationEventTypeUpd;

    // Conflict
    private String sConflictEmployeeName;
    private String sConflictEquipmentName;
    private String sConflictCrewName;
    private String sConflictJobSite;
    private String sConflictEmployeeEventType;
    private String sConflictEquipmentEventType;


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

        // === Read Properties
        //Schedule Setup
        sScheduleName = getProperty("sScheduleName");
        sBU = getProperty("sBU");
        sSchedulesNotes = getProperty("sSchedulesNotes");
        sScheduleFormatResourceListing = getProperty("sScheduleFormatResourceListing");
        sScheduleFormatLocationView = getProperty("sScheduleFormatLocationView");
        sScheduleFormatCrewView = getProperty("sScheduleFormatCrewView");

        sGroupingLevel1 = getProperty("sGroupingLevel1");
        sGroupingLevel2 = getProperty("sGroupingLevel2");
        sFilterType = getProperty("sFilterType");
        sFilterValue = getProperty("sFilterValue");
        sSecurityRole = getProperty("sSecurityRole");

        //Schedule View
        sEmployeeScheduleViewName = sScheduleName + " - Employees - " + n;
        sEquipmentScheduleViewName = sScheduleName + " - Equipment - " + n;
        sCrewScheduleViewName = sScheduleName + " - Crews - " + n;
        sLocationScheduleViewName = sScheduleName + " - Location - " + n;
        sDefaultEmployeeView = getProperty("sDefaultEmployeeView");
        sDefaultEquipmentView = getProperty("sDefaultEquipmentView");
        sDefaultCrewView = getProperty("sDefaultCrewView");
        sDefaultLocationView = getProperty("sDefaultLocationView");

        sJobSiteName = getProperty("sJobSiteName");
        sJobSiteNameUpd = getProperty("sJobSiteNameUpd");

        sRequestedBy = getProperty("sRequestedBy");
        sRequestedByUpd = getProperty("sRequestedByUpd");

        sEmployeeName = getProperty("sEmployeeName");
        sEmployeeNameUpd = getProperty("sEmployeeNameUpd");

        sEmployeeNameForSubstitution = getProperty("sEmployeeNameForSubstitution");
        sEmployeeSubstitution = getProperty("sEmployeeSubstitution");

        sEmployeeNeedName = getProperty("sEmployeeNeedName");
        sEmployeeNeedName1 = getProperty("sEmployeeNeedName1");
        sEmployeeNeedNameUpd = getProperty("sEmployeeNeedNameUpd");

        sEquipmentName = getProperty("sEquipmentName");
        sEquipmentNameUpd = getProperty("sEquipmentNameUpd");

        sEquipmentNeedName = getProperty("sEquipmentNeedName");
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

        sNotesText = getProperty("sNotesText");
        sNotesTextUpd = sNotesText + " UPD";

        sAssignmentDuration = getProperty("sAssignmentDuration");
        sAssignmentDurationUpd = getProperty("sAssignmentDurationUpd");
        sEventDuration = "0 HR";

        sAssignmentStartTime = getProperty("sAssignmentStartTime");
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

        employeeScheduleView = prepareEmployeeScheduleView(sScheduleFormatResourceListing);
        employeeScheduleView.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
        employeeScheduleView.setDuration(sCalendarDateRange);

        employeeDefaultScheduleView = employeeScheduleView.clone();
        employeeDefaultScheduleView.setName(sDefaultEmployeeView);

        equipmentScheduleView = prepareEquipmentScheduleView(sScheduleFormatResourceListing);
        equipmentScheduleView.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
        equipmentScheduleView.setDuration(sCalendarDateRange);

        equipmentDefaultScheduleView = equipmentScheduleView.clone();
        equipmentDefaultScheduleView.setName(sDefaultEquipmentView);

        crewsScheduleView = prepareCrewsScheduleView(sScheduleFormatCrewView);
        crewsScheduleView.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
        crewsScheduleView.setDuration(sCalendarDateRange);

        crewsDefaultScheduleView = crewsScheduleView.clone();
        crewsDefaultScheduleView.setName(sDefaultCrewView);

        locationScheduleView = prepareLocationScheduleView(sScheduleFormatLocationView);
        locationScheduleView.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
        locationScheduleView.setDuration(sCalendarDateRange);

        locationDefaultScheduleView = locationScheduleView.clone();
        locationDefaultScheduleView.setName(sDefaultLocationView);
    }

    public void testMain() throws Throwable {
        // === Create Schedule View
        b2wSchedulesTasks.createScheduleView(employeeScheduleView);
        b2wSchedulesTasks.createScheduleView(equipmentScheduleView);
        /*
        b2wSchedulesTasks.createScheduleView(crewsScheduleView);
        b2wSchedulesTasks.createScheduleView(locationScheduleView);
        */

        // === Employee Assignment tests
        ArrayList<Date> dateList = new ArrayList<Date>();
        dateList.add(employeeScheduleView.getStartDate()); //Start Date
        dateList.add(employeeScheduleView.getStartDate()); //End Date
        B2WAssignment employeeAssignment = new B2WAssignment(B2WAssignmentType.EMPLOYEE_TYPE, sEmployeeName, sJobSiteName, sRequestedBy, sNotesText,
                dateList, sAssignmentStartTime, sAssignmentDuration);
        B2WAssignment employeeNeed = new B2WAssignment(B2WAssignmentType.EMPLOYEE_NEED_TYPE, sEmployeeNeedName, sJobSiteName, sRequestedBy, sNotesText,
                dateList, sAssignmentStartTime, sAssignmentDuration);
        B2WAssignment employeeAssignmentForSubstitution = new B2WAssignment(B2WAssignmentType.EMPLOYEE_TYPE, sEmployeeNameForSubstitution, sJobSiteName, sRequestedBy, sNotesText,
                dateList, sAssignmentStartTime, sAssignmentDuration);

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateTo(employeeScheduleView), "Open " + employeeScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(employeeScheduleView), "Set " + employeeScheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(employeeScheduleView), "Set Start Date to " + employeeScheduleView.getStartDate());
        //logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Filter by " + employeeAssignment.getResourceName());
        //logCompare(true, b2wScheduler.createEmployeeAssignment(employeeAssignment), "Create Assignment for: " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.setSearchValue(employeeAssignmentForSubstitution.getResourceName()), "Set Filter by " + employeeAssignmentForSubstitution.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeAssignment(employeeAssignmentForSubstitution), "Create Assignment for: " + employeeAssignmentForSubstitution.getResourceName());
        logCompare(true, b2wScheduler.navigateTo(employeeDefaultScheduleView), "Open " + employeeDefaultScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.createEmployeeSubstitution(employeeAssignmentForSubstitution, sEmployeeSubstitution), "Create Assignment for: " + employeeAssignmentForSubstitution.getResourceName());

        // === Employee Need Tests
        logCompare(true, b2wScheduler.setSearchValue(employeeNeed.getResourceName()), "Set Filter by " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeNeed(employeeNeed), "Create Assignment for: " + employeeNeed.getResourceName());


        // === Equipment Assignment tests
        B2WAssignment equipmentAssignment = new B2WAssignment(B2WAssignmentType.EQUIPMENT_TYPE, sEquipmentName, sJobSiteName, sRequestedBy, sNotesText,
                dateList, sAssignmentStartTime, sAssignmentDuration);
        B2WAssignment equipmentNeed = new B2WAssignment(B2WAssignmentType.EQUIPMENT_NEED_TYPE, sEquipmentNeedName, sJobSiteName, sRequestedBy, sNotesText,
                dateList, sAssignmentStartTime, sAssignmentDuration);

        logCompare(true, b2wScheduler.navigateTo(equipmentScheduleView), "Open " + equipmentScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(equipmentScheduleView), "Set " + equipmentScheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(equipmentScheduleView), "Set Start Date to " + equipmentScheduleView.getStartDate());
        logCompare(true, b2wScheduler.setSearchValue(equipmentAssignment.getResourceName()), "Set Filter by " + equipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.createEquipmentAssignment(equipmentAssignment), "Create Assignment for: " + equipmentAssignment.getResourceName());
        logCompare(true, b2wScheduler.setSearchValue(equipmentNeed.getResourceName()), "Set Filter by " + equipmentNeed.getResourceName());
        logCompare(true, b2wScheduler.createEquipmentNeed(equipmentNeed), "Create Assignment for: " + equipmentNeed.getResourceName());
    }

    private B2WScheduleView prepareEmployeeScheduleView(String sScheduleFormat) {
        // Prepare Schedule Items based on Schedule Format
        ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sScheduleFormat);
        item.setResourceName("Employees");
        itemList.add(item);

        // Prepare Filters List
        ArrayList<String[]> filters = new ArrayList<String[]>();
        String[] filterItem = new String[2];
        filterItem[0] = sFilterType;
        filterItem[1] = sFilterValue;
        filters.add(filterItem);

        // Prepare Roles list
        ArrayList<String> roles = new ArrayList<String>();
        roles.add(sSecurityRole);

        // Prepare Users list
        ArrayList<String> users = new ArrayList<String>();

        return new B2WScheduleView(sEmployeeScheduleViewName, sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
                filters, roles, users);
    }

    private B2WScheduleView prepareEquipmentScheduleView(String sScheduleFormat) {
        // Prepare Schedule Items based on Schedule Format
        ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sScheduleFormat);
        item.setResourceName("Equipment");
        itemList.add(item);

        // Prepare Filters List
        ArrayList<String[]> filters = new ArrayList<String[]>();
        String[] filterItem = new String[2];
        filterItem[0] = sFilterType;
        filterItem[1] = sFilterValue;
        filters.add(filterItem);

        // Prepare Roles list
        ArrayList<String> roles = new ArrayList<String>();
        roles.add(sSecurityRole);

        // Prepare Users list
        ArrayList<String> users = new ArrayList<String>();

        return new B2WScheduleView(sEquipmentScheduleViewName, sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
                filters, roles, users);
    }

    private B2WScheduleView prepareCrewsScheduleView(String sScheduleFormat) {

        // Prepare Schedule Items based on Schedule Format
        ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sScheduleFormat);
        item.setResourceName("Production Crews");
        itemList.add(item);
        B2WScheduleItem item1 = new B2WScheduleItem();
        item1.setScheduleFormat(sScheduleFormat);
        item1.setResourceName("Transport Crews");
        itemList.add(item1);

        // Prepare Filters List
        ArrayList<String[]> filters = new ArrayList<String[]>();
        String[] filterItem = new String[2];
        filterItem[0] = sFilterType;
        filterItem[1] = sFilterValue;
        filters.add(filterItem);

        // Prepare Roles list
        ArrayList<String> roles = new ArrayList<String>();
        roles.add(sSecurityRole);

        // Prepare Users list
        ArrayList<String> users = new ArrayList<String>();

        return new B2WScheduleView(sCrewScheduleViewName, sBU, sSchedulesNotes, itemList, sGroupingLevel1, sGroupingLevel2,
                filters, roles, users);
    }

    private B2WScheduleView prepareLocationScheduleView(String sScheduleFormat) {
        // Prepare Schedule Items based on Schedule Format
        ArrayList<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sScheduleFormat);
        item.setResourceName("Job Sites");
        itemList.add(item);

        B2WScheduleItem item1 = new B2WScheduleItem();
        item1.setScheduleFormat(sScheduleFormat);
        item1.setResourceName("Places");
        itemList.add(item1);

        // Prepare Filters List
        ArrayList<String[]> filters = new ArrayList<String[]>();
        String[] filterItem = new String[2];
        filterItem[0] = sFilterType;
        filterItem[1] = sFilterValue;
        filters.add(filterItem);

        // Prepare Roles list
        ArrayList<String> roles = new ArrayList<String>();
        roles.add(sSecurityRole);

        // Prepare Users list
        ArrayList<String> users = new ArrayList<String>();

        return new B2WScheduleView(sLocationScheduleViewName, sBU, sSchedulesNotes, itemList, null, "",
                filters, roles, users);
    }

}