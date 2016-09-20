package com.b2w.suite;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.b2w.logging.AutomationLoggerAppender;
import com.b2w.test.BaseTestCase;
import com.b2w.test.LogLevel;
import com.b2w.test.TestFailListener;

import tasks.BrowserUtils;

public abstract class BaseSuiteRunner extends ParentRunner<BaseTestCase> implements TestFailListener {
	Logger log = Logger.getLogger(getClass());
	protected List<BaseTestCase> failed;
	protected String sTestSuiteName;
	protected boolean rerunMode;
	private static boolean isConfigLogged = false;

	public BaseSuiteRunner(Class<? extends BaseTestCase> testClass) throws InitializationError {
		super(testClass);
		log = Logger.getLogger(getClass());
		rerunMode = true;
		sTestSuiteName = testClass.getName();
		try {
			sTestSuiteName = (String) testClass.getField("name").get(null);
		} catch (Exception e) {
		}
		if (!isConfigLogged) {
			String config = getConfigLogString();
			if (config != null)
				log.info(config);
			isConfigLogged = true;
		}

		for (BaseTestCase test : getChildren())
			log.info(new StringBuffer("FOUNDTEST; ").append(test.getClass().getName()).append(test.getInstance()));
		failed = new ArrayList<BaseTestCase>();

	}

	protected abstract String getConfigLogString();

	protected Statement childrenInvoker(final RunNotifier notifier) {
		return new Statement() {
			@Override
			public void evaluate() {
				log.info("SUITESTART;" + sTestSuiteName);
				for (BaseTestCase test : getChildren()) {
					runChild(test, notifier);
				}
				if (rerunMode()) {
					for (BaseTestCase failedTest : failed) {
						failedTest.setRerun(true);
						runChild(failedTest, notifier);
					}
				}
				BrowserUtils.getDriver().quit();
				log.info(AutomationLoggerAppender.SUITEEND);
			}
		};
	}

	@SuppressWarnings("static-access")
	protected void runChild(BaseTestCase child, RunNotifier notifier) {

		Description description = describeChild(child);

		EachTestNotifier eachNotifier = new EachTestNotifier(notifier, description);
		eachNotifier.fireTestStarted();
		String instance = child.getInstance();
		log.info(new StringBuffer("TESTSTART; name=").append(child.getClass().getName()).append(instance).append(";")
				.append(child.isRerun() ? "rerun;" : "").append("datafile=").append(child.getDataFile()).append(";")
				.append("description=").append(child instanceof BaseTestCase
						? ((BaseTestCase) child).getTestDescription() : child.getTestDescription()));
		try {
			if (child.isSupported()) {
				child.before();
				child.runTest();
				if (child.bTestCaseSkipped) {
					log.info("TESTIGNORE; " + child.getClass().getName());
				} else if (!child.bTestCasePass) {
					throw new AssertionError("A non-fatal failure occured during the test case");
				} else {
					log.info("TESTPASS; " + child.getClass().getName());
				}
			} else {
				eachNotifier.fireTestIgnored();
				log.info("TESTIGNORE; " + child.getClass().getName());
			}
		} catch (Throwable t) { 
			
			onTestFail(child, t); 
			if (t instanceof AssumptionViolatedException)
				eachNotifier.addFailedAssumption((AssumptionViolatedException) t);
			else
				eachNotifier.addFailure(t);

			if (t instanceof AssertionError) {
				log.log(LogLevel.FAILED, "TESTFAIL; " + child.getClass().getName() + "; ", t);
			} else {
				log.error("TESTFAIL; " + child.getClass().getName() + "; ", t);
			}
			if (!child.isRerun())
				failed.add(child);
		} finally {
			try {
				if (child.isSupported()) {
					child.after();
				}
			} catch (Throwable t) {
				log.error(t);
			}
			eachNotifier.fireTestFinished();
		}
	}

	protected boolean rerunMode() {
		return rerunMode;
	}

	@Override
	protected Description describeChild(BaseTestCase child) {
		return Description.createTestDescription(child.getClass(), child.getTestDescription());
	}
}
