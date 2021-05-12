package com.j2store.UIAutomation.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;

public class ExcelApachePOITestData extends BaseDriver{
	
	//public static HSSFWorkbook xlxbook;

	public static XSSFSheet xlsxsheet;
	public static XSSFRow xlsxrow;
	public static XSSFCell xlsxcell;
	public static int tcnowno;
	
	
public void readFile(String TCName) {
		xlsxsheet = xlsxbook.getSheet("Sheet1");
		int noofrow = xlsxsheet.getLastRowNum();
		for(int i=1;i<=noofrow;i++) {
			String tcname = xlsxsheet.getRow(i).getCell(0).getStringCellValue();
			if(tcname.equalsIgnoreCase(TCName)) {
				tcnowno= i;
			}
		}
		
		xlsxrow = xlsxsheet.getRow(tcnowno);
		xlsxcell = xlsxrow.getCell(0);
		String value = xlsxcell.getStringCellValue();
	
	
}
}
