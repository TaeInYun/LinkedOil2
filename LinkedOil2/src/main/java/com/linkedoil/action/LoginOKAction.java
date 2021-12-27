package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.linkedoil.dao.MemberDAO;

public class LoginOKAction implements LinkedOilAction {
	MemberDAO dao;
	public LoginOKAction() {
		dao = new MemberDAO();
	}
	
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String viewPage = "";
		if(dao.isMember(email, pwd)) {
			 viewPage= "index.jsp";
		}else {
			
			viewPage= "login.jsp";
		
			 
		}
		return viewPage;
	}

}
