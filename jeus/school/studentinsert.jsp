<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DbConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Enumeration"%>
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
	<table>
		<tr>
			<td></td>
		</tr>
	</table>
	<%
		Enumeration<String> en = request.getParameterNames();
		out.println("<table>");
		while (en.hasMoreElements()) {
			String t = en.nextElement();
			out.println("<tr>");
			out.println("<td>" + t + "</td>");
			out.println("<td>" + request.getParameter(t) + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");

		DbConnection db = DbConnection.getDbConnection("javauser", "java1234");
		Connection con = db.getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("");//
		sql.append("INSERT INTO STUDENT (SD_NUM,");// 
		sql.append("        SD_NAME,            ");// 
		sql.append("        SD_ID,              ");// 
		sql.append("        SD_PASSWD,          ");// 
		sql.append("        S_NUM,              ");// 
		sql.append("        SD_BIRTH,           ");// 
		sql.append("        SD_PHONE,           ");// 
		sql.append("        SD_EMAIL,         ");// 
		sql.append("        SD_ADDRESS)           ");// 
		sql.append("VALUES (?,");// :SD_NUM,
		sql.append("        ?,");// :SD_NAME,
		sql.append("        ?,");// :SD_ID,
		sql.append("        ?,");// :SD_PASSWD,
		sql.append("        ?,");// :S_NUM,
		sql.append("        ?,");// :SD_BIRTH,
		sql.append("        ?,");// :SD_PHONE,
		sql.append("        ?,");// :SD_ADDRESS,
		sql.append("        ?)");// :SD_EMAIL)

		PreparedStatement ps = con.prepareStatement(sql.toString());

		int i = 0;
		ps.setString(++i, request.getParameter("num"));//	143
		ps.setString(++i, request.getParameter("name"));//	125151
		ps.setString(++i, request.getParameter("id"));//	test
		ps.setString(++i, request.getParameter("pass"));//	test1234
		ps.setString(++i, request.getParameter("snum"));//	1434
		ps.setString(++i, request.getParameter("birth").replaceAll("\\D", ""));//	2015-09-08
		ps.setString(++i, request.getParameter("tel"));//	12515
		ps.setString(++i, request.getParameter("email"));//	2341415
		ps.setString(++i, request.getParameter("address"));//	1244

		int r = ps.executeUpdate();

		if (r == 1) {
			out.println("insert ok");
			//response.sendRedirect("students.jsp");
	%>
	
	<%
		} else {
			out.println("insert errer");
			//response.sendRedirect("students.jsp");
	%>
	<%-- <%@ include file="students.jsp"%> --%>
	<%
		}
	%>
	<%-- <%@ include file="students.jsp"%> --%>
	<jsp:include page="students.jsp" flush="true"></jsp:include>
</body>
</html>