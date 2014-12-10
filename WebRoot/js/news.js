var url;
function newNews() {
	$('#news_dlg').dialog('open').dialog('setTitle', '新增新闻');
	$('#news_fm').form('clear');
	url = 'news/save!save.action';
}

function editNews() {
	var row = $('#news_dg').datagrid('getSelected');
	if (row) {
		$('#news_dlg').dialog('open').dialog('setTitle', '编辑新闻');
		$('#news_fm').form('load', row);
		url = 'news/update!update.action?keyId=' + row.id;
	}
}

function saveNews() {
	$('#news_fm').form('submit', {
		url : url,
		success : function(data) {
			var data = eval('(' + data + ')');
			alert(data);
			if(!data.success){
				$.messager.alert('系统提示','保存失败!','info'); 
			}else{
				$('#news_dlg').dialog('close');
				$('#news_dg').datagrid('reload');
				$.messager.alert("系统提示", data.message, "info");
			}
		}
	});
}

function format(val,row){
	if(val==""||val==null)
		val="NoFile";
    return '<a onclick="if(this.text==\'NoFile\') {alert(\'该新闻暂无附件信息\');return false;}"'+
     ' style="color:red;" href="download/download!download.action?filename='+val+'">'+val+'</a>';
}  

function destroyNews() {
	var row = $('#news_dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定删除该新闻吗?', function(r) {
			if (r) {
				$.post('news/delete!delete.action', {
					keyId : row.id
				}, function(result) {
					if (result.success) {
						$('#news_dg').datagrid('reload'); // reload the news
						// data
						$.messager.alert("系统提示", result.message, info);
					} else {
						$.messager.alert("系统提示", "删除出错了!!!!", error);
					}
				}, 'json');
			}
		});
	}
}