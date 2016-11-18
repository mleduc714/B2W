package tasks.util;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Timer {
	private long startTime = 0;
	private long endTime = 0;
	Logger log = Logger.getLogger(Timer.class);
	// simple timer class
	// class to time

	public void start() throws IOException {
		startTime = System.currentTimeMillis();
		log.info("TIMER START -> " + this.dateParser(startTime));
	}

	public void end() throws IOException {
		this.endTime = System.currentTimeMillis();
		log.info("TIMER END -> " + this.dateParser(this.endTime));
	}

	public Date getStartTime() throws IOException {
		log.info("GET START -> " + this.dateParser(this.startTime));
		return this.dateParser(this.startTime);
	}

	public Date getEndTime() throws IOException {
		log.info("GET END -> " + this.dateParser(this.endTime));
		return this.dateParser(this.endTime);
	}

	public long getTotalTime() throws IOException {
		long deltaTime = this.endTime - this.startTime;
		log.info("GET TOTAL -> " + deltaTime + " ms");
		return deltaTime;
	}

	public Date dateParser(long unixTime) {
		Date date = new Date();
		date.setTime(unixTime);
		return date;
	}

	public void waitFullLoad(WebDriver driver) throws InterruptedException {
		waitForLoad(driver);
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.id("ProcessingMessage1"))));
		List<WebElement> waitItems = driver.findElements(By.className("k-loading-image"));
		if (waitItems.size() > 0) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(waitItems));
		}
		waitForAjax(driver);

		Thread.sleep(500);
	}

	private void waitForAjax(WebDriver driver) throws InterruptedException {
		while (true) {
			Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
			if (ajaxIsComplete) {
				break;
			}
			TaskUtils.sleep(500);
		}
	}

	private void waitForLoad(WebDriver driver) throws InterruptedException {
		while (true) {
			Boolean loaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState")
					.equals("complete");
			if (loaded) {
				break;
			}
			TaskUtils.sleep(500);
		}
	}
}