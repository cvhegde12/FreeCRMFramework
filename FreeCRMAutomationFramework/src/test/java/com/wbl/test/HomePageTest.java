package com.wbl.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;

public class HomePageTest extends BaseTest {
	HomePage hm;

	public HomePageTest() {
		hm = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void clickAboutLinkTest() {
		hm.clickAboutLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://freecrm.co.in/about.html");
	}

	@Test(enabled = true)
	public void clickCompareLinkTest() {
		hm.clickCompareLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://freecrm.co.in/compare.html");
	}

}
