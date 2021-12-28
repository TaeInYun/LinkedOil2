package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.MemberDAO;

public class ConfirmIdAction implements LinkedOilAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email =  request.getParameter("email");
		System.out.println(email);
		String viewPage = "";
		boolean result = new MemberDAO().checkemail(email);
		
		if(result){
			request.setAttribute("msg", "이미 사용중인 ID입니다.");
			viewPage = "confirmId.jsp";
		}else {
			request.setAttribute("msg", "입력하신 " + email + "는 사용하실 수 있는 이메일입니다.");
				viewPage = "confirmId.jsp";
			}	
		return viewPage;
	}

}
