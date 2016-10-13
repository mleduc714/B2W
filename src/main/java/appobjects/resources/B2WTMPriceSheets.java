package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WTMPriceSheets extends KendoUI {

	
	public static By getNewPriceSheetButton() {
		return By.cssSelector(B2WUIMap.b2w_createnewpricesheetbutton);
	}
	public static By getB2WPriceSheetDialog() {
		return By.cssSelector(B2WUIMap.b2w_b2wmessenger);
	}
	public static By getB2WDialogForm() {
		return By.cssSelector(B2WUIMap.b2w_formvalidator);
	}
	public static By getB2WRatesHeader() {
		return By.cssSelector(B2WUIMap.b2w_ratesheader);
	}
	public static By getB2WCopyRateForm() {
		return By.cssSelector(B2WUIMap.b2w_copyrateform);
	}
	public static By getApplyRatesButton() {
		return By.cssSelector(B2WUIMap.b2w_tmpricesheetapplybutton);
	}
	public static By getPriceSheetDetails() {
		return By.cssSelector(B2WUIMap.b2w_pricesheetdetails);
	}
	public static By getRateSourceDescription() {
		return By.cssSelector(B2WUIMap.b2w_kendodata);
	}
	public static By getPriceSheetIntro() {
		return By.cssSelector(B2WUIMap.b2w_pricesheetitemintro);
	}
	public static By getPriceLeftColumn() {
		return By.cssSelector(B2WUIMap.b2w_pricesheetleftcolumn);
	}
	public static By getPriceRightColumn() {
		return By.cssSelector(B2WUIMap.b2w_pricesheetrightcolumn);
	}
	public static By getPriceSheetEditButton() {
		return By.cssSelector(B2WUIMap.b2w_tmpricesheeteditbutton);
	}
	public static By getPriceSheetModifyRateButton() {
		return By.cssSelector(B2WUIMap.b2w_tmpricesheetmodifyratesourcebutton);
	}
	public static By getPriceSheetCopyPriceSheetButton() {
		return By.cssSelector(B2WUIMap.b2w_tmpricesheetcopypricesheet);
	}
	public static By getPriceSheetDeleteButton() {
		return By.cssSelector(B2WUIMap.b2w_tmpricesheetdeletebutton);
	}
	public static By getBusinessUnitDropDown() {
		return By.cssSelector(B2WUIMap.b2w_tmpricesheetbusinessunitdropdown);
	}
	public static By getRatesSourceDropDown() {
		return By.cssSelector(B2WUIMap.b2w_tmpricesheetratessourcedropdown);
	}
}
