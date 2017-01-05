package tasks.resources;

import appobjects.resources.B2WCrewTemplates;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import tasks.BrowserUtils;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;

import static com.b2w.test.BaseAssert.logCompare;

public class B2WCrewTemplateTasks extends B2WKendoTasks {

    Logger log = Logger.getLogger(B2WEquipmentTasks.class);

    // Public Methods
    public boolean selectAddCrewTemplate(String type) {
        boolean bReturn = false;

        WebElement menuItem = WebElementUtils.findElement(B2WCrewTemplates.getAddCrewTemplateButton());
        if (menuItem != null) {
            bReturn = WebElementUtils.clickElement(menuItem);
            List<WebElement> list = WebElementUtils.waitAndFindDisplayedElements(B2WCrewTemplates.getCrewTypesList());
            for (WebElement item: list) {
                if (item.getText().equals(type)) {
                    bReturn = WebElementUtils.clickElement(item);
                    bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getCrewHeadline()) != null;
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
        bReturn &= setProductionForeman(crewTemplate.getForeman());
        logCompare(true, true, "====== Complete Crew Template Creation");
        return bReturn;
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
            bReturn = WebElementUtils.sendKeys(field, sValue);
        }
        return bReturn;
    }
    private boolean setID(String sValue) {
        boolean bReturn = false;
        WebElement field = WebElementUtils.findElement(B2WCrewTemplates.getIDField());
        if (field != null) {
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
        //WebElement item = WebElementUtils.findElement(B2WCrewTemplates.getForemanField());
        WebElement parent = WebElementUtils.findElement(B2WCrewTemplates.getResourceTree());
        WebElement child = WebElementUtils.getChildElement(parent, By.cssSelector("em"));
        if (parent != null) {
            try {
                Robot robot = new Robot();
                WebElementUtils.moveVirtualMouseOverElement(result);
                TaskUtils.sleep(500);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(child.getLocation().x + child.getSize().width / 2, child.getLocation().y + child.getSize().height / 2);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                new Actions(BrowserUtils.getDriver()).clickAndHold(result).moveToElement(child).pause(2000).release().build().perform();

            } catch (AWTException e) {
                e.printStackTrace();
            }

        }
        return bReturn;
    }
    private boolean selectSearchType(String sValue) {
        WebElement searchFDD = WebElementUtils.findElement(B2WCrewTemplates.getSearchTypesFDD());
        return selectValueFromFDD(searchFDD, sValue);
    }
    private boolean setSearchValue(String sValue) {
        boolean bReturn = false;
        WebElement searchField = WebElementUtils.findElement(B2WCrewTemplates.getSearchValueField());
        if (searchField != null) {
            bReturn = WebElementUtils.sendKeys(searchField, sValue);
        }
        return bReturn;
    }

}
