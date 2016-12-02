package tasks.setup;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WSchedules;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.B2WScheduleItem;

public class B2WSchedulesTasks extends B2WKendoTasks {

    Logger log = Logger.getLogger(B2WSchedulesTasks.class);

    public boolean clickCreateScheduleViewDialog() {
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
    public boolean clickUpdateScheduleViewDialog() {
        boolean bReturn = false;
        WebElement eEditScheduleBtn = WebElementUtils.findElement(B2WSchedules.editScheduleViewBtn());
        WebElementUtils.waitForElementClickable(eEditScheduleBtn);
        if (eEditScheduleBtn != null) {
            bReturn = WebElementUtils.clickElement(eEditScheduleBtn);
            waitForSchedulesPageNoBusy();
            bReturn &= getTextFromVisibleHeadline().equals("Edit Schedule");
        } else {
            log.debug("'Edit' button could not be found on the page.");
        }
        return bReturn;
    }

    public String getTextFromVisibleHeadline() {
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
    public boolean selectScheduleView(String sValue) {
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

    public boolean setName(String sValue) {
        boolean bReturn = false;
        WebElement eName = WebElementUtils.findElement(B2WSchedules.nameField());
        if (eName != null) {
            bReturn = WebElementUtils.sendKeys(eName, sValue);
        } else {
            log.debug("Element " + B2WSchedules.nameField() + " could not be found on the page.");
        }
        return bReturn;
    }
    public boolean setBU(String sValue) {
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
    public boolean setNotes(String sValue) {
        boolean bReturn = false;
        WebElement eNotes = WebElementUtils.findElement(B2WSchedules.notes());
        if (eNotes != null) {
            bReturn = WebElementUtils.sendKeys(eNotes, sValue);
        } else {
            log.debug("Element " + B2WSchedules.notes() + " could not be found on the page.");
        }
        return bReturn;
    }
    public boolean setScheduleFormat(String sValue) {
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
    public boolean setItems(List<B2WScheduleItem> itemList) {
        boolean bResult = false;
        disableAllResources();

        Iterator<B2WScheduleItem> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            B2WScheduleItem item = iterator.next();
            bResult = setItem(item);
        }
        return bResult;
    }
    public boolean setItem(B2WScheduleItem item) {
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
    public boolean setGrouping(String sGroupingFieldName, String sValue) {
        boolean bReturn = false;
        WebElement eGrouping;
        if (sGroupingFieldName.toLowerCase().equals("group items by")) {
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
        return bReturn;
    }
    public boolean setSecurityRole(String sValue) {
        //ToDo
        boolean bReturn = false;
        WebElement eSecurityRole = WebElementUtils.getKendoFDDElementByLabel("Roles with access to the schedule");
        if (eSecurityRole != null) {
            WebElementUtils.moveVirtualMouseOverElement(eSecurityRole);
            bReturn = WebElementUtils.clickElement(eSecurityRole);
            bReturn &= selectItemFromDropDown(sValue);
        } else {
            log.debug("'Security Role' dropdown could not be found on the page.");
        }
        return bReturn;
    }
    public boolean setFilter(String sType, String sValue) {
        //ToDo
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

    public boolean disableAllResources() {
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
    public boolean disableResource(WebElement parent, String sValue) {
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
    public boolean enableResource(WebElement parent, String sValue) {
        boolean bResult = false;
        WebElement el = WebElementUtils.getChildElement(parent, B2WSchedules.scheduleResourceBtn(sValue));
        if (el != null) {
            if (!el.getAttribute("class").toString().contains("checked")) {
                bResult = WebElementUtils.clickElement(el);
            }
        }
        return bResult;
    }

    public boolean setUser(String sValue) {
        //ToDo
        boolean bReturn = false;
        return bReturn;
    }

    public boolean saveSchedule() {
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
    public boolean deleteSchedule() {
        boolean bReturn = false;
        WebElement eDeleteBtn = WebElementUtils.findElement(B2WSchedules.deleteBtn());
        if (eDeleteBtn != null) {
            bReturn = WebElementUtils.clickElement(eDeleteBtn);
            WebElement eDeleteWindow = WebElementUtils.waitAndFindDisplayedElement(B2WSchedules.deletePopUpWindow());
            WebElement eYesBtn = WebElementUtils.getChildElement(eDeleteWindow, B2WSchedules.yesBtnOnPopupWindow());
            bReturn &= WebElementUtils.clickElement(eYesBtn);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Delete button could not be found on the page.");
        }
        return bReturn;
    }

    public boolean isScheduleExist(String sValue) {
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

    public WebElement findScheduleView(String sValue) {
            waitForSchedulesPageNoBusy();
            return WebElementUtils.findElement(B2WSchedules.schedulesRowOnGrid(sValue));
    }
    public boolean waitForSchedulesPageNoBusy() {
        return waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
    }


}
