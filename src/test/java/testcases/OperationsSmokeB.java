package testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class OperationsSmokeB extends B2WTestCase {

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

	String sProductionAccountDesc;
	String sProductionAccountID;
	String sProductionAccountBusinessUnit;
	String sProductionAccountUnitOfMeasure;
	String sProductionAccountNotes;

	String sOverheadAccountDesc;
	String sOverheadAccountID;
	String sOverheadAccountBusinessUnit;
	String sOverheadAccountNotes;

	String sMaterialsDescriptionA;
	String sMaterialsUnitOfMeasureA;
	String sMaterialsTotalCountA;
	String sMaterialsIDA;
	String sMaterialsCountA;

	String sMaterialsDescriptionB;
	String sMaterialsUnitOfMeasureB;
	String sMaterialsTotalCountB;
	String sMaterialsIDB;
	String sMaterialsCountB;

	String sMaterialsDescriptionC;
	String sMaterialsIDC;

	String sMaterialsDescriptionD;
	String sMaterialsIDD;

	String sPlaceDescription;
	String sPlaceID;
	String sPlaceBusinessUnit;
	String sPlaceCategory;
	String sPlaceAddress;
	String sPlaceCity;
	String sPlaceState;
	String sPlaceZip;
	String sPlaceCountry;
	String sPlaceStartDate;

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
		
		
		Calendar cal = Calendar.getInstance();
		sPlaceStartDate = format.format(cal.getTime());
		sProductionAccountDesc = getProperty("productionaccountdescription");
		sProductionAccountID = getProperty("productionaccountaccountid") + n;
		sProductionAccountBusinessUnit = getProperty("productionaccountbusinessunit");
		sProductionAccountUnitOfMeasure = getProperty("productionaccountunitofmeasure");
		sProductionAccountNotes = getProperty("productionacountnotes");
		sOverheadAccountDesc = getProperty("overheadaccountdescription");
		sOverheadAccountID = getProperty("overheadaccountaccountid") + n;
		sOverheadAccountBusinessUnit = getProperty("overheadaccountbusinessunit");
		sOverheadAccountNotes = getProperty("overheadacountnotes");

		sMaterialsDescriptionA = getProperty("materialdescriptionA");
		sMaterialsUnitOfMeasureA = getProperty("matieralunitofmeasureA");
		sMaterialsTotalCountA = getProperty("materialtotalcountA");
		sMaterialsIDA = getProperty("materialIDA") + n;
		sMaterialsCountA = getProperty("materialtotalcountA");

		sMaterialsDescriptionB = getProperty("materialdescriptionB");
		sMaterialsUnitOfMeasureB = getProperty("matieralunitofmeasureB");
		sMaterialsIDB = getProperty("materialIDB") + n;

		sMaterialsDescriptionC = getProperty("materialdescriptionC");
		sMaterialsIDC = getProperty("materialIDC") + n;

		sMaterialsDescriptionD = getProperty("materialdescriptionD");
		sMaterialsIDD = getProperty("materialIDD") + n;

		sPlaceDescription = getProperty("place") +n;
		sPlaceID = getProperty("placeID") + n;
		sPlaceBusinessUnit = getProperty("placebusinessunit");
		sPlaceCategory = getProperty("placecategory");
		sPlaceAddress = getProperty("placeaddress1");
		sPlaceCity = getProperty("placecity");
		sPlaceState = getProperty("placestate");
		sPlaceZip = getProperty("placepostalcode");
		sPlaceCountry = getProperty("placecountry");

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
	

		sLaborRateClass = getProperty("laborrateclass");
		

	}

	public void testMain() throws Throwable {

		createProductionAccount();
		verifyProductionAccount();
		assertTrue("Click Home", b2wNav.clickHome());
		createOverheadAccount();
		verifyOverheadAccount();
		createMaterialsA();
		createMaterialsB();
		createMaterialsC();
		createMaterialsD();
		createPlace();
		
	}

	public void createProductionAccount() {

		assertTrue("Open Accounts", b2wNav.openAccounts());
		assertTrue("collapse production accounts", b2wAct.collapseProductionAccounts());
		assertTrue("Create new production account", b2wAct.clickCreateNewProductionAccountButton());
		logCompare(true, b2wAct.setDescription(sProductionAccountDesc), "Enter in description for account");
		logCompare(true, b2wAct.setAccountID(sProductionAccountID), "Enter in Account ID");
		logCompare(true, b2wAct.selectBusinessUnit(sProductionAccountBusinessUnit), "Enter Production Business Unit");
		logCompare(true, b2wAct.selectUnitOfMeasure(sProductionAccountUnitOfMeasure), "Enter Unit of Measure");
		logCompare(true, b2wAct.setNotes(sProductionAccountNotes), "Enter in Notes");
		logCompare(true, b2wAct.clickTopSaveButton(), "Save Account");

	}

	public void createOverheadAccount() {

		assertTrue("Open Accounts", b2wNav.openAccounts());
		assertTrue("collapse overhead accounts", b2wAct.collapseOverheadAccounts());
		assertTrue("Create an Overhead account", b2wAct.clickCreateNewOverheadAccountButton());
		logCompare(true, b2wAct.setDescription(sOverheadAccountDesc), "Set " + sOverheadAccountDesc);
		logCompare(true, b2wAct.selectBusinessUnit(sOverheadAccountBusinessUnit), "Overhead Business Unit");
		logCompare(true, b2wAct.setAccountID(sOverheadAccountID), "Overhead Account ID");
		logCompare(true, b2wAct.setNotes(sOverheadAccountNotes), "Enter Notes");
		assertTrue("click save button", b2wAct.clickTopSaveButton());

	}

	public void verifyProductionAccount() {

		logCompare(sProductionAccountDesc, b2wAct.getDescriptionText(), "Description");
		logCompare(sProductionAccountID, b2wAct.getGenInfoAccountIDLabel(), "Account ID");
		logCompare(sProductionAccountBusinessUnit, b2wAct.getAccountBusinessUnitLink(), "Business Unit");
		logCompare(sProductionAccountUnitOfMeasure, b2wAct.getAccountUnitofMeasureText(), "Unit of Measure");
		logCompare(sProductionAccountNotes, b2wAct.getAccountNotesText(), "Notes for account");

	}

	public void verifyOverheadAccount() {

		logCompare(sOverheadAccountDesc, b2wAct.getDescriptionText(), "Description");
		logCompare(sOverheadAccountID, b2wAct.getGenInfoAccountIDLabel(), "Account ID");
		logCompare(sOverheadAccountBusinessUnit, b2wAct.getAccountBusinessUnitLink(), "Business Unit");
		logCompare(sOverheadAccountNotes, b2wAct.getAccountNotesText(), "Notes Account");

	}

	public void createMaterialsA() {

		assertTrue("Open Materials", b2wNav.openMaterials());
		assertTrue("Click Materials Button", b2wMat.clickCreateNewMaterialsButton());
		assertTrue("Set Description", b2wMat.setDescription(sMaterialsDescriptionA));
		assertTrue("Set Material ID", b2wMat.setMaterialID(sMaterialsIDA));
		assertTrue("Set Unit Of Measure", b2wMat.selectUnitOfMeasure(sMaterialsUnitOfMeasureA));
		assertTrue("Set Category", b2wMat.selectCategory("Asphalt"));
		logCompare(true, b2wMat.checkTemporaryMaterial(true), "Check Temp Material");
		logCompare(true, b2wMat.checkTrackableMaterial(true), "Trackable Material");
		logCompare(true, b2wMat.setTotalCount(sMaterialsTotalCountA), "Set Total Cost");
		if (logCompare(true, b2wAct.clickTopSaveButton(), "Save the Material")) {
			logCompare(sMaterialsDescriptionA, b2wMat.getMaterialDescriptionText(), "Verify Text");
			logCompare(sMaterialsIDA, b2wMat.getMaterialIDText(), "Verify ID");
			logCompare(sMaterialsUnitOfMeasureA, b2wMat.getAccountUnitofMeasureText(), "Unit of Measure");
			logCompare("Yes", b2wMat.getMaterialTempMaterialText(), "Temp Material");
			logCompare("Yes", b2wMat.getMaterialTrackableText(), "Material is Trackable");
			logCompare(sMaterialsTotalCountA, b2wMat.getMaterialTotalCountText(), "Total Count");
		}

	}

	public void deleteMaterial(String sDesc) {

		assertTrue("Open Materials", b2wNav.openMaterials());
		if (logCompare(true, b2wMat.searchOpenResourceByDescription(sDesc), "Open the resource " + sDesc)) {
			logCompare(true, b2wMat.deleteResource(), "Delete " + sDesc);
		}

	}

	public void createMaterialsB() {

		assertTrue("Open Materials", b2wNav.openMaterials());
		assertTrue("Click Materials Button", b2wMat.clickCreateNewMaterialsButton());
		assertTrue("Set Description", b2wMat.setDescription(sMaterialsDescriptionB));
		assertTrue("Set Material ID", b2wMat.setMaterialID(sMaterialsIDB));
		assertTrue("Set Unit Of Measure", b2wMat.selectUnitOfMeasure(sMaterialsUnitOfMeasureB));
		assertTrue("Set Category", b2wMat.selectCategory("Asphalt"));
		logCompare(true, b2wMat.checkTemporaryMaterial(true), "Check Temp Material");
		if (logCompare(true, b2wAct.clickTopSaveButton(), "Save the Material")) {
			logCompare(sMaterialsDescriptionB, b2wMat.getMaterialDescriptionText(), "Verify Text");
			logCompare(sMaterialsIDB, b2wMat.getMaterialIDText(), "Verify ID");
			logCompare(sMaterialsUnitOfMeasureB, b2wMat.getAccountUnitofMeasureText(), "Unit of Measure");
		}

	}

	public void createMaterialsC() {

		assertTrue("Open Materials", b2wNav.openMaterials());
		assertTrue("Click Materials Button", b2wMat.clickCreateNewMaterialsButton());
		assertTrue("Set Description", b2wMat.setDescription(sMaterialsDescriptionC));
		assertTrue("Set Material ID", b2wMat.setMaterialID(sMaterialsIDC));
		assertTrue("Set Unit Of Measure", b2wMat.selectUnitOfMeasure(sMaterialsUnitOfMeasureA));
		assertTrue("Set Category", b2wMat.selectCategory("Asphalt"));
		if (logCompare(true, b2wAct.clickTopSaveButton(), "Save the Material")) {
			logCompare(sMaterialsDescriptionC, b2wMat.getMaterialDescriptionText(), "Verify Text");
			logCompare(sMaterialsIDC, b2wMat.getMaterialIDText(), "Verify ID");
			logCompare(sMaterialsUnitOfMeasureA, b2wMat.getAccountUnitofMeasureText(), "Unit of Measure");

		}

	}

	public void createMaterialsD() {

		assertTrue("Open Materials", b2wNav.openMaterials());
		assertTrue("Click Materials Button", b2wMat.clickCreateNewMaterialsButton());
		assertTrue("Set Description", b2wMat.setDescription(sMaterialsDescriptionD));
		assertTrue("Set Material ID", b2wMat.setMaterialID(sMaterialsIDD));
		assertTrue("Set Unit Of Measure", b2wMat.selectUnitOfMeasure(sMaterialsUnitOfMeasureA));
		assertTrue("Set Category", b2wMat.selectCategory("Asphalt"));
		if (logCompare(true, b2wAct.clickTopSaveButton(), "Save the Material")) {
			logCompare(sMaterialsDescriptionD, b2wMat.getMaterialDescriptionText(), "Verify Text");
			logCompare(sMaterialsIDD, b2wMat.getMaterialIDText(), "Verify ID");
			logCompare(sMaterialsUnitOfMeasureA, b2wMat.getAccountUnitofMeasureText(), "Unit of Measure");

		}

	}

	public void createPlace() {
		assertTrue("Open Places", b2wNav.openPlaces());
		assertTrue("Create new place", b2wPlaces.createNewPlaceButton());
		logCompare(true, b2wPlaces.setPlaceID(sPlaceID), "Enter Place ID");
		logCompare(true, b2wPlaces.checkProducesMaterials(), "Check produces materials");
		logCompare(true, b2wPlaces.setPlaceDescription(sPlaceDescription), "Place Description");
		logCompare(true, b2wPlaces.selectBusinessUnit(sPlaceBusinessUnit), "Select Business Unit");
		logCompare(true, b2wPlaces.setPlaceCategory(sPlaceCategory), "set category");
		
		if (logCompare(true, b2wPlaces.clickAddMaterialsButton(), "Add Materials")) {
			logCompare(true, b2wAdd.setSearchMaterialsText(sMaterialsDescriptionC),
					" Enter in " + sMaterialsDescriptionC);
			if (logCompare(true, b2wAdd.setIDToSelect(sMaterialsIDC), " Enter in ID " + sMaterialsIDC)) {
				logCompare(true, b2wAdd.clickSelectButton(), "Select Button");
				TaskUtils.sleep(1000);
				logCompare(true, b2wAdd.clickAddButton(), "Add the materials");
				logCompare(sMaterialsDescriptionC, b2wPlaces.getMaterialsGridText(0),
						"The Material " + sMaterialsDescriptionC + " has been added");
			}else{
				b2wAdd.clickAddButton();
			}
		}
		if (logCompare(true, b2wPlaces.clickAddMaterialsButton(), "Add Materials")) {
			logCompare(true, b2wAdd.setSearchMaterialsText(sMaterialsDescriptionD),
					" Search for sMaterialsDescriptionD");
			if (logCompare(true, b2wAdd.setIDToSelect(sMaterialsIDD), "Select Materials by ID")) {
				logCompare(true, b2wAdd.clickSelectButton(), "Click Select Button");
				TaskUtils.sleep(1000);
				logCompare(true, b2wAdd.clickAddButton(), "Click Add Button");
				logCompare(sMaterialsDescriptionD, b2wPlaces.getMaterialsGridText(1),
						"The Material " + sMaterialsDescriptionD + " has been added");
			} else {
				b2wAdd.clickAddButton();
			}
		}
		TaskUtils.sleep(1000);
		logCompare(true, b2wPlaces.setStartDate(sPlaceStartDate), "Set date to today");
		logCompare(true, b2wPlaces.setNonWorkingDaySaturday(true), "not working saturday");
		logCompare(true, b2wPlaces.setNonWorkingDaySunday(true), "not working sunday");
		logCompare(true, b2wPlaces.setLocationAddress1(sPlaceAddress), "Set Address");
		logCompare(true, b2wPlaces.setLocationCity(sPlaceCity), "Set City");
		logCompare(true, b2wPlaces.setLocationState(sPlaceState), "Set State");
		logCompare(true, b2wPlaces.setLocationPostalCode(sPlaceZip), "Set ZipCode");
		logCompare(true, b2wPlaces.setLocationCountry(sPlaceCountry), "Set Country");
		logCompare(true, b2wPlaces.clickTopSaveButton(), "save Place");
		logCompare(sPlaceStartDate,b2wPlaces.getStartDateText(), "Start Date");
		logCompare(sPlaceBusinessUnit, b2wPlaces.getAccountBusinessUnitLink(), "Business Link");
		logCompare(sPlaceID,b2wPlaces.getPlaceIDText(), "Place ID");
		logCompare("Saturday, Sunday", b2wPlaces.getNonWorkingDaysText(), "Not working sat and sun");
		
	}



	public void deleteProductionAccount() {
		assertTrue("Open Accounts", b2wNav.openAccounts());
		b2wAct.collapseOverheadAccounts();
		b2wAct.expandProductionAccounts();
		logCompare(true, b2wAct.deleteProductionAccountByDescription(sProductionAccountDesc),
				"Delete " + sProductionAccountDesc);

	}

	public void deleteOverheadAccount() {
		assertTrue("Open Accounts", b2wNav.openAccounts());
		b2wAct.collapseProductionAccounts();
		b2wAct.expandOverheadAccounts();
		logCompare(true, b2wAct.deleteOverheadAccountByDescription(sOverheadAccountDesc),
				"Deleted " + sOverheadAccountDesc);

	}
	public void deletePlace() {
		b2wNav.openPlaces();
		b2wPlaces.searchOpenResourceByDescription(sPlaceDescription);
		b2wPlaces.deleteResource();
	}
	
	
	public void deleteAll() {
		deleteProductionAccount();
		deleteOverheadAccount();
		deletePlace();
		assertTrue("Click Home", b2wNav.clickHome());
		deleteMaterial(sMaterialsDescriptionA);
		deleteMaterial(sMaterialsDescriptionB);
		deleteMaterial(sMaterialsDescriptionC);
		deleteMaterial(sMaterialsDescriptionD);

	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	

	}

}
