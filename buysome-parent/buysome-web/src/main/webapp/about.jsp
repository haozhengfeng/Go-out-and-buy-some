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
			            <div class="weui-panel__hd">关于我们</div>
			            <div class="weui-panel__bd">
			                <div class="weui-media-box weui-media-box_text">
			                    <h4 class="weui-media-box__title">北京小米科技有限责任公司</h4>
			                    <div class="weui-media-box_appmsg">
			                        <img class="weui-media-box__thumb" src="//i1.mifile.cn/a4/xmad_1513304443358_gzjfM.jpg" srcset="//i1.mifile.cn/a4/xmad_15133044464271_MtLzl.jpg 2x">
			                    </div>			                    			                    
			                    <p class="weui-media-box_appmsg">
			                    	　　北京小米科技有限责任公司成立2010年4月，是一家专注于智能硬件和电子产品研发的移动互联网公司。“为发烧而生”是小米的产品概念。小米公司创造了用互联网模式开发手机操作系统、发烧友参与开发改进的模式。小米还是继苹果、三星、华为之后第四家拥有手机芯片自研能力的科技公司。
			                    </p>
			                    <p class="weui-media-box__desc">
			                    	<a href="/" class="weui-cell_access weui-cell_link">小米官网</a>
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
                <a href="javascript:;" class="weui-tabbar__item">
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



</body>
</html>