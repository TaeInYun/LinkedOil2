package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.LikeOilDAO;
import com.linkedoil.dao.MemberDAO;
import com.linkedoil.vo.LikeOilVO;
import com.linkedoil.vo.MemberVO;

public class InsertMemberAction implements LinkedOilAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String viewPage = "";
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String[] myOil = request.getParameterValues("myOil");
		
		MemberVO member = new MemberVO(email, pwd, name, nickname);
		MemberDAO dao = new MemberDAO();
		int re = dao.getNo(email, nickname);
		
		
		int no = dao.getNo(email, nickname);
		LikeOilDAO oilDao = new LikeOilDAO();
		int insert_oil = 0;
		if(re == 0) {
			re = dao.insertMember(member);
			if(re == 1) {
				if(myOil != null) {
					for(int i = 0; i < myOil.length; i++) {
						LikeOilVO v = new LikeOilVO(no, myOil[i]);
						insert_oil += oilDao.insertLikeOil(v);
					}
				}
				
				request.setAttribute("nickname", nickname);
				viewPage = "join_success.jsp";
			}
		}else {
			viewPage = "join_failed.jsp";
		}
		return viewPage;
	}

}
