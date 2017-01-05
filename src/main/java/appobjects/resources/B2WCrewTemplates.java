package appobjects.resources;

import appobjects.B2WUIMap;
import org.openqa.selenium.By;

public class B2WCrewTemplates {
    public static By getAddCrewTemplateButton() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_addbtn); }
    public static By getCrewTypesList() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_crewtypeslist); }
    public static By getCrewHeadline() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_headline); }
    public static By getNameField() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_name); }
    public static By getIDField() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_id); }
    public static By getInactiveCheckbox() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_inactive); }
    public static By getNotesField() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_notes); }
    public static By getForemanField() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_foreman); }
    public static By getSearchTypesFDD() { return By.xpath(B2WUIMap.getB2w_crewtemplates_searchtypes); }
    public static By getSearchValueField() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_searchvalue); }
    public static By getSearchResults() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_searchresults); }
    public static By getResourceTree() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_resourcetree); }

}
