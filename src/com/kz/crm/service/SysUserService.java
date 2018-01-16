package com.kz.crm.service;

import com.kz.crm.entity.SysUser;

public interface SysUserService {

	SysUser login(String usrName, String usrPassword);
	
}
