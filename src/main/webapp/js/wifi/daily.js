/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/wifi/wifiDailyData",
            method: "get",
            dataType: "json",
            success: function(data){
                initEchart("echart1",data.dailyticket,data.skuIdMap,data.nowtime);
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,yData,serisData,tit) {
        var yName = yData;
        var lendName = ["DBS","DGS","CONS","DES"];
        var serisDatas = [];
        for(var name in serisData){
            var tmpObj = {};
            tmpObj.name = name;
            tmpObj.type ="line";
            tmpObj.data = serisData[name];
            tmpObj.smooth = true;
            serisDatas.push(tmpObj);
        }
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            backgroundColor: '#03071D',//背景色
            title: {
                text: tit,
                x:10,
                y:10,
                backgroundColor:"#161C2F",
                textStyle: {
                    fontSize: 18,
                    fontWeight: 'bolder',
                    color: '#666c7f'          // 主标题文字颜色
                }
            },
            grid: {
                y: '20%',
                y2:'10%'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'none',
                    shadowColor:''
                }
            },
            legend: {
                orient:'vertical',
                x:'right',
                y:50,
                textStyle:{
                    fontSize: 12,
                    color: '#fff',
                },
                data:lendName
            },
            calculable: false,
            xAxis: [
                {
                    type: 'category',
                    boundaryGap : false,
                    axisLine : {    // 轴线
                        show: true
                    },
                    axisLabel : {//轴文本
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#FFFFFF'
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
                            color: '#666C7F',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    splitArea : {show : false},//网格区域
                    data:yName
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    fontsize:25,
                    axisLabel : {//轴数据风格
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        //rotate: 30,
                        margin:5,
                        splitNumber: 100,
                        textStyle:{
                            color: '#FFFFFF'
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
            series: serisDatas
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