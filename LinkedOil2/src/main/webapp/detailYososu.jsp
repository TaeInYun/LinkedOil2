<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/detailinfo.css">
</head>
<body>
<div id="container">

	<header>
		<nav>
		<ul id="main-nav">
		<li><button type="button" class="btn btn-outline-light"  onclick = "location.href = 'selectYososu.do'"> 요소수 주유소 검색</li>
		<div id="linkedoilLogo">
		<a href="index.jsp"><img id src="images/linkedoil_logo_white.png" width="140px" height="auto"> </a>
		</div>
		</ul>
		</nav>
	</header>


	<!-- 정보 보여주는 section -->
	<section id = "intro" >
		<div class="page-title">
			<h2>${y.name}</h2>
			<p>평점&nbsp;:&nbsp;  0&nbsp;  &nbsp;  리뷰&nbsp;:&nbsp; 0.0<br></p>
			<button type="button" class="btn btn-outline-dark" a href="likeStation.do">관심주유소</button>
		</div>
		<div class="line"></div>
		<div class="content">
			<p>주소 : ${y.addr}<br>
			전화번호 : ${y.tel }	<br> </p>
			
			<table class="table table-bordered" border="1" >
				<thead>
					<tr>
						<td>재고수량</td>
						<td>재고상태</td>
						<td>가격</td>
					</tr>
					</thead>
						<tr>
						<td> ${y.inventory } L</td>
						<td>${y.color }</td>
						<td>${y.price } 원</td>	
					</tr>
			</table>
		
		</div>
	</section>
	
	<!-- 지도 보여주는 section -->
	<section id = "mapinfo">
	 <div id="map" style="width:100%;height:400px;">

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=383beb63eac8714dec4cc534f56f27f8&libraries=services"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('${y.addr}', function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">${y.name}</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    
	</script>
	</div>

	</section>

</div>

</body>
</html>



