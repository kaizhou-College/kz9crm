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
		Test5.setParameters(doc, "�����߲���", "����", "���� ������ ����", "����·", "����·");
		doc.open();

		BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
				BaseFont.NOT_EMBEDDED);
		Font font = new Font(baseFont, 18, Font.NORMAL, Color.YELLOW);

		// doc.add(new Paragraph("hello pdf!!! ���",font));//���һ������

		Table table = new Table(5);
		table.setBorderWidth(1);
		table.setBorderColor(Color.GREEN);
		// table.setBackgroundColor(Color.RED);
		table.setPadding(5);
		table.setSpacing(5);

		Cell cell = new Cell(new Phrase("KATE", font));
		// ��ӵ�Ԫ��
		// Cell cell = new Cell();
		// cell.HorizontalAlignment = Element.ALIGN_CENTER;
		// cell.VerticalAlignment = Element.ALIGN_MIDDLE;
		// cell.add(new Paragraph("������Դ����", font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);// top botton middle
		//cell.setColspan(5);
		cell.setBackgroundColor(Color.RED);

		table.addCell(cell);

		// ��Ӵ˴����ÿҳ������ʾ��ͷ
		table.endHeaders();

		for (int i = 1; i <= 17; i++) {
			Cell cc = new Cell(new Phrase("��" + i, font));
			// Cell cc = new Cell();
			// cc.add(new Paragraph("1" + i, font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);// top botton middle
			cell.setBackgroundColor(Color.RED);
			table.addCell(cc);
		}

		doc.add(new Paragraph("�û���Ϣ���£�", font));
		doc.add(table);

		doc.close();
		// writer.close();
	}

	public static Document setParameters(Document document, String title,
			String subject, String keywords, String author, String creator) {
		// ���ñ���
		document.addTitle(title);
		// ��������
		document.addSubject(subject);
		// ��������
		document.addKeywords(keywords);
		// ��������
		document.addAuthor(author);
		// ���ô�����
		document.addCreator(creator);
		// ����������
		document.addProducer();
		// ���ô�������
		document.addCreationDate();

		return document;
	}
}
