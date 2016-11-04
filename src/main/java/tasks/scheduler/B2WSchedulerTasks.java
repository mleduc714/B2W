package tasks.scheduler;

import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.log4j.Logger;
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
import org.jfree.data.time.DateRange;

public class B2WSchedulerTasks extends B2WKendoTasks {

    public final String ASSIGNMENT = "Assignment/Need";
    public final String NEED = "Assignment/Need";
    public final String CREWASSIGNMENT = "Crew Assignment";
    public final String CREWNEED = "Crew Need";
    public final String MOVEORDER = "Move Order";
    public final String MOVEASSIGNMENT = "Move Assignment";
    public final String EVENT = "Event";

    private int daysSelectedCount = 0;

    Logger log = Logger.getLogger(B2WSchedulerTasks.class);

    // Property
    public int getDaysSelectedCount() {
        return daysSelectedCount;
    }
    public void setDaysSelectedCount(int daysSelectedCount) {
        this.daysSelectedCount = daysSelectedCount;
    }

    public boolean waitForSchedulePageNoBusy() {
        return waitForPageNotBusy();
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

                    //List<WebElement> items = panel.findElements(By.cssSelector("li"));
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

    //--Select Options from 'New' Menu
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
    public boolean setEmployee(String sValue) {
        return setFields("Employees", sValue);
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
    public boolean setPickupLocation(String sPickupType, List<String> sPickupDetails) {
        boolean bResult = false;
        //ToDo
        return bResult;
    }
    public boolean setPickupLocation(String sPickupType, String sPickupJobSiteName) {
        boolean bResult;
        WebElement dropDown = WebElementUtils.getKendoFDDElementByLabel("Pickup Location");
        bResult = clickAndSelectValueFromKendoFDD(dropDown, sPickupType);

        List<WebElement> inputList = WebElementUtils.findElements(B2WScheduleAssignments.getFieldLabel());
        WebElement el = WebElementUtils.getElementWithMatchingText(inputList, "Pickup Location", false);
        WebElement parent = WebElementUtils.getParentElement(el);
        WebElement elControlPanel = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getControlPanel());
        WebElement jobSite = WebElementUtils.getChildElement(elControlPanel, KendoUI.getKendoDropDown());
        if (jobSite != null) {
            bResult &= sendTextAndSelectValueFromKendoFDD(jobSite, sPickupJobSiteName);
        } else {
            bResult = false;
            log.debug("Job Site/Place field could not be found for Pickup Location.");
        }
        return bResult;
    }
    public boolean setDropoffLocation(String sDropoffType, List<String> sDropoffDetails) {
        boolean bResult = false;
        //ToDo
        return bResult;
    }
    public boolean setDropoffLocation(String sDropoffType, String sDropoffJobSiteName) {
        boolean bResult;
        WebElement dropDown = WebElementUtils.getKendoFDDElementByLabel("Drop-off Location");
        bResult = clickAndSelectValueFromKendoFDD(dropDown, sDropoffType);

        List<WebElement> inputList = WebElementUtils.findElements(B2WScheduleAssignments.getFieldLabel());
        WebElement el = WebElementUtils.getElementWithMatchingText(inputList, "Drop-off Location", false);
        WebElement parent = WebElementUtils.getParentElement(el);
        WebElement elControlPanel = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getControlPanel());
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
    public int getAssignmentsCount(String sResourceName, String sLocationName) {
        return getAssignments(sResourceName, sLocationName).size();
    }
    public List<WebElement> getAssignments(String sResourceName, String sLocationName) {
        List<WebElement> elResult = new ArrayList<WebElement>();
        List<WebElement> resourceList = getResourceListOnGrid();
        WebElement resourceElement = WebElementUtils.getElementWithWithMatchingAttribute(resourceList, "title", sResourceName);
        if (resourceElement != null) {
            WebElement parent = WebElementUtils.getParentUntilTagName(resourceElement, "tr");
            List<WebElement> fullAssignmentsListForResource = WebElementUtils.getChildElements(parent, B2WScheduleAssignments.getAssignments());
            elResult = WebElementUtils.getElementsWithWithMatchingAttribute(fullAssignmentsListForResource,
                    "title", sLocationName);

        } else {
            log.debug("WebElement could not be found with name " + sResourceName);
        }
        log.debug("Number of Assignments for " + sResourceName + " is " + elResult.size());
        return elResult;
    }
    public List<WebElement> getResourceListOnGrid() {
        return WebElementUtils.findElements(B2WScheduleAssignments.getResourceListOnGrig());
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
        return bResult;
    }
    public boolean saveEquipmentAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveEmployeeNeedAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveEquipmentNeedAssignment() {
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
    public boolean saveCrewNeedAssignment() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
    }
    public boolean saveMoveAssignment() {
        boolean bResult = false;
        WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getCreateAssignmentBtn());
        WebElementUtils.waitForElementClickable(el);
        if (el != null) {
            bResult = WebElementUtils.clickElement(el);
            waitForSchedulePageNoBusy();
            WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
            bResult &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleProductPageIcon()) != null;
        } else {
            log.debug("Create Assignment Button could not be found.");
        }

        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveMoveOrder() {
        boolean bResult = false;
        WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getCreateMoveOrderBtn());
        if (el != null) {
            bResult = WebElementUtils.clickElement(el);
            waitForSchedulePageNoBusy();
            WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
            bResult &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleProductPageIcon()) != null;
        } else {
            log.debug("Create Move Order Button could not be found.");
        }

        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveEvent() {
        boolean bResult;
        bResult = saveAssignment();
        waitForSchedulePageNoBusy();
        return bResult;
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

        DateRange dateRange = new DateRange(startDate, endDate);
        return dateRange;
    }
    public String correctDate(String sValue) {
        String sResult;
        String[] stringList = sValue.split("/");
        Integer iTmp = Integer.parseInt(stringList[1].toString());
        iTmp++;
        stringList[1] = String.valueOf(iTmp);
        sResult = stringList[0] + "/" + stringList[1] + "/" + stringList[2];
        return sResult;
    }
    public boolean isDateInRange(DateRange dateRange, String sDate) {
        Date date = StringUtils.getDateFromString(sDate);
        return dateRange.contains(date.getTime());
    }
    public boolean isValueSelected(List<WebElement> list, String sValue) {
        //ToDo Remove if could not fix it.
        boolean bReturn = false;
        String sTmp;
        Iterator<WebElement> iterator = list.iterator();
        while (iterator.hasNext() && !bReturn) {
            WebElement Item = iterator.next();
            if (WebElementUtils.getChildElements(Item, By.cssSelector("p")).size() > 0) {
                WebElement el = WebElementUtils.getChildElement(Item, By.cssSelector("p"));
                sTmp = el.getAttribute("title");
            } else {
                sTmp = Item.getText();
            }

            if (sTmp.equals(sValue)) {
                bReturn = true;
            }
        }
        return bReturn;
    }
}
