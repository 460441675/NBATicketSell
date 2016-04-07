<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户注册页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	 <!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
	<!-- Custom CSS -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/font-awesome.css" rel="stylesheet"> 
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!----webfonts--->
	<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
	<!---//webfonts--->  
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body id="login">
  <div class="login-logo">
    <a href="index.html"><img src="images/logo.png" alt=""/></a>
  </div>
  <h2 class="form-heading">用户注册</h2>
  <form class="form-signin app-cam" action="User_reg_regok" method="post">
  		<p> <s:if test="#request.tip == null">
  </s:if>
  <s:else><s:property value="#request.tip"/></s:else><br></p>
      <input type="text" name="user.username" class="form-control1" placeholder="用户名" autofocus="">
      <input type="password" name="user.password" class="form-control1" placeholder="密码">
      <input type="text"  name="user.nickname" class="form-control1" placeholder="昵称">
      <input type="text"  name="user.tel" class="form-control1" placeholder="电话"  onkeyup="this.value=this.value.replace(/[^\d]/g,'')">
     <!--  <label class="checkbox-custom check-success">
          <input type="checkbox" value="agree this condition" id="checkbox1"> <label for="checkbox1">I agree to the Terms of Service and Privacy Policy</label>
      </label> -->
      <button class="btn btn-lg btn-success1 btn-block" type="submit">注册</button>
      <div class="registration">
          已有账号
          <a class="" href="login.jsp">
              登录
          </a>
      </div>
  </form>
   <div class="copy_layout login register">
	<p>NBA联赛售票系统</p>
   </div>
  </body>
</html>
