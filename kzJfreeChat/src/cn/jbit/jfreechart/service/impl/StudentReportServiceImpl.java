package cn.jbit.jfreechart.service.impl;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import cn.jbit.jfreechart.dao.StudentDao;
import cn.jbit.jfreechart.entity.Student;
import cn.jbit.jfreechart.service.StudentReportService;

/**
 * ѧԱ��Ϣҵ����ӿ�ʵ���ࡣ
 * @author ��������
 */
public class StudentReportServiceImpl implements StudentReportService {
	// ѧԱ��Ϣ����DAO
	private StudentDao studentDao = null;

	/* (non-Javadoc)
	 * @see cn.jbit.jfreechart.service.StudentReportService#find(cn.jbit.jfreechart.entity.Student)
	 */
	public List<Student> find(Student condition) {
		List<Student> ret = this.studentDao.find(condition);
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see cn.jbit.jfreechart.service.StudentReportService#getBarStatistics()
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Long> getBarStatistics() {
		Map<String,Long> ret = new HashMap<String,Long>();
		String hql = "select s.stuEducation,count(s.stuEducation) from Student s group by s.stuEducation";
		List<Object[]> list = this.studentDao.search(hql);
		if (list!=null && !list.isEmpty()){
			for(Object[] arr : list){
				if (arr!=null && arr.length==2){
					System.out.println(arr[0]+"  "+arr[1]);
					ret.put((String)arr[0], (Long)arr[1]);
				}
			}
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see cn.jbit.jfreechart.service.StudentReportService#getPidStatistics()
	 */
	@SuppressWarnings("unchecked")
	public List getPidStatistics() {
		String hql = "select s.stuEducation,count(s.stuEducation) from Student s group by s.stuEducation";
		List ret = this.studentDao.search(hql);
		return ret;
	}

	/**
	 * @param studentDao the studentDao to set
	 */
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void writeJFreeChartToOs(OutputStream os) throws IOException {
		DefaultPieDataset ret = new DefaultPieDataset();
		List pieList = getPidStatistics();
		if (null != pieList) {
			Object[] obj = new Object[pieList.size()];
			for (int i = 0; i < pieList.size(); i++) {
				obj[i] = pieList.get(i);
			}

			for (int j = 0; j < obj.length; j++) {
				ret.setValue((String) ((Object[]) obj[j])[0],
						(Long) ((Object[]) obj[j])[1]);
			}
		}
		
		String title = "ѧ��ͳ�Ʊ�ͼ";
		Font bigFont = new Font("����", Font.BOLD, 22);
		Font middleFont = new Font("����", Font.BOLD, 14);

		JFreeChart chart = ChartFactory.createPieChart(title,ret, true,
				false, false);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(middleFont);
		plot.setBackgroundAlpha(0.2f);
		plot.setNoDataMessage("�޲�ѯ���������Ϣ��");
		plot.setCircular(true);
		
		chart.setTitle(new TextTitle(title,bigFont));
		//jfc�����Ѿ�����
		BufferedImage bi = chart.createBufferedImage(500, 370);
		ImageIO.write(bi, "PNG", os);
	}
	
}
