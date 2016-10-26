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
    public static By getControlPanel() { return By.cssSelector(B2WUIMap.b2w_schedulecontrolpanel); }
    public static By getSelectCrewBtn() { return By.cssSelector(B2WUIMap.b2w_scheduleselectcrewbtn); }
    public static By getButtonContainer() { return By.cssSelector(B2WUIMap.b2w_schedulebuttoncontainer); }
    public static By getCreateAssignmentBtn() { return By.xpath(B2WUIMap.b2w_schedulecreateassignmentbtn); }
    public static By getCreateMoveOrderBtn() { return By.xpath(B2WUIMap.b2w_schedulecreatemoveorderbtn); }
    public static By getLinksContainer() { return By.cssSelector(B2WUIMap.b2w_scheduleanimationcontainer); }
    public static By getLinks() { return By.cssSelector(B2WUIMap.b2w_schedulelinks); }
    public static By getEventTypeDropDown() { return By.xpath(B2WUIMap.b2w_scheduleeventtypedropdown); }
}
