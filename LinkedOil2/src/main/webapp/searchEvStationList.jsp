<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">  
<link rel="stylesheet" href="css/maplist.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script> 
<!--  시도 선택을 위한 js-->
<script language="javascript">
/*//내 위치 불러오기 
function getLocation() {
	  if (navigator.geolocation) { // GPS를 지원하면
	    navigator.geolocation.getCurrentPosition(function(position) {
	      alert(position.coords.latitude + ' ' + position.coords.longitude);
	      //위도 경도를 불러옴
	    }, function(error) {
	      console.error(error);
	    }, {
	      enableHighAccuracy: false,
	      maximumAge: 0,
	      timeout: Infinity
	    });
	  } else {
	    alert('GPS를 지원하지 않습니다');
	  }
	}
	getLocation();*/

 
	
$('document').ready(function() {
	 var area0 = ["시/도 선택","서울","인천","대전","광주","대구","울산","부산","경기","강원","충북","충남","전북","전남","경북","경남","제주"];
	  var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
	   var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
	   var area3 = ["대덕구","동구","서구","유성구","중구"];
	   var area4 = ["광산구","남구","동구", "북구","서구"];
	   var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
	   var area6 = ["남구","동구","북구","중구","울주군"];
	   var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
	   var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
	   var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
	   var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
	   var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
	   var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
	   var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
	   var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
	   var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
	   var area16 = ["서귀포시","제주시","남제주군","북제주군"];


	 // 시/도 선택 박스 초기화
	 $("select[name^=sido]").each(function() {
	  $selsido = $(this);
	  $.each(eval(area0), function() {
	   $selsido.append("<option value='"+this+"'>"+this+"</option>");
	  });
	  $selsido.next().append("<option value=''>구/군 선택</option>");
	 });

	 

	 // 시/도 선택시 구/군 설정
	 $("select[name^=sido]").change(function() {
	  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
	  var $gugun = $(this).next(); // 선택영역 군구 객체
	  $("option",$gugun).remove(); // 구군 초기화

	  if(area == "area0")
	   $gugun.append("<option value=''>구/군 선택</option>");
	  else {
	   $.each(eval(area), function() {
	    $gugun.append("<option value='"+this+"'>"+this+"</option>");
	   });
	  }
	 });
});

	
</script>
</head>
<body>
<%@ include file="header.jsp" %>


<div id="container" >

<div id="map" style="width:100%;height:900px;"></div>

<!-- -----------지도 -->


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=383beb63eac8714dec4cc534f56f27f8&libraries=services"></script>
<script>
	
var mapContainer = document.getElementById('map');
var mapOption = {
    center: new daum.maps.LatLng(37.450701, 126.570667),
    level: 8
};  

var map = new daum.maps.Map(mapContainer, mapOption); 
		
		
var geocoder = new daum.maps.services.Geocoder();

//주소를 배열에 담기
var listData = new Array();
<c:forEach items="${list}" var="e">
listData.push("${e.ev_addr}");
</c:forEach>

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

<!-- ----------------------------------리스트-- ----------------- -->	

<div id="list" >
 <b>충전소 리스트</b><br>
<div class="select">
<form action="searchEvStationList.do" method="post" >
      <select name="sido1" id="sido1"></select> 
      <select name="gugun1" id="gugun1"></select> 
                  
      <input type="submit" value="검색">
</form>
</div>

<div class="table" >
	<table class="table table-hover" style="table-layout: fixed">
	<colgroup>
	<col style="width:40%;">
	<col style="width:30%;">
	<col style="width:15%;">
	<col style="width:15%;">
	</colgroup>
		<thead>
		<tr bgcolor="#f2f2f2" >
			<th>이름</th>
			<th>주소</th>
			<th style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" >리뷰수</th>
			<th>평점</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${list}">
			<tr>
				
				<td><a href="detailEvStation.do?ev_id=${e.ev_id }">${e.ev_name}</a></td>
				<td style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;">${e.ev_addr }</td>
				<td >${e.review_cnt }</td>
				<td style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;" >${e.asterion_avg }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="pagination"> 
	<c:if test = "${startPage > 1}">
		<a href="searchEvStationList.do?pageNUM=${startPage-1}">&laquo;</a>
	</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="searchEvStationList.do?pageNUM=${i}">${i}</a>
		</c:forEach>
	<c:if test = "${endPage < totalPage}">
		<a href="searchEvStationList.do?pageNUM=${endPage+1}">&laquo;</a>
	</c:if>
	</div>
		
	</div>
		
</div>
</div>
<%@ include file="footer.jsp" %>
</body>

</html>
