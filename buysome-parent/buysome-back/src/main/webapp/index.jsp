<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台管理系统 | 欢迎使用</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="AdminLTE-2.4.2/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="AdminLTE-2.4.2/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="AdminLTE-2.4.2/dist/css/AdminLTE.css">
  <link rel="stylesheet" href="AdminLTE-2.4.2/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="css/main.css">
</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
  <header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
      <span class="logo-mini"><b>后台</b></span>
      <span class="logo-lg"><b>后台管理系统</b></span>
    </a>
    <!-- 头部导航栏 -->
    <nav class="navbar navbar-static-top">
      <!-- 侧边栏切换按钮-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">侧边栏切换按钮</span>
      </a>
      <!-- 导航栏 右侧菜单 -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">${sessionAdmin.username }</span>
            </a>
            <ul class="dropdown-menu">
              <!-- 用户头像 -->
              <li class="user-header">
                <img src="AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                <p>
                
                
                  ${sessionAdmin.username } - ${sessionAdmin.roleid==0?'超级管理员':sessionAdmin.roleid==1?'管理员':sessionAdmin.roleid==2?'用户':'' }
                  <small>欢迎登录后台管理系统</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-right">
                  <a href="admin/logout" class="btn btn-default btn-flat">退出</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${sessionAdmin.username }</p>
          <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
        </div>
      </div>
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">菜单</li>
        <!-- <li class="active treeview menu-open">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>系统设置</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="javascript:void(0);" href-url="admin/list"><i class="fa fa-circle-o"></i>管理员管理</a></li>
            <li><a href="index.html"><i class="fa fa-circle-o"></i>菜单管理</a></li>
          </ul>
        </li> -->
        <li class="active">
          <a href="javascript:void(0);" href-url="admin/list">
            <i class="fa fa-circle-o"></i>
            <span>管理员管理</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">8</small>
            </span>
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" href-url="shop/list">
            <i class="fa fa-files-o"></i>
            <span>店铺管理</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">8</small>
            </span>
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" href-url="goods/list">
            <i class="fa fa-th"></i> 
            <span>商品管理</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">8</small>
            </span>
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" href-url="category/list">
            <i class="fa fa-calendar"></i> 
            <span>分类管理</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">8</small>
            </span>
          </a>
        </li>
      </ul>
    </section>
  </aside>
  <div class="content-wrapper">
  	<iframe name="mainFrame" id="mainFrame"  src="" frameborder="0" scrolling="auto" width="100%"></iframe>
  </div>
	<!-- <div id="iframe"></div> -->
</div>

<!-- jQuery 3 -->
<script src="AdminLTE-2.4.2/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="AdminLTE-2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="AdminLTE-2.4.2/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="AdminLTE-2.4.2/dist/js/adminlte.js"></script>
<script src="js/main.js"></script>
</body>
</html>