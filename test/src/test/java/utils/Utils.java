package utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Utils {
	private Workbook workbook;
    private Sheet sheet;
	
	 public Utils(String filePath, String sheetName) {
	        try (FileInputStream file = new FileInputStream(filePath)) {
	            workbook = new XSSFWorkbook(file);
	            sheet = workbook.getSheet(sheetName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public String getData(int rowIndex, int colIndex) {
		    Row row = sheet.getRow(rowIndex);
		    if (row != null) {
		        Cell cell = row.getCell(colIndex);
		        if (cell != null) {
		            return cell.toString();
		        }
		    }
		    return ""; 
		}
}
