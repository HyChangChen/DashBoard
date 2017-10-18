$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/sla/viewperregionData",
            method: "get",
            dataType: "json",
            success: function (data) {
                var month = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
                var datas = {
                    'TREG-1':[],
                    'TREG-2':[],
                    'TREG-3':[],
                    'TREG-4':[],
                    'TREG-5':[],
                    'TREG-6':[],
                    'TREG-7':[],
                    'NAS':[]
                };
                month.forEach(function(el) {
                    var tmpData = data['fmap'][el];
                    for (var i = 0; i < tmpData.length; i++) {
                        switch (tmpData[i]['regional']) {
                            case 'TREG-1':
                                datas['TREG-1'].push(tmpData[i]['mttr']);
                                break;
                            case 'TREG-2':
                                datas['TREG-2'].push(tmpData[i]['mttr']);
                                break;
                            case 'TREG-3':
                                datas['TREG-3'].push(tmpData[i]['mttr']);
                                break;
                            case 'TREG-4':
                                datas['TREG-4'].push(tmpData[i]['mttr']);
                                break;
                            case 'TREG-5':
                                datas['TREG-5'].push(tmpData[i]['mttr']);
                                break;
                            case 'TREG-6':
                                datas['TREG-6'].push(tmpData[i]['mttr']);
                                break;
                            case 'TREG-7':
                                datas['TREG-7'].push(tmpData[i]['mttr']);
                                break;
                            default:
                                datas['NAS'].push(tmpData[i]['mttr']);
                                break;
                        }
                    }
                });
                initEchart("echart1",datas['NAS']);
                initEchart("echart2",datas['TREG-1']);
                //轮播图
                var j = 0;
                setInterval(function(){
                    j++;
                    if(j>=8){
                        j=0;
                    }else{
                        var index= j;
                        var liNav = '.first-nav li';
                        var thisLi = '.first-nav li:nth-child('+index+')';
                        $(liNav).css("color","#727386");
                        $(thisLi).css("color","#fff");

                        var liNav2 = '.sec-nav li'+' span';
                        var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
                        $(liNav2).css("backgroundColor","#0a0f25");
                        $(thisLi2).css("backgroundColor","#4a476a");

                        var objName = 'TREG-'+j;
                        initEchart("echart2",datas[objName]);
                    }
                },5000);

            },
            error: function () {

            }
        });
    }
    init();
    function initEchart(domId,echartData) {
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            backgroundColor:'#0A0F25',
            color:['#ef8a92','#2c2a4e'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid:{
                borderWidth: 1,
                color:'#494868'
            },
            xAxis : [
                {
                    type : 'category',
                    data:  ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
                    axisLabel:{
                        show: true,
                        textStyle:{
                            color:'#9FA0A1',
                        }
                    },
                    axisLine : {    // 轴线
                        show: false,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 2
                        },
                    },
                    splitLine : { //网格分隔线
                        show:false,
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
                        show: false,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 2
                        },
                    },
                    splitLine : { //网格分隔线
                        show:false,
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
            series :[
                {
                    name: 'mttr',
                    type: 'bar',
                    barWidth:'25',
                    itemStyle:{
                        normal:{
                            color: '#4B476A',
                            barBorderColor: '#4B476A',
                            barBorderWidth: 6,
                            barBorderRadius:0,
                            label: {
                                show: true,
                                textStyle: {
                                    color: '#ffffff'
                                }
                            }
                        }
                    },
                    data: echartData
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
});