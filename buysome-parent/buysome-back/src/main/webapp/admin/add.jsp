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
    <small>管理员管理</small>
  </h1>
</section>
<section class="content">
      <div class="row">
      	<div class="col-md-6">
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">添加管理员</h3>
            </div>
            <form id="myForm" role="form">
              <div class="box-body">
                <div class="form-group">
                  <label for="username">用户名</label>
                  <input id="username" name="username" class="form-control" placeholder="用户名" maxlength="20">
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input id="password" name="password" type="password" class="form-control" placeholder="密码" maxlength="10">
                </div>
                <div class="form-group">
                  <label for="roleid">角色</label>
                  <select id="roleid" name="roleid" class="form-control">
                  	<c:if test="${sessionAdmin.roleid==0 }">
                  		<option value="1">管理员</option>
                  	</c:if>
                  	<option value="2">用户</option>
                  </select>
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