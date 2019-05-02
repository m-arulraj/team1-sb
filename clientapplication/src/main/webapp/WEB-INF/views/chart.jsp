<!DOCTYPE HTML><%@ taglib prefix="spring"
                uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head> 
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color:#2A201E;
  padding: 5px 10px;
}

.header a {
  float: left;
  color: white;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: white;
  color: green;
}

.header a.active {
  background-color: #2A201E;
  color: blue;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
}
</style>
</head>
<body bgcolor="teal"> 
                <div class="header">
  <div class="header-right">
    <a href="/admin">HOME</a>
  </div>
</div>
<div id="chartContainer" style="height: 570px; width: 100%;"></div><script>
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                theme: "dark1", // "light1", "light2", "dark1", "dark2"
                title:{
                                text: "PROFIT-REPORT"
                },
                axisY: {
                                title: "PROFIT"
                },
                data: [{      
                                type: "column",  
                                showInLegend: true, 
                                legendMarkerColor: "dark1",
                                legendText: "MONTHS",
                                dataPoints: [  
                                                <c:forEach items="${dataPointsList}" var="profit" >
                     
                                                { y: ${profit.value} , label: "${profit.key}" },
     </c:forEach>    
                                                
                                ]
                }]
});
chart.render();

}
</script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
