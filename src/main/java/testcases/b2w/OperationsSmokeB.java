package testcases.b2w;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.B2WSetupTasks;
import tasks.resources.B2WAccountTasks;
import tasks.resources.B2WMaterialsTasks;
import tasks.setup.B2WUserTasks;
import tasks.util.TaskUtils;

public class OperationsSmokeB extends B2WTestCase {

	B2WUserTasks userTasks = new B2WUserTasks();
	B2WSetupTasks b2wSetup = new B2WSetupTasks();
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WAccountTasks b2wAct = new B2WAccountTasks();
	B2WMaterialsTasks b2wMat = new B2WMaterialsTasks();
	
	String sProductionAccountDesc;
	String sProductionAccountID;
	String sProductionAccountBusinessUnit;
	String sProductionAccountUnitOfMeasure;
	String sProductionAccountNotes;

	String sOverheadAccountDesc;
	String sOverheadAccountID;
	String sOverheadAccountBusinessUnit;
	String sOverheadAccountNotes;

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
		sProductionAccountDesc = getProperty("productionaccountdescription");
		sProductionAccountID = getProperty("productionaccountaccountid");
		sProductionAccountBusinessUnit = getProperty("productionaccountbusinessunit");
		sProductionAccountUnitOfMeasure = getProperty("productionaccountunitofmeasure");
		sProductionAccountNotes = getProperty("productionacountnotes");
		sOverheadAccountDesc = getProperty("overheadaccountdescription");
		sOverheadAccountID = getProperty("overheadaccountaccountid");
		sOverheadAccountBusinessUnit = getProperty("overheadaccountbusinessunit");
		sOverheadAccountNotes = getProperty("overheadacountnotes");

	}

	public void testMain() throws Throwable {
		assertTrue("Open Accounts", b2wNav.openAccounts());
		assertTrue("collapse production accounts", b2wAct.collapseProductionAccounts());
		assertTrue("Create new production account", b2wAct.clickCreateNewProductionAccountButton());
		logCompare(true, b2wAct.setDescription(sProductionAccountDesc), "Enter in description for account");
		logCompare(true, b2wAct.setAccountID(sProductionAccountID), "Enter in Account ID");
		logCompare(true, b2wAct.selectBusinessUnit(sProductionAccountBusinessUnit), "Enter Production Business Unit");
		logCompare(true, b2wAct.selectUnitOfMeasure(sProductionAccountUnitOfMeasure), "Enter Unit of Measure");
		logCompare(true, b2wAct.setNotes(sProductionAccountNotes), "Enter in Notes");
		assertTrue("click save button",b2wAct.clickTopSaveButton());
		// verify
		b2wNav.clickHome();
		b2wNav.openAccounts();
		b2wAct.expandProductionAccounts();
		b2wAct.enterSearchText(sProductionAccountDesc);
		b2wAct.clickSearchButton();
		b2wAct.openProductionAccountByAccountID(sProductionAccountID);
		TaskUtils.sleep(5000);
		logCompare(sProductionAccountDesc, b2wAct.getDescriptionText(), "Description");
		logCompare(sProductionAccountID, b2wAct.getAccountIDText(), "Account ID");
		logCompare(sProductionAccountBusinessUnit, b2wAct.getAccountBusinessUnitLink(), "Business Unit");
		logCompare(sProductionAccountUnitOfMeasure, b2wAct.getAccountUnitofMeasureText(), "Unit of Measure");

		
	/*	assertTrue("collapse overhead accounts", b2wAct.collapseOverheadAccounts());		
		logCompare(true, b2wAct.setDescription(sOverheadAccountDesc), "Set "+sOverheadAccountDesc);
		logCompare(true, b2wAct.selectBusinessUnit(sOverheadAccountBusinessUnit), "Overhead Business Unit");
		logCompare(true, b2wAct.setAccountID(sOverheadAccountID), "Overhead Account ID");
		logCompare(true, b2wAct.setNotes(sOverheadAccountNotes), "Enter Notes");
		assertTrue("click save button",b2wAct.clickTopSaveButton());
		
		//verify
		b2wNav.clickHome();
		b2wNav.openAccounts();
		b2wAct.collapseProductionAccounts();
		b2wAct.expandOverheadAccounts();
		b2wAct.enterSearchText(sOverheadAccountDesc);
		b2wAct.clickSearchButton();*/

		
	}
}
