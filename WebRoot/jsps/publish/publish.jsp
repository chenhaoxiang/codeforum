<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>发表帖子</title>
		<script type="text/javascript">
			var userId = "${sessionScope.user.id}";
		</script>
		<script type="text/javascript" src='<c:url value="/jsps/user/js/jquery-3.1.0.js"></c:url>' ></script>
		<script type="text/javascript" src='<c:url value="/jsps/publish/js/publish.js"></c:url>' ></script>
		<link rel="stylesheet" href='<c:url value="/jsps/publish/css/publish.css"></c:url>' />
	</head>
	<body>
		<div>
			<!-- 导入头 -->
			<jsp:include page="/userLog.jsp" flush="true"/>
		</div>
		<div>
		标题:<textarea name="title" id="title"></textarea>
		</div>
		<!--
        	作者：chenhaoxiang@chaojijuhui.com
        	时间：2017-01-07
        	描述：帖子正文
        -->
       	 正文:<br/>
		<textarea name="main" id="main"></textarea>
		<br/>
		<div>
			<button id="submit" name="submit"> 发表文章 </button>
		</div>
	</body>
</html>
