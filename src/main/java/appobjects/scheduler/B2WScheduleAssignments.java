package appobjects.scheduler;


import appobjects.B2WUIMap;
import appobjects.resources.KendoUI;
import org.openqa.selenium.By;

public class B2WScheduleAssignments extends KendoUI {

    public static By getScheduleCenterPanel() {
        return By.cssSelector(B2WUIMap.b2w_schedulecenterpanel);
    }
    public static By getScheduleProductPageIcon() {
        return By.cssSelector(B2WUIMap.b2w_scheduleproductpageicon);
    }
    public static By getScheduleViewNavigateMenu() { return By.cssSelector(B2WUIMap.b2w_scheduleviewnavigatemenu); }
    public static By getCreationSection() { return By.cssSelector(B2WUIMap.b2w_schedulecreationsection); }
    public static By getAssignmentWindow() { return By.cssSelector(B2WUIMap.b2w_scheduleassignmentwindow); }
    public static By getFieldLabel() { return By.cssSelector(B2WUIMap.b2w_schedulefieldslabel); }
    public static By getAddToScheduleBtn() { return By.cssSelector(B2WUIMap.b2w_scheduleaddtoschedulebtn); }
}
