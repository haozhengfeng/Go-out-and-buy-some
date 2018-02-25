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
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<link rel="stylesheet" href="../style/zhouyajing.css"/>
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
								        <h1 class="page__title">${goods.title }</h1>
								        <p class="page__desc"><pre style="white-space: pre-wrap;word-wrap: break-word;">${goods.description }</pre></p>
								        <p class="page__desc">
								        	<a href="../shop/${goods.shopid }" class="weui-cell_link">
							                    <div class="weui-cell__bd">进入店铺</div>
							                </a>   
								        </p>
									</div>
					            </div>			                    			                    
					        </div>
					    </div>
					</div>
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

<script type="text/javascript">

$(function(){
	$.ajax({
        type : "post",
        url : "../ticket/config",
        dataType : "json",
        success : function(data) {
            wx.config({
                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: data.appId, // 必填，公众号的唯一标识
                timestamp: data.timestamp, // 必填，生成签名的时间戳
                nonceStr: data.nonceStr, // 必填，生成签名的随机串
                signature: data.signature,// 必填，签名，见附录1
                jsApiList: ["getLocation","onMenuShareAppMessage","openLocation"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
            });
            
            wx.ready(function(){
                // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
                
				/**
            	wx.checkJsApi({
            	    jsApiList: ['onMenuShareQQ'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
            	    success: function(res) {
            	        // 以键值对的形式返回，可用的api值true，不可用为false
            	        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
            	        if(res.checkResult.onMenuShareQQ){
            	        	alert("支持qq接口");
            	        }						
            	    }
            	});
                */
				
              
			  wx.onMenuShareQQ({
					title: '${goods.title }', // 分享标题
					desc: '${goods.title }', // 分享描述
					//link: ''+window.location.href, // 分享链接
					link: 'http://www.haozf.org/goods/${goods.id }',
					imgUrl: '${goods.goodscover }', // 分享图标
					success: function () {
					// 用户确认分享后执行的回调函数
						alert("分享给朋友成功");
					},
					cancel: function () {
					// 用户取消分享后执行的回调函数
						alert('已取消');
					},
                    fail: function (res) {
                      	alert(JSON.stringify(res));
                    }
				});
				
				
            	wx.onMenuShareAppMessage({
                    title: '商品${goods.title }', // 分享标题
                    desc: '商品${goods.title }', // 分享描述
                    link: 'http://www.haozf.org/goods/${goods.id }', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                    imgUrl: '${goods.goodscover }',
                    success: function () { 
                        // 用户确认分享后执行的回调函数
                        alert("分享给朋友成功");
                    },
                    cancel: function () { 
                        // 用户取消分享后执行的回调函数
                    	alert('已取消');
                    },
                    fail: function (res) {
                      	alert(JSON.stringify(res));
                    }
                });	

				
				/**
				wx.getLocation({
					type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
					success: function (res) {
						var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
						var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
						var speed = res.speed; // 速度，以米/每秒计
						var accuracy = res.accuracy; // 位置精度
						
						wx.openLocation({
							latitude: latitude, // 纬度，浮点数，范围为90 ~ -90
							longitude: longitude, // 经度，浮点数，范围为180 ~ -180。
							name: '', // 位置名
							address: '', // 地址详情说明
							scale: 1, // 地图缩放级别,整形值,范围从1~28。默认为最大
							infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
						});
						
					}
				});*/			
				
				
				/**
				wx.hideMenuItems({
					menuList: ["menuItem:share:appMessage"] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
				});*/
				
                
            });
            
            wx.error(function(res){
                // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
                alert("请求失败");
            });
        }
    });
})

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