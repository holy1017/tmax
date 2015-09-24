<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String id = (String) session.getAttribute("id");
	String name = (String) session.getAttribute("name");
%>
<%-- <%response.sendRedirect("login.jsp");%> --%>
<script type="text/javascript">
$(document).ready(function() {
	$("#btlogout").click(function() {
		var para = $("#formlogout").serialize()
		$.ajax({
			type : "post",
			url : "login.jsp",
			data : para,
			success : function(data) {
				$("#login").html(data)
			},
			error : function(data, status) {
				alert("error1:" + status)
			}
		})
	})
})
</script>
<div id="id">	id:<%=id%></div>
<div id="id">	name:<%=name%></div>
<form id="formlogout" action="login.jsp">
	<input type="hidden" name="state" value="logout" /> 
	<input type="button" value="·Î±×¾Æ¿ô" id="btlogout" />
</form>