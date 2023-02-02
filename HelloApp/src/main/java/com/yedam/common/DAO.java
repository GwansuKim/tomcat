package com.yedam.common;

import java.sql.*;

public class DAO {
	public Connection conn;
	public Statement stmt = null;
	public ResultSet rs = null;
	public PreparedStatement psmt = null;

	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "hr";
	public String pass = "hr";
	public String sql;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass); // 요청 url 유저명 패스워드
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
	}

	public void disconn() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
