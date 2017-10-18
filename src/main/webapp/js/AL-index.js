/**
 * Created by Administrator on 14-11-16.
 */
$(document).ready(function(){
    $('#menu').tendina({
        openCallback: function(clickedEl) {
            clickedEl.addClass('opened');
        },
        closeCallback: function(clickedEl) {
            clickedEl.addClass('closed');
        }
    });
	
	/*$("#menu li a.firsta").click(function(){
			var status=$(this).next("ul").css("display");
			var firstchild_a_i=$(this).find("i").last();
            $("#menu li a.firsta").css("background","#339999");
            $("#menu li a.firsta").css("color","#fff");
			if(status=="none"){
                firstchild_a_i.removeClass("first-a-up");
                firstchild_a_i.addClass("first-a-down");
                $(this).css("background","#f5f5f5");
                $(this).css("color","#339999");
			}else{
                firstchild_a_i.removeClass("first-a-down");
                firstchild_a_i.addClass("first-a-up");
                $(this).css("background","#339999");
                $(this).css("color","#fff");
			}
		
		});*/
});
$(function(){
	
	/*$("#menu li.menu-list>ul>li").click(function(){
		$("#menu li.menu-list>ul>li").find("a").removeClass("specialclass");
		$(this).find("a",this).addClass("specialclass");
		
	})*/
	$(".admin").click(function(){
	    $(".admin-down-ul").toggle();
    });
    $("a").click(function(){
        var listName = $(this).text();
        var routerName = $(this).attr("id");
        $(".right-header span.header-router").show()
                               .text(listName);
        $(".router span.router-txt").text(routerName);
        var tmpUrl = $(this).href;
        localStorage.setItem("url",tmpUrl)

    });
})
	
$(function(){
    $("#ad_setting").click(function(){
        $("#ad_setting_ul").show();
    });
    $("#ad_setting_ul").mouseleave(function(){
        $(this).hide();
    });
    $("#ad_setting_ul li").mouseenter(function(){
        $(this).find("a").attr("class","ad_setting_ul_li_a");
    });
    $("#ad_setting_ul li").mouseleave(function(){
        $(this).find("a").attr("class","");
    });
    var beforeH;
    $("#all").click(function(){
        $(".header").hide();
        $(".right-header").hide();
        $(".router").hide();
        beforeH = $("#right-content").height();
        $("#right-content").css("marginLeft","0");
        $("#right-content").height("100%");
        $("#page_content").height("100%");
        // window.href=localStorage.getItem("url");
        $("#small").show();

    });
    $("#small").click(function(){
        $(".header").show();
        $(".right-header").show();
        $(".router").show();
        $("#right-content").css("marginLeft","230");
        $("#right-content").height(beforeH);
        $("#page_content").height(beforeH);
        $("#small").hide();
    });
});

