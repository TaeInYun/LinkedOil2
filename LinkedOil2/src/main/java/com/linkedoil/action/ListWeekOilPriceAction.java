package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListWeekOilPriceAction implements LinkedOilAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String oil_code_name = request.getParameter("oil_code_name");
		request.setAttribute("oil_code_name", oil_code_name);
		return "main/listWeekOilPrice.jsp";
	}

}
