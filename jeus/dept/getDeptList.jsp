<%@page import="vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="dc" class="mvc.DeptController" scope="page" />
<jsp:useBean id="vo" class="vo.DeptVO" scope="page"></jsp:useBean>
<%
	List<DeptVO> list = (List<DeptVO>) request.getAttribute("list");
	int size = 0;
	if (list != null) {
		size = list.size();
		vo = list.get(0);
	} else {

	}
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>"jeus/dept/getDeptList.jsp"</title>
<link rel="stylesheet" type="text/css" href="board.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src=".js"></script>
<script type="text/javascript"></script>
</head>
<body>
	"jeus/dept/getDeptList.jsp"
	<br>
	<%=size%>
	도서목록
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>지역</th>
		</tr>
		<%
			for (DeptVO dvo : list) {
		%>
		<tr>
			<td><%=dvo.getDeptno()%></td>
			<td><%=dvo.getDname()%></td>
			<td><%=dvo.getLoc()%></td>
		</tr>
		<%
			}
		%>
	</table>




</body>
</html>