<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="shortcut icon" href="assets/ico/logo.png">
    </head>

    <body background="images/2.jpg">
    

		<!-- Top menu -->
		<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
			<div class="container">
			
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right">
						<li>
						<h4>
						<img src="images/logo.png" style="width:30px;height:30px" >
						LHLH，让问答如此简单！
							</h4>
						</li>
					</ul>
				</div>
			</div>
		</nav>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-7 text">
                             <img src="images/logo.png" >
                             <h1><strong>LHLH-SURVER </strong> </h1>
                            <div class="description">
                            	<h4>
       							欢迎来到LHLH问卷调查系统！在这里 问答如此简单！<br><br>
                            	假如您还未注册，请点击注册！假如您忘记密码，请从管理员处找回密码！ 
                            	</h4>
                            </div>   
                        </div>
                        <div class="col-sm-5 form-box">
                        
                            <div class="form-bottom">
			            <form action="LoginServlet" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInRight">
						<div class="form-top-left">
                        		<Strong>登录：用户/管理员
								<select class="option" name="choice" style="width:80px;height:24px;"BACKGROUND-COLOR: #FFFFF0;color: #003366;>
                                <option value="user">用户</option>
                                <option value="admin">管理员</option>
                               </select>
                        	   </Strong>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-pencil"></i>
                        		</div>
						<div class="form-group">
							<label for="username" class="sr-only">Username</label>
							<input type="text" class="form-control" id="phone"  name="phone"   placeholder="账号/手机号码..." autocomplete="off"value="${phonecook}"/>
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="password" class="form-control" id="password" placeholder="密码..." autocomplete="off"name="password" value="${passwordcook}"/ >
		                <br>
		               
		               
						<div class="form-group">
						<td><input type="submit" value="登录" class="btn btn-primary"/></td>
						    <a href="UserRegister.jsp" class="btn btn-info">用户注册</a>
			                <br>
			                <td><font size="2" color="red">${ error }</font></td>
							
						</div>
					</form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyrights">Maked By<a href=""  title="Bibliosoft">Bibliosoft</a></div>
        </div>


        <!-- Javascript -->
       
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>