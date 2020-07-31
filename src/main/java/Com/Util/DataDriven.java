package Com.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public static List<Hashtable<String, String>> readFile(String sheetName) throws Exception{
		List<Hashtable<String, String>> dataList = new ArrayList<Hashtable<String, String>>();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\custdetails.xlsx");
		XSSFWorkbook excel=new XSSFWorkbook(fis);
		XSSFSheet sheet = excel.getSheet(sheetName);
		int rownumber = sheet.getLastRowNum();
		for(int i = 1; i<= rownumber; i++){
			Hashtable<String, String> data = new Hashtable<String, String>();;
			for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++){				
				data.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i).getCell(j).getStringCellValue());
			}				
			dataList.add(data);
		}
		
		return dataList;
	}
	
	
	public static String[][] getregisteredData() throws Exception {

	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\custdetails.xlsx");
	XSSFWorkbook excel=new XSSFWorkbook(fis);
	XSSFSheet sheet=excel.getSheetAt(0);
	String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=1;i<=sheet.getLastRowNum();i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			XSSFCell cell=row.getCell(j);
			data[i-1][j]=cell.getStringCellValue();
			
		}
		
	
	}
	return data;

}
	public static String[][] Query() throws Exception {

		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\custdetails.xlsx");
		XSSFWorkbook excel=new XSSFWorkbook(fis);
		XSSFSheet sheet=excel.getSheetAt(1);
		String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				XSSFCell cell=row.getCell(j);
				data[i-1][j]=cell.getStringCellValue();
				
			}
			
		
		}
		return data;

	}
public static String[][] loginData() throws Exception {

	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\custdetails.xlsx");
	XSSFWorkbook excel=new XSSFWorkbook(fis);
	XSSFSheet sheet=excel.getSheetAt(2);
	System.out.println(sheet.getLastRowNum());
	System.out.println(sheet.getRow(0).getLastCellNum());
	String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=1;i<=sheet.getLastRowNum();i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			XSSFCell cell=row.getCell(j);
			data[i-1][j]=cell.getStringCellValue();
			
		}
		
	
	}
	return data;

}

public static String[][] freecouponCourse() throws Exception {

	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\custdetails.xlsx");
	XSSFWorkbook excel=new XSSFWorkbook(fis);
	XSSFSheet sheet=excel.getSheetAt(3);
	String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=1;i<=sheet.getLastRowNum();i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			XSSFCell cell=row.getCell(j);
			data[i-1][j]=cell.getStringCellValue();
			
		}
		
	
	}
	return data;
}

public static String[][] TopSelfPacedAndLiveCoursesTest() throws Exception {

	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\custdetails.xlsx");
	XSSFWorkbook excel=new XSSFWorkbook(fis);
	XSSFSheet sheet=excel.getSheetAt(4);
	String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=1;i<=sheet.getLastRowNum();i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			XSSFCell cell=row.getCell(j);
			data[i-1][j]=cell.getStringCellValue();
			
		}
		
	
	}
	return data;
}}






