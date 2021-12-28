package com.linkedoil.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.websocket.Session;

import com.linkedoil.dao.MemberDAO;
import com.linkedoil.vo.MemberVO;

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
			  request.setAttribute("email", email);		
			  viewPage= "index.jsp";
			  
		}else {			
		 
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().print("<script>alert('로그인 정보가 일치하지 않습니다.');history.back();</script>");
			 
			viewPage= "login.jsp";
		 
		}
		return viewPage;
}
}
