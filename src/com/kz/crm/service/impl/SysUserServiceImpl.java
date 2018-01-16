package com.kz.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kz.crm.dao.SysUserDao;
import com.kz.crm.entity.SysUser;
import com.kz.crm.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sud;
	
	public SysUser login(String usrName, String usrPassword) {
		
		return sud.findUserByName(usrName,usrPassword);
	}

}
