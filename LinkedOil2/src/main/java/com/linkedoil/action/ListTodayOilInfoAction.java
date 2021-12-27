package com.linkedoil.action;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.TodayOilPriceDAO;
import com.linkedoil.vo.TodayOilVO;

public class ListTodayOilInfoAction implements LinkedOilAction {
	
	public TodayOilPriceDAO dao;
	
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		dao = new TodayOilPriceDAO();
		System.out.println("¿€µø");
		ArrayList<TodayOilVO> list = dao.listTodayOil();
		request.setAttribute("list", list);
		return "index.jsp";
	}

}
