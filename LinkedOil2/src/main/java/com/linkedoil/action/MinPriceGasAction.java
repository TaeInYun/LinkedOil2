package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.linkedoil.dao.MinPriceGasDAO;
 
import com.linkedoil.vo.MinPriceGasVO;

public class MinPriceGasAction implements LinkedOilAction {

	public MinPriceGasDAO dao;
	
	public MinPriceGasAction() {
		dao = new MinPriceGasDAO();
	}
		
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		 request.setCharacterEncoding("utf-8");
		 ArrayList<MinPriceGasVO>minList  = dao.minPriceGasList();
		 request.setAttribute("minList", minList);
	 
		return "minPriceGas.jsp";
	}

}
