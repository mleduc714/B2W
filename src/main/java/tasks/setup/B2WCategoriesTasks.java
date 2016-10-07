package tasks.setup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WCategories;
import tasks.B2WSetupTasks;
import tasks.WebElementUtils;

public class B2WCategoriesTasks extends B2WSetupTasks {

	String BRAKETYPE = "Brake Type";
	String CCACLASS = "CCA Class";
	String CHANGEORDERSTATUS = "Change Order Status";
	String CHANGEORDERTYPE = "Change Order Type";
	String CUTTINGEDGE = "Cutting Edge";
	String EMPLOYEEASSIGNMENTSTATUS = "Employee Assignment Status";
	String EMPLOYEECERTIFICATION = "Employee Certification";
	String EMPLOYEEEVENT = "Employee Event";
	String EMPLOYEEINACTIVEREASON = "Employee Inactive Reason";
	String EQUIPMENTASSIGNMENTSTATUS = "Employee Assignment Status";
	String EQUIPMENTCATEGORY = "Employee Category";
	String EQUIPMENTEVENT = "Equipment Event";
	String EQUIPMENTTAG = "Equipment Tag";
	String FUELTYPE = "Fuel Type";
	String HYDRAULICPUMPTYPE = "Hydraulic Pump Type";
	String JOBSITECATEGORY = "Job Site Category";
	String JOBSTATUS = "Job Status";
	String LOCATIONEVENT = "Location Event";
	String MAINTENANCEREQUESTPRIORITY = "Maintenance Request Priority";
	String MAINTENANCEREQUESTTYPE = "Maintenance Request Type";
	String MATERIALCATEGORY = "Material Category";
	String MISCELLANEOUSCATEGORY = "Miscellaneous Category";
	String METERCATEGORY = "Meter Category";
	String PARTCATEGORY = "Part Category";
	String REPORTCATEGORY = "Report Category";
	String TRACKTYPE = "Track Type";
	String WHEELTYPE = "Wheel Type";
	String WORKORDERPRIORITY = "Work Order Priority";
	String WORKTYPE = "Work Type";
	
	String PREVENTATIVE = "Preventative";
	String PLANNED = "Planned";
	String UNPLANNED = "Unplanned";
	
	public boolean selectCategoryFromDropDown(String sText) {
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WCategories.getCategoryDropDownList(), sText);
		return sText.equals(WebElementUtils.getSelectedTextFromDropDown(B2WCategories.getCategoryDropDownList()));
	}
	
	public boolean selectRequestClassificiationTypePreventive() {
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WCategories.getRequestClarificationType(), PREVENTATIVE);
		return WebElementUtils.getSelectedTextFromDropDown(B2WCategories.getRequestClarificationType()).equals(PREVENTATIVE);
	}
	public boolean selectRequestClassificiationTypePlanned() {
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WCategories.getRequestClarificationType(), PLANNED);
		return WebElementUtils.getSelectedTextFromDropDown(B2WCategories.getRequestClarificationType()).equals(PLANNED);
	}
	public boolean selectRequestClassificiationTypeUnplanned() {
		WebElementUtils.selectItemFromOpsDropDownMenu(B2WCategories.getRequestClarificationType(), UNPLANNED);
		return WebElementUtils.getSelectedTextFromDropDown(B2WCategories.getRequestClarificationType()).equals(UNPLANNED);
	}

	public boolean clickCreateNewCategory() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WCategories.getCategoryCreateNewButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WCategories.getCategoryName()) != null;
		}
		return bReturn;
	}
	
	public boolean getNameFromCategoryView(String sName) {
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(B2WCategories.getCatgoriesGridViewName());
		if (!list.isEmpty()){
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sName, false);
			if (el!=null){
				bReturn = true;
			}
		}
		return bReturn;
	}
	
	public boolean openNameFromCategoryView(String sName){
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(B2WCategories.getCatgoriesGridViewName());
		if (!list.isEmpty()){
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sName, false);
			if (el!=null){
				if (WebElementUtils.clickElement(el)){
					bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WCategories.getCategoryNameText()) != null;
				}
			}
		}
		return bReturn;
	} 
	
	public boolean isCategoryInListing(String sName){
		boolean bReturn = false;
		List<WebElement> list = WebElementUtils.findElements(B2WCategories.getCatgoriesGridViewName());
		if (!list.isEmpty()){
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sName, false);
			if (el!=null){
				bReturn = true;
				}
			}
		return bReturn;
	}
		
	public boolean setCategoryName(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WCategories.getCategoryName());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean setCategoryAssociatedColor(String sColor){

		boolean bReturn = false;
		WebElementUtils.clickElement(B2WCategories.getCategoryColorDropDown());
		WebElement el = WebElementUtils.findElement(B2WCategories.getCategoryAssociatedColor());
		List<WebElement> els = el.findElements(By.cssSelector("td.NameColumn"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sColor, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;

	}
	
	
	public boolean selectBreakType() {
		return selectCategoryFromDropDown(BRAKETYPE);
	}
	public boolean selectPartCategory() {
		return selectCategoryFromDropDown(PARTCATEGORY);
	}
	public boolean selectMeterCategory() {
		return selectCategoryFromDropDown(METERCATEGORY);
	}
	public boolean selectMaintenanceRequestType() {
		return selectCategoryFromDropDown(MAINTENANCEREQUESTTYPE);
	}
	public boolean selectMaintenanceRequestPriority() {
		return selectCategoryFromDropDown(MAINTENANCEREQUESTPRIORITY);
	}
	public boolean selectWorkOrderPriority() {
		return selectCategoryFromDropDown(WORKORDERPRIORITY);
	}
}
