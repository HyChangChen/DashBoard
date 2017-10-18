/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            parentList:[],
            sonList:[],
            modelname:"",
            modeldesc:"",
            parentid:"",
            modelid:"",
            modelnum:""
        },
        methods:{
            edit:function(item){
                var self = this;
                $(".mask").show();
                $(".box").show();
                self.modelname = item.modelname;
                self.modeldesc = item.modeldesc;
                self.parentid = item.parentid;
                self.modelid = item.modelid;
                self.modelnum = item.modelnum;
            },
            close:function(){
                $(".mask").hide();
                $(".box").hide();
            },
            save:function(){
                var self = this;
                $.ajax({
                    url: _ctx+"/system/editmodel",
                    method: "get",
                    dataType: "json",
                    data: {
                        modelname:self.modelname,
                        modeldesc:self.modeldesc,
                        parentid:self.parentid,
                        modelid:self.modelid,
                        modelnum:self.modelnum
                    },
                    success: function (data) {
                        alert(data.message);
                        window.location.href = _ctx+"/system/modelList";
                    },
                    error: function () {

                    }
                });
            },
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/system/modelListData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.parentList = data.listMap[0];
                    self.sonList = data.listMap[1];
                },
                error: function () {

                }
            });
        }
    });
});