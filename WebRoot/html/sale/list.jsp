<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/com.jsp"  %>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<link href="${basePath}/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${basePath}/html/script/common.js"></script>
<script type="text/javascript" src="${basePath}/html/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		//1,为查询按钮绑定事件
		$("#chance_query").click(function(){
			$.ajax({
				type:"post",
	  			url:"${basePath}/html/sale_listByCondition.action",
	  			data:$("#chance_frm").serialize(),
	  			success:function(data){
	  				$("#tbody").html(data);
	  			},
	  			error:function(){
	  				alert("请求失败！！！");
	  			}
			});
						
		});
	});
</script>
</head>
<body>

<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('add.html');">新建</button>  
	<button class="common_button" id="chance_query">查询</button> 
	</div>
	<form id="chance_frm">
	<table class="query_form_table">
		<tr>
			<th>客户名称</th>
			<td><input name="scq.chcCustName"/></td>
			<th>概要</th>
			<td><input name="scq.chcTitle"/></td>
			<th>联系人</th>
			<td>
				<input  size="20" name="scq.chcLinkman" />
			</td>
		</tr>
	</table>
	</form>
<br />
<table class="data_list_table">
	<thead>
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody id="tbody">
		<jsp:include page="listTemplate.jsp"></jsp:include>
	</tbody>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	共59条记录 每页<input value="10" size="2" />条
	第<input value="1" size="2"/>页/共5页
	<a href="#">第一页</a>
	<a href="#">上一页</a>
	<a href="#">下一页</a>
	<a href="#">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>