package tasks.setup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WCategories;
import tasks.WebElementUtils;

public class B2WCategoriesTasks {

	public boolean selectCategoryFromDropDown(String sText) {

		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WCategories.getCategoryDropDownList());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;

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
}
