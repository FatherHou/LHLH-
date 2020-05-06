<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> title here</title>
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
</head>
<body>
<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Welcome ${users.user_name} to LHLH questionnaire survey!"/>
</jsp:include>
<br><br><br><br><br><br>
<div class="container">

  <div class="row myCenter">
${question_id}
    <div class="col-xs-6 col-md-4 col-center-block">
<form action="AddoptionServlet" method="post" class="form-signin">
          	<input type="text" name="option_text" value="请输入选项..." class="form-control" /><br>
           	<input type="hidden" name="question_id" value="${param.setoption}"/><br>
			<input class="btn btn-primary" type="submit" name="提交" value="添加选项"/>
			</form>
			</div>
			</div>
			</div>
</body>
</html>