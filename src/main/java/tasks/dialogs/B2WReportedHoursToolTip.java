package tasks.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tasks.WebElementUtils;

public class B2WReportedHoursToolTip extends B2WKendoDialog {
	

	private WebElement getReportedHoursPopup() {
		WebElement tooltip = null;

		tooltip = WebElementUtils.getVisibleElementFromListofElements(WebElementUtils.findElements(By.className("reportedhours-tooltip")));
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
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}
	
	public String getEquipmentLinkText(){
		String s = "";
		WebElement el = getReportedHoursPopup();
		if (el != null){
			s = WebElementUtils.getChildElements(el, By.tagName("a")).get(0).getText();
		}
		return s;
	}
	
	public boolean clickOnWorkOrder() {
		boolean bReturn = false;
		WebElement el = getReportedHoursPopup();
		if (el != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElements(el, By.tagName("a")).get(1));
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	}

}
