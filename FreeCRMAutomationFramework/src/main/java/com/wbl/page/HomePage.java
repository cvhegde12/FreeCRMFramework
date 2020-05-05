package com.wbl.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;

public class HomePage extends CommonPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='About']")
	WebElement AboutLink;

	@FindBy(xpath = "//a[text()='Compare']")
	WebElement LinkComapre;

	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']")
	WebElement LinkLogin;

	public AboutPage clickAboutLink() {
		AboutLink.click();
		return new AboutPage(driver);
	}

	public ComparePage clickCompareLink() {
		LinkComapre.click();
		return new ComparePage(driver);
	}

	public LoginPage clickLoginLink() {
		LinkLogin.click();
		return new LoginPage(driver);
	}

}
