package tasks.jobs;

import org.openqa.selenium.WebElement;

import appobjects.B2WCommonObjects;
import tasks.WebElementUtils;

public class B2WJobsTasks {
	
	/**
	 * Wait for jobs page be visible
	 * checks for the grid displayed
	 * @return
	 */
	public boolean jobsPageOpen() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPageContentGrid(), 30);
		if (el!=null) {
			bReturn = el.isDisplayed();
		}
		return bReturn;
		
	}

}
