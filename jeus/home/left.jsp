<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script type="text/javascript">
	/* $(document).ready(function() {
		var para = "action=loginchack.jsp&method=post";
		$.ajax({
			type : "get",
			url : "login.jsp",
			success : function(data) {
				$("#login").html(data)
			}
		})
	}) */
</script>
<table id="left">
	<!-- width="100%" height="100%" -->
	<!-- border="1" borderColor="red" width="100%" height="100%" -->
	<!-- login -->

	<tr>
		<td id="login" valign="top">
			<%
				String id=(String)session.getAttribute("id");
			if(id==null){
			%> 
			<jsp:include page="login.jsp" flush="false"></jsp:include> 
			<%
			}else{
 			%>
 			<jsp:include page="logout.jsp" flush="false"></jsp:include> 
 			<%
			}
 			%>
		</td>
		<%-- <%@include file="login.jsp"%> --%>

	</tr>

	<!-- menu -->
	<tr>
		<td id="menu"><jsp:include page="menu.jsp" flush="false"></jsp:include></td>
	</tr>
</table>
