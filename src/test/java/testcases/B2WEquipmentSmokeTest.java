package testcases;

import java.util.Random;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEvent;
import tasks.dialogs.B2WAddPartsToEquipment;
import tasks.dialogs.B2WAddWarranty;
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
	
	public static void createSchedule(){
		
		B2WEquipmentTasks equipmentTasks = new B2WEquipmentTasks();
		
		B2WNavigationTasks navigation = new B2WNavigationTasks();
		
		B2WAddWarranty warranty = new B2WAddWarranty();
		
		B2WAddEvent events = new B2WAddEvent();
		
		Random random = new Random();
		
		B2WAddPartsToEquipment equipmentParts = new B2WAddPartsToEquipment();
		
		logCompare(true, navigation.openEquipment(), "");
		
		// Navigate to Maintain>Equipment
		
		logCompare(true, equipmentTasks.createNewEquipment(), "");
		
		String description = "This is a new Test Equipment # " + random.nextInt(5000) + 1;
		
		String id = "" + random.nextInt(50000) + 1;
		
		logCompare(true, equipmentTasks.setEquipmentDescription(description), "");
		
		logCompare(true, equipmentTasks.setEquipmentID(id), "");
		
		logCompare(true, equipmentTasks.selectNewEquipmentBusinessUnitFromDropDown("Northern Division\\Paving"), "");
		
		logCompare(true, equipmentTasks.selectNewEquipmentTypeFromDropDown("30 Ton Trucks"), "");
		
		logCompare(true, equipmentTasks.selectMobilityTypeRequiresMoveFromDropDown(), "");
		
		logCompare(true, equipmentTasks.selectOwnershipTypeOwnedFromDropDown(), "");
		
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
		logCompare(true, equipmentTasks.setComponentSpecsProductionDate("10/11/2016"), "Production Date");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Tire Size", "sText"), "Text Component Specs");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine", "Engine Name"), "Engine");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine Arrangement", "Arrangement"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Engine Serial Number", "54321"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Horse Power", "124"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Transmission Model", "A3B2C1"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Transmission Serial Number", "09876"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("G.E.T", "13"), "");
		logCompare(true, equipmentTasks.setTextComponentSpecs("Hydraulic Flow Rate", "23"), "");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Fuel Type", null, "Gasoline [GAS]"), "");
	    logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Wheel Type", null, "Rubber Tire [RTR]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Track Type", null, "In-Line Sprocket [ILSP]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Brake Type", null, "Pneumatic Brakes [AIRB]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Cutting Edge", null, "Grader Blades [GRADB]"), "");
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownComponentSpecs("Hydraulic Pump Type", null, "Load Sensing Pump [LSP]"), "");
		
		logCompare(true, equipmentTasks.collapseComponentSpecs(), "");
		
		//Enter Financials
		logCompare(true, equipmentTasks.expandFinancials(), "");
		
		logCompare(true, equipmentTasks.setFinancialsPurchasedFrom("ABC Construction"), "");
		logCompare(true, equipmentTasks.setFinancialsPurchasePrice("20000"), "");
		logCompare(true, equipmentTasks.setFinancialsInsuranceValue("10000"), "");
		logCompare(true, equipmentTasks.setFinancialsTitleHolder("TH Title Holder"), "");
		logCompare(true, equipmentTasks.setFinancialsSoldTo("XYZ Builders"), "");
		logCompare(true, equipmentTasks.setFinancialsSalesPrice("15000"), "");
		
		logCompare(true, equipmentTasks.setFieldAndItemFromDropDownEquipmentSpecs("CCA Class", null, "CCA-3 [CCA-5%]"), "");
		
		equipmentTasks.collapseFinancials();
		
		//Add Meter Types
		logCompare(true, equipmentTasks.expandMeters(), "");
		
		TaskUtils.sleep(5000);
		
		//equipmentTasks.clickAddMeterButton();
		
		//equipmentTasks.getMeterTypeByMeter("Hour Meter");
		
		//MISSING:
		//
		//		logCompare(true, b2wEquip.clickAddMeterButton(), "Click Add Meter");
		//B2WAddMeterToEquipment b2waddmeter = new B2WAddMeterToEquipment();
