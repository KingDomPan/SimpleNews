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
<title>News Main</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/user.css">
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/layout.js"></script>
<script type="text/javascript" src="js/md5.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script type="text/javascript" src="js/news.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body style="margin:0px;padding:0px;width:100%;height:100%;">
	<div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'west',split:true" title="管理员管理栏"
			style="width:200px;">

			<div class="easyui-accordion" style="width:193px;height:300px;">
				<div title="用户管理" data-options="iconCls:'icon-ok'"
					style="overflow:auto;padding:10px;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="usermanager">用户管理</a>
				</div>
				<div title="新闻管理" data-options="iconCls:'icon-ok'"
					style="overflow:auto;padding:10px;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="newsmanager">新闻管理</a>
				</div>
				<div title="评论管理" data-options="iconCls:'icon-ok'"
					style="overflow:auto;padding:10px;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add'">评论管理</a>
				</div>
			</div>

		</div>
		<div data-options="region:'center',title:'管理员查看区',iconCls:'icon-ok'">
			<div id="tabs" class="easyui-tabs" style="width:auto;height:auto;">
			</div>
		</div>
	</div>

</body>
</html>
