/**
 * Created by lenovo on 2017/6/26.
 */
/*$(function () {
    var digitalData = new Vue({
        el: "#mob86",
        data: {
            mobList:[],
            week1:'',
            week2:''
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob86Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mobList = data.vMob86List;
                    self.week1 = data.week1.replace("W","W-");
                    self.week2 = data.week2.replace("W","W-");
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
            url: _ctx+"/mobile/vMob86Data",
            method: "get",
            dataType: "json",
            success: function (data) {
                var d = new Date();
                var years = d.getFullYear();
                var month = add_zero(d.getMonth()+1);
                var days = add_zero(d.getDate());
                var hours = add_zero(d.getHours());
                var minutes = add_zero(d.getMinutes());
                var second=add_zero(d.getSeconds());
                var nowTime = years+"-"+month+"-"+days+" "+hours+":"+minutes+":"+second;
            function add_zero(temp) {
            if(temp<10) return "0"+temp;
            else return temp;
        }
                var time ='Last Update:'+nowTime;
                $('.ticket-time').text(time);
                $("table.sites-table tbody").html("");
                $("table.week-table1 tbody").html("");
                $("table.week-table2 tbody").html("");

                var mobList = data.vMob86List;
                var week1 = data.week1.replace("W","W-");
                var week2 = data.week2.replace("W","W-");
                $(".week1").text(week1);
                $(".week2").text(week2);
                var sitesHtml = "";
                var week1Html = "";
                var week2Html = "";
                for(var i=0;i<mobList.length;i++){
                    sitesHtml+='<tr><td>'+mobList[i].ioc1
                              +'</td><td>'+mobList[i].total_site
                              +'</td></tr>';
                    week1Html+='<tr>'+ selectBg(mobList[i].ioc5,95)
                             + selectBg(mobList[i].ioc6,95)
                             + selectBg(mobList[i].ioc7,0)
                             +'</tr>';
                    week2Html+='<tr>'+ selectBg(mobList[i].ioc2,95)
                              + selectBg(mobList[i].ioc3,95)
                              + selectBg(mobList[i].ioc4,0)
                              +'</tr>';
                    /*week1Html+='<tr>'+ selectBg(mobList[i].ioc2,95)
                        + selectBg(mobList[i].ioc3,95)
                        + selectBg(mobList[i].ioc4,0)
                        +'</tr>';
                    week2Html+='<tr>'+ selectBg(mobList[i].ioc5,95)
                        + selectBg(mobList[i].ioc6,95)
                        + selectBg(mobList[i].ioc7,0)
                        +'</tr>';*/
                }
                $("table.sites-table tbody").html(sitesHtml);
                $("table.week-table1 tbody").html(week1Html);
                $("table.week-table2 tbody").html(week2Html);
            },
            error: function () {

            }
        });
    }
    function selectBg(data,normal){
        var str='';
        if(data<normal){
            str ='<td class="bg-red">'+data+'</td>';
        }else{
            str ='<td class="bg-blue">'+data+'</td>';
        }
        return str;
    }
    init();
    setInterval(function(){
        init();
    },10000);
});
