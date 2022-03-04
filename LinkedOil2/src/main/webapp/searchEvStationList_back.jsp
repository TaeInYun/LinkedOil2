<%@page import="java.util.ArrayList"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"   
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">  
<link rel="stylesheet" href="css/searchEvStationList.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=383beb63eac8714dec4cc534f56f27f8&libraries=services"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
$(function(){
	
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
	 
	 var geocoder = new daum.maps.services.Geocoder();	 
	 var listData;
	 var positions = [];
	 

	 var lat;
	 var lng;
	 
	 $.ajax({url:"getJsonListEvStation.do",success:function(data){
		 listData = data;	
		 $.each(data, function(index, item){
			 ev_addr = item['ev_addr'];
			var ev_name = item['ev_name'];
			geocoder.addressSearch(ev_addr, function(result, status) {
				if(status == 'OK'){
					lng = result[0].x;
					lat = result[0].y;
					
					//X:126.840197816779     lng
					//y:86 36.6788131460864   lat
					 //center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					console.log("lat:"+lat);
					console.log("lng:" +lng);
					item = {
							ev_name:ev_name, 
				        latlng: new kakao.maps.LatLng(lat, lng)
				    }
					positions.push(item);
				}
			});
			
			 
		 });//end each
		 
		 
		 setTimeout(() => {
			console.log("OK");
			console.log("lat:"+lat);
			console.log("lng:" +lng);
			
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
		        level: 10 // 지도의 확대 레벨
		    };

			// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
			var map = new kakao.maps.Map(mapContainer, mapOption); 
			
			
			for (var i = 0; i < positions.length; i ++) {
				
				  
				var iwContent = '<div style="padding:5px;">'+positions[i].ev_name+'</div><a href="detailGasStation.do?ev_name='+positions[i].ev_name+'" style="color:blue" target="_blank">정보보기</a></div>' 				
			    iwPosition = positions[i].latlng; //인포윈도우 표시 위치입니다
			    
			    
			    
			 	// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
				    position : iwPosition, 
				    content : iwContent 
				});
			    
				
			    
			    
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng
			       
			    });
			    
			 	// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker); 
			}
				        
			
		}, 1000);
		 
		
		 
		
		  
		
		 
		 
		 
		
		 
		 
	 }});   //end Ajax
	 
	
	/*
	addr: "충청남도 예산군 예산읍 예산로 135"
	color: "많음"
	inventory: "1300"
	lat: 36.6788315
	lng: 126.8401942
	name: "예산현대주유소"
	price: 1500
	tel: "041-332-2632"
	*/
	
	

	

	
		
});
	
	
</script>
 



 </head>
<body>

<%@ include file="header.jsp" %>


<div id=container>
	<!-- 검색창 -->
	<section id="selectbox">
		
		 
	
	<form action="searchEvStationList.do" method="post" >
      <select name="sido1" id="sido1"></select> 
      <select name="gugun1" id="gugun1"></select> 
                  
      <input type="submit" value="검색">
	</form>


		 	
	 	
	</section>
	
	
	<!-- 검색창 지도 -->
	<section id = "maplist">
	
	<div id="map" style="width:100%;height:700px;"></div>
	
	
									 
</script>
	
	</section>									 
									 
<!-- ----------------------------------리스트-- ----------------- -->		
<hr>
	
	
	<section id="list">
	<table class="table table-hover">
		<tr>
		 

			<td>이름</td>
			<td>주소</td>
			<td>리뷰수</td>
			<td>평점</td>
				
		
		
<c:forEach var="e" items="${list}">
			<tr>				
				<td><a style="text-decoration: none; color : black; " href="detailEvStation.do?ev_id=${e.ev_id }">${e.ev_name}</a></td>
				<td >${e.ev_addr }</td>
				<td >${e.review_cnt }</td>
				<td >${e.asterion_avg }</td>
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
	
	</section>	
</body>


</html>

