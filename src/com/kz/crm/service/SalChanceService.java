package com.kz.crm.service;

import java.util.List;

import com.kz.crm.entity.SalChance;

public interface SalChanceService {

	List<SalChance> findByPage(int page, int pageSize);

}
