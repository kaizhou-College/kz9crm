package com.kz.crm.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kz.crm.entity.SysRole;
import com.kz.crm.service.SysRoleService;

@Controller
@Scope("prototype")
public class SysRoleAction {
	
	@Autowired
	private SysRoleService srs;
	
	private List<SysRole> roles;
	
	private SysRole role;
	/**
	 * 查询所有的角色信息
	 * @return
	 */
	public String list(){
		//没有加分页
		roles=  srs.list();
		
		return "list_success";
	}
	/**
	 * 查询指定角色的权限
	 */
	public String listRightByRole(){
		System.out.println("listRightByRole+"+role);
		
		
		return "listRight_success";
	}
	/**
	 * 为指定的角色分配权限
	 * @return
	 */
	public String disPathRight(){
		
		return "";
	}
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	
	
	
}

