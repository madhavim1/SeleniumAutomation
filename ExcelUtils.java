package com.sel.util;

import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtils {
	
	static Logger log = Logger.getLogger(ExcelUtils.class);
	
	@SuppressWarnings("resource")
	public Object[][] getData()
	{
		String[][] data;
		log.info("In ExcelUtils - get data:" +TsConstants.EXCEL_FILE);
		try {
			HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(TsConstants.EXCEL_FILE));
			HSSFSheet sheet = book.getSheetAt(0);
			int numOfRows = sheet.getLastRowNum();
			Row topRow = sheet.getRow(0);
			sheet.removeRow(topRow);
			int numOfCells = topRow.getLastCellNum();
			data = new String[numOfRows][numOfCells];
			Iterator<Row> rows = sheet.iterator();
			int i = 0;
			while(rows.hasNext())
			{
				int j = 0;
				HSSFRow row = (HSSFRow)rows.next();
				Iterator<Cell> cells = row.cellIterator();
				while(cells.hasNext())
				{
					HSSFCell cell = (HSSFCell) cells.next();
					data[i][j] = cell.getStringCellValue();
					//System.out.println("data[i][j] :"+data[i][j]);
					j++;
				}
				i++;
			}
			return data;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
}
