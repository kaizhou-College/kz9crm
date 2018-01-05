<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/com.jsp"  %>
<html>
<head>
<title>客户关系管理系统</title>
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="${basePath}/html/images/logo.gif"></td>
	<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">当前用户：${sysUser.usrName }（${sysUser.sysRole.roleName }）&nbsp;&nbsp; <a href="<%=basePath %>userAction.do?method=logout">退出系统</a></td>
</tr>
</table>
</body>
</html>
