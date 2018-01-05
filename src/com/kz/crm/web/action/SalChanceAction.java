package com.kz.crm.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kz.crm.entity.SalChance;
import com.kz.crm.service.SalChanceService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SalChanceAction extends ActionSupport{
	@Autowired
	private SalChanceService salChanceService;
	
	private List<SalChance> chances;
	/**
	 * 
	 * 分页查询销售机会的信息
	 */
	public String  list(){
		//1,页数和条数
		int page = 1;
		int pageSize = 10;
		//2,web--service--dao---数据库
		chances = salChanceService.findByPage(page,pageSize);
		System.out.println("chances=="+chances);
		if(chances==null){
			return "list_error";
		}
		return "list_success";
	}
}
