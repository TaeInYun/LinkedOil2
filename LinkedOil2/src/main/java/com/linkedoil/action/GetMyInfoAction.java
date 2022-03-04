package com.linkedoil.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linkedoil.dao.LikeOilDAO;
import com.linkedoil.dao.MemberDAO;
import com.linkedoil.vo.MemberVO;

public class GetMyInfoAction implements LinkedOilAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String nickname = (String)request.getAttribute("nickname");

			MemberDAO dao = new MemberDAO();
			LikeOilDAO like = new LikeOilDAO();
			System.out.println(nickname + "!!!!!!!!!!!!!11111!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			MemberVO vo = dao.getMyInfo(nickname);
			ArrayList<String> list = like.getLikeOil(nickname);
			String like_oil = "등록된 정보가 없습니다.";
			
			if(list != null) {
				for(int i = 0; i < list.size(); i++) {
					if(i == 0) {
						like_oil = list.get(i);
					}else{
						like_oil += ", " + list.get(i);
					}
				}
			}
			
			request.setAttribute("email", vo.getEmail());
			request.setAttribute("pwd", vo.getPwd());
			request.setAttribute("name", vo.getName());
			request.setAttribute("nickname", vo.getNickname());
			System.out.println(like_oil);
			request.setAttribute("list", like_oil);
			
			
		return "myPage.jsp";
	}

}
