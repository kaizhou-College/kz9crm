package com.kz.crm.dao;

import java.util.List;

import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.entity.SysRoleQuery;

public interface SysRoleDao {


	List<SysRole> findAll();

	SysRole findRole(Long roleId);

	List<SysRight> findRightsByRole(Long roleId);

	List<SysRole> findByPage(SysRoleQuery srq);

}
