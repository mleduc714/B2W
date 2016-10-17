package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WSetupUsers {

	public static By getCreateNewUserButton() {
		return By.cssSelector(B2WUIMap.b2w_users_createuser);
	}

	public static By getInactiveUserCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_users_inactivecheckbox);
	}

	public static By getB2WUserListingLastName() {
		return By.cssSelector(B2WUIMap.b2w_user_lastname);
	}

	public static By getB2WUserListingFirstName() {
		return By.cssSelector(B2WUIMap.b2w_user_firstname);
	}

	public static By getB2WUserListingWindowsAccount() {
		return By.cssSelector(B2WUIMap.b2w_user_windowsaccount);
	}

	public static By getB2WUserListingUserLicenses() {
		return By.cssSelector(B2WUIMap.b2w_user_licenses);
	}

	public static By getB2WUserListingInactive() {
		return By.cssSelector(B2WUIMap.b2w_user_inactive);
	}

	public static By getB2WUserListingEdit() {
		return By.cssSelector(B2WUIMap.b2w_user_edit);
	}

	public static By getB2WUserListingDelete() {
		return By.cssSelector(B2WUIMap.b2w_user_delete);
	}

	public static By getB2WViewUserList() {
		return By.cssSelector(B2WUIMap.b2w_user_view_user_list);
	}

	public static By getB2WUserEditButton() {
		return By.cssSelector(B2WUIMap.b2w_user_view_edit);
	}

	public static By getB2WUserDeleteButton() {
		return By.cssSelector(B2WUIMap.b2w_user_view_delete);
	}

	public static By getB2WUserCreateButton() {
		return By.cssSelector(B2WUIMap.b2w_user_view_create);
	}

	public static By getB2WEditFirstName() {
		return By.cssSelector(B2WUIMap.b2w_user_firstNameEdit);
	}

	public static By getB2WEditLastName() {
		return By.cssSelector(B2WUIMap.b2w_user_lastNameEdit);
	}

	public static By getB2WWindowsAccountEdit() {
		return By.cssSelector(B2WUIMap.b2w_user_windowsAccountEdit);
	}

	public static By getB2WWindowsMobileAccountEdit() {
		return By.cssSelector(B2WUIMap.b2w_user_mobileAccountEdit);
	}

	public static By getB2WBusinessUnitSelectBox() {
		return By.cssSelector(B2WUIMap.b2w_user_businessunitSelect);
	}

	public static By getB2WUserIntergrationMapping() {
		return By.cssSelector(B2WUIMap.b2w_user_integrationmapping);
	}

	public static By getB2WInactiveCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_user_inactivecheckbox);
	}

	public static By getB2WEmployeeDropDown() {
		return By.cssSelector(B2WUIMap.b2w_user_employeedropdown);
	}

	public static By getB2WUserTitle() {
		return By.cssSelector(B2WUIMap.b2w_user_title);
	}

	public static By getB2WUserEmailAddress() {
		return By.cssSelector(B2WUIMap.b2w_user_emailaddress);
	}

	public static By getB2WMobileDeviceCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_user_mobiledevicepincheckbox);
	}

	public static By getB2WTrackLicenseDropDown() {
		return By.cssSelector(B2WUIMap.b2w_user_tracklicensedropdown);
	}

	public static By getB2WDispatchLicenseDropDown() {
		return By.cssSelector(B2WUIMap.b2w_user_dispatchlicensedropdown);
	}

	public static By getB2WMainMechanicLicenseDropDown() {
		return By.cssSelector(B2WUIMap.b2w_user_maintainmechaniclicensedropdown);
	}

	public static By getB2WMainManagerLicenseDropDown() {
		return By.cssSelector(B2WUIMap.b2w_user_maintainmanagerlicensedropdown);
	}

	public static By getB2WAddSecurityRoleButton() {
		return By.cssSelector(B2WUIMap.b2w_user_addsecurityrolebutton);
	}

	public static By getB2WSecurityRoleTableView() {
		return By.cssSelector(B2WUIMap.b2w_user_securityroletableview);
	}
	public static By getUserInformationHeader() {
		return By.cssSelector(B2WUIMap.b2w_user_viewgeninfoHeader);
	}
	public static By getEmployeeHyperLink() {
		return By.cssSelector(B2WUIMap.b2w_user_employeehyperlink);
	}
}
