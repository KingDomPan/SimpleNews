$(document).ready(function(){
	$("#usermanager").click(function() {
		$("#tabs").tabs("add",{
			id:"usersInfo",
			title:"用户信息管理",
			closable:true,
			href:"admin/user.jsp"
		});
	});
	///////////////////////////
	$("#newsmanager").click(function() {
		$("#tabs").tabs("add",{
			id:"newsInfo",
			title:"新闻信息管理",
			closable:true,
			href:"admin/news.jsp"
		});
	});
});