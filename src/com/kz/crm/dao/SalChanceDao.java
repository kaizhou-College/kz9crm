package com.kz.crm.dao;

import java.util.List;

import com.kz.crm.entity.SalChance;

public interface SalChanceDao {

	List<SalChance> findByPage(int page, int pageSize);

}
