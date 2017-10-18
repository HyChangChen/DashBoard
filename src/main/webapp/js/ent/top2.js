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
                if(_show == "2"){
                    tool.headerInit(data.enterpriseMap["2"],".top2-layout-left",pageTit);
                    var data1 = tool.dealData(data.enterpriseMap["2"]);
                    tool.headerInit(data.enterpriseMap["3"],".top2-layout-right",pageTit);
                    var data2 = tool.dealData(data.enterpriseMap["3"]);
                    //initEchart1折线图，initEchart2圆形图
                    initEchart2("echart11",data1.leftTop.closenums,data1.leftTop.opennums,"REACTIVE");
                    initEchart1("echart12",data1.middleTop,data1.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart13",data1.rightTop,data1.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                    initEchart2("echart14",data1.leftBottom.closenums,data1.leftBottom.opennums,"PROACTIVE");
                    initEchart1("echart15",data1.middleBottom,data1.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart16",data1.rightBottom,data1.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                    //initEchart1折线图，initEchart2圆形图
                    //两个用户
                    initEchart2("echart21",data2.leftTop.closenums,data2.leftTop.opennums,"REACTIVE");
                    initEchart1("echart22",data2.middleTop,data2.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart23",data2.rightTop,data2.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                    initEchart2("echart24",data2.leftBottom.closenums,data2.leftBottom.opennums,"PROACTIVE");
                    initEchart1("echart25",data2.middleBottom,data2.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart26",data2.rightBottom,data2.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                }else{
                    var dataIndex = parseInt(_show);
                    var data1  = tool.dealData(data.enterpriseMap[dataIndex]);
                    var data2 = tool.dealData(data.enterpriseMap[dataIndex+1]);
                    var data3  = tool.dealData(data.enterpriseMap[dataIndex+2]);
                    var data4  = tool.dealData(data.enterpriseMap[dataIndex+3]);
                    //initEchart1折线图，initEchart2圆形图
                    tool.headerInit(data.enterpriseMap[dataIndex],".top2-layout-left",pageTit);
                    initEchart2("echart11",data1.leftTop.closenums,data1.leftTop.opennums,"REACTIVE");
                    initEchart1("echart12",data1.middleTop,data1.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart13",data1.rightTop,data1.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                    initEchart2("echart14",data1.leftBottom.closenums,data1.leftBottom.opennums,"PROACTIVE");
                    initEchart1("echart15",data1.middleBottom,data1.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart16",data1.rightBottom,data1.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                    //initEchart1折线图，initEchart2圆形图
                    //两个用户
                    tool.headerInit(data.enterpriseMap[dataIndex+1],".top2-layout-right",pageTit);
                    initEchart2("echart21",data2.leftTop.closenums,data2.leftTop.opennums,"REACTIVE");
                    initEchart1("echart22",data2.middleTop,data2.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart23",data2.rightTop,data2.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                    initEchart2("echart24",data2.leftBottom.closenums,data2.leftBottom.opennums,"PROACTIVE");
                    initEchart1("echart25",data2.middleBottom,data2.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                    initEchart1("echart26",data2.rightBottom,data2.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                    var i = 0;
                    var timer = setInterval(function(){
                        i++;
                        if(i>=2){
                            i=0;
                        }
                        switch(i){
                            case 1:
                                //initEchart1折线图，initEchart2圆形图
                                tool.headerInit(data.enterpriseMap[dataIndex+2],".top2-layout-left",pageTit);
                                initEchart2("echart11",data3.leftTop.closenums,data3.leftTop.opennums,"REACTIVE");
                                initEchart1("echart12",data3.middleTop,data3.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart13",data3.rightTop,data3.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                                initEchart2("echart14",data3.leftBottom.closenums,data3.leftBottom.opennums,"PROACTIVE");
                                initEchart1("echart15",data3.middleBottom,data3.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart16",data3.rightBottom,data3.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                                //initEchart1折线图，initEchart2圆形图
                                //两个用户
                                tool.headerInit(data.enterpriseMap[dataIndex+3],".top2-layout-right",pageTit);
                                initEchart2("echart21",data4.leftTop.closenums,data4.leftTop.opennums,"REACTIVE");
                                initEchart1("echart22",data4.middleTop,data4.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart23",data4.rightTop,data4.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                                initEchart1("echart25",data4.middleBottom,data4.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart26",data4.rightBottom,data4.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                                break;
                            default:
                                //initEchart1折线图，initEchart2圆形图
                                tool.headerInit(data.enterpriseMap[dataIndex],".top2-layout-left",pageTit);
                                initEchart2("echart11",data1.leftTop.closenums,data1.leftTop.opennums,"REACTIVE");
                                initEchart1("echart12",data1.middleTop,data1.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart13",data1.rightTop,data1.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                                initEchart2("echart14",data1.leftBottom.closenums,data1.leftBottom.opennums,"PROACTIVE");
                                initEchart1("echart15",data1.middleBottom,data1.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart16",data1.rightBottom,data1.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                                //initEchart1折线图，initEchart2圆形图
                                //两个用户
                                tool.headerInit(data.enterpriseMap[dataIndex+1],".top2-layout-right",pageTit);
                                initEchart2("echart21",data2.leftTop.closenums,data2.leftTop.opennums,"REACTIVE");
                                initEchart1("echart22",data2.middleTop,data2.middleTopName,"REACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart23",data2.rightTop,data2.rightTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                                initEchart2("echart24",data2.leftBottom.closenums,data2.leftBottom.opennums,"PROACTIVE");
                                initEchart1("echart25",data2.middleBottom,data2.middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                                initEchart1("echart26",data2.rightBottom,data2.rightBName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                                break;
                        }
                    },20000);
                }

            },
            error: function(){

            }
        })
    }
    function initEchart1(domId,echartData,xData,tit) {
        var xAxisData =  xData;
        var legendData;
        var seriesData = [];
        if(domId=='echart26'||domId=='echart16'){
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
                x:30,
                y:50,
                x2:100,
                y2:100,
                width: '75%',
                height: '60%',
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
                    radius : ['30%', '50%'],
                    itemStyle : {
                        normal : {
                            //不显示中间的字，而显示成饼图的那种label
                            label : {
                                show: lableShow,
                                fontSize: '18',
                                textStyle:{
                                    align:'center',
                                    baseline: 'center',
                                    color:"#fff"
                                },
                                fontWeight: 'normal',
                                formatter: "{b}:\n{c}"
                            },
                            labelLine : {
                                show : lableShow,
                                length: -2
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