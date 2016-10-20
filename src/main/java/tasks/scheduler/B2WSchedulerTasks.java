package tasks.scheduler;

import appobjects.B2WNavigationPanel;
import appobjects.scheduler.B2WScheduleAssignments;
import org.openqa.selenium.By;
import tasks.BrowserUtils;
import tasks.resources.B2WKendoTasks;
import tasks.WebElementUtils;
import org.openqa.selenium.WebElement;
import tasks.util.TaskUtils;

import java.util.List;

public class B2WSchedulerTasks extends B2WKendoTasks {

    public boolean waitForSchedulePageNoBusy() {
        return waitForPageNotBusy();
    }

    public boolean navigateToScheduleView(String sViewName, String sPanel) {
        boolean bReturn = false;
        //ToDo
        if (!new TaskUtils().waitForProductPanel(sPanel)) {
            WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getScheduleProductPageIcon());
            if (el != null) {
                if (WebElementUtils.clickElement(el)) {
                    WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleViewNavigateMenu(), 1);
                    WebElement panel = WebElementUtils.findElement(B2WScheduleAssignments.getScheduleViewNavigateMenu());
                    List<WebElement> items = panel.findElements(By.cssSelector("li"));
                    WebElement item = WebElementUtils.getElementWithMatchingText(items, sViewName, true);
                    if (item != null) {
                        item.click();
                        waitForSchedulePageNoBusy();
                        bReturn = new TaskUtils().waitForProductPanel(sPanel);
                    }
                }
            }
        } else bReturn = true;
        return bReturn;
    }
}
