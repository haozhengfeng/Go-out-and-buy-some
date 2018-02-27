<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>首页</title>
<link rel="shortcut icon" type="image/ico" href="/favicon.ico">
<link rel="stylesheet" href="../style/weui.css"/>
<link rel="stylesheet" href="../example/example.css"/>
<!-- Font Awesome -->
<link rel="stylesheet" href="../style/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../style/zhouyajing.css"/>
<link rel="stylesheet" href="../js/refresh/dropload.css">
<style type="text/css">
.outer{
	margin-top: 0px;
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction:column;
    -webkit-box-orient:vertical;
    box-orient:vertical;
    -webkit-flex-direction:column;
    flex-direction:column;
}
.inner{
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    -ms-flex: 1;
    flex: 1;
    background-color: #fff;
    overflow-y: scroll;
    -webkit-overflow-scrolling: touch;
    margin-bottom: 48px;
    margin-top: 40px;
}
</style>
</head>
<body>
<div class="container" id="container">
<div class="page tabbar searchbar flex js_show">
    <div class="page__bd" style="height: 100%;">
    	<!-- 外部框架 -->
        <div class="weui-tab">
            <div class="weui-tab__panel weui-tab__scoll">
	            <div class="page__bd">
		            <div class="wrapper weui-navbar weui-navbar_scoll" id="wrapper">
					<div class="scroller" style="width: 1204px; transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1); transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);">
						<ul class="clearfix">
							<li ${empty categorycode?'class="cur"':'' } style="margin-left: 0px; margin-right: 0px;"><a href="/">推荐</a></li>
							<c:forEach items="${categorys }" var="a" >
			            		<li ${categorycode==a.code?'class="cur"':'' } style="margin-left: 0px; margin-right: 0px;"><a href="list?categorycode=${a.code }" code="${a.code }">${a.name }</a></li>
			            	</c:forEach>
						</ul>
					</div>
					</div>
			        <div class="weui-panel outer">
			        	<div class="inner">
			            <div class="weui-panel__hd">热门商品</div>
			            <div class="weui-panel__bd ">
			            	<div class = 'lists'>
			            	<c:forEach items="${goodss }" var="a" >
			            	<a href="${a.id }" class="weui-media-box weui-media-box_appmsg">
			                    <div class="weui-media-box__hd">
			                    	<img class="weui-media-box__thumb" alt="${a.title }" src="${goodsCoverUrl }${a.goodscover }" style="vertical-align: middle;"/>
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
			        </div>
            </div>
            <div class="weui-tabbar">
                <a href="/" class="weui-tabbar__item">
                    <i class="fa fa-home fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">首页</p>
                </a>
                <a href="../shop/list" class="weui-tabbar__item  weui-bar__item_on">
                    <i class="fa fa-shopping-cart fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
                    <p class="weui-tabbar__label">店铺</p>
                </a>
                <a href="../about.jsp" class="weui-tabbar__item">
                	<span style="display: inline-block;position: relative;">
	                    <i class="fa fa-book fa-fw weui-tabbar__label" aria-hidden="true" style="font-size:26px;"></i>
	                    <p class="weui-tabbar__label">关于</p>
                    </span>
                </a>
            </div>
        </div>
    </div>
</div>

</div>

<script type="text/javascript" src="../example/zepto.js"></script>
<!-- <script type="text/javascript" src="../js/jquery-1.9.1/jquery.min.js"></script> -->
<script type="text/javascript" class="tabbar js_show">
    $(function(){
        $('.weui-tabbar__item').on('click', function () {
            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
        })
    })
</script>
<script type="text/javascript" src="../js/myjs/flexible.js"></script>
<script type="text/javascript" src='../js/myjs/iscroll.js'></script>
<script type="text/javascript" src='../js/myjs/navbarscroll.js'></script>
<script type="text/javascript">
$(function(){
	$('#wrapper').navbarscroll();
})
</script>

<script type="text/javascript" src="../js/refresh/dropload.js"></script>
<script type="text/javascript">
$(function(){
    var dropload = $('.inner').dropload({
    	domUp : {
            domClass   : 'dropload-up',
            domRefresh : '<div class="dropload-refresh">↓下拉刷新</div>',
            domUpdate  : '<div class="dropload-update">↑释放更新</div>',
            domLoad    : '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
        },
        domDown : {
            domClass   : 'dropload-down',
            domRefresh : '<div class="dropload-refresh">↑上拉加载更多</div>',
            domLoad    : '<div class="dropload-load"><span class="loading"></span>加载中...</div>',
            domNoData  : '<div class="dropload-noData">没有更多信息</div>'
        },
    	autoLoad : false,
        loadUpFn : function(me){
        	window.location.reload();
        },
        loadDownFn : function(me){
        	$.ajax({
                type: 'GET',
                url: 'ajaxlist',
                dataType: 'json',
                success: function(data){
                	
                	var goodsCoverUrl = '${goodsCoverUrl }';
                	
                	if(data.status=='yes'){
                		var result = '';
                        for(var i = 0; i < data.goods.length; i++){
                            result +=   '<a href="'+data.goods[i].id+'" class="weui-media-box weui-media-box_appmsg">'
                        	+'<div class="weui-media-box__hd">'
    	                    +'<img class="weui-media-box__thumb" alt="'+data.goods[i].title+'" src="'+goodsCoverUrl+data.goods[i].goodscover+'" style="vertical-align: middle;"/>'
    	                    	+'</div>'
    	                    +'<div class="weui-media-box__bd">'
    	                    +'<h4 class="weui-media-box__title">'+data.goods[i].title+'</h4>'
    	                        +'<p class="weui-media-box__desc">'+data.goods[i].description+'</p>'
    	                        +'</div>'
    	                    +'</a>';
                        }
                        
                        $('.lists').append(result);
                        // 每次数据加载完，必须重置
                        //dropload.resetload();
        	    	}else{
        	    		alert('加载错误!');
                        dropload.resetload();
        	    	}
                },
                error: function(xhr, type){
                    alert('加载错误!');
                    // 即使加载出错，也得重置
                    dropload.resetload();
                }
            });
        }
    });
})
</script>

</body>
</html>