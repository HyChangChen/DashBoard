/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/enterprise/entData",
            method: "get",
            data:{
                type: _type
            },
            dataType: "json",
            success: function(data){
                window.clearInterval(timer);
                $(".first-page").show();
                $(".sec-page").hide();
                $(".third-page").hide();
                var pageTit = '';
                switch(_type){
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
                $(".pageTit").text(pageTit);
                var tool = new entUtil();
                //tool.ShowSla(data.threeColor,pageTit);
                tool.ShowSla(data.threeColor,"",pageTit);

                var pieTop = data.pieRightnowList;
                var pieBottom = data.pieProactiveList;
                var lineTop = data.rightnowTicketM;
                var lineBottom = data.proactiveTicketM;
                var nameList = data.nameList;
                var secPage = data.enterpriseRegionMap;
                var thirdPage =  data.enterpriseProductMap;

                if(pieTop.length==0){
                    pieTop={
                        closenums: undefined,
                        opennums: undefined
                    }
                }else{
                    pieTop = data.pieRightnowList[0];
                }
                if(pieBottom.length==0){
                    pieBottom={
                        closenums: undefined,
                        opennums: undefined
                    }
                }else{
                    pieBottom = data.pieProactiveList[0];
                }

                var i = 1;
                initEchartPie("echart1",pieTop.closenums,pieTop.opennums,"Reactive");
                initEchartLine("echart2",lineTop,nameList,"Reactive TKT(30 DAYS)");
                initEchartPie("echart3",pieBottom.closenums,pieBottom.opennums,"Proactive");
                initEchartLine("echart4",lineBottom,nameList,"Proactive TKT(30 DAYS)");
                var timer = setInterval(function(){
                    i++;
                    if(i>=3){
                        i=0;
                    }
                    switch(i){
                        case 1:
                            $(".first-page").show();
                            $(".sec-page").hide();
                            $(".third-page").hide();
                            break;
                        case 2:
                            $(".first-page").hide();
                            $(".sec-page").show();
                            $(".third-page").hide();
                            initEchartScale("echart5",secPage,data.regionNameList,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                            break;
                        default:
                            $(".first-page").hide();
                            $(".sec-page").hide();
                            $(".third-page").show();
                            initEchartScale("echart6",thirdPage,data.productNameList,"TRAFFIC BY PRODUCT (2 DAYS PER 6 HOURS)");
                            break;
                    }


                },20000);
            },
            error: function(){

            }
        })
    }
    function initEchartLine(domId,echartData,xAxis,tit) {
        var legendData = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
        var seriesData = [];
        var xAxisData =  xAxis;
        legendData.forEach(function(el){
            var tmpObj = {};
            tmpObj.type = 'line';
            tmpObj.smooth = true;
            tmpObj.name = el;
            tmpObj.data = echartData[el];
            tmpObj.symbol = 'none';
            seriesData.push(tmpObj)
        });
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: tit,
                x:'left',
                y: 'top',
                textStyle: {
                    fontSize: '16',
                    fontWeight: 'bold',
                    color: '#fff'
                }
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
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
                x: 30,
                y: 50,
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
                        show:true,
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
                    name:'Ticket',
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
    function initEchartPie(idDom,data1,data2,titName){
        var initData;
        var bgcolor = [];
        var lableShow = false;
        if((typeof(data1)=="undefined"&&typeof(data2)=="undefined")||(data1==0&&data2==0)){
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
            lableShow = true;
        };
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title : {
                text: titName,
                x:'left',
                y: 'top',
                textStyle: {
                    fontSize: '16',
                    fontWeight: 'bold',
                    color: '#fff'
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
                            label:{
                                show: lableShow,
                                    fontSize: '18',
                                    fontWeight: 'normal',
                                    formatter : function (params) {
                                        return params.name+":"+params.value;
                                    }
                            },
                            labelLine :{
                                show: lableShow
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
    function initEchartScale(idDom,data,xAxis,tit){
        var legendData = [];
        if(idDom=='echart6'){
            legendData = ['ASTINET','IPTRANSIT','VPNIP'];
        }else{
            legendData = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
        }
        var serisData = [];
        var xAxisData =  xAxis;
        if(data.length==0){
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
                tmpObj.data = data[el];
                tmpObj.symbol = 'none';
                tmpObj.itemStyle =  {normal: {areaStyle: {type: 'default'}}};
                serisData.push(tmpObj)
            });
        };
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title: {
                text: tit,
                x:'center',
                y: 'top',
                textStyle: {
                    fontSize: '16',
                    fontWeight: 'bold',
                    color: '#fff'
                }
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
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
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字
                        rotate: 45,    //旋转度数
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#666C7F',
                            fontSize:12
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
                    name: 'GB',
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
            series:  serisData
        };
        myChart.setOption(option);
    }
    initData();
    setInterval(function(){
        initData();
    },300000);
}());