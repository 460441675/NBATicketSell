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
<title>主页</title>
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
					<li class="m_2"><a href="Order_queryOrderByUserId_myOrder?user.userId=${sessionScope.user.userId }"><i class="fa fa-usd"></i>我的订单</a></li>
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
						<td>比赛时间</td>
						<td>地点</td>
						<td>一等座票价</td>
						<td>二等座票价</td>
						<td>三等座票价</td>
						<td>一等座库存</td>
						<td>二等座库存</td>
						<td>三等座库存</td>
						<td>详情</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.pageBean.list" id="ticket">
						<tr class="success" align="center">
							<td>${requestScope.ticket.ticketName }</td>
							<td>${requestScope.ticket.fixture }</td>
							<td>${requestScope.ticket.venue }</td>
							<td>${requestScope.ticket.highPrice }</td>
							<td>${requestScope.ticket.middlePrice }</td>
							<td>${requestScope.ticket.lowPrice }</td>
							<td>${requestScope.ticket.highStorage-requestScope.ticket.highSoldNum }</td>
							<td>${requestScope.ticket.middleStorage-requestScope.ticket.middleSoldNum }</td>
							<td>${requestScope.ticket.lowStorage-requestScope.ticket.lowSoldNum }</td>
							<s:if test="#session.user.nickname!=null">
								<s:if
									test="#ticket.highStorage-#ticket.highSoldNum==0&&#ticket.middleStorage-#ticket.middleSoldNum==0&&#ticket.lowStorage-#ticket.lowSoldNum==0">
									<td>票已售空</td>
								</s:if>
								<s:else>
									<td><a
										href="Order_ticketDetail_order?ticket.ticketId=<s:property value="#ticket.ticketId" />&user.userId=${sessionScope.user.userId}">订票</a></td>
								</s:else>
							</s:if>
							<s:else>
								<td><a href="login.jsp">登录后订票</a></td>
							</s:else>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<center>

				<s:if test="#request.pageBean.allRows == 0">
					目前没有在售票务信息，请联系管理员！
				</s:if>
				<s:else>
				<font size="2">共<font color="red"><s:property
							value="#request.pageBean.totalPage" /></font>页
				</font>&nbsp;&nbsp; <font size="2">共<font color="red"><s:property
							value="#request.pageBean.allRows" /></font>条记录
				</font><br> <br>
					<s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
					<s:else>
						<a href="Ticket_execute_welcome">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
							href="Ticket_execute_welcome?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
					</s:else>
					<s:if
						test="#request.pageBean.currentPage != #request.pageBean.totalPage">
						<a
							href="Ticket_execute_welcome?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
							href="Ticket_execute_welcome?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
					</s:if>
					<s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
			</center>
			<br>

			<center>
				<form action="Ticket_execute_welcome" onsubmit="return validate();">
					<font size="2">跳转至 <input type="text" size="2" name="page">页
						<input type="submit" value="跳转"></font>
				</form>

				</s:else>
			</center>
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
<script type="text/javascript">
	function validate() {
		var page = document.getElementsByName("page")[0].value;

		if (page > <s:property value="#request.pageBean.totalPage"/>) {
			alert("你输入的页数大于最大页数！");
			//下面这句用来跳转至首页
			//window.document.location.href = "blogAction";
			return false;
		}
			return true;
	}
</script>
</html>
