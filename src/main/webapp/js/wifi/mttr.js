/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mttr-data",
        data: {
            mttrLeft: [],
            mttrRight: [],
            nowTime: '',
            time: '',
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiMttrData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    var date = new Date();
                    var date2 = new Date();
                    var dateshow= "";
                    date2.setMonth(date.getMonth()-1);
                    if((date2.getMonth()+1)<10)
                        dateshow = date2.getFullYear()+'-0'+(date2.getMonth()+1);
                    else
                        dateshow = date2.getFullYear()+'-'+(date2.getMonth()+1);
                    var time = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
                    var timeResult = "Last Update:"+time;
                    self.time = timeResult;
                    self.nowTime = dateshow;
                    self.mttrLeft = data.leftList;
                    self.mttrRight = data.rightList;
                    initEchart("echart1",data.mttrM,data.axisiData);
                },
                error: function () {

                }
            });
        }
    });
    function initEchart(domId,echartData,axisiData) {
        var myChart = echarts.init(document.getElementById(domId));
        var xData = axisiData;
        var legendData = [];
        var seriesData = [];
        for(var name in echartData){
            var tmpObj = {};
            tmpObj.type = 'bar';
            tmpObj.name = name;
            tmpObj.data = echartData[name];
            tmpObj.itemStyle = {
                normal: {
                    label: {
                        show: true, position: 'top'
                    }
                }
            };
            seriesData.push(tmpObj);
            legendData.push(name);
        }
        console.log(seriesData);
        console.log(xData);
        option = {
            title: {
                text: "Distribusi Pencapaian MTTR",
                backgroundColor:"#161C2F",
                x:'center',
                y: 'top',
                textStyle: {
                    fontSize: 26,
                    fontWeight: 'bolder',
                    color: '#fff'
                }
            },
            legend: {
                orient:'horizontal',
                x:'center',
                y:'bottom',
                textStyle:{
                    fontSize: 12,
                    color:'#fff'
                },
                data:legendData
            },
            backgroundColor: '#0c0e26',//背景色
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'none'
                },
                formatter: function(params) {
                    var color = '#87cefa';
                    var res = '<div style="color:' + color + '">';
                    res += '<strong>' + params[0].name + '</strong>'
                    for (var i = 0, l = params.length; i < l; i++) {
                        res += '<br/>' + params[i].seriesName + ' : ' + params[i].value
                    }
                    res += '</div>';
                    return res;
                }
            },
            color:['#009900','#FFFF00','#FF0000'],
            calculable: false,
            xAxis: [
                {
                    type: 'category',
                    name:'Region',
                    axisTick:{
                        interval:0
                    },
                    lineStyle: {
                        color: '#FFFFFF',
                        type: 'solid',
                        width: 2
                    },
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
                    splitLine : {
                        show:false,
                        lineStyle: {
                            color: '#FFFFFF',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    data:xData
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name:'value',
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
                            color: '#FFFFFF',
                            type: 'dashed',
                            width: 1
                        }
                    }
                }
            ],
            series : seriesData
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
