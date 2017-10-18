/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/enterprise/top1Data",
            method: "get",
            data:{
                type: _type,
                show: _show
            },
            dataType: "json",
            success: function(data){
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
                window.clearInterval(timer);
                var tool = new entUtil();
                if(_type == "DWS"){
                    var j = parseInt(_show);
                    //wholesale
                    if(_show == '18'){
                        var data1 = tool.dealData(data.enterpriseMap[j-3]);
                        var data2 = tool.dealData(data.enterpriseMap[j-2]);
                        var data3 = tool.dealData(data.enterpriseMap[j-1]);
                        var data4 = tool.dealData(data.enterpriseMap[j]);
                        tool.headerInit(data.enterpriseMap[j],"",pageTit);
                        initPage(data4);
                        var i = 0;
                        setInterval(function(){
                            i++;
                            if(i>=4){
                                i=0;
                            }
                            switch(i){
                                case 1:
                                    tool.headerInit(data.enterpriseMap[j-3],"",pageTit);
                                    initPage(data1);
                                    break;
                                case 2:
                                    tool.headerInit(data.enterpriseMap[j-2],"",pageTit);
                                    initPage(data2);
                                case 3:
                                    tool.headerInit(data.enterpriseMap[j-1],"",pageTit);
                                    initPage(data3);
                                default:
                                    tool.headerInit(data.enterpriseMap[j],"",pageTit);
                                    initPage(data4);
                                    break;
                            }
                        },20000);

                    }else{
                        var data1 = tool.dealData(data.enterpriseMap[j-1]);
                        var data2 = tool.dealData(data.enterpriseMap[j]);
                        //initEchart1折线图，initEchart2圆形图
                        tool.headerInit(data.enterpriseMap[j],"",pageTit);
                        initPage(data2);
                        var i = 0;
                        var timer = setInterval(function(){
                            i++;
                            if(i>=2){
                                i=0;
                            }
                            switch(i){
                                case 1:
                                    tool.headerInit(data.enterpriseMap[j-1],"",pageTit);
                                    initPage(data1);
                                    break;
                                default:
                                    tool.headerInit(data.enterpriseMap[j],"",pageTit);
                                    initPage(data2);
                                    break;
                            }
                        },20000);
                    }
                }else{
                    //enterprise
                    tool.headerInit(data.enterpriseMap["1"],"",pageTit);
                    var data1 = tool.dealData(data.enterpriseMap["1"]);
                    //initEchart1折线图，initEchart2圆形图
                    initPage(data1);
                }
            },
            error: function(){

            }
        })
    }
    function initPage(data){
        initEchart2("echart1",data.leftTop.closenums,data.leftTop.opennums,"REACTIVE");
        initEchart1("echart2",data.middleTop,data.middleTopName,"REACTIVE TICKETS(30 DAYS)");
        initEchart1("echart3",data.rightTop,data.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
        initEchart2("echart4",data.leftBottom.closenums,data.leftBottom.opennums,"PROACTIVE");
        initEchart1("echart5",data.middleBottom,data.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
        initEchart1("echart6",data.rightBottom,data.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
    }
    function initEchart1(domId,echartData,xData,tit) {
        var xAxisData =  xData;
        var legendData = [];
        var seriesData = [];
        if(domId == 'echart6'){
            legendData = ['ASTINET','IPTRANSIT','VPNIP'];
        }else{
            legendData = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
        }
        if(echartData.length==0){
            seriesData = [{
                name:'nodata',
                type:'line',
                smooth:true,
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
        };
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
                                show: lableShow,
                                position : 'outer',
                                formatter : function (params) {
                                    return params.name+":"+params.value;
                                }
                            },
                            labelLine : {
                                show : lableShow
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