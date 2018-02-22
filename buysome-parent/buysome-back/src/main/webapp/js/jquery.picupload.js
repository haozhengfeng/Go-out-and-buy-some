/**
 * 上传图片
 * 手动调用initPicUpload 
 * @param $
 */
// 图片上传demo
(function($){
	$.initPicUpload=function(opt){
        var $list = $('#fileList'),
        $manager = $(".manager"),
        $caption = $(".caption"),
        // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,

        // 缩略图大小
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,
        
        // Web Uploader实例
        uploader;
    
    	window.fileSuccess = 0;
    	window.fileCount = 0;
    	
    	
    	var option = {
	        // 自动上传。
	        auto: false,

	        // swf文件路径
	        swf: 'Uploader.swf',

	        formData:{},
	        
	        // 文件接收服务端。

	        server: 'goodsPicUpload',
	        // 选择文件的按钮。可选。
	        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	        pick: {
	        	id:'#filePicker',
	        	multiple :true
	        },

	        // 只允许选择文件，可选。
	        accept: {
	            title: 'Images',
	            extensions: 'gif,jpg,jpeg,bmp,png',
	            mimeTypes: 'image/*'
	        },
	        
	        compress:false
	    };
    	
    	option = $.extend(true,{},option ,opt);
    	$list = $(option.pick.id).prev("#fileList");
    	
	    // 初始化Web Uploader
	    uploader = WebUploader.create(option);
	    
	    /*
	     * 需要优化重新选择图片
	     * 
	    uploader.on( 'beforeFileQueued', function( file ) {
	    	
	    });*/
	
	    // 当有文件添加进来的时候
	    uploader.on( 'fileQueued', function( file ) {
    	
	    	window.fileCount++;
	        var $li = $(
	                '<div id="' + file.id + '" class="file-item thumbnail">' +
	                    '<img>' +
	                    '<div class="info">' + file.name + '</div>' +
	                '</div>'
	                ),
	            $img = $li.find('img'),
	            $info = $('<p class="error"></p>'),
	            $btns = $('<div class="file-panel">' +
		                '<span class="cancel">删除</span>' +
		                '</div>');
	        
	        $list.append( $li );
	        showError = function( code ) {
	            switch( code ) {
	                case 'exceed_size':
	                    text = '文件大小超出';
	                    break;
	
	                case 'interrupt':
	                    text = '上传暂停';
	                    break;
	
	                default:
	                    text = '上传失败，请重试';
	                    break;
	            }
	
	            $info.text( text ).appendTo( $list );
	        };        
	                
	        if ( file.getStatus() === 'invalid' ) {
	            showError( file.statusText );
	        } else {
	        	// 创建缩略图
	            uploader.makeThumb( file, function( error, src ) {
	                if ( error ) {
	                    $img.replaceWith('<span>不能预览</span>');
	                    return;
	                }
	
	                $img.attr( 'src', src );
	            }, thumbnailWidth, thumbnailHeight );
	        }
	        $li.on( 'mouseenter', function() {
	            $btns.stop().animate({height: 30});
	        });
	
	        $li.on( 'mouseleave', function() {
	            $btns.stop().animate({height: 0});
	        });
	        
	        $btns.on( 'click', 'span', function() {
	            var index = $(this).index(),
	                deg;
	
	            switch ( index ) {
	                case 0:
	                    uploader.removeFile( file );
	                    return;
	
	                case 1:
	                    file.rotation += 90;
	                    break;
	
	                case 2:
	                    file.rotation -= 90;
	                    break;
	            }
	
	        });
	        
	        $li.append( $btns );
	    });
    
	    // 文件上传过程中创建进度条实时显示。
	    uploader.on( 'uploadProgress', function( file, percentage ) {
	        var $li = $( '#'+file.id ),
	            $percent = $li.find('.progress span');
	
	        // 避免重复创建
	        if ( !$percent.length ) {
	            $percent = $('<p class="progress"><span></span></p>')
	                    .appendTo( $li )
	                    .find('span');
	        }
	
	        $percent.css( 'width', percentage * 100 + '%' );
	    });
	
	    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
	    uploader.on( 'uploadSuccess', function( file ) {
	        $( '#'+file.id ).addClass('upload-state-done');
	        window.fileSuccess++;
	    });
	
	    // 文件上传失败，现实上传出错。
	    uploader.on( 'uploadError', function( file ) {
	        var $li = $( '#'+file.id ),
	            $error = $li.find('div.error');
	
	        // 避免重复创建
	        if ( !$error.length ) {
	            $error = $('<div class="error"></div>').appendTo( $li );
	        }
	
	        $error.text('上传失败');
	    });
	
	    // 完成上传完了，成功或者失败，先删除进度条。
	    uploader.on( 'uploadComplete', function( file ) {
	        $( '#'+file.id ).find('.progress').remove();
	        if(window.fileSuccess==window.fileCount){
	        	top.$('#mainFrame').attr('src', top.$('#mainFrame').attr('src'));
//				top.layer.closeAll();
	        }
	    });
	    
	    uploader.onFileDequeued = function( file ) {
	    	window.fileCount--;
	        removeFile( file );
	    };
	    
	    // 负责view的销毁
	    function removeFile( file ) {
	        var $li = $('#'+file.id);
	        $li.off().find('.file-panel').off().end().remove();
	    }
    
	    //管理  图片删除按钮
	    $manager.click(function(){
	    	$(this).find(".caption").show();
	    });

	    $("body").click(function(e){
	    	var target = $(e.target);
	        if(!target.is('.manager')&&!target.is('.manager img')) {
	        	$(this).find(".manager .caption").hide();
	        }
	    });
	    
	    $caption.on("click",function(){
	    	//删除图片
	    	var id = $(this).find(".picid").val();
	    	var filetype = $(this).find(".filetype").val();
	    	
			var del_con = '您确定要删除吗？';
			layer.confirm(del_con, {offset: ['10%']}, function(){
				$.ajax({
					url: "../file/file_delete",
					type:"post", 
					data: {id: id,filetype:filetype},
					dataType:"json",
					cache: false,
					success: function(data){
						if( data.message=='' ){
							$(this).parent(".manager").remove();
							layer.closeAll();
							location.reload(true);
							return false;
						}else{
							layer.alert(data.message);
						}
					}
				});
			});
	    	return false;
	    });
	    
    	return uploader;
	}
})(jQuery)