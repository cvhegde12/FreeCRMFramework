package com.wbl.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.ComparePage;
import com.wbl.page.HomePage;
import com.wbl.util.ExcelHelper;

public class ComparePageTest extends BaseTest {
	Logger log = LogManager.getLogger(ComparePageTest.class);
	HomePage hm;

	@DataProvider(name = "columnName")
	public Object[][] readColumnNames() throws IOException {
		Object[][] data = ExcelHelper.getExcelData("DataSheetforFreeCRM.xlsx", "ComparePage");
		log.info(data[0][0]);
		log.info(data[1][0]);
		return data;
	}

	@Test
	public void CountNoOfColumnsInTableTest() throws IOException {
		Object[][] data = ExcelHelper.getExcelData("DataSheetforFreeCRM.xlsx", "ComparePage");
		List<String> colNames = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			colNames.add(data[i][0].toString());
		}
		int count = 0;
		hm = PageFactory.initElements(driver, HomePage.class);
		ComparePage cp = hm.clickCompareLink();
		List<WebElement> columnNames = cp.CountNoOfColumnsInTable();

		for (WebElement s : columnNames) {
			if (colNames.contains(s.getText())) {
				count++;
			}
		}
		Assert.assertEquals(count, 9);
	}
}
