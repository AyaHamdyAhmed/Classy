package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	static FileInputStream fis = null;
	
	
	public static FileInputStream getFile()
	{
		String filepath = System.getProperty("user.dir")+ "/src/main/java/data/TestData.xlsx";
		File file = new File(filepath);
		
		try
		{
			fis = new FileInputStream(file);
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Can't load the test data file");
			System.exit(0);
		}
		
		return fis;
	}
	

	
	public Object [][] getExcelData() throws IOException
	{
		fis = getFile();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int Rows = (sheet.getLastRowNum()+1);
		int Cols = 1;
		String [][] excelData = new String[Rows][Cols];
		
		for(int i=0; i<Rows;i++)
		{
			for(int j = 0; j<Cols;j++)
			{
				XSSFRow row  = sheet.getRow(i);
				excelData[i][j] = row.getCell(j).toString();
				System.out.println(excelData[i][j]);
			}
		}
		
		wb.close();
		
		return excelData;
	}
	

} 