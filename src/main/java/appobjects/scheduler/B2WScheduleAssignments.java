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
    public static By getSelectCrewBtn() { return By.cssSelector(B2WUIMap.b2w_scheduleselectcrewbtn); }
    public static By getSaveAssignmentBtn() { return By.cssSelector(B2WUIMap.b2w_schedule_savebtn); }
    public static By getLinksContainer() { return By.cssSelector(B2WUIMap.b2w_scheduleanimationcontainer); }
    public static By getLinks() { return By.cssSelector(B2WUIMap.b2w_schedulelinks); }
    public static By getEventTypeDropDown() { return By.xpath(B2WUIMap.b2w_scheduleeventtypedropdown); }
    public static By getAllSelectedItemsFromAllFDD() { return By.cssSelector(B2WUIMap.b2w_scheduleselecteditemsfromfdd); }
    public static By getSelectedDatesOnCalendar() { return By.cssSelector(B2WUIMap.b2w_scheduleselecteddates); }
    public static By getAssignments() { return By.cssSelector(B2WUIMap.b2w_scheduleassignments); }
    public static By getNotesField() { return By.cssSelector(B2WUIMap.b2w_schedulenotesfield);}
    public static By getClockBtn() { return By.cssSelector(B2WUIMap.b2w_scheduleclockbtn);}
    public static By getCalendarActiveDateRange() { return By.cssSelector(B2WUIMap.b2w_schedulecalendaractiverange); }
    public static By getCalendarStartDate() { return By.cssSelector(B2WUIMap.b2w_schedulecalendastartdate); }
    public static By getSearchBox() { return By.cssSelector(B2WUIMap.b2w_schedule_search); }
    public static By getGrid() { return By.cssSelector(B2WUIMap.b2w_schedule_grid); }
    public static By getAssignment() { return By.cssSelector(B2WUIMap.b2w_schedule_assignment); }
    public static By getResourceName() { return By.cssSelector(B2WUIMap.b2w_schedule_resourcename); }
    public static By getSpecificResourceName(String sValue) {
        if (sValue.contains("\\")) {sValue = sValue.replace("\\", "\\\\");}
        return By.cssSelector(B2WUIMap.b2w_schedule_resourcename + "[title='" + sValue + "']");
    }
    public static By getAddressSection() { return By.cssSelector(B2WUIMap.b2w_schedule_addresssection); }
    public static By getContextMenu() { return By.cssSelector(B2WUIMap.b2w_schedule_contextmenu); }
    public static By getDeleteOptionBtn(String sValue) { return By.xpath(B2WUIMap.b2w_schedule_contextmenu_deletebuttons + "[contains(text(), '" + sValue + "')]"); }
    public static By getDeleteEmployeeBtn() { return By.xpath(B2WUIMap.b2w_schedule_deleteemployeebtn); }
    public static By getEditLocationLink() { return By.xpath(B2WUIMap.b2w_schedule_editlocationlink); }
    public static By getPlaceholders() { return By.cssSelector(B2WUIMap.b2w_schedule_placeholder); }
    public static By getToolBarPanel() { return By.cssSelector(B2WUIMap.b2w_schedule_toolbarpanel); }
    public static By getExpandIcon() { return By.cssSelector(B2WUIMap.b2w_scheduled_expandicon); }
    public static By getCollapseIcon() { return By.cssSelector(B2WUIMap.b2w_scheduled_collapseicon); }
    public static By getAssignmentRightEdge() { return By.cssSelector(B2WUIMap.b2w_schedule_assignmentrightedge); }
    public static By getAssignmentLeftEdge() { return By.cssSelector(B2WUIMap.b2w_schedule_assignmentleftedge); }
    public static By getResourceWarningIcon() { return By.cssSelector(B2WUIMap.b2w_schedule_resourcewarningicon); }
    public static By getTooltip() { return By.cssSelector(B2WUIMap.b2w_schedule_tooltip); }
    public static By getConflictButton() { return By.cssSelector(B2WUIMap.b2w_schedule_conflictbutton); }
    public static By getConflictsPanel() { return By.cssSelector(B2WUIMap.b2w_schedule_conflictspanel); }
    public static By getConflictFromPanel() { return By.cssSelector(B2WUIMap.b2w_schedule_conflicblock); }
    public static By getFillNeedToolbar() { return By.cssSelector(B2WUIMap.b2w_schedule_conflictoolbar); }
    public static By getFirstResourceNameInList() { return By.xpath(B2WUIMap.b2w_schedule_firstitem); }
    public static By getCheckedBtn() { return By.cssSelector(B2WUIMap.b2w_schedule_checkedbtn); }
}
