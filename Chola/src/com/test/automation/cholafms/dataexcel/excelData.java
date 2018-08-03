package com.test.automation.cholafms.dataexcel;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class excelData {



	public Object[][] getExcelData() throws BiffException, IOException
	{
		
	File path=new File("D:\\java_selenium\\selenium\\WorkSpace_Selenium\\FMSv12-Data-Driven-Framework\\Drivers\\Test.xls");
	Workbook book=Workbook.getWorkbook(path);
	Sheet sheet=book.getSheet("Sheet1");
	int row=sheet.getRows();
	int column=sheet.getColumns();
	String inputData[][]=new String[row][column];
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<column;j++)
		{
			Cell c=sheet.getCell(j,i);
			inputData[i][j]= c.getContents();
				
		}
	}

     return inputData;
	
	}
	
}
