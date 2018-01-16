package com.kz.crm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRight entity. @author MyEclipse Persistence Tools
 */

public class SysRight implements java.io.Serializable {

	// Fields

	private String rightCode;
	private String rightParentCode;
	private String rightType;
	private String rightText;
	private String rightUrl;
	private String rightTip;
	private Set<SysRole> roles = new HashSet<SysRole>(0);

	// Constructors

	/** default constructor */
	public SysRight() {
	}

	/** minimal constructor */
	public SysRight(String rightCode) {
		this.rightCode = rightCode;
	}

	/** full constructor */
	public SysRight(String rightCode, String rightParentCode, String rightType,
			String rightText, String rightUrl, String rightTip
			) {
		this.rightCode = rightCode;
		this.rightParentCode = rightParentCode;
		this.rightType = rightType;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
		this.rightTip = rightTip;
	}

	// Property accessors

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightParentCode() {
		return this.rightParentCode;
	}

	public void setRightParentCode(String rightParentCode) {
		this.rightParentCode = rightParentCode;
	}

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightText() {
		return this.rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightUrl() {
		return this.rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightTip() {
		return this.rightTip;
	}

	public void setRightTip(String rightTip) {
		this.rightTip = rightTip;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "SysRight [rightCode=" + rightCode + ", rightParentCode="
				+ rightParentCode + ", rightText=" + rightText + ", rightTip="
				+ rightTip + ", rightType=" + rightType + ", rightUrl="
				+ rightUrl + "]\n";
	}
	

	

}