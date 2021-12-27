package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.EvstationDAO;
import com.linkedoil.dao.SearchStationDAO;
import com.linkedoil.vo.EvStationVO;
import com.linkedoil.vo.SearchStationVO;

public class SearchEvStationListAction implements LinkedOilAction {

	public SearchStationDAO dao;
	public SearchEvStationListAction() {
		dao = new SearchStationDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pageNUM = 1;
		if(request.getParameter("pageNUM") != null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		System.out.println("pageNUM:"+pageNUM);

		
		ArrayList<SearchStationVO> list  = dao.searchEvStationList(pageNUM);
		request.setAttribute("totalPage", SearchStationDAO.totalPage);
		request.setAttribute("list", list);

		
		return "searchEvStationList.jsp";
	}

}
