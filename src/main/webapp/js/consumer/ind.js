/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    var impactList = [];
    var regularList = [];
    var totalList = [];
    function initData(){
        $.ajax({
            url: _ctx+"/ano/indiHomeData",
            method: "get",
            dataType: "json",
            success: function (data) {
                impactList = data.homeImpactList;
                regularList = data.homeRegularList;
                totalList = data.homeTotalList;
                dealData(impactList);
                dealData(regularList);
                dealData(totalList);
                $('.ind-time').text(data.clienttime);
                var totalHtml = initDom(totalList);
                var imHtml = initDom(impactList);
                var reHtml = initDom(regularList);
                $("#total-table").html("");
                $("#total-table").append(totalHtml);
                $("#impact-table").html("");
                $("#impact-table").append(imHtml);
                $("#regular-table").html("");
                $("#regular-table").append(reHtml);
            },
            error: function () {

            }
        });
    }
    function dealData(data){
        for(var i=0;i<data.length;i++){
            if(data[i].dev<0){
                data[i].status = 'Menang';
            }
            if(data[i].dev==0){
                data[i].status = 'Seri';
            }
            if(data[i].dev>0){
                data[i].status = 'Kalah';
            }
        }
    }
    function initDom(data){


        var c = data.length -1 ;
        if(data[c].dev > 0){
            var  tmpHtml = '<tr><td rowspan="2">'
                +'TOTAL' +'</td><td>'
                +data[c].sh+'</td><td>'
                +data[c].op+'</td><td style="color: #FFFFFF;background: red;">'
                +data[c].dev+'</td></tr><tr><td>'
                +data[c].sh1+'</td><td>'
                +data[c].cl+'</td><td style="color: #FFFFFF;background: red;">'
                +data[c].status+'</td></tr>';
        }else if(data[c].dev < 0){
            var  tmpHtml = '<tr><td rowspan="2">'
                +'TOTAL' +'</td><td>'
                +data[c].sh+'</td><td>'
                +data[c].op+'</td><td style="color: #FFFFFF;background: green;">'
                +data[c].dev+'</td></tr><tr><td>'
                +data[c].sh1+'</td><td>'
                +data[c].cl+'</td><td style="color: #FFFFFF;background: green;">'
                +data[c].status+'</td></tr>';
        }else{
            var  tmpHtml = '<tr><td rowspan="2">'
                +'TOTAL' +'</td><td>'
                +data[c].sh+'</td><td>'
                +data[c].op+'</td><td style="color: #000000;background: yellow;">'
                +data[c].dev+'</td></tr><tr><td>'
                +data[c].sh1+'</td><td>'
                +data[c].cl+'</td><td style="color: #000000;background: yellow;">'
                +data[c].status+'</td></tr>';
        }



        for(var i=0;i<data.length-1;i++){

            if(data[i].dev>0){
                tmpHtml += '<tr><td rowspan="2">'
                    +data[i].regional+'</td><td>'
                    +data[i].sh+'</td><td>'
                    +data[i].op+'</td><td style="color: #FFFFFF;background: red;">'
                    +data[i].dev+'</td></tr><tr><td>'
                    +data[i].sh1+'</td><td>'
                    +data[i].cl+'</td><td style="color: #FFFFFF;background: RED;">'
                    +data[i].status+'</td></tr>';
            }else if(data[i].dev<0){
                tmpHtml += '<tr><td rowspan="2">'
                    +data[i].regional+'</td><td>'
                    +data[i].sh+'</td><td>'
                    +data[i].op+'</td><td style="color: #FFFFFF;background: green;">'
                    +data[i].dev+'</td></tr><tr><td>'
                    +data[i].sh1+'</td><td>'
                    +data[i].cl+'</td><td style="color: #FFFFFF;background: green;">'
                    +data[i].status+'</td></tr>';
            }else{
                tmpHtml += '<tr><td rowspan="2">'
                    +data[i].regional+'</td><td>'
                    +data[i].sh+'</td><td>'
                    +data[i].op+'</td><td style="color: #000000;background: yellow;">'
                    +data[i].dev+'</td></tr><tr><td>'
                    +data[i].sh1+'</td><td>'
                    +data[i].cl+'</td><td style="color: #000000;background: yellow;">'
                    +data[i].status+'</td></tr>';
            }
        }




        return tmpHtml;
    }
    initData();
    setInterval(function(){
        initData();
    },300000);
});
