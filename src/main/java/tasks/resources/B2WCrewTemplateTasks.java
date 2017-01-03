package tasks.resources;

import appobjects.resources.B2WCrewTemplates;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import tasks.WebElementUtils;

import java.util.ArrayList;
import java.util.List;

import static com.b2w.test.BaseAssert.logCompare;

public class B2WCrewTemplateTasks extends B2WKendoTasks {

    Logger log = Logger.getLogger(B2WEquipmentTasks.class);
    private List<WebElement> list;

    // Public Methods
    public boolean selectAddCrewTemplate(B2WCrewTemplate.CrewType type) {
        boolean bReturn = false;

        WebElement menuItem = WebElementUtils.findElement(B2WCrewTemplates.getAddCrewTemplateButton());
        if (menuItem != null) {
            List<WebElement> list = WebElementUtils.findElements(B2WCrewTemplates.getCrewTypesList());
            for (WebElement item: list) {
                if (type.equals(B2WCrewTemplate.CrewType.valueOf(item.getText()))) {
                    bReturn = WebElementUtils.clickElement(item);
                    bReturn &= WebElementUtils.waitAndFindElement(B2WCrewTemplates.getCrewHeadline()) != null;
                }
            }
        }
        return bReturn;
    }
    public boolean createCrewTemplate(B2WCrewTemplate crewTemplate) {
        boolean bReturn = false;
        logCompare(true, true, "====== Start Crew Template Creation");
        bReturn = setName(crewTemplate.getName());
        logCompare(true, true, "====== Complete Crew Template Creation");
        return bReturn;
    }

    // Private Methods
    private boolean setName(String sValue) {
        boolean bReturn = false;
        WebElement field = WebElementUtils.findElement(B2WCrewTemplates.getNameField());
        return bReturn;
    }
}
