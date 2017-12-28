<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
<title>首页</title>
<link rel="stylesheet" href="style/weui.css"/>
<link rel="stylesheet" href="example/example.css"/>
<script type="text/javascript" src="example/zepto.min.js"></script>
</head>
<body>
<div class="container" id="container">
<div class="page article tabbar js_show">
    <div class="page__bd" style="height: 100%;">
    	<!-- 外部框架 -->
        <div class="weui-tab">
        	
            <div class="weui-tab__panel">
            	<!-- 首页内容 -->
            	<div class="page__hd">
			        <h1 class="page__title">Article</h1>
			        <p class="page__desc">文章</p>
			    </div>	
            	<div class="page__bd">
			        <article class="weui-article">
			            <h1>大标题</h1>
			            <section>
			                <h2 class="title">章标题</h2>
			                <section>
			                    <h3>1.1 节标题</h3>
			                    <p>
			                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
			                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
			                        consequat.
			                    </p>
			                    <p>
			                        <img src="./images/pic_article.png" alt="">
			                        <img src="./images/pic_article.png" alt="">
			                    </p>
			                </section>
			                <section>
			                    <h3>1.2 节标题</h3>
			                    <p>
			                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
			                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
			                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			                    </p>
			                </section>
			            </section>
			        </article>
			    </div>
			    
			    <div class="page__bd page__bd_spacing">
			        <div class="weui-footer">
			            <p class="weui-footer__links">
			                <a href="javascript:void(0);" class="weui-footer__link">底部链接</a>
			                <a href="javascript:void(0);" class="weui-footer__link">底部链接</a>
			            </p>
			            <p class="weui-footer__text">Copyright © 2008-2016 weui.io</p>
			        </div>
			        <div class="weui-footer weui-footer_fixed-bottom">
			            <p class="weui-footer__links">
			                <a href="javascript:home();" class="weui-footer__link">WeUI首页</a>
			            </p>
			            <p class="weui-footer__text">Copyright © 2008-2016 weui.io</p>
			        </div>
			    </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>