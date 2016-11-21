package com.b2w.test;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class BaseTestCase extends BaseAssert implements BaseTestCaseInterface {
    /**
     * Info, warn, error, and fatal logging levels can be used tests.  Debug is reserved for the testing framework. 
     */
	public enum STATUS {PASS, FAIL, SKIP};
    protected Logger log;
    private boolean _rerun = false; 
    protected String dataFile = "";
    protected String uniqueInstance;
    private static int randnumber = 0;
    
    public BaseTestCase() {
        log = Logger.getLogger(getClass());
        uniqueInstance = "";
    }
    
    @Before
    public void before() throws Throwable {
        testSetUp();
    }
    
    @Test
    public void runTest() throws Throwable {
        testMain();
    }
    
    @After
    public void after() throws Throwable {
        testTearDown();
    }

    @Override
    public boolean isRerun() {
        return _rerun;
    }

    @Override
    public void setRerun(boolean isRerun) {
        _rerun = isRerun;
    }
    
    public String getTestCaseId() {
    	return "";
    }
    
    public void setDataFile(String sFileName){
    	dataFile = sFileName;
    }
    
    public String getDataFile() {
    	return dataFile;
    }
    
    public void setInstance(String sInstance){
    	uniqueInstance = sInstance;
    }
    
    public String getInstance() {
    	return uniqueInstance;
    }
    
	 
	public static int getRandomNumber() {
		if (randnumber == 0) {
			Random rand = new Random();

			randnumber = rand.nextInt(10000) + 1;
		}
		return randnumber;
	}

	public static int getRandomNumber(int iRange) {

		Random rand = new Random();

		randnumber = rand.nextInt(iRange) + 1;

		return randnumber;
	}
}
