package tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	
    private static WebDriver driver;
    protected static String webdriverDir = "//webdriver//";
    protected final static String libDir =  new File(".").getAbsolutePath();
    protected static String sDriverName;
    protected static File file;
    public static final String chromeDriverLocationProp = "webdriver.chrome.driver";
    public static final String ieDriverLocationProp = "webdriver.ie.driver";
    private static int defaultAsyncScriptTimeout = 100; // milliseconds value
    private static Logger log = Logger.getLogger(BrowserUtils.class);
    private static String mainWindowHandle;

    
    public enum Browser {
    	CHROME, EXPLORER, FIREFOX, SAFARI, EDGE
    }
    public static Browser browser;
    
	public static boolean loadURL(String url) {
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null)
			start();
		if (driver != null) {
			//driver.get(url);
			driver.get(url);
			
			switch (browser) {
			case CHROME:
				break;
			case FIREFOX:
				break;
			case EXPLORER:
				break;
			case SAFARI:
				break;
			case EDGE:
				break;
			}

			maximize();
			log.debug("Waiting for page to load after URL navigation: " + waitForPageLoaded());
			return true;
		} else {
			log.error("The WebDriver instance (wdBrowser) is null (most likely missing or corrupt driver)");
			return false;
		}
	}
    
    public static WebDriver getDriver() {
    	if (driver == null){
    	switch (browser){
    	case CHROME:
    		setChromeDriver();
    		break;
    	case FIREFOX:
    		setFireFoxDriver();
    		break;
    	case EXPLORER:
    		break;
    	case SAFARI:
    		break;
    	case EDGE:
    		break;
    	}
    	}
    	return driver;
    }
	
	
	public static void setWebBrowser(String sBrowser) {
		if (sBrowser.equals("chrome")){
			browser = Browser.CHROME;
		}
		if (sBrowser.equals("explorer")){
			browser = Browser.EXPLORER;
		}
		if (sBrowser.equals("firefox")){
			browser = Browser.FIREFOX;
		}
	}
	
	 public static void setChromeDriver(){
		    sDriverName = "chromedriver.exe";
		    file = new File(libDir+webdriverDir+sDriverName);
			System.setProperty(chromeDriverLocationProp, file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			List<String> ls = new ArrayList<String>();
			ls.add("--start-maximized");
			ls.add("disable-infobars");
			ls.add("test-type");
			ls.add("disable-extensions");
			options.addArguments(ls);
			driver = new ChromeDriver(options);
	 }
	 
	 public static void setExplorerDriver() {
		 driver = new InternetExplorerDriver();
		 
	 }
	 public static boolean isFirefox(){
		return browser.equals(Browser.FIREFOX);
	 }
	 public static boolean isChrome() {
		return browser.equals(Browser.CHROME);
	 }
	 public static boolean isInternetExplorer() {
		return browser.equals(Browser.EXPLORER);
	 }
	 public static boolean isSafari(){
		return browser.equals(Browser.SAFARI);
	 }
	 public static boolean isEdge() {
		 return browser.equals(Browser.EDGE);
	 }
	 public static void setFireFoxDriver() {
		 FirefoxProfile profile = new FirefoxProfile();
		 profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "opsdeploy-4");

		 driver = new FirefoxDriver(profile);
		 driver = new FirefoxDriver();
	 }

	 private static void start(){
		    start(false, false);
	}
	 private static boolean start(boolean useProxy, boolean enableProxyLogging){
		    log.info("Starting Driver for " + browser);
		    try{
		      getDriver();
		    }catch(WebDriverException wde){
		      log.debug("WebDriverException caught on WebDriver startup\n" + wde);
		    }catch(Throwable t){
		      log.debug("Generic Exception caught on WebDriver startup\n" + t);
		    }
		    if(driver == null){
		      log.error("Web Driver Instance was not able to be created");
		      return false;
		    }else{
		      driver.manage().timeouts().setScriptTimeout(defaultAsyncScriptTimeout, TimeUnit.MILLISECONDS);
		      mainWindowHandle = getWindowHandle();
		      log.debug("Browser Instance has started Main Window has been set to " + mainWindowHandle);
		      return true;
		    }
		  }

	  /**
	   * Maximizes the currently focused browser window using WebDriver APIs. Currently working around
	   * Mac defect by manually setting browser size
	   */
	  public static void maximize(){
	    if(driver == null){
	      log.error("Driver instance did not exist to Maximize");
	      return;
	    }
	   
	     driver.manage().window().maximize();
	    }
	  /**
	   * A quick way of determining if the page is loaded. This does not guarantee the page is ready to
	   * be interacted with. Use with caution.
	   */
	  public static boolean waitForPageLoaded(){
	    return waitForPageLoaded(30);
	  }

	  /**
	   * A quick way of determining if the page is loaded. This does not guarantee the page is ready to
	   * be interacted with. Use with caution.
	   */
	  public static boolean waitForPageLoaded(int timeoutInSeconds){
	    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>(){
	      public Boolean apply(WebDriver driver){
	        String state = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
	        return state.equals("complete");
	      }
	    };
	    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	    try{
	      wait.until(pageLoadCondition);
	      log.debug("Page Load Completed");
	    }catch(TimeoutException toe){
	      log.warn(toe.getMessage());
	      String state =
	          (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
	      return state.equals("complete");
	    }
	    return true;
	  }
	  
	  public static String getWindowHandle(){
		 
		    return driver.getWindowHandle();
	  }
	  
	  /**
	   * Uses the Java Robot to move the mouse cursor to the top left corner of the screen.
	   */
	  public static void moveMouseOffScreen(){
	    try{
	      Robot r = new Robot();
	      r.mouseMove(0, Toolkit.getDefaultToolkit().getScreenSize().height);
	    }catch(AWTException e){
	      e.printStackTrace();
	    }
	  }
	  
	 

		public static boolean waitForAuthenticationDialog(String sUserName, String sPassword){
			boolean bReturn = false;
			try {
				WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), WebElementUtils.MEDIUM_TIME_OUT);      
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				alert.authenticateUsing(new UserAndPassword(sUserName, sPassword));
				bReturn = true;
			}catch (TimeoutException toe){
				log.warn("The Authentication Alert did not appear within the timeout of "+ WebElementUtils.MEDIUM_TIME_OUT);
			}
			return bReturn;
		}

}
