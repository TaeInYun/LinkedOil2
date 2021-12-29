<%@page import="com.linkedoil.dao.MemberDAO"%>
<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>아이디 중복확인</title>
<script type="text/javascript">
function frameclose() { 
	parent.close() 
	window.close() 
	self.close() 
	} 
</script>
</head>
<body>
	<div class="header join__img">
		<a href="start.jsp"><img class="logo log__join" alt="링크드오일로고" src="images/로고.png"></a>
	</div>
	<h3 class="inform__title">	${ msg} </h3>
	<div class="nav">
	<span><a href="javascript:frameclose()">닫기</a></span>
	</div>
</body>
</html>