package com.wbl.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	static Logger log = LogManager.getLogger(WaitUtil.class);

	public static void implicitWait(WebDriver driver, long timeInSecs) {
		driver.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);
	}

	public static WebElement explicitWait(WebDriver driver, long timeInSecs, WebElement element) {
		WebElement e = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
			e = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception ex) {
			log.error("There has been exception during explicit wait");
		}
		return e;
	}

	public static List<WebElement> explicitWait(WebDriver driver, long timeInSecs, List<WebElement> element) {
		List<WebElement> e = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
			e = wait.until(ExpectedConditions.visibilityOfAllElements(element));
		} catch (Exception ex) {
			log.error("There has been exception during explicit wait");
		}
		return e;
	}
}
