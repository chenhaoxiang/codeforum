<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>城院论坛登录</title>
		<meta charset="UTF-8"/>
		<script src='<c:url value="/jsps/user/js/log.js"></c:url>' type="text/javascript" charset="utf-8"></script>
		<script src='<c:url value="/jsps/user/js/jquery-3.1.0.js"></c:url>' type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href='<c:url value="/jsps/user/css/reg.css"></c:url>'/>
	</head>
	<body>
		<h1><a href="<c:url value='/IndexServlet'/>">城院论坛</a>登录</h1>
		<form action="" method="post" class="form">
			<div class="formDiv">
			昵称:<input type="text" name="name" id="name" value="" />
			<span class="spanDiv" id="spanDiv"></span>
			</div>
			<div class="formDiv">
			密码:<input type="password" name="password" id="password" />
			</div>
			<div class="formDiv">
				<input type="button" class="submit" id="submit" value="登录"/>
			</div>
			<div class="formDiv">
				<a href='<c:url value="/jsps/user/reg.jsp"></c:url>'><input type="button" class="hava" id="hava" value="没有账号?"/></a>
				<a href=""><input type="button" class="forget" id="forget" value="忘记密码?"/></a>
			</div>
		</form>
	</body>
</html>
