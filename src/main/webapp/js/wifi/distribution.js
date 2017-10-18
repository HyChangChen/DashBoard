/**
 * Created by lenovo on 2017/6/26.
 */
/*$(function () {
    var digitalData = new Vue({
        el: "#distribution-data",
        data: {
            disList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiDistributionData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.disList = data;
                },
                error: function () {

                }
            });
        }
    });
});*/
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/wifi/vWifiDistributionData",
            method: "get",
            dataType: "json",
            success: function (data) {
                $("table.distribution tbody").html("");
                var tmpHtml  = '';
                for(var i = 0;i<data.length;i++){
                    tmpHtml+='<tr><td>'+data[i].ioc1
                        +'</td><td>'+data[i].ioc2
                        +'</td><td>'+data[i].ioc3
                        +'</td><td>'+data[i].ioc7
                        +'</td><td>'+data[i].ioc5
                        +'</td><td>'+data[i].ioc10
                        +'</td><td>'+data[i].ioc4
                        +'</td><td>'+data[i].ioc8
                        +'</td><td>'+data[i].ioc6
                        +'</td><td>'+data[i].ioc9
                        //+'</td><td>'+data[i].ioc11
                        +'</td></tr>';
                }
                $("table.distribution tbody").html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    init();
    setInterval(function(){
        init();
    },300000);
});
