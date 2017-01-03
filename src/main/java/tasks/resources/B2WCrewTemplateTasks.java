package tasks.resources;

import appobjects.resources.B2WCrewTemplates;
import appobjects.scheduler.B2WScheduleAssignments;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import tasks.WebElementUtils;

import java.util.ArrayList;
import java.util.List;

public class B2WCrewTemplateTasks extends B2WKendoTasks {

    Logger log = Logger.getLogger(B2WEquipmentTasks.class);
    private List<WebElement> list;

    public boolean selectAddCrewTemplate(B2WCrewTemplate.CrewType type) {
        boolean bReturn = false;

        WebElement menuItem = WebElementUtils.findElement(B2WCrewTemplates.getAddCrewTemplateButton());
        if (menuItem != null) {
            List<WebElement> list = WebElementUtils.findElements(B2WCrewTemplates.getCrewTypesList());
        }
        return bReturn;
    }
}
