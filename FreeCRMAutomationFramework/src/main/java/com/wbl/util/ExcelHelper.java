package com.wbl.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	static Logger log = LogManager.getLogger(ExcelHelper.class);

	public static Object[][] getExcelData(String excelfile, String sheetName) throws IOException {
		Object[][] data = null;
		XSSFWorkbook wb = null;

		try {
			String dir = System.getProperty("user.dir");
			wb = new XSSFWorkbook(dir + "\\Resource\\DataSheet\\" + excelfile);
			log.info("*********************Excel name: " + excelfile);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int rowsIndex = sheet.getLastRowNum(); // returns last row num- rown mun starts fom 0.
			log.info("Total rows:" + rowsIndex);
			data = new Object[rowsIndex][];

			for (int i = 1; i <= rowsIndex; i++) {
				XSSFRow row = sheet.getRow(i);
				int col = row.getLastCellNum(); // returns number of columns, column num starts from 0.
				log.info("Total columns:" + col);
				Object[] coldata = new Object[col];
				for (int j = 0; j < col; j++) {
					coldata[j] = row.getCell(j).toString();
				}
				data[i - 1] = coldata;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("This throws an IOException");
		} finally {
			wb.close();
		}

		return data;
	}
}
