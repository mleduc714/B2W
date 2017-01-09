package tasks.resources;

import appobjects.resources.B2WCrewTemplates;
import appobjects.resources.B2WEquipment;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import tasks.BrowserUtils;
import tasks.WebElementUtils;

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
    public boolean createProductionCrewTemplate(B2WCrewTemplate crewTemplate) {
        boolean bReturn;
        logCompare(true, true, "====== Start Crew Template Creation");
        bReturn = setName(crewTemplate.getName());
        bReturn &= setID(crewTemplate.getID());
        bReturn &= setWorkType(crewTemplate.getWorkType());
        bReturn &= setWorkSubtype(crewTemplate.getWorkSubType());
        bReturn &= setBU(crewTemplate.getBusinessUnit());
        bReturn &= setInactive(crewTemplate.isInactive());
        bReturn &= setCrewNotes(crewTemplate.getNotes());
        setYOffset();
        bReturn &= setProductionForeman(crewTemplate.getForeman());
        bReturn &= addEmployeeToCrew(crewTemplate.getEmployees());
        bReturn &= addEquipmentToCrew(crewTemplate.getEquipments());
        bReturn &= addLaborTypeToCrew(crewTemplate.getLaborTypes());
        bReturn &= addEquipmentTypeToCrew(crewTemplate.getEquipmentTypes());
        bReturn &= clickSave();
        bReturn &= getCrewTemplateFromList(crewTemplate.getName()) != null;
        logCompare(true, true, "====== Complete Crew Template Creation");
        return bReturn;
    }
    public boolean updateProductionCrewTemplate(B2WCrewTemplate crewTemplate, B2WCrewTemplate crewTemplateUpd) {
        boolean bReturn = false;
        logCompare(true, true, "====== Start Crew Template Update");
        if (selectCrewTemplate(crewTemplate)) {
            if (clickUpdate()) {
                bReturn = setName(crewTemplateUpd.getName());
                bReturn &= setID(crewTemplateUpd.getID());
                bReturn &= setWorkType(crewTemplateUpd.getWorkType());
                bReturn &= setWorkSubtype(crewTemplateUpd.getWorkSubType());
                bReturn &= setBU(crewTemplateUpd.getBusinessUnit());
                bReturn &= setInactive(crewTemplateUpd.isInactive());
                bReturn &= setCrewNotes(crewTemplateUpd.getNotes());
                setYOffset();
                bReturn &= deleteAllCrewMembers();
                bReturn &= setProductionForeman(crewTemplateUpd.getForeman());
                bReturn &= addEmployeeToCrew(crewTemplateUpd.getEmployees());
                bReturn &= addEquipmentToCrew(crewTemplateUpd.getEquipments());
                bReturn &= addLaborTypeToCrew(crewTemplateUpd.getLaborTypes());
                bReturn &= addEquipmentTypeToCrew(crewTemplateUpd.getEquipmentTypes());
                bReturn &= clickSave();
                bReturn &= getCrewTemplateFromList(crewTemplateUpd.getName()) != null;
            }
        }
        logCompare(true, true, "====== Complete Crew Template Update");
        return bReturn;
    }
    public boolean deleteCrew(B2WCrewTemplate crewTemplate) {
        boolean bReturn = false;
        if (selectCrewTemplate(crewTemplate)) {
            WebElement deleteBtn = WebElementUtils.waitAndFindElement(B2WCrewTemplates.getDeleteBtn());
            if (deleteBtn != null) {
                bReturn &= WebElementUtils.clickElement(deleteBtn);
                bReturn &= selectButtonOption("Yes");
                waitForSchedulesPageNoBusy();
                bReturn &= getCrewTemplateFromList(crewTemplate.getName()) == null;
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

    // Private Methods
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

    private boolean clickSave() {
        boolean bReturn = false;
        WebElement saveBtn = WebElementUtils.findElement(B2WCrewTemplates.getSaveBtn());
        if (saveBtn != null) {
            bReturn = WebElementUtils.clickElement(saveBtn);

            waitForSchedulesPageNoBusy();
        }
        return bReturn;
    }

    private boolean clickUpdate() {
        boolean bReturn = false;
        WebElement updateBtn = WebElementUtils.waitAndFindElement(B2WCrewTemplates.getUpdateBtn());
        if (updateBtn != null) {
            bReturn = WebElementUtils.clickElement(updateBtn);
            bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getSaveBtn()) != null;
        }
        return bReturn;
    }

    private boolean selectSearchType(String searchValue) {
        //WebElement searchFDD = WebElementUtils.findElement(B2WCrewTemplates.getSearchTypesFDD(searchType));
        WebElement searchFDD = WebElementUtils.getKendoFDDElementByTag("Crew Details", "h4");
        return selectValueFromFDD(searchFDD, searchValue);
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

    private boolean selectCrewTemplate(B2WCrewTemplate crewTemplate) {
        boolean bReturn = false;
        WebElement eCrewTemplate = getCrewTemplateFromList(crewTemplate.getName());
        if (eCrewTemplate != null) {
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
        if (WebElementUtils.waitAndFindDisplayedElement(B2WEquipment.getKendoPageLoading())!= null) {
            return waitForPageNotBusy(WebElementUtils.LONG_TIME_OUT);
        } else {
            return true;
        }

    }
}
