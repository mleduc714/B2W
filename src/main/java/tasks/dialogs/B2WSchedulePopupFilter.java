package tasks.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WSchedulePopupFilter extends B2WKendoDialog {
	
	public boolean selectItemFromSchedulerFilter(String sFilterType, String sFilterItem) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainDashboardFiltersDialog());
		if (el != null) {
			TaskUtils.sleep(500);
			WebElement dropdown = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDropDown());
			if (WebElementUtils.clickElement(dropdown)) {
				bReturn = selectItemFromDropDown(sFilterType);
				TaskUtils.sleep(2000);
				dropdown = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDropDown());
				WebElementUtils.clickElement(dropdown);
				TaskUtils.sleep(500);
				bReturn = selectItemFromDropDown(sFilterItem);
				WebElement button = WebElementUtils.getChildElement(el,
						B2WMaintain.getB2WMaintainDashboardFiltersApply());
				if (button != null) {
					bReturn = WebElementUtils.clickElement(button);
					WebElementUtils.waitForElementInvisible(button);
				}
			}
		}

		return bReturn;
	}
	
	public boolean removeFilter() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardFiltersDialog());
		if (el != null){
			WebElement filter = WebElementUtils.getChildElement(el,By.linkText("Remove filter"));
			bReturn = WebElementUtils.clickElement(filter);
			WebElement button = WebElementUtils.getChildElement(el,B2WMaintain.getB2WMaintainDashboardFiltersApply());
			if (button != null){
				bReturn = WebElementUtils.clickElement(button);
				WebElementUtils.waitForElementInvisible(button);
			}
		}
		return bReturn;
	}
	
	
}
