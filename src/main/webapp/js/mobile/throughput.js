$(function(){
    var totalData;
    var nameList;
    var dataOder = ["JAKARTA","SURABAYA","MAKASAR","PEKANBARU"];
    $.ajax({
        url: _ctx+"/mobile/throughtputData",
        method: "get",
        dataType: "json",
        success: function (data) {
            totalData = data.agteMap;
            nameList = data.namelist;
            initEchart('echart1',nameList,totalData["JAKARTA"].in,totalData["JAKARTA"].out,totalData["JAKARTA"].opers,totalData["JAKARTA"].wrong,totalData["JAKARTA"].maxVal,'JAKARTA');
        },
        error: function () {

        }
    });
    var i = 0;
    scroll(5,'first-nav','sec-nav');
    function scroll(count,domName1,domName2){
        setInterval(function(){
            i++;
            if(i>=count){
                i=0;
            }else{
                var index= i;
                var liNav = '.'+domName1+' li';
                var thisLi = '.'+domName1+' li:nth-child('+index+')';
                $(liNav).css("color","#727386");
                $(thisLi).css("color","#fff");

                var liNav2 = '.'+domName2+' li'+' span';
                var thisLi2 = '.'+domName2+' li:nth-child('+index+')'+' span';
                $(liNav2).css("backgroundColor","#0a0f25");
                $(thisLi2).css("backgroundColor","#4a476a");

                var objectName = dataOder[i-1];
                initEchart('echart1',nameList,totalData[objectName].in,totalData[objectName].out,totalData[objectName].opers,totalData[objectName].wrong,totalData[objectName].maxVal,objectName);
            }
        },15000);
    }
    function initEchart(domId,xData,lineData1,lineData2,barData1,barData2,max,tit) {
        var legendData=["GbitsPerSecondOut","GbitsPerSecondIn"]
        var myChart = echarts.init(document.getElementById(domId));
        var barDatas1 = [];
        var data1 = 0;
        var barDatas2 = [];
        var data2 = 0;
        barDatas1.length = barData1.length;
        barDatas2.length = barData2.length;
        for(var k = 0;k<barData1.length;k++){
            if(barData1[k]>0){
                barDatas1[k] = max;
                data1 = barData1[k];
            }else{
                barDatas1[k] = 0;
            }
        }
        for(var m = 0;m<barData2.length;m++){
            if(barData2[m]>0){
                barDatas2[m] = max;
                data2 = barData2[m];
            }else{
                barDatas2[m] = 0;
            }
        }
        option = {
            backgroundColor:'#0A0F25',
            color:['#ef8a92','#87CEFA'],
            title: {
                text: tit,
                x:'center',
                y:'top',
                textStyle: {
                    fontSize: 24,
                    fontFamily: 'Arial',
                    color: '#E3E3DF'
                }
            },
            legend: {
                data: legendData,
                x: 'center',
                y: 'bottom',
                textStyle: {
                    fontSize: 16,
                    fontFamily: "Arial",
                    color: '#CECECE'
                }
            },
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            calculable : true,
            grid:{
                borderWidth: 1,
                color:'#494868'
            },
            xAxis : [
                {
                    type : 'category',
                    data: xData,
                    axisLabel:{
                        show: true,
                        textStyle:{
                            color:'#9FA0A1',
                        }
                    },
                    axisLine : {    // 轴线
                        show: true,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 2
                        },
                    },
                    splitLine : { //网格分隔线
                        show:true,
                        lineStyle: {
                            color: '#23283B',
                            type: 'solid',
                            width: 1
                        }
                    },
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    axisLabel:{
                        show: true,
                        textStyle:{
                            color:'#9FA0A1',
                        }
                    },
                    axisLine : {    // 轴线
                        show: true,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 2
                        },
                    },
                    splitLine : { //网格分隔线
                        show:true,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 1
                        }
                    },
                    splitArea:{
                        show: false
                    }
                }
            ],
            series :[{
                name: 'GbitsPerSecondIn',
                type: 'line',
                smooth:true,
                symbol:'none',
                data: lineData1
                },
                {
                    name: 'GbitsPerSecondOut',
                    type: 'line',
                    smooth:true,
                    symbol:'none',
                    data: lineData2
                },
                {
                    type: 'bar',
                    name:'OperStatusPollable',
                    barWidth:'2',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            color: '#4B476A',
                            barBorderColor: '#4B476A',
                            barBorderWidth: 1,
                            barBorderRadius:0,
                            label : {
                                show: true,
                                textStyle: {
                                    fontWeight: 'normal'
                                },
                                formatter:function(params){
                                    if(params.value>0){
                                        return "OperStatusPollable:"+data1;
                                    }
                                },
                                position: 'inside'
                            }
                        }
                    },
                    data: barDatas1
                },
                {
                    type: 'bar',
                    name:'Error',
                    barWidth:'2',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            color: '#4B476A',
                            barBorderColor: '#4B476A',
                            barBorderWidth: 1,
                            barBorderRadius: 0,
                            label: {
                                show: true,
                                textStyle: {
                                    fontWeight: 'normal'
                                },
                                formatter: function (params) {
                                    if (params.value > 0) {
                                        return "Error:"+data1;
                                    }
                                },
                                position: 'inside'
                            }
                        }
                    },
                    data: barDatas2
                }
            ]
        };
        myChart.setOption(option);
    }
});
