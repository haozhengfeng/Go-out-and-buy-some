<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
<title>${shop.name }</title>
<link rel="stylesheet" href="../style/weui.css"/>
<link rel="stylesheet" href="../example/example.css"/>
<script type="text/javascript" src="../example/zepto.js"></script>
</head>
<body>
<div class="container" id="container">
<div class="page panel js_show">
    <!--<div class="page__hd">
        <h1 class="page__title">${shop.name }</h1>
        <p class="page__desc">${shop.description }</p>
    </div>-->
    <div class="page__bd">
        <div class="weui-panel weui-panel_access">		    
			<div class="weui-panel__bd">
		        <div class="weui-media-box weui-media-box_text">
		            <div class="weui-media-box_appmsg">
		                <div>
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
        <div class="weui-panel weui-panel_access">
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
</div>
</body>
</html>