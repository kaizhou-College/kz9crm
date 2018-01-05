package com.kz.crm.service.impl;

import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kz.crm.dao.SalChanceDao;
import com.kz.crm.entity.SalChance;
import com.kz.crm.service.SalChanceService;

@Service
public class SalChanceSericeImpl implements SalChanceService {
	
	@Autowired
	private SalChanceDao salChanceDao;
	
	public List<SalChance> findByPage(int page, int pageSize) {
		
		return salChanceDao.findByPage(page,pageSize);
	}

}
