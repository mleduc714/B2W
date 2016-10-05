package testcases;

import java.text.SimpleDateFormat;
import java.util.Random;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.B2WSetupTasks;
import tasks.resources.B2WAccountTasks;
import tasks.resources.B2WAddLaborTypeTasks;
import tasks.resources.B2WAddMaterialsTasks;
import tasks.resources.B2WEmployeeTasks;
import tasks.resources.B2WMaterialsTasks;
import tasks.resources.B2WNewLaborTypeTasks;
import tasks.resources.B2WPlaceTasks;
import tasks.setup.B2WUserTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeC extends B2WTestCase {

	B2WUserTasks userTasks = new B2WUserTasks();
	B2WSetupTasks b2wSetup = new B2WSetupTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WAccountTasks b2wAct = new B2WAccountTasks();
	B2WMaterialsTasks b2wMat = new B2WMaterialsTasks();
	B2WPlaceTasks b2wPlaces = new B2WPlaceTasks();
	B2WAddMaterialsTasks b2wAdd = new B2WAddMaterialsTasks();
	B2WNewLaborTypeTasks b2wLaborType = new B2WNewLaborTypeTasks();
	B2WEmployeeTasks b2wEmp = new B2WEmployeeTasks();
	B2WAddLaborTypeTasks b2wAddLabor = new B2WAddLaborTypeTasks();
	
	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");

	String sLaborTypeA;
	String sLaborTypeIDA;
	String sLaborTypeB;
	String sLaborTypeIDB;

	String sEmployeeNameA;
	String sEmployeeNameB;
	String sEmployeeNameC;
	String sEmployeeNameD;
	String sEmployeeNameE;
	String sEmployeeFirstNameA;
	String sEmployeeFirstNameB;
	String sEmployeeFirstNameC;
	String sEmployeeFirstNameD;
	String sEmployeeFirstNameE;
	String sEmployeeLastNameA;
	String sEmployeeLastNameB;
	String sEmployeeLastNameC;
	String sEmployeeLastNameD;
	String sEmployeeLastNameE;
	String sEmployeeIDA;
	String sEmployeeIDB;
	String sEmployeeIDC;
	String sEmployeeIDD;
	String sEmployeeIDE;

	String sLaborRateClass;

	/*
	 * Create new entities of the following types, through the Resources area
	 * 
	 * a.Production Account b.Overhead Account c.Material
	 * 
	 * 
	 */

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "mleduc";
	}

	@Override
	public String getDataPath() {
		// for properties files of test data
		return "data/test";
	}

	@Override
	public boolean isSupported() {
		// for specific browser
		return true;
	}

	@Override
	public String getCategory() {
		// Category of the within ops
		return null;
	}

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
		Random rand = new Random();
		int  n = rand.nextInt(10000) + 1;
		sLaborTypeA = getProperty("labortypeA");
		sLaborTypeIDA = getProperty("labortypeIDA")+ n;
		sLaborTypeB = getProperty("labortypeB");
		sLaborTypeIDB = getProperty("labortypeIDB") + n;
		sEmployeeFirstNameA = getProperty("employeenameFirstA");
		sEmployeeFirstNameB = getProperty("employeenameFirstB");
		sEmployeeFirstNameC = getProperty("employeenameFirstC");
		sEmployeeFirstNameD = getProperty("employeenameFirstD");
		sEmployeeFirstNameE = getProperty("employeenameFirstE");
		sEmployeeLastNameA = getProperty("employeenameLastA");
		sEmployeeLastNameB = getProperty("employeenameLastB");
		sEmployeeLastNameC = getProperty("employeenameLastC");
		sEmployeeLastNameD = getProperty("employeenameLastD");
		sEmployeeLastNameE = getProperty("employeenameLastE");
		sEmployeeIDA = getProperty("employeenameAID") +n;
		sEmployeeIDB = getProperty("employeenameBID") +n;
		sEmployeeIDC = getProperty("employeenameCID") +n;
		sEmployeeIDD = getProperty("employeenameDID") +n;
		sEmployeeIDE = getProperty("employeenameEID") +n;
	

	}

	public void testMain() throws Throwable {

		assertTrue("Click Home", b2wNav.clickHome());
		createLaborTypes();
		createEmployeeA();
		createEmployeeB();
		createEmployeeC();
		createEmployeeD();
		createEmployeeE();
	}


	public void createLaborTypes() {

		b2wNav.openLaborTypes();
		logCompare(true,b2wLaborType.createNewLaborType(),"Create Labor Type");
		logCompare(true,b2wLaborType.setLaborType(sLaborTypeA), "Set Labor Type");
		logCompare(true,b2wLaborType.setLaborID(sLaborTypeIDA), "Set Labor Type ID");
		logCompare(true,b2wLaborType.clickTopSaveButton(),"Click Save Button");
		logCompare(sLaborTypeIDA, b2wAct.getAccountIDText(), "Account ID");
		logCompare(sLaborTypeA, b2wLaborType.getLaborTypeTextLabel(), "Labor Type");
		b2wNav.openLaborTypes();
		logCompare(true,b2wLaborType.createNewLaborType(),"Create Labor Type");
		logCompare(true,b2wLaborType.setLaborType(sLaborTypeB), "Set Labor Type");
		logCompare(true,b2wLaborType.setLaborID(sLaborTypeIDB), "Set Labor ID");
		logCompare(true,b2wLaborType.clickTopSaveButton(),"Click Save Button");
		logCompare(sLaborTypeIDB, b2wAct.getAccountIDText(), "Account ID");
		logCompare(sLaborTypeB, b2wLaborType.getLaborTypeTextLabel(), "Labor Type");
		
		
	}

	public void createEmployeeA() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
	
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstNameA), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastNameA), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeIDA), "Set Employee ID");
		logCompare(true, b2wEmp.setEmployeeEmail(sEmployeeFirstNameA+"@gmail.com"), "Set Email");
		logCompare(true, b2wEmp.setEmployeeHomePhone("603-555-2312"), "Home Phone");
		logCompare(true, b2wEmp.setEmployeeTitle("Title"), "Title");
		logCompare(true, b2wEmp.openAddLaborTypeDialog(), "Open Labor Dialog");
		logCompare(true, b2wAddLabor.setSearchText(sLaborTypeA), "Search for Labor");
		TaskUtils.sleep(500);
		logCompare(true, b2wAddLabor.clickSearchButton(), "Click Search Button");
		TaskUtils.sleep(500);
		logCompare(true, b2wAddLabor.selectCheckBox(sLaborTypeA), "Select Labor Type");
		logCompare(true, b2wAddLabor.clickAddButton(), "Select Add Button");
		TaskUtils.sleep(500);
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");
		logCompare(true, b2wEmp.getEmployeeLaborTypeName().contains(sLaborTypeA), "Labor Type A");
		logCompare(true, b2wEmp.getEmployeeLaborTypeID().contains(sLaborTypeIDA), "Labor ID A");
		logCompare("603-555-2312",b2wEmp.getEmployeeHomePhoneText(), "Home Phone#");
		logCompare(sEmployeeFirstNameA+"@gmail.com", b2wEmp.getEmployeeEmailText(), "Email");
		logCompare("Title", b2wEmp.getEmployeeJobTitleText(), "Job Title");
	}
	
	public void createEmployeeB() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstNameB), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastNameB), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeIDB), "Set Employee ID");
		logCompare(true, b2wEmp.setFieldEmployeeCheckBox(false), "Uncheck employee");
		logCompare(true, b2wEmp.setDriverCheckBox(true), "Set Driver Checkbox");
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");
		logCompare("Driver",b2wEmp.getEmployeeRolesText(), "get the role");

	}
	
	public void createEmployeeC() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstNameC), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastNameC), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeIDC), "Set Employee ID");
		logCompare(true, b2wEmp.setFieldEmployeeCheckBox(false), "Uncheck employee");
		logCompare(true, b2wEmp.setTruckDriverCheckBox(true), "Set Driver Checkbox");
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");
		logCompare("Truck Driver",b2wEmp.getEmployeeRolesText(), "get the role");

	}
	
	public void createEmployeeD() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstNameD), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastNameD), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeIDD), "Set Employee ID");
		logCompare(true, b2wEmp.setFieldEmployeeCheckBox(false), "Uncheck employee");
		logCompare(true, b2wEmp.setMechanicCheckBox(true), "Set Driver Checkbox");
		logCompare(true, b2wEmp.openAddLaborTypeDialog(), "Open Labor Dialog");
		logCompare(true, b2wAddLabor.setSearchText(sLaborTypeB), "Search for Labor");
		TaskUtils.sleep(500);
		logCompare(true, b2wAddLabor.clickSearchButton(), "Click Search Button");
		TaskUtils.sleep(500);
		logCompare(true, b2wAddLabor.selectCheckBox(sLaborTypeB), "Select Labor Type");
		logCompare(true, b2wAddLabor.clickAddButton(), "Select Add Button");
		TaskUtils.sleep(500);
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");
		logCompare("Mechanic",b2wEmp.getEmployeeRolesText(), "get the role");
		logCompare(true, b2wEmp.getEmployeeLaborTypeName().contains(sLaborTypeB), "Labor Type B");
		logCompare(true, b2wEmp.getEmployeeLaborTypeID().contains(sLaborTypeIDB), "Labor ID B");

	}
	
	public void createEmployeeE() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstNameE), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastNameE), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeIDE), "Set Employee ID");
		logCompare(true, b2wEmp.setFieldEmployeeCheckBox(false), "Uncheck employee");
		logCompare(true, b2wEmp.setForemanCheckBox(true), "Select Foreman");
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");
		logCompare("Foreman",b2wEmp.getEmployeeRolesText(), "get the role");

	}

	public void createEquipmentTypes() {

	}




	public void deleteAll() {
		
//		assertTrue("Open Employees", b2wNav.openEmployees());
//		logCompare(true,b2wEmp.enterTextandSearchForEmployee(sEmployeeIDA), "Employee A");
//		logCompare(true,b2wEmp.openEmployeeByID(sEmployeeIDA), "Open Employee");
//		logCompare(true,b2wEmp.deleteResource(), "Delete");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.clickClearSearchButton(), "Clear Search");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.enterTextandSearchForEmployee(sEmployeeIDB), "Employee B");
//		logCompare(true,b2wEmp.openEmployeeByID(sEmployeeIDB), "Employee B");
//		logCompare(true,b2wEmp.deleteResource(), "Delete B");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.clickClearSearchButton(), "Clear");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.enterTextandSearchForEmployee(sEmployeeIDC), "Employee C");
//		logCompare(true,b2wEmp.openEmployeeByID(sEmployeeIDC), "Employee C");
//		logCompare(true,b2wEmp.deleteResource(), "Delete");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.clickClearSearchButton(), "Clear");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.enterTextandSearchForEmployee(sEmployeeIDD), "Employee D");
//		logCompare(true,b2wEmp.openEmployeeByID(sEmployeeIDD), "Employee D");
//		logCompare(true,b2wEmp.deleteResource(), "Employee D");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.clickClearSearchButton(), "Clear");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.enterTextandSearchForEmployee(sEmployeeIDE), "Employee E");
//		logCompare(true,b2wEmp.openEmployeeByID(sEmployeeIDE), "Employee E");
//		logCompare(true,b2wEmp.deleteResource(), "Delete");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wEmp.clickClearSearchButton(), "Clear Search");
//		TaskUtils.sleep(1000);
//		assertTrue("Open Labor", b2wNav.openLaborTypes());
//		logCompare(true,b2wLaborType.searchAndOpenLaborTypeByName(sLaborTypeA), "Open Labor Type A");
//		logCompare(true,b2wLaborType.clickTopDeleteButton(), "Delete");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wLaborType.clickClearSearchButton(), "Clear");
//		TaskUtils.sleep(1000);
//		logCompare(true,b2wLaborType.searchAndOpenLaborTypeByName(sLaborTypeB),"open labor");
//		logCompare(true,b2wLaborType.clickTopDeleteButton(), "Delete");
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();

	}

}
