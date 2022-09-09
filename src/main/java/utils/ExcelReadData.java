package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {
	
	public static String readExcelData(int rowNumber, int columnNumber) throws IOException {
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\umamaheswara.reddy\\OneDrive - Qualitest Group\\Documents\\Test\\Credentails.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fis); 
		XSSFSheet sheet=wb.getSheetAt(0);
		int cellDataType = sheet.getRow(rowNumber).getCell(columnNumber).getCellType();
		if(cellDataType == 0) {
			return String.valueOf(sheet.getRow(rowNumber).getCell(columnNumber).getNumericCellValue());
		}
		else {
			
			return sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
		}
		
		
	}
	public static void writeExcelData() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
	      
	      //Create a blank sheet
	      XSSFSheet spreadsheet = workbook.createSheet( "sheet1");

	      //Create row object
	      XSSFRow row;
	      

	      //This data needs to be written (Object[])
	      Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
	      empinfo.put( "1", new Object[] { "S.no",
	         "Product Name", "Product Price", "Reviews" });
	      
	      empinfo.put( "2", new Object[] {"1",
	 	        TestBase.ProductName,TestBase.ProductPrice, TestBase.productReviewsCount});
	 	      	
	 

	      //Iterate over data and write to sheet
	      Set < String > keyid = empinfo.keySet();
	      int rowid = 0;
	      
	      for (String key : keyid) {
	         row = spreadsheet.createRow(rowid++);
	         Object [] objectArr = empinfo.get(key);
	         int cellid = 0;
	         
	         for (Object obj : objectArr){
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      String projectPath =   System.getProperty("user.dir");
	      //Write the workbook in file system
	      FileOutputStream out = new FileOutputStream(
	    		  
	         new File(projectPath+"\\ProductInfo.xlsx"));
	      
	      workbook.write(out);
	      out.close();
	      System.out.println("Writesheet.xlsx written successfully");
	   
	}
}
	
