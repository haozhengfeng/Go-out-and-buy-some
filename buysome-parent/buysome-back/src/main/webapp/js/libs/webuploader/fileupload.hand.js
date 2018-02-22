/**
 * webupload 文件上传
 */
(function($){
	window.initFileUpload=function(opt){
		var state = 'pending',
			option = {
			        // 不压缩image
			        resize: false,
	
			        // swf文件路径
			        swf: 'Uploader.swf',
	
			        // 文件接收服务端。
			        server: '../uploadFile/uploadFile_upload',
	
			        // 选择文件的按钮。可选。
			        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
			        pick: {
			        		multiple:false
			        	  },
		        	accept: {        //指定接受哪些类型的文件
		                 title: 'filetype',    //文字描述
		                 extensions: 'doc,docx,xls,xlsx'    //允许的文件后缀，不带点，多个用逗号分割。
		            },
		            fileNumLimit:1,
	                fileSingleSizeLimit: 5 * 1024 * 1024    // 1 M
	                
			};
		option = $.extend(true,{},option ,opt);
		var uploader = WebUploader.create(option);
		
		var $fileupload = $(option.pick.id).parents(".fileupload");
		
		var $list = $fileupload.find("#thelist");
		
		uploader.on( 'fileQueued', function( file ) {
			window.fileCount++;
			
			var $file = $('<div id="' + file.id + '" class="item">' +
			            '<h4 class="info">' + file.name + '</h4>' +
			            '<p class="state">等待上传...</p>' +
			        '</div>');
			var $delete = $("<a href='javascript:void(0);'>删除</a>");
			$delete.appendTo($file);
	        $list.append( $file );
	        
	        $delete.on( 'click',function() {
	        	uploader.removeFile( file );
	        	uploader.getFiles();
	        });
	        
	    });
		
		uploader.onFileDequeued = function( file ) {
	    	window.fileCount--;
	        removeFile( file );
	    };
	    
	    // 负责view的销毁
	    function removeFile( file ) {
	        var $li = $('#'+file.id);
	        $li.remove();
	    }
		
		
		// 文件上传过程中创建进度条实时显示。
		uploader.on( 'uploadProgress', function( file, percentage ) {
	        var $li = $fileupload.find( '#'+file.id ),
	            $percent = $li.find('.progress .progress-bar');

	        // 避免重复创建
	        if ( !$percent.length ) {
	            $percent = $('<div class="progress progress-striped active">' +
	              '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	              '</div>' +
	            '</div>').appendTo( $li ).find('.progress-bar');
	        }

	        $li.find('p.state').text('上传中');

	        $percent.css( 'width', percentage * 100 + '%' );
	    });

		uploader.on( 'uploadSuccess', function( file ) {
			$fileupload.find( '#'+file.id ).find('p.state').text('已上传');
			window.fileSuccess++;
	    });

		uploader.on( 'uploadError', function( file ) {
			$fileupload.find( '#'+file.id ).find('p.state').text('上传出错');
	    });

		uploader.on( 'uploadComplete', function( file ) {
			$fileupload.find( '#'+file.id ).find('.progress').fadeOut();
			if(window.fileSuccess==window.fileCount){
	        	top.$('#mainFrame').attr('src', top.$('#mainFrame').attr('src'));
				top.layer.closeAll();
	        }
	    });

		uploader.on( 'all', function( type ) {
	        if ( type === 'startUpload' ) {
	            state = 'uploading';
	        } else if ( type === 'stopUpload' ) {
	            state = 'paused';
	        } else if ( type === 'uploadFinished' ) {
	            state = 'done';
	        }
	    });

//	    $btn.on( 'click', function() {
//	        if ( state === 'uploading' ) {
//	            uploader.stop();
//	        } else {
//	            uploader.upload();
//	        }
//	    });
	    
	    uploader.onError = function( code ) {
	        if(code=='F_DUPLICATE'){
	        	layer.alert('文件重复！');
	        }else if(code=='Q_TYPE_DENIED'){
	        	layer.alert('请上传'+option.accept.extensions+'文件！');
	        }else if(code=='Q_EXCEED_NUM_LIMIT'){
	        	layer.alert('只允许上传一个文件');
	        }else if(code=='F_EXCEED_SIZE'){
	        	layer.alert('文件大小不超过5兆');
	        }else{
	        	layer.alert( 'Eroor: ' + code );
	        }
	    };
	    
	    $(".filedelete").on("click",function(){
	    	//删除文件
	    	var id = $(this).attr("fileid");
	    	var filetype = $(this).attr("filetype");
	    	
	    	var row = $(this).parents(".row");
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
						//$(this).remove();
						row.prev(".fileupload").show();
						var con = row.prev(".fileupload").find(".webuploader-container div");
						$(con[1]).css("width","86px").css("height","41px");
						
						row.remove();
						layer.closeAll();
						//location.reload(true);
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
