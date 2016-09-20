package com.b2w.suite;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.b2w.test.B2WTestCase;

@RunWith (B2WTestSuiteRunner.class)
public abstract class B2WTestSuite extends B2WTestCase {
	protected List<Class<? extends B2WTestCase>> tests;

	public B2WTestSuite() {
		super();
		tests = new ArrayList<Class<? extends B2WTestCase>>();
	}

	public void addToTestList(String[] testNames) {
		for (String testName : testNames) {
			try {
				Class<? extends B2WTestCase> test = (Class<? extends B2WTestCase>) Class.forName(testName)
						.asSubclass(B2WTestCase.class);
				tests.add(test);
			} catch (ClassNotFoundException e) {
				log.warn("Class Not Found for " + testName + ", Skipping that test case");
				log.debug(e.getStackTrace());
			} catch (ClassCastException e) {
				log.warn("Class " + testName + " was not a valid Test Case, Skipping that test case");
				log.debug(e.getStackTrace());
			}
		}
	}

	public List<Class<? extends B2WTestCase>> getChildren() {
		return tests;
	}
}
