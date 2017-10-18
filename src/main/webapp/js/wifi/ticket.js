/**
 * Created by lenovo on 2017/6/26.
 */
/*$(function () {
    var digitalData = new Vue({
        el: "#ticket-data",
        data: {
            ticketList:[],
            test: 0,
            time: "",
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiTicketData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.ticketList = data.vWifiTickets;
                    self.time = data.nowTime;
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
            url: _ctx+"/wifi/vWifiTicketData",
            method: "get",
            dataType: "json",
            success: function (data) {
                var time ='Last Update:'+ data.nowTime;
                $('.ticket-time').text(time);
                $("table.ticket tbody").html("");
                var tmpHtml  = '';
                var tableData = data.vWifiTickets;
                for(var i = 0;i<tableData.length;i++){
                    tmpHtml+='<tr><td>'+tableData[i].ioc1
                        +'</td><td>'+tableData[i].ioc2
                        +'</td><td>'+tableData[i].ioc3
                        +'</td><td>'+tableData[i].ioc4
                        +'</td><td>'+tableData[i].ioc5
                        +'</td><td>'+tableData[i].ioc6
                        +'</td><td>'+tableData[i].ioc7
                        +'</td><td>'+tableData[i].ioc8
                        +'</td><td>'+tableData[i].ioc9
                        +'</td><td>'+tableData[i].ioc10
                        +'</td><td>'+tableData[i].ioc11
                        +'</td><td>'+tableData[i].ioc12
                        +'</td><td>'+tableData[i].ioc13+'</td>'
                        +select12(tableData[i].ioc12)
                        +'</tr>';
                }
                $("table.ticket tbody").html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    function select12(data){
        var str = '';
        if(parseInt(data)==0){
            str = '<td><span class="bule-star"></span></td>';
        }else{
            str = '<td style="color: #FFFFFF;background: #eb0300;">kalah</td>';
        }
         return str;
    }
    init();
    setInterval(function(){
        init();
    },300000);
});
