package com.kz.crm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kz.crm.dao.SalChanceDao;
import com.kz.crm.entity.SalChance;

public class SalChanceDaoImpl extends HibernateDaoSupport implements SalChanceDao {
	
	public List<SalChance> findByPage(int page, int pageSize) {
		Session session = this.getSession();
		int start = (page-1)*pageSize;
		List<SalChance> list = session.createCriteria(SalChance.class)
							.setFirstResult(start)
							.setMaxResults(pageSize)
							.list();
		return list;
	}

}
