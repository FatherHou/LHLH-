<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<script src="js/bootstrap.min.js"></script>
<style>
.col-center-block {
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>

</head>
<body>
<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Welcome ${users.user_name} to LHLH questionnaire survey!"/>
</jsp:include>
<br><br><br><br><br><br>

<div class="container">

  <div class="row myCenter">

    <div class="col-xs-6 col-md-4 col-center-block">
      <h5>请先点击添加问题按钮，创建问题。然后点击创建选项按钮，创建选项。</h5>
    <br><br>
<form action="QuestionServlet" method="post" class="form-signin">
<input type="text" name="question" value="问题..." class="form-control" /><br>
<input type="hidden" name="type" value="one"/><br>
<input type="hidden" name="survey_id" value="${survey.survey_id}"/>
<button class="btn btn-primary"  data-container="body" data-toggle="popover" data-placement="top"
            data-content="添加问题成功" type="submit">添加</button>
<input class="btn btn-primary"  type="reset" name="重置"/>
</form>
<br><br>
<c:set var="tjxx" value="${q.question_id}"></c:set>

<a href='createoption.jsp?setoption=${q.question_id}' class="list-group-item active" >添加选项</a><br>

<c:forEach items="${optionlist}" var="option1" varStatus="op">
<c:if test="${option1.question_id eq q.question_id}">
			<li class="list-group-item">${op.count}:${option1.option_text}</li>
			</c:if>
	</c:forEach>
	<br>
	<a  class="list-group-item active" href="QuestionList">完成</a>
	</div>
	</div>
	</div>
	<script>
$(function () { 
	$("[data-toggle='popover']").popover();
});
</script>
	
</body>
</html>
