<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"> 
	<title></title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<c:forEach items="${student1}" var="a" varStatus="st">
<c:if test="${a.survey_id eq param.id }">
<h1 align="center">${a.title}</h1>
<h3 align="center">${a.description}</h3>

<table class="table">
	<caption>问卷统计结果:</caption>
	<thead>
		<tr>
			<th>题目</th>
			<th>选项及其数量</th>
		</tr>
	</thead>
	<tbody>
	
	<c:forEach items="${student2}" var="b" >
<c:if test="${b.survey_id eq param.id }">
<tr>
<td>${b.question}[${b.type}]</td>
<c:forEach items="${student3}" var="c" >
<c:if test="${c.question_id eq b.question_id }">
<td>${c.option_text}</td>
<td>${c.sum}</td>
</c:if>
</c:forEach>
</tr>
</c:if>
</c:forEach>
	</tbody>
</table>
<hr>
${a.survey_id}
<h4><a href="TJServlet?id=${a.survey_id}">统计-饼状图</a><span class="label label-default">饼状</span></h4>
<hr>
<h4><a href="TXServlet?id=${a.survey_id}">统计-条形图</a><span class="label label-default">条形</span></h4>
<hr>
</c:if>
</c:forEach>
</body>
</html>