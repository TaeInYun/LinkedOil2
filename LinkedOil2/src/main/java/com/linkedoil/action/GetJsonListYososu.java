package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.SelectYososuDAO;

public class GetJsonListYososu implements LinkedOilAction {
	
	public SelectYososuDAO dao;
	public GetJsonListYososu() {
		dao = new SelectYososuDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub		
		return "getJsonListYososu.jsp";
	}

}
