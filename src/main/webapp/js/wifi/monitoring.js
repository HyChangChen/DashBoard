/**
 * Created by lenovo on 2017/6/26.
 */
/*$(function () {
    var digitalData = new Vue({
        el: "#moni-data",
        data: {
            moniList:[],
            titTime: ''
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiMonitoringData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.moniList = data.monitoringList;
                    self.titTime = data.nowtime;
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
            url: _ctx+"/wifi/vWifiMonitoringData",
            method: "get",
            dataType: "json",
            success: function (data) {
                var titTime = data.nowtime;
                $(".titTime").text(titTime);
                $("table.monitoring-table tbody").html("");
                var tmpHtml  = '';
                var tableData = data.monitoringList;
                for(var i = 0;i<tableData.length;i++){
                    tmpHtml+='<tr><td>'+tableData[i].ioc1+'</td>'
                           +txtColor(tableData[i].ioc2,12)
                           +txtColor(tableData[i].ioc3,48)
                           +txtColor(tableData[i].ioc4,48)
                           +txtColor(tableData[i].ioc5,48)
                           +txtColor(tableData[i].ioc6,12)
                           +txtColor(tableData[i].ioc7,48)
                           +txtColor(tableData[i].ioc8,48)
                           +txtColor(tableData[i].ioc9,48)
                           +txtColor(tableData[i].ioc10,12)
                           +txtColor(tableData[i].ioc11,48)
                           +txtColor(tableData[i].ioc12,48)
                           +txtColor(tableData[i].ioc13,48)
                           +txtColor(tableData[i].ioc14,12)
                           +txtColor(tableData[i].ioc15,48)
                           +txtColor(tableData[i].ioc16,48)
                           +txtColor(tableData[i].ioc17,48)
                           +radiusColor(tableData[i].ioc18)
                           +radiusColor(tableData[i].ioc19)
                           +radiusColor(tableData[i].ioc20)
                           +radiusColor(tableData[i].ioc21)
                           +radiusColor(tableData[i].ioc22)
                           +radiusColor(tableData[i].ioc23)
                           +radiusColor(tableData[i].ioc24)
                           +radiusColor(tableData[i].ioc25)
                           +'</tr>';
                }
                $("table.monitoring-table tbody").html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    function txtColor(data,normal){
        var str='';
        if(data>normal){
            str ='<td class="text-red">'+data+'</td>';
        }else{
            str ='<td class="text-blue">'+data+'</td>';
        }
        if(data == 0){
            str ='<td class="text-fff">'+data+'</td>';
        }
        return str;
    }
    function radiusColor(data){
        var str='';
        if(data>0.0){
            str ='<td class="green-radius" title='+data+'></td>';
        }else{
            str ='<td class="red-radius" title='+data+'></td>';
        }
        if(data == 0){
            str ='<td class="yellow-radius" title='+data+'></td>';
        }
        return str;
    }
    init();
    setInterval(function(){
        init();
    },10000);
});
