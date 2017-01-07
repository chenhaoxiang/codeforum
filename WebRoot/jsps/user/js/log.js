userNameUrl=getRootPath_web()+"/user"; //请求验证用户名的页面
regUrl = getRootPath_web()+"/user";//登录的页面
var returnUserNameOk; // 验证用户名是否存在
//returnUserNameOk ---返回的用户名是否已经存在 
// userNameRepeat 表示用户名存在  
// userNameOk 表示用户名不存在


window.onload = function() {
	//监听用户名的输入-获得焦点
	$("#name").focus(function() {
		$("#spanDiv").html("");
	});
	
	//监听用户名-失去焦点
	$("#name").blur(function() {
		var username = $("#name").val();
		//发送ajax请求，判断用户名是否存在
		if(username.length >= 1 && username.length <= 32) {
			sendUserName(username);
		}

		if(username.length < 1 || username.length > 32) {
			$("#spanDiv").html("用户名长度应在1-32之间");
			$("#spanDiv").css({"color": "red"});
		} else if(returnUserNameOk == "userNameOk") {
			$("#spanDiv").html("用户名不存在！");
			$("#spanDiv").css({"color": "red"});
		}
	});
	
	//点击登录按钮
	$("#submit").click(function() {
		//获取用户名
		var name = $("#name").val();
		if(name.length < 1 || name.length > 32) { //验证用户名
			$("#spanDiv").html("用户名长度应在0-32之间");
			$("#spanDiv").css({"color": "red"});
		}else if(returnUserNameOk == "userNameOk") {
			$("#spanDiv").html("用户名不存在！");
			$("#spanDiv").css({"color": "red"});
		}else {
			userLog();
		}
	});

}

function sendUserName(name) {
	$.post(userNameUrl, "name=" + name+"&cmd=val", function(response) {
		if(response == "userNameOk") {
			$("#spanDiv").html("用户名不存在！");
			$("#spanDiv").css({"color": "red"});
		}
		returnUserNameOk = response;
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

// 登录   /user/log
function userLog() {
	var name = $("#name").val();
	var password = $("#password").val();
	var parameter = "name=" + name+ "&password=" + password + "&cmd=log";

	$.post(regUrl, parameter, function(msg) {
		//alert(msg);
		if(msg == 0) {
			//成功，跳到首页
			window.location.href = getRootPath_web();
		} else if(msg == "-1") { //失败
			alert("密码错误，登录失败！");
			//跳到失败页面
			//window.location.href = getRootPath_web() + "/log/logError";
		}else {
			window.location.href = getRootPath_web() +"/articleServlet?infoId="+msg ;
		}
	});
}