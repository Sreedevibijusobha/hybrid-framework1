package com.allianz.utils;

import org.testng.annotations.DataProvider;

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


}
