/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function loginAction(){
        $(".login-form p").text(" ").hide();
        var username = $("#userName").val().trim();
        var pwd = $("#pwd").val().trim();
        if(username.length==0){
            $(".msg-user").text("存在必填项").show();
        }else{
            $.ajax({
                url: _ctx+"/system/login",
                method: "post",
                data: {
                    name : username,
                    password  : pwd
                },
                dataType: "json",
                success: function(data){
                    if(data.code==1){
                        window.location.href = _ctx+"/system/index?loginname="+username;
                    }else{
                        if(data.message == "The account does not exist!"){
                            $("p.msg-user").text(data.message).show();
                        }
                        if(data.message == "Password authentication error!"){
                            $("p.msg-pwd").text(data.message).show();
                        }
                    }
                },
                error: function(){

                }
            })
        }
    }
    $("#userName").on("keypress",function(event){
        if(event.keyCode == 13){
            loginAction();
        }
    });
    $("#pwd").on("keypress",function(event){
        if(event.keyCode == 13){
            loginAction();
        }
    });
    $("#login").click(function(){
           loginAction();
    });
    $(".forgot").click(function(){
        $(".forget-tip").text("").hide();
        $(".getPwd").css("marginTop",20);
        $(".mask").show();
        $(".forget-box").show();
    });
    $(".close").click(function(){
        $(".mask").hide();
        $(".forget-box").hide();
        $(".user-email").val("");
        $(".user-name").val("");
    });
    $(".getPwd").click(function(){
        var emails = $(".user-email").val().trim();
        var userName =  $(".user-name").val().trim();
        if(userName==""){
            $(".forget-tip").text("UserName is required!").show();
            $(".getPwd").css("marginTop",0);
            return;
        }
        if(emails==""){
            $(".forget-tip").text("Email is required!").show();
            $(".getPwd").css("marginTop",0);
            return;
        }
        $.ajax({
            url: _ctx+"/system/forget",
            method: "get",
            data: {
                loginname : userName,
                email  : emails
            },
            dataType: "json",
            success: function(data){
                $(".forget-tip").text(data.message).show();
                $(".getPwd").css("marginTop",0);
            },
            error: function(){

            }
        })
        /*$(".mask").hide();
        $(".forget-box").hide();*/
    });
});