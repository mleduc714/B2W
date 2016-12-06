package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.util.TaskUtils;

public class B2WEquipmentSmokeTest extends B2WTestCase {
	
	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
	}

	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		super.testMain();
		createSchedule();
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

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
	
	public static void createSchedule(){
		
		B2WEquipmentTasks equipmentTasks = new B2WEquipmentTasks();
		
		B2WNavigationTasks navigation = new B2WNavigationTasks();
		
		navigation.openEquipment();
		
		// Navigate to Maintain>Equipment
		
		equipmentTasks.createNewEquipment();
		
		equipmentTasks.setEquipmentDescription("This is a new Test Equipment");
		
		equipmentTasks.setEquipmentID("1234567890");
		
		equipmentTasks.selectNewEquipmentBusinessUnitFromDropDown("Northern Division\\Paving");
		
		equipmentTasks.selectNewEquipmentTypeFromDropDown("30 Ton Trucks");
		
		equipmentTasks.selectMobilityTypeRequiresMoveFromDropDown();
		
		equipmentTasks.selectOwnershipTypeSubcontractedFromDropDown();
		
		TaskUtils.sleep(5000);
		
		//Enter Equipment Specs
		equipmentTasks.expandEquipmentSpecs();
		
		equipmentTasks.setEquipmentSpecsManufacturer("ABC Construction");
		equipmentTasks.setEquipmentSpecsModel("New");
		equipmentTasks.setEquipmentSpecsYear("1999");//Doenst work
		equipmentTasks.setEquipmentSpecsColor("Blue");
		equipmentTasks.setEquipmentSpecsLojack("12");
		equipmentTasks.setEquipmentSpecsHutStickerNumber("67890");
		equipmentTasks.setEquipmentSpecsEZPassNumber("12345");
		
		//Enter Component Specs
		equipmentTasks.expandComponentSpecs();
		
		equipmentTasks.setComponentSpecsEngine("Engine Name");
		equipmentTasks.setComponentSpecsEngineArrangement("Arrangement");
		equipmentTasks.setComponentSpecsEngineSerialNumber("54321");
		equipmentTasks.setComponentSpecsHorsePower("124");
		equipmentTasks.setComponentSpecsTransmissionModel("A3B2C1");
		equipmentTasks.setComponentSpecsTransmissionSerialNumber("09876");//doesnt work
		equipmentTasks.setComponentSpecsTireSize("13");
		equipmentTasks.setComponentSpecsGET("123");
		equipmentTasks.setComponentSpecsHydraulicFlowRate("23");//doesnt work
		TaskUtils.sleep(5000);
		
		//Enter Financials
		equipmentTasks.expandFinancials();
		equipmentTasks.setFinancialsInsuranceValue("");
		equipmentTasks.setFinancialsPurchasedFrom("");
		equipmentTasks.setFinancialsPurchasePrice("");
		equipmentTasks.setFinancialsSalesPrice("");
		equipmentTasks.setFinancialsSoldTo("");
		equipmentTasks.setFinancialsTitleHolder("");
		
		//Add Meter Types
		equipmentTasks.expandMeters();
		
		equipmentTasks.clickAddMeterButton();
		
		//Add Parts
		equipmentTasks.expandParts();
		
		equipmentTasks.clickAddPartsButton();
		
		//Add a Warranty
		equipmentTasks.expandWarrenties();
		
		// Add a Maintenance Program
		equipmentTasks.expandPrograms();
		
		equipmentTasks.clickAddProgramButton();
		
		// Add Tags
		equipmentTasks.expandTags();
		
		//Add Events
		equipmentTasks.expandEvents();
		
		//Save the Equipment
		equipmentTasks.saveNewEquipment();
		
		// History
		equipmentTasks.expandHistory();
		
		// Location
		equipmentTasks.expandLocation();
		
		equipmentTasks.selectAllEquipmentByTypeView();
		
		equipmentTasks.selectFilterByBusinessUnit("Northern Division\\Paving");
		
		equipmentTasks.selectEquipmentFromViewByID("1234567890");
		
		equipmentTasks.selectEquipmentFromViewByDescription("This is a new Test Equipment");
	}
	
}