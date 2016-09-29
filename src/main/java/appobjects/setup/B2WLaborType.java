package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WLaborType {
	
		public static By getLaborName() {
			return By.cssSelector(B2WUIMap.b2w_generalinfoname);
		}
		public static By getLaborID() {
			return By.cssSelector(B2WUIMap.b2w_labortypeid);
		}
		public static By getCreateLabelTypeButton() {
			return By.cssSelector(B2WUIMap.b2w_createnewlabortype);
		}
		
}
