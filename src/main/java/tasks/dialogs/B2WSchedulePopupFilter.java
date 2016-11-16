package tasks.dialogs;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WSchedulePopupFilter extends B2WKendoDialog {
	
	public boolean selectItemFromSchedulerFilter(String sFilterType, String sFilterItem ){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getB2WMaintainDashboardFiltersDialog());
		WebElement dropdown = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDropDown());
		if (WebElementUtils.clickElement(dropdown)){
			bReturn = selectItemFromDropDown(sFilterType);
			dropdown = WebElementUtils.getChildElement(el, B2WMaintain.getKendoDropDown());
			if (WebElementUtils.clickElement(dropdown)){
				TaskUtils.sleep(500);
				bReturn = selectItemFromDropDown(sFilterItem);
				TaskUtils.sleep(500);
				WebElement button = WebElementUtils.getChildElement(el,B2WMaintain.getB2WMaintainDashboardFiltersApply());
				if (button != null){
					bReturn = WebElementUtils.clickElement(button);
				}
			}
		}
		return bReturn;
	}

}
