<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台管理系统 | 登录</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../js/libs/AdminLTE-2.4.2/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../js/libs/AdminLTE-2.4.2/dist/css/AdminLTE.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="index.html"><b>后台管理系统</b></a>
  </div>
  <div class="login-box-body">
    <form id="myForm">
      <div class="form-group has-error">
        <span class="help-block hidden"></span>
      </div>
      <div class="form-group">
        <input name="username" class="form-control" placeholder="管理员">
      </div>
      <div class="form-group">
        <input name="password" type="password" class="form-control" placeholder="密码">
      </div>
      <div class="row">
        <div class="col-xs-12">
          <button type="submit" class="btn btn-success btn-block btn-flat">登录</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!-- jQuery 3 -->
<script src="../js/libs/AdminLTE-2.4.2/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/libs/AdminLTE-2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../js/libs/AdminLTE-2.4.2/plugins/iCheck/icheck.min.js"></script>
<script src="../js/jquery.form.min.js"></script>
<script type="text/javascript">
$("#myForm").ajaxForm({
    type: "post",  //提交方式  
    dataType: "json", //数据类型  
    url: "login", //请求url  
    success: function (data) { //提交成功的回调函数  
    	if(data.status=='yes'){
    		window.location.href='';
    	}else{
    		$(".help-block").html(data.message);
    		$(".help-block").removeClass("hidden");
    	}
        
    }
});
</script>
</body>
</html>