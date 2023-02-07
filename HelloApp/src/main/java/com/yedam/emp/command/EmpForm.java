package com.yedam.emp.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.EmpServiceImpl;
import com.yedam.emp.service.EmpServiceMybatis;

import java.util.*;

public class EmpForm implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {

		EmpService service = new EmpServiceImpl();
		//EmpService service = new EmpServiceMybatis();
		Map<String, String> jobList = service.jobList();
		req.setAttribute("jobList", jobList);
		RequestDispatcher rd =  req.getRequestDispatcher("WEB-INF/views/emp.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
