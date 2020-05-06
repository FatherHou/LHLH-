<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="Jquery/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>

.col-center-block {

    float: none;

    display: block;

    margin-left: auto;

    margin-right: auto;

}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Welcome ${users.user_name} to LHLH questionnaire survey!"/>
</jsp:include>
<br><br><br><br><br><br>
<div class="container">

  <div class="row myCenter">

    <div class="col-xs-6 col-md-4 col-center-block">
<c:forEach items="${student2}" var="b" >
	<c:if test="${b.option_id eq param.setname}">
	<form action="SetoptionServlet" method="post" class="form-signin">
	<label for="col-sm-2 control-label">请填入您的修改的选项：</label><br>
	<input type="text" name="option_text" value="${b.option_text}" class="form-control" /><br>
	<input type="hidden" name="option_id" value="${b.option_id}" class="form-control" />
	<button type="submit"class="btn btn-primary">提交修改</button>
	</form>
	
	</c:if>
	</c:forEach>
</div>
</div>
</div>
</body>
</html>