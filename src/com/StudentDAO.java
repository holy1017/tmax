package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
	//데이터베이스 연결 관련 상수 선언
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String JDBC_URL = "jdbc:oracle:thin:@192.168.0.79:1521:orcl11";
	private static final String USER = "javauser";
	private static final String	PASSWD = "java1234";
	
	//데이터베이스 연결 관련 변수 선언
	private Connection con = null;//연결하기 위한 Connection 객체
	private PreparedStatement pstmt = null;
	
	//JDBC 드라이버를 로드하는 생성자
	public StudentDAO(){
		// JDBC 드라이버 로드
		try{
			Class.forName(JDBC_DRIVER);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//데이터베이스 연결 메소드
	public void connect(){
		try {
			//데이터베이스에 연결, Connection 객체 저장
			con = DriverManager.getConnection(JDBC_URL,USER,PASSWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//데이터베이스 연결 해제 메소드
	public void disconnect(){
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<StudentVO> getStudentList(){
		connect();
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select sd_num, sd_name, sd_id, s_num, sd_birth, ");
		sql.append("sd_phone, sd_address, sd_email, sd_date from student");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet의 결과에서 모든 행을 각각의 StudentVO 객체에 저장
			while(rs.next()){
				//한 행의 학생정보를 저장할 학생을 위한 빈즈 객체 생성
				StudentVO vo = new StudentVO();
				vo.setSd_num(rs.getString("sd_num"));
				vo.setSd_name(rs.getString("sd_name"));
				vo.setSd_id(rs.getString("sd_id"));
				vo.setS_num(rs.getString("s_num"));
				vo.setSd_birth(rs.getString("sd_birth"));
				vo.setSd_phone(rs.getString("sd_phone"));
				vo.setSd_address(rs.getString("sd_address"));
				vo.setSd_email(rs.getString("sd_email"));
				vo.setSd_date(rs.getString("sd_date"));
				
				//ArrayList에 학생정보 StudentVO 객체를 추가
				list.add(vo);
			}
			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			disconnect();
		}
		//완성된 ArrayList 객체를 반환
		return list;
	}
	public int StudentInsert(StudentVO vo){
		int rowCount=0;
		connect();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into student(no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, ");
		sql.append(" sd_phone, sd_address, sd_email) ");
		sql.append(" values(student_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, vo.getSd_num());
			pstmt.setString(2, vo.getSd_name());
			pstmt.setString(3, vo.getSd_id());
			pstmt.setString(4, vo.getSd_passwd());
			pstmt.setString(5, vo.getS_num());
			pstmt.setString(6, vo.getSd_birth().replace("-", ""));
			pstmt.setString(7, vo.getSd_phone());
			pstmt.setString(8, vo.getSd_address());
			pstmt.setString(9, vo.getSd_email());
			
			rowCount=pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			disconnect();
		}
		return rowCount;
	}
}
