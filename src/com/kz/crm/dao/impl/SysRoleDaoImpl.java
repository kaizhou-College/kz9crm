package com.kz.crm.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kz.crm.dao.SysRoleDao;
import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.entity.SysRoleQuery;

public class SysRoleDaoImpl extends HibernateDaoSupport implements SysRoleDao {

	public List<SysRole> findAll() {
		Session session = this.getSession();
		return session.createQuery("from SysRole").list();
	}

	public SysRole findRole(Long roleId) {
		Session session = this.getSession();
		//----老师
		SysRole curRole = (SysRole) session.get(SysRole.class, roleId);
		//-----学生
		Set<SysRight> rights = curRole.getRights();
		//所有学生都断绝与这个老师的关系
		//所有的权限都断绝与这个角色的关系
		for(SysRight rs:rights){
			rs.getRoles().remove(curRole);
		}
		return curRole ;
	}

	public List<SysRight> findRightsByRole(Long roleId) {
		Session session  =this.getSession();
		List<SysRight> rights = session.createQuery("select b from SysRole a inner join a.rights b where a.roleId=? order by b.rightCode")
		.setParameter(0, roleId)
		.list();
		return rights;
	}

	public List<SysRole> findByPage(SysRoleQuery srq) {
		Session session = this.getSession();
		Query query = session.createQuery("from SysRole");
		
		int start = (srq.getCurPage()-1)*srq.getPageSize();
		query.setFirstResult(start);
		query.setMaxResults(srq.getPageSize());
		return query.list();
	}

}
