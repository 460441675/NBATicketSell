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
<title>会员信息界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
					<li class="m_2"><a href="Order_queryOrderByUserId_myOrder?user.userId=${sessionScope.user.userId }"><i class="fa fa-usd"></i>我的订单<span
							class="label label-default">42</span></a></li>
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
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.jsp"><i class="fa fa-dashboard fa-fw nav_icon"></i>主页</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-laptop nav_icon"></i>票务信息管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="Ticket_queryAllTicket_main">查询票务信息</a>
                                    <a href="addTicket.jsp">添加新票务</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-indent nav_icon"></i>会员信息管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="User_queryAllUser_allUser">查询会员信息</a>
                                </li>
                                <li>
                                    <a href="reg.jsp">添加会员</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                         <li>
                            <a href="#"><i class="fa fa-envelope nav_icon"></i>订单管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="Order_queryAllOrder_allOrder">查询订单信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
        <div class="col-md-12 graphs">
	   <div class="xs">
			<h3 align="center">修改会员信息</h3>
		<div class="bs-example4" data-example-id="contextual-table">
			<div class="tab-content">
				<div class="tab-pane active" id="horizontal-form">
					<form class="form-horizontal" action="User_updateUserInfoByAdmin_error"
						method="post">
						<input type="hidden" name="user.userId"
							value="${requestScope.user.userId }"> 
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">用&nbsp;&nbsp;户&nbsp;&nbsp;名</label>
							<div class="col-sm-8">
								<input type="text" name="user.username"
									value="${requestScope.user.username }" class="form-control1"
									id="focusedinput" placeholder="用户名">
							</div>
							<!-- <div class="col-sm-2">
										<p class="help-block">Your help text!</p>
									</div> -->
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
							<div class="col-sm-8">
								<input type="text" name="user.password"
									value="${requestScope.user.password }" class="form-control1"
									id="focusedinput" placeholder="密码">
							</div>
							<!-- <div class="col-sm-2">
										<p class="help-block">Your help text!</p>
									</div> -->
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</label>
							<div class="col-sm-8">
								<input type="text" name="user.nickname"
									value="${requestScope.user.nickname }" class="form-control1"
									id="focusedinput" placeholder="昵称">
							</div>
							<!-- <div class="col-sm-2">
										<p class="help-block">Your help text!</p>
									</div> -->
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label>
							<div class="col-sm-8">
								<input type="text" name="user.tel"
									value="${requestScope.user.tel }" class="form-control1"
									id="focusedinput" placeholder="电话" onkeyup="this.value=this.value.replace(/[^\d]/g,'')">
							</div>
							<!-- <div class="col-sm-2">
										<p class="help-block">Your help text!</p>
									</div> -->
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</label>
							<div class="col-sm-8">
								<input type="text" name="user.address"
									value="${requestScope.user.address }" class="form-control1"
									id="focusedinput" placeholder="地址">
							</div>
							<!-- <div class="col-sm-2">
										<p class="help-block">Your help text!</p>
									</div> -->
						</div>
						<div class="form-group">
									<label for="selector1" class="col-sm-2 control-label">权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限</label>
									<div class="col-sm-8"><select name="user.right" id="selector1" class="form-control1">
										<s:if test="#request.user.right==1">
										<option value="0">普通会员</option>
										<option selected="selected" value="1">管理员</option>
										</s:if>
										<s:else>
										<option value="0">普通会员</option>
										<option value="1">管理员</option>
										</s:else>
									</select></div>
								</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">身份证号</label>
							<div class="col-sm-8">
								<input type="text" name="user.idCard"
									value="${requestScope.user.idCard }" class="form-control1"
									id="focusedinput" placeholder="身份证号" onkeyup="this.value=this.value.replace(/[^\d]/g,'')">
							</div>
							<!-- <div class="col-sm-2">
										<p class="help-block">Your help text!</p>
									</div> -->
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">银行卡号</label>
							<div class="col-sm-8">
								<input type="text" name="user.bankCard"
									value="${requestScope.user.bankCard }" class="form-control1"
									id="focusedinput" placeholder="银行卡号" onkeyup="this.value=this.value.replace(/[^\d]/g,'')">
							</div>
							<!-- <div class="col-sm-2">
										<p class="help-block">Your help text!</p>
									</div> -->
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-sm-8 col-sm-offset-2">
									<button class="btn-success btn">修改</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			</div>
			<div class="copy_layout">
				<p>Copyright &copy; 2016. NBA联赛票务代售系统 All rights reserved.</p>
			</div>
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
