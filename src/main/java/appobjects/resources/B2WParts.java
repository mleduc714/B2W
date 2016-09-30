package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WParts {
	
	public static By getCreateNewPartButton() {
		return By.cssSelector(B2WUIMap.b2w_createnewpart);
	}
	public static By getPartID() {
		return By.cssSelector(B2WUIMap.b2w_partidtext);
	}
	public static By getPartAltID() {
		return By.cssSelector(B2WUIMap.b2w_partaltidtext);
	}
	public static By getPartDescription() {
		return By.cssSelector(B2WUIMap.b2w_partdescription);
	}
	public static By getPartManufacturer() {
		return By.cssSelector(B2WUIMap.b2w_partmanufacturer);
	}
	
	
}
