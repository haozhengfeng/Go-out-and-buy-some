$(function(){
	
	$("#mainFrame").attr('src', $(".active a[href-url]").attr("href-url"));
	
	$(".sidebar-menu li").each(function(){
		if($(this).find(".treeview-menu").length>0){
			$(this).find(".treeview-menu").find("a").click(function(){
				 $("#mainFrame").attr('src', $(this).attr("href-url"));
			});
		}else{
			$(this).find("a").click(function(){
				 $("#mainFrame").attr("src", $(this).attr("href-url"));
				 $(".active").removeClass("active");
				 $(this).parent("li").addClass("active");
			});
		}
	});
	
	//alert($(".content-wrapper").height());
	//alert($(".content-wrapper").css('min-height'));
	
	//$("#mainFrame").css('min-height', (parseInt($(".content-wrapper").css('min-height'))-16)+"px");
	$("#mainFrame").css('min-height', ($(".content-wrapper").height()-16)+"px");
});