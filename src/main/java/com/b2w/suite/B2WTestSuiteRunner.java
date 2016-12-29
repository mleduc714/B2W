package com.b2w.suite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.InitializationError;

import com.b2w.logging.B2WRunConfig;
import com.b2w.test.B2WTestCase;
import com.b2w.test.BaseTestCase;
import com.b2w.test.LogLevel;

import tasks.util.TaskUtils;

public class B2WTestSuiteRunner extends BaseSuiteRunner {

	private static final B2WRunConfig RUN_CONFIG = new B2WRunConfig();
	Logger log = Logger.getLogger(B2WTestSuiteRunner.class);
	

	public B2WTestSuiteRunner(Class<? extends B2WTestCase> testClass) throws InitializationError {
		super(testClass);
		rerunMode = Boolean.parseBoolean(RUN_CONFIG.getProperty("rerunMode"));

	}

	protected List<BaseTestCase> getChildren() {
		List<BaseTestCase> ret = new ArrayList<BaseTestCase>(20);
		// RUN_CONFIG.placeCustomLogFiles();
		try {
			for (Class<? extends B2WTestCase> test : ((B2WTestSuite) getTestClass().getJavaClass().newInstance())
					.getChildren()) {
				if (B2WTestSuite.class.isAssignableFrom(test)) {
					ret.addAll(this.getChildren((B2WTestSuite) test.newInstance()));
				} else {
					B2WTestCase instance = test.newInstance();
					String dataPath;
					dataPath = getDataSet(instance);
					List<String> iterations = RUN_CONFIG.getPropertiesFiles(dataPath);
					if (iterations == null)
						log.error("Could not find properties files for " + test.getName());
					else {
						for (String file : iterations) {
							instance = instance == null ? (B2WTestCase) test.newInstance() : instance;
							setTestProperties(instance, file);
							ret.add(instance);

							instance = null; // reset for next loop

						}
					}
				}
			}
		} catch (Throwable t) {
			log.error("Error spawning test case instance of: " + getTestClass().getJavaClass().getName(), t);
		}

		return ret;
	}

	public String getDataSet(B2WTestCase test) {
		String dataPath;
		if (RUN_CONFIG.getProperty("dataMode") != null)
			dataPath = test.getDataPath() + "/" + RUN_CONFIG.getProperty("dataMode").toUpperCase();
		else
			dataPath = test.getDataPath();// +"/NORMAL"; //To Be restored once
											// full
											// implementation is complete
		return dataPath;
	}

	private Collection<? extends BaseTestCase> getChildren(B2WTestSuite newInstance) {
		List<BaseTestCase> ret = new ArrayList<BaseTestCase>(20);
		// Overwrite log.css in logs folder
		// RUN_CONFIG.placeCustomLogFiles();
		try {
			for (Class<? extends B2WTestCase> test : newInstance.getChildren()) {
				if (B2WTestSuite.class.isAssignableFrom(test)) {
					ret.addAll(this.getChildren((B2WTestSuite) test.newInstance()));
				} else {
					B2WTestCase instance = test.newInstance();
					List<String> iterations = RUN_CONFIG.getPropertiesFiles(instance.getDataPath());
					for (String file : iterations) {
						instance = instance == null ? (B2WTestCase) test.newInstance() : instance;
						setTestProperties(instance, file);
						ret.add(instance);
						instance = null; // reset for next loop
					}
				}
			}
		} catch (Throwable t) {
			log.error("Error spawning test case instance of: " + getTestClass().getJavaClass().getName(), t);
		}
		return ret;
	}

	private void setTestProperties(B2WTestCase test, String file) {
		file = getDataSet(test).replaceAll("[/]$", "") + "/" + file;
		test.setProperties(RUN_CONFIG, RUN_CONFIG.getProperties(file), file);
	}

	public void onTestFail(BaseTestCase test, Throwable t) {

		if (!(t instanceof AssumptionViolatedException)){
			log.log(LogLevel.WARN, "TESTFAILED: " + test.getClass().getName());
			TaskUtils.logScreenCapture();
		}else{
			log.log(LogLevel.INFO, "Assumption failure. No screenshot");
		}
	}


	@Override
	protected String getConfigLogString() {
		return new StringBuffer("CONFIG; browser=").append(RUN_CONFIG.getProperty("browser")).append(";").append("url=")
				.append(RUN_CONFIG.getProperty("deploy")).append(";").toString();
	}

}
