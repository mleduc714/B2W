package testcases;

import com.b2w.test.B2WTestCase;

import org.openqa.selenium.WebElement;
import tasks.B2WNavigationTasks;
import tasks.BrowserUtils;
import tasks.scheduler.B2WSchedulerTasks;
import tasks.setup.B2WSchedulesTasks;
import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleAssignments extends B2WTestCase {

    /*
     * 1. Create New Schedule View
     * 2. Create Employee Assignment
     * 3. Create Equipment Assignment
     * 4. Create Employee Need
     * 5. Create Equipment Need
     * 6. Create Crew Assignment
     * 7. Create Crew Need
     * 8. Create Move Assignment
     * 9. Create Move Order
     * 10. Create Employee Event
     * 11. Create Equipment Event
     * 12. Create Location Event
     *
     */

    B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    B2WSchedulerTasks b2wScheduler = new B2WSchedulerTasks();
    B2WSchedulesTasks b2wSchedulesTasks = new B2WSchedulesTasks();

    // Property
    // Schedule Setup
    String sScheduleName;
    String sBU;
    String sSchedulesNotes;
    String sScheduleFormatResourceListing;
    String sScheduleFormatLocationView;
    String sScheduleFormatCrewView;
    String sGroupingLevel1;
    String sGroupingLevel2;
    String sFilterType;
    String sFilterValue;
    String sSecurityRole;

    // Schedule View
    String sEmployeeView;
    String sEquipmentView;
    String sCrewView;
    String sLocationView;
    String sCalendarDateRange;
    String sCalendarStartDate;
    Date dCalendarStartDate;
    String sDefaultEmployeeView;
    String sDefaultEquipmentView;
    String sDefaultCrewView;
    String sDefaultLocationView;

    // Assignment - General Values
    String sJobSiteName;
    String sJobSiteNameUpd;
    String sRequestedBy;
    String sRequestedByUpd;
    String sNotesText;
    String sNotesTextUpd;
    String sAssignmentDuration;
    String sAssignmentDurationUpd;
    String sAssignmentStartTime;
    String sAssignmentStartTimeUpd;
    String sMoveDate;
    Date dMoveDate;

    // Employee
    String sEmployeeName;
    String sEmployeeNameUpd;
    String sEmployeeNeedName;
    String sEmployeeNeedName1;
    String sEmployeeNeedNameUpd;

    // Equipment
    String sEquipmentName;
    String sEquipmentNameUpd;
    String sEquipmentNeedName;
    String sEquipmentNeedNameUpd;

    // Crew
    String sCrewName;
    String sCrewNameUpd;
    String sCrewNeedName;
    String sCrewNeedNameUpd;

    // Move
    String sPickupJobSiteName;
    String sPickupJobSiteNameUpd;
    String sDropoffJobSiteName;
    String sDropoffJobSiteNameUpd;
    String sTransportationCrewName;
    String sTransportationCrewNameUpd;

    // Event
    String sEmployeeEventType;
    String sEmployeeEventTypeUpd;
    String sEquipmentEventType;
    String sEquipmentEventTypeUpd;
    String sLocationEventType;
    String sLocationEventTypeUpd;


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
        sEmployeeView = sScheduleName + " - Employees - " + n;
        sEquipmentView = sScheduleName + " - Equipment - " + n;
        sCrewView = sScheduleName + " - Crews - " + n;
        sLocationView = sScheduleName + " - Location - " + n;
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

        sAssignmentStartTime = getProperty("sAssignmentStartTime");
        sAssignmentStartTimeUpd = getProperty("sAssignmentStartTimeUpd");

        sCalendarDateRange = getProperty("sCalendarDateRange");

        sCalendarStartDate = getProperty("sCalendarStartDate");
        dCalendarStartDate = StringUtils.getDateFromStringWithPattern(sCalendarStartDate, "M/d/yyyy");

        sMoveDate = getProperty("sMoveDate");
        dMoveDate = StringUtils.getDateFromStringWithPattern(sMoveDate, "M/d/yyyy");
    }

    public void testMain() throws Throwable {

        //=== Setup Schedule View
        createNewEmployeeScheduleView();
        createNewEquipmentScheduleView();
        createNewCrewScheduleView();
        createNewJobSiteScheduleView();

        //=== Create Schedule Assignments
        createEmployeeAssignment();
        createEmployeeNeed();
        createEmployeeNeed(sEmployeeNeedName1, sJobSiteName, sRequestedBy, sNotesText, sAssignmentDuration, sAssignmentStartTime);
        createEquipmentAssignment();
        createEquipmentNeed();
        createEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentDuration, sAssignmentStartTime);
        createCrewAssignment();
        createCrewNeed();
        createCrewNeed(sCrewNeedNameUpd, sJobSiteName, sAssignmentDuration, sAssignmentStartTime);
        createMoveAssignment();
        createMoveOrder();
        createEmployeeEvent();
        createEquipmentEvent();
        createLocationEvent();

        //=== Move Assignments
        moveEmployeeAssignment();
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

        //=== Edit Assignments
        updateEmployeeAssignment();
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

        //=== Delete Assignments
        deleteEmployeeAssignment();
        deleteEmployeeNeed();
        deleteEmployeeNeed(sEmployeeNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        deleteEquipmentAssignment();
        deleteEquipmentNeed();
        deleteEquipmentNeed(sEquipmentNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        deleteCrewAssignment();
        deleteCrewNeed();
        deleteCrewNeed(sCrewNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        deleteMoveAssignment();
        deleteMoveOrder();
        deleteEmployeeEvent();
        deleteEquipmentEvent();
        deleteJobSiteEvent();

        //=== Delete Schedule View
        deleteScheduleView(sEmployeeView);
        deleteScheduleView(sEquipmentView);
        deleteScheduleView(sCrewView);
        deleteScheduleView(sLocationView);
    }

    @Override
    public void testTearDown() throws Throwable {
        super.testTearDown();
    }

    //=== Create Schedule View ===
    public void createNewEmployeeScheduleView() {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Open Create Schedule View dialog.
         * 3. Fill all fields (Name, BU, Notes, Items, Grouping Level1, Grouping Level 2, Filter, Security Roles)
         * 4. Save Schedule View
         * 5. Check that Schedule View has been created.
         */
        String sView = sScheduleFormatResourceListing;
        List<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sView);
        item.setResourceName("Employees");
        itemList.add(item);

        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.clickCreateScheduleViewDialog(), "Open Create Schedule View dialog.");
        logCompare(true, b2wSchedulesTasks.setName(sEmployeeView), "Set Name");
        logCompare(true, b2wSchedulesTasks.setBU(sBU), "Select BU");
        logCompare(true, b2wSchedulesTasks.setNotes(sSchedulesNotes), "Set Notes");
        logCompare(true, b2wSchedulesTasks.setScheduleFormat(sView), "Select Schedule Format");
        logCompare(true, b2wSchedulesTasks.setItems(itemList), "Select Items on Schedule");
        logCompare(true, b2wSchedulesTasks.setGrouping("Group items by", sGroupingLevel1), "Select Grouping item by");
        logCompare(true, b2wSchedulesTasks.setGrouping("Secondary grouping", sGroupingLevel2), "Select Secondary grouping");
        //ToDO: Remove comments after fixing
        //logCompare(true, b2wSchedulesTasks.setFilter(sFilterType, sFilterValue), "Set Filter");
        logCompare(true, b2wSchedulesTasks.setSecurityRole(sSecurityRole), "Select Security Role");
        logCompare(true, b2wSchedulesTasks.saveSchedule(), "Save Employee Schedule View");
        logCompare(true, b2wSchedulesTasks.isScheduleExist(sEmployeeView), "Check that Employee Schedule View has been created.");
    }

    public void createNewEquipmentScheduleView() {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Open Create Schedule View dialog.
         * 3. Fill all fields (Name, BU, Notes, Items, Grouping Level1, Grouping Level 2, Filter, Security Roles)
         * 4. Save Schedule View
         * 5. Check that Schedule View has been created.
         */
        String sView = sScheduleFormatResourceListing;
        List<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sView);
        item.setResourceName("Equipment");
        itemList.add(item);

        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.clickCreateScheduleViewDialog(), "Open Create Schedule View dialog.");
        logCompare(true, b2wSchedulesTasks.setName(sEquipmentView), "Set Name");
        logCompare(true, b2wSchedulesTasks.setBU(sBU), "Select BU");
        logCompare(true, b2wSchedulesTasks.setNotes(sSchedulesNotes), "Set Notes");
        logCompare(true, b2wSchedulesTasks.setScheduleFormat(sView), "Select Schedule Format");
        logCompare(true, b2wSchedulesTasks.setItems(itemList), "Select Items on Schedule");
        logCompare(true, b2wSchedulesTasks.setGrouping("Group items by", sGroupingLevel1), "Select Grouping item by");
        logCompare(true, b2wSchedulesTasks.setGrouping("Secondary grouping", sGroupingLevel2), "Select Secondary grouping");
        //ToDO: Remove comments after fixing
        //logCompare(true, b2wSchedulesTasks.setFilter(sFilterType, sFilterValue), "Set Filter");
        logCompare(true, b2wSchedulesTasks.setSecurityRole(sSecurityRole), "Select Security Role");
        logCompare(true, b2wSchedulesTasks.saveSchedule(), "Save Equipment Schedule View");
        logCompare(true, b2wSchedulesTasks.isScheduleExist(sEquipmentView), "Check that Equipment Schedule View has been created.");
    }

    public void createNewCrewScheduleView() {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Open Create Schedule View dialog.
         * 3. Fill all fields (Name, BU, Notes, Items, Grouping Level1, Grouping Level 2, Filter, Security Roles)
         * 4. Save Schedule View
         * 5. Check that Schedule View has been created.
         */
        String sView = sScheduleFormatCrewView;
        List<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sView);
        item.setResourceName("Production Crews");
        itemList.add(item);
        B2WScheduleItem item1 = new B2WScheduleItem();
        item1.setScheduleFormat(sView);
        item1.setResourceName("Transportation Crews");
        itemList.add(item1);

        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.clickCreateScheduleViewDialog(), "Open Create Schedule View dialog.");
        logCompare(true, b2wSchedulesTasks.setName(sCrewView), "Set Name");
        logCompare(true, b2wSchedulesTasks.setBU(sBU), "Select BU");
        logCompare(true, b2wSchedulesTasks.setNotes(sSchedulesNotes), "Set Notes");
        logCompare(true, b2wSchedulesTasks.setScheduleFormat(sView), "Select Schedule Format");
        logCompare(true, b2wSchedulesTasks.setItems(itemList), "Select Items on Schedule");
        logCompare(true, b2wSchedulesTasks.setGrouping("Group items by", sGroupingLevel1), "Select Grouping item by");
        logCompare(true, b2wSchedulesTasks.setGrouping("Secondary grouping", sGroupingLevel2), "Select Secondary grouping");
        //ToDO: Remove comments after fixing
        //logCompare(true, b2wSchedulesTasks.setFilter(sFilterType, sFilterValue), "Set Filter");
        logCompare(true, b2wSchedulesTasks.setSecurityRole(sSecurityRole), "Select Security Role");
        logCompare(true, b2wSchedulesTasks.saveSchedule(), "Save Crews Schedule View");
        logCompare(true, b2wSchedulesTasks.isScheduleExist(sCrewView), "Check that Crews Schedule View has been created.");
    }

    public void createNewJobSiteScheduleView() {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Open Create Schedule View dialog.
         * 3. Fill all fields (Name, BU, Notes, Items, Grouping Level1, Grouping Level 2, Filter, Security Roles)
         * 4. Save Schedule View
         * 5. Check that Schedule View has been created.
         */
        String sView = sScheduleFormatLocationView;
        List<B2WScheduleItem> itemList = new ArrayList<B2WScheduleItem>();
        B2WScheduleItem item = new B2WScheduleItem();
        item.setScheduleFormat(sView);
        item.setResourceName("Job Sites");
        itemList.add(item);

        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.clickCreateScheduleViewDialog(), "Open Create Schedule View dialog.");
        logCompare(true, b2wSchedulesTasks.setName(sLocationView), "Set Name");
        logCompare(true, b2wSchedulesTasks.setBU(sBU), "Select BU");
        logCompare(true, b2wSchedulesTasks.setNotes(sSchedulesNotes), "Set Notes");
        logCompare(true, b2wSchedulesTasks.setScheduleFormat(sView), "Select Schedule Format");
        logCompare(true, b2wSchedulesTasks.setItems(itemList), "Select Items on Schedule");
        logCompare(true, b2wSchedulesTasks.setGrouping("Group items by", sGroupingLevel1), "Select Grouping item by");
        logCompare(true, b2wSchedulesTasks.setGrouping("Secondary grouping", sGroupingLevel2), "Select Secondary grouping");
        //ToDO: Remove comments after fixing
        //logCompare(true, b2wSchedulesTasks.setFilter(sFilterType, sFilterValue), "Set Filter");
        logCompare(true, b2wSchedulesTasks.setSecurityRole(sSecurityRole), "Select Security Role");
        logCompare(true, b2wSchedulesTasks.saveSchedule(), "Save JobSite Schedule View");
        logCompare(true, b2wSchedulesTasks.isScheduleExist(sLocationView), "Check that JobSite Schedule View has been created.");
    }

    //=== Update Schedule View ===
    public void updateScheduleView() {
        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.selectScheduleView(sScheduleName), "Select Schedule View.");
        logCompare(true, b2wSchedulesTasks.clickUpdateScheduleViewDialog(), "Open Edit Schedule View Dialog.");

    }

    //=== Create Assignments/Needs/Orders/Events ===
    public void createEmployeeAssignment() {
        /*
         * 1. Open Employee Schedule View
         * 2. Change Schedule View Date Range
         * 3. Change Schedule View Start Date
         * 4. Set Filter
         * 5. Expand groups???
         * 6. Count number existing assignments for resource.
         * 7. Open New Employee Assignment Dialog
         * 8. Fill all fields (JobSite, Employee, Requested By, Notes, Duration, StartTime)
         * 9. Save New Employee Assignment
         * 10. Count number existing assignments for resource
         * 11. Check that the counts difference equal 1
         * 12. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEmployeeView, sDefaultEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeName), "Set Filter by Employee Name");

        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEmployeeAssignment(), "Open Create Employee Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployee(sEmployeeName), "Set Employee");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Start Time");
        logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Save New Employee Assignment");

        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
        WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Assignment has been created.");

    }

    public void createEquipmentAssignment() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing assignments for resource.
         * 6. Open New Equipment Assignment Dialog
         * 7. Fill all fields (JobSite, Equipment, Requested By, Notes, Duration, StartTime)
         * 8. Save New Equipment Assignment
         * 9. Count number existing assignments for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEquipmentAssignment(), "Open Create Equipment Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEquipmentAssignment(), "Save New Equipment Assignment");
        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.setSearchValue("aaa"), "Set Filter by Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Employee Need");
        //=============================
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Assignment has been created.");
        WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Equipment Assignment has been created.");
    }

    public void createEmployeeNeed() {
        this.createEmployeeNeed(sEmployeeNeedName, sJobSiteName, sRequestedBy, sNotesText, sAssignmentDuration, sAssignmentStartTime);
    }

    public void createEmployeeNeed(String sEmployeeNeedName, String sJobSiteName, String sRequestedBy, String sNotesText, String sAssignmentDuration, String sAssignmentStartTime) {
        /*
         * 1. Open Schedule View with Employee Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing assignments for resource.
         * 6. Open New Employee Assignment Dialog
         * 7. Fill all fields (JobSite, Employee Need, Requested By, Notes, Duration, StartTime)
         * 8. Save New Employee Assignment
         * 9. Count number existing assignments for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEmployeeView, sDefaultEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNeedName), "Set Filter by Employee Need");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEmployeeNeed(), "Open Create Employee Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployeeNeed(sEmployeeNeedName), "Set Employee Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEmployeeNeed(), "Save New Employee Need");
        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.setSearchValue("aaa"), "Set Filter by Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNeedName), "Set Filter by Employee Need");
        //=============================
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Employee Need has been created.");
        WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Employee Need has been created.");
    }

    public void createEquipmentNeed() {
        createEquipmentNeed(sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentDuration, sAssignmentStartTime);
    }

    public void createEquipmentNeed(String sEquipmentNeedName, String sJobSiteName, String sStartDate, String sEndDate, String sAssignmentDuration, String sAssignmentStartTime) {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing assignments for resource.
         * 6. Open New Equipment Assignment Dialog
         * 7. Fill all fields (JobSite, Equipment Need, Requested By, Notes, Duration, StartTime)
         * 8. Save New Equipment Assignment
         * 9. Count number existing assignments for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNeedName), "Set Filter by Equipment Need");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEquipmentNeed(), "Open Create Equipment Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipmentNeed(sEquipmentNeedName), "Set Equipment Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Start Time");
        logCompare(true, b2wScheduler.saveEquipmentNeed(), "Save New Equipment Need");
        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.setSearchValue("Aaa"), "Set Filter by Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNeedName), "Set Filter by Employee Need");
        //=============================
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Need has been created.");
        WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Equipment Need has been created.");
    }

    public void createCrewAssignment() {
        /*
         * 1. Open Schedule View with Crew Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing assignments for resource.
         * 6. Open New Crew Assignment Dialog
         * 7. Fill all fields (JobSite, Crew, Requested By, Notes, Duration, StartTime)
         * 8. Save New Crew Assignment
         * 9. Count number existing assignments for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultCrewView, sDefaultCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sCrewName), "Set Filter by Crew Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sCrewName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewCrewAssignment(), "Open Create Crew Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setCrew(sCrewName), "Set Crew");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveCrewAssignment(), "Save New Crew Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sCrewName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Crew Assignment has been created.");
        WebElement result = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Crew Assignment has been created.");
    }

    public void createCrewNeed() {
        createCrewNeed(sCrewNeedName, sJobSiteName, sAssignmentDuration, sAssignmentStartTime);
    }

    public void createCrewNeed(String sCrewNeedName, String sJobSiteName, String sAssignmentDuration, String sAssignmentStartTime) {
        /*
         * 1. Open Schedule View with Crew Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing assignments for resource.
         * 6. Open New Crew Assignment Dialog
         * 7. Fill all fields (JobSite, Crew, Requested By, Notes, Duration, StartTime)
         * 8. Save New Crew Assignment
         * 9. Count number existing assignments for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultCrewView, sDefaultCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNeedName), "Set Filter by Crew Need");
        int initialCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
        logCompare(true, b2wScheduler.createNewCrewNeed(), "Open Create New Crew Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setCrewNeed(sCrewNeedName), "Set Crew Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveCrewNeed(), "Save New Crew Need");
        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.setSearchValue("aaa"), "Set Filter by Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNeedName), "Set Filter by Employee Need");
        //===========================================
        int actualCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Crew Need has been created.");
        WebElement result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Crew Need has been created.");
    }

    public void createMoveAssignment() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing assignments for resource.
         * 6. Open New Move Assignment Dialog
         * 7. Fill all fields (Equipment, Pickup Location, Drop-off Location, Transportation Crew)
         * 8. Save New Move Assignment
         * 9. Count number existing assignments for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ASSIGNMENT_TYPE);
        logCompare(true, b2wScheduler.createNewMoveAssignment(), "Open Create Move Assignment Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.clickSelectCrew(), "Open Select Crew Dialog");
        logCompare(true, b2wScheduler.setCrew(sTransportationCrewName), "Set Crew");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveMoveAssignment(), "Save New Move Assignment");
        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.setSearchValue("aaa"), "Set Filter");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter");
        //===========================================
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ASSIGNMENT_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Move Assignment has been created.");
        WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Move Assignment has been created.");
    }

    public void createMoveOrder() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing assignments for resource.
         * 6. Open New Move Order Dialog
         * 7. Fill all fields (Equipment, Pickup Location, Drop-off Location)
         * 8. Save New Move Order
         * 9. Count number existing assignments for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName);
        logCompare(true, b2wScheduler.createNewMoveOrder(), "Open Create Move Order Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveMoveOrder(), "Save New Move Order");
        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.setSearchValue("aaa"), "Set Filter by Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Employee Need");
        //===========================================
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Move Order has been created.");
        WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Move Order has been created.");
    }

    public void createEmployeeEvent() {
        /*
         * 1. Open Schedule View with Employee Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing events for resource.
         * 6. Open New Employee Event Dialog
         * 7. Fill all fields (Employee, Event Type, Notes)
         * 8. Save New Employee Event
         * 9. Count number existing events for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular assignment is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEmployeeView, sDefaultEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeName), "Set Filter by Employee Name on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType);
        logCompare(true, b2wScheduler.createNewEmployeeEvent(), "Open Create Employee Event Dialog");
        logCompare(true, b2wScheduler.setEventEmployee(sEmployeeName), "Set Employee");
        logCompare(true, b2wScheduler.setEventType(sEmployeeEventType), "Set Employee Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Employee Event Type");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
        WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Assignment has been created.");
    }

    public void createEquipmentEvent() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing events for resource.
         * 6. Open New Equipment Event Dialog
         * 7. Fill all fields (Equipment, Event Type, Notes)
         * 8. Save New Equipment Event
         * 9. Count number existing events for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular event is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType);
        logCompare(true, b2wScheduler.createNewEquipmentEvent(), "Open Create Equipment Event Dialog");
        logCompare(true, b2wScheduler.setEventEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setEventType(sEquipmentEventType), "Set Equipment Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Equipment Event Type");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Event has been created.");
        WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Equipment Event has been created.");
    }

    public void createLocationEvent() {
        /*
         * 1. Open Schedule View with Location Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing events for resource.
         * 6. Open New Location Event Dialog
         * 7. Fill all fields (Location, Event Type, Notes)
         * 8. Save New Location Event
         * 9. Count number existing events for resource
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular event is created
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: Remove after Fix problems with grouping view
        //logCompare(true, b2wScheduler.navigateToScheduleView(sLocationView, sLocationView), "Open JobSites Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultLocationView, sDefaultLocationView), "Open JobSites Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sJobSiteName), "Set Filter by JobSite Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType);
        logCompare(true, b2wScheduler.createNewLocationEvent(), "Open Create Location Event Dialog");
        logCompare(true, b2wScheduler.setEventLocation(sJobSiteName), "Set Job Site");
        logCompare(true, b2wScheduler.setEventType(sLocationEventType), "Set Location Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Location Event Type");
        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.setSearchValue(sJobSiteNameUpd), "Set Filter by Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sJobSiteName), "Set Filter by Employee Need");
        //===========================================
        int actualCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that JobSite Event has been created.");
        WebElement result = b2wScheduler.getJobSiteEvent(sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific JobSite Event has been created.");
    }

    //=== Update Assignments/Needs/Orders/Events ===
    public void updateEmployeeAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeName), "Set Filter by Employee Name");
        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.editAssignment(), "Select 'Edit Assignment' option");
        logCompare(true, b2wScheduler.updateJobSite(sJobSiteNameUpd), "Update JobSite/Place");
        logCompare(true, b2wScheduler.updateEmployee(sEmployeeNameUpd), "Update Employee");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDurationUpd), "Update Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTimeUpd), "Update Start Time");
        logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Update Employee Assignment");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNameUpd), "Set Filter by updated Employee Name");
        WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Employee Assignment has been updated.");
    }

    public void updateEquipmentAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.editAssignment(), "Select 'Edit Assignment' option");
        logCompare(true, b2wScheduler.updateJobSite(sJobSiteNameUpd), "Update JobSite/Place");
        logCompare(true, b2wScheduler.updateEquipment(sEquipmentNameUpd), "Update Employee");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDurationUpd), "Update Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTimeUpd), "Update Start Time");
        logCompare(true, b2wScheduler.saveEquipmentAssignment(), "Save updated Equipment Assignment");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNameUpd), "Set Filter by updated Equipment Name");
        WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Equipment Assignment has been updated.");
    }

    public void updateEmployeeNeed() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Need
         * 6. Select Edit from context menu
         * 7. Update Need's data
         * 8. Save Need
         * 9. Verify that Need has been updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNeedName), "Set Filter by Employee Need");
        WebElement assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.editNeed(), "Select 'Edit Need' option");
        logCompare(true, b2wScheduler.updateJobSite(sJobSiteNameUpd), "Update JobSite/Place");
        logCompare(true, b2wScheduler.updateEmployeeNeed(sEmployeeNeedNameUpd), "Update Need");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDurationUpd), "Update Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTimeUpd), "Update Start Time");
        logCompare(true, b2wScheduler.saveEmployeeNeed(), "Update Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNeedNameUpd), "Set Filter by updated Employee Need");
        WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Employee Need has been updated.");
    }

    public void updateEquipmentNeed() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Need
         * 6. Select Edit from context menu
         * 7. Update Need's data
         * 8. Save Need
         * 9. Verify that Need has been updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNeedName), "Set Filter by Equipment Need");
        WebElement assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.editNeed(), "Select 'Edit Need' option");
        logCompare(true, b2wScheduler.updateJobSite(sJobSiteNameUpd), "Update JobSite/Place");
        logCompare(true, b2wScheduler.updateEquipmentNeed(sEquipmentNeedNameUpd), "Update Need");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDurationUpd), "Update Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTimeUpd), "Update Start Time");
        logCompare(true, b2wScheduler.saveEquipmentNeed(), "Update Equipment Need");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNeedNameUpd), "Set Filter by updated Employee Need");
        WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Equipment Need has been updated.");
    }

    public void updateCrewAssignment() {
/*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crews Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sCrewName), "Set Filter by Crew Name");
        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.editAssignment(), "Select 'Edit Assignment' option");
        logCompare(true, b2wScheduler.updateJobSite(sJobSiteNameUpd), "Update JobSite/Place");
        logCompare(true, b2wScheduler.updateCrew(sCrewNameUpd), "Update Crew");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDurationUpd), "Update Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTimeUpd), "Update Start Time");
        logCompare(true, b2wScheduler.saveCrewAssignment(), "Update Crew Assignment");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNameUpd), "Set Filter by updated Crew Name");
        WebElement result = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Crew Assignment has been updated.");
    }

    public void updateCrewNeed() {
/*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNeedName), "Set Filter by Crew Need");
        WebElement assignment = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Need's Context Menu");
        logCompare(true, b2wScheduler.editNeed(), "Select 'Edit Need' option");
        logCompare(true, b2wScheduler.updateJobSite(sJobSiteNameUpd), "Update JobSite/Place");
        logCompare(true, b2wScheduler.updateCrewNeed(sCrewNeedNameUpd), "Update Crew Need");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDurationUpd), "Update Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTimeUpd), "Update Start Time");
        logCompare(true, b2wScheduler.saveCrewNeed(), "Update Crew Need");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNeedNameUpd), "Set Filter by updated Crew Need");
        WebElement result = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Crew Need has been updated.");
    }

    public void updateMoveAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.editMoveAssignment(), "Select 'Edit Move Assignment' option");
        logCompare(true, b2wScheduler.clickEditLocation(), "Click 'Edit Location' link");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteNameUpd), "Update Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteNameUpd), "Update Drop-off Location");
        logCompare(true, b2wScheduler.clickEditCrew(), "Click 'Edit Crew' button");
        logCompare(true, b2wScheduler.updateTransportationCrew(sTransportationCrewNameUpd), "Update Transportation Crew");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.saveMoveAssignment(), "Update Move Assignment");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by updated Equipment Name");
        WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Move Assignment has been updated.");
    }

    public void updateMoveOrder() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Order's Context Menu");
        logCompare(true, b2wScheduler.editMoveOrder(), "Select 'Edit Move Order' option");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteNameUpd), "Update Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteNameUpd), "Update Drop-off Location");
        logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.saveMoveOrder(), "Update Move Order");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by updated Equipment Name");
        WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd);
        logCompare(true,  result != null, "Verification that specific Move Order has been updated.");
    }

    public void updateEmployeeEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeName), "Set Filter by Employee Name");
        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
        logCompare(true, b2wScheduler.editEvent(), "Select 'Edit Event' option");
        logCompare(true, b2wScheduler.updateEventEmployee(sEmployeeNameUpd), "Update Employee");
        logCompare(true, b2wScheduler.setEventType(sEmployeeEventTypeUpd), "Update Employee Event Type");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Update Employee Event");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNameUpd), "Set Filter by updated Employee Name");
        WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Employee Event has been updated.");
    }

    public void updateEquipmentEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
        logCompare(true, b2wScheduler.editEvent(), "Select 'Edit Event' option");
        logCompare(true, b2wScheduler.updateEventEquipment(sEquipmentNameUpd), "Update Equipment");
        logCompare(true, b2wScheduler.setEventType(sEquipmentEventTypeUpd), "Update Equipment Event Type");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Update Equipment Event");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNameUpd), "Set Filter by updated Employee Name");
        WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Equipment Event has been updated.");
    }

    public void updateLocationEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Edit from context menu
         * 7. Update Assignment's data
         * 8. Save Assignment
         * 9. Verify that Assignment was updated.
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        //ToDo: remove after fix
        //logCompare(true, b2wScheduler.navigateToScheduleView(sLocationView, sLocationView), "Open JobSites Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultLocationView, sDefaultLocationView), "Open JobSites Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sJobSiteName), "Set Filter by Location Name");

        WebElement assignment = b2wScheduler.getJobSiteEvent(sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
        logCompare(true, b2wScheduler.editEvent(), "Select 'Edit Event' option");
        logCompare(true, b2wScheduler.updateEventLocation(sJobSiteNameUpd), "Update Location");
        logCompare(true, b2wScheduler.setEventType(sLocationEventTypeUpd), "Update Location Event Type");
        logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Update Equipment Event");
        logCompare(true, b2wScheduler.setSearchValue(sJobSiteNameUpd), "Set Filter by updated Location Name");
        WebElement result = b2wScheduler.getJobSiteEvent(sJobSiteNameUpd, sLocationEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result != null, "Verification that specific Location Event has been updated.");
    }

    //=== Move Assignments/Needs/Orders/Events ===
    public void moveEmployeeAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEmployeeView, sDefaultEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeName), "Set Filter by Employee Name");

        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Assignment to the specific date");
        WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Employee Assignment was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeNameUpd, dCalendarStartDate), "Move Assignment to the specific date");
        result = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Assignment was moved to the specific date.");

        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(result, sEmployeeName, dCalendarStartDate), "Move Assignment to the specific date");
        result = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Assignment was moved to the specific date.");
    }

    public void moveEmployeeNeed() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEmployeeView, sDefaultEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNeedName), "Set Filter by Employee Need");

        WebElement assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Need to the specific date");
        WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Employee Need was moved to the specific date.");

        //ToDo There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedName1, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeNeedName, dCalendarStartDate), "Move Need to the specific date");
        result = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Need was moved to the specific date.");
    }

    public void moveEquipmentAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Assignment to the specific date");
        WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Equipment Assignment was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        //Move assignment to the another resource
        assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentNameUpd, dCalendarStartDate), "Move Equipment Assignment to the specific date and another resource");
        result = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Assignment was moved to the specific date.");

        //Move assignment to the original date and resource
        assignment = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentName    , dCalendarStartDate), "Move Equipment Assignment to the original date and resource");
        result = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Assignment was moved to the specific date.");
    }

    public void moveEquipmentNeed() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNeedName), "Set Filter by Equipment Need");

        //Move need to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Equipment Need to the specific date");
        WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Equipment Need was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        //Move need to the another resource
        assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentNeedName, dCalendarStartDate), "Move Equipment Need to the specific date and another resource");
        result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Need was moved to the specific date.");
    }

    public void moveCrewAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultCrewView, sDefaultCrewView), "Open Crews Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sCrewName), "Set Filter by Crew Name");

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Crew Assignment to the specific date");
        WebElement result = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Crew Assignment was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        //Move assignment to the another resource
        assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sCrewNameUpd, dCalendarStartDate), "Move Crew Assignment to the specific date and another resource");
        result = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Crew Assignment was moved to the specific date.");

        //Move assignment to the original date and resource
        assignment = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sCrewName, dCalendarStartDate), "Move Crew Assignment to the original date and resource");
        result = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Crew Assignment was moved to the specific date.");
    }

    public void moveCrewNeed() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultCrewView, sDefaultCrewView), "Open Crews Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNeedName), "Set Filter by Crew Need");

        //Move need to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Crew Need to the specific date");
        WebElement result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Crew Need was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        //Move need to the another resource
        assignment = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sCrewNeedName, dCalendarStartDate), "Move Crew Need to the specific date and another resource");
        result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Crew Need was moved to the specific date.");
    }

    public void moveMoveAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Move Assignment to the specific date");
        WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Move Assignment was moved to the specific date.");

        assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dCalendarStartDate), "Move Move Assignment to the specific date");
        result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Move Assignment was moved to the specific date.");
    }

    public void moveMoveOrder() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Move Order to the specific date");
        WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Move Order was moved to the specific date.");

        assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dCalendarStartDate), "Move Move Order to the specific date");
        result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Move Order was moved to the specific date.");
    }

    public void moveEmployeeEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEmployeeView, sDefaultEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeName), "Set Filter by Employee Name");

        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Employee Event to the specific date");
        WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Employee Event was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        //logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");
        b2wScheduler.clearSearchValue();
        BrowserUtils.getDriver().navigate().refresh();
        b2wScheduler.waitForSchedulePageNoBusy();
        //=================

        assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeNameUpd, dCalendarStartDate), "Move Employee Event to the specific date");
        result = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Event was moved to the specific date.");

        assignment = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeName, dCalendarStartDate), "Move Employee Event to the specific date");
        result = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Event was moved to the specific date.");
    }

    public void moveEquipmentEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultEquipmentView, sDefaultEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Equipment Event to the specific date");
        WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Equipment Event was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        //Move assignment to the another resource
        assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentNameUpd, dCalendarStartDate), "Move Equipment Event to the specific date and another resource");
        result = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Event was moved to the specific date.");

        //Move assignment to the original date and resource
        assignment = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentName    , dCalendarStartDate), "Move Equipment Event to the original date and resource");
        result = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Event was moved to the specific date.");
    }

    public void moveLocationEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Find Assignment
         * 6. Move Assignment to specific date
         * 7. Remove filter
         * 8. Expand all levels
         * 7. Move Assignment to another specific Resource and Date
         * 8. Move Assignment to original date and resource
         * 9. Verify that Assignment was updated.
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sDefaultLocationView, sDefaultLocationView), "Open JobSites Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sJobSiteName), "Set Filter by Location Name");

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getJobSiteEvent(sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Location Event to the specific date");
        WebElement result = b2wScheduler.getJobSiteEvent(sJobSiteName, sLocationEventType, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Location Event was moved to the specific date.");

        //ToDo: There is a BUG in the APP
        logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

        //Move assignment to the another resource
        assignment = b2wScheduler.getJobSiteEvent(sJobSiteName, sLocationEventType, sMoveDate, sMoveDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sJobSiteNameUpd, dCalendarStartDate), "Move Location Event to the specific date and another resource");
        result = b2wScheduler.getJobSiteEvent(sJobSiteNameUpd, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Location Event was moved to the specific date.");

        //Move assignment to the original date and resource
        assignment = b2wScheduler.getJobSiteEvent(sJobSiteNameUpd, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sJobSiteName, dCalendarStartDate), "Move Location Event to the original date and resource");
        result = b2wScheduler.getJobSiteEvent(sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Location Event was moved to the specific date.");
    }

    //=== Delete Assignments/Needs/Orders/Events ===
    public void deleteEmployeeAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNameUpd), "Set Filter by Employee Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeNameUpd, sJobSiteNameUpd);
        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.deleteAssignment(), "Delete Employee Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeNameUpd, sJobSiteNameUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that Employee Assignment has been deleted.");
        WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Employee Assignment has been deleted.");
    }

    public void deleteEmployeeNeed() {
        deleteEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
    }

    public void deleteEmployeeNeed(String sEmployeeNeedNameUpd, String sJobSiteNameUpd, String sStartDate, String sEndDate, String sAssignmentStartTime) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNeedNameUpd), "Set Filter by Employee Need");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedNameUpd, sJobSiteNameUpd);
        WebElement assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sStartDate, sEndDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Need's Context Menu");
        logCompare(true, b2wScheduler.deleteNeed(), "Delete Need");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedNameUpd, sJobSiteNameUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that Employee Need has been deleted.");
        WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sStartDate, sEndDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Employee Need has been deleted.");
    }

    public void deleteEquipmentAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNameUpd), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentNameUpd, sJobSiteNameUpd, b2wScheduler.EQUIPMENT_TYPE);
        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
        logCompare(true, b2wScheduler.deleteAssignment(), "Delete Equipment Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentNameUpd, sJobSiteNameUpd, b2wScheduler.EQUIPMENT_TYPE);
        logCompare(true, actualCount == initialCount - 1, "Verification that Equipment Assignment has been deleted.");
        WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Equipment Assignment has been deleted.");
    }

    public void deleteEquipmentNeed() {
        deleteEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
    }

    public void deleteEquipmentNeed(String sEquipmentNeedName, String sJobSiteName, String sStartDate, String sEndDate, String sAssignmentStartTime) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNeedName), "Set Filter by Equipment Need");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName);
        WebElement assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Need's Context Menu");
        logCompare(true, b2wScheduler.deleteNeed(), "Delete Equipment Need");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName);
        logCompare(true, actualCount == initialCount - 1, "Verification that Equipment Need has been deleted.");
        WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Equipment Need has been deleted.");
    }

    public void deleteCrewAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNameUpd), "Set Filter by Crew Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sCrewNameUpd, sJobSiteNameUpd);
        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Crew's Context Menu");
        logCompare(true, b2wScheduler.deleteAssignment(), "Delete Crew Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sCrewNameUpd, sJobSiteNameUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that Crew Assignment has been deleted.");
        WebElement result = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Crew Assignment has been deleted.");
    }

    public void deleteCrewNeed() {
        deleteCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
    }

    public void deleteCrewNeed(String sCrewNeedName, String sJobSiteName, String sStartDate, String sEndDate, String sAssignmentStartTime) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNeedName), "Set Filter by Crew Need");
        int initialCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
        WebElement assignment = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Need's Context Menu");
        logCompare(true, b2wScheduler.deleteNeed(), "Delete Crew Need");
        int actualCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
        logCompare(true, actualCount == initialCount - 1, "Verification that Crew Need has been deleted.");
        WebElement result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Crew Need has been deleted.");
    }

    public void deleteMoveAssignment() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteNameUpd);
        WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Move's Context Menu");
        logCompare(true, b2wScheduler.deleteMoveAssignment(), "Delete Move Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteNameUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that Move Assignment has been deleted.");
        WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Move Assignment has been deleted.");
    }

    public void deleteMoveOrder() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteNameUpd);
        WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Order's Context Menu");
        logCompare(true, b2wScheduler.deleteMoveOrder(), "Delete Move Order");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteNameUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that Move Order has been deleted.");
        WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Move Order has been deleted.");
    }

    public void deleteEmployeeEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEmployeeNameUpd), "Set Filter by Employee Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeNameUpd, sEmployeeEventTypeUpd);
        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
        logCompare(true, b2wScheduler.deleteEvent(), "Delete Employee Event");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeNameUpd, sEmployeeEventTypeUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that Employee Event has been deleted.");
        WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Employee Event has been deleted.");
    }

    public void deleteEquipmentEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentNameUpd), "Set Filter by Equipment Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentNameUpd, sEquipmentEventTypeUpd);
        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
        logCompare(true, b2wScheduler.deleteEvent(), "Delete Equipment Event");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentNameUpd, sEquipmentEventTypeUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that Equipment Event has been deleted.");
        WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific Equipment Event has been deleted.");
    }

    public void deleteJobSiteEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sLocationView, sLocationView), "Open Places Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date");
        logCompare(true, b2wScheduler.setSearchValue(sJobSiteNameUpd), "Set Filter by JobSite Name");
        int initialCount = b2wScheduler.getAssignmentsCount(sJobSiteNameUpd, sLocationEventTypeUpd);
        WebElement assignment = b2wScheduler.getJobSiteEvent(sJobSiteNameUpd, sLocationEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
        logCompare(true, b2wScheduler.deleteEvent(), "Delete JobSite Event");
        int actualCount = b2wScheduler.getAssignmentsCount(sJobSiteNameUpd, sLocationEventTypeUpd);
        logCompare(true, actualCount == initialCount - 1, "Verification that JobSite Event has been deleted.");
        WebElement result = b2wScheduler.getJobSiteEvent(sJobSiteNameUpd, sLocationEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime);
        logCompare(true,  result == null, "Verification that specific JobSite Event has been deleted.");
    }

    //=== Delete Schedule View
    public void deleteScheduleView(String sValue) {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Select Schedule View
         * 3. Delete Schedule View
         * 4. Check that Schedule View has been deleted.
         */
        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.selectScheduleView(sValue), "Select specific Schedule View");
        logCompare(true, b2wSchedulesTasks.deleteSchedule(), "Delete Schedule View");
        logCompare(false, b2wSchedulesTasks.isScheduleExist(sValue), "Check that Schedule View has been deleted.");
    }
}