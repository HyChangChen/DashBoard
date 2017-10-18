/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/enterprise/top1Data",
            method: "get",
            data:{
                type: type,
                show: '4'
            },
            dataType: "json",
            success: function(data){
                var pageTit = '';
                switch(type){
                    case 'DES':
                        pageTit = "Enterprise";
                        break;
                    case 'DGS':
                        pageTit = "Government";
                        break;
                    case 'DBS':
                        pageTit = "Business";
                        break;
                    default:
                        pageTit = "Wholesale";
                        break;
                }
                //页面用户名展示
                $("#top45 .top2-layout-left .ent-header h4").text(data.enterpriseMap["4"].name);
                //sla数据展示
                ShowSla(data.enterpriseMap["4"].threeColor,"#top45 .top2-layout-left",pageTit);
                //event
                showEvent(data.enterpriseMap["4"].eventList,"#top45 .top2-layout-left");
                //图标展示
                showLogo(data.enterpriseMap["4"].iconList,"#top45 .top2-layout-left");
                var leftTop1;
                var leftBottom1;
                //处理后台传回的数据为空的状态
                if(data.enterpriseMap["4"].rightnowList.length==0){
                    leftTop1 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    var leftTop1 = data.enterpriseMap["4"].rightnowList[0];
                };
                if(data.enterpriseMap["4"].proactiveList.length==0){
                    leftBottom1 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftBottom1 = data.enterpriseMap["4"].proactiveList[0];
                }
                var middleTop1 = data.enterpriseMap["4"].rightnowTicketM;
                var middleTopName1 = data.enterpriseMap["4"].nameList;
                var middleBottom1 = data.enterpriseMap["4"].proactiveTicketM;
                var middleBottomName1 = data.enterpriseMap["4"].nameList;

                //页面用户名展示
                $("#top45 .top2-layout-right .ent-header h4").text(data.enterpriseMap["5"].name);
                //sla数据展示
                ShowSla(data.enterpriseMap["5"].threeColor,"#top45 .top2-layout-right",pageTit);
                //event
                showEvent(data.enterpriseMap["5"].eventList,"#top45 .top2-layout-right");
                //图标展示
                showLogo(data.enterpriseMap["5"].iconList,"#top45 .top2-layout-right");
                var leftTop2;
                var leftBottom2;
                //处理后台传回的数据为空的状态
                if(data.enterpriseMap["5"].rightnowList.length==0){
                    leftTop2 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    var leftTop2 = data.enterpriseMap["5"].rightnowList[0];
                };
                if(data.enterpriseMap["5"].proactiveList.length==0){
                    leftBottom2 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftBottom2 = data.enterpriseMap["5"].proactiveList[0];
                }
                var middleTop2 = data.enterpriseMap["5"].rightnowTicketM;
                var middleTopName2 = data.enterpriseMap["5"].nameList;
                var middleBottom2 = data.enterpriseMap["5"].proactiveTicketM;
                var middleBottomName2 = data.enterpriseMap["5"].nameList;


                //页面用户名展示
                $("#top67 .top2-layout-left .ent-header h4").text(data.enterpriseMap["6"].name);
                //sla数据展示
                ShowSla(data.enterpriseMap["6"].threeColor,"#top67 .top2-layout-left",pageTit);
                //event
                showEvent(data.enterpriseMap["6"].eventList,"#top67 .top2-layout-left");
                //图标展示
                showLogo(data.enterpriseMap["6"].iconList,"#top67 .top2-layout-left");
                var leftTop3;
                var leftBottom3;
                //处理后台传回的数据为空的状态
                if(data.enterpriseMap["6"].rightnowList.length==0){
                    leftTop3 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    var leftTop3 = data.enterpriseMap["6"].rightnowList[0];
                };
                if(data.enterpriseMap["6"].proactiveList.length==0){
                    leftBottom3 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftBottom3 = data.enterpriseMap["6"].proactiveList[0];
                }
                var middleTop3 = data.enterpriseMap["6"].rightnowTicketM;
                var middleTopName3 = data.enterpriseMap["6"].nameList;
                var middleBottom3 = data.enterpriseMap["6"].proactiveTicketM;
                var middleBottomName3 = data.enterpriseMap["6"].nameList;

                //页面用户名展示
                $("#top67 .top2-layout-right .ent-header h4").text(data.enterpriseMap["7"].name);
                //sla数据展示
                ShowSla(data.enterpriseMap["7"].threeColor,"#top67 .top2-layout-right",pageTit);
                //event
                showEvent(data.enterpriseMap["7"].eventList,"#top67 .top2-layout-right");
                //图标展示
                showLogo(data.enterpriseMap["7"].iconList,"#top67 .top2-layout-right");
                var leftTop4;
                var leftBottom4;
                //处理后台传回的数据为空的状态
                if(data.enterpriseMap["7"].rightnowList.length==0){
                    leftTop4 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    var leftTop4 = data.enterpriseMap["7"].rightnowList[0];
                };
                if(data.enterpriseMap["7"].proactiveList.length==0){
                    leftBottom4 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftBottom4 = data.enterpriseMap["7"].proactiveList[0];
                }
                var middleTop4 = data.enterpriseMap["7"].rightnowTicketM;
                var middleTopName4 = data.enterpriseMap["7"].nameList;
                var middleBottom4 = data.enterpriseMap["7"].proactiveTicketM;
                var middleBottomName4 = data.enterpriseMap["7"].nameList;
                //initEchart1折线图，initEchart2圆形图
                //一个用户
                initEchart2("echart11",leftTop1.closenums,leftTop1.opennums,"PERCENTAGE REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart12",middleTop1,middleTopName1,"REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart13",middleTop1,middleTopName1,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                initEchart2("echart14",leftBottom1.closenums,leftBottom1.opennums,"ERCENTAGE PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart15",middleBottom1,middleBottomName1,"PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart16",middleBottom1,middleBottomName1,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                //两个用户
                initEchart2("echart21",leftTop2.closenums,leftTop2.opennums,"PERCENTAGE REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart22",middleTop2,middleTopName2,"REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart23",middleTop2,middleTopName2,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                initEchart2("echart24",leftBottom2.closenums,leftBottom2.opennums,"ERCENTAGE PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart25",middleBottom2,middleBottomName2,"PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart26",middleBottom2,middleBottomName2,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");

                initEchart2("echart31",leftTop3.closenums,leftTop3.opennums,"PERCENTAGE REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart32",middleTop3,middleTopName3,"REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart33",middleTop3,middleTopName3,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                initEchart2("echart34",leftBottom3.closenums,leftBottom3.opennums,"ERCENTAGE PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart35",middleBottom3,middleBottomName3,"PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart36",middleBottom3,middleBottomName3,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");

                initEchart2("echart41",leftTop4.closenums,leftTop4.opennums,"PERCENTAGE REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart42",middleTop4,middleTopName4,"REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart43",middleTop4,middleTopName4,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                initEchart2("echart44",leftBottom4.closenums,leftBottom4.opennums,"ERCENTAGE PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart45",middleBottom4,middleBottomName4,"PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart46",middleBottom4,middleBottomName4,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");

            },
            error: function(){

            }
        })
    }
    //展示sla数据
    function ShowSla(data,domName){
        var colorData1 = data;
        var cust = colorData1.cust ==null?'':colorData1.cust;
        var eq = colorData1.eq ==null?'0':colorData1.eq;
        var gt = colorData1.gt ==null?'0':colorData1.gt;
        var lt = colorData1.lt ==null?'0':colorData1.lt;
        $(domName+" "+".span-layout .sla").text(cust);
        $(domName+" "+".span-layout .red").text(eq);
        $(domName+" "+".span-layout .yellow").text(gt);
        $(domName+" "+".span-layout .green").text(lt);
    }
    function showEvent(data,domName){
        var events = data;
        var trHtml ="";
        for(var i =0,len=events.length;i<len;i++){
            var event = events[i].affevent;
            var time = event.split(" ")[0];
            var other = event.split("/")[3];
            trHtml+="<tr><td>"+time+"/"+other+"</td></tr>";
            $(domName+" "+".top1-event table").show();
        }
        $(domName+" "+".top1-event table tbody").html(trHtml);
    }
    function showLogo(data,domName){
        var logoList = data;
        for(var i=0,len=logoList.length;i<len;i++){
            var className = domName+' '+'.'+logoList[i].lay;
            var imgUrl = '';
            if(logoList[i].status=='0'){
                imgUrl = _ctx+'/imgs/red/'+logoList[i].lay+'.png';
            }else{
                imgUrl = _ctx+'/imgs/blue/'+logoList[i].lay+'.png';
            }
            $(className).show();
            $(className).attr('src',imgUrl);
        }
    }
    function initEchart1(domId,echartData,xData,tit) {
        var xAxisData =  xData;
        var legendData = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
        var seriesData = [];
        if(echartData.length==0){
            serisData = [{
                name:'nodata',
                type:'line',
                smooth:true,
                itemStyle: {normal: {areaStyle: {type: 'default'}}},
                data:[0]
            }];
        }else{
            legendData.forEach(function(el){
                var tmpObj = {};
                tmpObj.type = 'line';
                tmpObj.smooth = true;
                tmpObj.name = el;
                tmpObj.data = echartData[el];
                tmpObj.symbol = 'none';
                seriesData.push(tmpObj)
            });
        }
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: tit,
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: '12',
                    fontWeight: 'bold',
                    color: '#BDBEC3'
                }
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                show:false,
                orient:'vertical',
                x:'right',
                y:'top',
                textStyle:{
                    fontSize: 12,
                    color:'#fff'
                },
                data:legendData
            },
            calculable: false,
            grid:{
                borderWidth:0,//外围边框线
                borderColor:'#666c7f'
            },
            xAxis: [
                {
                    type: 'category',
                    name:'Day',
                    boundaryGap : false,
                    axisLine : {    // 轴线
                        show: true
                    },
                    axisLabel : {//轴文本
                        show:false,
                        interval:0,    // {number}刻度的长短，可设为数字
                        rotate: 45,    //旋转度数
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#666C7F',
                            fontSize:15
                        }
                    },

                    lineStyle: {
                        color: 'green',
                        type: 'solid',
                        width: 2
                    },
                    splitLine : { //网格分隔线
                        show:false,
                        lineStyle: {
                            color: '#483d8b',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    splitArea : {show : false},//网格区域
                    data:xAxisData
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    axisLabel : {
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#fff',
                            fontSize:15
                        }
                    },
                    splitLine : { //分隔线
                        show:true,
                        lineStyle: {
                            color: '#666C7F',
                            type: 'dashed',
                            width: 1
                        }
                    }
                }
            ],
            color:['#FF7F50','#87CEFA','#DA70D6','#32CD32','#e91437','#e9e857','#4019d3','#e99c1a'],
            series:  seriesData
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });
    }
    function initEchart2(idDom,data1,data2,titName){
        var initData;
        var bgcolor = [];
        if(typeof(data1)=="undefined"&&typeof(data2)=="undefined"){
            initData=[
                {
                    value:1,name:'nodata'
                }
            ];
            bgcolor = ['#BDBEC3'];
        }else{
            initData=[
                {value:data1, name:'close'},
                {value:data2, name:'open'}
            ]
            bgcolor = ["#ff7f50", "#87cefa"];
        };
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title : {
                text: titName,
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: '12',
                    fontWeight: 'bold',
                    color: '#BDBEC3'
                }
            },
            color:bgcolor,
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c}"
            },
            legend: {
                show:false,
                data:['close','open']
            },
            calculable : false,
            series : [
                {
                    name:'',
                    type:'pie',
                    radius : ['40%', '70%'],
                    itemStyle : {
                        normal : {
                            //不显示中间的字，而显示成饼图的那种label
                            label : {
                                show: false,
                                position : 'inner',
                                // formatter: '{b} : {c} ({d}%)'
                                formatter: "{d}%"
                                //formatter: '{b} : {c} ({d}%)'
                            },
                            labelLine : {
                                show : false
                            }
                        },
                        emphasis : {
                            label : {
                                show : false,
                                position : 'center',
                                textStyle : {
                                    fontSize : '20',
                                    fontWeight : 'bold'
                                }
                            }
                        }
                    },
                    data:initData
                }
            ]
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });
    }
    initData();
    setInterval(function(){
        initData();
    },300000);
}());