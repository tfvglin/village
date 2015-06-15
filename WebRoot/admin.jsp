<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台首页</title>
<link href="share/images/favicon.ico" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="public/share/css/share.css" />
<link rel="stylesheet" type="text/css"
	href="public/admin/css/default/index.css" />
<link rel="stylesheet" type="text/css"
	href="public/admin/css/default/share.css" />

<script type="text/javascript" src="public/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="public/share/js/jsUtil.js"></script>
<script src="public/admin/js/index.js" type="application/javascript"></script>
<script src="public/admin/js/index.js" type="application/javascript"></script>

<!-- ueditor -->
    <script type="text/javascript" charset="utf-8" src="public/Ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="public/Ueditor/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="public/Ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
	var options = {
          toolbars: [
               ['fullscreen', 'source', 'undo', 'redo', 'bold', 'italic', 'underline', 'fontborder', 'backcolor', 'fontsize', 'fontfamily', 'justifyleft', 'justifyright', 'justifycenter', 'justifyjustify', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', 'link', 'unlink', 'emotion', 'help']
          		]
    		};
			 UE.getEditor('editor',options);
  	</script>
</head>

<body>
	<div class="bezel" id="bezel-id">
		<div class="head">
			<div class="hleft">
				<span class="head-icon">社区管理平台</span>
			</div>
			<div class="hcenter">
				<ul>
					<li class="on">首页</li>
					<li>用户管理</li>
					<li>论坛管理</li>
					<li>消息管理</li>
				</ul>
			</div>
			<div class="hright">
				<span>当前登录用户：XX <a
					class="outLogin" href="#">注销登录 </a>登录时间：<a class="outLogin"
					href="javascript:outLogin()">退出</a>
				</span>
			</div>
		</div>
		<div class="center">
			<div class="cleft" id="cleft-id">
				<h4 class="on">用户管理</h4>
				<ul style="display:block;">
					<li class="on"><a href="login.html" target="contentMain">用户列表</a>
					</li>
					<li><a href="list.html" target="contentMain">XXXX</a>
					</li>

				</ul>
				<h4>论坛管理</h4>
				<ul>
					<li><a href="javascript:void(0)">XXXX</a>
					</li>
					<li><a href="javascript:void(0)">XXXX</a>
					</li>

				</ul>
				<h4>消息管理</h4>
				<ul>
					<li><a href="javascript:void(0)">推送消息</a>
					</li>
					<li><a href="javascript:void(0)">XXXX</a>
					</li>
				</ul>
				<h4>其他</h4>
			</div>
			<!-- <div id="showHideMenu"><div></div></div> -->
			<div class="rleft">
				<!--  <div class="position">ãå½åä½ç½®ï¼xxã&gt;ãxxã&gt;ãxx</div> -->
				<div class="center">
					<div class="topMenu">
						<ul>
							<li><a href="javascript:add()">添加</a>
							</li>
							<li><a href="#">删除</a>
							</li>
							<li><a href="#">修改</a>
							</li>
							
						</ul>
					</div>
					<div class="search">
						<span>姓名<input type="text" /></span> 
						<span>XXX<input type="text" /></span> 
						<span>XXX<input type="text" /></span> 
						<span>XXX<input type="text" /></span> 
						<span><input type="button" id="search-btn" value="搜索" /></span>
					</div>
					<div class="tableMain">
						<table class="right-table" width="99%" border="0px"
							cellpadding="0" align="center" cellspacing="0">
							<tbody>
								<tr>
									<th>aaaaa</th>
									<th>bbbbb</th>
									<th>ccccc</th>
									<th>ddddd</th>
									<th id="clearTDrightBorder">操作</th>
								</tr>
								<tr>

								</tr>
							</tbody>
						</table>
						<div>
    						<h1>demo</h1>
    					<%-- 	<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
						 --%>
						 	<textarea id="editor" style="width:700px;height:400px;"></textarea>
						 
						 </div>
					</div>
					<!--  <div id="page">
            <ul>
            <li class="first"><a href="#">&nbsp;é¦é¡µ&nbsp;</a></li>
            <li class="upPage"><a href="#">&nbsp;ä¸ä¸é¡µ&nbsp;</a></li>
            <li><a href="#">ã1ã</a></li>
            <li><a href="#">ã2ã</a></li>
            <li class="nextPage"><a href="#">&nbsp;ä¸ä¸é¡µ&nbsp;</a></li>
            <li class="lastPage"><a href="#">&nbsp;æ«é¡µ&nbsp;</a></li>
            </ul>
        </div> -->
				</div>
			</div>
		</div>
		<div class="floot" style="font-size:20px;">&copy版权信息</div>
	</div>
</body>
</html>
