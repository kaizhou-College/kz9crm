package cn.jbit.jfreechart.entity;

import java.util.Date;

/**
 * ѧԱ������Ϣʵ�塣
 * @author ��������
 */
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 8985499578658875622L;
	// ѧԱ���
	private Long stuid;
	// ѧԱ����
	private String stuName;
	// ����
	private String stuBirthplace;
	// ����
	private Date stuBirthday;
	// ��ѧʱ��
	private Date stuEnrollment;
	// ��ϵ�绰
	private String stuPhone;
	// ѧ��
	private String stuEducation;
	// ��ϵ��ַ
	private String stuAddress;
	
	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Long stuid) {
		this.stuid = stuid;
	}

	/** full constructor */
	public Student(Long stuid, String stuName, String stuBirthplace,
			Date stuBirthday, Date stuEnrollment, String stuPhone,
			String stuEducation, String stuAddress) {
		this.stuid = stuid;
		this.stuName = stuName;
		this.stuBirthplace = stuBirthplace;
		this.stuBirthday = stuBirthday;
		this.stuEnrollment = stuEnrollment;
		this.stuPhone = stuPhone;
		this.stuEducation = stuEducation;
		this.stuAddress = stuAddress;
	}

	/**
	 * @return the stuid
	 */
	public Long getStuid() {
		return stuid;
	}

	/**
	 * @param stuid the stuid to set
	 */
	public void setStuid(Long stuid) {
		this.stuid = stuid;
	}

	/**
	 * @return the stuName
	 */
	public String getStuName() {
		return stuName;
	}

	/**
	 * @param stuName the stuName to set
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * @return the stuBirthplace
	 */
	public String getStuBirthplace() {
		return stuBirthplace;
	}

	/**
	 * @param stuBirthplace the stuBirthplace to set
	 */
	public void setStuBirthplace(String stuBirthplace) {
		this.stuBirthplace = stuBirthplace;
	}

	/**
	 * @return the stuBirthday
	 */
	public Date getStuBirthday() {
		return stuBirthday;
	}

	/**
	 * @param stuBirthday the stuBirthday to set
	 */
	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}

	/**
	 * @return the stuEnrollment
	 */
	public Date getStuEnrollment() {
		return stuEnrollment;
	}

	/**
	 * @param stuEnrollment the stuEnrollment to set
	 */
	public void setStuEnrollment(Date stuEnrollment) {
		this.stuEnrollment = stuEnrollment;
	}

	/**
	 * @return the stuPhone
	 */
	public String getStuPhone() {
		return stuPhone;
	}

	/**
	 * @param stuPhone the stuPhone to set
	 */
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	/**
	 * @return the stuEducation
	 */
	public String getStuEducation() {
		return stuEducation;
	}

	/**
	 * @param stuEducation the stuEducation to set
	 */
	public void setStuEducation(String stuEducation) {
		this.stuEducation = stuEducation;
	}

	/**
	 * @return the stuAddress
	 */
	public String getStuAddress() {
		return stuAddress;
	}

	/**
	 * @param stuAddress the stuAddress to set
	 */
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}