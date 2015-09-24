<%@page import="java.sql.*"%>
<%@page import="db.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	<%
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                            ");
		sql.append("NO, SD_NUM, SD_NAME,              ");
		sql.append("   SD_ID, SD_PASSWD, S_NUM,       ");
		sql.append("   SD_BIRTH, SD_PHONE, SD_ADDRESS,");
		sql.append("   SD_EMAIL, SD_DATE              ");
		sql.append("FROM JAVAUSER.STUDENT            ");
		
		DbConnection db = DbConnection.getDbConnection();
		out.println(db.getResultSql(sql.toString(),"javauser", "java1234"));
	%>
</body>
</html>