package tasks.resources;

import appobjects.resources.B2WCrewTemplates;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

import java.awt.*;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;

import static com.b2w.test.BaseAssert.logCompare;

public class B2WCrewTemplateTasks extends B2WKendoTasks {

    static Logger log = Logger.getLogger(B2WEquipmentTasks.class);
    private int yOffset;

    // Public Methods
    public boolean selectAddCrewTemplate(String type) {
        boolean bReturn = false;

        WebElement menuItem = WebElementUtils.waitAndFindElement(B2WCrewTemplates.getAddCrewTemplateButton());
        if (menuItem != null) {
            bReturn = WebElementUtils.clickElement(menuItem);
            List<WebElement> list = WebElementUtils.waitAndFindDisplayedElements(B2WCrewTemplates.getCrewTypesList());
            for (WebElement item : list) {
                if (item.getText().equals(type)) {
                    bReturn = WebElementUtils.clickElement(item);
                    bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getCrewHeadline()) != null;
                    bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getResourceTree()) != null;
                    return bReturn;
                }
            }
        }
        return bReturn;
    }
    public boolean createCrewTemplate(B2WCrewTemplate crewTemplate) {
        if (crewTemplate.getType().equals("Production Crew")) {
            return createProductionCrewTemplate(crewTemplate);
        } else if (crewTemplate.getType().equals("Transport Crew")) {
            return createTransportCrewTemplate(crewTemplate);
        } else {
            return false;
        }
    }
    public boolean updateCrewTemplate(B2WCrewTemplate crewTemplate, B2WCrewTemplate crewTemplateUpd) {
        if (crewTemplate.getType().equals("Production Crew")) {
            return updateProductionCrewTemplate(crewTemplate, crewTemplateUpd);
        } else if (crewTemplate.getType().equals("Transport Crew")) {
            return updateTransportCrewTemplate(crewTemplate, crewTemplateUpd);
        } else {
            return false;
        }
    }
    public boolean copyCrewTemplate(B2WCrewTemplate crewTemplate) {
        boolean bReturn;
        bReturn = logCompare(true, selectCrewTemplate(crewTemplate), "Select Crew Template: " + crewTemplate.getName() + " from list.");
        bReturn &= logCompare(true, clickCopyButton(), "Click Copy Crew Template button.");
        bReturn &= logCompare(true, clickSaveButton(), "Click Save Crew Template button.");
        bReturn &= logCompare(true, getCrewTemplateFromList("Copy of " + crewTemplate.getName()) != null, "Check that Crew Template copy was saved.");
        return bReturn;
    }
    public boolean deleteCrew(B2WCrewTemplate crewTemplate) {
        boolean bReturn = false;
        if (logCompare(true, selectCrewTemplate(crewTemplate), "Select Crew Template '" + crewTemplate.getName() + "' in the list.")) {
            WebElement deleteBtn = WebElementUtils.waitAndFindElement(B2WCrewTemplates.getDeleteBtn());
            if (deleteBtn != null) {
                bReturn = WebElementUtils.clickElement(deleteBtn);
                WebElement popupWindow = WebElementUtils.waitAndFindDisplayedElement(B2WCrewTemplates.getPopupWindow());
                if ( popupWindow != null) {
                    logCompare(true, WebElementUtils.findElement(B2WCrewTemplates.getButtonByName("Yes")) != null, "Check that the Button Yes is displayed.");
                    if (selectButtonOption("Yes")) {
                        WebElementUtils.waitForElementInvisible(popupWindow);
                        waitForSchedulesPageNoBusy();
                        bReturn &= getCrewTemplateFromList(crewTemplate.getName()) == null;
                    } else {
                        log.warn("Button 'Yes' could not be found on the page.");
                    }
                } else {
                    log.warn("Popup window is not displayed.");
                }
            }
        }
        return bReturn;
    }
    public boolean searchCrewTemplate(String sName) {
        boolean bReturn;
        bReturn = logCompare(true, setSearchCrewTemplateName(sName), "Set Crew Template Name: " + sName + " to the search field.");
        bReturn &= logCompare(true, getCrewTemplateFromList(sName) != null, "Check that Crew Template Name: " + sName + " in the list.");
        bReturn &= logCompare(true, getCrewTemplateCountFromList() == 1, "Check that Crew Template List contains one record.");
        return bReturn;
    }
    public boolean clearSearchCrewTemplate() {
        boolean bReturn = false;
        WebElement listPanel = WebElementUtils.findElement(B2WCrewTemplates.getCrewTemplatesListPanel());
        if (listPanel != null) {
            WebElement parent = WebElementUtils.getParentElement(listPanel);
            WebElement deleteIcon = WebElementUtils.getChildElement(parent, B2WCrewTemplates.getDeleteCrewTemplateSearch());
            if (deleteIcon != null) {
                bReturn = WebElementUtils.clickElement(deleteIcon);
            }
        }

        return bReturn;
    }

    // Getter and Setter
    public int getyOffset() {
        if (this.yOffset > 0) {
            return yOffset;
        } else {
            return evaluateYOffset();
        }
    }
    public void setYOffset() {
        this.yOffset = evaluateYOffset();
    }

    // ==== Private Methods
    private boolean createProductionCrewTemplate(B2WCrewTemplate crewTemplate) {
        boolean bReturn;
        bReturn = logCompare(true, setName(crewTemplate.getName()), "Set Crew Template Name: " + crewTemplate.getName());
        bReturn &= logCompare(true, setID(crewTemplate.getID()), "Set Crew Template ID: " + crewTemplate.getID());
        bReturn &= logCompare(true, setWorkType(crewTemplate.getWorkType()), "Set Crew Template Work: " + crewTemplate.getWorkType());
        bReturn &= logCompare(true, setWorkSubtype(crewTemplate.getWorkSubType()), "Set Crew Template Work Subtype: " + crewTemplate.getWorkSubType());
        bReturn &= logCompare(true, setBU(crewTemplate.getBusinessUnit()), "Set Crew Template Business Unit: " + crewTemplate.getBusinessUnit());
        bReturn &= logCompare(true, setInactive(crewTemplate.isInactive()), "Set Crew Template Inactive Flag: " + crewTemplate.isInactive());
        bReturn &= logCompare(true, setCrewNotes(crewTemplate.getNotes()), "Set Crew Template Notes: " + crewTemplate.getNotes());
        setYOffset();
        bReturn &= logCompare(true, setProductionForeman(crewTemplate.getForeman()), "Add Crew Foreman: " + crewTemplate.getForeman());
        bReturn &= logCompare(true, addEmployeeToCrew(crewTemplate.getEmployees()), "Add Crew Employees: " + crewTemplate.getEmployees());
        bReturn &= logCompare(true, addEquipmentToCrew(crewTemplate.getEquipments()), "Add Crew Equipment: " + crewTemplate.getEquipments());
        bReturn &= logCompare(true, addLaborTypeToCrew(crewTemplate.getLaborTypes()), "Add Crew Labor Type: " + crewTemplate.getLaborTypes());
        bReturn &= logCompare(true, addEquipmentTypeToCrew(crewTemplate.getEquipmentTypes()), "Add Crew Equipment Type: " + crewTemplate.getEquipmentTypes());
        bReturn &= logCompare(true, clickSaveButton(), "Click Crew Template Save button.");
        bReturn &= logCompare(true, getCrewTemplateFromList(crewTemplate.getName()) != null, "Check that Crew Template was created.");
        return bReturn;
    }
    private boolean createTransportCrewTemplate(B2WCrewTemplate crewTemplate) {
        boolean bReturn;
        bReturn = logCompare(true, setName(crewTemplate.getName()), "Set Crew Template Name: " + crewTemplate.getName());
        bReturn &= logCompare(true, setID(crewTemplate.getID()), "Set Crew Template ID: " + crewTemplate.getID());
        bReturn &= logCompare(true, selectTransportType(crewTemplate.getTransportType()), "Select Transport function: " + crewTemplate.getTransportType());
        bReturn &= logCompare(true, setWorkType(crewTemplate.getWorkType()), "Set Crew Template Work: " + crewTemplate.getWorkType());
        bReturn &= logCompare(true, setWorkSubtype(crewTemplate.getWorkSubType()), "Set Crew Template Work Subtype: " + crewTemplate.getWorkSubType());
        bReturn &= logCompare(true, setBU(crewTemplate.getBusinessUnit()), "Set Crew Template Business Unit: " + crewTemplate.getBusinessUnit());
        bReturn &= logCompare(true, setInactive(crewTemplate.isInactive()), "Set Crew Template Inactive Flag: " + crewTemplate.isInactive());
        bReturn &= logCompare(true, setCrewNotes(crewTemplate.getNotes()), "Set Crew Template Notes: " + crewTemplate.getNotes());
        setYOffset();
        bReturn &= logCompare(true, setTransportDriver(crewTemplate.getForeman()), "Add Crew Driver: " + crewTemplate.getForeman());
        bReturn &= logCompare(true, addEmployeeToCrew(crewTemplate.getEmployees()), "Add Crew Employees: " + crewTemplate.getEmployees());
        bReturn &= logCompare(true, addEquipmentThatMovesToCrew(crewTemplate.getEquipmentThatMoves()), "Add Crew Equipments that moves: " + crewTemplate.getEquipmentThatMoves());
        bReturn &= logCompare(true, addEquipmentToCrew(crewTemplate.getEquipments()), "Add Crew Equipment: " + crewTemplate.getEquipments());
        bReturn &= logCompare(true, addLaborTypeToCrew(crewTemplate.getLaborTypes()), "Add Crew Labor Type: " + crewTemplate.getLaborTypes());
        bReturn &= logCompare(true, addEquipmentTypeToCrew(crewTemplate.getEquipmentTypes()), "Add Crew Equipment Type: " + crewTemplate.getEquipmentTypes());
        bReturn &= logCompare(true, clickSaveButton(), "Click Crew Template Save button.");
        bReturn &= logCompare(true, getCrewTemplateFromList(crewTemplate.getName()) != null, "Check that Crew Template was created.");
        return bReturn;
    }
    private boolean updateProductionCrewTemplate(B2WCrewTemplate crewTemplate, B2WCrewTemplate crewTemplateUpd) {
        boolean bReturn = false;
        if (selectCrewTemplate(crewTemplate)) {
            if (clickUpdateButton()) {
                bReturn = logCompare(true, setName(crewTemplateUpd.getName()), "Update Crew Template Name: " + crewTemplateUpd.getName());
                bReturn &= logCompare(true, setID(crewTemplateUpd.getID()), "Update Crew Template ID: " + crewTemplateUpd.getID());
                bReturn &= logCompare(true, setWorkType(crewTemplateUpd.getWorkType()), "Update Crew Template Work: " + crewTemplateUpd.getWorkType());
                bReturn &= logCompare(true, setWorkSubtype(crewTemplateUpd.getWorkSubType()), "Update Crew Template Work Subtype: " + crewTemplateUpd.getWorkSubType());
                bReturn &= logCompare(true, setBU(crewTemplateUpd.getBusinessUnit()), "Update Crew Template Business Unit: " + crewTemplateUpd.getBusinessUnit());
                bReturn &= logCompare(true, setInactive(crewTemplateUpd.isInactive()), "Update Crew Template Inactive Flag: " + crewTemplateUpd.isInactive());
                bReturn &= logCompare(true, setCrewNotes(crewTemplateUpd.getNotes()), "Update Crew Template Notes: " + crewTemplateUpd.getNotes());
                setYOffset();
                bReturn &= logCompare(true, deleteAllCrewMembers(), "Delete Crew Members.");
                bReturn &= logCompare(true, setProductionForeman(crewTemplateUpd.getForeman()), "Add Crew Foreman: " + crewTemplateUpd.getForeman());
                bReturn &= logCompare(true, addEmployeeToCrew(crewTemplateUpd.getEmployees()), "Add Crew Employees: " + crewTemplateUpd.getEmployees());
                bReturn &= logCompare(true, addEquipmentToCrew(crewTemplateUpd.getEquipments()), "Add Crew Equipment: " + crewTemplateUpd.getEquipments());
                bReturn &= logCompare(true, addLaborTypeToCrew(crewTemplateUpd.getLaborTypes()), "Add Crew Labor Type: " + crewTemplateUpd.getLaborTypes());
                bReturn &= logCompare(true, addEquipmentTypeToCrew(crewTemplateUpd.getEquipmentTypes()), "Add Crew Equipment Type: " + crewTemplateUpd.getEquipmentTypes());
                bReturn &= logCompare(true, clickSaveButton(), "Click Crew Template Save button.");
                bReturn &= logCompare(true, getCrewTemplateFromList(crewTemplateUpd.getName()) != null, "Check that Crew Template was updated.");
            }
        }
        return bReturn;
    }
    private boolean updateTransportCrewTemplate(B2WCrewTemplate crewTemplate, B2WCrewTemplate crewTemplateUpd) {
        boolean bReturn = false;
        if (selectCrewTemplate(crewTemplate)) {
            if (clickUpdateButton()) {
                bReturn = logCompare(true, setName(crewTemplateUpd.getName()), "Update Crew Template Name: " + crewTemplateUpd.getName());
                bReturn &= logCompare(true, setID(crewTemplateUpd.getID()), "Update Crew Template ID: " + crewTemplateUpd.getID());
                bReturn &= logCompare(true, selectTransportType(crewTemplateUpd.getTransportType()), "Update Transport function: " + crewTemplateUpd.getTransportType());
                bReturn &= logCompare(true, setWorkType(crewTemplateUpd.getWorkType()), "Update Crew Template Work: " + crewTemplateUpd.getWorkType());
                bReturn &= logCompare(true, setWorkSubtype(crewTemplateUpd.getWorkSubType()), "Update Crew Template Work Subtype: " + crewTemplateUpd.getWorkSubType());
                bReturn &= logCompare(true, setBU(crewTemplateUpd.getBusinessUnit()), "Update Crew Template Business Unit: " + crewTemplateUpd.getBusinessUnit());
                bReturn &= logCompare(true, setInactive(crewTemplateUpd.isInactive()), "Update Crew Template Inactive Flag: " + crewTemplateUpd.isInactive());
                bReturn &= logCompare(true, setCrewNotes(crewTemplateUpd.getNotes()), "Update Crew Template Notes: " + crewTemplateUpd.getNotes());
                setYOffset();
                bReturn &= logCompare(true, deleteAllCrewMembers(), "Delete Crew Members.");
                bReturn &= logCompare(true, setTransportDriver(crewTemplateUpd.getForeman()), "Add Crew Driver: " + crewTemplateUpd.getForeman());
                bReturn &= logCompare(true, addEmployeeToCrew(crewTemplateUpd.getEmployees()), "Add Crew Employees: " + crewTemplateUpd.getEmployees());
                bReturn &= logCompare(true, addEquipmentThatMovesToCrew(crewTemplateUpd.getEquipmentThatMoves()), "Add Crew Equipments that moves: " + crewTemplateUpd.getEquipmentThatMoves());
                bReturn &= logCompare(true, addEquipmentToCrew(crewTemplateUpd.getEquipments()), "Add Crew Equipment: " + crewTemplateUpd.getEquipments());
                bReturn &= logCompare(true, addLaborTypeToCrew(crewTemplateUpd.getLaborTypes()), "Add Crew Labor Type: " + crewTemplateUpd.getLaborTypes());
                bReturn &= logCompare(true, addEquipmentTypeToCrew(crewTemplateUpd.getEquipmentTypes()), "Add Crew Equipment Type: " + crewTemplateUpd.getEquipmentTypes());
                bReturn &= logCompare(true, clickSaveButton(), "Click Crew Template Save button.");
                bReturn &= logCompare(true, getCrewTemplateFromList(crewTemplateUpd.getName()) != null, "Check that Crew Template was updated.");
            }
        }
        return bReturn;
    }

    // Select Methods
    private boolean selectValueFromFDD(String fieldName, String sValue) {
        boolean bReturn = false;
        WebElement fdd = WebElementUtils.getKendoFDDElementByLabel(fieldName);
        if (fdd != null) {
            bReturn = WebElementUtils.clickElement(fdd);
            bReturn &= selectItemFromDropDown(sValue);
        } else {
            log.debug("'" + fieldName + "' dropdown could not be found on the page.");
        }
        return bReturn;
    }
    private boolean selectValueFromFDD(WebElement element, String sValue) {
        boolean bReturn = false;
        if (element != null) {
            bReturn = WebElementUtils.clickElement(element);
            bReturn &= selectItemFromDropDown(sValue);
        } else {
            log.debug("'" + element.toString() + "' could not be found on the page.");
        }
        return bReturn;
    }
    private boolean selectSearchType(String searchValue) {
        boolean bReturn = false;
        WebElement searchFDD = WebElementUtils.getKendoFDDElementByTag("Crew Details", "h4");
        if (searchFDD != null) {
            bReturn = selectValueFromFDD(searchFDD, searchValue);
            if (!bReturn) {
                log.debug("Could not select the value at first time. Trying to select one more time.");
                TaskUtils.sleep(100);
                searchFDD = WebElementUtils.getKendoFDDElementByTag("Crew Details", "h4");
                bReturn = selectValueFromFDD(searchFDD, searchValue);
            }
        } else {
            log.error("Could not find searchFDD.");
        }
        return bReturn;
    }
    private boolean selectCrewTemplate(B2WCrewTemplate crewTemplate) {
        boolean bReturn = false;
        WebElement eCrewTemplate = getCrewTemplateFromList(crewTemplate.getName());
        if (eCrewTemplate != null) {
            WebElementUtils.moveVirtualMouseOverElement(eCrewTemplate);
            bReturn = WebElementUtils.clickElement(eCrewTemplate);
            bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getDeleteBtn()) != null;
        } else {
            log.warn("Crew Template could not be found on the page.");
        }
        return bReturn;
    }
    private boolean selectButtonOption(String sButtonName) {
        boolean bReturn = false;
        WebElement button = WebElementUtils.waitAndFindDisplayedElement(B2WCrewTemplates.getButtonByName(sButtonName));
        if (button != null) {
            bReturn = WebElementUtils.clickElement(button);
            waitForSchedulesPageNoBusy();
        } else {
            log.debug("Button with text " + sButtonName + " could not be found on the page.");
        }
        return bReturn;
    }
    private boolean selectTransportType(String sTransportFunction) {
        boolean bReturn = false;
        WebElement eTransportFunction = null;
        if (sTransportFunction.equals("Moves Equipment")) {
            eTransportFunction = WebElementUtils.findElement(B2WCrewTemplates.getTransportFunction("1"));
        } else if (sTransportFunction.equals("Moves Materials")) {
            eTransportFunction = WebElementUtils.findElement(B2WCrewTemplates.getTransportFunction("2"));
        } else {
            log.warn("Incorrect Transport Function value");
        }
        if (eTransportFunction != null) {
            bReturn = WebElementUtils.clickElement(eTransportFunction);
        }
        return bReturn;
    }

    // Set Methods
    private boolean setName(String sValue) {
        boolean bReturn = false;
        WebElement field = WebElementUtils.findElement(B2WCrewTemplates.getNameField());
        if (field != null) {
            field.clear();
            bReturn = WebElementUtils.sendKeys(field, sValue);
        }
        return bReturn;
    }
    private boolean setID(String sValue) {
        boolean bReturn = false;
        WebElement field = WebElementUtils.findElement(B2WCrewTemplates.getIDField());
        if (field != null) {
            field.clear();
            bReturn = WebElementUtils.sendKeys(field, sValue);
        }
        return bReturn;
    }
    private boolean setWorkType(String sValue) {
        return selectValueFromFDD("Work Type", sValue);
    }
    private boolean setWorkSubtype(String sValue) {
        return selectValueFromFDD("Work Subtype", sValue);
    }
    private boolean setBU(String sValue) {
        return selectValueFromFDD("Business Unit", sValue);
    }
    private boolean setInactive(boolean bValue) {
        boolean bReturn = false;
        if (bValue) {
            WebElement field = WebElementUtils.findElement(B2WCrewTemplates.getInactiveCheckbox());
            if (field != null) {
                bReturn = WebElementUtils.clickElement(field);
            }
            return bReturn;
        } else {
            return true;
        }
    }
    private boolean setCrewNotes(String sValue) {
        boolean bReturn = false;
        WebElement field = WebElementUtils.findElement(B2WCrewTemplates.getNotesField());
        if (field != null) {
            field.clear();
            bReturn = WebElementUtils.sendKeys(field, sValue);
        }
        return bReturn;
    }
    private boolean setProductionForeman(String sValue) {
        boolean bReturn;

        bReturn = selectSearchType("Employees with Foreman Role");
        bReturn &= setSearchValue(sValue);

        List<WebElement> list = WebElementUtils.findElements(B2WCrewTemplates.getSearchResults());
        WebElement result = WebElementUtils.getElementWithContainsChildElementText(list, By.cssSelector("td"), sValue);
        WebElement parent = WebElementUtils.findElement(B2WCrewTemplates.getResourceTree());
        if (parent != null && result != null) {
            WebElement child = WebElementUtils.getChildElement(parent, By.cssSelector("em"));
            bReturn &= dragAndDropWithMouse(result, child, getyOffset());
        }
        return bReturn;
    }
    private boolean setTransportDriver(String sValue) {
        boolean bReturn;

        bReturn = logCompare(true, selectSearchType("Employees with Driver Role"), "Select search Type 'Employees with Driver Role'");
        bReturn &= logCompare(true, setSearchValue(sValue), "Set search value:" + sValue);

        List<WebElement> list = WebElementUtils.findElements(B2WCrewTemplates.getSearchResults());
        WebElement result = WebElementUtils.getElementWithContainsChildElementText(list, By.cssSelector("td"), sValue);
        WebElement parent = WebElementUtils.findElement(B2WCrewTemplates.getResourceTree());
        if (parent != null && result != null) {
            WebElement child = WebElementUtils.getChildElement(parent, By.cssSelector("em"));
            bReturn &= logCompare(true, dragAndDropWithMouse(result, child, getyOffset()), "Move element to position");
        } else {
            log.warn("Some elements were not found on the page.");
        }
        return bReturn;
    }
    private boolean setSearchValue(String sValue) {
        boolean bReturn = false;
        WebElement searchField = WebElementUtils.findElement(B2WCrewTemplates.getSearchValueField());
        if (searchField != null) {
            searchField.clear();
            bReturn = WebElementUtils.sendKeys(searchField, sValue);
        }
        return bReturn;
    }
    private boolean setSearchCrewTemplateName(String sValue) {
        boolean bReturn = false;
        WebElement searchField = WebElementUtils.waitAndFindDisplayedElement(B2WCrewTemplates.getCrewTemplateSearchField());
        if (searchField != null) {
            searchField.clear();
            bReturn = WebElementUtils.sendKeys(searchField, sValue);
        }
        return bReturn;
    }

    // Add Methods
    private boolean addEmployeeToCrew(ArrayList<String> employees) {
        boolean bReturn;
        bReturn = selectSearchType("Employees by Type");
        bReturn &= addItemsToCrew(employees);
        return bReturn;
    }
    private boolean addEquipmentToCrew(ArrayList<String> equipment) {
        boolean bReturn;
        bReturn = selectSearchType("Equipment by Type");
        bReturn &= addItemsToCrew(equipment);
        return bReturn;
    }
    private boolean addLaborTypeToCrew(ArrayList<String> laborType) {
        boolean bReturn;
        bReturn = selectSearchType("Labor Type Need");
        bReturn &= addItemsToCrew(laborType);
        return bReturn;
    }
    private boolean addEquipmentTypeToCrew(ArrayList<String> equipmentType) {
        boolean bReturn;
        bReturn = selectSearchType("Equipment Type Need");
        bReturn &= addItemsToCrew(equipmentType);
        return bReturn;
    }
    private boolean addEquipmentThatMovesToCrew(ArrayList<String> equipmentType) {
        boolean bReturn;
        bReturn = selectSearchType("Equipment that Moves other Equipment");
        bReturn &= addItemsToCrew(equipmentType);
        return bReturn;
    }
    private boolean addItemsToCrew(ArrayList<String> aList) {
        boolean bReturn = true;
        if (aList.size() > 0) {
            for (String sItem : aList) {
                bReturn &= setSearchValue(sItem);
                List<WebElement> list = WebElementUtils.findElements(B2WCrewTemplates.getSearchResults());
                WebElement result = WebElementUtils.getElementWithContainsChildElementText(list, By.cssSelector("td"), sItem);
                WebElement parent = WebElementUtils.findElement(B2WCrewTemplates.getResourceTree());
                if (parent != null && result != null) {
                    bReturn &= dragAndDropWithMouse(result, parent, getyOffset());
                    bReturn &= isItemInCrew(sItem);
                }
            }
        }
        return bReturn;
    }

    // Verification Methods
    private boolean isItemInCrew(String sName) {
        boolean bReturn = false;
        WebElement parent = WebElementUtils.findElement(B2WCrewTemplates.getResourceTree());
        List<WebElement> list = WebElementUtils.getChildElements(parent, B2WCrewTemplates.getResourceTreeItems());
        for (WebElement item : list) {
            if (item.getText() != null) {
                if (item.getText().contains(sName)) return true;
            }
        }
        return bReturn;
    }

    // Click Methods
    private boolean clickSaveButton() {
        boolean bReturn = false;
        WebElement saveBtn = WebElementUtils.findElement(B2WCrewTemplates.getSaveBtn());
        if (saveBtn != null) {
            bReturn = WebElementUtils.clickElement(saveBtn);
            WebElementUtils.waitForElementInvisible(saveBtn);
            waitForSchedulesPageNoBusy();
        }
        return bReturn;
    }
    private boolean clickUpdateButton() {
        boolean bReturn = false;
        WebElement updateBtn = WebElementUtils.waitAndFindElement(B2WCrewTemplates.getUpdateBtn());
        if (updateBtn != null) {
            bReturn = WebElementUtils.clickElement(updateBtn);
            bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getSaveBtn()) != null;
        }
        return bReturn;
    }
    private boolean clickCopyButton() {
        boolean bReturn = false;
        WebElement copyBtn = WebElementUtils.waitAndFindElement(B2WCrewTemplates.getCopyBtn());
        if (copyBtn != null) {
            bReturn = WebElementUtils.clickElement(copyBtn);
            bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getSaveBtn()) != null;
        }
        return bReturn;
    }

    // Move Methods
    private boolean dragAndDropWithMouse(WebElement dragFrom, WebElement dragTo, int yOffset) {
        boolean bReturn = false;
        Robot robot;
        if (dragFrom == null || dragTo == null) {
            if (dragFrom == null) log.warn("The WebElement to be dragged was NULL.");
            if (dragTo == null) log.warn("The WebElement to be the target was NULL.");
        } else {

            try {
                robot = new Robot();

                // need a delay for DnD - fails otherwise
                robot.setAutoDelay(1500);

                // Get size of elements
                org.openqa.selenium.Dimension fromSize = dragFrom.getSize();
                org.openqa.selenium.Dimension toSize = dragTo.getSize();

                // Get centre distance
                int xCentreFrom = fromSize.width / 2;
                int yCentreFrom = fromSize.height / 2;
                int xCentreTo = toSize.width / 2;
                int yCentreTo = toSize.height / 2;

                // Get x and y of WebElement to drag to
                org.openqa.selenium.Point toLocation = dragTo.getLocation();
                org.openqa.selenium.Point fromLocation = dragFrom.getLocation();

                // Make Mouse coordinate centre of element
                toLocation.x += xCentreTo;
                toLocation.y += yCentreTo;
                fromLocation.x += xCentreFrom;
                fromLocation.y += yCentreFrom;

                log.debug("toLocation is: (" + toLocation.x + ", " + toLocation.y + ")");
                log.debug("fromLocation is: (" + fromLocation.x + ", " + fromLocation.y + ")");

                Point mousepoint = new Point(0, 0);
                mousepoint.x = MouseInfo.getPointerInfo().getLocation().x;
                mousepoint.y = MouseInfo.getPointerInfo().getLocation().y;
                log.debug("mouse location now is: (" + mousepoint.x + ", " + mousepoint.y + ")");

                log.debug("move mouse to: (" + fromLocation.x + ", " + (fromLocation.y + yOffset) + ")");
                // Move mouse to drag from location
                robot.mouseMove(fromLocation.x, fromLocation.y + yOffset);

                mousepoint.x = MouseInfo.getPointerInfo().getLocation().x;
                mousepoint.y = MouseInfo.getPointerInfo().getLocation().y;
                log.debug("mouse location now is: (" + mousepoint.x + ", " + mousepoint.y + ")");

                log.debug("press mouse");
                // Click and drag
                robot.mousePress(InputEvent.BUTTON1_MASK);

                log.debug("move mouse to: (" + (((toLocation.x - fromLocation.x) / 2) + fromLocation.x) + ", "
                        + (((toLocation.y - fromLocation.y) / 2) + fromLocation.y) + ")");
                // Drag events require more than one movement to register
                // Just appearing at destination doesn't work so move halfway first
                robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x, ((toLocation.y - fromLocation.y) / 2)
                        + fromLocation.y);

                mousepoint.x = MouseInfo.getPointerInfo().getLocation().x;
                mousepoint.y = MouseInfo.getPointerInfo().getLocation().y;
                log.debug("mouse location now is: (" + mousepoint.x + ", " + mousepoint.y + ")");

                log.debug("move mouse to: (" + toLocation.x + ", " + (toLocation.y + yOffset) + ")");
                // Move to final position
                robot.mouseMove(toLocation.x, toLocation.y + yOffset);

                mousepoint.x = MouseInfo.getPointerInfo().getLocation().x;
                mousepoint.y = MouseInfo.getPointerInfo().getLocation().y;
                log.debug("mouse location now is: (" + mousepoint.x + ", " + mousepoint.y + ")");

                log.debug("release mouse");
                // Drop
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                bReturn = true;
                // Set delay back to default
                robot.setAutoDelay(0);
            } catch (AWTException e) {
                log.debug("Exception thrown in Drag: " + e.getLocalizedMessage());
            }
        }
        return bReturn;
    }

    // Get Methods
    private WebElement getCrewTemplateFromList(String sName) {
        WebElement eResult = null;
        WebElement listPanel = WebElementUtils.findElement(B2WCrewTemplates.getCrewTemplatesListPanel());
        if (listPanel != null) {
            WebElement listTable = WebElementUtils.getChildElement(listPanel, B2WCrewTemplates.getCrewTemplatesListTable());
            if (listTable != null) {
                List<WebElement> crewTemplatesList = WebElementUtils.getChildElements(listTable, By.cssSelector("tr"));
                for (WebElement eItem : crewTemplatesList) {
                    WebElement td = WebElementUtils.getChildElements(eItem, By.cssSelector("td")).get(0);
                    if (td.getText() != null) {
                        if (td.getText().equals(sName)) return eItem;
                    }
                }
            }
        } else {
            log.warn("Resource Tree could not be found on the page.");
        }
        return eResult;
    }
    private int getCrewTemplateCountFromList() {
        int iResult = 0;
        WebElement listPanel = WebElementUtils.findElement(B2WCrewTemplates.getCrewTemplatesListPanel());
        if (listPanel != null) {
            WebElement listTable = WebElementUtils.getChildElement(listPanel, B2WCrewTemplates.getCrewTemplatesListTable());
            if (listTable != null) {
                List<WebElement> crewTemplatesList = WebElementUtils.getChildElements(listTable, By.cssSelector("tr"));
                return crewTemplatesList.size();
            }
        } else {
            log.warn("Resource Tree could not be found on the page.");
        }
        return iResult;
    }

    // Delete Methods
    private boolean deleteAllCrewMembers() {
        boolean bReturn = false;
        WebElement listPanel = WebElementUtils.findElement(B2WCrewTemplates.getResourceTree());
        if (listPanel != null) {
            List<WebElement> crewTemplatesList = WebElementUtils.getChildElements(listPanel, B2WCrewTemplates.getCrewTemplatesListDeleteIcons());
            bReturn = true;
            for (WebElement eItem : crewTemplatesList) {
                if (eItem != null && eItem.isDisplayed()) {
                    bReturn &= WebElementUtils.clickElement(eItem);
                    if (WebElementUtils.findElement(B2WCrewTemplates.getButtonByName("Yes")) != null) {
                        selectButtonOption("Yes");
                        deleteAllCrewMembers();
                        break;
                    }
                }
            }
        } else {
            log.warn("Crew Resource Tree could not be found on th epage.");
        }
        return bReturn;
    }


    // === Support Methods
    public boolean waitForSchedulesPageNoBusy() {
        return waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
    }
    private int evaluateYOffset() {
        int iResult;
        // Evaluate yOffset
        WebElement main = WebElementUtils.findElement(By.cssSelector("html"));
        int pageHeight = BrowserUtils.getDriver().manage().window().getSize().getHeight();
        int positionYOffset = BrowserUtils.getDriver().manage().window().getPosition().getY();
        iResult = (pageHeight + positionYOffset) - main.getSize().getHeight();
        log.debug("yOffset = " + iResult);
        //------------
        return iResult;
    }
}
