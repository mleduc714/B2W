package testcases;

import java.text.SimpleDateFormat;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.util.Timer;

public class TestSetup extends B2WTestCase {



	B2WNavigationTasks b2wNav = new B2WNavigationTasks();


	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");

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
		//int  n = getRandomNumber();

	}

	public void testMain() throws Throwable {
		logCompare(true,b2wNav.clickHome(),"Go Home");
		logCompare(true,b2wNav.openJobs(),"Open jobs");
		assertTrue("open Maintain", b2wNav.openMaintain());
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	
}
