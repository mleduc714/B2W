package tasks.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tasks.WebElementUtils;

public class B2WReportedHoursToolTip {
	

	private WebElement getReportedHoursPopup() {
		WebElement tooltip = null;
		tooltip = WebElementUtils.waitAndFindDisplayedElement(By.className("reportedhours-tooltip"));
		return tooltip;
			
	}
	
	public String getLaborTypeAndLaborRateClassText() {
		String s = "";
		WebElement el = getReportedHoursPopup();
		if (el != null){
			s = WebElementUtils.getChildElements(el, By.tagName("div")).get(0).getText();
			
		}
		return s;
	}
	
	public String getTitle() {
		String s = "";
		WebElement el = getReportedHoursPopup();
		if (el != null){
			s = WebElementUtils.getChildElement(el, By.className("title")).getText();
		}
	
		return s;
	}
	
	public String getSectionTitle() {
		String s = "";
		WebElement el = getReportedHoursPopup();
		if (el != null){
			s = WebElementUtils.getChildElement(el, By.className("section-title")).getText();
		}
	
		return s;
	}
	public String getChargeToText() {
		String s = "";
		WebElement el = getReportedHoursPopup();
		if (el != null){
			s = WebElementUtils.getChildElements(el, By.tagName("div")).get(1).getText();
			
		}
		return s;
	}
	
	public boolean clickOnEquipment() {
		boolean bReturn = false;
		WebElement el = getReportedHoursPopup();
		if (el != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElements(el, By.tagName("a")).get(0));
		}
		return bReturn;
	}
	
	public boolean clickOnWorkOrder() {
		boolean bReturn = false;
		WebElement el = getReportedHoursPopup();
		if (el != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElements(el, By.tagName("a")).get(1));
		}
		return bReturn;
	}

}
