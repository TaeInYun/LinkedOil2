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
		//�̸����� ������
		String viewPage = "";
		
		if(email != null){
			request.setAttribute("email", email);
			viewPage = "idFindOK.jps";
			System.out.println(email);
			}else {
				viewPage = "idFind.jps";
			}	
		
		
		return viewPage;
		} 
		
	 
	}
 
