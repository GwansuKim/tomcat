package com.yedam.common;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.emp.command.EmpControl;
import com.yedam.emp.command.EmpDetailControl;
import com.yedam.emp.command.EmpForm;
import com.yedam.emp.command.EmpList;
import com.yedam.emp.command.EmpModControl;
import com.yedam.emp.command.EmpModFormControl;
import com.yedam.emp.command.LoginControl;
import com.yedam.emp.command.ServiceControl;

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	// url패턴과 실행할 프로그램과 매핑
	Map<String, Command> map;
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 첫 페이지 지정
		map.put("/main.do", new MainControl());
		
		map.put("/service.do", new ServiceControl());
		map.put("/login.do", new LoginControl());
		// get:목록출력(json)요청, post:입력처리
		map.put("/employee.do", new EmpControl());
		map.put("/empForm.do" , new EmpForm());
		map.put("/empList.do", new EmpList());
		map.put("/empDetail.do", new EmpDetailControl());
		map.put("/empModForm.do", new EmpModFormControl());
		map.put("/empModify.do", new EmpModControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// url 패턴을 확인 => 요청페이지 어떤지 ?
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		System.out.println(context);
		String page = uri.substring(context.length());
		System.out.println(page);
		
		Command command = map.get(page);
		command.exec(req,  resp);
	}
}
