<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/modernizr.custom.js"></script>
    
    <script type="text/javascript">
 
    
	 var arr = [['date','휘발유']];
    function setCodeName(c){
    	arr = [['date',c]];
    	$.ajax({url:"listWeekOilPrice.do?oil_code_name="+c,success:function(data){
    		console.log(data);
    		i=0;
    		$.each(data, function(index,item){
    			
    			if(i==0){
    				row = [];    				
    				
    				row.push(item['week']);    				
    			}
    			row.push(item['price']);
    			i++;
    			if(i == 1){
    				arr.push(row);
    				i=0;
    			}
    		
    		});
    		 google.charts.load('current', {'packages':['corechart']});
    		 google.charts.setOnLoadCallback(drawChart);
    	}});
    }
    
      function drawChart() {
        var data = google.visualization.arrayToDataTable(arr);

        var options = {
	          title: '최근 7일간 일일 유가 평균가격',
	          curveType: 'function',
	          legend: { position: 'bottom' },
	          responsive: false,
	          scales: {
				yAxes: [{
					ticks: {
						stepSize : 10
					}
				}]
			}
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }

</script>

</head>
<body>
	<ul class="grid cs-style-4">
		<li>
			<figure>
				<div>
					<a href="selectGasStation.do">
						<img src="images/main03.jpg" alt="img05">
					</a>
				</div>
				<figcaption>
					<h3>주유소</h3>
					<span>Gas Station</span>
					<a href="selectGasStation.do">검색하기</a>
				</figcaption>
			</figure>
		</li>
		<li>
			<figure>
				<div>
					<a href="searchEvStationList.do">
						<img src="images/main02.jpg" alt="img05">
					</a>
				</div>
				<figcaption>
					<h3>전기차 &nbsp;충전소</h3>
					<span>EV charging station</span>
					<a href="searchEvStationList.do">검색하기</a>
				</figcaption>
			</figure>
		</li>
		<li>
			<figure>
				<div>
					<a href="selectYososu.do">
						<img src="images/main01.jpg" alt="img05">
					</a>
				</div>
				<figcaption>
					<h3>요소수</h3>
					<span>Diesel exhaust fluid</span>
					<a href="selectYososu.do">검색하기</a>
				</figcaption>
			</figure>
		</li>
	</ul>
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
			<li><a href="#" onclick="setCodeName('고급휘발유')">고급휘발유</a></li>
			<li><a href="#"  onclick="setCodeName('휘발유')">휘발유</a></li>
			<li><a href="#"  onclick="setCodeName('경유')">경유</a></li>
			<li><a href="#"  onclick="setCodeName('LPG')">LPG</a></li>
		</ul>
		
	</div>
	
    <div id="curve_chart" style="width: 600px; height: 350px"></div>
    
    
</body>
</html>