package com.yedam.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.emp.vo.EmpVO;

//EmpServiceImpl : jdbc
//EmpServiceMybatis : mybatis
public class EmpServiceMybatis implements EmpService{

	SqlSessionFactory sessionFactory = DataSource.getInstance();
	SqlSession session = sessionFactory.openSession(true); //true:자동 커밋
	
	@Override
	public List<EmpVO> empList() {
		return session.selectList("com.yedam.emp.mapper.EmpMapper.empList");
	}

	@Override
	public int addEmp(EmpVO emp) {
		return session.insert("com.yedam.emp.mapper.EmpMapper.addEmp", emp);
	}

	@Override
	public EmpVO getEmp(int empId) {
		return session.selectOne("com.yedam.emp.mapper.EmpMapper.getEmp", empId);
	}

	@Override
	public int updateEmp(EmpVO emp) {
		return session.update("com.yedam.emp.mapper.EmpMapper.modEmp", emp);
	}

	@Override
	public Map<String, String> jobList() {
		return null;
	}

	@Override
	public int removeEmp(int empId) {
		return session.delete("com.yedam.emp.mapper.EmpMapper.removeEmp", empId);
	}
	
}
