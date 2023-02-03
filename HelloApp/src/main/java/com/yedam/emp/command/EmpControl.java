package com.yedam.emp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.emp.dao.EmpDAO;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.EmpServiceImpl;
import com.yedam.emp.vo.EmpVO;

public class EmpControl implements Command {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		String method = req.getMethod();
		PrintWriter out = null;
		RequestDispatcher rd;

		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (method.equals("GET")) {
			// resp.sendRedirect("WEB-INF/result/empList.jsp");
			rd = req.getRequestDispatcher("WEB-INF/result/empList.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (method.equals("POST")) {
			String eid = req.getParameter("eid");
			String lName = req.getParameter("last_name");
			String job = req.getParameter("job");
			String hire = req.getParameter("hire_date");
			String mail = req.getParameter("email");

			EmpVO emp = new EmpVO();
			if (eid.equals("") || lName.equals("") || job.equals("") || hire.equals("") || mail.equals("")) {
				// resp.sendRedirect("WEB-INF/result/errorResult.jsp");
				rd = req.getRequestDispatcher("WEB-INF/result/errorResult.jsp");
				try {
					rd.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				emp.setEmployeeId(Integer.parseInt(eid));
				emp.setLastName(lName);
				emp.setJobId(job);
				emp.setHireDate(hire);
				emp.setEmail(mail);

				EmpService service = new EmpServiceImpl();
				int result = service.addEmp(emp);

				if (result > 0) {
					// resp.sendRedirect("WEB-INF/result/addResult.jsp");
					rd = req.getRequestDispatcher("WEB-INF/result/addResult.jsp");
					try {
						rd.forward(req, resp);
					} catch (ServletException e) {
						e.printStackTrace();
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
		} else {
			System.out.println("알 수 없는 요청입니다");
		}
	}

}
