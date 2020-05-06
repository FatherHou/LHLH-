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
<style> /*web background*/ .container{ display:table; height:100%; } .row{ display: table-cell; vertical-align: middle; } /* centered columns styles */ .row-centered { text-align:center; } .col-centered { display:inline-block; float:none; text-align:left; margin-right:-4px; } </style> 
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Welcome ${users.user_name} to LHLH questionnaire survey!"/>
</jsp:include>
<h1 align="center">创建问卷</h1>
<br><br><br><br><br><br>
 <div class="container">
            <div class="row row-centered">
                <div class="well col-md-6 col-centered">

<form action="SurveyServlet" method="post" style="width:400px">
<div class="form-group">
<label for="col-sm-2 control-label">问卷标题:</label>
<input type="text" name="title" value="问卷标题..." class="form-control" id="name" />
</div>
<div class="form-group">
<label for="col-sm-2 control-label">问卷说明:</label>
<input type="text" name="description" value="问卷描述..." class="form-control" id="focusedInput" />
</div>
<input type="hidden" name="user_id" value="${users.user_id }"/>
<button type="submit"class="btn btn-primary">创建</button>
<input type="reset" name="重置" class="btn btn-primary"/>
</form>
</div>
</div>
</div>
</body>
</html>