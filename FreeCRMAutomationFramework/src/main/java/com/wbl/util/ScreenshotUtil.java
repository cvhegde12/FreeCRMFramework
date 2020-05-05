package com.wbl.util;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

	static Logger log = LogManager.getLogger(ScreenshotUtil.class);

	public static void takeScreenshot(String screenshotFileName, WebDriver driver) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(source, new File(
					System.getProperty("user.dir") + "\\Resource\\Screenshots\\" + screenshotFileName + ".png"));
		} catch (IOException e) {
			log.error("There is an IOexception while taking screenshot");
		}
	}
}
