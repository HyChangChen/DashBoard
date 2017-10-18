/**
 * Created by lenovo on 2017/6/26.
 */
/*$(function () {
    var digitalData = new Vue({
        el: "#ano81-data",
        data: {
            anoList:[]
        },
        methods: {
           initData:function(){
               var self = this;
               $.ajax({
                   url: _ctx+"/ano/ano81Data",
                   method: "get",
                   dataType: "json",
                   success: function (data) {
                       self.anoList = data;
                   },
                   error: function () {

                   }
               });
           },
            changeData: function(){
                var self = this;
                $.ajax({
                    url: _ctx+"/ano/ano81Data",
                    method: "get",
                    dataType: "json",
                    success: function (data) {
                        self.anoList.splice(data.length);
                    },
                    error: function () {

                    }
                });
            }
        },
        created: function () {
            var self = this;
            self.initData();
        }
    });
});*/
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/ano/ano81Data",
            method: "get",
            dataType: "json",
            success: function (data) {
                $("table.ano81 tbody").html("");
                var tmpHtml  = '';
                for(var i = 0;i<data.length;i++){
                    tmpHtml+='<tr><td>'+data[i].ioc1
                       +'</td><td>'+data[i].ioc2
                       +'</td><td>'+data[i].ioc3
                       +'</td><td>'+data[i].ioc4
                       +'</td><td>'+data[i].ioc5
                       +'</td><td>'+data[i].ioc6
                       +'</td><td>'+data[i].ioc7
                       +'</td><td>'+data[i].downunit
                       +'</td></tr>';
                }
                $("table.ano81 tbody").html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    init();
    setInterval(function(){
        init();
    },300000)
});
