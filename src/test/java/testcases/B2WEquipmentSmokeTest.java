package testcases;

import java.util.Random;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEvent;
import tasks.dialogs.B2WAddMeterToEquipment;
import tasks.dialogs.B2WAddPartsToEquipment;
import tasks.dialogs.B2WAddWarranty;
import tasks.resources.B2WEquipmentTasks;
import tasks.util.TaskUtils;


public class B2WEquipmentSmokeTest extends B2WTestCase {
	
	// TODO strings
	String sManufacturer, sModel, sYear, sColor, sLojack, sHutStickerNumber, sEZPassNumber, sTireSize, sEngine, EngineArrangement, 
	sEngineSerialNumber, sHorsePower, sTransmissionModel, sTransmissionSerialNumber, sGET, sHydraulicFlowRate;
	@Override
	public void testSetUp() throws Throwable {
		// TODO out source strings to equipmentsmoke.properties in data/equipment
		sManufacturer = getProperty("sManufacturer");
		sModel  = getProperty("sModel");
		sYear = getProperty("sYear");
		sColor  = getProperty("sColor");
		sLojack  = getProperty("sLojack");
		sHutStickerNumber  = getProperty("sHutStickerNumber");
		sEZPassNumber  = getProperty("sEZPassNumber");
		
		sTireSize = getProperty("sTireSize");
		sEngine = getProperty("sEngine");
		EngineArrangement = getProperty("EngineArrangement");
		sEngineSerialNumber = getProperty("sEngineSerialNumber");
		sHorsePower = getProperty("sHorsePower");
		sTransmissionModel = getProperty("sTransmissionMode");
		sTransmissionSerialNumber = getProperty("sTransmissionSerialNumber");
		sGET = getProperty("sGET");
		sHydraulicFlowRate = getProperty("sHydraulicFlowRate");
		
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
		return "data/equipment";
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
	
	public void createSchedule(){
		
		B2WEquipmentTasks equipmentTasks = new B2WEquipmentTasks();
		
		B2WNavigationTasks navigation = new B2WNavigationTasks();
		
		B2WAddWarranty warranty = new B2WAddWarranty();
		
		B2WAddEvent events = new B2WAddEvent();
		
		Random random = new Random();
		
		B2WAddPartsToEquipment equipmentParts = new B2WAddPartsToEquipment();
		
		B2WAddMeterToEquipment b2waddmeter = new B2WAddMeterToEquipment();
		
		logCompare(true, navigation.openEquipment(), "Open Equipment Page");
		
	
		// Navigate to Maintain>Equipment
		
		logCompare(true, equipmentTasks.createNewEquipment(), "Create New Equipment");
		
		String description = "This is a new Test Equipment # " + random.nextInt(5000) + 1;
		
		String id = "" + random.nextInt(50000) + 1;
		
		logCompare(true, equipmentTasks.setEquipmentDescription(description), "Set Equipment  Description");
		
		logCompare(true, equipmentTasks.setEquipmentID(id), "Set Equipment ID");
		
		logCompare(true, equipmentTasks.selectNewEquipmentBusinessUnitFromDropDown("Northern Division\\Paving"), "Set Business Unit");
		
		logCompare(true, equipmentTasks.selectNewEquipmentTypeFromDropDown("30 Ton Trucks"), "Set Equipment Type");
		
		logCompare(true, equipmentTasks.selectMobilityTypeRequiresMoveFromDropDown(), "Set Mobility Type to Resuires Move");
		
		logCompare(true, equipmentTasks.selectOwnershipTypeOwnedFromDropDown(), "Set Ownership Type to Owned");
		
		//Enter Equipment Specs
		logCompare(true, equipmentTasks.expandEquipmentSpecs(), "Expand Equipment Specs");
		
		//TODO Update compares with Strings and update compare text as demonstrated below
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Manufacturer", sManufacturer), "Set Manufacturer");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Model", sModel), "Model");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Year", sYear), "Year");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Color", sColor), "Color");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Lojack", sLojack), "Lojack");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("Hut Sticker Number", sHutStickerNumber), "Hut Sticker Number");
		logCompare(true, equipmentTasks.setTextEquipmentSpecs("EZ Pass Number", sEZPassNumber), "EZ Pass Number");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Length", "2354", "Foot [FOOT]"), "Length");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Width", "43", "Mile [MILE]"), "Width");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Height", "5433", "Millimeter [mm]"), "Height");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Max Weight", "445", "Gram [g]"), "Max Weight");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Combined Weight", "56", "Ton [TON]"), "Combined Weight");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Tare Weight", "45", "Kilogram [kg]"), "Tare Weight");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("Ground Pressure", "56", "Thousand Cubic Feet [MCF]"), "Ground Pressure");
		
		logCompare(true, equipmentTasks.collapseEquipmentSpecs(), "Collapse Equipment Specs");
		
		//Enter Component Specs
		
		logCompare(true, equipmentTasks.expandComponentSpecs(), "Expand Component Specs");
		logCompare(true, equipmentTasks.setComponentSpecsProductionDate("10/11/2016"), "Production Date");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Tire Size", sTireSize), "Text Component Specs");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine", sEngine), "Engine");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine Arrangement", EngineArrangement), "Engine Arrangement");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine Serial Number", sEngineSerialNumber), "Engine Serial Number");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Horse Power", sHorsePower), "Horse Power");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Transmission Model", sTransmissionModel), "Transmission Model");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Transmission Serial Number", sTransmissionSerialNumber), "Transmission Serial Number");
		logCompare(true, equipmentTasks.setTextComponentSpecs("G.E.T", sGET), "G.E.T");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Hydraulic Flow Rate", sHydraulicFlowRate), "Hydraulic Flow Rate");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Fuel Type", null, "Gasoline [GAS]"), "Select Fuel Type");
	    logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Wheel Type", null, "Rubber Tire [RTR]"), "Select Wheel Type");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Track Type", null, "In-Line Sprocket [ILSP]"), "Select Track Type");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Brake Type", null, "Pneumatic Brakes [AIRB]"), "Select Brake Type");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Cutting Edge", null, "Grader Blades [GRADB]"), "Select Cutting Edge");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Hydraulic Pump Type", null, "Load Sensing Pump [LSP]"), "Select Hydraulic Pump Type");
		
		logCompare(true, equipmentTasks.collapseComponentSpecs(), "Collapse Component Specs");
		
		//Enter Financials
		logCompare(true, equipmentTasks.expandFinancials(), "Expand Financials");
		
		logCompare(true, equipmentTasks.setFinancialsPurchasedFrom("ABC Construction"), "Financials Purchased From");
		logCompare(true, equipmentTasks.setFinancialsPurchasePrice("20000"), "Financials Purchase Price");
		logCompare(true, equipmentTasks.setFinancialsInsuranceValue("10000"), "Financials Insurance Values");
		logCompare(true, equipmentTasks.setFinancialsTitleHolder("TH Title Holder"), "Financials Title Holder");
		logCompare(true, equipmentTasks.setFinancialsSoldTo("XYZ Builders"), "Financials Sold To");
		logCompare(true, equipmentTasks.setFinancialsSalesPrice("15000"), "Financials Sales Price");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("CCA Class", null, "CCA-3 [CCA-5%]"), "Set Field and Item");
		
		logCompare(true, equipmentTasks.collapseFinancials(), "Collapse Financials");
		
		//Add Meter Types
		logCompare(true, equipmentTasks.expandMeters(), "Expand Meters");
		
		logCompare(true, equipmentTasks.clickAddMeterButton(), "Click Add Meter");
		logCompare(true, b2waddmeter.selectAddMeterTypeFromDD("Hour Meter"), "Select Add "+"Hour Meter"+" Meter");
		logCompare(true, b2waddmeter.selectAddMeterRequiredOnWorkOrderCompletionNotRequired(), "Add Meter not required");
		logCompare(true, b2waddmeter.selectAddMeterExcludeFromWorkOrdersNever(), "Exclude never");
		logCompare(true, b2waddmeter.setAddMeterIntialReading("20"),"Intial Reading");
		logCompare(true, b2waddmeter.setAddMeterEnterNewReadingCheckBox(), "Enter new reading checkbox");
		logCompare(true, b2waddmeter.setAddMeterEnterNewReading("120"),"Enter new reading");
		logCompare(true, b2waddmeter.setAddMeterEnterNewReadingDate("1/1/2017"), "Set two days ago");
		logCompare(true, b2waddmeter.clickSaveAddMeter(), "Add Meter");
		
		logCompare(true, equipmentTasks.collapseMeters(), "Collapse Meter");
		
		//Add Parts
		logCompare(true, equipmentTasks.expandParts(), "Expand Parts");
		
		logCompare(true, equipmentTasks.clickAddPartsButton(), "Add Parts");
		
		logCompare(true, equipmentParts.selectPartToAddToEquipmentByDescription("Bucket teeth"), "Select Part");

		logCompare(true, equipmentParts.clickSaveAddPart(), "Add Part");
		
		logCompare(true, equipmentTasks.collapseParts(), "Collapse Parts");
		
		//Add a Warranty
		logCompare(true, equipmentTasks.expandWarrenties(), "Expand Warranties");
		
		
		//No click 'Add Warranty' button
		logCompare(true, equipmentTasks.clickAddWarrantyButton(), "Click Add Warranty");
		
		String warrantyDescription = "This is a newly created warranty";
		
		logCompare(true, warranty.setWarrantyDescription(warrantyDescription), "Set Warranty Description");
		logCompare(true, warranty.selectWarrantyType("Equipment"), "Warranty Type");
		logCompare(true, warranty.selectTypeOfDurationCalendar(), "Duration Calendar");
		logCompare(true, warranty.setSpan("234"), "Span");
		logCompare(true, warranty.setSpanDays(), "Span Days");
		logCompare(true, warranty.setStarting("12/31/2016"), "Starting");
		logCompare(true, warranty.clickCompleteButton(), "Complete");

		logCompare(true, warranty.setWarrantyNotes("These are the warranty notes."), "Set Warranty Notes");
		logCompare(true, warranty.clickSaveWarranty(), "Save Warranty");

		logCompare(true, equipmentTasks.collapseWarrenties(), "Collapse Warranties");
		
		
		logCompare(true, equipmentTasks.expandPrograms(), "Expand Programs");
		
		logCompare(true, equipmentTasks.collapsePrograms(), "Collapse Programs");
		
		// Add Tags
		logCompare(true, equipmentTasks.expandTags(), "Expand Tags");
		
		logCompare(true, equipmentTasks.collapseTags(), "Collapse Tags");
		
		//Add Events
		logCompare(true, equipmentTasks.expandEvents(), "Expand Events");
		
		logCompare(true, equipmentTasks.clickAddEventButton(), "Click Add Event");
		logCompare(true, events.selectEventType("Memo"), "Event Type");
		logCompare(true, events.setEventStartDate("12/31/2016"), "Event Start Date");
		logCompare(true, events.setEventEndDate("12/31/2017"), "Event End Date");
		logCompare(true, events.setEventDescription("This is a description in the Description section for an event"), "Event Description");
		logCompare(true, events.clickSaveEvent(), "Save Event");
		
		logCompare(true, equipmentTasks.collapseEvents(), "Collapse Event");
		
		//Save the Equipment
		logCompare(true, equipmentTasks.saveNewEquipment(), "Save New Equipment");
		
		// History
		logCompare(true, equipmentTasks.expandHistory(), "Expand History");
		
		logCompare(true, equipmentTasks.collapseHistory(), "Collapse History");
		
		// Location
		logCompare(true, equipmentTasks.expandLocation(), "Expand Location");
		
		logCompare(true, equipmentTasks.collapseLocation(), "Collapse Location");
		
		
		//Select your equipment
		
		logCompare(true, equipmentTasks.selectAllEquipmentByTypeView(), "");
		
		logCompare(true, equipmentTasks.selectFilterByBusinessUnit("Northern Division\\Paving"), "Select Business Unit in Filter");

		logCompare(true, equipmentTasks.selectEquipmentFromViewByID(id), "Select Equipment "+id);

		logCompare(true, equipmentTasks.selectEquipmentFromViewByDescription(description), "Select Equipment by Description");

		logCompare(true, equipmentTasks.expandWarrenties(), "Expand Waranties");

		logCompare(true, equipmentTasks.editWarranty(warrantyDescription), "Select and Edit Warranty");
		
		String alteredDesc = "The Description was just altered";
		
		logCompare(true, warranty.setWarrantyDescription(alteredDesc), "Set Warranty Description");
		
	    String newWarrantyName = warrantyDescription + alteredDesc;
	    
	    logCompare(true, warranty.clickSaveWarranty(), "Save Warranty");	
		
	    logCompare(true, equipmentTasks.deleteWarranty(newWarrantyName), "Delete Warranty");
	    
	    logCompare(true, equipmentTasks.clickConfirmYes(), "Click Yes");

	    logCompare(true, equipmentTasks.collapseWarrenties(), "Collapse Warranties");
	    
	    
	    // Edit and Delete Meters

	    logCompare(true, equipmentTasks.expandMeters(), "Expand Meters");
		
		
		//****************************
		//DOESN'T WORK:
		//Editing Meters does not work
		//****************************
/*		
	    equipmentTasks.editMeter(meterDescription);
	    TaskUtils.sleep(5000);
		

		logCompare(true, b2waddmeter.setAddMeterEnterNewReadingCheckBox(), "Enter new reading checkbox");
		logCompare(true, b2waddmeter.setAddMeterEnterNewReading("400"),"Enter new reading");
		logCompare(true, b2waddmeter.setAddMeterEnterNewReadingDate("1/7/2017"), "Set two days ago");
		*/
		//b2waddmeter.clickSaveAddMeter();
	    
	    //
		
		//TaskUtils.sleep(5000);

		logCompare(true, equipmentTasks.saveNewEquipment(), "Save Equipment");
		
		TaskUtils.sleep(5000);
	}
	
}