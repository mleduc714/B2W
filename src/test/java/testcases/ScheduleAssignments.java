package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.scheduler.B2WSchedulerTasks;
import tasks.setup.B2WSchedulesTasks;

public class ScheduleAssignments extends B2WTestCase {

    /*
     * 1. Create New Schedule View
     * 1. Create Employee Assignment
     * 2. Create Equipment Assignment
     * 3. Create Employee Need
     * 4. Create Equipment Need
     * 5. Create Crew Assignment
     * 6. Create Crew Need
     * 7. Create Move Assignment
     * 8. Create Move Order
     * 9. Create Employee Event
     * 10. Create Equipment Event
     * 11. Create Location Event
     */

    B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    B2WSchedulerTasks b2wScheduler = new B2WSchedulerTasks();
    B2WSchedulesTasks b2wSchedulesTasks = new B2WSchedulesTasks();

    // Property
    // Schedule Setup
    String sScheduleName;
    String sBU;
    String sNotes;
    String sItemsOnTheSchedule;
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

    // Assignment - General Values
    String sJobSiteName;
    String sRequestedBy;
    String sNotesText;
    String sAssignmentDuration;
    String sAssignmentStartTime;

    // Employee
    String sEmployeeName;
    String sEmployeeNeedName;

    // Equipment
    String sEquipmentName;
    String sEquipmentNeedName;

    // Crew
    String sCrewName;
    String sCrewNeedName;

    // Move
    String sPickupJobSiteName;
    String sDropoffJobSiteName;
    String sTransportationCrewName;

    // Event
    String sEmployeeEventType;
    String sEquipmentEventType;
    String sLocationEventType;


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
        sScheduleName = getProperty("sScheduleName") + "-" + n;
        sBU = getProperty("sBU");
        sNotes = getProperty("sNotes");
        sItemsOnTheSchedule = getProperty("sItemsOnTheSchedule");
        sGroupingLevel1 = getProperty("sGroupingLevel1");
        sGroupingLevel2 = getProperty("sGroupingLevel2");
        sFilterType = getProperty("sFilterType");
        sFilterValue = getProperty("sFilterValue");
        sSecurityRole = getProperty("sSecurityRole");

        //Schedule View
        sEmployeeView = getProperty("sEmployeeView");
        sEquipmentView = getProperty("sEquipmentView");
        sCrewView = getProperty("sCrewView");
        sLocationView = getProperty("sLocationView");

