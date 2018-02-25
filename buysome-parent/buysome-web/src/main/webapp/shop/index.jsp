<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>${shop.name }</title>
<link rel="shortcut icon" type="image/ico" href="/favicon.ico">
<link rel="stylesheet" href="../style/weui.css"/>
<link rel="stylesheet" href="../example/example.css"/>
<!-- Font Awesome -->
<link rel="stylesheet" href="../style/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="../example/zepto.js"></script>
<link rel="stylesheet" href="../style/zhouyajing.css"/>
</head>
<body>
<div class="container" id="container">
<div class="page article tabbar js_show">
	<div class="page__bd" style="height: 100%;">
    	<!-- 外部框架 -->
        <div class="weui-tab">
            <div class="weui-tab__panel weui-tab__scoll">
			    <div class="page__bd">
			    
			    	<div class="wrapper weui-navbar weui-navbar_scoll" id="wrapper">
					<div class="scroller" style="width: 1204px; transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1); transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);">
						<ul class="clearfix">
							<li class="cur" style="margin-left: 0px; margin-right: 0px;"><a href="javascript:void(0)">推荐</a></li>
							<c:forEach items="${categorys }" var="a" >
			            		<li style="margin-left: 0px; margin-right: 0px;"><a href="../goods/list?categorycode=${a.code }" code="${a.code }">${a.name }</a></li>
			            	</c:forEach>
						</ul>
					</div>
					</div>
			    
			        <div class="weui-panel_access">		    
						<div class="weui-panel__bd">
					        <div class="weui-media-box weui-media-box_text">
					            <div class="weui-media-box_appmsg">
					                <div>
						                <i class="fa fa-qrcode fa-fw qrcode" aria-hidden="true"></i>
	                    				<img class="qrcodeimg" src="${shop.qrcode }"/>
										<h1 class="page__title">${shop.name }</h1>
										<p class="page__desc">${shop.description }</p>
									</div>
					            </div>			                    			                    
					        </div>
					    </div>
						<div class="weui-panel__bd">
					        <div class="weui-media-box weui-media-box_text">
					            <div class="weui-media-box_appmsg">
					                <img class="weui-media-box__thumb" src="${shop.shopcover }" srcset="${shop.shopcover } 2x">
					            </div>			                    			                    
					        </div>
					    </div>
					</div>
				</div>
			    <div class="page__bd">
			        <div class="weui-panel_access">
			            <div class="weui-panel__hd">店铺商品</div>
			            <div class="weui-panel__bd">
			            	<c:forEach items="${shopGoods }" var="a" >
			            		<a href="../goods/${a.id }" class="weui-media-box weui-media-box_appmsg">
				                    <div class="weui-media-box__hd">
				                        <img class="weui-media-box__thumb" src="${a.goodscover }" alt="">
				                    </div>
				                    <div class="weui-media-box__bd">
				                        <h4 class="weui-media-box__title">${a.title }</h4>
				                        <p class="weui-media-box__desc">${a.description }</p>
				                    </div>
				                </a>
			            	</c:forEach>
			            </div>
			        </div>
			    </div>
    		</div>
    		
    		<div class="weui-tabbar">
                <a href="/" class="weui-tabbar__item">
                    <i class="fa fa-home fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">首页</p>
                </a>
                <a href="list" class="weui-tabbar__item weui-bar__item_on">
                    <i class="fa fa-shopping-cart fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">店铺</p>
                </a>
                <!-- <a href="javascript:;" class="weui-tabbar__item">
                    <span style="display: inline-block;position: relative;">
                        <img src="./images/icon_tabbar.png" alt="" class="weui-tabbar__icon">
                        <span class="weui-badge weui-badge_dot" style="position: absolute;top: 0;right: -6px;"></span>
                    </span>
                    <p class="weui-tabbar__label">发现</p>
                </a> -->
                <a href="../about.jsp" class="weui-tabbar__item">
                    <i class="fa fa-book fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">关于</p>
                </a>
            </div>
    	</div>
    </div>
</div>
</div>
<script type="text/javascript">
$(function(){
	$(".qrcode").click(function(){
		 $(".qrcodeimg").toggle();
	});
	$(".qrcodeimg").click(function(){
		 $(".qrcodeimg").toggle();
	});
});
</script>
<script type="text/javascript" src="../js/myjs/flexible.js"></script>
<script type="text/javascript" src='../js/myjs/iscroll.js'></script>
<script type="text/javascript" src='../js/myjs/navbarscroll.js'></script>
<script type="text/javascript">
$(function(){
	$('#wrapper').navbarscroll();
});
</script>
</body>
</html>