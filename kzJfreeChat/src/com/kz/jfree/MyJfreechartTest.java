package com.kz.jfree;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class MyJfreechartTest {

	/**  
	 * ������ݼ���
	 * @return  
	 */
	private static DefaultPieDataset getDataSet() {
		DefaultPieDataset dfp = new DefaultPieDataset();
		dfp.setValue("������Ա", 25);
		dfp.setValue("�г���Ա", 35);
		dfp.setValue("������Ա", 20);
		dfp.setValue("������Ա", 5);
		dfp.setValue("������Ա", 15);
		return dfp;
	}

	/**  
	 * ���ɱ�״ͼ��
	 */
	public static void makePieChart3D() {
		String title = "��״ͼ";
		// ������ݼ�   
		DefaultPieDataset dataset = getDataSet();
		// ����chart��������һ��jfreechartʵ��   
		// ����˵����API   
//		JFreeChart chart = ChartFactory.createPieChart3D(title, // ͼ�����   
//				dataset, // ���ݼ�   
//				true, // �Ƿ���ʾͼ��   
//				false, // �Ƿ����ɹ��ߣ���ʾ��   
//				false // �Ƿ�����URL����   
//				);

		// ����pieChart�ı���������   
		Font font = new Font("����", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		/*chart.setTitle(textTitle);

		chart.setTextAntiAlias(false);

		// ���ñ���ɫ   
		chart.setBackgroundPaint(new Color(199, 237, 204));

		// ����ͼ������   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("����", 1, 15));

		// ����ͼ��ǩ����   
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("����", Font.TRUETYPE_FONT, 12));

		// ָ��ͼƬ��͸����(0.0-1.0)   
		plot.setForegroundAlpha(0.65f);

		// ͼƬ����ʾ�ٷֱ�:�Զ��巽ʽ��{0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ���� ,С�������λ   
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));

		// ͼ����ʾ�ٷֱ�:�Զ��巽ʽ�� {0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ����   
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0} ({2})"));

		// ���õ�һ�� ����section �Ŀ�ʼλ�ã�Ĭ����12���ӷ���   
		plot.setStartAngle(90);

		*//***********************************************************//*
		ChartFrame frame = new ChartFrame(title, chart, true);
		frame.pack();
		frame.setVisible(true);*/
	}

	/**  
	 * ������״ͼ��
	 */
	public static void makeBarChart3D() {

		String title = "��״ͼ";

		// ������ݼ�   
		CategoryDataset dataset = getDataset();

		JFreeChart chart = ChartFactory.createBarChart3D(title, // ͼ�����   
				"ˮ��", // Ŀ¼�����ʾ��ǩ   
				"����", // ��ֵ�����ʾ��ǩ   
				dataset, // ���ݼ�   
				PlotOrientation.VERTICAL,// ͼ����ˮƽ����ֱ   
				true, // �Ƿ���ʾͼ��   
				true, // �Ƿ����ɹ��ߣ���ʾ��   
				true // �Ƿ�����URL����   
				);

		// ���ñ�������   
		Font font = new Font("����", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		chart.setTitle(textTitle);

		chart.setTextAntiAlias(false);

		// ���ñ���ɫ   
		chart.setBackgroundPaint(new Color(199, 237, 204));

		// ����ͼ������   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("����", Font.TRUETYPE_FONT, 15));

		// �����״ͼ��Plot����   
		CategoryPlot plot = chart.getCategoryPlot();

		// ȡ�ú���   
		CategoryAxis categoryAxis = plot.getDomainAxis();

		// ���ú�����ʾ��ǩ������   
		categoryAxis.setLabelFont(new Font("����", Font.BOLD, 18));

		// �����ǩ��45�Ƚ���б   
		categoryAxis.setTickLabelFont(new Font("����", Font.TRUETYPE_FONT, 18));

		// ȡ������   
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();

		// ����������ʾ��ǩ������   
		numberAxis.setLabelFont(new Font("����", Font.BOLD, 18));

		/**************************************************************/
		ChartFrame frame = new ChartFrame(title, chart, true);
		frame.pack();
		frame.setVisible(true);
	}

	/**  
	 * ��������ͼ��
	 */
	public static void makeLineAndShapeChart() {

		String title = "����ͼ";

		// ������ݼ�   
		CategoryDataset dataset = getDataset();

		JFreeChart chart = ChartFactory.createLineChart(title, // ͼ�����   
				"X��", // Ŀ¼�����ʾ��ǩ   
				"Y��", // ��ֵ�����ʾ��ǩ   
				dataset, // ���ݼ�   
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ   
				true, // �Ƿ���ʾͼ��   
				true, // �Ƿ����ɹ��ߣ���ʾ��   
				false // �Ƿ�����URL����   
				);

		chart.setTextAntiAlias(false);
		// ���ñ���ɫ   
		chart.setBackgroundPaint(Color.WHITE);

		// ����ͼ�����������������title   
		Font font = new Font("����", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		chart.setTitle(textTitle);

		// �����������   
		Font labelFont = new Font("����", Font.BOLD, 18);

		chart.setBackgroundPaint(Color.WHITE);

		// ����ͼ������   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("����", Font.TRUETYPE_FONT, 15));

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();

		// x�� // �����������Ƿ�ɼ�   
		categoryplot.setDomainGridlinesVisible(true);

		// y�� //�����������Ƿ�ɼ�   
		categoryplot.setRangeGridlinesVisible(true);

		// ����ɫ��   
		categoryplot.setRangeGridlinePaint(Color.WHITE);

		// ����ɫ��   
		categoryplot.setDomainGridlinePaint(Color.WHITE);

		// ���ñ���ɫ   
		categoryplot.setBackgroundPaint(Color.lightGray);

		// ����������֮��ľ���   
		// categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));   

		CategoryAxis domainAxis = categoryplot.getDomainAxis();

		// ���ú����ǩ��������   
		domainAxis.setLabelFont(labelFont);

		// ���ú�����ֵ��ǩ����   
		domainAxis.setTickLabelFont(new Font("����", Font.TRUETYPE_FONT, 15));

		// �����ϵ�   
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

		// Lable   
		// 45����б   
		// ���þ���ͼƬ��˾���   
		domainAxis.setLowerMargin(0.0);
		// ���þ���ͼƬ�Ҷ˾���   
		domainAxis.setUpperMargin(0.0);

		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();

		// ����������ʾ��ǩ������   
		numberaxis.setLabelFont(labelFont);

		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);

		// ���renderer ע���������������͵�lineandshaperenderer����   
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();

		// series �㣨�����ݵ㣩�ɼ�   
		lineandshaperenderer.setBaseShapesVisible(true);

		// series �㣨�����ݵ㣩�������߿ɼ�   
		lineandshaperenderer.setBaseLinesVisible(true);

		// ��ʾ�۵�����   
		// lineandshaperenderer.setBaseItemLabelGenerator(new   
		// StandardCategoryItemLabelGenerator());   
		// lineandshaperenderer.setBaseItemLabelsVisible(true);   

		/*******************************************************/
		ChartFrame frame = new ChartFrame(title, chart, true);
		frame.pack();
		frame.setVisible(true);

	}

	public static void makeTimeSeriesChart() {

		// ������һ��ʱ����   
		TimeSeries pop1 = new TimeSeries("����", Day.class);
		pop1.add(new Day(10, 1, 2004), 100);
		pop1.add(new Day(10, 2, 2004), 150);
		pop1.add(new Day(10, 3, 2004), 250);
		pop1.add(new Day(10, 4, 2004), 275);
		pop1.add(new Day(10, 5, 2004), 325);
		pop1.add(new Day(10, 6, 2004), 425);

		// ����һ��ʱ�򼯺�   
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(pop1);

		// ����ʱ��ͼ   
		JFreeChart chart = ChartFactory.createTimeSeriesChart("�˿�ͳ��ʱ��ͼ", "����",
				"����", dataset, true, true, false);

		String title = "�˿�ͳ��ʱ��ͼ";

		// ����ͼ������   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("����", Font.TRUETYPE_FONT, 15));

		// ���ñ�������   
		Font font = new Font("����", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		chart.setTitle(textTitle);

		// ����������ʾ��ʽ   
		XYPlot plot = chart.getXYPlot();
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MM-dd-yyyy"));

		// ����   
		NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();

		// ���������ǩ����   
		numAxis.setLabelFont(new Font("����", Font.BOLD, 14));

		// ����   
		DateAxis dateaxis = (DateAxis) plot.getDomainAxis();

		// ���ú����ǩ����   
		dateaxis.setLabelFont(new Font("����", Font.BOLD, 14));

		ChartFrame cf = new ChartFrame("ʱ��ͼ", chart);
		cf.pack();
		cf.setVisible(true);

	}

	/**  
	 * ������ݼ���
	 * @return  
	 */
	private static CategoryDataset getDataset() {
		double[][] data = new double[][] { { 672, 766, 223, 540, 126 },
				{ 325, 521, 210, 340, 106 }, { 332, 256, 523, 240, 526 } };
		String[] rowKeys = { "ƻ��", "����", "����" };
		String[] columnKeys = { "����", "�Ϻ�", "����", "�ɶ�", "����" };
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				rowKeys, columnKeys, data);
		return dataset;
	}

	public static void main(String[] args) {

		// 3D��״ͼ   
		makePieChart3D();

		// 3D��״ͼ   
		makeBarChart3D();

		// ����ͼ   
		makeLineAndShapeChart();

		// ʱ��ͼ   
		makeTimeSeriesChart();
	}

}