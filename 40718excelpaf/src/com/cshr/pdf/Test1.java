package com.cshr.pdf;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//simple
		
		Document doc = new Document();
		
		PdfWriter writer =  PdfWriter.getInstance(doc, new FileOutputStream("simple.pdf"));
		
		doc.open();
		
		
		doc.add(new Paragraph("hello pdf!!! 你好"));//添加一段内容
		
		doc.close();
		writer.close();
		

	}

}
