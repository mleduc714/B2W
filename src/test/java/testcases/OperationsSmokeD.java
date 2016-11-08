package testcases;

import java.text.SimpleDateFormat;

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

public class OperationsSmokeD extends B2WTestCase {
	
/*	1) Create Equipment Category
	2) Create 4 Different Equipment Types
    3) Create 4 Different Pieces of Equipment
*/
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

	String sEquipmentTypeNameA;
	String sEquipmentTypeIDA;
	String sEquipmentTypeNameB;
	String sEquipmentTypeIDB;
	String sEquipmentTypeNameC;
	String sEquipmentTypeIDC;
	String sEquipmentTypeNameD;
	String sEquipmentTypeIDD;

	String sCategoryE;
	String sEquipmentDescA;
	String sEquipmentIDA;
	String sEquipmentDescB;
	String sEquipmentIDB;
	String sEquipmentDescC;
	String sEquipmentIDC;
	String sEquipmentDescD;
	String sEquipmentIDD;

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
		int  n = getRandomNumber();

		sEquipmentTypeNameA = getProperty("equipmenttypeA");
		sEquipmentTypeIDA = getProperty("equipmenttypeidA") + n;
		sEquipmentTypeNameB = getProperty("equipmenttypeB");
		sEquipmentTypeIDB = getProperty("equipmenttypeidB")+ n;
		sEquipmentTypeNameC = getProperty("equipmenttypeC");
		sEquipmentTypeIDC = getProperty("equipmenttypeidC")+ n;
		sEquipmentTypeNameD = getProperty("equipmenttypeD");
		sEquipmentTypeIDD = getProperty("equipmenttypeidD")+ n;

		sCategoryE = getProperty("categoryNameE") + n;


