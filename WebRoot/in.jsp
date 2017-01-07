<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>城院论坛</title>
		<meta charset="UTF-8" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
	</head>
	<body>
		<!-- 导入头 -->
		<jsp:include page="/userLog.jsp" flush="true"/>
		
		<div class="divhot">
			&nbsp;&nbsp;&nbsp;&nbsp;火热的帖子:
			<c:forEach items="${sessionScope.infoHots}" var="infoHot">
				<div class="tiezi">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="articleServlet?infoId=${infoHot.id}">${infoHot.title}</a>
				<span class="tiezi_p">
					&nbsp;&nbsp;—作者:${infoHot.name}&nbsp;&nbsp;阅读量：${infoHot.readNum}
				</span>
			</div>
			</c:forEach>
		</div>
		<div class="divleft">
			所有帖子:
			<c:forEach items="${sessionScope.infoAlls.datas}" var="data">
				<div class="tiezi">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="articleServlet?infoId=${data.id}">${data.title}</a>
				<span class="tiezi_p">
					&nbsp;&nbsp;—作者:${data.name}&nbsp;&nbsp;阅读量：${data.readNum}
				</span>
			</div>
			</c:forEach>
		</div>
		
	<c:if test="${sessionScope.infoAlls.currentPage!=1&&sessionScope.infoAlls.pageCount!=0}">
        <span class="pc">
            <a href='<c:url value="/IndexServlet?page=${sessionScope.infoAlls.currentPage-1}"></c:url>'>上一页</a>
        </span>
    </c:if>
    &nbsp;&nbsp;
    <c:forEach begin="1" end="${sessionScope.infoAlls.pageCount}" var="idx">
        <c:if test="${idx==sessionScope.infoAlls.currentPage}" var="isNow">
            <span class=now>${idx}</span>
        </c:if>
        <c:if test="${!isNow }">
            <span class="pc">
                <a href='<c:url value="/IndexServlet?page=${idx}"></c:url>'>${idx}</a>
            </span>
        </c:if>
        &nbsp;&nbsp;
    </c:forEach>

    <c:if test="${sessionScope.infoAlls.currentPage!=sessionScope.infoAlls.pageCount&&sessionScope.infoAlls.pageCount!=0}">
        <span class="pc">
            <a href="<c:url value='/IndexServlet?page=${sessionScope.infoAlls.currentPage+1}'></c:url>">下一页</a>
        </span>
    </c:if>
    <br/><br/>
		
	</body>

</html>