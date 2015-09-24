<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String menu = request.getParameter("memu");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main</title>
<LINK REL="stylesheet" TYPE="text/css" HREF="home.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="home.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* 		var para = "action=&method=";
		 $.ajax({
		 type : "post",
		 url : "login.jsp",
		 success : function(data) {
		 $("#login").html(data)
		 }
		 }) */
		/* $("body *").prepend("-") */
	})
</script>
</head>
<body>
	<table width="900" heigh="530">
		<!-- width="900" heigh="530" -->

		<!-- top -->
		<tr>
			<td colspan="2" width="900" height="80"><jsp:include
					page="top.jsp" flush="false"></jsp:include></td>
		</tr>

		<!-- body -->
		<tr>
			<!-- menu -->
			<td width="250" height="400"><jsp:include page="left.jsp"
					flush="false"></jsp:include></td>
			<!-- main -->
			<td width="650" height="400" id="main">
				<%
					if (menu == null || "main".equals(menu)) {
				%> <jsp:include page="main.jsp" flush="false"></jsp:include> <%
				 	} else if ("board".equals(menu)) {
				 %> <jsp:include page="board.jsp" flush="false"></jsp:include> <%
				 	}
				 %>
			</td>
		</tr>

		<!-- bottom -->
		<tr>
			<td colspan="2" width="900" height="50"><jsp:include
					page="bottom.jsp" flush="false"></jsp:include></td>
		</tr>

	</table>

	<%-- <div id="body">
		<!-- 위쪽 -->
		<header id="top"><jsp:include page="top.jsp" flush="false"></jsp:include></header>

		<!-- 왼쪽 -->
		<aside id="side"><jsp:include page="left.jsp" flush="false"></jsp:include></aside>

		<!-- 메인 -->
		<section id="main"><jsp:include page="main.jsp"
				flush="false"></jsp:include></section>

		<!-- 아래 -->
		<footer id="bottom"><jsp:include page="bottom.jsp"
				flush="false"></jsp:include></footer>
	</div> --%>
</body>
</html>