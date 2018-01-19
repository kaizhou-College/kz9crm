package com.cshr.pdf;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Table
		
		
		
	      // ����Document����(ҳ��Ĵ�СΪA4,���ҡ��ϡ��µ�ҳ�߾�Ϊ10)
        Document document = new Document(PageSize.A4, 10, 10, 10, 10);
        // ������д��
        PdfWriter.getInstance(document, new FileOutputStream("Test4.PDF"));
        // ������صĲ���
        Test4.setParameters(document, "�����߲���", "����", "���� ������ ����", "����·", "����·");
        // ���ĵ�
        document.open();
        // ʹ��iTextAsian.jar�е�����
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
        
        List<User> users = new ArrayList<User>();
        // ѭ����Ӷ���
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(""+i);
            user.setInfo("�����߲���"+i);
            user.setName("����"+i);
            users.add(user);
        }
        
        Table table = Test4.setTable(users);
        document.add(new Paragraph("�û���Ϣ���£�",Test4.setFont()));
        document.add(table);
        
        // �ر��ĵ�
        document.close();
    }
    
    public static Table setTable(List<User> users) throws BadElementException{
        //����һ����3�еı��
        Table table = new Table(3);
        table.setBorderWidth(1);
        table.setBorderColor(new Color(0, 0, 255));
        table.setPadding(5);
        //table.setSpacing(5);
        // ������ͷ
        Cell cell1 = Test4.setTableHeader("���ID");
        Cell cell2 = Test4.setTableHeader("������Ϣ");
        Cell cell3 = Test4.setTableHeader("����");
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        // ��Ӵ˴����ÿҳ������ʾ��ͷ
        table.endHeaders();

                
        for (int i = 0; i < users.size(); i++) {
            Cell celli1 = Test4.setTableHeader(users.get(i).getId());
            Cell celli2 = Test4.setTableHeader(users.get(i).getInfo());
            Cell celli3 = Test4.setTableHeader(users.get(i).getName());
            table.addCell(celli1);
            table.addCell(celli2);
            table.addCell(celli3);
        }
        
        return table;
        
    }
    /**
     * ������������ʽ
     * @return
     */
    public static Font setFont(){
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font = new Font(baseFont, 8, Font.NORMAL,Color.BLACK);
        return font;
    }
    /**
     * ����cell
     * @param name
     * @return
     * @throws BadElementException
     */
    public static Cell setTableHeader(String name) throws BadElementException{
        
        Cell cell = new Cell(new Phrase(name,Test4.setFont()));
        //��Ԫ��ˮƽ���뷽ʽ
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //��Ԫ��ֱ���뷽ʽ
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
//        cell.setHeader(true);
        cell.setBackgroundColor(Color.RED);
        return cell;
    }
    
    /**
     * ������ز���
     * @param document
     * @return
     */
    public static Document setParameters(Document document,String title,String subject,String keywords,String author,
            String creator){
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
