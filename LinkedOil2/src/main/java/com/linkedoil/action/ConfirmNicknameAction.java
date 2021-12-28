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
			request.setAttribute("msg", "�̹� ������� �г����Դϴ�.");
			viewPage = "confirmNickname.jsp";
		}else {
			request.setAttribute("msg", "�Է��Ͻ� " + nickname + "�� ����Ͻ� �� �ִ� �г����Դϴ�.");
				viewPage = "confirmNickname.jsp";
			}	
		return viewPage;
	}

}
