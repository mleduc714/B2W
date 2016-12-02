package com.b2w.test;

import java.io.File;
import java.util.Properties;

import org.junit.runner.RunWith;

import com.b2w.logging.B2WRunConfig;

import tasks.BrowserUtils;
import tasks.util.TaskUtils;

@RunWith(B2WTestRunner.class)
public class B2WTestCase extends BaseTestCase {
	protected Properties clientProps = new Properties();
	private B2WRunConfig config;
	protected Properties properties;
	@SuppressWarnings("unused")
	private String propfile = null;
	

	public void testSetUp() throws Throwable {
		// Prepare browser for testing
		log.debug("Preparing Selenium...");
		BrowserUtils.setWebBrowser(getEnvProperty("browser"));


		String testName = new StringBuffer(getClass().getSimpleName()).toString();
		// set the log for the webdriver
		File logFile = new File("logs/current/" + testName + "Driver.log");
		if (BrowserUtils.isChrome()) {
			System.setProperty("webdriver.chrome.logfile", logFile.getAbsolutePath());
		} else if (BrowserUtils.isInternetExplorer()) {
			System.setProperty("webdriver.ie.driver.logfile", logFile.getAbsolutePath());
		} else if (BrowserUtils.isFirefox()) {
			System.setProperty("webdriver.firefox.logfile", logFile.getAbsolutePath());
		}
		if (!BrowserUtils.loadURL(getEnvProperty("deploy"), getEnvProperty("username"), getEnvProperty("password"))) {
			fail("Failed to load initial URL due to WebDriver issue");
		}
		BrowserUtils.moveMouseOffScreen();
		
		bTestCasePass = true;
	}

	public void testMain() throws Throwable {
		// TODO Auto-generated method stub

	}

	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		if (TaskUtils.getAlertDialog() != null){
			logScreenCapture();
			TaskUtils.dismissAlert();
		}
		
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTestDescription() {
		return new StringBuffer(getClass().getSimpleName()).toString();
	}

	public String getDataPath() {
		// TODO Auto-generated method stub
		return "data";
	}

	public boolean isSupported() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getEnvProperty(String name) {
		String prop = config.getProperty(name);
		return prop;
	}

	public final String getProperty(String property) {
		return properties.getProperty(property);
	}


	public Properties getConfigProperties() {
		return config.getConfigProps();
	}

	public void setProperties(B2WRunConfig runConfig, Properties props, String file) {
		config = runConfig;
		properties = props;
		propfile = file;
	}

}
