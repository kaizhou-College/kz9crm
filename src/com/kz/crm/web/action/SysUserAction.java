package com.kz.crm.web.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kz.crm.core.common.Const;
import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.entity.SysUser;
import com.kz.crm.service.SysRoleService;
import com.kz.crm.service.SysUserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class SysUserAction extends ActionSupport{
	@Autowired
	private SysUserService us;
	
	@Autowired
	private SysRoleService srs;
	
	private SysUser user;
	
	private String rightStr;
	
	public String login(){
		//System.out.println("进入SysUserAction...."+user);
		//1,对用户名和密码进行验证
		SysUser loginUser = us.login(user.getUsrName(),user.getUsrPassword());
		//将登录用户对象保存到session中时，用户对象是没有关联到角色信息的
		//jsp中是到session域中获取，所有即使配置了openSessionInView也不会有用！！！
		loginUser.getSysRole().getRoleName();
		//System.out.println("=========="+loginUser.getSysRole());
		//2,将用户对象保存到session中
		ServletActionContext.getRequest().getSession().setAttribute(Const.LOGIN_USER, loginUser);
		//3,得到该用户的角色---关联对象
		SysRole sysRole  = loginUser.getSysRole();
		
		//4,根据角色获取排序权限
		//System.out.println(sysRole.getRights());
		rightStr = srs.findRightsByRole(sysRole.getRoleId());
		System.out.println("=============="+rightStr);
		//5,将所有权限：放入session
		ServletActionContext.getRequest().getSession().setAttribute("rightStr", rightStr);
		return "login_success";
	}
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public String getRightStr() {
		return rightStr;
	}
	public void setRightStr(String rightStr) {
		this.rightStr = rightStr;
	}
	
	
	
}
