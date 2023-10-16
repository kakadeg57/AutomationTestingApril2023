package crmutil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {

	public static XSSFWorkbook workbook;
	
	public static String [][] getData()
	{
		
		try
		{
		FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\AutomationTestingApril23\\TestData\\ContactTestData.xlsx");
		 workbook = new XSSFWorkbook(file);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		System.out.println("Data file not found");
		}
		
		XSSFSheet sheet = workbook.getSheet("data");
		int rows = sheet.getLastRowNum();
		System.out.println(rows);
		int column = sheet.getRow(1).getLastCellNum();
		System.out.println(column);
		
		String [][] data = new String [rows][column];
		
		for(int i = 0;i<rows;i++) // to iterate rows 
		{	
			for (int j=0 ; j<column; j++) // to iterate through columns	
			{
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				
				//System.out.print (data +"  ");
			}
			//System.out.println();
		}	
		
		return data;
	}
	
}
