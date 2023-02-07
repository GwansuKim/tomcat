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
import com.yedam.emp.command.EmpRemoveControl;
import com.yedam.emp.command.ServiceControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;
import com.yedam.member.command.MemberListControl;
import com.yedam.member.command.SignOnControl;
import com.yedam.member.command.SignOnFormControl;

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
		// get:목록출력(json)요청, post:입력처리
		map.put("/employee.do", new EmpControl());
		map.put("/empForm.do" , new EmpForm());
		map.put("/empList.do", new EmpList());
		map.put("/empDetail.do", new EmpDetailControl());
		map.put("/empModForm.do", new EmpModFormControl());
		map.put("/empModify.do", new EmpModControl());
		map.put("/empRemove.do", new EmpRemoveControl());
		
		//회원 관리 메뉴
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/signOnForm.do", new SignOnFormControl());
		map.put("/signon.do", new SignOnControl());
		map.put("/memberList.do", new MemberListControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// url 패턴을 확인 => 요청페이지 어떤지 ?
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String page = uri.substring(context.length());
		
		Command command = map.get(page);
		command.exec(req,  resp);
	}
}
