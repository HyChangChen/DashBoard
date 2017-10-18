$(function(){
	function init(){
        $.ajax({
            url: _ctx+"/ano/complaintData",
            method: "get",
            dataType: "json",
            success: function (data) {
                var month = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
                var datas = data.listM;
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

        var leg = '';
        if(domId == 'echart1')
        {
        leg = 'Number of New Installtion (INDIHOME)';
        }
        option = {
            backgroundColor:'#0A0F25',
            color:['#ef8a92'],
            //color:['#ef8a92','#2c2a4e'],

            legend: {
                show: true,
                orient: 'vertical',
                x: 'right',
                y: 'top',
                textStyle: {
                    color:'#9F9FA1'
                },
                data: [leg]
                //data: ['Number of New Installtion (INDIHOME)', 'Number of Complaint ≤ 60 Day (UNIQUE)']
            },
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
                    name: 'Number of New Installtion (INDIHOME)',
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
                                    color: '#ffffff',
                                    fontSize: 15
                                }
                            }
                        }
                    },
                    data: echartData
                }
                /*,
                {
                    name: 'Number of Complaint ≤ 60 Day (UNIQUE)',
                    type: 'bar',
                    barWidth:'25',
                    itemStyle:{
                        normal:{
                            color: '#2c2a4e',
                            barBorderColor: '#2c2a4e',
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
                    data: ''
                }*/
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