        sJobSiteName = getProperty("sJobSiteName");
        sRequestedBy = getProperty("sRequestedBy");
        sEmployeeName = getProperty("sEmployeeName");
        sEmployeeNeedName = getProperty("sEmployeeNeedName");
        sEquipmentName = getProperty("sEquipmentName");
        sEquipmentNeedName = getProperty("sEquipmentNeedName");
        sCrewName = getProperty("sCrewName");
        sCrewNeedName = getProperty("sCrewNeedName");
        sPickupJobSiteName = getProperty("sPickupJobSiteName");
        sDropoffJobSiteName = getProperty("sDropoffJobSiteName");
        sTransportationCrewName = getProperty("sTransportationCrewName");
        sEmployeeEventType = getProperty("sEmployeeEventType");
        sEquipmentEventType = getProperty("sEquipmentEventType");
        sLocationEventType = getProperty("sLocationEventType");
        sNotesText = getProperty("sNotesText");
        sAssignmentDuration = getProperty("sAssignmentDuration");
        sAssignmentStartTime = getProperty("sAssignmentStartTime");
        sCalendarDateRange = getProperty("sCalendarDateRange");
        sCalendarStartDate = getProperty("sCalendarStartDate");
    }

    public void testMain() throws Throwable {
        createNewScheduleView();

        createEmployeeAssignment();
        createEquipmentAssignment();
        createEmployeeNeed();
        createEquipmentNeed();
        createCrewAssignment();
        createCrewNeed();
        createMoveAssignment();
        createMoveOrder();
        createEmployeeEvent();
        createEquipmentEvent();
        createLocationEvent();

        deleteScheduleView();
    }

    @Override
    public void testTearDown() throws Throwable {
        super.testTearDown();
    }

    public void createNewScheduleView() {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Open Create Schedule View dialog.
         * 3. Fill all fields (Name, BU, Notes, Items, Grouping Level1, Grouping Level 2, Filter, Security Roles)
         * 4. Save Schedule View
         * 5. Check that Schedule View has been created.
         */
        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.openCreateScheduleViewDialog(), "Open Create Schedule View dialog.");
        logCompare(true, b2wSchedulesTasks.setName(sScheduleName), "Set Name");
        logCompare(true, b2wSchedulesTasks.setBU(sBU), "Select BU");
        logCompare(true, b2wSchedulesTasks.setNotes(sNotes), "Select BU");
        logCompare(true, b2wSchedulesTasks.setItems(sItemsOnTheSchedule), "Select Items on the Schedule");
        logCompare(true, b2wSchedulesTasks.setGrouping("Group items by", sGroupingLevel1), "Select Grouping item by");
        logCompare(true, b2wSchedulesTasks.setGrouping("Secondary grouping", sGroupingLevel2), "Select Secondary grouping");
        logCompare(true, b2wSchedulesTasks.setFilter(sFilterType, sFilterValue), "Set Filter");
        logCompare(true, b2wSchedulesTasks.setSecurityRole(sSecurityRole), "Select Security Role");
        logCompare(true, b2wSchedulesTasks.saveSchedule(), "Save Schedule View");
        logCompare(true, b2wSchedulesTasks.isScheduleExist(sScheduleName), "Check that Schedule View has been created.");
    }

    public void createEmployeeAssignment() {
        /*
         * 1. Open Schedule View with Employee Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Employee Assignment Dialog
         * 6. Fill all fields (JobSite, Employee, Requested By, Notes, Duration, StartTime)
         * 7. Save New Employee Assignment
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEmployeeAssignment(), "Open Create Employee Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployee(sEmployeeName), "Set Employee");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Save New Employee Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");

    }

    public void createEquipmentAssignment() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Equipment Assignment Dialog
         * 6. Fill all fields (JobSite, Equipment, Requested By, Notes, Duration, StartTime)
         * 7. Save New Equipment Assignment
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEquipmentAssignment(), "Open Create Equipment Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEquipmentAssignment(), "Save New Equipment Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createEmployeeNeed() {
        /*
         * 1. Open Schedule View with Employee Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Employee Assignment Dialog
         * 6. Fill all fields (JobSite, Employee Need, Requested By, Notes, Duration, StartTime)
         * 7. Save New Employee Assignment
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEmployeeNeed(), "Open Create Employee Need Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployeeNeed(sEmployeeNeedName), "Set Employee Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEmployeeNeedAssignment(), "Save New Employee Need Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createEquipmentNeed() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Equipment Assignment Dialog
         * 6. Fill all fields (JobSite, Equipment Need, Requested By, Notes, Duration, StartTime)
         * 7. Save New Equipment Assignment
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewEquipmentNeed(), "Open Create Equipment Need Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipmentNeed(sEquipmentNeedName), "Set Equipment Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEquipmentNeedAssignment(), "Save New Equipment Need Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createCrewAssignment() {
        /*
         * 1. Open Schedule View with Crew Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Crew Assignment Dialog
         * 6. Fill all fields (JobSite, Crew, Requested By, Notes, Duration, StartTime)
         * 7. Save New Crew Assignment
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
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
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createCrewNeed() {
        /*
         * 1. Open Schedule View with Crew Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Crew Assignment Dialog
         * 6. Fill all fields (JobSite, Crew, Requested By, Notes, Duration, StartTime)
         * 7. Save New Crew Assignment
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewCrewNeed(), "Open Create New Crew Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setCrewNeed(sCrewNeedName), "Set Crew Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveCrewNeedAssignment(), "Save New Crew Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createMoveAssignment() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Move Assignment Dialog
         * 6. Fill all fields (Equipment, Pickup Location, Drop-off Location, Transportation Crew)
         * 7. Save New Move Assignment
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewMoveAssignment(), "Open Create Move Assignment Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.clickSelectCrew(), "Open Select Crew Dialog");
        logCompare(true, b2wScheduler.setCrew(sTransportationCrewName), "Set Crew");
        logCompare(true, b2wScheduler.saveMoveAssignment(), "Save New Move Assignment");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createMoveOrder() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing assignments for resource.
         * 5. Open New Move Order Dialog
         * 6. Fill all fields (Equipment, Pickup Location, Drop-off Location)
         * 7. Save New Move Order
         * 8. Count number existing assignments for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, b2wScheduler.createNewMoveOrder(), "Open Create Move Order Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.saveMoveOrder(), "Save New Move Order");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createEmployeeEvent() {
        /*
         * 1. Open Schedule View with Employee Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing events for resource.
         * 5. Open New Employee Event Dialog
         * 6. Fill all fields (Employee, Event Type, Notes)
         * 7. Save New Employee Event
         * 8. Count number existing events for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType);
        logCompare(true, b2wScheduler.createNewEmployeeEvent(), "Open Create Employee Event Dialog");
        logCompare(true, b2wScheduler.setEventEmployee(sEmployeeName), "Set Employee");
        logCompare(true, b2wScheduler.setEventType(sEmployeeEventType), "Set Employee Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Employee Event Type");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createEquipmentEvent() {
        /*
         * 1. Open Schedule View with Equipment Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing events for resource.
         * 5. Open New Equipment Event Dialog
         * 6. Fill all fields (Equipment, Event Type, Notes)
         * 7. Save New Equipment Event
         * 8. Count number existing events for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType);
        logCompare(true, b2wScheduler.createNewEquipmentEvent(), "Open Create Equipment Event Dialog");
        logCompare(true, b2wScheduler.setEventEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setEventType(sEquipmentEventType), "Set Equipment Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Equipment Event Type");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createLocationEvent() {
        /*
         * 1. Open Schedule View with Location Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Count number existing events for resource.
         * 5. Open New Location Event Dialog
         * 6. Fill all fields (Location, Event Type, Notes)
         * 7. Save New Location Event
         * 8. Count number existing events for resource
         * 9. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sLocationView, sLocationView), "Open Places Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range on Schedule View");
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start Date on Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType);
        logCompare(true, b2wScheduler.createNewLocationEvent(), "Open Create Location Event Dialog");
        logCompare(true, b2wScheduler.setEventLocation(sJobSiteName), "Set Job Site");
        logCompare(true, b2wScheduler.setEventType(sLocationEventType), "Set Location Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Location Event Type");
        int actualCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void deleteScheduleView() {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Select Schedule View
         * 3. Delete Schedule View
         * 4. Check that Schedule View has been deleted.
         */
        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.selectScheduleView(sScheduleName), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.deleteSchedule(), "Delete Schedule View");
        logCompare(false, b2wSchedulesTasks.isScheduleExist(sScheduleName), "Check that Schedule View has been deleted.");
    }
}
