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
	
	//전체 목록 불러오기
	public List<EmpVO> empList(){
		List<EmpVO> emps = new ArrayList<>();
		connect();
		sql = "select employee_id, first_name, last_name, email, job_id, to_char(hire_date, 'yyyy-mm-dd') h_date from emp_temp order by employee_id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("h_date"));
				emp.setJobId(rs.getString("job_id"));
				
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return emps;
	}
	
	//한 건 조회
	public EmpVO searchEmp(int empId) {
		connect();
		sql = "select employee_id, first_name, last_name, email, job_id, to_char(hire_date, 'yyyy-mm-dd') hire_date from emp_temp where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
				
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}
	
	//한 건 추가
	public int insertEmp(EmpVO emp) {
		connect();
		sql = "insert into emp_temp(employee_id, last_name, email, hire_date, job_id) values(?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			
			int r =psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}
	
	//수정
	public int putEmp(EmpVO emp) {
		connect();
		sql = "update emp_temp set last_name = ?, email = ?, hire_date = ?, job_id = ? where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHireDate());
			psmt.setString(4, emp.getJobId());
			psmt.setInt(5, emp.getEmployeeId());
			
			int r =psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}
}
