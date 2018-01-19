package com.cshr.excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test1 {

	/**
	 * 测试excel的生成
	 */
	public static void main(String[] args) throws Exception {
		//1.新建一个工作簿
		WritableWorkbook book = Workbook.createWorkbook(new File("test1.xls"));
		//2.新建工作表
		WritableSheet sheet1 = book.createSheet("aa", 0);
		WritableSheet sheet2 = book.createSheet("bb", 1);
		
		
		//添加表头
		//第一个参数为x坐标
		//第二个参数为y坐标
		//第三个参数为内容
		sheet1.addCell(new Label(0, 0, "学号"));
		sheet1.addCell(new Label(1, 0, "姓名"));
		
		for(int i=1;i<=10;i++){
			sheet1.addCell(new Label(0, i, i+""));
			sheet1.addCell(new Label(1, i, "tom"+i));
			
		}
		
		
		
		book.write();
		book.close();
		
		
		
		

	}

}
