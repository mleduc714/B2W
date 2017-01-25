package testcases.maintain;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.dialogs.B2WAddToInventory;
import tasks.maintain.B2WInventoryTasks;
import tasks.maintain.B2WMaintainPartsTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.util.TaskUtils;

public class B2WInventorySmokeTest extends B2WTestCase {
	
	B2WInventoryTasks inventory = new B2WInventoryTasks();
	B2WMaintainPartsTasks parts = new B2WMaintainPartsTasks();
	B2WMaintainTasks b2wMain = new B2WMaintainTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WAddToInventory addInventory = new B2WAddToInventory();
	
	String sPartID, sPartUnitOfMeasure, sPartDesc, sPartStandardUnitCost,
	sPartMinInventory, sPartReorderQTY, sPartBusinessUnit, sPartManufacturer, sPartNotes, sPartInventory,
	sPartCategory, sPartLocation, sPartBin, sWorkOrderDescription, sWorkOrderItemDescription, sPartAdjustedInventory, sPartMovedInventory;
	int iRandom;

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
		iRandom = getRandomNumber();
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
		sPartAdjustedInventory = getProperty("sPartAdjustedInventory");
		sPartMovedInventory = getProperty("sPartMovedInventory");
	}

	@Override
	public void testTearDown() throws Throwable {
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		return null;
	}

	@Override
	public String getAuthor() {
		return "mleduc";
	}

	@Override
	public String getTestDescription() {
		return "Inventory Smoke Test";
	}

	@Override
	public String getDataPath() {
		return "data/inventory";
	}

	@Override
	public boolean isSupported() {
		return true;
	}
	
	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		b2wNav.openMaintain();
		addPart();
		addToInventory();
		editInventory();
		moveInventory();
/*		 Add to Inventory
		•Edit Inventory•Adjust Inventory
		•Change Location

		•Delete Inventory
		•Explore Filters/Search/Sorting
		•Explore Show inactive parts and not show inactive parts in list
		•Explore Allocated inventory tool tip and links to Work Order(s)
		•Security Permissions
		•Navigation options to the Inventory page*/
	}

	public void addToInventory() {
		logCompare(true,b2wMain.openInventory(),"Open Inventory");
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

		
	}
	
	public void editInventory() {
		inventory.editInventory(0);
		logCompare(true,addInventory.setNewQuantity(sPartAdjustedInventory),"Set New Quantity");
		logCompare(true,addInventory.saveAddToInventory(),"Save Add To Inventory");
		logCompare(sPartAdjustedInventory,inventory.getPartCurrentInventory(sPartDesc), "Verify Adjusted Inventory");

	}
	
	public void moveInventory() {
		inventory.editInventory(0);
		TaskUtils.sleep(1000);
		logCompare(true,addInventory.selectTypeOfUpdateLocation(),"Select Update Location");
		logCompare(true,addInventory.setQuantityToMove(sPartMovedInventory), "Quantity to Move");
		logCompare(true,addInventory.selectNewLocation("Main Shop"), "Select New Location");
		String sNewBin = addInventory.selectNewBin();
		logCompare(true,addInventory.saveAddToInventory(),"Save Add Inventory");
		logCompare(sNewBin, inventory.getPartBins().get(1), "New Bin Added");
		logCompare(sPartMovedInventory, inventory.getCurrentInventory().get(1), "Inventory moved");
		logCompare(sPartAdjustedInventory,inventory.getPartCurrentInventory(sPartDesc), "Verify Inventory not changed");

	}
	
	public void deleteInventory() {
		
	}
	
	public void addPart() {
		logCompare(true,b2wMain.openParts(),"Open Parts");
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

	}
		

}
