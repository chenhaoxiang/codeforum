var commentUrl = path + "articleServlet";

window.onload = function() {
	//点击评论按钮
	$("#submit").click(function() {
		//获取评论内容
		var comment = $("#liuyan").val();
		//判断
		if(comment.length==0){
			alert("评论内容不能为空！");
			return ;
		}
		comment=window.encodeURIComponent(comment); //解析特殊字符，防止后台无法解析
		var parameter ="infoId="+infoId+ "&userId=" + userId+ "&comment=" + comment + "&cmd=comment";
		$.post(commentUrl, parameter, function(response) {
			if(response==0){//未登录
				window.location = path+"jsps/user/log.jsp";
			}else if(response==1){
				window.location = path+"articleServlet?infoId="+infoId;
			}else{
				alert("评论失败！");
			}
		});
	});
	
}
