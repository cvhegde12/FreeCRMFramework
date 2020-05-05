package com.wbl.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wbl.base.CommonPage;

public class ComparePage extends CommonPage {

	Logger log = LogManager.getLogger(ComparePage.class);

	public ComparePage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//div[@class='cell-md-12']/div[2]/table/tbody/tr[1]/th")
	List<WebElement> listOfColumnsInTable;

	public List<WebElement> CountNoOfColumnsInTable() {
		for (WebElement e : listOfColumnsInTable) {
			log.info(e.getText());
		}
		return listOfColumnsInTable;
	}
}
