package com.allianz.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemoExcelTest {
	
	public static void main(String[] args) throws IOException
	{
		FileInputStream file = new FileInputStream("src/test/resources/test_data/hrm_data.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet= book.getSheet("invalidlogintest");
		//for excel sheet
		String value=sheet.getRow(0).getCell(0).getStringCellValue();
		
		
		//for array
		//Object[][] data = new Object[2][3];
		System.out.println(value);
		
		for(int r=0;r<3;r++)
		{
			for(int c=0;c<3;c++)
			{
				//for excel
				System.out.println("outerloop "+r);
				System.out.println("innerloop "+c);
				System.out.println("----------");
				System.out.println(value);
				
				//for array
				//String value=sheet.getRow(0).getCell(0).getStringCellValue();
				//System.out.println(value);
				//data[0][0]=value;
			}
		}
		book.close();
		file.close();
	}

}
