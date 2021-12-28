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
<!-- 지도그리기 -->
<div id="map" style="width:100%;height:350px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=efc51d149bcb86beca3f7969fe946ef1&libraries=services"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

<!-- 지도 그리기 -->
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

//주소를 배열에 담기
var listData = new Array();
<c:forEach items="${list}" var="e">
listData.push("${e.ev_addr}");
</c:forEach>

/*var listData = [
    {
        groupAddress: '제주특별자치도 제주시 첨단로 242', 
    },
    {
        groupAddress: '제주특별자치도 제주시 첨단로 241', 
    }
]; */

for (var i=0; i < listData.length ; i++) {
// 주소로 좌표를 검색합니다
geocoder.addressSearch(listData[i], function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

     /*   // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
        	content: result[0].y + "," + result[0].x
        });
        infowindow.open(map, marker);*/

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
})


};    
</script>

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
