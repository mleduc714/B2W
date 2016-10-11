package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WLaborType extends B2WResources
{
	
		public static By getLaborName() {
			return By.cssSelector(B2WUIMap.b2w_generalinfoname);
		}
		public static By getLaborID() {
			return By.cssSelector(B2WUIMap.b2w_labortypeid);
		}
		public static By getCreateLabelTypeButton() {
			return By.cssSelector(B2WUIMap.b2w_createnewlabortype);
		}
		
		public static By getLaborTypeViewGridName() {
			return By.cssSelector(B2WUIMap.b2w_categories_listview);
		}
		public static By getLaborTypeViewGridID() {
			return By.cssSelector(B2WUIMap.b2w_labortypegridid);
		}
	
}
			
	
