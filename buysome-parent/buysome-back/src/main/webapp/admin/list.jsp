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
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../AdminLTE-2.4.2/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../AdminLTE-2.4.2/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../AdminLTE-2.4.2/dist/css/AdminLTE.css">
  <link rel="stylesheet" href="../AdminLTE-2.4.2/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="../AdminLTE-2.4.2/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
</head>
<body>

<section class="content-header">
  <h1>
    <small>管理员管理</small>
  </h1>
</section>

<section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-body">
              <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
              
              <form action="list">
              <div class="row">
	       		<div class="col-sm-12">
		       		<div id="example1_filter" class="dataTables_filter">
		       			<label>Search:<input type="search" class="form-control input-sm" placeholder="搜索" aria-controls="example1"></label>
		       		</div>
	       		</div>
       		</div>
       		
       		<div class="row">
	       		<div class="col-sm-12">
		       		<div id="example1_filter" class="dataTables_filter">
		       			<button type="button" class="btn btn-success"  onclick="window.location.href='edit.jsp'">添加</button>
		       		</div>
	       		</div>
       		</div>
       		
       		<div class="row">
	       		<div class="col-sm-12">
	              <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
	                <thead>
	                <tr role="row">
	                	<th class="sorting_asc" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending" style="width: 197px;">id</th>
	                	<th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="width: 242px;">名称</th>
	                	<th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending" style="width: 216px;">操作</th>
	                </thead>
	                <tbody>
	                
	                <c:forEach items="${admins }" var="a" >
	                	<tr role="row" class="odd">
		                  <td class="sorting_1">${a.id }</td>
		                  <td>${a.username }</td>
		                  <td></td>
		                </tr>
	                </c:forEach>
	                
	               </tbody>
	              </table>
	              </div>
              </div>
              <div class="row">
              	
              	<div class="col-sm-5">
              		<div class="dataTables_length" id="example1_length">
					 <label>
					 	Show 
					 	<select id="pageSize" name="pageSize" aria-controls="example1" class="form-control input-sm">
					 		<option value="1" ${page.pageSize==1?'selected':''}>1</option>
					 		<option value="2" ${page.pageSize==2?'selected':''}>2</option>
					 		<option value="10" ${page.pageSize==10?'selected':''}>10</option>
					 	</select> 
					 	entries
					 </label>
					</div>
              	</div>
              	<div class="col-sm-7">
              		<div class="dataTables_paginate paging_simple_numbers" id="example1_paginate">
              			<ul class="pagination">
	              			<c:forEach var="p" begin="1" end="${page.pages}" step="1"> 
	              				<c:if test="${p==1 }">
	              					<li class="paginate_button previous <c:if test="${page.pageNum==1 }">disabled</c:if>" id="example1_previous">
		              					<a href="#" aria-controls="example1" data-dt-idx="Previous" tabindex="0">Previous</a>
		              				</li>
	              				</c:if>
	              				<li class="paginate_button <c:if test="${p==page.pageNum }">active</c:if>">
	              					<a href="#" aria-controls="example1" data-dt-idx="${p}" tabindex="0">${p}</a>
	              				</li>
	              				<c:if test="${p==page.pages }">
		              				<li class="paginate_button next <c:if test="${page.pageNum==page.pages }">disabled</c:if>" id="example1_next">
		              					<a href="#" aria-controls="example1" data-dt-idx="Next" tabindex="0">Next</a>
		              				</li>
	              				</c:if>
							</c:forEach>
           				</ul>
           				<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum }"/>
      				</div>
   				</div>
      				</div>
      				</form>
   				</div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
</section>

<!-- jQuery 3 -->
<script src="../AdminLTE-2.4.2/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../AdminLTE-2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../AdminLTE-2.4.2/bower_components/fastclick/lib/fastclick.js"></script>
<script src="../AdminLTE-2.4.2/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../AdminLTE-2.4.2/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../AdminLTE-2.4.2/dist/js/adminlte.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#pageSize").change(function(){
		$("#pageNum").val(1);
		$("form:last").submit();
	});
	
	$(".pagination li a").click(function(){
		if(!parseInt($(this).attr("data-dt-idx"))){
			if($(this).attr("data-dt-idx")=="Previous"){
				if($("#pageNum").val()==1) return;
				$("#pageNum").val(parseInt($("#pageNum").val())-1);								
			}else if($(this).attr("data-dt-idx")=="Next"){
				if($("#pageNum").val()==${page.pages}) return;
				$("#pageNum").val(parseInt($("#pageNum").val())+1);	
			}else{
				return;	
			}
		}else{
			$("#pageNum").val($(this).attr("data-dt-idx"));	
		}
		$("form:last").submit();
	});
});
</script>
</body>
</html>