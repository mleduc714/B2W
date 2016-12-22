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
        1. Create Employee Schedule View        - Done
        2. Create Equipment Schedule View       - Done
        3. Create Crew Schedule View            - Done
        4. Create Location Schedule View        - Done
        5. Create Employee Assignment           - Done
        6. Create Equipment Assignment          - Done
        7. Create Employee Need                 - Done
        8. Create Equipment Need                - Done
        9. Create Crew Assignment               - Done
        10.	Create Crew Need                    - Done
        11.	Create Move Assignment              - Done
        12.	Create Move Order                   - Done
        13.	Create Employee Event               - Done
        14.	Create Equipment Event              - Done
        15.	Create Location Event               - Done
        16. Create Employee Substitution        - Done
        17.	Move Employee Assignment            - Done
        18.	Move Equipment Assignment           - Done
        19.	Move Employee Need                  - Done
        20.	Move Equipment Need                 - Done
        21.	Move Crew Assignment                - Done
        22.	Move Crew Need                      - Done
        23.	Move Move Assignment                - Done
        24.	Move Move Order                     - Done
        25.	Move Employee Event                 - Done
        26.	Move Equipment Event                - Done
        27.	Move Location Event                 - Done
        28. Move Employee Substitution          - Done
        29.	Update Employee Assignment          - Done
        30.	Update Equipment Assignment         - Done
        31.	Update Employee Need                - Done
        32.	Update Equipment Need               - Done
        33.	Update Crew Assignment              - Done
        34.	Update Crew Need                    - Done
        35.	Update Move Assignment              - Done
        36.	Update Move Order                   - Done
        37.	Update Employee Event               - Done
        38.	Update Equipment Event              - Done
        39.	Update Location Event               - Done
        40. Update Employee Substitution        - Done
        41. Resize Employee Assignment          - Done
        42. Resize Equipment Assignment         - Done
        43. Resize Employee Need                - Done
        44. Resize Equipment Need               - Done
        45. Resize Crew Assignment              - Done
        46. Resize Crew Need                    - Done
        47. Resize Move Assignment              - Done
        48. Resize Move Order                   - Done
        49. Resize Employee Event               - Done
        50. Resize Equipment Event              - Done
        51. Resize Location Event               - Done
        52. View Orders and Need Panel
        53. View Conflicts Panel
        54. Fill Assignment Need
        55. Fill Equipment Need
        56. Fill Crew Need
        57. Fill Move Order
        58. View Employee Resource Tooltip
        59. View Equipment Resource Tooltip
        60. View Crew Resource Tooltip
        61. View JobSite Resource Tooltip
        62. View Places Resource Tooltip
        63. View Employee Assignment Tooltip
        64. View Employee Need Tooltip
        65. View Equipment Assignment Tooltip
        66. View Equipment Need Tooltip
        67. View Crew Assignment Tooltip
        68. View Crew Need Tooltip
        69. View Move Assignment Tooltip
        70. View Move Order Tooltip
        71. View Employee Event Tooltip
        72. View Equipment Event Tooltip
        73. View Location Event Tooltip
        74. View Schedule Alerts for Column
        75. View Schedule Alerts for Resource
        76.	Delete Employee Assignment          - Done
        77.	Delete Equipment Assignment         - Done
        78.	Delete Employee Need                - Done
        79.	Delete Equipment Need               - Done
        80.	Delete Crew Assignment              - Done
        81.	Delete Crew Need                    - Done
        81.	Delete Move Assignment              - Done
        82.	Delete Move Order                   - Done
        83.	Delete Employee Event               - Done
        84.	Delete Equipment Event              - Done
        85.	Delete Location Event               - Done
        86.	Delete Employee Schedule View       - Done
        87.	Delete Equipment Schedule View      - Done
        88.	Delete Crew Schedule View           - Done
        89.	Delete Location Schedule View       - Done
        90. Delete Employee Substitution        - Done
    */

    private final B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    private final B2WSchedulerTasks b2wScheduler = new B2WSchedulerTasks();
    private final B2WSchedulesTasks b2wSchedulesTasks = new B2WSchedulesTasks();

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
    private String sEmployeeView;
    private String sEquipmentView;
    private String sCrewView;
    private String sLocationView;
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
        sScheduleName = getProperty("sGeneralScheduleName");
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
        //=== Setup Schedule View
        createNewEmployeeScheduleView();
        createNewEquipmentScheduleView();
        createNewCrewScheduleView();
        createNewJobSiteScheduleView();

        //=== Create Schedule Assignments
        //createEmployeeAssignment(sEmployeeView, sEmployeeName, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createEmployeeAssignment(sEmployeeView, sEmployeeNameForSubstitution, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createEmployeeSubstitution(sEmployeeView, sEmployeeNameForSubstitution, sEmployeeSubstitution, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        //createEmployeeNeed(sEmployeeView, sEmployeeNeedName, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createEmployeeNeed(sEmployeeView, sEmployeeNeedName1, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createEquipmentAssignment(sEquipmentView, sEquipmentName, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createEquipmentNeed(sEquipmentView, sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        //createEquipmentNeed(sEquipmentView, sEquipmentNeedNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        //createCrewAssignment(sCrewView, sCrewName, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createCrewNeed(sCrewView, sCrewNeedName, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createCrewNeed(sCrewView, sCrewNeedNameUpd, sJobSiteName, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        //createMoveAssignment(sEquipmentView, sEquipmentName, sDropoffJobSiteName, sPickupJobSiteName, sTransportationCrewName, sPickupDate, sPickupTime, sDropoffDate, sDropoffTime);
        //createMoveOrder(sEquipmentView, sEquipmentName, sDropoffJobSiteName, sPickupJobSiteName, sPickupDate, sPickupTime,sDropoffDate, sDropoffTime, sRequestedBy, sNotesText);
        //createEmployeeEvent(sEmployeeView, sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        //createEquipmentEvent(sEquipmentView, sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        //createLocationEvent(sLocationView, sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);

        //=== Move Assignments
        //moveEmployeeAssignment();
        //moveSubstitution();
        //moveEmployeeNeed();
        //moveEquipmentAssignment();
        //moveEquipmentNeed();
        //moveCrewAssignment();
        //moveCrewNeed();
        //moveMoveAssignment();
        //moveMoveOrder();
        //moveEmployeeEvent();
        //moveEquipmentEvent();
        //moveLocationEvent();

        //=== Edit Assignments
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

        //=== Resize Assignments
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

        //=== Conflict Panel
        verifyEmployeeAssignmentConflict();
        verifyEquipmentAssignmentConflict();
        //ToDo: SCHED-2738
        //verifyCrewAssignmentConflict();
        verifyMoveAssignmentConflict();
        verifyEmployeeEventConflict();
        verifyEquipmentEventConflict();

        //=== Order Panel
        verifyEmployeeNeedOrder();

        //=== Delete Assignments
        deleteEmployeeAssignment(sEmployeeView, sEmployeeNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        deleteEmployeeAssignment(sDefaultEmployeeView, sEmployeeNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        deleteEmployeeNeed(sEmployeeView, sEmployeeNeedNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        deleteEmployeeNeed(sEmployeeView, sEmployeeNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
        deleteEquipmentAssignment(sEquipmentView, sEquipmentNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        deleteEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        deleteEquipmentNeed(sEquipmentNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
        deleteCrewAssignment(sCrewView, sCrewNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        deleteCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        deleteCrewNeed(sCrewNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
        //TODO: Issue with APP
        //deleteMoveAssignment(sEquipmentView, sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
        deleteMoveAssignment(sEquipmentView, sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
        deleteMoveOrder();
        deleteEmployeeSubstitution();
        deleteEmployeeAssignment(sEmployeeView, sEmployeeNameForSubstitution, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        deleteEmployeeEvent(sEmployeeView, sEmployeeNameUpd, sEmployeeEventTypeUpd, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
        deleteEquipmentEvent(sEquipmentView, sEquipmentNameUpd, sEquipmentEventTypeUpd, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
        deleteLocationEvent();

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

        createScheduleView(sEmployeeView, sBU, sSchedulesNotes, sGroupingLevel1, sGroupingLevel2, sFilterType, sFilterValue, sSecurityRole, sView, itemList);
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

        createScheduleView(sEquipmentView, sBU, sSchedulesNotes, sGroupingLevel1, sGroupingLevel2, sFilterType, sFilterValue, sSecurityRole, sView, itemList);
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
        item1.setResourceName("Transport Crews");
        itemList.add(item1);

        createScheduleView(sCrewView, sBU, sSchedulesNotes, sGroupingLevel1, sGroupingLevel2, sFilterType, sFilterValue, sSecurityRole, sView, itemList);
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

        createScheduleView(sLocationView, sBU, sSchedulesNotes, sGroupingLevel1, sGroupingLevel2, sFilterType, sFilterValue, sSecurityRole, sView, itemList);
    }

    public void createScheduleView(String sScheduleViewName, String sBUName, String sSchedulesNotes, String sGroupingLevel1,
                                   String sGroupingLevel2, String sFilterType, String sFilterValue, String sSecurityRole,
                                   String sView, List<B2WScheduleItem> itemList) {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Open Create Schedule View dialog.
         * 3. Fill all fields (Name, BU, Notes, Items, Grouping Level1, Grouping Level 2, Filter, Security Roles)
         * 4. Save Schedule View
         * 5. Check that Schedule View has been created.
         */

        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.clickCreateScheduleViewDialog(), "Open Create Schedule View dialog.");
        logCompare(true, b2wSchedulesTasks.setName(sScheduleViewName), "Set Name");
        logCompare(true, b2wSchedulesTasks.setBU(sBUName), "Select BU");
        logCompare(true, b2wSchedulesTasks.setNotes(sSchedulesNotes), "Set Notes");
        logCompare(true, b2wSchedulesTasks.setScheduleFormat(sView), "Select Schedule Format");
        logCompare(true, b2wSchedulesTasks.setItems(itemList), "Select Items on Schedule");
        logCompare(true, b2wSchedulesTasks.setGrouping("Group items by", sGroupingLevel1), "Select Grouping item by");
        logCompare(true, b2wSchedulesTasks.setGrouping("Secondary grouping", sGroupingLevel2), "Select Secondary grouping");
        logCompare(true, b2wSchedulesTasks.setFilter(sFilterType, sFilterValue), "Set Filter");
        logCompare(true, b2wSchedulesTasks.setSecurityAccess("Restricted Access", b2wSchedulesTasks.SECURITY_ROLE, sSecurityRole), "Select Security Role");
        logCompare(true, b2wSchedulesTasks.saveSchedule(), "Save " + sScheduleViewName + " Schedule View");
        logCompare(true, b2wSchedulesTasks.isScheduleExist(sScheduleViewName), "Check that " + sScheduleViewName + " Schedule View has been created.");
    }

    //=== Update Schedule View ===
    public void updateScheduleView() {
        logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        logCompare(true, b2wSchedulesTasks.selectScheduleView(sScheduleName), "Select Schedule View.");
        logCompare(true, b2wSchedulesTasks.clickUpdateScheduleViewDialog(), "Open Edit Schedule View Dialog.");

    }

    //=== Create Assignments/Needs/Orders/Events ===
    public void createEmployeeAssignment(String sScheduleView, String sEmployeeName, String sJobSiteName, String sRequestedBy,
                                         String sNotesText, String sAssignmentStartTime, String sAssignmentDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sJobSiteName, b2wScheduler.EMPLOYEE_TYPE);
        logCompare(true, b2wScheduler.createNewEmployeeAssignment(), "Open Create Employee Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployees(sEmployeeName), "Set Employee");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Start Time");
        logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Save New Employee Assignment");

        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sJobSiteName, b2wScheduler.EMPLOYEE_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Employee Assignment has been created.");
        WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true,  result != null, "Verification that specific Employee Assignment has been created.");
    }

    public void createEquipmentAssignment(String sScheduleView, String sEquipmentName, String sJobSiteName, String sRequestedBy,
                                          String sNotesText, String sAssignmentStartTime, String sAssignmentDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName, b2wScheduler.EQUIPMENT_TYPE);
        logCompare(true, b2wScheduler.createNewEquipmentAssignment(), "Open Create Equipment Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEquipmentAssignment(), "Save New Equipment Assignment");

        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName, b2wScheduler.EQUIPMENT_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Assignment has been created.");
        WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true,  result != null, "Verification that specific Equipment Assignment has been created.");
    }

    public void createEmployeeNeed(String sScheduleView, String sEmployeeNeedName, String sJobSiteName, String sRequestedBy, String sNotesText, String sAssignmentStartTime, String sAssignmentDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeNeedName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName, b2wScheduler.EMPLOYEE_NEED_TYPE);
        logCompare(true, b2wScheduler.createNewEmployeeNeed(), "Open Create Employee Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployeeNeed(sEmployeeNeedName), "Set Employee Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By/**/");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveEmployeeNeed(), "Save New Employee Need");

        //ToDo remove after fix SCHED-3321
        logCompare(true, b2wScheduler.expandAll(), "Expand All Levels");
        //=============================

        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName, b2wScheduler.EMPLOYEE_NEED_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Employee Need has been created.");
        WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true,  result != null, "Verification that specific Employee Need has been created.");
    }

    public void createEquipmentNeed(String sScheduleView, String sEquipmentNeedName, String sJobSiteName, String sStartDate, String sEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentNeedName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName, b2wScheduler.EQUIPMENT_NEED_TYPE);
        logCompare(true, b2wScheduler.createNewEquipmentNeed(), "Open Create Equipment Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipmentNeed(sEquipmentNeedName), "Set Equipment Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Duration");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Start Time");
        logCompare(true, b2wScheduler.saveEquipmentNeed(), "Save New Equipment Need");

        //ToDo remove after fix SCHED-3457
        logCompare(true, b2wScheduler.expandAll(), "Expand All levels");
        //=============================

        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName, b2wScheduler.EQUIPMENT_NEED_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Need has been created.");
        WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true,  result != null, "Verification that specific Equipment Need has been created.");
    }

    public void createCrewAssignment(String sScheduleView, String sCrewName, String sJobSiteName, String sRequestedBy, String sNotesText,
                                     String sAssignmentStartTime, String sAssignmentDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sCrewName);

        int initialCount = b2wScheduler.getAssignmentsCount(sCrewName, sJobSiteName, b2wScheduler.CREW_TYPE);
        logCompare(true, b2wScheduler.createNewCrewAssignment(), "Open Create Crew Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setCrew(sCrewName), "Set Crew");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveCrewAssignment(), "Save New Crew Assignment");

        int actualCount = b2wScheduler.getAssignmentsCount(sCrewName, sJobSiteName, b2wScheduler.CREW_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Crew Assignment has been created.");
        WebElement result = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true,  result != null, "Verification that specific Crew Assignment has been created.");
    }

    public void createCrewNeed(String sScheduleView, String sCrewNeedName, String sJobSiteName, String sRequestedBy, String sNotesText, String sAssignmentStartTime, String sAssignmentDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sCrewNeedName);

        int initialCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
        logCompare(true, b2wScheduler.createNewCrewNeed(), "Open Create New Crew Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setCrewNeed(sCrewNeedName), "Set Crew Need");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.setDuration(sAssignmentDuration), "Set Notes");
        logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTime), "Set Notes");
        logCompare(true, b2wScheduler.saveCrewNeed(), "Save New Crew Need");

        //ToDo remove after fix SCHED-3457
        logCompare(true, b2wScheduler.expandAll(), "Expand All Levels");
        /*
        logCompare(true, b2wScheduler.setSearchValue("aaa"), "Set Filter by Employee Need");
        logCompare(true, b2wScheduler.setSearchValue(sCrewNeedName), "Set Filter by Employee Need");
        */
        //===========================================

        int actualCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Crew Need has been created.");
        WebElement result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true,  result != null, "Verification that specific Crew Need has been created.");
    }

    public void createMoveAssignment(String sScheduleView, String sEquipmentName, String sDropoffJobSiteName, String sPickupJobSiteName,
                                     String sTransportationCrewName, String sPickupDate, String sPickupTime,
                                     String sDropoffDate, String sDropoffTime) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ASSIGNMENT_TYPE);
        logCompare(true, b2wScheduler.createNewMoveAssignment(), "Open Create Move Assignment Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupDate(sPickupDate), "Set Pickup Date");
        logCompare(true, b2wScheduler.setPickupTime(sPickupTime), "Set Pickup Time");
        logCompare(true, b2wScheduler.setDropoffDate(sDropoffDate), "Set Dropoff Date");
        logCompare(true, b2wScheduler.setDropoffTime(sDropoffTime), "Set Dropoff Time");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.clickSelectCrew(), "Open Select Crew Dialog");
        logCompare(true, b2wScheduler.setCrew(sTransportationCrewName), "Set Crew");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveMoveAssignment(), "Save New Move Assignment");

        //ToDo remove after fix SCHED-3321
        /*
        logCompare(true, b2wScheduler.setSearchValue("aaa"), "Set Filter");
        logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter");
        */
        //===========================================

        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ASSIGNMENT_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Move Assignment has been created.");
        //ToDo: Issue SCHED-3142
        //WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
        WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        logCompare(true,  result != null, "Verification that specific Move Assignment has been created.");
    }

    public void createMoveOrder(String sScheduleView, String sEquipmentName, String sDropoffJobSiteName, String sPickupJobSiteName,
                                String sPickupDate, String sPickupTime, String sDropoffDate, String sDropoffTime, String sRequestedBy,
                                String sNotesText) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ORDER_TYPE);
        logCompare(true, b2wScheduler.createNewMoveOrder(), "Open Create Move Order Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupAfter(sPickupDate), "Set Pickup After");
        logCompare(true, b2wScheduler.setPickupTime(sPickupTime), "Set Pickup Time");
        logCompare(true, b2wScheduler.setDropoffBefore(sDropoffDate), "Set Drop-off Before");
        logCompare(true, b2wScheduler.setDropoffTime(sDropoffTime), "Set Drop-off Time");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.setRequestedBy(sRequestedBy), "Set Requested By");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveMoveOrder(), "Save New Move Order");

        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ORDER_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Move Order has been created.");
        //ToDo: Issue SCHED-3142
        //WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
        WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        logCompare(true,  result != null, "Verification that specific Move Order has been created.");
    }

    public void createEmployeeEvent(String sScheduleView, String sEmployeeName, String sEmployeeEventType,
                                    String sEventStartDate, String sEventEndDate, String sEventStartTime, String sEventDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType, b2wScheduler.EMPLOYEE_EVENT_TYPE);
        logCompare(true, b2wScheduler.createNewEmployeeEvent(), "Open Create Employee Event Dialog");
        logCompare(true, b2wScheduler.setEventEmployee(sEmployeeName), "Set Employee");
        logCompare(true, b2wScheduler.setEventType(sEmployeeEventType), "Set Employee Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Employee Event Type");

        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType, b2wScheduler.EMPLOYEE_EVENT_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Employee Event has been created.");
        WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sEventStartDate, sEventEndDate, sEventStartTime, sEventDuration);
        logCompare(true,  result != null, "Verification that specific Employee Event has been created.");
    }

    public void createEquipmentEvent(String sScheduleView, String sEquipmentName, String sEquipmentEventType,
                                     String sEventStartDate, String sEventEndDate, String sEventStartTime, String sEventDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType, b2wScheduler.EQUIPMENT_EVENT_TYPE);
        logCompare(true, b2wScheduler.createNewEquipmentEvent(), "Open Create Equipment Event Dialog");
        logCompare(true, b2wScheduler.setEventEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setEventType(sEquipmentEventType), "Set Equipment Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Equipment Event Type");

        int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType, b2wScheduler.EQUIPMENT_EVENT_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Event has been created.");
        WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sEventStartDate, sEventEndDate, sEventStartTime, sEventDuration);
        logCompare(true,  result != null, "Verification that specific Equipment Event has been created.");
    }

    public void createLocationEvent(String sScheduleView, String sJobSiteName, String sLocationEventType,
                                    String sEventStartDate, String sEventEndDate, String sEventStartTime, String sEventDuration) {
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

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sJobSiteName);

        int initialCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType, b2wScheduler.LOCATION_EVENT_TYPE);
        logCompare(true, b2wScheduler.createNewLocationEvent(), "Open Create Location Event Dialog");
        logCompare(true, b2wScheduler.setEventLocation(sJobSiteName), "Set Job Site");
        logCompare(true, b2wScheduler.setEventType(sLocationEventType), "Set Location Event Type");
        logCompare(true, b2wScheduler.setNotes(sNotesText), "Set Notes");
        logCompare(true, b2wScheduler.saveEvent(), "Save New Location Event Type");

        int actualCount = b2wScheduler.getAssignmentsCount(sJobSiteName, sLocationEventType, b2wScheduler.LOCATION_EVENT_TYPE);
        logCompare(true, actualCount == initialCount + 1, "Verification that JobSite Event has been created.");
        WebElement result = b2wScheduler.getLocationEvent(sJobSiteName, sLocationEventType, sEventStartDate, sEventEndDate, sEventStartTime, sEventDuration);
        logCompare(true,  result != null, "Verification that specific JobSite Event has been created.");
    }

    public void createEmployeeSubstitution(String sScheduleView, String sEmployeeName, String sEmployeeSubstitution, String sJobSiteName, String sStartDate,
                                           String sEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View with Employee Schedule
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Count number existing substitutions for resource.
         * 6. Open New Substitution Dialog
         * 7. Fill all fields (Location, Event Type, Notes)
         * 8. Save Substitution
         * 9. Count number existing substitutions for resource.
         * 10. Check that the counts difference equal 1
         * 11. Check that the particular substitution was created
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.createSubstitution(), "Select 'Create Substitution' option");
            logCompare(true, b2wScheduler.setEmployee(sEmployeeSubstitution), "Set Employee Substitution");
            logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Save Employee Substitution");

            WebElement result = b2wScheduler.getEmployeeSubstituted(sEmployeeName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result != null, "Verification that specific Assignment converted to Substituted.");
            logCompare(true, b2wScheduler.setSearchValue(sEmployeeSubstitution), "Set Filter by Employee Name");
            result = b2wScheduler.getEmployeeSubstitution(sEmployeeSubstitution, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result != null, "Verification that specific Substitution has been created.");
        } else {
            logCompare(true, false, "Employee Assignment for " + sEmployeeName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.editAssignment(), "Select 'Edit Assignment' option");
            logCompare(true, b2wScheduler.updateJobSite(sJobSiteNameUpd), "Update JobSite/Place");
            logCompare(true, b2wScheduler.updateEmployees(sEmployeeNameUpd), "Update Employee");
            logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
            logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
            logCompare(true, b2wScheduler.setDuration(sAssignmentDurationUpd), "Update Duration");
            logCompare(true, b2wScheduler.setStartTime(sAssignmentStartTimeUpd), "Update Start Time");
            logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Update Employee Assignment");
            logCompare(true, b2wScheduler.setSearchValue(sEmployeeNameUpd), "Set Filter by updated Employee Name");

            WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Employee Assignment has been updated.");
        } else {
            logCompare(true, false, "Employee Assignment for " + sEmployeeName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
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
            WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Equipment Assignment has been updated.");
        } else {
            logCompare(true, false, "Equipment Assignment for " + sEquipmentName + " could not be found on the page." );
        }
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

        NavigateToScheduleView(sEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeNeedName);

        WebElement assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
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
            WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Employee Need has been updated.");
        } else {
            logCompare(true, false, "Employee Need for " + sEmployeeNeedName + " could not be found on the page." );
        }
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

        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentNeedName);

        WebElement assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
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
            WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Equipment Need has been updated.");
        } else {
            logCompare(true, false, "Equipment Need for " + sEquipmentNeedName + " could not be found on the page." );
        }
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

        NavigateToScheduleView(sCrewView, sCalendarStartDate, sCalendarDateRange, sCrewName);

        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
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
            WebElement result = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Crew Assignment has been updated.");
        } else {
            logCompare(true, false, "Crew Assignment for " + sCrewName + " could not be found on the page." );
        }
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

        NavigateToScheduleView(sCrewView, sCalendarStartDate, sCalendarDateRange, sCrewNeedName);

        WebElement assignment = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
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
            WebElement result = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Crew Need has been updated.");
        } else {
            logCompare(true, false, "Crew Need for " + sCrewNeedName + " could not be found on the page." );
        }
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

        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        if (assignment != null) {
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
            //ToDo: Issue SCHED-3142
            //WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
            WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
            logCompare(true, result != null, "Verification that specific Move Assignment has been updated.");
        } else {
            logCompare(true, false, "Move Assignment for " + sEquipmentName + " could not be found on the page." );
        }
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

        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Order's Context Menu");
            logCompare(true, b2wScheduler.editMoveOrder(), "Select 'Edit Move Order' option");
            logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteNameUpd), "Update Pickup Location");
            logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteNameUpd), "Update Drop-off Location");
            logCompare(true, b2wScheduler.updateRequestedBy(sRequestedByUpd), "Update Requested By");
            logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
            logCompare(true, b2wScheduler.saveMoveOrder(), "Update Move Order");
            logCompare(true, b2wScheduler.setSearchValue(sEquipmentName), "Set Filter by updated Equipment Name");
            //ToDo: Issue SCHED-3142
            //WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
            WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
            logCompare(true, result != null, "Verification that specific Move Order has been updated.");
        } else {
            logCompare(true, false, "Move Order for " + sEquipmentName + " could not be found on the page." );
        }
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

        NavigateToScheduleView(sEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
            logCompare(true, b2wScheduler.editEvent(), "Select 'Edit Event' option");
            logCompare(true, b2wScheduler.updateEventEmployee(sEmployeeNameUpd), "Update Employee");
            logCompare(true, b2wScheduler.setEventType(sEmployeeEventTypeUpd), "Update Employee Event Type");
            logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
            logCompare(true, b2wScheduler.saveEvent(), "Update Employee Event");
            logCompare(true, b2wScheduler.setSearchValue(sEmployeeNameUpd), "Set Filter by updated Employee Name");
            WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Employee Event has been updated.");
        } else {
            logCompare(true, false, "Employee Event for " + sEmployeeName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
            logCompare(true, b2wScheduler.editEvent(), "Select 'Edit Event' option");
            logCompare(true, b2wScheduler.updateEventEquipment(sEquipmentNameUpd), "Update Equipment");
            logCompare(true, b2wScheduler.setEventType(sEquipmentEventTypeUpd), "Update Equipment Event Type");
            logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
            logCompare(true, b2wScheduler.saveEvent(), "Update Equipment Event");
            logCompare(true, b2wScheduler.setSearchValue(sEquipmentNameUpd), "Set Filter by updated Employee Name");
            WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Equipment Event has been updated.");
        } else {
            logCompare(true, false, "Equipment Event for " + sEquipmentName + " could not be found on the page.");
        }
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

        //ToDo: Issue with grouping on Location View
        //NavigateToScheduleView(sLocationView, sCalendarStartDate, sCalendarDateRange, sJobSiteName);
        NavigateToScheduleView(sDefaultLocationView, sCalendarStartDate, sCalendarDateRange, sJobSiteName);

        WebElement assignment = b2wScheduler.getLocationEvent(sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {

            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
            logCompare(true, b2wScheduler.editEvent(), "Select 'Edit Event' option");
            logCompare(true, b2wScheduler.updateEventLocation(sJobSiteNameUpd), "Update Location");
            logCompare(true, b2wScheduler.setEventType(sLocationEventTypeUpd), "Update Location Event Type");
            logCompare(true, b2wScheduler.updateNotes(sNotesTextUpd), "Update Notes");
            logCompare(true, b2wScheduler.saveEvent(), "Update Equipment Event");
            logCompare(true, b2wScheduler.setSearchValue(sJobSiteNameUpd), "Set Filter by updated Location Name");
            WebElement result = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Location Event has been updated.");
        } else {
            logCompare(true, false, "Location Event for " + sJobSiteName + " could not be found on the page.");
        }
    }

    public void updateSubstitution() {
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

        NavigateToScheduleView(sEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeSubstitution);

        WebElement assignment = b2wScheduler.getEmployeeSubstitution(sEmployeeSubstitution, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.editSubstitution(), "Select 'Edit Substitution' option");
            logCompare(true, b2wScheduler.updateEmployee(sEmployeeNameUpd), "Update Employee");
            logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Update Employee Substitution");

            logCompare(true, b2wScheduler.setSearchValue(sEmployeeNameUpd), "Set Filter by updated Employee Name");
            //WebElement result = b2wScheduler.getEmployeeSubstitution(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            WebElement result = b2wScheduler.getEmployeeSubstitution(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result != null, "Verification that specific Employee Assignment has been updated.");
        } else {
            logCompare(true, false, "Employee substitution " + sEmployeeSubstitution + " could not be found on the page.");
        }
    }

    //=== Copy Assignments/Needs/Orders/Events ===
    public void copyEmployeeAssignment(String sScheduleView, String sEmployeeName, String sJobSiteName, String sAssignmentStartDate,
                                       String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Copy from context menu
         * 8. Save Assignment
         * 9. Verify that Assignment was created.
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        int initialCount = b2wScheduler.getEmployeeAssignments(sEmployeeName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);

        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.copyAssignment(), "Select 'Copy Assignment' option");
            logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Save Copy of Employee Assignment");

            int actualCount = b2wScheduler.getEmployeeAssignments(sEmployeeName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
            logCompare(true, actualCount == initialCount + 1, "Verification that Employee Assignment has been created.");
        } else {
            logCompare(true, false, "Employee Assignment for " + sEmployeeName + " could not be found on the page.");
        }
    }

    public void copyEquipmentAssignment(String sScheduleView, String sEquipmentName, String sJobSiteName, String sAssignmentStartDate,
                                       String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Copy from context menu
         * 8. Save Assignment
         * 9. Verify that Assignment was created.
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getEquipmentAssignments(sEquipmentName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);

        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.copyAssignment(), "Select 'Copy Assignment' option");
            logCompare(true, b2wScheduler.saveEquipmentAssignment(), "Save Copy of Equipment Assignment");

            int actualCount = b2wScheduler.getEquipmentAssignments(sEquipmentName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
            logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Assignment has been created.");
        } else {
            logCompare(true, false, "Equipment Assignment for " + sEquipmentName + " could not be found on the page.");
        }
    }

    public void copyCrewAssignment(String sScheduleView, String sCrewName, String sJobSiteName, String sAssignmentStartDate,
                                        String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Copy from context menu
         * 8. Save Assignment
         * 9. Verify that Assignment was created.
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sCrewName);

        int initialCount = b2wScheduler.getCrewAssignments(sCrewName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);

        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.copyAssignment(), "Select 'Copy Assignment' option");
            logCompare(true, b2wScheduler.saveCrewAssignment(), "Save Copy of Crew Assignment");

            int actualCount = b2wScheduler.getCrewAssignments(sCrewName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
            logCompare(true, actualCount == initialCount + 1, "Verification that Crew Assignment has been created.");
        } else {
            logCompare(true, false, "Crew Assignment for " + sCrewName + " could not be found on the page.");
        }
    }

    public void copyMoveAssignment(String sScheduleView, String sMoveAssignment, String sDropoffJobSiteName, String sAssignmentStartDate,
                                   String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Copy from context menu
         * 8. Save Assignment
         * 9. Verify that Assignment was created.
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sMoveAssignment);

        int initialCount = b2wScheduler.getMoveAssignments(sMoveAssignment, sDropoffJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
        WebElement assignment = b2wScheduler.getMoveAssignment(sMoveAssignment, sDropoffJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);

        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.copyMoveAssignment(), "Select 'Copy Move Assignment' option");
            logCompare(true, b2wScheduler.saveMoveAssignment(), "Save Copy of Move Assignment");

            int actualCount = b2wScheduler.getMoveAssignments(sMoveAssignment, sDropoffJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
            logCompare(true, actualCount == initialCount + 1, "Verification that Move Assignment has been created.");
        } else {
            logCompare(true, false, "Move Assignment for " + sMoveAssignment + " could not be found on the page.");
        }
    }

    public void copyEmployeeEvent(String sScheduleView, String sEmployeeName, String sEmployeeEventType, String sAssignmentStartDate,
                                       String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Copy from context menu
         * 8. Save Assignment
         * 9. Verify that Assignment was created.
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);
        int initialCount = b2wScheduler.getEmployeeEvents(sEmployeeName, sEmployeeEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);

        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Events's Context Menu");
            logCompare(true, b2wScheduler.copyEvent(), "Select 'Copy Event' option");
            logCompare(true, b2wScheduler.saveEvent(), "Save Copy of Employee Event");

            int actualCount = b2wScheduler.getEmployeeEvents(sEmployeeName, sEmployeeEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
            logCompare(true, actualCount == initialCount + 1, "Verification that Employee Event has been created.");
        } else {
            logCompare(true, false, "Employee Event for " + sEmployeeName + " could not be found on the page.");
        }
    }

    public void copyEquipmentEvent(String sScheduleView, String sEquipmentName, String sEquipmentEventType, String sAssignmentStartDate,
                                  String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Copy from context menu
         * 8. Save Assignment
         * 9. Verify that Assignment was created.
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);
        int initialCount = b2wScheduler.getEquipmentEvents(sEquipmentName, sEquipmentEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);

        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Events's Context Menu");
            logCompare(true, b2wScheduler.copyEvent(), "Select 'Edit Event' option");
            logCompare(true, b2wScheduler.saveEvent(), "Save Copy of Equipment Event");

            int actualCount = b2wScheduler.getEquipmentEvents(sEquipmentName, sEquipmentEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
            logCompare(true, actualCount == initialCount + 1, "Verification that Equipment Event has been created.");
        } else {
            logCompare(true, false, "Equipment Event for " + sEquipmentName + " could not be found on the page.");
        }
    }

    public void copyLocationEvent(String sScheduleView, String sJobSiteName, String sLocationEventType, String sAssignmentStartDate,
                                   String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range
         * 3. Change Start Date
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Select Copy from context menu
         * 8. Save Assignment
         * 9. Verify that Assignment was created.
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sJobSiteName);
        int initialCount = b2wScheduler.getLocationEvents(sJobSiteName, sLocationEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
        WebElement assignment = b2wScheduler.getLocationEvent(sJobSiteName, sLocationEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);

        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Events's Context Menu");
            logCompare(true, b2wScheduler.copyEvent(), "Select 'Edit Event' option");
            logCompare(true, b2wScheduler.saveEvent(), "Save Copy of Location Event");

            int actualCount = b2wScheduler.getLocationEvents(sJobSiteName, sLocationEventType, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration).size();
            logCompare(true, actualCount == initialCount + 1, "Verification that Location Event has been created.");
        } else {
            logCompare(true, false, "Location Event for " + sJobSiteName + " could not be found on the page.");
        }
    }

    //=== Conflicts ===
    public void checkResourceConflict(String sScheduleView, String sResourceName, String sJobSiteName, String sAssignmentStartDate,
                                      String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration, String sAssignmentType) {
        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, "");

        logCompare(true, b2wScheduler.conflictIconIsDisplayed(sResourceName, sAssignmentType), "Check that Conflict Icon is displayed.");
        logCompare(true, b2wScheduler.openConflictPanel(), "Open Conflict panel.");
        WebElement conflict = b2wScheduler.getConflictForResource(sResourceName);
        if (conflict != null) {
            logCompare(true, b2wScheduler.selectConflict(conflict), "Select Conflict on the panel..");
            WebElement assignment = b2wScheduler.getAssignment(sResourceName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration, sAssignmentType);
            if ( assignment != null) {
                logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
                if (sAssignmentType.equals(b2wScheduler.EMPLOYEE_EVENT_TYPE) || sAssignmentType.equals(b2wScheduler.EQUIPMENT_EVENT_TYPE)) {
                    logCompare(true, b2wScheduler.deleteEvent(), "Delete Event");
                } else if (sAssignmentType.equals(b2wScheduler.EMPLOYEE_NEED_TYPE) || sAssignmentType.equals(b2wScheduler.EQUIPMENT_NEED_TYPE) || sAssignmentType.equals(b2wScheduler.CREW_NEED_TYPE)) {
                    logCompare(true, b2wScheduler.deleteNeed(), "Delete Need");
                } else {
                    logCompare(true, b2wScheduler.deleteAssignment(), "Delete Assignment");
                }
                b2wScheduler.waitForSchedulePageNoBusy();
                logCompare(false, b2wScheduler.conflictIconIsDisplayed(sResourceName, sAssignmentType), "Check that Conflict Icon is not displayed anymore.");
                logCompare(true, b2wScheduler.closeConflictPanel(), "Check that Conflict Panel is closed.");
            } else {
                log.debug("Could not find assignment.");
            }
        } else {
            logCompare(true, false, "Conflict for " + sResourceName + " could not be found on the page.");
        }
    }

    public void checkEmployeeResourceConflict(String sScheduleView, String sResourceName, String sJobSiteName, String sAssignmentStartDate,
                                               String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        checkResourceConflict(sScheduleView, sResourceName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration, b2wScheduler.EMPLOYEE_TYPE);
    }

    public void checkEquipmentResourceConflict(String sScheduleView, String sResourceName, String sJobSiteName, String sAssignmentStartDate,
                                              String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        checkResourceConflict(sScheduleView, sResourceName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration, b2wScheduler.EQUIPMENT_TYPE);
    }

    public void checkCrewResourceConflict(String sScheduleView, String sResourceName, String sJobSiteName, String sAssignmentStartDate,
                                               String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        checkResourceConflict(sScheduleView, sResourceName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration, b2wScheduler.CREW_TYPE);
    }

    public void checkMoveResourceConflict(String sScheduleView, String sResourceName, String sJobSiteName, String sAssignmentStartDate,
                                          String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        checkResourceConflict(sScheduleView, sResourceName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration, b2wScheduler.MOVE_ASSIGNMENT_TYPE);
    }

    public void checkEmployeeEventConflict(String sScheduleView, String sResourceName, String sJobSiteName, String sAssignmentStartDate,
                                              String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        checkResourceConflict(sScheduleView, sResourceName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration, b2wScheduler.EMPLOYEE_EVENT_TYPE);
    }

    public void checkEquipmentEventConflict(String sScheduleView, String sResourceName, String sJobSiteName, String sAssignmentStartDate,
                                           String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        checkResourceConflict(sScheduleView, sResourceName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration, b2wScheduler.EQUIPMENT_EVENT_TYPE);
    }

    //=== Conflict Panel
    public void verifyEmployeeAssignmentConflict() {
        createEmployeeAssignment(sDefaultEmployeeView, sConflictEmployeeName, sConflictJobSite, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        copyEmployeeAssignment(sDefaultEmployeeView, sConflictEmployeeName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        checkEmployeeResourceConflict(sDefaultEmployeeView, sConflictEmployeeName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        deleteEmployeeAssignment(sDefaultEmployeeView, sConflictEmployeeName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
    }

    public void verifyEquipmentAssignmentConflict() {
        createEquipmentAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        copyEquipmentAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        checkEquipmentResourceConflict(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        deleteEquipmentAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
    }

    public void verifyCrewAssignmentConflict() {
        createCrewAssignment(sDefaultCrewView, sConflictCrewName, sConflictJobSite, sRequestedBy, sNotesText, sAssignmentStartTime, sAssignmentDuration);
        copyCrewAssignment(sDefaultCrewView, sConflictCrewName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        checkCrewResourceConflict(sDefaultCrewView, sConflictCrewName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        deleteCrewAssignment(sDefaultCrewView, sConflictCrewName, sConflictJobSite, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
    }

    public void verifyMoveAssignmentConflict() {
        createMoveAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sPickupJobSiteName,
                sTransportationCrewName, sPickupDate, sPickupTime, sDropoffDate, sDropoffTime);
        //Todo: Issue SCHED-3142
        //copyMoveAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sPickupDate, sPickupTime, sDropoffDate, sDropoffTime);
        copyMoveAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        //ToDo: Functionality is not implemented in the APP yet.
        // checkMoveResourceConflict(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        //=== Temp solution
        logCompare(true, b2wScheduler.conflictIconIsDisplayed(sConflictEquipmentName, b2wScheduler.MOVE_ASSIGNMENT_TYPE), "Check that Conflict Icon is displayed.");
        deleteMoveAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        logCompare(false, b2wScheduler.conflictIconIsDisplayed(sConflictEquipmentName, b2wScheduler.MOVE_ASSIGNMENT_TYPE), "Check that Conflict Icon is displayed.");
        //=================
        deleteMoveAssignment(sDefaultEquipmentView, sConflictEquipmentName, sConflictJobSite, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
    }

    public void verifyEmployeeEventConflict() {
        createEmployeeEvent(sDefaultEmployeeView, sConflictEmployeeName, sConflictEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        copyEmployeeEvent(sDefaultEmployeeView, sConflictEmployeeName, sConflictEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        checkEmployeeEventConflict(sDefaultEmployeeView, sConflictEmployeeName, sConflictEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        deleteEmployeeEvent(sDefaultEmployeeView, sConflictEmployeeName, sConflictEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
    }

    public void verifyEquipmentEventConflict() {
        createEquipmentEvent(sDefaultEquipmentView, sConflictEquipmentName, sConflictEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        copyEquipmentEvent(sDefaultEquipmentView, sConflictEquipmentName, sConflictEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        checkEquipmentEventConflict(sDefaultEquipmentView, sConflictEquipmentName, sConflictEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        deleteEquipmentEvent(sDefaultEquipmentView, sConflictEquipmentName, sConflictEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
    }

    public void verifyLocationEventConflict() {


    }

    //=== Order Panel
    public void verifyEmployeeNeedOrder() {

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

        NavigateToScheduleView(sDefaultEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Assignment to the specific date");
            WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Employee Assignment was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            assignment = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeNameUpd, dCalendarStartDate), "Move Assignment to the specific date");
            result = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Assignment was moved to the specific date.");

            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(result, sEmployeeName, dCalendarStartDate), "Move Assignment to the specific date");
            result = b2wScheduler.getEmployeeAssignment(sEmployeeName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Assignment was moved to the specific date.");
        } else {
            logCompare(true, false, "Employee assignment for " + sEmployeeName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeNeedName);

        WebElement assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Need to the specific date");
            WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Employee Need was moved to the specific date.");

            //ToDo There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedName1, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeNeedName, dCalendarStartDate), "Move Need to the specific date");
            result = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Need was moved to the specific date.");
        } else {
            logCompare(true, false, "Employee Need for " + sEmployeeNeedName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Assignment to the specific date");
            WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Equipment Assignment was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            //Move assignment to the another resource
            assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentNameUpd, dCalendarStartDate), "Move Equipment Assignment to the specific date and another resource");
            result = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Assignment was moved to the specific date.");

            //Move assignment to the original date and resource
            assignment = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentName, dCalendarStartDate), "Move Equipment Assignment to the original date and resource");
            result = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Assignment was moved to the specific date.");
        } else {
            logCompare(true, false, "Equipment Assignment for " + sEquipmentName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentNeedName);

        //Move need to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Equipment Need to the specific date");
            WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Equipment Need was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            //Move need to the another resource
            assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentNeedName, dCalendarStartDate), "Move Equipment Need to the specific date and another resource");
            result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Need was moved to the specific date.");
        } else {
            logCompare(true, false, "Equipment Need for " + sEquipmentNeedName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultCrewView, sCalendarStartDate, sCalendarDateRange, sCrewName);

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Crew Assignment to the specific date");
            WebElement result = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Crew Assignment was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            //Move assignment to the another resource
            assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sCrewNameUpd, dCalendarStartDate), "Move Crew Assignment to the specific date and another resource");
            result = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Crew Assignment was moved to the specific date.");

            //Move assignment to the original date and resource
            assignment = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sCrewName, dCalendarStartDate), "Move Crew Assignment to the original date and resource");
            result = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Crew Assignment was moved to the specific date.");
        } else {
            logCompare(true, false, "Crew Assignment for " + sCrewName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultCrewView, sCalendarStartDate, sCalendarDateRange, sCrewNeedName);

        //Move need to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Crew Need to the specific date");
            WebElement result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sMoveDate, sMoveDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Crew Need was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            //Move need to the another resource
            assignment = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sCrewNeedName, dCalendarStartDate), "Move Crew Need to the specific date and another resource");
            result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Crew Need was moved to the specific date.");
        } else {
            logCompare(true, false, "Crew Need for " + sCrewNeedName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //Move assignment to the latest date in the calendar period.
        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Move Assignment to the specific date");
            //ToDo: Issue SCHED-3142
            //WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
            WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Move Assignment was moved to the specific date.");

            //ToDo: Issue SCHED-3142
            //assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
            assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dCalendarStartDate), "Move Move Assignment to the specific date");
            //ToDo: Issue SCHED-3142
            //result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
            result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Move Assignment was moved to the specific date.");
        } else {
            logCompare(true, false, "Move Assignment for " + sEquipmentName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //Move assignment to the latest date in the calendar period.
        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Move Order to the specific date");
            //ToDo: Issue SCHED-3142
            //WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
            WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Move Order was moved to the specific date.");

            //ToDo: Issue SCHED-3142
            //assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
            assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dCalendarStartDate), "Move Move Order to the specific date");
            //ToDo: Issue SCHED-3142
            //result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sPickupTime, sDropoffTime);
            result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteName, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Move Order was moved to the specific date.");
        } else {
            logCompare(true, false, "Move Order for " + sEquipmentName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Employee Event to the specific date");
            WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Employee Event was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            //logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");
            b2wScheduler.clearSearchValue();
            BrowserUtils.getDriver().navigate().refresh();
            b2wScheduler.waitForSchedulePageNoBusy();
            //=================

            assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeNameUpd, dCalendarStartDate), "Move Employee Event to the specific date");
            result = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Event was moved to the specific date.");

            assignment = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeName, dCalendarStartDate), "Move Employee Event to the specific date");
            result = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Event was moved to the specific date.");
        } else {
            logCompare(true, false, "Employee Event for " + sEmployeeName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Equipment Event to the specific date");
            WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Equipment Event was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            //Move assignment to the another resource
            assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentNameUpd, dCalendarStartDate), "Move Equipment Event to the specific date and another resource");
            result = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Event was moved to the specific date.");

            //Move assignment to the original date and resource
            assignment = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEquipmentName, dCalendarStartDate), "Move Equipment Event to the original date and resource");
            result = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Equipment Event was moved to the specific date.");
        } else {
            logCompare(true, false, "Equipment Event for " + sEquipmentName + " could be found on the page.");
        }
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

        NavigateToScheduleView(sDefaultLocationView, sCalendarStartDate, sCalendarDateRange, sJobSiteName);

        //Move assignment to the latest date in the calendar period.
        WebElement assignment = b2wScheduler.getLocationEvent(sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToDate(assignment, dMoveDate), "Move Location Event to the specific date");
            WebElement result = b2wScheduler.getLocationEvent(sJobSiteName, sLocationEventType, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dMoveDate), "Verify that Location Event was moved to the specific date.");

            //ToDo: There is a BUG in the APP
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");

            //Move assignment to the another resource
            assignment = b2wScheduler.getLocationEvent(sJobSiteName, sLocationEventType, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sJobSiteNameUpd, dCalendarStartDate), "Move Location Event to the specific date and another resource");
            result = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Location Event was moved to the specific date.");

            //Move assignment to the original date and resource
            assignment = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sJobSiteName, dCalendarStartDate), "Move Location Event to the original date and resource");
            result = b2wScheduler.getLocationEvent(sJobSiteName, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Location Event was moved to the specific date.");
        } else {
            logCompare(true, false, "Location Event for " + sJobSiteName + " could be found on the page.");
        }
    }

    public void moveSubstitution() {
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

        NavigateToScheduleView(sDefaultEmployeeView, sCalendarStartDate, sCalendarDateRange, "");

        WebElement assignment = b2wScheduler.getEmployeeSubstitution(sEmployeeSubstitution, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeNameUpd, dCalendarStartDate), "Move Assignment to the specific date");
            WebElement result = b2wScheduler.getEmployeeSubstitution(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Assignment was moved to the specific date.");

            assignment = b2wScheduler.getEmployeeSubstitution(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.moveAssignmentToResourceAndDate(assignment, sEmployeeSubstitution, dCalendarStartDate), "Move Assignment to the specific date");
            result = b2wScheduler.getEmployeeSubstitution(sEmployeeSubstitution, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, b2wScheduler.getAssignmentStartDate(result).equals(dCalendarStartDate), "Verify that Employee Assignment was moved to the specific date.");
        } else {
            logCompare(true, false, "Substitution for " + sEmployeeNameUpd + " could be found on the page.");
        }
    }

    //=== Resize Assignments/Needs/Orders/Events ===
    public void resizeEmployeeAssignment() {
        NavigateToScheduleView(sEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeNameUpd);

        WebElement assignment = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Employee Assignment has been resized.");

            assignment = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            result = b2wScheduler.getEmployeeAssignment(sEmployeeNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Employee Assignment has been resized.");
        } else {
            logCompare(true, false, "Employee Assignment for " + sEmployeeNameUpd + " could not be found on the page.");
        }
    }

    public void resizeEquipmentAssignment() {
        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentNameUpd);

        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Equipment Assignment has been resized.");

            assignment = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            result = b2wScheduler.getEquipmentAssignment(sEquipmentNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Equipment Assignment has been resized.");
        } else {
            logCompare(true, false, "Equipment Assignment for " + sEquipmentNameUpd + " could not be found on the page.");
        }
    }

    public void resizeCrewAssignment() {
        NavigateToScheduleView(sCrewView, sCalendarStartDate, sCalendarDateRange, sCrewNameUpd);

        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            WebElement result = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Crew Assignment has been resized.");

            assignment = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            result = b2wScheduler.getCrewAssignment(sCrewNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Crew Assignment has been resized.");
        } else {
            logCompare(true, false, "Crew Assignment for " + sCrewNameUpd + " could not be found on the page.");
        }
    }

    public void resizeEmployeeNeed() {
        NavigateToScheduleView(sEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeNeedNameUpd);

        WebElement assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Employee Need has been resized.");

            assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Need to the specific date");
            result = b2wScheduler.getEmployeeNeed(sEmployeeNeedNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Employee Need has been resized.");
        } else {
            logCompare(true, false, "Employee Need for " + sEmployeeNeedNameUpd + " could not be found on the page.");
        }
    }

    public void resizeEquipmentNeed() {
        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentNeedNameUpd);

        WebElement assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Equipment Need has been resized.");

            assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Need to the specific date");
            result = b2wScheduler.getEquipmentNeed(sEquipmentNeedNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Equipment Need has been resized.");
        } else {
            logCompare(true, false, "Equipment Need for " + sEquipmentNeedNameUpd + " could not be found on the page.");
        }
    }

    public void resizeCrewNeed() {
        NavigateToScheduleView(sCrewView, sCalendarStartDate, sCalendarDateRange, sCrewNeedNameUpd);

        WebElement assignment = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            WebElement result = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Crew Need has been resized.");

            assignment = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sCalendarStartDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Need to the specific date");
            result = b2wScheduler.getCrewNeed(sCrewNeedNameUpd, sJobSiteNameUpd, sMoveDate, sMoveDate, sAssignmentStartTimeUpd, sAssignmentDurationUpd);
            logCompare(true, result != null, "Verification that specific Crew Need has been resized.");
        } else {
            logCompare(true, false, "Crew Need for " + sCrewNeedNameUpd + " could not be found on the page.");
        }
    }

    public void resizeMoveAssignment() {
        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sPickupDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sPickupDate, sEventStartTime, sEventStartTime);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            //ToDo: Issue SCHED-3142
            //WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sPickupTime, sDropoffTime);
            WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, result != null, "Verification that specific Move Assignment has been resized.");

            //ToDo: Issue SCHED-3142
            //assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sPickupTime, sDropoffTime);
            assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Assignment to the specific date");
            //ToDo: Issue SCHED-3142
            //result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
            result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, result != null, "Verification that specific Move Assignment has been resized.");
        } else {
            logCompare(true, false, "Move Assignment for " + sEquipmentName + " could not be found on the page.");
        }
    }

    public void resizeMoveOrder() {
        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sDropoffDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sDropoffDate, sEventStartTime, sEventStartTime);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Order to the specific date");
            //ToDo: Issue SCHED-3142
            //WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sPickupTime, sDropoffTime);
            WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, result != null, "Verification that specific Move Order has been resized.");

            //ToDo: Issue SCHED-3142
            //assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sPickupTime, sDropoffTime);
            assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sPickupDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Order to the specific date");
            //ToDo: Issue SCHED-3142
            //result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
            result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, result != null, "Verification that specific Move Order has been resized.");
        } else {
            logCompare(true, false, "Move Order for " + sEquipmentName + " could not be found on the page.");
        }
    }

    public void resizeEmployeeEvent() {
        NavigateToScheduleView(sEmployeeView, sCalendarStartDate, sCalendarDateRange, sEmployeeNameUpd);

        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Employee Event to the specific date");
            WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sCalendarStartDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Employee Event has been resized.");

            assignment = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sCalendarStartDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Event to the specific date");
            result = b2wScheduler.getEmployeeEvent(sEmployeeNameUpd, sEmployeeEventTypeUpd, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Employee Event has been resized.");
        } else {
            logCompare(true, false, "Employee Event for " + sEmployeeNameUpd + " could not be found on the page.");
        }
    }

    public void resizeEquipmentEvent() {
        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentNameUpd);

        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Employee Event to the specific date");
            WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sCalendarStartDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Employee Event has been resized.");

            assignment = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sCalendarStartDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Event to the specific date");
            result = b2wScheduler.getEquipmentEvent(sEquipmentNameUpd, sEquipmentEventTypeUpd, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Employee Event has been resized.");
        } else {
            logCompare(true, false, "Equipment Event for " + sEquipmentNameUpd + " could not be found on the page.");
        }
    }

    public void resizeLocationEvent() {
        //NavigateToScheduleView(sLocationView, sCalendarStartDate, sCalendarDateRange, sJobSiteNameUpd);
        NavigateToScheduleView(sDefaultLocationView, sCalendarStartDate, sCalendarDateRange, sJobSiteNameUpd);

        //ToDo: Issue with grouping
        logCompare(true, b2wScheduler.expandAll(), "Expand All Levels");
        //=======

        WebElement assignment = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventType, sCalendarStartDate, sCalendarStartDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.resizeAssignmentRightToDate(assignment, dMoveDate), "Resize Location Event to the specific date");
            WebElement result = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventType, sCalendarStartDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Location Event has been resized.");

            assignment = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventType, sCalendarStartDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, b2wScheduler.resizeAssignmentLeftToDate(assignment, dMoveDate), "Resize Event to the specific date");
            result = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventType, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, result != null, "Verification that specific Location Event has been resized.");
        } else {
            logCompare(true, false, "Location Event for " + sEquipmentNameUpd + " could not be found on the page.");
        }
    }

    //=== Delete Assignments/Needs/Orders/Events ===
    public void deleteEmployeeAssignment(String sViewName, String sAssignmentName, String sJobSiteName, String sAssignmentStartDate, String sAssignmentEndDate, String sAssignmentStartTime,
                                         String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sViewName, sAssignmentStartDate, sCalendarDateRange, sAssignmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sAssignmentName, sJobSiteName, b2wScheduler.EMPLOYEE_TYPE);
        WebElement assignment = b2wScheduler.getEmployeeAssignment(sAssignmentName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
        if ( assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.deleteAssignment(), "Delete Employee Assignment");
            int actualCount = b2wScheduler.getAssignmentsCount(sAssignmentName, sJobSiteName, b2wScheduler.EMPLOYEE_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Employee Assignment has been deleted.");
            WebElement result = b2wScheduler.getEmployeeAssignment(sAssignmentName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result == null, "Verification that specific Employee Assignment has been deleted.");
        } else {
            logCompare(true, false, "Assignment for " + sAssignmentName + " on " + sAssignmentStartDate + " could not be found.");
        }
    }

    public void deleteEmployeeNeed(String sScheduleView, String sEmployeeNeedName, String sJobSiteName, String sAssignmentStart, String sAssignmentEnd, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeNeedName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName, b2wScheduler.EMPLOYEE_NEED_TYPE);
        WebElement assignment = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sAssignmentStart, sAssignmentEnd, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Need's Context Menu");
        logCompare(true, b2wScheduler.deleteNeed(), "Delete Need");
        int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeNeedName, sJobSiteName, b2wScheduler.EMPLOYEE_NEED_TYPE);
        logCompare(true, actualCount == initialCount - 1, "Verification that Employee Need has been deleted.");
        WebElement result = b2wScheduler.getEmployeeNeed(sEmployeeNeedName, sJobSiteName, sAssignmentStart, sAssignmentEnd, sAssignmentStartTime, sAssignmentDuration);
        logCompare(true,  result == null, "Verification that specific Employee Need has been deleted.");
    }

    public void deleteEquipmentAssignment(String sScheduleView, String sEquipmentName, String sJobSiteName,
                                          String sAssignmentStartDate, String sAssignmentEndDate,
                                          String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName, b2wScheduler.EQUIPMENT_TYPE);
        WebElement assignment = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.deleteAssignment(), "Delete Equipment Assignment");
            int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sJobSiteName, b2wScheduler.EQUIPMENT_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Equipment Assignment has been deleted.");
            WebElement result = b2wScheduler.getEquipmentAssignment(sEquipmentName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result == null, "Verification that specific Equipment Assignment has been deleted.");
        } else {
            logCompare(true, false, "Equipment Assignment for " + sEquipmentName + " could not be found on the page.");
        }
    }

    public void deleteEquipmentNeed(String sEquipmentNeedName, String sJobSiteName, String sAssignmentStartDate, String sAssignmentEndDate, String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentNeedName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName, b2wScheduler.EQUIPMENT_NEED_TYPE);
        WebElement assignment = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Need's Context Menu");
            logCompare(true, b2wScheduler.deleteNeed(), "Delete Equipment Need");
            int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentNeedName, sJobSiteName, b2wScheduler.EQUIPMENT_NEED_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Equipment Need has been deleted.");
            WebElement result = b2wScheduler.getEquipmentNeed(sEquipmentNeedName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result == null, "Verification that specific Equipment Need has been deleted.");
        } else {
            logCompare(true, false, "Equipment Need for " + sEquipmentNeedName + " could not be found on the page.");
        }
    }

    public void deleteCrewAssignment(String sScheduleView, String sCrewName, String sJobSiteName,
                                     String sAssignmentStartDate, String sAssignmentEndDate,
                                     String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sCrewName);

        int initialCount = b2wScheduler.getAssignmentsCount(sCrewName, sJobSiteName, b2wScheduler.CREW_TYPE);
        WebElement assignment = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Crew's Context Menu");
            logCompare(true, b2wScheduler.deleteAssignment(), "Delete Crew Assignment");
            int actualCount = b2wScheduler.getAssignmentsCount(sCrewName, sJobSiteName, b2wScheduler.CREW_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Crew Assignment has been deleted.");
            WebElement result = b2wScheduler.getCrewAssignment(sCrewName, sJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result == null, "Verification that specific Crew Assignment has been deleted.");
        } else {
            logCompare(true, false, "Crew Assignment for " + sCrewName + " could not be found on the page.");
        }
    }

    public void deleteCrewNeed(String sCrewNeedName, String sJobSiteName, String sStartDate, String sEndDate, String sAssignmentStartTime, String sAssignmentDurationUpd) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sCrewView, sCalendarStartDate, sCalendarDateRange, sCrewNeedName);

        int initialCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
        WebElement assignment = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime, sAssignmentDurationUpd);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Need's Context Menu");
            logCompare(true, b2wScheduler.deleteNeed(), "Delete Crew Need");
            int actualCount = b2wScheduler.getAssignmentsCount(sCrewNeedName, sJobSiteName, b2wScheduler.CREW_NEED_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Crew Need has been deleted.");
            WebElement result = b2wScheduler.getCrewNeed(sCrewNeedName, sJobSiteName, sStartDate, sEndDate, sAssignmentStartTime, sAssignmentDurationUpd);
            logCompare(true, result == null, "Verification that specific Crew Need has been deleted.");
        } else {
            logCompare(true, false, "Crew Need for " + sCrewNeedName + " could not be found on the page.");
        }
    }

    public void deleteMoveAssignment(String sScheduleView, String sEquipmentName, String sDropoffJobSiteName,
                                     String sAssignmentStartDate, String sAssignmentEndDate,
                                     String sAssignmentStartTime, String sAssignmentDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ASSIGNMENT_TYPE);
        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Move's Context Menu");
            logCompare(true, b2wScheduler.deleteMoveAssignment(), "Delete Move Assignment");
            int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteName, b2wScheduler.MOVE_ASSIGNMENT_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Move Assignment has been deleted.");
            if (initialCount == 1) {
                //ToDo: Issue SCHED-3142
                //WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
                WebElement result = b2wScheduler.getMoveAssignment(sEquipmentName, sDropoffJobSiteName, sAssignmentStartDate, sAssignmentEndDate, sAssignmentStartTime, sAssignmentDuration);
                logCompare(true, result == null, "Verification that specific Move Assignment has been deleted.");
            }
        } else {
            logCompare(true, false, "Move Assignment for " + sEquipmentName + " could not be found on the page.");
        }
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

        NavigateToScheduleView(sEquipmentView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteNameUpd, b2wScheduler.MOVE_ORDER_TYPE);
        //ToDo: Issue SCHED-3142
        //WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
        WebElement assignment = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Order's Context Menu");
            logCompare(true, b2wScheduler.deleteMoveOrder(), "Delete Move Order");
            int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sDropoffJobSiteNameUpd, b2wScheduler.MOVE_ORDER_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Move Order has been deleted.");
            //ToDo: Issue SCHED-3142
            //WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sPickupTime, sDropoffTime);
            WebElement result = b2wScheduler.getMoveOrder(sEquipmentName, sDropoffJobSiteNameUpd, sMoveDate, sMoveDate, sEventStartTime, sEventStartTime);
            logCompare(true, result == null, "Verification that specific Move Order has been deleted.");
        } else {
            logCompare(true, false, "Move Order for " + sEquipmentName + " could not be found on the page.");
        }
    }

    public void deleteEmployeeEvent(String sScheduleView, String sEmployeeName, String sEmployeeEventType,
                                    String sAssignmentStartDate, String sAssignmentEndDate,
                                    String sEventStartTime, String sEventDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEmployeeName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType, b2wScheduler.EMPLOYEE_EVENT_TYPE);
        WebElement assignment = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sAssignmentStartDate, sAssignmentEndDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
            logCompare(true, b2wScheduler.deleteEvent(), "Delete Employee Event");
            int actualCount = b2wScheduler.getAssignmentsCount(sEmployeeName, sEmployeeEventType, b2wScheduler.EMPLOYEE_EVENT_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Employee Event has been deleted.");
            WebElement result = b2wScheduler.getEmployeeEvent(sEmployeeName, sEmployeeEventType, sAssignmentStartDate, sAssignmentEndDate, sEventStartTime, sEventDuration);
            logCompare(true, result == null, "Verification that specific Employee Event has been deleted.");
        } else {
            logCompare(true, false, "Employee Event for " + sEmployeeName + " could not be found on the page.");
        }
    }

    public void deleteEquipmentEvent(String sScheduleView, String sEquipmentName, String sEquipmentEventType,
                                     String sAssignmentStartDate, String sAssignmentEndDate,
                                     String sEventStartTime, String sEventDuration) {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sScheduleView, sCalendarStartDate, sCalendarDateRange, sEquipmentName);

        int initialCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType, b2wScheduler.EQUIPMENT_EVENT_TYPE);
        WebElement assignment = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sAssignmentStartDate, sAssignmentEndDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
            logCompare(true, b2wScheduler.deleteEvent(), "Delete Equipment Event");
            int actualCount = b2wScheduler.getAssignmentsCount(sEquipmentName, sEquipmentEventType, b2wScheduler.EQUIPMENT_EVENT_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that Equipment Event has been deleted.");
            WebElement result = b2wScheduler.getEquipmentEvent(sEquipmentName, sEquipmentEventType, sAssignmentStartDate, sAssignmentEndDate, sEventStartTime, sEventDuration);
            logCompare(true, result == null, "Verification that specific Equipment Event has been deleted.");
        } else {
            logCompare(true, false, "Equipment Event for " + sEquipmentName + " could not be found on the page.");
        }
    }

    public void deleteLocationEvent() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        //NavigateToScheduleView(sLocationView, sCalendarStartDate, sCalendarDateRange, sJobSiteNameUpd);
        //NavigateToScheduleView(sDefaultLocationView, sCalendarStartDate, sCalendarDateRange, sJobSiteNameUpd);
        NavigateToScheduleView(sDefaultLocationView, sMoveDate, sCalendarDateRange, sJobSiteNameUpd);

        int initialCount = b2wScheduler.getAssignmentsCount(sJobSiteNameUpd, sLocationEventTypeUpd, b2wScheduler.LOCATION_EVENT_TYPE);
        WebElement assignment = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventTypeUpd, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Event's Context Menu");
            logCompare(true, b2wScheduler.deleteEvent(), "Delete JobSite Event");
            int actualCount = b2wScheduler.getAssignmentsCount(sJobSiteNameUpd, sLocationEventTypeUpd, b2wScheduler.LOCATION_EVENT_TYPE);
            logCompare(true, actualCount == initialCount - 1, "Verification that JobSite Event has been deleted.");
            WebElement result = b2wScheduler.getLocationEvent(sJobSiteNameUpd, sLocationEventTypeUpd, sMoveDate, sMoveDate, sEventStartTime, sEventDuration);
            logCompare(true, result == null, "Verification that specific JobSite Event has been deleted.");
        } else {
            logCompare(true, false, "Location Event for " + sJobSiteNameUpd + " could not be found on the page.");
        }
    }

    public void deleteEmployeeSubstitution() {
        /*
         * 1. Open Schedule View
         * 2. Change Date Range on Schedule View
         * 3. Change Start Date on Schedule View
         * 4. Set Filter
         * 5. Select Assignment
         * 6. Delete Assignment
         * 7. Verify that Assignment was deleted
         */

        NavigateToScheduleView(sDefaultEmployeeView, sCalendarStartDate, sCalendarDateRange, "");

        int initialCountSubstituted = b2wScheduler.getAssignmentsCount(sEmployeeNameForSubstitution, sJobSiteName, b2wScheduler.SUBSTITUTED_TYPE);
        int initialCountSubstitution = b2wScheduler.getAssignmentsCount(sEmployeeNameUpd, sJobSiteName, b2wScheduler.SUBSTITUTION_TYPE);
        WebElement assignment = b2wScheduler.getEmployeeSubstitution(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
        if (assignment != null) {
            logCompare(true, b2wScheduler.openContextMenu(assignment), "Open Assignment's Context Menu");
            logCompare(true, b2wScheduler.deleteSubstitution(), "Delete Employee Substitution");
            int actualCountSubstituted = b2wScheduler.getAssignmentsCount(sEmployeeNameForSubstitution, sJobSiteName, b2wScheduler.SUBSTITUTED_TYPE);
            int actualCountSubstitution = b2wScheduler.getAssignmentsCount(sEmployeeNameUpd, sJobSiteName, b2wScheduler.SUBSTITUTION_TYPE);
            logCompare(true, actualCountSubstituted == initialCountSubstituted - 1, "Verification that original Employee Assignment converted to actual.");
            logCompare(true, actualCountSubstitution == initialCountSubstitution - 1, "Verification that Employee substitution has been deleted.");

            WebElement result = b2wScheduler.getEmployeeAssignment(sEmployeeNameForSubstitution, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result != null, "Verification that specific Employee Substitution has been deleted.");

            result = b2wScheduler.getEmployeeSubstitution(sEmployeeNameUpd, sJobSiteName, sCalendarStartDate, sCalendarStartDate, sAssignmentStartTime, sAssignmentDuration);
            logCompare(true, result == null, "Verification that specific Employee Substitution has been deleted.");
        } else {
            logCompare(true, false, "Substitution " + sEmployeeNameUpd + " for " + sEmployeeNameForSubstitution + " could not be found on the page.");
        }
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

    private void NavigateToScheduleView(String sViewName, String sCalendarStartDate, String sCalendarDateRange, String sSearchItem) {
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sViewName, sViewName), "Open " + sViewName + " Schedule View");
        logCompare(true, b2wScheduler.setCalendarDateRange(sCalendarDateRange), "Set Calendar Date Range to " + sCalendarDateRange);
        logCompare(true, b2wScheduler.setCalendarStartDate(sCalendarStartDate), "Set Calendar Start to " + sCalendarStartDate);
        if (sSearchItem.equals("")) {
            logCompare(true, b2wScheduler.clearSearchValue(), "Clear search value.");
        } else {
            logCompare(true, b2wScheduler.setSearchValue(sSearchItem), "Set Filter by " + sSearchItem);
        }
    }
}