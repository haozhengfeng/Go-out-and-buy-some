<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>首页</title>
<link rel="shortcut icon" type="image/ico" href="/favicon.ico">
<link rel="stylesheet" href="style/weui.css"/>
<link rel="stylesheet" href="example/example.css"/>
<!-- Font Awesome -->
<link rel="stylesheet" href="style/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="example/zepto.js"></script>
</head>
<body>
<div class="container" id="container">
<div class="page tabbar searchbar flex js_show">
    <div class="page__bd" style="height: 100%;">
        <div class="weui-tab">
            <div class="weui-tab__panel weui-tab__scoll">
	            <div class="weui-panel weui-panel_access">
			            <div class="weui-panel__hd">
			            	关于我们
			            </div>
			            <div class="weui-panel__bd">
			                <div class="weui-media-box weui-media-box_text">
				                <i class="fa fa-qrcode fa-fw qrcode" aria-hidden="true"></i>
		                    	<img class="qrcodeimg" src="images/qrcode_for_gh_d8d7461b9751_258.jpg"/>
			                    <h4 class="weui-media-box__title">好致富金服网</h4>
			                    <!-- <div class="weui-media-box_appmsg">
			                        <img class="weui-media-box__thumb" src="//i1.mifile.cn/a4/xmad_1513304443358_gzjfM.jpg" srcset="//i1.mifile.cn/a4/xmad_15133044464271_MtLzl.jpg 2x">
			                    </div>		 -->	                    			                    
			                    <p class="weui-media-box_appmsg">
			                    	 每个人都有一颗当老板的心，为用户提供免费共享平台。　　
			                    </p>
			                    <p class="weui-media-box__desc">
			                    	<a href="/" class="weui-cell_access weui-cell_link">进入首页</a>
			                    </p>
			                </div>
			            </div>
			        </div>
            </div>
            <div class="weui-tabbar">
                <a href="/" class="weui-tabbar__item">
                    <i class="fa fa-home fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">首页</p>
                </a>
                <a href="shop/list" class="weui-tabbar__item">
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
                <a href="javascript:;" class="weui-tabbar__item weui-bar__item_on">
                    <i class="fa fa-book fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">关于</p>
                </a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" class="tabbar js_show">
    $(function(){
        $('.weui-tabbar__item').on('click', function () {
            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
        });
    });
</script>
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