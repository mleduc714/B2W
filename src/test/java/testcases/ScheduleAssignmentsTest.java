package testcases;

import com.b2w.test.B2WTestCase;
import tasks.B2WNavigationTasks;
import tasks.scheduler.B2WScheduleView;
import tasks.scheduler.B2WSchedulerTasks;
import tasks.setup.B2WSchedulesTasks;
import tasks.util.StringUtils;

import java.util.Date;

public class ScheduleAssignmentsTest extends B2WTestCase {

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
    private String sEmployeeScheduleViewName;
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
        B2WScheduleView employeeScheduleView = new B2WScheduleView(sEmployeeScheduleViewName);
    }
}