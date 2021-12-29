<%@page import="com.linkedoil.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String email = request.getParameter("email");
	String pwd = request.getParameter("pwd");
	MemberDAO dao = new MemberDAO();
	
	if( dao.getEmail(email) == 1){
		String nickname = dao.isMember(email, pwd);
		if(nickname != null){
			session.setAttribute("nickname", nickname);
	        response.sendRedirect("start.jsp");
		}else{
			%>
	        <script>
	        alert('비밀번호가 일치하지않음');
	        location.href='login.jsp'; 
	        </script>
			<%
			
		}
	}else{
		
        %>
        <script>
        alert('이메일이 일치하지않음');
        location.href='sessionLogin.jsp';    
        </script>
		<%
	}
%>
</body>
</html>