package TestLayer;

import BaseLayer.BaseClass;
import UtilsLayer.ExcelReder;

public class Test_Everything extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		String path="C:\\TestNG\\TestNG_Parallel\\Resources\\Methods.xlsx";
		ExcelReder excelreder=new ExcelReder(path);
		int rows=excelreder.countRow(0);
		int cols=excelreder.countColos(0);
		System.out.println(rows);
		System.out.println(cols);
		for(int i=0;i<cols;i++)
		{
			for(int j=0;j<rows;j++)
			{
				System.out.println("coloum no="+i+" row no="+j+" "+excelreder.getData(0, j, i));
			}
		}
	}
}
