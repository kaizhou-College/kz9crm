package cn.jbit.jfreechart.dao;

import java.util.List;

import cn.jbit.jfreechart.entity.Student;

/**
 * ѧԱ��Ϣ����DAO��
 * @author ��������
 */
public interface StudentDao {
	/**
	 * ��ѯѧԱ�б���Ϣ��
	 * @param condition ��ѯ����
	 * @return ѧԱ�б�
	 */
	public List<Student> find(Student condition);
	/**
	 * ��ѯѧԱ�б�
	 * @param hql ��ѯ���
	 * @return �����������б�
	 */
	@SuppressWarnings("unchecked")
	public List search(String hql);
}
