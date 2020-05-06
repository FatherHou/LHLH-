<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>条形图</title>
</meta>
<link href="stylesheets/csschart.css" rel="stylesheet" type="text/css" media="screen" />
<style>
body {
	margin:0;
	padding:40px;
	background:#fff;
	font:70% Arial, Helvetica, sans-serif;
	color:#555;
	line-height:180%;
}

</style>
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
	<h1 id="test">LHLH-条形图</h1>
<ul class="yAxis">
	<li>100</li>
	<li>90</li>
	<li>80</li>
	<li>70</li>
	<li>60</li>
	<li>50</li>
	<li>40</li>
	<li>30</li>
	<li>20</li>
	<li>10</li>

</ul>
	<dl id="csschart">
		<c:forEach items="${student1}" var="b" >
		<c:if test="${ b.survey_id eq param.id}">
		<c:forEach items="${student}" var="a" >
		<c:if test="${ a.question_id eq b.question_id}">
		<c:if test="${a.sum != null}">
		<dt>${a.option_text}</dt>
		<dd class="p${a.sum}"><span><b>${a.sum}</b></span></dd>
		</c:if>
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
				
</dl>
<ul class="xAxis">
<c:forEach items="${student1}" var="b" >
		<c:if test="${ b.survey_id eq param.id}">
		<c:forEach items="${student}" var="a" >
		<c:if test="${ a.question_id eq b.question_id}">
		<c:if test="${a.sum != null}">
		<li>${a.option_text}</li>
		</c:if>
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
</ul>
</body>
</html>