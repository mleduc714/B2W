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
    private String sEmployeeScheduleViewName;
    private String sEquipmentScheduleViewName;
    private String sCrewScheduleViewName;
    private String sLocationScheduleViewName;
    private String sCalendarDateRange;
    private String sCalendarStartDate;
    private Date dCalendarStartDate;
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
        dCalendarStartDate = StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy");

        sMoveDate = getProperty("sMoveDate");
        dMoveDate = StringUtils.getDateFromStringWithPattern(sMoveDate, "M/d/yyyy");

        sConflictEmployeeName = getProperty("sConflictEmployeeName");
        sConflictEquipmentName = getProperty("sConflictEquipmentName");
        sConflictCrewName = getProperty("sConflictCrewName");
        sConflictJobSite = getProperty("sConflictJobSite");
        sConflictEmployeeEventType = getProperty("sConflictEmployeeEventType");
        sConflictEquipmentEventType = getProperty("sConflictEquipmentEventType");
    }

    public void testMain() throws Throwable {
        // === Create Schedule View
        B2WScheduleView employeeScheduleView = prepareEmployeeScheduleView(sScheduleFormatResourceListing);
        employeeScheduleView.setStartDate(StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy"));
        employeeScheduleView.setDuration(sCalendarDateRange);

        B2WScheduleView equipmentScheduleView = prepareEquipmentScheduleView(sScheduleFormatResourceListing);
        B2WScheduleView crewsScheduleView = prepareCrewsScheduleView(sScheduleFormatCrewView);
        B2WScheduleView locationScheduleView = prepareLocationScheduleView(sScheduleFormatLocationView);

        b2wSchedulesTasks.createScheduleView(employeeScheduleView);
        /*
        b2wSchedulesTasks.createScheduleView(equipmentScheduleView);
        b2wSchedulesTasks.createScheduleView(crewsScheduleView);
        b2wSchedulesTasks.createScheduleView(locationScheduleView);
        */

        // === Employee Assignment tests
        ArrayList<Date> dateList = new ArrayList<Date>();
        dateList.add(employeeScheduleView.getStartDate()); //Start Date
        dateList.add(employeeScheduleView.getStartDate()); //End Date
        B2WAssignment employeeAssignment = new B2WAssignment(B2WAssignmentType.EMPLOYEE_TYPE, sEmployeeName, sJobSiteName, sRequestedBy, sNotesText,
                dateList, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateTo(employeeScheduleView), "Open " + employeeScheduleView.getName() + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(employeeScheduleView), "Set " + employeeScheduleView.getDuration() + " Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(employeeScheduleView), "Set Start Date to " + employeeScheduleView.getStartDate());
        logCompare(true, b2wScheduler.setSearchValue(employeeAssignment.getResourceName()), "Set Filter by " + employeeAssignment.getResourceName());
        logCompare(true, b2wScheduler.createEmployeeAssignment(employeeAssignment), "Set Filter by " + employeeAssignment.getResourceName());


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