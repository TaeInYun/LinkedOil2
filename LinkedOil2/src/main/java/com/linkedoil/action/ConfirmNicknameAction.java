package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.MemberDAO;

public class ConfirmNicknameAction implements LinkedOilAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickname =  request.getParameter("nickname");
		String viewPage = "";
		boolean result = new MemberDAO().checkNickname(nickname);
		
		if(result){
			request.setAttribute("msg", "이미 사용중인 닉네임입니다.");
			viewPage = "confirmNickname.jsp";
		}else {
			request.setAttribute("msg", "입력하신 " + nickname + "는 사용하실 수 있는 닉네임입니다.");
				viewPage = "confirmNickname.jsp";
			}	
		return viewPage;
	}

}
