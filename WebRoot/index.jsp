<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <s:form method="post" action="userRegist">
   	
   	<s:textfield name="user.name"></s:textfield>
   	<s:password name="user.password"></s:password>
   	<s:submit>注册</s:submit>
    </s:form>
    <form method="post" action="userLogin">
   	
   	<input type="text" name="user.name"/>
   	<input type="password" name="user.password"/>
   	<input type="submit" value="登录"/>
    </form>
    
    <hr>

    <form method="post" action="userCheckLogin">
   	
   	用户名<input type="text" name="user.name"/>
   	token<input type="text" name="token"/>
   	<input type="submit" value="token登录"/>
    </form>
    
    <s:form method="post" action="notificationIssue">
   	
   	<s:textfield name="notification.message"></s:textfield>
   	<s:textfield name="notification.title"></s:textfield>
 
   	
   	<s:submit>发布通知</s:submit>
    </s:form>
    <s:form method="post" action="notificationList">
   	
   	<s:textfield name="count"></s:textfield>
   	<s:textfield name="offset"></s:textfield>
   	
   	<s:submit>查询条数</s:submit>
    </s:form>
<hr/>

   	<s:form method="post" action="userModify">
   	
  	<s:textfield name="user.name">用户名</s:textfield>
  	<s:textfield name="user.id">用户id</s:textfield>
   	<s:textfield name="user.realName">真实姓名</s:textfield>
   	<s:textfield name="user.phone">电话</s:textfield>
   	<s:textfield name="user.email">邮箱</s:textfield>
   	
   	<s:submit>修改</s:submit>
    </s:form> 
    <hr>
    
   	<s:form method="post" action="userModify"  enctype="multipart/form-data" content-type="text/html">
   	
  	<s:textfield name="b" value="aaaaa"></s:textfield>
  	
   	
   	<s:submit>修改json</s:submit>
    </s:form> 

    <hr>
    <s:form method="post" action="userInfo">
   	
  	<s:textfield name="user.name">用户名</s:textfield>
  	<s:textfield name="user.id">用户id</s:textfield>
   	<s:textfield name="user.realName">真实姓名</s:textfield>
   	<s:textfield name="user.phone">电话</s:textfield>
   	<s:textfield name="user.email">邮箱</s:textfield>
   	
   	<s:submit>用户信息</s:submit>
    </s:form> 
    <hr>
    
        <form method="post" action="userUploadImg">
   	
   	img<input type="text" name="img"/>

   	<input type="submit" value="tijiao"/>
    </form>
    <hr>
    <form method="post" action="nc/ncList">
   	
   	<input type="text" name="nid"/>

   	<input type="submit" value="查询"/>
    </form>
  </body>
</html>
