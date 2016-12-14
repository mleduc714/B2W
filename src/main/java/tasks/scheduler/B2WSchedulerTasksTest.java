package tasks.scheduler;

import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.jfree.data.time.DateRange;
import org.jfree.util.Log;
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
    public final String MENU_NEED = "Assignment/Need";
    public final String MENU_CREWASSIGNMENT = "Crew Assignment";
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
        String sValue = StringUtils.getStringFromDateByPattern(scheduleView.getStartDate(), "M/d/yyyy");
        WebElement inputCalendarStartDate = WebElementUtils.findElement(B2WScheduleAssignments.getCalendarStartDate());
        if (inputCalendarStartDate != null) {
            inputCalendarStartDate.clear();
            bReturn = WebElementUtils.sendKeys(inputCalendarStartDate, sValue + Keys.RETURN);
            TaskUtils.sleep(100);
            waitForSchedulesPageNoBusy();
            Date d1 = StringUtils.getDateFromStringWithPattern(sValue, "M/d/yyyy");
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
        bReturn = logCompare(true, true, "====== Start Assignment Creation for " + B2WAssignment.getResourceName());
        int initialCount = getAssignmentsCount(B2WAssignment.getResourceName(), B2WAssignment.getLocationName(), B2WAssignmentType.EMPLOYEE_TYPE);
        bReturn &= logCompare(true, createNewEmployeeAssignment(), "Open Create Employee Assignment Dialog");
        bReturn &= logCompare(true, setJobSite(B2WAssignment.getLocationName()), "Set JobSite/Place");
        bReturn &= logCompare(true, setEmployees(B2WAssignment.getResourceName()), "Set Employee");
        bReturn &= logCompare(true, setRequestedBy(B2WAssignment.getRequestedBy()), "Set Requested By");
        bReturn &= logCompare(true, setAssignmentNotes(B2WAssignment.getNotes()), "Set Notes");
        bReturn &= logCompare(true, setDuration(B2WAssignment.getDuration()), "Set Duration");
        bReturn &= logCompare(true, setStartTime(B2WAssignment.getStartTime()), "Set Start Time");
        bReturn &= logCompare(true, saveEmployeeAssignment(), "Save New Employee Assignment");

        int actualCount = getAssignmentsCount(B2WAssignment.getResourceName(), B2WAssignment.getLocationName(), B2WAssignmentType.EMPLOYEE_TYPE);
        bReturn &= logCompare(true, actualCount == initialCount + 1, "Verification that Employee Assignment has been created.");
        WebElement result = getEmployeeAssignment(assignment);
        bReturn &= logCompare(true,  result != null, "Verification that specific Employee Assignment has been created.");
        bReturn &= logCompare(true, true, "====== Complete Assignment Creation for " + B2WAssignment.getResourceName());
        return bReturn;
    }

    // === Private Methods
    private boolean createNewEmployeeAssignment() {
        return openCreateDialog(MENU_ASSIGNMENT);
    }
    private boolean createNewEquipmentAssignment() {
        return openCreateDialog(MENU_ASSIGNMENT);
    }
    private boolean createNewEmployeeNeed() {
        return openCreateDialog(MENU_NEED);
    }
    private boolean createNewEquipmentNeed() {
        return openCreateDialog(MENU_NEED);
    }
    private boolean createNewCrewAssignment() {
        return openCreateDialog(MENU_CREWASSIGNMENT);
    }
    private boolean createNewCrewNeed() {
        return openCreateDialog(CREWNEED);
    }
    private boolean createNewMoveAssignment() {
        return openCreateDialog(MOVEASSIGNMENT);
    }
    private boolean createNewMoveOrder() {
        return openCreateDialog(MOVEORDER);
    }
    private boolean createNewEvent(String sItem) {
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
    private boolean createNewEmployeeEvent() {
        boolean bResult;
        //bResult = openCreateDialog(EVENT);
        bResult = createNewEvent("Employee");
        return bResult;
    }
    private boolean createNewEquipmentEvent() {
        boolean bResult;
        //bResult = openCreateDialog(EVENT);
        bResult = createNewEvent("Equipment");
        return bResult;
    }
    private boolean createNewLocationEvent() {
        boolean bResult;
        //bResult = openCreateDialog(EVENT);
        bResult = createNewEvent("Location");
        return bResult;
    }

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
    private boolean openCreateDialog(String sItem) {
        boolean bReturn;
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getCreationSection(), 1);
        WebElement creationSection = WebElementUtils.findElement(B2WScheduleAssignments.getCreationSection());
        WebElement dropDownMenu = WebElementUtils.getChildElement(creationSection, B2WScheduleAssignments.getKendoDropDown());
        bReturn = clickAndSelectValueFromKendoFDD(dropDownMenu, sItem);
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
    private List<WebElement> getAssignmentsByLocationAndResourceName(String sResourceName, String sLocationName) {
        List<WebElement> lReturn = new ArrayList<WebElement>();
        List<WebElement> list = getAssignmentsByLocation(sLocationName);
        for (WebElement eTmp : list) {
            WebElement parent = WebElementUtils.getParentUntilTagName(eTmp, "td");
            WebElement eResourceName = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceName());
            if (eResourceName.getAttribute("title").equals(sResourceName)) {
                lReturn.add(eTmp);
            }
        }
        return lReturn;
    }
    private List<WebElement> getAssignmentsByLocationAndResourceName(String sResourceName, String sLocationName, String sType) {
        List<WebElement> lReturn = new ArrayList<WebElement>();
        List<WebElement> list = getAssignmentsByLocation(sLocationName);
        for (WebElement eTmp : list) {
            WebElement parent = WebElementUtils.getParentUntilTagName(eTmp, "td");
            WebElement eResourceName = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceName());
            String type = WebElementUtils.getParentElement(eTmp).getAttribute("class");
            if (eResourceName.getAttribute("title").equals(sResourceName) && type.contains(sType)) {
                lReturn.add(eTmp);
            }
        }
        return lReturn;
    }
    private int getAssignmentsCount(String sResourceName, String sLocationName) {
        return getAssignmentsByLocationAndResourceName(sResourceName, sLocationName).size();
    }
    private int getAssignmentsCount(String sResourceName, String sLocationName, String sType) {
        return getAssignmentsByLocationAndResourceName(sResourceName, sLocationName, sType).size();
    }
    private Date getAssignmentStartDate(WebElement item) {
        if (item != null) {
            try {
                WebElement parent = WebElementUtils.getParentElement(item);
                return StringUtils.getDateFromStringWithPattern(parent.getAttribute("b2w-assignment-start"), "yyyy-M-d");
            } catch (Exception ex) {
                log.debug("Could not get Parent element for: " + item.toString());
                return null;
            }
        } else {
            log.debug("Item is NULL.");
            return null;
        }
    }
    private Date getAssignmentEndDate(WebElement item) {
        if (item != null) {
            try {
                WebElement parent = WebElementUtils.getParentElement(item);
                return StringUtils.getDateFromStringWithPattern(parent.getAttribute("b2w-assignment-end"), "yyyy-M-d");
            } catch (Exception ex) {
                log.debug("Could not get Parent element for: " + item.toString());
                return null;
            }
        } else {
            log.debug("Item is NULL.");
            return null;
        }
    }
    private WebElement getResourceLine(String sResourceName) {
        return WebElementUtils.findElement(B2WScheduleAssignments.getSpecificResourceName(sResourceName));
    }
    private WebElement getAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration, String sType) {
        WebElement eReturn = null;

        sStartDate = sStartDate + " " + sStartTime;
        Date startDate = StringUtils.getDateFromStringWithPattern(sStartDate, "M/d/yyyy h:mm a");
        Date endDate;
        if (sDuration.toLowerCase().contains(":") ) {
            sEndDate = sEndDate + " " + sDuration;
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
        } else {
            sEndDate = sEndDate + " " + sStartTime;
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
            endDate = DateUtils.addHours(endDate, StringUtils.getHoursFromDuration(sDuration));
            endDate = DateUtils.addMinutes(endDate, StringUtils.getMinutesFromDuration(sDuration));
        }

        List<WebElement> list = getAssignmentsByLocationAndResourceName(sResourceName, sLocationName);
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
            if (assignmentStartDate.equals(startDate) && assignmentEndDate.equals(endDate) && type.contains(sType)) {
                eReturn = eTmp;
                flag = true;
            }
        }
        return eReturn;
    }
    private List<WebElement> getAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration, String sType) {
        List<WebElement> eReturn = new ArrayList<WebElement>();

        sStartDate = sStartDate + " " + sStartTime;
        Date startDate = StringUtils.getDateFromStringWithPattern(sStartDate, "M/d/yyyy h:mm a");
        Date endDate;
        if (sDuration.toLowerCase().contains(":") ) {
            sEndDate = sEndDate + " " + sDuration;
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
        } else {
            sEndDate = sEndDate + " " + sStartTime;
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
            endDate = DateUtils.addHours(endDate, StringUtils.getHoursFromDuration(sDuration));
            endDate = DateUtils.addMinutes(endDate, StringUtils.getMinutesFromDuration(sDuration));
        }

        List<WebElement> list = getAssignmentsByLocationAndResourceName(sResourceName, sLocationName);
        Iterator<WebElement> iterator = list.iterator();

        for (WebElement eTmp : list) {
            WebElement parent = WebElementUtils.getParentElement(eTmp);
            String b2wAssignmentStart = parent.getAttribute("b2w-assignment-start").replace('T', ' ');
            String b2wAssignmentEnd = parent.getAttribute("b2w-assignment-end").replace('T', ' ');
            Date assignmentStartDate = StringUtils.getDateFromStringWithPattern(b2wAssignmentStart, "yyyy-M-d HH:mm");
            Date assignmentEndDate = StringUtils.getDateFromStringWithPattern(b2wAssignmentEnd, "yyyy-M-d HH:mm");
            String type = parent.getAttribute("class");
            if (assignmentStartDate.equals(startDate) && assignmentEndDate.equals(endDate) && type.contains(sType)) {
                eReturn.add(eTmp);
            }
        }
        return eReturn;
    }
    private WebElement getMoveOrder(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.MOVE_ORDER_TYPE);
    }
    private WebElement getMoveAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.MOVE_ASSIGNMENT_TYPE);
    }
    private List<WebElement> getMoveAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.MOVE_ASSIGNMENT_TYPE);
    }
    private WebElement getEquipmentAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EQUIPMENT_TYPE);
    }
    private List<WebElement> getEquipmentAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EQUIPMENT_TYPE);
    }
    private WebElement getEquipmentNeed(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EQUIPMENT_NEED_TYPE);
    }
    private WebElement getEmployeeAssignment(B2WAssignment assignment) {
        return getAssignment(assignment.getResourceName(), assignment.getLocationName(), assignment.getStartDate(), assignment.getEndDate(),
                assignment.getStartTime(), assignment.getDuration(), B2WAssignmentType.EMPLOYEE_TYPE);
    }
    private List<WebElement> getEmployeeAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EMPLOYEE_TYPE);
    }
    private WebElement getEmployeeSubstitution(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.SUBSTITUTION_TYPE);
    }
    private WebElement getEmployeeSubstituted(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.SUBSTITUTED_TYPE);
    }
    private WebElement getEmployeeNeed(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EMPLOYEE_NEED_TYPE);
    }
    private WebElement getCrewAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.CREW_TYPE);
    }
    private List<WebElement> getCrewAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.CREW_TYPE);
    }
    private WebElement getCrewNeed(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.CREW_NEED_TYPE);
    }
    private WebElement getEmployeeEvent(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EMPLOYEE_EVENT_TYPE);
    }
    private List<WebElement> getEmployeeEvents(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EMPLOYEE_EVENT_TYPE);
    }
    private WebElement getEquipmentEvent(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EQUIPMENT_EVENT_TYPE);
    }
    private List<WebElement> getEquipmentEvents(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.EQUIPMENT_EVENT_TYPE);
    }
    private WebElement getLocationEvent(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.LOCATION_EVENT_TYPE);
    }
    private List<WebElement> getLocationEvents(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, B2WAssignmentType.LOCATION_EVENT_TYPE);
    }
    private List<WebElement> getAllConflictsFromPanel() {
        return WebElementUtils.findElements(B2WScheduleAssignments.getConflictFromPanel());
    }
    private WebElement getConflictForResource(String sResourceName) {
        return WebElementUtils.getElementWithContainsChildElementText(getAllConflictsFromPanel(), By.cssSelector("div.ng-binding"), sResourceName);
    }


    //-- Set Methods
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
    // Set Values on Create Assignment Dialog
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
    private boolean setEmployee(String sValue) {
        return setFields("Employee", sValue);
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
    private boolean setCrew(String sValue) {
        return setFields("Crew", sValue);
    }
    private boolean setCrewNeed(String sValue) {
        return setFields("Crew Need", sValue);
    }
    private boolean setPickupLocation(String sPickupType, String sPickupJobSiteName) {
        boolean bResult;
        WebElement dropDown = WebElementUtils.getKendoFDDElementByLabel("Pickup Location");
        bResult = clickAndSelectValueFromKendoFDD(dropDown, sPickupType);

        List<WebElement> inputList = WebElementUtils.findElements(B2WScheduleAssignments.getFieldLabel());
        WebElement el = WebElementUtils.getElementWithMatchingText(inputList, "Pickup Location", false);
        WebElement parent = WebElementUtils.getParentElement(el);
        //WebElement elControlPanel = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getControlPanel());
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
    private boolean clickSelectCrew() {
        boolean bResult;
        bResult = clickSelectCrewBtn();
        return bResult;
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
    private boolean setEventEmployee(String sValue) {
        return setFields("Employee", sValue);
    }
    private boolean setEventEquipment(String sEquipmentName) {
        return setFields("Equipment", sEquipmentName);
    }
    private boolean setEventLocation(String sJobSiteName) {
        return setFields("Location", sJobSiteName);
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

    //-- Save Methods
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
            bResult &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleProductPageIcon()) != null;
        } else {
            log.debug("Add to Schedule button could not be found.");
        }
        return bResult;
    }
    private boolean saveEmployeeAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulesPageNoBusy();
        bResult &= WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getGrid()) != null;
        return bResult;
    }
    private boolean saveEquipmentAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulesPageNoBusy();
        return bResult;
    }
    private boolean saveEmployeeNeed() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulesPageNoBusy();
        return bResult;
    }
    private boolean saveEquipmentNeed() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulesPageNoBusy();
        return bResult;
    }
    private boolean saveCrewAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulesPageNoBusy();
        return bResult;
    }
    private boolean saveCrewNeed() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulesPageNoBusy();
        return bResult;
    }
    private boolean saveMoveAssignment() {
        boolean bResult;
        WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getSaveAssignmentBtn());
        WebElementUtils.moveVirtualMouseOverElement(el);
        bResult = WebElementUtils.waitForElementClickable(el);
        if (el != null && bResult) {
            bResult = WebElementUtils.clickElement(el);
            WebElementUtils.waitForElementInvisible(el);
            waitForSchedulesPageNoBusy();
            WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
            bResult &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleProductPageIcon()) != null;
        } else {
            log.debug("Create Assignment Button could not be found.");
        }
        return bResult;
    }
    private boolean saveMoveOrder() {
        return saveMoveAssignment();
    }
    private boolean saveEvent() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulesPageNoBusy();
        return bResult;
    }

    // Click Methods
    public boolean clickSelectCrewBtn() {
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
    public boolean clickEditLocation() {
        boolean bReturn = false;
        WebElement eLink = WebElementUtils.findElement(B2WScheduleAssignments.getEditLocationLink());
        if (eLink != null) {
            bReturn = WebElementUtils.clickElement(eLink);
        } else {
            Log.debug("'Edit Location' link could not be found on the page.");
        }
        return bReturn;
    }
    public boolean clickEditCrew() {
        return clickSelectCrewBtn();
    }

    private boolean waitForSchedulesPageNoBusy() {
        return waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
    }
}
