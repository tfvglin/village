﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CMS后台管理-登录</title>
<link href="public/share/images/favicon.ico" rel="shortcut icon"/>
<link href="public/share/css/share.css" rel="stylesheet" type="text/css"/>
<link href="public/admin/css/default/login.css" rel="stylesheet" type="text/css"  />
<link href="public/admin/css/default/share.css" rel="stylesheet" type="text/css"  />
</head>

<body id="loginBody">
<div id="pointerOpen" onclick="hideLoginBezel()">开启登录</div>
<div id="loginBezel">
<!-- <div id="loginChildTop" onclick="hideLoginBezel()" title="点击将隐藏登录小窗口">　CMS管理平台</div> -->
<div id="loginChildTop">　<img src="public/admin/images/logo-right.png" width="57" height="50" align="absbottom"  /> CMS管理平台</div>
<div id="loginChildBottom">
<table cellpadding="0" cellspacing="0" width="100%" height="95%" border="0">
<tr>
<td align="right" width="35%">账　号：</td>
<td align="left" width="65%"><input type="text" id="account"  class="inputUP"/></td>
</tr>
<tr>
<td align="right">密　码：</td>
<td align="left"><input type="password" id="pwd" class="inputUP"/></td>
</tr>
<tr>
<td align="right">验证码：</td>
<td align="left"><input type="text" id="checkNum"/>&nbsp;<span id="checkNumResult"><img src="public/admin/images/checkNum.jpg" id="checkImage" align="absbottom" alt="验证码" title="点击更换验证码" /></span></td>
</tr>
<tr>
<td align="center" colspan="2"><input type="button" onclick="toLogin(this)"  id="toLogin" value="登　录"/> </td>
</tr> 
</table>
</div>
</div>
<script src="public/js/jquery-1.11.1.js"></script>
<script src="public/admin/js/login.js"></script>
</body>
</html>
