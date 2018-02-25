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
              <h3 class="box-title">修改管理员</h3>
            </div>
            <form id="myForm" role="form">
              <div class="box-body">
                <div class="form-group">
                  <label for="username">用户名</label>
                  <input id="username" name="username" class="form-control" placeholder="用户名" maxlength="10" value="${admin.username }">
                </div>
                <div class="form-group has-warning">
                  <label class="control-label" for="inputWarning"><i class="fa fa-bell-o"></i>密码为空时，不修改密码</label>
                  <label for="password">密码</label>
                  <input id="txtpassword" name="txtpassword" type="text" class="form-control" placeholder="密码" maxlength="10"/>
                  <input id="password" name="password" type="password" class="form-control" style="display: none" placeholder="密码" maxlength="10" readonly="true" />
                </div>
                <div class="form-group">
                  <label for="password">确认密码</label>
                  <input id="txtconfirm" name="txtconfirm" type="text" class="form-control" placeholder="确认密码" maxlength="10">
                  <input id="confirm" name="confirm" type="password" class="form-control" style="display: none" placeholder="确认密码" maxlength="10" readonly="true">
                </div>
                <div class="form-group">
                  <label for="roleid">角色</label>
                  <c:if test="${sessionAdmin.roleid==0 }">
                  	超级管理员
                  </c:if>
                  <c:if test="${sessionAdmin.roleid==1 }">
					  管理员
                  </c:if>
                  <c:if test="${sessionAdmin.roleid==2 }">
					 用户
                  </c:if>
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
    url: "edit", //请求url
    data:{id:${admin.id}},
    beforeSubmit: validate, // 提交前
    success: function (data) { //提交成功的回调函数  
    	if(data.status=='yes'){
    		window.location.href='list';
    	}else{
    		$(".help-block").html(data.message);
    		$(".help-block").removeClass("hidden");
    	}
    }
});

function validate(){
	if($("#username").val().trim()==""){
		$(".help-block").html("请输入用户名");
		$(".help-block").removeClass("hidden");
		return false;
	}
	
	if($("#password").val().trim()!=""&&$("#confirm").val()==""){
		$(".help-block").html("请确认密码");
		$(".help-block").removeClass("hidden");
		return false;
	}
}

$("[name=txtpassword]").focus(function () {
    /*当前文本框隐藏*/
    $(this).hide();
    /*隐藏的密码框显示并且获取焦点 只读属性去掉*/
    $('#password').show().attr('readonly', false).focus();
    $('#txtconfirm').hide();
    $('#confirm').show().attr('readonly', false).focus();
});
$("[name=txtconfirm]").focus(function () {
    /*当前文本框隐藏*/
    $(this).hide();
    /*隐藏的密码框显示并且获取焦点 只读属性去掉*/
    $('#txtpassword').hide();
    $('#password').show().attr('readonly', false).focus();
    $('#confirm').show().attr('readonly', false).focus();
});

</script>
</body>
</html>