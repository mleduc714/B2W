package tasks.resources;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.resources.B2WTMPriceSheets;
import appobjects.resources.KendoUI;
import tasks.WebElementUtils;

public class B2WTMPriceSheetsTasks extends B2WKendoTasks {

	private final String BUSINESSUNIT = "Select a Business Unit";
	private final String SOURCEOFRATES = "Select the source for the rates";
	private final String RATESOURCEFROMRATECLASS = "Set Rate Source from Rate Class";
	private final String RATESOURCEFROMTMPRICESHEET = "Set Rate Source from T&M Price Sheet";
	private final String NORATESOURCE = "No Rate Source";

	private final String LEFTCOLUMNRATESOURCE = "Rate Source";
	private final String LEFTCOLUMNOPERATEDRATES = "Use Operated Rates";
	private final String LEFTCOLUMNBUSINESSUNIT = "Business Unit";
	private final String LEFTCOUMMNNOTES = "Notes";

	private final String RIGHTCOLUMNMARKUP = "Markup";

	public boolean setEquipmentRatesName(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getB2WRatesHeader());
		List<WebElement> ls = WebElementUtils.getChildElements(el, B2WTMPriceSheets.getKendoInputTextBox());
		if (ls.size() != 0) {
			bReturn = WebElementUtils.sendKeys(ls.get(0), sText);
		}

