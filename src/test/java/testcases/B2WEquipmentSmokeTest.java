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
		
		logCompare(true, equipmentTasks.createNewEquipment(), "");
		
		logCompare(true, equipmentTasks.setEquipmentDescription("This is a new Test Equipment"), "");
		
		logCompare(true, equipmentTasks.setEquipmentID("1234567890"), "");
		
		logCompare(true, equipmentTasks.selectNewEquipmentBusinessUnitFromDropDown("Northern Division\\Paving"), "");
		
		logCompare(true, equipmentTasks.selectNewEquipmentTypeFromDropDown("30 Ton Trucks"), "");
		
		logCompare(true, equipmentTasks.selectMobilityTypeRequiresMoveFromDropDown(), "");
		
		logCompare(true, equipmentTasks.selectOwnershipTypeSubcontractedFromDropDown(), "");
		
		//Enter Equipment Specs
		logCompare(true, equipmentTasks.expandEquipmentSpecs(), "");
		
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Manufacturer", "ABC Construction"), "");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Model", "5B"), "");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Year", "1999"), "");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Color", "Blue"), "");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Lojack", "12"), "");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Hut Sticker Number", "67890"), "");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("EZ Pass Number", "12345"), "");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Length", "2354", "Foot [FOOT]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Width", "43", "Mile [MILE]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Height", "5433", "Millimeter [mm]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Max Weight", "445", "Gram [g]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Combined Weight", "56", "Ton [TON]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Tare Weight", "45", "Kilogram [kg]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Ground Pressure", "56", "Thousand Cubic Feet [MCF]"), "");
		
		logCompare(true, equipmentTasks.collapseEquipmentSpecs(), "");
		
		//Enter Component Specs
		logCompare(true, equipmentTasks.expandComponentSpecs(), "");
		
		logCompare(true, equipmentTasks.setTextComponentSpecs("Tire Size", "sText"), "Text Component Specs");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine", "Engine Name"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine Arrangement", "Arrangement"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine Serial Number", "54321"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Horse Power", "124"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Transmission Model", "A3B2C1"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Transmission Serial Number", "09876"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("GET", "13"), "");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Hydraulic Flow Rate", "23"), "");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Fuel Type", "null", "Gasoline [GAS]"), ""); //Doesn't Work
	    logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Wheel Type", "null", "Rubber Tire [RTR]"), ""); //Doesn't Work
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Track Type", "null", "In-Line Sprocket [ILSP]"), ""); //Doesn't Work
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Brake Type", "null", "Pneumatic Brakes [AIRB]"), ""); //Doesn't Work
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Cutting Edge", "null", "Grader Blades [GRADB]"), ""); //Doesn't Work
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Hydraulic Pump Type", "null", "Load Sensing Pump [LSP]"), ""); //Doesn't Work
		
		logCompare(true, equipmentTasks.collapseComponentSpecs(), "");
		
		//Enter Financials
		logCompare(true, equipmentTasks.expandFinancials(), "");
		
		logCompare(true, equipmentTasks.setTextFinancials("Purchased From", "ABC Construction"), "");
		logCompare(true, equipmentTasks.setTextFinancials("Purchased Price", "20000"), "");
		logCompare(true, equipmentTasks.setTextFinancials("Insurance Value", "10000"), "");
		logCompare(true, equipmentTasks.setTextFinancials("Title Holder", "TH Title Holder"), "");
		logCompare(true, equipmentTasks.setTextFinancials("Sold To", "XYZ Builders"), "");
		logCompare(true, equipmentTasks.setTextFinancials("Sale Price", "15000"), "");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("CCA Class", "null", "CCA-3 [CCA-5%]"), "");
		
		//Add Meter Types
		logCompare(true, equipmentTasks.expandMeters(), "");
		
		logCompare(true, equipmentTasks.clickAddMeterButton(), "");
		
		//Add Parts
		logCompare(true, equipmentTasks.expandParts(), "");
		
		logCompare(true, equipmentTasks.clickAddPartsButton(), "");
		
		//Add a Warranty
		logCompare(true, equipmentTasks.expandWarrenties(), "");
		
		// Add a Maintenance Program
		logCompare(true, equipmentTasks.expandPrograms(), "");
		
		logCompare(true, equipmentTasks.clickAddProgramButton(), "");
		
		// Add Tags
		logCompare(true, equipmentTasks.expandTags(), "");
		
		//Add Events
		logCompare(true, equipmentTasks.expandEvents(), "");
		
		//Save the Equipment
		logCompare(true, equipmentTasks.saveNewEquipment(), "");
		
		// History
		logCompare(true, equipmentTasks.expandHistory(), "");
		
		// Location
		logCompare(true, equipmentTasks.expandLocation(), "");
		
		logCompare(true, equipmentTasks.selectAllEquipmentByTypeView(), "");
		
		logCompare(true, equipmentTasks.selectFilterByBusinessUnit("Northern Division\\Paving"), "");
		
		logCompare(true, equipmentTasks.selectEquipmentFromViewByID("1234567890"), "");
		
		logCompare(true, equipmentTasks.selectEquipmentFromViewByDescription("This is a new Test Equipment"), "");
	}
	
}