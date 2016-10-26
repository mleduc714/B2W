package appobjects.resources;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public abstract class KendoUI {

	public static By getKendoDescription() {
		return By.cssSelector(B2WUIMap.b2w_kendoinputtexbox);
	}
	public static By getKendoDropDown() {
		return By.cssSelector(B2WUIMap.b2w_kendoinput);
	}
	public static By getKendoDropDownItem() {
		return By.cssSelector(B2WUIMap.b2w_kendodropdownitem);
	}
	public static By getKendoNameValuePair() {
		return By.cssSelector(B2WUIMap.b2w_kendonamevaluepair);
	}
	public static By getKendoLists() {
		return By.cssSelector(B2WUIMap.b2w_kendolistofitems);
	}
	public static By getKendoFilterByDD() {
		return By.cssSelector(B2WUIMap.b2w_kendofilterbydd);
	}
	public static By getKendoGridContent() {
		return By.cssSelector(B2WUIMap.b2w_kendogridcontent);
	}
	public static By getKendoItems() {
		return By.cssSelector(B2WUIMap.b2w_kendoitems);
	}
	public static By getKendoHeadersFromView() {
		return By.cssSelector(B2WUIMap.b2w_kendoheaders);
	}
	public static By getKendoPageLoading() {
		return By.cssSelector(B2WUIMap.b2w_kendoloadpage);
	}
	public static By getKendoInputTextBox() {
		return By.cssSelector(B2WUIMap.b2w_kendoinputtexbox);
	}
	public static By getKendoLabel() {
		return By.cssSelector(B2WUIMap.b2w_kendolabel);
	}
	public static By getKendoFormattedValue() {
		return By.cssSelector(B2WUIMap.b2w_kendoformatedvalue);
	}
	public static By getKendoDropDownForTMTab() {
		return By.cssSelector(B2WUIMap.b2w_kendotmtabdropdown);
	}
	public static By getKendoWorkItemTable() {
		return By.cssSelector(B2WUIMap.b2w_jobstmworkitemgrid);
	}
	public static By getKendoButton() {
		return By.cssSelector(B2WUIMap.b2w_kendobutton);
	}
	public static By getKendoFooter(){
		return By.cssSelector(B2WUIMap.b2w_kendofooter);
	}
	public static By getKendoWindow() {
		return By.cssSelector(B2WUIMap.b2w_kendowindow);
	}
	public static By getKendoNumericTextBox(){
		return By.cssSelector(B2WUIMap.b2w_kendonumerictextbox);
	}
}
