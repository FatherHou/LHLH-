<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">  
<script src="jquery/2.1.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<form action="SumServlet" method="post">
<c:forEach items="${student1}" var="a" varStatus="st">
<c:if test="${a.survey_id eq param.id }">
</c:if>
</c:forEach>
<c:forEach items="${student2}" var="b" >
<c:if test="${b.survey_id eq param.id }">
<c:forEach items="${student3}" var="c" >
<c:if test="${c.question_id eq b.question_id }">
<c:set var="sum" value="0" />
<c:forEach items="${student4}" var="d" >
<c:if test="${d.option_id eq c.option_id }">
<c:set var="sum" value="${sum+1}" />
<input type="hidden" name="option_id" value="${d.option_id}"/>
<input type="hidden" name="sum" value="${sum}"/>
</c:if>
</c:forEach>
</c:if>
</c:forEach>
</c:if>
</c:forEach>
 <img style="width:1600px;height:700px" src="images/logo2.jpg"/>
<button type="submit" class="btn btn-primary btn-lg btn-block">统计结果</button>
</form>
</body>
</html>