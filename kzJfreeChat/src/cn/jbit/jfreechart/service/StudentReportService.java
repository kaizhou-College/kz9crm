package cn.jbit.jfreechart.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import cn.jbit.jfreechart.entity.Student;

/**
 * ѧԱ��Ϣҵ����ӿڡ�
 * @author ��������
 */
public interface StudentReportService {
	/**
	 * ��ѯѧԱ��Ϣ
	 * @param condition ��ѯ����
	 * @return �����ѯ����Ϊnull����������ѧԱ��Ϣ�б�����������ѯѧԱ��Ϣ
	 */
	public List<Student> find(Student condition);
	/**
	 * ��ѯ��ͼͳ�Ʊ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getPidStatistics();
	/**
	 * ��ѯ��״ͼͳ�Ʊ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Long> getBarStatistics();
	public void writeJFreeChartToOs(OutputStream os) throws IOException;
}
