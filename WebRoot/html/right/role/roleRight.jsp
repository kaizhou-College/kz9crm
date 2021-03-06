<%@ page language="java" pageEncoding="UTF-8"%>

<%@include file="../../common/com.jsp" %>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<link href="${basePath}/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${basePath}/html/script/common.js"></script>
<script src="${basePath}/html/js/jquery-1.4.2.min.js"></script>

<script type="text/javascript">
	function selectAll(rightCode){
		$("[class^="+rightCode+"]:gt(0)").attr("checked",$("."+rightCode).attr("checked"));
	}
	function selectParent(rightCode){
		var parentCode = rightCode.substring(0,3);
		var parentChecked = false;
		$("[class^="+parentCode+"]:gt(0)").each(function(){
			if(this.checked){
				parentChecked = true;
			}
			return ;
		});
		$("[class="+parentCode+"]").attr("checked",parentChecked);
	}

</script>

</head>

<body>
<div class="page_title">分配角色权限</div>

<br />
<s:form method="post" action="right/role/update.action" namespace="/html">
	<input type="hidden" name="role.roleId" value="${role.roleId }"/>
	<table class="data_list_table">
	  <tr>
	    <th>
	    <div align="left">权限分配（选定后保存）当前角色-》<s:property value="%{role.roleName}"/> </div>
	    </th>
	  </tr>
	  
	  <s:iterator value="%{rights}" var="rl" status="index">
	  	<s:if test="%{#rl.rightType == 'Folder'}">
	  		<s:if test="%{#index.index == 0}">
	  			</p>
		    	</div>
				</td>
			  </tr>
			  <tr height="4"></tr>
			</s:if>
			 <tr>
		    <td class="list_data_number">
				<div align="left">
		        <p>
	  			<s:checkboxlist list="%{#rl.rightText}" name="currentRightsStr" onchange="selectAll('%{#rl.rightCode}')" cssClass="%{#rl.rightCode}" value="%{currentRightsStr}"/>
	 			</p>
		        <p>
	 		
	 	</s:if>
	 	<s:else>
	 		
	 			<s:checkboxlist list="%{#rl.rightText}" onchange="selectParent('%{#rl.rightCode}')" cssClass="%{#rl.rightCode}" name="currentRightsStr" value="%{currentRightsStr}"/>
	 	</s:else>
	  </s:iterator>
	   </p>
		      
		    	</div>
			</td>
		  </tr>
		  <tr height="4"></tr>
	  <tr>
	    <td class="list_data_number">
	    <input type="submit" value="提交">&nbsp;&nbsp;
	    <input type="button" value="返回" onclick="window.location.reload();">
		
			
		
		</td>
	  </tr>
	  <tr height="4"></tr>
	</table>
</s:form>

<s:debug></s:debug>

</body>
</html>
