package tasks.scheduler;

import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.log4j.Logger;
import org.jfree.data.time.DateRange;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.resources.B2WCrewTemplate;
import tasks.resources.B2WKendoTasks;
import tasks.util.StringUtils;
import tasks.util.TaskUtils;

import java.util.*;

import static com.b2w.test.BaseAssert.logCompare;

public class B2WSchedulerTasks extends B2WKendoTasks {
    public final String MENU_ASSIGNMENT = "Assignment/Need";
    public final String CREWASSIGNMENT = "Crew Assignment";
    public final String CREWNEED = "Crew Need";
    public final String MOVEORDER = "Move Order";
    public final String MOVEASSIGNMENT = "Move Assignment";
    public final String EVENT = "Event";

    private Logger log = Logger.getLogger(B2WSchedulerTasks.class);

    public boolean navigateTo(B2WScheduleView scheduleView) {
        boolean bReturn = false;

        if (!new TaskUtils().waitForProductPanel(scheduleView.getName())) {
            WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getScheduleProductPageIcon());
            if (el != null) {
                if (WebElementUtils.clickElement(el)) {
                    WebElement panel = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleViewNavigateMenu());
                    WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleViewNavigateMenu(), 1);

                    List<WebElement> items = WebElementUtils.getChildElements(panel, By.cssSelector("li"));
                    WebElement item = WebElementUtils.getElementWithMatchingText(items, scheduleView.getName(), true);
                    if (item != null) {
                        item.click();

                        WebElementUtils.waitForElementInvisible(panel);
                        waitForSchedulesPageNoBusy();

                        bReturn = new TaskUtils().waitForProductPanel(scheduleView.getName());
                        WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleCenterPanel(), 1);
                    }
                }
            }
        } else {
            bReturn = true;
        }
        return bReturn;
    }
    public boolean setCalendarDateRange(B2WScheduleView sValue) {
        boolean bReturn = false;
        WebElement activeDateRange = WebElementUtils.findElement(B2WScheduleAssignments.getCalendarActiveDateRange());
        if (activeDateRange != null) {
            if (!activeDateRange.getText().equals(sValue.getDuration())) {
                WebElement parent = WebElementUtils.getParentElement(activeDateRange);
                List<WebElement> dateRangeList = WebElementUtils.getChildElements(parent, By.cssSelector("a"));
                Iterator<WebElement> iterator = dateRangeList.iterator();
                while (iterator.hasNext() && !bReturn) {
                    WebElement item = iterator.next();
                    if (item.getText().equals(sValue.getDuration())) {
                        bReturn = WebElementUtils.clickElement(item);
                        TaskUtils.sleep(100);
                        waitForSchedulesPageNoBusy();
                        bReturn &= WebElementUtils.findElement(B2WScheduleAssignments.getCalendarActiveDateRange()).getText().equals(sValue.getDuration());
                    }
                }
            } else {
                bReturn = true;
            }
        } else {
            log.debug("Active date range element could not be found on the page.");
        }
        return bReturn;
    }
    public boolean setCalendarStartDate(B2WScheduleView scheduleView) {
        boolean bReturn = false;
        //String sValue = StringUtils.getStringFromDateByPattern(scheduleView.getStartDate(), "M/d/yyyy");
        String sValue = scheduleView.getStartDateAsSting();
        WebElement inputCalendarStartDate = WebElementUtils.findElement(B2WScheduleAssignments.getCalendarStartDate());
        if (inputCalendarStartDate != null) {
            inputCalendarStartDate.clear();
            bReturn = WebElementUtils.sendKeys(inputCalendarStartDate, sValue + Keys.RETURN);
            TaskUtils.sleep(100);
            waitForSchedulesPageNoBusy();
            //Date d1 = StringUtils.getDateFromStringWithPattern(sValue, "M/d/yyyy");
            Date d1 = scheduleView.getStartDate();
            DateRange dateRange = getSelectedDates();
            bReturn &= d1.equals(dateRange.getLowerDate());
        } else {
            log.debug("Calendar startDate field could not be found on the Schedule View page.");
        }
        return bReturn;
    }
    public boolean setSearchValue(String sValue) {
        try {
            boolean bReturn = false;
            WebElement eSearchBox = WebElementUtils.findElement(B2WScheduleAssignments.getSearchBox());
            if (eSearchBox != null) {
                eSearchBox.clear();
                bReturn = WebElementUtils.sendKeys(eSearchBox, sValue);
                WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getKendoPageLoading(), WebElementUtils.SHORT_TIME_OUT);
                waitForSchedulesPageNoBusy();
                bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
            } else {
                log.debug("Search box could not be found on the page.");
            }
            return bReturn;
        } catch (Exception e) {
            log.debug(e.toString());
            return false;
        }
    }
    public boolean clearSearchValue() {
        boolean bReturn = false;
        WebElement eSearchBox = WebElementUtils.findElement(B2WScheduleAssignments.getSearchBox());
        if (eSearchBox != null) {
            eSearchBox.clear();
            WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getKendoPageLoading(), WebElementUtils.SHORT_TIME_OUT);
            waitForSchedulesPageNoBusy();
            bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
        } else {
            log.debug("Search box could not be found on the page.");
        }
        return bReturn;
    }

    public boolean createEmployeeAssignment(B2WAssignment assignment) {
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

        boolean bReturn;
        bReturn = logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, selectNewAssignmentOrNeed(), "Select New -> Assignment/Need menu");
        bReturn &= logCompare(true, setEmployees(assignment.getResourceName()), "Set Resource: " + assignment.getResourceName());
        if (setGeneralFields(assignment)) {
            bReturn = saveGeneralAssignment(initialCount, assignment, false);
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }

        bReturn &= logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createEmployeeSubstitution(B2WAssignment assignment, String sEmployeeSubstitution) {
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

        boolean bReturn = false;
        WebElement eAssignment = getAssignment(assignment);
        if (eAssignment != null) {
            bReturn = logCompare(true, openContextMenu(eAssignment), "Open Assignment's Context Menu");
            bReturn &= logCompare(true, selectCreateSubstitution(), "Select 'Create Substitution' option");
            bReturn &= logCompare(true, setEmployee(sEmployeeSubstitution), "Set Employee Substitution");
            if (bReturn) {
                bReturn &= logCompare(true, saveAssignment(), "Save Employee Substitution");
                assignment.makeSubstitution(sEmployeeSubstitution);

                WebElement result = getAssignment(assignment);
                logCompare(true, result != null, "Verification that specific Assignment converted to Substituted.");
                logCompare(true, setSearchValue(sEmployeeSubstitution), "Set Filter by Employee Name");

                result = getAssignment(assignment.getSubstitution());
                logCompare(true, result != null, "Verification that specific Substitution has been created.");
            } else {
                cancelAssignment();
                selectButtonOption("Yes");
            }
        } else {
            logCompare(true, false, "Employee Assignment for " + assignment.getResourceName() + " could not be found on the page.");
        }
        return bReturn;
    }
    public boolean createEmployeeNeed(B2WAssignment assignment) {
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

        boolean bReturn;
        bReturn = logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, selectNewAssignmentOrNeed(), "Select New -> Assignment/Need menu");
        bReturn &= logCompare(true, setEmployeeNeed(assignment.getResourceName()), "Set Resource: " + assignment.getResourceName());

        if (setGeneralFields(assignment)) {
            bReturn = saveGeneralAssignment(initialCount, assignment, true);
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }

        bReturn &= logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createEquipmentAssignment(B2WAssignment assignment) {
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

        boolean bReturn;
        bReturn = logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, selectNewAssignmentOrNeed(), "Select New -> Assignment/Need menu");
        bReturn &= logCompare(true, setEquipment(assignment.getResourceName()), "Set Resource: " + assignment.getResourceName());

        if (setGeneralFields(assignment)) {
            bReturn = saveGeneralAssignment(initialCount, assignment, false);
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }

        bReturn &= logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createEquipmentNeed(B2WAssignment assignment) {
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

        boolean bReturn;
        bReturn = logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, selectNewAssignmentOrNeed(), "Select New -> Assignment/Need menu");
        bReturn &= logCompare(true, setEquipmentNeed(assignment.getResourceName()), "Set Resource: " + assignment.getResourceName());

        if (setGeneralFields(assignment)) {
            bReturn = saveGeneralAssignment(initialCount, assignment, true);
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }

        bReturn &= logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createCrewAssignment(B2WAssignment assignment) {
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

        boolean bReturn = false;
        logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, selectNewCrewAssignment(), "Select New -> Crew Assignment menu");
        bReturn &= logCompare(true, setCrew(assignment.getResourceName()), "Set Crew Resource");
        if (setGeneralFields(assignment)) {
            bReturn = saveGeneralAssignment(initialCount, assignment, false);
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createCrewAssignmentWithCustomCrew(B2WAssignment assignment, B2WCrewTemplate customCrew) {
        boolean bReturn = false;
        logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, selectNewCrewAssignment(), "Select New -> Crew Assignment menu");
        bReturn &= logCompare(true, setCrew(assignment.getResourceName()), "Set Crew Resource");
        bReturn &= logCompare(true, clickViewCrew(), "Click 'View Crew' link");
        bReturn &= logCompare(true, clickAddCrewResource(), "Click '+Add Resource/Need' button");
        bReturn &= logCompare(true, setResourceName("Equipment", customCrew.getEquipments()), "Add Equipment");
        bReturn &= logCompare(true, setResourceName("Equipment Needs", customCrew.getEquipmentTypes()), "Add Equipment Needs");
        bReturn &= logCompare(true, setResourceName("Employees", customCrew.getEmployees()), "Add Employees");
        bReturn &= logCompare(true, setResourceName("Employee Needs", customCrew.getLaborTypes()), "Add Employee Needs");
        bReturn &= logCompare(true, clickAddToCrew(), "Click 'Add to Crew' button.");
        bReturn &= logCompare(true, clickHideCrew(), "Click 'Hide Crew' link");
        if (setGeneralFields(assignment)) {
            bReturn = saveGeneralAssignment(initialCount, assignment, false);
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createCrewNeed(B2WAssignment assignment) {
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

        boolean bReturn = false;
        logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, selectNewCrewNeed(), "Select New -> Crew Need menu");
        bReturn &= logCompare(true, setCrewNeed(assignment.getResourceName()), "Set Crew Resource");
        if (setGeneralFields(assignment)) {
            bReturn = saveGeneralAssignment(initialCount, assignment, true);
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createMoveAssignment(B2WAssignment assignment) {
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


        boolean bReturn;
        logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);

        bReturn = logCompare(true, selectNewMoveAssignment(), "Select New ->  Move Assignment");
        bReturn &= logCompare(true, setEquipment(assignment.getResourceName()), "Set Equipment");
        bReturn &= logCompare(true, setPickupDate(assignment.getPickupDate()), "Set Pickup Date");
        bReturn &= logCompare(true, setPickupTime(assignment.getPickupTime()), "Set Pickup Time");
        bReturn &= logCompare(true, setDropoffDate(assignment.getDropoffDate()), "Set Dropoff Date");
        bReturn &= logCompare(true, setDropoffTime(assignment.getDropoffTime()), "Set Dropoff Time");
        bReturn &= logCompare(true, setPickupLocation(assignment.getPickupLocationType(), assignment.getPickupLocation()), "Set Pickup Location");
        bReturn &= logCompare(true, setDropoffLocation(assignment.getDropoffLocationType(), assignment.getDropoffLocation()), "Set Drop-off Location");
        bReturn &= logCompare(true, clickSelectCrewBtn(), "Open Select Crew Dialog");
        bReturn &= logCompare(true, setCrew(assignment.getTransportationCrew()), "Set Crew");
        bReturn &= logCompare(true, setRequestedBy(assignment.getRequestedBy()), "Set Requested By");
        bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes");

        if (bReturn) {
            bReturn &= logCompare(true, saveAssignment(), "Save New Move Assignment");

            int actualCount = getAssignmentsCount(assignment);
            bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that number of Assignment has been increased by 1.");
            WebElement result = getAssignment(assignment);
            bReturn &= logCompare(true,  result != null, "Verification that specific Assignment has been created.");
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createMoveAssignmentWithCustomCrew(B2WAssignment assignment, B2WCrewTemplate customCrew) {
        boolean bReturn = false;
        if (assignment != null || customCrew != null) {
            logCompare(true, true, "====== Start Assignment Creation for " + assignment.getResourceName());
            int initialCount = getAssignmentsCount(assignment);

            bReturn = logCompare(true, selectNewMoveAssignment(), "Select New ->  Move Assignment");
            bReturn &= logCompare(true, setEquipment(assignment.getResourceName()), "Set Equipment");
            bReturn &= logCompare(true, setPickupDate(assignment.getPickupDate()), "Set Pickup Date");
            bReturn &= logCompare(true, setPickupTime(assignment.getPickupTime()), "Set Pickup Time");
            bReturn &= logCompare(true, setDropoffDate(assignment.getDropoffDate()), "Set Dropoff Date");
            bReturn &= logCompare(true, setDropoffTime(assignment.getDropoffTime()), "Set Dropoff Time");
            bReturn &= logCompare(true, setPickupLocation(assignment.getPickupLocationType(), assignment.getPickupLocation()), "Set Pickup Location");
            bReturn &= logCompare(true, setDropoffLocation(assignment.getDropoffLocationType(), assignment.getDropoffLocation()), "Set Drop-off Location");
            bReturn &= logCompare(true, clickSelectCrewBtn(), "Open Select Crew Dialog");
            bReturn &= logCompare(true, setCrew(assignment.getTransportationCrew()), "Set Crew");
            bReturn &= logCompare(true, clickAddCrewResource(), "Click '+Add Resource/Need' button");
            ArrayList<String> aDriver = new ArrayList<>();
            aDriver.add(customCrew.getForeman());
            bReturn &= logCompare(true, setResourceName("Driver", aDriver), "Add Driver");
            bReturn &= logCompare(true, setResourceName("Equipment", customCrew.getEquipments()), "Add Equipment");
            bReturn &= logCompare(true, setResourceName("Equipment Needs", customCrew.getEquipmentTypes()), "Add Equipment Needs");
            bReturn &= logCompare(true, setResourceName("Employees", customCrew.getEmployees()), "Add Employees");
            bReturn &= logCompare(true, setResourceName("Employee Needs", customCrew.getLaborTypes()), "Add Employee Needs");
            bReturn &= logCompare(true, clickAddToCrew(), "Click 'Add to Crew' button.");

            bReturn &= logCompare(true, setRequestedBy(assignment.getRequestedBy()), "Set Requested By");
            bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes");

            if (bReturn) {
                bReturn &= logCompare(true, saveAssignment(), "Save New Move Assignment with Custom Crew");

                int actualCount = getAssignmentsCount(assignment);
                bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that number of Assignment has been increased by 1.");
                WebElement result = getAssignment(assignment);
                bReturn &= logCompare(true, result != null, "Verification that specific Assignment has been created.");
                B2WAssignment autoMoveAssignment = assignment.clone();
                autoMoveAssignment.setResourceName(customCrew.getEquipments().get(0));
                autoMoveAssignment.setAssignmentType(B2WAssignmentType.EQUIPMENT_TYPE);
                result = getAssignment(autoMoveAssignment);
                bReturn &= logCompare(true, result != null, "Verification that specific Assignment has been created.");
            } else {
                cancelAssignment();
                selectButtonOption("Yes");
            }
            logCompare(true, true, "====== Complete Assignment Creation for " + assignment.getResourceName());
        } else {
            log.error("Assignment or customCrew is NULL.");
        }
        return bReturn;
    }
    public boolean createMoveOrder(B2WAssignment assignment) {
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


        boolean bReturn;
        logCompare(true, true, "====== Start Order Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);

        bReturn = logCompare(true, selectNewMoveOrder(), "Select New -> Move Order");
        bReturn &= logCompare(true, setEquipment(assignment.getResourceName()), "Set Equipment");
        bReturn &= logCompare(true, setPickupAfter(assignment.getPickupDate()), "Set Pickup After");
        bReturn &= logCompare(true, setPickupTime(assignment.getPickupTime()), "Set Pickup Time");
        bReturn &= logCompare(true, setDropoffBefore(assignment.getDropoffDate()), "Set Drop-off Before");
        bReturn &= logCompare(true, setDropoffTime(assignment.getDropoffTime()), "Set Drop-off Time");
        bReturn &= logCompare(true, setPickupLocation(assignment.getPickupLocationType(), assignment.getPickupLocation()), "Set Pickup Location");
        bReturn &= logCompare(true, setDropoffLocation(assignment.getDropoffLocationType(), assignment.getDropoffLocation()), "Set Drop-off Location");
        bReturn &= logCompare(true, setRequestedBy(assignment.getRequestedBy()), "Set Requested By");
        bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes");

        if (bReturn) {
            bReturn &= logCompare(true, saveAssignment(), "Save New Move Order");

            int actualCount = getAssignmentsCount(assignment);
            bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that number of Assignment has been increased by 1.");
            WebElement result = getAssignment(assignment);
            bReturn &= logCompare(true,  result != null, "Verification that specific Assignment has been created.");
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Order Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createEmployeeEvent(B2WAssignment assignment) {
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

        boolean bReturn;
        logCompare(true, true, "====== Start Employee Event Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);

        bReturn = logCompare(true, selectNewEmployeeEvent(), "Select New -> Create Event -> Employee");
        bReturn &= logCompare(true, setEventEmployee(assignment.getResourceName()), "Set Employee");
        bReturn &= logCompare(true, setEventType(assignment.getLocationName()), "Set Employee Event Type");
        bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes");
        if (bReturn) {
            bReturn &= logCompare(true, saveAssignment(), "Save New Employee Event");

            int actualCount = getAssignmentsCount(assignment);
            bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that number of Events has been increased by 1.");
            WebElement result = getAssignment(assignment);
            bReturn &= logCompare(true,  result != null, "Verification that specific Event has been created.");
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Employee Event Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createEquipmentEvent(B2WAssignment assignment) {
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

        boolean bReturn;
        logCompare(true, true, "====== Start Equipment Event Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);

        bReturn = logCompare(true, selectNewEquipmentEvent(), "Select New -> Create Event -> Equipment");
        bReturn &= logCompare(true, setEventEquipment(assignment.getResourceName()), "Set Equipment");
        bReturn &= logCompare(true, setEventType(assignment.getLocationName()), "Set Equipment Event Type");
        bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes");
        if (bReturn) {
            bReturn &= logCompare(true, saveAssignment(), "Save New Equipment Event");

            int actualCount = getAssignmentsCount(assignment);
            bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that number of Events has been increased by 1.");
            WebElement result = getAssignment(assignment);
            bReturn &= logCompare(true,  result != null, "Verification that specific Event has been created.");
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Equipment Event Creation for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean createLocationEvent(B2WAssignment assignment) {
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

        boolean bReturn;
        logCompare(true, true, "====== Start Location Event Creation for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);

        bReturn = logCompare(true, selectNewLocationEvent(), "Select New -> Create Event -> Location");
        bReturn &= logCompare(true, setEventLocation(assignment.getResourceName()), "Set Location");
        bReturn &= logCompare(true, setEventType(assignment.getLocationName()), "Set Location Event Type");
        bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes");
        if (bReturn) {
            bReturn &= logCompare(true, saveAssignment(), "Save New Location Event");

            int actualCount = getAssignmentsCount(assignment);
            bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that number of Events has been increased by 1.");
            WebElement result = getAssignment(assignment);
            bReturn &= logCompare(true,  result != null, "Verification that specific Event has been created.");
        } else {
            cancelAssignment();
            selectButtonOption("Yes");
        }
        logCompare(true, true, "====== Complete Location Event Creation for " + assignment.getResourceName());
        return bReturn;
    }

    public boolean moveAssignmentToDate(B2WAssignment assignment, Date dMoveDate) {
        boolean bReturn;
        logCompare(true, true, "====== Start Moving Employee Assignment (" + assignment.getResourceName() + ") to Date: " + dMoveDate.toString());
        WebElement eAssignment = getAssignment(assignment);

        if (eAssignment != null) {
            bReturn = logCompare(true, moveAssignmentToDate(eAssignment, dMoveDate), "Move Assignment to the specific date");
            assignment.moveTo(dMoveDate);

            WebElement result = getAssignment(assignment);
            //bReturn &= logCompare(true, getAssignmentStartDate(result).equals(assignment.getStartDateAsDate()), "Verify that Employee Assignment was moved to the specific date.");
            bReturn &= logCompare(true, result != null, "Verify that Employee Assignment was moved to the specific date.");
        } else {
            bReturn = logCompare(true, false, "Employee assignment for " + assignment.getResourceName() + " could not be found on the page.");
        }
        logCompare(true, true, "====== Complete Moving Employee Assignment (" + assignment.getResourceName() + ") to Date: " + dMoveDate.toString());
        return bReturn;
    }

    /**
     * Method moving Assignment to the Resource and to the Date
     * @param assignment    Assignment that will be moved
     * @param sResourceName Assignment will be moved to this Resource
     * @param moveDate      Assignment will be moved to this Date
     * @return
     */
    public boolean moveAssignmentToResourceAndDate(B2WAssignment assignment, String sResourceName, Date moveDate, boolean check) {
        boolean bReturn;
        logCompare(true, true, "====== Start Moving Assignment (" + assignment.getResourceName() + ") to Resource: " + sResourceName + " and to the Date: " + moveDate.toString());
        WebElement eAssignment = getAssignment(assignment);

        if (eAssignment != null) {
            bReturn = logCompare(true, moveAssignmentToResourceAndDate(eAssignment, sResourceName, moveDate), "Move Assignment to the specific date");

            if (assignment.getAssignmentType().equals(B2WAssignmentType.MOVE_ORDER_TYPE)) {
                assignment.setTransportationCrew(sResourceName);
            } else {
                assignment.setResourceName(sResourceName);
                assignment.moveTo(moveDate);
            }

            if (check) {
                WebElement result = getAssignment(assignment);
                bReturn &= logCompare(true, result != null, "Verify that Employee Assignment was moved to the specific date.");
            }
        } else {
            bReturn = logCompare(true, false, "Employee assignment for " + assignment.getResourceName() + " could not be found on the page.");
        }
        logCompare(true, true, "====== Complete Moving  Assignment (" + assignment.getResourceName() + ") to Date: " + moveDate.toString());
        return bReturn;
    }
    public boolean moveAssignmentToResource(B2WAssignment assignment, String sResourceName) {
        return moveAssignmentToResourceAndDate(assignment, sResourceName, assignment.getStartDateAsDate(), true);
    }

    public boolean resizeAssignment(B2WAssignment assignment, String sEdge, Date dMoveDate) {
        boolean bReturn = false;
        logCompare(true, true, "====== Start Resize " + sEdge + " side of Assignments " + assignment.getResourceName() + " to " + dMoveDate);
        WebElement eAssignment = getAssignment(assignment);
        if (eAssignment != null) {

            if (sEdge.toLowerCase().equals("right")) {
                bReturn = logCompare(true, resizeAssignmentRightToDate(eAssignment, dMoveDate), "Resize Assignment to the specific date");

            } else if (sEdge.toLowerCase().equals("left")) {
                bReturn = logCompare(true, resizeAssignmentLeftToDate(eAssignment, dMoveDate), "Resize Assignment to the specific date");
            }
            waitForSchedulesPageNoBusy();
            assignment.resizeTo(sEdge, dMoveDate);
            WebElement result = getAssignment(assignment);
            bReturn &= logCompare(true, result != null, "Verification that specific Assignment has been resized.");
        } else {
            logCompare(true, false, "Assignment for " + assignment.getResourceName() + " could not be found on the page.");
        }
        logCompare(true, true, "====== Complete Resize " + sEdge + " side of Assignments " + assignment.getResourceName() + " to " + dMoveDate);
        return bReturn;
    }
    public boolean updateAssignment(B2WAssignment existsAssignment, B2WAssignment updatedAssignment) {
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

        boolean bReturn = false;
        logCompare(true, true, "====== Start Updating " + existsAssignment.getResourceName());
        WebElement eAssignment = getAssignment(existsAssignment);

        if (eAssignment != null) {
            bReturn = logCompare(true, openContextMenu(eAssignment), "Open Assignment's Context Menu");

            switch (existsAssignment.getAssignmentType()) {
                case B2WAssignmentType.EMPLOYEE_TYPE :
                    updateEmployeeAssignment(updatedAssignment);
                    break;
                case B2WAssignmentType.EQUIPMENT_TYPE :
                    updateEquipmentAssignment(updatedAssignment);
                    break;
                case B2WAssignmentType.CREW_TYPE :
                    updateCrewAssignment(updatedAssignment);
                    break;
                case B2WAssignmentType.EMPLOYEE_NEED_TYPE :
                    updateEmployeeNeed(updatedAssignment);
                    break;
                case B2WAssignmentType.EQUIPMENT_NEED_TYPE :
                    updateEquipmentNeed(updatedAssignment);
                    break;
                case B2WAssignmentType.CREW_NEED_TYPE :
                    updateCrewNeed(updatedAssignment);
                    break;
                case B2WAssignmentType.MOVE_ASSIGNMENT_TYPE :
                    updateMoveAssignment(updatedAssignment);
                    break;
                case B2WAssignmentType.MOVE_ORDER_TYPE :
                    updateMoveOrder(updatedAssignment);
                    break;
                case B2WAssignmentType.EMPLOYEE_EVENT_TYPE :
                    updateEmployeeEvent(updatedAssignment);
                    break;
                case B2WAssignmentType.EQUIPMENT_EVENT_TYPE :
                    updateEquipmentEvent(updatedAssignment);
                    break;
                case B2WAssignmentType.LOCATION_EVENT_TYPE :
                    updateLocationEvent(updatedAssignment);
                    break;
                case B2WAssignmentType.SUBSTITUTION_TYPE :
                    updateSubstitution(updatedAssignment);
                    break;
                default : break;
            }

            bReturn &= logCompare(true, saveAssignment(), "Save the updated Assignment");
            bReturn &= logCompare(true, setSearchValue(updatedAssignment.getResourceName()), "Set Quick Filter to :" + updatedAssignment.getResourceName());

            WebElement result = getAssignment(updatedAssignment);
            logCompare(true, result != null, "Verification that specific Employee Assignment has been updated.");
        } else {
            logCompare(true, false, "Assignment for " + existsAssignment.getResourceName() + " could not be found on the page.");
        }
        logCompare(true, true, "====== Complete Update Assignment " + existsAssignment.getResourceName());
        return bReturn;
    }
    public boolean copyAssignment(B2WAssignment assignment) {
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

        boolean bReturn = false;
        logCompare(true, true, "====== Start Copy Assignment " + assignment.getResourceName());
        WebElement eAssignment = getAssignment(assignment);

        if (eAssignment != null) {
            int initialCount = getAssignmentsCount(assignment);
            bReturn = logCompare(true, openContextMenu(eAssignment), "Open Assignment's Context Menu");

            switch (assignment.getAssignmentType()) {
                case B2WAssignmentType.EMPLOYEE_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Assignment"), "Select 'Copy Assignment' from Context Menu.");
                    break;
                case B2WAssignmentType.EQUIPMENT_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Assignment"), "Select 'Copy Assignment' from Context Menu.");
                    break;
                case B2WAssignmentType.CREW_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Assignment"), "Select 'Copy Assignment' from Context Menu.");
                    break;
                case B2WAssignmentType.EMPLOYEE_NEED_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Need"), "Select 'Copy Need' from Context Menu.");
                    break;
                case B2WAssignmentType.EQUIPMENT_NEED_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Need"), "Select 'Copy Need' from Context Menu.");
                    break;
                case B2WAssignmentType.CREW_NEED_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Need"), "Select 'Copy Need' from Context Menu.");
                    break;
                case B2WAssignmentType.MOVE_ASSIGNMENT_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Move Assignment"), "Select 'Copy Move Assignment' from Context Menu.");
                    break;
                case B2WAssignmentType.MOVE_ORDER_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Move Order"), "Select 'Copy Move Assignment' from Context Menu.");
                    break;
                case B2WAssignmentType.EMPLOYEE_EVENT_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Event"), "Select 'Copy Event' from Context Menu.");
                    break;
                case B2WAssignmentType.EQUIPMENT_EVENT_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Event"), "Select 'Copy Event' from Context Menu.");
                    break;
                case B2WAssignmentType.LOCATION_EVENT_TYPE :
                    bReturn &= logCompare(true, selectOptionFromContextMenu("Copy Event"), "Select 'Copy Event' from Context Menu.");
                    break;
                default : break;
            }
            waitForSchedulesPageNoBusy();
            bReturn &= logCompare(true, saveAssignment(), "Save the updated Assignment");
            int actualCount = getAssignmentsCount(assignment);
            bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that number of Assignment has been increased by 1.");
        } else {
            logCompare(true, false, "Assignment for " + assignment.getResourceName() + " could not be found on the page.");
        }
        logCompare(true, true, "====== Complete Copy Assignment " + assignment.getResourceName());
        return bReturn;
    }
    public boolean deleteAssignment(B2WAssignment assignment) {
        boolean bReturn = false;
        logCompare(true, true, "====== Start Assignment Deletion for " + assignment.getResourceName());
        int initialCount = getAssignmentsCount(assignment);
        WebElement eAssignment = getAssignment(assignment);
        if (eAssignment != null) {
            bReturn = logCompare(true, openContextMenu(eAssignment), "Open Assignment's Context Menu");
            switch (assignment.getAssignmentType()) {
                case B2WAssignmentType.EMPLOYEE_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Assignment");
                    break;
                case B2WAssignmentType.EQUIPMENT_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Assignment");
                    break;
                case B2WAssignmentType.CREW_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Assignment");
                    break;
                case B2WAssignmentType.EMPLOYEE_NEED_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Need");
                    break;
                case B2WAssignmentType.EQUIPMENT_NEED_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Need");
                    break;
                case B2WAssignmentType.CREW_NEED_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Need");
                    break;
                case B2WAssignmentType.MOVE_ASSIGNMENT_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Move Assignment");
                    break;
                case B2WAssignmentType.MOVE_ORDER_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Move Order");
                    break;
                case B2WAssignmentType.EMPLOYEE_EVENT_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Event");
                    break;
                case B2WAssignmentType.EQUIPMENT_EVENT_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Event");
                    break;
                case B2WAssignmentType.LOCATION_EVENT_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Event");
                    break;
                case B2WAssignmentType.SUBSTITUTED_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Substitution");
                    break;
                case B2WAssignmentType.SUBSTITUTION_TYPE :
                    bReturn &= selectOptionFromContextMenu("Delete Substitution");
                    break;
                default : break;
            }

            bReturn &= selectButtonOption("Yes");
            TaskUtils.sleep(1000);
            waitForSchedulesPageNoBusy();
            int actualCount = getAssignmentsCount(assignment);
            bReturn &= logCompare(true, actualCount == initialCount - 1, "Verification that number of Assignment has been decreased by 1.");
        } else {
            logCompare(true, false, "Assignment for " + assignment.getResourceName() + " on " + assignment.getResourceName() + " could not be found.");
        }
        logCompare(true, bReturn, "====== Complete Assignment Deletion for " + assignment.getResourceName());
        return bReturn;
    }
    public boolean markAsComplete(B2WAssignment assignment) {
        boolean bReturn = false;
        if (assignment != null) {
            logCompare(true, true, "====== Start Mark Assignment as Complete.");
            bReturn = logCompare(false, isAssignmentComplete(assignment), "Check that assignment '" + assignment.getResourceName() + "' is Incomplete.");
            bReturn &= logCompare(true, openContextMenu(assignment), "Open Assignment's Context Menu");
            bReturn &= logCompare(true, selectOptionFromContextMenu("Mark as Complete"), "Select 'Mark as Complete' from Context Menu.");
            bReturn &= logCompare(true, isAssignmentComplete(assignment), "Check that assignment '" + assignment.getResourceName() + "' is Complete.");
            logCompare(true, true, "====== Stop Mark Assignment as Complete.");
        }
        return bReturn;
    }
    public boolean markAsIncomplete(B2WAssignment assignment) {
        boolean bReturn = false;
        if (assignment != null) {
            logCompare(true, true, "====== Start Mark Assignment as Incomplete.");
            bReturn = logCompare(true, isAssignmentComplete(assignment), "Check that assignment '" + assignment.getResourceName() + "' is Complete.");
            bReturn &= logCompare(true, openContextMenu(assignment), "Open Assignment's Context Menu");
            bReturn &= logCompare(true, selectOptionFromContextMenu("Mark as Incomplete"), "Select 'Mark as Incomplete' from Context Menu.");
            bReturn &= logCompare(false, isAssignmentComplete(assignment), "Check that assignment '" + assignment.getResourceName() + "' is Incomplete.");
            logCompare(true, true, "====== Stop Mark Assignment as Incomplete.");
        }
        return bReturn;
    }
    public boolean unassignMove(B2WAssignment assignment) {
        boolean bReturn = false;
        if (assignment != null) {
            logCompare(true, true, "====== Start Unassign Move Assignment.");
            bReturn = logCompare(true, openContextMenu(assignment), "Open Assignment's Context Menu");
            bReturn &= logCompare(true, selectOptionFromContextMenu("Unassign Move"), "Select 'Unassign Move' from Context Menu.");
            bReturn &= logCompare(true, selectButtonOption("Yes"), "Confirm on Dialog.");
            assignment.setAssignmentType(B2WAssignmentType.MOVE_ORDER_TYPE);
            WebElement result = getAssignment(assignment);
            bReturn &= logCompare(true,  result != null, "Verification that specific Assignment has been converted to Move Assignment.");
            logCompare(true, true, "====== Stop Unassign Move Assignment.");
        }
        return bReturn;
    }

    public boolean openConflictPanel() {
        boolean bReturn = false;
        WebElement eConflictBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getConflictButton());
        if (eConflictBtn != null) {
            WebElement parent = WebElementUtils.getParentElement(eConflictBtn);
            if (!parent.getAttribute("class").contains("Toolbar__toggle-button--checked")) {
                bReturn = WebElementUtils.clickElement(eConflictBtn);
                TaskUtils.sleep(1000);
                waitForSchedulesPageNoBusy();
                bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getConflictsPanel(), WebElementUtils.LONG_TIME_OUT) != null;
            } else {
                bReturn = true;
            }
        } else {
            log.debug("Conflict button could not be found on the page.");
        }
        return bReturn;
    }
    public boolean closeConflictPanel() {
        boolean bReturn = false;
        //WebElement eConflictPanel = WebElementUtils.findElement(B2WScheduleAssignments.getConflictsPanel());
        WebElement eConflictPanel = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getConflictsPanel());
        WebElement eConflictBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getCheckedBtn());
        if (eConflictBtn != null && eConflictPanel != null) {
            bReturn = WebElementUtils.clickElement(eConflictBtn);
            if (!bReturn) {
                eConflictBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getCheckedBtn());
                if (eConflictBtn != null) {
                    TaskUtils.sleep(1000);
                    waitForSchedulesPageNoBusy();
                    bReturn = WebElementUtils.clickElement(eConflictBtn);
                }
            }
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitForElementInvisible(eConflictPanel);
        } else {
            log.debug("Conflict button could not be found on the page.");
        }
        return bReturn;
    }
    public boolean conflictIconIsDisplayed(B2WAssignment assignment) {
        boolean bReturn = false;
        WebElement eResourceLine = getResourceLine(assignment.getResourceName());
        if (eResourceLine != null) {
            WebElement parent = WebElementUtils.getParentElement(eResourceLine);
            WebElement eResourceWarningIcon = null;
            switch (assignment.getAssignmentType()) {
                case B2WAssignmentType.EMPLOYEE_TYPE :
                    eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierAlert());
                    break;
                case B2WAssignmentType.EQUIPMENT_TYPE :
                    eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierAlert());
                    break;
                case B2WAssignmentType.CREW_TYPE :
                    eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierAlert());
                    if (eResourceWarningIcon == null) {
                        eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierCaution());
                    }
                    break;
                case B2WAssignmentType.MOVE_ASSIGNMENT_TYPE :
                    eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierAlert());
                    break;
                case B2WAssignmentType.EMPLOYEE_EVENT_TYPE :
                    eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierAlert());
                    break;
                case B2WAssignmentType.EQUIPMENT_EVENT_TYPE :
                    eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierAlert());
                    break;
                case B2WAssignmentType.LOCATION_EVENT_TYPE :
                    eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceIconModifierAlert());
                    break;
                default : break;
            }
            if (eResourceWarningIcon != null && WebElementUtils.getParentElement(eResourceWarningIcon).isDisplayed()) {
                bReturn = WebElementUtils.clickElement(eResourceWarningIcon);
                WebElement eTooltip = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getTooltip());
                if (eTooltip != null) {
                    bReturn = WebElementUtils.getChildElementContainsText(eTooltip, By.cssSelector("a.Text--link"), "View in Conflicts Panel") != null;
                } else {
                    log.debug("Tooltip is not displayed.");
                }
            } else {
                log.debug("Warning Icon could not be found for Resource: " + assignment.getResourceName());
            }
        } else {
            log.debug("Could not find resource line for + " + assignment.getResourceName());
        }
        return bReturn;
    }
    public boolean resolveConflict(B2WAssignment assignment) {
        boolean bReturn;
        WebElement conflict = getConflictForResource(assignment.getResourceName());
        if (conflict != null) {
            bReturn = logCompare(true, selectConflict(conflict), "Select Conflict on the panel..");
            bReturn &= logCompare(true, deleteAssignment(assignment), "Delete Assignment");
        } else {
            bReturn = logCompare(true, false, "Conflict for " + assignment.getResourceName() + " could not be found on the page.");
        }
        return bReturn;
    }

    public boolean openOrderPanel() {
        boolean bReturn = false;
        WebElement eOrderPanelBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getOrderPanelButton());
        if (eOrderPanelBtn != null) {
            bReturn = WebElementUtils.clickElement(eOrderPanelBtn);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getOrderPanel(), WebElementUtils.LONG_TIME_OUT) != null;
        } else {
            log.debug("Order button could not be found on the page.");
        }
        return bReturn;
    }
    public boolean setOrdersFilter(String sValue) {
        boolean bReturn = false;
        WebElement eOrderPanel = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getOrderPanel(), WebElementUtils.LONG_TIME_OUT);
        if (eOrderPanel != null) {
            WebElement searchBox = WebElementUtils.getChildElement(eOrderPanel, B2WScheduleAssignments.getSearchBoxOnPanel());
            if (searchBox != null) {
                searchBox.clear();
                bReturn = WebElementUtils.sendKeys(searchBox, sValue);
            }
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Order button could not be found on the page.");
        }
        return bReturn;
    }
    public boolean warningIconIsDisplayed(String sResourceName) {
        boolean bReturn = false;
        WebElement eResourceLine = getResourceLine(sResourceName);
        if (eResourceLine != null) {
            WebElement parent = WebElementUtils.getParentElement(eResourceLine);
            WebElement eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourcesIconNeed());
            if (eResourceWarningIcon != null && WebElementUtils.getParentElement(eResourceWarningIcon).isDisplayed()) {
                bReturn = WebElementUtils.clickElement(eResourceWarningIcon);
                WebElement eTooltip = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getTooltip());
                if (eTooltip != null) {
                    bReturn = WebElementUtils.getChildElementContainsText(eTooltip, By.cssSelector("a.Text--link"), "View in Orders/Needs Panel") != null;
                } else {
                    log.debug("Tooltip is not displayed.");
                }
            } else {
                log.debug("Warning Icon could not be found for Resource: " + sResourceName);
            }
        } else {
            log.debug("Could not find resource line for + " + sResourceName);
        }
        return bReturn;
    }
    public boolean resolveOrderByDelete(B2WAssignment assignment) {
        boolean bReturn;
        WebElement order = getOrderForResource(assignment.getResourceName());
        if (order != null) {
            int initialCount = getAllOrdersFromPanel().size();
            bReturn = logCompare(true, selectOrder(order), "Select Conflict on the panel..");
            bReturn &= logCompare(true, deleteAssignment(assignment), "Delete Assignment");
            bReturn &= logCompare(true, initialCount - 1 == getAllOrdersFromPanel().size() , "Verify that Need was deleted from Order Panel.");
        } else {
            bReturn = logCompare(true, false, "Conflict for " + assignment.getResourceName() + " could not be found on the page.");
        }
        return bReturn;
    }
    public boolean resolveOrderByFill(B2WAssignment assignment, String sFillResourceName) {
        boolean bReturn;
        String tmpName = assignment.getResourceName();
        WebElement order = getOrderForResource(assignment.getResourceName());
        if (order != null) {
            int initialCount = getAllOrdersFromPanel().size();
            bReturn = logCompare(true, selectOrder(order), "Select Conflict on the panel..");
            WebElement eAssignment = getAssignment(assignment);
            if (eAssignment != null) {
                bReturn &= logCompare(true, openContextMenu(eAssignment), "Open Assignment's Context Menu");
                switch (assignment.getAssignmentType()) {
                    case B2WAssignmentType.EMPLOYEE_NEED_TYPE:
                        bReturn &= selectOptionFromContextMenu("Fill Need");
                        //bReturn &= logCompare(true, fillNeedDialog(assignment, sFillResourceName), "Fill Need to " + sFillResourceName);
                        bReturn &= logCompare(true, fillNeedDialog(sFillResourceName), "Fill Need to " + sFillResourceName);
                        assignment.setAssignmentType(B2WAssignmentType.EMPLOYEE_TYPE);
                        assignment.setResourceName(sFillResourceName);
                        break;
                    case B2WAssignmentType.EQUIPMENT_NEED_TYPE:
                        bReturn &= selectOptionFromContextMenu("Fill Need");
                        //bReturn &= logCompare(true, fillNeedDialog(assignment, sFillResourceName), "Fill Need to " + sFillResourceName);
                        bReturn &= logCompare(true, fillNeedDialog(sFillResourceName), "Fill Need to " + sFillResourceName);
                        assignment.setAssignmentType(B2WAssignmentType.EQUIPMENT_TYPE);
                        assignment.setResourceName(sFillResourceName);
                        break;
                    case B2WAssignmentType.CREW_NEED_TYPE:
                        bReturn &= selectOptionFromContextMenu("Fill Need");
                        //bReturn &= logCompare(true, fillNeedDialog(assignment, sFillResourceName), "Fill Need to " + sFillResourceName);
                        bReturn &= logCompare(true, fillNeedDialog(sFillResourceName), "Fill Need to " + sFillResourceName);
                        assignment.setAssignmentType(B2WAssignmentType.CREW_TYPE);
                        assignment.setResourceName(sFillResourceName);
                        break;
                    case B2WAssignmentType.MOVE_ORDER_TYPE:
                        bReturn &= selectOptionFromContextMenu("Assign Move Order");
                        bReturn &= logCompare(true, setCrew(sFillResourceName), "Set Crew");
                        bReturn &= logCompare(true, saveAssignment(), "Save Assigned Move Order");
                        assignment.setAssignmentType(B2WAssignmentType.MOVE_ASSIGNMENT_TYPE);
                        assignment.setTransportationCrew(sFillResourceName);
                        break;
                    default:
                        break;
                }
                logCompare(true, setOrdersFilter(tmpName), "Set Filter: " + tmpName + " on the Order panel.");
                bReturn &= logCompare(true, initialCount - 1 == getAllOrdersFromPanel().size(), "Verify that Need was deleted from Order Panel.");
            } else {
                bReturn = false;
            }
        } else {
            bReturn = logCompare(true, false, "Conflict for " + assignment.getResourceName() + " could not be found on the page.");
        }
        return bReturn;
    }
    public boolean resolveOrderByDrag(B2WAssignment assignment, String sFillResourceName) {
        boolean bReturn = false;
        int initialCount = getAllOrdersFromPanel().size();
        WebElement order = getOrderForResource(assignment.getResourceName());
        String tmpName = assignment.getResourceName();
        if (order != null) {
            bReturn = logCompare(true, selectOrder(order), "Select Conflict on the panel..");

            switch (assignment.getAssignmentType()) {
                case B2WAssignmentType.EMPLOYEE_NEED_TYPE:
                    bReturn &= logCompare(true, moveAssignmentToResourceAndDate(assignment, sFillResourceName, assignment.getStartDateAsDate(), false),
                            "Move Need ("+ assignment.getResourceName() +") to Resource (" + sFillResourceName + ")");
                    //bReturn &= logCompare(true, selectButtonOption("Yes"), "Confirm Fill Need.");
                    assignment.setAssignmentType(B2WAssignmentType.EMPLOYEE_TYPE);
                    assignment.setResourceName(sFillResourceName);
                    break;
                case B2WAssignmentType.EQUIPMENT_NEED_TYPE:
                    bReturn &= setFillWith("All Equipment");
                    bReturn &= logCompare(true, moveAssignmentToResourceAndDate(assignment, sFillResourceName, assignment.getStartDateAsDate(), false),
                            "Move Need ("+ assignment.getResourceName() +") to Resource (" + sFillResourceName + ")");
                    bReturn &= logCompare(true, selectButtonOption("Yes"), "Confirm Fill Need.");
                    assignment.setAssignmentType(B2WAssignmentType.EQUIPMENT_TYPE);
                    assignment.setResourceName(sFillResourceName);
                    break;
                case B2WAssignmentType.CREW_NEED_TYPE:
                    bReturn &= setFillWith("All Production Crews");
                    bReturn &= logCompare(true, moveAssignmentToResourceAndDate(assignment, sFillResourceName, assignment.getStartDateAsDate(), false),
                            "Move Need ("+ assignment.getResourceName() +") to Resource (" + sFillResourceName + ")");
                    bReturn &= logCompare(true, selectButtonOption("Yes"), "Confirm Fill Need.");
                    assignment.setAssignmentType(B2WAssignmentType.CREW_TYPE);
                    assignment.setResourceName(sFillResourceName);
                    break;
                case B2WAssignmentType.MOVE_ORDER_TYPE:
                    bReturn &= setFillWith("All Transport Crews");
                    bReturn &= logCompare(true, moveAssignmentToResourceAndDate(assignment, sFillResourceName, assignment.getStartDateAsDate(), false),
                            "Move Need ("+ assignment.getResourceName() +") to Resource (" + sFillResourceName + ")");
                    bReturn &= logCompare(true, saveAssignment(), "Save Assigned Move Order");
                    assignment.setAssignmentType(B2WAssignmentType.MOVE_ASSIGNMENT_TYPE);
                    assignment.setTransportationCrew(sFillResourceName);
                    break;
                default:
                    break;
            }
            logCompare(true, setOrdersFilter(tmpName), "Set Filter: " + tmpName + " on the Order panel.");
            bReturn &= logCompare(true, initialCount - 1 == getAllOrdersFromPanel().size() , "Verify that Need was deleted from Order Panel.");
            bReturn &= logCompare(true, getAssignment(assignment) != null, "Verify that Need was transformed to Assignment.");
        }
        return bReturn;
    }
    public boolean isOrderPanelEmpty() { return getAllOrdersFromPanel().size() == 0; }
    public int getOrdersCount() { return getAllOrdersFromPanel().size(); }

    public boolean collapseCalendarPanel() {
        boolean bReturn = true;
        WebElement item = WebElementUtils.findElement(B2WScheduleAssignments.getCollapseCalendarIcon());
        WebElement tmp = WebElementUtils.findElement(B2WScheduleAssignments.getCalendarActiveDateRange());
        if (item != null) {
            bReturn = WebElementUtils.clickElement(item);
            WebElementUtils.waitForElementInvisible(tmp);
        }
        return bReturn;
    }
    public boolean expandCalendarPanel() {
        boolean bReturn = true;
        WebElement item = WebElementUtils.findElement(B2WScheduleAssignments.getExpandCalendarIcon());
        if (item != null) {
            bReturn = WebElementUtils.clickElement(item);
            WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getCalendarActiveDateRange());
        }
        return bReturn;
    }

    // ==== Private Methods ============================================================================================
    // === Menu for Creation
    private boolean openCreateDialog(String sItem) {
        boolean bReturn;
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getCreationSection(), 1);
        WebElement creationSection = WebElementUtils.findElement(B2WScheduleAssignments.getCreationSection());
        WebElement dropDownMenu = WebElementUtils.getChildElement(creationSection, B2WScheduleAssignments.getKendoDropDown());
        bReturn = clickAndSelectValueFromKendoFDD(dropDownMenu, sItem);
        waitForSchedulesPageNoBusy();
        return bReturn;
    }
    private boolean selectNewAssignmentOrNeed() {
        return openCreateDialog(MENU_ASSIGNMENT);
    }
    private boolean selectNewCrewAssignment() {
        return openCreateDialog(CREWASSIGNMENT);
    }
    private boolean selectNewCrewNeed() {
        return openCreateDialog(CREWNEED);
    }
    private boolean selectNewMoveAssignment() {
        return openCreateDialog(MOVEASSIGNMENT);
    }
    private boolean selectNewMoveOrder() {
        return openCreateDialog(MOVEORDER);
    }
    private boolean selectNewEmployeeEvent() {
        boolean bResult;
        bResult = selectNewEvent("Employee");
        return bResult;
    }
    private boolean selectNewEquipmentEvent() {
        boolean bResult;
        bResult = selectNewEvent("Equipment");
        return bResult;
    }
    private boolean selectNewLocationEvent() {
        boolean bResult;
        bResult = selectNewEvent("Location");
        return bResult;
    }
    private boolean selectNewEvent(String sItem) {
        boolean bResult;
        bResult = openCreateDialog(EVENT);
        if (bResult) {
            bResult = false;
            TaskUtils.sleep(100);
            List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getLinksContainer());
            if (list.size() > 0) {
                Iterator<WebElement> iterator = list.iterator();
                while (iterator.hasNext() && !bResult) {
                    WebElement els = iterator.next();

                    if (els.isDisplayed()) {
                        List<WebElement> items = els.findElements(B2WScheduleAssignments.getLinks());
                        WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
                        if (item != null) {
                            bResult = WebElementUtils.clickElement(item);
                        } else {
                            log.debug("Item with could not be found matching 'Employee'");
                        }
                    }
                }
            }
            if (!bResult) log.debug("Submenu '" + sItem + "' could not be found.");
        } else {
            log.debug("Menu 'New -> Event' could not be clicked.");
        }
        return bResult;
    }

    // === Context Menu
    private boolean openContextMenu(WebElement eAssignment) {
        boolean bReturn = false;
        if (eAssignment != null) {
            bReturn = WebElementUtils.clickElement(eAssignment);
            WebElementUtils.waitForElementClickable(eAssignment);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getContextMenu()) != null;
        }
        return bReturn;
    }
    private boolean openContextMenu(B2WAssignment assignment) {
        return openContextMenu(getAssignment(assignment));
    }
    private boolean selectCreateSubstitution() {
        return selectOptionFromContextMenu("Create Substitution");
    }
    private boolean selectOptionFromContextMenu(String sMenuOption) {
        boolean bReturn = false;
        WebElement contextMenu = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getContextMenu());
        if (contextMenu != null) {
            List<WebElement> list = WebElementUtils.getChildElements(contextMenu, By.cssSelector(".k-link"));
            Iterator<WebElement> iterator = list.iterator();
            while (iterator.hasNext() && !bReturn) {
                WebElement item = iterator.next();
                String sTmp = item.getText();
                if (sTmp.contains(sMenuOption)) {
                    bReturn = WebElementUtils.clickElement(item);
                    TaskUtils.sleep(500);
                    waitForSchedulesPageNoBusy();
                }
            }
            if (!bReturn) {
                log.debug("Could not found " + sMenuOption + " in the Context Menu.");
            }
        } else {
            log.debug("Context menu could not be found on the page.");
        }
        return bReturn;
    }
    private boolean expandAll() {
        boolean bReturn = false;
        WebElement eToolBarPanel = WebElementUtils.findElement(B2WScheduleAssignments.getToolBarPanel());
        if (eToolBarPanel != null) {
            List<WebElement> list = WebElementUtils.getChildElements(eToolBarPanel, B2WScheduleAssignments.getExpandIcon());
            boolean flag = true;
            for (WebElement el : list) {
                if (el.isDisplayed()) {
                    flag &= WebElementUtils.clickElement(el);
                    waitForSchedulesPageNoBusy();
                    flag &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
                }
            }
            bReturn = flag;
        } else {
            log.debug("ToolBar panel could not be found.");
        }
        return bReturn;
    }

    // === Get Methods
    // ==Methods for Assignments
    private List<WebElement> getAllAssignments() {
        return WebElementUtils.findElements(B2WScheduleAssignments.getAssignment());
    }
    private List<WebElement> getAssignmentsByLocation(String sLocationName) {
        return WebElementUtils.getElementsWithMatchingAttribute(getAllAssignments(), "title", sLocationName);
    }
    private List<WebElement> getAssignmentsByLocationAndResourceName(B2WAssignment assignment) {
        List<WebElement> lReturn = new ArrayList<WebElement>();
        List<WebElement> list = getAssignmentsByLocation(assignment.getLocationName());
        for (WebElement eTmp : list) {
            WebElement parent = WebElementUtils.getParentUntilTagName(eTmp, "td");
            if (parent != null) {
                WebElement eResourceName = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceName());
                String type = WebElementUtils.getParentElement(eTmp).getAttribute("class");
                if (type != null) {
                    if (eResourceName.getAttribute("title").equals(assignment.getResourceName()) && type.contains(assignment.getAssignmentType())) {
                        lReturn.add(eTmp);
                    }
                }
            } else {
                log.debug("Parent doesn't have tag 'td'");
                return null;
            }
        }
        return lReturn;
    }
    private int getAssignmentsCount(B2WAssignment assignment) {
        return getAssignmentsByLocationAndResourceName(assignment).size();
    }
    private WebElement getAssignment(B2WAssignment assignment) {
        WebElement eReturn = null;

        Date startDate = assignment.getDateList().get(0);
        Date endDate = assignment.getDateList().get(assignment.getDateList().size()-1);
        List<WebElement> list = getAssignmentsByLocationAndResourceName(assignment);
        Iterator<WebElement> iterator = list.iterator();
        boolean flag = false;
        while (iterator.hasNext() && !flag) {
            WebElement eTmp = iterator.next();
            WebElement parent = WebElementUtils.getParentElement(eTmp);
            String b2wAssignmentStart = parent.getAttribute("b2w-assignment-start").replace('T', ' ');
            String b2wAssignmentEnd = parent.getAttribute("b2w-assignment-end").replace('T', ' ');
            Date assignmentStartDate = StringUtils.getDateFromStringWithPattern(b2wAssignmentStart, "yyyy-M-d HH:mm");
            Date assignmentEndDate = StringUtils.getDateFromStringWithPattern(b2wAssignmentEnd, "yyyy-M-d HH:mm");
            String type = parent.getAttribute("class");
            if (assignmentStartDate.equals(startDate) && assignmentEndDate.equals(endDate) && type.contains(assignment.getAssignmentType())) {
                eReturn = eTmp;
                flag = true;
            }
        }
        return eReturn;
    }
    public WebElement getResourceLine(String sResourceName) {
        return WebElementUtils.findElement(B2WScheduleAssignments.getSpecificResourceName(sResourceName));
    }

    // === Set Methods
    // == Assignments\Needs
    private boolean setGeneralFields(B2WAssignment assignment) {
        boolean bReturn;
        bReturn = logCompare(true, setJobSite(assignment.getLocationName()), "Set JobSite/Place: " + assignment.getLocationName());
        bReturn &= logCompare(true, setRequestedBy(assignment.getRequestedBy()), "Set Requested By: " + assignment.getRequestedBy());
        bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes: " + assignment.getNotes());
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Set Duration: " + assignment.getDuration());
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Set Start Time: " + assignment.getStartTime());
        return bReturn;
    }

    // == Method to set value to FDD fields
    private boolean setFields(String sFieldName, String sValue) {
        boolean bReturn = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);
        WebElement employeeAssignment = WebElementUtils.getKendoFDDElementByLabel(sFieldName);
        if (employeeAssignment != null && assignmentWindow != null) {
            bReturn = sendTextAndSelectValueFromKendoFDD(employeeAssignment, sValue);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Create Assignment Window or Field '" + sFieldName + "' could not be found.");
        }
        return bReturn;
    }
    // == Set Values on Create Assignments\Needs Dialog
    private boolean setJobSite(String sValue) {
        return setFields("Job Site/Place", sValue);
    }
    private boolean setRequestedBy(String sValue) { return setFields("Requested By", sValue); }
    private boolean setAssignmentNotes(String sValue) {
        boolean bResult = false;
        WebElement notesField = WebElementUtils.findElement(B2WScheduleAssignments.getNotesField());
        if (notesField != null) {
            bResult = WebElementUtils.sendKeys(notesField, sValue);
        } else {
            log.debug("Element 'Requested By' could not be found on the page." );
        }
        return bResult;
    }
    private boolean setEmployees(String sValue) {
        return setFields("Employees", sValue);
    }
    private boolean setEmployeeNeed(String sValue) {
        return setFields("Employee Needs", sValue);
    }
    private boolean setEquipment(String sValue) {
        return setFields("Equipment", sValue);
    }
    private boolean setEquipmentNeed(String sValue) {
        return setFields("Equipment Needs", sValue);
    }
    private boolean setEmployee(String sValue) {
        return setFields("Employee", sValue);
    }
    private boolean setDuration(String sValue) { return setFields("Duration", sValue); }
    private boolean setStartTime(String sValue) {
        boolean bReturn = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);

        if (assignmentWindow != null) {
            List<WebElement> inputList = WebElementUtils.findElements(By.cssSelector("label"));
            WebElement el = WebElementUtils.getElementWithMatchingText(inputList, "Start Time", false);
            WebElement startTimeDD = WebElementUtils.getParentElement(el);
            if (startTimeDD != null) {
                WebElement clockBtn = WebElementUtils.getChildElement(startTimeDD, B2WScheduleAssignments.getClockBtn());
                WebElementUtils.clickElement(clockBtn);
                TaskUtils.sleep(100);
                bReturn = selectItemFromFDD(sValue);
            }
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Create Assignment Window could not be found");
        }
        return bReturn;
    }

    // == Set values on Create Crew Assignment\Need Dialog
    private boolean setCrew(String sValue) {
        return setFields("Crew", sValue);
    }
    private boolean setCrewNeed(String sValue) {
        return setFields("Crew Need", sValue);
    }
    private boolean setResourceName(String sFieldName, ArrayList<String> list) {
        boolean bReturn = false;
        WebElement addResourceDialog = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAddToCrewDialog());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAddToCrewDialog(), 1);
        WebElement resourceSection = WebElementUtils.getKendoFDDElementByLabel(addResourceDialog, sFieldName);
        if (resourceSection != null && addResourceDialog != null) {
            for (String item: list) {
                bReturn = sendTextAndSelectValueFromKendoFDD(resourceSection, item);
            }
        } else {
            log.debug("Add Resource to Crew Window or Field '" + sFieldName + "' could not be found on the page.");
        }
        return bReturn;
    }

    // == Set values on Move Assignment\Order Dialog
    private boolean setPickupDate(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Pickup Date");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    private boolean setPickupAfter(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Pickup After");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    private boolean setPickupTime(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Pickup Time");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    private boolean setDropoffDate(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Drop-off Date");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    private boolean setDropoffBefore(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Drop-off Before");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    private boolean setDropoffTime(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Drop-off Time");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    private boolean setPickupLocation(String sPickupType, String sPickupJobSiteName) {
        boolean bResult;
        WebElement dropDown = WebElementUtils.getKendoFDDElementByLabel("Pickup Location");
        bResult = clickAndSelectValueFromKendoFDD(dropDown, sPickupType);

        List<WebElement> inputList = WebElementUtils.findElements(B2WScheduleAssignments.getFieldLabel());
        WebElement el = WebElementUtils.getElementWithMatchingText(inputList, "Pickup Location", false);
        WebElement parent = WebElementUtils.getParentElement(el);
        WebElement elControlPanel = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getAddressSection());
        WebElement jobSite = WebElementUtils.getChildElement(elControlPanel, KendoUI.getKendoDropDown());
        if (jobSite != null) {
            bResult &= sendTextAndSelectValueFromKendoFDD(jobSite, sPickupJobSiteName);
        } else {
            bResult = false;
            log.debug("Job Site/Place field could not be found for Pickup Location.");
        }
        return bResult;
    }
    private boolean setDropoffLocation(String sDropoffType, String sDropoffJobSiteName) {
        boolean bResult;
        WebElement dropDown = WebElementUtils.getKendoFDDElementByLabel("Drop-off Location");
        bResult = clickAndSelectValueFromKendoFDD(dropDown, sDropoffType);

        List<WebElement> inputList = WebElementUtils.findElements(B2WScheduleAssignments.getFieldLabel());
        WebElement el = WebElementUtils.getElementWithMatchingText(inputList, "Drop-off Location", false);
        WebElement parent = WebElementUtils.getParentElement(el);
        WebElement elControlPanel = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getAddressSection());
        WebElement jobSite = WebElementUtils.getChildElement(elControlPanel, KendoUI.getKendoDropDown());
        if (jobSite != null) {
            bResult &= sendTextAndSelectValueFromKendoFDD(jobSite, sDropoffJobSiteName);
        } else {
            bResult = false;
            log.debug("Job Site/Place field could not be found for Drop-off Location.");
        }
        return bResult;
    }

    // == Click Methods
    private boolean clickSelectCrewBtn() {
        boolean bResult = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);
        WebElement selectBtn = WebElementUtils.getChildElement(assignmentWindow, B2WScheduleAssignments.getSelectCrewBtn());
        if (selectBtn != null) {
            bResult = WebElementUtils.clickElement(selectBtn);
            bResult &= WebElementUtils.getKendoFDDElementByLabel("Crew") != null;
        } else {
            log.debug("Select Crew button could not be found.");
        }
        return bResult;
    }
    private boolean clickViewCrew() {
        boolean bReturn = false;
        WebElement viewBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getViewCrewBtn());
        if (viewBtn != null) {
            bReturn = WebElementUtils.clickElement(viewBtn);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getHideCrewBtn()) != null;
        }
        return bReturn;
    }
    private boolean clickHideCrew() {
        boolean bReturn = false;
        WebElement hideBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getHideCrewBtn());
        if (hideBtn != null) {
            bReturn = WebElementUtils.clickElement(hideBtn);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getViewCrewBtn()) != null;
        }
        return bReturn;
    }
    private boolean clickAddCrewResource() {
        boolean bReturn = false;
        WebElement hideBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getAddCrewResourceBtn());
        if (hideBtn != null) {
            bReturn = WebElementUtils.clickElement(hideBtn);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getAddToCrewDialog()) != null;
        }
        return bReturn;
    }
    private boolean clickAddToCrew() {
        boolean bReturn = false;
        WebElement saveBtn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getAddToCrewBtn());
        if (saveBtn != null) {
            bReturn = WebElementUtils.clickElement(saveBtn);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getAddToScheduleBtn()) != null;
        }
        return bReturn;
    }

    // == Set values on Event
    private boolean setEventEmployee(String sValue) {
        return setFields("Employee", sValue);
    }
    private boolean setEventType(String sTypeName) {
        boolean bResult = false;
        WebElement dropDown = WebElementUtils.findElement(B2WScheduleAssignments.getEventTypeDropDown());
        if (dropDown != null) {
            WebElement parent = WebElementUtils.getParentElement(dropDown);
            bResult = WebElementUtils.clickElement(parent);
            bResult &= selectItemFromDropDown(sTypeName);
        } else {
            log.debug("Could not find 'Select event type' dropdown.");
        }
        return bResult;
    }
    private boolean setEventEquipment(String sEquipmentName) {
        return setFields("Equipment", sEquipmentName);
    }
    private boolean setEventLocation(String sJobSiteName) {
        return setFields("Location", sJobSiteName);
    }

    // == Update Assignments
    private boolean updateEmployeeAssignment(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Assignment"), "Select 'Edit Assignment' from Context Menu.");
        bReturn &= logCompare(true, setJobSite(assignment.getLocationName()), "Update JobSite/Place");
        bReturn &= logCompare(true, updateEmployees(assignment.getResourceName()), "Update Employee");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Update Duration");
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Update Start Time");
        return bReturn;
    }
    private boolean updateSubstitution(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Substitution"), "Select 'Edit Substitution' from Context Menu.");
        bReturn &= logCompare(true, updateEmployee(assignment.getResourceName()), "Update Employee");
        return bReturn;
    }
    private boolean updateEmployeeNeed(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Need"), "Select 'Edit Need' from Context Menu.");
        bReturn &= logCompare(true, setJobSite(assignment.getLocationName()), "Update JobSite/Place");
        bReturn &= logCompare(true, updateEmployeeNeed(assignment.getResourceName()), "Update Need");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Update Duration");
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Update Start Time");
        return bReturn;
    }
    private boolean updateEquipmentAssignment(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Assignment"), "Select 'Edit Assignment' from Context Menu.");
        bReturn &= logCompare(true, setJobSite(assignment.getLocationName()), "Update JobSite/Place");
        bReturn &= logCompare(true, updateEquipment(assignment.getResourceName()), "Update Equipment");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Update Duration");
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Update Start Time");
        return bReturn;
    }
    private boolean updateEquipmentNeed(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Need"), "Select 'Edit Need' from Context Menu.");
        bReturn &= logCompare(true, setJobSite(assignment.getLocationName()), "Update JobSite/Place");
        bReturn &= logCompare(true, updateEquipmentNeed(assignment.getResourceName()), "Update Equipment Need");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Update Duration");
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Update Start Time");
        return bReturn;
    }
    private boolean updateCrewAssignment(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Assignment"), "Select 'Edit Assignment' from Context Menu.");
        bReturn &= logCompare(true, setJobSite(assignment.getLocationName()), "Update JobSite/Place");
        bReturn &= logCompare(true, updateCrew(assignment.getResourceName()), "Update Crew");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Update Duration");
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Update Start Time");
        return bReturn;
    }
    private boolean updateCrewNeed(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Need"), "Select 'Edit Need' from Context Menu.");
        bReturn &= logCompare(true, setJobSite(assignment.getLocationName()), "Update JobSite/Place");
        bReturn &= logCompare(true, updateCrewNeed(assignment.getResourceName()), "Update Crew Need");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Update Duration");
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Update Start Time");
        return bReturn;
    }
    private boolean updateMoveAssignment(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Move Assignment"), "Select 'Edit Move Assignment' from Context Menu.");
        bReturn &= logCompare(true, clickEditLocation(), "Click 'Edit Location' link");
        bReturn &= logCompare(true, setPickupLocation("Job Site/Place", assignment.getPickupLocation()), "Update Pickup Location");
        bReturn &= logCompare(true, setDropoffLocation("Job Site/Place", assignment.getDropoffLocation()), "Update Drop-off Location");
        bReturn &= logCompare(true, clickSelectCrewBtn(), "Click 'Edit Crew' button");
        bReturn &= logCompare(true, updateTransportationCrew(assignment.getTransportationCrew()), "Update Transportation Crew");
        bReturn &= logCompare(true, setPickupDate(assignment.getPickupDate()), "Set Pickup Date");
        bReturn &= logCompare(true, setPickupTime(assignment.getPickupTime()), "Set Pickup Time");
        bReturn &= logCompare(true, setDropoffDate(assignment.getDropoffDate()), "Set Dropoff Date");
        bReturn &= logCompare(true, setDropoffTime(assignment.getDropoffTime()), "Set Dropoff Time");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        return bReturn;
    }
    private boolean updateMoveOrder(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Move Order"), "Select 'Edit Move Order' from Context Menu.");
        bReturn &= logCompare(true, setPickupLocation("Job Site/Place", assignment.getPickupLocation()), "Update Pickup Location");
        bReturn &= logCompare(true, setDropoffLocation("Job Site/Place", assignment.getDropoffLocation()), "Update Drop-off Location");
        bReturn &= logCompare(true, setPickupAfter(assignment.getPickupDate()), "Set Pickup After");
        bReturn &= logCompare(true, setPickupTime(assignment.getPickupTime()), "Set Pickup Time");
        bReturn &= logCompare(true, setDropoffBefore(assignment.getDropoffDate()), "Set Drop-off Before");
        bReturn &= logCompare(true, setDropoffTime(assignment.getDropoffTime()), "Set Drop-off Time");
        bReturn &= logCompare(true, updateRequestedBy(assignment.getRequestedBy()), "Update Requested By");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        return bReturn;
    }
    private boolean updateEmployeeEvent(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Event"), "Select 'Edit Event' from Context Menu.");
        bReturn &= logCompare(true, updateEventEmployee(assignment.getResourceName()), "Update Employee");
        bReturn &= logCompare(true, setEventType(assignment.getLocationName()), "Update Employee Event Type");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        return bReturn;
    }
    private boolean updateEquipmentEvent(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Event"), "Select 'Edit Event' from Context Menu.");
        bReturn &= logCompare(true, updateEventEquipment(assignment.getResourceName()), "Update Equipment");
        bReturn &= logCompare(true, setEventType(assignment.getLocationName()), "Update Equipment Event Type");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        return bReturn;
    }
    private boolean updateLocationEvent(B2WAssignment assignment) {
        boolean bReturn = logCompare(true, selectOptionFromContextMenu("Edit Event"), "Select 'Edit Event' from Context Menu.");
        bReturn &= logCompare(true, updateEventLocation(assignment.getResourceName()), "Update Location");
        bReturn &= logCompare(true, setEventType(assignment.getLocationName()), "Update Location Event Type");
        bReturn &= logCompare(true, updateNotes(assignment.getNotes()), "Update Notes");
        return bReturn;
    }

    // == Update Values on Assignments\Needs Dialog
    private boolean updateEmployees(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEmployees(sValue);
    }
    private boolean updateEmployee(String sValue) {
        clearFields("Employee");
        return setEmployee(sValue);
    }
    private boolean updateEmployeeNeed(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEmployeeNeed(sValue);
    }
    private boolean updateEquipment(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEquipment(sValue);
    }
    private boolean updateEquipmentNeed(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEquipmentNeed(sValue);
    }
    private boolean updateCrew(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setCrew(sValue);
    }
    private boolean updateCrewNeed(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setCrewNeed(sValue);
    }
    private boolean updateTransportationCrew(String sValue) {
        clearFields("Crew");
        return setCrew(sValue);
    }
    private boolean updateRequestedBy(String sValue) {
        clearFields("Requested By");
        return setRequestedBy(sValue);
    }
    private boolean updateNotes(String sValue) {
        boolean bResult = false;
        WebElement notesField = WebElementUtils.findElement(B2WScheduleAssignments.getNotesField());
        if (notesField != null) {
            notesField.clear();
            bResult = WebElementUtils.sendKeys(notesField, sValue);
        } else {
            log.debug("Element 'Requested By' could not be found on the page." );
        }
        return bResult;
    }
    private boolean updateEventEmployee(String sValue) {
        clearFields("Employee");
        return setEventEmployee(sValue);
    }
    private boolean updateEventEquipment(String sValue) {
        clearFields("Equipment");
        return setEventEquipment(sValue);
    }
    private boolean updateEventLocation(String sValue) {
        clearFields("Location");
        return setEventLocation(sValue);
    }
    private void clearFields(String sFieldName) {
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);

        if (assignmentWindow != null) {
            WebElement employeeAssignment = WebElementUtils.getKendoFDDElementByLabel(sFieldName);
            employeeAssignment.clear();
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Create Assignment Window could not be found");
        }
    }
    private boolean clickEditLocation() {
        boolean bReturn = false;
        WebElement eLink = WebElementUtils.findElement(B2WScheduleAssignments.getEditLocationLink());
        if (eLink != null) {
            bReturn = WebElementUtils.clickElement(eLink);
        } else {
            log.debug("'Edit Location' link could not be found on the page.");
        }
        return bReturn;
    }

    // === Save Methods
    private boolean saveGeneralAssignment(int count, B2WAssignment assignment, boolean expandAll) {
        boolean bReturn = true;
        bReturn &= logCompare(true, saveAssignment(), "Save Assignment");

        if (expandAll) {
            logCompare(true, expandAll(), "Expand All levels");
        }
        int actualCount = getAssignmentsCount(assignment);
        bReturn &= logCompare(true, actualCount == count + 1, "Verification that number of Assignment has been increased by 1.");
        WebElement result = getAssignment(assignment);
        bReturn &= logCompare(true,  result != null, "Verification that specific Assignment has been created.");
        return bReturn;
    }
    private boolean saveAssignment() {
        /*
         * 1. Click on Add to Schedule button
         * 2. Check that Schedule View is displayed.
         */
        boolean bResult = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);
        if (assignmentWindow != null) {
            WebElement saveBtn = WebElementUtils.getChildElement(assignmentWindow, B2WScheduleAssignments.getAddToScheduleBtn());

            if (saveBtn != null && WebElementUtils.waitForElementClickable(saveBtn)) {
                bResult = WebElementUtils.clickElement(saveBtn);
                WebElementUtils.waitForElementInvisible(saveBtn);
                waitForSchedulesPageNoBusy();
                WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
                bResult &= WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getGrid()) != null;
            } else {
                log.debug("Add to Schedule button could not be found.");
            }
        }
        return bResult;
    }
    private boolean cancelAssignment() {
        /*
         * 1. Click on Add to Schedule button
         * 2. Check that Schedule View is displayed.
         */
        boolean bResult = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);
        WebElement cancelBtn = WebElementUtils.getChildElement(assignmentWindow, B2WScheduleAssignments.getCancelBtn());
        if (cancelBtn != null) {
            bResult = WebElementUtils.clickElement(cancelBtn);
            WebElementUtils.waitForElementInvisible(cancelBtn);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Add to Schedule button could not be found.");
        }
        return bResult;
    }
    private boolean selectButtonOption(String sButtonName) {
        boolean bReturn = false;
        WebElement button = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getDeleteOptionBtn(sButtonName));
        if (button != null) {
            bReturn = WebElementUtils.clickElement(button);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Button with text " + sButtonName + " could not be found on the page.");
        }
        return bReturn;
    }

    // === Date methods
    private String correctDate(String sValue) {
        String sResult = "";
        if (sValue.contains("/")) {
            String[] stringList = sValue.split("/");
            Integer iTmp = Integer.parseInt(stringList[1]);
            iTmp++;
            stringList[1] = String.valueOf(iTmp);
            sResult = stringList[0] + "/" + stringList[1] + "/" + stringList[2];
        } else if (sValue.contains("-")) {
            String[] stringList = sValue.split("-");
            Integer iTmp = Integer.parseInt(stringList[1]);
            iTmp++;
            stringList[1] = String.valueOf(iTmp);
            sResult = stringList[0] + "-" + stringList[1] + "-" + stringList[2];
        } else {
            log.debug("Date has incorrect format.");
        }
        return sResult;
    }
    private DateRange getSelectedDates() {
        Date startDate = null;
        Date endDate = null;

        List<WebElement> listDates = WebElementUtils.findElements(B2WScheduleAssignments.getSelectedDatesOnCalendar());

        for (WebElement item : listDates) {
            WebElement el = WebElementUtils.getChildElement(item, By.cssSelector("a.k-link"));
            if (el != null) {
                String dataValue = el.getAttribute("data-value");
                dataValue = correctDate(dataValue);
                Date tmpDate = StringUtils.getDateFromString(dataValue);
                if (startDate != null) {
                    if (startDate.after(tmpDate)) {
                        startDate = tmpDate;
                    }
                } else {
                    startDate = tmpDate;
                }
                if (endDate != null) {
                    if (endDate.before(tmpDate)) {
                        endDate = tmpDate;
                    }
                } else {
                    endDate = tmpDate;
                }
            }
        }

        return new DateRange(startDate, endDate);
    }
    private int getPositionInDateRange(Date end) {
        Date tmpDate = new Date(end.getTime());
        tmpDate.setHours(0);
        tmpDate.setMinutes(0);
        DateRange selectedDates = getSelectedDates();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(selectedDates.getLowerDate());
        int i = 0;
        while (!calendar.getTime().equals(tmpDate) && i != 365) {
            i++;
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return i;
    }

    // === Move Methods
    private boolean moveAssignmentToDate(WebElement item, Date date) {
        boolean bReturn = false;
        int iDateOffset = getPositionInDateRange(date);
        WebElement parent = WebElementUtils.getParentUntilTagName(item, "tr");
        if (parent != null) {
            List<WebElement> list = WebElementUtils.getChildElements(parent, B2WScheduleAssignments.getPlaceholders());
            if (list.size() > 0 && list.size() >= iDateOffset) {
                WebElement container = list.get(iDateOffset);
                try {
                    WebElementUtils.moveVirtualMouseOverElement(item);
                    TaskUtils.sleep(500);
                    new Actions(BrowserUtils.getDriver()).clickAndHold(item).moveToElement(container).release().perform();
                    waitForSchedulesPageNoBusy();
                    bReturn = true;
                } catch (Exception ex) {
                    log.debug("Could not perform move operation.");
                }
            } else {
                log.debug("Could not find placeholders for Resource");
            }
        } else {
            log.debug(item + " is not displayed on the page.");
        }
        return bReturn;
    }
    private boolean moveAssignmentToResourceAndDate(WebElement item, String sResourceName, Date date) {
        boolean bReturn = false;
        int iDateOffset = getPositionInDateRange(date);

        WebElement eResourceLine = getResourceLine(sResourceName);
        WebElement parent = WebElementUtils.getParentUntilTagName(eResourceLine, "tr");
        if (parent != null) {
            List<WebElement> list = WebElementUtils.getChildElements(parent, B2WScheduleAssignments.getPlaceholders());
            if (list.size() > 0 && list.size() >= iDateOffset) {
                WebElement container = list.get(iDateOffset);
                try {
                    WebElementUtils.moveVirtualMouseOverElement(container);
                    new Actions(BrowserUtils.getDriver()).clickAndHold(item).moveToElement(container).release().perform();
                    waitForSchedulesPageNoBusy();
                    bReturn = true;
                } catch (Exception ex) {
                    log.debug("Could not perform move operation.");
                }
            } else {
                log.debug("Could not find placeholders for Resource");
            }
        } else {
            log.debug(sResourceName + " is not displayed on the page.");
        }
        return bReturn;
    }
    private Date getAssignmentStartDate(WebElement item) {
        if (item != null) {
            try {
                WebElement parent = WebElementUtils.getParentElement(item);

                String b2wAssignmentStart = parent.getAttribute("b2w-assignment-start").replace('T', ' ');
                Date assignmentStartDate = StringUtils.getDateFromStringWithPattern(b2wAssignmentStart, "yyyy-M-d HH:mm");
                return assignmentStartDate;
            } catch (Exception ex) {
                log.debug("Could not get Parent element for: " + item.toString());
                return null;
            }
        } else {
            log.debug("Item is NULL.");
            return null;
        }
    }

    //Resize methods
    private boolean resizeAssignmentRightToDate(WebElement eAssignment, Date date) {
        boolean bReturn = false;
        if (eAssignment != null) {
            WebElement rightEdge = WebElementUtils.getChildElement(WebElementUtils.getParentElement(eAssignment), B2WScheduleAssignments.getAssignmentRightEdge());
            if (rightEdge != null) {
                bReturn = moveAssignmentToDate(rightEdge, date);
            } else {
                log.debug("Could not get right edge of assignment.");
            }

        }
        return bReturn;
    }
    private boolean resizeAssignmentLeftToDate(WebElement eAssignment, Date date) {
        boolean bReturn = false;
        if (eAssignment != null) {
            WebElement leftEdge = WebElementUtils.getChildElement(WebElementUtils.getParentElement(eAssignment), B2WScheduleAssignments.getAssignmentLeftEdge());
            if (leftEdge != null) {
                bReturn = moveAssignmentToDate(leftEdge, date);
            } else {
                log.debug("Could not get right edge of assignment.");
            }

        }
        return bReturn;
    }

    // Conflict Panel
    private List<WebElement> getAllConflictsFromPanel() {
        return WebElementUtils.findElements(B2WScheduleAssignments.getConflictFromPanel());
    }
    private WebElement getConflictForResource(String sResourceName) {
        return WebElementUtils.getElementWithContainsChildElementText(getAllConflictsFromPanel(), By.cssSelector("div.ng-binding"), sResourceName);
    }
    private boolean selectConflict(WebElement eConflict) {
        boolean bReturn = false;
        try {
            String expectedValue = eConflict.getText();

            bReturn = WebElementUtils.clickElement(eConflict);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getFillNeedToolbar()) != null;
            List<WebElement> firstItemDescList = WebElementUtils.findElements(B2WScheduleAssignments.getResourceDescription());
            if (firstItemDescList.size() > 0) {
                WebElement firstItem = WebElementUtils.getChildElement(firstItemDescList.get(0), B2WScheduleAssignments.getResourceDescriptionName());
                if (firstItem != null) {
                    String actualValue = firstItem.getAttribute("title");
                    bReturn &= expectedValue.contains(actualValue);
                }
            }
        } catch (Exception e) {
            log.warn("Exception: " + e.toString());
        }
        return bReturn;
    }

    // Order Panel
    //private boolean fillNeedDialog(B2WAssignment order, String employeeName) {
    private boolean fillNeedDialog(String employeeName) {
        boolean bReturn = false;
        WebElement dialog = WebElementUtils.findElement(B2WScheduleAssignments.getAssignmentWindow());
        if (dialog != null) {
            WebElement searchBox = WebElementUtils.getChildElement(dialog, B2WScheduleAssignments.getSearchBox());
            if (searchBox != null) {
                bReturn = WebElementUtils.sendKeys(searchBox, employeeName);
                WebElement checkbox = WebElementUtils.getChildElement(dialog, B2WScheduleAssignments.getFirstEmployeeCheckbox());
                if (checkbox != null) {
                    bReturn &= WebElementUtils.clickElement(checkbox);
                    bReturn &= saveAssignment();
                } else {
                    log.debug("Could not select Employee " + employeeName + " from the list.");
                    bReturn = false;
                }
                if (!bReturn) {
                    WebElement cancelBtn = WebElementUtils.findElement(B2WScheduleAssignments.getCancelBtn());
                    WebElementUtils.clickElement(cancelBtn);
                    selectButtonOption("Yes");
                    waitForSchedulesPageNoBusy();
                }
            } else {
                log.debug("The search box could not be found on the Fill Need dialog.");
            }
        } else {
            log.debug("The Fill Need Dialog could not be found.");
        }
        return bReturn;
    }
    private List<WebElement> getAllOrdersFromPanel() {
        return WebElementUtils.findElements(B2WScheduleAssignments.getOrderFromPanel());
    }
    private WebElement getOrderForResource(String sResourceName) {
        return WebElementUtils.getElementWithContainsChildElementText(getAllOrdersFromPanel(), By.cssSelector("div.ng-binding"), sResourceName);
    }
    private boolean selectOrder(WebElement eOrder) {
        boolean bReturn;

        if (!eOrder.getAttribute("class").contains("AssignmentBlock--selected")) {
            bReturn = WebElementUtils.clickElement(eOrder);
            waitForSchedulesPageNoBusy();
        } else {
            return true;
        }
        return bReturn;
    }
    private boolean setFillWith(String sValue) {
        boolean bReturn = false;
        WebElement item = WebElementUtils.findElement(B2WScheduleAssignments.getFillWith());
        if (item != null) {
            bReturn = WebElementUtils.clickElement(item);
            bReturn &= selectItemFromFDD(sValue);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Could not find 'Fill With' field on the page.");
        }
        return bReturn;
    }
    private boolean isAssignmentComplete(B2WAssignment assignment) {
        boolean bReturn = false;
        WebElement eAssignment = getAssignment(assignment);
        List<WebElement> iconsList = WebElementUtils.getChildElements(WebElementUtils.getParentElement(eAssignment), B2WScheduleAssignments.getAssignmentIcon());
        for (WebElement item : iconsList) {
            if (item.isDisplayed()) {
                if (item.getAttribute("class").contains("complete-icon")) {
                    return true;
                }
            }
        }
        return bReturn;
    }

    // === Support Methods
    public boolean waitForSchedulesPageNoBusy() {
        return waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
    }
}
