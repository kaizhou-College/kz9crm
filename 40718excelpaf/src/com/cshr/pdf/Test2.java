package com.cshr.pdf;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//Font
		
		Document doc = new Document();
		
		PdfWriter writer =  PdfWriter.getInstance(doc, new FileOutputStream("font.pdf"));
		
		doc.open();
		
		BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
		Font font = new Font(baseFont, 18, Font.BOLD,Color.RED);
		
		doc.add(new Paragraph("hello pdf!!! 你好",font));//添加一段内容
		
		doc.close();
		writer.close();
		

	}

}
