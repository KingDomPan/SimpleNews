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
<title>News Login</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/adduser.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
<script type="text/javascript" src="js/adduser.js"></script>
	<div class="easyui-panel" title="新用户注册"
		style="width:300px;background:#fafafa;padding:10px;">
		<form id="ff" method="post">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input class="easyui-validatebox"
						name="userDto.user.username" type="text"
						data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>密 码:</td>
					<td><input class="easyui-validatebox"
						name="userDto.user.password" type="password"
						data-options="required:true"></input>
					</td>
				</tr>
				<tr>
					<td>密码确认:</td>
					<td><input class="easyui-validatebox"
						name="userDto.repassword" type="password"
						data-options="required:true"></input></td>
				</tr>

				<tr>
					<td>性 别:</td>
					<td><input name="userDto.user.sex" type="radio"
						checked="checked" value="男">男 &nbsp;&nbsp;&nbsp;&nbsp;<input
						name="userDto.user.sex" type="radio" value="女">女 </input></td>
				</tr>

				<tr>
					<td>真实姓名:</td>
					<td><input class="easyui-validatebox"
						name="userDto.user.realname" type="text"
						data-options="required:true"></input></td>
				</tr>

				<tr>
					<td>从属工作:</td>
					<td><input class="easyui-validatebox" name="userDto.user.job"
						type="text" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>邮 箱:</td>
					<td><input class="easyui-validatebox" type="text"
						name="userDto.user.email"
						data-options="validType:'email' ,required:true" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="注册"> <input
						type="reset" value="清空"></input></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
