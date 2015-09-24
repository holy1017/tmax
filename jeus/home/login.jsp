<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String action = request.getParameter("action");
	String method = request.getParameter("method");

	String id = "";
	//try{
	String state = request.getParameter("state");
	if ("logout".equals(state)) {
		session.invalidate();
	}
	if ("false".equals(state)) {
%>
<script type="text/javascript">
	alert("로그인 실패");
</script>
<%
	}
	//if (true) {
%>
<%-- 	if ("false".equals(request.getParameter("login"))) {
		//out.print("실패" );
%>
<script type="text/javascript">
alert("로그인 실패");
</script>
<%
	}
%> --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- <script src="login.js"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginbt").click(function() {
			var para = $("#loginform").serialize();
			// var para = "action=loginchack.jsp&method=post";
			//alert("login.js:"+para)
			$.ajax({
				type : "post",
				/*url : "loginchack.jsp",*/
				url : "logindb.jsp",
				data : para,
				success : function(data) {
					$("#login").html(data)
				},
				error : function(data, status) {
					alert("error:" + status)
				}
			})

		})
	})
</script>
<%-- <form action=<%=action %> method=<%=method %>> --%>
<form action="logindb.jsp" method="post" id="loginform" name="loginform">
	<table>
		<tr>
			<td class="label"><label for="id">아이디</label></td>
			<td class="input"><input type="text" name="id" id="id"
				maxlength="50" placeholder="id" autofocus="autofocus"
				required="required" /></td>
		</tr>
		<tr>
			<td class="label"><label for="pw">비번</label></td>
			<td class="input"><input type="password" name="pw" id="pw"
				placeholder="1~16자리" maxlength="16" required="required" /></td>
		</tr>
		<tr>
			<td class="button" colspan="2"><input type="button" value="로그인"
				id="loginbt" /> <input type="reset" value="다시입력" /></td>
		</tr>
	</table>
</form>
<%-- <%
	} else {
%>
<%=id%>
<from method="post" action="logout.jsp"> <input type="submit"
	value="로그아웃" /> </from>
<%
	}
	/* }catch{
		
	} */
%> --%>