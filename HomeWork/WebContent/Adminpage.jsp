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
    	#adminList{
			margin-top:50px;
			width:1200px;
			margin-left: 20px;
			margin-right: 100px;
			position: relative;
			text-align:center;
		}
    	#adminInformation{
			width: 1000px;
			height: 750px;
		}
        #ai-head{
			width: auto;
			height: 50px;
		}
		#ai-imformation{
		    width:800px;
			margin-left: 200px;
			margin-top: 40px;
		}
		#idInput{
			width: 300px;
			height: 30px;
			border-radius: 7px;
		}
		#nameInput{
			width: 300px;
			height: 30px;
			border-radius: 7px;
		}
		#phoneInput{
			width: 300px;
			height: 30px;
			border-radius: 7px;
		}
        #sUser{
          	float: left;
          	width: 300px;
        }
        #changeAdminPassword{
			width: 800px;
			height: 750px;
		}
        #changeupassword{
			width: 800px;
			height: 750px;
		}
		#cupswd-head{
			width: auto;
			height: 50px;
			margin-left: 290px;
		}
		#cupswd-security{
			margin-left: 250px;
		}
		#oldPasswordInput{
			width: 300px;
			height: 30px;
			border-radius: 7px;
		}
		#newPasswordInput{
			width: 300px;
			height: 30px;
			border-radius: 7px;
		}
		#newPasswordInputAgain{
			width: 300px;
			height: 30px;
			border-radius: 7px;
		}
    	#searchcontainer{
        	float:left;
        	width: 300px;
        	margin-top: 100px;
        	margin-left:400px;
        	height: 150px;
        }
        #sQustionnaire{
          	float: left;
          	width: 300px;
        }
        #searchbutton{
        	float: right;
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
	<div class="wrap">
    <!-- 左边导航栏-->
       <div id="left" class="left">
           <div id="logoDiv" class="logoDiv">
               <p id="logoTitle" class="logoTitle">
               		<img id="logo" alt="picture-log" src="./image/logo.jpg" style="height: 28px; padding-right: 5px;vertical-align: middle;">
                    <span style="font-size:18px;">${admin.admin_name}</span>
               </p>
            </div>
                    <div class="menu-item" data-toggle="collapse" data-target="#madmin" onmouseover="mouseover('hadmin')" onmouseout="mouseout('hadmin')" id="hadmin" style="font-weight: bold;color:#707983;">- Manage Administrator Account</div>
	                <div id="madmin" class="collapse" style="background-color:#666666">
	                    <div class="menu-item" href="#adminList" data-toggle="tab" onmouseover="mouseover('hadminlist')" onmouseout="mouseout('hadminlist')" id="hadminlist"> 
	                         &nbsp;&nbsp;Administrator Account List
	                    </div>
	                    <div class="menu-item" href="#search_admin" data-toggle="tab" onmouseover="mouseover('hsearchadmin');" onmouseout="mouseout('hsearchadmin')" id="hsearchadmin">
	                         &nbsp;&nbsp;Search Administrator Account
	                    </div>
	                    <div class="menu-item" href="#adminInformation" data-toggle="tab" onmouseover="mouseover('hmyadmin');" onmouseout="mouseout('hmyadmin')" id="hmyadmin">
	                         &nbsp;&nbsp;Manage My Account
	                    </div>
	                    <div class="menu-item" href="#changeAdminPassword" data-toggle="tab" onmouseover="mouseover('cmyadmin');" onmouseout="mouseout('cmyadmin')" id="cmyadmin">
	                         &nbsp;&nbsp;Change My Password
	                    </div>
                    </div>
                    
                    <div class="menu-item" data-toggle="collapse" data-target="#muser" onmouseover="mouseover('huser')" onmouseout="mouseout('huser')" id="huser" style="font-weight: bold;color:#707983;">- Manage User Account</div>
	                <div id="muser" class="collapse" style="background-color:#666666">
	                    <div class="menu-item" href="#search_user" data-toggle="tab" onmouseover="mouseover('hsearchuser')" onmouseout="mouseout('hsearchuser')" id="hsearchuser"> 
	                         &nbsp;&nbsp;Search User Account
	                    </div>
	                    <div class="menu-item" href="#add_user" data-toggle="tab" onmouseover="mouseover('hadduser')" onmouseout="mouseout('hadduser')" id="hadduser"> 
	                         &nbsp;&nbsp;Add A User
	                    </div>
                    </div> 
                                 
                    
                    <div class="menu-item" data-toggle="collapse" data-target="#mquestionnaire" onmouseover="mouseover('hquestionnaire')" onmouseout="mouseout('hquestionnaire')" id="hquestionnaire" style="font-weight: bold;color:#707983;">- Manage Questionnaire</div>
	                <div id="mquestionnaire" class="collapse" style="background-color:#666666">
	                    <div class="menu-item" href="#search_questionnaire" data-toggle="tab" onmouseover="mouseover('hsearchquestionnaire')" onmouseout="mouseout('hsearchquestionnaire')" id="hsearchquestionnaire"> 
	                         &nbsp;&nbsp;Search Questionnaire
	                    </div>

	                    <div class="menu-item" href="#examine_questionnaire" data-toggle="tab" onmouseover="mouseover('hexaminequestionnaire')" onmouseout="mouseout('hexaminequestionnaire')" id="hexaminequestionnaire"> 
	                         &nbsp;&nbsp;Examine Questionnaire
	                    </div>
                    </div> 
					
                </div>
				
				<!-- 添加导航栏所链接的内容-->
				
                <div id="right" class="tab-content right">
                        <!-- 欢迎页面 -->
                        <div id="one" class="tab-pane active">
                            <div id="welcome">
                            </div>
                        </div>
                        
                        
                        <div class="tab-pane" id="adminList" style="position: relative">
            			<h2  style="text-align:center;">Welcome to AdminList page,${nowAdmin.admin_name}!</h2>
						<table id="ordertab" border="1" width=100% cellpadding="5" style="margin-left:5px;margin-right:30px;">
						<thead>
						<tr>			
				  			<th style="text-align:center;"><font size="4">ID</font></th>
				  			<th style="text-align:center;"><font size="4">Name</font></th>
				  			<th style="text-align:center;"><font size="4">Phone</font></th>
				  			<th style="text-align:center;"><font size="4">Actor</font></th>
						</tr>
						</thead>
						<c:forEach items="${admins }" var="admin" varStatus="loop">
						<tr>
							<td><font size="4">${admin.admin_id }</font></td>
							<td><font size="4">${admin.admin_name }</font></td>
							<td><font size="4">${admin.admin_phone }</font></td>
							<td><font size="4">${admin.actor }</font></td>
						</tr>
						</c:forEach>
						</table>
						</div>
                        
                        
				
						<!-- 搜索管理员-->
						<div id="search_admin" class="tab-pane" style="text-align:center;postion:relative;">
						<iframe src="SearchHou?searchAdmin=" style="width:100%;height:1000px;;margin-top:0px;">
						</iframe>

                        </div>
						
						
						<!-- 修改管理员密码-->
						<div class="tab-pane" id="changeAdminPassword" style="position: relative">
            					<div style="width: auto;height: 8px"></div>
            					<div id="cupswd-head">
  										<h3 style="text-indent: 5%;">Personal Security</h3>
									</div>
									<hr style="color: black">
								<form method="post" action="changePassword">
								<div id="cupswd-security">
									<p>OldPassword:
									<input id="oldPasswordInput" name="OldPassword" class="form-control" placeholder="please input your old password" type="password" maxlength="16">
									</p>
									<br/>
									<p>NewPassword:
									<input id="newPasswordInput" name="NewPassword" class="form-control" placeholder="please input your new password" type="password" maxlength="16">
									</p>
									<br/>
									<p>NewPasswordInputAgain:
									<input id="newPasswordInputAgain" name="NewPasswordAgain" placeholder="please input your new password again" class="form-control" type="password" maxlength="16">
									</p>
									<br/>
									<button id="cleanImformation" style="margin-left: 125px;" class="btn btn-primary btn-info" onclick="changePassword">Submit</button>
								</div>
								</form>
						</div>
						<script type="text/javascript">
                            function changePassword(){
                            	var oldPassword = document.getElementById("oldPasswordInput").value;
                            	var newPassword = document.getElementById("newPasswordInput").value;
                            	var newPasswordAgain = document.getElementById("newPasswordInputAgain").value;
                            	if(oldPassword == "")
                            		alert("old password can't be null");
                            	else
                            		if(newPassword == "")
                            			alert("new password can't be null");
                            		else
                            		{
                            			if(newPasswordAgain == "")
                            				alert("please input new password again");
                            			else
                            				{
                            				   if(newPassword == newPasswordAgain){
                            					   if(confirm("Are you sure to cahnge the password?")){
                          					  		 document.getElementById("changepd").submit();
                          				
                          					       }   
                            				   }
                            				   else
                            					   alert("the two input password is inconsistent.");
                            				}
                            		}
                            }
                        </script>
						
						
						<!-- 管理员个人资料 -->
						<div id="adminInformation" class="tab-pane">
                            <div style="width: auto;height: 8px"></div>
								<div id="ai-head">
									<h3 style="text-indent: 5%">Administrator Information</h3>
								</div>
								<hr style="color: black">
								<div id="ai-imformation" >
									<p>ID:<input id="idInput" class="form-control" value="${admin.admin_id }" readonly></p>
									<p>Name:<input id="nameInput" class="form-control" value="${admin.admin_name }"></p>
									<p>Phone:<input id="phoneInput" class="form-control" value="${admin.admin_phone }"></p>
									<br/>
									<button id="modify" class="btn btn-primary btn_search" onclick="modifyImformation()">modify</button>
								</div>
						</div>
						 <script type="text/javascript">
        					function modifyImformation(){
        						var name = document.getElementById("nameInput").value;
        						var phone = document.getElementById("phoneInput").value;
        						if(name != ""){
        							if(phone != ""){
        								if(confirm("Are you sure to modify the personal imformation?")){
        									modifyurl="modifyInformation?Name="+name+"&&Phone="+phone;
        									window.location.href=modifyurl;
        									alert("modify successfully!");
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
						
						<!-- 搜索用户 -->
						<div id="search_user" class="tab-pane" style="text-align:center;postion:relative;">
						<iframe src="SearchUser?searchUser=" style="width:100%;height:1000px;;margin-top:0px;">
						</iframe>
						
                        </div>
                        
                        <!-- 添加用户-->
						<div id="add_user" class="tab-pane" style="text-align:center;postion:relative;">
						<iframe src="AddUser?Id=&&Name=&&Phone=&&Password=&Actor=&&Birthday==&&Eamil=" style="width:100%;height:1000px;;margin-top:0px;">
						</iframe>

                        </div>
								
						
						<!--搜索问卷-->
						<div id="search_questionnaire" class="tab-pane" style="text-align:center;postion:relative;">
						<iframe src="SearchSurvey?searchSurvey=" style="width:100%;height:1000px;;margin-top:0px;">
						</iframe>

                        </div>
                        <!--审核-->
						<div id="examine_questionnaire" class="tab-pane" style="text-align:center;postion:relative;">
						<iframe src="ExaminaServlet" style="width:100%;height:1000px;;margin-top:0px;">
						</iframe>

                        </div>
                </div>
      </div>
</body>
    <script>
         $(function() {
           		$(".menu-item").click(function() {
                    $(".menu-item").removeClass("menu-item-active");
                    $(this).addClass("menu-item-active");
                    var itmeObj = $(".menu-item").find("img");
                    itmeObj.each(function() {
                        var items = $(this).attr("src");
                        items = items.replace("_grey.png", ".png");
                        items = items.replace(".png", "_grey.png")
                        $(this).attr("src", items);
                    });
                    var attrObj = $(this).find("img").attr("src");;
                    attrObj = attrObj.replace("_grey.png", ".png");
                    $(this).find("img").attr("src", attrObj);
                });
            });
            function changeFrameHeight(){
				var ifm=document.getElementById("fourIfm"); 
            	ifm.height = document.documentElement.clientHeight;
            }
            window.onresize=function(){  
                 changeFrameHeight();  
            }
            function mouseover(divname){
            	var color=document.getElementById(divname);
            	color.style.color="#FFFFFF";
            }
            function mouseout(divname){
            	 var color=document.getElementById(divname);
               	 color.style.color="#aab1b7";
            }
    </script>
</html>