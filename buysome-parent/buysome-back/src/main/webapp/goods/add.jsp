<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台管理系统 | 欢迎使用</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../js/libs/AdminLTE-2.4.2/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../js/libs/AdminLTE-2.4.2/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../js/libs/AdminLTE-2.4.2/dist/css/AdminLTE.css">
  <link rel="stylesheet" href="../js/libs/AdminLTE-2.4.2/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="../js/libs/AdminLTE-2.4.2/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="../js/libs/webuploader/webuploader.css">
</head>
<body>
<section class="content-header">
  <h1>
    <small>商品管理</small>
  </h1>
</section>
<section class="content">
      <div class="row">
      	<div class="col-md-6">
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">添加商品</h3>
            </div>
            <form id="myForm" role="form" enctype="multipart/form-data">
              <div class="box-body">
                <div class="form-group">
                  <label for="title">商品名称</label>
                  <input id="title" name="title" class="form-control" placeholder="商品名称" maxlength="10">
                </div>
                <div class="form-group">
                  <label for="goodscover">商品封面</label>
                  <input id="file" name="file" type="file" accept="image/*" placeholder="商品封面"/>  
                </div>
                <div class="form-group">
                  <label for="description">商品描述</label>
                  <textarea id="description" name="description" class="form-control" rows="3" placeholder="商品描述"></textarea>
                </div>
                <div class="form-group">
                  <label for="hasgoods">是否有货</label>
				  <select id="hasgoods" name="hasgoods" class="form-control">
	               	  <option value="1">有货</option>
	               	  <option value="0">无货</option>
              	  </select>                
                </div>
                <div class="form-group">
                  <label for="categorycode">商品分类</label>
				  <select id="categorycode" name="categorycode" class="form-control">
	               	  <c:forEach items="${categorys }" var="a" >
	                	<option value="${a.code }">${a.name }</option>
	                </c:forEach>
              	  </select>                
                </div>
                <div class="form-group">
                  <label for="location">店铺</label>
                  ${shop.name }
                  <input id="shopid" name="shopid" type="hidden" value="${shop.id }">
                </div>
                <div class="form-group">
	            	<div id="uploader">
					    <div id="fileList" class="uploader-list"></div>
					    <div id="goodspic">选择图片</div>
					</div>
                </div>
                <div class="form-group has-error">
			      <span class="help-block hidden"></span>
			    </div>
              </div>
              <div class="box-footer">
                <button type="submit" class="btn btn-success">提交</button>
                <button type="button" class="btn btn-success"  onclick="window.location.href='list'">返回</button>
              </div>
            </form>
          </div>
        </div>
      </div>
</section>

<!-- jQuery 3 -->
<script src="../js/libs/AdminLTE-2.4.2/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/libs/AdminLTE-2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../js/libs/AdminLTE-2.4.2/bower_components/fastclick/lib/fastclick.js"></script>
<script src="../js/libs/AdminLTE-2.4.2/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../js/libs/AdminLTE-2.4.2/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../js/libs/AdminLTE-2.4.2/dist/js/adminlte.js"></script>
<script type="text/javascript" src="../js/libs/webuploader/webuploader.js"></script>
<script type="text/javascript" src="../js/jquery.picupload.js"></script>
<script type="text/javascript" src="../js/jquery.form.min.js"></script>
<script type="text/javascript">
var goodspic = $.initPicUpload({
	pick: {
		id:'#goodspic'
	},
	fileNumLimit:9
});

$("#myForm").ajaxForm({
    type: "post",  //提交方式  
    dataType: "json", //数据类型  
    url: "add", //请求url  
    success: function (data) { //提交成功的回调函数  
    	if(data.status=='yes'){
    		
    		goodspic.options.formData.goodsid=data.goods.id;
    		goodspic.upload();
    		
    		if(window.fileCount<=0){
    			window.location.href='list';
    		}
    		
    		
    	}else{
    		$(".help-block").html(data.message);
    		$(".help-block").removeClass("hidden");
    	}
    }
});



</script>
</body>
</html>