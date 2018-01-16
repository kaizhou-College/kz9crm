package com.kz.crm.dao;

import com.kz.crm.entity.SysUser;

public interface SysUserDao {

	SysUser findUserByName(String usrName, String usrPassword);
	
}
