package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.GasDAO;

public class GetJsonListGasStation implements LinkedOilAction {
	
	public GasDAO dao;
	public GetJsonListGasStation() {
		dao = new GasDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "getJsonListtGasStation.jsp";
	}

}
