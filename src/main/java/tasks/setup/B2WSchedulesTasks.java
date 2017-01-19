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
import tasks.util.Timer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.b2w.test.BaseAssert.logCompare;

public class B2WSchedulesTasks extends B2WKendoTasks {
    private final String SECURITY_ROLE = "Roles with access to this schedule";
    private final B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    private Logger log = Logger.getLogger(B2WSchedulesTasks.class);

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
    public long createScheduleView_Performance(B2WScheduleView scheduleView) {
        Timer timer = new Timer();
        clickCreateScheduleView();
        setName(scheduleView.getName());
        setBU(scheduleView.getBusinessUnit());
        setScheduleNotes(scheduleView.getNotes());
        setScheduleItems(scheduleView.getScheduleItems());
        setGrouping("Resource Grouping", scheduleView.getResourceGrouping());
        setGrouping("Secondary grouping", scheduleView.getSecondaryGrouping());
        setFilters(scheduleView.getFilters());
        setSecurityRoles(scheduleView.getRoles());
        setSecurityUsers(scheduleView.getUsers());
        try {
            timer.start();
            saveSchedule();
            timer.end();
            if (isScheduleExist(scheduleView.getName())) {
                return timer.getTotalTime();
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    public boolean deleteScheduleView(B2WScheduleView scheduleView) {
        /*
         * 1. Navigate to Setup -> Schedules
         * 2. Select Schedule View
         * 3. Delete Schedule View
         * 4. Check that Schedule View has been deleted.
         */
        boolean bReturn;
        logCompare(true, true, "====== Start Schedule View Deletion: " + scheduleView.getName());
        bReturn = logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        bReturn &= logCompare(true, selectScheduleView(scheduleView.getName()), "Select specific Schedule View");
        if (bReturn) {
            bReturn &= logCompare(true, deleteSchedule(), "Delete Schedule View");
        }
        bReturn &= logCompare(false, isScheduleExist(scheduleView.getName()), "Check that Schedule View has been deleted.");
        logCompare(true, true, "====== Stop Schedule View Deletion: " + scheduleView.getName());
        return bReturn;
    }
    public B2WScheduleView copyScheduleView(B2WScheduleView scheduleView) {
        B2WScheduleView oReturn = null;
        boolean bReturn = logCompare(true, true, "====== Start Schedule View Copy: " + scheduleView.getName());
        bReturn &= logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        bReturn &= logCompare(true, selectScheduleView(scheduleView.getName()), "Select Schedule View '" + scheduleView.getName() + "' in the list.");
        bReturn &= logCompare(true, clickCopyScheduleView(), "Click 'Copy' button.");
        bReturn &= logCompare(true, saveSchedule(), "Save 'Copy of " + scheduleView.getName() + "' Schedule View");
        bReturn &= logCompare(true, isScheduleExist("Copy of " + scheduleView.getName()), "Check that 'Copy of " + scheduleView.getName() + "' Schedule View has been created.");
        if (bReturn) {
            oReturn = scheduleView.clone();
            oReturn.setName("Copy of " + scheduleView.getName());
        }
        logCompare(true, true, "====== End Schedule View Copy: " + scheduleView.getName());
        return oReturn;
    }
    public boolean updateScheduleView(B2WScheduleView scheduleView, B2WScheduleView updateScheduleView) {
        boolean bReturn;
        logCompare(true, true, "====== Start Schedule View Update: " + scheduleView.getName());
        bReturn = logCompare(true, b2wNav.openSchedules(), "Navigate to Setup -> Schedules");
        bReturn &= logCompare(true, selectScheduleView(scheduleView.getName()), "Select Schedule View '" + scheduleView.getName() + "' in the list.");
        bReturn &= logCompare(true, clickEditScheduleView(), "Click 'Edit' button.");
        bReturn &= logCompare(true, deleteAllSelectedItems(), "Delete All selected Items from FDD.");
        bReturn &= logCompare(true, setName(updateScheduleView.getName()), "Set Name");
        bReturn &= logCompare(true, setBU(updateScheduleView.getBusinessUnit()), "Select BU");
        bReturn &= logCompare(true, setScheduleNotes(updateScheduleView.getNotes()), "Set Notes");
        bReturn &= logCompare(true, setScheduleItems(updateScheduleView.getScheduleItems()), "Select Schedule Format");
        bReturn &= logCompare(true, setGrouping("Resource Grouping", updateScheduleView.getResourceGrouping()), "Select Resource Grouping item by");
        bReturn &= logCompare(true, setGrouping("Secondary grouping", updateScheduleView.getSecondaryGrouping()), "Select Secondary grouping item by");
        bReturn &= logCompare(true, setFilters(updateScheduleView.getFilters()), "Set Filter");
        bReturn &= logCompare(true, setSecurityRoles(updateScheduleView.getRoles()), "Select Security Role");
        bReturn &= logCompare(true, setSecurityUsers(updateScheduleView.getUsers()), "Select Security Users");
        bReturn &= logCompare(true, saveSchedule(), "Save " + updateScheduleView.getName() + " Schedule View");
        bReturn &= logCompare(true, isScheduleExist(updateScheduleView.getName()), "Check that '" + scheduleView.getName() +
                "' Schedule View has been updated to '" + updateScheduleView.getName() + "'.");
        logCompare(true, true, "====== End Schedule View Update: " + scheduleView.getName());
        return bReturn;
    }

    // === Private Methods
    private boolean clickCreateScheduleView() {
        boolean bReturn = false;
        WebElement eNewScheduleBtn = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.createScheduleViewBtn());
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
    private boolean clickCopyScheduleView() {
        boolean bReturn = false;
        WebElement btnCopy = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.copyBtn());
        if (btnCopy != null) {
            bReturn = WebElementUtils.clickElement(btnCopy);
            waitForSchedulesPageNoBusy();
            bReturn &= getTextFromVisibleHeadline().equals("New Schedule");
        }
        return bReturn;
    }
    private boolean clickEditScheduleView() {
        boolean bReturn = false;
        WebElement btnEdit = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.editBtn());
        if (btnEdit != null) {
            bReturn = WebElementUtils.clickElement(btnEdit);
            waitForSchedulesPageNoBusy();
            bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.saveBtn()) != null;
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
    private boolean deleteAllFilters() {
        boolean bReturn = true;
        List<WebElement> removeFilterLinks = WebElementUtils.findElements(B2WSchedules.removeFilterLink());
        if (removeFilterLinks != null) {
            for (WebElement item: removeFilterLinks) {
                bReturn &= WebElementUtils.clickElement(item);
            }
        }
        return bReturn;
    }
    private boolean deleteAllSelectedItems() {
        boolean bReturn = true;
        List<WebElement> itemsList = WebElementUtils.findElements(B2WSchedules.removeItemBtn());
        if (itemsList != null) {
            for (WebElement item : itemsList) {
                bReturn &= WebElementUtils.clickElement(item);
            }
        }
        return bReturn;
    }
    private boolean disableResource(WebElement parent, String sValue) {
        boolean bResult = false;
        WebElement el = WebElementUtils.getChildElement(parent, B2WSchedules.scheduleResourceBtn(sValue));
        if (el != null) {
            WebElement p = WebElementUtils.getParentElement(el);
            if (p.getAttribute("class").contains("Button--selected")) {
                bResult = WebElementUtils.clickElement(el);
            } else {
                bResult = true;
            }
        }
        return bResult;
    }
    private boolean deleteSchedule() {
        boolean bReturn = false;
        WebElement eDeleteBtn = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.deleteBtn());
        if (eDeleteBtn != null) {
            bReturn = WebElementUtils.clickElement(eDeleteBtn);
            WebElement eDeleteWindow = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.deletePopUpWindow());
            if (eDeleteWindow != null) {
                WebElement eYesBtn = WebElementUtils.getChildElement(eDeleteWindow, B2WSchedules.yesBtnOnPopupWindow());
                if (eYesBtn != null) {
                    if (WebElementUtils.clickElement(eYesBtn)) {
                        bReturn = true;
                    } else {
                        TaskUtils.sleep(100);
                        bReturn = WebElementUtils.clickElement(eYesBtn);
                    }
                }
            }
        }
        return bReturn;
    }

