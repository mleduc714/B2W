package appobjects.scheduler;


import appobjects.B2WUIMap;
import appobjects.resources.B2WResources;
import org.openqa.selenium.By;

public class B2WScheduleAssignments extends B2WResources {

    public static By getScheduleCenterPanel() {
        return By.cssSelector(B2WUIMap.b2w_schedulecenterpanel);
    }
    public static By getScheduleProductPageIcon() {
        return By.cssSelector(B2WUIMap.b2w_scheduleproductpageicon);
    }
    public static By getScheduleViewNavigateMenu() { return By.cssSelector(B2WUIMap.b2w_scheduleviewnavigatemenu); }
}
