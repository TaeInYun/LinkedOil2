<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/styles.css">
<title>���̵�ã�� ���-��ũ�� ����</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="header join__img">
		<a href="start.jsp"><img class="logo log__join" alt="��ũ����Ϸΰ�" src="images/�ΰ�.png"></a>
	</div>
	<div class="inform">
		<h3 class="inform__title">���̵� ã�� ���</h3>
		<p class="inform__title">ȸ������ ���̵�� ${email} �Դϴ�.</p>
	</div>
	<div class="nav">
		<span><a href="login.jsp">�α���</a></span>
		<span><a href="pwdFind.jsp">��й�ȣ ã��</a></span>
	</div>
	
</body>
</html>