package tasks.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WAddMaterials;
import appobjects.resources.B2WPlaces;
import tasks.WebElementUtils;

public class B2WPlaceTasks extends B2WResourceTasks {
	
	

	public boolean createNewPlaceButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WPlaces.getCreateNewPlaceButton())) {
			bReturn = waitForProcessingDialogToClear();
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getAccountDescription()) != null;
		}
		return bReturn;
	}

	public boolean setPlaceID(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getPlaceID());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}

	public boolean setPlaceDescription(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getPlaceDescription());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;

	}

	public boolean setPlaceBusinessUnit(String sText) {
		return selectBusinessUnit(sText);
	}

	public boolean setPlaceCategory(String sText) {

		boolean bReturn = false;
		WebElementUtils.clickElement(B2WPlaces.getPlaceCategory());
		WebElement el = WebElementUtils.findElement(B2WPlaces.getPlaceCategoryColorDropDown());
		List<WebElement> els = el.findElements(By.cssSelector("td.NameColumn"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;

	}

	public boolean clickAddMaterialsButton() {
		WebElementUtils.switchToFrame(B2WPlaces.getAddMaterialsButton(), WebElementUtils.SHORT_TIME_OUT);
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindElement(B2WPlaces.getAddMaterialsButton());
		if (el != null) {
			bReturn = WebElementUtils.clickElement(el);
			WebElementUtils.switchToFrame(B2WAddMaterials.getMaterialsDialog(), WebElementUtils.SHORT_TIME_OUT);
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid(), WebElementUtils.LONG_TIME_OUT) != null;
			
		}
		return bReturn;
	}

	public boolean setStartDate(String startDate) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WPlaces.getStartDate());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(el, startDate);
		}
		return bReturn;
	}

	public boolean setNonWorkingDayMonday(boolean bCheck) {
		return checkBox(B2WPlaces.getNonWorkingMonday(), bCheck);
	}

	public boolean setNonWorkingDayTuesday(boolean bCheck) {
		return checkBox(B2WPlaces.getNonWorkingTuesday(), bCheck);
	}

	public boolean setNonWorkingDayWednesday(boolean bCheck) {
		return checkBox(B2WPlaces.getNonWorkingWednesday(), bCheck);
	}

	public boolean setNonWorkingDayThursday(boolean bCheck) {
		return checkBox(B2WPlaces.getNonWorkingThursday(), bCheck);
	}

	public boolean setNonWorkingDayFriday(boolean bCheck) {
		return checkBox(B2WPlaces.getNonWorkingFriday(), bCheck);
	}

	public boolean setNonWorkingDaySaturday(boolean bCheck) {
		return checkBox(B2WPlaces.getNonWorkingSaturday(), bCheck);
	}

	public boolean setNonWorkingDaySunday(boolean bCheck) {
		return checkBox(B2WPlaces.getNonWorkingSunday(), bCheck);
	}

	// public abstract boolean setShowOnJobBoard();
	public boolean checkProducesMaterials() {
		return WebElementUtils.clickElement(B2WPlaces.getProducesMaterialsCheckBox());
	}

	public boolean setDurationType(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getDurationTypeDropDown());
		List<WebElement> els = el.findElements(By.tagName("option"));
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;
	}

	// public abstract boolean setShowOnMap();
	public boolean setLocationAddress1(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getAddress1());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getAddress1(), sText);
		}
		return bReturn;

	}

	// public boolean setLocationAddress2();
	public boolean setLocationCity(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getCity());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getCity(), sText);
		}
		return bReturn;

	}

	public boolean setLocationState(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getState());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getState(), sText);
		}
		return bReturn;

	}

	public boolean setLocationPostalCode(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getZip());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getZip(), sText);
		}
		return bReturn;

	}

	public boolean setLocationCountry(String sText) {

		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getCountry());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getCountry(), sText);
		}
		return bReturn;
	}

	public String getPlaceIDText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceIDText()).getText();
	}

	public String getPlaceDescText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceDescText()).getText();
	}

	public String getPlaceCategoryLabel() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceCategoryLabel()).getText();
	}

	public String getStartDateText() {
		return WebElementUtils.findElement(B2WPlaces.getStartDateText()).getText();
	}

	public String getEndDateText() {
		return WebElementUtils.findElement(B2WPlaces.getEndDateText()).getText();
	}

	public String getNonWorkingDaysText() {
		return WebElementUtils.findElement(B2WPlaces.getNonWorkingDaysText()).getText();
	}

	public String getShowOnJobBoardText() {
		return WebElementUtils.findElement(B2WPlaces.getShowOnJobBoardText()).getText();
	}

	public String getCanProduceMaterialsText() {
		return WebElementUtils.findElement(B2WPlaces.getCanProduceMaterialsText()).getText();
	}

	public String getPlaceAddressText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceAddressText()).getText();
	}

	public String getPlaceCityText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceCityText()).getText();
	}

	public String getPlaceStateText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceStateText()).getText();
	}

	public String getPlaceZipText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceZipText()).getText();
	}

	public String getPlaceCountryText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceCountryText()).getText();
	}

	public String getMaterialsGridText(int iRow) {
		String sText = "";
		try {
			WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getMaterialsGrid());
			if (el != null) {
				WebElement body = el.findElement(By.tagName("tbody"));
				List<WebElement> rows = body.findElements(By.tagName("tr"));
				if (!rows.isEmpty()) {
					WebElement row = rows.get(iRow);
					if (row != null) {
						sText = row.findElement(By.tagName("td")).getText();
					}
				}
			}

		} catch (IndexOutOfBoundsException e) {
			log.debug("The row " + iRow + " is was not found");
		}

		return sText;

	}
	
	public boolean createBin() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WPlaces.getAddBinButton());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getNewPlaceBinDescription()) != null;
		}
		
		return bReturn;
	}
	
	public boolean setPlaceBinDescription(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNewPlaceBinDescription());
		if (el != null){
			bReturn = WebElementUtils.sendKeys(el, sText);
		}
		return bReturn;
	}
	
	public boolean clickSaveBin() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WPlaces.getTopSavePanel());
		if (el!=null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getPlaceCityText()) != null;
		}
		return bReturn;
	}
	
	public String getInventoryBinDescription() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WPlaces.getInventoryBinDescription());
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	
	
}
