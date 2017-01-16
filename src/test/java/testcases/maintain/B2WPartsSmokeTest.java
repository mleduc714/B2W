package testcases.maintain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddEquipmentToMainProgram;
import tasks.dialogs.B2WAddInterval;
import tasks.dialogs.B2WAddItemMaintenanceProgram;
import tasks.dialogs.B2WAddItemWorkOrder;
import tasks.dialogs.B2WAddMaintenanceReqToWorkOrder;
import tasks.dialogs.B2WAddPartsToWorkItem;
import tasks.dialogs.B2WAddToInventory;
import tasks.dialogs.B2WApprovePurchaseOrder;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.dialogs.B2WEditScheduleMaintenance;
import tasks.dialogs.B2WReportHours;
import tasks.dialogs.B2WScheduleMaintenance;
import tasks.jobs.B2WJobsTasks;
import tasks.maintain.B2WInventoryTasks;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainPartsTasks;
import tasks.maintain.B2WMaintainProgramsTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainScheduleTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WPurchasingTasks;
import tasks.maintain.B2WTimeCardTasks;
import tasks.maintain.B2WWorkOrdersTasks;
import tasks.resources.B2WEmployeeTasks;
import tasks.resources.B2WEquipmentTasks;
import tasks.util.TaskUtils;

