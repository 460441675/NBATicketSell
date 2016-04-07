<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>添加订单</title>
	<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
	<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT"> 
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

<body>
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">NBA联赛票务代售系统</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="images/1.png" alt=""/></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header text-center">
							<s:if test="#session.user.nickname!=null">
							<strong>用户名：
    <s:property value="#session.user.nickname" />
							</strong>
						</li>
						<li class="m_2"><a href="User_userInfo_userInfo?user.userId=<s:property value="#session.user.userId" />"><i class="fa fa-user"></i>个人信息</a></li>
						<li class="m_2"><a href="Order_queryOrderByUserId_myOrder?user.userId=${sessionScope.user.userId }"><i class="fa fa-usd"></i>我的订单</a></li>
						<!-- <li class="divider"></li> -->
						<li class="m_2"><a href="securityCenter.jsp"><i class="fa fa-shield"></i>安全中心</a></li>
						<li class="m_2"><a href="User_logout_index"><i class="fa fa-lock"></i>退出登录</a></li>
						</s:if>
						<s:else>
							<strong>还没有登录哦</strong>
							<li class="m_2" align="center"><a href="login.jsp">登 录</a></li>
							<li class="m_2" align="center"><a href="reg.jsp">注 册</a></li>
						</s:else>	
	        		</ul>
	      		</li>
			</ul>
        </nav>
  	<div class="bs-example4" data-example-id="contextual-table">
  	<form action="Order_addOrder_addOrderSuccess?ticket.ticketId=${requestScope.ticket.ticketId }" method="post" onsubmit="return validate()">
    <table class="table">
      <thead>
      <tr  align="center">
        <td colspan="2" rowspan="1"><font size="6" color="black">票名：${requestScope.ticket.ticketName }</font></td>
        <td>比赛时间：<br>${requestScope.ticket.fixture }</td>
        <td>比赛地点:<br>${requestScope.ticket.venue }</td>
        <td>比赛详情:<br>${requestScope.ticket.details }</td>
      </tr>
        <tr align="center">
          <td>等级</td>
			<td>票价</td>
			<td>库存</td>
			<td>订购数量</td>
			<td>操作</td>
        </tr>
      </thead>
      <tbody>
      	<tr class="success" align="center">
      		<td>一等座</td>
    		<td>${requestScope.ticket.highPrice }</td>
    		<td>${requestScope.ticket.highStorage-requestScope.ticket.highSoldNum }</td>
    		<td><input name="order.highOrder" type="text" onkeyup="check(),this.value=this.value.replace(/[^\d]/g,'') " /></td>
    		<td>总价：<input name="order.orderPrice" id="total" readonly="readonly" type="text" /></td>
    		
      	</tr>
      	<tr class="success" align="center">
    		<td>二等座</td>
    		<td>${requestScope.ticket.middlePrice }</td>
    		<td>${requestScope.ticket.middleStorage-requestScope.ticket.middleSoldNum }</td>
    		<td><input name="order.middleOrder" type="text" onkeyup="check(),this.value=this.value.replace(/[^\d]/g,'') "/></td>
    		<td><input type="submit" value="提交订单" /></td>
    	</tr>
    	<tr class="success" align="center">
    		<td>三等座</td>
    		<td>${requestScope.ticket.lowPrice }</td>
    		<td>${requestScope.ticket.lowStorage-requestScope.ticket.lowSoldNum }</td>
    		<td><input name="order.lowOrder"  type="text" onkeyup="check(),this.value=this.value.replace(/[^\d]/g,'') "/></td>
    		<td></td>
    	</tr>
      </tbody>
    </table>
    <div class="copy_layout">
      <p>NBA联赛票务代售系统</p>
  </div>
   </div>
      </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
<!-- Nav CSS -->
<link href="css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
    
  </body>
  
  <script type="text/javascript">
  	function check() {
  		var highOrder = document.getElementsByName("order.highOrder")[0].value;
  		var middleOrder = document.getElementsByName("order.middleOrder")[0].value;
  		var lowOrder = document.getElementsByName("order.lowOrder")[0].value;
  		if(highOrder>${requestScope.ticket.highStorage-requestScope.ticket.highSoldNum }) {
  			document.getElementsByName("order.highOrder")[0].value="";
  			highOrder=0;
  			alert("请输入合法购买数量");
  		}else if(middleOrder>${requestScope.ticket.middleStorage-requestScope.ticket.middleSoldNum }) {
  			document.getElementsByName("order.middleOrder")[0].value="";
  			middleOrder=0;
  			alert("请输入合法购买数量");
  		}else if(lowOrder>${requestScope.ticket.lowStorage-requestScope.ticket.lowSoldNum }) {
  			document.getElementsByName("order.lowOrder")[0].value="";
  			lowOrder=0;
  			alert("请输入合法购买数量");
  			
  		}
		  	var totalPrice = highOrder * ${requestScope.ticket.highPrice} + middleOrder * ${requestScope.ticket.middlePrice} + lowOrder * ${requestScope.ticket.lowPrice}
  			document.getElementById("total").value=totalPrice;
  		
  	}
  	function validate() {
  		var highOrder = document.getElementsByName("order.highOrder")[0].value;
  		var middleOrder = document.getElementsByName("order.middleOrder")[0].value;
  		var lowOrder = document.getElementsByName("order.lowOrder")[0].value;
  		if(highOrder==0 && middleOrder==0 && lowOrder==0 ||(highOrder=="" && middleOrder=="" && lowOrder=="")) {
  			alert("请输入正确订购数量");
  			return false;
  		}
  	}
  </script>
</html>
