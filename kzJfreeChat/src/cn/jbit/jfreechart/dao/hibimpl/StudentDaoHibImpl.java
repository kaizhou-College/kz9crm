package cn.jbit.jfreechart.dao.hibimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jbit.jfreechart.dao.StudentDao;
import cn.jbit.jfreechart.entity.Student;

/**
 * 学员信息处理DAO实现类。
 * @author 北大青鸟
 */
public class StudentDaoHibImpl extends HibernateDaoSupport implements
		StudentDao {

	/* (non-Javadoc)
	 * @see cn.jbit.jfreechart.dao.StudentDao#find(cn.jbit.jfreechart.entity.Student)
	 */
	@SuppressWarnings("unchecked")
	public List<Student> find(Student condition) {
		List<Student> ret = this.getHibernateTemplate().findByExample(condition);
		return ret;
	}

	/* (non-Javadoc)
	 * @see cn.jbit.jfreechart.dao.StudentDao#search(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List search(String hql) {
		List ret = this.getHibernateTemplate().find(hql);
		return ret;
	}

}
