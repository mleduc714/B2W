package tasks.scheduler;

import appobjects.resources.B2WEquipment;
import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import tasks.resources.B2WKendoTasks;
import tasks.WebElementUtils;
import org.openqa.selenium.WebElement;
import tasks.util.TaskUtils;
import java.util.Iterator;
import java.util.List;

public class B2WSchedulerTasks extends B2WKendoTasks {

    public String ASSIGNMENT = "Assignment/Need";
    public String NEED = "Assignment/Need";
    public String CREWASSIGNMENT = "Crew Assignment";
    public String CREWNEED = "Crew Need";
    public String MOVEORDER = "Move Order";
    public String MOVEASSIGNMENT = "Move Assignment";
    public String EVENT = "Event";

    Logger log = Logger.getLogger(B2WEquipment.class);

    public boolean waitForSchedulePageNoBusy() {
        return waitForPageNotBusy();
    }

    //Navigate and Select Menu section
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

    //Select Options from 'New' Menu
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

    // Set value to fields: Equipment, Employee, Equipment Need, Employee Need
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

    public boolean setJobSite(String sValue) {
        return setFields("Job Site/Place", sValue);
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
        WebElement elContolPanel = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getControlPanel());
        WebElement jobSite = WebElementUtils.getChildElement(elContolPanel, KendoUI.getKendoDropDown());
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
        WebElement elContolPanel = WebElementUtils.getChildElement(parent, B2WScheduleAssignments.getControlPanel());
        WebElement jobSite = WebElementUtils.getChildElement(elContolPanel, KendoUI.getKendoDropDown());
        if (jobSite != null) {
            bResult &= sendTextAndSelectValueFromKendoFDD(jobSite, sDropoffJobSiteName);
        } else {
            bResult = false;
            log.debug("Job Site/Place field could not be found for Drop-off Location.");
        }
        return bResult;
    }
    public boolean selectCrew(String sCrewName) {
        //ToDo
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
        //ToDo
        boolean bResult;
        bResult = saveAssignment();
        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveEquipmentAssignment() {
        //ToDo
        boolean bResult;
        bResult = saveAssignment();
        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveEmployeeNeedAssignment() {
        //ToDo
        boolean bResult;
        bResult = saveAssignment();
        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveEquipmentNeedAssignment() {
        //ToDo
        boolean bResult;
        bResult = saveAssignment();
        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveCrewAssignment() {
        //ToDo
        boolean bResult;
        bResult = saveAssignment();
        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveCrewNeedAssignment() {
        //ToDo
        boolean bResult;
        bResult = saveAssignment();
        //bResult &= checkAssignmentExist();
        return bResult;
    }
    public boolean saveMoveAssignment() {
        //ToDo
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
        //ToDo
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
        //ToDo
        boolean bResult;
        bResult = saveAssignment();
        //bResult &= checkAssignmentExist();
        return bResult;
    }
}
