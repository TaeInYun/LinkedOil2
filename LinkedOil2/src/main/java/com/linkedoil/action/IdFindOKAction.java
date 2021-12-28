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
		System.out.println(email);
		//이메일을 가져옴
		String viewPage = "";
		
		if(email != null){
			viewPage = "idFindOK.jsp";
			System.out.println(email);
			request.setAttribute("email", email);
			}else {
				viewPage = "idFind.jsp";
			}	
		
		
		return viewPage;
		} 
		
	 
	}
 
