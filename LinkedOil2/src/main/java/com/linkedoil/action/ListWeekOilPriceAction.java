package com.linkedoil.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListWeekOilPriceAction implements LinkedOilAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oil_code = request.getParameter("oil_code");
		request.setAttribute("oil_code", oil_code);
		return "main/listWeekOilPrice.jsp";
	}

}
