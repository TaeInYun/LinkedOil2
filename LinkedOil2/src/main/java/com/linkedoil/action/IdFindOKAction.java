package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.linkedoil.dao.MemberDAO;

public class IdFindOKAction implements LinkedOilAction {

	public MemberDAO dao;
	public IdFindOKAction() {
		dao = new MemberDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nickName =  request.getParameter("nickName");
		String name = request.getParameter("name");
		String email = 	dao.findId(nickName, name);
		//이메일을 가져옴
		String viewPage = "";
		
		if(email != null){
			request.setAttribute("email", email);
			viewPage = "idFindOK.jsp";
			//찾았으면 idFindOK.jsp로 가서 아이디 알려주기
			System.out.println(email);
			}else {
				viewPage = "idFindError.jsp";
			}	
		
		
		return viewPage;
		} 
		
	 
	}
 
