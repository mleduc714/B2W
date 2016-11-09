package tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import appobjects.resources.KendoUI;
import tasks.util.TaskUtils;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtils {

	public static final int LONG_TIME_OUT = 30;
	public static final int MEDIUM_TIME_OUT = 10;
	public static final int SHORT_TIME_OUT = 5;

	private static Logger log = Logger.getLogger(WebElementUtils.class);

	public static WebElement waitAndFindDisplayedElement(By locator, int timeOut) {
		WebElement el = null;
		WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
		try {
			el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			log.warn("Element "+ locator.toString() +" never displayed with in timeout of " + timeOut);
		}
		return el;
	}

	public static WebElement waitAndFindDisplayedElement(By locator) {
		return waitAndFindDisplayedElement(locator, SHORT_TIME_OUT);
	}

	public static WebElement getChildElement(WebElement parent, By child) {
		WebElement el = null;
		if (parent == null) {
			log.warn("The parent element is null.");
		}
		try {
			el = parent.findElement(child);
		} catch (NoSuchElementException nsee) {
			log.warn("No child of the WebElement that matches " + child.toString());
		}
		return el;
	}

	public static List<WebElement> getChildElements(WebElement parent, By child) {
		List<WebElement> list = null;
		if (parent == null) {
			log.warn("The parent element is null.");
		}
		try {
			list = parent.findElements(child);
		} catch (NoSuchElementException nsee) {
			log.warn("No child of the WebElement that matches " + child.toString());
		}
		return list;
	}

	public static WebElement getChildElement(List<WebElement> list, By child) {
		WebElement el = null;
		if (list.size() == 0) {
			log.warn("The List is empty");
		}

		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement temp = iter.next();
			el = WebElementUtils.getChildElement(temp, child);
			WebElement test = temp.findElement(By.cssSelector("*"));
			if (test.getAttribute("id").endsWith("Panel_UnitOfMeasureDropDownList")) {
				System.out.println(test.getAttribute("id"));
				el = BrowserUtils.getDriver().findElement(By.id(test.getAttribute("id")));
			}

			if (el != null) {
				break;
			}
		}
		return el;
	}

	// not checking if displayed. Could add that?
	public static WebElement getElementWithMatchingChildElementText(By parentsBy, By childBy, String text) {
		List<WebElement> parents = waitAndFindDisplayedElements(parentsBy);
		return getElementWithMatchingChildElementText(parents, childBy, text);
	}

	public static List<WebElement> waitAndFindDisplayedElements(By locator) {
		return waitAndFindDisplayedElements(locator, SHORT_TIME_OUT);
	}

	public static WebElement getElementWithMatchingChildElementText(List<WebElement> list, By childBy, String text) {
		if (list.isEmpty()) {
			log.debug("List of elements to search is empty");
		}
		Iterator<WebElement> iter = list.iterator();
		log.info("List size: " + list.size());
		WebElement ret = null;
		while (iter.hasNext()) {
			WebElement el = iter.next();
			try {
				WebElement child = waitForChildElement(el, childBy, SHORT_TIME_OUT);
				if (text.equals(child.getText())) {
					ret = el;
					break;
				}
			} catch (NoSuchElementException nse) {
				log.warn("Parent did not contain Child element: " + childBy.toString());
				log.debug("Parent Element Class: " + el.getAttribute("class"));
			}

		}
		return ret;
	}

	public static WebElement waitAndFindDisplayedEletment(By locator) {
		return waitAndFindDisplayedElement(locator, SHORT_TIME_OUT);
	}

	public static List<WebElement> waitAndFindDisplayedElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
		try {
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch (TimeoutException e) {
			return new ArrayList<WebElement>();
		}
	}

	public static WebElement waitForChildElement(final WebElement parent, final By childLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
		try {
			return wait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return parent.findElement(childLocator);
				}
			});
		} catch (TimeoutException e) {
			log.warn("Did not find child element, " + childLocator + ", in " + timeOut + " seconds");
			return null;
		}
	}

	public static WebElement getElementWithMatchingText(List<WebElement> list, String text, boolean caseSensitive) {
		Iterator<WebElement> iter = list.iterator();
		log.debug("Number of Elements to search thru " + list.size() + " to find " + text);
		WebElement ret = null;
		while (iter.hasNext()) {
			WebElement el = iter.next();
			// getAllInfo(el);
			String elementText = el.getText();
			if (caseSensitive) {
				if (text.equals(elementText)) {
					ret = el;
					break;
				}
			} else {
				if (text.equalsIgnoreCase(elementText)) {
					ret = el;
					break;
				}
			}
		}
		return ret;
	}
	
	public static WebElement getElementWithMatchingText(By by, String text) {
		WebElement ret = null;
		try {
			List<WebElement> list = WebElementUtils.findElements(by);
			Iterator<WebElement> iter = list.iterator();
			log.debug("Number of Elements to search thru " + list.size() + " to find " + text);
			while (iter.hasNext()) {
				WebElement element = iter.next();

				if (element.getText().equalsIgnoreCase(text)) {
					ret = element;
				}

			}
		} catch (StaleElementReferenceException e) {
			log.warn("Caught Stale Element Exception");
			return getElementWithMatchingText(by, text);
		}

		return ret;
	}

	public static WebElement getElementWithMatchingStartsWithText(List<WebElement> list, String sText) {
		Iterator<WebElement> iter = list.iterator();
		log.debug("Number of Elements to search thru " + list.size());
		WebElement ret = null;
		while (iter.hasNext()) {
			WebElement el = iter.next();
			String sElementText = el.getText();
			if (sElementText.startsWith(sText)) {
				ret = el;
				break;
			}
		}
		return ret;
	}

	public static WebElement getElementWithWithMatchingAttribute(List<WebElement> list, String sAttribute,
			String sAttributeValue) {
		Iterator<WebElement> iter = list.iterator();
		log.debug("Number of Elements to search thru " + list.size());
		WebElement ret = null;
		while (iter.hasNext()) {
			WebElement el = iter.next();
			String sName = el.getAttribute(sAttribute);
			if (sName.equals(sAttributeValue)) {
				ret = el;
				break;
			}
		}
		return ret;
	}

	public static List<WebElement> getElementsWithWithMatchingAttribute(List<WebElement> list, String sAttribute,
																 String sAttributeValue) {
		List<WebElement> listResult = new ArrayList<WebElement>();
		Iterator<WebElement> iter = list.iterator();
		log.debug("Number of Elements to search thru " + list.size());
		while (iter.hasNext()) {
			WebElement el = iter.next();
			String sName = el.getAttribute(sAttribute);
			if (sName.equals(sAttributeValue)) {
				listResult.add(el);
			}
		}
		return listResult;
	}

	public static boolean switchToFrame(By locator, int timeout) {
		boolean bReturn = false;
		WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeout);
		long start = System.currentTimeMillis();
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
			bReturn = true;
		} catch (TimeoutException toe) {
			log.warn("Element with locator '" + locator.toString() + " was never focused.");
		} catch (WebDriverException wde) {
			log.debug("WebDriverException thrown, will quickly retry: " + wde);
			int adjustedTimeout = (int) Math.max(timeout - ((System.currentTimeMillis() - start) / 1000.0),
					SHORT_TIME_OUT);
			bReturn = switchToFrame(locator, adjustedTimeout);
		}
		return bReturn;
	}

	public static WebElement findElement(By locator) {
		try {
			log.debug("Looking for element "+locator.toString());
			return BrowserUtils.getDriver().findElement(locator);
		} catch (NoSuchElementException e) {
			log.debug("Element with Locator " + locator + " not found");
			return null;
		}
	}

	public static List<WebElement> findElements(By locator) {

		try {
			return BrowserUtils.getDriver().findElements(locator);
		} catch (NoSuchElementException e) {
			log.debug("Element with Locator " + locator + " not found");
			return null;
		}

	}

	public static boolean sendKeys(By locator, String sText) {
		boolean bReturn = false;
		WebElement el = findElement(locator);
		if (el != null) {
			bReturn = sendKeys(el, sText);
		}

		return bReturn;
	}

	public static boolean sendKeys(WebElement el, String keysToSend) {
		boolean bReturn = false;
		try {
			el.sendKeys(keysToSend);
			log.debug("Sending "+keysToSend+ " to: " +el.toString());
			bReturn = true;
		} catch (WebDriverException wde) {
			log.debug("Exception Throws using native sendKeys. " + wde.getMessage());
		}
		return bReturn;
	}

	public static boolean setTextWithJS(By by, String text) {
		boolean bReturn = false;
		WebElement el = findElement(by);
		if (el == null) {
			log.debug("Unable to find element with locator " + by);

		} else {
			setTextWithJS(el, text);
			bReturn = true;
		}
		return bReturn;
	}

	public static void setTextWithJS(WebElement el, String text) {
		text = text.replace("\\", "\\\\");
		((JavascriptExecutor) BrowserUtils.getDriver())
				.executeScript("arguments[0].setAttribute('value', '" + text + "')", el);
	}

	public static boolean clickElement(By target) {
		return clickElement(target, SHORT_TIME_OUT);
	}

	public static boolean clickElement(By target, int timeout) {
		WebElement element = null;
		boolean bReturn = false;
		long start = System.currentTimeMillis();
		try {
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(target));
			if (!BrowserUtils.isSafari()) {
				element.click();
			} else {
				// TODO
				// clickWithRobot(element);
			}
			bReturn = true;
		} catch (TimeoutException e) {
			log.debug("Unable to click element " + target + "\n" + e);
		} catch(StaleElementReferenceException e2){
			try {
				int remaining = (int) Math.floor(timeout - ((System.currentTimeMillis() - start) / 1000.0));
				log.debug("Stale Reference caught - Waiting additonal " + remaining + " seconds for element clikcable");
				if (remaining > 0) {
					WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), remaining);
					element = wait.until(ExpectedConditions.elementToBeClickable(target));
					element.click();
					return true;
				} else {
					return false;
				}
			}catch(WebDriverException e3){
		          log.debug("Unable to click element " + target + "\n" + e2);
		          return false;
		        }
		}
		return bReturn;
	}

	public static boolean clickElement(WebElement element) {
		boolean bReturn = false;
		if (waitForElementClickable(element)) {
			if (!BrowserUtils.isSafari()) {
				try {
					new Actions(BrowserUtils.getDriver()).click(element).perform();
					bReturn = true;
				} catch (WebDriverException e) {
					try {
						log.debug("First click failed - " + e.getMessage());
						TaskUtils.sleep(500);
						element.click();
						bReturn = true;
						//new Actions(BrowserUtils.getDriver()).click(element).perform();
						//bReturn = true;
					} catch (WebDriverException e2) {
						// Still not clickable, fail
						log.debug("Retry click failed - Unable to click element " + element.getAttribute("class") + "\n"
								+ e2);
					}
				} 
				
			} else {
				// clickWithRobot(element);
				// TODO if we do safari requires robot
			}
		}
		return bReturn;
	}

	public static WebElement waitAndFindElement(By locator) {
		return waitAndFindElement(locator, MEDIUM_TIME_OUT);
	}

	/**
	 * Will wait timeout value in seconds for an element matching the locator to
	 * be visible and return that WebElement
	 * 
	 * @return The first element in the dom found matching the locator else null
	 */
	public static WebElement waitAndFindElement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeout);
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			return null;
		}
	}

	public static boolean waitForElementClickable(By locator) {
		return waitForElementClickable(locator, MEDIUM_TIME_OUT, true);
	}

	public static boolean waitForElementClickable(WebElement el) {
		return waitForElementClickable(el, MEDIUM_TIME_OUT, true);
	}

	public static boolean waitForElementClickable(By locator, int timeOut, boolean expectedClickable) {
		boolean bReturn = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			bReturn = true;
		} catch (TimeoutException e) {
			if (!expectedClickable) {
				bReturn = true;
			} else {
				log.warn("Element with locator '" + locator + "' is not clickable");
			}
		}
		return bReturn;
	}

	public static boolean waitForElementClickable(WebElement element, int timeout, boolean expectedClickable) {
		boolean bReturn = false;
		if (element == null) {
			log.warn("The provided WebElement was null");
		}
		try {
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			bReturn = true;
		} catch (TimeoutException e) {
			if (!expectedClickable) {
				bReturn = true;
			} else {
				log.warn("Element with locator '" + element + "' is not clickable");

			}
		}
		return bReturn;
	}

	private static ExpectedCondition<Boolean> attributeToHaveValue(final By locator, final String attribute,
			final String value, final boolean b) {

		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				try {
					String elementText = driver.findElement(locator).getAttribute(attribute);
					if (elementText != null) {
						if (value != null) {
							String pattern = (attribute.equals("class"))
									? ("(^|\\s)\\Q" + value.toUpperCase() + "\\E($|\\s)")
									: "\\Q" + value.toUpperCase() + "\\E";
							// If value is not NULL, proceed with the
							// comparison.
							elementText = elementText.replaceAll("\\xA0", " ").toUpperCase();
							Pattern patern = Pattern.compile(pattern);
							boolean found = patern.matcher(elementText).find();
							return b ? found : !found;
						} else {
							// If value is NULL, then the expected value does
							// not match what was found.
							return !b;
						}
					} else {
						// The attribute returned null. Was the expected value
						// also null? Did this match our
						// expectations?
						return (value == null) == b;
					}
				} catch (NoSuchElementException e) {
					return !b;
				} catch (NullPointerException e) {
					log.debug(e.getMessage());
					if (driver == null) {
						log.debug("The driver is null");
					} else {
						log.debug(driver.findElement(locator).toString());
					}
					return null;
				}
			}
		};

	}
	
	
	private static ExpectedCondition<Boolean> attributeToHaveValue(final WebElement el, final String attribute,
			final String value, final boolean b) {

		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				try {
					String elementText = el.getAttribute(attribute);
					if (elementText != null) {
						if (value != null) {
							String pattern = (attribute.equals("class"))
									? ("(^|\\s)\\Q" + value.toUpperCase() + "\\E($|\\s)")
									: "\\Q" + value.toUpperCase() + "\\E";
							// If value is not NULL, proceed with the
							// comparison.
							elementText = elementText.replaceAll("\\xA0", " ").toUpperCase();
							Pattern patern = Pattern.compile(pattern);
							boolean found = patern.matcher(elementText).find();
							return b ? found : !found;
						} else {
							// If value is NULL, then the expected value does
							// not match what was found.
							return !b;
						}
					} else {
						// The attribute returned null. Was the expected value
						// also null? Did this match our
						// expectations?
						return (value == null) == b;
					}
				} catch (NoSuchElementException e) {
					return !b;
				} catch (NullPointerException e) {
					log.debug(e.getMessage());
					if (driver == null) {
						log.debug("The driver is null");
					} else {
						log.debug(el.toString());
					}
					return null;
				}
			}
		};

	}

	public static boolean waitForElementHasAttributeWithValue(By by, String attribute, String value, boolean expected,
			int timeOut) {
		boolean bReturn = false;
		try {
			log.info("The Value now is: " + WebElementUtils.findElement(by).getAttribute(attribute));
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
			bReturn = wait.until(attributeToHaveValue(by, attribute, value, expected));
		} catch (TimeoutException toe) {
			log.warn("Element with locator '" + by.toString() + " " + attribute + " attribute "
					+ (expected ? "never contained " : "never lost ") + value);
		} catch (StaleElementReferenceException e) {
			log.warn("Stale Element Exception");
			return waitForElementHasAttributeWithValue(by, attribute, value, expected, timeOut);
		}
		return bReturn;
	}

	public static boolean waitForElementHasAttributeWithValue(WebElement el, String attribute, String value, boolean expected,
			int timeOut) {
		boolean bReturn = false;
		try {
			log.info("The Value now is: " + el.getAttribute(attribute));
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
			bReturn = wait.until(attributeToHaveValue(el, attribute, value, expected));
		} catch (TimeoutException toe) {
			log.warn("Element with locator '" + el.toString() + " " + attribute + " attribute "
					+ (expected ? "never contained " : "never lost ") + value);
		} catch (StaleElementReferenceException e) {
			log.warn("Stale Element Exception");
			return waitForElementHasAttributeWithValue(el, attribute, value, expected, timeOut);
		}
		return bReturn;
	}
	

	public static boolean selectElementFromDropDownList(List<WebElement> els, int iSelect) {
		boolean bReturn = false;
		if (iSelect <= els.size() - 1) {
			log.debug("Total number of selections in the dropdown is: " + els.size());
			bReturn = WebElementUtils.clickElement(els.get(iSelect));
			log.debug("Selection from the dropdown: ");
			els.get(iSelect).getText();
		}

		return bReturn;
	}

	public static String getSelectedTextFromDropDown(By by) {
		try {
			WebElement dd = WebElementUtils.findElement(by);
			List<WebElement> els = dd.findElements(By.tagName("option"));
			Iterator<WebElement> iter = els.iterator();
			while (iter.hasNext()) {
				WebElement el = iter.next();
				if (el.getAttribute("selected") != null) {
					return el.getText();
				}
			}
		} catch (StaleElementReferenceException e) {
			log.warn("Found Stale Element Exception");
			return getSelectedTextFromDropDown(by);
		}
		return "";

	}

	public static boolean isCheckboxChecked(By by) {
		boolean bReturn = false;
		try{
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(by);
		bReturn = new Boolean(el.getAttribute("checked"));
		}catch (StaleElementReferenceException e){
			log.warn("Caught stale element exception in checking box");
			return isCheckboxChecked(by);
		}
		return bReturn;
	}

	public static boolean isCheckboxChecked(WebElement el) {
		boolean bReturn = false;
		try{
			bReturn = new Boolean(el.getAttribute("checked"));
		}catch (StaleElementReferenceException e){
			log.warn("Caught stale element exception in checking box");
		}
		return bReturn;
	}

	public static Alert waitForAndGetAlertDialog(int timeOut) {
		Alert ret = null;
		try {
			log.debug("Begin waitForAndGetAlertDialog() timeOut=" + timeOut);
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
			ret = wait.until(ExpectedConditions.alertIsPresent());
			log.debug("Found Alter with message: " + ret.getText());
		} catch (TimeoutException te) {
			log.warn("No Alert was shown within " + timeOut + " seconds");
		}
		return ret;
	}

	public static boolean waitForElementIsDisplayed(WebElement el, int iTimeout) {
		WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), iTimeout);
		wait.until(ExpectedConditions.visibilityOf(el));
		return el.isDisplayed();
	}

	public static boolean selectItemFromOpsDropDownMenu(By by, String sText) {
		boolean bReturn = false;
		try {
			WebElement el = WebElementUtils.findElement(by);
			if (el != null) {
				List<WebElement> els = el.findElements(By.tagName("option"));
				WebElement item = WebElementUtils.getElementWithMatchingText(els, sText, false);
				if (item != null) {
					WebElementUtils.clickElement(item);
					bReturn = true;
				} else {
					log.warn("The Item is Null: " + sText);
				}
			}
		} catch (StaleElementReferenceException e) {
			log.warn("Caught Stale Element Exception!!");
			return selectItemFromOpsDropDownMenu(by, sText);
		}
		return bReturn;
	}
	
	public static String selectAnyItemFromOpsDropDownMenu(By by){
		String sItem = "";
		try {
			WebElement el = WebElementUtils.findElement(by);
			if (el != null) {
				List<WebElement> els = el.findElements(By.tagName("option"));
				Random rand = new Random();

				int randnumber = rand.nextInt(els.size()-1);
				WebElement item = els.get(randnumber);
				if (item != null) {
					WebElementUtils.clickElement(item);
					sItem = item.getText();
				} else {
					log.warn("The Item is Null");
				}
			}
		} catch (StaleElementReferenceException e) {
			log.warn("Caught Stale Element Exception!!");
			return selectAnyItemFromOpsDropDownMenu(by);
		}
		return sItem;
	}
	
	
	public static void selectItemFromOpsDropDownMenuByStartsWithText(By by, String sText) {
		try {
			WebElement el = WebElementUtils.findElement(by);
			List<WebElement> els = el.findElements(By.tagName("option"));
			WebElement item = WebElementUtils.getElementWithMatchingStartsWithText(els, sText);
			if (item != null) {
				WebElementUtils.clickElement(item);
			} else {
				log.warn("The Item is Null: " + sText);
			}
		} catch (StaleElementReferenceException e) {
			log.warn("Caught Stale Element Exception!!");
			selectItemFromOpsDropDownMenu(by, sText);
		}
	}
	
	public static String selectItemFromOpsDropDownMenuByNumber(By by, int iNumber) {
		String sCategory = "";
		try {
			WebElement el = WebElementUtils.findElement(by);
			List<WebElement> els = el.findElements(By.tagName("option"));
			if (els.size() != 0) {
				if (!(iNumber > (els.size() -1))){
					sCategory = els.get(iNumber).getText();
					WebElementUtils.clickElement(els.get(iNumber));
				}
			} else {
				log.warn("The Number was not found");
			}
		} catch (StaleElementReferenceException e) {
			log.warn("Caught Stale Element Exception!!");
			return selectItemFromOpsDropDownMenuByNumber(by, iNumber);
		}
		return sCategory;
	}

	public static boolean waitForElementStale(WebElement el, int timeOut) {
		boolean isStale = false;
		// If the WebElement is null, do not attempt this method
		if (el == null) {
			log.warn("The provided WebElement was NULL.");
		} else {
			try {
				WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
				isStale = wait.until(ExpectedConditions.stalenessOf(el));
			} catch (TimeoutException toe) {
				log.debug("Element was not found to be Stale in time");
			}
		}
		return isStale;
	}

	public static boolean setAttributeWithJS(String sID, String sAttribute, String sValue) {
		boolean bReturn = false;
		String sExecute = "document.getElementById('" + sID + "').setAttribute('" + sAttribute + "', '" + sValue + "')";
		try {
			JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.getDriver();
			js.executeScript(sExecute);
			bReturn = true;
		} catch (Exception e) {
			//log.warn("Found Exception in executing javascript");
		}
		return bReturn;

	}
	

	public static void moveVirtualMouseOverElement(WebElement el) {
		if (el == null) {
			log.warn("The provided WebElement was NULL.");
		} else {
			if (!BrowserUtils.isSafari()) {
				Actions action = new Actions(BrowserUtils.getDriver());
				action.moveToElement(el);
				action.perform();
			} else {
				try {
					Robot robot = new Robot();
					robot.setAutoDelay(1000);
					int targetX = el.getLocation().x + el.getSize().width / 2;
					int targetY = el.getLocation().y + el.getSize().height / 2;
					robot.mouseMove(targetX, targetY);
				} catch (AWTException e) {
					log.warn(e.getMessage());
				}
			}
		}
	}

	public static void getAllInfo(WebElement el) {
		JavascriptExecutor executor = (JavascriptExecutor) BrowserUtils.getDriver();
		Object aa = executor.executeScript(
				"var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
				el);
		System.out.println(aa.toString());
	}

	public static WebElement getParentElement(WebElement el) {
		JavascriptExecutor executor = (JavascriptExecutor) BrowserUtils.getDriver();
		WebElement parentElement = (WebElement) executor.executeScript("return arguments[0].parentNode;", el);
		return parentElement;
	}

	public static WebElement getParentUntilTagName(WebElement el, String sTagName) {
		WebElement elResult = getParentElement(el);
		while (!elResult.getTagName().toLowerCase().equals(sTagName)) {
			elResult = getParentElement(elResult);
		}
		return elResult;
	}
	public static boolean waitForElementInvisible(WebElement element, int timeout, boolean expectedClickable) {
		boolean bReturn = false;
		if (element == null) {
			log.warn("The provided WebElement was null");
		}
		try {
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeout);
			List<WebElement> list = new ArrayList<WebElement>();
			list.add(element);
			wait.until(ExpectedConditions.invisibilityOfAllElements(list));
			bReturn = true;
		} catch (TimeoutException e) {
			if (!expectedClickable) {
				bReturn = true;
			} else {
				log.warn("Element with locator '" + element + "' is not Invisible");

			}
		}
		return bReturn;
	}

	public static boolean waitForElementInvisible(WebElement element) {
		return waitForElementInvisible(element, MEDIUM_TIME_OUT, true);
	}
	
	public static String getElementValueByAttribute(By by, String sAttribute){
		String sValue = "";
		try {
			WebElement el = WebElementUtils.findElement(by);
			sValue = el.getAttribute(sAttribute);
		}catch (StaleElementReferenceException e){
			log.warn("Caught Stale Element Exception in trying to obtain value of attribute");
			return getElementValueByAttribute(by, sAttribute);
		}
		return sValue;
	}

	public static WebElement getKendoFDDElementByLabel(String sText) {
		try {
			List<WebElement> inputList = WebElementUtils.findElements(By.cssSelector("label"));
			WebElement el = getElementWithMatchingText(inputList, sText, false);
			if (el != null) {
				WebElement parent = getParentElement(el);
				WebElement elResult = getChildElement(parent, KendoUI.getKendoDropDown());
				return elResult;
			} else {
				log.debug(sText + " could not be found on the Page.");
				return null;
			}
		} catch (TimeoutException e) {
			log.warn("Could not find element with text " + sText);
			return null;
		}

	}
}
