package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WCategories {
	
	public static By getCategoryDropDownList() {
		return By.cssSelector(B2WUIMap.b2w_categoriesdropdown);
	}
	
	public static By getCategoryCreateNewButton() {
		return By.cssSelector(B2WUIMap.b2w_createnewcategorybutton);
	}
	
	public static By getCategoryName() {
		return By.cssSelector(B2WUIMap.b2w_generalinfoname);
	}
	public static By getRequestClarificationType() {
		return By.cssSelector(B2WUIMap.b2w_categoriesrequestcalificationtype);
	}
	public static By getCatgoriesGridViewName() {
		return By.cssSelector(B2WUIMap.b2w_categories_listview);
	}
	public static By getCategoryNameText() {
		return By.cssSelector(B2WUIMap.b2w_categories_categorynametext);
	}
	public static By getCategoryColorDropDown() {
		return By.cssSelector(B2WUIMap.b2w_categoriescolordropdown);
	}
	
	public static By getCategoryAssociatedColor() {
		return By.cssSelector(B2WUIMap.b2w_categoriesassociatedcolor);
	}
}
