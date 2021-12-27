<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
    $.ajax({url:"listDayStationPriceData.jsp",success:function(data){
       console.log(data);
        arr = data['RESULT']['OIL'];
        $.each(arr, function(index, item){
           var price= item['PRICE'];
           var diff = item['DIFF'];
           var prodcd = item['PRODCD'];
           
  
               switch(prodcd){
        		case 'B027' :
        			var bPrice = $("<p></p>").html(price);
        			var bDiff = $("<p></p>").html("어제보다 " + diff);
    				break;
        		case 'D047' :
        			var dPrice = $("<p></p>").html( price );
        			var dDiff = $("<p></p>").html("어제보다 " + diff);
    				break;
        		case 'K015' :
        			var cPrice = $("<p></p>").html( price);
        			var cDiff = $("<p></p>").html("어제보다 " + diff);
    				break;       				
        	}

             
           $("#bPrice").append(bPrice);
           $("#bDiff").append(bDiff);
           $("#dPrice").append(dPrice);
           $("#dDiff").append(dDiff);
           $("#cPrice").append(cPrice);
           $("#cDiff").append(cDiff);
           
        });
    }})      
 });
</script>


</head>
<body>
  
	<table>
		<tr>
			<th>휘발유</th>
			<th>경유</th>
			<th>LPG</th>
		</tr>
		<tr>
			<td> <div id="bPrice"></div></td>
			<td> <div id="dPrice"></div></td>
			<td> <div id="cPrice"></div></td>
		</tr>
		<tr>
			<td><div id="bDiff"></div></td>
			<td><div id="dDiff"></div></td>
			<td><div id="cDiff"></div></td>
		</tr>
	</table>
</body>
</html>