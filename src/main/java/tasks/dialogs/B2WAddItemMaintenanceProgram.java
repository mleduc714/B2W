package tasks.dialogs;

import java.util.List;

import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;

public class B2WAddItemMaintenanceProgram extends B2WKendoDialog {
	
	private final String ITEMDESC = "Item Description";
	private final String TYPE = "Type";
	private final String PRIORITY = "Priority";
	private final String LEVEL = "Level";
	


	public boolean setAddItemDescription(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(ITEMDESC);
		if (el != null) {
			WebElement textbox = el.findElement(B2WMaintain.getKendoInputTextBox());
			bReturn = WebElementUtils.clickElement(textbox);
			bReturn &= WebElementUtils.sendKeys(textbox, sText);
		}
		return bReturn;
	}

	public boolean selectAddItemTypeFromDD(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(TYPE);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}
	
	

	public boolean selectAddItemPriority(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(PRIORITY);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= selectItemFromDropDown(sText);
		}
		return bReturn;
	}

	public boolean setAddItemLevel(String sText) {
		boolean bReturn = false;
		WebElement el = getItemFromAddItemDialog(LEVEL);
		if (el != null) {
			List<WebElement> els = WebElementUtils.getChildElements(el, B2WMaintain.getB2WMaintainAddItemLevel());
			WebElementUtils.clickElement(els.get(0));
			bReturn = WebElementUtils.sendKeys(els.get(1), sText);

		}
		return bReturn;
	}
	
	public boolean saveItem() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getB2WMaintainAddItemDialog());
		WebElement save = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainAddItemSaveButton());
		if (save != null) {
			bReturn = WebElementUtils.clickElement(save);
			bReturn &= WebElementUtils.waitForElementInvisible(save);
		}
		return bReturn;
	}
}
