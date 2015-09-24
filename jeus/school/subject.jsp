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
		/* try {
			Connection con=null;
			PreparedStatement st = null;
			ResultSet rs = null;
			ResultSetMetaData rsmd = null;
			int colCount = 0;
			
			DbConnection db = DbConnection.getDbConnection();
			con = db.getConnection("javauser", "java1234");
			
			StringBuilder sql = new StringBuilder();
			// String sql="SELECT mem_name FROM AJAX_MEMBER ";//where mem_id=?
			// and mem_pw=?
			sql.append("");
			sql.append("SELECT                            ");
			sql.append("NO, SD_NUM, SD_NAME,              ");
			sql.append("   SD_ID, SD_PASSWD, S_NUM,       ");
			sql.append("   SD_BIRTH, SD_PHONE, SD_ADDRESS,");
			sql.append("   SD_EMAIL, SD_DATE              ");
			sql.append("FROM JAVAUSER.STUDENT            ");
		
			st = con.prepareStatement(sql.toString());
			rs = st.executeQuery();
			rsmd = rs.getMetaData();
			colCount = rsmd.getColumnCount();
			out.println("<table>");
			out.println("<tr>");
			for (int i = 1; i <= colCount; i++) {
				out.println("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				for (int i = 1; i <= colCount; i++) {
					out.println("<td>" + rs.getObject(i) + "</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  */
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("NO, S_NUM, S_NAME ");
		sql.append("FROM JAVAUSER.SUBJECT");
		
		DbConnection db = DbConnection.getDbConnection();
		out.println(db.getResultSql(sql.toString(),"javauser", "java1234"));
	%>
</body>
</html>