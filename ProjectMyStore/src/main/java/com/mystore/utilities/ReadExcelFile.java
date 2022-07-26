package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelFile {
	
	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException, InvalidFormatException {

		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Data.xlsx");
		FileInputStream fis=new FileInputStream(f);
		
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sheetName=wb.getSheet(excelSheetName);
		
		int totalRow=sheetName.getLastRowNum();
		System.out.println("Total Row is:"+totalRow);
		
		Row rowCells=sheetName.getRow(0);
		
		int totalColumn=rowCells.getLastCellNum();
		
		System.out.println("Total column:"+ totalColumn);
		
		DataFormatter format=new DataFormatter();
		String testData[][]= new String[totalRow][totalColumn];
		for(int i=1;i<=totalRow; i++){
			for(int j=0; j<totalColumn;j++) {
				
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		
		return testData;
	}

}
