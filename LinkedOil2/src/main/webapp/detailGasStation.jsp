<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/detailGasStation.css">
</head>
<body>
 <a href="selectGasStation.do">주유소 리스트로 돌아가기</a>

 <div>
 <div class="left">
  
	<div class="name"><h2>${g.station_name}</h2></div>
	<div class="list">
	  
		 <div class="data">${g.station_local }</div>
	 	 <hr> 	
		<div class="data"> ${g.station_addr }<br>
		<hr>
		<div class="data">  ${g.station_brand } <br>				
		<hr>
		<div class="data"> ${g.station_self }	<br> 	 
		<hr>
		<div class="data">  ${g.oil_b037 }<br>		 
		<hr>
		<div class="data"> ${g.oil_b027 }<br>
		<hr>
		<div class="data"> 	${g.oil_d047 }<br>				
		<hr>
		<div class="data">  ${g.oil_c004}<br>
</div>		
</div>
 <div id="map">

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5ce43d6c6e81f2fef309da06d4726f64&libraries=services"></script>
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
geocoder.addressSearch('${g.station_addr}', function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${g.station_name}</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
</div>
</div>

</body>
</html>
