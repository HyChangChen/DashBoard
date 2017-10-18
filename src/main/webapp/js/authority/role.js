$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            roleList:[],
            roleName:"",
            roleDesc: "",
            modelNoList:[],
            modelHaveList:[]
        },
        methods:{
            add:function(){
                var self = this;
                self.isNew = true;
                self.roleName = "";
                self.roleDesc = "";
                $(".mask").show();
                $(".box").show();
            },
            edit:function(item){
                var self = this;
                self.isNew = false;
                $(".mask").show();
                $(".box").show();
                self.roleName = item.rolename;
                self.roleDesc = item.roledesc;
                self.roleId = item.roleid;
            },
            del:function(item){
                var msgs = 'Are you sure to delete the role?';
                console.log(item.roleid);
                Showbo.Msg.confirm(msgs,function(f){
                    if(f=='yes'){
                        $.ajax({
                            url: _ctx+"/system/delrole",
                            method: "get",
                            dataType: "json",
                            data:{
                                id: item.roleid
                            },
                            success: function (data) {
                                alert(data.message);
                                window.location.href = _ctx+"/system/roleList";
                            },
                            error: function () {

                            }
                        });
                    }else{
                        return false;
                    }
                });
            },
            authorization:function(item){
                var self = this;
                $(".mask").show();
                $(".auth-box").show();
                self.roleId = item.roleid;
                $.ajax({
                    url: _ctx+"/system/modelRoleData",
                    method: "get",
                    dataType: "json",
                    data:{
                        roleid: item.roleid
                    },
                    success: function (data) {
                        for(var i=0;i<data.modelNoList.length;i++){
                            data.modelNoList[i].checked = false;
                        }
                        for(var j=0;j<data.modelHaveList.length;j++){
                            data.modelHaveList[j].checked = true;
                        }
                        self.modelNoList  = data.modelNoList;
                        self.modelHaveList = data.modelHaveList;
                    },
                    error: function () {

                    }
                });
            },
            close:function(){
                $(".box").hide();
                $(".mask").hide();
                $(".auth-box").hide();
            },
            save:function(){
                var self = this;
                var tmpUrl = '';
                var datas = {};
                if(self.isNew){
                    tmpUrl = _ctx+"/system/addrole";
                    datas = {
                        rolename: self.roleName,
                        roledesc: self.roleDesc
                    }
                }else{
                    tmpUrl = _ctx+"/system/editrole";
                    datas = {
                        roleid: self.roleId,
                        rolename: self.roleName,
                        roledesc: self.roleDesc
                    }
                }
                $.ajax({
                    url: tmpUrl,
                    method: "get",
                    dataType: "json",
                    data: datas,
                    success: function (data) {
                        alert(data.message);
                        window.location.href = _ctx+"/system/roleList";
                    },
                    error: function () {

                    }
                });
            },
            saveModule:function(){
                var self = this;
                var arr = [];
                var noList = this.modelNoList;
                var haveList = this.modelHaveList;
                for(var i = 0;i<noList.length;i++){
                    if(noList[i].checked){
                        arr.push(noList[i].modelid);
                    }
                }
                for(var i = 0;i<haveList.length;i++){
                    if(haveList[i].checked){
                        arr.push(haveList[i].modelid);
                    }
                }
                var result = arr.join(",");
                $.ajax({
                    url: _ctx+"/system/roleModel",
                    method: "get",
                    data:{
                        roleid:self.roleId,
                        models:result
                    },
                    dataType: "json",
                    success: function (data) {
                        alert(data.message);
                        $(".box").hide();
                        $(".mask").hide();
                        $(".auth-box").hide();
                        window.history.href = _ctx + "/system/roleList";
                    },
                    error: function () {

                    }
                });
            }
        },
        created: function () {
            var self = this;
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
        }
    });
});