package com.kz.crm.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kz.crm.dao.SysUserDao;
import com.kz.crm.entity.SysUser;
public class SysUserDaoImpl extends HibernateDaoSupport implements SysUserDao {

	public SysUser findUserByName(String usrName, String usrPassword) {
		Session session = this.getSession();
		Query query = session.createQuery("from SysUser where usrName=? and usrPassword=?");
		//占位符的下标从0开始  jdb从1开始
		query.setParameter(0, usrName);
		query.setParameter(1, usrPassword);
		return (SysUser) query.uniqueResult();
	}

}
