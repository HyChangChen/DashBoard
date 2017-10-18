/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            userList:[],
            userName:'',
            roleName:'',
            selected:'1',
            roleList:[],
            email:'',
            isNew: true,
            userid:'',
            userNum:'',
            department:'',
            mobile:''
        },
        methods:{
            add:function(){
                var self = this;
                self.isNew = true;
                self.userName = "";
                self.selected = "";
                self.email = "";
                self.userid =  "";
                self.userNum = "";
                self.department = "";
                self.mobile = "";
                self.selected = "";
                $.ajax({
                    url: _ctx+"/system/roleListData",
                    method: "get",
                    dataType: "json",
                    success: function (data) {
                        self.roleList = data;
                    },
                    error: function () {

                    }
                });
                $(".mask").show();
                $(".box").show();
            },
            edit:function(item){
                var self = this;
                self.isNew = false;
                self.userName = item.name;
                self.selected = item.roleName;
                self.userid = item.id;
                self.selected = '1'
                $.ajax({
                    url: _ctx+"/system/userDetailData",
                    method: "get",
                    dataType: "json",
                    data:{
                        id: item.id
                    },
                    success: function (data) {
                        self.roleList = data.roleList;
                        self.userNum = data.account.usernum;
                        self.department = data.account.department;
                        self.mobile = data.account.mobile;
                        self.email = data.account.email;
                        $(".mask").show();
                        $(".box").show();
                    },
                    error: function () {

                    }
                });
            },
            del:function(item){
                var msgs = 'Are you sure to delete the user?';
                Showbo.Msg.confirm(msgs,function(f){
                    if(f=='yes'){
                        $.ajax({
                            url: _ctx+"/system/delUser",
                            method: "get",
                            dataType: "json",
                            data:{
                                id: item.id
                            },
                            success: function (data) {
                                window.location.href = _ctx+"/system/userList";
                            },
                            error: function () {

                            }
                        });
                    }else{
                        return false;
                    }
                });
            },
            close:function(){
                $(".box").hide();
                $(".mask").hide();
            },
            reset:function(item){
                $.ajax({
                    url: _ctx+"/system/resetPassword",
                    method: "get",
                    dataType: "json",
                    data: {
                        userid:item.id
                    },
                    success: function (data) {
                        alert(data.message);
                        window.location.href = _ctx+"/system/userList";
                    },
                    error: function () {

                    }
                });
            },
            save:function(){
                var self = this;
                var tmpUrl = '';
                var data = {};
                if(self.isNew){
                    tmpUrl = _ctx+"/system/addUser";
                    datas = {
                        loginname: self.userName,
                        email: self.email,
                        roleid: self.selected,
                        usernum:  self.userNum,
                        department: self.department,
                        mobile: self.mobile
                    }
                }else{
                    tmpUrl = _ctx+"/system/editUser";
                    datas = {
                        loginname: self.userName,
                        email: self.email,
                        userid: self.userid,
                        roleid: self.selected,
                        usernum:  self.userNum,
                        department: self.department,
                        mobile: self.mobile
                    }
                }
                $.ajax({
                    url: tmpUrl,
                    method: "get",
                    dataType: "json",
                    data: datas,
                    success: function (data) {
                       alert(data.message);
                       window.location.href = _ctx+"/system/userList";
                    },
                    error: function () {

                    }
                });
            }
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/system/userListData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.userList = data.list;
                },
                error: function () {

                }
            });
        }
    });
});