package com.allianz.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.sun.org.apache.bcel.internal.classfile.Method;

public class DataUtils {
@DataProvider
	
public Object[][] invalidData()
	{
	Object[][] data = new Object[2][3];
	
	data[0][0]="saul";
	data[0][1]="saul123";
	data[0][2]="Invalid credentials";
	
	data[1][0]="peter";
	data[1][1]="peter123";
	data[1][2]="Invalid credentials";

	
	return data;
}
@DataProvider

public Object[][] commonDataProvider(Method mtd)throws IOException
{
	String currentTestName=mtd.getName();
			Object[][] data=ExcelUtils.getSheetIntoTwoDimensionalArray("src/test/resources/test_data/hrm_data.xlsx",currentTestName);
	
	return data;
	       
}



}
