package com.linkedoil.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.linkedoil.dao.MemberDAO;
import com.linkedoil.vo.MemberVO;

public class IdFindAction implements LinkedOilAction {
	
	MemberDAO dao;
	public IdFindAction() {
		dao= new MemberDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String nickname = request.getParameter("nickName");
		String name = request.getParameter("name");
		return "idFindOK.do";

}

}