package com.wbl.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

	protected WebDriver driver;
	public Logger log = LogManager.getLogger(CommonPage.class);

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
