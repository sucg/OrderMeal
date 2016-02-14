
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.glodon.model.Userinfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<base href="<%=basePath%>">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>订餐系统</title>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/ui/easyui1.4.4/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/ui/easyui1.4.4/themes/icon.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/css/global.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>resource/css/index.css">
		<script type="text/javascript"
			src="<%=basePath%>resource/ui/easyui1.4.4/jquery.min.js">
</script>
		<script type="text/javascript"
			src="<%=basePath%>resource/ui/easyui1.4.4/jquery.easyui.min.js">
</script>

<script type="text/javascript"
			src="<%=basePath%>resource/js/common.js">
</script>

<script type="text/javascript"
			src="<%=basePath%>resource/js/index.js">
</script>
		
		<body class="easyui-layout">
			<div id="northRegion" data-options="region:'north',border:false">
				<div id="title">OE大区湘菜点餐系统</div>
		
		<div id="logn-area">
		
		<c:if test="${empty sessionScope.userinfo}"> 
			<a id="login-dlg-logout" href="javascript:void(0)" class="easyui-linkbutton"  iconcls="icon-man" onclick="$('#login-dlg').form('clear');$('#login_message').text('');$('#login-dlg').dialog('open')">登录</a>
			<a id="login-dlg-logout" href="javascript:void(0)" class="easyui-linkbutton"  iconcls="icon-save">注册</a>
		</c:if>
		<c:if test="${not empty sessionScope.userinfo}">
			<span>
				欢迎${sessionScope.userinfo.name}！
			</span>
			<a id="login-dlg-logout" href="javascript:void(0)" class="easyui-linkbutton"  iconcls="icon-save" onclick="logout(${sessionScope.userinfo.id})">注销</a>
		</c:if>
		<!-- end logn-area -->
		</div>	
			
	 	<div id="login-dlg" buttons="#login-dlg-button" class="easyui-dialog" title="登录" 
	 		data-options="iconCls:'icon-man',resizable:false,modal:true,width: 350, height: 210,closed: true,
	    cache: false"> 
			 
			<form id="login-form" method="post" action="<%=basePath %>index/login">
				<div class="edititem">
			        <label for="description" >用户名:</label>
			        <input class="easyui-validatebox" type="text" name="name" required="true"></input>
			    </div>
			    <div class="edititem">
			        <label for="price">密码:</label>
			        <input class="easyui-validatebox" type="password" name="password" required="true"></input>
			    </div>
			     <div class="edititem">
			     	<label></label>
			        <span id="login_message"></span>
			    </div> 
			</form>
		
		</div>
				
				<div id="login-dlg-button">
					 <a id="login-dlg-login" href="javascript:void(0)" class="easyui-linkbutton"  iconcls="icon-ok" onclick="login($('#login-form'), $('#login_message'))">确定</a> 
        				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#login-dlg').dialog('close')"
            			iconcls="icon-cancel">取消</a> 
				</div> 
				<!-- end northRegion-->
			</div>
			<div id="westRegion"
				data-options="region:'west',split:false,title:'导航栏'">

				<ul id="nav-west" class="easyui-tree" data-options="animate:true">
					<li>
						点餐
					</li>
					<li>
						当前菜单
					</li>
					<li>
						饭局管理
					</li>
					<li>
						菜单管理
					</li>
					<li>
						用户管理
					</li>
					<li>
						我的信息
					</li>
				</ul>

				<!-- end westRegion-->
			</div>
			<div id="southRegion" data-options="region:'south',border:true">
				south region

				<!-- end southRegion-->
			</div>
			<div id="centerRegion" data-options="region:'center'">

				<table id="maindata-datagrid" toolbar="#maindata-toolbar">
				
				</table>
				
				<div id="maindata-toolbar" style="padding:3px">
				    <a class="easyui-linkbutton" iconCls="icon-ok" onclick="submitrow();">提交</a>
				    <a class="easyui-linkbutton" iconCls="icon-add" onclick="insertrow();">添加</a>
				    <a class="easyui-linkbutton" iconCls="icon-edit" onclick="editrow();">修改</a>
				    <a class="easyui-linkbutton" iconCls="icon-remove" onclick="deleterow($('#maindata-datagrid'), 'menu/delete');">删除</a>
				    <span style="margin-left: 10px;"></span>
				    <input id="search" type="text" style="width: 150px;height: 23px;border: 1px #CCC solid" onkeyup="datagridToolbarSearch(event, $('#maindata-datagrid'), $('#search'));"/>
					<a class="easyui-linkbutton"  onclick="datagridToolbarSearch(event, $('#maindata-datagrid'), $('#search'));">搜    索</a>
					<a class="easyui-linkbutton"  onclick="cancelDatagridToolbarSearch($('#maindata-datagrid'), $('#search'));">取消搜索</a>
				</div>
							
				<div id="edit-dlg" buttons="#edit-dlg-button"> 
					 <div class="edit-form-title"> 
				           信息编辑 
				       </div> 
					<form id="edit-form" method="post">
						<input  type="hidden" name="id" />
						<div class="edititem">
					        <label for="description" >名称:</label>
					        <input class="easyui-validatebox" type="text" name="description" required="true"></input>
					    </div>
					    <div class="edititem">
					        <label for="price">价格:</label>
					        <input class="easyui-validatebox" type="text" name="price" required="true" validType="email"></input>
					    </div>
					    <!--
					    <div class="edititem">
					        <label for="subject">类别:</label>
					        <input class="easyui-validatebox" type="text" name="subject" required="true"></input>
					    </div>
					    -->
					    <div class="edititem">
					        <label for="remark">备注:</label>
					        <input class="easyui-validatebox" type="text" name="remark" ></input>
					    </div>
					</form>
				
				</div>
				
				<div id="edit-dlg-button">
					 <a id="edit-dlg-ok" href="javascript:void(0)" class="easyui-linkbutton"  iconcls="icon-save">保存</a> 
        				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#edit-dlg').dialog('close')"
            			iconcls="icon-cancel">取消</a> 
				
				</div>
				<!-- end centerRegion-->
			</div>
			
			<div id="eastRegion" data-options="region:'east',title:'当前菜单'">
				
				<table id="orderinfo-datagrid">
				</table>
			
			<!-- end eastRegion-->
			</div>
		</body>

		<script type="text/javascript">
		$(document).ready(function() { 
			//设置BaseURL地址
			setBaseURL('<%=basePath%>');
			//初始化订单信息
			initOrderinfoDataGrid();
			//初始化菜单信息
			initMainDataGrid();
			//初始化对话框
			initDialog();
		
		}); 
		</script>
</html>
