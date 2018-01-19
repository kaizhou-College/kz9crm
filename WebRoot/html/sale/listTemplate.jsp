<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/com.jsp"  %>
<s:iterator value="chances" var="chance">
	<tr>
		<td class="list_data_number">${chance.chcId}</td>
		<td class="list_data_text">${chance.chcCustName}</td>
		<td class="list_data_ltext">${chance.chcTitle}</td>
		<td class="list_data_text">${chance.chcLinkman}</td>
		<td class="list_data_text">${chance.chcTel}</td>
		<td class="list_data_text">${chance.chcDueDate}</td>
		<td class="list_data_op">
			<img onclick="to('dispatch.html');" title="指派" src="${basePath}/html/images/bt_linkman.gif" class="op_button" />
			<img onclick="to('edit.html');" title="编辑" src="${basePath}/html/images/bt_edit.gif" class="op_button" />
			<img onclick="del('“销售机会：采购笔记本电脑意向”');" title="删除" src="${basePath}/html/images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>