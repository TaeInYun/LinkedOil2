<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
 
    var arr = [['date','휘발유']];
    $(function(){
    	$.ajax({url:"main/listWeekOilPrice.jsp",success:function(data){
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
    	
    });
    
   
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
    <div id="curve_chart" style="width: 600px; height: 350px"></div>
  </body>
</html>