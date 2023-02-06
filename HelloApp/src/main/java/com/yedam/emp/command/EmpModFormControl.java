package com.yedam.emp.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.EmpServiceImpl;
import com.yedam.emp.vo.EmpVO;

public class EmpModFormControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		
		EmpService service = new EmpServiceImpl();
		EmpVO emp = service.getEmp(Integer.parseInt(id));
		Map<String, String> jobList = service.jobList();
		req.setAttribute("jobList", jobList);
		
		req.setAttribute("searchVO", emp);
		req.setAttribute("myAge", 100);
		req.setAttribute("loginId", "user1");
		
		try {
			req.getRequestDispatcher("WEB-INF/views/modify.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
