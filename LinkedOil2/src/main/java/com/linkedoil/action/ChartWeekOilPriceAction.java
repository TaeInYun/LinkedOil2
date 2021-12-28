package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChartWeekOilPriceAction implements LinkedOilAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String oil_code = request.getParameter("oil_code");
		request.setAttribute("oil_code", oil_code);
		return "main/chartWeekOilPrice.jsp";
	}

}
