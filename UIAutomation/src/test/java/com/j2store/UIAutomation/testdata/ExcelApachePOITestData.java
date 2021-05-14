package com.j2store.UIAutomation.testdata;

import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;

public class ExcelApachePOITestData extends BaseDriver {

	// public static HSSFWorkbook xlxbook;

	public static XSSFSheet xlsxsheet;
	public static XSSFRow xlsxrow;
	public static XSSFCell xlsxcell;
	public static int tcnowno;
	public static String TCName;
	public static int columnnno;
	public static HashMap<String, Integer> columnheading;

	public ExcelApachePOITestData() {
		setsheet();
		setrownum();
		listcolhead();
	}
	
	public void setsheet() {
		xlsxsheet = xlsxbook.getSheet(prop.getProperty("sheetname"));	
	}

	public void setrownum() {
		int noofrow = xlsxsheet.getLastRowNum();
		for (int i = 1; i <= noofrow; i++) {
			String tcname = xlsxsheet.getRow(i).getCell(0).getStringCellValue();
			if (tcname.equalsIgnoreCase(TCName)) {
				tcnowno = i;
			}
		}
	}

	public void listcolhead() {
		columnheading = new HashMap<String, Integer>();
		int lastcolumn = xlsxsheet.getRow(0).getLastCellNum();
		for (int i = 1; i < lastcolumn; i++) {
			String columnname = xlsxsheet.getRow(0).getCell(i).getStringCellValue();
			columnheading.put(columnname, i);
		}
	}

	public String getData(String Columnheading) {
		String value = xlsxsheet.getRow(tcnowno).getCell(columnheading.get(Columnheading)).getStringCellValue();
		return value;
	}

}
