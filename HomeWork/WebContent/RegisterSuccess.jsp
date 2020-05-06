<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册结果</title>
</head>
<body background="images/zhuce.jpg">
<br><br><br><br><br><br><br>
<c:choose>
	<c:when  test="${param.info eq 'yes'}">
	<h2 align="center" style="color:#AEEEEE">恭喜您注册成功，点击下面按钮，返回登录页面。</h2>
	<h4 align="center"><a href="Login.jsp"><button  type="button" class="btn btn-primary">返回登录</button></a></h4>
	</c:when>
	<c:otherwise>
	<h1 align="center" style="color:red">对不起，此手机账号已被注册</h1>
	<h2 align="center" style="color:white">请更换手机注册或通过邮件找回密码</h2>
	<br>
	<br>
	<h4 align=center><a href="UserRegister.jsp"><button  type="button" class="btn btn-primary">重新注册</button> </a> <a href=""><button  type="button" class="btn btn-primary">找回密码</button></a></h4>
	</c:otherwise>
</c:choose>
</body>
</html>