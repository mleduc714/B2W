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
import tasks.resources.B2WEquipmentTasks;
import tasks.resources.B2WEquipmentTypesTasks;
import tasks.resources.B2WLaborRateClassTasks;
import tasks.resources.B2WMaterialsTasks;
import tasks.resources.B2WNewLaborTypeTasks;
import tasks.resources.B2WPartTasks;
import tasks.resources.B2WPlaceTasks;
import tasks.setup.B2WCategoriesTasks;
import tasks.setup.B2WUserTasks;

public class OperationsSmokeE extends B2WTestCase {

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
	B2WEquipmentTypesTasks B2WEquipTypes = new B2WEquipmentTypesTasks();
	B2WLaborRateClassTasks b2wLRC = new B2WLaborRateClassTasks();
	B2WPartTasks b2wPart = new B2WPartTasks();
	B2WCategoriesTasks b2wCatTasks = new B2WCategoriesTasks();
	B2WEquipmentTasks b2wEquip = new B2WEquipmentTasks();
	
	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");


	String sLaborRate;
	String sLaborRateID;
	String sCategoryA;
	String sCategoryB;
	String sCategoryC;
	String sCategoryD;

	
	String sLow = "Low";
	String sMedium = "Medium";
	String sHigh = "High";
	String sPartA;
	String sPartIDA;
	String sPartB;
	String sPartIDB;
	String sPartC;
	String sPartIDC;
	
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
	String sPlaceBin;


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

		int n = rand.nextInt(10000) + 1;
		sLaborRate = getProperty("laborrateclass")+ n;
		sLaborRateID = getProperty("laborrateclassid") + n;
		sCategoryA = getProperty("categoryNameA");
		sCategoryB = getProperty("categoryNameB");
		sCategoryC = getProperty("categoryNameC");
		sCategoryD = getProperty("categoryNameD");
		sPartA = getProperty("partA");
		sPartIDA = getProperty("partIDA") + n;
		sPartB = getProperty("partB");
		sPartIDB = getProperty("partIDB")+ n;
		sPartC = getProperty("partC");
		sPartIDC = getProperty("partIDC")+ n;
		
