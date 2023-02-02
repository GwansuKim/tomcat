package com.yedam.emp.dao;

import java.sql.*;
import java.util.*;

import com.yedam.common.DAO;
import com.yedam.emp.vo.EmpVO;

public class EmpDAO extends DAO{
	//싱글톤, 생성자:private, 메소드:public getInstance()
	private static EmpDAO singleton = new EmpDAO();
	
	private EmpDAO() {};
	
	public static EmpDAO getInstance() {
		return singleton;
	}
	
	public List<EmpVO> empList(){
		List<EmpVO> emps = new ArrayList<>();
		connect();
		sql = "select * from emp_temp order by employee_id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return emps;
	}
}
