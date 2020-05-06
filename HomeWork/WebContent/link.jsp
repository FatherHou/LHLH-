<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myTags" uri="simpleTags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">  
<script src="jquery/2.1.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="page-header">
<c:forEach items="${student3}" var="c" varStatus="st">
	<c:if test="${c.survey_id eq param.id}">
	 <h1 align="center">${c.title}
        <small>${c.description}</small>
    </h1>
<h5>此问卷已有<myTags:counter1/> 人参与问答<br>
参与时间:<myTags:simple1/> <br>
作者邮箱:<myTags:query
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/lhlh"
    user="root"
    pass=""
    sql="select user_email from user where user_id = '${c.user_id}'" />
   <h5> (如果您有任何问题，请和发起者联系)</h5>
     </h5>
	</c:if>
	</c:forEach>
</div>
 <form action="AnswerServlet" method="post">
   <c:set var="index" value="0" />
	<c:forEach items="${student1}" var="a" begin='0' end='8' step='1' varStatus="s">
	<c:if test="${a.survey_id eq param.id}">
	
    <c:set var="index" value="${index+1}" />
	<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">No.${index}:${a.question}  [${a.type}]</h3>
    </div>
    <c:choose>
			<c:when test="${a.type eq 'text'}">
			<div class="form-group">
    		<input type="checkbox" name="textid" value="${a.question_id}"/><em style="color:#FF0000">输入您的答案</em>
   	 		<textarea class="form-control" rows="3" name="tt" >答案:</textarea>
   	 		<input type="hidden" name="type" value="${a.type }"/>
   		 	</div>
			</c:when>
			<c:when test="${a.type eq 'one'}">
			<em style="color:#FF0000">仅能选择一个选项</em>
			<c:set var="count" value="0" />
			<c:forEach items="${student2}" var="b" varStatus="t">
			<c:if test="${b.question_id eq a.question_id}">	
			<c:set var="count" value="${count+1}" />
			 <table class="table">
        	<tr><td> <input type="checkbox" name="option_id" value="${b.option_id}"/>${count}:${b.option_text}</td></tr>
          	</table>	
			</c:if>
			</c:forEach>          	
			</c:when>
			<c:otherwise>
			<em style="color:#FF0000">可以选择多个选项</em>
			<c:set var="count" value="0" />
			<c:forEach items="${student2}" var="b" varStatus="t">
			<c:if test="${b.question_id eq a.question_id}">	
			<c:set var="count" value="${count+1}" />
			 <table class="table">
        	<tr><td> <input type="checkbox" name="option_id" value="${b.option_id}"/>${count}:${b.option_text}</td></tr>

          	</table>	
			</c:if>
			</c:forEach>
			</c:otherwise>
			</c:choose>
  
</div>		
		</c:if>
	</c:forEach>
	<input class="btn btn-primary"  type="submit" value="提交"/>
</form>	
</body>
</html>