		sPlaceDescription = getProperty("placeD") +n;
		sPlaceID = getProperty("placeIDD") + n;
		sPlaceBusinessUnit = getProperty("placebusinessunitD");
		sPlaceCategory = getProperty("placecategoryD");
		sPlaceAddress = getProperty("placeaddress1D");
		sPlaceCity = getProperty("placecityD");
		sPlaceState = getProperty("placestateD");
		sPlaceZip = getProperty("placepostalcodeD");
		sPlaceCountry = getProperty("placecountryD");
		sPlaceBin = getProperty("placebin");
		
	}

	public void testMain() throws Throwable {
		
		// create labor rate class
		// create categories
		// create parts
		// create place
		// create organization
		createLaborRateClass(sLaborRate, sLaborRateID, "Hauling" );
		createTrackPart();
		createMeter();
		createMaintenanceRequests();
		createPart(sPartA, sPartIDA, sCategoryA );
		createPart(sPartB, sPartIDB, sCategoryA );
		createPart(sPartC, sPartIDC, sCategoryA );
		createPlace();
		
	}
		

	
	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();

		
		

	}
	
	public void createTrackPart() {
		logCompare(true,b2wNav.openCategories(),"Open Categories");
		b2wCatTasks.selectPartCategory();
		logCompare(true,b2wCatTasks.enterTextAndClickSearch(sCategoryA), "search for category");
		if (!b2wCatTasks.isCategoryInListing(sCategoryA)){
			logCompare(true,b2wCatTasks.clickCreateNewCategory(),"Create new category");
			logCompare(true,b2wCatTasks.setCategoryName(sCategoryA), "Set Category Name");
			logCompare(true,b2wCatTasks.clickTopSaveButton(), "Save Category");
			logCompare(sCategoryA, b2wCatTasks.getGenInfoNameValueLabel(), "Category Name");
		}
		
	}
	
	public void createMeter() {
		logCompare(true,b2wNav.openCategories(), "Open Catgories");
		b2wCatTasks.selectMeterCategory();
		logCompare(true,b2wCatTasks.enterTextAndClickSearch(sCategoryB), "Search for Category");
		if (!b2wCatTasks.isCategoryInListing(sCategoryB)){
			logCompare(true,b2wCatTasks.clickCreateNewCategory(),"Create new category");
			logCompare(true,b2wCatTasks.setCategoryName(sCategoryB), "Set Category Name");
			logCompare(true,b2wAct.selectUnitOfMeasure("HR"), "Select Unit of measure");
			logCompare(true,b2wCatTasks.clickTopSaveButton(), "Save Category");
			logCompare("HR", b2wCatTasks.getAccountUnitOfMeasureText(), "Unit of Measure");
			logCompare(sCategoryB, b2wCatTasks.getGenInfoNameValueLabel(), "Meter Name");
		}
	}
	
	
	public void createMaintenanceRequests() {
		logCompare(true,b2wNav.openCategories(),"Open Categories");
		b2wCatTasks.selectMaintenanceRequestType();
		logCompare(true,b2wCatTasks.enterTextAndClickSearch(sCategoryC), "Enter Text and Search");
		if (!b2wCatTasks.isCategoryInListing(sCategoryC)){
			logCompare(true,b2wCatTasks.clickCreateNewCategory(),"Create New Category");
			logCompare(true,b2wCatTasks.setCategoryName(sCategoryC), "Set Category Name");
			logCompare(true,b2wCatTasks.selectRequestClassificiationTypePlanned(), "Set to planned");
			logCompare(true,b2wCatTasks.clickTopSaveButton(),"Save Category");
		}
		logCompare(true,b2wNav.openCategories(),"Open Categories");
		b2wCatTasks.selectMaintenanceRequestType();
		logCompare(true,b2wCatTasks.enterTextAndClickSearch(sCategoryD), "Enter text and search");
		if (!b2wCatTasks.isCategoryInListing(sCategoryD)){
			logCompare(true,b2wCatTasks.clickCreateNewCategory(),"Create new Category");
			logCompare(true,b2wCatTasks.setCategoryName(sCategoryD), "Set Category");
			logCompare(true,b2wCatTasks.selectRequestClassificiationTypeUnplanned(), "Set to unplanned");
			logCompare(true,b2wCatTasks.clickTopSaveButton(),"Save Category");
		}
	}
	
	public void maintenanceRequestPriorities(String sName, String sColor) {
		b2wNav.openCategories();
		b2wCatTasks.selectMaintenanceRequestPriority();
		b2wCatTasks.enterTextAndClickSearch(sName);
		if (!b2wCatTasks.isCategoryInListing(sName)){
			b2wCatTasks.clickCreateNewCategory();
			b2wCatTasks.setCategoryName(sName);
			b2wCatTasks.setCategoryAssociatedColor(sColor);
			b2wCatTasks.clickTopSaveButton();
		}
		
		
	}
	
	public void workOrderPriorities(String sName, String sColor) {
		b2wNav.openCategories();
		b2wCatTasks.selectWorkOrderPriority();
		b2wCatTasks.enterTextAndClickSearch(sName);
		if (!b2wCatTasks.isCategoryInListing(sName)){
			b2wCatTasks.clickCreateNewCategory();
			b2wCatTasks.setCategoryName(sName);
			b2wCatTasks.setCategoryAssociatedColor(sColor);
			b2wCatTasks.clickTopSaveButton();
		}
		
	}
	
	public void createLaborRateClass(String sName, String sID, String sUnit){
		logCompare(true,b2wNav.openLaborRateClasses(), "Open Labor Rate Class");
		logCompare(true,b2wLRC.createNewLaborRateClass(), "Create new Labor Rate Class");
		logCompare(true,b2wLRC.setLaborRateName(sName), "Set Labor Rate Name");
		logCompare(true,b2wLRC.setLaborRateID(sID), "Set Labor Rate ID");
		logCompare(true,b2wLRC.setLaborRateBusinessUnit(sUnit)," Set Business Unit");
		logCompare(true,b2wLRC.clickTopSaveButton(), "Save the Labor Rate Class");
		logCompare(sName,b2wLRC.getGenInfoNameLabel(), "Labor Rate Name");
		logCompare(sID,b2wLRC.getGenInfoAccountIDLabel(), "Labor Rate ID");
		logCompare(sUnit,b2wLRC.getAccountBusinessUnitLink(), "Business Unit");
		
	}
	

	
	public void createPart(String sPart, String sPartID, String sCategory){
		logCompare(true,b2wNav.openParts(), "Open Parts");
		logCompare(true,b2wPart.createNewPart(), "Create new Part");
		logCompare(true,b2wPart.setPartDescription(sPart), "Set Part");
		logCompare(true,b2wPart.setPartID(sPartID), "Set Part ID");
		logCompare(true,b2wPart.selectBusinessUnit("Hauling"), "Set to Hauling");
		logCompare(true,b2wPart.selectCategory(sCategory), "Select the Category");
		logCompare(true,b2wPart.selectUnitOfMeasure("SET"), "Set Unit of Measure");
		logCompare(true,b2wPart.clickTopSaveButton(), "Save Part");
		logCompare(sPart,b2wPart.getDescriptionText(), "Part Description");
		logCompare(sPartID, b2wPart.getGenInfoAccountIDLabel(), "Part ID");
		logCompare("Hauling", b2wPart.getAccountBusinessUnitLink(),"Business Unit");
		logCompare("SET", new B2WMaterialsTasks().getAccountUnitofMeasureText(), "Unit of measure");

		
	}
	public void createPlace() {
		
		Calendar cal = Calendar.getInstance();
		sPlaceStartDate = format.format(cal.getTime());
		
		assertTrue("Open Places", b2wNav.openPlaces());
		assertTrue("Create new place", b2wPlaces.createNewPlaceButton());
		logCompare(true, b2wPlaces.setPlaceID(sPlaceID), "Enter Place ID");
		logCompare(true, b2wPlaces.checkProducesMaterials(), "Check produces materials");
		logCompare(true, b2wPlaces.setPlaceDescription(sPlaceDescription), "Place Description");
		logCompare(true, b2wPlaces.selectBusinessUnit(sPlaceBusinessUnit), "Select Business Unit");
		logCompare(true, b2wPlaces.setPlaceCategory(sPlaceCategory), "set category");

		logCompare(true, b2wPlaces.setStartDate(sPlaceStartDate), "Set date to today");
		logCompare(true, b2wPlaces.setNonWorkingDaySaturday(true), "not working saturday");
		logCompare(true, b2wPlaces.setNonWorkingDaySunday(true), "not working sunday");
		logCompare(true, b2wPlaces.setLocationAddress1(sPlaceAddress), "Set Address");
		logCompare(true, b2wPlaces.setLocationCity(sPlaceCity), "Set City");
		logCompare(true, b2wPlaces.setLocationState(sPlaceState), "Set State");
		logCompare(true, b2wPlaces.setLocationPostalCode(sPlaceZip), "Set ZipCode");
		logCompare(true, b2wPlaces.setLocationCountry(sPlaceCountry), "Set Country");
		logCompare(true, b2wPlaces.clickTopSaveButton(), "Save Place");
		logCompare(sPlaceStartDate,b2wPlaces.getStartDateText(), "Start Date");
		logCompare(sPlaceBusinessUnit, b2wPlaces.getAccountBusinessUnitLink(), "Business Link");
		logCompare(sPlaceID,b2wPlaces.getPlaceIDText(), "Place ID");
		logCompare("Saturday, Sunday", b2wPlaces.getNonWorkingDaysText(), "Not working sat and sun");
		logCompare(true, b2wPlaces.createBin(), "Create Bin");
		logCompare(true, b2wPlaces.setPlaceBinDescription(sPlaceBin), "New Bin");
		logCompare(true,b2wPlaces.clickSaveBin(),"Save Bin");
		logCompare(sPlaceBin, b2wPlaces.getInventoryBinDescription(), "Inventory Description");
	}
	
	
	

}
