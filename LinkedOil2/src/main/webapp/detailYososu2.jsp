<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="width: 100%">

<div class="container">
 <button type="button" class="btn btn-dark"><a href="selectYososu.do">요소수 리스트로 돌아가기</a></button>
 <button type="button" class="btn btn-dark"><a href="likeStation.do">관심주유소 등록하기</a></button>
 </div>
 
 <div>
 
 <hr>
 <div class="container"></div>
 <div id="show">
 <div style="text-align: center; margin: 0 auto;"><h1><b>결과 리스트</b></h1></div><br>
 
 <div class="container">
	
	 <!-- <table border="1" width="60%">  -->
		 <table class="table table-hover"> 
		<tr>
		<!--  		 
			<td>번호</td>
			<td>셀프여부</td>		
			<td>고급휘발유</td>	
			<td>등유</td>	 -->
			
			<tr><td><h3>이름</h3></td>
				<td>${y.name }</td></tr>
			<tr><td><h3>주소</h3></td>		
				<td>${y.addr }</td>	</tr>
			<tr><td><h3>재고수량</h3></td>
				<td> ${y.inventory } L</td></tr>
			<tr><td><h3>재고상태</h3></td>
				<td>${y.color } </td></tr>	
			<tr><td><h3>가격</h3></td>  
				<td> ${y.price } 원</td>	</tr>				 
			<tr><td><h3>전화번호</h3></td>
				<td> ${y.tel } </td></tr>
				
			<!-- <td>리뷰수</td>		 
			<td>평균평점</td>	 -->	 
			<!-- <td>위도</td>
			<td>경도</td> -->
			
			</tr>
		
		
		 	<%-- <tr>
		 	  				
			 	<tr><td>${y.name }</td></tr>
			 	<tr><td>${y.addr }</td>	</tr>		 
				<tr><td> ${y.inventory } L</td></tr>
				<tr><td>${y.color } </td></tr>
				<tr><td> ${y.price } 원</td>	</tr>									
				<tr><td> ${y.tel } </td></tr>
				<td> ${y.review_cnt } </td>			
				<td> ${y.asterion_avg } </td>		
					<td> ${y.lat } </td>			
				<td> ${y.lng } </td>			
						 
			</tr>	 --%>		
		
		
		
 	</table>
 	</div>
 	
 	</div>  <!--show(메뉴)  -->
 
 
 <%-- <div class="left">
 	
	<h2>요소수 상세 페이지</h2>
	
	
	<hr>
	
		요소수 보유 주유소 이름 : ${y.name }<br> 
		주소:  ${y.addr}<br>
		요소수 재고수 : ${y.inventory }<br>  
	 	요소수 재고상태: ${y.color }	<br>   	
		요소수 가격: ${y.price }<br> 
		경도: ${y.lat } <br>		 		
		위도: ${y.lng }	<br> 
		전화번호:${y.tel} <br>	 
		 
		
		
</div> --%>

 <div id="map" style="width:100%;height:350px;" class="right">


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
</div>

</body>
</html>



