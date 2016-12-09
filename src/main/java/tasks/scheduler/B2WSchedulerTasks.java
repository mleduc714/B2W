package tasks.scheduler;

import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.StringUtils;
import tasks.util.TaskUtils;
import java.util.*;
import org.jfree.data.time.DateRange;

public class B2WSchedulerTasks extends B2WKendoTasks {

    public final String ASSIGNMENT = "Assignment/Need";
    public final String NEED = "Assignment/Need";
    public final String CREWASSIGNMENT = "Crew Assignment";
    public final String CREWNEED = "Crew Need";
    public final String MOVEORDER = "Move Order";
    public final String MOVEASSIGNMENT = "Move Assignment";
    public final String EVENT = "Event";
    public final String EQUIPMENT_TYPE = "equipment";
    public final String EQUIPMENT_NEED_TYPE = "equipment-need";
    public final String EMPLOYEE_TYPE = "employee";
    public final String EMPLOYEE_NEED_TYPE = "labortype-need";
    public final String MOVE_ASSIGNMENT_TYPE = "move-assignment";
    public final String MOVE_ORDER_TYPE = "move-order";
    public final String CREW_TYPE = "crew";
    public final String CREW_NEED_TYPE = "crew-need";
    public final String EMPLOYEE_EVENT_TYPE = "employee-event";
    public final String EQUIPMENT_EVENT_TYPE = "equipment-event";
    public final String LOCATION_EVENT_TYPE = "jobsite-event";
    public final String SUBSTITUTION_TYPE = "substitution";
    public final String SUBSTITUTED_TYPE = "substituted";

    private int daysSelectedCount = 0;

    private final Logger log = Logger.getLogger(B2WSchedulerTasks.class);

    // Property
    private int getDaysSelectedCount() {
        return daysSelectedCount;
    }
    private void setDaysSelectedCount(int daysSelectedCount) {
        this.daysSelectedCount = daysSelectedCount;
    }

    public boolean waitForSchedulePageNoBusy() {
        TaskUtils.sleep(100);
        return waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
    }

