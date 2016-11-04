package appobjects.setup;

import appobjects.B2WUIMap;
import org.openqa.selenium.By;

public class B2WSchedules {
    public static By rightPanel() { return By.cssSelector(B2WUIMap.b2w_schedules_panel); }
    public static By createScheduleViewBtn() { return By.cssSelector(B2WUIMap.b2w_schedules_createscheduleviewbtn); }
    public static By editScheduleViewBtn() { return By.cssSelector(B2WUIMap.b2w_schedules_editscheduleviewbtn); }
    public static By headline() { return By.cssSelector(B2WUIMap.b2w_schedules_headline); }
    public static By nameField() { return By.cssSelector(B2WUIMap.b2w_schedules_name); }
    public static By notes() { return By.cssSelector(B2WUIMap.b2w_schedules_notes); }
    public static By scheduleFormat() { return By.cssSelector(B2WUIMap.b2w_schedules_scheduleformat); }
    public static By scheduleFormatItem(String sValue) { return By.cssSelector(B2WUIMap.b2w_schedules_scheduleformat + "[value='" + sValue + "']"); }
    public static By scheduleCheckBox(String sValue) { return By.cssSelector(B2WUIMap.b2w_schedules_input + "[name='" + sValue + "']"); }
    public static By scheduleResourceBtn(String sValue) { return By.cssSelector(B2WUIMap.b2w_schedules_input + "[value='" + sValue + "']"); }

    //ToDo Remove All unnecessary methods
    public static By groupItemsBy() { return By.cssSelector(B2WUIMap.b2w_schedules_groupitemsby); }
    public static By secondaryGrouping() { return By.cssSelector(B2WUIMap.b2w_schedules_secondarygrouping); }
    public static By saveBtn() { return By.cssSelector(B2WUIMap.b2w_schedules_savebtn); }
    public static By schedulesRowOnGrid(String sValue) { return By.cssSelector(B2WUIMap.b2w_schedules_rowongrid + "[title='" + sValue + "']"); }
    public static By addFilterDropDown() { return By.cssSelector(B2WUIMap.b2w_schedules_addfilter); }
    public static By filterItemLabel() { return By.cssSelector(B2WUIMap.b2w_schedules_filterlabel); }
    public static By deleteBtn() { return By.cssSelector(B2WUIMap.b2w_schedules_deletebtn); }
    public static By deletePopUpWindow() { return By.cssSelector(B2WUIMap.b2w_schedules_deletepopupwindow); }
    public static By yesBtnOnPopupWindow() { return By.cssSelector(B2WUIMap.b2w_schedules_popupwindow_yesbtn); }
}
