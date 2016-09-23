package testcases.b2w;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.B2WSetupTasks;
import tasks.resources.B2WAccountTasks;
import tasks.setup.B2WUserTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeB extends B2WTestCase {
	
	
	B2WUserTasks userTasks = new B2WUserTasks();
	B2WSetupTasks b2wSetup = new B2WSetupTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WAccountTasks b2wAct = new B2WAccountTasks();

	
	
/*	
 * Create new entities of the following types, through the Resources area
 * 
 *  a.Production Account
	b.Overhead Account
	c.Material
	
	
 * */



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
	}

	public void testMain() throws Throwable {
		// open resources
		// check for expand or not
		// create
//		b2wNav.openAccounts();
//		b2wAct.collapseProductionAccounts();
//		b2wAct.clickCreateNewProductionAccountButton();
//		b2wAct.setDescription("Automation Production Account");
//		b2wAct.setAccountID("123-Auto");
//		b2wAct.checkTimeAndMaterials();
//		b2wAct.selectBusinessUnit(5);
//		b2wAct.selectUnitOfMeasure("YARD");
//		b2wAct.setNotes("This is test acccount for automation");
//		b2wAct.clickTopSaveButton();
//		b2wAct.collapseProductionAccounts();
//		b2wAct.collapseOverheadAccounts();
//		b2wAct.clickCreateNewOverheadAccountButton();
//		b2wAct.setDescription("Automation Overhead Account");
//		b2wAct.setAccountID("456-Auto");
//		b2wAct.clickTopSaveButton();
//		b2wAct.selectBusinessUnit(5);
		
		b2wNav.openMaterials();
		b2wAct.clickCreateNewMaterialsButton();
		b2wAct.setDescription("Paving Form");
		b2wAct.selectUnitOfMeasure("EACH");
		b2wAct.checkTemporaryMaterial(true);
		b2wAct.checkTrackableMaterial(true);
		b2wAct.setTotalCount("5");

/*		Materiali.1 with the following properties:1.Description = "Paving Form"
				2.Temporary Material = checked
				3.Trackable Material = checked
				4.Unit of Measure = EACH
				5.Total Count = 5

				ii.1 with the following properties1.Description = "Traffic Cone"
				2.Temporary Material = checked
				3.Unit of Measure = EACH

				iii.1, named "Asphalt Base E190"
				iv.1, named "Asphalt Base E550"*/

		
		
		
	}
}
