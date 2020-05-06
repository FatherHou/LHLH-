<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.*" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!doctype html>
<html>
<head>

	<meta charset="utf-8">
	<title>version2.0</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./css2/bootstrap.css" rel="stylesheet" media="screen"> 
    <link rel="stylesheet" href="./css2/bootstrap.min2.css">
    <link rel="stylesheet" href="./css2/bootstrap-table.css">
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/bootstrap-table.js"></script>
    <script src="./js/bootstrap-table-zh-CN.js"></script>
    <link href="./css2/buttons-xiang.css" rel="stylesheet" media="screen">
	<!-- 这里面对body的样式进行了更改 -->
	<!-- 一些 menu的样式也是直接改了，不过我估计应该没问题-->
	<style>
        body{
            margin:0; 
            padding:0;
            font-family: Lato,Helvetica,Arial,sans-serif;
            font-size: 14px;
            line-height: 1.772;
            color: #34495e;
            background-color: #fff;
        }
        .wrap {
            min-width: 100%;
            position: absolute;
            background: #eff3f6 bottom;
            min-height: 100%;
            overflow: hidden;
         }
        .left{
            margin-left:0px;
            position: absolute;
            box-sizing: border-box;
            width: 280px;
            height: 100%;
            background: #4D4D4D bottom;
         }
         .logoDiv{
                padding-top: 20px;
                padding-bottom: 20px;
                height: 70px;
                background-color:#383838;
                font-size: 17px;
                color: #fff;
                vertical-align: bottom;    
         }
         .logoTitle{
                margin-left:15px;
                line-height: 1.7;
          }
          .menu-title {
                margin-left:15px;
                color: #828e9a;
                padding-top: 10px;
                padding-bottom: 10px;
                font-size: 14px;
                font-weight: bold;
          }
          .menu-item {
                padding-left:15px;
                line-height: 40px;
                height: 40px;
                color: #aab1b7;
                font-size: 16px;
                cursor: pointer;
          }
          .menu-item-active {
                /*background-color: #99ffcc; */
                border-right: 4px solid #647f9d;
                color: #ffffcc;
          }
          .right{
                box-sizing: border-box;
                float: left;
                box-sizing: border-box;
                padding-left: 280px;
                overflow-y: overlay;
                overflow-x: hidden;
                clear: both;
                color: #717592;
                min-width: 100%;
                min-height: 500px;
          }
          .content{
          	margin-left:30px;
          	margin-top:80px;
          }
    </style>
    <style>
    	#userInformation{
			width: 1000px;
			height: 750px;
			padding-left: 80px;
		}
    </style>
    <style>
      #ordertab
        {
        
            border-collapse: separate;
            border-spacing: 0;
            border: 2px #DCDCDC;
            margin: 0 auto;
        }
        #ordertab td
        {
            border: 0px solid #DCDCDC;
            color: #666;
            height: 30px;
        }
		#ordertab th
		{
			border: 0px solid #DCDCDC;
            color: #666;
            height: 50px;
		}
        #ordertab thead th
        {
            background-color: #DCDCDC;
            width: 100px;
        }
        #ordertab tr:nth-child(odd)
        {
            background: #fff;
        }
        #ordertab tr:nth-child(even)
        {
            background: #DCDCDC;
        }
        #ordertab th:first-child{/*设置table左边边框*/
            border-left: 2px solid #DCDCDC;
        }
		#ordertab td:first-child {/*设置table左边边框*/
            border-left: 2px solid #DCDCDC;
        }

        #ordertab tr td:first-child,
        #ordertab tr td:nth-child(2),
        #ordertab tr td:nth-child(3),
        #ordertab tr td:nth-child(4),
        #ordertab tr td:nth-child(5),
        #ordertab tr td:nth-child(6),
        #ordertab tr td:nth-child(7),
        #ordertab tr td:nth-child(8),
        #ordertab tr td:nth-child(9),
        #ordertab tr td:last-child{/*设置table表格每列底部边框*/
            border-bottom: 2px solid #DCDCDC;
        }
        #ordertab tr:first-child th:first-child {
            border-top-left-radius: 15px;
        }

        #ordertab tr:first-child th:last-child {
            border-top-right-radius: 15px;
        }
        #ordertab tr:last-child td:first-child {
            border-bottom-left-radius: 15px;
        }

        #ordertab tr:last-child td:last-child {
            border-bottom-right-radius: 15px;
        }
    </style>
</head>
<body>
						
						
						<!-- 用户个人资料 -->
						<div id="userInformation" class="tab-pane">
                            <div style="width: auto;height: 8px"></div>
								<div id="ai-head">
									<h3 style="text-indent: 5%">Administrator Information</h3>
								</div>
								<hr style="color: black">
								<div id="ai-imformation" >
									<p>ID:<input id="idInput" class="form-control" value="${user.user_id }" readonly></p>
									<p>Name:<input id="nameInput" class="form-control" value="${user.user_name }"></p>
									<p>Password:<input id="passwordInput" class="form-control" value="${user.user_password }"></p>
									<p>Phone:<input id="phoneInput" class="form-control" value="${user.user_phone }"></p>
									<p>Birthday:<input id="birthdayInput" class="form-control" value="${user.user_bithday }"></p>
									<p>Email:<input id="emailInput" class="form-control" value="${user.user_email }"></p>
									<p>Actor:<input id="actorInput" class="form-control" value="${user.actor }" readonly></p>
									<br/>
									<button id="modify" class="btn btn-primary btn_search" onclick="modifyImformation()">modify</button>
								</div>
						</div>
						 <script type="text/javascript">
        					function modifyImformation(){
        						var name = document.getElementById("nameInput").value;
        						var phone = document.getElementById("phoneInput").value;
        						var password = document.getElementById("passwordInput").value;
        						var birthday = document.getElementById("birthdayInput").value;
        						var email = document.getElementById("emailInput").value;
        						var id = document.getElementById("idInput").value;
        						var actor = document.getElementById("actorInput").value;
        						if(name != ""){
        							if(phone != ""){
        								if(password != ""){
        									if(birthday != ""){
        										if(email != ""){
			        								if(confirm("Are you sure to modify the personal imformation?")){
			        									modifyurl="umodifyInformation?Name="+name+"&&Phone="+phone+"&&Password="+password+"&&Birthday="+birthday+"&&Email="+email+"&&Id="+id+"&&Actor="+actor;
			        									window.location.href=modifyurl;
			        									alert("modify successfully!");
			        								}
        										}else{
        											alert("please input the email!");
        										}
        									}else{
        										alert("please input the birthday!");
        									}
        								}else{
        									alert("please input the password!");
        								}
        							}
        							else{
        								alert("please input the phone!");
        							}
        						}
        						else {
        							alert("please input the name!");
        						}
        					}
					   </script>
						
</body>
</html>