$(function() {
	$('#ff').form({
		url : "user/register!register.action",
		success : function(data) {
			var data = eval('(' + data + ')');
			if (data.success) {
				$.messager.alert('系统提示', data.message, 'info');
			}
		}
	});
});