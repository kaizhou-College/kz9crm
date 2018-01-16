package com.kz.crm.service;

import java.util.List;

import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.entity.SysRoleQuery;

public interface SysRoleService {
	List<SysRole> selRoleByPage(SysRoleQuery srq);

	List<SysRole> list();

	SysRole findRole(Long roleId);

	String findRightsByRole(Long roleId);

}
