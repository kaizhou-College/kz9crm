package cn.jbit.jfreechart.action;

import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import cn.jbit.jfreechart.service.StudentReportService;

/**
 * ����ͼ��Action��
 * @author ��������
 */
public class StudentReportAction {
	// 
	private JFreeChart chart = null;
	// ѧԱ��Ϣҵ����ӿ�
	private StudentReportService studentReportService = null;

	/**
	 * Ĭ��Action�������ɱ�ͼ��
	 * @return
	 */
	public String execute() {
		String title = "ѧ��ͳ�Ʊ�ͼ";
		Font bigFont = new Font("����", Font.BOLD, 22);
		Font middleFont = new Font("����", Font.BOLD, 14);

		chart = ChartFactory.createPieChart(title, getPieDataset(), true,
				false, false);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(middleFont);
		plot.setBackgroundAlpha(0.2f);
		
		chart.setTitle(new TextTitle(title,bigFont));
		
		return "success";
	}
	
	/**
	 * Ĭ��Action�������ɱ�ͼ��
	 * @return
	 * @throws IOException 
	 */
	public void executePie() throws IOException {
		HttpServletResponse response  = ServletActionContext.getResponse();
		OutputStream os = response.getOutputStream();
		//��jfreechart���ɵ�ͼƬ��Ϣд�뵽os�о�����
		 this.studentReportService.writeJFreeChartToOs(os);
	}
	
	/**
	 * ��״ͼ��
	 * @return
	 */
	public String reportBarPic() {
		String title = "ѧ��ͳ����״ͼ";
		Font bigFont = new Font("����",Font.BOLD,22);
		Font middleFont = new Font("����",Font.BOLD,14);
		Font smallFont = new Font("����",Font.BOLD,12);
		
		chart = ChartFactory.createBarChart(
				title,
				"",
				"������Ԫ��",
				getBarDataset(),
				PlotOrientation.VERTICAL,
				false,
				false,
				false
			);
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		plot.getDomainAxis().setTickLabelFont(smallFont);
		plot.getDomainAxis().setLabelFont(middleFont);
		plot.getRangeAxis().setLabelFont(middleFont);
		plot.setBackgroundAlpha(0.6f);
		
		chart.setTitle(new TextTitle(title,bigFont));
		
		return "success";
	}
	
	

	/**
	 * �������ͼ�����ݡ�
	 * @return PieDataset
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private PieDataset getPieDataset() {
		DefaultPieDataset ret = new DefaultPieDataset();
		List pieList = this.studentReportService.getPidStatistics();
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

		return ret;
	}
	
	private CategoryDataset getBarDataset(){
		DefaultCategoryDataset ret = new DefaultCategoryDataset();
		Map<String, Long> data = this.studentReportService.getBarStatistics();
		for(String depart : data.keySet()){
			ret.addValue(data.get(depart), "", depart);
		}
		return ret;
	}

	/**
	 * @return the chart
	 */
	public JFreeChart getChart() {
		return chart;
	}

	/**
	 * @param studentReportService
	 *            the studentReportService to set
	 */
	public void setStudentReportService(
			StudentReportService studentReportService) {
		this.studentReportService = studentReportService;
	}

	/**
	 * @param chart the chart to set
	 */
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
}