		sEquipmentDescA = getProperty("equipmentA");
		sEquipmentIDA = getProperty("equipmentidA") + n;
		sEquipmentDescB = getProperty("equipmentB");
		sEquipmentIDB = getProperty("equipmentidB")+ n;
		sEquipmentDescC = getProperty("equipmentC");
		sEquipmentIDC = getProperty("equipmentidC")+ n;
		sEquipmentDescD = getProperty("equipmentD");
		sEquipmentIDD = getProperty("equipmentidD")+ n;
		
	}

	public void testMain() throws Throwable {
		
		// create equipment categories, types, and equipment
		
		createEquipmentCategory(sCategoryE);
		createEquipmentType(sEquipmentTypeNameA, sEquipmentTypeIDA, true, sCategoryE);
		createEquipmentType(sEquipmentTypeNameB, sEquipmentTypeIDB, false, sCategoryE);
		createEquipmentType(sEquipmentTypeNameC, sEquipmentTypeIDC, false, sCategoryE);
		createEquipmentType(sEquipmentTypeNameD, sEquipmentTypeIDD, false, sCategoryE);
		createEquipment();
	}
		

	
	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();

		
		

	}
	

	public void createEquipmentCategory(String sCategory){
		logCompare(true,b2wNav.openCategories(),"Open Categories");
		b2wCatTasks.selectEquipmentCategory();
		assertTrue("Create New Category Name",b2wCatTasks.clickCreateNewCategory());
		logCompare(true,b2wCatTasks.setCategoryName(sCategory), "Set Category Name");
		logCompare(true,b2wCatTasks.clickTopSaveButton(), "Save Category");
		
	}
	
	
	public void createEquipmentType(String sName, String sID, boolean bTransport, String sCategory) {

		logCompare(true,b2wNav.openEquipmentTypes(), "Open Equipment Type");
		assertTrue("Create New Equipment",B2WEquipTypes.createNewEquipmentType());
		logCompare(true,B2WEquipTypes.setEquipmentTypeName(sName),"Set Equipment Type Name");
		logCompare(true,B2WEquipTypes.setEquipmentTypeID(sID),"Set Equipment ID");
		logCompare(true,B2WEquipTypes.setEquipmentTypeTransportsMaterials(bTransport), "set to transport");
		logCompare(true,B2WEquipTypes.selectEquipmentTypeCategory(sCategory),"Set Type Category");
		logCompare(true,B2WEquipTypes.selectBusinessUnit("Northern Division\\Paving"), "Select Paving");
		logCompare(true,B2WEquipTypes.clickTopSaveButton(),"Save Type");
		logCompare(sName,B2WEquipTypes.getGenInfoNameLabel(), "Equipment Type name");
		logCompare(sID,B2WEquipTypes.getGenInfoAccountIDLabel(),"Set Equipment ID");
		if (bTransport)
			logCompare("Yes",B2WEquipTypes.getEquipmentTypeTransportsMaterialsText(), "Transports Materials");
		else{
			logCompare("No",B2WEquipTypes.getEquipmentTypeTransportsMaterialsText(), "Transports Materials");
		}
		logCompare(sCategory, B2WEquipTypes.getGenInfoCatgoryLabel(), "Catgory of Equipment Type");
		logCompare("Northern Division\\Paving",B2WEquipTypes.getAccountBusinessUnitLink()," Paving");
		
	}
	

	public void createEquipment(){
		assertTrue("Open Equipment",b2wNav.openEquipment());
		assertTrue("Create New Equipment", b2wEquip.createNewEquipment());
		logCompare(true,b2wEquip.setEquipmentDescription(sEquipmentDescA), "Equipment Description");
		logCompare(true,b2wEquip.setEquipmentID(sEquipmentIDA), "Equipment ID");
		logCompare(true,b2wEquip.selectMobilityTypeSelfMobileFromDropDown(),"Select Self Mobile");
		logCompare(true,b2wEquip.selectNewEquipmentBusinessUnitFromDropDown("Hauling"), "Select Business Unit");
		logCompare(true,b2wEquip.selectNewEquipmentTypeFromDropDown(sEquipmentTypeNameA), "Select Equipment Type");
		logCompare(true,b2wEquip.saveNewEquipment(), "Save Equipment");
		logCompare("Hauling",b2wEquip.getBusinessUnitOfItem(), "Business Unit");
		logCompare(sEquipmentTypeNameA, b2wEquip.getEquipmentTypeOfItem(), "Equipment Type");
		logCompare(sEquipmentIDA + " ["+sEquipmentDescA+"]", b2wEquip.getEquipmentHeadline(), "Headline");
		logCompare(true, b2wEquip.saveNewEquipment(), "Save Equipment");
		
		assertTrue("Create New Equipment", b2wEquip.createNewEquipment());
		logCompare(true,b2wEquip.setEquipmentDescription(sEquipmentDescB), "Equipment Description");
		logCompare(true,b2wEquip.setEquipmentID(sEquipmentIDB), "Equipment ID");
		logCompare(true,b2wEquip.selectMobilityTypeMovesOtherEquipmentFromDropDown(),"Select Moves Other Equipment");
		logCompare(true,b2wEquip.selectNewEquipmentBusinessUnitFromDropDown("Hauling"), "Select Business Unit");
		logCompare(true,b2wEquip.selectNewEquipmentTypeFromDropDown(sEquipmentTypeNameB), "Select Equipment Type");
		logCompare(true,b2wEquip.saveNewEquipment(), "Save Equipment");
		logCompare("Hauling",b2wEquip.getBusinessUnitOfItem(), "Business Unit");
		logCompare(sEquipmentTypeNameB, b2wEquip.getEquipmentTypeOfItem(), "Equipment Type");
		logCompare(sEquipmentIDB + " ["+sEquipmentDescB+"]", b2wEquip.getEquipmentHeadline(), "Headline");
		logCompare(true, b2wEquip.saveNewEquipment(), "Save Equipment");
		
		assertTrue("Create New Equipment", b2wEquip.createNewEquipment());
		logCompare(true,b2wEquip.setEquipmentDescription(sEquipmentDescC), "Equipment Description");
		logCompare(true,b2wEquip.setEquipmentID(sEquipmentIDC), "Equipment ID");
		logCompare(true,b2wEquip.selectMobilityTypeRequiresMoveFromDropDown(),"Select Requires Move");
		logCompare(true,b2wEquip.selectNewEquipmentBusinessUnitFromDropDown("Hauling"), "Select Business Unit");
		logCompare(true,b2wEquip.selectNewEquipmentTypeFromDropDown(sEquipmentTypeNameC), "Select Equipment Type");
		logCompare(true,b2wEquip.saveNewEquipment(), "Save Equipment");
		logCompare("Hauling",b2wEquip.getBusinessUnitOfItem(), "Business Unit");
		logCompare(sEquipmentTypeNameC, b2wEquip.getEquipmentTypeOfItem(), "Equipment Type");
		logCompare(sEquipmentIDC + " ["+sEquipmentDescC+"]", b2wEquip.getEquipmentHeadline(), "Headline");
		logCompare(true, b2wEquip.saveNewEquipment(), "Save Equipment");
		
		assertTrue("Create New Equipment", b2wEquip.createNewEquipment());
		logCompare(true,b2wEquip.setEquipmentDescription(sEquipmentDescD), "Equipment Description");
		logCompare(true,b2wEquip.setEquipmentID(sEquipmentIDD), "Equipment ID");
		logCompare(true,b2wEquip.selectMobilityTypeSelfMobileFromDropDown(),"Self Mobile");
		logCompare(true,b2wEquip.selectNewEquipmentBusinessUnitFromDropDown("Hauling"), "Select Business Unit");
		logCompare(true,b2wEquip.selectNewEquipmentTypeFromDropDown(sEquipmentTypeNameD), "Select Equipment Type");
		logCompare(true,b2wEquip.saveNewEquipment(), "Save Equipment");
		logCompare("Hauling",b2wEquip.getBusinessUnitOfItem(), "Business Unit");
		logCompare(sEquipmentTypeNameD, b2wEquip.getEquipmentTypeOfItem(), "Equipment Type");
		logCompare(sEquipmentIDD + " ["+sEquipmentDescD+"]", b2wEquip.getEquipmentHeadline(), "Headline");
		logCompare(true, b2wEquip.saveNewEquipment(), "Save Equipment");
		
		
	}
	

}
