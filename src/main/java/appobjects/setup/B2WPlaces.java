package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WPlaces extends B2WResources {
	
	public static By getCreateNewPlaceButton() {
		return By.cssSelector(B2WUIMap.b2w_createnewplacebutton);
	}

	public static By getAddMaterialsButton() {
		return By.className(B2WUIMap.b2w_newplace_addmaterialsbutton);
	}

	public static By getProducesMaterialsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_canproducematerials);
	}

	public static By getPlaceDescription() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placedesc);
	}

	public static By getPlaceID() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placeid);
	}

	public static By getDurationTypeDropDown() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_durationdd);
	}
	
	public static By getPlaceCategory() {
		return By.cssSelector(B2WUIMap.b2w_newplace_categorydropdown);
	}
	
	public static By getPlaceCategoryColorDropDown() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_catcolor);
	}

	public static By getStartDate() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placestartdate);
	}

	public static By getNonWorkingMonday() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_nonworkingmonday);
	}

	public static By getNonWorkingTuesday() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_nonworkingtuesday);
	}

	public static By getNonWorkingWednesday() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_nonworkingwednesday);
	}

	public static By getNonWorkingThursday() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_nonworkingthursday);
	}

	public static By getNonWorkingFriday() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_nonworkingfriday);
	}

	public static By getNonWorkingSaturday() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_nonworkingsat);
	}

	public static By getNonWorkingSunday() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_nonworkingsun);
	}

	public static By getGeneralInfoShowOnJobBoard() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_showonjobboard);
	}

	public static By getShowOnMap() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_showonmap);
	}

	public static By getCanProduceMaterialsCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_canproducematerials);
	}

	public static By getAddress1() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placeadd1);

	}

	public static By getAddress2() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placeadd2);

	}

	public static By getCity() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placecity);
	}

	public static By getState() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placestate);
	}

	public static By getZip() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placezip);
	}

	public static By getCountry() {
		return By.cssSelector(B2WUIMap.b2w_newplace_generalinfo_placecountry);
	}

	public static By getPlaceIDText() {
		return By.cssSelector(B2WUIMap.b2w_place_id);
	}
	public static By getPlaceDescText() {
		return By.cssSelector(B2WUIMap.b2w_place_description);
	}
	public static By getPlaceCategoryLabel() {
		return By.cssSelector(B2WUIMap.b2w_place_categorylabel);
	}

	public static By getStartDateText() {
		return By.cssSelector(B2WUIMap.b2w_place_startdate);
	}
	public static By getEndDateText() {
		return By.cssSelector(B2WUIMap.b2w_place_enddate);
	}
	public static By getNonWorkingDaysText() {
		return By.cssSelector(B2WUIMap.b2w_place_nonworking);
	}
	public static By getShowOnJobBoardText() {
		return By.cssSelector(B2WUIMap.b2w_place_showonboard);
	}
	public static By getCanProduceMaterialsText() {
		return By.cssSelector(B2WUIMap.b2w_place_canproduce);
	}
	public static By getPlaceAddressText(){
		return By.cssSelector(B2WUIMap.b2w_place_address1);
	}
	public static By getPlaceCityText() {
		return By.cssSelector(B2WUIMap.b2w_place_city);
	}
	public static By getPlaceStateText() {
		return By.cssSelector(B2WUIMap.b2w_place_state);
	}
	public static By getPlaceZipText() {
		return By.cssSelector(B2WUIMap.b2w_place_zip);
	}
	public static By getPlaceCountryText() {
		return By.cssSelector(B2WUIMap.b2w_place_country);
	}

}
