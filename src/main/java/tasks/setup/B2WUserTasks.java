package tasks.setup;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import appobjects.setup.B2WSetup;
import appobjects.setup.B2WSetupUsers;
import tasks.B2WSetupTasks;
import tasks.BrowserUtils;
import tasks.WebElementUtils;

public class B2WUserTasks extends B2WSetupTasks {
	
	public enum ACCESSLEVEL {NONE,FULL,READONLY};
	
	ACCESSLEVEL access;
	public boolean clickSearchButton(){
		return WebElementUtils.clickElement(B2WSetup.getB2WSearchButton());
	}
	

	public boolean openUserByFirstName(String sFirstName){
		boolean bReturn = false;
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WSetupUsers.getB2WUserListingFirstName());
		if (!list.isEmpty()){
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sFirstName, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WSetupUsers.getUserInformationHeader());
			bReturn = waitForThis!=null;
		}
		return bReturn;
	}
	
	public boolean openUserByLastName(String sLastName){
		boolean bReturn = false;
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WSetupUsers.getB2WUserListingLastName());
		if (!list.isEmpty()){
			WebElement el = WebElementUtils.getElementWithMatchingText(list, sLastName, false);
			WebElementUtils.clickElement(el);
			WebElement waitForThis = WebElementUtils.waitAndFindDisplayedElement(B2WSetupUsers.getUserInformationHeader());
			bReturn = waitForThis!=null;
		}
		return bReturn;
	}
	
	
	public boolean isFirstNameInSearch(String sText) {
		boolean bReturn = false;
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WSetupUsers.getB2WUserListingFirstName());
		WebElement el = WebElementUtils.getElementWithMatchingText(list, sText, true);
		if (el!=null){
			bReturn = true;
		}
		return bReturn;
		
	}
	
	public boolean isLastNameInSearch(String sText) {
		boolean bReturn = false;
		List<WebElement> list = BrowserUtils.getDriver().findElements(B2WSetupUsers.getB2WUserListingLastName());
		WebElement el = WebElementUtils.getElementWithMatchingText(list, sText, true);
		if (el!=null){
			bReturn = true;
		}
		return bReturn;
		
	}
	
	public boolean clickEditButton(){
		boolean bReturn = false;
		if (WebElementUtils.clickElement(B2WSetupUsers.getB2WUserEditButton())){
			bReturn = waitForProcessingDialogToClear();
			bReturn &= WebElementUtils.waitAndFindDisplayedElement(B2WSetupUsers.getB2WDispatchLicenseDropDown())!=null;
		}
		
		return bReturn;
	}
	
	public boolean changeTrackAccessToReadOnly() {
		access = ACCESSLEVEL.READONLY;
		boolean bReturn = false;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WTrackLicenseDropDown()));
		return bReturn;
	}
	public boolean changeTrackAccessToFullAccess() {
		boolean bReturn = false;
		access = ACCESSLEVEL.FULL;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WTrackLicenseDropDown()));
		return bReturn;
		
	}
	public boolean changeTrackAccessToNone() {
		boolean bReturn = false;
		access = ACCESSLEVEL.NONE;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WTrackLicenseDropDown()));
		return bReturn;
	}
	
	public boolean changeDispatchAccessToReadOnly() {
		access = ACCESSLEVEL.READONLY;
		boolean bReturn = false;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WDispatchLicenseDropDown()));
		return bReturn;
	}
	public boolean changeDispatchAccessToFullAccess() {
		boolean bReturn = false;
		access = ACCESSLEVEL.FULL;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WDispatchLicenseDropDown()));
		return bReturn;
		
	}
	public boolean changeDispatchAccessToNone() {
		boolean bReturn = false;
		access = ACCESSLEVEL.NONE;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WDispatchLicenseDropDown()));
		return bReturn;
	}
	public boolean changeMaintainMechanicAccessToReadOnly() {
		access = ACCESSLEVEL.READONLY;
		boolean bReturn = false;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WMainMechanicLicenseDropDown()));
		return bReturn;
	}
	public boolean changeMaintainMechanicAccessToFullAccess() {
		boolean bReturn = false;
		access = ACCESSLEVEL.FULL;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WMainMechanicLicenseDropDown()));
		return bReturn;
		
	}
	public boolean changeMaintainMechanicAccessToNone() {
		boolean bReturn = false;
		access = ACCESSLEVEL.NONE;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WMainMechanicLicenseDropDown()));
		return bReturn;
	}
	public boolean changeMaintainManagerAccessToReadOnly() {
		access = ACCESSLEVEL.READONLY;
		boolean bReturn = false;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WMainManagerLicenseDropDown()));
		return bReturn;
	}
	public boolean changeMaintainManagerAccessToFullAccess() {
		boolean bReturn = false;
		access = ACCESSLEVEL.FULL;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WMainManagerLicenseDropDown()));
		return bReturn;
		
	}
	public boolean changeMaintainManagerAccessToNone() {
		boolean bReturn = false;
		access = ACCESSLEVEL.NONE;
		bReturn = changeAccess(access,WebElementUtils.findElement(B2WSetupUsers.getB2WMainManagerLicenseDropDown()));
		return bReturn;
	}
	
	
	private boolean changeAccess(ACCESSLEVEL level, WebElement el) {
	
		Select select = new Select(el);
		switch (level) {
		case NONE:
			select.selectByIndex(0);
			break;
		case FULL:
			select.selectByIndex(1);
			break;
		case READONLY:
			select.selectByIndex(2);
			break;
		}
		return true;
		
	}
	
	


}
