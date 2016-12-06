package testcases;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.resources.B2WEquipmentTasks;

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
		
		//Enter Equipment Specs
		equipmentTasks.expandEquipmentSpecs();
		
		equipmentTasks.setTextEquipmentSpecs("Manufacturer", "ABC Construction");
		equipmentTasks.setTextEquipmentSpecs("Model", "5B");
		equipmentTasks.setTextEquipmentSpecs("Year", "1999");
		equipmentTasks.setTextEquipmentSpecs("Color", "Blue");
		equipmentTasks.setTextEquipmentSpecs("Lojack", "12");
		equipmentTasks.setTextEquipmentSpecs("HutStickerNumber", "67890");
		equipmentTasks.setTextEquipmentSpecs("EZPassNumber", "12345");
		
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Lengh", "2354", "Foot [FOOT]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Width", "43", "Mile [MILE]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Height", "5433", "Millimeter [mm]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Max Weight", "445", "Gram [g]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Combined Weight", "56", "Ton [TON]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Tare Weight", "45", "Kilogram [kg]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Ground Pressure", "56", "Thousand Cubic Feet [MCF]");
		
		equipmentTasks.collapseEquipmentSpecs();
		
		//Enter Component Specs
		equipmentTasks.expandComponentSpecs();
		
		equipmentTasks.setTextComponentSpecs("TireSize", "sText");
		equipmentTasks.setTextComponentSpecs("Engine", "Engine Name");
		equipmentTasks.setTextComponentSpecs("EngineArrangement", "Arrangement");
		equipmentTasks.setTextComponentSpecs("EngineSerialNumber", "54321");
		equipmentTasks.setTextComponentSpecs("HorsePower", "124");
		equipmentTasks.setTextComponentSpecs("TransmissionModel", "A3B2C1");
		equipmentTasks.setTextComponentSpecs("TransmissionSerialNumber", "09876");
		equipmentTasks.setTextComponentSpecs("GET", "13");
	    equipmentTasks.setTextEquipmentSpecs("HydraulicFlowRate", "23");
		
	    equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Fuel Type", "null", "Gasoline [GAS]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Wheel Type", "null", "Rubber Tire [RTR]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Track Type", "null", "In-Line Sprocket [ILSP]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Brake Type", "null", "Pneumatic Brakes [AIRB]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Cutting Edge", "null", "Grader Blades [GRADB]");
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Hydraulic Pump Type", "null", "Load Sensing Pump [LSP]");
		
		equipmentTasks.collapseComponentSpecs();
		
		//Enter Financials
		equipmentTasks.expandFinancials();
		
		equipmentTasks.setTextFinancials("PurchasedFrom", "ABC Construction");
		equipmentTasks.setTextFinancials("PurchasedPrice", "20000");
		equipmentTasks.setTextFinancials("InsuranceValue", "10000");
		equipmentTasks.setTextFinancials("TitleHolder", "TH Title Holder");
		equipmentTasks.setTextFinancials("SoldTo", "XYZ Builders");
		equipmentTasks.setTextFinancials("SalePrice", "15000");
		
		equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("CCA Class", "null", "CCA-3 [CCA-5%]");
		
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