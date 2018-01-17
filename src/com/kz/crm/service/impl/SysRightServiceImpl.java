package com.kz.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kz.crm.dao.SysRightDao;
import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.service.SysRightService;
@Service
public class SysRightServiceImpl implements SysRightService {
	
	@Autowired
	private SysRightDao rd;

	public SysRight findRightByText(String rightText) {
		return rd.findRightByText(rightText);
	}

	public int updateRight(SysRole tempRole) {
		int re = 1;
		try {
			rd.updateRight(tempRole);
			re = 1;
		} catch (Exception e) {
			e.printStackTrace();
			re = -1;
		}
		return re;
		
	}

	public List<SysRight> list() {
		return rd.findAll();
	}

}
