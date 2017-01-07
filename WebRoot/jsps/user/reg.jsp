<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>城院论坛注册</title>
		<meta charset="UTF-8"/>
		<script src='<c:url value="/jsps/user/js/reg.js"></c:url>' type="text/javascript" charset="utf-8"></script>
		<script src='<c:url value="/jsps/user/js/jquery-3.1.0.js"></c:url>' type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href='<c:url value="/jsps/user/css/reg.css"></c:url>'/>
	</head>
	<body>
		<h1><a href="<c:url value='/IndexServlet'/>">城院论坛</a>注册</h1>
		<form method="post" class="form">
			<div class="formDiv">
			昵称:<input type="text" name="name" id="name" value="" />
			<span class="spanDiv" id="spanDiv"></span>
			</div>
			<div class="formDiv">
			年龄:<input type="text" name="age" id="age" />
			</div>
			<div class="formDiv">
			职业:<input type="text" name="profession" id="profession" />
			</div>
			<div class="formDiv">
			爱好:<input type="text" name="love" id="love" />
			</div>
			<div class="formDiv">
			密码:<input type="password" name="password" id="password" />
			<span class="spanPwd" id="spanPwd"></span>
			</div>
			<div class="formDiv">
			确认密码:<input type="password" name="password2" id="password2" />
			<span class="spanPwd2" id="spanPwd2"></span>
			</div>
			<div class="formDiv">
			性别:<input type="radio" name="sex" id="sex" checked="checked" value="1"/>男 &nbsp;
				<input type="radio" name="sex" id="sex" value="0"/>女 &nbsp;
			</div>
			<div class="formDiv">
				<input type="button" class="submit" id="submit" value="注册"/>
			</div>
			<div class="formDiv">
				<a href='<c:url value="/jsps/user/log.jsp"></c:url>'><input type="button" class="hava" id="hava" value="已有账号?"/></a>
				<a href=""><input type="button" class="forget" id="forget" value="忘记密码?"/></a>
			</div>
		</form>
	</body>
</html>