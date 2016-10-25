package tasks.scheduler;

import appobjects.resources.B2WEquipment;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import tasks.BrowserUtils;
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
        boolean bReturn = false;
        WebElement creationSection = WebElementUtils.findElement(B2WScheduleAssignments.getCreationSection());
        WebElement dropDownMenu = WebElementUtils.getChildElement(creationSection, B2WScheduleAssignments.getKendoDropDown());
        if (WebElementUtils.clickElement(dropDownMenu)) {
            // when we click we need to find the visible list
            List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getKendoLists());
            Iterator<WebElement> iter = list.iterator();
            while (iter.hasNext() && !bReturn) {
                WebElement els = iter.next();
                String hidden = els.getAttribute("aria-hidden");
                //if (hidden != null && hidden.equals("false")) {
                if (hidden != null) {
                    List<WebElement> items = els.findElements(B2WScheduleAssignments.getKendoDropDownItem());
                    WebElement item = WebElementUtils.getElementWithMatchingText(items, sItem, false);
                    if (item != null) {
                        WebElementUtils.waitForElementHasAttributeWithValue(els, "aria-hidden", "false", true, WebElementUtils.MEDIUM_TIME_OUT);
                        bReturn = WebElementUtils.clickElement(item);
                    }else{
                        log.debug("Item with could not be found matching " + sItem);
                    }
                }
            }
        }
        return bReturn;
    }

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
    public boolean createNewEmployeeEvent() {
        return openCreateDialog(EVENT);
    }
    public boolean createNewEquipmentEvent() {
        return openCreateDialog(EVENT);
    }
    public boolean createNewLocationEvent() {
        return openCreateDialog(EVENT);
    }

    public boolean setJobSite(String sValue) {
        boolean bReturn = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);
        if (assignmentWindow != null) {
            WebElement jobSite = WebElementUtils.getChildElement(assignmentWindow, B2WEquipment.getKendoDropDown());
            if (WebElementUtils.sendKeys(jobSite, sValue)) {
                List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getKendoLists());
                Iterator<WebElement> iter = list.iterator();
                while (iter.hasNext() && !bReturn) {
                    WebElement els = iter.next();
                    String hidden = els.getAttribute("aria-hidden");
                    if (hidden != null) {
                        List<WebElement> items = els.findElements(B2WScheduleAssignments.getKendoDropDownItem());
                        WebElement item = WebElementUtils.getElementWithMatchingText(items, sValue, false);
                        if (item != null) {
                            WebElementUtils.waitForElementHasAttributeWithValue(els, "aria-hidden", "false", true, WebElementUtils.MEDIUM_TIME_OUT);
                            bReturn = WebElementUtils.clickElement(item);
                        }else{
                            log.debug("Item with could not be found matching " + sValue);
                        }
                    }
                }
                if (!bReturn) log.debug("Element with value" + sValue + " could not be found.");
            }
        } else {
            log.debug("Create Assignment Window could not be found");
        }
        return bReturn;
    }

    public boolean setEmployee(String sFieldName, String sValue) {
        boolean bReturn = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);
        if (assignmentWindow != null) {
            List<WebElement> inputList = WebElementUtils.findElements(B2WScheduleAssignments.getFieldLabel());
            WebElement el = WebElementUtils.getElementWithMatchingText(inputList, sFieldName, false);
            WebElement employeeAssignment = WebElementUtils.getChildElement(WebElementUtils.getParentElement(el), B2WScheduleAssignments.getKendoFilterByDD());
            if (WebElementUtils.clickElement(employeeAssignment)) {
                List<WebElement> list = WebElementUtils.findElements(B2WScheduleAssignments.getKendoLists());
                Iterator<WebElement> iter = list.iterator();
                while (iter.hasNext() && !bReturn) {
                    WebElement els = iter.next();
                    String hidden = els.getAttribute("aria-hidden");
                    if (hidden != null && hidden.equals("false")) {
                        List<WebElement> items = els.findElements(B2WScheduleAssignments.getKendoDropDownItem());
                        WebElement item = WebElementUtils.getElementWithMatchingStartsWithText(items, sValue);
                        if (item != null) {
                            bReturn = WebElementUtils.clickElement(item);
                        }else{
                            log.debug("Item with could not be found matching " + sValue);
                        }
                    }
                }
            }
        } else {
            log.debug("Create Assignment Window could not be found");
        }
        return bReturn;
    }

    public boolean saveEmployeeAssignment() {
        boolean bReturn = false;
        WebElement assignmentWindow = WebElementUtils.waitAndFindElement(B2WScheduleAssignments.getAssignmentWindow());
        WebElementUtils.switchToFrame(B2WScheduleAssignments.getAssignmentWindow(), 1);
        WebElement saveBtn = WebElementUtils.getChildElement(assignmentWindow, B2WScheduleAssignments.getAddToScheduleBtn());
        if (saveBtn != null) {
            bReturn = WebElementUtils.clickElement(saveBtn);
            waitForSchedulePageNoBusy();
            WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleProductPageIcon(), 1);
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleProductPageIcon()) != null;
        } else {
            log.debug("Add to Schedule button could not be found.");
        }
        return bReturn;
    }
}
