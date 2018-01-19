package com.cshr.pdf;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class Test5 {
	public static void main(String[] args) throws Exception {
		Document doc = new Document(PageSize.A4, 10, 10, 10, 10);

		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(
				"table8.PDF"));
		Test5.setParameters(doc, "开发者测试", "测试", "测试 开发者 调试", "甘雨路", "甘雨路");
		doc.open();

		BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
				BaseFont.NOT_EMBEDDED);
		Font font = new Font(baseFont, 18, Font.NORMAL, Color.YELLOW);

		// doc.add(new Paragraph("hello pdf!!! 你好",font));//添加一段内容

		Table table = new Table(5);
		table.setBorderWidth(1);
		table.setBorderColor(Color.GREEN);
		// table.setBackgroundColor(Color.RED);
		table.setPadding(5);
		table.setSpacing(5);

		Cell cell = new Cell(new Phrase("KATE", font));
		// 添加单元格
		// Cell cell = new Cell();
		// cell.HorizontalAlignment = Element.ALIGN_CENTER;
		// cell.VerticalAlignment = Element.ALIGN_MIDDLE;
		// cell.add(new Paragraph("人力资源报表", font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);// top botton middle
		//cell.setColspan(5);
		cell.setBackgroundColor(Color.RED);

		table.addCell(cell);

		// 添加此代码后每页都会显示表头
		table.endHeaders();

		for (int i = 1; i <= 17; i++) {
			Cell cc = new Cell(new Phrase("狗" + i, font));
			// Cell cc = new Cell();
			// cc.add(new Paragraph("1" + i, font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);// top botton middle
			cell.setBackgroundColor(Color.RED);
			table.addCell(cc);
		}

		doc.add(new Paragraph("用户信息如下：", font));
		doc.add(table);

		doc.close();
		// writer.close();
	}

	public static Document setParameters(Document document, String title,
			String subject, String keywords, String author, String creator) {
		// 设置标题
		document.addTitle(title);
		// 设置主题
		document.addSubject(subject);
		// 设置作者
		document.addKeywords(keywords);
		// 设置作者
		document.addAuthor(author);
		// 设置创建者
		document.addCreator(creator);
		// 设置生产者
		document.addProducer();
		// 设置创建日期
		document.addCreationDate();

		return document;
	}
}
