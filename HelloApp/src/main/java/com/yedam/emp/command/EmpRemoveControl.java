package com.yedam.emp.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.EmpServiceImpl;
import com.yedam.emp.service.EmpServiceMybatis;

public class EmpRemoveControl implements Command {


	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher rd;
		String id = req.getParameter("id");
		
		//EmpService service = new EmpServiceImpl();
		EmpService service = new EmpServiceMybatis();
		int r = service.removeEmp(Integer.parseInt(id));
		
		if(r>0) {
			try {
				resp.sendRedirect("empList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// resp.sendRedirect("WEB-INF/result/errorResult.jsp");
			rd = req.getRequestDispatcher("WEB-INF/result/errorResult.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
