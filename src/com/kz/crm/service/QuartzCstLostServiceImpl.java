package com.kz.crm.service;

public class QuartzCstLostServiceImpl {
	//定时任务方法
	public void work1(){
		System.out.println("我是定时任务....");
		//1,查询订单表，订单日期超过6个月的客户的名字
		//select * from orders where months_between(sysdate,odr_date)>6
		//2,根据客户的名字查询客户表得到客户所有信息
		
		//3,将该客户信息添加到cst_lost表中
	}
}
