package appobjects.resources;

import appobjects.B2WUIMap;
import org.openqa.selenium.By;

public class B2WCrewTemplates {
    public static By getAddCrewTemplateButton() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_addbtn); }
    public static By getCrewTypesList() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_crewtypeslist); }
    public static By getCrewHeadline() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_headline); }
    public static By getNameField() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_name); }
    public static By getIDField() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_id); }
    public static By getInactiveCheckbox() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_inactive); }
    public static By getNotesField() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_notes); }
    public static By getSearchValueField() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_searchvalue); }
    public static By getSearchResults() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_searchresults); }
    public static By getResourceTree() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_resourcetree); }
    public static By getResourceTreeItems() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_resourcetreeitems); }
    public static By getSaveBtn() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_savebtn); }
    public static By getDeleteBtn() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_deletebtn); }
    public static By getUpdateBtn() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_updatebtn); }
    public static By getCopyBtn() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_copybtn); }
    public static By getCrewTemplatesListPanel() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_listpanel); }
    public static By getCrewTemplatesListTable() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_listtable); }
    public static By getCrewTemplatesListDeleteIcons() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_resourcedeleteicons); }
    public static By getButtonByName(String sValue) { return By.xpath(B2WUIMap.b2w_crewtemplates_button + "[contains(text(), '" + sValue + "')]"); }
    public static By getPopupWindow() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_popupwindow); }
    public static By getTransportFunction(String sValue) { return By.cssSelector(B2WUIMap.b2w_crewtemplates_transportfunction + "[value='" + sValue + "']"); }
    public static By getCrewTemplateSearchField() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_searchfield); }
    public static By getDeleteCrewTemplateSearch() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_deletesearchfield); }
}
