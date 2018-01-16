package com.kz.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kz.crm.dao.SysRoleDao;
import com.kz.crm.entity.SysRight;
import com.kz.crm.entity.SysRole;
import com.kz.crm.entity.SysRoleQuery;
import com.kz.crm.service.SysRoleService;

//<bean id="roleService" class="com.kz.service.impl.RoleServiceImpl"></bean>
@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao rd;

	public List<SysRole> selRoleByPage(SysRoleQuery srq) {
		return rd.seleRoleByPage(srq);
	}

	public List<SysRole> list() {
		return rd.findAll();
	}

	public SysRole findRole(Long roleId) {
		return rd.findRole(roleId);
	}

	// 根句角色的id來獲取排序的權限
	public String findRightsByRole(Long roleId) {
		//获取了权限 拼接成 index-ec.jsp中菜单的样子？
		/*L01 = theMenu.addChild(l2ID, "Folder", "营销管理", "", "营销管理...");
		L0101 = theMenu.addChild(L01, "Document", "销售机会管理", "${basePath}/html/sale_list.action", "销售机会管理...");
		L0102 = theMenu.addChild(L01, "Document", "客户开发计划", "~sale/dev.html", "客户开发计划...");*/
		List<SysRight> rigths = rd.findRightsByRole(roleId);
		StringBuffer rightStr = new StringBuffer();
		for(SysRight right :rigths){
			if(right.getRightType().equals("Folder")){
				rightStr.append(right.getRightCode()+" = theMenu.addChild(l2ID, \"Folder\", \""+right.getRightText()+"\", \"\", \""+right.getRightTip()+"...\");\n");
			}else{
				rightStr.append(right.getRightCode()+" = theMenu.addChild("+right.getRightParentCode()+", \"Document\", \""+right.getRightText()+"\", \""+right.getRightUrl()+"\", \""+right.getRightTip()+"...\");");
			}
		}
		
		/*L01 = theMenu.addChild(l2ID, "Folder", "营销管理", "", "营销管理...");
		L0101 = theMenu.addChild(L01, "Document", "销售机会管理", "${basePath}/html/sale_list.action", "销售机会管理...");
		L0102 = theMenu.addChild(L01, "Document", "客户开发计划", "~sale/dev.html", "客户开发计划...");
*/
		return rightStr.toString();
	}

}
