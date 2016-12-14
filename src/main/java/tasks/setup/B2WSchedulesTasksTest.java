package tasks.setup;

import appobjects.resources.KendoUI;
import appobjects.scheduler.B2WScheduleAssignments;
import appobjects.setup.B2WSchedules;
import org.apache.log4j.Logger;
import org.jfree.data.time.DateRange;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tasks.B2WNavigationTasks;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.scheduler.B2WScheduleView;
import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;
import tasks.util.TaskUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.b2w.test.BaseAssert.logCompare;

public class B2WSchedulesTasksTest extends B2WKendoTasks {
    private final String SECURITY_ROLE = "Roles with access to this schedule";
    private final String SECURITY_USERS = "Users with access to this schedule";

    private final B2WNavigationTasks b2wNav = new B2WNavigationTasks();

    private Logger log = Logger.getLogger(B2WSchedulesTasksTest.class);

    public boolean createScheduleView(B2WScheduleView scheduleView) {
        boolean bReturn;
        bReturn = logCompare(true, true, "====== Start Schedule View Creation: " + scheduleView.getName());
        bReturn &= logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        bReturn &= logCompare(true, clickCreateScheduleView(), "Open Create Schedule View dialog.");
        bReturn &= logCompare(true, setName(scheduleView.getName()), "Set Name");
        bReturn &= logCompare(true, setBU(scheduleView.getBusinessUnit()), "Select BU");
        bReturn &= logCompare(true, setScheduleNotes(scheduleView.getNotes()), "Set Notes");
        bReturn &= logCompare(true, setScheduleItems(scheduleView.getScheduleItems()), "Select Schedule Format");
        bReturn &= logCompare(true, setGrouping("Resource Grouping", scheduleView.getResourceGrouping()), "Select Resource Grouping item by");
        bReturn &= logCompare(true, setGrouping("Secondary grouping", scheduleView.getSecondaryGrouping()), "Select Secondary grouping item by");
        bReturn &= logCompare(true, setFilters(scheduleView.getFilters()), "Set Filter");
        bReturn &= logCompare(true, setSecurityRoles(scheduleView.getRoles()), "Select Security Role");
        bReturn &= logCompare(true, setSecurityUsers(scheduleView.getUsers()), "Select Security Users");
        bReturn &= logCompare(true, saveSchedule(), "Save " + scheduleView.getName() + " Schedule View");
        bReturn &= logCompare(true, isScheduleExist(scheduleView.getName()), "Check that " + scheduleView.getName() + " Schedule View has been created.");
        bReturn &= logCompare(true, true, "====== End Schedule View Creation: " + scheduleView.getName());
        return bReturn;
    }

    // === Private Methods
    private boolean clickCreateScheduleView() {
        boolean bReturn = false;
        WebElement eNewScheduleBtn = WebElementUtils.findElement(B2WSchedules.createScheduleViewBtn());
        WebElementUtils.waitForElementClickable(eNewScheduleBtn);
        if (eNewScheduleBtn != null) {
            bReturn = WebElementUtils.clickElement(eNewScheduleBtn);
            waitForSchedulesPageNoBusy();
            bReturn &= getTextFromVisibleHeadline().equals("New Schedule");
        } else {
            log.debug("'New Schedule' button could not be found on the page.");
        }
        return bReturn;
    }

    private boolean disableAllResources() {
        boolean bReturn = false;
        WebElement eScheduleFormatSection = WebElementUtils.getElementWithMatchingText(B2WSchedules.filterItemLabel(), "Schedule Format");
        eScheduleFormatSection = WebElementUtils.getParentElement(eScheduleFormatSection);
        List<WebElement> eList = WebElementUtils.getChildElements(eScheduleFormatSection, By.cssSelector("input"));
        boolean bTmp = true;
        for (WebElement item : eList) {
            if (item.isDisplayed() && WebElementUtils.isCheckboxChecked(item)) {
                bTmp &= WebElementUtils.clickElement(item);
                bReturn = true;
            }
        }
        bReturn &= bTmp;
        return bReturn;
    }

    private boolean disableResource(WebElement parent, String sValue) {
        boolean bResult = false;
        WebElement el = WebElementUtils.getChildElement(parent, B2WSchedules.scheduleResourceBtn(sValue));
        if (el != null) {
            if (el.getAttribute("class").toString().contains("checked")) {
                bResult = WebElementUtils.clickElement(el);
            } else {
                bResult = true;
            }
        }
        return bResult;
    }

    private WebElement findScheduleView(String sValue) {
        waitForSchedulesPageNoBusy();
        return WebElementUtils.findElement(B2WSchedules.schedulesRowOnGrid(sValue));
    }

