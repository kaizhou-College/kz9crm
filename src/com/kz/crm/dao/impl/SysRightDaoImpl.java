package com.kz.crm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kz.crm.dao.SysRightDao;
import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;

public class SysRightDaoImpl extends HibernateDaoSupport implements SysRightDao {
	public SysRight findRightByText(String rightText) {
		Session session = this.getSession();
		Query query = session.createQuery("from SysRight a where a.rightText=?");
		query.setParameter(0, rightText);
		return (SysRight) query.uniqueResult();
	}

	public void updateRight(SysRole tempRole) {
		Session session = this.getSession();
		session.update(tempRole);
	}

	public List<SysRight> findAll() {
		Session session = this.getSession();
		return session.createQuery("from SysRight").list();
	}

	
	
}
