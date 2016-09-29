package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WAddLaborTypes {

	public static By getAddLaborTypesDialog() {
		return By.cssSelector(B2WUIMap.b2w_addlabortypesdialog);
	}
	
	public static By getAddLaborTypeSearchText() {
		return By.cssSelector(B2WUIMap.b2w_addlabortypesearch);
	}
	public static By getAddLaborTypeCheckBoxGrid() {
		return By.cssSelector(B2WUIMap.b2w_addlabortypecheckboxgrid);
	}
	public static By getAddLaborTypeAddButton() {
		return By.cssSelector(B2WUIMap.b2w_addlabortypeaddbutton);
	}
	public static By getAddLaborTypeCancelButton() {
		return By.cssSelector(B2WUIMap.b2w_addlabortypecancelbutton);
	}
	public static By getAddLaborTypeSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_addlabortypesearchbutton);
	}
	public static By getAddLaborTypeClearSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_addlabortypeclearsearchbutton);
	}
	public static By getAddLaborNameText() {
		return By.cssSelector(B2WUIMap.b2w_addlaborgridtext);
	}
	public static By getAddLaborNameCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_addlaborgridcheckbox);
	}
	public static By getAddLaborGridHeader() {
		return By.cssSelector(B2WUIMap.b2w_addlaborgridheader);
	}

}
