package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.MemberDAO;

public class PwdFindOKAction implements LinkedOilAction {
	MemberDAO dao;
	public PwdFindOKAction() {
		dao = new MemberDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = dao.findPwd(email);
		
		String viewPage = "";
		
		if(pwd != null) {			
			  request.setAttribute("pwd", pwd);		
			  viewPage= "pwdFindOK.jsp";
			  
		}else {			
			viewPage = "pwdFind.jsp";
		}
		return viewPage;
	}

}
