package com.kz.crm.entity;

import java.util.Date;

/**
 * SalPlan entity. @author MyEclipse Persistence Tools
 */

public class SalPlan implements java.io.Serializable {

	// Fields

	private Integer plaId;
	//private Integer plaChcId;
	private Date plaDate;
	private String plaTodo;
	private String plaResult;
	//获取计划信息的同时要获得机会信息
	private SalChance salChance;
	// Constructors

	public SalChance getSalChance() {
		return salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	/** default constructor */
	public SalPlan() {
	}

	/** minimal constructor */
	public SalPlan( Date plaDate, String plaTodo) {
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
	}

	/** full constructor */
	public SalPlan( Date plaDate, String plaTodo,
			String plaResult) {
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
	}

	// Property accessors

	public Integer getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}


	public Date getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Date plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaTodo() {
		return this.plaTodo;
	}

	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

}