    private WebElement findScheduleView(String sValue) {
        waitForSchedulesPageNoBusy();
        return WebElementUtils.findElement(B2WSchedules.schedulesRowOnGrid(sValue));
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

    private boolean setName(String sValue) {
        boolean bReturn = false;
        WebElement eName = WebElementUtils.findElement(B2WSchedules.nameField());
        if (eName != null) {
            eName.clear();
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
            eNotes.clear();
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
        WebElement element = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.scheduleCheckBox(item.getResourceName()));
        if (element == null) {
            List<WebElement> elementList = WebElementUtils.findElements(B2WSchedules.scheduleCheckBox(item.getResourceName()));
            if (elementList != null) {
                for (WebElement it : elementList) {
                    if (it.isDisplayed()) {
                        element = it;
                        break;
                    }
                }
            }
        }
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
        if (filters != null) {
            bReturn = deleteAllFilters();
            for (String[] item : filters) {
                bReturn &= setFilter(item[0], item[1]);
                waitForSchedulesPageNoBusy();
            }
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
            if (roles.get(0).equals("No Restrictions")) {
                bReturn = setRestrictedAccess(false);
            } else {
                bReturn = setRestrictedAccess(true);
                for (String item : roles) {
                    bReturn &= setSecurityRole(item);
                }
            }
        }
        return bReturn;
    }
    private boolean setSecurityUsers(ArrayList<String> users) {
        boolean bReturn = true;
        if (!users.isEmpty()) {
            bReturn = setRestrictedAccess(true);
            for (String item : users) {
                bReturn &= setUser(item);
            }
        }
        return bReturn;
    }
    private boolean setUser(String sValue) {
        boolean bReturn = false;
        WebElement eTmp = WebElementUtils.findElement(B2WScheduleAssignments.getUserItem());
        if (eTmp != null) {
            WebElement parent = WebElementUtils.getParentElement(eTmp);
            WebElement elResult = WebElementUtils.getChildElement(parent, KendoUI.getKendoDropDown());
            if (elResult != null) {
                WebElementUtils.moveVirtualMouseOverElement(elResult);
                WebElementUtils.clickElement(elResult);
                bReturn = selectItemFromDropDown(sValue);
            } else {
                log.debug("User field could not be found on the page.");
            }
        } else {
            log.debug("User field could not be found on the page.");
        }
        return bReturn;
    }
    private boolean setRestrictedAccess(boolean flag) {
        boolean bReturn = false;
        WebElement ePreviewLocation = WebElementUtils.findElement(B2WSchedules.previewLocation());
        if (ePreviewLocation != null) {
            WebElement parent = WebElementUtils.getParentElement(ePreviewLocation);
            WebElement eSelect = WebElementUtils.getChildElement(parent, KendoUI.getKendoDropDown());
            bReturn = WebElementUtils.clickElement(eSelect);
            if (flag) {
                bReturn &= selectItemFromDropDown("Restricted Access");
            } else {
                bReturn &= selectItemFromDropDown("No Restrictions");
            }
        }
        return bReturn;
    }
    private boolean setSecurityRole(String sValue) {
        boolean bReturn = false;
        WebElement eSecurityRole = WebElementUtils.getKendoFDDElementByLabel(SECURITY_ROLE);
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

    private boolean selectScheduleView(String sValue) {
        boolean bReturn = false;
        WebElement eItem = findScheduleView(sValue);
        if (eItem != null) {
            bReturn = WebElementUtils.clickElement(eItem);
            waitForSchedulesPageNoBusy();
            WebElement panel = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.rightPanel());
            WebElement headline = WebElementUtils.getChildElement(panel, B2WSchedules.headline());
            bReturn &= headline.getText().equals(sValue);
        }
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
