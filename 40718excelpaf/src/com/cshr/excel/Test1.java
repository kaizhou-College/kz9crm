package com.cshr.excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test1 {

	/**
	 * ����excel������
	 */
	public static void main(String[] args) throws Exception {
		//1.�½�һ��������
		WritableWorkbook book = Workbook.createWorkbook(new File("test1.xls"));
		//2.�½�������
		WritableSheet sheet1 = book.createSheet("aa", 0);
		WritableSheet sheet2 = book.createSheet("bb", 1);
		
		
		//��ӱ�ͷ
		//��һ������Ϊx����
		//�ڶ�������Ϊy����
		//����������Ϊ����
		sheet1.addCell(new Label(0, 0, "ѧ��"));
		sheet1.addCell(new Label(1, 0, "����"));
		
		for(int i=1;i<=10;i++){
			sheet1.addCell(new Label(0, i, i+""));
			sheet1.addCell(new Label(1, i, "tom"+i));
			
		}
		
		
		
		book.write();
		book.close();
		
		
		
		

	}

}
