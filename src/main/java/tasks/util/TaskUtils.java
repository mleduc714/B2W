package tasks.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.b2w.test.BaseAssert;

import appobjects.B2WCommonObjects;
import tasks.BrowserUtils;
import tasks.WebElementUtils;

public class TaskUtils extends BaseAssert {

	private static Logger log = Logger.getLogger(TaskUtils.class);

	public static void sleep(int milliSeconds) {
		log.debug("Sleeping Thread for " + milliSeconds / 1000.0 + " seconds");
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * @param sHeader
	 * @return
	 */
	public boolean waitForPageHeader(String sHeader) {
		boolean bReturn = false;
		WebElement panel = WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPageContentDetailPanel(), WebElementUtils.MEDIUM_TIME_OUT);
		String sText = panel.findElement(By.tagName("h2")).getText();
		log.debug("Panel is " + sText);
		if (sText.equals(sHeader)) {
			bReturn = true;
		}
		return bReturn;

	}
	
	public String getPageHeader() {
		String sText = "";
		WebElement el = WebElementUtils.findElement(B2WCommonObjects.getB2WPageContentDetailPanel());
		if (el!=null){
			sText = el.findElement(By.tagName("h2")).getText();
		}
		return sText;
	}
	

	public boolean waitForProductPanel(String sProduct) {
		boolean bReturn = false;
		WebElement panel = WebElementUtils.waitAndFindDisplayedElement(B2WCommonObjects.getB2WPageProductPanel());
		String sText = panel.findElement(By.tagName("h1")).getText();
		log.debug("Product Panel is " + sText);
		if (sText.equals(sProduct)) {
			bReturn = true;
		}
		return bReturn;
	}
	

	public String getTextOfCurrentSelectionFromDropDown(WebElement el) {
		String sSelection = null;
		List<WebElement> list = el.findElements(By.tagName("option"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.isSelected()) {
				sSelection = item.getText();
				break;
			}
		}
		return sSelection;
	}

	public int getPositionCurrentSelectionFromDropDown(WebElement el) {
		int i = -1;
		List<WebElement> list = el.findElements(By.tagName("option"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement item = iter.next();
			if (item.isSelected()) {
				i = new Integer(item.getAttribute("value")).intValue();
				break;
			}
		}
		return i;
	}

	public static Alert getAlertDialog() {
		Alert alert = null;
		try {
			alert = BrowserUtils.getDriver().switchTo().alert();
			log.debug("Alert Message: " + alert.getText());
		} catch (NoAlertPresentException nape) {
			log.warn("No Alert Dialog was found: " + nape);
		} catch (NoSuchWindowException nswe) {
			log.warn("The expected alert was not found: " + nswe);
		} catch (TimeoutException toe) {
			log.warn("TimeoutException, usally a browser hang: " + toe);
		}
		return alert;
	}

	public static boolean dismissAlert() {
		boolean bReturn = false;
		Alert alert = getAlertDialog();
		if (alert != null) {
			log.debug("Dismissing alert with message: " + alert.getText());
			alert.accept();
			bReturn = waitForAlertNotPresent(WebElementUtils.SHORT_TIME_OUT);
		} else {
			log.warn("No alert dialog found");
		}
		return bReturn;
	}

	private static boolean waitForAlertNotPresent(int timeOut) {
		boolean bReturn = false;
		try {
			WebDriverWait wait = new WebDriverWait(BrowserUtils.getDriver(), timeOut);
			wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
			bReturn = true;
		} catch (TimeoutException te) {
			logScreenCapture("Unexpected Alert");
			log.warn("An Alert was still present after " + timeOut + " seconds");
		}
		return bReturn;
	}
	
	public static ArrayList<String> getTextFromElements(By by) {
		ArrayList<String> al = new ArrayList<String>();
		List<WebElement> ls = WebElementUtils.findElements(by);
		if (!ls.isEmpty()) {
			Iterator<WebElement> iter = ls.iterator();
			while (iter.hasNext()) {
				WebElement el = iter.next();
				al.add(el.getText());
			}
		}
		return al;

	}
}
