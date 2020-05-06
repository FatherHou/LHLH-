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

<table class="table table-hover">
	<caption>LHLH--我的表单</caption>
	<thead>
		<tr>
			<th>问卷标题</th>
			<th>问卷说明</th>
			<th>问卷发起者</th>
			<th>问卷状态</th>
			<th>问卷标号</th>
			<th>审核结果</th>
			<th>是否确定</th>
		</tr>
	</thead>
	
	<c:forEach items="${mysurvey}" var="my" varStatus="s">
	<tbody>
		<tr>
			<td>${my.title}</td>
			<td>${my.description}</td>
			<td>${my.user_id}</td>
			<td>${my.state}</td>
			<td>${my.survey_id}</td>
			<form action="SetstateServlet" method="post" >
          	<td><select class="option" name="state" style="width:80px;height:24px;"BACKGROUND-COLOR: #FFFFF0;color: #003366;>
                                <option value="审核通过">审核通过</option>
                                <option value="审核未通过">审核未通过</option>
                               </select></td>
           	<input type="hidden" name="survey_id" value="${my.survey_id}"/><br>
			<td><input type="submit" name="提交" value="确定"/></td>
			</form>
		</tr>
	</tbody>
	
	</c:forEach>
	
	
</table>

</body>
</html>