package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.linkedoil.dao.GasDAO;
import com.linkedoil.vo.GasStationVO;

public class SelectGasStationAction2 implements LinkedOilAction {

	
	public GasDAO dao;
	public SelectGasStationAction2() {
		dao = new GasDAO();
	}
	
	
		
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 

		 HttpSession session = request.getSession();
			
			 request.setCharacterEncoding("utf-8");
			
			 String sido1 = request.getParameter("sido1");
			 
			 String gugun1 = request.getParameter("gugun1");	
			 
			 String user_brand = request.getParameter("user_brand");
			 
			 String oil = request.getParameter("oil");
			 
			 
				
			 
				if(sido1 == null && session.getAttribute("sido1")!=null) {				
					user_brand = (String)session.getAttribute("user_brand");
					sido1 = (String)session.getAttribute("sido1");
				}
				if(gugun1 == null && session.getAttribute("gugun1")!=null) {				
					user_brand = (String)session.getAttribute("user_brand");
					sido1 = (String)session.getAttribute("sido1");
					gugun1 = (String)session.getAttribute("gugun1");
				}
				 
				if(oil == null && session.getAttribute("oil") != null) {
					oil = (String)session.getAttribute("oil");
				}
		
		 	int pageNUM=1;
			 
			if(request.getParameter("pageNUM")!=null) {			
				pageNUM =Integer.parseInt(request.getParameter("pageNUM"));
			}
			
			System.out.println("pageNUM:"+pageNUM);
			ArrayList<GasStationVO>list = dao.listgas(pageNUM,sido1,gugun1,user_brand,oil);
		 	request.setAttribute("totalPage", GasDAO.totalPage);		
			request.setAttribute("list", list);
			
			
			request.setAttribute("totalPage", GasDAO.totalPage);
			request.setAttribute("startPage", GasDAO.startPage);
			request.setAttribute("endPage", GasDAO.endPage);
		 
			if(sido1 != null && gugun1!=null) {
				
				session.setAttribute("sido1", sido1);
				session.setAttribute("gugun1", gugun1);
				session.setAttribute("user_brand", user_brand);
			}
			
			if(oil != null) {
				session.setAttribute("oil", oil);
			}return "selectGasStation.jsp";			
 
			}

	}


