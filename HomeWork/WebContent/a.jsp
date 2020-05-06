<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>圆形饼状</title>

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
/* holder */
#holder{margin:-350px 0 0 -350px;width:700px;height:700px;position:absolute;left:50%;top:50%;}
</style>

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/raphael-min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</head>
<body>
<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Welcome ${users.user_name} to LHLH questionnaire survey!"/>
</jsp:include>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">LHLH</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="Usermain.jsp">创建问卷</a></li>
			<li><a href="MySurveyServlet">我的问卷</a></li>
			<li><a href="Count1">统计问卷</a></li>
			<li><a href="Result1">问卷结果</a></li>
		</ul>
	</div>
	</div>
</nav>

<table>
	<tbody>
		<c:forEach items="${student1}" var="b" >
		<c:if test="${ b.survey_id eq param.id}">
		<c:forEach items="${student}" var="a" >
		<c:if test="${ a.question_id eq b.question_id}">
		<c:if test="${a.sum != null}">
		<tr>
		<th scope="row">${a.option_text}</th>
		<td>${a.sum}</td>
		</tr>
		</c:if>
		</c:if>
         </c:forEach>
         </c:if>
		</c:forEach>
	</tbody>
</table>
	
<div id="holder"></div>

</body>
</html>