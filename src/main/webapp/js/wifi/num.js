/**
 * Created by lenovo on 2017/6/26.
 */
/*$(function () {
    var digitalData = new Vue({
        el: "#num-data",
        data: {
            numList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiNumberData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.numList = data;
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
            url: _ctx+"/wifi/vWifiNumberData",
            method: "get",
            dataType: "json",
            success: function (data) {
                var date = new Date();
                var time = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
                var timeResult = "Last Update:"+time;
                $(".ticket-time").text(timeResult);
                $("table.num tbody").html("");
                var tmpHtml  = '';
                for(var i = 0;i<data.length;i++){
                    tmpHtml+='<tr><td>'+data[i].ioc1
                        +'</td><td>'+data[i].ioc2
                        +'</td><td>'+data[i].ioc3
                        +'</td><td>'+data[i].ioc4
                        +'</td><td>'+data[i].ioc5
                        +'</td><td>'+data[i].ioc12
                        +'</td><td>'+data[i].ioc13
                        +'</td><td>'+data[i].ioc14
                        +'</td><td>'+data[i].ioc15
                        +'</td><td>'+data[i].ioc8
                        +'</td><td>'+data[i].ioc9
                        +'</td><td>'+data[i].ioc10
                        +'</td><td>'+data[i].ioc11
                        +'</td><td>'+data[i].ioc6
                        +'</td><td>'+data[i].ioc7
                        +'</td><td>'+data[i].ioc16
                        +'</td></tr>';
                }
                $("table.num tbody").html(tmpHtml);
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
