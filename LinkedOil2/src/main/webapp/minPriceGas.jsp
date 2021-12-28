<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>전국 주유소 최저가 리스트</h2>

	 <table border="1" width="60%">
	 <tr>
	  
		<td>고유번호</td>		
		<td>지역</td>		
		<td>이름</td>			
		<td>위치</td>			 	
		<td>휘발유</td>			 
		
		<c:forEach var="g" items="${minList}">
		<tr>
			 	<td>${g.station_no } </td>  
			 	<td>${g.station_local } </td>
			 	<td><a href="detailGasStation.do?station_no=${g.station_no}">${g.station_name }</a></td>			 
				<td> ${g.station_addr } </td>
				<td> ${g.oil_b027 } </td>	
			</tr>		
		
		</c:forEach>
	 </tr>
	 
	 
	 
	 
	 </table>
</body>
</html>