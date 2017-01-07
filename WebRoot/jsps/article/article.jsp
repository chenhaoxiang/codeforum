<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var userId="${sessionScope.user.id}";//获取EL表达式中的值
	var infoId="${sessionScope.article.id}";
	var path = "<c:url value='/'/>";
</script>
<script type="text/javascript" src='<c:url value="/jsps/article/js/article.js"></c:url>'></script>
<script src='<c:url value="/jsps/user/js/jquery-3.1.0.js"></c:url>' type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/jsps/article/css/article.css"></c:url>' />
</head>
<body>
	<!-- 导入头 -->
	<jsp:include page="/userLog.jsp" flush="true"/>
	
	<br />
	<br />
	<div class="title">
		${sessionScope.article.title} <br /> <span class="titlespan">
			——作者:${sessionScope.article.name}&nbsp;&nbsp;发表时间：${sessionScope.articleTime}&nbsp;&nbsp;阅读量：${sessionScope.article.readNum}
		</span>
	</div>
	<br />
	<br />
	<br />
	<div class="message">${sessionScope.article.message}</div>
	<br />
	<div>
		我要评论:<br />
		<textarea name="liuyan" id="liuyan"></textarea>
		<button id="submit" name="submit">评论</button>
	</div>

	<div class="reply">
		<c:forEach items="${sessionScope.replys.datas}" var="data">
			<div class="replymsg">
				评论者:${data.name} &nbsp;&nbsp;积分:${data.integral
				}&nbsp;&nbsp;时间:${data.time }&nbsp;&nbsp;IP:${data.ip } <br />
				<div>${data.message}</div>
			</div>
		</c:forEach>
	</div>
	<c:if
		test="${sessionScope.replys.currentPage!=1&&sessionScope.replys.pageCount!=0}">
		<span class="pc"> <a
			href='<c:url value="/articleServlet?page=${sessionScope.replys.currentPage-1}&infoId=${sessionScope.article.id}"></c:url>'>上一页</a>
		</span>
	</c:if>
	&nbsp;&nbsp;
	<c:forEach begin="1" end="${sessionScope.replys.pageCount}" var="idx">
		<c:if test="${idx==sessionScope.replys.currentPage}" var="isNow">
			<span class=now>${idx}</span>
		</c:if>
		<c:if test="${!isNow }">
			<span class="pc"> <a
				href='<c:url value="/articleServlet?page=${idx}&infoId=${sessionScope.article.id}"></c:url>'>${idx}</a>
			</span>
		</c:if>
        &nbsp;&nbsp;
    </c:forEach>

	<c:if
		test="${sessionScope.replys.currentPage!=sessionScope.replys.pageCount&&sessionScope.replys.pageCount!=0}">
		<span class="pc"> <a
			href="<c:url value='/articleServlet?page=${sessionScope.replys.currentPage+1}&infoId=${sessionScope.article.id}'></c:url>">下一页</a>
		</span>
	</c:if>
</body>
</html>
