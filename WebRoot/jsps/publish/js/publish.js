var publishUrl = getRootPath_web() + "/publishServlet"; //发表文章 的链接

window.onload = function() {
	
	//点击发表按钮
	$("#submit").click(function() {
		//获取文章标题，正文
		var title = $("#title").val();
		var message = $("#main").val();
		if(title.length<3){
			alert("标题不能太短！");
			return ;
		}
		if(message.length<15){
			alert("正文不能太短！");
			return ;
		}
		title = window.encodeURIComponent(title);
		message = window.encodeURIComponent(message);
		var data = "title="+title+"&message="+message+"&userId="+userId;
//		alert(data);
		$.post(publishUrl, data, function(response) {
			if(response == 0) {
				alert("发表失败！");
			}else{
				alert("发表成功！");
				window.location=getRootPath_web()+"/articleServlet?infoId="+response;//返回到发表成功的帖子页面	
			}
		});
	
	});

}

function getRootPath_web() { //http://127.0.0.1:8020/codeforum
	
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return(localhostPaht + projectName);
}