package com.kz.crm.dao;

import java.util.List;

import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;

public interface SysRightDao {

	SysRight findRightByText(String rightText);

	void updateRight(SysRole tempRole);

	List<SysRight> findAll();


}
