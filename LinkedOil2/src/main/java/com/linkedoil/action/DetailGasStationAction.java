package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.GasDAO;
import com.linkedoil.vo.GasStationVO;

public class DetailGasStationAction implements LinkedOilAction {
	
	public GasDAO dao;
	public DetailGasStationAction() {
		dao = new GasDAO();		
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String station_no = request.getParameter("station_no");
		GasStationVO g = dao.getGas(station_no);
		request.setAttribute("g", g);
		return "detailGasStation.jsp";
	}

}
