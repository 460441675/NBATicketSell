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
<title>我的订单</title>
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
<meta name="keywords"
	content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
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
<link
	href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="top1 navbar navbar-default navbar-static-top"
			role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">NBA联赛票务代售系统</a>
		</div>
		<!-- /.navbar-header -->
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle avatar"
				data-toggle="dropdown"><img src="images/1.png" alt="" /></a>
				<ul class="dropdown-menu">
					<li class="dropdown-menu-header text-center"><s:if
							test="#session.user.nickname!=null">
							<strong>用户名： <s:property value="#session.user.nickname" />
							</strong></li>
					<li class="m_2"><a
						href="User_userInfo_userInfo?user.userId=<s:property value="#session.user.userId" />"><i
							class="fa fa-user"></i>个人信息</a></li>
					<li class="m_2"><a href="Order_queryOrderByUserId_myOrder"><i class="fa fa-usd"></i>我的订单</a></li>
					<!-- <li class="divider"></li> -->
					<li class="m_2"><a href="securityCenter.jsp"><i
							class="fa fa-shield"></i>安全中心</a></li>
					<li class="m_2"><a href="User_logout_index"><i
							class="fa fa-lock"></i>退出登录</a></li>
					</s:if>
					<s:else>
						<strong>还没有登录哦</strong>
						<li class="m_2" align="center"><a href="login.jsp">登 录</a></li>
						<li class="m_2" align="center"><a href="reg.jsp">注 册</a></li>
					</s:else>
				</ul></li>
		</ul>
		</nav>
		<div class="bs-example4" data-example-id="contextual-table">
			<table class="table">
				<thead>
					<tr align="center">
						<td>票名</td>
						<td>联系人</td>
						<td>订单日期</td>
						<td>收货地址</td>
						<td>电话号码</td>
						<td>一等座订票数量</td>
						<td>二等座订票数量</td>
						<td>三等座订票数量</td>
						<td>订单总价</td>
						<td>是否付款</td>
						<td colspan="3">操作</td>
					</tr>
				</thead>
				<tr>
					<td colspan="12" align="center"><s:if test="#request.list.size()==0"><font size="4" color="black">还没有任何订单，赶快去<a href="index.jsp">订票</a>吧！</font></s:if></td>
				</tr>
				<s:else>
				<tbody>
					<s:iterator value="#request.list" id="order">
						<tr class="success" align="center">
							<td><s:property value="#order.ticket.ticketName" /></td>
							<td scope="row"><s:property value="#order.consignee" /></td>
							<td><s:property value="#order.orderDate" /></td>
							<td><s:property value="#order.address" /></td>
							<td><s:property value="#order.phone" /></td>
							<td><s:property value="#order.highOrder" /></td>
							<td><s:property value="#order.middleOrder" /></td>
							<td><s:property value="#order.lowOrder" /></td>
							<td><s:property value="#order.orderPrice" /> </td>
							<td><s:property value="#order.isPay" /> </td>
							<td><a href="">支付</a></td>
							<td><a href="Order_orderDetail_updateOrder?order.orderId=<s:property value="#order.orderId" />">修改</a></td>
							<td><a href="Order_deleteOrder_myOrder?order.orderId=<s:property value="#order.orderId" />">删除</a></td>
						</tr>
					</s:iterator>
				</tbody>
				</s:else>
			</table>
		</div>
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
</html>
