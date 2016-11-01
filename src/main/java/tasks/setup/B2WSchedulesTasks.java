package tasks.setup;

import appobjects.setup.B2WSchedules;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import java.util.Iterator;
import java.util.List;

public class B2WSchedulesTasks extends B2WKendoTasks {

    Logger log = Logger.getLogger(B2WSchedulesTasks.class);

    public boolean openCreateScheduleViewDialog() {
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

    public boolean setFields(String sFieldName, String sValue) {
        boolean bReturn = false;
        WebElement eFDD = WebElementUtils.getKendoFDDElementByLabel(sFieldName);
        if (eFDD != null) {
            bReturn = sendTextAndSelectValueFromKendoFDD(eFDD, sValue);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("FDD with label " + sFieldName + " could not be found");
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
    public boolean setItems(String sValue) {
        boolean bReturn;
        bReturn = setFields("Items on the schedule", sValue);
        return bReturn;
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
            WebElement parent = WebElementUtils.getParentElement(item);
            bReturn &= clickAndSelectValueFromKendoFDD(parent, sValue);
        } else {
            log.debug("'Add a filter' dropdown could not be found on the page.");
        }
        return bReturn;
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
            //TaskUtils.sleep(100);
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
            waitForSchedulesPageNoBusy();
            bReturn = findScheduleView(sValue) != null;
        } catch (Exception e) {
            log.debug("Exception during executing: " + e.toString() );
        }
        return bReturn;
    }

    public WebElement findScheduleView(String sValue) {
            waitForSchedulesPageNoBusy();
            return WebElementUtils.findElement(B2WSchedules.schedulesRowOnGrid(sValue));
    }
    public boolean waitForSchedulesPageNoBusy() {
        return waitForPageNotBusy();
    }
}
