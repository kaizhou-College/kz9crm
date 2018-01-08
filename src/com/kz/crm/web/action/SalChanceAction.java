package com.kz.crm.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kz.crm.entity.SalChance;
import com.kz.crm.entity.SalChanceQuery;
import com.kz.crm.service.SalChanceService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SalChanceAction extends ActionSupport{
	@Autowired
	private SalChanceService salChanceService;
	
	private List<SalChance> chances;
	
	private SalChanceQuery scq;
	public List<SalChance> getChances() {
		return chances;
	}
	public void setChances(List<SalChance> chances) {
		this.chances = chances;
	}
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
	/**
	 * 根据条件来进行查询（+分页）
	 */
	public String listByCondition(){
		System.out.println("进入action"+scq);
		//没有写条件查询 直接写分页查询 这个是不行的 为了测试
		chances = salChanceService.findByPage(1,10);
		return "lislTemplate";
		
	}
	public SalChanceQuery getScq() {
		return scq;
	}
	public void setScq(SalChanceQuery scq) {
		this.scq = scq;
	}
	
}
