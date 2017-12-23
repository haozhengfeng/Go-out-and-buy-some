<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
首页
<c:choose>
	<c:when test="${empty sessionScope._SESSION_MEMBER_ID_ }">
		<button onclick="window.location.href='member/toLogin' ">登录</button>
	</c:when>
	<c:otherwise>
		${sessionScope._SESSION_MEMBER_.name }<button onclick="window.location.href='member/logout' ">退出</button>
	</c:otherwise>
</c:choose>
</body>
</html>