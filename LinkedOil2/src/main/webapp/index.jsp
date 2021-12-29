<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>링크드 오일</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/styles.css" rel="mainstylesheet">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <script src="js/modernizr.custom.js"></script>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

   <style>
      .price-flex {
         display: flex;
          align-items: center;
          justify-content: center;
       }
       
      .price-up-btn {
         width: 4rem;
         border-radius: 1.5rem; 
         font-size: 0.75rem; 
         background: #eb53741f;
         color: #EB5374;
         font-weight: bold;
      }
      
      
      .price-down-btn {
         width: 4rem;
         border-radius: 1.5rem; 
         font-size: 0.75rem; 
         background: #eff2ff;
         color: #5673EB;
         font-weight: bold;
      }
      
      .price-vs-div {
         width: 4rem;
         text-align: left;
         color: #464d52;
      }
      
      .font-small {
         font-size: small
      }
      
      .no-wrap {
         flex-wrap: nowrap;
      }
      
      #myTabContent {
         display: flex;
          flex-direction: column;
          justify-content: center;
          height: 90%;
       }
   
   </style>

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
   
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
 
    
    var arr = [['date','휘발유']];
    function setCodeName(c){
       arr = [['date',c]];
       console.log(c);
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

      
      setCodeName('고급휘발유')
</script>

</head>
<body>
   <jsp:include page="header.jsp"/>
   <div class="container">
	
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
      <div class="row m-0 w-100">
      <div class="col">
         <div class="card h-100">
            <div class="card-body">
               <ul class="nav nav-tabs font-small " id="myTab" role="tablist">
                  <c:forEach  var="t"  items="${list }" varStatus="status">
                     <li class="nav-item" role="presentation">
                         <button class="nav-link
                            <c:if test="${status.index == 0}">
                               active
                            </c:if>
                            "
                         id="${t.oil_name }-tab" data-bs-toggle="tab" data-bs-target="#${t.oil_name }" type="button" role="tab" 
                         aria-controls="${t.oil_name }" aria-selected="true">
                            ${t.oil_name}
                         </button>
                       </li>
                  </c:forEach>
               </ul>
               
               <div class="tab-content" id="myTabContent" >
                  <c:forEach  var="t"  items="${list }" varStatus="status">
                       <div class="tab-pane fade show 
                       
                        <c:if test="${status.index == 0}">
                            active
                         </c:if>
                        " id="${t.oil_name}" role="tabpanel" aria-labelledby="${t.oil_name}-tab">
                             <div class="row">
                                <div class="col text-center pr-0"  style="padding-right: 0">
                                   <div class="" style="color: gray; font-size: large;">오늘의 유가</div>
                                   <h3 style="font-size: xx-large; font-weight: bold">${t.price }원</h3>
                                </div>
                                <div class="col text-center" style="display: flex;
                                     font-size: small;
                                     padding-left: 0;
                                     flex-direction: column;
                                     justify-content: center;">
                                   <div class="price-flex mb-1" >
                                      <div class="price-vs-div">
                                         vs 어제 
                                      </div>
                                      <div class="btn btn-sm py-0 price-down-btn" >
                                         ${t.api_diff }
                                      </div>
                                   </div>
                                   <div class="price-flex mb-1">
                                      <div class="price-vs-div">
                                         vs 1주전
                                      </div>
                                      <div class="btn btn-sm py-0 price-up-btn" >
                                         ${t.week_diff }
                                      </div>
                                   </div>
                                   <div class="price-flex">
                                      <div class="price-vs-div">
                                         vs 1달전
                                      </div>
                                      <div class="btn btn-sm py-0 price-up-btn" >
                                         ${t.month_diff }
                                      </div>
                                   </div>
                                </div>
                             </div>
                       </div>
                    </c:forEach>
               </div>
            </div>
         </div>
         </div>
            
         <div class="col">
            <div class="card">
               <div class="card-body">
                  <ul class="nav nav-tabs font-small " id="myTab" role="tablist">
                       <li class="nav-item"  role = "presentation">
                         <a class="nav-link active" href="#" onclick="setCodeName('고급휘발유')">고급휘발유</a>
                       </li>
                       <li class="nav-item">
                         <a class="nav-link" href="#"onclick="setCodeName('휘발유')">휘발유</a>
                       </li>
                       <li class="nav-item">
                            <a class="nav-link" href="#"onclick="setCodeName('경유')">경유</a>
                       </li>
                       <li class="nav-item">
                            <a class="nav-link" href="#"onclick="setCodeName('LPG')">LPG</a>
                       </li>
                  </ul>
                  <div id="curve_chart" ></div>
               </div>
            </div>
         </div>
      </div>

      
   
   
   </div>

    
</body>
</html>