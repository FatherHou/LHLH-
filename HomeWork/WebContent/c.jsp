<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery饼状图比例分布数据显示代码 - xw素材网</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jsapi.js"></script>
<script type="text/javascript" src="js/corechart.js"></script>		
<script type="text/javascript" src="js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js/jquery.ba-resize.min.js"></script>
<script type="text/javascript">
gvChartInit();
$(document).ready(function(){
	$('#myTable5').gvChart({
		chartType: 'PieChart',
		gvSettings: {
			vAxis: {title: 'No of players'},
			hAxis: {title: 'Month'},
			width: 600,
			height: 350
		}
	});
});
</script>
<script type="text/javascript">
gvChartInit();
$(document).ready(function(){
		$('#myTable1').gvChart({
			chartType: 'PieChart',
			gvSettings: {
			vAxis: {title: 'No of players'},
			hAxis: {title: 'Month'},
			width: 600,
			height: 350
		}
	});
});
</script>
</head>
<body>
	
			<c:forEach items="${student}" var="a" >
		    <c:if test="${a.sum != null}">
		    <div style="width:600px;margin:0 auto;">
	       <table id='myTable5'>
			<thead>
				<tr>
					<th>${a.option_text}</th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>${a.sum}</th>
					
				</tr>
			</tbody>
				
		</table>  

	</div>	
	</c:if>
         </c:forEach>
</body>
</html>