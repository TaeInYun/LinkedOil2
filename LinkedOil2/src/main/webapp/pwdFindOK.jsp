<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/styles.css">
<title>��й�ȣã�� ���-��ũ�� ����</title>
		  
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="header join__img">
		<a href="start.jsp"><img class="logo log__join" alt="��ũ����Ϸΰ�" src="images/�ΰ�.png"></a>
	</div>
	<div class="inform">
		<h3 class="inform__title">��й�ȣ ã�� ���</h3>
		<p class="inform__title">ȸ������ ��й�ȣ�� ${pwd} �Դϴ�.</p>
	</div>
	<div class="nav">
		<span><a href="login.jsp">�α���</a></span>
	</div>
</body>
</html>