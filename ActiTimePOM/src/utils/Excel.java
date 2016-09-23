package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Excel{
	
	
	public  String getExcelData(String SheetName,int row,int col) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{	
		
		FileInputStream fis = new FileInputStream(TestDataLocation.getTestDataPath());
		//create reference variable to workbook interface
		Workbook wb = WorkbookFactory.create(fis);
		
		//get the sheet control by passing the sheet name
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(SheetName);
		
		//get the 1st row
		 Row r = sh.getRow(row);
		 //get second column value from 1st row
		 
		 String data = r.getCell(col).getStringCellValue();
		 
		 return data;
		 
	}
	
	public int rowCount() throws InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(TestDataLocation.getTestDataPath());
		//create reference variable to workbook interface
		Workbook wb = WorkbookFactory.create(fis);
		
		String SheetName = "Login";
		//get the sheet control by passing the sheet name
		org.apache.poi.ss.usermodel.Sheet sh =wb.getSheet(SheetName);
		
		@SuppressWarnings("unused")
		int rowCount = sh.getLastRowNum();
		return rowCount();
		
	}
	
	


	public static void setExcelData(String SheetName,int row,int col,String sdata) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		 
		FileInputStream fis = new FileInputStream(TestDataLocation.getTestDataPath());
			//create reference variable to workbook interface
			Workbook wb = WorkbookFactory.create(fis);
			
			//get the sheet control by passing the sheet name
			org.apache.poi.ss.usermodel.Sheet sh =wb.getSheet(SheetName);
			
			//System.out.println(sh);
			//row = row+1;
			Row r = sh.getRow(row);
//			 Row currentRow = sh.iterator().next();
			if(r == null){
				 r = sh.createRow(row);	
			}
			
			 //System.out.println(r);
			
			Cell c = r.createCell(col);
			
			c.setCellType(Cell.CELL_TYPE_STRING);
			
			c.setCellValue(sdata);
			
			FileOutputStream fos = new FileOutputStream("//home//vijya//projects//NimbusTestAutomation//selenium_automation//FaceGuruAutomation//src//testData//TestData.xlsx");
			
			wb.write(fos);
			
			
			
			
	}
	
	}
