<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
	<a href='<c:url value="/index.jsp"></c:url>'>城院论坛</a>
</h1>
<span class="h1span"> <c:if test="${empty sessionScope.user}"
		var="userIf">
		<span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="jsps/user/log.jsp">登录</a> &nbsp;&nbsp;&nbsp;<a
			href="jsps/user/reg.jsp">注册</a> </span>
	</c:if> <c:if test="${!userIf}">
		<span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			欢迎登录，${sessionScope.user.name} &nbsp;&nbsp;&nbsp; <a
			href='<c:url value="/jsps/publish/publish.jsp"></c:url>'>发表文章</a>
			&nbsp;&nbsp; <a href="<c:url value='/user?cmd=out'></c:url>">退出</a> </span>
	</c:if> </span>
