package com.wbl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverUtil {

	static Logger log = LogManager.getLogger(WebDriverUtil.class);

	Browsers browsername;

	// Factory design Pattern
	public static WebDriver getDriver(Browsers browsername) {
		WebDriver driver = null;
		try {
			switch (browsername) {
			case Chrome: // Chrome

				Thread.sleep(5000);
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\cvheg\\eclipse-workspace\\FreeCRMAutomationFramework\\Resource\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case Firefox: // Firefox
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\cvheg\\eclipse-workspace\\FreeCRMAutomationFramework\\Resource\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;

			case edge: // edge
				// WebDriverManager.MicrosoftWebDriver.setup();
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\cvheg\\eclipse-workspace\\FreeCRMAutomationFramework\\Resource\\drivers\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				break;

			case HTMLUnit: // HTMLUnit
				driver = new HtmlUnitDriver();
				break;

			default:
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\cvheg\\eclipse-workspace\\FreeCRMAutomationFramework\\Resource\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			log.error("there is exception while creating the Webdriver object" + e.getMessage());
		}
		return driver;
	}

}