    //--Navigate and Select Menu section
    public boolean navigateToScheduleView(String sViewName, String sPanel) {
        boolean bReturn = false;

        if (!new TaskUtils().waitForProductPanel(sPanel)) {
            WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getScheduleProductPageIcon());
            if (el != null) {
                if (WebElementUtils.clickElement(el)) {
                    WebElement panel = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleViewNavigateMenu());
                    WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleViewNavigateMenu(), 1);

                    List<WebElement> items = WebElementUtils.getChildElements(panel, By.cssSelector("li"));
                    WebElement item = WebElementUtils.getElementWithMatchingText(items, sViewName, true);
                    if (item != null) {
                        item.click();

                        WebElementUtils.waitForElementInvisible(panel);
                        waitForSchedulePageNoBusy();

                        bReturn = new TaskUtils().waitForProductPanel(sPanel);
                        WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleCenterPanel(), 1);
                    }
                }
            }
        } else {
            bReturn = true;
        }
        return bReturn;
    }
    public boolean openCreateDialog(String sItem) {
        boolean bReturn;
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getCreationSection(), 1);
        WebElement creationSection = WebElementUtils.findElement(B2WScheduleAssignments.getCreationSection());
        WebElement dropDownMenu = WebElementUtils.getChildElement(creationSection, B2WScheduleAssignments.getKendoDropDown());
        bReturn = clickAndSelectValueFromKendoFDD(dropDownMenu, sItem);
        return bReturn;
    }
    public boolean openContextMenu(WebElement eAssignment) {
        boolean bReturn = false;
        if (eAssignment != null) {
            bReturn = WebElementUtils.clickElement(eAssignment);
            WebElementUtils.waitForElementClickable(eAssignment);
            waitForSchedulePageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getContextMenu()) != null;
        }
        return bReturn;
    }
    public boolean openConflictPanel() {
        boolean bReturn = false;
        WebElement eConflictBtn = WebElementUtils.findElement(B2WScheduleAssignments.getConflictButton());
        if (eConflictBtn != null) {
            bReturn = WebElementUtils.clickElement(eConflictBtn);
            waitForSchedulePageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getConflictsPanel(), WebElementUtils.LONG_TIME_OUT) != null;
        } else {
            log.debug("Conflict button could not be found on the page.");
        }
        return bReturn;
    }
    public boolean closeConflictPanel() {
        boolean bReturn = false;
        WebElement eConflictPanel = WebElementUtils.findElement(B2WScheduleAssignments.getConflictsPanel());
        WebElement eConflictBtn = WebElementUtils.findElement(B2WScheduleAssignments.getCheckedBtn());
        if (eConflictBtn != null && eConflictPanel != null) {
            bReturn = WebElementUtils.clickElement(eConflictBtn);
            waitForSchedulePageNoBusy();
            bReturn &= WebElementUtils.waitForElementInvisible(eConflictPanel);
        } else {
            log.debug("Conflict button could not be found on the page.");
        }
        return bReturn;
    }

    //-- Grouping Methods
    public boolean expand(String sValue) {
        boolean bReturn = false;
        return bReturn;
    }
    public boolean expandAll() {
        boolean bReturn = false;
        WebElement eToolBarPanel = WebElementUtils.findElement(B2WScheduleAssignments.getToolBarPanel());
        if (eToolBarPanel != null) {
            List<WebElement> list = WebElementUtils.getChildElements(eToolBarPanel, B2WScheduleAssignments.getExpandIcon());
            boolean flag = true;
            for (WebElement el : list) {
                if (el.isDisplayed()) {
                    flag &= WebElementUtils.clickElement(el);
                    waitForSchedulePageNoBusy();
                    flag &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
                }
            }
            bReturn = flag;
        } else {
            log.debug("ToolBar panel could not be found.");
        }
        return bReturn;
    }
    public boolean collapse(String sValue) {
        boolean bReturn = false;
        return bReturn;
    }
    public boolean collapseAll() {
        boolean bReturn = false;
        return bReturn;
    }

    //-- Select Options from 'New' Menu
    public boolean createNewEmployeeAssignment() {
        return openCreateDialog(ASSIGNMENT);
    }
    public boolean createNewEquipmentAssignment() {
        return openCreateDialog(ASSIGNMENT);
    }
    public boolean createNewEmployeeNeed() {
        return openCreateDialog(NEED);
    }
    public boolean createNewEquipmentNeed() {
        return openCreateDialog(NEED);
    }
    public boolean createNewCrewAssignment() {
        return openCreateDialog(CREWASSIGNMENT);
    }
    public boolean createNewCrewNeed() {
        return openCreateDialog(CREWNEED);
    }
    public boolean createNewMoveAssignment() {
        return openCreateDialog(MOVEASSIGNMENT);
    }
    public boolean createNewMoveOrder() {
        return openCreateDialog(MOVEORDER);
    }
    public boolean createNewEvent(String sItem) {
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
    public boolean createNewEmployeeEvent() {
        boolean bResult;
        //bResult = openCreateDialog(EVENT);
        bResult = createNewEvent("Employee");
        return bResult;
    }
    public boolean createNewEquipmentEvent() {
        boolean bResult;
        //bResult = openCreateDialog(EVENT);
        bResult = createNewEvent("Equipment");
        return bResult;
    }
    public boolean createNewLocationEvent() {
        boolean bResult;
        //bResult = openCreateDialog(EVENT);
        bResult = createNewEvent("Location");
        return bResult;
    }
    public boolean clearSearchValue() {
        boolean bReturn = false;
        WebElement eSearchBox = WebElementUtils.findElement(B2WScheduleAssignments.getSearchBox());
        if (eSearchBox != null) {
            eSearchBox.clear();
            TaskUtils.sleep(1000);
            waitForSchedulePageNoBusy();
            bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
        } else {
            log.debug("Search box could not be found on the page.");
        }
        return bReturn;
    }

    //-- Select Options from Context Menu
    public boolean selectOptionFromContextMenu(String sMenuOption) {
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
                    waitForSchedulePageNoBusy();
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
    public boolean selectButtonOption(String sButtonName) {
        boolean bReturn = false;
        WebElement button = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getDeleteOptionBtn(sButtonName));
        if (button != null) {
            bReturn = WebElementUtils.clickElement(button);
            waitForSchedulePageNoBusy();
        } else {
            log.debug("Button with text " + sButtonName + " could not be found on the page.");
        }
        return bReturn;
    }
    public boolean deleteEntireAssignment() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Assignment");
        bReturn &= selectButtonOption("Delete Entire Assignment");
        return bReturn;
    }
    public boolean deleteSelectedDatesAssignment() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Assignment");
        bReturn &= selectButtonOption("Delete Selected Dates");
        return bReturn;

    }
    public boolean deleteAssignment() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Assignment");
        bReturn &= selectButtonOption("Yes");
        return bReturn;
    }
    public boolean deleteSubstitution() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Substitution");
        bReturn &= selectButtonOption("Yes");
        return bReturn;
    }
    public boolean deleteNeed() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Need");
        bReturn &= selectButtonOption("Yes");
        return bReturn;
    }
    public boolean deleteMoveAssignment() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Move Assignment");
        bReturn &= selectButtonOption("Yes");
        return bReturn;
    }
    public boolean deleteMoveOrder() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Move Order");
        bReturn &= selectButtonOption("Yes");
        return bReturn;
    }
    public boolean deleteEvent() {
        boolean bReturn;
        bReturn = selectOptionFromContextMenu("Delete Event");
        bReturn &= selectButtonOption("Yes");
        return bReturn;
    }
    public boolean editAssignment() {
        return selectOptionFromContextMenu("Edit Assignment");
    }
    public boolean editNeed() {
        return selectOptionFromContextMenu("Edit Need");
    }
    public boolean editMoveAssignment() {
        return selectOptionFromContextMenu("Edit Move Assignment");
    }
    public boolean editMoveOrder() {
        return selectOptionFromContextMenu("Edit Move Order");
    }
    public boolean editEvent() {
        return selectOptionFromContextMenu("Edit Event");
    }
    public boolean editSubstitution() {
        return selectOptionFromContextMenu("Edit Substitution");
    }
    public boolean createSubstitution() {
        return selectOptionFromContextMenu("Create Substitution");
    }
    public boolean copyAssignment() {
        return selectOptionFromContextMenu("Copy Assignment");
    }
    public boolean copyMoveAssignment() {
        return selectOptionFromContextMenu("Copy Move Assignment");
    }
    public boolean copyEvent() {
        return selectOptionFromContextMenu("Copy Event");
    }

    //-- Set Methods
    // Method to set value to FDD fields
    public boolean setFields(String sFieldName, String sValue) {
        boolean bReturn = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);

        if (assignmentWindow != null) {
            WebElement employeeAssignment = WebElementUtils.getKendoFDDElementByLabel(sFieldName);
            bReturn = sendTextAndSelectValueFromKendoFDD(employeeAssignment, sValue);
            waitForSchedulePageNoBusy();
        } else {
            log.debug("Create Assignment Window could not be found");
        }
        return bReturn;
    }
    public void clearFields(String sFieldName) {
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);

        if (assignmentWindow != null) {
            WebElement employeeAssignment = WebElementUtils.getKendoFDDElementByLabel(sFieldName);
            employeeAssignment.clear();
            waitForSchedulePageNoBusy();
        } else {
            log.debug("Create Assignment Window could not be found");
        }
    }
    // Set Values on Create Assignment Dialog
    public boolean setJobSite(String sValue) {
        return setFields("Job Site/Place", sValue);
    }
    public boolean setRequestedBy(String sValue) { return setFields("Requested By", sValue); }
    public boolean setNotes(String sValue) {
        boolean bResult = false;
        WebElement notesField = WebElementUtils.findElement(B2WScheduleAssignments.getNotesField());
        if (notesField != null) {
            bResult = WebElementUtils.sendKeys(notesField, sValue);
        } else {
            log.debug("Element 'Requested By' could not be found on the page." );
        }
        return bResult;
    }
    public boolean setEmployees(String sValue) {
        return setFields("Employees", sValue);
    }
    public boolean setEmployee(String sValue) {
        return setFields("Employee", sValue);
    }
    public boolean setEmployeeNeed(String sValue) {
        return setFields("Employee Needs", sValue);
    }
    public boolean setEquipment(String sValue) {
        return setFields("Equipment", sValue);
    }
    public boolean setEquipmentNeed(String sValue) {
        return setFields("Equipment Needs", sValue);
    }
    public boolean setCrew(String sValue) {
        return setFields("Crew", sValue);
    }
    public boolean setCrewNeed(String sValue) {
        return setFields("Crew Need", sValue);
    }
    public boolean setPickupLocation(String sPickupType, String sPickupJobSiteName) {
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
    public boolean setPickupDate(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Pickup Date");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    public boolean setPickupAfter(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Pickup After");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    public boolean setPickupTime(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Pickup Time");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    public boolean setDropoffDate(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Drop-off Date");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    public boolean setDropoffBefore(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Drop-off Before");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    public boolean setDropoffTime(String sValue) {
        boolean bReturn = false;
        WebElement element = WebElementUtils.getKendoFDDElementByLabel("Drop-off Time");
        if (element != null ) {
            element.clear();
            bReturn = WebElementUtils.sendKeys(element, sValue);
        }
        return bReturn;
    }
    public boolean setDropoffLocation(String sDropoffType, String sDropoffJobSiteName) {
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
    public boolean clickSelectCrew() {
        boolean bResult;
        bResult = clickSelectCrewBtn();
        return bResult;
    }
    public boolean setEventType(String sTypeName) {
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
    public boolean setEventEmployee(String sValue) {
        return setFields("Employee", sValue);
    }
    public boolean setEventEquipment(String sEquipmentName) {
        return setFields("Equipment", sEquipmentName);
    }
    public boolean setEventLocation(String sJobSiteName) {
        return setFields("Location", sJobSiteName);
    }
    public boolean setDuration(String sValue) { return setFields("Duration", sValue); }
    public boolean setStartTime(String sValue) {
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
            waitForSchedulePageNoBusy();
        } else {
            log.debug("Create Assignment Window could not be found");
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
            waitForSchedulePageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getGrid(), WebElementUtils.LONG_TIME_OUT) != null;
        } else {
            log.debug("Search box could not be found on the page.");
        }
        return bReturn;
    }

    // Update methods
    public boolean updateJobSite(String sValue) {
        return setJobSite(sValue);
    }
    public boolean updateEmployees(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEmployees(sValue);
    }
    public boolean updateEmployee(String sValue) {
        clearFields("Employee");
        return setEmployee(sValue);
    }
    public boolean updateEquipment(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEquipment(sValue);
    }
    public boolean updateEmployeeNeed(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEmployeeNeed(sValue);
    }
    public boolean updateEquipmentNeed(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setEquipmentNeed(sValue);
    }
    public boolean updateCrew(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setCrew(sValue);
    }
    public boolean updateTransportationCrew(String sValue) {
        clearFields("Crew");
        return setCrew(sValue);
    }
    public boolean updateCrewNeed(String sValue) {
        List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getDeleteEmployeeBtn());
        for (WebElement item : list) {
            WebElementUtils.clickElement(item);
        }
        return setCrewNeed(sValue);
    }
    public boolean updateRequestedBy(String sValue) {
        clearFields("Requested By");
        return setRequestedBy(sValue);
    }
    public boolean updateNotes(String sValue) {
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
    public boolean updateEventEmployee(String sValue) {
        clearFields("Employee");
        return setEventEmployee(sValue);
    }
    public boolean updateEventEquipment(String sValue) {
        clearFields("Equipment");
        return setEventEquipment(sValue);
    }
    public boolean updateEventLocation(String sValue) {
        clearFields("Location");
        return setEventLocation(sValue);
    }

    // Methods for Calendar on Schedule View
    public boolean setCalendarDateRange(String sValue) {
        boolean bReturn = false;
        WebElement activeDateRange = WebElementUtils.findElement(B2WScheduleAssignments.getCalendarActiveDateRange());
        if (activeDateRange != null) {
            if (!activeDateRange.getText().equals(sValue)) {
                WebElement parent = WebElementUtils.getParentElement(activeDateRange);
                List<WebElement> dateRangeList = WebElementUtils.getChildElements(parent, By.cssSelector("a"));
                Iterator<WebElement> iterator = dateRangeList.iterator();
                while (iterator.hasNext() && !bReturn) {
                    WebElement item = iterator.next();
                    if (item.getText().equals(sValue)) {
                        bReturn = WebElementUtils.clickElement(item);
                        TaskUtils.sleep(100);
                        waitForSchedulePageNoBusy();
                        bReturn &= WebElementUtils.findElement(B2WScheduleAssignments.getCalendarActiveDateRange()).getText().equals(sValue);
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
    public boolean setCalendarStartDate(String sValue) {
        boolean bReturn = false;
        WebElement inputCalendarStartDate = WebElementUtils.findElement(B2WScheduleAssignments.getCalendarStartDate());
        if (inputCalendarStartDate != null) {
            inputCalendarStartDate.clear();
            bReturn = WebElementUtils.sendKeys(inputCalendarStartDate, sValue + Keys.RETURN);
            TaskUtils.sleep(100);
            waitForSchedulePageNoBusy();
            Date d1 = StringUtils.getDateFromStringWithPattern(sValue, "M/d/yyyy");
            DateRange dateRange = getSelectedDates();
            //bReturn &= calendarStartDateValue.getText().contains(sValue);
            bReturn &= d1.equals(dateRange.getLowerDate());
        } else {
            log.debug("Calendar startDate field could not be found on the Schedule View page.");
        }
        return bReturn;
    }

    //-- Get Methods
    // Methods for Assignments
    public List<WebElement> getAllAssignments() {
        return WebElementUtils.findElements(B2WScheduleAssignments.getAssignment());
    }
    public List<WebElement> getAssignmentsByLocation(String sLocationName) {
        return WebElementUtils.getElementsWithMatchingAttribute(getAllAssignments(), "title", sLocationName);
    }
    public List<WebElement> getAssignmentsByLocationAndResourceName(String sResourceName, String sLocationName) {
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
    public List<WebElement> getAssignmentsByLocationAndResourceName(String sResourceName, String sLocationName, String sType) {
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
    public int getAssignmentsCount(String sResourceName, String sLocationName) {
        return getAssignmentsByLocationAndResourceName(sResourceName, sLocationName).size();
    }
    public int getAssignmentsCount(String sResourceName, String sLocationName, String sType) {
        return getAssignmentsByLocationAndResourceName(sResourceName, sLocationName, sType).size();
    }
    public Date getAssignmentStartDate(WebElement item) {
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
    public Date getAssignmentEndDate(WebElement item) {
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
    public WebElement getResourceLine(String sResourceName) {
        return WebElementUtils.findElement(B2WScheduleAssignments.getSpecificResourceName(sResourceName));
    }
    public WebElement getAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration, String sType) {
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
    public List<WebElement> getAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration, String sType) {
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
    public WebElement getMoveOrder(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, MOVE_ORDER_TYPE);
    }
    public WebElement getMoveAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, MOVE_ASSIGNMENT_TYPE);
    }
    public List<WebElement> getMoveAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, MOVE_ASSIGNMENT_TYPE);
    }
    public WebElement getEquipmentAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EQUIPMENT_TYPE);
    }
    public List<WebElement> getEquipmentAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EQUIPMENT_TYPE);
    }
    public WebElement getEquipmentNeed(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EQUIPMENT_NEED_TYPE);
    }
    public WebElement getEmployeeAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EMPLOYEE_TYPE);
    }
    public List<WebElement> getEmployeeAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EMPLOYEE_TYPE);
    }
    public WebElement getEmployeeSubstitution(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, SUBSTITUTION_TYPE);
    }
    public WebElement getEmployeeSubstituted(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, SUBSTITUTED_TYPE);
    }
    public WebElement getEmployeeNeed(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EMPLOYEE_NEED_TYPE);
    }
    public WebElement getCrewAssignment(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, CREW_TYPE);
    }
    public List<WebElement> getCrewAssignments(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, CREW_TYPE);
    }
    public WebElement getCrewNeed(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, CREW_NEED_TYPE);
    }
    public WebElement getEmployeeEvent(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EMPLOYEE_EVENT_TYPE);
    }
    public List<WebElement> getEmployeeEvents(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EMPLOYEE_EVENT_TYPE);
    }
    public WebElement getEquipmentEvent(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EQUIPMENT_EVENT_TYPE);
    }
    public List<WebElement> getEquipmentEvents(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, EQUIPMENT_EVENT_TYPE);
    }
    public WebElement getLocationEvent(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignment(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, LOCATION_EVENT_TYPE);
    }
    public List<WebElement> getLocationEvents(String sResourceName, String sLocationName, String sStartDate, String sEndDate, String sStartTime, String sDuration) {
        return getAssignments(sResourceName, sLocationName, sStartDate, sEndDate, sStartTime, sDuration, LOCATION_EVENT_TYPE);
    }
    public List<WebElement> getAllConflictsFromPanel() {
        return WebElementUtils.findElements(B2WScheduleAssignments.getConflictFromPanel());
    }
    public WebElement getConflictForResource(String sResourceName) {
        return WebElementUtils.getElementWithContainsChildElementText(getAllConflictsFromPanel(), By.cssSelector("div.ng-binding"), sResourceName);
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

    //-- Save Methods
    public boolean saveAssignment() {
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
            waitForSchedulePageNoBusy();
            WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
            bResult &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleProductPageIcon()) != null;
        } else {
            log.debug("Add to Schedule button could not be found.");
        }
        return bResult;
    }
    public boolean saveEmployeeAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        bResult &= WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getGrid()) != null;
        return bResult;
    }
    public boolean saveEquipmentAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveEmployeeNeed() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveEquipmentNeed() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveCrewAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveCrewNeed() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveMoveAssignment() {
        boolean bResult;
        WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getSaveAssignmentBtn());
        WebElementUtils.moveVirtualMouseOverElement(el);
        bResult = WebElementUtils.waitForElementClickable(el);
        if (el != null && bResult) {
            bResult = WebElementUtils.clickElement(el);
            WebElementUtils.waitForElementInvisible(el);
            waitForSchedulePageNoBusy();
            WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
            bResult &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleProductPageIcon()) != null;
        } else {
            log.debug("Create Assignment Button could not be found.");
        }
        return bResult;
    }
    public boolean saveMoveOrder() {
        return saveMoveAssignment();
    }
    public boolean saveEvent() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }

    //Move methods
    public boolean moveAssignmentToDateRangeEnd(WebElement item) {
        boolean bReturn = false;

        WebElement parent = WebElementUtils.getParentUntilTagName(item, "tr");
        List<WebElement> list = WebElementUtils.getChildElements(parent, B2WScheduleAssignments.getPlaceholders());
        if (list.size() > 0) {
            WebElement container = list.get(list.size() - 1);
            new Actions(BrowserUtils.getDriver()).clickAndHold(item).moveToElement(container).release().perform();
            waitForSchedulePageNoBusy();
            bReturn = true;
        } else {
            log.debug("Could not find placeholders for Resource");
        }
        return bReturn;
    }
    public boolean moveAssignmentToDate(WebElement item, Date date) {
        boolean bReturn = false;
        int iDateOffset = getPositionInDateRange(date);
        WebElement parent = WebElementUtils.getParentUntilTagName(item, "tr");
        if (parent != null) {
            List<WebElement> list = WebElementUtils.getChildElements(parent, B2WScheduleAssignments.getPlaceholders());
            if (list.size() > 0 && list.size() >= iDateOffset) {
                WebElement container = list.get(iDateOffset);
                try {
                    WebElementUtils.moveVirtualMouseOverElement(item);
                    new Actions(BrowserUtils.getDriver()).clickAndHold(item).moveToElement(container).release().perform();
                    waitForSchedulePageNoBusy();
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
    public boolean moveAssignmentToResourceAndDate(WebElement item, String sResourceName, Date date) {
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
                    waitForSchedulePageNoBusy();
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

    //Resize methods
    public boolean resizeAssignmentRightToDate(WebElement eAssignment, Date date) {
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
    public boolean resizeAssignmentLeftToDate(WebElement eAssignment, Date date) {
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
    //-- Support Functions
    public DateRange getSelectedDates() {
        Date startDate = null;
        Date endDate = null;
        setDaysSelectedCount(0);

        List<WebElement> listDates = WebElementUtils.findElements(B2WScheduleAssignments.getSelectedDatesOnCalendar());

        for (WebElement item : listDates) {
            WebElement el = WebElementUtils.getChildElement(item, By.cssSelector("a.k-link"));
            if (el != null) {
                String dataValue = el.getAttribute("data-value");
                dataValue = correctDate(dataValue);
                Date tmpDate = StringUtils.getDateFromString(dataValue);
                setDaysSelectedCount(getDaysSelectedCount() + 1);
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
    public String correctDate(String sValue) {
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
    public int getPositionInDateRange(Date end) {
        DateRange selectedDates = getSelectedDates();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(selectedDates.getLowerDate());
        int i = 0;
        while (!calendar.getTime().equals(end)) {
            i++;
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return i;
    }
    public boolean conflictIconIsDisplayed(String sResourceName, String sAssignmentType) {
        boolean bReturn = false;
        WebElement eResourceLine = getResourceLine(sResourceName);
        if (eResourceLine != null) {
            WebElement parent = WebElementUtils.getParentElement(eResourceLine);
            WebElement eResourceWarningIcon = null;
            if (sAssignmentType.equals(EMPLOYEE_TYPE) || sAssignmentType.equals(EQUIPMENT_TYPE) || sAssignmentType.equals(MOVE_ASSIGNMENT_TYPE) ||
                    sAssignmentType.equals(EMPLOYEE_EVENT_TYPE) || sAssignmentType.equals(EQUIPMENT_EVENT_TYPE)) {
                eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceWarningIcon_i152());
            } else if (sAssignmentType.equals(CREW_TYPE)) {
                eResourceWarningIcon = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getResourceWarningIcon_i228());
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
                log.debug("Warning Icon could not be found for Resource: " + sResourceName);
            }
        } else {
            log.debug("Could not find resource line for + " + sResourceName);
        }
        return bReturn;
    }
    public boolean selectConflict(WebElement eConflict) {
        boolean bReturn = WebElementUtils.clickElement(eConflict);
        waitForSchedulePageNoBusy();
        bReturn &= WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getFillNeedToolbar()) != null;
        WebElement firstItem = WebElementUtils.findElement(B2WScheduleAssignments.getFirstResourceNameInList());
        String actualValue = firstItem.getAttribute("title");
        String expectedValue = eConflict.getText();
        bReturn &= expectedValue.contains(actualValue);
        return bReturn;
    }
}
