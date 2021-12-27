<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
    /*
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Year', 'Sales', 'Expenses'],
        ['2004',  1000,      400],
        ['2005',  1170,      460],
        ['2006',  660,       1120],	
        ['2007',  1030,      540]
      ]);

      var options = {
        title: 'Company Performance',
        curveType: 'function',
        legend: { position: 'bottom' }
      };

      var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

      chart.draw(data, option);
    */
      
 
    var arr = [['date','휘발유','고급휘발유','등유','경유','LPG']];
    $(function(){
    	$.ajax({url:"listWeekOilPrice.jsp",success:function(data){
    		console.log(data);
    		console.log("----------------------------------");
    		i=0;
    		$.each(data, function(index,item){
    			
    			if(i==0){
    				row = [];
    				row.push(item['week']);    				
    			}
    			row.push(item['price']);
    			i++;
    			if(i == 5){
    				arr.push(row);
    				i=0;
    			}
    		
    		});
    		console.log(arr);
    		 google.charts.load('current', {'packages':['corechart']});
    		 google.charts.setOnLoadCallback(drawChart);
    	}});
    	
    });
    
   
      function drawChart() {
        var data = google.visualization.arrayToDataTable(arr);

        var options = {
          title: '최근 7일간 일일 유가 평균가격',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="curve_chart" style="width: 900px; height: 500px"></div>
  </body>
</html>