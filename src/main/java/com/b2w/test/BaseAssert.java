package com.b2w.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class BaseAssert {
	public static final String sFAIL = "FAILED";
	public static final String sPASS = "PASSED";
	public static String sTestCaseName = "";
	public static boolean bTestCasePass = true;
	public static boolean bTestCaseSkipped = false;
	public static String sTestCaseId = "";
	public static int iTestCaseVP = 1;
	public static boolean bOverrideLogLevelDuringSetUp = false;
	protected static HashMap<String, Integer> vpMap = new HashMap<String, Integer>();

	
    private static Logger getLogger() {
        Logger logger = null;
        String sThisTestCaseName = "";
        String sTrace = "";
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] trace = e.getStackTrace();
            
            for(StackTraceElement te : trace)
            	sTrace = sTrace + te.toString() + ",";
            
    
            for (int x = 2; x < trace.length ; x++){
            	if(trace[x].toString().matches(".*testMain.*")){
            		sThisTestCaseName = trace[x].getClassName().substring(trace[x].getClassName().lastIndexOf('.')+1);
            		if(!sThisTestCaseName.equals(sTestCaseName)){
            			sTestCaseName = sThisTestCaseName;
            			bTestCasePass = true;
            		}
            		break;
            	}
            }
            
            for (int i = 2; logger == null && i < trace.length; i++) {	
                if (!trace[i].getClassName().equals(BaseAssert.class.getName())){
                	logger = Logger.getLogger(trace[i].getClassName());
                }
            }
        }
        return logger;
    }
    protected static void logMessage(Level level, String sMessage){
    	Logger _log = getLogger();
    	boolean bFail = level==LogLevel.FAILED;
    	boolean bImage = level == LogLevel.IMAGE;
    	
    	String message = sMessage == null ? "NULL message" : sMessage;
    	if(bOverrideLogLevelDuringSetUp && !bImage)
        	level = LogLevel.SETTING;
    	
    	if(bFail){
    		if(!bOverrideLogLevelDuringSetUp) bTestCasePass = false;
    	}
    	
    	_log.log(level, message);
    	
    	if(bFail)
    		_log.log(LogLevel.IMAGE, "SCREEN CAPTURE");
    }
    
    public static void logCompare(ArrayList<String> expected, ArrayList<String> actual, String sLogMessage){
    	if (expected.size() == actual.size()){
    		for (int i = 0; i < expected.size(); i++){
    			logCompare(expected.get(i), actual.get(i), sLogMessage);
    		}
    	}
    }
    
    /**
	 * Compares the Two strings. Logs the output
	 * @param sExpected
	 * @param sActual
	 * @param sLogMessage message you want logged
	 * @return boolean result
	 */
	public static boolean logCompare(String sExpected, String sActual, String sLogMessage){
		boolean bReturn = false;
		Level level = null;
        
		// compare expected with actual & save result in bReturn
		// set return value T == pass, F == fail
		// set correct pass/fail result string
		if(null != sExpected && sExpected.equals(sActual)){
			bReturn = true;
			level = LogLevel.PASSED;
		}else{
			bReturn = false;
			level = LogLevel.FAILED;
			bTestCasePass = false;
		}

		// report compare results to log & console
		logMessage(level, 
				sLogMessage 
				+ " :: <br><code>Expected: (" + sExpected + ") "+(sExpected.length() > 100? "<br><br>" : "<br>")+"Actual:&nbsp;&nbsp; (" + sActual + ")</code>");
		
		return bReturn;
	}
	

	/**
	 * Compares the two ints. Logs the output
	 * @param iExpected
	 * @param iActual
	 * @param sLogMessage Message you want logged	
	 * @return boolean result
	 */
	public static boolean logCompare(int iExpected, int iActual, String sLogMessage){
		boolean bReturn = false;
		Level level = null;

        // compare expected with actual & save result in bReturn
		// set return value T == pass, F == fail
		// set correct pass/fail result string
		if(iExpected == iActual){
			bReturn = true;
			level = LogLevel.PASSED;
		}else{
			bReturn = false;
			bTestCasePass = bReturn;
			level = LogLevel.FAILED;
		}

		// report compare results to log & console
		logMessage(level, 
				sLogMessage 
				+ " :: Expected: (" + iExpected + ") Actual: (" + iActual + ")");
		
		return bReturn;
	}
	
	/**
	 * Compares two booleans together. Logs the output
	 * @param bExpected
	 * @param bActual
	 * @param sLogMessage Message you want logged
	 * @return boolean result
	 */
	public static boolean logCompare(boolean bExpected, boolean bActual, String sLogMessage){
		boolean bReturn = false;
		Level level = null;
		
		// compare expected with actual & save result in bReturn
		// set return value T == pass, F == fail
		// set correct pass/fail result string
		
        if(bExpected == bActual){ 
			bReturn = true;
			level = LogLevel.PASSED;
		}else{
			bReturn = false;
			bTestCasePass = bReturn;
			level = LogLevel.FAILED;
		}

       // report compare results to log & console
		logMessage(level, 
				sLogMessage 
				+ " :: Expected: (" + bExpected + ") Actual: (" + bActual + ")");
		
		return bReturn;
	}
	
   static public void fail() {
       fail(null);
   }
   
   /**
    * Asserts that a condition is true. If it isn't it throws
    * an AssertionError with the given message.
    */
   static public void assertTrue(String message, boolean condition) {
       try {

           Assert.assertTrue(message, condition);
           logMessage(LogLevel.PASSED,message);
       } catch (AssertionError afe) {
       	logMessage(LogLevel.FAILED, afe.getMessage());
           throw afe;
       }
   }
   
   static public void assertFalse(String message, boolean condition) {
       assertTrue(message, !condition);
   }
   
   /**
    * Fails a test with the given message.
    */
   static public void fail(String message) {
       try {
           Assert.fail(message);
           logMessage(LogLevel.PASSED,message);
       } catch (AssertionError afe) {
       	logMessage(LogLevel.FAILED, afe.getMessage());
           throw afe;
       }
   }
   
	public static void logScreenCapture(String sMessage) {
		logMessage(LogLevel.IMAGE, sMessage);
	}
	
	public static void logScreenCapture() {
		logMessage(LogLevel.IMAGE,"SCREEN CAPTURE");
	}
	
}
