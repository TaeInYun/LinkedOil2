package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.DetailStationDAO;
import com.linkedoil.dao.EvstationDAO;
import com.linkedoil.dao.SearchStationDAO;
import com.linkedoil.vo.DetailStationVO;
import com.linkedoil.vo.EvStationVO;
import com.linkedoil.vo.SearchStationVO;

public class DetailEvStationAction implements LinkedOilAction {

	public DetailStationDAO dao;
	
	public DetailEvStationAction() {
		dao= new DetailStationDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int ev_id = Integer.parseInt(request.getParameter("ev_id"));
		System.out.println(ev_id);
		
		
		DetailStationVO ev = dao.getEvStation(ev_id); 
		ArrayList<DetailStationVO> clist = dao.EvChargerlist(ev_id);

		request.setAttribute("ev", ev);
		request.setAttribute("clist", clist);
		
		
		for(DetailStationVO vo : clist) {
			System.out.println(vo);
		}
		
		return "detailEvStation.jsp";
	}

}
