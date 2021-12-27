<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<b>결과 리스트</b><br>
<hr>
	<!--  <form action="searchEvStationList.do" method="post">
	</form>-->
	<table border="1" width="80%">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>리뷰수</th>
			<th>평점</th>
	
		<c:forEach var="e" items="${list}">
			<tr>
				<td>${e.ev_id }</td>
				<td><a href="detailEvStation.do?ev_id=${e.ev_id }">${e.ev_name}</a></td>
				<td>${e.ev_addr }</td>
				<td>${e.review_cnt }</td>
				<td>${e.asterion_avg }</td>
			</tr>
		</c:forEach>
			</tr>
	</table>
	<br>
	<br>
	<c:forEach var="i" begin="1" end="${totalPage}">
		<a href="searchEvStationList.do?pageNUM=${i}">${i}</a>&nbsp;&nbsp;
		<!-- -링크를 걸어주고 page번호를 받음 -->
	</c:forEach>
</body>
</html>
