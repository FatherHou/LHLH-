<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">  
<script src="jquery/2.1.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
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

<br>
<button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
 <span class="glyphicon glyphicon-user"></span>  我的问卷
</button>


<table class="table table-hover">
	<caption>LHLH--我的表单</caption>
	<thead>
		<tr>
			<th>问卷标题</th>
			<th>问卷说明</th>
			<th>问卷发起者</th>
			<th>问卷标号</th>
			<th>查看结果</th>
		</tr>
	</thead>
	
	<c:forEach items="${mysurvey}" var="my" varStatus="s">
	<tbody>
	<c:if test="${my.user_id eq users.user_id}">
		<tr>
			<td>${my.title}</td>
			<td>${my.description}</td>
			<td>${users.user_name}</td>
			<td>${my.survey_id}</td>
			<td><a href="ResultServlet?id=${my.survey_id}">查看结果</a></td>
		</tr>
		</c:if>
	</tbody>
	
	</c:forEach>
	
	
</table>

</body>
</html>