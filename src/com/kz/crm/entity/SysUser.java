package com.kz.crm.entity;
import java.util.Set;
/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Long usrId;
	//得到用户的同时得到该用户对应的角色的所有信息
	//private long usr_role_id
	private SysRole sysRole;
	private String usrName;
	private String usrPassword;
	private Integer usrFlag;
	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(Long usrId, String usrName, String usrPassword,
			Integer usrFlag) {
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
	}

	/** full constructor */
	public SysUser(Long usrId, SysRole sysRole, String usrName,
			String usrPassword, Integer usrFlag) {
		this.usrId = usrId;
		this.sysRole = sysRole;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
	}

	// Property accessors

	public Long getUsrId() {
		return this.usrId;
	}

	@Override
	public String toString() {
		return "SysUser [usrFlag=" + usrFlag + ", usrId=" + usrId
				+ ", usrName=" + usrName + ", usrPassword=" + usrPassword + "]";
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Integer getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}

	

	
	
}