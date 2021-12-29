package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.GasDAO;
import com.linkedoil.dao.SearchStationDAO;

public class GetJsonListEvStation implements LinkedOilAction {

	public SearchStationDAO dao;
	public GetJsonListEvStation() {
		dao = new SearchStationDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "getJsonListEvStation.jsp";
	}

}
