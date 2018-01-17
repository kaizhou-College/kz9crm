package com.kz.crm.service;

import java.util.List;

import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.entity.SysRoleQuery;

public interface SysRoleService {

	List<SysRole> list();

	SysRole findRole(Long roleId);

	String findRightsByRole(Long roleId);

	List<SysRole> listByPage(SysRoleQuery srq);

	void updateRights(String[] currentRightsStr, Long roleId);

}
