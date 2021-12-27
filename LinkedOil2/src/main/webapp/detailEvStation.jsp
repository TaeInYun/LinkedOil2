<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a href="searchEvStationList.do">자동차 충전소 리스트로 돌아가기</a>
  <a href="likeStation.do">관심주유소 등록하기</a>
 <div>
 <div class="left">
 
	<h2>전기차 충전소 상세 페이지</h2>
	
	<hr>
		전기차충전소 아이디 : ${ev.ev_id}<br>
		전기차충전소 이름 : ${ev.ev_name}<br>
		전기차충전소 주소 : ${ev.ev_addr}<br>
		별점 : ${ev.review_cnt}<br>
		평점 : ${ev.asterion_avg}<br>
	<hr>
		<table border="1" width="60%">
		<tr>
			
			<td>상태</td>
			<td>충전기 방식</td>		
			<td>충전기 타입</td>		
		
		<c:forEach var="c" items="${clist}">
			<tr>
				<td>${c.charger_status_name }</td>
				<td>${c.charger_type_name }</td>
				<td>${c.charger_method_name}</td>
			</tr>
		</c:forEach>
			</tr>
	</table>
	

		
</div>
 <div id="map" style="width:100%;height:350px;" class="right">

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
geocoder.addressSearch('${ev.ev_addr}', function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${ev.ev_name}</div>'
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
