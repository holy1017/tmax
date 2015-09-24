<%@page import="java.util.Enumeration"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@page import="db.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	DbConnection db = DbConnection.getDbConnection();
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	String name = null;
	StringBuilder sb = new StringBuilder();

	try {
		con = db.getConnection("scott", "test1234");
		sb.append("SELECT mem_name FROM AJAX_MEMBER where mem_id=? and mem_pw=?");
		st = con.prepareStatement(sb.toString());
		st.setString(1, id);
		st.setString(2, pw);
		rs = st.executeQuery();
		//		System.out.println(rs.getRow());
		if (rs.next()) {
			name = rs.getString("mem_name");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		out.print("SQLException:" + sb.toString());
	} catch (Exception e) {
		e.printStackTrace();
		out.print("Exception:" + e.getMessage());
	}
	if (name != null) {
		session.setAttribute("id", id);
		session.setAttribute("name", name);
%>
<jsp:include page="logout.jsp" flush="false"></jsp:include>
<%
	} else {
%>
<jsp:include page="login.jsp" flush="false">
	<jsp:param name="state" value="false" />
</jsp:include>
<%
	}
%>