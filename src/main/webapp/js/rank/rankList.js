/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            customer:[]
        },
        methods:{
            customFilter:function(list){
                return customer.filter(function(item){
                    return item.n<=33;
                });
            },
            goto:function(item){
                window.location.href = _ctx+'/system/rankDetail?ioccustomerusertop7id='+item.ioccustomerusertop7id;
            }
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/system/custtop7ListData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.customer = data;
                },
                error: function () {

                }
            });
        }
    });
});