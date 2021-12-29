package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.SelectYososuDAO;
import com.linkedoil.vo.DetailStationVO;
import com.linkedoil.vo.DetailYososuVO;
import com.linkedoil.vo.YososuVO;

public class DetailYososuAction implements LinkedOilAction {

	public SelectYososuDAO dao;
	public DetailYososuAction() {
		dao = new SelectYososuDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 String name = request.getParameter("name"); YososuVO y = dao.getYososu(name);
		 request.setAttribute("y", y);
		 
		 //DetailYososuVO dv = dao.detailYososu(name); 
		 
		// ArrayList<DetailYososuVO>  dlist = dao.detailYososu(name); 
		
		/*
		 * String name2 = request.getParameter("name"); DetailYososuVO dy =
		 * dao.detailYososu(name2); request.setAttribute("dy", dy);
		 * request.setAttribute("dlist", dlist);
		 */
		
				
		return "detailYososu.jsp";
	}

}






