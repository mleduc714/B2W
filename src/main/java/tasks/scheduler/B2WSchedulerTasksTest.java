package tasks.scheduler;

import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.jfree.data.time.DateRange;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.StringUtils;
import tasks.util.TaskUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.b2w.test.BaseAssert.logCompare;

public class B2WSchedulerTasksTest extends B2WKendoTasks {
    public final String MENU_ASSIGNMENT = "Assignment/Need";
    public final String CREWASSIGNMENT = "Crew Assignment";
    public final String CREWNEED = "Crew Need";
    public final String MOVEORDER = "Move Order";
    public final String MOVEASSIGNMENT = "Move Assignment";
    public final String EVENT = "Event";

    private Logger log = Logger.getLogger(B2WSchedulerTasksTest.class);

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
        boolean bReturn = false;
        WebElement eSearchBox = WebElementUtils.findElement(B2WScheduleAssignments.getSearchBox());
        if (eSearchBox != null) {
            eSearchBox.clear();
            bReturn = WebElementUtils.sendKeys(eSearchBox, sValue);
            //ToDo replace sleep to correct waiting
            TaskUtils.sleep(1000);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
        } else {
            log.debug("Search box could not be found on the page.");
        }
        return bReturn;
    }
    public boolean clearSearchValue() {
        boolean bReturn = false;
        WebElement eSearchBox = WebElementUtils.findElement(B2WScheduleAssignments.getSearchBox());
        if (eSearchBox != null) {
            eSearchBox.clear();
            //ToDo replace sleep to correct waiting
            TaskUtils.sleep(1000);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
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
        bReturn &= setGeneralFields(assignment);
        if (setGeneralFields(assignment)) {
            //ToDo: Issue
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

        bReturn &= setGeneralFields(assignment);
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
        bReturn &= setGeneralFields(assignment);
        if (setGeneralFields(assignment)) {
            //ToDo: Issue
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
            //ToDo: Issue
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

        bReturn = logCompare(true, selectNewMoveAssignment(), "Open Create Move Assignment Dialog");
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

    // ==== Private Methods ============================================================================================
    // === Menu for Creation
    private boolean openCreateDialog(String sItem) {
        boolean bReturn;
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getCreationSection(), 1);
        WebElement creationSection = WebElementUtils.findElement(B2WScheduleAssignments.getCreationSection());
        WebElement dropDownMenu = WebElementUtils.getChildElement(creationSection, B2WScheduleAssignments.getKendoDropDown());
        bReturn = clickAndSelectValueFromKendoFDD(dropDownMenu, sItem);
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
    public boolean selectNewMoveAssignment() {
        return openCreateDialog(MOVEASSIGNMENT);
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

    //-- Get Methods
    // Methods for Assignments
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
            WebElement eResourceName = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceName());
            String type = WebElementUtils.getParentElement(eTmp).getAttribute("class");
            if (eResourceName.getAttribute("title").equals(assignment.getResourceName()) && type.contains(assignment.getAssignmentType())) {
                lReturn.add(eTmp);
            }
        }
        return lReturn;
    }
    private int getAssignmentsCount(B2WAssignment assignment) {
        return getAssignmentsByLocationAndResourceName(assignment).size();
    }
    private WebElement getAssignment(B2WAssignment assignment) {
        WebElement eReturn = null;

        /*
        String sStartDate = assignment.getStartDate() + " " + assignment.getStartTime();
        Date startDate = StringUtils.getDateFromStringWithPattern(sStartDate, "M/d/yyyy h:mm a");
        Date endDate;
        if (assignment.getDuration().toLowerCase().contains(":") ) {
            String sEndDate = assignment.getEndDate() + " " + assignment.getDuration();
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
        } else {
            String sEndDate = assignment.getEndDate() + " " + assignment.getStartTime();
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
            endDate = DateUtils.addHours(endDate, StringUtils.getHoursFromDuration(assignment.getDuration()));
            endDate = DateUtils.addMinutes(endDate, StringUtils.getMinutesFromDuration(assignment.getDuration()));
        }
        */
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

    //-- Set Methods
    // === Assignments\Needs
    private boolean setGeneralFields(B2WAssignment assignment) {
        boolean bReturn;
        bReturn = logCompare(true, setJobSite(assignment.getLocationName()), "Set JobSite/Place: " + assignment.getLocationName());
        bReturn &= logCompare(true, setRequestedBy(assignment.getRequestedBy()), "Set Requested By: " + assignment.getRequestedBy());
        bReturn &= logCompare(true, setAssignmentNotes(assignment.getNotes()), "Set Notes: " + assignment.getNotes());
        bReturn &= logCompare(true, setDuration(assignment.getDuration()), "Set Duration: " + assignment.getDuration());
        bReturn &= logCompare(true, setStartTime(assignment.getStartTime()), "Set Start Time: " + assignment.getStartTime());
        return bReturn;
    }

    // Method to set value to FDD fields
    private boolean setFields(String sFieldName, String sValue) {
        boolean bReturn = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);

        if (assignmentWindow != null) {
            WebElement employeeAssignment = WebElementUtils.getKendoFDDElementByLabel(sFieldName);
            bReturn = sendTextAndSelectValueFromKendoFDD(employeeAssignment, sValue);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Create Assignment Window could not be found");
        }
        return bReturn;
    }

    // Set Values on Create Assignments\Needs Dialog
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

    // Set values on Create Crew Assignment\Need Dialog
    private boolean setCrew(String sValue) {
        return setFields("Crew", sValue);
    }
    private boolean setCrewNeed(String sValue) {
        return setFields("Crew Need", sValue);
    }

    // Set values on Move Assignment\Order Dialog
    private boolean setPickupDate(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Pickup Date");
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

    //-- Save Methods
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
        WebElement saveBtn = WebElementUtils.getChildElement(assignmentWindow, B2WScheduleAssignments.getAddToScheduleBtn());
        if (saveBtn != null) {
            bResult = WebElementUtils.clickElement(saveBtn);
            WebElementUtils.waitForElementInvisible(saveBtn);
            waitForSchedulesPageNoBusy();
            WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
            bResult &= WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getGrid()) != null;
        } else {
            log.debug("Add to Schedule button could not be found.");
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

    // Date methods
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

    // Support Methods
    private boolean waitForSchedulesPageNoBusy() {
        return waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
    }
}
