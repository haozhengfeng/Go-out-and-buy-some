<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>${goods.title }</title>
<link rel="shortcut icon" type="image/ico" href="/favicon.ico">
<link rel="stylesheet" href="../style/weui.css"/>
<link rel="stylesheet" href="../example/example.css"/>
<!-- Font Awesome -->
<link rel="stylesheet" href="../style/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="../example/zepto.js"></script>
</head>
<body>
<div class="container" id="container">
<div class="page article tabbar js_show">
    <div class="page__bd" style="height: 100%;">
    	<!-- 外部框架 -->
        <div class="weui-tab">
            <div class="weui-tab__panel weui-tab__scoll">
            	<!-- 首页内容 -->
            	<div class="page__bd">
			        <div class="weui-panel_access">		    
						<div class="weui-panel__bd">
					        <div class="weui-media-box weui-media-box_text">
					            <div class="weui-media-box_appmsg">
					                <div>
						               <i class="fa fa-qrcode fa-fw qrcode" aria-hidden="true"></i>
					                    <img class="qrcodeimg" src="${shop.qrcode }"/>
								        <h1 class="page__title">${goods.title }</h1>
								        <p class="page__desc"><pre style="white-space: pre-wrap;word-wrap: break-word;">${goods.description }</pre></p>
								        <%-- <p class="page__desc">
								        	<a href="../shop/${goods.shopid }" class="weui-cell_link">
							                    <div class="weui-cell__bd">进入店铺</div>
							                </a>   
								        </p> --%>
									</div>
					            </div>			                    			                    
					        </div>
					    </div>
					</div>
			    </div>	
            	<div class="page__bd">
			        <div class="weui-panel_access">
            		<c:forEach items="${goodsPics }" var="a" >
					    <div class="weui-panel__bd">
					        <div class="weui-media-box weui-media-box_text">
					            <div class="weui-media-box_appmsg thumbnail">
					                <img src="${a.picurl }"/>
					            </div>			                    			                    
					        </div>
					    </div>
					</c:forEach>
					<%-- <div class="weui-panel__ft">
		                <a href="../shop/${goods.shopid }" class="weui-cell weui-cell_access weui-cell_link">
		                    <div class="weui-cell__bd">进入店铺</div>
		                </a>    
		            </div> --%>
					</div>
				</div>
            </div>
            <div class="weui-tabbar">
                <a href="/" class="weui-tabbar__item">
                    <i class="fa fa-home fa-fw" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">首页</p>
                </a>
                <a href="../shop/${goods.shopid }" class="weui-tabbar__item weui-bar__item_on">
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
                    <i class="fa fa-book fa-fw" aria-hidden="true" style="font-size:26px;"></i>
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
})
</script>
</body>
</html>