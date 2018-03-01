$(function(){
	
	var pageNum = 1;
	
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
            domNoData  : '<div class="dropload-noData">没有更多了</div>'
        },
        loadUpFn : function(me){
        	window.location.reload();
        },
        loadDownFn : function(me){
        	$.ajax({
                type: 'GET',
                url: 'ajaxlist',
                data:{pageNum:pageNum++,categorycode:categorycode},
                dataType: 'json',
                success: function(data){
                	
                	if(data.goods.length==0){
                        me.lock();
                        me.noData(true);
                        me.resetload();
                        return ;
                	}
                	
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
                        
                        me.unlock();
                        me.noData(false);
                        
                        // 每次数据加载完，必须重置
                        dropload.resetload();
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