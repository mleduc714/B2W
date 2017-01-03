package appobjects.resources;

import appobjects.B2WUIMap;
import org.openqa.selenium.By;

public class B2WCrewTemplates {
    public static By getAddCrewTemplateButton() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_addbtn); }
    public static By getCrewTypesList() { return By.cssSelector(B2WUIMap.b2w_crewtemplates_crewtypeslist); }
    public static By getCrewHeadline() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_headline); }
    public static By getNameField() { return By.cssSelector(B2WUIMap.getB2w_crewtemplates_name); }

}
