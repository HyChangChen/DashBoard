$(function(){
    function init(){
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
        var time ='Last Update:'+ nowTime;
        $('.ticket-time').text(time);
        $.ajax({
            url: _ctx+"/ano/monthlyData",
            method: "get",
            dataType: "json",
            success: function (data) {

               // $('table.monthly thead tr td.ticket-time').html(time);
                $("table.monthly tbody").html("");
                var tmpHtml  = '';
                var datas = data.iocProMonthlyList;
                for(var i = 0;i<datas.length;i++){
                    var firstTd = '';
                    if(i>=7){
                        firstTd = 'BIGES';
                    }else{
                        firstTd = "TREG-"+(i+1);
                    }
                    tmpHtml+='<tr><td width="20%">'+firstTd
                        +'</td><td width="20%">'+datas[i].mtt
                        +'</td><td width="20%">'+datas[i].mtti
                        +'</td><td width="20%">'+datas[i].jmlAll.toFixed(2)
                        +'</td><td width="20%">'+datas[i].tt
                        +'</td></tr>';
                }
                $("table.monthly tbody").html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    init();
});