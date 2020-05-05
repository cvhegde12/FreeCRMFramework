package com.wbl.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wbl.base.CommonPage;
import com.wbl.util.WaitUtil;

public class LoginPage extends CommonPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "input[name='email']")
	WebElement username;

	@FindBy(css = "input[name='password']")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement ButtonLogin;

	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']")
	WebElement LinkLogin;

	public CogmentoCRMPage CheckLoginFeature() {
		WaitUtil.explicitWait(driver, 10, LinkLogin);
		username.sendKeys("cvhegde12@gmail.com");
		password.sendKeys("Chiisthebest");
		ButtonLogin.click();
		return new CogmentoCRMPage(driver);
	}
}
