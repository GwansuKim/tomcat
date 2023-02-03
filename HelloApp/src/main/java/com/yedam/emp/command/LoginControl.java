package com.yedam.emp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;

public class LoginControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("로그인 컨트롤");
		
		String method = req.getMethod();
		System.out.println("요청방식: " + method);
		String id = req.getParameter("uid");
		String pw = req.getParameter("upw");
		System.out.println("id: " + id + " pw: " + pw);
	}

}
