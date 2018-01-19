package com.cshr.excel;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databasename=hr_db1","sa","123");
		String sql = " select * from human_file";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs =  pstmt.executeQuery();
		//��ȡ����ԭ������
		ResultSetMetaData rsmd = rs.getMetaData();
		
		//���������������п���֪���ж��ٸ���
		int counts = rsmd.getColumnCount();
		//����excel
		WritableWorkbook book = Workbook.createWorkbook(new File("humanfile.xls"));
		WritableSheet sheet = book.createSheet("����", 0);
		String [] columns = new String[counts];
		//��ӱ�ͷ
		for(int i=0;i<counts;i++){
			columns[i] = rsmd.getColumnName(i+1);
			sheet.addCell(new Label(i, 0, columns[i]));
		}
		
		//��ȡ���ݿ������ݣ�д��excel��ȥ
		int j = 1;
		while(rs.next()){
			for(int i=0;i<counts;i++){
				sheet.addCell(new Label(i, j, rs.getString(columns[i])));
			}
			j++;
		}
		
		book.write();
		book.close();
		
		
	
		
		
		
		

	}

}
