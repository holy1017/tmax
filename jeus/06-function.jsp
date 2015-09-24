<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="date"  uri="/WEB-INF/tld/ELfunction.tld"%>    
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="image/icon.png" />
		<link rel="apple-touch-icon" href="image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<![endif]-->

<title>EL 함수</title>
</head>
<body>
	<%
		Date today = new Date();
		request.setAttribute("now", today);
		if(session.isNew()) session.setAttribute("now", today);
	%>
	<h3> EL 함수 예제</h3>
	[Refresh]하면 현재 시간 : ${date:format(now)} <p>
	처음 접속한 시간 : ${date:format(sessionScope.now) }<p>
</body>
</html>