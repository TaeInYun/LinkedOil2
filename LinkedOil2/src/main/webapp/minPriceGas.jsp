<%@page import="com.linkedoil.dao.MinPriceGasDAO"%>
<%@page import="com.linkedoil.vo.MinPriceGasVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<link rel="stylesheet" href="css/minPriceGas.css">
	 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery. slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div id="name">
		<p>���� ������ ������
	</div>	
	
	
 
	
	<%
	MinPriceGasDAO dao= new MinPriceGasDAO();
	ArrayList<MinPriceGasVO>minList  = dao.minPriceGasList();
	request.setAttribute("minList", minList);
	%>
		<div id="tableList">
			<table class="table table-hover">
				 <tr>		 		
					<th style="text-align:  center;">����</th>		
					<th style="text-align:  center;">�̸�</th>			
					<th style="text-align:  center;">��ġ</th>			 	
					<th style="text-align:  center;">�ֹ���</th>			 
					<c:forEach var="g" items="${minList}">
				 <tr>
					<td>${g.station_local } </td>
				 	<td><a style="text-decoration: none; color : black;"href="detailGasStation.do?station_no=${g.station_no}">${g.station_name }</a></td>			 
					<td> ${g.station_addr } </td>
					<td> ${g.oil_b027 } </td>	
				</tr>		
					</c:forEach>
				</tr>
		  	</table>
		</div>
		<div id="map" class="box-map" ></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=383beb63eac8714dec4cc534f56f27f8&libraries=services"></script>
		<script>
	
		var mapContainer = document.getElementById('map');
		var mapOption = {
		    center: new daum.maps.LatLng(37.450701, 126.570667),
		    level: 10
		};  

		var map = new daum.maps.Map(mapContainer, mapOption); 
		
		var geocoder = new daum.maps.services.Geocoder();

		//�ּҸ� �迭�� ���
		var listData = new Array();
		<c:forEach items="${minList}" var="g">
		listData.push("${g.station_addr}");
		</c:forEach>

		for (var i=0; i < listData.length ; i++) {
		// �ּҷ� ��ǥ�� �˻��մϴ�
			geocoder.addressSearch(listData[i], function(result, status) {
    		// ���������� �˻��� �Ϸ������     
			     	if (status === daum.maps.services.Status.OK) {
			        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
			        // ��������� ���� ��ġ�� ��Ŀ�� ǥ���մϴ�
			        var marker = new daum.maps.Marker({
			            map: map,
			            position: coords
			        });
 
        		map.setCenter(coords);
       			} 
			})
		};     
</script>
	</div>
</body>
</html>