package com.wbl.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;
import com.wbl.page.LoginPage;

public class LoginPageTest extends BaseTest {

	HomePage hm;

	@Test
	public void CheckLoginFeatureTest() {
		hm = PageFactory.initElements(driver, HomePage.class);
		LoginPage lp = hm.clickLoginLink();
		lp.CheckLoginFeature();
		Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
	}
}