public class B2WPartsSmokeTest extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WJobsTasks b2wJob = new B2WJobsTasks();
	B2WMaintainDashboardTasks b2wDash = new B2WMaintainDashboardTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WMaintainTasks b2wMaintain = new B2WMaintainTasks();
	B2WWorkOrdersTasks b2wWork = new B2WWorkOrdersTasks();
	B2WAddMaintenanceReqToWorkOrder addToWO = new B2WAddMaintenanceReqToWorkOrder();
	B2WMaintainProgramsTasks b2wMainPrograms = new B2WMaintainProgramsTasks();
	B2WAddInterval addInterval = new B2WAddInterval();
	B2WAddItemMaintenanceProgram b2wAddItem = new B2WAddItemMaintenanceProgram();
	B2WMaintainScheduleTasks b2wSchd = new B2WMaintainScheduleTasks();
	B2WScheduleMaintenance b2wSchMain = new B2WScheduleMaintenance();
	B2WCompleteWorkOrder b2wComplete = new B2WCompleteWorkOrder();
	B2WEditScheduleMaintenance b2wEditSch = new B2WEditScheduleMaintenance();
	B2WReportHours b2wReport = new B2WReportHours();
	B2WTimeCardTasks b2wtimecards = new B2WTimeCardTasks();
	B2WAddEquipmentToMainProgram b2wEquipmentProgram = new B2WAddEquipmentToMainProgram();
	B2WAddItemWorkOrder b2wAddItemWO = new B2WAddItemWorkOrder();
	B2WInventoryTasks inventory = new B2WInventoryTasks();
	B2WAddToInventory addInventory = new B2WAddToInventory();
	B2WMaintainPartsTasks parts = new B2WMaintainPartsTasks();
	B2WEquipmentTasks b2wE = new B2WEquipmentTasks();
	B2WAddItemWorkOrder b2wAddToWorkOrder = new B2WAddItemWorkOrder();
	B2WAddPartsToWorkItem addParts = new B2WAddPartsToWorkItem();
	B2WEmployeeTasks b2wEmp = new B2WEmployeeTasks();
	B2WApprovePurchaseOrder approve = new B2WApprovePurchaseOrder();	
	B2WPurchasingTasks purch = new B2WPurchasingTasks();

	String sPartID, sPartUnitOfMeasure, sPartDesc, sPartStandardUnitCost,
	sPartMinInventory, sPartReorderQTY, sPartBusinessUnit, sPartManufacturer, sPartNotes, sPartInventory,
	sPartCategory, sPartLocation, sPartBin, sWorkOrderDescription, sWorkOrderItemDescription,
	sEstQty, sReportedQty, sPartsVendor, sEmployeeFirstNameB,sEmployeeLastNameB,sEmployeeIDB;
	
	static SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
	Calendar cal = Calendar.getInstance();
	
	@Override
	public void testSetUp() throws Throwable {
		// code here for setting up the test
		super.testSetUp();
		int iRandom = getRandomNumber();
		int iEstQty = getRandomNumber(25);
		sEstQty = Integer.toString(iEstQty);
		sReportedQty = Integer.toString(iEstQty-1);
		sPartID = getProperty("sPartID")+iRandom;
		sPartUnitOfMeasure = getProperty("sPartUnitOfMeasure");
		sPartDesc = getProperty("sPartDesc")+iRandom;
		sPartStandardUnitCost = getProperty("sPartStandardUnitCost");
		sPartMinInventory = getProperty("sPartMinInventory");
		sPartReorderQTY = getProperty("sPartReorderQTY");
		sPartBusinessUnit = getProperty("sPartBusinessUnit");
		sPartManufacturer = getProperty("sPartManufacturer");
		sPartNotes = getProperty("sPartNotes");
		sPartInventory = getProperty("sPartInventory");
		sPartCategory = getProperty("sPartCategory");
		sPartLocation = getProperty("sPartLocation");
		sWorkOrderDescription = getProperty("sWorkOrderDescription")+iRandom;
		sWorkOrderItemDescription = getProperty("sWorkOrderItemDescription")+iRandom;
		sEmployeeFirstNameB = getProperty("sEmployeeFirstNameB");
		sEmployeeLastNameB = getProperty("sEmployeeLastNameB");
		sEmployeeIDB = getProperty("sEmployeeIDB")+iRandom;

		cal.add(Calendar.DAY_OF_YEAR,14);
		
	}

	@Override
	public void testTearDown() throws Throwable {
		// code here for code after the test complete. 
		// cleanup
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() {
		return "mleduc";
	}

	@Override
	public String getTestDescription() {
		// enter the description for the testcase
		return "Smoke Test for Parts";
	}

	@Override
	public String getDataPath() {
		//the path to properties file for data for the testcase
		return "data/maintain";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		createEmployee();
		
		b2wNav.openMaintain();

		addPart();
		addToInventory();
		createWorkOrder();
		createPurchaseOrder();
		TaskUtils.sleep(5000);
		/*	
		•Add a Primary Vendor
		•Add the new part to Inventory, Create Request, Work Order,and Purchase Order to create Part history for these entities

		•Explore Links within the Entities - Work Order, PO#, Attachments, Vendor
		•Explore Inactive and Active Parts
		•Edit a Part
		•Delete a Part (Including confirming message when deleting a Part in use)
		•Explore Filters & Search & Sorting - Part List and Filtering/Sorting within the Entities
		•Explore having enough Vendors, Inventory History, PO History to increment the items per page and navigating to next page and back
		•Security Permissions
		•Navigation options to Parts Page
		*/
		
		
		
	}
	public void createEmployee() {
		assertTrue("Open Employees", b2wNav.openEmployees());
		assertTrue("Create New Employee",b2wEmp.createNewEmployeeButton());
		logCompare(true, b2wEmp.setEmployeeFirstName(sEmployeeFirstNameB), "Set First Name");
		logCompare(true, b2wEmp.setEmployeeLastName(sEmployeeLastNameB), "Set Last Name");
		logCompare(true, b2wEmp.setEmployeeID(sEmployeeIDB), "Set Employee ID");
		logCompare(true, b2wEmp.setDriverCheckBox(true), "Set Driver Checkbox");
		logCompare(true, b2wEmp.setPurchaseOrderApproverCheckBox(true), "Approver");
		logCompare(true, b2wEmp.clickTopSaveButton(), "Click Top Save Button");


	}
	public void addPart() {
		b2wMaintain.openParts();
		logCompare(true,parts.clickAddPart(),"");
		logCompare(true,parts.setPartID(sPartID),"Set Part ID");
		logCompare(true,parts.setPartDescription(sPartDesc),"Set Part Desc");
		logCompare(true,parts.selectUnitOfMeasure(sPartUnitOfMeasure),"Set Unit Of Measure");
		logCompare(true,parts.setStandardUnitCost(sPartStandardUnitCost),"Set Unit Cost");
		logCompare(true,parts.selectCategory(sPartCategory),"Set Category");
		logCompare(true,parts.setMinimumInventory(sPartMinInventory),"Ste Min Inventory");
		logCompare(true,parts.setReorderQuantity(sPartReorderQTY),"Set Reorder QTY");
		logCompare(true,parts.selectBusinessUnit(sPartBusinessUnit),"set Business Unit");
		logCompare(true,parts.setManufacturer(sPartManufacturer),"Set Manufacturer");
		logCompare(true,parts.setNotes(sPartNotes),"Set Notes");
		logCompare(true,parts.clickAddWarranty(),"Add Warranty");
		logCompare(true,parts.setWarrantyDescription("AutoWarranty"),"Set Warranty Desc");
		logCompare(true,parts.selectTypeOfDurationCalendar(),"Set Duration");
		logCompare(true,parts.setSpan("100"),"Set Span");
		logCompare(true,parts.setSpanWeeks(),"Set Span Weeks");
		logCompare(true,parts.clickCompleteButton(),"click complete");
		logCompare(true,parts.clickSavePart(),"Save Part");
		logCompare(true,parts.selectPartByDescription(sPartDesc),"Select Part");
		logCompare(true,parts.expandVendors(),"Expand Vendors");
		logCompare(true,parts.clickAddVendor(),"Add Vendors");
		sPartsVendor = parts.selectAnyVendor();
		logCompare(true,parts.setVendorPartNumber("1922"),"Set Vendor Part");
		logCompare(true,parts.setPartLeadTime("5"),"Set Lead Time");
		logCompare(true,parts.saveVendor(),"Save Vendor");
	}
	
	public void addToInventory() {
		logCompare(true,b2wMaintain.openInventory(),"Open Inventory");
		logCompare(true,inventory.clickAddToInventory(),"Add To Inventory");
		TaskUtils.sleep(1000);
		logCompare(true,addInventory.selectPart(this.sPartDesc), "Select Part");
		TaskUtils.sleep(1000);
		logCompare(true,addInventory.selectLocation(sPartLocation), "Select Location");
		sPartBin = addInventory.selectAnyBin();
		TaskUtils.sleep(500);
		logCompare(true,addInventory.setQuantity(sPartInventory),"Set Quantity");
		logCompare(true,addInventory.saveAddToInventory(),"Save Inventory");
		logCompare(sPartInventory,inventory.getPartCurrentInventory(sPartDesc), "Verify Inventory");
		logCompare(sPartMinInventory, inventory.getPartMinimumInventory(sPartDesc), "Minimum Inventory");
		logCompare(sPartCategory, inventory.getPartCategory(sPartDesc), "Part Category");
		b2wMaintain.openParts();
		logCompare(true,parts.selectPartByDescription(sPartDesc), "Select Desc");
		logCompare(true,parts.expandInventoryHistory(),"Expand History");
		logCompare(1,parts.getInventoryHistoryRows(), "Inventory History rows should be 1");
		logCompare("Add Inventory",parts.getInventorySource().get(0), "Verify Source");
		logCompare(true, parts.getInventoryText(0, 4).startsWith(sPartInventory), "Inventory starts with "+sPartInventory + " "+sPartUnitOfMeasure);
		
	}
	
	public void createWorkOrder() {
		logCompare(true,b2wMaintain.openWorkOrders(),"Open Work Orders");
		logCompare(true,b2wWork.clickCreateNewWorkOrderButton(),"Create New Work Order");
		b2wWork.selectAnyEquipment();
		logCompare(true,b2wWork.selectPriorityFromDD("Medium"), "Select Medium");
		logCompare(true,b2wWork.setWorkOrderDescription(sWorkOrderDescription),"Work Order Desc");
		b2wWork.selectAnyPlannedWorkLocation();
		logCompare(true,b2wWork.clickAddItemButton(), "New Item");
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.clickAddItemButton(),"Add Item");
		logCompare(true,b2wAddToWorkOrder.setAddItemDescription(sWorkOrderItemDescription), "Set Desc");
		b2wAddToWorkOrder.setAnyAddItemTypeFromDD();
		b2wAddToWorkOrder.selectAddItemPriorityFromDD("Medium");
		b2wAddToWorkOrder.selectAnyAddItemProblemCodeFromDD();
		b2wAddToWorkOrder.selectAnyAddItemCompCodeFromDD();
		b2wAddToWorkOrder.selectAnyAddItemSubCodeFromDD();
		b2wAddToWorkOrder.selectAnyAddItemFailureCodeFromDD();
		b2wAddToWorkOrder.selectAnyAddItemActionCodeFromDD();
		TaskUtils.sleep(1000);
		b2wAddToWorkOrder.selectAnyAddItemRequestedByFromDD();
		TaskUtils.sleep(1000);
		logCompare(true,b2wAddToWorkOrder.clickCreateAddItemButton(),"Add Item");
		TaskUtils.sleep(1000);
		logCompare(true,b2wWork.expandParts(), "Expand Parts");
		logCompare(true,b2wWork.clickAddParts(), "Add Parts");
		logCompare(true,addParts.selectPartToAddToWorkItemByDescription(sPartDesc),"");
		logCompare(true,addParts.partsNext(),"");
		logCompare(true,addParts.setEstimatedQty(sPartDesc,sEstQty),"");
		logCompare(true,addParts.setReportedQty(sPartDesc, sReportedQty),"");
		String sInventoryChange = "("+sReportedQty+" EACH)";
		logCompare(true,addParts.saveParts(), "Save Parts");
		logCompare(true,b2wWork.clickSaveButton(),"Click Save");
		logCompare(true,b2wMaintain.openParts(),"Open Parts");
		logCompare(true,parts.selectPartByDescription(sPartDesc), "Select Desc");
		logCompare(true,parts.expandInventoryHistory(),"Expand History");
		logCompare(2,parts.getInventoryHistoryRows(), "Inventory History rows should be 2");
		logCompare(sInventoryChange,parts.getInventoryText(1, 4),"Inventory Changed");

	}
	
	public void createPurchaseOrder() {
		
		logCompare(true,b2wMaintain.openPurchasing(),"Open Purchases Orders");
		logCompare(true,purch.createBlankPurchaseOrder(), "Blank Purchase Order");
		logCompare(true,purch.selectChooseVendorfromDD(sPartsVendor), "Choose Vendor");
		logCompare(true,purch.setAltID("1234"), "Set Alt ID");
		logCompare(true,purch.setPODueDate(format.format(cal.getTime())), "Due Date");
		logCompare(true,purch.setCompanyName("BOW STREET"), "Company Name");
		logCompare(true,purch.setStreetAddress("99 Bow Street"),"Address");
		logCompare(true,purch.setCity("Portsmouth"),"City");
		logCompare(true,purch.setState("NH"),"State");
		logCompare(true,purch.setPostalCode("03801"),"Zip");
		logCompare(true,purch.setCountry("USA"), "Country");
		logCompare(true,purch.setTaxRate("5"),"Percent");
		logCompare(true,purch.setFreight("34.00"), "Freight");
		logCompare(true,purch.savePurchaseOrder(), "Save Purchase Order");
		TaskUtils.sleep(1000);
		logCompare(true,purch.clickAddPart(), "Add Part");
		logCompare(true,purch.setPart(sPartDesc), "Set Part");
		logCompare(true,purch.savePartOrder(), "Save Part Order");
		logCompare(true,purch.clickApproveButton(), "Approve");
		TaskUtils.sleep(500);
		logCompare(true,approve.selectApprover(sEmployeeFirstNameB), "First Name");
		logCompare(true,approve.clickApproveButton(), "Click Approve");
		
	}
	

}
