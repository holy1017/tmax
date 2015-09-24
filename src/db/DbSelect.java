package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class DbSelect {
	DbConnection db = DbConnection.getDbConnection();

	Connection cnt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	String col = null;
	String table = null;

	public DbSelect() {
		// TODO Auto-generated constructor stub
	}

	public DbSelect(String table) {
		// TODO Auto-generated constructor stub
		this.table = table;
	}
	/*
	 * public DbUser selectDbUser(DbUser inDU) {
	 * 
	 * // SELECT // ID, PW, NICK // FROM CHAT_USER // WHERE ID = ?; return inDU;
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * public DbUser[] selectAllDbUser(DbUser inDU) { StringBuilder sb_sql = new
	 * StringBuilder(); sb_sql.append("SELECT           "); sb_sql.append(
	 * "ID, PW, NICK     "); sb_sql.append("FROM CHAT_USER   "); //
	 * sb_sql.append("WHERE  ID   = ?; "); DbUser[] uss = null; try { cnt =
	 * db.getConnection(); pst = cnt.prepareStatement(sb_sql.toString()); rs =
	 * pst.executeQuery(); Vector<DbUser> v = new Vector<>(); DbUser us; while
	 * (rs.next()) { us = new DbUser(); us.setId(rs.getString("id"));
	 * us.setPw(rs.getString("pw")); us.setNick(rs.getString("nick"));
	 * v.add(us); } uss = new DbUser[v.size()]; v.copyInto(uss);
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } finally {
	 * db.CloseConnection(cnt, pst, rs); } return uss; // TODO Auto-generated
	 * method stub }
	 */

	public Object[] selectAllObject(Object obj) {
		StringBuilder sb_sql = new StringBuilder();
		sb_sql.append(" SELECT           ");
		sb_sql.append(col);
		sb_sql.append(" FROM " + table);
		// sb_sql.append("WHERE ID = ?; ");
		return null;
	}

	/**
	 * �뺤긽 �묐룞 �앹꽦���낅젰���뚯씠釉�紐낆쑝濡�議고쉶
	 * 
	 * @param col
	 * @return �뚯씠釉붾챸��吏�젙 �덈맟�꾧꼍����諛섑솚.
	 */
	public Vector<Vector<Object>> selectAllVector(Vector<String> col) {
		return table != null ? selectAllVector(col, table) : null;
	}

	/**
	 * �뺤긽 �묐룞
	 * 
	 * @param col
	 *            吏�젙��移쇰읆留�異쒕젰.
	 * @param table
	 * @return
	 */
	public Vector<Vector<Object>> selectAllVector(Vector<String> col, String table) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < col.size() - 1; i++) {
			sb.append(col.get(i) + ",");
		}
		sb.append(col.get(col.size() - 1));
		// for (String string : col) {
		// sb.append(string);
		// }
		return selectAllVector(sb.toString(), table);
		// System.out.println(sb.toString());
		/*
		 * StringBuilder sb_sql = new StringBuilder(); sb_sql.append(
		 * "SELECT           "); sb_sql.append(sb.toString()); sb_sql.append(
		 * " FROM " + table); // sb_sql.append("WHERE  ID   = ?; "); // Object[]
		 * objs = null;
		 * 
		 * try { cnt = db.getConnection();
		 * st=cnt.prepareStatement(sb_sql.toString()); rs=st.executeQuery();
		 * ResultSetMetaData rsmd = rs.getMetaData();
		 * 
		 * int colCount = rsmd.getColumnCount(); // for (int i = 1; i <=
		 * colCount; i++) { // System.out.print(rsmd.getColumnName(i) + "\t");
		 * // } Vector<Vector<Object>> vv=new Vector<>(); while (rs.next()) {
		 * Vector<Object> v=new Vector<>(); for (int i = 1; i <= colCount; i++)
		 * { v.add(rs.getObject(i)); } // Object[] obj=new Object[colCount]; //
		 * v.copyInto(obj);
		 * 
		 * vv.add(v); } // Object[][] objs=null; // Object[][] objs=new
		 * Object[vv.size()][colCount]; // vv.copyInto(objs); return vv; } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); return null; }
		 */
		// return objs;

	}

	/**
	 * �뺤긽 �묐룞/
	 * 
	 * @param col
	 *            吏�젙��移쇰읆留�異쒕젰 ex) "id,pw,nick"
	 * @param table
	 * @return
	 */
	public Vector<Vector<Object>> selectAllVector(String col, String table) {

		System.out.println(col);

		StringBuilder sb_sql = new StringBuilder();
		sb_sql.append("SELECT           ");
		sb_sql.append(col);
		sb_sql.append(" FROM " + table);
		// sb_sql.append("WHERE ID = ?; ");
		// Object[] objs = null;

		try {
			cnt = db.getConnection();
			pst = cnt.prepareStatement(sb_sql.toString());
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			// for (int i = 1; i <= colCount; i++) {
			// System.out.print(rsmd.getColumnName(i) + "\t");
			// }
			Vector<Vector<Object>> vv = new Vector<>();
			while (rs.next()) {
				Vector<Object> v = new Vector<>();
				for (int i = 1; i <= colCount; i++) {
					v.add(rs.getObject(i));
				}
				// Object[] obj=new Object[colCount];
				// v.copyInto(obj);
				vv.add(v);
			}
			// Object[][] objs=null;
			// Object[][] objs=new Object[vv.size()][colCount];
			// vv.copyInto(objs);
			return vv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// return objs;
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}

	}

	/**
	 * �묐룞 �덈맖
	 * 
	 * @param col
	 * @param table
	 * @return
	 */
	public Object[][] selectAllObject(String col, String table) {
		StringBuilder sb_sql = new StringBuilder();
		sb_sql.append("SELECT           ");
		sb_sql.append(col);
		sb_sql.append(" FROM " + table);
		// sb_sql.append("WHERE ID = ?; ");
		// Object[] objs = null;

		try {
			cnt = db.getConnection();
			pst = cnt.prepareStatement(sb_sql.toString());
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			// for (int i = 1; i <= colCount; i++) {
			// System.out.print(rsmd.getColumnName(i) + "\t");
			// }
			Vector<Object[]> vv = new Vector<>();
			while (rs.next()) {
				Vector<Object> v = new Vector<>();
				for (int i = 1; i <= colCount; i++) {
					System.out.print(rs.getObject(i) + "\t");
					v.add(rs.getObject(i));
				}
				System.out.println();
				Object[] obj = new Object[colCount];
				v.copyInto(obj);
			}
			// Object[][] objs=null;
			Object[][] objs = new Object[vv.size()][colCount];
			vv.copyInto(objs);
			return objs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// return objs;
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}

	}

	public String select(String col, String where) {
		StringBuilder sb_sql = new StringBuilder();
		sb_sql.append("SELECT           ");
		sb_sql.append(col);
		sb_sql.append(" FROM " + table);
		sb_sql.append(" where " + where);
		// sb_sql.append("WHERE ID = ?; ");
		// Object[] objs = null;

		try {
			cnt = db.getConnection();
			pst = cnt.prepareStatement(sb_sql.toString());
			rs = pst.executeQuery();
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// return objs;
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
		// return null;
	}

	public void selectAllPrint(String col, String table) {
		StringBuilder sb_sql = new StringBuilder();
		sb_sql.append("SELECT           ");
		sb_sql.append(col);
		sb_sql.append(" FROM " + table);
		// sb_sql.append("WHERE ID = ?; ");
		// Object[] objs = null;

		try {
			cnt = db.getConnection();
			pst = cnt.prepareStatement(sb_sql.toString());
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			for (int i = 1; i <= colCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			while (rs.next()) {

				for (int i = 1; i <= colCount; i++) {
					System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DbSelect db = new DbSelect();
		db.selectAllPrint("*","ajax_member"	);
	}
}
