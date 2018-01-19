package com.cshr.pdf;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//Font
		
		Document doc = new Document();
		
		PdfWriter writer =  PdfWriter.getInstance(doc, new FileOutputStream("image.pdf"));
		
		doc.open();
		
		Image image = Image.getInstance("nn.jpg");
		image.scaleToFit(200, 300);
		doc.add(image);
		
		doc.close();
		writer.close();
		

	}

}
