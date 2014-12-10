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
<title>新闻管理</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/user.css">
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/datagrid-detailview.js"></script> 
<script type="text/javascript" src="js/news.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>

	<div data-options="region:'center',title:'管理员查看区',iconCls:'icon-ok'">
		<table id="news_dg" title="新闻信息" class="easyui-datagrid"
			style="width:auto;height:auto"
			url="news/findbypage!findListByPage.action" toolbar="#toolbar"
			sortName="createDate" sortOrder="desc" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
			<thead>
				<tr>
					<th field="title" width="50">新闻标题</th>
					<th field="content" width="50">新闻内容</th>
					<th data-options="field:'filePath',width:100,align:'right',formatter:format">附件信息</th> 
					<th field="createDate" width="50">创建时间</th>
					<th field="type" width="50">新闻类型</th>
					<th field="lastModifyTime" width="100">最后修改时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="newNews()">新增新闻</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editNews()">编辑新闻</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="destroyNews()">删除新闻</a>
		</div>

		<div id="news_dlg" class="easyui-dialog"
			style="width:400px;height:380px;padding:10px 20px" closed="true"
			buttons="#news_dlg-buttons">
			<div class="ftitle">新闻信息</div>
			<form id="news_fm" method="post" enctype="multipart/form-data">
				<div class="fitem">
					<label>新闻标题:</label> <input class="easyui-validatebox" name="title" 
						type="text" data-options="required:true"></input>
				</div>
				<div class="fitem">
					<label>新闻内容:</label>
					<textarea class="easyui-validatebox" name="content" type="text"
						data-options="required:true"></textarea>
				</div>
				<div class="fitem">
					<label>附件信息:</label> <input name="file" type="file"> </input>
				</div>
				<div class="fitem">
					<label>新闻类型:</label> <input id="newstype" class="easyui-combobox"
						name="type"
						data-options="valueField:'id',textField:'text',url:'json/type.json',panelHeight:'auto',required:true" />
				</div>
			</form>
		</div>
		<div id="news_dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveNews()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel"
				onclick="javascript:$('#news_dlg').dialog('close')">取消</a>
		</div>
	</div>
</body>
</html>
