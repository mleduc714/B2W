package tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	public static final int SHORT_TIME_OUT = 2;

	private static Logger log = Logger.getLogger(WebElementUtils.class);

	public static WebElement waitAndFindDisplayedElement(By locator, int timeOut) {
		WebElement el = null;
		WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
		try {
			el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			log.warn("Element never displayed with in timeout of " + timeOut);
		}
		return el;
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

	public static WebElement waitAndFindDisplayedElement(By locator) {
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
		log.debug("Number of Elements to search thru " + list.size());
		WebElement ret = null;
		while (iter.hasNext()) {
			WebElement el = iter.next();
			if (caseSensitive) {
				if (text.equals(el.getText())) {
					ret = el;
					break;
				}
			} else {
				if (text.equalsIgnoreCase(el.getText())) {
					ret = el;
					break;
				}
			}
		}
		return ret;
	}

	public static WebElement getElementWithMatchingStartsWithText(List<WebElement> list, String sText) {
		Iterator<WebElement> iter = list.iterator();
		log.debug("Number of Elements to search thru " + list.size());
		WebElement ret = null;
		while (iter.hasNext()) {
			WebElement el = iter.next();

			if (el.getText().startsWith(sText)) {
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
			bReturn = true;
		} catch (WebDriverException wde) {
			log.debug("Exception Throws using native sendKeys. " + wde.getMessage());
		}
		return bReturn;
	}

	public static boolean clickElement(By target) {
		return clickElement(target, SHORT_TIME_OUT);
	}

	public static boolean clickElement(By target, int timeout) {
		WebElement element = null;
		boolean bReturn = false;
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
		}
		return bReturn;
	}

	public static boolean clickElement(WebElement element) {
		boolean bReturn = false;
		if (waitForElementClickable(element)) {
			if (!BrowserUtils.isSafari()) {
				try {
					element.click();
					bReturn = true;
				} catch (WebDriverException e) {
					try {
						log.debug("First click failed - " + e.getMessage());
						new Actions(BrowserUtils.getDriver()).click(element).perform();
						bReturn = true;
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

	/**
	 * @param by
	 * @param attribute
	 * @param value
	 * @param expected
	 * @param timeOut
	 * @return
	 */
	public static boolean waitForElementHasAttributeWithValue(By by, String attribute, String value, boolean expected,
			int timeOut) {
		boolean bReturn = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
			bReturn = wait.until(attributeToHaveValue(by, attribute, value, expected));
		} catch (TimeoutException toe) {
			log.warn("Element with locator '" + by.toString() + " " + attribute + " attribute "
					+ (expected ? "never contained " : "never lost ") + value);
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

	public static String getSelectedTextFromDropDown(List<WebElement> els) {
		String sSelection = null;
		Iterator<WebElement> iter = els.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			if (el.getAttribute("selected") != null) {
				sSelection = el.getText();
			}
		}
		return sSelection;

	}

	public static boolean isCheckboxChecked(WebElement el) {
		return new Boolean(el.getAttribute("checked"));
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

}
