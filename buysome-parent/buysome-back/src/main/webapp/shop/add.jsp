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
</head>
<body>
<section class="content-header">
  <h1>
    <small>店铺管理</small>
  </h1>
</section>
<section class="content">
      <div class="row">
      	<div class="col-md-6">
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">开通店铺</h3>
            </div>
            <form id="myForm" role="form" enctype="multipart/form-data">
              <div class="box-body">
                <div class="form-group">
                  <label for="name">店铺名称</label>
                  <input id="name" name="name" class="form-control" placeholder="店铺名称" maxlength="10">
                </div>
                <div class="form-group">
                  <label for="file1">微信二维码</label>
                  <input id="file1" name="file1" type="file" accept="image/*" placeholder="微信二维码"/>  
                </div>
                <div class="form-group">
                  <label for="file">店铺封面</label>
                  <input id="file" name="file" type="file" accept="image/*" placeholder="店铺封面"/>  
                </div>
                <div class="form-group">
                  <label for="description">店铺描述</label>
                  <textarea id="description" name="description" class="form-control" rows="3" placeholder="店铺描述"></textarea>
                </div>
                <div class="form-group">
                  <label for="location">店铺位置</label>
                  <input id="location" name="location" class="form-control" placeholder="店铺位置" maxlength="50">
                </div>
                <div class="form-group">
                  <label for="location">店主</label>
                  ${admin.username }
                  <input id="adminid" name="adminid" type="hidden" value="${admin.id }">
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
<script src="../js/jquery.form.min.js"></script>
<script type="text/javascript">
$("#myForm").ajaxForm({
    type: "post",  //提交方式  
    dataType: "json", //数据类型  
    url: "add", //请求url  
    success: function (data) { //提交成功的回调函数  
    	if(data.status=='yes'){
    		window.location.href='list';
    	}else{
    		$(".help-block").html(data.message);
    		$(".help-block").removeClass("hidden");
    	}
    }
});
</script>
</body>
</html>