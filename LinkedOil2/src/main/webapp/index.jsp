<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="search.jsp"/>
	<table class="table table-striped">
		<tr>
			<c:forEach var="t" items="${list }">
				<td>${t.oil_name }</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="t" items="${list }">
				<td>${t.price }</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="t" items="${list }">
				<td>어제보다 ${t.api_diff }원</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="t" items="${list }">
				<td>지난주보다 ${t.week_diff }원</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="t" items="${list }">
				<td>지난달보다 ${t.month_diff }원</td>
			</c:forEach>
		</tr>
	</table>
	<div>
		<ul>
			<li><a href="listWeekOilPrice.do?oil_code='B034'">고급휘발유</a></li>
			<li><a href="listWeekOilPrice.do?oil_code='B027'">휘발유</a></li>
			<li><a href="listWeekOilPrice.do?oil_code='D047'">경유</a></li>
			<li><a href="listWeekOilPrice.do?oil_code='K015'">LPG</a></li>
		</ul>
		<jsp:include page="main/chartWeekOilPrice.jsp"/>
	</div>
</body>
</html>