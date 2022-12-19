package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReder extends BaseClass{
	public static XSSFWorkbook workbook;
	public ExcelReder(String path)
	{
		File f=new File(path);
		System.out.println("File statis="+f.exists());
		try {
			FileInputStream fis=new FileInputStream(f);
			workbook =new XSSFWorkbook(fis);
 		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getData(int sheetIndex,int row,int coloumn)
	{
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(coloumn).getStringCellValue();
	}
	public static int countRow(int sheetIndex)
	{
		return workbook.getSheetAt(sheetIndex).getLastRowNum()+1;
	}
	public static int countColos(int sheetIndex)
	{
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}
}
