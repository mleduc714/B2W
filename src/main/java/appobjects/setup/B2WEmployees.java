package appobjects.setup;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WEmployees {
	
	public static By getCreateNewEmployeeButton() {
		return By.cssSelector(B2WUIMap.b2w_createnewemployee);
	}
	
	public static By getEmployeeFirstName() {
		return By.cssSelector(B2WUIMap.b2w_employeefirstname);
	}
	
	public static By getEmployeeLastName() {
		return By.cssSelector(B2WUIMap.b2w_employeelastname);
	}
	
	public static By getEmployeeMiddleName() {
		return By.cssSelector(B2WUIMap.b2w_middlename);
	}
	
	public static By getEmployeeID() {
		return By.cssSelector(B2WUIMap.b2w_employeeID);
	}
	
	public static By getFieldLogReviewer() {
		return By.cssSelector(B2WUIMap.b2w_employeefieldlogreviewer);
	}
	public static By getEmployeeTitle() {
		return By.cssSelector(B2WUIMap.b2w_employeetitle);
	}
	public static By getEmployeeNickName() {
		return By.cssSelector(B2WUIMap.b2w_employeenickname);
	}
	public static By getEmployeeCellPhone() {
		return By.cssSelector(B2WUIMap.b2w_employeecellphone);
	}
	public static By getEmployeeHomePhone() {
		return By.cssSelector(B2WUIMap.b2w_employeehomephone);
	}
	public static By getEmployeeWorkPhone() {
		return By.cssSelector(B2WUIMap.b2w_employeeworkphone);
	}
	public static By getEmployeeEmail() {
		return By.cssSelector(B2WUIMap.b2w_employeeemail);
	}
	public static By getFieldEmployeeCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_fieldemployeecheckbox);
	}
	public static By getDriverCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_drivercheckbox);
	}
	public static By getTruckDriverCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_trucckdrivercheckbox);
	}
	public static By getForemanCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_foremancheckbox);
	}
	public static By getSupervisorheckBox() {
		return By.cssSelector(B2WUIMap.b2w_supervisorcheckbox);
	}
	public static By getProjectManagerCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_projectmanagercheckbox);
	}
	public static By getMechanicCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_mechaniccheckbox);
	}
	public static By getBuyerCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_buyercheckbox);
	}
	public static By getPurchaseOrderApproverCheckBox() {
		return By.cssSelector(B2WUIMap.b2w_purchaseorderapprovercheckbox);
	}
	public static By getAddLaborTypeButton() {
		return By.cssSelector(B2WUIMap.b2w_employeeaddlabortype);
	}
	public static By getAddCertificationsButton() {
		return By.cssSelector(B2WUIMap.b2w_employeeaddcertifications);
	}
	public static By getEmployeeSearchText() {
		return By.cssSelector(B2WUIMap.b2w_employeesearchtext);
	}
	public static By getEmployeeSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_employeesearchbutton);
	}
	public static By getEmployeeClearSearchButton() {
		return By.cssSelector(B2WUIMap.b2w_employeeclearsearchbutton);
	}
	public static By getEmployeeByLastNameGrid() {
		return By.cssSelector(B2WUIMap.b2w_employeefirstnamegrid);
	}
	public static By getEmployeeLastNameText() {
		return By.cssSelector(B2WUIMap.b2w_employeelastnamelabel);
	}
	
}
