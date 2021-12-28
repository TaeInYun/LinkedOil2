package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.linkedoil.dao.SelectYososuDAO;
import com.linkedoil.vo.YososuVO;

public class SelectYososuAction implements LinkedOilAction {

	public SelectYososuDAO dao;
	public SelectYososuAction() {
		dao = new SelectYososuDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 HttpSession session = request.getSession();
			
		 request.setCharacterEncoding("utf-8");
		
		 String sido1 = request.getParameter("sido1");
		 System.out.println("검색 시도 :  "+sido1);
		 
		 String gugun1 = request.getParameter("gugun1");	
		 System.out.println("검색 군구: "+gugun1);
		
		
		 if(sido1 == null && session.getAttribute("sido1")!=null) {				
				sido1 = (String)session.getAttribute("sido1");
			}
			if(gugun1 == null && session.getAttribute("gugun1")!=null) {				
				sido1 = (String)session.getAttribute("sido1");
				gugun1 = (String)session.getAttribute("gugun1");
			}
		
			int pageNUM=1;
			
			if(request.getParameter("pageNUM")!=null) {			
				pageNUM =Integer.parseInt(request.getParameter("pageNUM"));
			}
			
			System.out.println("pageNUM:"+pageNUM);
			ArrayList<YososuVO>list = dao.listyososu(pageNUM,sido1,gugun1);
		 	request.setAttribute("totalPage", SelectYososuDAO.totalPage);		
			request.setAttribute("list", list);
		 
			if(sido1 != null && gugun1!=null) {
				
				session.setAttribute("sido1", sido1);
				session.setAttribute("gugun1", gugun1);			
			}
			
			
		return "selectYososu.jsp";
	}

}







