package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;
import tasks.resources.B2WResourceTasks;

public class B2WLaborRateClasses extends B2WResourceTasks {
	
	public static By getCreateNewLaborRateClassButton() {
		return By.cssSelector(B2WUIMap.b2w_createnewlaborrateclass);
	}
	public static By getLaborRateName() {
		return B2WLaborType.getLaborName();
	}
	public static By getLaborRateID() {
		return By.cssSelector(B2WUIMap.b2w_newlaborrateid);
	}
	

}
