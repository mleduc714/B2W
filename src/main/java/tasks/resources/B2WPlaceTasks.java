package tasks.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.setup.B2WAddMaterials;
import appobjects.setup.B2WPlaces;
import tasks.WebElementUtils;

public class B2WPlaceTasks extends B2WResourceTasks {

	public boolean createNewPlaceButton() {
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WPlaces.getCreateNewPlaceButton())) {
			bReturn = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getAccountDescription()) != null;
		}
		return bReturn;
	}

	public boolean setPlaceID(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getPlaceID());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getPlaceID(), sText);
		}
		return bReturn;
	}

	public boolean setPlaceDescription(String sText) {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getPlaceDescription());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getPlaceID(), sText);
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
		System.out.println("Size" + els.size());
		WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
		if (item != null) {
			bReturn = WebElementUtils.clickElement(item);
		}
		return bReturn;

	}
	
	public boolean addMaterials() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindElement(B2WPlaces.getAddMaterialsButton());
		if (el != null){
			bReturn = WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.switchToFrame(B2WAddMaterials.getMaterialsDialog(), WebElementUtils.SHORT_TIME_OUT);
		}	
		return bReturn;
	}

	public boolean setStartDate(String startDate){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WPlaces.getStartDate());
		if (el!=null){
			bReturn = WebElementUtils.sendKeys(el, startDate);
		}
		return bReturn;
	}
	// public abstract boolean setSpecifyTimeCheckBox();
	public boolean setNonWorkingDayMonday(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNonWorkingMonday());
		return checkBox(el, bCheck);
	}
	public boolean setNonWorkingDayTuesday(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNonWorkingTuesday());
		return checkBox(el, bCheck);
	}
	public boolean setNonWorkingDayWednesday(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNonWorkingWednesday());
		return checkBox(el, bCheck);
	}
	public boolean setNonWorkingDayThursday(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNonWorkingThursday());
		return checkBox(el, bCheck);
	}
	public boolean setNonWorkingDayFriday(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNonWorkingFriday());
		return checkBox(el, bCheck);
	}
	public boolean setNonWorkingDaySaturday(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNonWorkingSaturday());
		return checkBox(el, bCheck);
	}
	public boolean setNonWorkingDaySunday(boolean bCheck){
		WebElement el = WebElementUtils.findElement(B2WPlaces.getNonWorkingSunday());
		return checkBox(el, bCheck);
	}
	
	
	
	
	
	
	// public abstract boolean setShowOnJobBoard();
	public boolean checkProducesMaterials() {
		return WebElementUtils.clickElement(B2WPlaces.getProducesMaterialsCheckBox());
	}
	public boolean setDurationType(String sText){
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
	 public boolean setLocationAddress1(String sText){
			boolean bReturn = false;
			WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getAddress1());
			if (el != null) {
				bReturn = WebElementUtils.sendKeys(B2WPlaces.getAddress1(), sText);
			}
			return bReturn;

		}
	// public boolean setLocationAddress2();
	public boolean setLocationCity(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getCity());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getCity(), sText);
		}
		return bReturn;

	}
	public boolean setLocationState(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getState());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getState(), sText);
		}
		return bReturn;

	}
	public boolean setLocationPostalCode(String sText){
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getZip());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getZip(), sText);
		}
		return bReturn;

	}
	public boolean setLocationCountry(String sText){

		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WPlaces.getCountry());
		if (el != null) {
			bReturn = WebElementUtils.sendKeys(B2WPlaces.getCountry(), sText);
		}
		return bReturn;
	}


	public static String getPlaceIDText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceIDText()).getText();
	}
	public static String getPlaceDescText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceDescText()).getText();
	}
	public static String getPlaceCategoryLabel() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceCategoryLabel()).getText();
	}

	public static String getStartDateText() {
		return WebElementUtils.findElement(B2WPlaces.getStartDateText()).getText();
	}
	public static String getEndDateText() {
		return WebElementUtils.findElement(B2WPlaces.getEndDateText()).getText();
	}
	public static String getNonWorkingDaysText() {
		return WebElementUtils.findElement(B2WPlaces.getNonWorkingDaysText()).getText();
	}
	public static String getShowOnJobBoardText() {
		return WebElementUtils.findElement(B2WPlaces.getShowOnJobBoardText()).getText();
	}
	public static String getCanProduceMaterialsText() {
		return WebElementUtils.findElement(B2WPlaces.getCanProduceMaterialsText()).getText();
	}
	public static String getPlaceAddressText(){
		return WebElementUtils.findElement(B2WPlaces.getPlaceAddressText()).getText();
	}
	public static String getPlaceCityText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceCityText()).getText();
	}
	public static String getPlaceStateText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceStateText()).getText();
	}
	public static String getPlaceZipText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceZipText()).getText();
	}
	public static String getPlaceCountryText() {
		return WebElementUtils.findElement(B2WPlaces.getPlaceCountryText()).getText();
	}
}
