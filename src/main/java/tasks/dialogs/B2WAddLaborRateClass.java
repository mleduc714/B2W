package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.jobs.B2WJobs;
import tasks.WebElementUtils;

public class B2WAddLaborRateClass {
	
	public boolean selectItem(int i){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WLaborrateclassdialogpanel());
		if (el != null){
			
			List<WebElement> list = WebElementUtils.getChildElements(el, B2WJobs.getB2WLaborrateclassgridcheckbox());
			bReturn = WebElementUtils.clickElement(list.get(i));
			
		}
		return bReturn;
	}
	
	public boolean clickAdd() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WLaborrateclassdialogpanel());
		if (el != null) {

			WebElement button = WebElementUtils.getChildElement(el, B2WJobs.getB2WLaborrateclassesaddbutton());
			bReturn = WebElementUtils.clickElement(button);
			WebElementUtils.waitForElementInvisible(button);

		}
		return bReturn;
	}
	
	public boolean selectItem(String s){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WJobs.getB2WLaborrateclassgridview());
		if (el != null){
			List<WebElement> rows = WebElementUtils.getChildElements(el, By.tagName("tr"));
			// start at 1 to avoid header
			for (int i = 1; i < rows.size(); i++){
				WebElement row  = rows.get(i);
				WebElement checkbox = WebElementUtils.getChildElement(row, By.tagName("input"));
				String sText = WebElementUtils.getChildElements(row, By.tagName("td")).get(1).getText();
				if (s.equals(sText)){
					bReturn = WebElementUtils.clickElement(checkbox);
					break;
				}
			}
			
		}
		return bReturn;
	}

}
