//Q) Develop AutomationFramework(Minimum 4 Pages) from scratch on https://freecrm.co.in/ , push into GitHub and Share the Link.
//1. Page Object Pattern 2. UI Mapping 3. Data Driven 4. Support for Edge, Chrome, Firefox and HTMLUnit 
//5. Preference to CSS and XPath Selectors 6. TestNG HTML report and Extent Reports. 7. implement EventFiringWebDriver 
//8. Log4J 9. Analyze the code with FindBugs and CheckStyles(IDE plugins) solve violations and bugs then push it into GitHub

package com.wbl.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wbl.util.Browsers;
import com.wbl.util.ConfigUtils;
import com.wbl.util.WebDriverUtil;

public class BaseTest {

	protected static WebDriver driver;
	protected static String url;
	protected static String browser;
	protected static Browsers b;
	public static ExtentTest test;
	public static ExtentReports report;

	@BeforeSuite
	public void initialsetup() {
		String dir = System.getProperty("user.dir");
		ConfigUtils configUtils = new ConfigUtils(dir + "\\Resource\\PropertiesFile\\config.properties");
		url = configUtils.getProperty("QAurl");
		browser = configUtils.getProperty("browser");
		b = Enum.valueOf(Browsers.class, browser);
	}

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(
				System.getProperty("user.dir") + "\\Resource\\ExtentReports\\ExtentReportResults.html");
		test = report.startTest("testng.xml");

	}

	@BeforeMethod
	public void setup() {
		driver = WebDriverUtil.getDriver(b);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		if (test.getRunStatus() == LogStatus.PASS) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		driver.quit();
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
}
