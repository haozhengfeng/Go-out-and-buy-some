$(function(){
	$("#mainFrame").attr('src', $(".active a[href-url]").attr("href-url"));
	
	$("#mainFrame").css('min-height', (parseInt($(".content-wrapper").css('min-height'))-16)+"px");

	$(".sidebar-menu li").each(function(){
		if($(this).find(".treeview-menu").length>0){
			$(this).find(".treeview-menu").find("a").click(function(){
				 $("#mainFrame").attr('src', $(this).attr("href-url"));
			});
		}else{
			$(this).find("a").click(function(){
				 $("#mainFrame").attr('src', $(this).attr("href-url"));
			});
		}
	});
});