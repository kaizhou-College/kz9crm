package com.kz.crm.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.entity.SysRoleQuery;
import com.kz.crm.service.SysRightService;
import com.kz.crm.service.SysRoleService;

@Controller
@Scope("prototype")
public class SysRoleAction {
	
	@Autowired
	private SysRoleService srs;
	
	@Autowired
	private SysRightService rightService;
	
	private List<SysRole> roles;
	
	private SysRoleQuery srq;
	
	private SysRole role;
	
	private List<SysRight> rights;
	
	private String[] currentRightsStr;
	/**
	 * 分页查询所有的角色信息
	 * @return
	 */
	public String list(){
		
		if(srq==null){
			srq = new SysRoleQuery();
			srq.setCurPage(1);//默认第1页
			srq.setPageSize(10);//默认每页10条
		}
		
		//分页查询
		roles=  srs.listByPage(srq);
		
		return "list_success";
	}
	/**
	 * 查询指定角色的权限
	 */
	public String listRightByRole(){
		//System.out.println("listRightByRole+"+role);
		//1,根据id来获取角色对象
		role = srs.findRole(role.getRoleId());
		//2,获取该角色的当前权限
		Set<SysRight> currentRights = role.getRights();
		//2,1构建当前角色的权限的数组
		currentRightsStr = new String[currentRights.size()];
		int i = 0;//表示数组的开始下标
		for(SysRight sr:currentRights){
			currentRightsStr[i]=sr.getRightText();
			i++;
		}
		/*for(String s:currentRightsStr){
			System.out.println(s+"\t");
		}*/
		//3,查询所有权限
		rights = rightService.list();
		return "listRight_success";
	}
	/**
	 * 为指定的角色分配权限
	 * @return
	 */
	public void update(){
		System.out.println("update............");
		
		srs.updateRights(currentRightsStr,role.getRoleId());
		
		return;
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
	public SysRoleQuery getSrq() {
		return srq;
	}
	public void setSrq(SysRoleQuery srq) {
		this.srq = srq;
	}
	public List<SysRight> getRights() {
		return rights;
	}
	public void setRights(List<SysRight> rights) {
		this.rights = rights;
	}
	public String[] getCurrentRightsStr() {
		return currentRightsStr;
	}
	public void setCurrentRightsStr(String[] currentRightsStr) {
		this.currentRightsStr = currentRightsStr;
	}
	
	
	
	
	
	
}

