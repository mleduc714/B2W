package com.b2w.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.InitializationError;

import com.b2w.logging.B2WRunConfig;

public class B2WTestRunner extends BaseRunner {

	private static final B2WRunConfig RUN_CONFIG = new B2WRunConfig();
	protected long startTime;
	protected long lapTime;
	protected String timingFile = System.getProperty("user.dir") + "/logs/current/";


	public B2WTestRunner(Class<? extends BaseTestCase> testClass) throws InitializationError {
		super(testClass);

	}

	public void onTestFail(BaseTestCase test, Throwable t) {

		if (!(t instanceof AssumptionViolatedException))
			log.log(LogLevel.WARN, "TESTFAILED: " + test.getClass().getName());
		else
			log.log(LogLevel.INFO, "Assumption failure. No screenshot");
	}

	@Override
	protected String getConfigLogString() {
		return new StringBuffer("CONFIG; browser=").append(RUN_CONFIG.getProperty("browser")).append(";")
				.append("url=").append(RUN_CONFIG.getProperty("deploy"))
				.append(";").toString();
	}

	@Override
	protected List<BaseTestCase> getChildren() {

	    List<BaseTestCase> ret = new ArrayList<BaseTestCase>(20);

	    try{
	    	B2WTestCase instance = (B2WTestCase) getTestClass().getJavaClass().newInstance();
	    	String dataPath;
	    	dataPath = getDataSet(instance);
	    	List<String> iterations = RUN_CONFIG.getPropertiesFiles(dataPath);
	    	if(iterations == null)
	    		log.error("Could not find properties files for " + getTestClass().getName());
	    	else{
	        for(String file:iterations){
	          instance = instance == null ? (B2WTestCase) getTestClass().getJavaClass().newInstance() : instance;
	          setTestProperties(instance, file);
	          ret.add(instance);

	          instance = null; // reset for next loop
	        }
	      }
	    }catch(Throwable t){
	      log.warn("Error spawning test case instance of: " + getTestClass().getJavaClass().getName(), t);
	    }

	    return ret;
	  
	}

	private void setTestProperties(B2WTestCase test, String file) {
		file = test.getDataPath().replaceAll("[/]$", "") + "/" + file;
		test.setProperties(RUN_CONFIG, RUN_CONFIG.getProperties(file), file);

	}
	 public String getDataSet(B2WTestCase test){
		    String dataPath;
		    if(RUN_CONFIG.getProperty("dataMode") != null)
		      dataPath = test.getDataPath() + "/" + RUN_CONFIG.getProperty("dataMode").toUpperCase();
		    else dataPath = test.getDataPath();// +"/NORMAL"; //To Be restored once full
		                                       // implementation is complete
		    return dataPath;
		  }

}
