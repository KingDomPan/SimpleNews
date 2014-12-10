<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>用户管理</title>
<!-- <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="easyui/demo/demo.css"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="easyui/themes/default/easyui.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="css/user.css"> -->
<!-- <script type="text/javascript" src="js/jquery-1.8.2.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery.easyui.min.js"></script> -->
<!-- <script type="text/javascript" src="js/md5.js"></script> -->
<!-- <script type="text/javascript" src="js/user.js"></script> -->

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>

	<div data-options="region:'center',title:'管理员查看区',iconCls:'icon-ok'">
		<table id="user_dg" title="用户信息" class="easyui-datagrid"
			style="width:auto;height:auto"
			url="user/findbypage!findListByPage.action" toolbar="#user_toolbar"
			pagination="true" rownumbers="true" fitColumns="true"
			singleSelect="true">
			<thead>
				<tr>
					<th field="username" width="50">用户名</th>
					<th field="password" width="50">密 码</th>
					<th field="realname" width="50">真实姓名</th>
					<th field="sex" width="50">性 别</th>
					<th field="job" width="50">从属工作</th>
					<th field="email" width="100">邮箱地址</th>
				</tr>
			</thead>
		</table>
		<div id="user_toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="newUser()">新增用户</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
		</div>

		<div id="user_dlg" class="easyui-dialog"
			style="width:400px;height:380px;padding:10px 20px" closed="true"
			buttons="#user_dlg-buttons">
			<div class="ftitle">用户信息</div>
			<form id="user_fm" method="post">
				<div class="fitem">
					<label>用户名:</label> <input class="easyui-validatebox"
						name="username" type="text" data-options="required:true"></input>
				</div>
				<div class="fitem">
					<label>密 码:</label> <input class="easyui-validatebox" id="password"
						name="password" type="password" data-options="required:true"></input>
				</div>
				<div class="fitem">
					<label>性 别:</label> <input name="sex" type="radio"
						checked="checked" value="男">男 &nbsp;&nbsp;&nbsp;&nbsp;<input
						name="sex" type="radio" value="女">女 </input>
				</div>
				<div class="fitem">
					<label>真实姓名:</label> <input class="easyui-validatebox"
						name="realname" type="text" data-options="required:true"></input>
				</div>

				<div class="fitem">
					<label>从属工作:</label> <input class="easyui-validatebox" name="job"
						type="text" data-options="required:true"></input>
				</div>
				<div class="fitem">
					<label>邮 箱:</label> <input class="easyui-validatebox" type="text"
						name="email" data-options="validType:'email' ,required:true" />
				</div>
			</form>
		</div>
		<div id="user_dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveUser()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#user_dlg').dialog('close')">取消</a>
		</div>
	</div>
</body>
</html>
