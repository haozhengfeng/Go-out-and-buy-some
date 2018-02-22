<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
<title>${goods.title }</title>
<link rel="stylesheet" href="../style/weui.css"/>
<link rel="stylesheet" href="../example/example.css"/>
<script type="text/javascript" src="../example/zepto.js"></script>
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
			        <h1 class="page__title">${goods.title }</h1>
			        <p class="page__desc">${goods.description }</p>
			    </div>	
            	<div class="page__bd">
			        <div class="weui-panel weui-panel_access">
            		<c:forEach items="${goodsPics }" var="a" >
					    <div class="weui-panel__bd">
					        <div class="weui-media-box weui-media-box_text">
					            <div class="weui-media-box_appmsg">
					                <img src="${a.picurl }" style="width: 100%;"/>
					            </div>			                    			                    
					        </div>
					    </div>
					</c:forEach>
					<div class="weui-panel__ft">
		                <a href="../shop/${goods.shopid }" class="weui-cell weui-cell_access weui-cell_link">
		                    <div class="weui-cell__bd">进入店铺</div>
		                </a>    
		            </div>
					</div>
				</div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>