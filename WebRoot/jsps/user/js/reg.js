userNameUrl=getRootPath_web()+"/user"; //请求验证用户名的页面
regUrl = getRootPath_web()+"/user";//注册的页面
var returnUserNameOk; // 验证用户名是否存在
//returnUserNameOk ---返回的用户名是否已经存在 
// userNameRepeat 表示用户名已经存在  
// userNameOk 表示用户名可以使用

window.onload = function() {
	//监听用户名的输入-获得焦点
	$("#name").focus(function() {
		returnUserNameOk="";
		$("#spanDiv").html("");
	});
	
	
	//监听第一次密码的输入-获得焦点
	$("#password").focus(function() {
		$("#spanPwd").html("");
	});

	//监听第二次密码的输入-获得焦点
	$("#password2").focus(function() {
		$("#spanPwd2").html("");
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
		} else if(returnUserNameOk == "userNameRepeat") {
			$("#spanDiv").html("用户名已存在！");
			$("#spanDiv").css({"color": "red"});
		}
	});
	
	//监听第一次密码-失去焦点
	$("#password").blur(function() {
		var pwd = $("#password").val();
		if(pwd.length<3){
			$("#spanPwd").html("密码太短");
			$("#spanPwd").css({"color": "red"});
		}
	});

	//监听第二次密码-失去焦点
	$("#password2").blur(function() {
		var pwd = $("#password2").val();
		if(pwd != $("#password").val() ) {
			$("#spanPwd2").html("两次输入的密码不同");
			$("#spanPwd2").css({"color": "red"});
		}
	});
	
	//点击注册按钮
	$("#submit").click(function() {
		//获取用户名
		var name = $("#name").val();
		if(name.length < 1 || name.length > 32) { //验证用户名
			$("#spanDiv").html("用户名长度应在0-32之间");
			$("#spanDiv").css({"color": "red"});
		}else if(returnUserNameOk == "userNameRepeat") {
			$("#spanDiv").html("用户名已存在！");
			$("#spanDiv").css({"color": "red"});
		}else if($("#password").val() != $("#password2").val()) {
			$("#spanPwd2").html("两次输入的密码不同");
			$("#spanPwd2").css({"color": "red"});
		}else if($("#password").val().length<3){
			$("#spanPwd").html("密码太短");
			$("#spanPwd").css({"color": "red"});
		}else {
			userReg();
		}
	});

}

function sendUserName(name) {
	$.post(userNameUrl, "name=" + name+"&cmd=val", function(response) {
		if(response == "userNameRepeat") {
			$("#spanDiv").html("用户名已存在！");
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

// 注册   /user/reg
function userReg() {
	//$("#test").html("前去注册...");
	
	var name = $("#name").val();
	var age = $("#age").val();
	var profession = $("#profession").val();//职业
	var love = $("#love").val();
	var password = $("#password").val();
	var sex = $("input[name='sex']:checked").val();

	var parameter = "cmd=reg&name=" + name + "&age=" + age + "&profession=" + profession 
					+ "&love=" + love+"&password=" + password 
					+"&sex=" + sex ;
	//alert("去注册..."+parameter);	
	$.post(regUrl, parameter, function(msg) {
		if(msg == 1) {
			//跳到成功
			window.location.href = getRootPath_web() + "/jsps/user/log.jsp";
		} else if(msg == 0) { //失败
			//跳到失败页面
			alert("注册失败，请重新注册！！！");
		}
	});
}