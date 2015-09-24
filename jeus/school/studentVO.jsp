<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.StudentDAO" scope="page"></jsp:useBean>
<jsp:useBean id="vo" class="com.StudentVO" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>JSP 예제 student.jsp</title>

		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="./image/icon.png" />
		<link rel="apple-touch-icon" href="./image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--[if lt IE 9]>
		<script src="./js/html5shiv.js"></script>
		<![endif]-->
	</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:setProperty name="vo" property = "*"/>
	<%
	int rowCount = dao.StudentInsert(vo);
	if(rowCount == 1){
	%>
	<script type="text/javascript">
	alert("학생정보를 등록완료 되었습니다. ");
	location.href="students.jsp";
	</script>
	<%
		}else{
	%>
	<script type="text/javascript">
	alert("학생정보 등록 시 문제가 발생하여 등록 완료하지 못하였습니다.");
	history.go(-1);
	</script>
	<%
		}
	%>
</body>
</html>