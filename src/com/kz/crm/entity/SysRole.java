package com.kz.crm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String roleName;
	private String roleDesc;
	private Integer roleFlag;
	//得到角色的同时需要得到该角色的所有用户的所有信息
	private Set sysUsers = new HashSet(0);
	//得到角色的同时需要获取所有的权限的所有信息
	private Set<SysRight> rights = new HashSet<SysRight>(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(Long roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	/** full constructor */
	public SysRole(Long roleId, String roleName, String roleDesc,
			Integer roleFlag, Set sysUsers/*, Set rights*/) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleFlag = roleFlag;
		this.sysUsers = sysUsers;
		//this.rights = rights;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleFlag() {
		return this.roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Set getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set sysUsers) {
		this.sysUsers = sysUsers;
	}

	@Override
	public String toString() {
		return "SysRole [roleDesc=" + roleDesc + ", roleFlag=" + roleFlag
				+ ", roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	
	public Set<SysRight> getRights() {
		return rights;
	}

	public void setRights(Set<SysRight> rights) {
		this.rights = rights;
	}

	

}