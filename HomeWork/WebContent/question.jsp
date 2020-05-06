<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="test/css" href="css/a.css">
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


		<div class="container">
            <div class="row row-centered">
             <div class="col-sm-4">
      <h2 align="left">---LHLH---</h2>
      <div class="fakeimg"><img src="images/logo.png" style="height:100px;width:120px"></div>
      <p></p>
      <h3>添加问题</h3>
      <p>请选择添加单选、多选、文本</p>
      <ul class="nav nav-pills ">
        <li class="active"><a href="createquestion.jsp">单选题</a></li>
        <li class="active"><a href="createmorequestion.jsp">多选题</a></li>
        <li><a href="createtextquestion.jsp">文本题</a></li>
      </ul>
      <hr class="hidden-sm hidden-md hidden-lg">
    </div>
            
 <div class="col-sm-8">
<h1 align="left">标题：${survey.title}</h1>
<br>
<h4 align="left"><strong>问卷说明：${survey.description}</strong></h4>
<hr>
	<c:forEach items="${student1}" var="a" varStatus="s">
	<c:if test="${a.survey_id eq survey.survey_id}">
		<tr>
			<td><strong>No.${s.count}:${a.question}  [${a.type}]</strong></td>
			<a href='Setquestion.jsp?setname=${a.question_id}'><h5 align="right" >【修改问题】</h5></a><br>
			<c:choose>
			<c:when test="${a.type eq 'text'}">
			<div class="form-group">
    		<label for="name">在下列框中输入:</label>
   	 		<textarea class="form-control" rows="3"></textarea>
   		 	</div>
			</c:when>
			<c:otherwise>
			<a href='addoption.jsp?setoption=${a.question_id}'><h5 align="right" >【添加选项】</h5></a><br>
			<c:set var="count" value="0" />
			<c:forEach items="${student2}" var="b" varStatus="t">
			<c:if test="${b.question_id eq a.question_id}">
			<c:set var="count" value="${count+1}" />		
			<td>${count}:${b.option_text}</td><a href='Setoption.jsp?setname=${b.option_id}'>【修改选项】</a><br><br>
			</c:if>
			</c:forEach>
			<hr>
			</c:otherwise>
			</c:choose>
		</tr>
		</c:if>
	</c:forEach>
	</div>
	</div>
	</div>
<h4 align="center"><a class="btn btn-primary " href='TJ.jsp'>提交审核</a></h4>
</body>
</html>