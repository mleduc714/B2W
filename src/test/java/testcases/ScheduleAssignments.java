package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.scheduler.B2WSchedulerTasks;

public class ScheduleAssignments extends B2WTestCase {

    /*
     * 1. Create an Employee Assignment
     * 2. Create an Equipment Assignment
     * 3. Create an Employee Need
     * 4. Create an Equipment Need
     * 5. Create a Crew Assignment
     * 6. Create a Crew Need
     * 7. Create a Move Assignment
     * 8. Create a Move Order
     * 9. Create an Employee Event
     * 10. Create an Equipment Event
     * 11. Create a Location Event
     */

    B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    B2WSchedulerTasks b2wScheduler = new B2WSchedulerTasks();

    // Property
    // Schedule View
    String sEmployeeView;
    String sEquipmentView;
    String sCrewView;
    String sLocationView;

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
        //int  n = getRandomNumber();

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
    }

    public void testMain() throws Throwable {
        /*
        createEmployeeAssignment();
        createEquipmentAssignment();
        createEmployeeNeed();
        createEquipmentNeed();
        */
        //createCrewAssignment();
        //createCrewNeed();
        //createMoveAssignment(); ??
        //createMoveOrder(); ??
        createEmployeeEvent();
        //createEquipmentEvent();
        //createLocationEvent();
    }

    @Override
    public void testTearDown() throws Throwable {
        super.testTearDown();
    }

    public void createEmployeeAssignment() {
        /*
         * 1. Open Schedule View with Employee Schedule
         * 2. Count number existing assignments for resource.
         * 3. Open New Employee Assignment Dialog
         * 4. Fill all fields (JobSite, Employee, Requested By, Notes, Duration, StartTime)
         * 5. Save New Employee Assignment
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
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
         * 2. Count number existing assignments for resource.
         * 3. Open New Equipment Assignment Dialog
         * 4. Fill all fields (JobSite, Equipment, Requested By, Notes, Duration, StartTime)
         * 5. Save New Equipment Assignment
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
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
         * 2. Count number existing assignments for resource.
         * 3. Open New Employee Assignment Dialog
         * 4. Fill all fields (JobSite, Employee Need, Requested By, Notes, Duration, StartTime)
         * 5. Save New Employee Assignment
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
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
         * 2. Count number existing assignments for resource.
         * 3. Open New Equipment Assignment Dialog
         * 4. Fill all fields (JobSite, Equipment Need, Requested By, Notes, Duration, StartTime)
         * 5. Save New Equipment Assignment
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
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
         * 2. Count number existing assignments for resource.
         * 3. Open New Crew Assignment Dialog
         * 4. Fill all fields (JobSite, Crew, Requested By, Notes, Duration, StartTime)
         * 5. Save New Crew Assignment
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
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
         * 2. Count number existing assignments for resource.
         * 3. Open New Crew Assignment Dialog
         * 4. Fill all fields (JobSite, Crew, Requested By, Notes, Duration, StartTime)
         * 5. Save New Crew Assignment
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
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
         * 2. Count number existing assignments for resource.
         * 3. Open New Move Assignment Dialog
         * 4. Fill all fields (Equipment, Pickup Location, Drop-off Location, Transportation Crew)
         * 5. Save New Move Assignment
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
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
         * 2. Count number existing assignments for resource.
         * 3. Open New Move Order Dialog
         * 4. Fill all fields (Equipment, Pickup Location, Drop-off Location)
         * 5. Save New Move Order
         * 6. Count number existing assignments for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
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
         * 2. Count number existing events for resource.
         * 3. Open New Employee Event Dialog
         * 4. Fill all fields (Employee, Event Type, Notes)
         * 5. Save New Employee Event
         * 6. Count number existing events for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
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
         * 2. Count number existing events for resource.
         * 3. Open New Equipment Event Dialog
         * 4. Fill all fields (Equipment, Event Type, Notes)
         * 5. Save New Equipment Event
         * 6. Count number existing events for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sLocationEventType);
        logCompare(true, b2wScheduler.createNewEquipmentEvent(), "Open Create Equipment Event Dialog");
        logCompare(true, b2wScheduler.setEventEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setEventType(sEquipmentEventType), "Set Equipment Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Equipment Event Type");
        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sLocationEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }

    public void createLocationEvent() {
        /*
         * 1. Open Schedule View with Location Schedule
         * 2. Count number existing events for resource.
         * 3. Open New Location Event Dialog
         * 4. Fill all fields (Location, Event Type, Notes)
         * 5. Save New Location Event
         * 6. Count number existing events for resource
         * 7. Check that the counts difference equal 1
         */
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sLocationView, sLocationView), "Open Places Schedule View");
        int initialCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType);
        logCompare(true, b2wScheduler.createNewLocationEvent(), "Open Create Location Event Dialog");
        logCompare(true, b2wScheduler.setEventLocation(sJobSiteName), "Set Job Site");
        logCompare(true, b2wScheduler.setEventType(sLocationEventType), "Set Location Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Location Event Type");
        int actualCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType);
        logCompare(true, actualCount == initialCount + 1, "Verification that Assignment has been created.");
    }
}
