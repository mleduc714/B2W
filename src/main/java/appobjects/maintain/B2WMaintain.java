package appobjects.maintain;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WMaintain {
	

	 public static By getB2WMaintainGrid(){
		    return By.cssSelector(B2WUIMap.b2w_maintain_grid_content);
	 }


}