		return bReturn;

	}

	public boolean setEquipmentRatesID(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getB2WRatesHeader());
		List<WebElement> ls = WebElementUtils.getChildElements(el, B2WTMPriceSheets.getKendoInputTextBox());
		if (ls.size() != 0) {
			bReturn = WebElementUtils.sendKeys(ls.get(1), sText);
		}

		return bReturn;

	}

	public boolean selectEquipmentBusinessUnitFromDD(String sText) {
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WTMPriceSheets.getKendoDropDown());
		WebElement bDD = WebElementUtils.findElement(B2WTMPriceSheets.getBusinessUnitDropDown());
		Iterator<WebElement> iter = ls.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			if (el.getText().equals(BUSINESSUNIT)) {
				if (WebElementUtils.clickElement(el)) {
					bReturn = selectItemFromDropDown(sText);
					bReturn &= WebElementUtils.waitForElementHasAttributeWithValue(bDD, "aria-expanded", "false", true,
							WebElementUtils.SHORT_TIME_OUT);
				}
			}
		}
		return bReturn;
	}

	private boolean selectRateSourceFromDD(String sText) {
		boolean bReturn = false;
		List<WebElement> ls = WebElementUtils.findElements(B2WTMPriceSheets.getKendoDropDown());
		WebElement rDD = WebElementUtils.findElement(B2WTMPriceSheets.getRatesSourceDropDown());
		Iterator<WebElement> iter = ls.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			if (el.getText().equals(SOURCEOFRATES)) {
				if (WebElementUtils.clickElement(el)) {
					bReturn = selectItemFromDropDown(sText);
					bReturn &= WebElementUtils.waitForElementHasAttributeWithValue(rDD, "aria-expanded", "false", true,
							WebElementUtils.SHORT_TIME_OUT);
				}
			}
		}
		return bReturn;
	}

	public boolean setRateSourceFromRateClass(String sRateClass, String sValue) {
		boolean bReturn = false;
		if (selectRateSourceFromDD(RATESOURCEFROMRATECLASS)) {
			bReturn = setRateClass(sRateClass, sValue);
		}
		return bReturn;
	}

	public boolean setRateSourceFromTMPriceSheet(String sRateClass, String sValue) {
		boolean bReturn = false;
		if (selectRateSourceFromDD(RATESOURCEFROMTMPRICESHEET)) {
			bReturn = setRateClass(sRateClass, sValue);
		}
		return bReturn;
	}

	public boolean setRateSourceNoRateSource() {
		return selectRateSourceFromDD(this.NORATESOURCE);
	}

	public boolean createNewPriceSheetForEquipment() {
		return createPriceSheet("Equipment");
	}

	public boolean createNewPriceSheetForLabor() {
		return createPriceSheet("Labor");
	}

	public boolean createNewPriceSheetForMaterials() {
		return createPriceSheet("Materials");
	}

	public boolean createNewPriceSheetForMiscellaneous() {
		return createPriceSheet("Miscellaneous");
	}

	private boolean createPriceSheet(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getNewPriceSheetButton());
		if (el != null) {
			if (WebElementUtils.clickElement(el)) {
				List<WebElement> ls = WebElementUtils
						.waitAndFindDisplayedElements(B2WTMPriceSheets.getKendoDropDownItem());
				Iterator<WebElement> iter = ls.iterator();
				while (iter.hasNext()) {
					WebElement item = iter.next();
					if (item.getText().equals(sText)) {
						bReturn = WebElementUtils.clickElement(item);
						WebElementUtils.switchToFrame(B2WTMPriceSheets.getKendoInputTextBox(),
								WebElementUtils.SHORT_TIME_OUT);
						break;
					}
				}
			}
		}
		return bReturn;
	}

	private boolean setRateClass(String sRateClass, String sMarkup) {
		boolean bReturn = false;
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(B2WTMPriceSheets.getB2WCopyRateForm());
		WebElement el = WebElementUtils.getChildElement(parent, B2WTMPriceSheets.getKendoDropDown());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sRateClass.substring(0, 2));
			WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "true", true,
					WebElementUtils.SHORT_TIME_OUT);
			bReturn &= selectItemFromDropDown(sRateClass);
			WebElementUtils.waitForElementHasAttributeWithValue(el, "aria-expanded", "false", true,
					WebElementUtils.SHORT_TIME_OUT);
			WebElement markup = WebElementUtils.waitAndFindDisplayedElement(KendoUI.getKendoFormattedValue());
			bReturn &= WebElementUtils.sendKeys(markup, sMarkup);
		}

		return bReturn;
	}

	public boolean clickApply() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WTMPriceSheets.getApplyRatesButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= waitForPageNotBusy();
		}
		return bReturn;
	}

	public boolean selectPriceSheetByDescription(String sDesc) {
		boolean bReturn = false;

		WebElement grid = WebElementUtils.findElement(B2WTMPriceSheets.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.getAttribute("class").equals("k-grouping-row")) {
				continue;
			}
			List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));

			String sText = gridcontent.get(1).getText();
			// when it's a empty string we need to get into view
			if (sText.equals("")) {
				Coordinates coordinate = ((Locatable) item).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
			}
			sText = gridcontent.get(1).getText();
			if (sText.startsWith(sDesc)) {
				bReturn = WebElementUtils.clickElement(item);
				WebElement ps = WebElementUtils.waitAndFindDisplayedElement(B2WTMPriceSheets.getPriceSheetIntro(),
						WebElementUtils.MEDIUM_TIME_OUT);
				bReturn &= ps != null;
				break;
			}
		}
		return bReturn;
	}
	
	public boolean selectPriceSheetByID(String sID){

		boolean bReturn = false;

		WebElement grid = WebElementUtils.findElement(B2WTMPriceSheets.getKendoGridContent());
		List<WebElement> items = WebElementUtils.getChildElements(grid, By.tagName("tr"));
		Iterator<WebElement> iter = items.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.getAttribute("class").equals("k-grouping-row")) {
				continue;
			}
			List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));

			String sText = gridcontent.get(2).getText();
			// when it's a empty string we need to get into view
			if (sText.equals("")) {
				Coordinates coordinate = ((Locatable) item).getCoordinates();
				coordinate.onPage();
				coordinate.inViewPort();
			}
			sText = gridcontent.get(2).getText();
			if (sText.startsWith(sID)) {
				bReturn = WebElementUtils.clickElement(item);
				WebElement ps = WebElementUtils.waitAndFindDisplayedElement(B2WTMPriceSheets.getPriceSheetIntro(),
						WebElementUtils.MEDIUM_TIME_OUT);
				bReturn &= ps != null;
				break;
			}
		}
		return bReturn;
	
		
	}

	public String getRateSourceDescription() {
		return getInfoFromLeftColumn(getLabelFromLeftColumn(LEFTCOLUMNRATESOURCE));
	}

	public String getUseOperatedRates() {
		return getInfoFromLeftColumn(getLabelFromLeftColumn(LEFTCOLUMNOPERATEDRATES));
	}

	public String getBusinessUnit() {
		return getInfoFromLeftColumn(getLabelFromLeftColumn(LEFTCOLUMNBUSINESSUNIT));
	}

	public String getNotes() {
		return getInfoFromLeftColumn(getLabelFromLeftColumn(LEFTCOUMMNNOTES));
	}

	public String getMarkup() {
		return getInfoFromRightColumn(getLabelFromRightColumn(RIGHTCOLUMNMARKUP));
	}

	private int getLabelFromLeftColumn(String sLabel) {
		int i = -1;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceLeftColumn());
		if (el != null) {
			List<WebElement> ls = el.findElements(B2WTMPriceSheets.getKendoLabel());
			Iterator<WebElement> iter = ls.iterator();
			while (iter.hasNext()) {
				i++;
				if (iter.next().getText().equals(sLabel)){
					break;
				}
				

			}
		}
		return i;
	}

	private String getInfoFromLeftColumn(int i) {
		String sInfo = "";
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceLeftColumn());
		if (el != null) {
			List<WebElement> ls = el.findElements(B2WTMPriceSheets.getRateSourceDescription());
			if (ls.size() != 0) {
				sInfo = ls.get(i).getText();
			}
		}
		return sInfo;
	}

	private int getLabelFromRightColumn(String sLabel) {
		int i = -1;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceRightColumn());
		if (el != null) {
			List<WebElement> ls = el.findElements(B2WTMPriceSheets.getKendoLabel());
			Iterator<WebElement> iter = ls.iterator();
			while (iter.hasNext()) {
				i++;
				ls.get(i).getText().equals(sLabel);
				break;

			}
		}
		return i;
	}

	private String getInfoFromRightColumn(int i) {
		String sInfo = "";
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceRightColumn());
		if (el != null) {
			List<WebElement> ls = el.findElements(B2WTMPriceSheets.getRateSourceDescription());
			if (ls.size() != 0) {
				sInfo = ls.get(i).getText();
			}
		}

		return sInfo;

	}

	public boolean clickEditButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceSheetEditButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickModifyRateButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceSheetModifyRateButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickCopyPriceSheetButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceSheetCopyPriceSheetButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

	public boolean clickDeleteButton() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WTMPriceSheets.getPriceSheetDeleteButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
		}
		return bReturn;
	}

}
