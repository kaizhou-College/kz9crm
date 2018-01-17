package com.kz.crm.service;

import java.util.List;

import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;


public interface SysRightService {

	SysRight findRightByText(String rightText);

	int updateRight(SysRole tempRole);

	List<SysRight> list();

	
}
