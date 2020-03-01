package com.eCommerce.excelRead;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public FileInputStream filein;
	public FileOutputStream fileout =null;
	public String path;
	public XSSFWorkbook workbook;	
	public static XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public ExcelReader(String path)
	{
		this.path = path;
		try {
			filein=new FileInputStream(path);
			workbook = new XSSFWorkbook(filein);
			
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public String [][] getDataFromSheet(String sheetName, String ExcelName){
		String dataSets[][]= null;
		try {
			sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			int totalColumn= sheet.getRow(0).getLastCellNum();
			dataSets = new String [totalRow-1][totalColumn];
			for(int i =1; i<totalRow; i++)
			{
				XSSFRow rows = sheet.getRow(i);
				for(int j=0; j<totalColumn; j++)
				{
				XSSFCell cell= rows.getCell(j);
				if(cell.getCellType() == CellType.STRING)
				{
					dataSets[i-1][j]= cell.getStringCellValue();
				}else if(cell.getCellType()== CellType.NUMERIC)
				{
					String cellText =String.valueOf(cell.getNumericCellValue());
					dataSets[i-1][j]=cellText;
				}
				else
					dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				{
					
				}
				}
			}
		}
			catch(Exception e) {
				System.out.println("Exception in Reading xlsx file" +e.getMessage());
				e.printStackTrace();
			}
		
		return dataSets;
		
	}
	 
	

}