//		logCompare(true, b2waddmeter.selectAddMeterTypeFromDD(sCategoryB), "Select Add "+sCategoryB+" Meter");
//		logCompare(true, b2waddmeter.selectAddMeterRequiredOnWorkOrderCompletionNotRequired(), "Add Meter not required");
//		logCompare(true, b2waddmeter.selectAddMeterExcludeFromWorkOrdersNever(), "Exclude never");
//		logCompare(true, b2waddmeter.setAddMeterTypeDescription("Hours Meter"), "Meter Description");
//		logCompare(true, b2waddmeter.setAddMeterIntialReading("20"),"Intial Reading");
//		logCompare(true, b2waddmeter.setAddMeterEnterNewReadingCheckBox(), "Enter new reading checkbox");
//		logCompare(true, b2waddmeter.setAddMeterEnterNewReading("120"),"Enter new reading");
//		logCompare(true, b2waddmeter.setAddMeterEnterNewReadingDate(sDateTwoDaysAgo), "Set two days ago");
		//b2waddmeter.clickSaveAddMeter()
		//
		//Save Meter
		
		equipmentTasks.collapseMeters();
		
		//Add Parts
		logCompare(true, equipmentTasks.expandParts(), "");
		
		//equipmentTasks.clickAddPartsButton();
		
		//MISSING:
		//
		//select a part
		
		equipmentParts.selectPartToAddToEquipmentByDescription("Bucket teeth");
		
		equipmentTasks.collapseParts();
		
		//Add a Warranty
		logCompare(true, equipmentTasks.expandWarrenties(), "");
		
		
		//No click 'Add Warranty' button
		equipmentTasks.clickAddWarrantyButton();
		
		String warrantyDescription = "This is a newly created warranty";
		
		logCompare(true, warranty.setWarrantyDescription(warrantyDescription), "");
		logCompare(true, warranty.selectWarrantyType("Equipment"), "");
		logCompare(true, warranty.selectTypeOfDurationCalendar(), "");
		logCompare(true, warranty.setSpan("234"), "");
		logCompare(true, warranty.setSpanDays(), "");
		logCompare(true, warranty.setStarting("12/31/2016"), "");
		warranty.clickCompleteButton();

		logCompare(true, warranty.setWarrantyNotes("These are the warranty notes."), "");
		logCompare(true, warranty.clickSaveWarranty(), "");

		equipmentTasks.collapseWarrenties();
		
		
		logCompare(true, equipmentTasks.expandPrograms(), "");
		
		equipmentTasks.collapsePrograms();
		
		// Add Tags
		logCompare(true, equipmentTasks.expandTags(), "");
		
		equipmentTasks.collapseTags();
		
		//Add Events
		logCompare(true, equipmentTasks.expandEvents(), "");
		
		equipmentTasks.clickAddEventButton();
		logCompare(true, events.selectEventType("Memo"), "");
		logCompare(true, events.setEventStartDate("12/31/2016"), "");
		logCompare(true, events.setEventEndDate("12/31/2017"), "");
		logCompare(true, events.setEventDescription("This is a description in the Description section for an event"), "");
		logCompare(true, events.clickSaveEvent(), "");
		
		equipmentTasks.collapseEvents();
		
		//Save the Equipment
		logCompare(true, equipmentTasks.saveNewEquipment(), "");
		
		// History
		logCompare(true, equipmentTasks.expandHistory(), "");
		
		equipmentTasks.collapseHistory();
		
		// Location
		logCompare(true, equipmentTasks.expandLocation(), "");
		
		equipmentTasks.collapseLocation();
		
		// DOES NOT WORK:
		//
		//logCompare(true, equipmentTasks.selectAllEquipmentByTypeView(), "");
		
		logCompare(true, equipmentTasks.selectFilterByBusinessUnit("Northern Division\\Paving"), "");
		
		logCompare(true, equipmentTasks.selectEquipmentFromViewByID(id), "");
		
		logCompare(true, equipmentTasks.selectEquipmentFromViewByDescription(description), "");
		
		equipmentTasks.clickEdit();
		
		
		//Edit and Delete Warranty
		
		equipmentTasks.expandWarrenties();
		
		equipmentTasks.editWarranty(warrantyDescription);
		
		String alteredDesc = "The Description was just altered";
		
		warranty.setWarrantyDescription(alteredDesc);
		
		warranty.clickSaveWarranty();
		
		equipmentTasks.deleteWarranty(warrantyDescription + alteredDesc);
		
		equipmentTasks.clickConfirmYes();

		equipmentTasks.collapseWarrenties();
		
		//Edit and Delete Meter

		equipmentTasks.expandMeters();
		
		//equipmentTasks.editMeter("meter");
		TaskUtils.sleep(5000);

		
		equipmentTasks.saveNewEquipment();
		
		//verification
		
	}
	
}