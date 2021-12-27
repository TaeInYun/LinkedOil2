<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
        			var bDiff = $("<p></p>").html(diff);
    				break;
        		case 'D047' :
        			var dPrice = $("<p></p>").html( price );
        			var dDiff = $("<p></p>").html(diff);
    				break;
        		case 'K015' :
        			var cPrice = $("<p></p>").html( price);
        			var cDiff = $("<p></p>").html(diff);
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
			<td>휘발유</td>
			<td>경유</td>
			<td>LPG</td>
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