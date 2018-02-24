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
<link rel="stylesheet" href="style/weui.css"/>
<link rel="stylesheet" href="example/example.css"/>
<!-- Font Awesome -->
<link rel="stylesheet" href="style/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="style/zhouyajing.css"/>

</head>
<body>
<div class="container" id="container">
<div class="page tabbar searchbar flex js_show">
    <div class="page__bd" style="height: 100%;">
    	<!-- 外部框架 -->
        <div class="weui-tab">
            <div class="weui-tab__panel weui-tab__scoll">
            	<!-- 首页内容 -->
            	<!-- 搜索 -->
            	<!-- <div class="page__bd">
			        <div class="weui-search-bar" id="searchBar">
			            <form class="weui-search-bar__form">
			                <div class="weui-search-bar__box">
			                    <i class="weui-icon-search"></i>
			                    <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="搜索" required="">
			                    <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
			                </div>
			                <label class="weui-search-bar__label" id="searchText">
			                    <i class="weui-icon-search"></i>
			                    <span>搜索</span>
			                </label>
			            </form>
			            <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
			        </div>
			        <div class="weui-cells searchbar-result" id="searchResult">
			            <div class="weui-cell weui-cell_access">
			                <div class="weui-cell__bd weui-cell_primary">
			                    <p>实时搜索文本</p>
			                </div>
			            </div>
			        </div>
			    </div> -->
	            
	            <div class="page__bd">
		            <div class="wrapper weui-navbar weui-navbar_scoll" id="wrapper">
					<div class="scroller" style="width: 1204px; transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1); transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);">
						<ul class="clearfix">
							<li class="cur" style="margin-left: 0px; margin-right: 0px;"><a href="javascript:void(0)">推荐</a></li>
							<c:forEach items="${categorys }" var="a" >
			            		<li style="margin-left: 0px; margin-right: 0px;"><a href="javascript:void(0)" code="${a.code }">${a.name }</a></li>
			            	</c:forEach>
						</ul>
					</div>
					</div>
	            
	            <!-- 首页内容  -->
	            <div class="weui-panel weui-panel_access">
			            <div class="weui-panel__hd">最新商品</div>
			            <div class="weui-panel__bd">
			                <div class="weui-media-box weui-media-box_text">
			                	<a href="goods/${latestGoods.id }" class="weui-cell_access">
			                    <h4 class="weui-media-box__title">${latestGoods.title }</h4>
			                    <div class="weui-media-box_appmsg">
			                        <img class="weui-media-box__thumb" src="${goodsCoverUrl }${latestGoods.goodscover }">
			                    </div>			                    			                    
			                    <p class="weui-media-box_appmsg">${latestGoods.description }</p>
			                    </a>
			                    <p class="weui-media-box__desc">
			                    	<a href="shop/${latestGoods.shopid }" class="weui-cell_access weui-cell_link">进入店铺</a>
			                    </p>
			                </div>
			            </div>
			            <!-- <div class="weui-panel__ft">
			                <a href="javascript:void(0);" class="weui-cell weui-cell_access weui-cell_link">
			                    <div class="weui-cell__bd">查看更多</div>
			                    <span class="weui-cell__ft"></span>
			                </a>    
			            </div> -->
			        </div>
			        <div class="weui-panel">
			            <div class="weui-panel__hd">热门商品</div>
			            <div class="weui-panel__bd">
			            	<c:forEach items="${hotGoods }" var="a" >
			            	<a href="goods/${a.id }" class="weui-media-box weui-media-box_appmsg">
			                    <div class="weui-media-box__hd">
			                    	<img class="weui-media-box__thumb" alt="${a.title }" src="${goodsCoverUrl }${a.goodscover }">
			                    </div>
			                    <div class="weui-media-box__bd">
			                        <h4 class="weui-media-box__title">${a.title }</h4>
			                        <p class="weui-media-box__desc">${a.description }</p>
			                        <ul class="weui-media-box__info">
				                        <li class="weui-media-box__info__meta"><fmt:formatDate value="${a.addtime }" type="both" /></li>
				                    </ul>
			                    </div>
			                </a>
			            	</c:forEach>
			            </div>
			            <!-- <div class="weui-panel__ft">
			                <a href="javascript:void(0);" class="weui-cell weui-cell_access weui-cell_link">
			                    <div class="weui-cell__bd">查看更多</div>
			                    <span class="weui-cell__ft"></span>
			                </a>    
			            </div> -->
			        </div>
			        </div>
			    <!-- 加载 -->
			    <!-- <div class="page__bd">
			        <div class="weui-loadmore">
			            <i class="weui-loading"></i>
			            <span class="weui-loadmore__tips">正在加载</span>
			        </div>
			    </div> -->
            </div>
            <div class="weui-tabbar">
                <a href="/" class="weui-tabbar__item weui-bar__item_on">
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
                <a href="about.jsp" class="weui-tabbar__item">
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

<script type="text/javascript" src="example/zepto.js"></script>

<script ty
<script type="text/javascript" class="tabbar js_show">
    $(function(){
        $('.weui-tabbar__item').on('click', function () {
            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
        });
    });
</script>

<script type="text/javascript" class="searchbar js_show">
    $(function(){
        var $searchBar = $('#searchBar'),
            $searchResult = $('#searchResult'),
            $searchText = $('#searchText'),
            $searchInput = $('#searchInput'),
            $searchClear = $('#searchClear'),
            $searchCancel = $('#searchCancel');

        function hideSearchResult(){
            $searchResult.hide();
            $searchInput.val('');
        }
        function cancelSearch(){
            hideSearchResult();
            $searchBar.removeClass('weui-search-bar_focusing');
            $searchText.show();
        }

        $searchText.on('click', function(){
            $searchBar.addClass('weui-search-bar_focusing');
            $searchInput.focus();
        });
        $searchInput
            .on('blur', function () {
                if(!this.value.length) cancelSearch();
            })
            .on('input', function(){
                if(this.value.length) {
                    $searchResult.show();
                } else {
                    $searchResult.hide();
                }
            })
        ;
        $searchClear.on('click', function(){
            hideSearchResult();
            $searchInput.focus();
        });
        $searchCancel.on('click', function(){
            cancelSearch();
            $searchInput.blur();
        });
    });
</script>

<script type="text/javascript" src="js/myjs/flexible.js"></script>
<script type="text/javascript" src='js/myjs/iscroll.js'></script>
<script type="text/javascript" src='js/myjs/navbarscroll.js'></script>
<script type="text/javascript">
$(function(){
	$('#wrapper').navbarscroll();
});
</script>
</body>
</html>