    private String getTextFromVisibleHeadline() {
        String sReturn = "";
        List<WebElement> list = WebElementUtils.findElements(B2WSchedules.headline());
        Iterator<WebElement> iterator = list.iterator();
        boolean bResult = false;
        while (iterator.hasNext() && !bResult) {
            WebElement item = iterator.next();
            String attribute = item.getAttribute("data-bind");
            if (attribute.split(":")[0].equals("visible")) {
                bResult = true;
                sReturn = item.getText();
            }
        }
        return sReturn;
    }

    private boolean isScheduleExist(String sValue) {
        boolean bReturn = false;
        try {
            bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.editScheduleViewBtn()) != null;
            waitForSchedulesPageNoBusy();
            bReturn &= findScheduleView(sValue) != null;
        } catch (Exception e) {
            log.debug("Exception during executing: " + e.toString());
        }
        return bReturn;
    }

    private boolean setName(String sValue) {
        boolean bReturn = false;
        WebElement eName = WebElementUtils.findElement(B2WSchedules.nameField());
        if (eName != null) {
            bReturn = WebElementUtils.sendKeys(eName, sValue);
        } else {
            log.debug("Element " + B2WSchedules.nameField() + " could not be found on the page.");
        }
        return bReturn;
    }

    private boolean setBU(String sValue) {
        boolean bReturn = false;
        WebElement eBU = WebElementUtils.getKendoFDDElementByLabel("Business Unit");
        if (eBU != null) {
            bReturn = WebElementUtils.clickElement(eBU);
            bReturn &= selectItemFromDropDown(sValue);
        } else {
            log.debug("'BU' dropdown could not be found on the page.");
        }
        return bReturn;
    }

    private boolean setScheduleNotes(String sValue) {
        boolean bReturn = false;
        WebElement eNotes = WebElementUtils.findElement(B2WSchedules.notes());
        if (eNotes != null) {
            bReturn = WebElementUtils.sendKeys(eNotes, sValue);
        } else {
            log.debug("Element " + B2WSchedules.notes() + " could not be found on the page.");
        }
        return bReturn;
    }

    private boolean setScheduleItems(ArrayList<B2WScheduleItem> scheduleItemsList) {
        boolean bReturn = true;
        if (!scheduleItemsList.isEmpty()) {
            bReturn &= setScheduleFormat(scheduleItemsList.get(0).getScheduleFormat());
            disableAllResources();
        }
        for (B2WScheduleItem item : scheduleItemsList) {
            bReturn &= setItem(item);
        }
        return bReturn;
    }

    private boolean setScheduleFormat(String sValue) {
        boolean bReturn = false;
        List<WebElement> eList = WebElementUtils.findElements(B2WSchedules.scheduleFormat());
        if (eList != null && eList.size()>0) {
            WebElement eItem;
            if (sValue.equals("Resource Listing")) {
                eItem = WebElementUtils.findElement(B2WSchedules.scheduleFormatItem("1"));
            } else if (sValue.equals("Location View")) {
                eItem = WebElementUtils.findElement(B2WSchedules.scheduleFormatItem("2"));
            } else if (sValue.equals("Crew View")) {
                eItem = WebElementUtils.findElement(B2WSchedules.scheduleFormatItem("3"));
            } else {
                eItem = null;
            }
            if (eItem != null) {
                bReturn = WebElementUtils.clickElement(eItem);
            } else {
                log.debug("Element " + sValue + " could not be found on the page.");
            }
        } else {
            log.debug("Element " + B2WSchedules.scheduleFormat() + " could not be found on the page.");
        }
        return bReturn;
    }

    private boolean setItem(B2WScheduleItem item) {
        boolean bResult = false;
        WebElement element = WebElementUtils.findElement(B2WSchedules.scheduleCheckBox(item.getResourceName()));
        if (element != null) {
            WebElement parent = WebElementUtils.getParentElement(element);
            parent = WebElementUtils.getParentElement(parent);
            bResult = WebElementUtils.clickElement(element);
            if (!item.isAssignments() && item.isItemAvailable("Assignments")) {
                bResult &= disableResource(parent, "Assignments");
            }
            if (!item.isNeeds() && item.isItemAvailable("Needs")) {
                bResult &= disableResource(parent, "Needs");
            }
            if (!item.isEvents() && item.isItemAvailable("Events")) {
                bResult &= disableResource(parent, "Events");
            }
            if (!item.isMoveAssignments() && item.isItemAvailable("Move Assignments")) {
                bResult &= disableResource(parent, "Move Assignments");
            }
            if (!item.isMoveOrders() && item.isItemAvailable("Move Orders")) {
                bResult &= disableResource(parent, "Move Orders");
            }
            if (!item.isTarget() && item.isItemAvailable("Target")) {
                bResult &= disableResource(parent, "Target");
            }
        }
        return bResult;
    }

    private boolean setGrouping(String sGroupingFieldName, String sValue) {
        boolean bReturn = true;
        if (sValue != null) {
            if (!sValue.equals("")) {
                WebElement eGrouping;
                if (sGroupingFieldName.toLowerCase().equals("resource grouping")) {
                    eGrouping = WebElementUtils.findElement(B2WSchedules.groupItemsBy());
                } else if (sGroupingFieldName.toLowerCase().equals("secondary grouping")) {
                    eGrouping = WebElementUtils.findElement(B2WSchedules.secondaryGrouping());
                } else {
                    eGrouping = null;
                }
                if (eGrouping != null) {
                    WebElement parent = WebElementUtils.getParentElement(eGrouping);
                    bReturn = WebElementUtils.clickElement(parent);
                    bReturn &= selectItemFromDropDown(sValue);
                    waitForSchedulesPageNoBusy();
                } else {
                    log.debug("'" + sGroupingFieldName + "' dropdown could not be found on the page.");
                }
            }
        }
        return bReturn;
    }

    private boolean setFilters(ArrayList<String[]> filters) {
        boolean bReturn = true;
        for (String[] item : filters) {
            bReturn &= setFilter(item[0], item[1]);
            waitForSchedulesPageNoBusy();
        }
        return bReturn;
    }

    private boolean setFilter(String sType, String sValue) {
        boolean bReturn = false;
        WebElement eAddFilterDD = WebElementUtils.findElement(B2WSchedules.addFilterDropDown());
        if (eAddFilterDD != null) {
            bReturn = clickAndSelectValueFromKendoFDD(eAddFilterDD, sType);
            WebElement item = WebElementUtils.getElementWithMatchingChildElementText(B2WSchedules.addFilterDropDown(), B2WSchedules.filterItemLabel(), sType);
            if (item != null){
                WebElement parent = WebElementUtils.getParentElement(item);
                bReturn &= clickAndSelectValueFromKendoFDD(parent, sValue);
            }
        } else {
            log.debug("'Add a filter' dropdown could not be found on the page.");
        }
        return bReturn;
    }

    private boolean setSecurityRoles(ArrayList<String> roles) {
        boolean bReturn = true;
        if (!roles.isEmpty()) {
            bReturn = setRestrictedAccess();
            for (String item : roles) {
                bReturn &= setSecurityRole(SECURITY_ROLE, item);
            }
        }
        return bReturn;
    }

    private boolean setSecurityUsers(ArrayList<String> users) {
        boolean bReturn = true;
        if (!users.isEmpty()) {
            bReturn = setRestrictedAccess();
            for (String item : users) {
                bReturn &= setSecurityUser(SECURITY_USERS, item);;
            }
        }
        return bReturn;
    }

    private boolean setRestrictedAccess() {
        boolean bReturn = false;
        WebElement ePreviewLocation = WebElementUtils.findElement(B2WSchedules.previewLocation());
        if (ePreviewLocation != null) {
            WebElement parent = WebElementUtils.getParentElement(ePreviewLocation);
            WebElement eSelect = WebElementUtils.getChildElement(parent, KendoUI.getKendoDropDown());
            bReturn = WebElementUtils.clickElement(eSelect);
            bReturn &= selectItemFromDropDown("Restricted Access");
        }
        return bReturn;
    }

    private boolean setSecurityRole(String sFieldName, String sValue) {
        boolean bReturn = false;
        WebElement eSecurityRole = WebElementUtils.getKendoFDDElementByLabel(sFieldName);
        if (eSecurityRole != null) {
            WebElementUtils.moveVirtualMouseOverElement(eSecurityRole);
            WebElementUtils.waitForElementClickable(eSecurityRole);
            bReturn = WebElementUtils.clickElement(eSecurityRole);
            bReturn &= selectItemFromDropDown(sValue);
        } else {
            log.debug("'Security Role' dropdown could not be found on the page.");
        }
        return bReturn;
    }

    private boolean setSecurityUser(String sFieldName, String sValue) {
        boolean bReturn = false;
        return bReturn;
    }

    private boolean saveSchedule() {
        boolean bReturn = false;
        WebElement eSaveBtn = WebElementUtils.findElement(B2WSchedules.saveBtn());
        if (eSaveBtn != null) {
            bReturn = WebElementUtils.clickElement(eSaveBtn);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Save button could not be found on the page.");
        }
        return bReturn;
    }

    private boolean waitForSchedulesPageNoBusy() {
        return waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
    }
}
