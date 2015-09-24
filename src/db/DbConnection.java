package db;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

public class DbConnection {

	private static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String _URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private static String _ID = "scott";
	private static String _PW = "test1234";

	private static DbConnection dbc = null;

	/**
	 * @param _ID
	 * @param _PW
	 * @return
	 */

	public static DbConnection getDbConnection(String _ID, String _PW) {
		// TODO Auto-generated constructor stub
		if (dbc == null) {
			synchronized (DbConnection.class) {
				if (dbc == null) {
					dbc = new DbConnection();
				}
			}
		}
		DbConnection._ID = _ID;
		DbConnection._PW = _PW;
		return dbc;
	}

	public static DbConnection getDbConnection() {
		// TODO Auto-generated constructor stub
		if (dbc == null) {
			synchronized (DbConnection.class) {
				if (dbc == null) {
					dbc = new DbConnection();
				}
			}
		}
		return dbc;
	}

	public Connection getConnection() {
		Connection cnt = null;
		try {
			Class.forName(_DRIVER);
			cnt = DriverManager.getConnection(_URL, _ID, _PW);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}

	public Connection getConnection(String id, String pw) {
		Connection cnt = null;
		try {
			Class.forName(_DRIVER);
			cnt = DriverManager.getConnection(_URL, id, pw);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}

	public Connection getConnection(String url, String id, String pw) {
		Connection cnt = null;
		try {
			Class.forName(_DRIVER);
			cnt = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}

	public Statement getStatement(Connection cnt) {
		Statement st = null;
		// LoggableStatement stmt = new LoggableStatement(cnt,
		// BOARD_SEARCHLIST);
		try {
			st = cnt.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	public void CloseConnection(Connection cnt, Statement st) {
		CloseConnection(cnt, st, null);
	}

	public void CloseConnection(Connection cnt, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (cnt != null)
				cnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CloseConnection(Connection cnt, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (cnt != null)
				cnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CloseConnection(Connection cnt, PreparedStatement pst) {
		CloseConnection(cnt, pst, null);
	}

	public Connection getConnectioPool() {
		// TODO Auto-generated constructor stub
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("hyPool");
			con = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public String getResultSql(String sql) {
		return getResultSql(sql, _ID, _PW, null);
	}

	public String getResultSql(String sql, String id, String pw) {
		return getResultSql(sql, id, pw, null);
	}

	public String getResultSql(String sql, String id, String pw, String type) {
		try {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			ResultSetMetaData rsmd = null;
			int colCount = 0;

			DbConnection db = DbConnection.getDbConnection();
			// con = db.getConnection("javauser", "java1234");
			con = db.getConnection(id, pw);

			// StringBuilder sql = new StringBuilder();
			// // String sql="SELECT mem_name FROM AJAX_MEMBER ";//where
			// mem_id=?
			// // and mem_pw=?
			// sql.append("");
			// sql.append("SELECT ");
			// sql.append("NO, SD_NUM, SD_NAME, ");
			// sql.append(" SD_ID, SD_PASSWD, S_NUM, ");
			// sql.append(" SD_BIRTH, SD_PHONE, SD_ADDRESS,");
			// sql.append(" SD_EMAIL, SD_DATE ");
			// sql.append("FROM JAVAUSER.STUDENT ");

			st = con.prepareStatement(sql);// .toString()
			rs = st.executeQuery();
			rsmd = rs.getMetaData();
			colCount = rsmd.getColumnCount();

			StringBuilder data = new StringBuilder();

			if ("all".equals(type)) {
				data.append("<table>");

				data.append("<tr>");
				for (int i = 1; i <= colCount; i++) {
					data.append("<th>" + rsmd.getColumnName(i) + "</th>");
				}
				data.append("</tr>");
			}

			while (rs.next()) {
				data.append("<tr>");
				for (int i = 1; i <= colCount; i++) {
					data.append("<td>" + rs.getObject(i) + "</td>");
				}
				data.append("</tr>");
			}

			if ("all".equals(type))
				data.append("</table>");

			// System.out.println(data.toString());
			return data.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static void main(String[] args) {
		/*
		 * String id = "test"; String pw = "test1234"; DbConnection db =
		 * DbConnection.getDbConnection(); Connection con = null;
		 * PreparedStatement st = null; ResultSet rs = null; StringBuilder sb =
		 * new StringBuilder(); sb.append(
		 * "SELECT mem_name FROM AJAX_MEMBER where mem_id=? and mem_pw=?"); try
		 * { con = db.getConnectioPool(); st =
		 * con.prepareStatement(sb.toString()); st.setString(1, id);
		 * st.setString(2, pw); rs = st.executeQuery(); //
		 * System.out.println(rs.getRow()); rs.next(); String name =
		 * rs.getString("mem_name"); System.out.print("이름:" + name); } catch
		 * (SQLException e) { e.printStackTrace();
		 * System.out.print("SQLException:" + sb.toString()); } catch (Exception
		 * e) { e.printStackTrace(); }
		 */
		try {
			Connection con = null;
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

			StringBuilder data = new StringBuilder();
			data.append("<table>");
			data.append("<tr>");
			for (int i = 1; i <= colCount; i++) {
				data.append("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			data.append("</tr>");
			while (rs.next()) {
				data.append("<tr>");
				for (int i = 1; i <= colCount; i++) {
					data.append("<td>" + rs.getObject(i) + "</td>");
				}
				data.append("</tr>");
			}
			data.append("</table>");
			System.out.println(data.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
