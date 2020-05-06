<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="./css2/bootstrap.css" rel="stylesheet" media="screen"> 
<link rel="stylesheet" href="./css2/bootstrap.min2.css">
<link rel="stylesheet" href="./css2/bootstrap-table.css">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/bootstrap-table.js"></script>
<script src="./js/bootstrap-table-zh-CN.js"></script>
<link href="./css2/buttons-xiang.css" rel="stylesheet" media="screen">
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
        width: 250px;
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
            padding-left: 250px;
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
    #ordertab th:first-child{/*è®¾ç½®tableå·¦è¾¹è¾¹æ¡*/
        border-left: 2px solid #DCDCDC;
    }
 #ordertab td:first-child {/*è®¾ç½®tableå·¦è¾¹è¾¹æ¡*/
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
    #ordertab tr td:last-child{/*è®¾ç½®tableè¡¨æ ¼æ¯ååºé¨è¾¹æ¡*/
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
<style>
  	 #searchcontainer{
      	float:left;
      	width: 300px;
      	margin-top: 100px;
      	margin-left:400px;
      	height: 150px;
      }
      #searchbutton{
      	float: right;
      }
</style>
</head>
<body>
<script>
	function deletUser(ID){
		var deletUser="DeleteUser?ID="+ID;             
		window.location.href=deletUser;		
	}
</script>
<div id="search_user" class="tab-pane" style="text-align:center;postion:relative;">
<form method="POST" action="SearchUser">
    <div id="searchcontainer">
			<input id="sUser" type="text" name="searchUser" class="form-control" placeholder="please input key words">
			<button id="searchbutton" type="submit" name="btn_submit" class="btn btn-primary btn-info">search</button>
	</div>
</form>
<div  style="text-align:center;postion:relative;margin-left:100px;">
<c:choose>
<c:when test="${fn:length(userList)!=0 }">		
	<table id="ordertab" border="1" cellpadding="5" style="margin-left:5px;margin-right:30px;width:1000px;margin-left:50px;">
		<thead>
			<tr>
			<th style="text-align:center;"><font size="4">User Id</font></th>
	  		<th style="text-align:center;"><font size="4">Name</font></th>
	  		<th style="text-align:center;"><font size="4">Phone</font></th>
	  		<th style="text-align:center;"><font size="4">Birthday</font></th>
	  		<th style="text-align:center;"><font size="4">Email</font></th>
	  		<th style="text-align:center;"><font size="4">Actor</font></th>
	  		<th style="text-align:center;"><font size="4">Operation</font></th>
	  		<th style="text-align:center;"><font size="4">Detail</font></th>
			</tr>
		</thead>
		<c:forEach items="${userList}" var="userList" varStatus="loop">
			<tr>
			<td><font size="4">${userList.user_id}</font></td>
			<td><font size="4">${userList.user_name}</font></td>
			<td><font size="4">${userList.user_phone}</font></td>
			<td><font size="4">${userList.user_bithday}</font></td>
			<td><font size="4">${userList.user_email}</font></td>
			<td><font size="4">${userList.actor}</font></td>
			<td><font size="4"><a onclick="deletUser(${userList.user_id})">删除</a></font></td>
			<td><font size="4"><a style="color:black;" href="UserDetail?user_id=${userList.user_id}">详情</a></font></td>
			</tr>
		</c:forEach>
	</table>
</c:when>
<c:otherwise>	
</c:otherwise>
</c:choose>
</div>
</div>
</body>
</html>