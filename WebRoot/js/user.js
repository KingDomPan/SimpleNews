var url;
function newUser() {
	$('#user_dlg').dialog('open').dialog('setTitle', '新增用户');
	$('#user_fm').form('clear');
	url = 'user/save!save.action';
}
function editUser() {
	var row = $('#user_dg').datagrid('getSelected');
	if (row) {
		$('#user_dlg').dialog('open').dialog('setTitle', '编辑用户');
		$('#user_fm').form('load', row);
		url = 'user/update!update.action?keyId=' + row.id;
		console.log(url);
	}
}
function saveUser() {
	console.log("saveuser");
	$('#user_fm').form('submit', {
		url : url,
		onSubmit:function(){
			var pass=$("#password").val();
			pass=hex_md5(pass);
			$("#password").val(pass);
			console.log(pass);
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (!result.success) {
				$.messager.alert("系统提示", "保存失败", "info");
			} else {
				$('#user_dlg').dialog('close'); // close the dialog
				$('#user_dg').datagrid('reload'); // reload the user data
				$.messager.alert("系统提示", result.message, "info");
			}
		}
	});
}
function destroyUser() {
	var row = $('#user_dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定删除该用户吗?', function(r) {
			if (r) {
				$.post('user/delete!delete.action', {
					keyId : row.id
				}, function(result) {
					if (result.success) {
						$('#user_dg').datagrid('reload'); // reload the user data
						$.messager.alert("系统提示", result.message, info);
					} else {
						$.messager.alert("系统提示", "删除出错了!!!!", error);
					}
				}, 'json');
			}
		});
	}
}